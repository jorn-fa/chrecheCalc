package jorn.hiel.calculator.business;

import jorn.hiel.calculator.business.pojo.Day;
import lombok.Getter;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Hiel Jorn
 */
@Slf4j
public class FileProcessor {

    @Getter
    private List<String> result;
    private final FileMarker fileMarker;
    private List<String> previousFiles;
    private List<Day> days;


    /**
     * Default constructor
     */
    public FileProcessor() {
        result=new ArrayList<>();
        fileMarker=new FileMarker();
        days=new ArrayList<>();
        previousFiles=new ArrayList<>();
    }

    /**
     * @param where
     * loads fileName version file
     */
    public void getPreviousProcessedFiles(String where) throws IOException {

            fileMarker.createFile(where);
            this.previousFiles=fileMarker.getOriginalContent();

    }



    /**
     * @param  fileName
     */
    public void markFile( String fileName) {
        if (!previousFiles.contains(fileName)){
        fileMarker.addFileName(fileName);}
    }

    /**
     * @return
     */
    public Day getDayFromPdf() {
        // TODO implement here
        return null;
    }

    /**
     * @param day  which day to save
     */
    public void saveDay(Day day) {
        days.add(day);
        log.debug("stored day in collection");
    }

    /**
     * @param folderName
     *
     * Gets list of PDF files specified on the given folder
     */
    public void readFolderContent(@NonNull String folderName) {
        try (Stream<Path> walk = Files.walk(Paths.get(folderName))) {

            result  = walk.filter(Files::isRegularFile)
                    .map(Path::toString)
                    .filter(s -> s.endsWith(".pdf")).collect(Collectors.toList());


        } catch (IOException e) {
           log.error(e.getMessage());
        }


    }

    /**
     *  saves the marked file list
     */
    public void saveMarked() {
        fileMarker.saveFile();
    }

    /**
     * process pdf files in previous specified folder
     */
    public void processFiles() {
        PdfReader reader = new PdfReader();
        DayCreator creator = new DayCreator();
        for (String fileName:result) {
            if (!previousFiles.contains(fileName)){
                saveDay(creator.createDay(fileName));

            reader.readFile(fileName);

            }
        }
    }

    public void printFound(){
        days.forEach(System.out::println);
    }
}
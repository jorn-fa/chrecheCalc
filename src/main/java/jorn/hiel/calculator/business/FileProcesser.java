package jorn.hiel.calculator.business;

import jorn.hiel.calculator.business.pojo.Day;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Hiel Jorn
 */
@Slf4j
public class FileProcesser {

    List<String> result;

    /**
     * Default constructor
     */
    public FileProcesser() {
    }



    /**
     * @param fileName
     */
    private void markAsProcessed(String fileName) {
        // TODO implement here
    }

    /**
     * @param  fileName
     */
    public void markFile( String fileName) {
        // TODO implement here
    }

    /**
     * @return
     */
    public Day getDayFromPdf() {
        // TODO implement here
        return null;
    }

    /**
     * @param day
     */
    public void saveDay(Day day) {
        // TODO implement here
    }

    /**
     * @param folderName
     */
    public void readFolderContent(@NonNull String folderName) {
        try (Stream<Path> walk = Files.walk(Paths.get(folderName))) {

            result  = walk.filter(Files::isRegularFile)
                    .map(x -> x.toString()).collect(Collectors.toList());



        } catch (IOException e) {
           log.error(e.getMessage());
        }

    }

}
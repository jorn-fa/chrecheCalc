package jorn.hiel.calculator.business;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

/**
 * @author Hiel Jorn
 */
@Slf4j
public class FileMarker {

    private String sourceFileLocation;
    private List<String> sourceFileNames;
    private List<String> originalContent;


    /**
     * Reads the contents of the previously saved file containing the pdf filenames
     */

    private void readFile(){

        try {
            String content = Files.readString(Paths.get(sourceFileLocation), StandardCharsets.US_ASCII);
             String[] split = content.split("\\r?\\n");
             sourceFileNames = new ArrayList<>();
             originalContent = new ArrayList<>();
            sourceFileNames.addAll(Arrays.asList(split));
            originalContent.addAll(sourceFileNames);

             log.debug("file " + sourceFileLocation + "split into lines");

         } catch (IOException e) {
           log.debug(e.getMessage());
        }
    }

    /**
     * saves the memory content to file
     */
    public void saveFile(){
        FileNameWriter fileNameWriter=new FileNameWriter();
        try {
            fileNameWriter.writeToFile(sourceFileLocation,originalContent,sourceFileNames);
            log.debug("writing to file filenames to memory file:");
            log.debug("original read file ->"+ originalContent.size());
            log.debug("new content -> " + sourceFileNames.size());
        } catch (IOException e) {
            log.debug(e.getMessage());
        }

    }


        /**
     * @param fileName
         * adds filename to sourceFile list
     */
    public void addFileName(String fileName) {
        if (!hasFileName(fileName)){
        sourceFileNames.add(fileName);}
    }

    /**
     * @param fileName
     * checks if sourceFile list contains give sourceFileName
     */
    public boolean hasFileName(String fileName) {
        return sourceFileNames.contains(fileName);
    }

    /**
     * @param fileName
     *
     * checks if given file exists and creates new if needed
     */
    public void createFile(@NonNull String fileName) throws IOException {
        String folder = FileSystemView.getFileSystemView().getDefaultDirectory().getPath();
        sourceFileLocation = folder+File.separator+fileName;
        File file= new File(sourceFileLocation);
        if (file.createNewFile()) {
            log.debug("File created -> " + folder);
        } else {
            log.debug("File found - Reading file");
            readFile();

        }

    }

    /**
      * @return unmodifiable list of the previous fileNames
     */

    public List<String> getOriginalContent(){
        return  Collections.unmodifiableList(originalContent);
    }

}
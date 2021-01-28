package jorn.hiel.calculator.business;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.io.IOException;

/**
 * @author Hiel Jorn
 */
@Slf4j
public class FileMarker {

    /**
     * Default constructor
     */
    public FileMarker() {
    }

    /**
     * location of the previous saved file
     */
    private String sourceFileLocation;


    /**
     * @param fileName
     */
    public void addFileName(String fileName) {
        // TODO implement here
    }

    /**
     * @param fileName
     */
    public void hasFileName(String fileName) {
        // TODO implement here
    }

    /**
     * @param fileName
     */
    public void eraseFileName(String fileName) {
        // TODO implement here
    }

    /**
     * @param fileName
     *
     * checks if given file exists and creates new if needed
     */
    public void createFile(@NonNull String fileName) throws IOException {
        String folder = FileSystemView.getFileSystemView().getDefaultDirectory().getPath();
        String location = folder+File.separator+fileName;
        File file= new File(location);
        if (file.createNewFile()) {
            log.debug("File created -> " + folder);
        } else {
            log.debug("File found");

        }
    }

}
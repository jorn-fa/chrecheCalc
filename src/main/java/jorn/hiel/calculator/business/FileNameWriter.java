package jorn.hiel.calculator.business;


import lombok.extern.slf4j.Slf4j;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Hiel Jorn
 */
@Slf4j
public class FileNameWriter {

    /**
     * Default constructor
     */
    public FileNameWriter() {
        difference=new ArrayList<>();
    }


    private List<String> oldContent;
    private List<String> newContent;
    private List<String> difference;


    /**
     * @param fileName 
     * @param oldContent 
     * @param newContent
     */
    public void writeToFile(String fileName, List oldContent, List newContent) throws IOException {
       this.oldContent=oldContent;
        this.newContent=newContent;
        compareContents();


        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));

       difference.forEach(x -> {
           try {
               writer.append(x.toString()+"\n");
           } catch (IOException e) {
               log.debug(e.getMessage());
           }
       });

        writer.close();
    }

    /**
     * compare new content vs old content, retain
     * only difference.

     */
    private void compareContents() {
        this.newContent.forEach(x -> {
            if(!this.oldContent.contains(x)){
                log.debug("Filename not found -> adding "+ x);
                this.difference.add(x);};});
    }

}
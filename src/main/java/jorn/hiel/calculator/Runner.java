package jorn.hiel.calculator;

import jorn.hiel.calculator.business.FileMarker;
import jorn.hiel.calculator.business.FileProcessor;

import java.io.IOException;

public class Runner {



    public static void main(String[] args) {

        System.out.println("Running");
        FileMarker fileMarker=new FileMarker();
        FileProcessor fileProcessor = new FileProcessor();
        try {
            fileProcessor.readFolderContent("c:/chreche/");
            fileProcessor.processFiles();
            fileProcessor.printFound();


            fileProcessor.getPreviousProcessedFiles("crecheTester.txt");

            fileProcessor.markFile("jorn.test");
            fileProcessor.markFile("lijn4eneenhalf");
            fileProcessor.markFile("lijn3");
            fileProcessor.markFile("volledige nieuw file");
            fileProcessor.saveMarked();




        } catch (IOException e) {
            e.printStackTrace();
        }


    }




}

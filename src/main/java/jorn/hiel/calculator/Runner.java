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
            fileProcessor.getPreviousProcessedFiles("crecheTester.txt");
            fileProcessor.readFolderContent("c:/chreche/");
            fileProcessor.processFiles();
            fileProcessor.printFound();
            fileProcessor.saveMarked();







        } catch (IOException e) {
            e.printStackTrace();
        }


    }




}

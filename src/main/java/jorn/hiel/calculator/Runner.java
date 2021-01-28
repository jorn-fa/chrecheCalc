package jorn.hiel.calculator;

import jorn.hiel.calculator.business.FileMarker;

import java.io.IOException;

public class Runner {



    public static void main(String[] args) {

        System.out.println("Running");
        FileMarker fileMarker=new FileMarker();
        try {
            fileMarker.createFile("crecheTester.txt");
            fileMarker.addFileName("jorn.test");
            fileMarker.addFileName("lijn4eneenhalf");
            fileMarker.addFileName("lijn3");
            fileMarker.saveFile();


        } catch (IOException e) {
            e.printStackTrace();
        }


    }




}

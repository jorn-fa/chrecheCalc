package jorn.hiel.calculator;

import jorn.hiel.calculator.business.PdfReader;

public class Runner {



    public static void main(String[] args) {

        System.out.println("Running");
        String where= "C:/temp/tester2.pdf";

        PdfReader reader = new PdfReader();
        reader.readFile(where);
        System.out.println(reader.getArrival());


    }




}

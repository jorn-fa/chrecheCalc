package jorn.hiel.calculator;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalTime;

public class Runner {
    public static void newLine() {
        System.out.println("*********");
    }

    private static String searchMe(String[] text, String filter){
        String returnMe = "";
        for (String line:text)
            if (line.toLowerCase().contains(filter)) {
                returnMe = line;
            }
        return returnMe;
    }


    public static void main(String[] args) {

        //Loading an existing document

        try {
            File file = new File("C:/temp/tester2.pdf");
            PDDocument document = PDDocument.load(file);

            //Instantiate PDFTextStripper class
            PDFTextStripper pdfStripper = new PDFTextStripper();

            //Retrieving text from PDF document
            String text = pdfStripper.getText(document);



            String lines[] = text.split("\\r?\\n");


            LocalTime arrival = getHour(searchMe(lines,"aankomst"));
            LocalTime departure = getHour(searchMe(lines,"vertrek"));
            Duration between = Duration.between(arrival,departure);


            System.out.println(getHour(arrival.toString()));
            System.out.println(getHour(departure.toString()));
            System.out.println("been there for" + between.toHoursPart() + ":" + between.toMinutesPart());


            //Closing the document
            document.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private static LocalTime getHour(String aankomst) {
        int where = aankomst.indexOf(":");
        return LocalTime.parse( aankomst.substring(where-2,where+3));
    }


}

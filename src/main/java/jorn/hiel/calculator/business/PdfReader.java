package jorn.hiel.calculator.business;

import lombok.Getter;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Locale;

@Getter
@Slf4j
public class PdfReader {

    private LocalTime arrival;
    private LocalTime departure;
    private LocalDate date;

    private String searchMe(String[] text, String filter) {
        String returnMe = "";
        for (String line : text)
            if (line.toLowerCase().contains(filter)) {
                returnMe = line;
            }
        return returnMe;
    }

    private LocalTime getHour(@NonNull String arrival) {
        int where = arrival.indexOf(":");
        return LocalTime.parse(arrival.substring(where - 2, where + 3));
    }

    private int toInt(@NonNull String text){
        return Integer.parseInt(text);
    }
    private int monthToInt(@NonNull String month){
        return switch (month.toLowerCase(Locale.ROOT)) {
            case "januari" -> 1;
            case "februari" -> 2;
            case "maart" -> 3;
            case "april" -> 4;
            case "mei" -> 5;
            case "juni" -> 6;
            case "juli" -> 7;
            case "augustus" -> 8;
            case "september" -> 9;
            case "oktober" -> 10;
            case "november" -> 11;
            default -> 12;
        };

    }

    private LocalDate getDate(@NonNull String date){
        String[] words = date.split(" ");

        return LocalDate.of(toInt(words[3]),monthToInt(words[2]),toInt(words[1]));
    }


    public void readFile(@NonNull String fileName) {

        try {
            File file = new File(fileName);
            PDDocument document = PDDocument.load(file);
            PDFTextStripper pdfStripper = new PDFTextStripper();

            String text = pdfStripper.getText(document);
            String[] lines = text.split("\\r?\\n");

            arrival = getHour(searchMe(lines, "aankomst"));
            departure = getHour(searchMe(lines, "vertrek"));
            date= getDate(searchMe(lines, "2021"));

        } catch (IOException e) {
                log.error(e.getMessage());
        }

    }
}

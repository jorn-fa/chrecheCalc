package jorn.hiel.calculator.business;

import lombok.Getter;
import lombok.NonNull;

public class DayCreator {

    @Getter
    private Day day;

    private PdfReader pdfReader = new PdfReader();

    private Day createDay(@NonNull String fileName) {
        day = new Day();
        pdfReader.readFile(fileName);
        day.setDate(pdfReader.getDate());
        day.setArrival(pdfReader.getArrival());
        day.setDeparture(pdfReader.getDeparture());
        return day;
    }


}

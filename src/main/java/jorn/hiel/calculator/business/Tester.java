package jorn.hiel.calculator.business;

import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import jorn.hiel.calculator.business.enums.DayState;
import jorn.hiel.calculator.business.pojo.Day;

import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class Tester {

    static String where="c:/temp/test/test.csv";

    public static void main(String[] args) throws Exception {



        DayWriter writer = new DayWriter();


        Day dayOne = new Day();
        dayOne.setDate( LocalDate.of(2021,12,21));
        dayOne.setDaystate(DayState.regular);
        dayOne.setArrival(LocalTime.of(8,05,12));
        dayOne.setDeparture(LocalTime.of(18,01,55));
        dayOne.setDaystate(DayState.regular);
        System.out.println(dayOne);
        writer.getDays().add(dayOne);
        writer.setFileLocation(where);
        writer.writeDays(writer.getDays());
        writer.readPreviousDays();


        //readFile(writer);




    }

    public static void readFile(DayWriter writer) throws CsvRequiredFieldEmptyException, IOException, CsvDataTypeMismatchException {


        List<Day> beans = new CsvToBeanBuilder(new FileReader(where))
                .withType(Day.class)
                .build()
                .parse();

        beans.forEach(System.out::println);


    }
}

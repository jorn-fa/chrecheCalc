package jorn.hiel.calculator.business;

import com.opencsv.bean.CsvToBeanBuilder;
import jorn.hiel.calculator.business.enums.DayState;
import jorn.hiel.calculator.business.pojo.Day;

import java.io.FileReader;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class Tester {



    public static void main(String[] args) throws Exception {

        String where="c:/temp/test/test.csv";

        DayWriter writer = new DayWriter();


        Day dayOne = new Day();
        dayOne.setDate( LocalDate.of(2021,12,21));
        dayOne.setDaystate(DayState.regular);
        dayOne.setArrival(LocalTime.of(8,05,00));
        dayOne.setDeparture(LocalTime.of(18,01,00));
        dayOne.setDaystate(DayState.regular);
        System.out.println(dayOne);
        writer.getDays().add(dayOne);
        writer.setFileLocation(where);


        writer.writeDays(writer.getDays());

        List<Day> beans = new CsvToBeanBuilder(new FileReader(where))
                .withType(Day.class)
                .build()
                .parse();

        beans.forEach(System.out::println);



    }
}

package jorn.hiel.calculator.business.pojo;

import com.opencsv.bean.CsvBindByName;
import jorn.hiel.calculator.business.enums.DayState;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@ToString
public class Day {
    @CsvBindByName(column = "date")
    private LocalDate date;

    @CsvBindByName(column = "arrival")
    private LocalTime arrival;

    @CsvBindByName(column = "departure")
    private LocalTime departure;


    @ToString.Exclude
    @CsvBindByName(column = "dayState")
    private DayState daystate=DayState.regular;



    public Duration getBetween() {

        return Duration.between(arrival, departure);
    }


}

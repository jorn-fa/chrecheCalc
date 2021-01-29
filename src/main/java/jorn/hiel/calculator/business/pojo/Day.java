package jorn.hiel.calculator.business.pojo;

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
    private LocalDate date;
    private LocalTime arrival;
    private LocalTime departure;
    @ToString.Exclude
    private DayState daystate=DayState.regular;


    public Duration getBetween() {

        return Duration.between(arrival, departure);
    }


}

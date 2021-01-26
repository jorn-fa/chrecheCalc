package jorn.hiel.calculator.business;

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
    LocalDate date;
    LocalTime arrival;
    LocalTime departure;

    public Duration getBetween() {
        return Duration.between(arrival, departure);
    }

}

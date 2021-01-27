package jorn.hiel.calculator.business;


import jorn.hiel.calculator.business.pojo.Month;
import lombok.Getter;

public class MonthCreator {

    @Getter
    private Month month;

    public void createMonth(String monthName, int year){

        month = new Month(monthName,year);

    }

}



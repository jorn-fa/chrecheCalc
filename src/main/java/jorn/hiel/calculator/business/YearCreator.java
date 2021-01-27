package jorn.hiel.calculator.business;

import jorn.hiel.calculator.business.pojo.Year;

public class YearCreator {

    public Year createYear(int number){
        return new Year(number);

    }
}

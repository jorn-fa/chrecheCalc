package jorn.hiel.calculator.business.pojo;

import lombok.Getter;
import lombok.NonNull;

import java.util.HashSet;
import java.util.Set;
@Getter
public class Month {
    private Set<Day> days;
    private String name;
    private int year;

    public Month(String whichMonth,int year){
        this.name=whichMonth;
        this.year=year;
        days=new HashSet<>();

    }



    public void addDay(@NonNull Day day){
        days.add(day);
    }
    public boolean hasDay(@NonNull Day day){
        return days.contains(day);
    }
}

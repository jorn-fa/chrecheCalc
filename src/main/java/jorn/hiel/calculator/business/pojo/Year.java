package jorn.hiel.calculator.business.pojo;

import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

@Getter
public class Year {

    private final Set<Month> monhts;
    private int id;

    public Year(int id){
        this.id=id;
        monhts=new HashSet<>();
    }


}

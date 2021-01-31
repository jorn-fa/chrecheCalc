package jorn.hiel.calculator.business;

import com.opencsv.bean.CsvToBeanBuilder;
import jorn.hiel.calculator.business.pojo.Day;
import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Hiel Jorn
 */
@Slf4j
public class DayWriter{


    private List<Day> days;
    private String fileLocation;
    private List<Day> originalDays;

    public DayWriter() {
        days=new ArrayList<>();
        fileLocation="";
        originalDays=new ArrayList<>();
    }


    /**
     * @param addTheseDays
     *
     * add newly processed days to the previous saved ones
     */
    public void writeDays(List<Day> addTheseDays) {

        if (canWrite()) {

            days = new ArrayList<>(); //nuke any older ones
            for (Day day : addTheseDays) {
                if (!originalDays.contains(day)) {
                    days.add(day);
                }
            }

            //todo   Day to csv format

            days.forEach(x -> {
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileLocation, true))) {
                    writer.append(x.toString() + "\n");
                } catch (IOException e) {
                    log.debug(e.getMessage());
                }
            });
        }
    }

    /**
     * throws invalidParameter if fileLocation has not been set or
     * set file does not exist
     */
    public void readPreviousDays() throws InvalidParameterException, FileNotFoundException {
        if (canWrite()){
            throw new InvalidParameterException("Empty fileLocation");
        }

        List<Day> beans = new CsvToBeanBuilder(new FileReader(fileLocation))
                .withType(Day.class)
                .build()
                .parse();

        beans.forEach(System.out::println);

    }



    private boolean canWrite(){return !fileLocation.isEmpty()&&!new File(fileLocation).exists();}

    /**
     * @return days from previous saved file
     */
    public List<Day> getDays() {
        // TODO implement here
        return null;
    }

    /**
     * @param location
     * specify where the previous saved file location is
     */
    public void setFileLocation(String location ) {
        // TODO implement here
    }

}
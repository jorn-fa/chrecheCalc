package jorn.hiel.calculator.business;

import com.opencsv.CSVWriter;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import jorn.hiel.calculator.business.pojo.Day;
import lombok.Setter;
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
    @Setter
    private String fileLocation;
    private List<Day> originalDays;

    public DayWriter() {
        days=new ArrayList<>();
        fileLocation="";
        originalDays=new ArrayList<>();
    }

    private boolean canWrite()  {



        return !fileLocation.isEmpty();
    }

    /**
     * @param addTheseDays
     *
     * add newly processed days to the previous saved ones
     */
    public void writeDays(List<Day> addTheseDays) throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {

        if (canWrite()) {
            System.out.println("passing");

            days = new ArrayList<>(); //nuke any older ones
            for (Day day : addTheseDays) {
                if (!originalDays.contains(day)) {
                    days.add(day);
                }
            }

            Writer writer  = new FileWriter(fileLocation);

            System.out.println(days.size());


            StatefulBeanToCsv sbc = new StatefulBeanToCsvBuilder(writer)
                    .withSeparator(CSVWriter.DEFAULT_SEPARATOR)
                    .build();
            sbc.write(days);
            writer.close();

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





    /**
     * @return days from previous saved file
     */
    public List<Day> getDays() {
       return days;
    }



}
import jorn.hiel.calculator.business.DayCreator;
import jorn.hiel.calculator.business.enums.DayState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;


public class DayCreatorTest {

    private final DayCreator dayCreator = new DayCreator();
    private String where;



    @BeforeEach
    public void setup(){
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(Objects.requireNonNull(classLoader.getResource("tester.pdf")).getFile());
        where=file.getAbsolutePath();
    }



    @Test
     public void doesExist(){
        assertNotEquals(null, dayCreator);
    }

    @Test
    public void noDayFoundOnNew(){
        assertNull( dayCreator.getDay());
    }

    @Test
    public void canCreateADay(){
        assertNull(dayCreator.getDay());
        assertNotEquals(null, dayCreator.createDay(where));
        assertEquals(LocalDate.of(2021,1,22),dayCreator.getDay().getDate());
        assertEquals(LocalTime.of(8,6), dayCreator.getDay().getArrival());
        assertEquals(LocalTime.of(17,32),dayCreator.getDay().getDeparture());
        assertEquals(566,dayCreator.getDay().getBetween().toMinutes());
        assertEquals(DayState.regular,dayCreator.getDay().getDaystate());
    }

    @Test
    public void toStringTest(){
        dayCreator.createDay(where);
        String testTo = "Day(date=2021-01-22, arrival=08:06, departure=17:32, daystate=regular)";
        assertEquals(testTo,dayCreator.getDay().toString());
    }


}

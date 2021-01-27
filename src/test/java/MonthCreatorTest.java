import jorn.hiel.calculator.business.MonthCreator;
import jorn.hiel.calculator.business.pojo.Day;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;
public class MonthCreatorTest {

    private MonthCreator monthCreator;

    @BeforeEach
    public void setup(){
        monthCreator= new MonthCreator();
    }

    @Test
    public void hasMonth(){
        assertNull(monthCreator.getMonth());
        monthCreator.createMonth("april",2020);
        assertNotNull(monthCreator.getMonth());
    }

    @Test
    public void hasDetails(){
        monthCreator.createMonth("april",2020);
        assertEquals(monthCreator.getMonth().getName(),"april");
        assertEquals(monthCreator.getMonth().getYear(),2020);
        assertEquals(monthCreator.getMonth().getDays().size(),0);
    }

    @Test
    public void canAddDay(){
        monthCreator.createMonth("april",2020);
        assertEquals(monthCreator.getMonth().getName(),"april");
        assertEquals(0,monthCreator.getMonth().getDays().size());
        monthCreator.getMonth().addDay(new Day());
        assertEquals(1,monthCreator.getMonth().getDays().size());
    }
}

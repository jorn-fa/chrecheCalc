import interfaces.StandardTestNames;
import jorn.hiel.calculator.business.DayCreator;
import jorn.hiel.calculator.business.MonthCreator;
import jorn.hiel.calculator.business.YearCreator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class CreatorTests  implements StandardTestNames {

    private DayCreator dayCreator;
    private MonthCreator monthCreator;
    private YearCreator yearCreator;


    @BeforeEach
    public void setup(){
        dayCreator=new DayCreator();
        monthCreator=new MonthCreator();
        yearCreator=new YearCreator();
    }

    @Override
    public void letDown() {
        dayCreator=null;
        monthCreator=null;
        yearCreator=null;


    }

    @Test
    public void doesExist(){
        assertNotNull(dayCreator);
        assertNotNull(monthCreator);
        assertNotNull(yearCreator);
    }



}
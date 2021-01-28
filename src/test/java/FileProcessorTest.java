import interfaces.StandardTestNames;
import jorn.hiel.calculator.business.FileProcessor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

public class FileProcessorTest implements StandardTestNames {

    private FileProcessor fileProcessor;
    private String where;


    @BeforeEach
    public void setup(){
        fileProcessor=new FileProcessor();

        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(Objects.requireNonNull(classLoader.getResource("tester.pdf")).getFile());
        Path path = Paths.get(file.getAbsolutePath());
        where = path.getParent().toString();


    }

    @AfterEach
    public void letDown() {
        fileProcessor=null;
    }

    @Test
    public void doesExist() {
        assertNotNull(fileProcessor);
    }

    @Test
    public void canCount(){
        assertEquals(0,fileProcessor.getResult().size());
        fileProcessor.readFolderContent(where);
        assertTrue(fileProcessor.getResult().size()>0);
    }



}

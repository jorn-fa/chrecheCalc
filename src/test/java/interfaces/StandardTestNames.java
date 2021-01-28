package interfaces;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public interface StandardTestNames {
    @BeforeEach void setup();
    @AfterEach void letDown();
    @Test void doesExist();




}

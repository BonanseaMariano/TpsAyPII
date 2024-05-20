package test;
import Prueba.Prueba;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class pruebaTest {
    Prueba prueba;
    @BeforeEach
    public void setup() {
         prueba = new Prueba();
    }

    @Test
    public void test() {
        assertTrue(prueba.test2());
    }
}

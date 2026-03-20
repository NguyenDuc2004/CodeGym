import org.example.Calculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CaculatorTest {
    @Test
    public void testAdd() {
        int actual = Calculator.add(2,3);
        int expected = 5;
        assertEquals(expected,actual);
    }

    @Test
    public void testAdd5vs5() {
        int actual = Calculator.add(5,5);
        int expected = 10;
        assertEquals(expected,actual); //2 tham so gia tri ki vong va gia tri that
    }

    @Test
    public void testSubtraction(){
        int actual = Calculator.subtraction(10,5);
        int expected = 5;
        assertEquals(expected,actual);
    }


}

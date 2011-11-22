import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.fail;

public class StringCalculatorTest {


    StringCalculator stringCalculator = new StringCalculator();


    @Test
    public void testZero() {
        assertEquals(0, stringCalculator.add(""));
    }

    @Test
    public void testOne() {
        assertEquals(1, stringCalculator.add("1"));
    }


    @Test
    public void testTwo() {
        assertEquals(3, stringCalculator.add("1,2"));
    }

    @Test
    public void testLargeAmount() {
        assertEquals(146, stringCalculator.add("1,2,6,4,2,7,2,4,68,9,0,34,2,5"));
    }


    @Test
    public void testBreaks() {
        assertEquals(5, stringCalculator.add("2\n3"));
    }

    @Test
    public void testDisallowedBreaks() {
        try {
            assertEquals(5, stringCalculator.add("2\n,3"));
            fail();
        } catch (Exception e) {
            assertEquals("2\n,3", e.getMessage());
            System.out.println("Exception: the numbers contains erroneous delimiters: " + e.getMessage());
        }
    }

    @Test
    public void testNewDelimiter() {
        assertEquals(10, stringCalculator.add("//:\n4:6"));
    }

    @Test
    public void testNegatives() {

        try {
            assertEquals(3, stringCalculator.add("4,6,-7,8,5,7,-9,7,5"));
            fail();
        } catch (Exception e) {
            assertEquals("-7-9", e.getMessage());
            System.out.println("Exception: no negatives allowed: " + e.getMessage());
        }
    }
}

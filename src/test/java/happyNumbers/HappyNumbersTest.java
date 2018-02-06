package happyNumbers;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HappyNumbersTest {

    private HappyNumbers happyNumbers = new HappyNumbers();

    @Test
    public void sumOfSquaresTest() {
        assertEquals(happyNumbers.sumOfSquares(2), new Integer(4));
        assertEquals(happyNumbers.sumOfSquares(123), happyNumbers.sumOfSquares(321));
        assertEquals(happyNumbers.sumOfSquares(56), new Integer(5*5 + 6*6));
        assertEquals(happyNumbers.sumOfSquares(0), new Integer(0));
        assertEquals(happyNumbers.sumOfSquares(-1), new Integer(0));
        assertEquals(happyNumbers.sumOfSquares(11111), new Integer(5));
    }

    @Test
    public void isHappyTest() {
        assertEquals(happyNumbers.isHappy(0), Boolean.FALSE);
        assertEquals(happyNumbers.isHappy(2), Boolean.FALSE);
        assertEquals(happyNumbers.isHappy(-1), Boolean.FALSE);
        assertEquals(happyNumbers.isHappy(-12431), Boolean.FALSE);
        assertEquals(happyNumbers.isHappy(999), Boolean.FALSE);

        for (int i = 0; i < 50; i++) {
            assertEquals(happyNumbers.isHappy(i), happyNumbers.isHappy(happyNumbers.sumOfSquares(i)));
            assertEquals(happyNumbers.isHappy(i), Boolean.TRUE);
        }
    }
}

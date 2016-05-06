package jUnitClass;

/**
 * Created by Samuele on 06/05/2016.
 */

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import Utils.MathUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value = Parameterized.class)
public class MathUtilsTest {

    private int numberA;
    private int numberB;
    private int expected;

    //parameters pass via this constructor
    public MathUtilsTest(int numberA, int numberB, int expected) {
        this.numberA = numberA;
        this.numberB = numberB;
        this.expected = expected;
    }

    //Declares parameters here
    @Parameters(name = "{index}: add({0}+{1})={2}")
    public static Iterable<Object[]> data1() {
        return Arrays.asList(new Object[][] {
                { 5, 3, 8 },
                { 7, 7, 14 },
                { 18, 2, 20 },
                { 3, 4, 7 }
        });
    }

    @Test
    public void addTest() {
        assertEquals(expected, MathUtils.add(numberA, numberB));
    }

}
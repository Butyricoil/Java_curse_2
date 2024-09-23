package org.example;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {

    private Calculator calculator;

    @Before
    public void setUp() {
        calculator = new Calculator();
    }

    @Test
    public void givenFiveAndTen_whenAdd_thenResultShouldBeFifteen() {
        int expected = 15;
        int result = calculator.add(10, 5);
        assertEquals(expected, result);
    }

    @Test
    public void whgivenFiveAndTenString_whenAdd_thenResultShouldBeFifteenen5() {
        int expected = 15;
        int result = calculator.add("10", "5");
        assertEquals(expected, result);

    }
    @Test
    public void whenInputIncorecValueThenThrowExeption() {
       boolean wasExpected = false;
        try {
            calculator.add("ten", "five");
        } catch (NumberFormatException e) {
            wasExpected = true;
        }
        assertTrue(wasExpected);
    }

    @Test
    public void givenTenAndFive_whenSubtract_thenResultShouldBeFive() {
        int expected = 5;
        int result = calculator.subtract(10, 5);
        assertEquals(expected, result);
    }

    @Test
    public void givenTenAndThree_whenMultiply_thenResultShouldBeThirty() {
        double expected = 30.0;
        double result = calculator.multiply(10.0, 3.0);
        assertEquals(expected, result, 0.001);
    }

    @Test
    public void givenTenAndThree_whenDivide_thenResultShouldBeApproximatelyThree() {
        double expected = 3.0;
        double result = calculator.divide(10.0, 3.0);
        assertEquals(expected, result, 0.5);
    }

    @Test
    public void givenTenAndSix_whenPower_thenResultShouldBeOneMillion() {
        int expected = 1000000;
        int result = calculator.power(10, 6);
        assertEquals(expected, result);
    }
}

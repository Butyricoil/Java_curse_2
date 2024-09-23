package org.example;

import org.junit.Test;

import static org.junit.Assert.*;
public class CalculatorTest {

    @Test
    public void add() {
        Calculator calculator = new Calculator();
        int expected = 15;
        int result = calculator.add(10,5);
        assertEquals(expected, result);
    }

    @Test
    public void subtract() {
        Calculator calculator = new Calculator();
        int expected = 5;
        int result = calculator.subtract(10, 5);
        assertEquals(expected, result);
    }

    @Test
    public void multiply() {
        Calculator calculator = new Calculator();
        double expected = 30.0;
        double result = calculator.multiply(10.0, 3.0);
        assertEquals(expected, result, 0.001);
    }

    @Test
    public void divide() {
        Calculator calculator = new Calculator();
        double expected = 3.0;
        double result = calculator.divide(10.0, 3.0);
        assertEquals(expected, result, 0.9);
    }

    @Test
    public void power() {
        Calculator calculator = new Calculator();
        int expected = 1000000;
        int result = calculator.power(10, 6);
        assertEquals(expected, result);

    }
}
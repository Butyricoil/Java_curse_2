package org.example;

import org.junit.Test;

import static org.junit.Assert.*;
public class CalculatorTest2 {

    @Test
    public void add() {
        Calculator calculator = new Calculator();
        int expected = 15;
        int result = calculator.add(10,5);
        assertEquals(expected, result);
    }
}
package org.example;

public class Calculator {

    public int add (int a, int b) {
        return a + b;
    }

    public int add (String sa, String sb) {
        int a = Integer.parseInt(sa);
        int b = Integer.parseInt(sb);
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public double multiply(double a, double b) {
        return a * b;
    }

    public double divide(double a, double b) {
        return (double) a / b;
    }

    public int power(int a, int b) {
        return (int) Math.pow(a, b);
    }


}

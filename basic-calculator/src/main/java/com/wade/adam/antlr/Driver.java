package com.wade.adam.antlr;

public class Driver {

    public static void main(String[] args) {

        Calculator calculator = new Calculator();
        calculator.calculate(
                "193\n" +
                        "a = 5\n" +
                        "b = 6\n" +
                        "a+b*2\n" +
                        "(1+2)*3\n");
    }


}

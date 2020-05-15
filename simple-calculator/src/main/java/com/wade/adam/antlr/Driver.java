package com.wade.adam.antlr;

public class Driver {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        System.out.println(calculator.calculate("10 + 5"));
        System.out.println(calculator.calculate("3 * 5"));
        System.out.println(calculator.calculate("5 - 4"));
        System.out.println(calculator.calculate("5 / 2"));
        System.out.println(calculator.calculate("5 $ 3"));
      }
}

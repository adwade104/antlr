package com.wade.adam.antlr;

public class Driver {

    public static void main(String[] args) {
        String stringArray = "{ 99, {37, 22, 39}, 3, 451 }";
        StringArrayToUnicodeConverter converter = new StringArrayToUnicodeConverter();
        System.out.println(converter.convert(stringArray));
    }

}

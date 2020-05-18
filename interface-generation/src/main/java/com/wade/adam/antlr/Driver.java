package com.wade.adam.antlr;

public class Driver {

    public static void main(String[] args) {

        JavaInterfaceGenerator generator = new JavaInterfaceGenerator();
        generator.generateInterface("import java.util.List; import java.util.Map; public class Demo { void f(int x, String y) { } int[ ] g(/*no args*/) { return null; } List<Map<String, Integer>>[] h() { return null; } }");

    }



}

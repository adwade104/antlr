package com.wade.adam.antlr;

import java.io.IOException;
import java.net.URISyntaxException;

public class Driver {

    public static void main(String[] args) throws URISyntaxException, IOException {

        JavaInterfaceGenerator generator = new JavaInterfaceGenerator();

        String demoClassFile = FileUtil.readFileToString("Demo.java");
        generator.generateInterface(demoClassFile);

        System.out.println();

        String employeeClassFile = FileUtil.readFileToString("Employee.java");
        generator.generateInterface(employeeClassFile);

        System.out.println();

        String antlrClassFile = FileUtil.readFileToString("UnbufferedCharStream.java");
        generator.generateInterface(antlrClassFile);

    }

}

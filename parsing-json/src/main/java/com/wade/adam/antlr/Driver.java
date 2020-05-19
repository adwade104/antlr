package com.wade.adam.antlr;

import java.net.URISyntaxException;

public class Driver {

    public static void main(String[] args) throws URISyntaxException {

        JsonValidator jsonValidator = new JsonValidator();
        String sampleJsonFile = FileUtil.readFileToString("JsonSample.json");
        jsonValidator.validate(sampleJsonFile);
    }

}

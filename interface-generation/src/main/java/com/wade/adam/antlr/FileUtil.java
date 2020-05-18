package com.wade.adam.antlr;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public final class FileUtil {

    private FileUtil() { }

    public static String readFileToString(String fileName) throws URISyntaxException {

        StringBuilder contentBuilder = new StringBuilder();

        URI uri = ClassLoader.getSystemResource(fileName).toURI();
        String mainPath = Paths.get(uri).toString();

        try (Stream<String> stream = Files.lines(Paths.get(mainPath)))
        {
            stream.forEach(s -> contentBuilder.append(s).append("\n"));
        }catch (IOException e) {
            throw new RuntimeException("Exception occurred while reading file: ");
        }

        return contentBuilder.toString();
    }

}

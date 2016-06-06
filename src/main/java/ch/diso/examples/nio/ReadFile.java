package ch.diso.examples.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadFile {

    public static void main(String[] args) throws IOException {
        Files.lines(Paths.get("gettys.html"))
                .forEach(System.out::println);
    }
}

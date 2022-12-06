package by.home.webproject.dao;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DataDao implements Dao {

    @Override
    public String getData(String URL) throws FileNotFoundException {
        try (Stream<String> lines = Files.lines(Paths.get(URL), StandardCharsets.UTF_8)) {
            return lines.collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new FileNotFoundException(URL + " not found");
        }
    }
}

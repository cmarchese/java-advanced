package com.educacionit.orders;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LoadFilesService {


    public static void main (String[] args) {

        try (Stream<Path> walk = Files.walk(Paths.get("/opt"))) {

            List<String> result = walk.map(x -> x.toString())
                    .filter(f -> f.endsWith(".pdf")).collect(Collectors.toList());

            result.forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package cz.jpcz;

import cz.jpcz.exceptions.InputDataException;
import cz.jpcz.utils.DataFilter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {

        String RESOURCE_PATH = "/data.txt";
        DataFilter<String> filter;

        List<Predicate<String>> conditions = new ArrayList<>();

        conditions.add(t -> (Integer.parseInt(t) == 1000));

        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        Objects.requireNonNull(Main.class.getResourceAsStream(RESOURCE_PATH))
                )
        )) {

            List<String> values = reader.lines().toList();
            filter = new DataFilter<>(values);

        } catch (IOException ioe) {
            throw new InputDataException("Error while trying to access data", ioe.getCause());
        }

        System.out.println("Filtered data: ");
        for (String s : filter.getFiltered(conditions)) {
            System.out.println(s);
        }
    }
}
package ex_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> phoneNumbers = Arrays.stream(reader.readLine().trim().split("\\s+"))
                .collect(Collectors.toList());
        List<String> sitesToVisit = Arrays.stream(reader.readLine().trim().split("\\s+"))
                .collect(Collectors.toList());

        Smartphone smartphone = new Smartphone(phoneNumbers, sitesToVisit);
        System.out.println(smartphone.call());
        System.out.println(smartphone.browse());
    }
}
package ex_07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().trim().split("\\s+");
        int n = Integer.parseInt(reader.readLine());

        AddCollection addCollection = new AddCollection();
        AddRemoveCollection addRemoveCollection = new AddRemoveCollection();
        MyListImpl myListImpl = new MyListImpl();

        Arrays.stream(input).forEach(e -> System.out.printf("%d ", addCollection.add(e)));
        System.out.println();
        Arrays.stream(input).forEach(e -> System.out.printf("%d ", addRemoveCollection.add(e)));
        System.out.println();
        Arrays.stream(input).forEach(e -> System.out.printf("%d ", myListImpl.add(e)));
        System.out.println();
        IntStream.range(0, n).forEach(i -> System.out.printf("%s ", addRemoveCollection.remove()));
        System.out.println();
        IntStream.range(0, n).forEach(i -> System.out.printf("%s ", myListImpl.remove()));
    }
}
package ex_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder text = new StringBuilder(reader.readLine());

        CommandInterface commandInterface = Initialization.buildCommandInterface(text);

        String inputLine = reader.readLine();

        while (!inputLine.equals("exit")) {
            commandInterface.handleInput(inputLine);
            inputLine = reader.readLine();
        }

        System.out.println(text);
    }
}
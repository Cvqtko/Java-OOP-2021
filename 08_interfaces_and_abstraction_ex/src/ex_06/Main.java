package ex_06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import ex_06.commandClasses.CommandoCommand;
import ex_06.commandClasses.EngineerCommand;
import ex_06.commandClasses.LieutenantGeneralCommand;
import ex_06.commandClasses.PrivateCommand;
import ex_06.commandClasses.SpyCommand;
import ex_06.interfaces.Command;
import ex_06.interfaces.Soldier;


public class Main {

    public static final List<Soldier> soldiers = new ArrayList<>();
    public static final Map<String, Command> commands = new HashMap<>() {{
        put("P", new PrivateCommand(soldiers));
        put("L", new LieutenantGeneralCommand(soldiers));
        put("E", new EngineerCommand(soldiers));
        put("C", new CommandoCommand(soldiers));
        put("S", new SpyCommand(soldiers));
    }};

    public static void main(String[] args) throws IOException {

       BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while (!"End".equals(input = reader.readLine())) {
            String command = input.trim().substring(0, 1);
            commands.get(command).execute(Arrays.stream(input.split("\\s+")).skip(1)
                    .collect(Collectors.toList()));
        }
      soldiers
              .forEach(soldier -> System.out.println(soldier.toString()));
    }
}
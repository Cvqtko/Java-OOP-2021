package ex_04;

public class Initialization {

    public static CommandInterface buildCommandInterface(StringBuilder text) {
        return new CommandImpl(text);
    }
}
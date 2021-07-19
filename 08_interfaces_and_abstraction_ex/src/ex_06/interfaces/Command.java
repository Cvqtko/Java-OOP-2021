package ex_06.interfaces;

import java.util.List;

public interface Command {

    void execute(List<String> args);
}
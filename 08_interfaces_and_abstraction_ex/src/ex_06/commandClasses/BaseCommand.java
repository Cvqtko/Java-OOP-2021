package ex_06.commandClasses;

import java.util.List;

import ex_06.interfaces.Command;
import ex_06.interfaces.Soldier;

public abstract class BaseCommand implements Command {

    private final List<Soldier> soldiers;

    protected BaseCommand(List<Soldier> soldiers) {
        this.soldiers = soldiers;
    }

    protected List<Soldier> getSoldier() {
        return this.soldiers;
    }

    public void add(Soldier soldier) {
        this.soldiers.add(soldier);
    }
}
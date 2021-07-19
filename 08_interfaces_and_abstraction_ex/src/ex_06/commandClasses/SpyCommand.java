package ex_06.commandClasses;

import java.util.List;

import ex_06.factoryClasses.SoldierFactory;
import ex_06.interfaces.Soldier;

public class SpyCommand extends BaseCommand {
    public SpyCommand(List<Soldier> soldiers) {
        super(soldiers);
    }

    @Override
    public void execute(List<String> args) {
        super.add(SoldierFactory.produceSpy(args));
    }
}
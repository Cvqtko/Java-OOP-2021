package ex_06.commandClasses;

import java.util.List;

import ex_06.factoryClasses.SoldierFactory;
import ex_06.interfaces.Soldier;

public class PrivateCommand extends BaseCommand {

    public PrivateCommand(List<Soldier> soldiers) {

        super(soldiers);
    }

    @Override
    public void execute(List<String> args) {
        super.add(SoldierFactory.producePrivate(args));
    }
}
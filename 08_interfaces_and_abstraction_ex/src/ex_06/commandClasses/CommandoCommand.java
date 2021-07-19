package ex_06.commandClasses;

import java.util.List;

import ex_06.enumeration.Corps;
import ex_06.factoryClasses.SoldierFactory;
import ex_06.interfaces.Soldier;

public class CommandoCommand extends BaseCommand {
    public CommandoCommand(List<Soldier> soldiers) {
        super(soldiers);
    }

    @Override
    public void execute(List<String> args) {
        if (Corps.isValidCorps(args.get(4))) {
            super.add(SoldierFactory.produceCommando(args));
        }
    }
}
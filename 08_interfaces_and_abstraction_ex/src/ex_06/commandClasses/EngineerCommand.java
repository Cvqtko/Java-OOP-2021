package ex_06.commandClasses;

import java.util.List;

import ex_06.enumeration.Corps;
import ex_06.factoryClasses.SoldierFactory;
import ex_06.interfaces.Soldier;

public class EngineerCommand extends BaseCommand {


    public EngineerCommand(List<Soldier> soldiers) {
        super(soldiers);
    }

    @Override
    public void execute(List<String> args) {
        if (Corps.isValidCorps(args.get(4))) {
            super.add(SoldierFactory.produceEngineer(args));
        }
    }
}
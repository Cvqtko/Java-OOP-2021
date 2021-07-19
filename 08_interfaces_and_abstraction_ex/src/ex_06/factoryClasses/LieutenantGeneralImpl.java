package ex_06.factoryClasses;

import java.util.Set;
import java.util.TreeSet;

import ex_06.interfaces.LieutenantGeneral;
import ex_06.interfaces.Private;

public class LieutenantGeneralImpl extends PrivateImpl implements LieutenantGeneral {

    private final Set<Private> privates;

    public LieutenantGeneralImpl(int id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName, salary);
        this.privates = new TreeSet<>((first, second) -> second.getId() - first.getId());
    }

    @Override
    public void addPrivate(Private soldier) {
        this.privates.add(soldier);
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder(super.toString());
        output.append(System.lineSeparator()).append("Privates:").append(System.lineSeparator());
        for (Private soldier : this.privates) {
            output.append("  ").append(soldier.toString()).append(System.lineSeparator());
        }
        return output.toString().trim();
    }
}
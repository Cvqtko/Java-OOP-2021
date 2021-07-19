package ex_07;

public class AddRemoveCollection extends Collection implements AddRemovable {
    public AddRemoveCollection() {
        super();
    }

    @Override
    public String remove() {
        return getItems().remove(getItems().size() - 1);
    }

    @Override
    public int add(String item) {
        getItems().add(0, item);
        return 0;
    }
}
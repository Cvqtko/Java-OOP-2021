package ex_06.enumeration;

public enum State {

    INPROGRESS("inProgress"), FINISHED("Finished");

    private final String state;

    State(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public static boolean isValidState(String state) {
        return state.equals(INPROGRESS.getState()) || state.equals(FINISHED.getState());
    }
}
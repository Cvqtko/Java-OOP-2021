package ex_04;

public enum StateMachine {
	RED, GREEN, YELLOW;

	public static StateMachine update(StateMachine state) {
		switch (state) {
		case RED:
			return GREEN;
		case GREEN:
			return YELLOW;
		case YELLOW:
			return RED;
		}
		return null;
	}
}
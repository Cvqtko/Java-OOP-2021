package ex_01;

public enum CardSuits {
	CLUBS(0), DIAMONDS(1), HEARTS(2), SPADES(3);

	private int value;

	private CardSuits(int value) {
		this.value = value;
	}

	public int getValue() {
		return this.value;
	}
}

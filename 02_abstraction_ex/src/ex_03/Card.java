package ex_03;

public class Card {

	private CardRanks cardRank;
	private CardSuits cardSuit;
	private int power;

	public Card(CardRanks cardRank, CardSuits cardSuit) {
		this.cardRank = cardRank;
		this.cardSuit = cardSuit;
	}

	public int getPower() {
		return this.cardSuit.getPower() + this.cardRank.getPower();
	}
}

package game;

public class Winnings {
	//Queen of spades is 13
	//Each heart is 13
	//If you get every point, you get 0 points and everyone else gets 26
	
	private Card[] myCards = new Card[52];
	private Card[] myCardsThatCount = new Card[14];
	private int cardsNumber = 0;
	private int cardsThatCountNumber = 0;
	
	public Winnings() {
		
	}
	
	public void addToWinnings(Card[] cards) {
		for (Card c : cards) {
			myCards[cardsNumber] = c;
			cardsNumber++;
			if (c.suit().equals("Hearts")) {
				myCardsThatCount[cardsThatCountNumber] = c;
				cardsThatCountNumber++;
			}
			else if ((c.numberValue() == 12) && (c.suit().equals("Spades"))) {
				myCardsThatCount[cardsThatCountNumber] = c;
				cardsThatCountNumber++;
			}
		}
	}
	
	@Override
	public String toString() {
		String ret = "";
		if (cardsNumber > 0) {
			for (Card c : myCards) {
				ret += (c.toString()+ ", ");
			}
		}
		else {
			ret = "No cards in winnings";
		}
		return ret;
	}
}

package game;

import java.util.Collection;

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
	
	public void addToWinnings(Collection<Card> cards) {
		for (Card c : cards) {
			myCards[cardsNumber] = c;
			cardsNumber++;
			if (c.suit().equals("hearts")) {
				myCardsThatCount[cardsThatCountNumber] = c;
				cardsThatCountNumber++;
			}
			else if ((c.numberValue() == 12) && (c.suit().equals("spades"))) {
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
	
	public int calculateWinnings() {
		if (cardsThatCountNumber == 0) {
			return 0;
		}
		else{
			int ret = 0;
			for (Card c : myCardsThatCount) {
				if (c.suit().equals("spades")) {
					ret+=13;
				}
				else {
					ret+=1;
				}
			}
			return ret;
		}
	}
}

package game;

public class Hand {
	private Card[] myCards;
	private int numberOfCards = 0;
	
	public Hand() {
		myCards = new Card[13];
	}
	
	public void add(Card addingCard) {
		myCards[numberOfCards] = addingCard;
		numberOfCards++;
	}
	
	
	/**
	 * 
	 * @param droppingCard
	 * @return returns card that you are dropping if possible. returns null if the card does not exist
	 */
	public Card drop(Card droppingCard) {
		Card cardToDrop;
		for (int i = 0; i < numberOfCards; i++) {
			if (droppingCard.equals(myCards[i])){
				cardToDrop = myCards[i];
				myCards[i] = myCards[numberOfCards-1];
				numberOfCards-=1;
				return cardToDrop;
			}
		}
		return null;
	}
	
	@Override
	public String toString() {
		String ret = "";
		if (numberOfCards > 0) {
			for (Card c : myCards) {
				ret += (c.toString()+ ", ");
			}
		}
		else {
			ret = "No more cards left in hand";
		}
		return ret;
	}
	
	public int sizeOfHand() {
		return numberOfCards;
	}
	
	public Card[] seeHand() {
		return myCards;
	}

}

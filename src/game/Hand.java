package game;

import java.util.HashSet;
import java.util.Set;

public class Hand {
	private Card[] myCards;
	private int numberOfCards = 0;
	private Set<Integer> spades;
	private Set<Integer> hearts;
	private Set<Integer> clubs;
	private Set<Integer> diamonds;
	
	public Hand() {
		myCards = new Card[13];
		spades = new HashSet<Integer>();
		clubs = new HashSet<Integer>();
		hearts = new HashSet<Integer>();
		diamonds = new HashSet<Integer>();
	}
	
	public void add(Card addingCard) {
		myCards[numberOfCards] = addingCard;
		switch (addingCard.suit()){
		case("spades"): 
			spades.add(addingCard.numberValue());
			break;
		case("hearts"): 
			hearts.add(addingCard.numberValue());
			break;
		case("clubs"): 
			clubs.add(addingCard.numberValue());
			break;
		case("diamonds"): 
			diamonds.add(addingCard.numberValue());
			break;
		}
		numberOfCards++;
	}
	
	
	/**
	 * 
	 * @param droppingCard
	 * @return returns card that you are dropping if possible. returns null if the card does not exist
	 */
	public Card drop(String value, String suit) {
		Card cardToDrop;
		for (int i = 0; i < numberOfCards; i++) {
			if (value.equals(myCards[i].stringValue()) && suit.equals(myCards[i].suit())){
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
	
	public Set<Integer> seeSpades() {
		return spades;
	}
	public Set<Integer> seeHearts() {
		return hearts;
	}
	public Set<Integer> seeClubs() {
		return clubs;
	}
	public Set<Integer> seeDiamonds() {
		return diamonds;
	}

}

package game;

import java.util.Random;

public class Deck {
	
	String[] suits = {"clubs", "hearts", "spades", "diamonds"};
	
	private Card[] theDeck = new Card[52];
	
	public Deck() {
		Integer counter = 0;
		for (int i=1; i<=13; i++) {
			for (String s : suits) {
				theDeck[counter] =  new Card(i, s);
				counter++;
			}
		}
	}
	
	public Hand[] deal() {
		Hand[] hands = new Hand[4];
		Random rand = new Random();
		int cardsInDeck = 51;
		
		for (int iteration = 4; iteration > 0; iteration--) {
			Hand currentHand = new Hand();
			for (int i = 14; i>1; i--) {
				int randomNumber = rand.nextInt(((i)+(iteration-1)));
				Card addingCard = theDeck[randomNumber]; //returns a random card out of the deck to grab
				currentHand.add(addingCard);
				theDeck[randomNumber] = theDeck[cardsInDeck];
				cardsInDeck--;
			}
			hands[iteration-1] = currentHand;
		}
		return hands;
	}
	
	@Override
	public String toString() {
		String ret = "";
		int counter = 1;
		for (Card c : theDeck) {
			ret += (c.toString()+ ", ");
			if ((counter % 13) == 0) {
				ret+="\n";
			}
			counter++;
		}
		return ret;
	}
}

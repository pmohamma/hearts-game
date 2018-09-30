package game;

import java.util.Collection;
import java.util.Scanner;

public class Player implements Comparable<Player> {
	private String myName;
	private Winnings myWinnings;
	private Hand myHand;
	private int score = 0;
	
	public Player(String name) {
		myName = name;
		resetWinnings();
	}
	
	public boolean assignHand(Hand h){
		if (!((myHand == null) || (myHand.sizeOfHand() == 0))) {
			System.out.println("CODING ERROR: Cannot assign new hand to a player with a hand already");
			return false;
		}
		else {
			myHand = h;
			return true;
		}
	}
	
	public Hand accessHand() {
		return myHand;
	}
	
	public int getScore() {
		score += myWinnings.calculateWinnings();
		return score ;
	}
	
	public void resetWinnings() {
		myWinnings = new Winnings();
	}
	
	public void addWinnings(Collection<Card> cards) {
		myWinnings.addToWinnings(cards);
	}
	
	public int calculateScore() {
		score += myWinnings.calculateWinnings();
		return score;
	}
	
	public String getName() {
		return myName;
	}
	
	public Card playCard(String value, String suit, Scanner reader) {
		Card cardToDrop = myHand.drop(value, suit);
		while (cardToDrop == null) {
			System.out.println("This was not a valid entry. Please make sure the card you typed" +
					" is in our hand and try again.");
			String val = reader.next();
			reader.next();
			String playersSuit = reader.next();
			cardToDrop = myHand.drop(val,  playersSuit);
		}
		return cardToDrop;
	}
	
	@Override
	public int compareTo(Player p) {
        return (myName.compareTo(p.getName()));
    }
	
	@Override
	public boolean equals(Object o) {
		if (! (o instanceof Player) || o == null){
			return false;
		}
		
		Player obj = (Player) o;
		if (myName.equals(obj.getName())) {
			return true;
		}
		else {
			return false;
		}
	}
}

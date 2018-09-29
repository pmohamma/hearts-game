package game;

public class Player {
	private String myName;
	private Winnings myWinnings = new Winnings();
	private Hand myHand;
	
	public Player(String name) {
		myName = name;
	}
	
	public boolean assignHand(Hand h){
		if ((myHand == null) || (myHand.sizeOfHand() == 0)) {
			System.out.println("CODING ERROR: Cannot assign new hand to a player with a hand already");
			return false;
		}
		else {
			myHand = h;
			return true;
		}
	}
	
	public void addWinnings(Card[] cards) {
		myWinnings.addToWinnings(cards);
	}
	
	public int calculateScore() {
		return 0;
	}
	
	public String getName() {
		return myName;
	}
	
}

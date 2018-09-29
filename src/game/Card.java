package game;

public class Card {
	private String myStringValue;
	private String mySuit;
	private int myNumberValue;
	
	public Card(int number, String type) {
		myNumberValue = number;
		
		if ((number<=10) && (number >=2)) {
			myStringValue = Integer.toString(number);
		}
		else {
			switch(number) {
			case (11): {myStringValue = "Jack";
				break;
				}
			case (12): {myStringValue = "Queen";
				break;
				}
			case (13): {myStringValue = "King";
				break;
				}
			case (1): {myStringValue = "Ace";
				break;
				}
			}
		}
		
		mySuit = type;
	}
	
	public int numberValue() {
		return myNumberValue;
	}
	
	public String StringValue() {
		return myStringValue;
	}
	
	public String Suit() {
		return mySuit;
	}
	
	@Override
	public String toString() {
		return myStringValue + " of " + mySuit;
	}
	
	@Override
	public boolean equals(Object o) {
		if (! (o instanceof Card) || o == null){
			return false;
		}
		
		Card obj = (Card) o;
		if ((obj.numberValue() == myNumberValue) && (myStringValue.equals(obj.StringValue()))){
			return true;
		}
		else {
			return false;
		}
	}
}
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
			case (11): {myStringValue = "jack";
				break;
				}
			case (12): {myStringValue = "queen";
				break;
				}
			case (13): {myStringValue = "king";
				break;
				}
			case (1): {myStringValue = "ace";
				break;
				}
			}
		}
		
		mySuit = type;
	}
	
	public int numberValue() {
		return (Integer) myNumberValue;
	}
	
	public String stringValue() {
		return myStringValue;
	}
	
	public String suit() {
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
		if ((obj.numberValue() == myNumberValue) && (myStringValue.equals(obj.stringValue()))){
			return true;
		}
		else {
			return false;
		}
	}
}

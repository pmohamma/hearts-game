package game;

/** import java.util.Arrays;
import java.util.HashSet;
import java.util.Set; **/

public class Hearts {
	public static void main(String[] args) {
		Deck mainDeck = new Deck();
		
		Hand[] hands = mainDeck.deal();
		
		for (Hand h:hands) {
			System.out.println(h);
		}
		
/*
 *Tests to make sure that the deal function works correctly
 *If un-commenting, make sure to un-comment set and array imports
 *
 * 		for (int h = 0; h < 3; h++) {
			for (int j = h+1; j < 4; j++) {
				Set<Card> set1 = new HashSet<Card>(Arrays.asList(hands[h].seeHand()));
				Set<Card> set2 = new HashSet<Card>(Arrays.asList(hands[j].seeHand()));
				set1.retainAll(set2);
				for (Card c : set1) {
					System.out.print(c);
				}
				
				System.out.println(h  + " " +  j);
			}
		}
*/		
	}
}

package game;

import java.util.Scanner;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Hearts {
	public static void main(String[] args) {
		Deck mainDeck = new Deck();
		Scanner reader = new Scanner(System.in);
		Player player1;
		Player player2 = new Player("cpu2");
		Player player3 = new Player("cpu3");
		Player player4 = new Player("cpu4");
		Player starter;
		
		
		Hand[] hands = mainDeck.deal();
		
		for (Hand h:hands) {
			System.out.println(h);
		}
		
		System.out.println("What is your first name?");
		String playerName = reader.next();
		player1 = new Player(playerName);
		
		Player[] players = {player1, player2, player3, player4};
		
		for (int i = 0; i < 4; i++) {
			players[i].assignHand(hands[i]);
		}
		
		//TODO: calculateInitialStarter
		//TODO: change this while loop to while scores < 100
		//TODO: also add scores to each player
		//TODO: 
		while (cardsLeft(hands[0]) > 0) {
			//TODO: start with winner and then go in circle using modulo to get each person's card
		}
		
	}
	
	public static int cardsLeft(Hand oneHand) {
		return oneHand.sizeOfHand();
	}
	
	public static void testDeal(Hand[] hands) {
		for (int h = 0; h < 3; h++) {
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
	}
}

package game;

import java.util.Scanner;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Hearts {
	public static void main(String[] args) {
		Deck mainDeck = new Deck();
		Scanner reader = new Scanner(System.in);
		Player starter;
			
		Hand[] hands = mainDeck.deal();
		Player[] players = new Player[4];
		
		for (int i = 0; i < 4; i++) {
			createPlayer(reader, players, i);
		}
		
		for (int i = 0; i < 4; i++) {
			players[i].assignHand(hands[i]);
		}
		
		starter = getInitialStarter(players);
		
		System.out.println("\n\nAwesome. Let's get started!\n"+ starter.getName() + " will lead with the two of clubs.");
		System.out.println("Press Enter to Continue.");
		while (!reader.nextLine().equals("")) {
		}
		while (!reader.nextLine().equals("")) {
		}
		
		Map<Player, Card> cardsPlayed = new TreeMap<Player, Card>();
		for (Player p : players) {
			p.resetWinnings();
		}
		cardsPlayed.put(starter, starter.playCard("2", "clubs", reader, "clubs"));
		starter = playHand(players, cardsPlayed, starter, reader);
		
		while ( !gameOver(players) ) {
			
			if (cardsLeft(hands[0]) == 0){
				for (Player p : players) {
					p.resetWinnings();
				}
				cardsPlayed.clear();
				cardsPlayed.put(starter, starter.playCard("2", "clubs", reader, "clubs"));
				playHand(players, cardsPlayed, starter, reader);
			}
			
			else {
				System.out.println("\n" + starter.getName() +  ": Press Enter to see your cards.");
				while (!reader.nextLine().equals("")) {
					}
				System.out.println(starter.getName() + ": What Card Would you like to play? \n" + 
						"Please type your card in a format like \"2 of clubs\" or \"king of diamonds\"+"
						+ "Here are your cards:\n" + starter.accessHand().toString());
				boolean notClearHearts = true;
				String val = "";
				String playersSuit = "";
				while (notClearHearts) {
					val = reader.next();
					reader.next();
					playersSuit = reader.next();
					if (!playersSuit.equals("hearts")) {
						notClearHearts = false;
					}
					else if (brokenHearts(hands)) {
						notClearHearts = false;
					}
					else {
						System.out.println("You cannot start a round with a heart, since the hearts have yet to be broken. Please try again");
					}
				}
				cardsPlayed.put(starter, starter.playCard(val, playersSuit, reader, playersSuit));
				starter = playHand(players, cardsPlayed, starter, reader);
			}
		}
		
		reader.close();
	}
	
	
	public static int cardsLeft(Hand oneHand) {
		return oneHand.sizeOfHand();
	}
	
	public static Player playHand(Player[] players, Map<Player, 
			Card> cardsPlayed, Player starter, Scanner reader) {
		for (int i = 0; i < 4; i++) {
			if (players[i].equals(starter)) {
				for (int j = 1; j < 4; j++) {
					System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nCards played so far:");
					Player[] keys = new Player[4];
					for (int h = 0; h < 4; h++) {
						keys[h] = players[(i+h)%4];
					}
					for(Player p: keys) {
						if (cardsPlayed.get(p) != null) {
							System.out.println("" + p.getName() + ": " + cardsPlayed.get(p));
						}
					}
					Player currentPlayer = players[(i+j)%4];
					System.out.println("\n" + currentPlayer.getName() +  ": It is your turn. Press Enter to see your cards.");
					while (!reader.nextLine().equals("")) {
						}
					System.out.println(currentPlayer.getName() + ": What Card Would you like to play? \n" + 
							"Please type your card in a format like \"2 of clubs\" or \"king of diamonds\""
							+ "Here are your cards:\n" + currentPlayer.accessHand().toString());
					String val = reader.next();
					reader.next();
					String playersSuit = reader.next();
					String leadSuit = cardsPlayed.get(starter).suit();
					cardsPlayed.put(currentPlayer, currentPlayer.playCard(val, playersSuit, reader, leadSuit));
				}
				break;
			}
		}
		Card topCard = cardsPlayed.get(starter);
		Player topPlayer = starter;
		String topSuit = topCard.suit();
		Integer topNumber = topCard.numberValue();
		for(Map.Entry<Player,Card> entry : cardsPlayed.entrySet()) {
			Card currentCard = entry.getValue();
			if (currentCard.suit().equals("hearts")) {
				if ((topSuit.equals("hearts")) && (currentCard.numberValue() > topNumber)) {
					topSuit = currentCard.suit();
					topNumber = currentCard.numberValue();
					topCard = currentCard;
					topPlayer = entry.getKey();
				}
				else if (!topSuit.equals("hearts")) {
					topSuit = currentCard.suit();
					topNumber = currentCard.numberValue();
					topCard = currentCard;
					topPlayer = entry.getKey();
				}
			}
			else if ((currentCard.suit().equals(topSuit)) && (currentCard.numberValue() > topNumber)) {
				topSuit = currentCard.suit();
				topNumber = currentCard.numberValue();
				topCard = currentCard;
				topPlayer = entry.getKey();
			}
		}
		topPlayer.addWinnings(cardsPlayed.values());
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n" + topPlayer.getName() + 
				" takes the hand with the " + topCard.toString() + " so they get to start this hand of play.");
		System.out.println("Press Enter to Continue");
		while (!reader.nextLine().equals("")) {
		}
		while (!reader.nextLine().equals("")) {
		}
		cardsPlayed.clear();
		return topPlayer;
	}
	
	public static boolean brokenHearts(Hand[] hands) {
		int sum = 0;
		for (Hand h: hands) {
			sum += h.seeHearts().size();
		}
		if (sum == 13) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public static boolean gameOver(Player[] players) {
		int max = 0;
		Set<Player> winners = new HashSet<Player>();
		String winner = "";
		for (int p = 0; p < 4; p++) {
			int pScore = players[p].getScore();
			if (pScore > max) {
				max = pScore;
				winners.clear();
				winners.add(players[p]);
				winner = players[p].getName();
			}
			else if (pScore == max) {
				winners.add(players[p]);
			}
		}
		if ((max >= 100) && (winners.size()==1)) {
			System.out.println("" + winner + " has one the game. Congratulations " + winner + "!" +
					"\nIf you would like to play again, please restart the program.");
			return true;
		}
		return false;
	}
	
	public static Player getInitialStarter(Player[] players) {
		for (Player p : players) {
			if (p.accessHand().seeClubs().contains(2)) {
				return p;
			}
		}
		return null;
	}
	
	public static void createPlayer(Scanner reader, Player[] players, int i) {
		System.out.println("Player " + (i+1) + ": What is your first name?");
		String playerName = reader.next();
		boolean taken = false;
		for (int j = i-1; j >= 0; j--) {
			if (players[j].getName().equals(playerName.trim())) {
				taken = true;
			}
		}
		if (taken) {
			System.out.println("That name is taken. Please try again.");
			createPlayer(reader, players, i);
		}
		else {
			players[i] = new Player(playerName.trim());
		}
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

package application;

import java.util.ArrayList;
import java.util.Collections;

import application.Card.Rank;
import application.Card.Suit;


public class Deck {
	
	 //Cards remaining in deck.
	 
	private ArrayList<Card> cards = new ArrayList<Card>();

	
	 // Cards drawn from deck.
	 
	private ArrayList<Card> taken = new ArrayList<>();

	public Deck() {
		// === Add on one of each 52 cards ===
		for (Suit suit : Suit.values()) {
			for (Rank rank : Rank.values()) {
				cards.add(new Card(suit, rank));
			}
		}
	}

	public void reset() {
		// === Add back all taken cards ===
		cards.addAll(taken);
		taken.clear();
	}

	public void shuffle() {
		// === Why invent when you can reuse? ===
		Collections.shuffle(cards);
	}

	public Card drawCard() {
		// === Draw card, place it in the taken list as well ===
		if (cards.isEmpty())
			return null;

		Card drawn = cards.remove(0);
		taken.add(drawn);

		return drawn;
	}
}
package application;

import application.Card.Rank;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.ObservableList;
import javafx.scene.Node;

/**
 * @author GladeJoa
 */
public class Hand implements Commons {

	/**
	 * The cards that define this hand.
	 */
	private ObservableList<Node> cards;

	/**
	 * A property that represents the value of the hand.
	 */
	private SimpleIntegerProperty value = new SimpleIntegerProperty(0);

	/**
	 * A property that represents the size of the hand.
	 */
	private SimpleIntegerProperty size = new SimpleIntegerProperty(0);

	/**
	 * The number of aces in hand.
	 */
	private int aces = 0;

	public Hand(ObservableList<Node> cards) {
		this.cards = cards;
	}

	public void reset() {
		cards.clear();
		value.set(0);
		aces = 0;
		size.set(0);
	}

	public void showFirstCard() {
		if (cards.isEmpty()) return;
		((Card) cards.get(0)).showCard();
	}

	public void hideFirstCard() {
		if (cards.isEmpty()) return;
		((Card) cards.get(0)).hideCard();
	}

	public void addAllCards(Card... cardsToAdd) {
		for (Card card : cardsToAdd) {
			addCard(card);
		}
	}

	/**
	 * Method will add card to view and not add on value.
	 * 
	 * @param card
	 *            : Card to be added to hand's view.
	 */
	public void addCardToView(Card card) {
		cards.add(card);
	}

	/**
	 * Method will add card's value, but not to view.
	 * 
	 * @param card
	 *            : Card to add on value from.
	 */
	private void addCard(Card card) {
		if (card.rank() == Rank.ACE)
			aces++;

		// ~ Busted, but got an ace? Subtract 10 from current value.
		if (value.get() + card.value() > PLAYER_HAND_MAX_VALUE && aces > 0) {
			value.set(value.get() + card.value() - 10);
			aces--;
		} else {
			value.set(value.get() + card.value());
		}

		// ~ Update Size
		size.set(size.get() + 1);
	}

	/**
	 * Method will return the visible value of hand, that is the value of shown
	 * cards in hand.
	 * 
	 * @return The visible value of hand
	 */
	public int visibleValue() {
		if (cards.size() == 0) return 0;
		
		Card first = (Card) cards.get(0);
		return first.isHidden() ? value.get() - first.value() : value.get();
	}

	/**************************/
	/** GETTERS AND SETTERS **/
	/**************************/
	public int aces() {
		return aces;
	}

	public SimpleIntegerProperty valueProperty() {
		return value;
	}

	public int value() {
		return value.get();
	}

	public SimpleIntegerProperty sizeProperty() {
		return size;
	}

	public int size() {
		return size.get();
	}
}
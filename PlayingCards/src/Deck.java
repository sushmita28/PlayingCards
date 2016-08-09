import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

	private List<Card> cards = new ArrayList<Card>();

	public Deck() {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 13; j++) {
				cards.add(new Card(i, j));
			}
		}
		cards = shuffle();
	}

	public List<Card> shuffle() {
		Collections.shuffle(this.cards);
		return cards;
	}

	public Card drawRandomCard() {
		Card latestCard = cards.get(cards.size());
		return latestCard;
	}

}

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Deck {
	private int cardsInDeck;

	private List<Pack> packs = new ArrayList<Pack>();
	private List<Card> cards = new ArrayList<Card>();

	public Deck(List<Pack> packs) {
		for (Pack p : packs)
			for (int i = 0; i < p.getPackSize(); i++)
				cards.add(p.getCard(i));
	}
	// cards = Pack.shuffle();

	public int getCardsInDeck() {
		return cardsInDeck;
	}

	public List<Pack> shuffleDeck() {
		Collections.shuffle(this.packs);
		return packs;
	}

	public Card drawRandomCard() {
		Random generator = new Random();
		int index = generator.nextInt(cards.size());
		return cards.remove(index);
	}

	public static void main(String[] args) {
		System.out.println("Enter the number of players");

	}

}

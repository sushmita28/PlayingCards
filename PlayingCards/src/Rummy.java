import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Rummy {
	static HashMap<String,Integer> suitMap = new HashMap<String,Integer>();
	
	List<Integer> nums = new ArrayList<>();
	List<Integer> shapes = new ArrayList<>();
	static Card[] cardsInHand;
	public static void assessRummyCards(Hand hand) {
		
		sortCards(cardsInHand);
		for(Card c:cardsInHand) {
			System.out.println(c.cardValue+"of"+c.cardSuit);
		}
	}
	
	public Rummy(Hand hand) {
		cardsInHand = hand.getCards();
	}
	
	public static void sortCards(Card[] cardsInHand) {
		for(int i=0;i<(cardsInHand.length-1);i++) {
			for(int j=i+1; j<cardsInHand.length;j++) {
				if(suitMap.get(cardsInHand[i].getCardSuit())>suitMap.get(cardsInHand[j].getCardSuit())) {
					swap(cardsInHand[i],cardsInHand[j]);
				}	
			}
		}
		String firstSuit = cardsInHand[0].getCardSuit();
		int firstSuitIndex = 0;
		for(int i=1;i<cardsInHand.length; i++) {
			if(cardsInHand[i].getCardSuit()==firstSuit) {
				i++;
			}
			else {
				sortWithin(cardsInHand,firstSuitIndex,i-1);
				firstSuitIndex = i;
				firstSuit = cardsInHand[i].getCardSuit();
			}
		}
 	}
	
private static void sortWithin(Card[] cardsInHand, int firstSuitIndex, int lastSuitIndex) {
		// TODO Auto-generated method stub
	for(int i=firstSuitIndex; i <lastSuitIndex-1; i++) {
		for(int j=i+1; j<lastSuitIndex;j++) {
			if((Integer.parseInt(cardsInHand[i].cardValue)) > (Integer.parseInt(cardsInHand[j].cardValue)))
				swap(cardsInHand[i],cardsInHand[j]);
		}
	}
}


	public Rummy(){
		populateSuitValues();
	}
	
	public static void swap(Card c1,Card c2) {
		Card temp;
		temp = c1;
		c1 = c2;
		c2 = temp;
	}
	
	private void populateSuitValues(){
		suitMap.put("HEARTS", 0);
		suitMap.put("SPADES", 1);
		suitMap.put("DIAMONDS", 2);
		suitMap.put("CLUBS", 3);
	}

//	private List<Integer> getSets(List<Integer> nums) {
//		
//		
//		for(Integer n: nums) {
//			int difference = nums.get(n+1) - nums.get(n);
//		}
//		return null;
//	}
	
	public static void main(String[] args) {

		Pack p = new Pack();
		List<Pack> packList = new ArrayList<Pack>();
		packList.add(p);
		Deck deck = new Deck(packList);
		Hand hand = new Hand(deck,13);
		Rummy r = new Rummy(hand);
		assessRummyCards(hand);
		
	}
}

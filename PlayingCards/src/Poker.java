package playCards;

import java.util.HashMap;

public class Poker {
	card[] cards;
	static HashMap<String,Integer> suitMap = new HashMap<String,Integer>();
	
	
	//public Poker(Hand hand){
		
	//	cards=hand.getCards();
//	}
		
		public boolean isFiveOfAKind(Hand h){
			cards=h.getCards();
			String FaceValue=cards[0].getCardValue();
			for(int i=1;i<cards.length;i++){
				if(cards[i].getCardValue()!=FaceValue){
					return false;
				}
				
			}
			return true;
		}
		
		public boolean isStraightFlush(Hand h){
			cards=h.getCards();
			sortWithin(cards,0,cards.length-1);
			for(int i=0;i<cards.length-1;i++){
				if(cards[i].getCardValue()!=cards[i+1].getCardValue()){
					return false;
				}
			}
		return true;
	}
		
		public boolean isFourOfAKind(Hand h){
			cards=h.getCards();
			sortWithin(cards,0,cards.length-1);
			String FaceValue=cards[0].getCardValue();
			int CountOfValue=0;
			if(FaceValue!=cards[1].getCardValue()){
				FaceValue=cards[1].getCardValue();
			}
			for(int i=1;i<cards.length;i++){
				if(cards[i].getCardValue()==FaceValue){
					CountOfValue++;
				}
			}
			if(CountOfValue==4){
				return true;
			}
			else return false;
			
		}
		
		public boolean isFullHouse(Hand h){
			cards=h.getCards();
			sortWithin(cards,0,cards.length-1);
			if(cards[0].getCardValue()==cards[1].getCardValue() && cards[1].getCardValue()==cards[2].getCardValue()){
				if(cards[3].getCardValue()==cards[4].getCardValue()){
					return true;
				}
			}
			return false;
		}
		
		public boolean isFlush(Hand h){
			cards=h.getCards();
			String cardSuit=cards[0].getCardSuit();
			for(int i=0;i<cards.length;i++){
				if(cards[i].getCardSuit()!=cardSuit){
					return false;
				}
			}
			return true;
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
		
		

}

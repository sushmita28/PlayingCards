
public class Hand {
	
	private Card[] Cards;
	
	
	
	public Hand(Deck d , int size){
		
		Cards = new Card[size];
		for(i=0; i < size ; i++)
			Cards[i] = d.drawRandomCard();
		
	}
	
	public void printHand(){
		for(Card C : Cards){
			System.out.println(C.getCardValue() + " " + C.getCardSuit)
		}
	}
	
	public void evaluateHand(){
		
	}
	
	public void compare(Hand H){
		
	}
			

}

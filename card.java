package playCards;

public class card {
	String cardValue;
	String cardSuit;
	
	int type;    
	int value;
	
	private static String[] VALUES = { "Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13" };
	
	private static String[] SUITS = { "HEARTS", "DIAMONDS", "SPADES", "CLUBS" };
    
	public card(int cardSuit, int cardValue) {
		this.cardValue = card.VALUES[cardValue+1];
		this.cardSuit = card.SUITS[cardSuit+1];
	}

	public String getCardValue() {

		return this.cardValue;

	}

	public String getCardSuit() {
		return this.cardSuit;
	}

	public boolean isSuitMatch(card c) {
		return c.getCardSuit() == this.cardSuit;
	}
	
	public boolean isValueMatch(card c){
		return c.getCardValue()==this.cardValue;
	}
	
	public boolean isNextCardByValue(card c){
		int thisIndex=0;
		int thatIndex=0;
		for(int i=0;i<card.VALUES.length;i++){
			if(card.VALUES[i]==c.getCardValue()){
				thatIndex=i;
			}
			if(card.VALUES[i]==this.cardValue){
				thisIndex=i;
			}
			
		}
		return thisIndex==thatIndex+1;
	}
	
	public boolean isPrevCardByValue(card c){
		int thisIndex=0;
		int thatIndex=0;
		for(int i=0;i<card.VALUES.length;i++){
			if(card.VALUES[i]==c.getCardValue()){
				thatIndex=i;
			}
			if(card.VALUES[i]==this.cardValue){
				thisIndex=i;
			}
			
		}
		return thisIndex==thatIndex-1;
	}
	
	

}
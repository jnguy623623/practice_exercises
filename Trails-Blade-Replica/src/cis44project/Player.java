
package cis44project;


public class Player<T> {
    Card card = new Card();
    private StackInterface<Card> field;
    private Card[] hand;
    
    public Player(StackInterface<Card> field, Card[] hand){
        
        this.field = field;
        this.hand = hand;
        
    }
    
    
    public Card[] getHand(){
        return hand;
    }
    
    public StackInterface<Card> getField(){
        return field;
    }
    
    public int getFieldPwr(){
        
        int total = 0;
        
        //take items from stack and place into temporary stack
        while (field.isEmpty() == false){
            
            StackInterface<Card> tempStack = new ArrayStack<>();
            
            Card tempCard = field.pop();
            total += tempCard.getPwr();
            tempStack.push(tempCard);
            
            
        }
        
        return total;
        
    }
    
    
    
    /**
     * Adds cards from an ArrayBag to the hand
     * @param deck 
     
    public void addCards(BagInterface<T> deck){
        
        for (int i = 0; i < hand.length; i++){
            T tempCard = deck.remove(); //THIS LINE
            hand[i] = tempCard;
            
        }
   
    }*/
    
    //text form only
    public void displayHand(){
        
        String str = "";
        for(int i = 0; i < hand.length; i++){
           Card currentCard = hand[i];
           str = str + currentCard.toString() + "\n"; 
        }
        
        
        System.out.print(str);
        //return str;
        
        
    }
   
    public String toString(){
        
        String str = "";
        for(int i = 0; i < hand.length; i++){
           
           str = str + hand[i].toString() + "\n"; 
        }
        
        
        
        return str;
        
        
    }
    
    
    
}

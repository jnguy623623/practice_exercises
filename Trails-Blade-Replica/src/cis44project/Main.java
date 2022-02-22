
package cis44project;

/**
 *
 * @author daic
 */
public class Main {

    public static void main(String[] args) {
        
        //Setup
        BagInterface<Card> deck = new ArrayBag<>();
        StackInterface<Card> field1 = new ArrayStack<>();
        StackInterface<Card> field2 = new ArrayStack<>();
        Card[] hand1 = new Card[10];
        Card[] hand2 = new Card[10];
        
        Card card1 = new Card(1, "Hammer"); //Hmr
        Card card2 = new Card(2, "Dagger"); //Dgr
        Card card3 = new Card(3, "Short"); //Srt
        Card card4 = new Card(4, "Zwei"); //Zwi
        Card card5 = new Card(5, "Lance");//Lnc
        Card card6 = new Card(6, "Halberd");//Hld
        Card card7 = new Card(7, "BattleAxe");//Axe
        
        Card card8 = new Card(0, "Thief");//Thf
        Card card9 = new Card(0, "Swap");//Swp
        Card card10 = new Card(0, "Sabotage");//Sbg 
        
        
        //we need to add cards to deck
        for (int i = 0; i < 20; i++){
            deck.add(card2); 
            deck.add(card3);
            deck.add(card4);
            deck.add(card5);
            deck.add(card6);
            deck.add(card7);
            
            
            deck.add(card1);
            deck.add(card8);
            deck.add(card9);
            deck.add(card10);
        }
       //System.out.println(deck.getCurrentSize());
       //deck.display();//display the contents of the deck
        
        //we need to draw from the deck and assign "fields"
        
        for (int i = 0; i < hand1.length; i++){
            Card tempCard1 = deck.remove();
            Card tempCard2 = deck.remove();
            
            hand1[i] = tempCard1;
            hand2[i] = tempCard2;
            
        }
        
                
                
                
        
        Player player1 = new Player(field1, hand1);
        Player player2 = new Player(field2, hand2);

        System.out.println("Player1 hand:");
        //System.out.println(player1.toString());//need to edit stuff to display pwr
        player1.displayHand();
        
        System.out.println("Player2 hand:");
        //System.out.println(player2.toString());
        player1.displayHand();
        
        //we need to determines who goes first
        
        
        
        int goFirst, goSecond;
        while (field1.isEmpty() == false && field2.isEmpty() == false){
            
            Card aCard = deck.remove();
            field1.push(aCard);
            Card bCard = deck.remove();
            field2.push(bCard);
            
            if (aCard.getPwr() > bCard.getPwr()){
                goFirst = 2;
                goSecond = 1;
            }
            
            if (aCard.getPwr() < bCard.getPwr()){
                goFirst = 1;
                goSecond = 2;
            }
            
            else{
                field1.pop();
                field2.pop();
            }
            
            
        }
        
        
    }//end main method
    
    
    
    
    
}//end class


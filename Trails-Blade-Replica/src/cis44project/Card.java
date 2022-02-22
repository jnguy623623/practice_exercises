package cis44project;

/**
 *
 * @author daic
 */
public class Card {
    
    private int pwr;
    private String name;
    
    
    
    public Card(){
        pwr = 0;
        name = "";
    }
    
    public Card(int pwr, String name){
        
        this.pwr = pwr;
        this.name = name;
        
    }
    
    public int getPwr(){
        return pwr;
    }
    
    public void setPwr(int newPwr){
        
        pwr = newPwr;
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String newName){
        name = newName;
    }
    
    public String toString(){
        
        String str = " ";
        str += getName();
        //str = "Card Name: " + getName() + "\n";
        //str = str + "Card Power: " + getPwr() + "\n";
        
        return str;
        
    }
    
}

//do we need comparable for comparing pwr?
import javax.swing.text.StyledEditorKit.BoldAction;

public class Utility extends Property{
	
    public Utility(String propertyName){
        this.propertyName = propertyName;
        bankPrice = 150;
        propertyType = "Utility";
    }
    
    public int costOfRent(int position, int diceRoll1, int diceRoll2) {
    	int cost = 0;
    	int utilitiesOwned = 0;
    	
    	if(Board.allProperties[position].isMortgaged)
    		return cost;
    	if(Board.allProperties[12].isMortgaged && Board.allProperties[12].ownedBy.equals(Board.allProperties[position].ownedBy))
    		utilitiesOwned--;
    	if(Board.allProperties[28].isMortgaged && Board.allProperties[28].ownedBy.equals(Board.allProperties[position].ownedBy))
    		utilitiesOwned--;
    	
    	if(Board.allProperties[12].ownedBy != null && Board.allProperties[12].ownedBy.equals(Board.allProperties[position].ownedBy))
    		utilitiesOwned++;
        if(Board.allProperties[28].ownedBy != null && Board.allProperties[28].ownedBy.equals(Board.allProperties[position].ownedBy))
    		utilitiesOwned++;
        
        if(utilitiesOwned == 1)
        	cost = 4 * (diceRoll1 + diceRoll2);
        else if(utilitiesOwned == 2)
        	cost = 10 * (diceRoll1 + diceRoll2);
        
        return cost;
    }
}
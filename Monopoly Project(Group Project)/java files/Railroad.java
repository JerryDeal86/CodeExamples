import javax.lang.model.util.ElementScanner6;

public class Railroad extends Property {
	
    public Railroad(String propertyName) {
        this.propertyName = propertyName;
        bankPrice = 200;
        propertyType = "Railroad";
    }
    
    public int costOfRent(int position) {
    	int cost = 0;
    	int RRsOwned = 0;
    	
    	if(Board.allProperties[position].isMortgaged)
    		return cost;
    	
    	for(int i = 5; i <= 35; i +=10)
    		if(Board.allProperties[i].isMortgaged && Board.allProperties[i].ownedBy.equals(Board.allProperties[position].ownedBy))
        		RRsOwned--;
    	
    	for(int i = 5; i <= 35; i +=10)
    		if(Board.allProperties[i].ownedBy != null && Board.allProperties[i].ownedBy.equals(Board.allProperties[position].ownedBy))
        		RRsOwned++;
        
    	if(RRsOwned==0)
    		return cost;
    	
    	cost = 25;
    	for(int i = 1; i < RRsOwned ; i++)
    		cost *= 2;
    	
        //cost = RRsOwned * 25;
    	
        return cost;
    }
}
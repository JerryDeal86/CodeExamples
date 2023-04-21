import javax.lang.model.util.ElementScanner6;
import java.util.ArrayList;

public class NormalProperty extends Property{
	
    String propertyColor;
    int housePrice;
    int ownedPrices[] = new int[6];
    int numberOfHouses = 0;
    
    public NormalProperty(String propertyName, String propertyColor, int bankPrice, int housePrice, int[] ownedPrices){
        this.propertyName = propertyName;
        this.propertyColor = propertyColor;
        this.bankPrice = bankPrice;
        this.housePrice = housePrice;
        propertyType = "Normal Property";
        
        for(int i = 0; i < 6; i++)
        	this.ownedPrices[i] = ownedPrices[i];
    }
    
    
    public int costOfRent(int position) {
    	int cost = 0;
    	String holdsColor = "";
    	ArrayList<NormalProperty> allOfSameColor = new ArrayList<>();
    	
    	if(Board.allProperties[position].isMortgaged) {
    		return cost;
    	}
    	
    	else {
        	cost = this.ownedPrices[this.numberOfHouses];
        	
        	if(this.numberOfHouses == 0) {
        		holdsColor = this.propertyColor;
        		this.allOfAColor(allOfSameColor, holdsColor);
        		
        		int i;
        		for(i = 0; i < allOfSameColor.size(); i++)
        			if(allOfSameColor.get(i).ownedBy == null || !allOfSameColor.get(i).ownedBy.equals(this.ownedBy))
        				break;
        		
        		if(i == allOfSameColor.size())
        			cost *= 2;
        	}
    	}
    	
    	return cost;
    }
    
    public void allOfAColor(ArrayList<NormalProperty> colorProperty, String color) {
		int i;
		for(i = 0; i < 40; i++) {
			if(Board.allProperties[i] != null && Board.allProperties[i].propertyType != null &&
			Board.allProperties[i].propertyType.equals("Normal Property")) {
				NormalProperty prop = (NormalProperty) Board.allProperties[i];
				
				if(prop.propertyColor.equals(color))
					colorProperty.add(prop);
			}
		}
    }
    
    
    
    /* Unused Methods
    public int findPrice(boolean isMortgaged, int ownedPrices[], int numberofHouses){
        if(isMortgaged)
            return 0; //there is no rent.
        else
            if(numberofHouses >= 0 && numberofHouses <= 5)
                return ownedPrices[numberOfHouses];
            else
                return -1;
    }
    
    public int findHousePrice() {
    	return this.housePrice;
    }

public int buyHouse(int cash){
    	if(cash < this.housePrice)
    		return -1; //Player has insufficient cash
    	if(numberOfHouses<5) {
    		this.numberOfHouses++;
    		return this.housePrice;
    	}
    	if(numberOfHouses==5)
    		return -2; //This property has a hotel already!
    	
    	return 00;
    }
    public int sellHouse(){
    	if(this.numberOfHouses>0) {
    		numberOfHouses--;
    		return (this.housePrice/2); //Returns cash given to player for selling house.
    	}
    	return -1;
    }*/
}
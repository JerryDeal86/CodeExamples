import java.util.ArrayList;

public class Player {
    
	int number;
	String name;
    int cash;
    ArrayList<Property> propertyOwned = new ArrayList<>();
    boolean outOfMoney;
    int position;
    boolean isInJail;
    boolean justLeftJail;
    int jailDoubleTries = 0;
    int diceRoll1;
    int diceRoll2;
    int doubles = 0;
    
    public Player(String name , int number) {
    	this.name = name;
    	this.number = number;
    	cash = 1500;
    	outOfMoney = false;
    	position = 0;
    	isInJail = false;
    }
    
    public void playTurn() {
    	PlayerTurn turn = new PlayerTurn(this);
    	diceRoll1 = turn.diceRoll();
    	diceRoll2 = turn.diceRoll();
    	
    	if(diceRoll1 == diceRoll2)
    		doubles++;
    	
    	if(isInJail) {
    		jailDoubleTries++;
    		if(doubles == 1) {
    			turn.leaveJail();
    			doubles = 0;
    			jailDoubleTries = 0;
    		}
    		else if(jailDoubleTries == 3) {
    			cash -= 50;
    			turn.leaveJail();
    			doubles = 0;
    			jailDoubleTries = 0;
    		}
    		else
    			return;
    	}
    	
    	if(doubles == 3 || position + diceRoll1 + diceRoll2 == 30)
    		turn.goToJail();
    	else {
    		if(position + diceRoll1 + diceRoll2 >= 40)
    			turn.passGo(cash);
    		position = (position + diceRoll1 + diceRoll2) % 40;
    	}
    	
    	if(Board.allProperties[position] != null && Board.allProperties[position].ownedBy != null 
    	&& !Board.allProperties[position].ownedBy.equals(this))
    		turn.payRent(position);
    	else if(position == 4)
    		cash -= 200;
    	else if(position == 38)
    		cash -= 75;
    }
    
    public void buyProperty(int position) {
 
    	if(Board.allProperties[position] == null || Board.allProperties[position].ownedBy != null) {
    		return;
    	}
    	
    	int cost = Board.allProperties[position].findPrice(Board.allProperties[position].propertyType);
    	
    	if(cash >= cost) {
    		Board.allProperties[position].ownedBy = this;
    		propertyOwned.add(Board.allProperties[position]);
    		cash -= cost;
    	}
    }

	//You can't actually sell property in Monopoly unless it's to
	//another player, which would be extremely difficult to implement.
	//Should be deleted.
    /*
    public int sellProperty(String property) {
    	return 1;
    }*/

    public void mortgage(String propName) {
    	int i;
    	String holdsColor;
    	ArrayList<NormalProperty> allOfSameColor = new ArrayList<>();
    	boolean skip = false;
    	
    	for(i = 0; i < propertyOwned.size(); i++)
    		if(propertyOwned.get(i).propertyName.equals(propName))
    			break;
    	
    	if(i < propertyOwned.size() && propertyOwned.get(i).propertyType.equals("Normal Property") && !propertyOwned.get(i).isMortgaged) {
    		NormalProperty np = (NormalProperty) propertyOwned.get(i);
    		
    		holdsColor = np.propertyColor;
    		np.allOfAColor(allOfSameColor, holdsColor);
    		
    		for(int j = 0; j < allOfSameColor.size(); j++)
    			if(allOfSameColor.get(j).ownedBy != null && !allOfSameColor.get(j).ownedBy.equals(np.ownedBy)) {
    				skip = true;
    				break;
    			}
    		
    		if(!skip)
    			for(int j = 0; j < allOfSameColor.size(); j++)
    				if(allOfSameColor.get(j).numberOfHouses > 0)
    					return;
    	}
    	
    	int mortgage;
    	if(i < propertyOwned.size() && !propertyOwned.get(i).isMortgaged) {
    		mortgage = propertyOwned.get(i).bankPrice / 2; //The mortgage price is half the bank price.
    		propertyOwned.get(i).isMortgaged = true;
    		cash += mortgage;
    	}
    }
    
    public void unmortgage(String propName) {
    	int i;
    	
    	for(i = 0; i < propertyOwned.size(); i++)
    		if(propertyOwned.get(i).propertyName.equals(propName))
    			break;
    	
    	int unmortgage = (int) Math.round((propertyOwned.get(i).bankPrice / 2) * 1.1); //The unmortgage price is half the bank price and 10% extra.
;
    	if(cash >= unmortgage && i < propertyOwned.size() && propertyOwned.get(i).isMortgaged) {
    		propertyOwned.get(i).isMortgaged = false;
    		cash -= unmortgage;
    	}
    }
    
    public void buyHouse(String propName) {
    	int i;
    	String holdsColor;
    	ArrayList<NormalProperty> allOfSameColor = new ArrayList<>();
    	int priceOfHouse;
    	
    	for(i = 0; i < propertyOwned.size(); i ++)
    		if(propertyOwned.get(i).propertyName.equals(propName))
    			break;
    	
    	if(i < propertyOwned.size() && propertyOwned.get(i).propertyType.equals("Normal Property") && !propertyOwned.get(i).isMortgaged) {
    		NormalProperty np = (NormalProperty) propertyOwned.get(i);
    		
    		holdsColor = np.propertyColor;
    		np.allOfAColor(allOfSameColor, holdsColor);
    		
    		for(int j = 0; j < allOfSameColor.size(); j++)
    			if(allOfSameColor.get(j).ownedBy != null && !allOfSameColor.get(j).ownedBy.equals(np.ownedBy))
    				return;
    		
    		for(int j = 0; j < allOfSameColor.size(); j++)
    			if(allOfSameColor.get(j).isMortgaged || np.numberOfHouses > allOfSameColor.get(j).numberOfHouses)
    				return;
    		
			priceOfHouse = np.housePrice;
    		if(cash >= priceOfHouse && np.numberOfHouses < 5) {
    			cash -= priceOfHouse;
    			np.numberOfHouses++;
    		}
    	}
    }
    
    public void sellHouse(String propName) {
    	int i;
    	String holdsColor;
    	ArrayList<NormalProperty> allOfSameColor = new ArrayList<>();
    	int priceOfHouse;
    	
    	for(i = 0; i < propertyOwned.size(); i ++)
    		if(propertyOwned.get(i).propertyName.equals(propName))
    			break;
    	
    	if(i < propertyOwned.size() && propertyOwned.get(i).propertyType.equals("Normal Property") && !propertyOwned.get(i).isMortgaged) {
    		NormalProperty np = (NormalProperty) propertyOwned.get(i);
    		
    		holdsColor = np.propertyColor;
    		np.allOfAColor(allOfSameColor, holdsColor);
    		
    		for(int j = 0; j < allOfSameColor.size(); j++)
    			if(!allOfSameColor.get(j).ownedBy.equals(np.ownedBy))
    				return;
    		
    		for(int j = 0; j < allOfSameColor.size(); j++)
    			if(np.numberOfHouses < allOfSameColor.get(j).numberOfHouses)
    				return;
    		
    		if(np.numberOfHouses > 0) {
    			priceOfHouse = np.housePrice;
    			cash += priceOfHouse / 2;
    			np.numberOfHouses--;
    		}
    	}
    }
}
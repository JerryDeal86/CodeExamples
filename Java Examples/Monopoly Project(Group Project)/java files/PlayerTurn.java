public class PlayerTurn{
    boolean doubles;
    Player player;

    public PlayerTurn(Player player){
    	this.player = player;
    }

    public int diceRoll() {
    	int dice = (int) (Math.random() * 6 + 1);
        return dice;
    }
    
    public void goToJail() {
    	player.position = 10;
    	player.isInJail = true;
    	player.doubles = 0;
    }
    
    public void leaveJail() {
    	player.position = 10;
    	player.isInJail = false;
    	player.justLeftJail = true;
    }
    
    public void payRent(int position) {
    	int cost = 0;    	
    	
    	if(Board.allProperties[position].propertyType.equals("Normal Property")) {
    		NormalProperty np = (NormalProperty) Board.allProperties[position];
    		cost = np.costOfRent(position);
    	}
    	
    	else if(Board.allProperties[position].propertyType.equals("Railroad")) {
    		Railroad rr = (Railroad) Board.allProperties[position];
    		cost = rr.costOfRent(position);
    	}
    	
    	else {
    		Utility u = (Utility) Board.allProperties[position];
    		cost = u.costOfRent(position, player.diceRoll1, player.diceRoll2);
    	}
    	
    	player.cash -= cost;
    	Board.allProperties[position].ownedBy.cash += cost;
    }
    	    	    
    public void passGo(int cash){
    	player.cash += 200;
    }
}
public class Property { //This should probably be an abstract class.
	
    String propertyName;
    int bankPrice;
    boolean isMortgaged;
    Player ownedBy;
    String propertyType;
    
    public Property() {
    }
    
    public int costOfRent(String propertyType) {
    	return 0;
    }
    
    /*
    public int mortgage(String property) {
        return 1;
    }*/
    
    
    public int findPrice(String propertyType) {
        return this.bankPrice;
    }
    
    //Most likely not needed.
    //Should be deleted.
    //public String unmortgageProperty(int cash){
    //    return "test";
    //}
    
    //Moved to Player.
    /*
    public String buyProperty(int cash){
        return "test";
    }
    
    public int sellProperty(Property property){
        return 1;
    }
    **/
}
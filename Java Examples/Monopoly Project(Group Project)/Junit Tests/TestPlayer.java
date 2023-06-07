import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TestPlayer{
    
	@Test
	void testBuyProperty() {
		
		Player player1 = new Player("Test Player", 1);
		player1.cash = 1500;
		
		Property p2Property = new NormalProperty("Oriental Ave", "Cyan", 100, 50, new int[] {50, 70, 90, 270, 400, 550});
		Board.allProperties[6] = p2Property;
		Property secondProperty = new NormalProperty("VT Ave", "Cyan", 100, 50, new int[] {6, 30, 90, 270, 400, 550});
		Board.allProperties[8] = secondProperty;
		
		player1.buyProperty(6);
		assertEquals(true,(Board.allProperties[6].ownedBy == player1));
		
	}
	
	@Test
	void testMortgage() {
		
		Player player1 = new Player("Test Player", 1);
		player1.cash = 1500;
		
		Board test = new Board();
		test.createAllProperty();
		Property p2Property = new NormalProperty("Oriental Ave", "Cyan", 100, 50, new int[] {50, 70, 90, 270, 400, 550});
		Board.allProperties[6] = p2Property;
		Property secondProperty = new NormalProperty("VT Ave", "Cyan", 100, 50, new int[] {6, 30, 90, 270, 400, 550});
		Board.allProperties[8] = secondProperty;
		
		player1.buyProperty(6);
		player1.mortgage("Oriental Ave");
		
		assertEquals(true, Board.allProperties[6].isMortgaged);
	}
	
	@Test
	void testUnmortgage() {
		
		Player player1 = new Player("Test Player", 1);
		player1.cash = 1500;
		
		Board test = new Board();
		test.createAllProperty();
		Property p2Property = new NormalProperty("Oriental Ave", "Cyan", 100, 50, new int[] {50, 70, 90, 270, 400, 550});
		Board.allProperties[6] = p2Property;
		Property secondProperty = new NormalProperty("VT Ave", "Cyan", 100, 50, new int[] {6, 30, 90, 270, 400, 550});
		Board.allProperties[8] = secondProperty;
		
		player1.buyProperty(6);
		player1.mortgage("Oriental Ave");
		player1.unmortgage("Oriental Ave");
		
		assertEquals(false, Board.allProperties[6].isMortgaged);
		
	}
	
	@Test
	void testBuyHouse() {
		
		Player player1 = new Player("Test Player", 1);
		player1.cash = 1500;
		int houses = 0;
		
		Board test = new Board();
		test.createAllProperty();
		Property p2Property = new NormalProperty("Oriental Ave", "Cyan", 100, 50, new int[] {50, 70, 90, 270, 400, 550});
		Board.allProperties[6] = p2Property;
		Property secondProperty = new NormalProperty("VT Ave", "Cyan", 100, 50, new int[] {6, 30, 90, 270, 400, 550});
		Board.allProperties[8] = secondProperty;
		
		player1.buyProperty(6);
		player1.buyHouse("Oriental Ave");
		
		if(Board.allProperties[6].propertyType.equals("Normal Property")) {
    		NormalProperty np = (NormalProperty) Board.allProperties[6];
    		houses = np.numberOfHouses;
    	}
		
		assertEquals(1, houses);
	}
	
	@Test
	void testSellHouse() {
		
		Player player1 = new Player("Test Player", 1);
		player1.cash = 1500;
		int houses = 0;
		
		Board test = new Board();
		test.createAllProperty();
		Property p2Property = new NormalProperty("Oriental Ave", "Cyan", 100, 50, new int[] {50, 70, 90, 270, 400, 550});
		Board.allProperties[6] = p2Property;
		Property secondProperty = new NormalProperty("VT Ave", "Cyan", 100, 50, new int[] {6, 30, 90, 270, 400, 550});
		Board.allProperties[8] = secondProperty;
		
		player1.buyProperty(6);
		player1.buyHouse("Oriental Ave");
		player1.sellHouse("Oriental Ave");
		
		if(Board.allProperties[6].propertyType.equals("Normal Property")) {
    		NormalProperty np = (NormalProperty) Board.allProperties[6];
    		houses = np.numberOfHouses;
    	}
		
		assertEquals(0, houses);
	}
}
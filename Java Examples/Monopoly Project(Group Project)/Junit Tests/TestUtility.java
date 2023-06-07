import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TestUtility{
	
	@Test
	void costOfRent(){
		Utility test = new Utility("Water Works");
		
		Board test2 = new Board();
		test2.createAllProperty();
		Player testificate = new Player("Testificate", 1);
		Player heather = new Player("Heather", 2);
		
		/**
		 * One Property Owned by player 
		 */
		Board.allProperties[12].isMortgaged = false;
		Board.allProperties[12].ownedBy = testificate;
		assertEquals(28,test.costOfRent(12,5,2));
		
		/**
		 * Property owned by player is mortgaged
		 */
		Board.allProperties[12].isMortgaged = true;
		assertEquals(0,test.costOfRent(12,5,2));
		
		/**
		 * Player owns two utilities
		 */
		Board.allProperties[12].isMortgaged = false;
		Board.allProperties[12].ownedBy = testificate;
		Board.allProperties[28].ownedBy = testificate;
		assertEquals(70,test.costOfRent(12,5,2));
		
		/**
		 * Player owned two utilities, but one is mortgaged
		 */
		Board.allProperties[12].isMortgaged = false;
		Board.allProperties[28].isMortgaged = true;
		Board.allProperties[12].ownedBy = testificate;
		Board.allProperties[28].ownedBy = testificate;
		assertEquals(28,test.costOfRent(12,5,2));
		
		/**
		 * Two separate players own utilities and both are not mortgaged
		 */
		Board.allProperties[12].isMortgaged = false;
		Board.allProperties[28].isMortgaged = false;
		Board.allProperties[12].ownedBy = testificate;
		Board.allProperties[28].ownedBy = heather;
		assertEquals(28,test.costOfRent(12,5,2));
		
		/**
		 * Two separate players own utilities, but the other is mortgaged
		 */
		Board.allProperties[12].isMortgaged = false;
		Board.allProperties[28].isMortgaged = true;
		Board.allProperties[12].ownedBy = testificate;
		Board.allProperties[28].ownedBy = heather;
		assertEquals(28,test.costOfRent(12,5,2));
		
	}
}
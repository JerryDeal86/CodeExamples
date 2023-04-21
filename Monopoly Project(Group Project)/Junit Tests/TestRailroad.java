import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TestRailroad{
	
	@Test
	void costOfRent() {
		int position = 35;
		Railroad test = new Railroad("Short Line");
		Board test2 = new Board();
		test2.createAllProperty();
		Player testificate = new Player("Testificate", 1);
		Player heather = new Player("Heather", 2);
		/**
		 * Testing one person owns the railroad for rent
		 */
		Board.allProperties[5].ownedBy = testificate;
		Board.allProperties[15].ownedBy = heather;
		Board.allProperties[25].ownedBy = heather;
		Board.allProperties[35].ownedBy = heather;
		assertEquals(25,test.costOfRent(5));
		/**
		 * Two railroads are owned for rent
		 */
		Board.allProperties[5].ownedBy = testificate;
		Board.allProperties[15].ownedBy = testificate;
		Board.allProperties[25].ownedBy = heather;
		Board.allProperties[35].ownedBy = heather;
		assertEquals(50,test.costOfRent(5));
		/**
		 * Three railroads are owned for rent
		 */
		Board.allProperties[5].ownedBy = testificate;
		Board.allProperties[15].ownedBy = testificate;
		Board.allProperties[25].ownedBy = testificate;
		Board.allProperties[35].ownedBy = heather;
		assertEquals(100,test.costOfRent(5));
		/**
		 * All four are owned by the same person
		 */
		Board.allProperties[5].ownedBy = testificate;
		Board.allProperties[15].ownedBy = testificate;
		Board.allProperties[25].ownedBy = testificate;
		Board.allProperties[35].ownedBy = testificate;
		assertEquals(200,test.costOfRent(5));
		/**
		 * Railroad is mortgaged
		 */
		Board.allProperties[5].ownedBy = testificate;
		Board.allProperties[5].isMortgaged = true;
		Board.allProperties[15].ownedBy = testificate;
		Board.allProperties[25].ownedBy = testificate;
		Board.allProperties[35].ownedBy = testificate;
		assertEquals(0,test.costOfRent(5));
		/**
		 * One other railroad is mortgaged
		 */
		Board.allProperties[5].ownedBy = testificate;
		Board.allProperties[5].isMortgaged = false;
		Board.allProperties[15].ownedBy = testificate;
		Board.allProperties[15].isMortgaged = true;
		Board.allProperties[25].ownedBy = testificate;
		Board.allProperties[35].ownedBy = testificate;
		assertEquals(100,test.costOfRent(5));
		/**
		 * Three of four railroads are mortgaged
		 */
		Board.allProperties[5].ownedBy = testificate;
		Board.allProperties[5].isMortgaged = false;
		Board.allProperties[15].ownedBy = testificate;
		Board.allProperties[15].isMortgaged = true;
		Board.allProperties[25].ownedBy = testificate;
		Board.allProperties[25].isMortgaged = true;
		Board.allProperties[35].ownedBy = testificate;
		Board.allProperties[35].isMortgaged = true;
		assertEquals(25,test.costOfRent(5));
	}
}
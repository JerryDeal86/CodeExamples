import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TestNormalProperty{

	@Test
	void costOfRent() {
		NormalProperty test = new NormalProperty("Boardwalk", "Blue", 400, 200, new int[] {50, 200, 600, 1400, 1700, 2000});
		Board test2 = new Board();
		test2.createAllProperty();
		Player testificate = new Player("Testificate", 1);
		Player heather = new Player("Heather", 2);
		
		Board.allProperties[39].isMortgaged = false;
		Board.allProperties[39].ownedBy = testificate;
		
		/**
		 * Rent with 0 houses
		 */
		test.numberOfHouses = 0;
		assertEquals(50,test.costOfRent(39));
		/**
		 * Rent with 3 houses
		 */
		test.numberOfHouses = 3;
		assertEquals(1400,test.costOfRent(39));
	}
}
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TestPlayerTurn{
	
	@Test
	void testDiceRoll() {
		Player player = new Player("Test Player", 1);
		PlayerTurn turn = new PlayerTurn(player);
		int playerDiceRoll = turn.diceRoll();
		
		assertEquals(true, playerDiceRoll >= 1 && playerDiceRoll <= 6);
	}
	
	@Test
	void testGoToJail() {
		Player player = new Player("Test Player", 2);
		PlayerTurn turn = new PlayerTurn(player);
		int truth = 10;
		turn.goToJail();
		
		assertEquals(truth, turn.player.position);	
		assertEquals(true, turn.player.isInJail);		
	}
	
	@Test
	void testLeaveJail() {
		Player player = new Player("Test Player", 3);
		PlayerTurn turn = new PlayerTurn(player);
		int truth = 10;
		turn.leaveJail();
		
		assertEquals(truth, turn.player.position);	
		assertEquals(false, turn.player.isInJail);		
	}
	
	@Test
	void testPayRent() {
		Player player1 = new Player("Test Player", 1);
		PlayerTurn turn = new PlayerTurn(player1);
		
		Player player2 = new Player("Test Player", 2);
		
		turn.player.cash = 1500;
		player2.cash = 2000;
		
		
		Property p2Property = new NormalProperty("Oriental Ave", "Cyan", 100, 50, new int[] {50, 70, 90, 270, 400, 550});
		Board.allProperties[6] = p2Property;
		Property secondProperty = new NormalProperty("VT Ave", "Cyan", 100, 50, new int[] {6, 30, 90, 270, 400, 550});
		Board.allProperties[8] = secondProperty;
		
		turn.player.position = 6;
		Board.allProperties[6].ownedBy = player2;
		
		turn.payRent(6);
		
		assertEquals(1450, turn.player.cash);
		assertEquals(2050, player2.cash);
	}

	
	@Test
	void testPassGo() {
		Player player = new Player("Test Player", 1);
		PlayerTurn turn = new PlayerTurn(player);
		
		player.cash = 1500;
		turn.passGo(player.cash);
		
		assertEquals(player.cash, 1700);
	}
}
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
//import java.applet.*;

public class Game {
	static final Property[] allProperties = new Property[40];

	public static void main(String[] args) throws InterruptedException {		
		boolean gameHasStarted = false;
		
		JFrame f = new JFrame();
		JPanel mainPanel = new JPanel();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		f.setBounds(0, 0, 1200, 725);
		f.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		mainPanel.setLayout(null);
		Board board = new Board();
		mainPanel = board;
		f.getContentPane().add(mainPanel);
		f.setVisible(true);
		
		board.playerInfoDisplay();
		
		board.createAllProperty();
		
		while(!gameHasStarted) {
			gameHasStarted = board.startGame();
			Thread.sleep(100);
		}
		
		board.optionsDisplay();
		
		boolean turnHasEnded = false;
		
		while(board.turnsLeft > 0) {
			for(int currentPlayer = 0; currentPlayer < board.numberOfPlayers; currentPlayer++) {
				while(!turnHasEnded) {
					turnHasEnded = board.turnEnded();
					Thread.sleep(100);
				}
				turnHasEnded = false;
			}
		}
		
		board.endGame();
	}
}
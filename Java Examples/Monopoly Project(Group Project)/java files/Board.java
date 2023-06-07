import java.awt.*;
import java.awt.event.*; 
import javax.swing.*;
import java.util.ArrayList;
import java.applet.*;

class Board extends JPanel implements ActionListener {
	
	/*
	final String[] allPositions = new String[] {"GO", "Med. Ave", "Community Chest 1", "Baltic Ave", "Income Tax", "Reading RR", "Oriental Ave", 
			"Chance 1", "VT Ave", "CT Ave", "Jail Space", "St. Charles Place", "Electric Co.", "States Ave", "VA Ae", "PA RR", "St. James Place", 
			"Community Chest 2", "TN Ave", "NY Ave", "Free Parking", "KY Ave", "Chance 2", "IN Ave", "IL Ave", "B. & O. RR", "Atlantic Ave.", 
			"Ventor Ave.", "Water Works", "Marvin Garden", "Go to Jail", "Pacific Ave", "NC Ave", "Community Chest 3", "PA Ave", "Short Line", 
			"Chance 3", "Park Place", "Luxury Tax", "Boardwalk"};
	*/
	
	JLabel[] houseCounterArray = new JLabel[40];
	JLabel medAveHouse = new JLabel("0");
	JLabel balticAveHouse = new JLabel("0");
	JLabel orientalAveHouse = new JLabel("0");
	JLabel vtAveHouse = new JLabel("0");
	JLabel ctAveHouse = new JLabel("0");
	JLabel stCharlesPlaceHouse = new JLabel("0");
	JLabel statesAveHouse = new JLabel("0");
	JLabel vaAveHouse = new JLabel("0");
	JLabel stJamesPlaceHouse = new JLabel("0");
	JLabel tnAveHouse = new JLabel("0");
	JLabel nyAveHouse = new JLabel("0");
	JLabel kyAveHouse = new JLabel("0");
	JLabel inAveHouse = new JLabel("0");
	JLabel ilAveHouse = new JLabel("0");
	JLabel atlanticAveHouse = new JLabel("0");
	JLabel ventnorAveHouse = new JLabel("0");
	JLabel marvinGardenHouse = new JLabel("0");
	JLabel pacificAveHouse = new JLabel("0");
	JLabel ncAveHouse = new JLabel("0");
	JLabel paAveHouse = new JLabel("0");
	JLabel parkPlaceHouse = new JLabel("0");
	JLabel boardwalkHouse = new JLabel("0");
	
	int turnsLeft;
	JLabel l2 = new JLabel(turnsLeft + " Turns Left");
		
	public void paintComponent(Graphics g) {
		this.setLayout(null);
		super.paintComponent(g);
		JLabel monopolyLogo = new JLabel(" MONOPOLY ");
		monopolyLogo.setBounds(230, 265, 250, 150);
		Font logoFont = new Font(monopolyLogo.getName(), Font.BOLD, 30);
		monopolyLogo.setFont(logoFont);
		this.add(monopolyLogo);
		
		int x = 10;
		int y = 10;
	   
		for(int i = 0; i < 2; i++) {
			g.setColor(Color.WHITE);
			g.fillRect(x, y, 100, 100);
			g.setColor(Color.BLACK);
			g.drawRect(x, y, 100, 100);
			
			if(i == 0) {
				JLabel label = new JLabel("Free Parking");
				label.setBounds(x + 5, y, 100, 100);
				Font f = new Font(label.getName(), Font.BOLD, 14);
				label.setFont(f);
				this.add(label);
			}
			else {
				JLabel label = new JLabel("<html>Just<br/><br/><br/>Visiting</html>");
				label.setBounds(x + 5, y + 10, 100, 100);
				this.add(label);
				g.setColor(Color.ORANGE);
				g.fillRect(x + 40, y, 60, 60);
				g.setColor(Color.BLACK);
				g.drawRect(x + 40, y, 60, 60);
				JLabel extraLabel = new JLabel("<html><div style='text-align: center;'>In<br/>Jail</html>");
				extraLabel.setBounds(x + 60, y + 5, 50, 50);
				this.add(extraLabel);
			}
        	 
			x += 100;
			
			for(int j = 0; j < 9; j++) {
				g.setColor(Color.WHITE);
				g.fillRect(x, y, 50, 100); 
				g.setColor(Color.BLACK);
				g.drawRect(x, y, 50, 100);
				
				if(i == 0) {
					if(j == 1) { 
						JLabel label = new JLabel("Chance");
						label.setBounds(x + 5, y, 100, 100);
						this.add(label);
					}
					else if(j == 4) {
						JLabel label = new JLabel("<html><div style='text-align: center;'>B. & O.<br/>RR</html>");
           	 			label.setBounds(x + 5, y, 100, 100);
           	 			this.add(label);
	            	}
					else if(j == 7) {
						JLabel label = new JLabel("<html><div style='text-align: center;'>Water<br/>Works</html>");
						label.setBounds(x + 5, y, 100, 100);
						this.add(label);
					}
					else {
						if(j == 0 || j == 2 || j == 3) {
							g.setColor(Color.RED);
							g.fillRect(x, y + 80, 50, 20);
							g.setColor(Color.BLACK);
							g.drawRect(x, y + 80, 50, 20);
							g.setColor(Color.GREEN);
							g.fillOval(x + 30, y + 85, 10, 10);
							g.setColor(Color.BLACK);
							g.drawOval(x + 30, y + 85, 10, 10);
							
							if(j == 0) {
								JLabel label = new JLabel("<html><div style='text-align: center;'>KY<br/>Ave</html>");
								label.setBounds(x + 15, y, 100, 100);
								this.add(label);
								kyAveHouse.setBounds(x + 10, y + 85, 10, 10);
								kyAveHouse.setForeground(Color.BLACK);
								this.add(kyAveHouse);
	            			}
							
							else if(j == 2) {
								JLabel label = new JLabel("<html><div style='text-align: center;'>IN<br/>Ave</html>");
								label.setBounds(x + 15, y, 100, 100);
								this.add(label);
								inAveHouse.setBounds(x + 10, y + 85, 10, 10);
								inAveHouse.setForeground(Color.BLACK);
								this.add(inAveHouse);
							}
							
							else {
								JLabel label = new JLabel("<html><div style='text-align: center;'>IL<br/>Ave</html>");
								label.setBounds(x + 15, y, 100, 100);
								this.add(label);
								ilAveHouse.setBounds(x + 10, y + 85, 10, 10);
								ilAveHouse.setForeground(Color.BLACK);
								this.add(ilAveHouse);
							}
						}
						else {
							g.setColor(Color.YELLOW);
							g.fillRect(x, y + 80, 50, 20);
							g.setColor(Color.BLACK);
							g.drawRect(x, y + 80, 50, 20);
							g.setColor(Color.GREEN);
							g.fillOval(x + 30, y + 85, 10, 10);
							g.setColor(Color.BLACK);
							g.drawOval(x + 30, y + 85, 10, 10);
							
							if(j == 5) {
								JLabel label = new JLabel("<html><div style='text-align: center;'>Atlantic<br/>Ave</html>");
								label.setBounds(x + 5, y, 100, 100);
								this.add(label);
								atlanticAveHouse.setBounds(x + 10, y + 85, 10, 10);
								atlanticAveHouse.setForeground(Color.BLACK);
								this.add(atlanticAveHouse);
							}
							
							else if(j == 6) {
								JLabel label = new JLabel("<html><div style='text-align: center;'>Ventnor<br/>Ave</html>");
								label.setBounds(x + 3, y, 100, 100);
								this.add(label);
								ventnorAveHouse.setBounds(x + 10, y + 85, 10, 10);
								ventnorAveHouse.setForeground(Color.BLACK);
								this.add(ventnorAveHouse);
							}
	            			
							else {
								JLabel label = new JLabel("<html><div style='text-align: center;'>Marvin<br/>Garden</html>");
								label.setBounds(x + 5, y, 100, 100);
								this.add(label);
								marvinGardenHouse.setBounds(x + 10, y + 85, 10, 10);
								marvinGardenHouse.setForeground(Color.BLACK);
								this.add(marvinGardenHouse);
							}
						}
					}
				}
				
				if(i == 1) {
					if(j == 2) {
						JLabel label = new JLabel("Chance");
						label.setBounds(x + 3, y, 100, 100);
						this.add(label);
					}
					else if(j == 4) {
						JLabel label = new JLabel("<html><div style='text-align: center;'>Reading<br/>RR</html>");
						label.setBounds(x + 3, y, 100, 100);
						this.add(label);
					}
					else if(j == 5) {
						JLabel label = new JLabel("<html><div style='text-align: center;'>Income<br/>Tax</html>");
						label.setBounds(x + 5, y, 100, 100);
						this.add(label);
					}
					else if(j == 7) {
						JLabel label = new JLabel("<html><div style='text-align: center;'>Community<br/><br/>Chest</html>");
						label.setBounds(x + 1, y, 100, 100);
						Font f = new Font(label.getName(), Font.BOLD, 8);
						label.setFont(f);
						this.add(label);
					}
					else {
						g.setColor(Color.GREEN);
						g.fillOval(x + 30, y, 10, 10);
						g.setColor(Color.BLACK);
						g.drawOval(x + 30, y, 10, 10);
						
						if(j == 6 || j == 8) {
							Color purple = new Color(160, 0, 160);
							g.setColor(purple);
							g.fillRect(x, y, 50, 20);
							g.setColor(Color.BLACK);
							g.drawRect(x, y, 50, 20);
							g.setColor(Color.GREEN);
							g.fillOval(x + 30, y + 5, 10, 10);
							g.setColor(Color.BLACK);
							g.drawOval(x + 30, y + 5, 10, 10);
							
							if(j == 6) {
								JLabel label = new JLabel("<html><div style='text-align: center;'>Baltic<br/>Ave</html>");
								label.setBounds(x + 10, y, 100, 100);
								this.add(label);
								balticAveHouse.setBounds(x + 10, y + 5, 10, 10);
								balticAveHouse.setForeground(Color.BLACK);
								this.add(medAveHouse);
							}
							
							else {
								JLabel label = new JLabel("<html><div style='text-align: center;'>Med.<br/>Ave</html>");
								label.setBounds(x + 10, y, 100, 100);
								this.add(label);
								medAveHouse.setBounds(x + 10, y + 5, 10, 10);
								medAveHouse.setForeground(Color.BLACK);
								this.add(balticAveHouse);
							}
						}
						else {
							g.setColor(Color.CYAN);
							g.fillRect(x, y, 50, 20);
							g.setColor(Color.BLACK);
							g.drawRect(x, y, 50, 20);
							g.setColor(Color.GREEN);
							g.fillOval(x + 30, y + 5, 10, 10);
							g.setColor(Color.BLACK);
							g.drawOval(x + 30, y + 5, 10, 10);
							
							if(j == 0) {
								JLabel label = new JLabel("<html><div style='text-align: center;'>CT<br/>Ave</html>");
								label.setBounds(x + 15, y, 100, 100);
								this.add(label);
								ctAveHouse.setBounds(x + 10, y + 5, 10, 10);
								this.add(ctAveHouse);
							}
							
							else if(j == 1) {
								JLabel label = new JLabel("<html><div style='text-align: center;'>VT<br/>Ave</html>");
								label.setBounds(x + 15, y, 100, 100);
								this.add(label);
								vtAveHouse.setBounds(x + 10, y + 5, 10, 10);
								this.add(vtAveHouse);
							}
							
							else {
								JLabel label = new JLabel("<html><div style='text-align: center;'>Oriental<br/>Ave</html>");
								label.setBounds(x + 2, y, 100, 100);
								this.add(label);
								orientalAveHouse.setBounds(x + 10, y + 5, 10, 10);
								orientalAveHouse.setForeground(Color.BLACK);
								this.add(orientalAveHouse);
							}
						}
					}
				}
				x += 50;
			}
			
			g.setColor(Color.WHITE);
			g.fillRect(x, y, 100, 100);
			g.setColor(Color.BLACK);
			g.drawRect(x, y, 100, 100);
			
			if(i == 0) {
				JLabel label = new JLabel("Go to Jail");
				label.setBounds(x + 15, y, 100, 100);
				Font f = new Font(label.getName(), Font.BOLD, 15);
				label.setFont(f);
				this.add(label);
			}
			else {
				JLabel label = new JLabel("<html><div style='text-align: center;'>GO<br/><br/><br/>Collect $200</html>");
				label.setBounds(x + 7, y, 100, 100);
				Font f = new Font(label.getName(), Font.BOLD, 15);
				label.setFont(f);
				this.add(label);
			}
			
			x -= 550;
			y += 550;
		}
		
		y -= 1000;
		
		for(int i = 0; i < 2; i++) {
			for(int j = 0; j < 9; j++) {
				g.setColor(Color.WHITE);
				g.fillRect(x, y, 100, 50);
				g.setColor(Color.BLACK);
				g.drawRect(x, y, 100, 50);
				
				if(i == 0) {
					if(j == 2) {
						JLabel label = new JLabel("<html><div style='text-align: center;'>Community<br/><br/>Chest</html>");
						label.setBounds(x + 25, y - 25, 100, 100);
						Font f = new Font(label.getName(), Font.BOLD, 8);
						label.setFont(f);
						this.add(label);
					}
					else if(j == 4) {
						JLabel label = new JLabel("PA RR");
						label.setBounds(x + 30, y - 25, 100, 100);
						this.add(label);
					}
					else if(j == 7) {
						JLabel label = new JLabel("Electric Co.");
						label.setBounds(x + 15, y - 25, 100, 100);
						this.add(label);
					}
					else {
						if(j == 0 || j == 1 || j == 3) {
							g.setColor(Color.ORANGE);
							g.fillRect(x + 80, y, 20, 50);
							g.setColor(Color.BLACK);
							g.drawRect(x + 80, y, 20, 50);
							g.setColor(Color.GREEN);
							g.fillOval(x + 85, y + 30, 10, 10);
							g.setColor(Color.BLACK);
							g.drawOval(x + 85, y + 30, 10, 10);
							
							
							if(j == 0) {
								JLabel label = new JLabel("<html><div style='text-align: center;'>NY<br/>Ave</html>");
								label.setBounds(x + 30, y - 25, 100, 100);
								this.add(label);
								nyAveHouse.setBounds(x + 85, y + 10, 10, 10);
								nyAveHouse.setForeground(Color.BLACK);
								this.add(nyAveHouse);
							}
							
							else if(j == 1) {
								JLabel label = new JLabel("<html><div style='text-align: center;'>TN<br/>Ave</html>");
								label.setBounds(x + 30, y - 25, 100, 100);
								this.add(label);
								tnAveHouse.setBounds(x + 85, y + 10, 10, 10);
								tnAveHouse.setForeground(Color.BLACK);
								this.add(tnAveHouse);
							}
							
							else {
								JLabel label = new JLabel("<html><div style='text-align: center;'>St. James<br/>Place</html>");
								label.setBounds(x + 12, y - 25, 100, 100);
								this.add(label);
								stJamesPlaceHouse.setBounds(x + 85, y + 10, 10, 10);
								stJamesPlaceHouse.setForeground(Color.BLACK);
								this.add(stJamesPlaceHouse);
							}
						}
						else {
							g.setColor(Color.PINK);
							g.fillRect(x + 80, y, 20, 50);
							g.setColor(Color.BLACK);
							g.drawRect(x + 80, y, 20, 50);
							g.setColor(Color.GREEN);
							g.fillOval(x + 85, y + 30, 10, 10);
							g.setColor(Color.BLACK);
							g.drawOval(x + 85, y + 30, 10, 10);
							
							if(j == 5) {
								JLabel label = new JLabel("<html><div style='text-align: center;'>VA<br/>Ave</html>");
								label.setBounds(x + 30, y - 25, 100, 100);
								this.add(label);
								vaAveHouse.setBounds(x + 85, y + 10, 10, 10);
								vaAveHouse.setForeground(Color.BLACK);
								this.add(vaAveHouse);
							}
							
							else if(j == 6) {
								JLabel label = new JLabel("<html><div style='text-align: center;'>States<br/>Ave</html>");
								label.setBounds(x + 20, y - 25, 100, 100);
								this.add(label);
								statesAveHouse.setBounds(x + 85, y + 10, 10, 10);
								statesAveHouse.setForeground(Color.BLACK);
								this.add(statesAveHouse);
							}
							
							else {
								JLabel label = new JLabel("<html><div style='text-align: center;'>St. Charles<br/>Place</html>");
								label.setBounds(x + 12, y - 25, 100, 100);
								this.add(label);
								stCharlesPlaceHouse.setBounds(x + 85, y + 10, 10, 10);
								stCharlesPlaceHouse.setForeground(Color.BLACK);
								this.add(stCharlesPlaceHouse);
							}
						}
					}
				}
				
				if(i == 1) {
					if(j == 2) {
						JLabel label = new JLabel("<html><div style='text-align: center;'>Community<br/><br/>Chest</html>");
						label.setBounds(x + 30, y - 25, 100, 100);
						Font f = new Font(label.getName(), Font.BOLD, 8);
						label.setFont(f);
						this.add(label);
					}
					else if(j == 4) {
						JLabel label = new JLabel("Short Line");
						label.setBounds(x + 20, y - 25, 100, 100);
						this.add(label);
					}
					else if(j == 5) {
						JLabel label = new JLabel("Chance");
						label.setBounds(x + 30, y - 25, 100, 100);
						this.add(label);
					}
					else if(j == 7) {
						JLabel label = new JLabel("Luxury Tax");
						label.setBounds(x + 18, y - 25, 100, 100);
						this.add(label);
					}
					else if(j == 6 || j == 8) {
						Color newBlue = new Color(0, 0, 255);
						g.setColor(newBlue);
						g.fillRect(x, y, 20, 50);
						g.setColor(Color.BLACK);
						g.drawRect(x, y, 20, 50);
						g.setColor(Color.GREEN);
						g.fillOval(x + 5, y + 30, 10, 10);
						g.setColor(Color.BLACK);
						g.drawOval(x + 5, y + 30, 10, 10);
						
						if(j == 6) {
							JLabel label = new JLabel("<html><div style='text-align: center;'>Park<br/>Place</html>");
							label.setBounds(x + 40, y - 25, 100, 100);
							this.add(label);
							parkPlaceHouse.setBounds(x + 5, y + 10, 10, 10);
							parkPlaceHouse.setForeground(Color.BLACK);
							this.add(parkPlaceHouse);
						}
						
						else {
							JLabel label = new JLabel("Boardwalk");
							label.setBounds(x + 30, y - 25, 100, 100);
							this.add(label);
							boardwalkHouse.setBounds(x + 5, y + 10, 10, 10);
							boardwalkHouse.setForeground(Color.BLACK);
							this.add(boardwalkHouse);
						}
					}
					else {
						Color darkGreen = new Color(0, 150, 0);
						g.setColor(darkGreen);
						g.fillRect(x, y, 20, 50);
						g.setColor(Color.BLACK);
						g.drawRect(x, y, 20, 50);
						g.setColor(Color.GREEN);
						g.fillOval(x + 5, y + 30, 10, 10);
						g.setColor(Color.BLACK);
						g.drawOval(x + 5, y + 30, 10, 10);
						
						if(j == 0) {
							JLabel label = new JLabel("<html><div style='text-align: center;'>Pacific<br/>Ave</html>");
							label.setBounds(x + 35, y - 25, 100, 100);
							this.add(label);
							pacificAveHouse.setBounds(x + 5, y + 10, 10, 10);
							pacificAveHouse.setForeground(Color.BLACK);
							this.add(pacificAveHouse);
						}
						
						else if(j == 1) {
							JLabel label = new JLabel("<html><div style='text-align: center;'>NC<br/>Ave</html>");
							label.setBounds(x + 45, y - 25, 100, 100);
							this.add(label);
							ncAveHouse.setBounds(x + 5, y + 10, 10, 10);
							ncAveHouse.setForeground(Color.BLACK);
							this.add(ncAveHouse);
						}
						
						else {
							JLabel label = new JLabel("<html><div style='text-align: center;'>PA<br/>Ave</html>");
							label.setBounds(x + 45, y - 25, 100, 100);
							this.add(label);
							paAveHouse.setBounds(x + 5, y + 10, 10, 10);
							paAveHouse.setForeground(Color.BLACK);
							this.add(paAveHouse);
						}
					}
				}
				y += 50;
			}
			x += 550;
			y -= 450;
		}
	}
    	
	static Property[] allProperties = new Property[40];
    int initialButtonCounter = 0;
    int numberOfPlayers = 0;
    ArrayList<Player> playerList = new ArrayList<>();
    
	JLabel player1Icon = new JLabel("P1");
	JLabel player2Icon = new JLabel("P2");
	JLabel player3Icon = new JLabel("P3");
	JLabel player4Icon = new JLabel("P4");
	JLabel[] playerIcons = new JLabel[]{player1Icon, player2Icon, player3Icon, player4Icon};
    
	JTextField t = new JTextField();
    JLabel l = new JLabel("<html>Enter the number of players (2-4).</html>");
    JButton b = new JButton("Enter");
    JLabel info = new JLabel();
    
    static boolean gameHasStarted;
    
    public void playerInfoDisplay() {
    	this.setLayout(null);
    	
		player1Icon.setBounds(590, 590, 20, 20);
		player1Icon.setBackground(Color.RED);
		player1Icon.setOpaque(true);
		player1Icon.setVisible(false);
		this.add(player1Icon);
		player2Icon.setBounds(610, 590, 20, 20);
		player2Icon.setBackground(Color.BLUE);
		player2Icon.setOpaque(true);
		player2Icon.setVisible(false);
		this.add(player2Icon);
		player3Icon.setBounds(590, 610, 20, 20);
		player3Icon.setBackground(Color.GREEN);
		player3Icon.setOpaque(true);
		player3Icon.setVisible(false);
		this.add(player3Icon);
		player4Icon.setBounds(610, 610, 20, 20);
		player4Icon.setBackground(Color.YELLOW);
		player4Icon.setOpaque(true);
		player4Icon.setVisible(false);
		this.add(player4Icon);
		
		l.setVerticalAlignment(JLabel.TOP);
		
        t.setBounds(920, 300, 150, 20);
        l.setBounds(920, 270, 400, 40);
        b.setBounds(920, 340, 100, 20);
		info.setBounds(720, 0, 200, 200);
		
        this.add(t);
        this.add(l);
        this.add(b);
		this.add(info);
		
        b.addActionListener(new ActionListener() {
        	@Override
	        public void actionPerformed(ActionEvent e) {
	            String s = e.getActionCommand();
	            if(s.equals("Enter")) {
	            	initialButtonCounter++;
	            	if(initialButtonCounter == 1 && (t.getText().equals("2") || t.getText().equals("3") || t.getText().equals("4"))) {
	            		numberOfPlayers = Integer.parseInt(t.getText());
	                    l.setText("<html>Enter a name for Player 1.</html>"); 
	            	}
	            	else if(initialButtonCounter == 1 || t.getText().trim().length() == 0)
	            		initialButtonCounter--;
	            	else if(initialButtonCounter == 2 && t.getText().trim().length() != 0) {
	                    Player player1 = new Player(t.getText(), 1);
	                    playerList.add(player1);
	            		player1Icon.setVisible(true);
	                    l.setText("<html>Enter a name for Player 2.</html>");
	            	}
	                    
	            	else if(initialButtonCounter == 3 && numberOfPlayers >= 3 && t.getText().trim().length() != 0) {
	                    Player player2 = new Player(t.getText(), 2);
	                    playerList.add(player2);
	            		player2Icon.setVisible(true);
	            		l.setText("<html>Enter a name for Player 3.</html>");
	            	}
	            	else if(initialButtonCounter == 4 && numberOfPlayers == 4 && t.getText().trim().length() != 0) {
	                    Player player3 = new Player(t.getText(), 3);
	                    playerList.add(player3);
	            		player3Icon.setVisible(true);
	                    l.setText("<html>Enter a name for Player 4.</html>");
	            	}
	            	else if(initialButtonCounter == numberOfPlayers + 1) {
	            		if(numberOfPlayers == 2) {
	                        Player player2 = new Player(t.getText(), 2);
	                        playerList.add(player2);
	                		player2Icon.setVisible(true);
	            		}
	            		else if(numberOfPlayers == 3) {
	                        Player player3 = new Player(t.getText(), 3);
	                        playerList.add(player3);
	                		player3Icon.setVisible(true);
	            		}
	            		else {
	                        Player player4 = new Player(t.getText(), 4);
	                        playerList.add(player4);
	                		player4Icon.setVisible(true);
	            		}
	                    l.setText("<html>Enter the number of turns for this game (10 turn min).</html>");
	            	}
	            	
	                else if(initialButtonCounter > numberOfPlayers + 1) {
	                	try {
	                		turnsLeft = Integer.parseInt(t.getText());	                		
	                	}
	                	
	                	catch (NumberFormatException n) {
		                	t.setText(""); 
	                	}
	                	
	                	if(turnsLeft < 10)
	                		initialButtonCounter--;
	                	else {
               	 			l2.setText(turnsLeft + " Turns Left");
	                		gameHasStarted = true;
	                		info.setText("<html>Player 1<br>Name: " + playerList.get(0).name + "<br>Cash: $"
	            			+ playerList.get(0).cash + "</html>");
	            			Font f = new Font(info.getName(), Font.BOLD, 20);
	               	 		info.setFont(f);
	               	 		b.setBounds(920, 420, 120, 30);
	               	 		b.setText("Buy Property");
	               	 		t.setVisible(false);
	               	 		l.setVisible(false);
	               	 		
	               	 		String propertyOwned = "";
	               	 		String propertyMortgaged = "";
	               	 		propertyOwnedLabel.setText("<html>Property Owned (Active): " + propertyOwned + "</html>");
	               	 		propertyMortgagedLabel.setText("<html>Property Mortgaged: " + propertyMortgaged + "</html>");
	               	 		
	                	}
	                }
	            }
	            else if(s.equals("Buy Property")) {
	               	Player chosenPlayer = playerList.get(currentPlayer - 1);
	               	chosenPlayer.buyProperty(chosenPlayer.position);
                	info.setText("<html>Player " + currentPlayer + "<br>Name: " + chosenPlayer.name + "<br>Cash: $"
                	+ chosenPlayer.cash + "</html>");
                	
                	String propertyOwned = "";
                	String propertyMortgaged = "";
                	
                	for(int i = 0; i < chosenPlayer.propertyOwned.size(); i++) {            			            			
                		if(chosenPlayer.propertyOwned.get(i).isMortgaged) {
                			if(propertyMortgaged.equals(""))
                				propertyMortgaged = chosenPlayer.propertyOwned.get(i).propertyName;
                			else
                				propertyMortgaged = propertyMortgaged + ", " + chosenPlayer.propertyOwned.get(i).propertyName;
                		}
                		else {
                			if(propertyOwned.equals(""))
                				propertyOwned = chosenPlayer.propertyOwned.get(i).propertyName;
                			else
                				propertyOwned = propertyOwned + ", " + chosenPlayer.propertyOwned.get(i).propertyName;
                		}
                	}
                	
                	propertyOwnedLabel.setText("<html>Property Owned (Active): " + propertyOwned + "</html>");
                	propertyMortgagedLabel.setText("<html>Property Mortgaged: " + propertyMortgaged + "</html>");
                	t1.setText("");
                }
            	
                else if(s.contentEquals("Final Results")) {
                	
                	for(int i = 0; i < playerList.size(); i++) {
                		for(int j = 0; j < playerList.get(i).propertyOwned.size(); j++) {
                			if(playerList.get(i).propertyOwned.get(j).propertyType.equals("Normal Property")) {
                            	NormalProperty np = (NormalProperty) playerList.get(i).propertyOwned.get(j);
                				playerList.get(i).cash += np.numberOfHouses * np.housePrice;
                			}
                			
                			if(playerList.get(i).propertyOwned.get(j).isMortgaged)
                				playerList.get(i).cash += playerList.get(i).propertyOwned.get(j).bankPrice * 0.55;
                			else
                				playerList.get(i).cash += playerList.get(i).propertyOwned.get(j).bankPrice;
                		}
                	}
                	
                	String resultsString = "";
	               	numberOfPlayers = playerList.size();
	               	int position;
	               	int previousMax = -999999;
	               	int numberOfTies = 0;
	              	
                	while(playerList.size() > 0) {
                		int maxCash = -999999;
                		int maxElement = -1;
                		
                		for(int i = 0; i < playerList.size(); i++) {
                			if(playerList.get(i).cash > maxCash) {
                				maxCash = playerList.get(i).cash;
                				maxElement = i;
                			}
                		}
                		
                		if(previousMax == maxCash)
                			numberOfTies++;
                		else
	               			numberOfTies = 0;
	                		
                		position = numberOfPlayers - playerList.size() - numberOfTies + 1;
                		previousMax = maxCash;
                		
                		resultsString = resultsString +  position + ". Player " + playerList.get(maxElement).number + ", " +
                		playerList.get(maxElement).name + ", $" + playerList.get(maxElement).cash + "<br><br>";

                		playerList.remove(maxElement);
                	}
                	
                	b.setVisible(false);
                	info.setVisible(false);
                    l.setBounds(900, 250, 400, 400);
                	l.setFont(font1);
                	l.setText("<html>" + resultsString + "</html>");
                }
               	t.setText("");
            }
        });
        
        this.revalidate();
        this.repaint();
    }
    
    String propertyName;
    String propertyColor;
    int propertyCost;
    int houseCost;
    int[] ownedPrices = new int[6];
    
        
    public void createAllProperty() {
    	allProperties[1] = new NormalProperty("Med. Ave", "Purple", 60, 50, new int[] {2, 10, 30, 90, 160, 250});
    	allProperties[3] = new NormalProperty("Baltic Ave", "Purple", 60, 50, new int[] {4, 20, 60, 180, 320, 450});
    	allProperties[6] = new NormalProperty("Oriental Ave", "Cyan", 100, 50, new int[] {6, 30, 90, 270, 400, 550});
    	allProperties[8] = new NormalProperty("VT Ave", "Cyan", 100, 50, new int[] {6, 30, 90, 270, 400, 550});
    	allProperties[9] = new NormalProperty("CT Ave", "Cyan", 120, 50, new int[] {8, 40, 100, 300, 450, 600});
    	allProperties[11] = new NormalProperty("St. Charles Place", "Pink", 140, 100, new int[] {10, 50, 150, 450, 625, 750});
    	allProperties[13] = new NormalProperty("States Ave", "Pink", 140, 100, new int[] {10, 50, 150, 450, 625, 750});
    	allProperties[14] = new NormalProperty("VA Ave", "Pink", 160, 100, new int[] {12, 60, 180, 500, 700, 900});
    	allProperties[16] = new NormalProperty("St. James Place", "Orange", 180, 100, new int[] {14, 70, 200, 550, 750, 950});
    	allProperties[18] = new NormalProperty("TN Ave", "Orange", 180, 100, new int[] {14, 70, 200, 550, 750, 950});
    	allProperties[19] = new NormalProperty("NY Ave", "Orange", 200, 100, new int[] {16, 80, 220, 600, 800, 1000});
    	allProperties[21] = new NormalProperty("KY Ave", "Red", 220, 150, new int[] {18, 90, 250, 700, 875, 1050});
    	allProperties[23] = new NormalProperty("IN Ave", "Red", 220, 150, new int[] {18, 90, 250, 700, 875, 1050});
    	allProperties[24] = new NormalProperty("IL Ave", "Red", 240, 150, new int[] {20, 100, 300, 750, 925, 1100});
    	allProperties[26] = new NormalProperty("Atlantic Ave", "Yellow", 260, 150, new int[] {22, 110, 330, 800, 975, 1150});
    	allProperties[27] = new NormalProperty("Ventnor Ave", "Yellow", 260, 150, new int[] {22, 110, 330, 800, 975, 1150});
    	allProperties[29] = new NormalProperty("Marvin Gardens", "Yellow", 280, 150, new int[] {24, 120, 360, 850, 1025, 1200});
    	allProperties[31] = new NormalProperty("Pacific Ave", "Green", 300, 200, new int[] {26, 130, 390, 900, 1100, 1275});
    	allProperties[32] = new NormalProperty("NC Ave", "Green", 300, 200, new int[] {26, 130, 390, 900, 1100, 1275});
    	allProperties[34] = new NormalProperty("PA Ave", "Green", 320, 200, new int[] {28, 150, 450, 1000, 1200, 1400});
    	allProperties[37] = new NormalProperty("Park Place", "Blue", 350, 200, new int[] {35, 175, 500, 1100, 1300, 1500});
    	allProperties[39] = new NormalProperty("Boardwalk", "Blue", 400, 200, new int[] {50, 200, 600, 1400, 1700, 2000});
    	
    	houseCounterArray[1] = medAveHouse;
    	houseCounterArray[3] = balticAveHouse;
    	houseCounterArray[6] = orientalAveHouse;
    	houseCounterArray[8] = vtAveHouse;
    	houseCounterArray[9] = ctAveHouse;
    	houseCounterArray[11] = stCharlesPlaceHouse;
    	houseCounterArray[13] = statesAveHouse;
    	houseCounterArray[14] = vaAveHouse;
    	houseCounterArray[16] = stJamesPlaceHouse;
    	houseCounterArray[18] = tnAveHouse;
    	houseCounterArray[19] = nyAveHouse;
    	houseCounterArray[21] = kyAveHouse;
    	houseCounterArray[23] = inAveHouse;
    	houseCounterArray[24] = ilAveHouse;
    	houseCounterArray[26] = atlanticAveHouse;
    	houseCounterArray[27] = ventnorAveHouse;
    	houseCounterArray[29] = marvinGardenHouse;
    	houseCounterArray[31] = pacificAveHouse;
    	houseCounterArray[32] = ncAveHouse;
    	houseCounterArray[34] = paAveHouse;
    	houseCounterArray[37] = parkPlaceHouse;
    	houseCounterArray[39] = boardwalkHouse;
    	
    	allProperties[5] = new Railroad("Reading RR");
    	allProperties[15] = new Railroad("PA RR");
    	allProperties[25] = new Railroad("B. & O. RR");
    	allProperties[35] = new Railroad("Short Line");
    	
    	allProperties[12] = new Utility("Electric Co.");
    	allProperties[28] = new Utility("Water Works");
    }
    
    public boolean startGame() {
    	return gameHasStarted;
    }
    
	JTextField t1 = new JTextField(SwingConstants.CENTER);
	JLabel dices1And2 = new JLabel();
	JLabel diceSum = new JLabel();
	
    JLabel l1 = new JLabel("Enter property name exactly as written on the board.", SwingConstants.CENTER);
    Font font1 = new Font(t1.getName(), Font.BOLD, 16);
	Font font2 = new Font(l1.getName(), Font.BOLD, 12);
	Font font3 = new Font(t1.getName(), Font.BOLD, 30);
	Font font4 = new Font(t1.getName(), Font.BOLD, 40);
	Font font5 = new Font(l2.getName(), Font.BOLD, 20);
	Font font6 = new Font(l2.getName(), Font.BOLD, 28);
	Font font7 = new Font(l2.getName(), Font.BOLD, 14);
    JButton b1 = new JButton("Roll Dice");
    JButton b2 = new JButton("Mortgage");
    JButton b3 = new JButton("Buy House");
    JButton b4 = new JButton("Sell House");
    JButton b5 = new JButton("Unmortgage");
    
    int currentPlayer = 1;
    int doublesRolled = 0;
    
    JLabel propertyOwnedLabel = new JLabel();
    JLabel propertyMortgagedLabel = new JLabel();
    
    public void optionsDisplay() {
    	this.setLayout(null);
    	
        t1.setFont(font1);
    	l1.setFont(font2);
    	l2.setFont(font5);
    	dices1And2.setFont(font3);
    	diceSum.setFont(font4);
    	
    	
    	t1.setBounds(875, 525, 220, 30);
    	l1.setBounds(770, 485, 420, 30);
    	l2.setBounds(1100, 20, 1000, 40);
        b1.setBounds(920, 200, 120, 30);
        b2.setBounds(850, 575, 120, 30);
        b3.setBounds(1000, 575, 120, 30);
        b4.setBounds(1000, 625, 120, 30);
        b5.setBounds(850, 625, 120, 30);
        
        dices1And2.setBounds(960, 50, 120, 30);
        diceSum.setBounds(970, 100, 120, 30);
        
        propertyOwnedLabel.setVerticalAlignment(JLabel.TOP);
        propertyMortgagedLabel.setVerticalAlignment(JLabel.TOP);

        propertyOwnedLabel.setBounds(770, 240, 450, 90);
        propertyMortgagedLabel.setBounds(770, 330, 450, 90);
        
        this.add(dices1And2);
        this.add(diceSum);
        
        this.add(t1);
        this.add(l1);
        this.add(l2);
        this.add(b1);
        this.add(b2);
        this.add(b3);
        this.add(b4);
        this.add(b5);
        
        this.add(propertyOwnedLabel);
        this.add(propertyMortgagedLabel);
        
        b1.addActionListener(new ActionListener() {
        	@Override
	        public void actionPerformed(ActionEvent e) {
        		Player chosenPlayer = playerList.get(currentPlayer - 1);
	            String s = e.getActionCommand();
        		String propertyOwned = "";
        		String propertyMortgaged = "";

	            if(s.equals("Roll Dice")) {
	            	chosenPlayer.playTurn();
	            	dices1And2.setText(chosenPlayer.diceRoll1 + ", " + chosenPlayer.diceRoll2);
	            	diceSum.setText(Integer.toString(chosenPlayer.diceRoll1 + chosenPlayer.diceRoll2));
	            	movePlayerPiece(chosenPlayer, currentPlayer);
	            	
            		for(int i = 0; i < chosenPlayer.propertyOwned.size(); i++) {            			            			
            			if(chosenPlayer.propertyOwned.get(i).isMortgaged) {
            				if(propertyMortgaged.equals(""))
            					propertyMortgaged = chosenPlayer.propertyOwned.get(i).propertyName;
            				else
            					propertyMortgaged = propertyMortgaged + ", " + chosenPlayer.propertyOwned.get(i).propertyName;
            			}
            			else {
                			if(propertyOwned.equals(""))
                				propertyOwned = chosenPlayer.propertyOwned.get(i).propertyName;
                			else
                				propertyOwned = propertyOwned + ", " + chosenPlayer.propertyOwned.get(i).propertyName;
            			}
            		}

            		
            		info.setText("<html>Player " + currentPlayer + "<br>Name: " + chosenPlayer.name + "<br>Cash: $"
            		+ chosenPlayer.cash + "</html>");
            		
            		propertyOwnedLabel.setText("<html>Property Owned (Active): " + propertyOwned + "</html>");
            		propertyMortgagedLabel.setText("<html>Property Mortgaged: " + propertyMortgaged + "</html>");
	            	t1.setText("");
	            	
	            	if(chosenPlayer.cash < 0) {
	            		int z;
	            		for(z = 0; z < chosenPlayer.propertyOwned.size(); z++)
	            			if(!chosenPlayer.propertyOwned.get(z).isMortgaged)
	            				break;
	            		if(z < chosenPlayer.propertyOwned.size()) {
	            			b1.setVisible(false);
	            	        l.setBounds(800, 200, 400, 40);
	            			l.setText("Mortgage property and/or sell houses until cash is nonnegative or everything is mortgaged.");
	            			l.setVisible(true);
	            		}
	            	}
	            	
	            	if(doublesRolled == chosenPlayer.doubles || chosenPlayer.doubles == 3 || chosenPlayer.isInJail) {
		            	b1.setText("End Turn");
		            	doublesRolled = 0;
		            	chosenPlayer.doubles = 0;
	            	}
	            	else
	            		doublesRolled++;
	            }
	            else {
	            	turnHasEnded = true;
	            	b1.setText("Roll Dice");
               	 	currentPlayer++;
               	 	
               	 	if(currentPlayer > playerList.size()) {
               	 		currentPlayer = 1;
               	 		turnsLeft--;
               	 		if(turnsLeft == 0) {
               	 			l2.setFont(font6);
               	 			l2.setText("Finish!");
               	 		}
               	 		else if(turnsLeft == 1) {
               	 			l2.setFont(font6);
               	 			l2.setText("Final Turn!");
               	 		}
               	 		else if(turnsLeft <= 5) {
               	 			l2.setFont(font6);
               	 			l2.setText(turnsLeft + " Turns Left!");
               	 		}
               	 		else
               	 			l2.setText(turnsLeft + " Turns Left");
               	 	}
               	 	
               	 	chosenPlayer = playerList.get(currentPlayer - 1);
               	 	
            		info.setText("<html>Player " + currentPlayer + "<br>Name: " + chosenPlayer.name + "<br>Cash: $"
            		+ chosenPlayer.cash + "</html>");
            		
            		for(int i = 0; i < chosenPlayer.propertyOwned.size(); i++) {            			            			
            			if(chosenPlayer.propertyOwned.get(i).isMortgaged) {
            				if(propertyMortgaged.equals(""))
            					propertyMortgaged = chosenPlayer.propertyOwned.get(i).propertyName;
            				else
            					propertyMortgaged = propertyMortgaged + ", " + chosenPlayer.propertyOwned.get(i).propertyName;
            			}
            			else {
                			if(propertyOwned.equals(""))
                				propertyOwned = chosenPlayer.propertyOwned.get(i).propertyName;
                			else
                				propertyOwned = propertyOwned + ", " + chosenPlayer.propertyOwned.get(i).propertyName;
            			}
            		}

            		propertyOwnedLabel.setText("<html>Property Owned (Active): " + propertyOwned + "</html>");
            		propertyMortgagedLabel.setText("<html>Property Mortgaged: " + propertyMortgaged + "</html>");
            		
	            	dices1And2.setText("");
	            	diceSum.setText("");
	            	t1.setText("");
	            }
        	}
        });
        
        b2.addActionListener(new ActionListener() {
        	@Override
	        public void actionPerformed(ActionEvent e) {
        		Player chosenPlayer = playerList.get(currentPlayer - 1);
        		String textFieldProperty = "";
	            String s = e.getActionCommand();
	            
	            if(s.equals("Mortgage")) {
	            	textFieldProperty = t1.getText();
	            	chosenPlayer.mortgage(textFieldProperty);
            		String propertyOwned = "";
            		String propertyMortgaged = "";
            		
            		for(int i = 0; i < chosenPlayer.propertyOwned.size(); i++) {            			            			
            			if(chosenPlayer.propertyOwned.get(i).isMortgaged) {
            				if(propertyMortgaged.equals(""))
            					propertyMortgaged = chosenPlayer.propertyOwned.get(i).propertyName;
            				else
            					propertyMortgaged = propertyMortgaged + ", " + chosenPlayer.propertyOwned.get(i).propertyName;
            			}
            			else {
                			if(propertyOwned.equals(""))
                				propertyOwned = chosenPlayer.propertyOwned.get(i).propertyName;
                			else
                				propertyOwned = propertyOwned + ", " + chosenPlayer.propertyOwned.get(i).propertyName;
            			}
            		}
            		
            		info.setText("<html>Player " + currentPlayer + "<br>Name: " + chosenPlayer.name + "<br>Cash: $"
            		+ chosenPlayer.cash + "</html>");
            		propertyOwnedLabel.setText("<html>Property Owned (Active): " + propertyOwned + "</html>");
            		propertyMortgagedLabel.setText("<html>Property Mortgaged: " + propertyMortgaged + "</html>");
	            	t1.setText("");
	            	
	            	int z;
	            	for(z = 0; z < chosenPlayer.propertyOwned.size(); z++)
	            		if(!chosenPlayer.propertyOwned.get(z).isMortgaged)
	            			break;
	            	if(chosenPlayer.cash >= 0 || z == chosenPlayer.propertyOwned.size()) {
	            			b1.setVisible(true);
	            			l.setVisible(false);
	            	}
	            }
        	}
        });
        
        b5.addActionListener(new ActionListener() {
        	@Override
	        public void actionPerformed(ActionEvent e) {
        		Player chosenPlayer = playerList.get(currentPlayer - 1);
        		String textFieldProperty = "";
	            String s = e.getActionCommand();
	            
	            if(s.equals("Unmortgage")) {
	            	textFieldProperty = t1.getText();
	            	chosenPlayer.unmortgage(textFieldProperty);
            		String propertyOwned = "";
            		String propertyMortgaged = "";
            		
            		for(int i = 0; i < chosenPlayer.propertyOwned.size(); i++) {            			            			
            			if(chosenPlayer.propertyOwned.get(i).isMortgaged) {
            				if(propertyMortgaged.equals(""))
            					propertyMortgaged = chosenPlayer.propertyOwned.get(i).propertyName;
            				else
            					propertyMortgaged = propertyMortgaged + ", " + chosenPlayer.propertyOwned.get(i).propertyName;
            			}
            			else {
                			if(propertyOwned.equals(""))
                				propertyOwned = chosenPlayer.propertyOwned.get(i).propertyName;
                			else
                				propertyOwned = propertyOwned + ", " + chosenPlayer.propertyOwned.get(i).propertyName;
            			}
            		}
            		
            		info.setText("<html>Player " + currentPlayer + "<br>Name: " + chosenPlayer.name + "<br>Cash: $"
            		+ chosenPlayer.cash + "</html>");
            		propertyOwnedLabel.setText("<html>Property Owned (Active): " + propertyOwned + "</html>");
            		propertyMortgagedLabel.setText("<html>Property Mortgaged: " + propertyMortgaged + "</html>");
	            	t1.setText("");	            	
	            }
        	}
        });
        
        b3.addActionListener(new ActionListener() {
        	@Override
	        public void actionPerformed(ActionEvent e) {
        		Player chosenPlayer = playerList.get(currentPlayer - 1);
        		String textFieldProperty = "";
	            String s = e.getActionCommand();
	            
	            if(s.equals("Buy House")) {
	            	textFieldProperty = t1.getText();
	            	chosenPlayer.buyHouse(textFieldProperty);
            		updateHouseCountLabel(textFieldProperty);
	            	
            		info.setText("<html>Player " + currentPlayer + "<br>Name: " + chosenPlayer.name + "<br>Cash: $"
            		+ chosenPlayer.cash + "</html>");
	            	t1.setText("");
	            }
        	}
        });
        
        b4.addActionListener(new ActionListener() {
        	@Override
	        public void actionPerformed(ActionEvent e) {
        		Player chosenPlayer = playerList.get(currentPlayer - 1);
        		String textFieldProperty = "";
	            String s = e.getActionCommand();
	            
	            if(s.equals("Sell House")) {
	            	textFieldProperty = t1.getText();
	            	chosenPlayer.sellHouse(textFieldProperty);
            		updateHouseCountLabel(textFieldProperty);
	            	
            		info.setText("<html>Player " + currentPlayer + "<br>Name: " + chosenPlayer.name + "<br>Cash: $"
            		+ chosenPlayer.cash + "</html>");
	            	t1.setText("");
	            	
	            	int z;
	            	for(z = 0; z < chosenPlayer.propertyOwned.size(); z++)
	            		if(!chosenPlayer.propertyOwned.get(z).isMortgaged)
	            			break;
	            	if(chosenPlayer.cash >= 0 || z == chosenPlayer.propertyOwned.size()) {
	            			b1.setVisible(true);
	            			l.setVisible(false);
	            	}
	            }
        	}
        });

        
        this.revalidate();
        this.repaint();
    }
    
    void movePlayerPiece(Player aPlayer, int playerNumber) {
    	
    	JLabel icon = playerIcons[playerNumber - 1];
    	
    	if(aPlayer.position == 10 && aPlayer.isInJail) {
    		if(playerNumber == 1)
    			icon.setBounds(60, 560, icon.getWidth(), icon.getHeight());
    		else if(playerNumber == 2)
    			icon.setBounds(80, 560, icon.getWidth(), icon.getHeight());
    		else if(playerNumber == 3)
    			icon.setBounds(60, 580, icon.getWidth(), icon.getHeight());
    		else
    			icon.setBounds(80, 580, icon.getWidth(), icon.getHeight());
    		return;
    	}

    	if(aPlayer.justLeftJail) {
			icon.setBounds(icon.getX() - 50, icon.getY() + 30, icon.getWidth(), icon.getHeight());
			aPlayer.justLeftJail = false;
    	}
    	
    	int oldPosition = aPlayer.position - aPlayer.diceRoll1 - aPlayer.diceRoll2;
    	
    	if(oldPosition < 0)
    		oldPosition += 40;
    	    	
    	while(oldPosition != aPlayer.position) {
    		if(oldPosition == 0)
    			icon.setBounds(icon.getX() - 80, icon.getY(), icon.getWidth(), icon.getHeight());
    		else if(oldPosition < 9)
    			icon.setBounds(icon.getX() - 50, icon.getY(), icon.getWidth(), icon.getHeight());
    		else if(oldPosition == 9)
    			icon.setBounds(icon.getX() - 100, icon.getY(), icon.getWidth(), icon.getHeight());
    		else if(oldPosition == 10)
    			icon.setBounds(icon.getX() + 20, icon.getY() - 80, icon.getWidth(), icon.getHeight());
    		else if(oldPosition < 19)
    			icon.setBounds(icon.getX(), icon.getY() - 50, icon.getWidth(), icon.getHeight());
    		else if(oldPosition == 19)
    			icon.setBounds(icon.getX(), icon.getY() - 80, icon.getWidth(), icon.getHeight());
    		else if(oldPosition == 20)
    			icon.setBounds(icon.getX() + 80, icon.getY(), icon.getWidth(), icon.getHeight());
    		else if(oldPosition < 29)
    			icon.setBounds(icon.getX() + 50, icon.getY(), icon.getWidth(), icon.getHeight());
    		else if(oldPosition == 29)
    			icon.setBounds(icon.getX() + 80, icon.getY(), icon.getWidth(), icon.getHeight());
    		else if(oldPosition == 30)
    			icon.setBounds(icon.getX(), icon.getY() + 80, icon.getWidth(), icon.getHeight());
    		else if(oldPosition < 39)
    			icon.setBounds(icon.getX(), icon.getY() + 50, icon.getWidth(), icon.getHeight());
    		else
    			icon.setBounds(icon.getX(), icon.getY() + 80, icon.getWidth(), icon.getHeight());
    		
    		oldPosition = (oldPosition + 1) % 40;
    	}
    }
    
    boolean turnHasEnded = false;
    
    public boolean turnEnded() {
    	if(turnHasEnded) {
    		turnHasEnded = false;
    		return true;
    	}
    	return false;
    }
    
    public void updateHouseCountLabel(String property) {
    	int i;
    	String houseCountString;
    	
    	for(i = 0; i < allProperties.length; i++)
    		if(allProperties[i] != null && allProperties[i].propertyName.equals(property))
    			break;
    	
    	if(i == allProperties.length || !allProperties[i].propertyType.equals("Normal Property"))
    		return;
    	
    	NormalProperty np = (NormalProperty) allProperties[i];
    	houseCountString = Integer.toString(np.numberOfHouses);
    	if(np.numberOfHouses == 5)
    		houseCounterArray[i].setText("H");
    	else
    		houseCounterArray[i].setText(houseCountString);
    }
    
    public void endGame() {
    	b1.setVisible(false);
    	b2.setVisible(false);
    	b3.setVisible(false);
    	b4.setVisible(false);
    	b5.setVisible(false);
    	l1.setVisible(false);
    	propertyOwnedLabel.setVisible(false);
    	propertyMortgagedLabel.setVisible(false);
    	info.setVisible(false);
    	t1.setVisible(false);
        l.setBounds(800, 300, 400, 100);
        
    	l.setText("<html>All turns are up. The game will be decided by summing up cash, the price of all houses, and the " + 
    	"price of all properties, less the amount owed due to mortgage.</html>");
    	l.setFont(font7);
    	l.setVisible(true);
    	
    	b.setText("Final Results");
    	b.setBounds(920, 400, 120, 30);
    }
    
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
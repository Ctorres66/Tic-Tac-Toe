import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class main {
	public static ArrayList<int[]>  WinningCombos = new ArrayList<int[]>();
	public static int turnCounter = 1;
	public static JButton[] spaces = new JButton[9];
	public static ImageIcon X = new ImageIcon("C:/Users/ctorr/git/Tic-Tac-Toe/TicTacToe/src/resources/X.png");
	public static ImageIcon O = new ImageIcon("C:/Users/ctorr/git/Tic-Tac-Toe/TicTacToe/src/resources/O.png");
	
	
	public static void main(String args[]) 
	{
		SetUpWinCons();
		spaces = drawCheckerboard();
		giveCommands(spaces);
	}
	
	//----------------------------------------------------------------------------------------------//
	//sets up Jframe with the pieces on each of the buttons
		private static JButton[] drawCheckerboard() 
		{

			//setting buttons and grid as well as adding each button to the grid
			JPanel gridPanel = new JPanel();
			gridPanel.setLayout(new GridLayout(3, 3));
			gridPanel.setSize(600, 600);
			JButton[] buttons = new JButton [9];
		
				for (int i = 0; i < buttons.length; i++) 
				{
					buttons[i] = new JButton();
					buttons[i].setSize(200, 200);
					buttons[i].setIcon(null);
					gridPanel.add(buttons[i]);
				}
				
			//jframe for board itself where the panel shall be added to
			JFrame board = new JFrame("Checkerboard");
			board.setSize(600, 600);
			board.add(gridPanel);
			board.setResizable(false);
			board.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			board.setVisible(true);
			
			giveCommands(buttons);
			
			return buttons;
		}
		//-----------------------------------------------------------------------------------//
		
		
		private static void giveCommands(JButton[] spaces)
		{
			ActionListener command = new ActionListener() 
			{
				
				@Override
				public void actionPerformed(ActionEvent e) {
					String state = e.getActionCommand();
					if (state == "unpressed")
					{
						if (turnCounter%2 == 1)
						{
							for (int i = 0; i < 9; i++)
							{
								if(e.getSource().equals(spaces[i]))
								{
									spaces[i].setActionCommand("pressed");
									spaces[i].setIcon(X);
									if (WinCheck(spaces) == true)
									{
										System.out.println("X is the Winner!");
									}
								}
							}
						}					
						else if  (turnCounter%2 == 0) 
						{
							for (int i = 0; i < 9; i++)
							{
								if(e.getSource().equals(spaces[i]))
								{
									spaces[i].setActionCommand("pressed");
									spaces[i].setIcon(O);
									if (WinCheck(spaces) == true)
									{
										System.out.println("O is the Winner!");
									}
								}
							}
						}
						turnCounter++;
						System.out.println(turnCounter);
					}
					
				
				};
			};
			
			
			for (int i = 0; i< 9; i++)
			{
				spaces[i].addActionListener(command);
				spaces[i].setActionCommand("unpressed");
			}
		}
//----------------------------------------------------------------------------------------------//
//Checks if any of the players have won
		public static boolean WinCheck(JButton[] spaces)
		{
			for (int[] WinCon : WinningCombos)
			{
				int first = WinCon[0];
				int second = WinCon[1];
				int third = WinCon[2];
				if(spaces[first].getIcon() == spaces[second].getIcon() && 
						spaces[second].getIcon() == spaces[third].getIcon()
						&& spaces[first].getIcon() != null)
				{
					return true;
				}
			}
			return false;
		}
//----------------------------------------------------------------------------------------------//
//Sets up ArrayList of Possible Win Conditions
		private static void SetUpWinCons()
		{
			int[] a = {0, 1, 2};
			WinningCombos.add(a);
			int [] b = {3, 4, 5};
			WinningCombos.add(b);
			int [] c = {6, 7, 8};
			WinningCombos.add(c);
			int [] d = {0, 3, 6};
			WinningCombos.add(d);
			int [] e = {1, 4, 7};
			WinningCombos.add(e);
			int [] f = {2, 5, 8};
			WinningCombos.add(f);
			int [] g = {0, 4, 8};
			WinningCombos.add(g);
			int [] h = {2, 4, 6};
			WinningCombos.add(h);
		}
}
				
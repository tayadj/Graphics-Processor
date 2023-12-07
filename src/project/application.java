package project;

import java.awt.event.*;

import javax.swing.*;

public class application
{
	public static JFrame mainFrame;
	public static JMenuBar mainBar;
	public static JMenu mainMenu;
	public static JMenuItem mainMenu_linearContrastAlgorithm;
	
	
	public static void showGUI()
	{		
		mainMenu_linearContrastAlgorithm = new JMenuItem("Linear Contrast Algorithm");
		mainMenu_linearContrastAlgorithm.addActionListener
		(
			new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent event)
				{
					try
					{
						project.processor();
					} 
					catch (Exception error) 
					{ 
			            System.out.println("Oops! " + error);
			            System.exit(0);
			        }
				}
			}
		);
		
		mainMenu = new JMenu("Algorithms");
		mainMenu.add(mainMenu_linearContrastAlgorithm);
		
		mainBar = new JMenuBar();
		mainBar.add(mainMenu);
		
		mainFrame = new JFrame("Graphics Processor");
		mainFrame.setSize(720,540);
		mainFrame.setLayout(null);
		mainFrame.setVisible(true);	
		mainFrame.setJMenuBar(mainBar);
	}

}

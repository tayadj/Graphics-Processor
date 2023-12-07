package project;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class application
{
	public static JFrame mainFrame 									= new JFrame();
	public static JPanel sidePanel 									= new JPanel();
	public static JButton sidePanelButton_linearContrast			= new JButton();
	
	public static void connectResizeEvent() 
	{
		mainFrame.addComponentListener
		(
			new ComponentAdapter() 
			{
			    public void componentResized(ComponentEvent event) {
			    	sidePanel.setBounds(20, 20, 200, mainFrame.getHeight() - 80);
			    	System.out.println(mainFrame.getHeight() + " " + mainFrame.getWidth());
			    }
			}
		);
	}
	
	public static void connectActionEvent()
	{
		sidePanelButton_linearContrast.addActionListener
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
					System.out.println("Cool");
				}
			}
		);
	}
	
	public static void connectMouseEvent()
	{
		sidePanelButton_linearContrast.addMouseListener
		(
				new MouseAdapter()
				{
					public void mouseEntered(MouseEvent event)
					{
						sidePanelButton_linearContrast.setBackground(new Color(255,255,255));
					}
					
					public void mouseExited(MouseEvent event)
					{
						sidePanelButton_linearContrast.setBackground(new Color(254,230,0));
					}
				}
			);
	}
	
	public static void showGUI()
	{		
		mainFrame.setTitle("Graphics Processor");
		mainFrame.getContentPane().setBackground(new Color(255,255,255));
		mainFrame.setMinimumSize(new Dimension(720,540));
		mainFrame.setSize(720,540);
		mainFrame.setVisible(true);	
		mainFrame.setLayout(null);		
		mainFrame.add(sidePanel);
		
		sidePanel.setBounds(20, 20, 200, 440);
		sidePanel.setBackground(new Color(255,255,255));
		sidePanel.add(sidePanelButton_linearContrast);
		
		sidePanelButton_linearContrast.setBounds(0,0,200,60);
		sidePanelButton_linearContrast.setText("LINEAR CONTRAST");
		sidePanelButton_linearContrast.setBackground(new Color(254,230,0));
		sidePanelButton_linearContrast.setBorderPainted(false);
		sidePanelButton_linearContrast.setForeground(new Color(0,0,0));
		
		connectResizeEvent();
		connectActionEvent();
		connectMouseEvent();
	}
	
	/*public static JFrame mainFrame;
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
		mainMenu_linearContrastAlgorithm.addMouseListener
		(
			new MouseAdapter()
			{
				public void mouseEntered(MouseEvent event)
				{
					mainMenu_linearContrastAlgorithm.setBackground(new Color(200,200,187));
				}
				
				public void mouseExited(MouseEvent event)
				{
					mainMenu_linearContrastAlgorithm.setBackground(new Color(100,200,187));
				}
			}
		);
		
		mainMenu = new JMenu("Algorithms");
		mainMenu.add(mainMenu_linearContrastAlgorithm);
		
		mainBar = new JMenuBar();
		mainBar.add(mainMenu);
		mainBar.setBackground(new Color(200,200,187));
		
		
		mainFrame = new JFrame("Graphics Processor");
		mainFrame.setSize(720,540);
		mainFrame.setLayout(null);
		mainFrame.setVisible(true);	
		mainFrame.setJMenuBar(mainBar);
	}
	*/

}

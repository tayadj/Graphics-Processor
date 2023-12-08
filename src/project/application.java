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
						project.processor(1);
					} 
					catch (Exception error) 
					{ 
			            System.err.println("Oops! " + error);
			            System.exit(0);
			        }
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

}

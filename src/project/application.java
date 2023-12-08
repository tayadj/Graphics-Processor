package project;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class application
{
	public static JFrame mainFrame 										= new JFrame();
	public static JPanel sidePanel 										= new JPanel();
	public static JButton sidePanelButton_linearContrast				= new JButton();
	public static JButton sidePanelButton_homogeneousAveragingFilter 	= new JButton();
	public static JButton sidePanelButton_chooseFile				 	= new JButton();
	
	public static String filePath = "C:/Education/Java/Eclipse/eclipse-workspace/GraphicsProcessor/data/Fig5.04(i).bmp";
	
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
						project.processor(1, 0, filePath);
					} 
					catch (Exception error) 
					{ 
			            System.err.println("Oops! " + error);
			            System.exit(0);
			        }
				}
			}
		);
		
		sidePanelButton_homogeneousAveragingFilter.addActionListener
		(
			new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent event)
				{
					try
					{
						project.processor(2, 1, filePath);
					} 
					catch (Exception error) 
					{ 
			            System.err.println("Oops! " + error);
			            System.exit(0);
			        }
				}
			}
		);
		
		sidePanelButton_chooseFile.addActionListener
		(
			new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent event)
				{
					JFileChooser fileChooser = new JFileChooser();
					int result = fileChooser.showDialog(null, "Open image");     
					
					if (result == JFileChooser.APPROVE_OPTION)
					{
					    filePath = fileChooser.getSelectedFile().getPath();
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
						sidePanelButton_linearContrast.setBackground(new Color(0,0,0));
						sidePanelButton_linearContrast.setForeground(new Color(254,230,0));
					}
					
					public void mouseExited(MouseEvent event)
					{
						sidePanelButton_linearContrast.setBackground(new Color(254,230,0));
						sidePanelButton_linearContrast.setForeground(new Color(0,0,0));
					}
				}
		);
		
		sidePanelButton_homogeneousAveragingFilter.addMouseListener
		(
				new MouseAdapter()
				{
					public void mouseEntered(MouseEvent event)
					{
						sidePanelButton_homogeneousAveragingFilter.setBackground(new Color(0,0,0));
						sidePanelButton_homogeneousAveragingFilter.setForeground(new Color(254,230,0));
					}
					
					public void mouseExited(MouseEvent event)
					{
						sidePanelButton_homogeneousAveragingFilter.setBackground(new Color(254,230,0));
						sidePanelButton_homogeneousAveragingFilter.setForeground(new Color(0,0,0));
					}
				}
		);
		
		sidePanelButton_chooseFile.addMouseListener
		(
				new MouseAdapter()
				{
					public void mouseEntered(MouseEvent event)
					{
						sidePanelButton_chooseFile.setBackground(new Color(0,0,0));
						sidePanelButton_chooseFile.setForeground(new Color(254,230,0));
					}
					
					public void mouseExited(MouseEvent event)
					{
						sidePanelButton_chooseFile.setBackground(new Color(254,230,0));
						sidePanelButton_chooseFile.setForeground(new Color(0,0,0));
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
		sidePanel.add(sidePanelButton_homogeneousAveragingFilter);
		sidePanel.add(sidePanelButton_chooseFile);
		
		sidePanelButton_linearContrast.setBounds(0,0,200,60);
		sidePanelButton_linearContrast.setText("LINEAR CONTRAST");
		sidePanelButton_linearContrast.setBackground(new Color(254,230,0));
		sidePanelButton_linearContrast.setBorderPainted(false);
		sidePanelButton_linearContrast.setForeground(new Color(0,0,0));
		
		sidePanelButton_homogeneousAveragingFilter.setBounds(0,80,200,60);
		sidePanelButton_homogeneousAveragingFilter.setText("HOMOGENEOUS AVERAGING");
		sidePanelButton_homogeneousAveragingFilter.setBackground(new Color(254,230,0));
		sidePanelButton_homogeneousAveragingFilter.setBorderPainted(false);
		sidePanelButton_homogeneousAveragingFilter.setForeground(new Color(0,0,0));
		
		sidePanelButton_chooseFile.setBounds(160,0,200,60);
		sidePanelButton_chooseFile.setText("CHOOSE FILE");
		sidePanelButton_chooseFile.setBackground(new Color(254,230,0));
		sidePanelButton_chooseFile.setBorderPainted(false);
		sidePanelButton_chooseFile.setForeground(new Color(0,0,0));
		
		connectResizeEvent();
		connectActionEvent();
		connectMouseEvent();
	}

}

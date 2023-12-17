package project;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import java.awt.*;

public class application
{
	public static JFrame mainFrame 										= new JFrame();
	public static JPanel sidePanel 										= new JPanel();
	public static JButton sidePanelButton_chooseFile				 	= new JButton();
	public static JButton sidePanelButton_linearContrast				= new JButton();
	public static JButton sidePanelButton_homogeneousAveragingFilter 	= new JButton();
	public static JButton sidePanelButton_gaussianFilter				= new JButton();
	public static JButton sidePanelButton_laplacianOfGaussContrast  	= new JButton();
	public static JButton sidePanelButton_medianFilter				  	= new JButton();
	public static JButton sidePanelButton_maximumFilter				  	= new JButton();
	public static JButton sidePanelButton_minimumFilter				  	= new JButton();
	public static JButton sidePanelButton_morphologicalProcessing		= new JButton();
	public static JLabel fileImage										= new JLabel();
	
	public static String filePath;
	public static Image fileSourceImage;
	public static BufferedImage fileBufferedImage;
	
	public static void connectResizeEvent() 
	{
		mainFrame.addComponentListener
		(
			new ComponentAdapter() 
			{
			    public void componentResized(ComponentEvent event) {
			    	sidePanel.setBounds(20, 20, 260, mainFrame.getHeight() - 80);
			    }
			}
		);
	}
	
	public static void connectActionEvent()
	{
		mainFrame.addWindowListener
		(
			new WindowAdapter()
			{
			    @Override
			    public void windowClosing(WindowEvent e) 
			    {
			        System.exit(0);
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
					    try
					    {
					    	filePath = fileChooser.getSelectedFile().getPath();
							fileSourceImage = ImageIO.read(new File(filePath));
							fileBufferedImage = new BufferedImage(fileSourceImage.getWidth(null), fileSourceImage.getHeight(null), BufferedImage.TYPE_INT_ARGB);
						    fileBufferedImage = ImageIO.read(new File(filePath));
					    }
						catch (Exception error) 
						{ 
				            System.err.println("Oops! " + error);
				            System.exit(0);
				        }
					   
					    if (fileBufferedImage.getWidth() > fileBufferedImage.getHeight())
					    {
					    	fileImage.setBounds(340, 20 + (460 - (int) (fileBufferedImage.getHeight()*1.0/(fileBufferedImage.getWidth()*1.0/460)))/2, 460, (int) (fileBufferedImage.getHeight()*1.0/(fileBufferedImage.getWidth()*1.0/460)));
					    	fileImage.setIcon(new ImageIcon(new ImageIcon(fileBufferedImage).getImage().getScaledInstance(460, (int) (fileBufferedImage.getHeight()*1.0/(fileBufferedImage.getWidth()*1.0/460)), java.awt.Image.SCALE_SMOOTH)));
					    }
					    else if (fileBufferedImage.getWidth() < fileBufferedImage.getHeight())
					    {
					    	fileImage.setBounds(340 + (460 - (int) (fileBufferedImage.getWidth()*1.0/(fileBufferedImage.getHeight()*1.0/460)))/2, 20, (int) (fileBufferedImage.getWidth()*1.0/(fileBufferedImage.getHeight()*1.0/460)), 460);
					    	fileImage.setIcon(new ImageIcon(new ImageIcon(fileBufferedImage).getImage().getScaledInstance((int) (fileBufferedImage.getWidth()*1.0/(fileBufferedImage.getHeight()*1.0/460)), 460, java.awt.Image.SCALE_SMOOTH)));
					    }
					    else 
					    {
					    	fileImage.setBounds(340, 20, 460, 460);
					    	fileImage.setIcon(new ImageIcon(new ImageIcon(fileBufferedImage).getImage().getScaledInstance(460, 460, java.awt.Image.SCALE_SMOOTH)));
					    }
					}
				}
			}
		);
		
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
		
		sidePanelButton_gaussianFilter.addActionListener
		(
			new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent event)
				{
					try
					{
						project.processor(3, 2, filePath);
					} 
					catch (Exception error) 
					{ 
			            System.err.println("Oops! " + error);
			            System.exit(0);
			        }
				}
			}
		);	
		
		sidePanelButton_laplacianOfGaussContrast.addActionListener
		(
			new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent event)
				{
					try
					{
						project.processor(4, 0, filePath);
					} 
					catch (Exception error) 
					{ 
			            System.err.println("Oops! " + error);
			            System.exit(0);
			        }
				}
			}
		);
		
		sidePanelButton_medianFilter.addActionListener
		(
			new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent event)
				{
					try
					{
						project.processor(5, 0, filePath);
					} 
					catch (Exception error) 
					{ 
			            System.err.println("Oops! " + error);
			            System.exit(0);
			        }
				}
			}
		);
		
		sidePanelButton_maximumFilter.addActionListener
		(
			new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent event)
				{
					try
					{
						project.processor(6, 0, filePath);
					} 
					catch (Exception error) 
					{ 
			            System.err.println("Oops! " + error);
			            System.exit(0);
			        }
				}
			}
		);
		
		sidePanelButton_minimumFilter.addActionListener
		(
			new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent event)
				{
					try
					{
						project.processor(7, 0, filePath);
					} 
					catch (Exception error) 
					{ 
			            System.err.println("Oops! " + error);
			            System.exit(0);
			        }
				}
			}
		);
		
		sidePanelButton_morphologicalProcessing.addActionListener
		(
			new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent event)
				{
					try
					{
						project.processor(8, 0, filePath);
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
		
		sidePanelButton_gaussianFilter.addMouseListener
		(
				new MouseAdapter()
				{
					public void mouseEntered(MouseEvent event)
					{
						sidePanelButton_gaussianFilter.setBackground(new Color(0,0,0));
						sidePanelButton_gaussianFilter.setForeground(new Color(254,230,0));
					}
					
					public void mouseExited(MouseEvent event)
					{
						sidePanelButton_gaussianFilter.setBackground(new Color(254,230,0));
						sidePanelButton_gaussianFilter.setForeground(new Color(0,0,0));
					}
				}
		);
		
		sidePanelButton_laplacianOfGaussContrast.addMouseListener
		(
				new MouseAdapter()
				{
					public void mouseEntered(MouseEvent event)
					{
						sidePanelButton_laplacianOfGaussContrast.setBackground(new Color(0,0,0));
						sidePanelButton_laplacianOfGaussContrast.setForeground(new Color(254,230,0));
					}
					
					public void mouseExited(MouseEvent event)
					{
						sidePanelButton_laplacianOfGaussContrast.setBackground(new Color(254,230,0));
						sidePanelButton_laplacianOfGaussContrast.setForeground(new Color(0,0,0));
					}
				}
		);
		
		sidePanelButton_medianFilter.addMouseListener
		(
				new MouseAdapter()
				{
					public void mouseEntered(MouseEvent event)
					{
						sidePanelButton_medianFilter.setBackground(new Color(0,0,0));
						sidePanelButton_medianFilter.setForeground(new Color(254,230,0));
					}
					
					public void mouseExited(MouseEvent event)
					{
						sidePanelButton_medianFilter.setBackground(new Color(254,230,0));
						sidePanelButton_medianFilter.setForeground(new Color(0,0,0));
					}
				}
		);
		
		sidePanelButton_maximumFilter.addMouseListener
		(
				new MouseAdapter()
				{
					public void mouseEntered(MouseEvent event)
					{
						sidePanelButton_maximumFilter.setBackground(new Color(0,0,0));
						sidePanelButton_maximumFilter.setForeground(new Color(254,230,0));
					}
					
					public void mouseExited(MouseEvent event)
					{
						sidePanelButton_maximumFilter.setBackground(new Color(254,230,0));
						sidePanelButton_maximumFilter.setForeground(new Color(0,0,0));
					}
				}
		);
		
		sidePanelButton_minimumFilter.addMouseListener
		(
				new MouseAdapter()
				{
					public void mouseEntered(MouseEvent event)
					{
						sidePanelButton_minimumFilter.setBackground(new Color(0,0,0));
						sidePanelButton_minimumFilter.setForeground(new Color(254,230,0));
					}
					
					public void mouseExited(MouseEvent event)
					{
						sidePanelButton_minimumFilter.setBackground(new Color(254,230,0));
						sidePanelButton_minimumFilter.setForeground(new Color(0,0,0));
					}
				}
		);
		
		sidePanelButton_morphologicalProcessing.addMouseListener
		(
				new MouseAdapter()
				{
					public void mouseEntered(MouseEvent event)
					{
						sidePanelButton_morphologicalProcessing.setBackground(new Color(0,0,0));
						sidePanelButton_morphologicalProcessing.setForeground(new Color(254,230,0));
					}
					
					public void mouseExited(MouseEvent event)
					{
						sidePanelButton_morphologicalProcessing.setBackground(new Color(254,230,0));
						sidePanelButton_morphologicalProcessing.setForeground(new Color(0,0,0));
					}
				}
		);
	}
	
	public static void showGUI()
	{			
		sidePanel.setBounds(20, 20, 260, 440);
		sidePanel.setBackground(new Color(255,255,255));
		sidePanel.setLayout(null);
		sidePanel.add(sidePanelButton_chooseFile);
		sidePanel.add(sidePanelButton_linearContrast);
		sidePanel.add(sidePanelButton_homogeneousAveragingFilter);
		sidePanel.add(sidePanelButton_gaussianFilter);
		sidePanel.add(sidePanelButton_laplacianOfGaussContrast);	
		sidePanel.add(sidePanelButton_medianFilter);
		sidePanel.add(sidePanelButton_maximumFilter);
		sidePanel.add(sidePanelButton_minimumFilter);	
		sidePanel.add(sidePanelButton_morphologicalProcessing);
		
		sidePanelButton_chooseFile.setBounds(0,0,240,40);
		sidePanelButton_chooseFile.setText("CHOOSE FILE");
		sidePanelButton_chooseFile.setBackground(new Color(254,230,0));
		sidePanelButton_chooseFile.setBorderPainted(false);
		sidePanelButton_chooseFile.setForeground(new Color(0,0,0));
		
		sidePanelButton_linearContrast.setBounds(0,60,240,40);
		sidePanelButton_linearContrast.setText("LINEAR CONTRAST");
		sidePanelButton_linearContrast.setBackground(new Color(254,230,0));
		sidePanelButton_linearContrast.setBorderPainted(false);
		sidePanelButton_linearContrast.setForeground(new Color(0,0,0));
		
		sidePanelButton_homogeneousAveragingFilter.setBounds(0,120,240,40);
		sidePanelButton_homogeneousAveragingFilter.setText("HOMOGENEOUS AVERAGING");
		sidePanelButton_homogeneousAveragingFilter.setBackground(new Color(254,230,0));
		sidePanelButton_homogeneousAveragingFilter.setBorderPainted(false);
		sidePanelButton_homogeneousAveragingFilter.setForeground(new Color(0,0,0));
		
		sidePanelButton_gaussianFilter.setBounds(0,180,240,40);
		sidePanelButton_gaussianFilter.setText("GAUSSIAN AVERAGING");
		sidePanelButton_gaussianFilter.setBackground(new Color(254,230,0));
		sidePanelButton_gaussianFilter.setBorderPainted(false);
		sidePanelButton_gaussianFilter.setForeground(new Color(0,0,0));
		
		sidePanelButton_laplacianOfGaussContrast.setBounds(0,240,240,40);
		sidePanelButton_laplacianOfGaussContrast.setText("LOG CONTRAST");
		sidePanelButton_laplacianOfGaussContrast.setBackground(new Color(254,230,0));
		sidePanelButton_laplacianOfGaussContrast.setBorderPainted(false);
		sidePanelButton_laplacianOfGaussContrast.setForeground(new Color(0,0,0));
		
		sidePanelButton_medianFilter.setBounds(0,300,240,40);
		sidePanelButton_medianFilter.setText("MEDIAN FILTER");
		sidePanelButton_medianFilter.setBackground(new Color(254,230,0));
		sidePanelButton_medianFilter.setBorderPainted(false);
		sidePanelButton_medianFilter.setForeground(new Color(0,0,0));
		
		sidePanelButton_maximumFilter.setBounds(0,360,240,40);
		sidePanelButton_maximumFilter.setText("MAXIMUM FILTER");
		sidePanelButton_maximumFilter.setBackground(new Color(254,230,0));
		sidePanelButton_maximumFilter.setBorderPainted(false);
		sidePanelButton_maximumFilter.setForeground(new Color(0,0,0));
		
		sidePanelButton_minimumFilter.setBounds(0,420,240,40);
		sidePanelButton_minimumFilter.setText("MINIMUM FILTER");
		sidePanelButton_minimumFilter.setBackground(new Color(254,230,0));
		sidePanelButton_minimumFilter.setBorderPainted(false);
		sidePanelButton_minimumFilter.setForeground(new Color(0,0,0));	
		
		sidePanelButton_morphologicalProcessing.setBounds(0,480,240,40);
		sidePanelButton_morphologicalProcessing.setText("MORPHOLOGICAL PROCESSING");
		sidePanelButton_morphologicalProcessing.setBackground(new Color(254,230,0));
		sidePanelButton_morphologicalProcessing.setBorderPainted(false);
		sidePanelButton_morphologicalProcessing.setForeground(new Color(0,0,0));	
		
		mainFrame.setTitle("Graphics Processor");
		mainFrame.getContentPane().setBackground(new Color(255,255,255));
		mainFrame.setMinimumSize(new Dimension(900,540));
		mainFrame.setPreferredSize(new Dimension(900,540));
		mainFrame.setSize(900,540);
		mainFrame.setVisible(true);	
		mainFrame.setLayout(null);		
		mainFrame.add(sidePanel);
		mainFrame.add(fileImage);
		mainFrame.pack();
		
		connectResizeEvent();
		connectActionEvent();
		connectMouseEvent();
	}

}

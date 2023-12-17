package forms;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class morphologicalMask
{
	public static JFrame formFrame 					= new JFrame();
	public static GridLayout formFrameLayout 		= new GridLayout();
	public static JButton[][] formButtons			= new JButton[5][5];
	
	public static boolean[][] mask 					= new boolean[5][5];
	public static int mode 							= 0;
	public static String filePath					= null;
	
	public static void connectActionEvent()
	{
		formFrame.addWindowListener
		(
			new WindowAdapter()
			{
			    @Override
			    public void windowClosing(WindowEvent e) 
			    {
			    	for (int x = 0; x < 5; ++x)
			    	{
			    		for (int y = 0; y < 5; ++y)
			    		{
			    			if (formButtons[x][y].getBackground().getRed() != 0)
			    			{
			    				mask[x][y] = true;
			    			}
			    		}
			    	}
			    	
			        switch (mode)
			        {
				        case 8:
				        {
				        	try 
				        	{
								project.project.processor(8, 0, mask, filePath);
				        	} 
							catch (Exception error) 
							{ 
					            System.err.println("Oops! " + error);
					            System.exit(0);
					        }
				        	break;
				        }
				        case 9:
				        {
				        	try
				        	{
				        		project.project.processor(9, 0, mask, filePath);
					        } 
							catch (Exception error) 
							{ 
					            System.err.println("Oops! " + error);
					            System.exit(0);
					        }
				        	break;
				        }
			        }
			        
			        formFrame = new JFrame();
			    	formFrameLayout = new GridLayout();
			    	formButtons	= new JButton[5][5];
			    	mask = new boolean[5][5];
			    	mode = 0;
			    	filePath = null;
			    }
			}
		);
	}
	
	public static void connectFormEvent()
	{
		formButtons[0][0].addActionListener
		(
			new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent event)
				{
					if (formButtons[0][0].getBackground().getRed() == 0)
					{
						formButtons[0][0].setBackground(new Color(254,230,0));
					}
					else
					{
						formButtons[0][0].setBackground(new Color(0,0,0));
					}					
				}
			}
		);

		formButtons[1][0].addActionListener
		(
			new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent event)
				{
					if (formButtons[1][0].getBackground().getRed() == 0)
					{
						formButtons[1][0].setBackground(new Color(254,230,0));
					}
					else
					{
						formButtons[1][0].setBackground(new Color(0,0,0));
					}					
				}
			}
		);

		formButtons[2][0].addActionListener
		(
			new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent event)
				{
					if (formButtons[2][0].getBackground().getRed() == 0)
					{
						formButtons[2][0].setBackground(new Color(254,230,0));
					}
					else
					{
						formButtons[2][0].setBackground(new Color(0,0,0));
					}					
				}
			}
		);

		formButtons[3][0].addActionListener
		(
			new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent event)
				{
					if (formButtons[3][0].getBackground().getRed() == 0)
					{
						formButtons[3][0].setBackground(new Color(254,230,0));
					}
					else
					{
						formButtons[3][0].setBackground(new Color(0,0,0));
					}					
				}
			}
		);

		formButtons[4][0].addActionListener
		(
			new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent event)
				{
					if (formButtons[4][0].getBackground().getRed() == 0)
					{
						formButtons[4][0].setBackground(new Color(254,230,0));
					}
					else
					{
						formButtons[4][0].setBackground(new Color(0,0,0));
					}					
				}
			}
		);
		
		formButtons[0][1].addActionListener
		(
			new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent event)
				{
					if (formButtons[0][1].getBackground().getRed() == 0)
					{
						formButtons[0][1].setBackground(new Color(254,230,0));
					}
					else
					{
						formButtons[0][1].setBackground(new Color(0,0,0));
					}					
				}
			}
		);

		formButtons[1][1].addActionListener
		(
			new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent event)
				{
					if (formButtons[1][1].getBackground().getRed() == 0)
					{
						formButtons[1][1].setBackground(new Color(254,230,0));
					}
					else
					{
						formButtons[1][1].setBackground(new Color(0,0,0));
					}					
				}
			}
		);

		formButtons[2][1].addActionListener
		(
			new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent event)
				{
					if (formButtons[2][1].getBackground().getRed() == 0)
					{
						formButtons[2][1].setBackground(new Color(254,230,0));
					}
					else
					{
						formButtons[2][1].setBackground(new Color(0,0,0));
					}					
				}
			}
		);

		formButtons[3][1].addActionListener
		(
			new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent event)
				{
					if (formButtons[3][1].getBackground().getRed() == 0)
					{
						formButtons[3][1].setBackground(new Color(254,230,0));
					}
					else
					{
						formButtons[3][1].setBackground(new Color(0,0,0));
					}					
				}
			}
		);

		formButtons[4][1].addActionListener
		(
			new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent event)
				{
					if (formButtons[4][1].getBackground().getRed() == 0)
					{
						formButtons[4][1].setBackground(new Color(254,230,0));
					}
					else
					{
						formButtons[4][1].setBackground(new Color(0,0,0));
					}					
				}
			}
		);
		
		formButtons[0][2].addActionListener
		(
			new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent event)
				{
					if (formButtons[0][2].getBackground().getRed() == 0)
					{
						formButtons[0][2].setBackground(new Color(254,230,0));
					}
					else
					{
						formButtons[0][2].setBackground(new Color(0,0,0));
					}					
				}
			}
		);

		formButtons[1][2].addActionListener
		(
			new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent event)
				{
					if (formButtons[1][2].getBackground().getRed() == 0)
					{
						formButtons[1][2].setBackground(new Color(254,230,0));
					}
					else
					{
						formButtons[1][2].setBackground(new Color(0,0,0));
					}					
				}
			}
		);

		formButtons[2][2].addActionListener
		(
			new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent event)
				{
					if (formButtons[2][2].getBackground().getRed() == 0)
					{
						formButtons[2][2].setBackground(new Color(254,230,0));
					}
					else
					{
						formButtons[2][2].setBackground(new Color(0,0,0));
					}					
				}
			}
		);

		formButtons[3][2].addActionListener
		(
			new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent event)
				{
					if (formButtons[3][2].getBackground().getRed() == 0)
					{
						formButtons[3][2].setBackground(new Color(254,230,0));
					}
					else
					{
						formButtons[3][2].setBackground(new Color(0,0,0));
					}					
				}
			}
		);

		formButtons[4][2].addActionListener
		(
			new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent event)
				{
					if (formButtons[4][2].getBackground().getRed() == 0)
					{
						formButtons[4][2].setBackground(new Color(254,230,0));
					}
					else
					{
						formButtons[4][2].setBackground(new Color(0,0,0));
					}					
				}
			}
		);
		
		formButtons[0][3].addActionListener
		(
			new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent event)
				{
					if (formButtons[0][3].getBackground().getRed() == 0)
					{
						formButtons[0][3].setBackground(new Color(254,230,0));
					}
					else
					{
						formButtons[0][3].setBackground(new Color(0,0,0));
					}					
				}
			}
		);

		formButtons[1][3].addActionListener
		(
			new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent event)
				{
					if (formButtons[1][3].getBackground().getRed() == 0)
					{
						formButtons[1][3].setBackground(new Color(254,230,0));
					}
					else
					{
						formButtons[1][3].setBackground(new Color(0,0,0));
					}					
				}
			}
		);

		formButtons[2][3].addActionListener
		(
			new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent event)
				{
					if (formButtons[2][3].getBackground().getRed() == 0)
					{
						formButtons[2][3].setBackground(new Color(254,230,0));
					}
					else
					{
						formButtons[2][3].setBackground(new Color(0,0,0));
					}					
				}
			}
		);

		formButtons[3][3].addActionListener
		(
			new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent event)
				{
					if (formButtons[3][3].getBackground().getRed() == 0)
					{
						formButtons[3][3].setBackground(new Color(254,230,0));
					}
					else
					{
						formButtons[3][3].setBackground(new Color(0,0,0));
					}					
				}
			}
		);

		formButtons[4][3].addActionListener
		(
			new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent event)
				{
					if (formButtons[4][3].getBackground().getRed() == 0)
					{
						formButtons[4][3].setBackground(new Color(254,230,0));
					}
					else
					{
						formButtons[4][3].setBackground(new Color(0,0,0));
					}					
				}
			}
		);
		
		formButtons[0][4].addActionListener
		(
			new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent event)
				{
					if (formButtons[0][4].getBackground().getRed() == 0)
					{
						formButtons[0][4].setBackground(new Color(254,230,0));
					}
					else
					{
						formButtons[0][4].setBackground(new Color(0,0,0));
					}					
				}
			}
		);

		formButtons[1][4].addActionListener
		(
			new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent event)
				{
					if (formButtons[1][4].getBackground().getRed() == 0)
					{
						formButtons[1][4].setBackground(new Color(254,230,0));
					}
					else
					{
						formButtons[1][4].setBackground(new Color(0,0,0));
					}					
				}
			}
		);

		formButtons[2][4].addActionListener
		(
			new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent event)
				{
					if (formButtons[2][4].getBackground().getRed() == 0)
					{
						formButtons[2][4].setBackground(new Color(254,230,0));
					}
					else
					{
						formButtons[2][4].setBackground(new Color(0,0,0));
					}					
				}
			}
		);

		formButtons[3][4].addActionListener
		(
			new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent event)
				{
					if (formButtons[3][4].getBackground().getRed() == 0)
					{
						formButtons[3][4].setBackground(new Color(254,230,0));
					}
					else
					{
						formButtons[3][4].setBackground(new Color(0,0,0));
					}					
				}
			}
		);

		formButtons[4][4].addActionListener
		(
			new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent event)
				{
					if (formButtons[4][4].getBackground().getRed() == 0)
					{
						formButtons[4][4].setBackground(new Color(254,230,0));
					}
					else
					{
						formButtons[4][4].setBackground(new Color(0,0,0));
					}					
				}
			}
		);		
	}
	
	public static void evoke(int mode, String filePath)
	{
		morphologicalMask.mode = mode;
		morphologicalMask.filePath = filePath;
		
		formFrameLayout.setColumns(5);
		formFrameLayout.setRows(5);
		formFrameLayout.setHgap(20);
		formFrameLayout.setVgap(20);
		
		
		formFrame.setTitle("Morphological Mask Form");
		formFrame.getContentPane().setBackground(new Color(255,255,255));
		formFrame.setMinimumSize(new Dimension(400,400));
		formFrame.setPreferredSize(new Dimension(400,400));
		formFrame.setSize(400,400);
		formFrame.setVisible(true);
		formFrame.setLayout(formFrameLayout);
		for (int x = 0; x < 5; ++x)
		{
			for (int y = 0; y < 5; ++y)
			{
				formButtons[x][y] = new JButton();
				formButtons[x][y].setBorder(null);
				formButtons[x][y].setBackground(new Color(0, 0, 0));
				formFrame.add(formButtons[x][y]);
			}
		}
		
		connectActionEvent();
		connectFormEvent();
	}
}

package forms;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import java.awt.*;

public class morphologicalMask
{
	public static JFrame formFrame 					= new JFrame();
	public static GridLayout formFrameLayout 		= new GridLayout();
	public static JButton[][] formButtons			= new JButton[5][5];
	
	
	public static boolean[][] evoke()
	{
		boolean[][] mask = new boolean[5][5];

		formFrameLayout.setColumns(5);
		formFrameLayout.setRows(5);
		formFrameLayout.setHgap(20);
		formFrameLayout.setVgap(20);
		for (int x = 0; x < 5; ++x)
		{
			for (int y = 0; y < 5; ++y)
			{
				formButtons[x][y] = new JButton();
				formFrameLayout.addLayoutComponent(null, formButtons[x][y]);
			}
		}
		
		formFrame.setTitle("Morphological Mask Form");
		formFrame.getContentPane().setBackground(new Color(255,255,255));
		formFrame.setMinimumSize(new Dimension(400,400));
		formFrame.setPreferredSize(new Dimension(400,400));
		formFrame.setSize(400,400);
		formFrame.setVisible(true);
		formFrame.setLayout(formFrameLayout);
		
		return mask;
	}
}

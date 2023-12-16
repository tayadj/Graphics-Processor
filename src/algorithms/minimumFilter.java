package algorithms;

import javax.imageio.*;
import javax.swing.ImageIcon;

import project.application;

import java.awt.image.*;
import java.awt.*;
import java.io.*;
import java.util.*;

public class minimumFilter
{

	public static BufferedImage resultImage;
	public static BufferedImage processingImage;
	
	public static BufferedImage process(Image sourceImage, File inputFile)
	throws IOException
	{
		processingImage = new BufferedImage(sourceImage.getWidth(null), sourceImage.getHeight(null), BufferedImage.TYPE_INT_ARGB);
		resultImage = new BufferedImage(sourceImage.getWidth(null), sourceImage.getHeight(null), BufferedImage.TYPE_INT_ARGB);
		processingImage = ImageIO.read(inputFile);
		
		int valueRGB;
		java.util.List<Integer> medianA, medianR, medianG, medianB;
		for (int x = 1; x < sourceImage.getWidth(null) - 1; ++x) 
		{
			for (int y = 1; y < sourceImage.getHeight(null) - 1; ++y)
			{				
				medianA = new ArrayList<Integer>();
				medianR = new ArrayList<Integer>();
				medianG = new ArrayList<Integer>();
				medianB = new ArrayList<Integer>();
				
				for (int sector_x = x - 1; sector_x <= x + 1; ++sector_x)
				{
					for (int sector_y = y - 1; sector_y <= y + 1; ++sector_y)
					{
						medianA.add(((processingImage.getRGB(sector_x, sector_y)) >> 24) & 0xff);
						medianR.add(((processingImage.getRGB(sector_x, sector_y)) >> 16) & 0xff);
						medianG.add(((processingImage.getRGB(sector_x, sector_y)) >> 8) & 0xff);
						medianB.add(((processingImage.getRGB(sector_x, sector_y))) & 0xff);
					}
				}	
				
				medianA.sort(null);
				medianR.sort(null);
				medianG.sort(null);
				medianB.sort(null);
				
				valueRGB = (medianA.get(0) << 24) | (medianR.get(0) << 16) | (medianG.get(0) << 8) | medianB.get(0);
				resultImage.setRGB(x, y, valueRGB);				
			}
		}
		
		if (resultImage.getWidth() > resultImage.getHeight())
	    {
			application.fileImage.setBounds(340, 20 + (460 - (int) (resultImage.getHeight()*1.0/(resultImage.getWidth()*1.0/460)))/2, 460, (int) (resultImage.getHeight()*1.0/(resultImage.getWidth()*1.0/460)));
			application.fileImage.setIcon(new ImageIcon(new ImageIcon(resultImage).getImage().getScaledInstance(460, (int) (resultImage.getHeight()*1.0/(resultImage.getWidth()*1.0/460)), java.awt.Image.SCALE_SMOOTH)));
	    }
	    else if (resultImage.getWidth() < resultImage.getHeight())
	    {
	    	application.fileImage.setBounds(340 + (460 - (int) (resultImage.getWidth()*1.0/(resultImage.getHeight()*1.0/460)))/2, 20, (int) (resultImage.getWidth()*1.0/(resultImage.getHeight()*1.0/460)), 460);
	    	application.fileImage.setIcon(new ImageIcon(new ImageIcon(resultImage).getImage().getScaledInstance((int) (resultImage.getWidth()*1.0/(resultImage.getHeight()*1.0/460)), 460, java.awt.Image.SCALE_SMOOTH)));
	    }
	    else 
	    {
	    	application.fileImage.setBounds(340, 20, 460, 460);
	    	application.fileImage.setIcon(new ImageIcon(new ImageIcon(resultImage).getImage().getScaledInstance(460, 460, java.awt.Image.SCALE_SMOOTH)));
	    }
		
		return resultImage;
	}

}
package algorithms;

import javax.imageio.*;
import javax.swing.ImageIcon;

import project.application;

import java.awt.image.*;
import java.awt.*;
import java.io.*;

public class morphologicalErosion
{

	public static BufferedImage resultImage;
	public static BufferedImage processingImage;
	
	public static BufferedImage process(Image sourceImage, File inputFile, boolean[][] mask)
	throws IOException
	{
		processingImage = new BufferedImage(sourceImage.getWidth(null), sourceImage.getHeight(null), BufferedImage.TYPE_INT_ARGB);
		resultImage = new BufferedImage(sourceImage.getWidth(null), sourceImage.getHeight(null), BufferedImage.TYPE_INT_ARGB);
		processingImage = ImageIO.read(inputFile);
		
		int valueRGB, valueA = 0, valueR = 0, valueG = 0, valueB = 0;
		boolean flag = true;
		for (int x = 2; x < sourceImage.getWidth(null) - 2; ++x) 
		{
			for (int y = 2; y < sourceImage.getHeight(null) - 2; ++y)
			{
				flag = true;
				for (int sector_x = x - 2; sector_x <= x + 2; ++sector_x)
				{
					for (int sector_y = y - 2; sector_y <= y + 2; ++sector_y)
					{
						valueA = ((processingImage.getRGB(sector_x, sector_y)) >> 24) & 0xff;
						valueR = ((processingImage.getRGB(sector_x, sector_y)) >> 16) & 0xff;
						valueG = ((processingImage.getRGB(sector_x, sector_y)) >> 8) & 0xff;
						valueB = ((processingImage.getRGB(sector_x, sector_y))) & 0xff;
						
						if (mask[sector_x - x + 2][sector_y - y + 2] == true && valueR == 0)
						{
							flag = false;
							break;
						}
						if (mask[sector_x - x + 2][sector_y - y + 2] == true && valueG == 0)
						{
							flag = false;
							break;
						}
						if (mask[sector_x - x + 2][sector_y - y + 2] == true && valueB == 0)
						{
							flag = false;
							break;
						}
					}
				}
				
				valueA = ((processingImage.getRGB(x, y)) >> 24) & 0xff;
				valueR = ((processingImage.getRGB(x, y)) >> 16) & 0xff;
				valueG = ((processingImage.getRGB(x, y)) >> 8) & 0xff;
				valueB = ((processingImage.getRGB(x, y))) & 0xff;
				
				if (flag)
				{
					valueRGB = (valueA << 24) | (valueR << 16) | (valueG << 8) | valueB;
					resultImage.setRGB(x, y, valueRGB);	
				}
				else
				{
					resultImage.setRGB(x, y, valueA << 24);	
				}
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


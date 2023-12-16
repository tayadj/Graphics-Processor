package algorithms;

import javax.imageio.*;
import javax.swing.ImageIcon;

import project.application;

import java.awt.image.*;
import java.awt.*;
import java.io.*;

public class homogeneousAveragingFilter
{
	
	public static BufferedImage resultImage;
	public static BufferedImage processingImage;
	
	public static BufferedImage process(Image sourceImage, File inputFile, int weight)
	throws IOException
	{
		processingImage = new BufferedImage(sourceImage.getWidth(null), sourceImage.getHeight(null), BufferedImage.TYPE_INT_ARGB);
		resultImage = new BufferedImage(sourceImage.getWidth(null), sourceImage.getHeight(null), BufferedImage.TYPE_INT_ARGB);
		processingImage = ImageIO.read(inputFile);
		
		int valueA, valueR, valueG, valueB, valueRGB;
		for (int x = 1; x < sourceImage.getWidth(null) - 1; ++x) 
		{
			for (int y = 1; y < sourceImage.getHeight(null) - 1; ++y)
			{
				valueA = 0;
				valueR = 0;
				valueG = 0; 
				valueB = 0;
				
				for (int sector_x = x - 1; sector_x <= x + 1; ++sector_x)
				{
					for (int sector_y = y - 1; sector_y <= y + 1; ++sector_y)
					{
						if (sector_x == x && sector_y == y)
						{
							valueA += (((processingImage.getRGB(sector_x, sector_y)) >> 24) & 0xff) * weight;
							valueR += (((processingImage.getRGB(sector_x, sector_y)) >> 16) & 0xff) * weight;
							valueG += (((processingImage.getRGB(sector_x, sector_y)) >> 8) & 0xff) * weight;
							valueB += (((processingImage.getRGB(sector_x, sector_y))) & 0xff) * weight;
						}
						else 
						{
							valueA += ((processingImage.getRGB(sector_x, sector_y)) >> 24) & 0xff;
							valueR += ((processingImage.getRGB(sector_x, sector_y)) >> 16) & 0xff;
							valueG += ((processingImage.getRGB(sector_x, sector_y)) >> 8) & 0xff;
							valueB += ((processingImage.getRGB(sector_x, sector_y))) & 0xff;
						}
					}
				}	
				
				valueA /= (8 + weight);
				valueR /= (8 + weight);
				valueG /= (8 + weight); 
				valueB /= (8 + weight);
				
				valueRGB = (valueA << 24) | (valueR << 16) | (valueG << 8) | valueB;
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

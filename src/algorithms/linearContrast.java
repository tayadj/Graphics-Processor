package algorithms;

import javax.imageio.*;
import javax.swing.ImageIcon;

import project.application;

import java.awt.image.*;
import java.awt.*;
import java.io.*;

public class linearContrast
{
	
	public static BufferedImage resultImage;
	public static BufferedImage processingImage;
	
	public static BufferedImage process(Image sourceImage, File inputFile)
	throws IOException
	{
		processingImage = new BufferedImage(sourceImage.getWidth(null), sourceImage.getHeight(null), BufferedImage.TYPE_INT_ARGB);
		resultImage = new BufferedImage(sourceImage.getWidth(null), sourceImage.getHeight(null), BufferedImage.TYPE_INT_ARGB);
		processingImage = ImageIO.read(inputFile);
		
		int maxValueA = 0, minValueA = 255;
		int maxValueR = 0, minValueR = 255;
		int maxValueG = 0, minValueG = 255;
		int maxValueB = 0, minValueB = 255;
		for (int x = 0; x < sourceImage.getWidth(null); ++x) 
		{
			for (int y = 0; y < sourceImage.getHeight(null); ++y)
			{
				if (maxValueA < (((processingImage.getRGB(x, y)) >> 24) & 0xff))
				{
					maxValueA = ((processingImage.getRGB(x, y)) >> 24) & 0xff;
				}
				if (maxValueR < (((processingImage.getRGB(x, y)) >> 16) & 0xff))
				{
					maxValueR = ((processingImage.getRGB(x, y)) >> 16) & 0xff;
				}
				if (maxValueG < (((processingImage.getRGB(x, y)) >> 8) & 0xff))
				{
					maxValueG = ((processingImage.getRGB(x, y)) >> 8) & 0xff;
				}
				if (maxValueB < (((processingImage.getRGB(x, y))) & 0xff))
				{
					maxValueB = ((processingImage.getRGB(x, y))) & 0xff;
				}
				if (minValueA > (((processingImage.getRGB(x, y)) >> 24) & 0xff))
				{
					minValueA = ((processingImage.getRGB(x, y)) >> 24) & 0xff;
				}
				if (minValueR > (((processingImage.getRGB(x, y)) >> 16) & 0xff))
				{
					minValueR = ((processingImage.getRGB(x, y)) >> 16) & 0xff;
				}
				if (minValueG > (((processingImage.getRGB(x, y)) >> 8) & 0xff))
				{
					minValueG = ((processingImage.getRGB(x, y)) >> 8) & 0xff;
				}
				if (minValueB > (((processingImage.getRGB(x, y))) & 0xff))
				{
					minValueB = ((processingImage.getRGB(x, y))) & 0xff;
				}
			}
		}
		
		int valueA, valueR, valueG, valueB, valueRGB;
		for (int x = 0; x < sourceImage.getWidth(null); ++x) 
		{
			for (int y = 0; y < sourceImage.getHeight(null); ++y)
			{
				valueA = 255;
				valueR = ((processingImage.getRGB(x, y)) >> 16) & 0xff;
				valueG = ((processingImage.getRGB(x, y)) >> 8) & 0xff;
				valueB = ((processingImage.getRGB(x, y))) & 0xff;
				
				if (minValueR != maxValueR) { valueR = 255 * (valueR - minValueR) / (maxValueR - minValueR); }
				if (minValueG != maxValueG) { valueG = 255 * (valueG - minValueG) / (maxValueG - minValueG); }
				if (minValueB != maxValueB) { valueB = 255 * (valueB - minValueB) / (maxValueB - minValueB); }
				
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

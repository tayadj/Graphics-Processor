package algorithms;

import javax.imageio.*;
import java.awt.image.*;
import java.awt.*;
import java.io.*;
import java.util.*;

public class medianFilter
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
				
				valueRGB = (medianA.get(4) << 24) | (medianR.get(4) << 16) | (medianG.get(4) << 8) | medianB.get(4);
				resultImage.setRGB(x, y, valueRGB);				
			}
		}
		
		return resultImage;
	}

}

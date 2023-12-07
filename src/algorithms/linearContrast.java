package algorithms;

import javax.imageio.*;
import java.awt.image.*;
import java.awt.*;
import java.io.*;

public class linearContrast
{
	public static BufferedImage resultImage;
	
	public static BufferedImage process(BufferedImage processingImage, Image sourceImage, File inputFile)
	throws IOException
	{
		processingImage = new BufferedImage(sourceImage.getWidth(null), sourceImage.getHeight(null), BufferedImage.TYPE_INT_ARGB);
		resultImage = new BufferedImage(sourceImage.getWidth(null), sourceImage.getHeight(null), BufferedImage.TYPE_INT_ARGB);
		processingImage = ImageIO.read(inputFile);
		
		/*for (int x = 1; x < sourceImage.getWidth(null) - 1; ++x)
		{
			for (int y = 1; y < sourceImage.getHeight(null) - 1; ++y)
			{
				int valueA = 0, valueR = 0, valueG = 0, valueB = 0;
				for (int sector_x = x - 1; sector_x < x + 1; ++sector_x) 
				{
					for (int sector_y = y - 1; sector_y < y + 1; ++sector_y)
					{
						if (valueA < (((processingImage.getRGB(sector_x, sector_y)) >> 24) & 0xff))
						{
							valueA = ((processingImage.getRGB(sector_x, sector_y)) >> 24) & 0xff;
						}
						if (valueR < (((processingImage.getRGB(sector_x, sector_y)) >> 16) & 0xff))
						{
							valueR = ((processingImage.getRGB(sector_x, sector_y)) >> 16) & 0xff;
						}
						if (valueG < (((processingImage.getRGB(sector_x, sector_y)) >> 8) & 0xff))
						{
							valueG = ((processingImage.getRGB(sector_x, sector_y)) >> 8) & 0xff;
						}
						if (valueB < (((processingImage.getRGB(sector_x, sector_y))) & 0xff))
						{
							valueB = ((processingImage.getRGB(sector_x, sector_y))) & 0xff;
						}
					}
				}				
	            int valueRGB = (valueA << 24) | (valueR << 16) | (valueG << 8) | valueB; 
				resultImage.setRGB(x, y, valueRGB);
			}
		}*/
		
		return resultImage;
	}
	
	
}

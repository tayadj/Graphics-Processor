package algorithms;

import javax.imageio.*;
import java.awt.image.*;
import java.awt.*;
import java.io.*;

public class laplacianOfGaussContrast
{
	
	public static BufferedImage resultImage;
	public static BufferedImage processingImage;
	
	public static BufferedImage process(Image sourceImage, File inputFile)
	throws IOException
	{
		processingImage = new BufferedImage(sourceImage.getWidth(null), sourceImage.getHeight(null), BufferedImage.TYPE_INT_ARGB);
		resultImage = new BufferedImage(sourceImage.getWidth(null), sourceImage.getHeight(null), BufferedImage.TYPE_INT_ARGB);
		processingImage = ImageIO.read(inputFile);
		
		int valueA, valueR, valueG, valueB, valueRGB;
		for (int x = 2; x < sourceImage.getWidth(null) - 2; ++x) 
		{
			for (int y = 2; y < sourceImage.getHeight(null) - 2; ++y)
			{
				valueA = 255;
				valueR = 0;
				valueG = 0; 
				valueB = 0;
				
				for (int sector_x = x - 2; sector_x <= x + 2; ++sector_x)
				{
					for (int sector_y = y - 2; sector_y <= y + 2; ++sector_y)
					{
						if (sector_x == x && sector_y == y)
						{
							valueA += (((processingImage.getRGB(sector_x, sector_y)) >> 24) & 0xff) * 16;
							valueR += (((processingImage.getRGB(sector_x, sector_y)) >> 16) & 0xff) * 16;
							valueG += (((processingImage.getRGB(sector_x, sector_y)) >> 8) & 0xff) * 16;
							valueB += (((processingImage.getRGB(sector_x, sector_y))) & 0xff) * 16;
						}
						else if (Math.abs(sector_x - x) + Math.abs(sector_y - y) == 1)
						{
							valueA += (((processingImage.getRGB(sector_x, sector_y)) >> 24) & 0xff) * (-2);
							valueR += (((processingImage.getRGB(sector_x, sector_y)) >> 16) & 0xff) * (-2);
							valueG += (((processingImage.getRGB(sector_x, sector_y)) >> 8) & 0xff) * (-2);
							valueB += (((processingImage.getRGB(sector_x, sector_y))) & 0xff) * (-2);
						}
						else if (Math.abs(sector_x - x) + Math.abs(sector_y - y) == 2)
						{
							valueA += (((processingImage.getRGB(sector_x, sector_y)) >> 24) & 0xff) * (-1);
							valueR += (((processingImage.getRGB(sector_x, sector_y)) >> 16) & 0xff) * (-1);
							valueG += (((processingImage.getRGB(sector_x, sector_y)) >> 8) & 0xff) * (-1);
							valueB += (((processingImage.getRGB(sector_x, sector_y))) & 0xff) * (-1);
						}
					}
				}
				
				valueR = Math.max(0, valueR);
				valueG = Math.max(0, valueG);
				valueB = Math.max(0, valueB);
				
				valueRGB = (valueA << 24) | (valueR << 16) | (valueG << 8) | valueB;
				resultImage.setRGB(x, y, valueRGB);				
			}
		}
		
		return resultImage;
	}

}

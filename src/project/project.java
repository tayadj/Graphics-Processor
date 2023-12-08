package project;
  
import algorithms.*;

import javax.imageio.*;
import java.awt.image.*;
import java.awt.*;
import java.io.*;
  
public class project { 

	public static BufferedImage processingImage;
	public static BufferedImage resultImage;
	public static Image sourceImage;
	public static File inputFile;
	public static File outputFile;
	
	public static void processor(int mode, int flag, String inputPath) 
	throws IOException
	{		
		try
		{
			try
			{
				inputFile = new File(inputPath);
				sourceImage = ImageIO.read(inputFile);
			}
			catch (Exception error) 
			{ 
	            System.err.println("Oops! " + error);
	            System.exit(0);
	        }
			
			switch (mode)
			{
				case 1:
				{
					resultImage = linearContrast.process(sourceImage, inputFile);
					break;
				}
				case 2:
				{
					resultImage = homogeneousAveragingFilter.process(sourceImage, inputFile, flag);
					break;
				}
				case 3:
				{
					resultImage = gaussianFilter.process(sourceImage, inputFile, flag);
					break;
				}
			}
			
			try
			{
				outputFile = new File(inputPath+"_PROCESSED_"+mode+".png"); 
	            ImageIO.write(resultImage, "png", outputFile); 
			}
			catch (Exception error) 
			{ 
	            System.err.println("Oops! " + error);
	            System.exit(0);
	        }			
		} 
		catch (Exception error) 
		{ 
            System.err.println("Oops! " + error);
            System.exit(0);
        }		
	}
	
	public static void main(String args[])
	throws IOException
	{		
		application.showGUI();
	}
	
}
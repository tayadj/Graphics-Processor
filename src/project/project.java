package project;
  
import algorithms.*;

import javax.imageio.*;
import java.awt.image.*;
import java.awt.*;
import java.io.*;
  
public class project { 

	public static BufferedImage processingImage;
	public static BufferedImage resultImage;
	//public static String inputPath = "C:/Education/Java/Eclipse/eclipse-workspace/GraphicsProcessor/data/Fig3.15(a)1top.bmp";
	//public static String inputPath = "C:/Education/Java/Eclipse/eclipse-workspace/GraphicsProcessor/data/Fig5.04(i).bmp";
	public static String inputPath = "C:/Education/Java/Eclipse/eclipse-workspace/GraphicsProcessor/data/Fig3.35(a).bmp";
	public static String outputPath = "C:/Education/Java/Eclipse/eclipse-workspace/GraphicsProcessor/data/JavaResult";
	public static Image sourceImage;
	public static File inputFile;
	public static File outputFile;
	
	public static void processor(int mode) 
	throws IOException
	{
		try
		{
			switch (mode)
			{
				case 1:
				{
					resultImage = linearContrast.process(sourceImage, inputFile);
					break;
				}
				case 2:
				{
					resultImage = homogeneousAveragingFilter.process(sourceImage, inputFile, 1);
					break;
				}
			}
			
			try
			{
				outputFile = new File(outputPath+mode+3+".png"); 
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
		
		application.showGUI();
	}
	
}
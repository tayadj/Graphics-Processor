package project;
  
import algorithms.*;

import javax.imageio.*;
import java.awt.image.*;
import java.awt.*;
import java.io.*;
  
public class project { 

	public static BufferedImage processingImage;
	public static BufferedImage resultImage;
	public static String inputPath = "C:/Education/Java/Eclipse/eclipse-workspace/GraphicsProcessor/data/Fig3.15(a)1top.bmp";
	public static String outputPath = "C:/Education/Java/Eclipse/eclipse-workspace/GraphicsProcessor/data/JavaResult___.png";
	public static Image sourceImage;
	public static File inputFile;
	public static File outputFile;
	
	public static void processor() 
	throws IOException
	{
		try
		{
			resultImage = linearContrast.process(processingImage, sourceImage, inputFile);
		} 
		catch (Exception error) 
		{ 
            System.out.println("Oops! " + error);
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
            System.out.println("Oops! " + error);
            System.exit(0);
        }
		
		application.showGUI();
		processor();
		
		try
		{
			outputFile = new File(outputPath); 
            ImageIO.write(resultImage, "png", outputFile); 
		}
		catch (Exception error) 
		{ 
            System.out.println("Oops! " + error);
            System.exit(0);
        }
		
	}
	
}
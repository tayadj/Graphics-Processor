package project;
  
import javax.imageio.*;
import java.awt.image.*;
import java.io.*;
  
public class project { 

	public static BufferedImage processingImage;
	public static File input;
	public static File output;
	
	public static void main(String args[])
	throws IOException
	{
		
		
		
	}
	
 /*   public static void main(String args[])
    throws IOException 
    { 
    	
        // width of the image 
        int width = 1029; 
  
        // height of the image 
        int height = 653; 
  
        // For storing image in RAM 
        BufferedImage image = null; 
  
        // READ IMAGE 
        try { 
            File input_file = new File( 
                "C:/Users/37533/OneDrive/Pictures/Screenshots/Снимок экрана 2023-03-05 130101.png"); 
  
            // image file path create an object of 
            // BufferedImage type and pass as parameter the 
            // width,  height and image int 
            // type. TYPE_INT_ARGB means that we are 
            // representing the Alpha , Red, Green and Blue 
            // component of the image pixel using 8 bit 
            // integer value. 
  
            image = new BufferedImage( 
                width, height, BufferedImage.TYPE_INT_ARGB); 
  
            // Reading input file 
            image = ImageIO.read(input_file); 
            
            int a = 255; 
            int r = 100; 
            int g = 150; 
            int b = 200; 
            int value = (a << 24) | (r << 16) | (g << 8) | b; 
            image.setRGB(10, 10, value);
  
            System.out.println("Reading complete."); 
        } 
        catch (IOException e) { 
            System.out.println("Error: " + e); 
        } 
  
        // WRITE IMAGE 
        try { 
            // Output file path 
            File output_file = new File( 
                "C:/Users/37533/OneDrive/Pictures/Screenshots/JavaResult.png"); 
  
            // Writing to file taking type and path as 
            ImageIO.write(image, "png", output_file); 
            
  
            System.out.println("Writing complete."); 
        } 
        catch (IOException e) { 
            System.out.println("Error: " + e); 
        } 
    } // main() ends here 
    */
}
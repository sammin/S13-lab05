package edu.ucsb.cs56.S13.drawings.pconrad.advanced;
import java.awt.image.BufferedImage;
import java.awt.Graphics2D;
import java.awt.Color;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;


import edu.ucsb.cs56.S13.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.S13.drawings.utilities.GeneralPathWrapper;


/**
 *  A class with a main method that can write a drawing to a graphics file.
 *  
 *  @author P. Conrad, 
 *  @version for CS56, W11 UCSB
 */

public class WritePictureToFile
{
    public static void usage()
    {
       System.out.println("Usage: java WritePictureToFile mypicture");
       // @@@ modify the next line to describe your picture
       System.out.println("     Writes a lovely picture of coffee cups to mypicture.png"); 
    }

    /** Write the drawFourCoffeeCups picture to a file.
     * 
     * @param args  The first command line argument is the file to write to.  We leave off the extension
     *              because that gets put on automatically.
     */

   public static void main(String[] args)
   {
     // make sure we have exactly one command line argument  
     if (args.length != 1)
     {
        usage();
        System.exit(1);
     }
        
     String outputfileName = args[0]; // the first command line argument
     
     final int WIDTH = 640;
     final int HEIGHT = 480;
         
     // create a new image
     // TYPE_INT_ARGB is "RGB image" with transparency (A = alpha channel)
     
     BufferedImage bi = 
        new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB); 

     Graphics2D g2 = bi.createGraphics();
      
     AllMyDrawings.drawPicture2(g2); // draw four coffee cups
      
     final String imageType = "png"; // choices: "gif", "png", "jpg"
      
     String fullFileName = ""; // must declare outside the try block, so we can see it inside the catch block
     
     try 
     {
        fullFileName = outputfileName + "." + imageType; // make the file name
        File outputfile = new File(fullFileName); // the file we will try to write
        ImageIO.write(bi, imageType, outputfile); // actually write it
        System.out.println("I created " + fullFileName); // tell the user
     } 
     catch (IOException e)
     {
      System.err.println("Sorry, an error occurred--I could not create "+ fullFileName +"\n The error was: "+ e.toString());
     }

      
   }
}

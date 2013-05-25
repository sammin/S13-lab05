package edu.ucsb.cs56.S13.drawings.samuelmin.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.geom.AffineTransform; // translation, rotation, scale
import java.awt.Shape; // general class for shapes

// all imports below this line needed if you are implementing Shape
import java.awt.geom.Point2D; 
import java.awt.geom.Rectangle2D;
import java.awt.Rectangle;
import java.awt.geom.PathIterator;
import java.awt.geom.AffineTransform;

import edu.ucsb.cs56.S13.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.S13.drawings.utilities.GeneralPathWrapper;

/**
   A Lamp (wrapper around a General Path, implements Shape)

   This provides an example of how you can start with the coordinates
   of a hard coded object, and end up with an object that can be
   drawn anywhere, with any width or height.
   
      
   @author Samuel Min 
   @version for CS56, W11, UCSB, 05/24/2013
   
*/
public class Lamp extends GeneralPathWrapper implements Shape
{

    
    /**
     * Constructor for objects of class Lamp
     */
    public Lamp(double x, double y, double width, double height)
    {
    
        // Specify the upper left corner, and the 
        //  width and height of the original points used to 
        //  plot the *hard-coded* lamp
        
        final double ORIG_ULX = 100.0; 
        final double ORIG_ULY = 100.0; 
        final double ORIG_HEIGHT = 400.0; 
        final double ORIG_WIDTH = 200.0; 
                
        GeneralPath top = new GeneralPath();
      
        // top of lamp
       
        top.moveTo(100,250);
        top.lineTo(150,100);
        top.lineTo(250,100);
        top.lineTo(300,250);
        top.lineTo(100,250);
	
        GeneralPath base = new GeneralPath();

	base.moveTo(175,250);
	base.lineTo(175,450);
	base.lineTo(100,450);
	base.lineTo(100,500);
	base.lineTo(300,500);
	base.lineTo(300,450);
	base.lineTo(225,450);
	base.lineTo(225,250); 
        /*GeneralPath topAndBottom = new GeneralPath();
       
        topAndBottom.moveTo(100,100);
        topAndBottom.lineTo(500,100); // top of cup
        
        topAndBottom.moveTo(200,400);
        topAndBottom.lineTo(400,400); // bottom of cup
       
        Shape rightSide = ShapeTransforms.horizontallyFlippedCopyOf(leftSide);
       
        // after flipping around the upper left hand corner of the
        // bounding box, we move this over to the right by 400 pixels
       
        rightSide = ShapeTransforms.translatedCopyOf(rightSide, 400.0, 0.0);
       
        // now we put the whole thing together ino a single path.
       */
        GeneralPath wholeLamp = new GeneralPath ();
        wholeLamp.append(top, false);
       wholeLamp.append(base, false); 
        // translate to the origin by subtracting the original upper left x and y
        // then translate to (x,y) by adding x and y
        
        Shape s = ShapeTransforms.translatedCopyOf(wholeLamp, -ORIG_ULX + x, -ORIG_ULY + y);
 
	// scale to correct height and width
        s =  ShapeTransforms.scaledCopyOf(s,
					  width/ORIG_WIDTH,
					  height/ORIG_HEIGHT) ;
	 
	// Use the GeneralPath constructor that takes a shape and returns
	// it as a general path to set our instance variable cup
        
	this.set(new GeneralPath(s));
        
    }

}

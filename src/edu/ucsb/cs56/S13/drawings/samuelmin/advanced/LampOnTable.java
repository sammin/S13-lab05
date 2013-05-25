package edu.ucsb.cs56.S13.drawings.samuelmin.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.geom.AffineTransform; // translation, rotation, scale
import java.awt.Shape; // general class for shapes

// all imports below this line needed if you are implementing Shape
import java.awt.geom.Point2D; 
import java.awt.geom.Line2D; 
import java.awt.geom.Rectangle2D;
import java.awt.Rectangle;
import java.awt.geom.PathIterator;
import java.awt.geom.AffineTransform;

import edu.ucsb.cs56.S13.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.S13.drawings.utilities.GeneralPathWrapper;
/**
   A House
      
   @author Phill Conrad 
   @version for CS56, W11, UCSB, 02/23/2011
   
*/
public class LampOnTable extends Lamp  implements Shape
{
    /**
     * Constructor for objects of class LampOnTable
     */
    public LampOnTable(double x, double y, double width, double height)
    {
	// construct the basic lamp shell
	super(x,y,width,height);

	// get the GeneralPath that we are going to append stuff to
	GeneralPath gp = this.get();
	
	double w = 0.10 * width;
	double l = 0.10 * height;

	Rectangle2D.Double top =
	    new Rectangle2D.Double(x, y+height, width, w);
	Rectangle2D.Double leg1 =
	    new Rectangle2D.Double(x, y+w+height, w, width);
	Rectangle2D.Double leg2 =
	    new Rectangle2D.Double(x + width - w, y+w+height, w, width);
	
	// add the windows to the house
	// Look up the meaning of the second parameter of append
	// (Hint--is a method of "GeneralPath")

        GeneralPath wholeThing = this.get();
        wholeThing.append(top, false);
        wholeThing.append(leg1, false);
        wholeThing.append(leg2, false); 
    }

}

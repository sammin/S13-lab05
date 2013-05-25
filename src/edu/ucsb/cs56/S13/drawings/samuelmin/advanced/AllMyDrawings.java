package edu.ucsb.cs56.S13.drawings.samuelmin.advanced;

import java.awt.Graphics2D;
import java.awt.geom.Line2D;  // single lines
import java.awt.geom.Ellipse2D;  // ellipses and circles
import java.awt.geom.Rectangle2D; // for the bounding box
import java.awt.Rectangle;  // squares and rectangles
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.geom.AffineTransform; // translation, rotation, scale
import java.awt.Shape; // general class for shapes
import java.awt.Color; // class for Colors
import java.awt.Stroke;
import java.awt.BasicStroke;


import edu.ucsb.cs56.S13.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.S13.drawings.utilities.GeneralPathWrapper;

/**
 * A class with static methods for drawing various pictures
 * 
 * @author Samuel Min
 * @version for CS56, lab05, Spring 2013
 */


public class AllMyDrawings
{
    /** Draw a picture with a few lamps 
     */

    public static void drawPicture1(Graphics2D g2) {

	Lamp l1 = new Lamp(100,250,50,75);
	g2.setColor(Color.CYAN); g2.draw(l1);
	
	Shape l2 = ShapeTransforms.scaledCopyOf(l1,0.5,0.5);
	l2 = ShapeTransforms.translatedCopyOf(l2,150,0);
	g2.setColor(Color.BLACK); g2.draw(l2);
	
	l2 = ShapeTransforms.scaledCopyOfLL(l2,4,4);
	l2 = ShapeTransforms.translatedCopyOf(l2,150,0);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(l2); 
		
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A few lamps by Samuel Min", 20,20);
    }
	
	
    /** Draw a picture with a few lamps on tables
     */
    public static void drawPicture2(Graphics2D g2) {

	// Draw some coffee cups.
	
	LampOnTable large = new LampOnTable(100,50,225,150);
	LampOnTable smallCC = new LampOnTable(20,50,40,30);
	LampOnTable tallSkinny  = new LampOnTable(20,150,20,40);
	
	g2.setColor(Color.RED);     //g2.draw(large);
	g2.setColor(Color.GREEN);   g2.draw(smallCC);
	g2.setColor(Color.BLUE);    g2.draw(tallSkinny);
	
	// Rotate 45 degrees around its center.
	Shape hw3 = ShapeTransforms.rotatedCopyOf(large, Math.PI/4.0);

	g2.draw(hw3);
	

	g2.setColor(Color.BLACK); 
	g2.drawString("A bunch of lamps on tables by Samuel Min", 20,20);
    }
  
    /** Draw a different picture with a lamp and table
     */

    public static void drawPicture3(Graphics2D g2) {
	
	// label the drawing
	
	g2.drawString("A bunch of lamps and tables by Samuel Min", 20,20);


	
       LampOnTable lot = new LampOnTable(100,50,225,150);
       Lamp fdsa = new Lamp(20,50,40,30);
       
       g2.setColor(Color.RED);     g2.draw(lot);
       g2.setColor(Color.GREEN);   g2.draw(fdsa);
       
       
    }
	
    

}

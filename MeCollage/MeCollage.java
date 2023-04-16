/**
 * MeCollage.java
 * 
 * A program, using the StdDraw class, to make a simple collage with 5 images
 * to describe myself, the author, along with descriptions to show what the
 * things in each of those images mean to me.
 *
 * @author Sanjay Chandrasekar
 * @version 1.0
 * @since 8/17/2021
 */

import java.awt.Color;
import java.awt.Font;
import java.util.Scanner;

public class MeCollage 
{ 
	/** 
	 *  Creates a MeCollage object.  There are no field 
	 *  variables to construct for this class, and this
	 *  is a no-args constructor.
	 */
	public MeCollage ( )
	{ }

	/** 
	 *  The main method, to create and run the instance of MeCollage,
	 *  named "run" here.
	 *  @param args          The array of String that can be used to 
	 *                       pass in String arguments from the command line.
	 */
	public static void main(String[] args)
	{
		MeCollage run = new MeCollage();
		run.setUpCanvas();
		run.drawInformationAboutMe();
    } 

	/** 
	 *  Sets up the canvas of this JFrame, using the appropriate size.  The
	 *  x and y axes are also scaled, ready for components like rectangles,
	 *  images, and text to be placed.  The background is set to black and 
	 *  the font is prepared.
	 */
	public void setUpCanvas()
	{
		StdDraw.setCanvasSize(1400, 900);
		StdDraw.setXscale(-700, 700);
		StdDraw.setYscale(-450, 450);
		StdDraw.clear();
		StdDraw.picture(0, 0, "bg.jpeg", 1400, 900);

		Font font = new Font("Times New Roman", Font.BOLD, 13);
		StdDraw.setFont(font);
		
//		StdDraw.enableDoubleBuffering();
	}

	/** 
	 *  Splits the drawing of the collage into 5 components.
	 */
	public void drawInformationAboutMe()
	{
		dogInfo();
		aboutMe();
		myFamily();
		foodTruck();
		badminton();
	}

	/** 
	 *  Adds a picture of a dog on the canvas, and draws a green rectangle with a
	 *  smaller white rectangle inside it, with text inside it describing the image.
	 */
	public void dogInfo()
	{
		StdDraw.picture(-450,260,"kulfi.jpeg",300,225);
		StdDraw.setPenColor(new Color(80,230,90));
		StdDraw.filledRectangle(-470,40,125,75);
		StdDraw.setPenColor(new Color(255,255,255));
		StdDraw.filledRectangle(-470,40,120,70);
		StdDraw.setPenColor(new Color(50,50,50));
		StdDraw.textLeft(-575,90,"We got a golden retriever puppy ");
		StdDraw.textLeft(-575,65,"this summer! We named him Kulfi, ");
		StdDraw.textLeft(-575,40,"and he's been a really good boy ");
		StdDraw.textLeft(-575,15,"for the one month that he's been ");
		StdDraw.textLeft(-575,-10,"with us so far.");
	}

	/** 
	 *  Adds a picture of myself on the canvas, and draws a green rectangle with a
	 *  smaller white rectangle inside it, with text inside it describing the image.
	 */
	public void aboutMe()
	{
		StdDraw.picture(440,250,"picOfMe.jpg",240,210);
		StdDraw.setPenColor(new Color(80,230,90));
		StdDraw.filledRectangle(410,40,120,75);
		StdDraw.setPenColor(new Color(255,255,255));
		StdDraw.filledRectangle(410,40,115,70);
		StdDraw.setPenColor(new Color(50,50,50));
		StdDraw.textLeft(305,90,"I'm a sophomore here at Monta Vista.");
		StdDraw.textLeft(305,65,"I like computer science and coding.");
		StdDraw.textLeft(305,40,"I'm excited to get to know everyone");
		StdDraw.textLeft(305,15,"here and to have a great year with");
		StdDraw.textLeft(305, -10, "all of you!");
	}

	/** 
	 *  Adds a picture of my family on the canvas, and draws a green rectangle with a
	 *  smaller white rectangle inside it, with text inside it describing the image.
	 */
	public void myFamily()
	{
		StdDraw.picture(0,70,"myfamily.jpg",320,240);
		StdDraw.setPenColor(new Color(80,230,90));
		StdDraw.filledRectangle(-30,290,120,75);
		StdDraw.setPenColor(new Color(255,255,255));
		StdDraw.filledRectangle(-30,290,115,70);
		StdDraw.setPenColor(new Color(50,50,50));
		StdDraw.textLeft(-135,340,"This is my family. The image");
		StdDraw.textLeft(-135,315,"quality isn't too good, but this");
		StdDraw.textLeft(-135,290,"is us at Crater Lake this summer.");
		StdDraw.textLeft(-135,265,"We really enjoy traveling and");
		StdDraw.textLeft(-135,240,"spending time with each other.");
	}

	/** 
	 *  Adds a picture of a food truck on the canvas, and draws a green rectangle with a
	 *  smaller white rectangle inside it, with text inside it describing the image.
	 */
	public void foodTruck()
	{
		StdDraw.picture(-520,-240,"foodTruck.jpeg",330,220);
		StdDraw.setPenColor(new Color(80,230,90));
		StdDraw.filledRectangle(-210,-265,120,75);
		StdDraw.setPenColor(new Color(255,255,255));
		StdDraw.filledRectangle(-210,-265,115,70);
		StdDraw.setPenColor(new Color(50,50,50));
		StdDraw.textLeft(-315,-215,"My family and I enjoy going");
		StdDraw.textLeft(-315,-240,"out to eat, especially at food");
		StdDraw.textLeft(-315,-265,"trucks. Our favorite is one");
		StdDraw.textLeft(-315,-290,"area in Sunnyvale, and I love");
		StdDraw.textLeft(-315,-315,"their specialty, called momos.");
	}

	/** 
	 *  Adds a picture of a badminton racket and birdie on the canvas, and draws a
	 *  green rectangle with a smaller white rectangle inside it, with text inside
	 *  it describing the image.
	 */
	public void badminton()
	{
		StdDraw.picture(180,-250,"badminton.jpeg",320,220);
		StdDraw.setPenColor(new Color(80,230,90));
		StdDraw.filledRectangle(485,-245,120,75);
		StdDraw.setPenColor(new Color(255,255,255));
		StdDraw.filledRectangle(485,-245,115,70);
		StdDraw.setPenColor(new Color(50,50,50));
		StdDraw.textLeft(380,-195,"I enjoy playing badminton a lot.");
		StdDraw.textLeft(380,-220,"It's my favorite sport and I put");
		StdDraw.textLeft(380,-245,"much of my time into practicing.");
		StdDraw.textLeft(380,-270,"I look forward to getting better and");
		StdDraw.textLeft(380,-295,"better at the sport.");
	}
} 
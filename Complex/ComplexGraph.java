/**
 * ComplexGraph.java
 * 
 * Graphs two complex numbers, and shows the 
 * sum, or difference, or product, or quotient
 * of these two numbers, as chosen by the user.
 * The two complex numbers are draggable (can be
 * selected by the mouse and dragged to a new
 * location).  Also, the values of the two points
 * are printed to the GUI, along with the
 * resulting sum, difference, product, or quotient,
 * as chosen by the user.
 *
 * @author Scott DeRuiter
 * @version 1.0
 * @since 10/22/2018
 */

import java.awt.Color;
import java.awt.Font;

public class ComplexGraph 
{ 
	/** Complex values to be graphed and manipulated.                              */
	private Complex redA, blueB;
	
	/**  Booleans to keep track of which point is being moved or changed.          */
	private boolean changeA, changeB;
	
	/**  Indicates if the mouse has been pressed on one of the points.             */
	private boolean pointHasFocus;

	/** 
	 *  Creates a ComplexGraph object.  A no-args constructor.  The boolean
	 *  fields are all set to false, and the complex points are set to random
	 *  values.
	 */
	public ComplexGraph ( )
	{
		redA = new Complex(-4 + (int)(9 * Math.random()),-3 + (int)(9 * Math.random()));
		blueB = new Complex(-4 + (int)(9 * Math.random()),-3 + (int)(9 * Math.random()));
		changeA = changeB = pointHasFocus = false;
	}

	/**
	 *  The main method, to run some of the operations and print them to the
	 *  terminal window.  Also, a canvas is set up, and the GUI is run.
	 */
	public static void main(String[] args)
	{
		ComplexGraph graph = new ComplexGraph();
		graph.checkComplexOperations();
		graph.setUpCanvas();
		graph.runGUI();
    } 
	
	/** 
	 *  Checks many of the constructors and methods of the Complex class,
	 *  including the four constructors, addition, subtraction, multiplication,
	 *  and division.
	 */
	public void checkComplexOperations ( )
	{
		System.out.println("\n\n\n");
		Complex num1 = new Complex();
		Complex num2 = new Complex(4);
		Complex num3 = new Complex(3,4);
		Complex num4 = new Complex(1,-2);
		Complex num5 = new Complex(num3);
		System.out.println("num1 = " + num1);
		System.out.println("num2 = " + num2);
		System.out.println("num3 = " + num3);
		System.out.println("num4 = " + num4);
		System.out.println("num5 = " + num5);
		num5.set(2.4,3.5);
		System.out.println("num5 = " + num5);
		System.out.println("(" + num3 + ")" + " + " + "(" + num4 + ") = " + num3.add(num4));
		System.out.println("(" + num3 + ")" + " - " + "(" + num4 + ") = " + num3.subtract(num4));
		System.out.println("(" + num3 + ")" + " * " + "(" + num4 + ") = " + num3.multiply(num4));
		System.out.println("(" + num3 + ")" + " / " + "(" + num4 + ") = " + num3.divide(num4));
		System.out.println("\n\n\n");
	}
	
	
	/** 
	 *  Sets up the canvas, using methods from StdDraw.  This includes
	 *  setting up the canvas size, the horizontal scale (Xscale), and
	 *  the vertical scale (Yscale).  
	 */
	public void setUpCanvas ( )
	{
		final int WIDTH = 1240;
		final int HEIGHT = 740;
		StdDraw.setCanvasSize(WIDTH, HEIGHT);
		StdDraw.setXscale(-9.4, 15.4);
		StdDraw.setYscale(-7.4, 7.4);
		
		StdDraw.enableDoubleBuffering();
	}
	
	/** 
	 *  Runs the Graphical User Interface.
	 */
	public void runGUI ( )
	{
		int buttonChoice = 4;
		while(true)
		{
			StdDraw.clear(new Color(255,255,255));
			drawAxesScaleAndBackground();
			drawPointsAndVectorsAndInfo(buttonChoice);
			buttonChoice = drawOperators(buttonChoice);
			reactToMousePressAndDragOnPoint(redA);
			reactToMousePressAndDragOnPoint(blueB);
			StdDraw.show();
			StdDraw.pause(40);
		}
	}
	
	/**
	 *  Draws the axes for the real and imaginary parts of the complex
	 *  number.  These axes are labeled, and grid lines are shown, to 
	 *  help with the identification of the point in the plane.
	 */
	public void drawAxesScaleAndBackground ( )
	{
		Font font = new Font("Arial", Font.PLAIN, 18);
		StdDraw.setFont(font);
		for(double integers = -9; integers <= 15; integers++)
		{
			StdDraw.setPenColor(new Color(220,220,220)); 
			if(integers == 0)
			{
				StdDraw.setPenColor(new Color(0,0,0)); 			
			}
			StdDraw.line(integers,-7.4,integers,7.4);
			StdDraw.line(-9.4,integers,15.4,integers);
			StdDraw.setPenColor(new Color(0,0,0)); 	
			if(integers != 0)
			{
				StdDraw.text(integers,-0.4,"" + (int)integers);
				StdDraw.text(-0.3,integers-0.05,"" + (int)integers);
			}
		}
		font = new Font("Arial", Font.BOLD, 18);
		StdDraw.setFont(font);
		StdDraw.text(14.5,0.11,"REAL");
		StdDraw.text(0.24,-6,"IMAGINARY",90);
	}
	
	/**
	 *  Draws the 3 points, A, B, and the operation on A and B (A+B or A-B or
	 *  A*B or A/B), as chosen by the user.  Vectors are also drawn to A and
	 *  B.  The values of A and B, along with the value of the operation on
	 *  A and B, are printed in the lower right of the GUI.
	 */
	public void drawPointsAndVectorsAndInfo(int buttonChoice)
	{
		drawPoints(buttonChoice);
		drawVectorsAnglesAndInfo(buttonChoice);
	}
	
	/**
	 *  Draws the 3 points, A, B, and the operation on A and B (A+B or A-B or
	 *  A*B or A/B), as chosen by the user.
	 */
	public void drawPoints(int buttonChoice)
	{
		Font font = new Font("Arial", Font.BOLD, 18);
		StdDraw.setFont(font);
		Complex sum = redA.add(blueB);
		Complex diff = redA.subtract(blueB);
		Complex product = redA.multiply(blueB);
		Complex quotient = redA.divide(blueB);
		StdDraw.setPenColor(new Color(255,0,0));
		StdDraw.line(0,0,redA.getReal(),redA.getImaginary());
		StdDraw.setPenColor(new Color(0,0,255));
		StdDraw.line(0,0,blueB.getReal(),blueB.getImaginary());
		for(int i = 0; i < 5; i++)
		{
			StdDraw.setPenColor(new Color(255 - i * 15,0,0));
			StdDraw.filledCircle(redA.getReal(),redA.getImaginary(),0.2 - 0.04 * i);
			StdDraw.setPenColor(new Color(0,0,255 - i * 15));
			StdDraw.filledCircle(blueB.getReal(),blueB.getImaginary(),0.2 - 0.04 * i);
			StdDraw.setPenColor(new Color(0 + 25 * i,0 + 25 * i,0 + 25 * i));
			if(buttonChoice == 4)
			{
				StdDraw.filledCircle(sum.getReal(), sum.getImaginary(), 0.2 - 0.04 * i);
			}
			else if(buttonChoice == 3)
			{
				StdDraw.filledCircle(diff.getReal(), diff.getImaginary(), 0.2 - 0.04 * i);
			}
			else if(buttonChoice == 2)
			{
				StdDraw.filledCircle(product.getReal(), product.getImaginary(), 0.2 - 0.04 * i);
			}
			else if(buttonChoice == 1)
			{
				StdDraw.filledCircle(quotient.getReal(), quotient.getImaginary(), 0.2 - 0.04 * i);
			}
		}
	}
	
	/**
	 *  Vectors are drawn to A and B with addition and subtraction.  Angles for A and
	 *  B are swept out for multiplication and division.  The values of A and B, along 
	 *  with the value of the operation on A and B, are printed in the lower right of the GUI.
	 */
	public void drawVectorsAnglesAndInfo(int buttonChoice)
	{
		Font font = new Font("Arial", Font.BOLD, 18);
		StdDraw.setFont(font);
		Complex sum = redA.add(blueB);
		Complex diff = redA.subtract(blueB);
		Complex product = redA.multiply(blueB);
		Complex quotient = redA.divide(blueB);
		StdDraw.setPenColor(new Color(0,0,0));
		StdDraw.text(redA.getReal() - 0.4,redA.getImaginary() - 0.05,"A");
		StdDraw.text(blueB.getReal() - 0.4,blueB.getImaginary() - 0.05,"B");
		StdDraw.textLeft(11,-4.5,"A = " + redA);
		StdDraw.textLeft(11,-5.5,"B = " + blueB);
		if(buttonChoice == 4)
		{
			StdDraw.text(sum.getReal() - 0.63, sum.getImaginary() - 0.05, "A+B");
			StdDraw.textLeft(11,-6.5,"A+B = " + sum);
			StdDraw.setPenColor(new Color(0,0,255));
			StdDraw.line(redA.getReal(),redA.getImaginary(),redA.getReal()+blueB.getReal(),redA.getImaginary()+blueB.getImaginary());
		}
		else if(buttonChoice == 3)
		{
			StdDraw.text(diff.getReal() - 0.63, diff.getImaginary() - 0.05, "A-B");
			StdDraw.textLeft(11,-6.5,"A-B = " + diff);
			StdDraw.setPenColor(new Color(0,0,255));
			StdDraw.line(redA.getReal(),redA.getImaginary(),redA.getReal()-blueB.getReal(),redA.getImaginary()-blueB.getImaginary());
		}
		else if(buttonChoice == 2)
		{
			StdDraw.text(product.getReal() - 0.63, product.getImaginary() - 0.05, "A*B");
			StdDraw.textLeft(11,-6.5,"A*B = " + product);
			StdDraw.setPenColor(new Color(255,0,0));
			StdDraw.arc(0,0,Math.sqrt(Math.pow(redA.getReal(),2) + Math.pow(redA.getImaginary(),2)),0,180 / Math.PI * Math.atan2(redA.getImaginary(),redA.getReal()));
			StdDraw.setPenColor(new Color(0,0,255));
			StdDraw.arc(0,0,Math.sqrt(Math.pow(blueB.getReal(),2) + Math.pow(blueB.getImaginary(),2)),0,180 / Math.PI * Math.atan2(blueB.getImaginary(),blueB.getReal()));
			StdDraw.setPenColor(new Color(255,0,0));
			StdDraw.arc(0,0,Math.sqrt(Math.pow(product.getReal(),2) + Math.pow(product.getImaginary(),2)) + 0.1,0,180 / Math.PI * Math.atan2(redA.getImaginary(),redA.getReal()));
			StdDraw.setPenColor(new Color(0,0,255));
			StdDraw.arc(0,0,Math.sqrt(Math.pow(product.getReal(),2) + Math.pow(product.getImaginary(),2)),180 / Math.PI * Math.atan2(redA.getImaginary(),redA.getReal()),
						180 / Math.PI * Math.atan2(redA.getImaginary(),redA.getReal()) + 180 / Math.PI * Math.atan2(blueB.getImaginary(),blueB.getReal()));
		}
		else if(buttonChoice == 1)
		{
			StdDraw.text(quotient.getReal() - 0.63, quotient.getImaginary() - 0.05, "A/B");
			StdDraw.textLeft(11,-6.5,"A/B = " + quotient);
			StdDraw.setPenColor(new Color(255,0,0));
			StdDraw.arc(0,0,Math.sqrt(Math.pow(redA.getReal(),2) + Math.pow(redA.getImaginary(),2)),0,180 / Math.PI * Math.atan2(redA.getImaginary(),redA.getReal()));
			StdDraw.setPenColor(new Color(0,0,255));
			StdDraw.arc(0,0,Math.sqrt(Math.pow(blueB.getReal(),2) + Math.pow(blueB.getImaginary(),2)),0,180 / Math.PI * Math.atan2(blueB.getImaginary(),blueB.getReal()));
			StdDraw.setPenColor(new Color(255,0,0));
			StdDraw.arc(0,0,Math.sqrt(Math.pow(quotient.getReal(),2) + Math.pow(quotient.getImaginary(),2)) + 0.1,0,180 / Math.PI * Math.atan2(redA.getImaginary(),redA.getReal()));
			StdDraw.setPenColor(new Color(0,0,255));
			StdDraw.arc(0,0,Math.sqrt(Math.pow(quotient.getReal(),2) + Math.pow(quotient.getImaginary(),2)),
						180 / Math.PI * Math.atan2(redA.getImaginary(),redA.getReal()) - 180 / Math.PI * Math.atan2(blueB.getImaginary(),blueB.getReal()),
						180 / Math.PI * Math.atan2(redA.getImaginary(),redA.getReal()));
		}
	}
	
	/**
	 *  Draws the buttons representing the four operations, +, -, *, and /,
	 *  in the upper right hand corner of the GUI.  The user may click on
	 *  a button to select a particular operation.
	 */
	public int drawOperators(int buttonChoice)
	{
		double x = StdDraw.mouseX();
		double y = StdDraw.mouseY();
		if(x >= 14.1 && x <= 14.9 && StdDraw.isMousePressed() && !pointHasFocus)
		{
			if(y >= 3.1 && y <= 3.9)
			{
				buttonChoice = 1;
			}
			else if(y >= 4.1 && y <= 4.9)
			{
				buttonChoice = 2;
			}
			else if(y >= 5.1 && y <= 5.9)
			{
				buttonChoice = 3;
			}
			else if(y >= 6.1 && y <= 6.9)
			{
				buttonChoice = 4;
			}
		}
		for(int i = 1; i <= 4; i++)
		{
			if(i == buttonChoice)
			{
				StdDraw.setPenColor(new Color(255,0,0));
				StdDraw.filledRectangle(14.5,2.5 + i,0.5,0.5);
			}
			StdDraw.setPenColor(new Color(0,0,0));
			StdDraw.filledRectangle(14.5,2.5 + i,0.4,0.4);
			StdDraw.setPenColor(new Color(200,200,200));
			StdDraw.filledRectangle(14.5,2.5 + i,0.34,0.34);
		}
		Font font = new Font("Arial", Font.BOLD, 45);
		StdDraw.setFont(font);
		StdDraw.setPenColor(new Color(0,0,0));
		StdDraw.text(14.5,6.35,"+");
		StdDraw.text(14.5,5.44,"-");
		StdDraw.text(14.5,4.2,"*");
		StdDraw.text(14.5,3.36,"/");
		return buttonChoice;
	}
	
	/**
	 *  Reacts to the mouse being pressed and then dragged on the point A or
	 *  the point B.  Boolean values are set to indicate that a point has
	 *  focus, and to indicate which point has focus.
	 */
	public void reactToMousePressAndDragOnPoint(Complex number)
	{
		double x = StdDraw.mouseX();
		double y = StdDraw.mouseY();
		if(Math.sqrt(Math.pow(x - number.getReal(),2) + Math.pow(y - number.getImaginary(),2)) < 0.22)
		{
			if(StdDraw.isMousePressed() & !pointHasFocus)
			{
				if(number == redA)
				{
					redA.set(x,y);
					changeA = pointHasFocus = true;
					changeB = false;
				}
				else if(number == blueB)
				{
					blueB.set(x,y);
					changeB = pointHasFocus = true;
					changeA = false;
				}
			}
		}
		if(StdDraw.isMousePressed() && pointHasFocus)
		{
			if(changeA)
			{
				redA.set(x,y);
			}
			else if(changeB)
			{
				blueB.set(x,y);
			}
		}
		else
		{
			pointHasFocus = changeA = changeB = false;
		}
	}
} 
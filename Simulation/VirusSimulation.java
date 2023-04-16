/**
 * VirusSimulation.java
 * 
 * A program to simulate a number of people
 * moving around, with one starting out as
 * infected, and consequently infecting
 * anyone else the infected person comes in
 * contact with. The VirusSimulation class
 * is a client of the Person class.
 * 
 * @author Sanjay Chandrasekar
 * @version 1.0
 * @since 10/18/21
 */

public class VirusSimulation
{
	private Person[] actor;
	private int pauseMilli;
	
	/**
	 * VirusSimulation constructor. Parameters are number of
	 * Person objects to create, number of milliseconds to
	 * pause between each frame, radius of each person, and
	 * chance of infection upon collision. One random Person
	 * in the array of Person objects will start out as
	 * infected.
	 */
	public VirusSimulation(int n, int p, double r, double iC)
	{
		pauseMilli = p;
		actor = new Person[n];
		for (int i = 0; i < actor.length; i++)
		{
			actor[i] = new Person(r, iC);
		}
		
		actor[(int)(Math.random() * actor.length)].setInfectedStatus();
	}
	
	/**
	 * Main method in VirusSimulation class. First,
	 * command-line arguments are taken in and assigned
	 * to their corresponding variables. These variables
	 * include the number of Persons to display, the
	 * number of milliseconds to pause between each frame,
	 * the radius of the Persons, and the chance of
	 * infection after each collision between a healthy
	 * Person and infected Person. If any of these
	 * arguments aren't given or are of different type
	 * than they should be, then default values will be
	 * used or the exception will be handled (respectively).
	 * 
	 * A VirusSimulation object is constructed with the
	 * number of Persons, the number of milliseconds to
	 * pause between each frame, the radius of the Persons,
	 * and the chance of infection after each collision
	 * between a healthy Person and infected Person.
	 * The frame is then set up and the collisionLoop
	 * method is called to carry out the program.
	 */
	public static void main(String[] args)
	{
		int numberOfPersons = 200;
		int pause = 20;
		double radius = Constants.RADIUS;
		double infectChance = Constants.INFECT_CHANCE;
		
		if (args.length > 3)
		{
			try
			{
				infectChance = Double.parseDouble(args[3]);
			}
			catch(NumberFormatException e)
			{
				System.err.println("Sorry, but the third argument should be an double. " +
					"Please try again.");
				System.exit(3);
			}
		}

		if (args.length > 2)
		{
			try
			{
				radius = Double.parseDouble(args[2]);
			}
			catch(NumberFormatException e)
			{
				System.err.println("Sorry, but the third argument should be an double. " +
					"Please try again.");
				System.exit(2);
			}
		}
		
		if (args.length > 1)
		{
			try
			{
				pause = Integer.parseInt(args[1]);
			}
			catch(NumberFormatException e)
			{
				System.err.println("Sorry, but the second argument should be an integer. " +
					"Please try again.");
				System.exit(1);
			}
		}
		if (args.length > 0)
		{
			try
			{
				numberOfPersons = Integer.parseInt(args[0]);
			}
			catch(NumberFormatException e)
			{
				System.err.println("Sorry, but the first argument should be an integer. " +
					"Please try again.");
				System.exit(0);
			}
		}

		VirusSimulation run = new VirusSimulation(numberOfPersons, pause, radius, infectChance);
		run.setUpGraphics();
		run.collisionLoop();
	}
	
	/**
	 * Sets up the canvas which the program will be
	 * run on, using values from the Constants class.
	 */
	public void setUpGraphics()
	{
		StdDraw.setCanvasSize(Constants.BOARD_SIZE, Constants.BOARD_SIZE);
		StdDraw.setXscale(-Constants.BOARD_SCALE, Constants.BOARD_SCALE);
		StdDraw.setYscale(-Constants.BOARD_SCALE, Constants.BOARD_SCALE);
		StdDraw.enableDoubleBuffering();
	}
	
	/**
	 * A method to actually carry out the program using
	 * methods from the Person class. If two Persons
	 * have collided, then subsequent action is taken,
	 * using the collisionChange method in the Person class.
	 * 
	 * Also checks if each Person is infected, and for each
	 * infected Person, the days passed since that Person was
	 * infected is incremented. If the days passed since
	 * infected reaches 500, then the Person's status is
	 * set as recovered.
	 */
	public void collisionLoop()
	{
		while(true)
		{
			StdDraw.clear(StdDraw.BLACK);
			
			for (int i = 0; i < actor.length; i++)
			{
				for (int j = i + 1; j < actor.length; j++)
				{
					if (actor[j].collision(actor[i]))
					{
						actor[i].collisionChange(actor[j]);
					}
				}
			}
			for (int i = 0; i < actor.length; i++)
			{
				actor[i].changePosition();
				if(actor[i].getHealthStatus().equals("infected"))
				{
					actor[i].incrementDays();
					if (actor[i].getDaysPassed() >= 500)
						actor[i].setRecoveredStatus();

				}
				actor[i].draw();
			}
			
			StdDraw.show();
			StdDraw.pause(pauseMilli);
		}
	}

}
public class Simulation
{
	private Person[] actor;
	private int pauseMilli;
	
	public Simulation(int n, int p, double r)
	{
		pauseMilli = p;
		actor = new Person[n];
		for (int i = 0; i < actor.length; i++)
		{
			actor[i] = new Person(r);
		}
	}
	
	public static void main(String[] args)
	{
		int number = 200;
		int pause = 20;
		double radius = Constants.RADIUS;
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
				number = Integer.parseInt(args[0]);
			}
			catch(NumberFormatException e)
			{
				System.err.println("Sorry, but the first argument should be an integer. " +
					"Please try again.");
				System.exit(0);
			}
		}
		Simulation run = new Simulation(number, pause, radius);
		run.setUpGraphics();
		run.collisionLoop();
	}
	
	public void setUpGraphics()
	{
		StdDraw.setCanvasSize(Constants.BOARD_SIZE, Constants.BOARD_SIZE);
		StdDraw.setXscale(-Constants.BOARD_SCALE, Constants.BOARD_SCALE);
		StdDraw.setYscale(-Constants.BOARD_SCALE, Constants.BOARD_SCALE);
		StdDraw.enableDoubleBuffering();
	}
	
	public void collisionLoop()
	{
		while(true)
		{
			StdDraw.clear(StdDraw.LIGHT_GRAY);
			
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
				actor[i].draw();
			}
			
			StdDraw.show();
			StdDraw.pause(pauseMilli);
		}
	}

}
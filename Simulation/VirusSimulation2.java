import java.awt.Color;

public class VirusSimulation2
{
	private Person[] actor;
	private int pauseMilli;
	
	public VirusSimulation2(int n, int p, double r, double iC)
	{
		pauseMilli = p;
		actor = new Person[n];
		for (int i = 0; i < actor.length; i++)
		{
			actor[i] = new Person(r, iC);
		}
		
		actor[(int)(Math.random() * actor.length)].setInfectedStatus();
	}
	
	public static void main(String[] args)
	{
		int number = 200;
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
				number = Integer.parseInt(args[0]);
			}
			catch(NumberFormatException e)
			{
				System.err.println("Sorry, but the first argument should be an integer. " +
					"Please try again.");
				System.exit(0);
			}
		}
		VirusSimulation2 run = new VirusSimulation2(number, pause, radius, infectChance);
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
		int count = 0;
		Color randomColor = new Color((int)(100 * Math.random()), (int)(255 * Math.random()), (int)(255 * Math.random()));
		while(true)
		{
			StdDraw.clear(randomColor);
			
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

			if (count % 40 == 0)
				randomColor = new Color((int)(200 * Math.random()), (int)(255 * Math.random()), (int)(200 * Math.random()));

			count++;
		}
	}

}
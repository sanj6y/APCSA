public class WeightWatcher extends Weight
{
	private int tooLittle, tooMuch;
	
	public WeightWatcher(int w, int tL, int tM)
	{
		super(w);
		tooLittle = tL;
		tooMuch = tM;
	}
	
	public void increase(int more)
	{
		super.increase(more);
		if(getWeight() >= tooMuch)
		{
			System.out.println("Exercise today!");
		}
	}
	
	public void decrease(int less)
	{
		super.decrease(less);
		{
			if(getWeight() <= tooLittle)
			{
				System.out.println("Eat an extra snack!");
			}
		}
	}
}
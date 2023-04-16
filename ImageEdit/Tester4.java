public class Tester4
{
	public static void main(String [] args)
	{
		Tester4 run = new Tester4();
		run.trials();
	}
	
	public void trials ( )
	{
		trial1();
		trial2();
		trial3();
		trial4();
		trial5();
		trial6();
		trial7();
		trial8();
	}
	
	public void trial1 ( )
	{
		ImageEdit result1 = new ImageEdit("girlWithPearl.ppm", "result1.ppm");
		result1.saveToOutputFile(result1.rotate(result1.openFileAndRead(), 35));
	}
	
	public void trial2 ( )
	{
		ImageEdit result2 = new ImageEdit("girlWithPearl.ppm", "result2.ppm");
		result2.saveToOutputFile(result2.rotate(result2.openFileAndRead(), 70));
	}
	
	public void trial3 ( )
	{
		ImageEdit result3 = new ImageEdit("girlWithPearl.ppm", "result3.ppm");
		result3.saveToOutputFile(result3.rotate(result3.openFileAndRead(), 105));
	}
	
	public void trial4 ( )
	{
		ImageEdit result4 = new ImageEdit("girlWithPearl.ppm", "result4.ppm");
		result4.saveToOutputFile(result4.rotate(result4.openFileAndRead(), 140));
	}
	
	public void trial5 ( )
	{
		ImageEdit result5 = new ImageEdit("girlWithPearl.ppm", "result5.ppm");
		result5.saveToOutputFile(result5.rotate(result5.openFileAndRead(), 175));
	}
	
	public void trial6 ( )
	{
		ImageEdit result6 = new ImageEdit("girlWithPearl.ppm", "result6.ppm");
		result6.saveToOutputFile(result6.rotate(result6.openFileAndRead(), 210));
	}
	
	public void trial7 ( )
	{
		ImageEdit result7 = new ImageEdit("girlWithPearl.ppm", "result7.ppm");
		result7.saveToOutputFile(result7.rotate(result7.openFileAndRead(), 245));
	}
	
	public void trial8 ( )
	{
		ImageEdit result8 = new ImageEdit("girlWithPearl.ppm", "result8.ppm");
		result8.saveToOutputFile(result8.rotate(result8.openFileAndRead(), 280));
	}
}
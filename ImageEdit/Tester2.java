public class Tester2
{
	public static void main(String [] args)
	{
		Tester2 run = new Tester2();
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
		ImageEdit result1 = new ImageEdit("laFragua.ppm", "result1.ppm");
		result1.saveToOutputFile(result1.shiftRight(result1.openFileAndRead(), 100));
	}
	
	public void trial2 ( )
	{
		ImageEdit result2 = new ImageEdit("nathanChen.ppm", "result2.ppm");
		result2.saveToOutputFile(result2.shiftRight(result2.openFileAndRead(), 30));
	}
	
	public void trial3 ( )
	{
		ImageEdit result3 = new ImageEdit("laFragua.ppm", "result3.ppm");
		result3.saveToOutputFile(result3.shiftRight(result3.openFileAndRead(), 60));
	}
	
	public void trial4 ( )
	{
		ImageEdit result4 = new ImageEdit("chloeKim.ppm", "result4.ppm");
		result4.saveToOutputFile(result4.shiftRight(result4.openFileAndRead(), 85));
	}
	
	public void trial5 ( )
	{
		ImageEdit result5 = new ImageEdit("nathanChen.ppm", "result5.ppm");
		result5.saveToOutputFile(result5.zoomLowerRight(result5.openFileAndRead()));
	}
	
	public void trial6 ( )
	{
		ImageEdit result6 = new ImageEdit("mayThree.ppm", "result6.ppm");
		result6.saveToOutputFile(result6.zoomLowerRight(result6.openFileAndRead()));
	}
	
	public void trial7 ( )
	{
		ImageEdit result7 = new ImageEdit("juana.ppm", "result7.ppm");
		result7.saveToOutputFile(result7.zoomLowerRight(result7.openFileAndRead()));
	}
	
	public void trial8 ( )
	{
		ImageEdit result8 = new ImageEdit("chloeKim.ppm", "result8.ppm");
		result8.saveToOutputFile(result8.zoomLowerRight(result8.openFileAndRead()));
	}
}
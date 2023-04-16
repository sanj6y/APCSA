public class Tester3
{
	public static void main(String [] args)
	{
		Tester3 run = new Tester3();
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
		result1.saveToOutputFile(result1.tileAndMirror(result1.openFileAndRead()));
	}
	
	public void trial2 ( )
	{
		ImageEdit result2 = new ImageEdit("nathanChen.ppm", "result2.ppm");
		result2.saveToOutputFile(result2.tileAndMirror(result2.openFileAndRead()));
	}
	
	public void trial3 ( )
	{
		ImageEdit result3 = new ImageEdit("juana.ppm", "result3.ppm");
		result3.saveToOutputFile(result3.tileAndMirror(result3.openFileAndRead()));
	}
	
	public void trial4 ( )
	{
		ImageEdit result4 = new ImageEdit("chloeKim.ppm", "result4.ppm");
		result4.saveToOutputFile(result4.tileAndMirror(result4.openFileAndRead()));
	}
	
	public void trial5 ( )
	{
		ImageEdit result5 = new ImageEdit("juana.ppm", "result5.ppm");
		result5.saveToOutputFile(result5.zoomPatch(result5.openFileAndRead(), 50, 90, 10, 40));
	}
	
	public void trial6 ( )
	{
		ImageEdit result6 = new ImageEdit("juana.ppm", "result6.ppm");
		result6.saveToOutputFile(result6.zoomPatch(result6.openFileAndRead(), 0, 40, 60, 100));
	}
	
	public void trial7 ( )
	{
		ImageEdit result7 = new ImageEdit("laFragua.ppm", "result7.ppm");
		result7.saveToOutputFile(result7.zoomPatch(result7.openFileAndRead(), 10, 40, 18, 53));
	}
	
	public void trial8 ( )
	{
		ImageEdit result8 = new ImageEdit("laFragua.ppm", "result8.ppm");
		result8.saveToOutputFile(result8.zoomPatch(result8.openFileAndRead(), 75, 94, 25, 55));
	}
}
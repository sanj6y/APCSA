public class Tester1
{
	public static void main(String [] args)
	{
		Tester1 run = new Tester1();
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
		ImageEdit result1 = new ImageEdit("mayThree.ppm", "result1.ppm");
		result1.saveToOutputFile(result1.goToGrayScale(result1.flipAlongCentralHorizontalAxis(result1.flipAlongCentralVerticalAxis(result1.openFileAndRead()))));
	}
	
	public void trial2 ( )
	{
		ImageEdit result2 = new ImageEdit("girlWithPearl.ppm", "result2.ppm");
		result2.saveToOutputFile(result2.rotate90Clockwise(result2.rotate90Clockwise(result2.extremeContrast(result2.openFileAndRead()))));
	}
	
	public void trial3 ( )
	{
		ImageEdit result3 = new ImageEdit("girlWithPearl.ppm", "result3.ppm");
		result3.saveToOutputFile(result3.goToGrayScale(result3.rotate90Clockwise(result3.rotate90Clockwise(result3.rotate90Clockwise(result3.openFileAndRead())))));
	}
	
	public void trial4 ( )
	{
		ImageEdit green = new ImageEdit("deruiter.ppm", "result4.ppm");
		ImageEdit other = new ImageEdit("obama.ppm");
		green.saveToOutputFile(green.greenScreen(green.openFileAndRead(), other.openFileAndRead()));
	}
	
	public void trial5 ( )
	{
		ImageEdit result5 = new ImageEdit("laFragua.ppm", "result5.ppm");
		result5.saveToOutputFile(result5.pixelate(result5.rotate90Clockwise(result5.flipAlongCentralHorizontalAxis(result5.openFileAndRead()))));
	}
	
	public void trial6 ( )
	{
		ImageEdit result6 = new ImageEdit("nathanChen.ppm", "result6.ppm");
		result6.saveToOutputFile(result6.rotate90Clockwise(result6.flipAlongCentralVerticalAxis(result6.flipAlongCentralHorizontalAxis(result6.openFileAndRead()))));
	}
	
	public void trial7 ( )
	{
		ImageEdit result7 = new ImageEdit("chloeKim.ppm", "result7.ppm");
		result7.saveToOutputFile(result7.extremeContrast(result7.goToNegative(result7.pixelate(result7.openFileAndRead()))));
	}
	
	public void trial8 ( )
	{
		ImageEdit result8 = new ImageEdit("juana.ppm", "result8.ppm");
		result8.saveToOutputFile(result8.flipAlongCentralVerticalAxis(result8.goToNegative(result8.rotate90Clockwise(result8.openFileAndRead()))));
	}
}
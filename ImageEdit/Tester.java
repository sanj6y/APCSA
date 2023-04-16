public class Tester
{
	public static void main(String [] args)
	{
		Tester run = new Tester();
		run.trials();
	}
	
	public void trials ( )
	{
		trial1();
		trial2();
		trial3();
		trial4();
		trial5();
	}
	
	public void trial1 ( )
	{
		ImageEdit result1 = new ImageEdit("mayThree.ppm", "result1.ppm");
		result1.saveToOutputFile(result1.goToGrayScale(result1.flipAlongCentralHorizontalAxis(result1.flipAlongCentralVerticalAxis(result1.openFileAndRead()))));
	}
	
	public void trial2 ( )
	{
		ImageEdit result2 = new ImageEdit("laFragua.ppm", "result2.ppm");
		result2.saveToOutputFile(result2.pixelate(result2.rotate90Clockwise(result2.flipAlongCentralHorizontalAxis(result2.openFileAndRead()))));
	}
	
	public void trial3 ( )
	{
		ImageEdit result3 = new ImageEdit("juana.ppm", "result3.ppm");
		result3.saveToOutputFile(result3.flipAlongCentralVerticalAxis(result3.goToNegative(result3.rotate90Clockwise(result3.openFileAndRead()))));
	}
	
	public void trial4 ( )
	{
		ImageEdit result4 = new ImageEdit("girlWithPearl.ppm", "result4.ppm");
		result4.saveToOutputFile(result4.rotate90Clockwise(result4.rotate90Clockwise(result4.extremeContrast(result4.openFileAndRead()))));
	}
	
	public void trial5 ( )
	{
		ImageEdit green = new ImageEdit("deruiter.ppm", "result5.ppm");
		ImageEdit other = new ImageEdit("obama.ppm");
		green.saveToOutputFile(green.greenScreen(green.openFileAndRead(), other.openFileAndRead()));
	}
}
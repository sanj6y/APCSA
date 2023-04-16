public class ComplexNumber {

	private double a; 
	private double b;
	
	/**
	 * Creates a new ComplexNumber with both real and imaginary components
	 * @param a the real component of the complex number
	 * @param b the imaginary component of the complex number
	 */
	public ComplexNumber(double a, double b){
		this.a = a;
		this.b = b;		
	}
	
	/**
	 * The "copy constructor"
	 * Creates a new ComplexNumber from an existing ComplexNumber
	 * @param c a ComplexNumber
	 */
	public ComplexNumber(ComplexNumber c){
		a = c.getReal();
		b = c.getImaginary();
	}
	
	/**
	* The default constructor
	**/
	public ComplexNumber() {
		this.a = 0;
		this.b = 0;
	}
	/**
	 * An "accessor" method
	 * Returns the real component of this ComplexNumber
	 * @return a the private real component of this ComplexNumber 
	 */
	public double getReal(){
		return a;
	}
	
	/**
	 * An "accessor" method
	 * Returns the imaginary component of this ComplexNumber
	 * @return b the private imaginary component of this ComplexNumber 
	 */
	public double getImaginary(){
		return b;
	}

	/**
	 * An instance method to add two complex numbers
	 * @param add2 the complex number added to the instance
	 * @return result the result of the addition
	 */
	public ComplexNumber add(ComplexNumber add2) {
		double real2 = add2.getReal();
		double img2 = add2.getImaginary();
		ComplexNumber result  = new ComplexNumber(this.a+real2, this.b+img2);
		return result;
	}

	/**
	 * A static method that adds two complex numbers
	 * @param add1 first complex number
	 * @param add2 second complex number
	 * @return result the result of the addition
	 */
	public static ComplexNumber add(ComplexNumber add1, ComplexNumber add2) {
		double real1 = add1.getReal();
		double img1 = add1.getImaginary();
		double real2 = add2.getReal();
		double img2 = add2.getImaginary();
		ComplexNumber result  = new ComplexNumber(real1+real2, img1+img2);
		return result;
	}

	/**
	 * An instance method to multiply two complex numbers
	 * @param multiply2 the complex number multiplied by the instance
	 * @return result the product
	 */
	public ComplexNumber multiply(ComplexNumber multiply2) {
		double f = this.a*multiply2.getReal();
		double o = this.a*multiply2.getImaginary();
		double i = this.b*multiply2.getReal();
		double l = this.b*multiply2.getImaginary()*-1;

		double real = f +l;
		double imaginary = o +i;

		ComplexNumber result = new ComplexNumber(real, imaginary);
		return result;
	}


	/**
	 * An instance method that raises an instance to a power
	 * @param exponent the exponent 
	 * @return result the result of the multiplication
	 */
	public ComplexNumber power(int exponent) {
		ComplexNumber result= new ComplexNumber(this);
		if (exponent == 0) {
			return new ComplexNumber(1, 0);
		} else if (exponent < 0) {
			throw new IllegalArgumentException();
		}

		for (int i = 1; i < exponent; i++) {
			result = result.multiply(this);
		}

		return result;
	}

	/**
	 * A static method that raises a complex number to a power
	 * @param input the complex number
	 * @param exponent the power the complex number will be raised to
	 * @return result the result of the multiplication
	 */
	public static ComplexNumber power(ComplexNumber input, int exponent) {
		ComplexNumber result= new ComplexNumber(input);
		
		if (exponent == 0) {
			return new ComplexNumber(1, 0);
		} else if (exponent < 0) {
			throw new IllegalArgumentException();
		}

		for (int i = 1; i < exponent; i++) {
			result = result.multiply(input);
		}

		return result;
	}

	/**
	 * An instance method that returns the magnitude of a complex number 
	 * @return magnitude magnitude (double)
	 */
	public double magnitude() {
		return (Math.sqrt(a * a + b * b));
	}

	public static void leftGraph(ComplexNumber cons, double x1, double x2, double y1, double y2) {
		double x = scale(cons.getReal(), x1, x2, 0, 400);
		double y = scale(cons.getImaginary(), y1, y2, 0, 300);
		StdDraw.point(x, y);
		
	}

	public static void rightGraph(ComplexNumber cons, double x1, double x2, double y1, double y2) {
		double x = scale(cons.getReal(), x1, x2, 400, 800);
		double y = scale(cons.getImaginary(), y1, y2, 0, 300);
		StdDraw.point(x, y);
		
	}

	public static double scale(final double valueIn, final double baseMin, final double baseMax, final double limitMin, final double limitMax) {
        return ((limitMax - limitMin) * (valueIn - baseMin) / (baseMax - baseMin)) + limitMin;
    }
}

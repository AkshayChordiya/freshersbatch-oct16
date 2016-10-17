
/**
	Complex Number Program
	@author Akshay Chordiya
*/
public class Complex {
	
	private double real;
	private double imaginary;
	
	/** Default Constructor **/
	public Complex() {
		real = 0.0;
		imaginary = 0.0;
	}
	
	public Complex(double real, double imaginary) {
		this.real = real;
		this.imaginary = imaginary;
	}
	
	public String toString() {
		return real + " + (" + imaginary + ")i";
	}
	
	/** GETTERS and SETTERS **/
	
	public void add(Complex two) {
		this.real += two.real; 
		this.imaginary += two.imaginary; 
	}
	
	public void subtract(Complex two) {
		this.real -= two.real; 
		this.imaginary -= two.imaginary; 
	}
	
	public void multiply(Complex two) {
		this.real *= two.real; 
		this.imaginary *= two.imaginary; 
	}

	/**
		Starting point of the program. The Main function.
	*/
    public static void main(String[] args) {
		Complex complex = new Complex(2, 4);
		System.out.println(complex);
		complex.add(new Complex(2, 3));
		System.out.println(complex);
		complex.subtract(new Complex(2, 8));
		System.out.println(complex);
		complex.multiply(new Complex(1, 2));
		System.out.println(complex);
    }

}
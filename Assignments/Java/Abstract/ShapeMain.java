
/**
	Shape Abstract Program
	@author Akshay Chordiya
*/
public class ShapeMain {

	/**
		Starting point of the program. The Main function.
	*/
    public static void main(String[] args) {
		ShapeMain shape = new ShapeMain();
		shape.main();
    }
	
	public void main() {
		Shape s[] = new Shape[6];
		s[0] = new Point();
		s[1] = new Line();
		s[2] = new Circle();
		s[3] = new Rectangle();
		s[4] = new Cylinder();
		s[5] = new Cube();
		drawAllShapes(s);
	}
	
	public void drawAllShapes(Shape shapes[]) {
		for (Shape shape: shapes) {
			shape.draw();
		}
	}
	
	public abstract class Shape {
		public abstract void draw();
	}
	
	public class Point extends Shape {
		public void draw() {
			System.out.println("Drawing Point");
		}
	} 
	
	public class Line extends Shape {
		public void draw() {
			System.out.println("Drawing Line");
		}
	} 
	
	public class Circle extends Point {
		public void draw() {
			System.out.println("Drawing Circle");
		}
	} 
	
	public class Cylinder extends Point {
		public void draw() {
			System.out.println("Drawing Cylinder");
		}
	} 
	
	public class Rectangle extends Line {
		public void draw() {
			System.out.println("Drawing Rectangle");
		}
	} 
	
	public class Cube extends Line {
		public void draw() {
			System.out.println("Drawing Cube");
		}
	} 

}
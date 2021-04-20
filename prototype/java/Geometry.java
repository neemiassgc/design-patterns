abstract class Shape implements Cloneable {

	private int x, y;
	private String color;

	Shape() {
		this(140, 210, "Red");
	}

	Shape(int x, int y, String color) {
		this.x = x;
		this.y = y;
		this.color = color;
	}

	protected Shape(Cloneable prototype) {
		Shape shape = (Shape)prototype;
		this.x = shape.x;
		this.y = shape.y;
		this.color = shape.color;
	}

	@Override
	public boolean equals(Object another) {
		if (another == null || !(another instanceof Shape)) return false;

		Shape shape = (Shape)another;

		return this.x == shape.x && this.y == shape.y && this.color.equals(shape.color);
	}

}

class Rectangle extends Shape {

	private int width, height;
	private String color;

	Rectangle(int width, int height) {
		super();
		this.width = width;
		this.height = height;
	}

	private Rectangle(Cloneable prototype) {
		super(prototype);

		Rectangle rec = (Rectangle)prototype;
		this.width = rec.width;
		this.height = rec.height;
	}

	@Override
	public Shape clone() {
		return new Rectangle(this);
	}

	@Override
	public boolean equals(Object another) {
		if (another == null || !(another instanceof Shape)) return false;

		Rectangle rec = (Rectangle)another;

		return super.equals(another) && this.width == rec.width && this.height == rec.height;
	}
}

final class Geometry {

	public static void main(String[] args) {
		Rectangle rec = new Rectangle(10, 30);
		Rectangle rec2 = (Rectangle) rec.clone();

		System.out.printf("Are the same? %s\n", rec.equals(rec2));

	}
}
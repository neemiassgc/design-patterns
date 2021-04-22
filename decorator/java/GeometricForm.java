interface Shape {

	void draw();
}

final class Circle implements Shape {

	@Override
	public void draw() {
		System.out.println("Draw circle");
	}
}

final class Ractangle implements Shape {

	@Override
	public void draw() {
		System.out.println("Draw rectangle");
	}
}

abstract class ShapeDecorator implements Shape {

	private Shape shape;

	protected ShapeDecorator(Shape shape) {
		this.shape = shape;
	}

	@Override
	public void draw() {
		shape.draw();
	}
}

final class CircleDecorator extends ShapeDecorator {

	CircleDecorator(Shape shape) {
		super(shape);
	}

	@Override
	public void draw() {
		super.draw();
		this.addRedBorder();
	}

	private void addRedBorder() {
		System.out.println("Add border red to circle");
	}
}

final class RectangleDecorator extends ShapeDecorator {

	RectangleDecorator(Shape shape) {
		super(shape);
	}

	@Override
	public void draw() {
		super.draw();
		this.addRedBorder();
	}

	private void addRedBorder() {
		System.out.println("Add border red to rectangle");
	}
}

final class GeometricForm {

	public static void main(String[] args) {
		Shape shape = new Circle();
		ShapeDecorator shapeDecorator = new CircleDecorator(shape);

		shapeDecorator.draw();

		shape = new Ractangle();
		shapeDecorator = new CircleDecorator(shape);

		shapeDecorator.draw();
	}
}
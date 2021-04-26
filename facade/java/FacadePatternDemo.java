interface Shape {

	void draw();
}

final class Circle implements Shape {

	@Override
	public void draw() {
		System.out.println("Circle::draw");
	}
}

final class Rectangle implements Shape {

	@Override
	public void draw() {
		System.out.println("Rectangle::draw");
	}
}

final class Square implements Shape {

	@Override
	public void draw() {
		System.out.println("Square::draw");
	}
}

final class ShapeFacade {

	private final Shape circle, square, rectangle;

	public ShapeFacade() {
		this.circle = new Circle();
		this.square = new Square();
		this.rectangle = new Rectangle();
	}

	public void drawCircle() {
		circle.draw();
	}

	public void drawRectangle() {
		rectangle.draw();
	}

	public void drawSquare() {
		square.draw();
	}
}

final class FacadePatternDemo {

	public static void main(String[] args) {
		ShapeFacade shapeFacade = new ShapeFacade();
		shapeFacade.drawSquare();
		shapeFacade.drawCircle();
		shapeFacade.drawRectangle();
	}
}
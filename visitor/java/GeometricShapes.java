interface Graphic {

	void accept(Visitor v);
}

interface Visitor {

	void visitShape(Shape shape);

	void visitDot(Dot dot);

	void visitRectangle(Rectangle rectangle);

	void visitCircle(Circle circle);
}

final class ConcreteVisitor implements Visitor {

	@Override
	public void visitShape(Shape shape) {
		System.out.println("Shape visited");
	}

	@Override
	public void visitDot(Dot dot) {
		System.out.println("Dot visited");
	}

	@Override
	public void visitRectangle(Rectangle rectangle) {
		System.out.println("Rectangle visited");
	}

	@Override
	public void visitCircle(Circle circle) {
		System.out.println("Circle visited");
	}
}

class Shape implements Graphic {

	@Override
	public void accept(Visitor v) {
		v.visitShape(this);
	}
}

class Dot extends Shape {

	@Override
	public void accept(Visitor v) {
		v.visitDot(this);
	}
}

class Rectangle extends Dot {

	@Override
	public void accept(Visitor v) {
		v.visitRectangle(this);
	}
}

final class Circle extends Shape {

	@Override
	public void accept(Visitor v) {
		v.visitCircle(this);
	}
}

public final class GeometricShapes {

	public static void main(String[] args) {
		Visitor visitor = new ConcreteVisitor();
		Graphic[] graphics = new Graphic[4];
		graphics[0] = new Shape();
		graphics[1] = new Dot();
		graphics[2] = new Rectangle();
		graphics[3] = new Circle();

		for (Graphic g : graphics) g.accept(visitor);
	}
}
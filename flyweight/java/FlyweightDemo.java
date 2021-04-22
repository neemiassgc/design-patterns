import java.util.HashMap;
import java.util.Map;
import java.util.Random;

interface Shape {

	void draw();
}

final class Circle implements Shape {

	private int x, y, radius;
	private String color;

	public Circle(String color) {
		this.color = color;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	@Override
	public void draw() {
		System.out.printf("[Draw circle] x: %d, y: %d, radius: %d, color: %s\n",
			this.x, this.y, this.radius, this.color);
	}
}

final class CircleFactory {

	private static final Map<String, Shape> flyweights = new HashMap<>();

	private CircleFactory() {}

	public static Shape getCircle(String color) {
		Shape circle = flyweights.get(color);

		if (circle == null) {
			circle = new Circle(color);
			flyweights.put(color, circle);
		}

		return circle;
	}
}

final class FlyweightDemo {

	public static void main(String[] args) {
		String[] colors = {"Red", "Green", "Blue", "White", "Black"};
		Random ran = new Random();

		ran.ints(20, 0, colors.length).forEach(n -> {
			Circle circle = (Circle)CircleFactory.getCircle(colors[n]);
			circle.setX(ran.nextInt(100));
			circle.setY(ran.nextInt(100));
			circle.setRadius(100);
			circle.draw();
		});
	}
}
interface Shape {

	fun draw(): Unit
}

class Circle : Shape {

	override fun draw(): Unit {
		println("Draw circle");
	}
}

class Rectangle : Shape {

	override fun draw(): Unit {
		println("Draw rectangle");
	}
}

abstract class AbstractDecorator(private val shape: Shape) : Shape {

	override fun draw(): Unit {
		shape.draw()
	}
}

class CircleDecorator : AbstractDecorator {

	constructor(shape: Shape) : super(shape)

	override fun draw(): Unit {
		super.draw()
		this.addRedBorder()
	}

	private fun addRedBorder(): Unit {
		println("Add red border to circle");
	}
}

class RectangleDecorator : AbstractDecorator {

	constructor(shape: Shape) : super(shape)

	override fun draw(): Unit {
		super.draw()
		this.addRedBorder()
	}

	private fun addRedBorder(): Unit {
		println("Add red border to circle");
	}
}

fun main(): Unit {
	val circle: Circle = Circle()
	val rectangle: Rectangle = Rectangle()

	// Decorates the circle
	var decorator: AbstractDecorator = CircleDecorator(circle)

	decorator.draw()

	// Decorates the rectangle
	decorator = RectangleDecorator(rectangle)

	decorator.draw()
}
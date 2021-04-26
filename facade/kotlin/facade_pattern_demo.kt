interface Shape {

	fun draw(): Unit
}

class Circle : Shape {

	override fun draw(): Unit {
		println("Circle::draw")
	}
}

class Rectangle : Shape {

	override fun draw(): Unit {
		println("Rectangle::draw")
	}
}

class Square : Shape {

	override fun draw(): Unit {
		println("Square::draw")
	}
}

class FacadePattern(
	private val circle: Shape,
	private val square: Shape,
	private val rectangle: Shape,
) {

	constructor() : this(Circle(), Square(), Rectangle())

	fun drawCircle(): Unit {
		this.circle.draw();
	}

	fun drawRectangle(): Unit {
		this.rectangle.draw();
	}

	fun drawSquare(): Unit {
		this.square.draw();
	}
}

fun main(): Unit {
	val fp: FacadePattern = FacadePattern()
	fp.drawCircle();
	fp.drawRectangle();
	fp.drawSquare();
}

interface Prototype {

	fun clone(): Prototype
}

abstract class Shape(
	internal var x: Int,
	internal var y: Int,
	internal var color: String
) : Prototype {
	internal constructor() : this(120, 144, "red")

	protected constructor(prototype: Prototype) : this() {
		val shape: Shape = prototype as Shape;
		this.x = shape.x;
		this.y = shape.y;
		this.color = shape.color;
	}

	override abstract fun clone(): Prototype

	override open fun equals(other: Any?): Boolean {
		if (other == null || other !is Shape) return false

		return this.x == other.x && this.y == other.y
			&& this.color.equals(color)
	}
}

class Rectangle : Shape {

	var width: Int
		private set
	var height: Int
		private set

	internal constructor(width: Int, height: Int) : super() {
		this.width = width
		this.height = height
	}

	private constructor(prototype: Prototype) : super(prototype) {
		val rec: Rectangle = prototype as Rectangle
		this.width = rec.width
		this.height = rec.height
	}

	override fun clone(): Prototype = Rectangle(this)

	override fun equals(other: Any?): Boolean {
		if (other == null || other !is Rectangle) return false

		return super.equals(other) && this.width == other.width
			&& this.height == other.height
	}
}

class Circle : Shape {

	var radius: Int
		private set

	internal constructor(radius: Int) : super() {
		this.radius = radius
	}

	private constructor(prototype: Prototype) : super(prototype) {
		val circle: Circle = prototype as Circle
		this.radius = circle.radius
	}

	override fun clone(): Prototype = Circle(this)

	override fun equals(other: Any?): Boolean {
		if (other == null || other !is Circle) return false

		return super.equals(other) && this.radius == other.radius
	}
}

fun main(): Unit {
	val circle: Circle = Circle(8)
	val circleClone: Circle = circle.clone() as Circle

	val rec: Rectangle = Rectangle(15, 18)
	val recClone: Rectangle = rec.clone() as Rectangle

	println("Are the rectangles same? ${rec.equals(recClone)}")
	println("Are the circles same? ${circle.equals(circleClone)}")
}
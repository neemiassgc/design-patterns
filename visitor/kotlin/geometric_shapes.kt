interface Visitor {

	fun visitShape(shape: Shape): Unit

	fun visitDot(dot: Dot): Unit

	fun visitRectangle(rectangle: Rectangle): Unit

	fun visitCircle(circle: Circle): Unit
}

interface Graphic {

	fun accept(v: Visitor): Unit
}

open class Shape() : Graphic {

	override fun accept(v: Visitor): Unit {
		v.visitShape(this)
	}
}

open class Dot() : Shape() {

	override fun accept(v: Visitor): Unit {
		v.visitDot(this)
	}
}

class Rectangle() : Dot() {

	override fun accept(v: Visitor): Unit {
		v.visitRectangle(this)
	}
}

class Circle() : Graphic {

	override fun accept(v: Visitor): Unit {
		v.visitCircle(this)
	}
}

class ConcreteVisitor() : Visitor {

	override fun visitShape(shape: Shape): Unit {
		println("Shape visited")
	}

	override fun visitDot(dot: Dot): Unit {
		println("Dot visited")
	}

	override fun visitRectangle(rectangle: Rectangle): Unit {
		println("Rectangle visited")
	}

	override fun visitCircle(circle: Circle): Unit {
		println("Circle visited")
	}
}

fun main(): Unit {
	val visitor: Visitor = ConcreteVisitor()
	val graphics: Array<Graphic?> = Array(4) { null }
	graphics[0] = Shape()
	graphics[1] = Dot()
	graphics[2] = Rectangle()
	graphics[3] = Circle()

	graphics.forEach { it?.accept(visitor) }
}
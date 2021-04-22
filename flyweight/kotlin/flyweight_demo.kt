import kotlin.random.*

interface Shape {

	fun draw(): Unit
}

class Circle(private val color: String) : Shape {

	var x: Int
	var y: Int
	var radius: Int

	init {
		this.x = 0
		this.y = 0
		this.radius = 0
	}

	override fun draw(): Unit {
		println("[Draw circle] x: ${this.x}, y: ${this.y}, radius: ${this.radius}, color: ${this.color}\n")
	}
}

class CircleFactory {

	companion object {
		private val flyweights: MutableMap<String, Shape> = mutableMapOf()

		fun getCircle(color: String): Shape =
			flyweights.getOrPut(color) { Circle(color) }
	}

	private constructor() {}
}

fun main(): Unit {
	val colors: Array<String> = arrayOf("Red", "Green", "Blue", "White", "Black")

	for(i in 1..20) {
		val circle: Circle = CircleFactory.getCircle(colors.random()) as Circle;
		circle.x = Random.nextInt(100)
		circle.y = Random.nextInt(100)
		circle.radius = 100
		circle.draw()
	}
}
interface Builder {

	fun reset(): Unit

	fun setSeats(number: Int): Builder

	fun setEngine(engine: String): Builder

	fun setTripComputer(): Builder

	fun setGPS(): Builder
}

class Car(
	var seats: Int = 4,
	var engine: String = "V8",
	var tripComputer: Boolean = false,
	var gps: Boolean = false
)

class CarBuilder(private var car: Car = Car()) : Builder {

	override fun reset(): Unit {
		car = Car()
	}

	override fun setSeats(number: Int): CarBuilder {
		car.seats = number
		return this
	}

	override fun setEngine(engine: String): CarBuilder {
		car.engine = engine
		return this
	}

	override fun setTripComputer(): CarBuilder {
		car.tripComputer = true
		return this
	}

	override fun setGPS(): CarBuilder {
		car.gps = true
		return this
	}

	fun build(): Car {
		val car: Car = this.car
		this.reset()
		return car
	}
}

fun main(): Unit {
	val car: Car = CarBuilder()
		.setTripComputer()
		.setGPS()
		.build()

	println("sets: ${car.seats}, engine: ${car.engine}, tripComputer: ${car.tripComputer}, gps: ${car.gps}")
}
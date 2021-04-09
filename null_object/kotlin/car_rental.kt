interface Veicle {

	fun start(): Unit {
		System.out.println("Starting veicle");
	}

	fun stop(): Unit {
		System.out.println("Stoping veicle");
	}

	fun accelerate(): Unit {
		System.out.println("Accelerating veicle");
	}

	fun park(): Unit {
		System.out.println("Parking veicle");
	}
}

open class Car(
	val brand: String,
	val model: String,
	val color: String
) : Veicle

class NullCar : Car("Audi", "A8", "Grey")


class CarRental {

	fun rental(): Car = NullCar()
}

fun main(): Unit {
	val carRental: CarRental = CarRental()
	val myCar: Car = carRental.rental()

	println("${myCar.brand} ${myCar.model} ${myCar.color}")

	myCar.accelerate()
}
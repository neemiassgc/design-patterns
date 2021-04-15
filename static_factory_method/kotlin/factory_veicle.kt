interface Veicle {

	fun turnOn(): Unit;

	fun accelerate(): Unit;

	fun turnOff(): Unit;
}

class Car : Veicle {

	override fun turnOn(): Unit {
		println("Turning on the car");
	}

	override fun accelerate(): Unit {
		println("Accelerating the car");
	}

	override fun turnOff(): Unit {
		println("Turning off the car");
	}
}

class Helicopter : Veicle {

	override fun turnOn(): Unit {
		println("Turning on the helicopter");
	}

	override fun accelerate(): Unit {
		println("Accelerating the helicopter");
	}

	override fun turnOff(): Unit {
		println("Turning off the helicopter");
	}

}

class FactoryVeicle private constructor() {

	companion object Factory {
		fun getCar(): Veicle = Car();

		fun getHelicopter(): Veicle = Helicopter();
	}
}

fun main(): Unit {
	var veicle: Veicle = FactoryVeicle.getCar();
	veicle.turnOn();
	veicle.accelerate();
	veicle.turnOff();

	veicle = FactoryVeicle.getHelicopter();

	veicle.turnOn();
	veicle.accelerate();
	veicle.turnOff();
}
interface Veicle {

	void turnOn();

	void accelerate();

	void turnOff();
}

final class Car implements Veicle {

	public void turnOn() {
		System.out.println("Turning on the car");
	}

	public void accelerate() {
		System.out.println("Accelerating the car");
	}

	public void turnOff() {
		System.out.println("Turning off the car");
	}
}

final class Helicopter implements Veicle {

	public void turnOn() {
		System.out.println("Turning on the helicopter");
	}

	public void accelerate() {
		System.out.println("Accelerating the helicopter");
	}

	public void turnOff() {
		System.out.println("Turning off the helicopter");
	}

}

final class FactoryVeicle {

	private FactoryVeicle() {}

	public static Veicle getCar() {
		return new Car();
	}

	public static Veicle getHelicopter() {
		return new Helicopter();
	}
}


final class FactoryVeicleDemo {

	public static void main(String[] args) {
		Veicle car = FactoryVeicle.getCar();
		car.turnOn();
		car.accelerate();
		car.turnOff();
	}
}
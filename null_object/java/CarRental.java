interface Veicle {

	default void start() {
		System.out.println("Starting veicle");
	}

	default void stop() {
		System.out.println("Stoping veicle");
	}

	default void accelerate() {
		System.out.println("Accelerating veicle");
	}

	default void park() {
		System.out.println("Parking veicle");
	}
}


class Car implements Veicle {

	String color;
	String model;
	String brand;

	Car(String color, String model, String brand) {
		this.color = color;
		this.model = model;
		this.brand = brand;
	}

	public String getColor() {
		return color;
	}

	public String getModel() {
		return model;
	}

	public String getBrand() {
		return brand;
	}
}

final class NullCar extends Car {

	public NullCar() {
		super("Black", "A8", "Audi");
	}

	@Override
	public String getColor() {
		return super.getColor();
	}

	@Override
	public String getModel() {
		return super.getModel();
	}

	@Override
	public String getBrand() {
		return super.getBrand();
	}
}

final class CarRental {

	Car rental() {
		return new NullCar();
	}


	public static void main(String[] args) {
		final Car car = new CarRental().rental();
		System.out.printf("%s %s %s\n", car.getBrand(), car.getModel(), car.getColor());
		car.start();
		car.park();
	}
}
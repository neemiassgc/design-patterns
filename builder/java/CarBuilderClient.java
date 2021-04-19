interface Builder {

	void reset();

	Builder setSeats(int seats);

	Builder setEngine(String engine);

	Builder setTripComputer();

	Builder setGPS();
}

final class Car {

	private int seats;
	private String engine;
	private boolean tripComputer;
	private boolean gps;

	Car() {
		this.seats = 4;
		this.engine = "V8";
		this.tripComputer = this.gps = false;
	}

	public int getSeats() {
		return this.seats;
	}

	public String getEngine() {
		return this.engine;
	}

	public boolean hasTripComputer() {
		return this.tripComputer;
	}

	public boolean hasGps() {
		return this.gps;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	public void setEngine(String engine) {
		this.engine = engine;
	}

	public void setTripComputer(boolean tripComputer) {
		this.tripComputer = tripComputer;
	}

	public void setGps(boolean gps) {
		this.gps = gps;
	}
}

final class CarBuilder implements Builder {

	private Car car;

	CarBuilder() {
		reset();
	}

	@Override
	public void reset() {
		this.car = new Car();
	}

	@Override
	public CarBuilder setSeats(int number) {
		this.car.setSeats(number);
		return this;
	}

	@Override
	public CarBuilder setEngine(String engine) {
		this.car.setEngine(engine);
		return this;
	}

	@Override
	public CarBuilder setTripComputer() {
		this.car.setTripComputer(true);
		return this;
	}

	@Override
	public CarBuilder setGPS() {
		this.car.setGps(true);
		return this;
	}

	public Car build() {
		Car car = this.car;
		this.reset();
		return car;
	}
}

final class CarBuilderClient {

	public static void main(String[] args) {
		Car car = new CarBuilder()
			.setTripComputer()
			.setGPS()
			.build();

		System.out.printf(
			"sets: %d, engine: %s, tripComputer: %s, gps: %s\n",
			car.getSeats(), car.getEngine(),
			car.hasTripComputer(), car.hasGps()
		);
	}
}
import java.time.temporal.ChronoUnit;

interface Veicle {}

interface ValueCalculation {

	double calculate(long period, Veicle veicle);
}

final class DailyCalculation implements ValueCalculation {

	private final double dailyValue;

	public DailyCalculation(double dailyValue) {
		this.dailyValue = dailyValue;
	}

	@Override
	public double calculate(long period, Veicle veicle) {
		return dailyValue * Math.ceil(period / ChronoUnit.HOURS.getDuration().toSeconds());
	}
}

final class ParkingBill {

	private ValueCalculation calculation;
	private Veicle veicle;
	private long start, end;

	public ParkingBill(ValueCalculation calculation, Veicle veicle, long start, long end) {
		this.calculation = calculation;
		this.veicle = veicle;
		this.start = start;
		this.end = end;
	}

	public double valueBill() {
		return calculation.calculate(start - end, veicle);
	}

	public void setCalculation(ValueCalculation calculation) {
		this.calculation = calculation;
	}


	public static void main(String[] args) {
		Veicle car = new Veicle() { };

		ValueCalculation dailyCalculation = new DailyCalculation(34.0D);
		ParkingBill parkingBill = new ParkingBill(dailyCalculation, car, 3143894L, 2349017348L);
		parkingBill.setCalculation(dailyCalculation);

		double computedValue = parkingBill.valueBill();

		System.out.println(computedValue);
	}
}
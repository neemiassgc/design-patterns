interface Transport {

	void deliver();
}

final class SeaTransport implements Transport {

	@Override
	public void deliver() {
		System.out.println("Transport by sea is delivering");
	}
}

final class RoadTransport implements Transport {

	@Override
	public void deliver() {
		System.out.println("Transport by road is delivering");
	}
}

abstract class Logistic {

	final void plainDeliver() {
		createTransport().deliver();
	}

	abstract Transport createTransport();
}

final class SeaLogistic extends Logistic {

	@Override
	public Transport createTransport() {
		return new SeaTransport();
	}
}

final class RoadLogistic extends Logistic {

	@Override
	public Transport createTransport() {
		return new RoadTransport();
	}
}

final class LogisticApp {

	public static void main(String[] args) {
		Logistic logistic = new RoadLogistic();
		logistic.plainDeliver();

		logistic = new SeaLogistic();
		logistic.plainDeliver();
	}
}
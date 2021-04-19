interface Transport {

	fun deliver(): Unit;
}

class SeaTransport : Transport {

	override fun deliver(): Unit {
		println("Transport by sea is delivering");
	}
}

class RoadTransport : Transport {

	override fun deliver(): Unit {
		println("Transport by road is delivering");
	}
}

abstract class Logistic {

	fun plainDeliver(): Unit {
		createTransport().deliver()
	}

	abstract fun createTransport(): Transport
}

class SeaLogistic : Logistic() {

	override fun createTransport(): Transport = SeaTransport()
}

class RoadLogistic : Logistic() {

	override fun createTransport(): Transport = RoadTransport()
}


fun main(): Unit {
	var logistic: Logistic = RoadLogistic()

	logistic.plainDeliver();

	logistic = SeaLogistic();
	logistic.plainDeliver();
}
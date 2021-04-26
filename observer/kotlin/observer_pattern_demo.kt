interface Observer {

	fun <T> update(state: T): Unit
}

abstract class Publisher(private val observers: MutableList<Observer>) {

	var state: String = ""
		set(value) = this.notifyAllObservers()

	protected constructor() : this(mutableListOf())

	fun subscribe(observer: Observer): Unit {
		this.observers.add(observer)
	}

	fun unsubscribe(observer: Observer): Unit {
		this.observers.remove(observer)
	}

	private fun notifyAllObservers(): Unit {
		this.observers.forEach { it.update<String>(this.state) }
	}
}

class ConcretePublisher : Publisher()

class ConcreteObserver(private val name: String) : Observer {

	override fun <T> update(state: T): Unit {
		println("[State notified] name: ${this.name}, state: $state")
	}
}

fun main(): Unit {
	val pub: Publisher = ConcretePublisher()
	val obs1: Observer = ConcreteObserver("obs1");
	val obs2: Observer = ConcreteObserver("obs2");
	val obs3: Observer = ConcreteObserver("obs3");
	val obs4: Observer = ConcreteObserver("obs4");
	val obs5: Observer = ConcreteObserver("obs5");

	pub.subscribe(obs1)
	pub.subscribe(obs2)
	pub.subscribe(obs3)
	pub.subscribe(obs4)
	pub.subscribe(obs5)

	pub.state = "State 1"
	pub.state = "State 2"
	pub.state = "State 3"
}
abstract class Memento<O>(protected val originator: O, val name: String) {

	abstract fun restore(): Unit
}

class Originator(var state: String) {

	private class Snapshot : Memento<Originator> {

		private val state: String

		constructor(originator: Originator, name: String): super(originator, name) {
			this.state = originator.state
		}

		override fun restore(): Unit {
			this.originator.state = this.state
		}
	}

	fun makeSnapshot(name: String): Memento<Originator> = Snapshot(this, name)
}

fun main(): Unit {
	val mementos: MutableList<Memento<Originator>> = mutableListOf()
	val originator: Originator = Originator("State 1");

	mementos.add(originator.makeSnapshot("m1"));
	originator.state = "State 2"
	mementos.add(originator.makeSnapshot("m2"));
	originator.state = "State 3"
	mementos.add(originator.makeSnapshot("m3"));

	println(originator.state);
	mementos[0].restore();
	println(mementos[0].name+" - "+originator.state);
	mementos[2].restore();
	println(mementos[2].name+" - "+originator.state);
	mementos[1].restore();
	println(mementos[1].name+" - "+originator.state);
}
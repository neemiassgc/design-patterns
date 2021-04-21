interface Order {

	val price: Double
}

class Hammer(override val price: Double) : Order

class Phone(override val price: Double) : Order

class Earphone(override val price: Double) : Order

class Charger(override val price: Double) : Order

class Receip(override val price: Double) : Order

class Printer(override val price: Double) : Order

class Box : Order {

	val orders: MutableList<Order>
	override val price: Double
		get() = this@Box.orders.sumOf { it.price }

	init {
		this.orders = mutableListOf()
	}

	fun add(order: Order): Unit {
		this.orders.add(order)
	}
}

fun main(): Unit {
	val hammer: Order = Hammer(130.50)
	val phone: Order = Phone(2500.0)
	val earphone: Order = Earphone(50.0)
	val charger: Order = Charger(70.0)
	val receip: Order = Receip(30.14)
	val printer: Order = Printer(900.0)

	val container: Box = Box()
	val phoneBox: Box = Box()
	phoneBox.add(phone)
	phoneBox.add(earphone)
	phoneBox.add(charger)

	val hammerBox: Box = Box()
	hammerBox.add(hammer)

	container.add(phoneBox)
	container.add(hammerBox)
	container.add(receip)
	container.add(printer)

	println("Total order price: ${container.price}")
}
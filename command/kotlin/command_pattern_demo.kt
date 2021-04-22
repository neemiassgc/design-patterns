interface OrderCommand {

	fun execute(): Unit
}

class Stock(
	private val name: String,
	private val quantity: Int
) {

	fun buy(): Unit {
		println("Stock [name: ${this.name}, quantity: ${this.quantity}] bought")
	}

	fun sell(): Unit {
		println("Stock [name: ${this.name}, quantity: ${this.quantity}] sold")
	}
}

class BuyStock(private val stock: Stock) : OrderCommand {

	override fun execute(): Unit {
		stock.buy();
	}
}

class SellStock(private val stock: Stock) : OrderCommand {

	override fun execute(): Unit {
		stock.sell();
	}
}

class Broker(private val orders: MutableList<OrderCommand>) {

	constructor() : this(mutableListOf())

	fun takeOrder(order: OrderCommand): Unit {
		this.orders.add(order);
	}

	fun placeOrders(): Unit {
		this.orders.forEach(OrderCommand::execute);
		this.orders.clear();
	}
}

fun main(): Unit {
	val stock: Stock = Stock("Shoe", 596);
	val buyCommand: OrderCommand = BuyStock(stock);
	val sellCommand: OrderCommand = SellStock(stock);
	val broker: Broker = Broker();

	broker.takeOrder(buyCommand);
	broker.takeOrder(sellCommand);

	broker.placeOrders();
}
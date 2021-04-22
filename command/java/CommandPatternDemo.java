import java.util.List;
import java.util.Vector;

interface OrderCommand {

	void execute();
}

final class Stock {

	private String name;
	private int quantity;

	public Stock(String name, int quantity) {
		this.name = name;
		this.quantity = quantity;
	}

	public String getName() {
		return this.name;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void buy() {
		System.out.printf("Stock [name: %s, quantity: %d] bought\n", this.name, this.quantity);
	}

	public void sell() {
		System.out.printf("Stock [name: %s, quantity: %d] sold\n", this.name, this.quantity);
	}
}

final class BuyStock implements OrderCommand {

	private Stock stock;

	public BuyStock(Stock stock) {
		this.stock = stock;
	}

	@Override
	public void execute() {
		stock.buy();
	}
}

final class SellStock implements OrderCommand {

	private Stock stock;

	public SellStock(Stock stock) {
		this.stock = stock;
	}

	@Override
	public void execute() {
		stock.sell();
	}
}

final class Broker {

	private final List<OrderCommand> orders;

	public Broker() {
		this.orders = new Vector();
	}

	public void takeOrder(OrderCommand order) {
		this.orders.add(order);
	}

	public void placeOrders() {
		this.orders.stream().forEach(OrderCommand::execute);
		this.orders.clear();
	}
}

final class CommandPatternDemo {

	public static void main(String[] args) {
		Stock stock = new Stock("Shoe", 596);
		OrderCommand buyCommand = new BuyStock(stock);
		OrderCommand sellCommand = new SellStock(stock);
		Broker broker = new Broker();

		broker.takeOrder(buyCommand);
		broker.takeOrder(sellCommand);

		broker.placeOrders();
	}
}
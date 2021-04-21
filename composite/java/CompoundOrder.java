import java.util.Vector;

abstract class Order {

	private double price;

	protected Order(double price) {
		this.price = price;
	}

	protected double getPrice() {
		return this.price;
	}
}

final class Hammer extends Order {

	Hammer(double price) {
		super(price);
	}
}

final class Phone extends Order {

	Phone(double price) {
		super(price);
	}
}

final class Earphone extends Order {

	Earphone(double price) {
		super(price);
	}
}

final class Charger extends Order {

	Charger(double price) {
		super(price);
	}
}

final class Receip extends Order {

	Receip(double price) {
		super(price);
	}
}

final class Printer extends Order {

	Printer(double price) {
		super(price);
	}
}

final class Box extends Order {

	private Vector<Order> orders;

	Box() {
		super(0.0);
		this.orders = new Vector();
	}

	public void add(Order order) {
		this.orders.add(order);
	}

	@Override
	public double getPrice() {
		return orders.stream().mapToDouble(Order::getPrice).sum();
	}
}

final class CompoundOrder {


	public static void main(String[] args) {
		Order hammer = new Hammer(130.50);
		Order phone = new Phone(2500.0);
		Order earphone = new Earphone(50.0);
		Order charger = new Charger(70.0);
		Order receip = new Receip(30.14);
		Order printer = new Printer(900.0);

		Box container = new Box();
		Box phoneBox = new Box();
		phoneBox.add(phone);
		phoneBox.add(earphone);
		phoneBox.add(charger);

		Box hammerBox = new Box();
		hammerBox.add(hammer);

		container.add(phoneBox);
		container.add(hammerBox);
		container.add(receip);
		container.add(printer);

		System.out.println("Total order price: "+container.getPrice());
	}
}
import java.util.Vector;
import java.util.List;

interface Observer {

	<T> void update(T state);
}

abstract class Publisher {

	private String state;
	private final List<Observer> observers;

	protected Publisher() {
		this.observers = new Vector();
		this.state = "";
	}

	public void setState(String state) {
		this.state = state;
		this.notifyAllObservers();
	}

	void subscribe(Observer observer) {
		this.observers.add(observer);
	}

	void unsubscribe(Observer observer) {
		this.observers.remove(observer);
	}

 	private void notifyAllObservers() {
		for (Observer o : this.observers) o.<String>update(this.state);
	}
}


final class ConcretePublisher extends Publisher {

	public ConcretePublisher() {
		super();
	}
}


final class ConcreteObserver implements Observer {

	private String name;

	public ConcreteObserver(String name) {
		this.name = name;
	}

	@Override
	public <T> void update(T state) {
		System.out.printf("[State notified] name: %s, state: %s\n", this.name, state+"");
	}
}

final class ObserverPatternDemo {

	public static void main(String[] args) {
		Publisher pub = new ConcretePublisher();

		Observer obs1 = new ConcreteObserver("obs1");
		Observer obs2 = new ConcreteObserver("obs2");
		Observer obs3 = new ConcreteObserver("obs3");
		Observer obs4 = new ConcreteObserver("obs4");

		pub.subscribe(obs1);
		pub.subscribe(obs2);
		pub.subscribe(obs3);
		pub.subscribe(obs4);
		pub.setState("state 1");
		pub.setState("state 4");
		pub.setState("state 7");
		pub.setState("state 10");
	}
}
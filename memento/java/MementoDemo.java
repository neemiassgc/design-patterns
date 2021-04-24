import java.util.Vector;
import java.util.List;

abstract class Memento<O> {

	private O originator;
	private String name;

	protected Memento(O originator, String name) {
		this.name = name;
		this.originator = originator;
	}

	public String getName() {
		return this.name;
	}

	protected O getOriginator() {
		return this.originator;
	}

	protected abstract void restore();
}

final class Originator {

	private String state;

	Originator(String state) {
		this.state = state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getState() {
		return this.state;
	}

	private class Snapshot extends Memento<Originator> {

		// Field to restore
		private String state;

		Snapshot(Originator originator, String name) {
			super(originator, name);
			this.state = originator.state;
		}

		@Override
		public void restore() {
			this.getOriginator().setState(this.state);
		}
	}

	public Snapshot makeSnapshot(String name) {
		return new Snapshot(this, name);
	}
}

final class MementoDemo {

	public static void main(String[] args) {
		List<Memento<Originator>> mementos = new Vector<>();
		Originator originator = new Originator("State 1");
		mementos.add(originator.makeSnapshot("m1"));
		originator.setState("State 2");
		mementos.add(originator.makeSnapshot("m2"));
		originator.setState("State 3");
		mementos.add(originator.makeSnapshot("m3"));

		System.out.println(originator.getState());
		mementos.get(0).restore();
		System.out.println(mementos.get(0).getName()+" - "+originator.getState());
		mementos.get(2).restore();
		System.out.println(mementos.get(2).getName()+" - "+originator.getState());
		mementos.get(1).restore();
		System.out.println(mementos.get(1).getName()+" - "+originator.getState());
	}
}
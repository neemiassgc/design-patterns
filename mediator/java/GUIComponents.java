interface Mediator {

	void notify(Component sender, String msg);
}

abstract class Component {

	private Mediator mediator;

	protected Component(Mediator mediator) {
		this.mediator = mediator;
	}

	protected final void click() {
		this.mediator.notify(this, "Click");
	}
	
	protected final void keypress() {
		this.mediator.notify(this, "Keypress");
	}
}

final class Button extends Component {

	public Button(Mediator mediator) {
		super(mediator);
	}
}

final class Checkbox extends Component {

	public Checkbox(Mediator mediator) {
		super(mediator);
	}
}

final class Textbox extends Component {

	public Textbox(Mediator mediator) {
		super(mediator);
	}
}

final class ConcreteMediator implements Mediator {

	@Override
	public void notify(Component sender, String msg) {
		if (sender instanceof Button)
			System.out.println("[Button] "+msg);
		else if (sender instanceof Checkbox)
			System.out.println("[Checkbox] "+msg);
		else if (sender instanceof Textbox)
			System.out.println("[Textbox] "+msg);
	}
}

final class GUIComponents {

	public static void main(String[] args) {
		Mediator mediator = new ConcreteMediator();
		Component checkbox = new Checkbox(mediator);
		Component button = new Button(mediator);
		Component textbox = new Textbox(mediator);

		checkbox.click();
		checkbox.keypress();
		textbox.click();
		textbox.keypress();
		button.click();
		button.keypress();
	}
}
interface Button {

	void click();
}

interface Checkbox {

	void check();
}

interface AbstractFactory {

	Button createButton();

	Checkbox createCheckbox();
}

final class WinButton implements Button {

	@Override
	public void click() {
		System.out.println("It has clicked on Windows button");
	}
}

final class WinCheckbox implements Checkbox {

	@Override
	public void check() {
		System.out.println("It has checked on Windows checkbox");
	}
}

final class MacButton implements Button {

	@Override
	public void click() {
		System.out.println("It has clicked on Mac button");
	}
}

final class MacCheckbox implements Checkbox {

	@Override
	public void check() {
		System.out.println("It has checked on Mac checkbox");
	}
}

final class WinFactory implements AbstractFactory {

	@Override
	public Button createButton() {
		return new WinButton();
	}

	@Override
	public Checkbox createCheckbox() {
		return new WinCheckbox();
	}
}

final class MacFactory implements AbstractFactory {

	@Override
	public Button createButton() {
		return new MacButton();
	}

	@Override
	public Checkbox createCheckbox() {
		return new MacCheckbox();
	}
}

final class MultiplatformGUI {

	public static void main(String[] args) {
		AbstractFactory factory = null;
		Button button = null;
		Checkbox checkbox = null;

		// For Windows OS
		factory = new WinFactory();
		button = factory.createButton();
		checkbox = factory.createCheckbox();

		button.click();
		checkbox.check();

		// For Mac OS
		factory = new MacFactory();

		button = factory.createButton();
		checkbox = factory.createCheckbox();

		button.click();
		checkbox.check();
	}
}
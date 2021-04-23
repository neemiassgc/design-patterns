interface Mediator {

	fun notify(sender: Component, msg: String): Unit
}

abstract class Component(private val mediator: Mediator) {

	fun click(): Unit {
		mediator.notify(this, "Click")
	}

	fun keypress(): Unit {
		mediator.notify(this, "Keypress")
	}
}

class Button : Component {

	constructor(mediator: Mediator) : super(mediator)
}

class Textbox : Component {

	constructor(mediator: Mediator) : super(mediator)
}


class Checkbox : Component {

	constructor(mediator: Mediator) : super(mediator)
}

class ConcreteMediator : Mediator {

	override fun notify(sender: Component, msg: String): Unit {

		if (sender is Button) println("[Button] $msg")
		else if (sender is Textbox) println("[Textbox] $msg")
		else if (sender is Checkbox) println("[Checkbox] $msg")
	}
}


fun main(): Unit {
	val mediator: Mediator = ConcreteMediator()
	val button: Component = Button(mediator)
	val checkbox: Component = Checkbox(mediator)
	val textbox: Component = Textbox(mediator)

	button.click();
	button.keypress()
	checkbox.click();
	checkbox.keypress()
	textbox.click();
	textbox.keypress()
}
interface Button {

	fun click(): Unit
}

interface Checkbox {

	fun check(): Unit
}

interface GUIAbstractFactory {

	fun createButton(): Button

	fun createCheckbox(): Checkbox
}

class WinButton : Button {

	override fun click(): Unit {
		println("It has clicked on Windows button")
	}
}

class WinCheckbox : Checkbox {

	override fun check(): Unit {
		println("It has checked on Windows checkbox")
	}
}

class MacButton : Button {

	override fun click(): Unit {
		println("It has clicked on Mac button")
	}
}

class MacCheckbox : Checkbox {

	override fun check(): Unit {
		println("It has checked on Mac checkbox")
	}
}

class WinFactory : GUIAbstractFactory {

	override fun createButton(): Button = WinButton()

	override fun createCheckbox(): Checkbox = WinCheckbox()
}

class MacFactory : GUIAbstractFactory {

	override fun createButton(): Button = MacButton()

	override fun createCheckbox(): Checkbox = MacCheckbox()
}

fun main(): Unit {
	var factory: GUIAbstractFactory = WinFactory()

	var button: Button = factory.createButton()

	var checkbox: Checkbox = factory.createCheckbox()

	button.click()
	checkbox.check()

	factory = MacFactory()
	button = factory.createButton()
	checkbox = factory.createCheckbox()

	button.click()
	checkbox.check()
}
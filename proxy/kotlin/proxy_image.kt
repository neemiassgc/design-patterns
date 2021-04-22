interface Image {

	fun display(): Unit
}

class RealImage(private val fileName: String) : Image {

	init {
		loadFromDisk(this.fileName)
	}

	override fun display(): Unit {
		println("Display: ${this.fileName}")
	}

	private fun loadFromDisk(fileName: String): Unit {
		println("Load: $fileName")
	}
}

class ProxyImage(
	private val fileName: String,
	private var realImage: Image? = null
) : Image {

	override fun display(): Unit {
		realImage = realImage ?: RealImage(fileName)
		realImage?.display()
	}
}

fun main(): Unit {
	val image: Image = ProxyImage("test_10mb.jpg");

	image.display()

	println()

	image.display()
}
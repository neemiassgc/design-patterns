interface Iterator {
	fun hasNext(): Boolean;
	fun <T> next(): T;
}

interface Collection {

	fun getIterator(): Iterator;

	fun getIteratorReversed(): Iterator;
}

class NameRepository(private val langs: Array<String>) : Collection {

	constructor() : this(arrayOf<String>("Java", "Kotlin", "C++", "Python", "Rust", "C#", "Ruby", "Pearl", "JS"))

	override fun getIterator(): Iterator {
		return object : Iterator {

			private var index: Int = 0;
	
			override fun hasNext(): Boolean {
				return index >= 0 && index < langs.size;
			}

	
			override fun <T> next(): T {
				return langs[index++] as T;
			}
		};
	}

	override fun getIteratorReversed(): Iterator {
		return object : Iterator {

			private var index: Int = langs.size - 1;
			
			override fun hasNext(): Boolean {
				return index >= 0 && index < langs.size;
			}

	
			override fun <T> next(): T {
				return langs[index--] as T;
			}
		};
	}
}

private fun print(iter: Iterator): Unit {
	while (iter.hasNext())
		print(iter.next<String>()+" ")
	println()
}

fun main(): Unit {
	val collection: Collection = NameRepository()
	var iterator: Iterator = collection.getIterator()
	print(iterator)

	iterator = collection.getIteratorReversed()
	print(iterator)
}
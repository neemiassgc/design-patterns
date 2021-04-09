abstract class Game {

	abstract fun initialize(): Unit;

	abstract fun startPlay(): Unit;

	abstract fun endPlay(): Unit;

	// main method
	fun play(): Unit {
		initialize();
		startPlay();
		endPlay();
	}
}

class Mario : Game() {

	override fun initialize(): Unit {
		System.out.println("Mario Game Initialized! Start playing.");
	}

	override fun startPlay(): Unit {
		System.out.println("Mario Game Started. Enjoy the game!");
	}

	override fun endPlay(): Unit {
		System.out.println("Mario Game Finished!");
	}
}

class Sonic : Game() {

	override fun initialize(): Unit {
		System.out.println("Sonic Game Initialized! Start playing.");
	}

	override fun startPlay(): Unit {
		System.out.println("Sonic Game Started. Enjoy the game!");
	}

	override fun endPlay(): Unit {
		System.out.println("Sonic Game Finished!");
	}
}

fun main(): Unit {
	var gamer: Game = Mario()
	gamer.play()

	gamer = Sonic()
	gamer.play()
}
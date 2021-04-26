enum class GameState {
	PLAY, MENU, SCORE, GAMEOVER;

	fun state(): State = 
		when (this) {
			PLAY -> Play();
			MENU -> Menu();
			GAMEOVER -> Score();
			SCORE -> GameOver();
		}
}

interface State {

	fun render(): Unit
}

class Play : State {

	override fun render(): Unit {
		println("Transacted to Play")
	}
}

class Menu : State {

	override fun render(): Unit {
		println("Transacted to Menu")
	}
}

class GameOver : State {

	override fun render(): Unit {
		println("Transacted to GameOver")
	}
}

class Score : State {

	override fun render(): Unit {
		println("Transacted to Score")
	}
}

class Game(var state: State) {

	fun render(): Unit {
		this.state.render()
	}
}

fun main(): Unit {
	val game: Game = Game(GameState.MENU.state())
	val gameStates: Array<GameState> = GameState.values()
	
	(1..10).forEach {
		game.state = gameStates.random().state()
		game.render()
	}
}
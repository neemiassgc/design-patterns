import java.util.Random;

enum GameState {
	PLAY, MENU, GAMEOVER, SCORE;

	public State getState() {
		return switch (this) {
			case PLAY -> new Play();
			case MENU -> new Menu();
			case GAMEOVER -> new Score();
			case SCORE -> new GameOver();
		};
	}
}

interface State {

	void render();
}

final class Play implements State {

	@Override
	public void render() {
		System.out.println("Transacted to Play state");
	}
}

final class Menu implements State {

	@Override
	public void render() {
		System.out.println("Transacted to Menu state");
	}
}

final class Score implements State {

	@Override
	public void render() {
		System.out.println("Transacted to Score state");
	}
}

final class GameOver implements State {

	@Override
	public void render() {
		System.out.println("Transacted to GameOver state");
	}
}

final class Game {

	private State currentState;

	Game(GameState initialState) {
		this.currentState = initialState.getState();
	}

	public void render() {
		this.currentState.render();
	}

	public void setState(GameState gameState) {
		this.currentState = gameState.getState();
	}
}

public final class GameStateDemo {

	public static void main(String[] args) {
		final Game game = new Game(GameState.MENU);
		GameState[] gameStates = GameState.values();

		new Random().ints(10, 0, gameStates.length).forEach(i -> {
			game.setState(gameStates[i]);
			game.render();
		});
	}
}
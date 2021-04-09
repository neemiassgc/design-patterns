abstract class Game {

	abstract void initialize();

	abstract void startPlay();

	abstract void endPlay();

	// main method
	final void play() {
		initialize();
		startPlay();
		endPlay();
	}
}

final class Mario extends Game {

	@Override
	public void initialize() {
		System.out.println("Mario Game Initialized! Start playing.");
	}

	@Override
	public void startPlay() {
		System.out.println("Mario Game Started. Enjoy the game!");
	}

	@Override
	public void endPlay() {
		System.out.println("Mario Game Finished!");
	}
}

final class Sonic extends Game {

	@Override
	public void initialize() {
		System.out.println("Sonic Game Initialized! Start playing.");
	}

	@Override
	public void startPlay() {
		System.out.println("Sonic Game Started. Enjoy the game!");
	}

	@Override
	public void endPlay() {
		System.out.println("Sonic Game Finished!");
	}
}

final class Gamer {

	public static void main(String[] args) {
		Game game = new Mario();
		game.play();

		game = new Sonic();
		game.play();
	}
}
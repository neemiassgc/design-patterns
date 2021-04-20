final class RoundHole {

	private int radius;

	RoundHole(int radius) {
		this.radius = radius;
	}

	public boolean fits(RoundPeg peg) {
		return this.radius >= peg.getRadius();
	}

	public int getRadius() {
		return this.radius;
	}
}

class RoundPeg {

	private int radius;

	RoundPeg(int radius) {
		this.radius = radius;
	}

	public int getRadius() {
		return this.radius;
	}
}

class SquarePeg {

	private int width;

	SquarePeg(int width) {
		this.width = width;
	}

	public int getWidth() {
		return this.width;
	}
}

final class SquarePegAdapter extends RoundPeg {

	private SquarePeg squarePeg;

	SquarePegAdapter(SquarePeg squarePeg) {
		super((int)(squarePeg.getWidth() * Math.sqrt(2) / 2.0));
		this.squarePeg = squarePeg;
	}
}

final class RoundHoleAdapter {

	public static void main(String[] args) {
		RoundHole roundHole = new RoundHole(35);

		RoundPeg roundPeg = new RoundPeg(18);

		SquarePeg smallSQPeg = new SquarePeg(14);
		SquarePeg largeSQPeg = new SquarePeg(55);

		System.out.println("Does round peg fit? "+roundHole.fits(roundPeg));
		System.out.println("Does small square peg fit? "+roundHole.fits(new SquarePegAdapter(smallSQPeg)));
		System.out.println("Does large square peg fit? "+roundHole.fits(new SquarePegAdapter(largeSQPeg)));
	}
}
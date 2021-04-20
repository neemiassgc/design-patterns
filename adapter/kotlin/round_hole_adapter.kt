class RoundHole(val radius: Int) {

	fun fits(roundPeg: RoundPeg): Boolean = this.radius >= roundPeg.radius
}

open class RoundPeg(open val radius: Int)

class SquarePeg(val width: Int)

class SquarePegAdapter(private val peg: SquarePeg) : RoundPeg(0) {

	override val radius: Int
		get() = (this.peg.width.toDouble() * Math.sqrt(2.0) / 2.0).toInt()
}

fun main(): Unit {
	val hole: RoundHole = RoundHole(20)
	val peg: RoundPeg = RoundPeg(20)

	val smallSQPeg: SquarePeg = SquarePeg(17)
	val largeSQPeg: SquarePeg = SquarePeg(17)

	val smallSQPegAdapter: RoundPeg = SquarePegAdapter(smallSQPeg)
	val largeSQPegAdapter: RoundPeg = SquarePegAdapter(largeSQPeg)

	println("Round peg: ${hole.fits(peg)}")
	println("Small square peg: ${hole.fits(smallSQPegAdapter)}")
	println("Large square peg: ${hole.fits(largeSQPegAdapter)}")
}
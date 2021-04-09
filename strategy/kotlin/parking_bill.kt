import kotlin.time.*

interface Veicle

interface ValueCalculation {

	fun calculate(period: Long, veicle: Veicle): Double
}

@kotlin.time.ExperimentalTime
class DailyCalculation(val daily: Double) : ValueCalculation {

	override fun calculate(period: Long, veicle: Veicle): Double {
		return daily * Math.ceil(period / 1.hours.inSeconds)
	}
}

class ParkingBill(
	val veicle: Veicle,
	var calculation: ValueCalculation,
	val start: Long, 
	val end: Long
) {
	fun valueBill(): Double = calculation.calculate(end - start, veicle)
}

@kotlin.time.ExperimentalTime
fun main(): Unit {
	val car: Veicle = object : Veicle {}
	val calculation: ValueCalculation = DailyCalculation(293.90)
	val parkingBill: ParkingBill = ParkingBill(car, calculation, 3124901349L, 4123487891L)

	println(parkingBill.valueBill())
}
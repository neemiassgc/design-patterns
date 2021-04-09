class CustomerBill(var strategy: (Int) -> Int) {

    private val drinks: MutableList<Int> = ArrayList()

    fun add(price: Int, quantity: Int): Unit {
        this.drinks.add(this.strategy(price * quantity))
    }

    fun print(): Unit {
        val sum: Int = this.drinks.sumBy { it } ;
        println("Total due: " + sum);
        this.drinks.clear();
    }
}

fun main(): Unit {
    // Prepare strategies
    val normalStrategy: (Int) -> Int = { it }
    val happyHourStrategy: (Int) -> Int = { it / 2 }
    val freeStrategy: (Int) -> Int = { 0 }

    val firstCustomer: CustomerBill = CustomerBill(normalStrategy);

    // Normal billing
    firstCustomer.add(100, 1);

    // Start Happy Hour
    firstCustomer.strategy = happyHourStrategy;
    firstCustomer.add(100, 2);

    // New Customer
    val secondCustomer: CustomerBill = CustomerBill(happyHourStrategy);
    secondCustomer.add(80, 1);
    // The Customer pays
    firstCustomer.print();

    // Happy Hour
    secondCustomer.strategy = normalStrategy;
    secondCustomer.add(130, 2);
    secondCustomer.add(250, 1);
    secondCustomer.print();

    // Free Strategy
    secondCustomer.strategy = freeStrategy;
    secondCustomer.add(130, 2);
    secondCustomer.add(250, 1);
    secondCustomer.add(300, 5);
    secondCustomer.add(250, 1);
    secondCustomer.print();
}
class Database private constructor(val db: String) {

	companion object Singleton {
		private var instance: Database? = null

		fun getInstance(): Database = instance ?: Database("Mysql")
	}
}

fun main(): Unit {
	val db1: Database = Database.getInstance()
	val db2: Database = Database.getInstance()

	println("db1: ${db1.db}, db2: ${db2.db}")
	println("Are the same? ${db1.db.equals(db2.db)}")
}
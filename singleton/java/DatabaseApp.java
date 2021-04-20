final class Database {

	private String db;
	private static Database instance;

	private Database(String db) {
		this.db = db;
	}

	public static Database getInstance() {
		if (instance == null) return new Database("Oracle");
		return instance;
	}

	@Override
	public boolean equals(Object other) {
		if(other == null || !(other instanceof Database)) return false;
		return this.db.equals(((Database)other).getDB());
	}

	public String getDB() {
		return db;
	}
}

final class DatabaseApp {

	public static void main(String[] args) {
		Database db = Database.getInstance();
		Database db2 = Database.getInstance();

		System.out.printf("db1: %s, db2: %s\n", db.getDB(), db2.getDB());
		System.out.printf("Are the same? %s\n", db.equals(db2));
	}
}
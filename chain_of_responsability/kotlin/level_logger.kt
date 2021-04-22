enum class Level(val level: Int) {
	INFO(1), DEBUG(2), ERROR(3)
}

abstract class AbstractLogger(
	private val lvl: Level,
	var nextLogger: AbstractLogger? = null
) {

	fun logMessage(lvl: Level, message: String): Unit {
		if (this.lvl.level == lvl.level) {
			this.writeMessage(message)
			return
		}
		nextLogger?.logMessage(lvl, message)
	}

	protected abstract fun writeMessage(message: String): Unit
}

class ConsoleLogger : AbstractLogger {

	constructor(lvl: Level) : super(lvl)

	override fun writeMessage(message: String): Unit {
		println("Standard Console::Logger: $message");
	}
}

class FileLogger : AbstractLogger {

	constructor(lvl: Level) : super(lvl)

	override fun writeMessage(message: String): Unit {
		println("File::Logger: $message");
	}
}

class ErrorLogger : AbstractLogger {

	constructor(lvl: Level) : super(lvl)

	override fun writeMessage(message: String): Unit {
		println("Error Console::Logger: $message");
	}
}

private fun getChainOfLoggers(): AbstractLogger {
	val errorLogger: AbstractLogger = ErrorLogger(Level.ERROR);
	val fileLogger: AbstractLogger = FileLogger(Level.DEBUG);
	val consoleLogger: AbstractLogger = ConsoleLogger(Level.INFO);

	errorLogger.nextLogger = fileLogger;
	fileLogger.nextLogger = consoleLogger;

	return errorLogger;	
}

fun main(): Unit {
	val loggerChain: AbstractLogger = getChainOfLoggers();

	loggerChain.logMessage(Level.INFO, "This is an information.");

	loggerChain.logMessage(Level.DEBUG, "This is an debug level information.");

	loggerChain.logMessage(Level.ERROR, "This is an error information.");
}
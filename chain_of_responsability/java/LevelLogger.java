enum Level {
	DEBUG(2), ERROR(3), INFO(1);

	private int level;

	Level(int level) {
		this.level = level;
	}

	public int getLevel() {
		return this.level;
	}
}

abstract class AbstractLevelLogger {

	protected Level level;
	private AbstractLevelLogger nextLevelLogger;

	protected AbstractLevelLogger(Level level) {
		this.level = level;
	}

	public void setNextLevelLogger(AbstractLevelLogger nextLevelLogger) {
		this.nextLevelLogger = nextLevelLogger;
	}

	protected void logMessage(Level level, String msg) {
		if (this.level.getLevel() == level.getLevel()) {
			this.writeMessage(msg);
			return;
		}
		if (nextLevelLogger != null) nextLevelLogger.logMessage(level, msg);
	}

	protected abstract void writeMessage(String msg);
}

final class ConsoleLogger extends AbstractLevelLogger {

	public ConsoleLogger(Level level) {
		super(level);
	}

	@Override
	public void writeMessage(String message) {
		System.out.println("Standard Console::Logger: " + message);
	}
}

final class FileLogger extends AbstractLevelLogger {

	public FileLogger(Level level) {
		super(level);
	}

	@Override
	public void writeMessage(String message) {		
		System.out.println("File::Logger: " + message);
	}
}

final class ErrorLogger extends AbstractLevelLogger {

	public ErrorLogger(Level level){
		super(level);
	}

	@Override
	public void writeMessage(String message) {
		System.out.println("Error Console::Logger: " + message);
	}
}

final class LevelLogger {

	private static AbstractLevelLogger getChainOfLoggers() {
		AbstractLevelLogger errorLogger = new ErrorLogger(Level.ERROR);
		AbstractLevelLogger fileLogger = new FileLogger(Level.DEBUG);
		AbstractLevelLogger consoleLogger = new ConsoleLogger(Level.INFO);

		errorLogger.setNextLevelLogger(fileLogger);
		fileLogger.setNextLevelLogger(consoleLogger);

		return errorLogger;
	}

	public static void main(String[] args) {
		AbstractLevelLogger loggerChain = getChainOfLoggers();

		loggerChain.logMessage(Level.INFO, "This is an information.");

		loggerChain.logMessage(Level.DEBUG, "This is an debug level information.");

		loggerChain.logMessage(Level.ERROR, "This is an error information.");
	}
}
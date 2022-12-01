package analytics_lib;

import java.util.List;

/**
 * Enjoying our time implementing our own logger class to log output to user on the console.
 * @author Marina
 *
 */
public class Logger {
	private LogLevel logLevel; /**< Minimum logging level. */
	private static Logger instance = null; /**< Singleton instance of the logger. */
	
	/**
	 * Private constructor to create logger based on the minimum logging level.
	 * @param level logging level.
	 */
	private Logger(LogLevel level) {
		logLevel = level;
	}
	
	/**
	 * Gets singleton object instance of the logger adjusted at certain logging level.
	 * @param level minimum logging level.
	 * @return Singleton instance of the logger object.
	 */
	public static Logger getInstance(LogLevel level) {
		if (instance == null) {
			instance = new Logger(level);
		} else {
			instance.setLevel(level);
		}
		return instance;
	}
	
	/**
	 * Gets singleton object instance of the logger adjusted at default logging level.
	 * @return Singleton instance of the logger object adjusted at default logging level.
	 */
	public static Logger getInstance() {
		if (instance == null) {
			instance = new Logger(LogLevel.LOG_LEVEL_DEFAULT);
		}
		return instance;
	}
	
	/**
	 * Sets the minimum logging level of the logger.
	 * @param level minimum logging level.
	 */
	public void setLevel(LogLevel level) {
		logLevel = level;
	}
	
	/**
	 * Logs a string message at certain logging level.
	 * If the message level is less than or equal to logger level the message will be printed.
	 * @param msg string message to be logged.
	 * @param level the level of the message.
	 */
	public void log(String msg, LogLevel level) {
		String levelstr = "";
		
		if (level == LogLevel.LOG_LEVEL_DEBUG) {
			levelstr = "(Debug) ";
		} else if (level == LogLevel.LOG_LEVEL_ERROR) {
			levelstr = "(Error) ";
		} else if (level == LogLevel.LOG_LEVEL_INFO) {
			levelstr = "(Info) ";
		}
		
		if (level.getVal() <= logLevel.getVal()) {
			String printedMsg = levelstr + msg;
			System.out.println(printedMsg);
		}
	}

	/**
	 * Logs a string message at the default logging level.
	 * @param msg string message to be logged.
	 */
	public void log(String msg) {
		this.log(msg, LogLevel.LOG_LEVEL_DEFAULT);
	}
	
	/**
	 * Logs an integer message at certain logging level.
	 * If the message level is less than or equal to logger level the message will be printed.
	 * @param msg the integer message to be logged.
	 */
	public void log(int msg) {
		String printedMsg = Integer.toString(msg);
		this.log(printedMsg, LogLevel.LOG_LEVEL_DEFAULT);
	}
	
	/**
	 * Logs an list of integers message at certain logging level.
	 * If the message level is less than or equal to logger level the message will be printed.
	 * @param msg list of integers to be logged.
	 */
	public void log(List<Integer> msg) {
		this.log(msg.toString(), LogLevel.LOG_LEVEL_DEFAULT);
	}
	
}

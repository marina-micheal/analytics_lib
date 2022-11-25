package analytics_lib;

public class Logger {

	private LogLevel logLevel;
	private static Logger instance = null;
	
	private Logger(LogLevel level) {
		logLevel = level;
	}
	
	public static Logger getInstance(LogLevel level) {
		if (instance == null) {
			instance = new Logger(level);
		} else {
			instance.setLevel(level);
		}
		
		return instance;
	}
	
	public static Logger getInstance() {
		if (instance == null) {
			instance = new Logger(LogLevel.LOG_LEVEL_DEFAULT);
		}
		return instance;
	}
	
	public void setLevel(LogLevel level) {
		logLevel = level;
	}
	
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
	
	public void log(String msg) {
		this.log(msg, LogLevel.LOG_LEVEL_DEFAULT);
	}
}

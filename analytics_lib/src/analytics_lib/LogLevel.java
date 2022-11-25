package analytics_lib;

public enum LogLevel {
	LOG_LEVEL_ERROR(0),
	LOG_LEVEL_DEFAULT(1),
	LOG_LEVEL_INFO(2),
	LOG_LEVEL_DEBUG(3);
	
	private int enumVal;
	
	LogLevel(int val) {
		enumVal = val;
	}
	
	public int getVal() {
		return enumVal;
	}
}

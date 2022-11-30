package analytics_lib;

/**
 * Enum class representing the possible logging levels supported by the logger class.
 * @author Marina
 *
 */
public enum LogLevel {
	LOG_LEVEL_ERROR(0),
	LOG_LEVEL_DEFAULT(1),
	LOG_LEVEL_INFO(2),
	LOG_LEVEL_DEBUG(3);
	
	private int enumVal; /**< The numerical value of the enum. */
	
	/**
	 * Enum class constructor to create enum using a numerical value.
	 * @param val Numerical value of the enum.
	 */
	LogLevel(int val) {
		enumVal = val;
	}
	
	/**
	 * Returns the enum numerical value.
	 * @return Enum integer value.
	 */
	public int getVal() {
		return enumVal;
	}
}

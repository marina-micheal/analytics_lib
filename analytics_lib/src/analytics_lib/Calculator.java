package analytics_lib;

/**
 * Calculations class to perform main operations.
 * @author Marina
 *
 */
public class Calculator {
	Logger logger; /**< Logger to log messages to user. */
	
	/**
	 * Calculator default constructor.
	 */
	public Calculator() {
		
		logger = Logger.getInstance(LogLevel.LOG_LEVEL_DEFAULT);
	}
	
	/**
	 * Perform calculation operation using operation data object.
	 * @param opData Operation data object.
	 * @return the result int from executing the operation.
	 */
	public static int calculate (SimpleOpData opData) {
		int result;
		
		if (opData == null) {
			result = 0;
		} else {
			result = calculate(opData.getOp(), opData.getFirstNum(), opData.getSecondNum());
		}
		
		return result;
	}
	
	/**
	 * Perform calculation operation using input parameters.
	 * @param operator Character representing operation to be performed.
	 * @param firstNum Operation first argument.
	 * @param secondNum Operation second argument.
	 * @return Operation result.
	 * @throws ArithmeticException in case of division by zero.
	 */
	public static int calculate(String operator, int firstNum, int secondNum) throws ArithmeticException {
		if(operator.equals("+")) {
			return firstNum + secondNum;
		}else if (operator.equals("-")) {
			return firstNum - secondNum;
		}else if (operator.equals("*")) {
			return firstNum * secondNum;
		}else if (operator.equals("/")) {
			
			if(secondNum == 0) {
				throw new ArithmeticException("Invalid division by zero");
			}else {
				return firstNum / secondNum;
			}
			
		}else if (operator.equals("%")) {
			if(secondNum == 0) {
				throw new ArithmeticException("Invalid division by zero");
			}else {
				return firstNum % secondNum;
			}
		}else {
			throw new IllegalArgumentException("invalid operator selected");
		}
	}

}
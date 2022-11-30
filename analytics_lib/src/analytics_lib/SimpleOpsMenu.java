package analytics_lib;

import java.util.Scanner;

/**
 * Simple operations sub menu, implementing ISubMenu interface.
 * @author Marina
 *
 */
public class SimpleOpsMenu implements ISubMenu {
	Scanner sc; /**< Scanner to read user inputs from console. */
	Logger logger; /**< Logger to log user messages to console. */
	
	/**
	 * Class default constructor.
	 */
	public SimpleOpsMenu( ) {
		sc = new Scanner(System.in);		
		logger = Logger.getInstance(LogLevel.LOG_LEVEL_DEFAULT);
	}
	
	/**
	 * Reads user requested operation.
	 * @return Character representing user selected operation.
	 */
	private String parseOperator() {
		logger.log("Enter operation (+ or - or * or / or %): ");
		String operator= sc.next(); 
		
		while( (!operator.equals("+"))&&(!operator.equals("-"))&&(!operator.equals("*"))&&(!operator.equals("/"))&&(!operator.equals("%"))) {
			logger.log("Enter correct operation (+ or - or * or / or %): ");
			operator= sc.next();
		}
		
		return operator;
	}
	
	/**
	 * Execute simple calculation based on the requested operation.
	 * @param op the operation to be performed.
	 */
	private void executeSimpleCalcuation(String op) {
		logger.log("Enter first number: ");
		int firstNum= sc.nextInt();
		logger.log("Enter second number: ");
		
		int secondNum=sc.nextInt();
					
		int result = Calculator.calculate(op, firstNum, secondNum);
	
		logger.log(result);
	}
	
	/**
	 * Checks if the user would like to continue and reads user input.
	 * @return True or false based on user input.
	 */
	private Boolean askToContinue() {
		logger.log("Do you want to try another operation? (y/n): ");
		String r;
		do {
			r = sc.nextLine();
			
		} while (r.length() <= 0);
			
		return (r.charAt(0) == 'y');
	}
	
	/**
	 * Simple operations sub menu main loop.
	 */
	@Override
	public void mainLoop() {
		Boolean exitFlag = false;
		do {
			String op = parseOperator();
			executeSimpleCalcuation(op);
			exitFlag = !askToContinue();
		}while(Boolean.FALSE.equals(exitFlag));
	}
}

package analytics_lib;

import java.util.Scanner;

public class SimpleOpsMenu implements ISubMenu {

	Scanner sc;
	Logger logger;
	public SimpleOpsMenu( ) {
		sc = new Scanner(System.in);		
		logger = Logger.getInstance(LogLevel.LOG_LEVEL_DEFAULT);
	}
	
	private String parseOperator() {
		logger.log("Enter operation (+ or - or * or / or %): ");
		String operator= sc.next(); 
		
		while( (operator.equals("+")==false)&&(operator.equals("-")==false)&&(operator.equals("*")==false)&&(operator.equals("/")==false)&&(operator.equals("%")==false)) {
			logger.log("Enter correct operation (+ or - or * or / or %): ");
			operator= sc.next();
		}
		
		return operator;
	}
	
	private void executeSimpleCalcuation(String op) {
		logger.log("Enter first number: ");
		int firstNum= sc.nextInt();
		logger.log("Enter second number: ");
		
		int secondNum=sc.nextInt();
					
		int result = Calculator.calculate(op, firstNum, secondNum);
		String resultString=Integer.toString(result); 
		logger.log(resultString);
		
	}
	
	private Boolean askToContinue() {
		logger.log("Do you want to try another operation? (y/n): ");
		String r;
		do {
			r = sc.nextLine();
			
		} while (r.length() <= 0);
			
		if (r.charAt(0) == 'y') {
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public void mainLoop() {
		Boolean exit_flag = false;
		do {
			String op = parseOperator();
			executeSimpleCalcuation(op);
			exit_flag = !askToContinue();
		}while(!exit_flag);
	}
}

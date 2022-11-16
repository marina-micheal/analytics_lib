package analytics_lib;

import java.util.Scanner;

public class SimpleOpsMenu implements ISubMenu {

	Scanner sc;

	public SimpleOpsMenu( ) {
		sc = new Scanner(System.in);		
	}
	
	private String parseOperator() {
		System.out.print("Enter operation (+ or - or * or / or %): ");
		
		String operator= sc.next(); 
		
		while( (operator.equals("+")==false)&&(operator.equals("-")==false)&&(operator.equals("*")==false)&&(operator.equals("/")==false)&&(operator.equals("%")==false)) {
			System.out.print("Enter correct operation (+ or - or * or / or %): ");	
			operator= sc.next();
		}
		
		return operator;
	}
	
	private void executeSimpleCalcuation(String op) {
		System.out.print("Enter first number: ");
		int firstNum= sc.nextInt();
		System.out.print("Enter second number: "); 
		int secondNum=sc.nextInt();
					
		int result = Calculator.calculate(op, firstNum, secondNum);
		System.out.println(result);
	}
	
	private Boolean askToContinue() {
		System.out.print("Do you want to try another operation? (y/n): ");
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

package analytics_lib;

import java.util.Scanner;

public class MainMenu {
	public void mainLoop() {
		String choice="";
		do {
			Scanner sc =new Scanner(System.in);
			System.out.print("choose to make the operation(o) or exit(e): ");  
			choice= sc.nextLine(); 
			if(choice.equals("e")) {
				break;
			}else if((choice.equals("e") == false) &&  (choice.equals("o") == false)) {
				System.out.println("choose correct choice");
				continue;
			}
			System.out.print("Enter operation (+ or - or * or / or %): ");
			
			String operator= sc.next(); 
			
			while( (operator.equals("+")==false)&&(operator.equals("-")==false)&&(operator.equals("*")==false)&&(operator.equals("/")==false)&&(operator.equals("%")==false)) {
				System.out.print("Enter correct operation (+ or - or * or / or %): ");	
				operator= sc.next();
			}
			
			System.out.print("Enter first number: ");
			int firstNum= sc.nextInt();
			System.out.print("Enter second number: "); 
			int secondNum=sc.nextInt();
		
			Calculator calc = new Calculator();
			
			int result = calc.calculate(operator, firstNum, secondNum);
			System.out.println(result);
			/*
			 * System.out.println(choice); System.out.println(operator);
			 * System.out.println(firstNum); System.out.println(secondNum);
			 */
		}while(choice.equals("e")==false);	
	}

}

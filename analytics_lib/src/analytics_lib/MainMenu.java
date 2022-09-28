package analytics_lib;

import java.util.Scanner;

public class MainMenu {
	public void mainLoop() {
		String choice="";
		//String filePath="";
		do {
			Scanner sc =new Scanner(System.in);
			System.out.print("choose to make the operation(o) or exit(e) or file(f): ");  
			choice= sc.nextLine(); 
			if(choice.equals("e")) {
				break;
			}else if(choice.equals("f")) {
				System.out.print("enter the file path");
				
			//	filePath=sc.next();
//				String EExtention = FilenameUtils.getExtension();
//				if(filePath){
//					
//				}
//				//System.out.print(filePath);
//				
				
			}else if(choice.equals("o")) {
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
				
			}else {
				System.out.println("Invalid input, choose correct choice");
				//choice= sc.nextLine(); 
				continue;
			}
			
			/*
			 * System.out.println(choice); System.out.println(operator);
			 * System.out.println(firstNum); System.out.println(secondNum);
			 */
		}while(true);	
	}

}

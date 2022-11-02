package analytics_lib;

import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class MainMenu {
	public void mainLoop() {
		String choice="";
		String filePath="";
		
		do {
			Scanner sc =new Scanner(System.in);
			System.out.print("choose to make the operation(o) or exit(e) or file(f) or array(a): ");  
			choice= sc.nextLine(); 
			if(choice.equals("e")) {
				break;
			}else if(choice.equals("f")) {
				System.out.print("Enter file path: ");
				filePath = sc.nextLine();
				FileReader fReader = FileReaderFacory.createFileReader(filePath);
				if (fReader != null) {
					Calculator calc = new Calculator();
					int numOfOps = fReader.getNumOfOps();
					for (int i = 0; i < numOfOps; i++) {
						OperationData opData = fReader.readLine();
						if (opData != null) {
							int result = calc.calculate(opData);
							System.out.println(result);
						}						
					}
				}
			 
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
				
			}else if(choice.equals("a")) {
				System.out.print("Enter Array Length");
				
				
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

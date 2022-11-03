package analytics_lib;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class MainMenu {
	ArrayList<Integer> Nums = new ArrayList<Integer>();
	
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
				System.out.print("what is the number of Numbers you want to write in the array?");
				int NumOfNumbers= sc.nextInt(); 
				for(int i =0;i < NumOfNumbers ;i++) {
					System.out.print("put number you want");
					int num;
					num=sc.nextInt();
					Nums.add(num);	
				}
				System.out.print("Your array" + Nums);
				System.out.print("what operation you want to make on the array" );
				break;
				
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

	private void While(boolean b) {
		// TODO Auto-generated method stub
		
	}

}

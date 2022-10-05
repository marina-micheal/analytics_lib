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
			System.out.print("choose to make the operation(o) or exit(e) or file(f): ");  
			choice= sc.nextLine(); 
			if(choice.equals("e")) {
				break;
			}else if(choice.equals("f")) {
				System.out.print("enter the file path");
				Scanner scanner =new Scanner(System.in);
				filePath=scanner.next();
				
				FileReaderFacory.createFileReader(filePath);
			
				
				
				  /* 	
				filePath=sc.next();
				 if (filePath.endsWith("desc")) {
			    	  
			   
				 try {
				      File myObj = new File(filePath);
				     
				      Scanner myReader = new Scanner(myObj);
				      
				      while (myReader.hasNextLine()) {
				    	  int operations=myReader.nextInt();
			    		  myReader.nextLine();
				    	  for(int i =0;i< operations;i++) {
				    		  String line=myReader.nextLine();
				    		  String[] parts = line.split(" ");
				    		  int firstNumFile = Integer.parseInt(parts[0]) ; 
				    		  System.out.println(firstNumFile);
				    		  
				    		 
				    		  String operatorFile=parts[1];
				    		  System.out.println(operatorFile);
				    		  
				    		  int secondNumFile = Integer.parseInt(parts[2]) ; 
				    		  System.out.println(secondNumFile);

				    		 
				    		  Calculator calc = new Calculator();
				    		  int resultFile=calc.calculate(operatorFile,firstNumFile,secondNumFile);
				    		  System.out.println(resultFile);
				    	  }
				      }
				      myReader.close();
				    } catch (FileNotFoundException e) {
				      System.out.println("An error occurred.");
				      e.printStackTrace();
				    }
				 }*/
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

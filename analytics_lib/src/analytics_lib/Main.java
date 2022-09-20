
package analytics_lib;
import java.util.*;  

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println("Hello World");
		mainLoop();
	}
	
	public static void mainLoop() {
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
			basicCalc(operator, firstNum, secondNum);
			
			System.out.println(choice);
			System.out.println(operator);
			System.out.println(firstNum);
			System.out.println(secondNum);
		}while(choice.equals("e")==false);	
	}
	
	public static int basicCalc(String operator, int firstNum, int secondNum) {
		if(operator.equals("+")) {
			int add=firstNum + secondNum;
			return add;
		}else if (operator.equals("-")) {
			int sub=firstNum - secondNum;
			return sub;
		}else if (operator.equals("*")) {
			int mul=firstNum * secondNum;
			return mul;
		}else if (operator.equals("/")) {
			int div=firstNum / secondNum;
			return div;
		}else if (operator.equals("%")) {
			int mod=firstNum % secondNum;
			return mod;
		}else {
			System.out.println("invalid operator");
			return 0;
		}
	}
}

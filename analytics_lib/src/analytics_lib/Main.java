
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
			
			String a= sc.next(); 
			
			while( (a.equals("+")==false)&&(a.equals("-")==false)&&(a.equals("*")==false)&&(a.equals("/")==false)&&(a.equals("%")==false)) {
				System.out.print("Enter correct operation (+ or - or * or / or %): ");	
				a= sc.next();
			}
			
			System.out.print("Enter first number: ");
			int b= sc.nextInt();
			System.out.print("Enter second number: "); 
			int c=sc.nextInt();
			System.out.println(choice);
			System.out.println(a);
			System.out.println(b);
			System.out.println(c);
		}while(choice.equals("e")==false);	
	}
}

package analytics_lib;

import java.util.Scanner;

public class MainMenu {
	
	Scanner sc;
	SubMenuFactorty subMenuManager = null;
	public MainMenu() {
		// TODO Auto-generated constructor stub
		sc = new Scanner(System.in);
		subMenuManager = SubMenuFactorty.getInstance();
	}
	
	private char parseMainChoice() {
		System.out.print("Choose operation to perform:\r\n"
				+ "(s) for simple calculation operations\r\n"
				+ "(f) for batch calculation operations from file\r\n"
				+ "(a) to perform operations on arrays\r\n"
				+ "(v) to perform linear operations on vectors\r\n"
				+ "(e) to exit\r\n"
				+ "Please enter your choice: "
				);
		String scan;
		do {
			scan = sc.nextLine();
			
		} while (scan.length() <= 0);
			
		return scan.charAt(0);
	}

	private void displayUnexpectedErrorMessage() {
		System.out.print("Unexpected error happened\n Please try again\n"); 
	}
	
	private void displayWelcomeMessage() {
		System.out.print("Welcome to analytical library interface\n"); 
	}
	
	private void displayByeByeMessage() {
		System.out.print("Bye Bye, see you next time\n"); 
	}
	
	public void mainLoop() {		
		Boolean exit_flag = false;
		ISubMenu submenu = null;
		displayWelcomeMessage();
		do {
			char choice = parseMainChoice();
			switch(choice) {
			case 's':
			case 'f':
			case 'a':
			case 'v':
				 submenu = subMenuManager.getSubMenuInterface(choice);
				if (submenu == null) {
					displayUnexpectedErrorMessage();
				} else {
					submenu.mainLoop();
				}
				break;
				
			case 'e':
				exit_flag = true;
				break;

			default:
				System.out.println("Invalid input, choose correct choice");
				continue;				
			}
			
		}while(!exit_flag);
		
		displayByeByeMessage();
	}
}

package analytics_lib;
import java.util.Scanner;

public class MainMenu {
	
	Scanner sc;
	SubMenuFactorty subMenuManager = null;
	Logger logger;
	
	public MainMenu() {
		sc = new Scanner(System.in);
		subMenuManager = SubMenuFactorty.getInstance();
		logger = Logger.getInstance(LogLevel.LOG_LEVEL_DEFAULT);
	}
	
	/**
	 * 
	 * @return
	 */
	private char parseMainChoice() {
		logger.log("Choose operation to perform:\r\n"
				+ "(s) for simple calculation operations\r\n"
				+ "(f) for batch calculation operations from file\r\n"
				+ "(a) to perform operations on arrays\r\n"
				+ "(v) to perform linear operations on vectors\r\n"
				+ "(e) to exit\r\n"
				+ "Please enter your choice: ");
		
		
		
		String scan;
		do {
			scan = sc.nextLine();
			
		} while (scan.length() <= 0);
			
		return scan.charAt(0);
	}

	/**
	 * Displays 
	 */	
	private void displayUnexpectedErrorMessage() {
		
		logger.log("Unexpected error happened\n Please try again\n",LogLevel.LOG_LEVEL_ERROR);
	}
	
	private void displayWelcomeMessage() {
		
		logger.log("Welcome to analytical library interface");
	}
	
	private void displayByeByeMessage() {
		
		logger.log("Bye Bye, see you next time\n");
	}
	
	
	/**
	 * Executes the main loop of the program.
	 */
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
				logger.log("Invalid input, choose correct choice", LogLevel.LOG_LEVEL_ERROR);
				continue;				
			}
			
		}while(!exit_flag);
		
		displayByeByeMessage();
	}
}

package analytics_lib;
import java.io.IOException;
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
	 * show the main menu and take the choice from the user. 
	 * @return user choice as char value.
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
	private void displayWelcomeMessage() {
		
		logger.log("Welcome to analytical library interface");
	}
	
	private void displayByeByeMessage() {
		
		logger.log("Bye Bye, see you next time\n");
	}
	
	/**
	 * Executes the main loop of the program.
	 * @throws Exception invalid input
	 */
	public void mainLoop() throws IOException {		
		Boolean exitFlag = false;
		ISubMenu submenu = null;
		displayWelcomeMessage();
		do {
			char choice = parseMainChoice();
			switch(choice) {
			case 's', 'f', 'a', 'v':				
				try {
					submenu = subMenuManager.getSubMenuInterface(choice);
					submenu.mainLoop();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();					
				}
				break;
				
			case 'e':
				exitFlag = true;
				break;

			default:
				throw new IOException("Invalid input, choose correct choice");
			}
			
		}while(Boolean.FALSE.equals(exitFlag));
		
		displayByeByeMessage();
	}
}

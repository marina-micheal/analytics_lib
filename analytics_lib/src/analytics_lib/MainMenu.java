package analytics_lib;
import java.io.IOException;
import java.util.Scanner;

/**
 * Program main menu class.
 * @author webse
 *
 */
public class MainMenu {
	Scanner sc; /**< Scanner to read user inputs from console. */
	SubMenuFactorty subMenuManager = null; /**< Sub menu factory based on user inputs. */
	Logger logger; /**< Logger to log user messages to console. */
	
	/**
	 * Main menu default constructor.
	 */
	public MainMenu() {
		sc = new Scanner(System.in);
		subMenuManager = SubMenuFactorty.getInstance();
		logger = Logger.getInstance(LogLevel.LOG_LEVEL_DEFAULT);
	}
	
	/**
	 * Shows the main menu and take the choice from the user. 
	 * @return user choice as char value.
	 */
	private char parseMainChoice() {
		logger.log("""
						Choose operation to perform:
						(s) for simple calculation operations
						(f) for batch calculation operations from file
						(a) to perform operations on arrays
						(v) to perform linear operations on vectors
						(e) to exit
						Please enter your choice: 
						""");	
		String scan;
		do {
			scan = sc.nextLine();
			
		} while (scan.length() <= 0);
			
		return scan.charAt(0);
	}

	/**
	 * Displays welcome message to user.
	 */	
	private void displayWelcomeMessage() {
		
		logger.log("Welcome to analytical library interface");
	}

	/**
	 * Displays program normal termination message to user.
	 */
	private void displayByeByeMessage() {
		
		logger.log("Bye Bye, see you next time\n");
	}
	
	/**
	 * Executes the main loop of the program.
	 * @throws IOException invalid user input
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
				throw new IOException("Invalid menu input, program terminates");
			}
			
		}while(Boolean.FALSE.equals(exitFlag));
		
		displayByeByeMessage();
	}
}

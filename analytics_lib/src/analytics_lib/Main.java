
package analytics_lib;
import java.io.IOException;

/**
 * Default main class executes the main loop.
 * @author Marina
 *
 */
public class Main {
	/**
	 * Main function
	 * @param args main function arguments.
	 */
	public static void main(String[] args) {		
		MainMenu menu = new MainMenu();
		Logger logger = Logger.getInstance();
		try {
			menu.mainLoop();
		} catch (IOException e) {
			logger.log(e.toString(), LogLevel.LOG_LEVEL_ERROR);
		}
	}
}

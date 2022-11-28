
package analytics_lib;
import java.io.IOException;  

public class Main {

	public static void main(String[] args) {		
		MainMenu menu = new MainMenu();
		try {
			menu.mainLoop();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

package analytics_lib;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * File operations sub menu, implementing ISubMenu interface.
 * @author Marina
 *
 */
public class FileOpsMenu implements ISubMenu {
	Scanner sc; /**< Scanner to read user inputs from console. */
	Logger logger; /**< Logger to print messages to user on console. */
	
	/**
	 * Class default constructor.
	 */
	public FileOpsMenu( ) {
		sc = new Scanner(System.in);	
		logger = Logger.getInstance(LogLevel.LOG_LEVEL_DEFAULT);
	}
	
	/**
	 * Reads file name from user.
	 * @return File name and path as string.
	 */
	private String parseFileName() {
		logger.log("Enter file path:");
		return sc.nextLine();
	}
	
	/**
	 * Executes the file operations based on the file path.
	 * @param filePath Path of the file to be manipulated.
	 */
	private void executeFileOps(String filePath) {
		try {
			FileReader fReader = FileReaderFacory.createFileReader(filePath);
			if (fReader != null) {
				int numOfOps = fReader.getNumOfOps();
				for (int i = 0; i < numOfOps; i++) {
					SimpleOpData opData = fReader.readNextOperation();
					if (opData != null) {
						int result = Calculator.calculate(opData);						
						logger.log(result);
					}						
				}
			}
		} catch (FileNotFoundException e) {
			logger.log("Invalid file path", LogLevel.LOG_LEVEL_ERROR);
		}
	}
	
	/**
	 * Checks if the user would like to continue and reads user input.
	 * @return True or false based on user input.
	 */
	private Boolean askToContinue() {	
		logger.log("Do you want to try another file? (y/n): ");
		String r;
		do {
			r = sc.nextLine();
			
		} while (r.length() <= 0);
			
		return (r.charAt(0) == 'y');
	}
	
	/**
	 * File operations sub menu main loop.
	 */
	@Override
	public void mainLoop() {
		Boolean exitFlag = false;
		do {
			String filepath = parseFileName();
			executeFileOps(filepath);
			exitFlag = !askToContinue();
		}while(Boolean.FALSE.equals(exitFlag));
	}

}

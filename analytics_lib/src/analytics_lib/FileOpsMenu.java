package analytics_lib;

import java.util.Scanner;

public class FileOpsMenu implements ISubMenu {

	Scanner sc;
	Logger logger;
	public FileOpsMenu( ) {
		sc = new Scanner(System.in);	
		logger = Logger.getInstance(LogLevel.LOG_LEVEL_DEFAULT);
	}
	
	private String parseFileName() {
		
		logger.log("Enter file path:");
		return sc.nextLine();
	}
	
	private void executeFileOps(String filePath) {
		FileReader fReader = FileReaderFacory.createFileReader(filePath);
		if (fReader != null) {
			int numOfOps = fReader.getNumOfOps();
			for (int i = 0; i < numOfOps; i++) {
				SimpleOpData opData = fReader.readLine();
				if (opData != null) {
					int result = Calculator.calculate(opData);
					//String resultString=Integer.toString(result); 
					logger.log(result);
				
					
				}						
			}
		}
	}
	
	private Boolean askToContinue() {
		
	
		logger.log("Do you want to try another file? (y/n): ");
		String r;
		do {
			r = sc.nextLine();
			
		} while (r.length() <= 0);
			
		if (r.charAt(0) == 'y') {
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public void mainLoop() {
		Boolean exit_flag = false;
		do {
			String filepath = parseFileName();
			executeFileOps(filepath);
			exit_flag = !askToContinue();
		}while(!exit_flag);
	}

}

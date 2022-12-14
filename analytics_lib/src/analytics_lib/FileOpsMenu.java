package analytics_lib;

import java.util.Scanner;

public class FileOpsMenu implements ISubMenu {

	Scanner sc;

	public FileOpsMenu( ) {
		sc = new Scanner(System.in);		
	}
	
	private String parseFileName() {
		System.out.print("Enter file path: ");
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
					System.out.println(result);
				}						
			}
		}
	}
	
	private Boolean askToContinue() {
		System.out.print("Do you want to try another file? (y/n): ");
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

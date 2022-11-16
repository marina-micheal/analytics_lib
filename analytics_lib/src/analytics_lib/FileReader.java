package analytics_lib;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader {

    private File myFile;
    private int numberOfOps;
    private Scanner myReader;
    
	public FileReader(String filePath) {
		myFile = new File(filePath);
		try {
			myReader = new Scanner(myFile);
			numberOfOps = myReader.nextInt();
	    	myReader.nextLine();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public SimpleOpData readLine() {
      if (myReader.hasNextLine()) {
			String line = myReader.nextLine();
			String[] parts = line.split(" ");
			int firstNum = Integer.parseInt(parts[0]) ; 
			//System.out.println(firstNumFile);
			  
			String operator = parts[1];
			//System.out.println(operatorFile);
			  
			int secondNum = Integer.parseInt(parts[2]) ; 
			//System.out.println(secondNumFile);
	
			SimpleOpData opData = new SimpleOpData(operator, firstNum, secondNum);
		  	return opData;
  		} else {
  			return null;
  		}
	}
	
	public int getNumOfOps() {
		return numberOfOps;
	}
}

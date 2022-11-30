package analytics_lib;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * File reader class to read file contents using the program specific format.
 * @author Marina
 *
 */
public class FileReader {
    private File myFile; /**< Java pointer to the file operated. */
    private int numberOfOps; /**< Number of operations to be performed stored in the file. */
    private Scanner myReader; /**< Scanner to read file content. */
    
    /**
     * Constructor to create file reader using the file path.
     * @param filePath Path to the file to be operated.
     */
	public FileReader(String filePath) {
		myFile = new File(filePath);
		try {
			myReader = new Scanner(myFile);
			numberOfOps = myReader.nextInt();
	    	myReader.nextLine();
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
	}
	
	/**
	 * Read the next operation to be performed from the file.
	 * @return Immutable object to the operation to be performed.
	 */
	public SimpleOpData readNextOperation() {
      if (myReader.hasNextLine()) {
			String line = myReader.nextLine();
			String[] parts = line.split(" ");
			int firstNum = Integer.parseInt(parts[0]) ; 
			String operator = parts[1];
			int secondNum = Integer.parseInt(parts[2]) ; 
			return new SimpleOpData(operator, firstNum, secondNum);
  		} else {
  			return null;
  		}
	}
	
	/**
	 * Returns the number of operations stored in the file.
	 * @return Number of operation.
	 */
	public int getNumOfOps() {
		return numberOfOps;
	}
}

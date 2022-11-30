package analytics_lib;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * Factory class to create file reader based on the file path.
 * @author Marina
 *
 */
public class FileReaderFacory {
	Logger logger; /**< Logger to print messages to the user. */

	/**
	 * Class default constructor.
	 */
	public FileReaderFacory() {
		logger = Logger.getInstance(LogLevel.LOG_LEVEL_DEFAULT);
	}
	
	/**
	 * Create a new File Reader object class from the file path.
	 * @param filePath Path to the file to be operated.
	 * @return new object FileReader
	 * @throws FileNotFoundException in case the file path is invalid.
	 */
	public static FileReader createFileReader(String filePath) throws FileNotFoundException {
		 File f = new File(filePath);
		 if(f.exists() && !f.isDirectory() && filePath.endsWith(".desc")) { 
			 return new FileReader(filePath);   
		 } else {
			 throw new FileNotFoundException("Invalid file path");
		 }
	}
}

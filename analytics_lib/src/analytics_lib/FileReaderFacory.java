package analytics_lib;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class FileReaderFacory {
	
	 public static FileReader createFileReader(String filePath){
		 File f = new File(filePath);
		 if(f.exists() && !f.isDirectory() && filePath.endsWith(".desc")) { 
	         return new FileReader(filePath);    
	      } else {
	    	 System.out.println("invalid file path");
		     return null;
	      }
	      
	   }

}

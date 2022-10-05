package analytics_lib;


public class FileReaderFacory {
	
	 public static fileReader createFileReader(String filePath){
	      if(filePath.equalsIgnoreCase(filePath)){
	         return new fileReader();    
	      } else {
	    	 System.out.println("invalid");
		     return null;
	      }
	      
	   }

}

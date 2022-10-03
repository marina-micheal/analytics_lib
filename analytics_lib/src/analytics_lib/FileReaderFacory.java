package analytics_lib;

public class FileReaderFacory {
	
	 public fileReader getShape(String filePath){
	      if(filePath == null){
	         return null;
	      }		
	      if(filePath.equalsIgnoreCase("C:\\Users\\webse\\OneDrive\\Documents\file.desc")){
	         return new fileReader();
	         
	      } 
	      System.out.println("invalid");
	      return null;
	   }

}

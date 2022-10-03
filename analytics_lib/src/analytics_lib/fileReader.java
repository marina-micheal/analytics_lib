package analytics_lib;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class fileReader {

	public void readFile(String filePath) {
		Scanner scanner =new Scanner(System.in);
		filePath=scanner.next();
		 if (filePath.endsWith("desc")) {
		 
		 try {
		      File myObj = new File(filePath);
		      Scanner myReader = new Scanner(myObj);
		      while (myReader.hasNextLine()) {
		    	  int operations=myReader.nextInt();
	    		  myReader.nextLine();
		    	  for(int i =0;i< operations;i++) {
		    		  String line=myReader.nextLine();
		    		  String[] parts = line.split(" ");
		    		  int firstNumFile = Integer.parseInt(parts[0]) ; 
		    		  System.out.println(firstNumFile);
		    		  
		    		 
		    		  String operatorFile=parts[1];
		    		  System.out.println(operatorFile);
		    		  
		    		  int secondNumFile = Integer.parseInt(parts[2]) ; 
		    		  System.out.println(secondNumFile);

		    		 
		    		  Calculator calc = new Calculator();
		    		  int resultFile=calc.calculate(operatorFile,firstNumFile,secondNumFile);
		    		  System.out.println(resultFile);
		    	  }
		      }
		      myReader.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		 }
	}
}

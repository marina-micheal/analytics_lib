package analytics_lib;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ArrOpMenu implements ISubMenu {
	ArrayList<Integer> nums = null;
	Scanner sc = null;
	Logger logger;

	public ArrOpMenu() {
		nums = new ArrayList<>();
		sc = new Scanner(System.in);
		logger = Logger.getInstance(LogLevel.LOG_LEVEL_DEFAULT);
	}
	
	private void scanNewArray() {
		nums.clear();

		logger.log("Please enter array length: ");
		int numOfNumbers = sc.nextInt(); 
		for(int i = 0; i < numOfNumbers; i++) {
			logger.log("Write a new number to add to array: ");
			int num;
			num = sc.nextInt();
			nums.add(num);	
		}
		logger.log("Your array: " + nums);

	}
	// options operated on the array when given
	private int printArrayOpMenu() {
		
		logger.log("\nWhat operation you want to make on the array\r\n" 
				+ "(1) Print maximum\r\n"
				+ "(2) Print minimum\r\n"
				+ "(3) Print mean\r\n"
				+ "(4) Print sorted array\r\n"
				+ "(5) Search for number\r\n"
				+ "(6) Create a new array\r\n"
				+ "(7) Return back to main menu\r\n"
				+ "Please enter your choice: ");
		int Op = sc.nextInt();
		return Op;
	}
	
	@Override
	public void mainLoop() {
		Op();
	}
	
	public void Op() {
		scanNewArray();
		Boolean exitFlag = false;		
		do {
			int op = printArrayOpMenu();
			switch(op) {
			case 1:
				int max = Collections.max(nums);
			
				logger.log(max);
				break;
				
			case 2:
				int min = Collections.min(nums);
			
				logger.log(min);
				break;
				
			case 3:
				 int total = 0;
				 int avg;
				 for(int i = 0; i < nums.size(); i++)
				        total += nums.get(i);
				 
				 avg = total / nums.size(); // finding the average value
			
				 logger.log("The Average is: " + avg);
				 break;
				 
			case 4:
				Collections.sort(nums);
				logger.log(nums);
				break;
				
			case 5:
				
				logger.log("what is the number zou want to search for?");
				
				
				int searchNum=sc.nextInt();
				if(nums.contains(searchNum)) {
					
					logger.log(nums.indexOf(searchNum) + 1);
				}
				break;
				
			case 6:
				scanNewArray();
				break;
				
			case 7:
				exitFlag = true;
				break;

			default:
			
				logger.log("Invalid operation number, choose correct choice");
				continue;				
			}
			
		} while (Boolean.FALSE.equals(exitFlag));
	}
	
}
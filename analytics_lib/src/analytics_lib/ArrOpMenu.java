package analytics_lib;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Array operations sub menu, implementing ISubMenu interface.
 * @author Marina
 */
public class ArrOpMenu implements ISubMenu {
	ArrayList<Integer> nums = null; /**< Numbers list to operate on. */
	Scanner sc = null; /**< Scanner to read user inputs from console. */
	Logger logger; /**< Logger to log the messages to user on console. */

	/**
	 * Class default constructor.
	 */
	public ArrOpMenu() {
		nums = new ArrayList<>();
		sc = new Scanner(System.in);
		logger = Logger.getInstance(LogLevel.LOG_LEVEL_DEFAULT);
	}
	
	/**
	 * Scan the input array to operate on.
	 */
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

	/**
	 * Prints the array operations menu and parses the user input.
	 * @return User selected operation.
	 */
	private int printArrayOpMenu() {
		
		logger.log("""
					What operation you want to make on the array?
					(1) Print maximum
					(2) Print minimum
					(3) Print mean
					(4) Print sorted array
					(5) Search for number
					(6) Create a new array
					(7) Return back to main menu
					Please enter your choice:
					""");
		return sc.nextInt();
	}
	
	/**
	 * Array operations menu main loop.
	 */
	@Override
	public void mainLoop() {
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
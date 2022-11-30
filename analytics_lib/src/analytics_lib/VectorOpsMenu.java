package analytics_lib;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Vector operations sub menu, implementing ISubMenu interface.
 * @author Marina
 */
public class VectorOpsMenu implements ISubMenu {
	static final String RESULT_MSG = "Result vector elements: "; /**< Constant user message to be logged. */
	ArrayList<Integer> vec1 = null; /**< Objects list for the first vector. */
	ArrayList<Integer> vec2 = null; /**< Objects list for the second vector. */
	Scanner sc = null; /**< Scanner to read user inputs from console. */
	Logger logger; /**< Logger to log the messages to user on console. */

	/**
	 * Class default constructor.
	 */
	public VectorOpsMenu() {
		vec1 = new ArrayList<>();
		vec2 = new ArrayList<>();
		sc = new Scanner(System.in);
		logger = Logger.getInstance(LogLevel.LOG_LEVEL_DEFAULT);
	}
	
	/**
	 * Reads from the user the first and the second vectors.
	 */
	private void scanNewVectors() {
		vec1.clear();
		vec2.clear();
		
		logger.log("Please enter vector length: ");
		
		int numOfNumbers = sc.nextInt(); 
		for(int i = 0; i < numOfNumbers; i++) {
			
			logger.log("Write a new number to add to first vector: ");
			int num;
			num = sc.nextInt();
			vec1.add(num);	
		}
		
		logger.log("First vector elements: " + vec1);
		logger.log("\r\n");
	
		for(int i = 0; i < numOfNumbers; i++) {
	
			logger.log("Write a new number to add to second vector: ");
			int num;
			num = sc.nextInt();
			vec2.add(num);	
		}
	
		logger.log("Second vector elements: " + vec2);
		
	}
	
	/**
	 * Prints the vector operations sub menu, and reads from the user the selected operation.
	 * @return Character representing the selected operation.
	 */
	private char printArrayOpMenu() {
		if (vec1.size() <= 3) {
			logger.log("""
						What operation you want to make on the vectors?
						(a) Add vectors
						(s) Subtract vectors
						(*) Vectors element-wise multiplication
						(.) Vectors dot product
						(x) Vectors cross product
						(1) First vector magnitude
						(2) Second vector magnitude
						(r) Enter new vectors
						(e) Exit this menu
						Please enter your choice: 
						""");
		
		} else {
			logger.log("""
					What operation you want to make on the vectors?
					(a) Add vectors
					(s) Subtract vectors
					(*) Vectors element-wise multiplication
					(.) Vectors dot product
					(1) First vector magnitude
					(2) Second vector magnitude
					(r) Enter new vectors
					(e) Exit this menu
					Please enter your choice: 
					""");
		}
		String scan;
		do {
			scan = sc.nextLine();
			
		} while (scan.length() <= 0);
			
		return scan.charAt(0);
	}
	
	/**
	 * Adds the two vectors and prints the result.
	 */
	private void addTwoVectors() {
		ArrayList<Integer> sumVec = new ArrayList<>();
		for(int i = 0; i < vec1.size(); i++) {
			sumVec.add(vec1.get(i) + vec2.get(i));	
		}

		logger.log(RESULT_MSG + sumVec);
	}
	
	/**
	 * Subtracts the second vector from the first vector and prints the result.
	 */
	private void subTwoVectors() {
		ArrayList<Integer> subVec = new ArrayList<>();
		for(int i = 0; i < vec1.size(); i++) {
			subVec.add(vec1.get(i) - vec2.get(i));	
		}

		logger.log(RESULT_MSG + subVec);
	}
	
	/**
	 * Performs element wise multiplication between the two vectors and prints the result.
	 */
	private void elmMulTwoVectors() {
		ArrayList<Integer> mulVec = new ArrayList<>();
		for(int i = 0; i < vec1.size(); i++) {
			mulVec.add(vec1.get(i) * vec2.get(i));	
		}
		
		logger.log(RESULT_MSG + mulVec);
	}
	
	/**
	 * Performs dot product between the two vectors and prints the result.
	 */
	private void dotProdTwoVectors() {
		int sum = 0;
		for(int i = 0; i < vec1.size(); i++) {
			sum += vec1.get(i) * vec2.get(i);	
		}
	
		logger.log("Dot product result: " + sum);
	}
	
	/**
	 * Performs cross product between the two vectors and prints the result.
	 */
	private void crsProdTwoVectors() {
		if (vec1.size() > 3) {
			logger.log("Invalid vector length, vectors length should be less than or equal to 3\r\n");
		} else {
			ArrayList<Integer> mulVec = new ArrayList<>();
			mulVec.add((vec1.get(1) * vec2.get(2)) - (vec1.get(2) * vec2.get(1)));
			mulVec.add((vec1.get(2) * vec2.get(0)) - (vec1.get(0) * vec2.get(2)));
			mulVec.add((vec1.get(0) * vec2.get(1)) - (vec1.get(1) * vec2.get(0)));
			
			logger.log(RESULT_MSG + mulVec);
		}
	}
	
	/**
	 * Prints first vector magnitude.
	 */
	private void printVector1Mag() {
		int sum = 0;
		for(int i = 0; i < vec1.size(); i++) {
			sum += vec1.get(i) * vec1.get(i);	
		}
		
		logger.log("Vector 1 magnitude: " + Math.sqrt(sum));
	}
	
	/**
	 * Prints second vector magnitude.
	 */
	private void printVector2Mag() {
		int sum = 0;
		for(int i = 0; i < vec2.size(); i++) {
			sum += vec2.get(i) * vec2.get(i);	
		}
		
		logger.log("Vector 2 magnitude: " + Math.sqrt(sum));
	}
	
	/**
	 * Executes vector operations sub menu main loop.
	 */
	@Override
	public void mainLoop() {
		scanNewVectors();
		Boolean exitFlag = false;		
		do {
			char op = printArrayOpMenu();
			switch(op) {
			case 'a':
				addTwoVectors();
				break;
				
			case 's':
				subTwoVectors();
				break;
				
			case '*':
				elmMulTwoVectors();
				 break;
				 
			case '.':
				dotProdTwoVectors();
				break;
				
			case 'x':
				crsProdTwoVectors();
				break;
				
			case '1':
				printVector1Mag();
				break;
				
			case '2':
				printVector2Mag();
				break;
				
			case 'r':
				scanNewVectors();
				break;
				
			case 'e':
				exitFlag = true;
				break;

			default:
			
				logger.log("Invalid operation, choose correct choice");
				continue;				
			}
			
		} while (Boolean.FALSE.equals(exitFlag));
	}
}

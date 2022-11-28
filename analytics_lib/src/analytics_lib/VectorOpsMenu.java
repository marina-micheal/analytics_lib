package analytics_lib;

import java.util.Vector;
import java.util.Scanner;
import java.lang.Math;

public class VectorOpsMenu implements ISubMenu {
	Vector<Integer> vec1 = null;
	Vector<Integer> vec2 = null;
	Scanner sc = null;
	Logger logger;

	public VectorOpsMenu() {
		vec1 = new Vector<Integer>();
		vec2 = new Vector<Integer>();
		sc = new Scanner(System.in);
		logger = Logger.getInstance(LogLevel.LOG_LEVEL_DEFAULT);
	}
	
	private void scanNewVectors() {
		vec1.clear();
		vec2.clear();
		
		logger.log("Please enter vector length: ");
		
		int NumOfNumbers = sc.nextInt(); 
		for(int i = 0; i < NumOfNumbers; i++) {
			
			logger.log("Write a new number to add to first vector: ");
			int num;
			num = sc.nextInt();
			vec1.add(num);	
		}
		System.out.print("First vector elements: " + vec1);
		
		System.out.print("\r\n");
		for(int i = 0; i < NumOfNumbers; i++) {
			System.out.print("Write a new number to add to second vector: ");
			int num;
			num = sc.nextInt();
			vec2.add(num);	
		}
		System.out.print("Second vector elements: " + vec2);
	}
	
	private char printArrayOpMenu() {
		if (vec1.size() <= 3) {
			System.out.print("\nWhat operation you want to make on the vectors\r\n" 
					+ "(a) Add vectors\r\n"
					+ "(s) Subtract vectors\r\n"
					+ "(*) Vectors elementwise multiplication\r\n"
					+ "(.) Vectors dot product\r\n"
					+ "(x) Vectors cross product\r\n"
					+ "(1) First vector magnitude\r\n"
					+ "(2) Second vector magnitude\r\n"
					+ "(r) Enter new vectors\r\n"
					+ "(e) Exit this menu\r\n"
					+ "Please enter your choice: ");
		} else {
			System.out.print("\nWhat operation you want to make on the vectors\r\n" 
					+ "(a) Add vectors\r\n"
					+ "(s) Subtract vectors\r\n"
					+ "(*) Vectors elementwise multiplication\r\n"
					+ "(.) Vectors dot product\r\n"
					+ "(1) First vector magnitude\r\n"
					+ "(2) Second vector magnitude\r\n"
					+ "(r) Enter new vectors\r\n"
					+ "(e) Exit this menu\r\n"
					+ "Please enter your choice: ");
		}
		String scan;
		do {
			scan = sc.nextLine();
			
		} while (scan.length() <= 0);
			
		return scan.charAt(0);
	}
	
	@Override
	public void mainLoop() {
		Op();
	}

	private void addTwoVectors() {
		Vector<Integer> sumVec = new Vector<Integer>();
		for(int i = 0; i < vec1.size(); i++) {
			sumVec.add(vec1.get(i) + vec2.get(i));	
		}
		System.out.print("Result vector elements: " + sumVec);
	}
	
	private void subTwoVectors() {
		Vector<Integer> subVec = new Vector<Integer>();
		for(int i = 0; i < vec1.size(); i++) {
			subVec.add(vec1.get(i) - vec2.get(i));	
		}
		System.out.print("Result vector elements: " + subVec);
	}
	
	private void elmMulTwoVectors() {
		Vector<Integer> mulVec = new Vector<Integer>();
		for(int i = 0; i < vec1.size(); i++) {
			mulVec.add(vec1.get(i) * vec2.get(i));	
		}
		System.out.print("Result vector elements: " + mulVec);
	}
	
	private void dotProdTwoVectors() {
		int sum = 0;
		for(int i = 0; i < vec1.size(); i++) {
			sum += vec1.get(i) * vec2.get(i);	
		}
		System.out.print("Dot product result: " + sum);
	}
	
	private void crsProdTwoVectors() {
		if (vec1.size() > 3) {
			System.out.print("Invalid vector length, vectors length should be less than or equal to 3\r\n");
			return;
		} else {
			Vector<Integer> mulVec = new Vector<Integer>();
			mulVec.add((vec1.get(1) * vec2.get(2)) - (vec1.get(2) * vec2.get(1)));
			mulVec.add((vec1.get(2) * vec2.get(0)) - (vec1.get(0) * vec2.get(2)));
			mulVec.add((vec1.get(0) * vec2.get(1)) - (vec1.get(1) * vec2.get(0)));
			System.out.print("Result vector elements: " + mulVec);
		}
	}
	
	private void printVector1Mag() {
		int sum = 0;
		for(int i = 0; i < vec1.size(); i++) {
			sum += vec1.get(i) * vec1.get(i);	
		}
		System.out.print("Vector 1 magnitude: " + Math.sqrt(sum));
	}
	
	private void printVector2Mag() {
		int sum = 0;
		for(int i = 0; i < vec2.size(); i++) {
			sum += vec2.get(i) * vec2.get(i);	
		}
		System.out.print("Vector 2 magnitude: " + Math.sqrt(sum));
	}
	
	public void Op() {
		scanNewVectors();
		Boolean exit_flag = false;		
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
				exit_flag = true;
				break;

			default:
				System.out.println("Invalid operation, choose correct choice");
				continue;				
			}
			
		} while (!exit_flag);
	}
	
}

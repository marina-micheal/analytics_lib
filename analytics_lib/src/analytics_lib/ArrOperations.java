package analytics_lib;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ArrOperations {
	ArrayList<Integer> Nums = new ArrayList<Integer>();
	Scanner sc =new Scanner(System.in);

	public ArrOperations() {
		
		System.out.print("what is the number of Numbers you want to write in the array?");
		int NumOfNumbers= sc.nextInt(); 
		for(int i =0;i < NumOfNumbers ;i++) {
			System.out.print("put number you want");
			int num;
			num=sc.nextInt();
			Nums.add(num);	
		}
		System.out.print("Your array" + Nums);
		
	}
	
	
	
	
	public void Op() {
		System.out.print("what operation you want to make on the array\r\n" 
				+ "1-Print maximum\r\n"
				+ "2-Print minimum\r\n"
				+ "3-Print mean\r\n"
				+ "4-Print sorted array\r\n"
				+ "5-Search for number\r\n"
				+ "6-Return back to main menu");
		int Op=sc.nextInt();
		if(Op == 1) {
			int max = Collections.max(Nums);
			System.out.println(max);
		}else if(Op == 2) {
			int min = Collections.min(Nums);
			System.out.println(min);
		}else if(Op == 3) {
			 int total = 0;
			 int avg;
			 for(int i = 0; i < Nums.size(); i++)
			        total += Nums.get(i);
			 
			 avg = total / Nums.size(); // finding the average value
			 System.out.println("The Average is: " + avg);
			
		}else if(Op == 4) {
			Collections.sort(Nums);
			System.out.println(Nums);	
		}else if(Op == 5) {
			System.out.println("what is the number zou want to search for?");
			int searchNum=sc.nextInt();
			if(Nums.contains(searchNum)) {
				System.out.println(Nums.indexOf(searchNum) + 1);
			}
			
		}else if(Op == 6) {
			
			//continue;
			
		}else {
			System.out.println("inavlid operation number");
			
		}
	}
	
	}
	
	
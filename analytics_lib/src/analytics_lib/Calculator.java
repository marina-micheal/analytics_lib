package analytics_lib;

public class Calculator {
	
	public static int calculate (SimpleOpData opData) {
		int result;
		
		if (opData == null) {
			result = 0;
		} else {
			result = calculate(opData.getOp(), opData.getFirstNum(), opData.getSecondNum());
		}
		
		return result;
	}
	
	public static int calculate(String operator, int firstNum, int secondNum) {
		if(operator.equals("+")) {
			int add=firstNum + secondNum;
			return add;
		}else if (operator.equals("-")) {
			int sub=firstNum - secondNum;
			return sub;
		}else if (operator.equals("*")) {
			int mul=firstNum * secondNum;
			return mul;
		}else if (operator.equals("/")) {
			
			if(secondNum == 0) {
				System.out.println("inavlid number");
				return 0;
			}else {
				int div=firstNum / secondNum;
				return div;
			}
			
		}else if (operator.equals("%")) {
			if(secondNum == 0) {
				System.out.println("inavlid number");
				return 0;
			}else {
				int mod=firstNum % secondNum;
				return mod;
			}
		}else {
			System.out.println("invalid operator");
			return 0;
		}
	}

}
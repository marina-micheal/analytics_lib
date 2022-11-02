package analytics_lib;

public class OperationData {
	private String op;
	private int firstNum;
	private int secondNum;
	
	public OperationData (String opParam, int firstNumParam, int secondNumParam) {
		op = opParam;
		firstNum = firstNumParam;
		secondNum = secondNumParam;
	}
	
	public String getOp( ) {
		return op;
	}
	
	public int getFirstNum() {
		return firstNum;
	}
	
	public int getSecondNum() {
		return secondNum;
	}
}

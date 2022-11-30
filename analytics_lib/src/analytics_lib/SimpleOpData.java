package analytics_lib;

/**
 * Class representing immutable simple operation to be performed.
 * @author Marina
 *
 */
public class SimpleOpData {
	private String op; /**< Character representing operation to be performed. */
	private int firstNum; /**< First operand. */
	private int secondNum; /**< Second operand. */
	
	/**
	 * Constructor to create immutable simple operation object.
	 * @param opParam character representing operation to be performed.
	 * @param firstNumParam first operand as integer.
	 * @param secondNumParam second operand as integer.
	 */
	public SimpleOpData (String opParam, int firstNumParam, int secondNumParam) {
		op = opParam;
		firstNum = firstNumParam;
		secondNum = secondNumParam;
	}
	
	/**
	 * Returns the operation to be performed.
	 * @return character representing the operation.
	 */
	public String getOp( ) {
		return op;
	}
	
	/**
	 * Returns the first operand.
	 * @return integer as first operand.
	 */
	public int getFirstNum() {
		return firstNum;
	}
	
	/**
	 * Returns the second operand.
	 * @return integer as second operand.
	 */
	public int getSecondNum() {
		return secondNum;
	}
}

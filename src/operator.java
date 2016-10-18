import java.util.*;

public class operator {
	private String operater1 = "+";
	private String operater2 = "-";
	private String operater3 = "*";
	private String operater4 = "/";
	private String operater5 = "(";
	private String operater6 = ")";

	public double Cul(String oper, float a, float b) {
		switch (oper) {
		case "+":
			return a + b;
		case "-":
			return a - b;
		case "*":
			return a * b;
		case "/":
			return a / b;
		default:
			return 0.0;
		}
	}
}
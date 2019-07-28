import java.util.Scanner;
import java.util.Stack;

public class Calculator {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter A Expression : ");
		String expression = scan.nextLine();
		scan.close();
		
			
		Double result = evaluate(expression);
		
		System.out.println(result);
	}
	
	public static Double operation(Double a, Double b, Character ch) {
		Double result = 0.0;
		
		switch(ch) {
			case '/' :
				if(b==0)
					break;
				result = a/b;
				break;
			case '*' :
				result = a*b;
				break;
			case '+' :
				result = a+b;
				break;
			case '-' :
				result = a-b;
		}
		
		return result;
	}
	
	public static Boolean hasPrecedence(char op1, char op2) { 
        if (op2 == '(' || op2 == ')') 
            return false; 
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-')) 
            return false; 
        else
            return true; 
    }

	public static Double evaluate(String expression) { 
        char[] tokens = expression.toCharArray(); 
        return evaluateExpression(tokens); 
    }

	public static Double evaluateExpression(char[] tokens) { 
        
		
        return null;
    }
     
}


/*
 100+100/100*100-100
 */

/*
 * 
 * Stack<Double> values = new Stack<>(); 
        Stack<Character> ops = new Stack<>(); 
for (int i = 0; i < tokens.length; i++) {
if (tokens[i] == ' ') 
    continue; 

if (tokens[i] >= '0' && tokens[i] <= '9') { 
    StringBuffer sbuf = new StringBuffer(); 
    while (i < tokens.length && tokens[i] >= '0' && tokens[i] <= '9') 
        sbuf.append(tokens[i++]); 
    values.push(Double.parseDouble(sbuf.toString())); 
} 

else if (tokens[i] == '(') 
    ops.push(tokens[i]); 

else if (tokens[i] == ')') { 
    while (ops.peek() != '(') 
      values.push(operation(values.pop(), values.pop(), ops.pop())); 
    ops.pop(); 
} 

else if (tokens[i] == '+' || tokens[i] == '-' || 
         tokens[i] == '*' || tokens[i] == '/') { 
    while (!ops.empty() && hasPrecedence(tokens[i], ops.peek())) 
      values.push(operation(values.pop(), values.pop(), ops.pop())); 

    ops.push(tokens[i]); 
} 
} 

while (!ops.empty()) 
            values.push(operation(values.pop(), values.pop(), ops.pop()));
*/
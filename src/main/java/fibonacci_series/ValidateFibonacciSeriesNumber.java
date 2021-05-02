package fibonacci_series;

public class ValidateFibonacciSeriesNumber {
	
	public static void main(String... s) {
		for(int i=0; i<10; i++) {
			println(i + ((isFibonacci(i)) ? " is Fibonacci Number." : " is not Fibonacci Number."));
		}
	}
	
	// Validate number is fibonacci or not
	public static boolean isFibonacci(int n) {
		return isPerfectSquare(5*n*n + 4) || isPerfectSquare(5*n*n - 4);
	}
	
	// Given number perfect square or not
	public static boolean isPerfectSquare(int x) {
		int s = (int)Math.sqrt(x);
		return ( Math.pow(s,2)==x);
	}
	
	public static <T> void println(T message) {
		System.out.println(message);
	}
	
	public static <T> void print(T message) {
		System.out.print(message + "\t");
	}
	
}
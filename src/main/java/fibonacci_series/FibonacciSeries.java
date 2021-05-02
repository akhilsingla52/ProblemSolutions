package fibonacci_series;

public class FibonacciSeries {
	
	public static void main(String... s) {
		int first = 0, second=1, temp=0;
		
		println("Print Fibonacci Series : ");
		print(first);
		print(second);
		for(int i=2; i<10; i++) {
			temp = first + second;
			print(temp);
			first = second;
			second = temp;
		}
	}
	
	public static <T> void println(T message) {
		System.out.println(message);
	}
	
	public static <T> void print(T message) {
		System.out.print(message + "\t");
	}
	
}
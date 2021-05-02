package fibonacci_series;

import java.util.Scanner;

// Java program to find n-th Fibonacci number 
class FibonacciSeriesStartsGivenNumber {
	// Approximate value of golden ratio
	final static double PHI = 1.6180339;

	// Fibonacci numbers upto n = 5
	static int f[] = { 0, 1, 1, 2, 3, 5 };

	// Function to find next fibonacci number using previous fibonacci number
	public static int nextFibonacciNumber(int previousNumber) {
		if (previousNumber > 1)
			return (int) Math.round(previousNumber * PHI);
		else
			return 1;
	}

	// Given number perfect square or not
	public static boolean isPerfectSquare(int x) {
		int s = (int) Math.sqrt(x);
		return (Math.pow(s, 2) == x);
	}

	// Validate number is fibonacci or not
	public static boolean isFibonacci(int n) {
		return isPerfectSquare(5 * n * n + 4) || isPerfectSquare(5 * n * n - 4);
	}

	public static void main(String[] args) {
		int first, second, temp, length;
		try (Scanner scan = new Scanner(System.in)) {
			print("Enter a fibonacci number : ");
			first = scan.nextInt();

			if (isFibonacci(first)) {
				second = nextFibonacciNumber(first);
			} else {
				println(first + " number is not fibonacci");
				return;
			}

			print("Enter series length : ");
			length = scan.nextInt();
		}

		println("Print Fibonacci Series : ");
		print(first);
		print(second);
		for (int i = 2; i < length; i++) {
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

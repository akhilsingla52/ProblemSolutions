import java.util.Scanner;

public class NumberOne {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		Integer exit;
		
		do {
			System.out.println("======================================================================================================");
			System.out.print("Enter Any Number : ");
			Long n = scan.nextLong();
			
			final long time1 = System.nanoTime();
			
			Integer count = 0;
			while(n!=1) {
				if(n % 3 == 1)
					n = n - 1;
				else if(n % 3 == 0)
					n = n / 3;
				else if(n % 2 == 0)
					n = n / 2;
				else
					n= n - 1;
				
				count++;
			}
			
			final long time2 = System.nanoTime();
			
			System.out.println("Total steps for make number 1 : "+count);
			System.out.println( (time2-time1)/1000000000.0 );
			
			System.out.print("\n\n\nEnter 0 for exit : ");
			exit = scan.nextInt();
			System.out.println("\n\n\n");
		} while (exit!=0);
		
		scan.close();
	}
	
}

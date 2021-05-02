package coin;

import java.util.Scanner;

public class MinimumCoinCount {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		Integer exit;
		
		do {
			System.out.println("======================================================================================================");
			System.out.print("Enter Any Price : ");
			Long n = scan.nextLong();
			
			final long time1 = System.nanoTime();
			
			Long count = 0L;
			Long totalCount = 0L;
			while(n!=0) {
				if(n>=5 && n % 5 >= 0) {
					count = n / 5;
					totalCount += count;
					System.out.println("Coin of five rupees : "+count);
					n = n % 5;
				} else if(n>=3 && n % 3 >= 0) {
					count = n / 3;
					totalCount += count;
					System.out.println("Coin of three rupees : "+count);
					n = n % 3;
				} else {
					count = n / 1;
					totalCount += count;
					System.out.println("Coin of one rupees : "+ count);
					n = n % 1;
				}
			}
			
			final long time2 = System.nanoTime();
			
			System.out.println("Total count of coins : "+totalCount);
			System.out.println( (time2-time1)/1000000000.0 );
			
			System.out.print("\n\n\nEnter 0 for exit : ");
			exit = scan.nextInt();
			System.out.println("\n\n\n");
		} while (exit!=0);
		
		scan.close();
	}
}

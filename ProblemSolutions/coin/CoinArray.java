import java.util.Scanner;

public class CoinArray {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Integer exit;
		
		do {
			System.out.println("======================================================================================================");
			System.out.println("Coin Matrix");
			System.out.print("Enter no of rows : ");
			int row = scan.nextInt();
			System.out.print("Enter no of columns : ");
			int col = scan.nextInt();
			
			Long[][] coinMat = new Long[row][col]; 
			
			System.out.println("Enter Matrix values for "+row+" x "+col);
			for(int i=0; i<row; i++) {
				for(int j=0; j<col; j++) {
					System.out.print("Enter Matrix value for row "+(i+1)+", col "+(j+1)+" : ");
					coinMat[i][j] = scan.nextLong();
				}
				System.out.println();
			}
			
			final long time1 = System.nanoTime();
			
			
			
			final long time2 = System.nanoTime();
			
			System.out.println( (time2-time1)/1000000000.0 );
			
			System.out.print("\n\n\nEnter 0 for exit : ");
			exit = scan.nextInt();
			System.out.println("\n\n\n");
		} while (exit!=0);
		
		scan.close();
	}
}

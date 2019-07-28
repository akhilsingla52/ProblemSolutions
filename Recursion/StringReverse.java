import java.util.Scanner;

public class StringReverse {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter A String : ");
		String string = scan.nextLine();
		scan.close();
		
		System.out.println("Reverse String : " + reverse(string));		
		
	}
	
	public static String reverse(String string) {
		if(string.length()==1)
			return string;
		else
			return reverse(string.substring(1)) + string.charAt(0);
	}

}

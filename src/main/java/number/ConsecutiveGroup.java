package number;

public class ConsecutiveGroup {
	
	public static void main(String[] args) {
		int[] numbers = {1, 2, 3, 4, 3, 2, 4, 1, 5, 2, 5, 6, 77, 2, 1, 4, 5, 66, 66, 67, 68, 69, 69, 93} ;
		
		int max = 0;
		int count = 0;
		int prevNum = 0;
		
		for(int number : numbers) {
			if(count==0) {
				count++;
			} else if(prevNum <= number) {
				count++;
			} else {
				if(max < count) max = count;
				count = 1;
			}
			prevNum = number;
		}

		if(max < count) max = count;
		
		System.out.println("Max count of consecutive increase no. : "+max);
	}

}

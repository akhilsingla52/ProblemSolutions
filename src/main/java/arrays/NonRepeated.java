package arrays;

public class NonRepeated {

	//public int[] numbers = new int[]{1, 2, 1, 3, 2};
	
	public static void main(String[] args) {
		int[] numbers = {-2, -3, -1, 4, -2, -1, -3};
		
		System.out.println("Non Repeating Number : " + getNonRepeatingNumber(numbers));
	}
	
	public static Integer getNonRepeatingNumber1(int[] numbers) {
		for(int i =0; i<numbers.length; i++) {
			for(int j=0; j<numbers.length; j++) {
				if(i!=j && numbers[i]==numbers[j])
					break;
				if(j==numbers.length-1)
					return numbers[i];
			}
		}
		
		return null;
	}
	
	/**
	 * ^ = XOR operator
	 * 4 ^ 6 equals
	 * 4 = 0100
	 * 6 = 0110
	 * r = 0010 = 2
	 */
	public static Integer getNonRepeatingNumber(int[] numbers) {
		int num = 0;
		for(int i =0; i<numbers.length; i++) {
			num = num ^ numbers[i];
		}
		
		return num;
	}
}

package arrays;

class Kadane {
	public static void main (String[] args) {
		int [] a = {-2, -3, 4, -1, -2, 1, 5, -3};
		maxSubArraySum(a);
	}

	public static void maxSubArraySum(int a[]) {
		int size = a.length;
		int sum = Integer.MIN_VALUE;
		int tempSum = 0;
		int startIndex = 0;
		int[] result = new int[3];

		for (int i = 0; i < size; i++) {
			tempSum = tempSum + a[i];
			if (sum < tempSum) {
				sum = tempSum;
				result[0] = startIndex+1;
				result[1] = i+1;
				result[2] = sum;
			}
			if (tempSum < 0) {
				tempSum = 0;
				startIndex = i+1;
			}
		}
		System.out.print("Start : "+result[0]);
		System.out.println("\tEnd : "+result[1]);
		System.out.println("------------------------");
		System.out.println("Sum : "+result[2]);
	}
}

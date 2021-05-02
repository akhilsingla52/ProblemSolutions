package other;

public class Problem1
{
    public static int[][] function(int[] input_collection, int size, int step) {
        int value = input_collection.length/step;
        int[][] result = new int[value][size];
        int k=0,l=0;
        for(int i=0; i<input_collection.length; i=i+step) {
            if(input_collection.length >= i+size) {
                l=0;
                for(int j=i; j<i+size; j++) {
                   result[k][l] = input_collection[j];
                   l++;
                }
                k++;
            }
        }
        return result;
    }
    
    public static void display(int[][] result) {
        System.out.print("[");
        for(int i=0; i<result.length; i++) {
            System.out.print("[");
            for(int j=0; j<result[i].length; j++) {
                System.out.print(result[i][j]+",");
            }
            System.out.print("] ");
        }
        System.out.print("]");
    }
    
	public static void main(String[] args) {
		int[] input_collection = {1,2,3,4,5,6};
		display(function(input_collection,2,2));
		System.out.println("");
		display(function(input_collection,2,3));
		System.out.println("");
		display(function(input_collection,3,4));
	}
}

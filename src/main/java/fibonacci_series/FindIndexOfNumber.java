package fibonacci_series;
// Fibonacci number 
public class FindIndexOfNumber  { 
  
  public static int findIndex(int n) { 
    float fibo = 2.078087F * (float) Math.log(n) + 1.672276F; 
    // returning rounded off value of index 
    return Math.round(fibo); 
  } 
  
  public static void main(String[] args) 
  { 
    int result = findIndex(55); 
    System.out.println(result); 
  } 
}
import java.util.*;

public class Fibonacci_Sequence {
    public int fibonacci(int n) {
        int [] fibArray = new int[40];
        fibArray[1]= 0 ;
        fibArray[2]= 1;  // already defined

        for (int i=3 ; i<40; i++){
            fibArray[i] = fibArray[i-1]+fibArray[i-2];
        }

        return fibArray[n] ;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int value = new Fibonacci_Sequence().fibonacci(number);
        System.out.println(value);
    }
}
import java.util.*;

public class Sum_Even_and_Odd {
    public int[] sumEvenOdd(int[] array) {
    	int[] sum = {0,0} ;
        for (int i = 0; i < array.length ; i++) {
            if(array[i]%2==0) {
                sum[0] += array[i];
            }else {
                sum[1] +=array[i];
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String in = scanner.nextLine().replaceAll("\\[|\\]", "");
        String[] s = in.split(", ");;
        int[] numbers = new int[s.length];
        if (s.length == 1 && s[0].isEmpty())
            numbers = new int[]{};
        else {
            for(int i = 0; i < s.length; ++i)
                numbers[i] = Integer.parseInt(s[i]);
        }
        int[] result = new Sum_Even_and_Odd().sumEvenOdd(numbers);
        System.out.println(Arrays.toString(result));

    }
}
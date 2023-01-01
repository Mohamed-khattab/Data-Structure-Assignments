import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Array_average_value {
    public double average(int[] array) {
        double av ; int sum =0 ;
        if(array.length !=0) {
            for (int i = 0; i < array.length; i++) {
                sum += array[i];
            }
            av = (double) sum / array.length;
            return av;
        }else {
            return 0.0 ;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String in = scanner.nextLine().replaceAll("\\[|\\]", "");
        String[] s = in.split(", ");
        int[] array = new int[s.length];
        if (s.length == 1 && s[0].isEmpty())
            array = new int[]{};
        else {
            for(int i = 0; i < s.length; ++i)
                array[i] = Integer.parseInt(s[i]);
        }
        
        double average = new Array_average_value().average(array);
        System.out.println(average);
    
    
    }
}


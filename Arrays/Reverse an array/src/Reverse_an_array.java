import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Reverse_an_array {
    public int[] reverse(int[] array){
        int size = array.length; int temp ;
        for (int i = 0; i <size/2 ; i++) {
            temp = array[i]; array[i] = array[size-i-1];
            array[size-i-1] = temp ;
        }
        return array;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String sin = sc.nextLine().replaceAll("\\[|\\]", "");
        String[] s = sin.split(", ");;
        int[] arr = new int[s.length];
        if (s.length == 1 && s[0].isEmpty())
            arr = new int[]{};
        else {
            for(int i = 0; i < s.length; ++i)
                arr[i] = Integer.parseInt(s[i]);
        }
        int[] res = new Reverse_an_array().reverse(arr);
        System.out.print("[");
        for(int i = 0; i < res.length; ++i) {
            System.out.print(res[i]);
            if(i != s.length - 1)
                System.out.print(", ");
        }
        System.out.print("]");
    }
}
// Online Java Compiler
// Use this editor to write, compile and run your Java code online

import java.util.Arrays;
import java.util.Scanner;
import static java.lang.Math.sqrt;
public class Transpose_2d_array {
    public int[][] transpose(int[][] array) {
        int[][] transposeArray = new int[array.length][array.length];

        for(int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                transposeArray[i][j]=array[j][i];
            }
        }
        return transposeArray;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String in = sc.nextLine().replaceAll("\\[|\\]", "");
        String[] s = in.split(", ");;
        int[][] array = new int[(int)sqrt(s.length)][(int)sqrt(s.length)];

        if (s.length == 1 && s[0].isEmpty())
            array = new int[0][];
        else {
            int x =0 ;
            for(int i = 0; i < sqrt(s.length); ++i){
                for(int j = 0; j < sqrt(s.length); ++j) {
                    array[i][j] = Integer.parseInt(s[x++]);
                }
            }
        }
        int [][] transpose = new Transpose_2d_array().transpose(array) ;
        if (transpose.length==0)
            System.out.println("[[]]");
        else
        System.out.println(Arrays.deepToString(transpose));
    }
}
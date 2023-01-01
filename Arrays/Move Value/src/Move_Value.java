import java.util.*;

public class Move_Value {
    public int[] moveValue(int[] array, int value) {
       int[] tempArray = new int[array.length];
       Arrays.fill(tempArray,value); // fill the array with the value
       int index =0;
        for (int i = 0; i < array.length; i++) {
            if (array[i]!=value){
                tempArray[index]=array[i];
                index ++;
            }
        }
        return tempArray;
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
        int value = scanner.nextInt();
        int[] result = new Move_Value().moveValue(numbers,value);
        System.out.println(Arrays.toString(result));


    }
}
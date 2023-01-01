import java.util.*;
interface ICalculator {

    int add(int x, int y);
    float divide(int x, int y) throws RuntimeException;
}


public class Calculator implements ICalculator{
    /* Implement your calculator class here*/
    public  int add(int a, int b) {
        int sum = a + b;
        // return value
        return sum;
    }
    public float divide(int a, int b){
        float result = (float)a/(float)b ;

        return result ;
    }

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            String equation = scanner.nextLine().trim();
            Calculator operation = new Calculator();

            if (equation.indexOf("+") > 0) {
                String[] numbers = equation.split("\\+", 2);
                int x = Integer.parseInt(numbers[0].trim());
                int y = Integer.parseInt(numbers[1].trim());
                System.out.println(operation.add(x, y));
            } else {
                String[] numbers = equation.split("\\/", 2);
                int x = Integer.parseInt(numbers[0].trim());
                int y = Integer.parseInt(numbers[1].trim());
                if (y==0)
                    System.out.println("Error");
                else
                    System.out.println(operation.divide(x, y));
            }
        }
        catch (Exception e){
            System.out.println("Error");
        }
    }

}

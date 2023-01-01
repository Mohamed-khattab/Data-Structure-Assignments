
import java.util.Arrays;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Scanner;

class Node{
    Object  data ;
    Node next ;

    public Node(Object data ){
        this.data = data ;
        this.next = null ;
    }
}

class LinkedList{
    private int size ;
    private Node head ;

    public LinkedList(){
        this.size = 0 ;
        this.head= null;
    }
    public  void add(Object data,String position ) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;

        } else {
            if (position.equals("first")) {
                newNode.next = head;
                head = newNode ;
            } else {
                Node curr = head;
                while ((curr.next != null )) {
                    curr = curr.next;
                }
                curr.next = newNode;
                newNode.next = null;
            }

        }
        this.size += 1;
    }
    public void  removeFirst (){
        if(head== null){
            System.out.println("Error");
        }else {
            head = head.next ;
        }
        this.size -=1 ;
    }

    public Object getFirst() {
        return head.data ;
    }

    public void displayList(){
        Object [] numbers = new Object[this.size] ;
        Node curr = head ;
        for (int i = 0; i < this.size ; i++) {
            numbers[i]=  curr.data;
            curr = curr.next;
        }
        System.out.println(Arrays.toString(numbers));
    }

    public int size (){
        return this.size ;
    }
}
class StackImplementation{

    LinkedList link = new LinkedList();

    public void push(Object data  ){
//        if (method.equals("push")){
        link.add(data,"first");  // here it push to the first place

    }
    public Object pop(){
        Object data = link.getFirst() ;
        link.removeFirst();
        return data;
    }
    public boolean isEmpty(){
        return(link.size() == 0) ;

    }
    public Object peek(){
        return link.getFirst();
    }
    public int size(){
        return link.size();
    }
}

interface IExpressionEvaluator {


    public String infixToPostfix(String expression);


    public Object evaluate(String[] expression);

}




class ExperssionEvaluator implements IExpressionEvaluator {
    boolean isOperand(char c) {
        return Character.isLetter(c);}
    boolean isDigit(String c) {
        try {
            double d = Double.parseDouble(c);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
//        return Character.isDigit(c);
    }
    int getPrecedence(char c) {
        switch (c){

            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    Object calculateOperation(Object num1, Object num2, String operation) {
        int a = (int)num1;
        int b =(int) num2;

        if (operation.trim().equals("+"))// == "+")
            return a + b;
        else if (operation.trim().equals("-"))    // == '-')
            return a - b;
        else if ((operation.trim().equals("*")))  // == '*')
            return a * b;
        else if (operation.trim().equals("^")) { // == '^')
            if(a==0&&b==0)
                throw new RuntimeException("Error");
            return  (int)((double)Math.pow(a,b));}
        else {
            if(b==0)
                throw new RuntimeException("Error");
            return a / b;
        }
    }
    public String infixToPostfix(String expression) {
        StackImplementation stack = new StackImplementation();
        String exp = "";

        for (int i = 0; i < expression.length(); i++) {
            if (isOperand(expression.charAt(i))) {
                exp += expression.charAt(i) ;
                continue;
            }
            if(isDigit(String.valueOf(expression.charAt(i))))
            {
                int j = i;
                for(;j < expression.length();j++)
                {
                    if(!isDigit(String.valueOf(expression.charAt(j))))
                        break;
                }
                j--;
                exp += expression.substring(i,j+1) + " ";
                i = j;
                continue;
            }
            if (expression.charAt(i) == '(') {
                stack.push(expression.charAt(i));
                continue;
            }
            if (expression.charAt(i) == ')') {
                while (!stack.isEmpty() && !((Character) stack.peek() == '(')) {
                    exp += stack.peek() ;
                    stack.pop();
                }
                if (stack.isEmpty())
                    throw new RuntimeException("Error");
                stack.pop();
                continue;
            }

            int operatorPriorioty = getPrecedence(expression.charAt(i));

            if (operatorPriorioty == 0)
                continue;
            while (!stack.isEmpty() && getPrecedence((Character) stack.peek()) >= operatorPriorioty) {
                exp += stack.peek() ;
                stack.pop();
            }
            stack.push(expression.charAt(i));
        }
        while (!stack.isEmpty()) {
            exp += (Character) stack.peek();
            if ((Character) stack.peek() == '(')
                throw new RuntimeException("Error");
            stack.pop();
        }
        return exp;
    }

    public Object evaluate(String[] exp) {

        StackImplementation stack = new StackImplementation();

        for (int i = 0; i < exp.length; i++) {

            if(exp[i]== "  "|| exp[i]==" ")
                continue;

            if (isDigit(exp[i])) {
                stack.push(Integer.parseInt(exp[i]));
                continue;
            }
            if (stack.size() < 2)
                throw new RuntimeException("Error");

            Object secondOperand = stack.pop(); //  1 2+
            Object firstOperand =  stack.pop();

            stack.push(calculateOperation(firstOperand, secondOperand, exp[i]));

        }
        if (stack.size() != 1)
            throw new RuntimeException("Error");

        return stack.peek();
    }
}

public class ExpressionEvaluator {

    public static void main(String[] args) {
        try {
            ExperssionEvaluator exv = new ExperssionEvaluator();

            Scanner sc = new Scanner(System.in);
            String expression = sc.nextLine();

            expression = expression.replaceAll(" ","");
            // System.out.println(expression);

            int divIndex = expression.indexOf("/-");
            while(divIndex >=0 ){
                expression = expression.substring(0,divIndex-1)+"-"+expression.charAt(divIndex-1) +"/" +expression.substring(divIndex+2) ;
                divIndex = expression.indexOf("/-");
            }

            int mulIndex = expression.indexOf("*-");
            while(mulIndex >=0 ){
                expression = expression.substring(0,mulIndex-1)+"-"+expression.charAt(mulIndex-1)+"*"+expression.substring(mulIndex+2) ;

                mulIndex = expression.indexOf("*-");
            }



            Dictionary variablesValues  = new Hashtable();
            String[] values ;

            for(int i =0 ; i<3 ;i ++) {
                values  =sc.nextLine().split("=");
                variablesValues.put(values[0].charAt(0), values[1]);
            }

//
            if (expression.indexOf("--")>= 0) {
                expression = expression.replaceAll("--","+");
            }

            if(expression.charAt(0)=='+')
                expression=expression.substring(1);

            while (expression.indexOf("-+")>= 0) {
                expression = expression.replaceAll("\\-+", "-");
            }

            while (expression.indexOf("*-")>= 0) {
                expression = expression.replace("*-","*");
            }
            while (expression.indexOf("*+")>= 0) {
                expression = expression.replace("*+","*");
            }
            while (expression.indexOf("/-")>= 0) {
                expression = expression.replace("/-","/");
            }
            while (expression.indexOf("^+")>= 0) {
                expression = expression.replace("^+","^");
            }


            String postfixExpression = exv.infixToPostfix(expression);          // postfix // trusted


            if (expression.charAt(0)=='-') {
                expression = "0" + expression.trim() ;
            }
            if(expression.indexOf("(-") >= 0){
                expression = expression.replaceAll("\\(-","(0-");
            }

            // System.out.println(expression);

            String modPostfix = exv.infixToPostfix(expression);

            modPostfix= modPostfix.replaceAll(" ","") ;

            String[] postfixWithDigits = new String[modPostfix.length()];

            for (int i = 0; i < modPostfix.length() ; i++) {
                char c = modPostfix.charAt(i);
                if(exv.isOperand(c)){
                    postfixWithDigits[i] = (String.valueOf(variablesValues.get(c)));}
                else
                    postfixWithDigits[i] = String.valueOf(c);
            }


            int expValue = (int) exv.evaluate(postfixWithDigits);
            System.out.println(postfixExpression);

            System.out.println(expValue);


        }catch (Exception e){
            System.out.println("Error");
        }

    }
}
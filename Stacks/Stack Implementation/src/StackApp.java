import java.util.Arrays;
import java.util.Scanner;

class Node{
    int  data ;
    Node next ;

    public Node(int data ){
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

    public  void add(int data,String position ) {
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

    public int getFirst() {
        return head.data ;
    }


    public void displayList(){
        int [] numbers = new int[this.size] ;
        Node curr = head ;
        for (int i = 0; i < this.size  ; i++) {
            numbers[i]= curr.data;
            curr = curr.next;
        }
        System.out.println(Arrays.toString(numbers));
    }

    public int size (){
        return this.size ;
    }


}


interface IStack {


    public void pop() ;

    public Object peek();

    public void push(int data, String method  );

    public boolean isEmpty() ;

    public int size();
}

class StackImplementation implements IStack{

    LinkedList link = new LinkedList();

    public void push(int data, String method  ){
        if (method.equals("push")){
            link.add(data,"first");  // here it push to the first place
            link.displayList();
        }
        else {
            link.add(data, "last");
        }


    }
    public void pop(){
        if(link.size() > 0) {
            link.removeFirst();
            link.displayList();
        }
        else
        {System.out.println("Error");
        }
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

public class StackApp {
    public static void main(String[] args) {
        try {


            StackImplementation stack = new StackImplementation();
            boolean flag = false ;

            Scanner sc = new Scanner(System.in);
            String in = sc.nextLine();
            if (!(in.equals("[]")) ){
                String[] numbers = in.replaceAll("\\[|\\]", "").split(",");
                for (String number : numbers) {
                    stack.push(Integer.parseInt(number.trim()), "initiate");
                }
            }
            else {
                flag = true;
            }
            String operation = sc.nextLine();

            switch (operation) {
                case "push": {
                    int data = sc.nextInt();
                    stack.push(data, operation);
                    break;
                }
                case "pop": {
                    stack.pop();
                    break;
                }
                case "peek": {
                    System.out.println(stack.peek());
                    break;
                }
                case "isEmpty": {

                    if(flag){
                        System.out.println("True") ;
                        break ;
                    }
                    String out = String.valueOf(stack.isEmpty());
                    System.out.println(String.valueOf(out.substring(0, 1).toUpperCase() + out.substring(1)));
                    break;
                }
                case "size": {
                    System.out.println(stack.size());
                    break;
                }
                default:
                    System.out.println("Error");
            }
        }
        catch(Exception e) {
            System.out.println("Error");
        }
    }
}
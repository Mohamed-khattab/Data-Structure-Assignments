import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//  tree implementation in java
 class Node{
    public int id ;
    public double iData ;
    public Node leftChild ;
    public Node rightChild ;

    public void displayNode()
    // display  node
    {
        System.out.print('{');
        System.out.print(iData);
        System.out.print(" , ");
        System.out.print(iData);
        System.out.print("}");
    }
 }
 class BinarySearchTree {
    private Node root ;

    public BinarySearchTree(){
        root = null ;
    }
    public Node find(int key){
        Node current = root ;
        while(current.id != key ){
            if(current.id > key )              // search on the left side of the tree ;
                current= current.leftChild ;
            else                                     // search on the right side of the tree ;
                current = current.rightChild;
            if(current== null)
                return null ;
        }
        return current;                          // find it
    }

    public void insert(int id , double idata ){
        Node newNode = new Node() ;
        newNode.id= id ;
        newNode.iData = idata;
        if(root == null )
            root = newNode;
        else {
            Node current = root ;
            Node parent ;
            while (true){
                parent= current;
                if(current.id > id )   {
                    current= current.leftChild ;
                    if(current == null ) {
                        parent.leftChild = newNode;
                        return;
                    }
                }
                else  {
                    current = current.rightChild;
                    if(current== null ){
                        parent.rightChild= newNode;
                        return;
                    }
                }
            }
        }
    }
    public boolean delete(int key){
        Node current = root  ;
        Node parent  = root;
        boolean isLeftChild = true ;
        while (current.id != key ){                           // first we find the node
            parent = current;
            if(current.id > key) {// go to the left side
                current = current.leftChild;
                isLeftChild = true ;
            }
            else {
                isLeftChild= false;
                current = current.rightChild;
            }
            if(current == null)
                return  false;
        }                                                                 // here the ite is found ;
        if(current.leftChild==null && current.rightChild == null ){     // check for no children case
            if(isLeftChild)
                parent.leftChild = null ;               // disconnect the left  child
            else
                parent.rightChild= null ;               // disconnect the right child
        }
        else if (current.rightChild== null ) {          // node has only one child on the left side
            if(current == root )
                root = current.leftChild;
            else if(isLeftChild)
                parent.leftChild= current.leftChild;
            else
                parent.rightChild = current.leftChild;

        }
        else if (current.leftChild== null ) {          // node has only one child on the right side
            if(current == root )
                root = current.rightChild;
            else if(isLeftChild)
                parent.leftChild= current.rightChild;
            else
                parent.rightChild = current.rightChild;
        }
        else {
           /* here the node has two children  , we have two approaches . find the max at left subtree or the min at right sub three
            here the code is implemented using the min at right sub three called successor */
            Node successor = getSuccessor(current) ;
            if(current == root )
                root= successor;
            else if (isLeftChild)
                parent.leftChild =successor ;
            else
                parent.rightChild= successor;
            successor.leftChild = current.leftChild;
        }
        return true;
    }
    private Node  getSuccessor( Node delNode){
        Node successorParent = delNode;
        Node successor = delNode ;
        Node current = delNode.rightChild;           // go to the right side  the find the min at it ;
        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.leftChild;
        }
        if(successor != current.rightChild){           // if not directly connected to the  current which means it has right = null
            successorParent.leftChild = successor.rightChild;
            successor.rightChild= delNode.rightChild;
        }
        return successor;
    }
    public void traverse(int traverseTye ){
        switch (traverseTye){
            case 1 :
                System.out.println("\n preorder Traversal \n");
                preOrder(root);
                break ;
            case 2 :
                System.out.println("\n Inorder Traversal \n");
                inOrder(root);
                break ;
            case 3:
                System.out.println("\n PostOrder Traversal \n");
                postOrder(root);
                break ;
        }
        System.out.println();

    }
     private void preOrder(Node localroot){
        if(localroot!= null ){
            System.out.println(localroot.iData + " ");
            preOrder(localroot.leftChild);
            preOrder(localroot.rightChild);
        }
     }
     private void inOrder(Node localroot){
         if(localroot!= null ){
             inOrder(localroot.leftChild);
             System.out.println(localroot.iData +" ");
             inOrder(localroot.rightChild);
         }
     }
     private void postOrder(Node localroot){
         if(localroot!= null ){
             postOrder(localroot.leftChild);
             postOrder(localroot.rightChild);
             System.out.println(localroot.iData + " ");
         }
     }


     public void displayTree(){   /* display  nodes in level way BFS  */
         Queue<Node> queue = new LinkedList<Node>();
         queue.add(root);
         while (!queue.isEmpty()) {
             Node tempNode = queue.poll();
             System.out.print(tempNode.iData + " ");

             /*add left child to the queue */
             if (tempNode.leftChild != null) {
                 queue.add(tempNode.leftChild);
             }
             /*add  right child to the queue */
             if (tempNode.rightChild != null) {
                 queue.add(tempNode.rightChild);
             }
         }
     }
 }
public class BinarySearchTreeApp {
    public static void main(String[] args) throws IOException {
        int value;
        BinarySearchTree tree = new BinarySearchTree();

        tree.insert(50, 2.0);
        tree.insert(25, 1.9);
        tree.insert(75, 1.8);
        tree.insert(37, 1.7);
        tree.insert(43, 1.6);
        tree.insert(30, 1.5);
        tree.insert(33, 1.4);
        tree.insert(87, 1.3);
        tree.insert(93, 1.2);
        tree.insert(97, 1.1);


        while (true) {
            System.out.print("Enter first letter of show, insert, find, delete, or traverse: ");
            int choice = getChar();
            switch (choice) {
                case 's':
                    tree.displayTree();
                    break;
                case 'i':
                    System.out.print("Enter value to insert: ");
                    value = getInt();
                    tree.insert(value, value + 0.9);
                    break;
                case 'f':
                    System.out.print("Enter value to find: ");
                    value = getInt();
                    Node found = tree.find(value);
                    if (found != null) {
                        System.out.print("Found: ");
                        found.displayNode();
                        System.out.print("\n");
                    } else
                        System.out.print("Could not find ");
                    System.out.print(value + "\n");
                    break;
                case 'd':
                    System.out.print("Enter value to delete: ");
                    value = getInt();
                    boolean didDelete = tree.delete(value);
                    if (didDelete)
                        System.out.print("Deleted " + value + "\n");
                    else
                        System.out.print("Could not delete");
                    System.out.print(value + "\n");
                    break;
                case 't':
                    System.out.print("Enter type 1, 2 or 3: ");
                    value = getInt();
                    tree.traverse(value);
                    break;
                default:
                    System.out.print("Invalid entry\n");
            }
        }
    }
    public static String getString() throws IOException
    {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }
    public static char getChar() throws IOException
    {
        String s = getString();
        return s.charAt(0);
    }
    public static int getInt() throws IOException
        {
        String s = getString();
        return Integer.parseInt(s);
        }
    }

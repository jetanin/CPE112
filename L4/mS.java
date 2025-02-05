class Node{
    private int value;
    private Node next;

    public Node(int value){
        this.value = value;
        this.next = null;
    }

    public int getValue(){
        return this.value;
    }

    public Node getNext(){
        return this.next;
    }

    public void setNext(Node node){
        this.next = node;
    }
}

class Stack{
    private Node top;

    public Stack(){
        this.top = null;
    }

    public void push(int value){
        Node node = new Node(value);

        if(top == null){
            this.top = node;
        }else{
            node.setNext(this.top);
            this.top = node;
        }
    }

    public int pop(){
        if(this.top == null){
            System.out.println("Empty");
            return -1;
        }
        else{
            int val = this.top.getValue();
            this.top = this.top.getNext();
            return val;
        }
    }
}

public class mS{
    public static void main(String[] args){
        Stack s = new Stack();
        s.push(0);
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);

        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
    }
}
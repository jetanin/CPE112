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

class Queue{
    private Node front;
    private  Node rear;

    public Queue(){
        this.front = null;
        this.rear = null;
    }

    public void enqueue(int value){
        Node node = new Node(value);
        if(this.front == null){
            this.front = node;
            this.rear = node;
        }else{
            this.rear.setNext(node);
            this.rear = node;
        }
    }

    public int dequeue(){
        if(this.front == null){
            System.out.println("Empty");
            return -1;
        }else{
            int val = this.front.getValue();
            if(rear == front){
                this.front = null;
                this.rear = null;
            }else {
                this.front = this.front.getNext();
            }
            return  val;
        }
    }
}

public class mQ{
    public static void main(String[] args) {
        Queue q = new Queue();

        q.enqueue(0);
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);

        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
    }
}
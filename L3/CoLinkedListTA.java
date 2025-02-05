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
class LinkedList{
    private Node head;

    public LinkedList(){
        this.head = null;
    }

    public void insert(int value){
        Node newNode = new Node(value);
        if(head == null){
            this.head = newNode;
        }else{
            Node currentNode = head;
            while(currentNode.getNext() != null){
                currentNode = currentNode.getNext();
            }

            currentNode.setNext(newNode);
        }
    }

    public boolean findValue(int value){
        if(head == null){
            return false;
        }else{
            Node currentNode = head;
            while(currentNode != null){
                if(currentNode.getValue() == value){
                    return true;
                }
                currentNode = currentNode.getNext();

            }
            return false;
        }
    }

    public void display(){
        if(head == null){
            System.out.println("Empty");
        }else{
            Node currentNode = head;
            while(currentNode != null){
                System.out.printf("%d ", currentNode.getValue());
                currentNode = currentNode.getNext();
            }
        }
    }
}




public class CoLinkedList {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();

        ll.insert(10);
        ll.insert(12);
        ll.insert(50);
        ll.display();
        System.out.println();
        System.out.println("find 10 " + ll.findValue(10));
        System.out.println("find 12 " + ll.findValue(12));
        System.out.println("find 50 " + ll.findValue(50));
        System.out.println("find 0 " + ll.findValue(0));
    }
}

import java.util.Scanner;

class Node{
    int data;
    String name;
    Node left;
    Node right;
    
    public Node(int value, String name){
        this.data = value;
        this.name = name;
        this.left = null;
        this.right = null;
    }

    public boolean setChildNode(Node child, char direction){
        if(direction == 'l'){
            this.left = child;
            return true;
        }
        else if(direction == 'r'){
            this.right = child;
            return true;
        }
        else{
            return false;
        } 
    }
}

class Tree{
    Node[] node;
    Node root;

    public Tree(int n){
        this.node = new Node[n];
        this.root = null;
    }

    private Node searchByName(String name){
        for(Node n : this.node){
            if(n.name.equals(name)){
                return n;
            }
        }
        return null;
    }

    public boolean addEdge(String pName, String cName, char direction){
        Node pNode = searchByName(pName);
        Node cNode = searchByName(cName);
        if(pNode == null || cNode == null){
            return false;
        }
        else {
            pNode.setChildNode(cNode, direction);
            return  true;
        }
    }

    public boolean setRoot(String rName){
        Node root = searchByName(rName);
        if(root == null){
            return false;
        }
        else {
            this.root = root;
            return true;
        }
    }

    public void preoder(Node root){
        if(root != null){
            System.out.printf("%d ", root.data);
            // System.out.printf("%s %d\n", root.name, root.data);
            preoder(root.left);
            preoder(root.right);
        }
    }
    public void preorder(){
        preoder(this.root);
    }

    private void postorder(Node root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.printf("%d ", root.data);
        }
    }

    public void postorder() {
        postorder(this.root);
    }

    private void inorder(Node root){
        if (root != null) {
            inorder(root.left);
            System.out.printf("%d ", root.data);
            inorder(root.right);
        } 
    }

    public void inorder() {
        inorder(this.root);
    }
}

public class Lab05_PlantingTree{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Tree tree = new Tree(n);
        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int data = sc.nextInt();
            tree.node[i] = new Node(data, name);
        }
        for (int i = 0; i < n - 1; i++) {
            String pname = sc.next();
            String cname = sc.next();
            char direction = sc.next().charAt(0);
            tree.addEdge(pname, cname, direction);
        }
        String rname = sc.next();
        tree.setRoot(rname);
        tree.preorder();
        System.out.printf("\n");
        tree.inorder();
        System.out.printf("\n");
        tree.postorder();
    }
}
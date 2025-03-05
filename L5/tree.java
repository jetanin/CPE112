import java.util.Scanner;
class Node{
    int data;
    String name;
    Node left;
    Node right;

    public Node(int data, String name){
        this.data = data;
        this.name = name;
        this.left = null;
        this.right = null;
    }

    public boolean setChildNode(Node child, char direction){
        if(direction == 'L'){
            this.left = child;
            return true;
        }else if(direction == 'R'){
            this.right = child;
            return true;
        }else{
            return false;
        }
    }
}

class Tree{
    Node[] node;
    Node root;

    public Tree(int n){
        this.node = new Node[n]; // malloc(sizeof(Node) * n)
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
        }else{
            pNode.setChildNode(cNode, direction);
            return true;
        }
    }

    public boolean setRoot(String rName){
        Node root = searchByName(rName);
        if(root == null){
            return false;
        }else{
            this.root = root;
            return true;
        }
    }
    //pre root->left->right
    private void preorder(Node root){
        if(root != null){
            System.out.printf("%d ", root.data);
            preorder(root.left);
            preorder(root.right);
        }
    }

    public void preorder(){
        preorder(this.root);
    }
    //post คือ left->Right->Root
    private void postorder(Node root){
        if(root != null){
            postorder(root.left);
            postorder(root.right);
            System.out.printf("%d ", root.data);
        }
    }

    public void postorder(){
        postorder(this.root);
    }
    //in left->root->right
    private void inorder(Node root){
        if(root != null){
            inorder(root.left);
            System.out.printf("%d ", root.data);
            inorder(root.right);
        }
    }

    public void inorder(){
        inorder(this.root);
    }

}
public class tree{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Tree tree = new Tree(n);
        
        for(int i=0;i<n;i++){
            String name = sc.next();
            int value = sc.nextInt();
            tree.node[i] = new Node(value,name);
        }
        for(int i=0;i<n-1;i++){
            String pName = sc.next();
            String cName = sc.next();
            char direction = sc.next().charAt(0);
            tree.addEdge(pName, cName, direction);
        }
        String rName = sc.next();
        tree.setRoot(rName);
        tree.preorder();
        System.out.println();
        tree.inorder();
        System.out.println();
        tree.postorder();
        sc.close();
    }
}
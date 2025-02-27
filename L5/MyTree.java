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

    private void preorder(Node root){
        if(root != null){
            System.out.printf("%s %d\n", root.name, root.data);
            preorder(root.left);
            preorder(root.right);
        }
    }

    public void preorder(){
        preorder(this.root);
    }

}
public class MyTree{
    public static void main(String[] args) {
        
    }
}
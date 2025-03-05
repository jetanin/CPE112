//values & referance type variable

class  node{
    int data;
    node leftChild;
    node rightChild;

    public node(int data){
        this.data = data;
        this.leftChild = null;
        this.rightChild = null;
    }

}

class tree{
    node[] node;
    node root;

    public tree(int n){
        this.node = new node[n];
        this.root = null;   
    }
}

public class  tree2{
    public static void main(String[] args) {
        
    }
}
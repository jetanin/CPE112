class node{
    int value;
    node left;
    node right;

    public node(int val){
        this.value = val;
        this.left = null;
        this.right = null;
    }
}

class Tree{
    node root;
    
    public Tree(){
        this.root = null;
    }

    public void insertNode(int val){
        node newNode = new node(val);
        if(this.root == null){
            this.root = newNode;
            return;
        }
        node currNode = this.root;
        while (true) { 
        //     if(currNode.left == null){
        //         currNode.left = newNode;
        //         return;
        //     }
        //     currNode = currNode.left;
        // }
        // while(currNode != null){
            if(val < currNode.value){
                if(currNode.left == null){
                    currNode.left = newNode;
                    return;
                }
                else {
                    currNode = currNode.left;
                }
            }
            else if(val > currNode.value){
                if(currNode.right == null){
                    currNode.right = newNode;
                    return;
                }
                else {
                    currNode = currNode.right;
                }
            }
        }
    }

    private void inorder(node root){
        if (root != null) {
            inorder(root.left);
            System.out.printf("%d ", root.value);
            inorder(root.right);
        } 
    }

    public void inorder() {
        inorder(this.root);
    }

}

public class Lab06_BST{
    public static void main(String[] args) {
        Tree tree = new Tree(); 
        tree.insertNode(6);
        tree.insertNode(2);
        tree.insertNode(3);
        tree.insertNode(4);
        tree.insertNode(5);

        tree.inorder();
    }
}
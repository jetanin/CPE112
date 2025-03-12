import java.util.Scanner;

class Node{
    int key;
    Node left;
    Node right;
    int height;

    Node(int val){
        key = val;
        height = 1;
    }
}

public class AVLTree{
    Node root;

    int height(Node node){
        if(node == null){
            return 0;
        }
        return node.height;
    }
    
    int max(int a, int b){
        return Math.max(a,b);
    }

    int balanceFactor(Node node){
        if(node == null){
            return 0;
        }
        return height(node.left) - height(node.right);
    }

    Node rightRotate(Node oldRoot){
        Node newRoot = oldRoot.left;

        Node T2 = newRoot.right;
        
        newRoot.right = oldRoot;
        oldRoot.left = T2;

        oldRoot.height = max(height(oldRoot.left), height(oldRoot.right)) + 1;
        newRoot.height = max(height(newRoot.left), height(newRoot.right)) + 1;
        return newRoot;
    }
    Node leftRotate(Node oldRoot){
        Node newRoot = oldRoot.right;

        Node T2 = newRoot.left;
        
        newRoot.left = oldRoot;
        oldRoot.right = T2;

        oldRoot.height = max(height(oldRoot.left), height(oldRoot.right)) + 1;
        newRoot.height = max(height(newRoot.left), height(newRoot.right)) + 1;

        return  newRoot;
    }
    
    Node insert(Node node , int key){
        if(node == null){
            return new Node(key);
        }

        if(key < node.key){
            node.left = insert(node.left, key);
        }
        if(key > node.key){
            node.right = insert(node.right, key);
        }
        else{
            return node;
        }

        node.height = 1 + max(height(node.left), height(node.right));

        int balanceFactor = balanceFactor(node);

        if(balanceFactor > 1 && key < node.left.key){
            return rightRotate(node);
        }
        if(balanceFactor < -1 && key > node.right.key){
            return leftRotate(node);
        }
        if (balanceFactor > 1 && key > node.left.key) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        if (balanceFactor < -1 && key < node.right.key) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    void inOrder(Node root){
        if (root != null) {
            inOrder(root.left);
            System.out.printf("%d ", root.key);
            inOrder(root.right);
        } 
    }
    void inOrder() {
        inOrder(this.root);
    }

    void preOrder(Node root){
        if (root != null) {
            System.out.printf("%d ", root.key);
            preOrder(root.left);
            preOrder(root.right);
        } 
    }
    void preOrder() {
        preOrder(this.root);
    }

    void postOrder(Node root){
        if (root != null) {
            preOrder(root.left);
            postOrder(root.right);
            System.out.printf("%d ", root.key);
        } 
    }

     void postOrder() {
        postOrder(this.root);
    }

    public static void main(String[] args) {
        AVLTree tree = new AVLTree();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of nodes: ");
        int n = sc.nextInt();
        System.out.println("Enter elements: ");
        for(int i = 0; i < n; i++){
            int input = sc.nextInt();
            tree.root = tree.insert(tree.root, input);
        }
        sc.close();

        System.out.println("Preorder: ");
        tree.preOrder(tree.root);
        System.out.println("\nInorder: ");
        tree.inOrder(tree.root);
        System.out.println("\nPostorder: ");
        tree.postOrder(tree.root);

    }
}
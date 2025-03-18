class Node{
    int key;
    Node left;
    Node right;
    int height;

    Node(int val){
        this.key = val;
        this.left = null;
        this.right = null;
        this.height = 1;
    }
}

class AVLtree{
    Node root;

    public int height(Node node){
        if(node == null){
            return 0;
        }
        return node.height;
    }

    public int balanceFactor(Node node){
        if(node == null){
            return 0;
        }
        return height(node.left) - height(node.right);
    }

    public Node rightRotate(Node oldRoot){
        Node newRoot = oldRoot.left;
        Node T2 = newRoot.right;
        newRoot.right = oldRoot;
        oldRoot.left = T2;

        oldRoot.height = Math.max(height(oldRoot.left),height(oldRoot.right)) + 1;
        newRoot.height = Math.max(height(newRoot.left),height(newRoot.right)) + 1;
        return newRoot;
    }


    public Node leftRotate(Node oldRoot){
        Node newRoot = oldRoot.right;
        Node T2 = newRoot.left;
        newRoot.left = oldRoot;
        oldRoot.right = T2;

        oldRoot.height = Math.max(height(oldRoot.right),height(oldRoot.left)) + 1;
        newRoot.height = Math.max(height(newRoot.right),height(newRoot.left)) + 1;
        return newRoot;
    }

    public Node insert(Node node, int key){
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

        node.height = 1 + Math.max(height(node.left), height(node.right));

        int balanceFactor = balanceFactor(node);

        if(balanceFactor > 1 && key < node.left.key){
            return rightRotate(node);
        }
        if(balanceFactor < -1 && key > node.right.key){
            return leftRotate(node);
        }
        if(balanceFactor > 1 && key > node.left.key){
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        if(balanceFactor < -1 && key < node.right.key){
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    public void inOrder(Node root){
        if (root != null) {
            inOrder(root.left);
            System.out.printf("%d ", root.key);
            inOrder(root.right);
        } 
    }
    public void inOrder() {
        inOrder(this.root);
    }

    public void preOrder(Node root){
        if (root != null) {
            System.out.printf("%d ", root.key);
            preOrder(root.left);
            preOrder(root.right);
        } 
    }
    public void preOrder() {
        preOrder(this.root);
    }

    public void postOrder(Node root){
        if (root != null) {
            preOrder(root.left);
            postOrder(root.right);
            System.out.printf("%d ", root.key);
        } 
    }

    public void postOrder() {
        postOrder(this.root);
    }

    public void printTree(Node root, String prefix, boolean isLeft) {
        if (root != null) {
            System.out.println(prefix + (isLeft ? "├── " : "└── ") + root.key);
            printTree(root.left, prefix + (isLeft ? "│   " : "    "), true);
            printTree(root.right, prefix + (isLeft ? "│   " : "    "), false);
        }
    }

    public void printTree() {
        printTree(this.root, "", false);
    }
}

class BST{
    Node root;
    
    public BST(){
        this.root = null;
    }

    public void insertNode(int val){
        Node newNode = new Node(val);
        if(this.root == null){
            this.root = newNode;
            return;
        }
        Node currNode = this.root;
        while (true) {
            if(val < currNode.key){
                if(currNode.left == null){
                    currNode.left = newNode;
                    return;
                }
                else {
                    currNode = currNode.left;
                }
            }
            else if(val > currNode.key){
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

    public void inOrder(Node root){
        if (root != null) {
            inOrder(root.left);
            System.out.printf("%d ", root.key);
            inOrder(root.right);
        } 
    }
    public void inOrder() {
        inOrder(this.root);
    }

    public void preOrder(Node root){
        if (root != null) {
            System.out.printf("%d ", root.key);
            preOrder(root.left);
            preOrder(root.right);
        } 
    }
    public void preOrder() {
        preOrder(this.root);
    }

    public void postOrder(Node root){
        if (root != null) {
            preOrder(root.left);
            postOrder(root.right);
            System.out.printf("%d ", root.key);
        } 
    }

    public void postOrder() {
        postOrder(this.root);
    }

    public void printTree(Node root, String prefix, boolean isLeft) {
        if (root != null) {
            System.out.println(prefix + (isLeft ? "├── " : "└── ") + root.key);
            printTree(root.left, prefix + (isLeft ? "│   " : "    "), true);
            printTree(root.right, prefix + (isLeft ? "│   " : "    "), false);
        }
    }

    public void printTree() {
        printTree(this.root, "", false);
    }
}

public class AVL_vs_BST{
    public static void main(String[] args) {
        System.out.println("AVL TREE\n");
        AVLtree avlTree = new AVLtree();
        avlTree.root = avlTree.insert(avlTree.root, 3);
        avlTree.root = avlTree.insert(avlTree.root, 4);
        avlTree.root = avlTree.insert(avlTree.root, 2);
        avlTree.root = avlTree.insert(avlTree.root, 6);
        avlTree.root = avlTree.insert(avlTree.root, 7);
        System.out.println("Preorder: ");
        avlTree.preOrder();
        System.out.println("\nTree structure: ");
        avlTree.printTree();

        System.out.println("\nBINARY SEARCH TREE");
        BST bst = new BST(); 
        bst.insertNode(3);
        bst.insertNode(4);
        bst.insertNode(2);
        bst.insertNode(6);
        bst.insertNode(7);
        System.out.println("Preorder: ");
        avlTree.preOrder();
        System.out.println("\nTree structure: ");
        avlTree.printTree();
    }
} 
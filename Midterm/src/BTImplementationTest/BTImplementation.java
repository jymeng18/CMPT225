package BTImplementationTest;


import java.util.*;

class Node {
    int data;
    Node left, right, parent;

    public Node(int item) {
        data = item;
        left = right = parent = null;
    }
}

class BinaryTreeAlgorithms {
    Node root;

    public BinaryTreeAlgorithms() {
        root = null;
    }

    // Helper method to insert with parent pointer
    public void insert(int data) {
        root = insertRec(root, null, data);
    }

    private Node insertRec(Node root, Node parent, int data) {
        if (root == null) {
            Node newNode = new Node(data);
            newNode.parent = parent;
            return newNode;
        }

        if (data < root.data) {
            root.left = insertRec(root.left, root, data);
        } else if (data > root.data) {
            root.right = insertRec(root.right, root, data);
        }

        return root;
    }

    public Node findNode(Node node, int data){
        if(node == null){
            return null;
        }

        if(node.data == data){
            return node;
        }
        if(data < node.data){
            return findNode(node.left, data);
        }
        else if(data > node.data){
            return findNode(node.right, data);
        }

        return node;
    }

    public int findMin(Node node){

        // Base case
        if(node.right == null && node.left == null){
            return node.data;
        }

        int min = node.data;

        if(node.left != null){
            int leftMin = findMin(node.left);
            if(leftMin < min){
                min = leftMin;
            }
        }

        if(node.right != null){
            int rightMin = findMin(node.right);
            if(rightMin < min){
                min = rightMin;
            }
        }
        return min;
    }

    public int totalSum(Node node){
        // Base case
        if(node == null){
            return 0;
        }

        int sum = node.data + totalSum(node.left) + totalSum(node.right);
        return sum;
    }

    public int totalLeaves(Node node){

        // Base case
        if(node == null){
            return 0;
        }

        if(node.left == null && node.right == null){
            return 1;
        }
        int sum = totalLeaves(node.left) + totalLeaves(node.right);
        return sum;
    }

    public int countSingleChild(Node node){

        if(node == null){
            return 0;
        }

        // Base case: if found only one child
        if(node.left != null && node.right == null){
            return 1;
        }
        if(node.left == null && node.right != null){
            return 1;
        }

        int sum = countSingleChild(node.left) + countSingleChild(node.right);
        return sum;
    }

    public int countSingleChildWrap(){
        return countSingleChild(root);
    }

    public int getDepth(Node node){
        if(node == null){
            return -1;
        }
        int depth = 0;
        Node current = node;

        while(current.parent != null){
            current = current.parent;
            depth++;
        }
        return depth;
    }

    public static boolean areEqual(Node root1, Node root2){

        if(root1 == null && root2 == null){
            return true;
        }

        // One is null other is not -> Not the same
        if(root1 == null || root2 == null){
            return false;
        }

        if(root1.data != root2.data){
            return false;
        }

        if(!areEqual(root1.left, root2.left)){
            return false;
        }

        if(!areEqual(root1.right, root2.right)){
            return false;
        }
        return true;
    }

    public int getSize(){
        if(root == null){
            return 0;
        }

        Stack<Node> stack = new Stack<Node>();
        int size = 0;
        Node current = null;

        // push root first
        stack.push(root);
        while(!stack.isEmpty()){
            current = stack.pop();
            size++;

            // Push the children into the stack
            if(current.left != null){
                stack.push(current.left);
            }
            if(current.right != null){
                stack.push(current.right);
            }
        }
        return size;
    }

    public int getSizeRecursively(Node node){
        // Base case: once you hit the leaves
        if(node == null){
            return 0;
        }
        return 1 + getSizeRecursively(node.left) + getSizeRecursively(node.right);
    }

    public void rightSkewedTree(int arr[]){
        if(arr.length == 0){
            root = null;
            return;
        }

        root = new Node(arr[0]);
        Node current = root;

        for(int i = 1; i < arr.length; i++){
            current.right = new Node(arr[i]);
            current = current.right;
        }
    }


    // Main method to test all algorithms
    public static void main(String[] args) {
        BinaryTreeAlgorithms tree = new BinaryTreeAlgorithms();

        // Build tree
        tree.insert(50);
        tree.insert(30);
        tree.insert(70);
        tree.insert(20);
        tree.insert(40);
        tree.insert(60);
        tree.insert(80);
        tree.insert(10);
        tree.insert(90);

        System.out.println("Tree structure:");
        System.out.println("           50");
        System.out.println("          /  \\");
        System.out.println("        30    70");
        System.out.println("       / \\    / \\");
        System.out.println("      20 40  60 80");
        System.out.println("     /            \\");
        System.out.println("    10            90");
        System.out.println();

        int val = tree.countSingleChildWrap();
        System.out.println(val + " ");
    }
}
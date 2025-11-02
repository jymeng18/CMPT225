package AVLTree;

class AVLTree {
    class Node {
        int key, height;
        Node left, right;

        Node(int key) {
            this.key = key;
            height = 1; // new nodes start at height 1
        }
    }

    Node root;

    // --- Utility methods ---
    int height(Node n) {
        return n == null ? 0 : n.height;
    }

    int getBalance(Node n) {
        return n == null ? 0 : height(n.left) - height(n.right);
    }

    // --- Rotations ---
    Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        // Perform rotation
        x.right = y;
        y.left = T2;

        // Update heights
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x; // new root
    }

    Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        // Perform rotation
        y.left = x;
        x.right = T2;

        // Update heights
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y; // new root
    }

    // --- Insert and balance ---
    Node insert(Node node, int key) {
        // 1. Perform normal BST insert
        if (node == null)
            return new Node(key);
        if (key < node.key)
            node.left = insert(node.left, key);
        else if (key > node.key)
            node.right = insert(node.right, key);
        else
            return node; // duplicates not allowed

        // 2. Update height
        node.height = 1 + Math.max(height(node.left), height(node.right));

        // 3. Get balance factor
        int balance = getBalance(node);

        // 4. Check four rotation cases
        // Left Left
        if (balance > 1 && key < node.left.key)
            return rightRotate(node);

        // Right Right
        if (balance < -1 && key > node.right.key)
            return leftRotate(node);

        // Left Right
        if (balance > 1 && key > node.left.key) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // Right Left
        if (balance < -1 && key < node.right.key) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node; // balanced
    }

    void insert(int key) {
        root = insert(root, key);
    }

    // --- Traversal (for testing) ---
    void inorder(Node node) {
        if (node != null) {
            inorder(node.left);
            System.out.print(node.key + " ");
            inorder(node.right);
        }
    }

    void printInOrder() {
        inorder(root);
        System.out.println();
    }

    // --- Example run ---
    public static void main(String[] args) {
        AVLTree tree = new AVLTree();
        int[] nums = {10, 20, 30, 40, 50, 25};
        for (int n : nums)
            tree.insert(n);

        System.out.println("Inorder traversal of balanced AVL tree:");
        tree.printInOrder();
    }
}

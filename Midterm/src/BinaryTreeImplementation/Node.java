package BinaryTreeImplementation;
import java.lang.Math.*;
import java.util.*;

import static java.lang.Math.max;


class Node<T extends Comparable<T>> {
    T data;
     Node<T> leftChild, rightChild, parent;

    public Node(T data){
        this.data = data;
        leftChild = rightChild = parent = null;
    }
}

class BinaryTree<T extends Comparable<T>> {
    Node<T> root;

    public BinaryTree(Node<T> root){
        this.root = root;
    }

    public void preOrderIterativeStack(Node<T> root){
        if(root == null){
            return;
        }

        Stack<Node<T>> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()){
            Node<T> node = stack.pop();
            System.out.println(node.data + " ");

            if(node.rightChild != null){
                stack.push(node.rightChild);
            }
            if(node.leftChild != null){
                stack.push(node.leftChild);
            }
        }
    }

    public void preOrderIterativeQueue(Node<T> root){
        if(root == null){
            return;
        }

        Queue<Node<T>> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            Node<T> node = queue.poll();
            System.out.println(node + " ");

            if(node.leftChild != null){
                queue.offer(node.leftChild);
            }
            if(node.rightChild != null){
                queue.offer(node.rightChild);
            }
        }

        return;
    }

    public Node<T> findRecursively(Node<T> node, T target){

        // Base case:
        if(node == null){
            return null;
        }

        if(node.data.compareTo(target) == 0){
            return node;
        }

        if(node.data.compareTo(target) < 0){
            return findRecursively(node.rightChild, target);
        }
        if(node.data.compareTo(target) > 0){
            return findRecursively(node.leftChild, target);
        }
        return node;
    }

    public Node<T> findIteratively(Node<T> root, T target){
        Node<T> currentNode = root;
        while(currentNode != null){

            if(currentNode.data.compareTo(target) == 0){
                return currentNode;
            }
            if(currentNode.data.compareTo(target) < 0){
                currentNode = currentNode.rightChild;
            }
            if(currentNode.data.compareTo(target) > 0){
                currentNode = currentNode.leftChild;
            }
        }
        // Node not found;
        return null;
    }

    public T findMinBT(Node<T> node){
        if(node.leftChild == null && node.rightChild == null){
            return node.data;
        }
        T min = node.data;

        if(node.leftChild != null){
            T leftMin = findMinBT(node.leftChild);
            if(leftMin.compareTo(min) < 0){
                min = leftMin;
            }
        }
        if(node.rightChild != null){
            T rightMin = findMinBT(node.rightChild);
            if(rightMin.compareTo(min) < 0){
                min = rightMin;
            }
        }
        return min;
    }

    public T findMinBST(Node<T> node){
        if(node == null){
            return null;
        }
        if(node.leftChild == null && node.rightChild == null){
            return node.data;
        }
        return findMinBST(node.leftChild);
    }

    public Integer findSum(Node<Integer> root){
        if(root == null){
            return 0;
        }
        return root.data + findSum(root.leftChild) + findSum(root.rightChild);
    }

    public Integer findNumLeaves(Node<Integer> root){
        if(root == null){
            return 0;
        }
        if(root.leftChild == null && root.rightChild == null){
            return 1;
        }
        return findNumLeaves(root.rightChild) + findNumLeaves(root.leftChild);
    }

    public Node<T> insert(Node<T> root, T data){
        if(root == null){
            root = new Node<>(data);
            return root;
        }

        if(data.compareTo(root.data) < 0){
            root.leftChild = insert(root.leftChild, data);
        }
        else{
            root.rightChild = insert(root.rightChild, data);
        }
        return root;
    }

    public void insertRec(T data){
        if(root == null){
            root = new Node<>(data);
            return;
        }
        Node<T> current = root;
        Node<T> parent = null;

        while(current != null){
            parent = current;
            if(data.compareTo(current.data) < 0){
                current = current.leftChild;
            }
            if(data.compareTo(current.data) > 0){
                current = current.rightChild;
            }
        }
        if(data.compareTo(parent.data) < 0){
            parent.leftChild = new Node<>(data);
        }
        else{
            parent.rightChild = new Node<>(data);
        }
    }

    public int sizeRec(Node<T> root){
        if(root == null){
            return 0;
        }
        int sum = 1 + sizeRec(root.leftChild) + sizeRec(root.rightChild);
        return sum;
    }

    public Integer getDepth(Node<T> node){
        if(node == null){
            return null;
        }
        int depth = 0;
        while(node.parent != null){
            node = node.parent;
            depth++;
        }
        return depth;
    }

    public int sizeIteratively(Node<T> root){
        if(root == null){
            return 0;
        }

        int size = 0;
        Stack<Node<T>> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()){
            Node<T> node = stack.pop();
            size++;

            if(node.rightChild != null){
                stack.push(node.rightChild);
            }
            if(node.leftChild != null){
                stack.push(node.leftChild);
            }
        }
        return size;
    }

    public Node<T> delete(Node<T> root, T data) {
        // base case
        if(root == null){
            return null;
        }

        if(data.compareTo(root.data) < 0){
            root.leftChild = delete(root.leftChild, data);
        }
        else if(data.compareTo(root.data) > 0){
            root.rightChild = delete(root.rightChild, data);
        }

        // Found nodeToBeRemoved
        else{
            if(root.leftChild == null){
                return root.rightChild;
            }
            else if(root.rightChild == null){
                return root.leftChild;
            }

            // 2 children
        }

        return root;
    }

    public T findMinRec(Node<T> node){
        if(node.leftChild == null && node.rightChild == null){
            return node.data;
        }
        return findMinRec(root.leftChild);
    }

    public T findMinIteratively(){
        if(root == null){
            return null;
        }
        Node<T> cur = root;
        while(cur.leftChild != null){
            cur = cur.leftChild;
        }
        return cur.data;
    }

    public Integer getHeightRec(Node<T> node){
        if(node == null){
            return -1;
        }
        return 1 + max(getHeightRec(node.leftChild), getHeightRec(node.rightChild));
    }

    public Integer getHeightIter(){
        if(root == null){
            return 0;
        }
        Queue<Node<T>> queue = new LinkedList<>();
        int height = 0;
        queue.offer(root);

        while(!queue.isEmpty()){
            int levelSize = queue.size();

            // process all nodes on that level
            for(int i = 0; i < levelSize; i++){
                Node<T> current = queue.poll();

                if(current.leftChild != null){
                    queue.offer(current.leftChild);
                }
                if(current.rightChild != null){
                    queue.offer(current.rightChild);
                }
            }
            height++;
        }
        return height;
    }

    public void preOrderRec(Node<T> root){
        if(root == null){
            return;
        }
        System.out.println(root.data);

        if(root.leftChild != null){
            preOrderRec(root.leftChild);
        }
        if(root.rightChild != null){
            preOrderRec(root.rightChild);
        }
        return;
    }

    public void preOrderIter(){
        if(root == null){
            return;
        }
        Stack<Node<T>> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()){
            Node<T> cur = stack.pop();
            System.out.println(cur.data);

            if(cur.rightChild != null){
                stack.push(cur.rightChild);
            }
            if(cur.leftChild != null){
                stack.push(cur.leftChild);
            }
        }
    }

    public void inOrderRec(Node<T> root){
        if(root == null){
            return;
        }
        inOrderRec(root.leftChild);
        System.out.println(root.data);
        inOrderRec(root.rightChild);
        return;
    }

    public void inOrderIter(){
        Stack<Node<T>> stack = new Stack<>();
        Node<T> curr = root;

        while(!stack.isEmpty() || curr != null){
            while(curr != null){
                stack.push(curr);
                curr = curr.leftChild;
            }
            curr = stack.pop();
            System.out.println(curr.data);

            curr = curr.rightChild;
        }
    }

    public void balance(){
        List<T> list = new ArrayList<>();
        sortedArray(root, list);
        root = makeBalance(list, 0, list.size() - 1);
    }

    public void sortedArray(Node<T> node, List<T> list){
        if(node == null){
            return;
        }

        // In order traversal
        if(node.leftChild != null) {
            sortedArray(node.leftChild, list);
        }
        list.add(node.data);
        if(node.rightChild != null){
            sortedArray(node.rightChild, list);
        }
    }

    public Node<T> makeBalance(List<T> arr, int start, int end){
        if(start > end){
            return null;
        }
        int mid = start + (end - start) / 2;
        Node<T> newNode = new Node<>(arr.get(mid));
        newNode.leftChild = makeBalance(arr, start, mid);
        newNode.rightChild = makeBalance(arr, mid + 1, end);
        return newNode;
    }

    public Node<T> buildByPreOrder(List<T> preorder, int index){
        if(preorder.isEmpty()){
            return null;
        }

        if(index >= preorder.size()){
            return null;
        }

        T val = preorder.get(index); // 0 default
        index++;

        Node<T> root = new Node<>(val);
        root.leftChild = buildByPreOrder(preorder, index);
        root.rightChild = buildByPreOrder(preorder, index);

        return root;
    }

}
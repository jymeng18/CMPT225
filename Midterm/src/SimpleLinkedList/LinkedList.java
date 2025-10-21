package SimpleLinkedList;

public class LinkedList<T> {
    private static class Node<T>{
        T data;
        Node<T> next;
        Node<T> prev;
        public Node(T data){
            this.data = data;
            next = null;
            prev = null;
        }
    }

    private int elementCount;
    private Node<T> head;
    private Node<T> tail;
    private boolean isReversed;

    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.elementCount = 0;
        this.isReversed = false;
    }

    void addToHead(T element){
        Node<T> newNode = new Node<>(element);
        if(head == null){
            head = newNode;
            tail = newNode;
            elementCount++;
        }
        if(isReversed){
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
            elementCount++;
        }
        else{
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
            elementCount++;
        }
    }

    void addToTail(T element){
        Node<T> newNode = new Node<>(element);
        if(head == null){
            head = newNode;
            tail = newNode;
            elementCount++;
            return;
        }
        if(isReversed){
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
            elementCount++;
        }
        else{
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
            elementCount++;
        }
    }

    T removeFromHead(){
        if(head == null){
            return null;
        }

        T valNode;
        if(isReversed){
            valNode = tail.data;
            tail = tail.prev;
            if(tail != null){
                tail.next = null;
            }
            else{
                head = null;
            }
            elementCount--;
        }
        else{
            valNode = head.data;
            head = head.next;
            if(head != null){
                head.prev = null;
            }
            else{
                tail = null;
            }
            elementCount--;
        }
        return valNode;
    }

    T removeFromTail(){
        if(head == null){
            return null;
        }

        T nodeVal;

        if(isReversed){
            nodeVal = head.data;
            head = head.next;
            if(head != null){
                head.prev = null;
            }
            else{
                tail = null;
            }
            elementCount--;
        }
        else{
            nodeVal = tail.data;
            tail = tail.prev;
            if(tail != null){
                tail.next = null;
            }
            else{
                head = null;
            }
            elementCount--;
        }

        return nodeVal;
    }

    void isReversed(){
        if(isReversed){
            isReversed = false;
        }
        else{
            isReversed = true;
        }
    }

}





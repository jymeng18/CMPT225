package SimpleQueue;

public class SimpleQueueImplementation<T> {
    private Node<T> front;
    private Node<T> rear;
    private int size;

    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    public SimpleQueueImplementation() {
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    // Add element to the rear of the queue
    public void enqueue(T item) {
        Node<T> newNode = new Node<>(item);

        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    // Remove and return element from the front of the queue
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }

        T data = front.data;
        front = front.next;

        if (front == null) {
            rear = null;
        }

        size--;
        return data;
    }

    // View the front element without removing it
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return front.data;
    }

    // Check if queue is empty
    public boolean isEmpty() {
        return front == null;
    }

    // Get the size of the queue
    public int size() {
        return size;
    }

    // Example usage
    public static void main(String[] args) {
        SimpleQueueImplementation<Integer> queue = new SimpleQueueImplementation<>();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println("Front element: " + queue.peek());
        System.out.println("Queue size: " + queue.size());

        System.out.println("Dequeued: " + queue.dequeue());
        System.out.println("Dequeued: " + queue.dequeue());

        System.out.println("Queue size: " + queue.size());
        System.out.println("Is empty: " + queue.isEmpty());
    }
}
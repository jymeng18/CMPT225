package heap;

import java.util.ArrayList;
import java.util.List;

/**
 * The MinMaxHeap class supports the following operations
 * - add: adds an item to the heap in O(log(n)) time
 * - getMin: returns the minimal element in the heap without modifying the heap in O(1) time
 * - getMax: returns the maximal element in the heap without modifying the heap in O(1) time
 * - removeMin: removes the minimal element in the heap and returns it in O(log(n)) time
 * - removeMax: removes the maximal element in the heap and returns it in O(log(n)) time
 * @param <T> the type of elements in this heap, which must implement Comparable
 */
public class MinMaxHeap<T extends Comparable<T>> {
    private final List<T> heap;

    public MinMaxHeap() {
        heap = new ArrayList<>();
    }

    /**
     * Adds item to the heap in O(log(n)) time
     */
    public void add(T item) {
        heap.add(item);
        bubbleUp(heap.size() - 1);
    }

    /**
     * @return minimum of the heap in O(1) time
     */
    public T getMin() {
        if (heap.isEmpty()) {
            return null;
        }
        return heap.getFirst();
    }

    /**
     * @return maximum of the heap in O(1) time
     */
    public T getMax() {
        /*
         * The max elements are from index 0-2
         * Only look at those
         */

        if (heap.isEmpty()) {
            return null;
        }
        if (heap.size() == 1) {
            return heap.getFirst();
        }
        if (heap.size() == 2) {
            return heap.get(1);
        }
        else {
            if (heap.get(1).compareTo(heap.get(2)) > 0) {
                return heap.get(1);
            } else {
                return heap.get(2);
            }
        }
    }

    /**
     * @return minimum of the heap in O(log(n)) time
     */
    public T removeMin() {
        if (heap.isEmpty()) {
            return null;
        }
        T min = heap.getFirst();
        if (heap.size() == 1) {
            heap.removeFirst();
            return min;
        }

        // Replace root with last element and remove last
        T last = heap.removeLast();
        if (!heap.isEmpty()) {
            heap.set(0, last);
            bubbleDown(0);
        }
        return min;
    }

    /**
     * @return maximum of the heap in O(log(n)) time
     */
    public T removeMax() {
        if (heap.isEmpty()) {
            return null;
        }
        if (heap.size() == 1) {
            return heap.removeFirst();
        }

        int maxIndex = 1;
        if (heap.size() > 2 && heap.get(2).compareTo(heap.get(1)) > 0) {
            maxIndex = 2;
        }

        T max = heap.get(maxIndex);
        if (heap.size() == 2) {
            heap.remove(1);
            return max;
        }

        // Replace max with last element and remove last
        T last = heap.removeLast();
        if (maxIndex < heap.size()) {
            heap.set(maxIndex, last);
            bubbleDown(maxIndex);
        }
        return max;
    }

    /**
     * @return the number of elements in the heap
     */
    public int size() {
        return heap.size();
    }

    // Private helper methods

    private void bubbleUp(int index) {
        if (index == 0) return;

        int parent = (index - 1) / 2;
        int level = getLevel(index);

        if (level % 2 == 0) { // Min level
            if (heap.get(index).compareTo(heap.get(parent)) > 0) {
                swap(index, parent);
                bubbleUpMax(parent);
            } else {
                bubbleUpMin(index);
            }
        } else { // Max level
            if (heap.get(index).compareTo(heap.get(parent)) < 0) {
                swap(index, parent);
                bubbleUpMin(parent);
            } else {
                bubbleUpMax(index);
            }
        }
    }

    private void bubbleUpMin(int index) {
        while (index > 2) {
            int grandparent = ((index - 1) / 2 - 1) / 2;
            if (heap.get(index).compareTo(heap.get(grandparent)) < 0) {
                swap(index, grandparent);
                index = grandparent;
            } else {
                break;
            }
        }
    }

    private void bubbleUpMax(int index) {
        while (index > 2) {
            int grandparent = ((index - 1) / 2 - 1) / 2;
            if (heap.get(index).compareTo(heap.get(grandparent)) > 0) {
                swap(index, grandparent);
                index = grandparent;
            } else {
                break;
            }
        }
    }

    private void bubbleDown(int index) {
        int level = getLevel(index);
        if (level % 2 == 0) { // Min level
            trickleDownMin(index);
        } else { // Max level
            trickleDownMax(index);
        }
    }

    private void trickleDownMin(int index) {
        if (hasChildren(index)) {
            int m = getMinChildOrGrandchild(index);

            // If m is a grandchild
            if (getLevel(m) == getLevel(index) + 2) {
                if (heap.get(m).compareTo(heap.get(index)) < 0) {
                    swap(m, index);
                    if (heap.get(m).compareTo(heap.get((m - 1) / 2)) > 0) {
                        swap(m, (m - 1) / 2);
                    }
                    trickleDownMin(m);
                }
            }
            // If m is a child
            else if (heap.get(m).compareTo(heap.get(index)) < 0) {
                swap(m, index);
            }
        }
    }

    private void trickleDownMax(int index) {
        if (hasChildren(index)) {
            int m = getMaxChildOrGrandchild(index);

            // If m is a grandchild
            if (getLevel(m) == getLevel(index) + 2) {
                if (heap.get(m).compareTo(heap.get(index)) > 0) {
                    swap(m, index);
                    if (heap.get(m).compareTo(heap.get((m - 1) / 2)) < 0) {
                        swap(m, (m - 1) / 2);
                    }
                    trickleDownMax(m);
                }
            }
            // If m is a child
            else if (heap.get(m).compareTo(heap.get(index)) > 0) {
                swap(m, index);
            }
        }
    }

    private int getMinChildOrGrandchild(int index) {
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        int min = left;

        // Check children
        if (left < heap.size()) {
            if (right < heap.size() && heap.get(right).compareTo(heap.get(left)) < 0) {
                min = right;
            }
        }

        // Check grandchildren
        int leftLeft = 2 * left + 1;
        int leftRight = 2 * left + 2;
        int rightLeft = 2 * right + 1;
        int rightRight = 2 * right + 2;

        int[] grandchildren = {leftLeft, leftRight, rightLeft, rightRight};
        for (int grandchild : grandchildren) {
            if (grandchild < heap.size() && heap.get(grandchild).compareTo(heap.get(min)) < 0) {
                min = grandchild;
            }
        }

        return min;
    }

    private int getMaxChildOrGrandchild(int index) {
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        int max = left;

        // Check children
        if (left < heap.size()) {
            if (right < heap.size() && heap.get(right).compareTo(heap.get(left)) > 0) {
                max = right;
            }
        }

        // Check grandchildren
        int leftLeft = 2 * left + 1;
        int leftRight = 2 * left + 2;
        int rightLeft = 2 * right + 1;
        int rightRight = 2 * right + 2;

        int[] grandchildren = {leftLeft, leftRight, rightLeft, rightRight};
        for (int grandchild : grandchildren) {
            if (grandchild < heap.size() && heap.get(grandchild).compareTo(heap.get(max)) > 0) {
                max = grandchild;
            }
        }

        return max;
    }

    private boolean hasChildren(int index) {
        return 2 * index + 1 < heap.size();
    }

    private int getLevel(int index) {
        return (int) (Math.log(index + 1) / Math.log(2));
    }

    private void swap(int i, int j) {
        T temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }
}
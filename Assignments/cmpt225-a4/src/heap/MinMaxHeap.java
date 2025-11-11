package heap;

import java.util.*;

/**
 * the classHeap supports the following operations
 * - add: adds an item to the heap
 * - getMin: returns the minimal element in the heap without modifying the heap
 * - getMax: returns the maximal element in the heap without modifying the heap
 * - removeMin: removes the minimal element in the heap and returns it
 * - removeMax: removes the maximal element in the heap and returns it
 * @param <T>
 */
public class MinMaxHeap <T extends Comparable<T>> {
    private final List<T> heap;

    public MinMaxHeap() {
        this.heap = new ArrayList<>();
    }

    /**
     * Utility Methods
     */
    private int getParent(int idx){ return (idx-1) / 2;}

    private int getLeftChild(int idx){ return 2 * idx + 1;}

    private int getRightChild(int idx){ return 2 * idx + 2;}

    private boolean hasChildren(int idx){ return 2 * idx + 1 < heap.size(); }

    private boolean getLevel(int idx){
        int level = (int) (Math.log(idx + 1) / Math.log(2));
        return level % 2 == 0;
    }

    /**
     * adds item to the heap in O(log(n)) time
     */
    public void add(T item) {
        heap.add(item); // Add to end of list
        bubbleUp(heap.size() - 1);
    }

    /**
     * @return minimum of the heap in O(1) time
     */
    public T getMin() {
        if(heap.isEmpty()){ return null; }
        return heap.getFirst();
    }

    /**
     * @return maximum of the heap in O(1) time
     */
    public T getMax() {
        if(heap.isEmpty()){ return null; }

        // Only need to look at indexes 0 to 2 included
        if(heap.size() == 1) { return heap.getFirst();}
        if(heap.size() == 2){ return heap.get(1); }
        else{
            if(heap.get(1).compareTo(heap.get(2)) > 0){
                return heap.get(1);
            }
            else{
                return heap.get(2);
            }
        }
    }

    /**
     * @return minimum of the heap in O(log(n)) time
     */
    public T removeMin() {
        if(heap.isEmpty()){ return null; }

        T min = heap.getFirst();
        if(heap.size() == 1){
            return min;
        }

        // Remove last element in the heap and move it to front
        T last = heap.removeLast();

        // Restoring
        if(!heap.isEmpty()){
            heap.set(0, last);
            bubbleDown(0);
        }
        return min;
    }

    /**
     * @return maximum of the heap in O(log(n)) time
     */
    public T removeMax() {
        if(heap.isEmpty()){ return null; }

        int maxIdx;
        if(heap.size() == 1){
            return heap.removeFirst();
        }
        else if(heap.size() == 2){
            maxIdx = 1;
        }
        else{
            if(heap.get(1).compareTo(heap.get(2)) < 0){
                maxIdx = 2;
            }
            else{
                maxIdx = 1;
            }
        }

        // Restore heap
        T max = heap.get(maxIdx);
        T last = heap.removeLast();

        // Heap is smaller now
        if(maxIdx < heap.size()){
            heap.set(maxIdx, last);
            bubbleDown(maxIdx);
        }
        return max;
    }


    /**
     * Checks which level we are on, (min/max),
     * if min -> value at idx must be greater than its parent
     * if max -> value at idx must be less than its parent
     * If anything violates, swap, and bubbleUpMin/Max
     */
    public void bubbleUp(int idx){
        // If root, no need to restore anything
        if(idx == 0) return;

        int parentIdx = getParent(idx);
        boolean isLevelMin = getLevel(idx);

        // Min level (0, 2, 4, 6, ...)
        if(isLevelMin){
            // Value must be less than its parent (Min level)
            if(heap.get(idx).compareTo(heap.get(parentIdx)) > 0){
                swapPlaces(idx, parentIdx);
                bubbleUpMax(parentIdx);
            }
            else{
                bubbleUpMin(idx);
            }
        }
        // Max level (1, 3, 5, ..)
        else{
            // Value must be greater than its parent
            if(heap.get(idx).compareTo(heap.get(parentIdx)) < 0){
                swapPlaces(idx, parentIdx);
                bubbleUpMin(parentIdx);
            }
            else{
                bubbleUpMax(idx);
            }
        }
    }

    /**
     * Comparing the value at idx to its grandparent value
     * Precondition: the value at idx must not be at levels 0 or 1,
     */
    private void bubbleUpMin(int idx){
        if(idx <= 2) return; // Base case
        int grandparent = getParent(getParent(idx));
        if(heap.get(idx).compareTo(heap.get(grandparent)) < 0){
            swapPlaces(idx, grandparent);
            bubbleUpMin(grandparent);
        }
    }
    private void bubbleUpMax(int idx) {
        if(idx <= 2) return; // Base case
        int grandparent = getParent(getParent(idx));
        if(heap.get(idx).compareTo(heap.get(grandparent)) > 0){
            swapPlaces(idx, grandparent);
            bubbleUpMax(grandparent);
        }
    }

    /**
     * Similar to bubbleUp, except we are now
     * doing it reverse order
     */
    private void bubbleDown(int idx){
        boolean isMin = getLevel(idx);
        if(isMin){ // removeMin(..)
            bubbleDownMin(idx);
        }
        else{ // removeMax(..)
            bubbleDownMax(idx);
        }
    }

    private void bubbleDownMin(int idx){
        // If there is no children, cannot have grandchildren either, return
        if(!hasChildren(idx)){
            return;
        }
        int minIdx = getMinDesc(idx);
        if(minIdx == -1) return;

        boolean isGrandChild = idx < getParent(minIdx);

        // If is grandchild
        if(isGrandChild){
            if(heap.get(minIdx).compareTo(heap.get(idx)) < 0){
                swapPlaces(idx, minIdx);
                // After swap, ensure minIdx is less than its parent
                int parent = getParent(minIdx);
                if(heap.get(minIdx).compareTo(heap.get(parent)) > 0){
                    swapPlaces(minIdx, parent);
                }
                bubbleDownMin(minIdx);
            }
        }
        // Is a child -> Child(Max lvl) is less then Parent(Min lvl)
        else {
            if (heap.get(minIdx).compareTo(heap.get(idx)) < 0) {
                swapPlaces(idx, minIdx);
            }
        }
    }

    private void bubbleDownMax(int idx){
        int maxIdx = getMaxDesc(idx);
        if(maxIdx == -1) return;

        boolean isGrandChild = idx < getParent(maxIdx);
        if(isGrandChild){
            if(heap.get(maxIdx).compareTo(heap.get(idx)) > 0){
                swapPlaces(maxIdx, idx);
                int parent = getParent(maxIdx);
                if(heap.get(maxIdx).compareTo(heap.get(parent)) < 0){
                    swapPlaces(maxIdx, parent);
                }
                bubbleDownMax(maxIdx);
            }
        }
        else{ // Child
            if(heap.get(maxIdx).compareTo(heap.get(idx)) > 0){
                swapPlaces(maxIdx, idx);
            }
        }
    }

    /**
     * Returns the index of the minimum element
     * in the heap, can be a child or grandchild
     */
    private int getMinDesc(int idx){
        int leftIdx = getLeftChild(idx);
        int rightIdx = getRightChild(idx);

        if(leftIdx >= heap.size()){ return -1; } // Bounds check

        int minIdx = leftIdx;

        // BFS for MinIdx
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(leftIdx);

        if(rightIdx < heap.size()){
            queue.offer(rightIdx);
        }

        // In min-max heap, max levels we need to traverse is 2 levels
        int levelsToTraverse = 2;
        int curLevel = 0;

        while(!queue.isEmpty() && (curLevel < levelsToTraverse)){
            int levelSize = queue.size();
            for(int i = 0; i < levelSize; i++) {
                Integer curIdx = queue.poll();
                if(curIdx == null){
                    continue; // Note: should not occur
                }
                // Update minimum idx
                if (heap.get(curIdx).compareTo(heap.get(minIdx)) < 0) {
                    minIdx = curIdx;
                }

                // Enqueue children for next level
                int childLeftIdx = getLeftChild(curIdx);
                int childRightIdx = getRightChild(curIdx);

                if (childLeftIdx < heap.size()) {
                    queue.offer(childLeftIdx);
                }
                if (childRightIdx < heap.size()) {
                    queue.offer(childRightIdx);
                }
            }
            curLevel++; // Move to next level
        }
        return minIdx;
    }

    private int getMaxDesc(int idx){
        int leftIdx = getLeftChild(idx);
        int rightIdx = getRightChild(idx);

        if(leftIdx >= heap.size()){ return -1; }

        int maxIdx = leftIdx;

        // BFS for MaxIdx
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(leftIdx);

        if(rightIdx < heap.size()){
            queue.offer(rightIdx);
        }

        // In min-max heap, max levels we need to traverse is 2 levels
        int levelsToTraverse = 2;
        int curLevel = 0;

        while(!queue.isEmpty() && (curLevel < levelsToTraverse)){
            int levelSize = queue.size();
            for(int i = 0; i < levelSize; i++) {
                Integer curIdx = queue.poll();
                if(curIdx == null){
                    continue;
                }
                // Update minimum idx
                if (heap.get(curIdx).compareTo(heap.get(maxIdx)) > 0) {
                    maxIdx = curIdx;
                }

                // Enqueue children for next level
                int childLeftIdx = getLeftChild(curIdx);
                int childRightIdx = getRightChild(curIdx);

                if (childLeftIdx < heap.size()) {
                    queue.offer(childLeftIdx);
                }
                if (childRightIdx < heap.size()) {
                    queue.offer(childRightIdx);
                }
            }
            curLevel++;
        }
        return maxIdx;
    }

    /**
     * @return the number of elements in the heap
     */
    public int size() {
        return heap.size();
    }

    private void swapPlaces(int i, int j){
        T tmp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, tmp);
    }
}

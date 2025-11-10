import heap.MinMaxHeap;

public class TestHeap {

    public static void test1() {
        MinMaxHeap<Integer> heap = new MinMaxHeap<Integer>();
        heap.add(8);
        heap.add(2);
        heap.add(10);
        heap.add(6);
        heap.add(3);
        heap.add(-1);
        heap.add(20);

        if (heap.getMin() != -1) {
            System.out.println("getMin ERROR");
            return;
        }
        if (heap.getMax() != 20) {
            System.out.println("getMax ERROR");
            return;
        }

        int prevMin = heap.removeMin(); // expected -1
        int newMin = heap.getMin();     // expected 2
        if (prevMin != -1 || newMin != 2) {
            System.out.println("removeMin ERROR");
            return;
        }

        int prevMax = heap.removeMax(); // expected 20
        int newMax = heap.getMax();     // expected 10
        if (prevMax != 20 || newMax != 10) {
            System.out.println("removeMax ERROR");
            return;
        }

        System.out.println("test1 OK");
    }

    public static void test2() {
        int N = 100;
        MinMaxHeap<Integer> heap = new MinMaxHeap<Integer>();
        for (int i = 0; i <= N; i++) {
            heap.add(i);
            heap.add(i * i + 1);
            heap.add(-i - 10);
        }

        if (heap.getMin() != -N - 10) {
            System.out.println("getMin ERROR");
            return;
        }

        if (heap.getMax() != N * N + 1) {
            System.out.println("getMax ERROR");
            return;
        }

        int prevMin = heap.removeMin(); // expected -N-10
        int newMin = heap.getMin();     // expected -N-9
        if (prevMin != -N - 10 || newMin != -N - 9) {
            System.out.println("removeMin ERROR");
            return;
        }

        int prevMax = heap.removeMax(); // expected N*N+1
        int newMax = heap.getMax();     // expected (N-1)*(N-1)+1
        if (prevMax != N * N + 1 || newMax != (N - 1) * (N - 1) + 1) {
            System.out.println("removeMax ERROR");
            return;
        }

        for (int i = 0; i <= N / 4; i++) {
            if (heap.removeMax() != (N - i - 1) * (N - i - 1) + 1) {
                System.out.println("removeMax loop (i=" + i + ") ERROR");
                return;
            }
        }

        System.out.println("test2 OK");
    }

    public static void main(String[] args) {
        test1();
        test2();
    }
}

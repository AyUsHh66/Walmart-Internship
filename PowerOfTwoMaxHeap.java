import java.util.ArrayList;
import java.util.Collections;

public class PowerOfTwoMaxHeap<T extends Comparable<T>> {
    private final int childrenCount;
    private final ArrayList<T> heap;

    public PowerOfTwoMaxHeap(int power) {
        if (power < 0) {
            throw new IllegalArgumentException("Power must be non-negative");
        }
        this.childrenCount = 1 << power; // 2^power
        this.heap = new ArrayList<>();
    }

    public void insert(T value) {
        heap.add(value);
        heapifyUp(heap.size() - 1);
    }

    public T popMax() {
        if (heap.isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }
        T max = heap.get(0);
        T last = heap.remove(heap.size() - 1);
        if (!heap.isEmpty()) {
            heap.set(0, last);
            heapifyDown(0);
        }
        return max;
    }

    private void heapifyUp(int index) {
        while (index > 0) {
            int parentIndex = (index - 1) / childrenCount;
            if (heap.get(index).compareTo(heap.get(parentIndex)) > 0) {
                Collections.swap(heap, index, parentIndex);
                index = parentIndex;
            } else {
                break;
            }
        }
    }

    private void heapifyDown(int index) {
        while (true) {
            int largest = index;
            for (int i = 1; i <= childrenCount; i++) {
                int childIndex = childrenCount * index + i;
                if (childIndex < heap.size() && heap.get(childIndex).compareTo(heap.get(largest)) > 0) {
                    largest = childIndex;
                }
            }
            if (largest != index) {
                Collections.swap(heap, index, largest);
                index = largest;
            } else {
                break;
            }
        }
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    public int size() {
        return heap.size();
    }
}

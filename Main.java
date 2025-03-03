public class Main {
    public static void main(String[] args) {
        PowerOfTwoMaxHeap<Integer> heap = new PowerOfTwoMaxHeap<>(2); // 2^2 = 4 children per node

        heap.insert(10);
        heap.insert(20);
        heap.insert(5);
        heap.insert(30);
        heap.insert(15);

        System.out.println("Max Element: " + heap.popMax()); // Should print 30
        System.out.println("Max Element: " + heap.popMax()); // Should print 20
        System.out.println("Heap Size: " + heap.size()); // Should print 3
    }
}

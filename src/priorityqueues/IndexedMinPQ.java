package priorityqueues;

import java.util.*;

public class IndexedMinPQ<T extends Comparable<T>> {
    private List<T> heap;
    private Map<Integer, Integer> indexMap;

    public IndexedMinPQ() {
        heap = new ArrayList<>();
        indexMap = new HashMap<>();
        // Adding a dummy element at index 0 for 1-based indexing
        heap.add(null);
    }

    public boolean contains(int index) {
        return indexMap.get(index) != null;
    }

    public void insert(int index, T key) {
        if (index <= 0 || index > heap.size() - 1) {
            throw new IllegalArgumentException("Index out of bounds");
        }

        heap.add(key);
        indexMap.put(index, heap.size() - 1);
        swim(heap.size() - 1);
    }

    public int extractMin() {
        if (isEmpty()) {
            throw new NoSuchElementException("Priority queue is empty");
        }

        int minIndex = indexMap.remove(1);
        T min = heap.get(1);
        swap(1, heap.size() - 1);
        indexMap.put(minIndex, 1);
        heap.remove(heap.size() - 1);
        sink(1);

        return minIndex;
    }

    public void decreaseKey(int index, T newKey) {
        if (!indexMap.containsKey(index)) {
            throw new NoSuchElementException("Index not found in the priority queue");
        }

        int heapIndex = indexMap.get(index);
        if (newKey.compareTo(heap.get(heapIndex)) >= 0) {
            throw new IllegalArgumentException("New key is not smaller than the current key");
        }

        heap.set(heapIndex, newKey);
        swim(heapIndex);
    }

    public boolean isEmpty() {
        return heap.size() <= 1;
    }

    private void swim(int k) {
        while (k > 1 && heap.get(k).compareTo(heap.get(k / 2)) < 0) {
            swap(k, k / 2);
            k /= 2;
        }
    }

    private void sink(int k) {
        int n = heap.size() - 1;
        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && heap.get(j).compareTo(heap.get(j + 1)) > 0) {
                j++;
            }
            if (heap.get(k).compareTo(heap.get(j)) <= 0) {
                break;
            }
            swap(k, j);
            k = j;
        }
    }

    private void swap(int i, int j) {
        T temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
        indexMap.put(getIndex(heap.get(i)), i);
        indexMap.put(getIndex(heap.get(j)), j);
    }

    private int getIndex(T key) {
        for (Map.Entry<Integer, Integer> entry : indexMap.entrySet()) {
            if (heap.get(entry.getValue()).equals(key)) {
                return entry.getKey();
            }
        }
        return -1;
    }
}


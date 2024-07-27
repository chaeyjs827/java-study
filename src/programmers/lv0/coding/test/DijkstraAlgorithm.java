package programmers.lv0.coding.test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class DijkstraAlgorithm {

    public static int solution(int N, int[] board) {

        int[] DX = {-1, 1, 0, 0};
        int[] DY = {0, 0, -1, 1};

        int[][] grid = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                grid[i][j] = board[i * N + j];
            }
        }

        int startX = N / 2;
        int startY = N / 2;
        int[][] dist = new int[N][N];
        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        dist[startX][startY] = 0;

        MinHeap heap = new MinHeap(N * N);
        heap.add(new Node(startX, startY, 0));

        while (!heap.isEmpty()) {
            Node current = heap.poll();
            int x = current.x;
            int y = current.y;
            int currentCost = current.cost;

            if (currentCost > dist[x][y]) continue;

            for (int i = 0; i < 4; i++) {
                int nx = x + DX[i];
                int ny = y + DY[i];

                if (isValid(nx, ny, N, x, y)) {
                    int newCost = currentCost + grid[nx][ny];
                    if (newCost < dist[nx][ny]) {
                        dist[nx][ny] = newCost;
                        heap.add(new Node(nx, ny, newCost));
                    }
                }
            }
        }

        int minDist = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            minDist = Math.min(minDist, dist[i][0]);
            minDist = Math.min(minDist, dist[i][N - 1]);
            minDist = Math.min(minDist, dist[0][i]);
            minDist = Math.min(minDist, dist[N - 1][i]);
        }

        return minDist;
    }

    private static boolean isValid(int x, int y, int N, int px, int py) {
        if (x < 0 || x >= N || y < 0 || y >= N) return false;
        if (x == y) return false;
        int K = N / 2;
        return Math.max(Math.abs(x - K), Math.abs(y - K)) <= Math.max(Math.abs(px - K), Math.abs(py - K));
    }

    private static class Node {
        int x, y, cost;
        Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }

    private static class MinHeap {
        private Node[] heap;
        private int size;

        MinHeap(int capacity) {
            heap = new Node[capacity];
            size = 0;
        }

        void add(Node node) {
            if (size >= heap.length) return;
            heap[size] = node;
            siftUp(size++);
        }

        Node poll() {
            if (size == 0) return null;
            Node min = heap[0];
            heap[0] = heap[--size];
            heap[size] = null;
            siftDown(0);
            return min;
        }

        boolean isEmpty() {
            return size == 0;
        }

        private void siftUp(int index) {
            while (index > 0) {
                int parent = (index - 1) / 2;
                if (heap[index].cost >= heap[parent].cost) break;
                swap(index, parent);
                index = parent;
            }
        }

        private void siftDown(int index) {
            while (true) {
                int leftChild = 2 * index + 1;
                int rightChild = 2 * index + 2;
                int smallest = index;

                if (leftChild < size && heap[leftChild].cost < heap[smallest].cost) {
                    smallest = leftChild;
                }
                if (rightChild < size && heap[rightChild].cost < heap[smallest].cost) {
                    smallest = rightChild;
                }
                if (smallest == index) break;
                swap(index, smallest);
                index = smallest;
            }
        }

        private void swap(int i, int j) {
            Node temp = heap[i];
            heap[i] = heap[j];
            heap[j] = temp;
        }
    }
}

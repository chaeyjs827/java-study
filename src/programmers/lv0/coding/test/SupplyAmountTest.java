package programmers.lv0.coding.test;

import java.util.*;

public class SupplyAmountTest {

    public static void main(String[] args) {
        int[][] orders1 = {
                {10, 60},
                {15, 30},
                {20, 80},
                {30, 40},
                {35, 70},
                {40, 20}
        };
        int[][] orders2 = {
                {7, 35},
                {5, 25},
                {3, 15},
                {1, 5}
        };
        int[][] orders3 = {
                {13,39 },
                {16, 50},
                {50, 17},
                {61, 39},
                {92, 22}
        };
//        System.out.println(solution(5, orders1)); // expected=170
        System.out.println(solution(5, orders2)); // expected=35
//        System.out.println(solution(4, orders3)); // expected=128
    }


    public static int solution(int n, int[][] orders) {
        int[][] sortedOrders = bubbleSort(orders);

        int totalProduced = 0;
        int totalDelivered = 0;

        int tempQuantity = 0;

        for (int[] order : sortedOrders) {
            int date = order[0];
            int quantity = order[1];

            totalProduced = date * n;

            int currentInventory = totalProduced - totalDelivered;

            if (currentInventory >= quantity) {
                totalDelivered += quantity;
                tempQuantity = quantity;
            } else {
                if (tempQuantity != 0 && (tempQuantity + currentInventory) >= quantity) {
                    totalDelivered += quantity - tempQuantity;
                    tempQuantity = quantity;
                }
            }
        }

        return totalDelivered;
    }

    private static int[][] bubbleSort(int[][] orders) {
        int n = orders.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (orders[j][0] > orders[j + 1][0]) {
                    int[] temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
        return orders;
    }
}

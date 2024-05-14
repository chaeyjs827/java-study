package javalearn.interview;

public class SubStringComparison {

    public static void main(String[] args) {
        String str = "helloworldjava";
        String[] subStringArray = getSubStringArray(str, 3);
        bubbleSort(subStringArray);
        System.out.println(getSmallestAndLargestArray(subStringArray));
    }

    private static String[] getSubStringArray(String str, int inputLength) {
        int end = str.length() - inputLength + 1;
        String[] subStringArray = new String[end];
        for (int i = 0; i < end; i++) {
            subStringArray[i] = str.substring(i, i + inputLength);
        }
        return subStringArray;
    }

    public static void bubbleSort(String[] substrings) {
        int n = substrings.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (substrings[j].compareTo(substrings[j + 1]) > 0) {
                    // swap substrings[j+1] and substrings[j]
                    String temp = substrings[j];
                    substrings[j] = substrings[j + 1];
                    substrings[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }

    private static String getSmallestAndLargestArray(String[] substrings) {
        String smallest = getSmallest(substrings);
        String largest = getLargest(substrings);
        return smallest+"\n"+largest;
    }

    private static String getSmallest(String[] subStringArray) {
        if (subStringArray.length > 0) {
            return subStringArray[0];
        }
        return null;
    }

    private static String getLargest(String[] subStringArray) {
        if (subStringArray.length > 0) {
            return subStringArray[subStringArray.length - 1];
        }
        return null;
    }

}

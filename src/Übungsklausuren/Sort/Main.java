package Übungsklausuren.Sort;

public class Main {
    public static void main(String[] args) {
        int[] i = new int[5];


        for (int j = 0; j < i.length; j++) {
            i[j] = (int) (Math.random() * 10);
        }
        printArray(i);
        sort(i);
        System.out.println("wird sortiert");
        printArray(i);
    }

    public static void sort(int[] elements) {
        for (int max = elements.length - 1; max > 0; max--) {
            boolean swapped = false;
            for (int i = 0; i < max; i++) {
                int left = elements[i];
                int right = elements[i + 1];
                if (left > right) {
                    elements[i + 1] = left;
                    elements[i] = right;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    public static void printArray(int[] arr) {

        for (int element : arr) {
            System.out.print(element + ", ");
        }
        System.out.println();
    }
}

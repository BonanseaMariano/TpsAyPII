package qSort;

import java.util.Arrays;

public class QuicksortExample {

    public static void main(String[] args) {
        int[] arr = {10, 7, 8, 9, 1, 5};
        int n = arr.length;

        System.out.println("Arreglo original: " + Arrays.toString(arr));

        quicksort(arr, 0, n - 1);

        System.out.println("Arreglo ordenado: " + Arrays.toString(arr));
    }

    public static void quicksort(int[] arr, int low, int high) {
        if (low < high) {
            // Encuentra el índice del pivote y ordena las dos mitades
            int pivotIndex = partition(arr, low, high);

            // Recursivamente ordena las mitades antes y después del pivote
            quicksort(arr, low, pivotIndex - 1);
            quicksort(arr, pivotIndex + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // Elegimos el último elemento como pivote
        int i = low - 1; // Índice del elemento más pequeño

        for (int j = low; j < high; j++) {
            // Si el elemento actual es menor o igual al pivote, lo intercambiamos con el elemento en i
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Intercambiamos el pivote con el elemento en i+1
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1; // Devolvemos el índice del pivote
    }
}

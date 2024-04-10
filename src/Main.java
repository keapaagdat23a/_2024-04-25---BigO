import java.util.Arrays;

public class Main {
  static final int ARRAY_SIZE = 25000;

   public static void main(String[] args) {

      int[] arr = createArray();

      // System.out.println("Original array: " + Arrays.toString(arr));

      // Measure execution time of bubble sort
      long startTime = System.currentTimeMillis();
      bubbleSort(arr.clone());
      long bubbleSortTime = System.currentTimeMillis() - startTime;

      // Measure execution time of insertion sort
      startTime = System.currentTimeMillis();
      insertionSort(arr.clone());
      long insertionSortTime = System.currentTimeMillis() - startTime;

      // Measure execution time of quick sort
      startTime = System.currentTimeMillis();
      quickSort(arr.clone(), 0, arr.length - 1);
      long quickSortTime = System.currentTimeMillis() - startTime;

      System.out.println("Bubble sort time: " + bubbleSortTime + " ms");
      System.out.println("Insertion sort time: " + insertionSortTime + " ms");
      System.out.println("Quick sort time: " + quickSortTime + " ms");
    }

  private static int[] createArray() {
     int[] arr = new int[ARRAY_SIZE];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = (int)(Math.random() * Integer.MAX_VALUE);
    }
    return arr;
  }

  // Bubble sort algorithm
    public static void bubbleSort(int[] arr) {
      int n = arr.length;
      for (int i = 0; i < n-1; i++)
        for (int j = 0; j < n-i-1; j++)
          if (arr[j] > arr[j+1]) {
            int temp = arr[j];
            arr[j] = arr[j+1];
            arr[j+1] = temp;
          }
    }

    // Insertion sort algorithm
    public static void insertionSort(int[] arr) {
      int n = arr.length;
      for (int i = 1; i < n; ++i) {
        int key = arr[i];
        int j = i - 1;

        while (j >= 0 && arr[j] > key) {
          arr[j + 1] = arr[j];
          j = j - 1;
        }
        arr[j + 1] = key;
      }
    }

    // Quick sort algorithm
    public static void quickSort(int[] arr, int low, int high) {
      if (low < high) {
        int pi = partition(arr, low, high);
        quickSort(arr, low, pi - 1);
        quickSort(arr, pi + 1, high);
      }
    }

    public static int partition(int[] arr, int low, int high) {
      int pivot = arr[high];
      int i = (low - 1);
      for (int j = low; j < high; j++) {
        if (arr[j] < pivot) {
          i++;
          int temp = arr[i];
          arr[i] = arr[j];
          arr[j] = temp;
        }
      }
      int temp = arr[i + 1];
      arr[i + 1] = arr[high];
      arr[high] = temp;
      return i + 1;
    }
  }

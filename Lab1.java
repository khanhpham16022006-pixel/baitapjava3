import java.util.*;

public class Lab1 {

    public static boolean isPrime(int num) {
        if (num <= 1) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static int secondLargestPosition(int[] arr) {
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        int position = -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > largest) {
                secondLargest = largest;
                largest = arr[i];
                position = i;
            } else if (arr[i] > secondLargest && arr[i] != largest) {
                secondLargest = arr[i];
                position = i;
            }
        }

        return position;
    }

    public static int[] removeDuplicates(int[] arr) {
        Set<Integer> uniqueSet = new HashSet<>();
        for (int num : arr) {
            uniqueSet.add(num);
        }
        int[] newArr = new int[uniqueSet.size()];
        int index = 0;
        for (int num : uniqueSet) {
            newArr[index++] = num;
        }
        return newArr;
    }

    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void sortArray(int[] arr, int pos) {
        Arrays.sort(arr, 0, pos + 1);

        Arrays.sort(arr, pos + 1, arr.length);
        for (int i = pos + 1; i < arr.length / 2 + pos + 1; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - i + pos];
            arr[arr.length - i + pos] = temp;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n;
        do {
            System.out.print("Enter the number of elements (1-20): ");
            n = scanner.nextInt();
        } while (n <= 0 || n > 20);

        int[] arr = new int[n];
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.println("All elements:");
        printArray(arr);

        int secondLargestPos = secondLargestPosition(arr);
        System.out.println("Second position of the largest value: " + secondLargestPos);

        sortArray(arr, secondLargestPos);
        System.out.println("Array after sorting in ascending to the second largest and descending afterward:");
        printArray(arr);

        arr = removeDuplicates(arr);
        System.out.println("Array after removing duplicates:");
        printArray(arr);

        System.out.println("Prime numbers in the array:");
        for (int num : arr) {
            if (isPrime(num)) {
                System.out.print(num + " ");
            }
        }
    }
}

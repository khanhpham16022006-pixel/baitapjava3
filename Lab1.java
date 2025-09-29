import java.util.*;

public class Lab1 {
    public static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n;
        do {
            System.out.print("Enter the number of elements (1–20): ");
            n = sc.nextInt();
        } while (n <= 0 || n > 20);

        int[] arr = new int[n];
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("All elements: ");
        for (int x : arr) {
            System.out.print(x + " ");
        }
        System.out.println();

        int maxVal = Arrays.stream(arr).max().getAsInt();
        int count = 0, secondPos = -1;
        for (int i = 0; i < n; i++) {
            if (arr[i] == maxVal) {
                count++;
                if (count == 2) {
                    secondPos = i;
                    break;
                }
            }
        }

        if (secondPos != -1) {
            System.out.println("Second position of the largest value: " + (secondPos + 1));

            Arrays.sort(arr, 0, secondPos + 1);

            Arrays.sort(arr, secondPos, n);
            for (int i = secondPos, j = n - 1; i < j; i++, j--) {
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }

            System.out.print("Array after sorting (asc/desc): ");
            for (int x : arr) {
                System.out.print(x + " ");
            }
            System.out.println();

            ArrayList<Integer> list = new ArrayList<>();
            for (int x : arr) {
                if (!list.contains(x)) {
                    list.add(x);
                }
            }

            System.out.print("Array after removing duplicates: ");
            for (int x : list) {
                System.out.print(x + " ");
            }
            System.out.println();

            System.out.print("Prime numbers in the array: ");
            boolean foundPrime = false;
            for (int x : list) {
                if (isPrime(x)) {
                    System.out.print(x + " ");
                    foundPrime = true;
                }
            }
            if (!foundPrime) {
                System.out.print("None");
            }
            System.out.println();

        } else {
            System.out.println("The largest value does not appear twice.");
        }
    }
}


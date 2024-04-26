import java.util.Scanner;

public class InsertionSortLab {
    private static int comparisons;
    private static int swaps;

    public static int [] numRead() {
        int i;          // for loop variable
        int size;       // variable for size of array
        int [] numbers; // array of integers

        Scanner scnr = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        size = scnr.nextInt();
        System.out.println("Enter integer elements of array: ");
        numbers = new int [size];
        for (i = 0; i < size; ++i) {
            numbers[i] = scnr.nextInt();
        }
        return numbers;
    }

    public static void numPrint(int [] nums) {
        // use a for each loop to print array at each swap
        for (int num : nums) {
            System.out.print(num + " ");
        }
        // Print a new line after each array
        System.out.println();
    }

    public static void insertionSort(int[] numbers) {
        int i;          // for loop variable
        int j;          // while loop variable
        int temp;       // temporary variable for swap

        for (i = 1; i < numbers.length; ++i) {
            j = i;
            while(j > 0 && numbers[j] < numbers[j - 1]) {
                // comparison has been made
                comparisons++;
                temp = numbers[j];
                numbers[j] = numbers[j - 1];
                numbers[j - 1] = temp;
                // swap has been made
                swaps++;
                /* The pointer needs to return to the j-1
                   position to check while loop conditions
                   again. */
                --j;
            }
            /* To account for final comparison made, which happens
               outside of the while loop, comparison must be
               incremented once more. Since the while loop decrements
               j to array index 0 by the last iteration, the
               for loop then increments i for the length of the array,
               setting the value of j equal to i.Check to see IF j is
               greater than zero after the while loop block for last
               comparison increment. */
            if (j > 0) comparisons++;
            // print sorted array after each swap, call printing method
            numPrint(numbers);
        }
    }

    public static void main(String[] args) {
        // Initialize numbers array using numRead() method
        int [] numbers = numRead();
        // Enter newline to give space from user input in display
        System.out.println();
        // Print initial array as input by user
        numPrint(numbers);
        // Insert newline to give space between initial array and
        // sorted array output
        System.out.println();
        // Call insertionSort() method to sort array in ascending order
        // and print each step of the process
        insertionSort(numbers);
        // Insert another newline between sorted arrays and comparisons
        System.out.println();
        // Print the value of comparisons
        System.out.println("Comparisons: " + comparisons);
        // Print the value of swaps
        System.out.println("Swaps: " + swaps);
    }
}

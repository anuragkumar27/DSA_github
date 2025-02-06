import java.util.Arrays;

public class cycle_sort {
    public static void cycleSort(int[] arr) {
        int n = arr.length;

        for (int start = 0; start < n - 1; start++) {
            int item = arr[start]; // Pick the starting element
            int pos = start;

            // Step 1: Count elements smaller than item
            for (int i = start + 1; i < n; i++) {
                if (arr[i] < item) {
                    pos++;
                }
            }

            // If the item is already in the correct position, continue
            if (pos == start) {
                continue;
            }

            // Step 2: Skip duplicates
            while (item == arr[pos]) {
                pos++;
            }

            // Swap item to its correct position
            int temp = arr[pos];
            arr[pos] = item;
            item = temp;

            // Step 3: Rotate rest of the cycle
            while (pos != start) {
                pos = start;
                for (int i = start + 1; i < n; i++) {
                    if (arr[i] < item) {
                        pos++;
                    }
                }

                while (item == arr[pos]) {
                    pos++;
                }

                temp = arr[pos];
                arr[pos] = item;
                item = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = { 1,2,0 };
        cycleSort(arr);
        System.out.println(Arrays.toString(arr)); // Output: [1, 2, 3, 4, 5]
    }
}

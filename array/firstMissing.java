import java.util.Arrays;

class fistMissing{
    public static int firstMissingPositive(int[] arr) {
        int n = arr.length;
        
        // Step 1: Place each number in its correct position (i.e., arr[i] should be i+1)
        for (int i = 0; i < n; i++) {
            while (arr[i] > 0 && arr[i] <= n && arr[arr[i] - 1] != arr[i]) {
                // Swap arr[i] and arr[arr[i] - 1] to put the number in the correct position
                int temp = arr[i];
                arr[i] = arr[arr[i] - 1];
                arr[temp - 1] = temp;
            }
        }

        // Step 2: Find the first index where arr[i] != i + 1
        for (int i = 0; i < n; i++) {
            if (arr[i] != i + 1) {
                return i + 1; // First missing positive
            }
        }

        // Step 3: If all positions are filled correctly, the answer is n + 1
        return n + 1;
    }
    public static void main(String[] args) {
        int[] arr = {3,4,-1,1 };
        int res = firstMissingPositive(arr);
        System.out.println(res);  // Output: 2                  
        System.out.println(Arrays.toString(arr)); // Output: [1, 2, 3, 4, 5]
    }
}

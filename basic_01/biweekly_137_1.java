class biweekly_137_1 {
    public static int[] resultsArray(int[] nums, int k) {
        
            int n = nums.length;
            int[] result = new int[n - k + 1];
            
            // Handle the case when k is 1 separately
            if (k == 1) {
                return nums.clone();
            }
            
            // Initialize the first window
            boolean consecutive = true;
            for (int i = 0; i < k - 1; i++) {
                if (nums[i] + 1 != nums[i + 1]) {
                    consecutive = false;
                    break;
                }
            }
            
            // Process all windows
            for (int i = 0; i <= n - k; i++) {
                if (consecutive) {
                    result[i] = nums[i + k - 1];
                } else {
                    result[i] = -1;
                }
                
                // Update consecutive for the next window
                if (i < n - k) {
                    if (consecutive) {
                        consecutive = (nums[i + k - 1] + 1 == nums[i + k]);
                    } else {
                        consecutive = true;
                        for (int j = i + 1; j < i + k; j++) {
                            if (nums[j] + 1 != nums[j + 1]) {
                                consecutive = false;
                                break;
                            }
                        }
                    }
                }
            }
            
            return result;
    }

    public static void main(String[] args) {

        // Test case 1
        int[] nums1 = { 1,1,1,2,3};
        int k1 = 3;
        int[] result1 = resultsArray(nums1, k1);
        System.out.println("Test case 1: " + java.util.Arrays.toString(result1)); // Expected output: [3, 4, 5]

        // Test case 2
        int[] nums2 = { 1, 2, 4, 5, 6 };
        int k2 = 3;
        int[] result2 = resultsArray(nums2, k2);
        System.out.println("Test case 2: " + java.util.Arrays.toString(result2)); // Expected output: [4, 5, -1]

        // Test case 3
        int[] nums3 = { 1, 1 };
        int k3 = 1;
        int[] result3 = resultsArray(nums3, k3);
        System.out.println("Test case 3: " + java.util.Arrays.toString(result3)); // Expected output: [1, 1]

    }
}

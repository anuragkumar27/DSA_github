//78. Subsets && Print all subsequences/Power Set
/*Given an integer array nums of unique elements, return all possible 
subsets
 (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

 

Example 1:

Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
Example 2:

Input: nums = [0]
Output: [[],[0]] */

import java.util.ArrayList;
import java.util.List;

public class subsequence {
    static List<List<Integer>> subset(int[] nums) {
        List<List<Integer>> set = new ArrayList<>();
        int n = nums.length;
        int s = 1 << n;

        for (int i = 0; i < s; i++) {
            List<Integer> subset = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    subset.add(nums[j]);
                }
            }
            set.add(subset);
        }
        return set;

    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3 };
        List<List<Integer>> set = subset(arr);
        for (List<Integer> subset : set) {
            System.out.print(subset + " ");
        }
    }

}

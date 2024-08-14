/*78. Subsets
Solved
Medium
Topics
Companies
Given an integer array nums of unique elements, return all possible 
subsets
 (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

 

Example 1:

Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
Example 2:

Input: nums = [0]
Output: [[],[0]] */

import java.util.List;
import java.util.ArrayList;

public class subsets {
    static void findsubsets(int[] arr, int index, List<List<Integer>> set, List<Integer> ds) {
        if (index == arr.length) {
            set.add(new ArrayList<>(ds));
            return;
        }
        ds.add(arr[index]);
        findsubsets(arr, index + 1, set, ds);
        ds.remove(ds.size() - 1);
        findsubsets(arr, index + 1, set, ds);
    }

    public static List<List<Integer>> subset(int[] nums) {
        List<List<Integer>> set = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        findsubsets(nums, 0, set, ds);
        return set;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        List<List<Integer>> result = subset(nums);
        System.out.println(result);
        // Output: [[], [1], [2], [1, 2], [3], [1, 3], [2, 3], [1, 2, 3]]
    }
}



/*40. Combination Sum II
Solved
Medium
Topics
Companies
Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.

Each number in candidates may only be used once in the combination.

Note: The solution set must not contain duplicate combinations.

 

Example 1:

Input: candidates = [10,1,2,7,6,1,5], target = 8
Output: 
[
[1,1,6],
[1,2,5],
[1,7],
[2,6]
]
Example 2:

Input: candidates = [2,5,2,1,2], target = 5
Output: 
[
[1,2,2],
[5]
] */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class combinationSum2 {
    static void findcombinationSum2(int[] arr, int index, int target, List<List<Integer>> list, List<Integer> ds) {
        if (target == 0) {
            list.add(new ArrayList<>(ds));
            return;
        }
        for (int i = index; i < arr.length; i++) {
            if (i > index && arr[i] == arr[i - 1])
                continue;
            if (arr[i] > target)
                break;
            ds.add(arr[i]);
            findcombinationSum2(arr, i + 1, target - arr[i], list, ds);
            ds.remove(ds.size() - 1);
        }

    }

    public static List<List<Integer>> combiSum2(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        Arrays.sort(candidates);
        findcombinationSum2(candidates, 0, target, list, ds);
        return list;
    }

    public static void main(String[] args) {
        int[] candidates = { 10, 1, 2, 7, 6, 1, 5 };
        int target = 8;
        List<List<Integer>> result = combiSum2(candidates, target);
        System.out.println(result); // Expected output: [[1, 1, 6], [1, 2, 5], [1, 7], [2, 6]]
    }

}

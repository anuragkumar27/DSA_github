

//Solution

import java.util.ArrayList;
import java.util.List;

class combinationSum {
    static void findcombinationSum(int arr[], int index, int target, List<List<Integer>> list, List<Integer> ds) {
        if (index == arr.length) {
            if (target == 0) {
                list.add(new ArrayList<>(ds));
            }
            return;
        }
        if (arr[index] <= target) {
            ds.add(arr[index]);
            findcombinationSum(arr, index, target - arr[index], list, ds);
            ds.remove(ds.size() - 1);
        }
        findcombinationSum(arr, index + 1, target, list, ds);
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        findcombinationSum(candidates, 0, target, list, ds);
        return list;
    }

    public static void main(String[] args) {
        int[] candidates = { 2, 3, 6, 7 };
        int target = 7;
        List<List<Integer>> result = combinationSum(candidates, target);
        System.out.println(result); // Output: [[2, 2, 3], [7]]
    }
}

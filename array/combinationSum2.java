
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

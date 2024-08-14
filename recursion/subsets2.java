import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class subsets2 {
    static void printAns(List<List<Integer>> ans) {
        System.out.println("The unique subsets are ");
        System.out.println(ans.toString().replace(",", " "));
    }

    // public static void findSubsets(int ind, int[] nums, List<Integer> ds,
    // List<List<Integer>> ansList) {
    // ansList.add(new ArrayList<>(ds));
    // for (int i = ind; i < nums.length; i++) {
    // if (i != ind && nums[i] == nums[i - 1])
    // continue;
    // ds.add(nums[i]);
    // findSubsets(i + 1, nums, ds, ansList);
    // ds.remove(ds.size() - 1);
    // }

    // }

    // public static List<List<Integer>> subsetsWithDup(int[] nums) {
    // Arrays.sort(nums);
    // List<List<Integer>> ansList = new ArrayList<>();
    // findSubsets(0, nums, new ArrayList<>(), ansList);
    // return ansList;
    // }

    static void findsubsets(int[] arr, int index, List<List<Integer>> list,
            List<Integer> ds) {
        list.add(new ArrayList<>(ds));
        for (int i = index; i < arr.length; i++) {
            if (i != index && arr[i] == arr[i - 1])
                continue;
            ds.add(arr[i]);
            findsubsets(arr, i + 1, list, ds);
            ds.remove(ds.size() - 1);
        }
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        Arrays.sort(nums);
        findsubsets(nums, 0, list, ds);
        return list;
    }

    public static void main(String args[]) {
        int nums[] = { 1, 2, 2 };

        List<List<Integer>> ans = subsetsWithDup(nums);
        printAns(ans);

    }
}

/*46. Permutations
Medium
Topics
Companies
Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.

 

Example 1:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
Example 2:

Input: nums = [0,1]
Output: [[0,1],[1,0]]
Example 3:

Input: nums = [1]
Output: [[1]] */

import java.util.ArrayList;
import java.util.List;

public class permutations {
    // static void findpermutations(int arr[], List<Integer> ds, List<List<Integer>> list, boolean[] freq) {
    //     if (ds.size() == arr.length) {
    //         list.add(new ArrayList<>(ds));
    //         return;
    //     }
    //     for (int i = 0; i < arr.length; i++) {
    //         if (!freq[i]) {
    //             freq[i] = true;
    //             ds.add(arr[i]);
    //             findpermutations(arr, ds, list, freq);
    //             ds.remove(ds.size() - 1);
    //             freq[i] = false;
    //         }
    //     }
    // }

    // public static List<List<Integer>> permute(int[] nums) {
    //     List<Integer> ds = new ArrayList<>();
    //     List<List<Integer>> list = new ArrayList<>();
    //     boolean[] freq = new boolean[nums.length];
    //     findpermutations(nums, ds, list, freq);
    //     return list;
    // }

    static void findpermutations(int index,int arr[],List<List<Integer>> list){
        if(index==arr.length){
            List<Integer> ds = new ArrayList<>();
            for(int i=0;i<arr.length;i++){
                ds.add(arr[i]);
            }
            list.add(new ArrayList<>(ds));
            return;
        }
        for(int i=index;i<arr.length;i++){
            swap(i,index,arr);
            findpermutations(index+1,arr,list);
            swap(i,index,arr);
        }
    }
    static void swap(int i,int j,int[] arr){
        int temp= arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        findpermutations(0,nums,list);
        return list;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        List<List<Integer>> permutations = permute(nums);

        for (List<Integer> perm : permutations) {
            System.out.println(perm);
        }
    }
}

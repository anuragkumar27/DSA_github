/*Subset Sums
Difficulty: MediumAccuracy: 72.55%Submissions: 123K+Points: 4
Given a list arr of n integers, return sums of all subsets in it. Output sums can be printed in any order.

 

Example 1:

Input:
n = 2
arr[] = {2, 3}
Output:
0 2 3 5
Explanation:
When no elements is taken then Sum = 0.
When only 2 is taken then Sum = 2.
When only 3 is taken then Sum = 3.
When element 2 and 3 are taken then 
Sum = 2+3 = 5.
Example 2:

Input:
n = 3
arr = {5, 2, 1}
Output:
0 1 2 3 5 6 7 8 */

import java.util.ArrayList;
import java.util.Collections;

public class subsetSum {

    void findSubsetsum(ArrayList<Integer> arr, int index, ArrayList<Integer> sumset, int sum) {
        if (index == arr.size()) {
            sumset.add(sum);
            return;
        }
        findSubsetsum(arr, index + 1, sumset, sum + arr.get(index));
        findSubsetsum(arr, index + 1, sumset, sum);
    }

    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int n) {
        ArrayList<Integer> sumset = new ArrayList<>();
        findSubsetsum(arr, 0, sumset, 0);
        Collections.sort(sumset);
        return sumset;
    }

    public static void main(String[] args) {
        subsetSum obj = new subsetSum();

        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(3);
        arr.add(1);
        arr.add(2);
        ArrayList<Integer> result = obj.subsetSums(arr, arr.size());
        System.out.println(result); // Output: [0, 1, 2, 3, 3, 4, 5, 6]
    }
}

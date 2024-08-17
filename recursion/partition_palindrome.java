/*131. Palindrome Partitioning
Medium
Topics
Companies
Given a string s, partition s such that every 
substring
 of the partition is a 
palindrome
. Return all possible palindrome partitioning of s.

 

Example 1:

Input: s = "aab"
Output: [["a","a","b"],["aa","b"]]
Example 2:

Input: s = "a"
Output: [["a"]] */

import java.util.ArrayList;
import java.util.List;

public class partition_palindrome {
    static void findpalindrome(int index, String s, List<List<String>> list, List<String> ds) {
        if (index == s.length()) {
            list.add(new ArrayList<>(ds));
            return;
        }
        for (int i = index; i < s.length(); i++) {
            if (isPalindrome(s, index, i)) {
                ds.add(s.substring(index, i + 1));
                findpalindrome(i + 1, s, list, ds);
                ds.remove(ds.size() - 1);
            }
        }
    }

    static boolean isPalindrome(String s, int start, int end) {
        while (start <= end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }

    public static List<List<String>> partition(String s) {
        List<List<String>> list = new ArrayList<>();
        List<String> ds = new ArrayList<>();
        findpalindrome(0, s, list, ds);
        return list;
    }

    public static void main(String[] args) {
        String input = "aabb";

        List<List<String>> result = partition(input);

        System.out.println("All possible palindromic partitions of the string \"" + input + "\":");
        for (List<String> partition : result) {
            System.out.println(partition);
        }
    }

}

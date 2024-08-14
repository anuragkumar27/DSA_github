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

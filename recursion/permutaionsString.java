import java.util.ArrayList;
import java.util.List;

public class permutaionsString {
    static void findPermutations(String str, List<Character> ds, List<String> list, boolean[] freq) {
        if (ds.size() == str.length()) {
            StringBuilder sb = new StringBuilder();
            for (char c : ds) {
                sb.append(c);
            }
            list.add(sb.toString());
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            if (freq[i] || (i > 0 && str.charAt(i) == str.charAt(i-1) && !freq[i - 1])) {
                continue;
            }
            freq[i] = true;
            ds.add(str.charAt(i));
            findPermutations(str, ds, list, freq);
            ds.remove(ds.size() - 1);
            freq[i] = false;

        }
    }

    public static List<String> permute(String str) {
        List<Character> ds = new ArrayList<>();
        List<String> list = new ArrayList<>();
        boolean[] freq = new boolean[str.length()];
        findPermutations(str, ds, list, freq);
        return list;
    }

    public static void main(String[] args) {

        String input = "ABB";
        List<String> permutations = permute(input);

        // Print all permutations
        for (String perm : permutations) {
            System.out.println(perm);
        }
    }
}

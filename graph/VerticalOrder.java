import java.util.*;

// Node class for the binary tree
class Node {
    int data;
    Node left;
    Node right;

    public Node(int val) {
        data = val;
        left = null;
        right = null;
    }
}

public class VerticalOrder {
    // Function to perform vertical order traversal and return a 2D list of node
    // values
    public List<List<Integer>> findVertical(Node root) {
        Map<Integer, TreeMap<Integer, ArrayList<Integer>>> node = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(root, 0, 0));
        while (!q.isEmpty()) {
            Tuple curr = q.poll();
            int x = curr.x; // vertical
            int y = curr.y; // level

            node.putIfAbsent(x, new TreeMap<>());
            node.get(x).putIfAbsent(y, new ArrayList<>());
            node.get(x).get(y).add(curr.node.data);

            if (curr.node.left != null) {
                q.add(new Tuple(curr.node.left, x - 1, y + 1));
            }
            if (curr.node.right != null) {
                q.add(new Tuple(curr.node.right, x + 1, y + 1));
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        for (TreeMap<Integer, ArrayList<Integer>> ys : node.values()) {
            List<Integer> curr = new ArrayList<>();
            for (ArrayList<Integer> s : ys.values()) {
                Collections.sort(s);
                curr.addAll(s);
            }
            res.add(curr);
        }
        return res;
    }

    class Tuple {
        Node node;
        int x;
        int y;

        public Tuple(Node node, int x, int y) {
            this.node = node;
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        // Create a sample binary tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(10);
        root.left.left.right = new Node(5);
        root.left.left.right.right = new Node(6);
        root.right = new Node(3);
        root.right.right = new Node(10);
        root.right.left = new Node(9);

        VerticalOrder solution = new VerticalOrder();

        // Get the vertical traversal of the binary tree
        List<List<Integer>> verticalTraversal = solution.findVertical(root);

        // Print the result
        for (List<Integer> column : verticalTraversal) {
            System.out.println(column);
        }
    }
}

import java.util.*;

class Pair {
    int node;
    int weight;

    Pair(int node, int weight) {
        this.node = node;
        this.weight = weight;
    }
}

public class Dijkstra {
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.weight - y.weight);
        int[] res = new int[V];
        Arrays.fill(res, Integer.MAX_VALUE);
        res[S] = 0;
        pq.add(new Pair(S, 0));

        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int node = current.node;
            int weight = current.weight;

            for (int i = 0; i < adj.get(node).size(); i++) {
                int adj_node = adj.get(node).get(i).get(0);
                int adj_wt = adj.get(node).get(i).get(1);

                if (res[adj_node] > weight + adj_wt) {
                    res[adj_node] = weight + adj_wt;
                    pq.offer(new Pair(adj_node, res[adj_node]));
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Number of vertices and edges
        int V = sc.nextInt();
        int E = sc.nextInt();

        // Adjacency list representation of the graph
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Reading edges
        for (int i = 0; i < E; i++) {
            int u = sc.nextInt(); // from vertex
            int v = sc.nextInt(); // to vertex
            int w = sc.nextInt(); // weight of the edge

            ArrayList<Integer> edge = new ArrayList<>();
            edge.add(v); // destination vertex
            edge.add(w); // weight of the edge
            adj.get(u).add(edge); // add this edge to the adjacency list
        }

        // Source vertex
        int S = sc.nextInt();

        // Running Dijkstra's algorithm
        int[] result = dijkstra(V, adj, S);

        // Printing the result
        // Printing the result
        for (int i = 0; i < V; i++) {
            if (result[i] == Integer.MAX_VALUE) {
                System.out.print("Infinity "); // or use -1
            } else {
                System.out.print(result[i] + " ");
            }
        }

    }
}

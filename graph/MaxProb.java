/*1514. Path with Maximum Probability
Solved
Medium
Topics
Companies
Hint
You are given an undirected weighted graph of n nodes (0-indexed), represented by an edge list where edges[i] = [a, b] is an undirected edge connecting the nodes a and b with a probability of success of traversing that edge succProb[i].

Given two nodes start and end, find the path with the maximum probability of success to go from start to end and return its success probability.

If there is no path from start to end, return 0. Your answer will be accepted if it differs from the correct answer by at most 1e-5.

 

Example 1:



Input: n = 3, edges = [[0,1],[1,2],[0,2]], succProb = [0.5,0.5,0.2], start = 0, end = 2
Output: 0.25000
Explanation: There are two paths from start to end, one having a probability of success = 0.2 and the other has 0.5 * 0.5 = 0.25. */

import java.util.*;

class MaxProb {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        // Create adjacency list to store the graph
        Map<Integer, List<double[]>> adj = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            double prob = succProb[i];

            adj.putIfAbsent(u, new ArrayList<>());
            adj.putIfAbsent(v, new ArrayList<>());
            adj.get(u).add(new double[] { v, prob });
            adj.get(v).add(new double[] { u, prob });
        }

        // Array to store the maximum probability to reach each node
        double[] maxprob = new double[n];
        Arrays.fill(maxprob, 0.0);
        maxprob[start_node] = 1.0;

        // Priority queue to process nodes with maximum probability first
        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));
        pq.offer(new double[] { maxprob[start_node], start_node });

        while (!pq.isEmpty()) {
            double[] curr = pq.poll();
            double prob = curr[0];
            int node = (int) curr[1];

            // If the end node is reached, return the probability
            if (node == end_node)
                return prob;

            // Process all neighbors of the current node
            if (adj.containsKey(node)) {
                for (double[] neighbour : adj.get(node)) {
                    int adj_node = (int) neighbour[0];
                    double edge_prob = neighbour[1];
                    double new_prob = prob * edge_prob;

                    // Update the maximum probability and add to queue if improved
                    if (maxprob[adj_node] < new_prob) {
                        maxprob[adj_node] = new_prob;
                        pq.offer(new double[] { new_prob, adj_node });
                    }
                }
            }
        }

        // Return 0.0 if there is no path from start_node to end_node
        return 0.0;
    }

    public static void main(String[] args) {
        MaxProb sol = new MaxProb();
        int n = 3;
        int[][] edges = { { 0, 1 }, { 1, 2 }, { 0, 2 } };
        double[] succProb = { 0.5, 0.5, 0.2 };
        int start_node = 0;
        int end_node = 2;

        double result = sol.maxProbability(n, edges, succProb, start_node, end_node);
        System.out.println("Maximum probability: " + result); // Expected output: 0.25
    }
}

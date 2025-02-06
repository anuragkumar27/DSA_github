import java.util.*;

public class biDirectionalBFS {
    
    // Function to perform Bi-Directional BFS
    public static int bidirectionalBFS(Map<Integer, List<Integer>> graph, int start, int goal) {
        if (start == goal) return 0;

        // Two queues for BFS
        Queue<Integer> queueStart = new LinkedList<>();
        Queue<Integer> queueGoal = new LinkedList<>();
        
        // Two visited sets
        Set<Integer> visitedStart = new HashSet<>();
        Set<Integer> visitedGoal = new HashSet<>();
        
        // Add start and goal to their respective queues
        queueStart.add(start);
        queueGoal.add(goal);
        visitedStart.add(start);
        visitedGoal.add(goal);
        
        int steps = 0;
        
        // BFS Loop
        while (!queueStart.isEmpty() && !queueGoal.isEmpty()) {
            steps++;
            if (expandLevel(graph, queueStart, visitedStart, visitedGoal)) return steps;
            if (expandLevel(graph, queueGoal, visitedGoal, visitedStart)) return steps;
        }
        
        return -1; // No path found
    }

    // Function to expand a level in BFS
    private static boolean expandLevel(Map<Integer, List<Integer>> graph, Queue<Integer> queue, 
                                       Set<Integer> visitedThisSide, Set<Integer> visitedOtherSide) {
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            int node = queue.poll();
            if (visitedOtherSide.contains(node)) return true; // Paths meet
            
            for (int neighbor : graph.getOrDefault(node, new ArrayList<>())) {
                if (!visitedThisSide.contains(neighbor)) {
                    visitedThisSide.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // Example Graph (Adjacency List Representation)
        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(1, Arrays.asList(2, 4));
        graph.put(2, Arrays.asList(1, 3, 5));
        graph.put(3, Arrays.asList(2, 6));
        graph.put(4, Arrays.asList(1, 5));
        graph.put(5, Arrays.asList(2, 4, 6));
        graph.put(6, Arrays.asList(3, 5, 7));
        graph.put(7, Arrays.asList(6));

        int start = 1;
        int goal = 7;
        
        int shortestPath = bidirectionalBFS(graph, start, goal);
        System.out.println("Shortest path length: " + shortestPath);
    }
}

import java.util.*;

public class MazeBFS {
   
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {1, 0, -1, 0};

    static boolean bfs(int[][] maze,int startX,int startY,int n,int m){
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX,startY});
        visited[startX][startY] = true;

        while(!queue.isEmpty()){
            int [] curr = queue.poll();
            int x = curr[0];
            int y = curr[1];
            if(x==n-1 && y==m-1){
                return true;
            }
            for(int i=0;i<4;i++){
                int newx = x+dx[i];
                int newy = y+dy[i];
                if(newx>=0 && newx<n && newy>=0 && newy<m && maze[newx][newy]==0 && !visited[newx][newy]){
                    queue.add(new int[]{newx,newy});
                    visited[newx][newy] = true;
                }

            }
            

        }
        return false;
    }

    public static void main(String[] args) {
        // 0 represents open path, 1 represents wall
        int[][] maze = {
            {0, 0, 1, 0, 0},
            {0, 1, 0, 1, 0},
            {0, 0, 0, 0, 0},
            {1, 1, 1, 1, 0},
            {0, 0, 0, 0, 0}
        };

        if (bfs(maze, 0, 0, 5, 5)) {
            System.out.println("Path found!");
        } else {
            System.out.println("No path found.");
        }
    }
}

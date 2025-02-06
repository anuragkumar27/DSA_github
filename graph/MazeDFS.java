import java.util.*;

public class MazeDFS {

    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {1, 0, -1, 0};

    static boolean dfs(int[][] maze,int startX,int startY,int endX,int endY,boolean[][] visited){
        if(startX==endX && startY ==endY){
            return true;
        }
        visited[startX][startY] = true;
        for(int i=0;i<4;i++){
            int newX = startX + dx[i];
            int newY = startY + dy[i];
            if(newX>=0 && newX<=endX && newY>=0 && newY<=endY && maze[newX][newY]==0 && !visited[newX][newY]){
                if(dfs(maze,newX,newY,endX,endY,visited)){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // 0 represents open path, 1 represents wall
        int[][] maze = {
                { 0, 0, 1, 0, 0 },
                { 0, 1, 0, 1, 0 },
                { 0, 0, 0, 0, 0 },
                { 1, 1, 1, 1, 0 },
                { 0, 0, 0, 0, 0 }
        };

        boolean[][] visited = new boolean[maze.length][maze[0].length];

        if (dfs(maze, 0, 0, 4, 4, visited)) {
            System.out.println("Path found!");
        } else {
            System.out.println("No path found.");
        }
    }
}

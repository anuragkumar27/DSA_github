/*Rat in a Maze Problem - I
Difficulty: MediumAccuracy: 35.75%Submissions: 285K+Points: 4
Consider a rat placed at (0, 0) in a square matrix mat of order n* n. It has to reach the destination at (n - 1, n - 1). Find all possible paths that the rat can take to reach from source to destination. The directions in which the rat can move are 'U'(up), 'D'(down), 'L' (left), 'R' (right). Value 0 at a cell in the matrix represents that it is blocked and rat cannot move to it while value 1 at a cell in the matrix represents that rat can be travel through it.
Note: In a path, no cell can be visited more than one time. If the source cell is 0, the rat cannot move to any other cell. In case of no path, return an empty list. The driver will output "-1" automatically.

Examples:

Input: mat[][] = [[1, 0, 0, 0],
                [1, 1, 0, 1], 
                [1, 1, 0, 0],
                [0, 1, 1, 1]]
Output: DDRDRR DRDDRR
Explanation: The rat can reach the destination at (3, 3) from (0, 0) by two paths - DRDDRR and DDRDRR, when printed in sorted order we get DDRDRR DRDDRR.
Input: mat[][] = [[1, 0],
                [1, 0]]
Output: -1
Explanation: No path exists and destination cell is blocked. */

import java.util.ArrayList;
import java.util.List;

class rat_maze {
    static void findpath(int i, int j, int[][] mat, List<String> res, String move, int[] di, int[] dj, int[][] vis) {
        if (i == mat.length - 1 && j == mat.length - 1) {
            res.add(move);
            return;
        }

        String s = "DLRU"; // Order of movements: Down, Left, Right, Up
        for (int ind = 0; ind < 4; ind++) {
            int nexti = i + di[ind];
            int nextj = j + dj[ind];
            if (nexti >= 0 && nextj >= 0 && nexti < mat.length && nextj < mat.length
                    && vis[nexti][nextj] == 0 && mat[nexti][nextj] == 1) {

                vis[i][j] = 1; // Mark current cell as visited
                findpath(nexti, nextj, mat, res, move + s.charAt(ind), di, dj, vis);
                vis[i][j] = 0; // Unmark current cell to backtrack
            }
        }
    }

    public static List<String> findPath(int[][] mat) {
        int[][] vis = new int[mat.length][mat.length];
        String move = "";
        int[] di = { 1, 0, 0, -1 }; // Directions for Down, Left, Right, Up
        int[] dj = { 0, -1, 1, 0 };
        List<String> res = new ArrayList<>();
        if (mat[0][0] == 1) { // Start from (0,0) only if it's a valid cell
            findpath(0, 0, mat, res, move, di, dj, vis);
        }
        return res;
    }

    public static void main(String[] args) {

        int[][] mat = {
                { 1, 0, 0, 0 },
                { 1, 1, 0, 1 },
                { 1, 1, 0, 0 },
                { 0, 1, 1, 1 }
        };
        List<String> result = findPath(mat);
        for (String path : result) {
            System.out.println(path);
        }
    }
}

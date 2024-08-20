import java.util.ArrayList;
// import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class nqueen {
    static void putqueen(int col, char[][] board, List<List<String>> list, int[] leftrow, int[] upperdiagonal,
            int[] lowerdiagonal) {
        if (col == board.length) {
            list.add(construct(board));
            return;
        }
        for (int row = 0; row < board.length; row++) {
            if (leftrow[row] == 0 && upperdiagonal[row + col] == 0
                    && lowerdiagonal[board.length - 1 + row - col] == 0) {
                board[row][col] = 'Q';
                leftrow[row] = 1;
                upperdiagonal[row + col] = 1;
                lowerdiagonal[board.length - 1 + row - col] = 1;
                putqueen(col + 1, board, list, leftrow, upperdiagonal, lowerdiagonal);
                board[row][col] = '.';
                leftrow[row] = 0;
                upperdiagonal[row + col] = 0;
                lowerdiagonal[board.length - 1 + row - col] = 0;
            }
        }
    }

    static List<String> construct(char[][] board) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> list = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        int[] leftrow = new int[n];
        int[] lowerdiagonal = new int[2 * n - 1];
        int[] upperdiagonal = new int[2 * n - 1];
        putqueen(0, board, list, leftrow, upperdiagonal, lowerdiagonal);
        return list;
    }

    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        List<List<String>> list = solveNQueens(n);
        int i = 1;
        for (List<String> it : list) {
            System.out.println("Arrangement " + i);
            for (String s : it) {
                System.out.println(s);
            }
            System.out.println();
            i += 1;
        }
        sc.close();
    }
}

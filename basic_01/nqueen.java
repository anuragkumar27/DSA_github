import java.util.ArrayList;
// import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class nqueen {
    static List<List<String>> solveQueen(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        List<List<String>> list = new ArrayList<>();
        putqueen(0, board, list);
        return list;
    }

    static boolean validate(char[][] board, int row, int col) {
        int duprow = row;
        int dupcol = col;
        while (row >= 0 && col >= 0) {
            if (board[row][col] == 'Q') {
                return false;
            }
            row--;
            col--;
        }
        row = duprow;
        col = dupcol;
        while (col >= 0) {
            if (board[row][col] == 'Q') {
                return false;
            }
            col--;
        }
        row = duprow;
        col = dupcol;
        while (row < board.length && col >= 0) {
            if (board[row][col] == 'Q') {
                return false;
            }
            row++;
            col--;
        }
        return true;

    }

    static void putqueen(int col, char[][] board, List<List<String>> list) {
        if (col == board.length) {
            list.add(construct(board));
            return;
        }
        for (int row = 0; row < board.length; row++) {
            if (validate(board, row, col)) {
                board[row][col] = 'Q';
                putqueen(col + 1, board, list);
                board[row][col] = '.';
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

    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        List<List<String>> list = solveQueen(n);
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

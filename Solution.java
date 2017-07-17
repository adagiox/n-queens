import java.util.*;

// i = row = y
// j = col = x

public class Solution
{
    public static void main(String args[])
    {
        int board_size = Integer.parseInt(args[0]);
        String board[][] = initBoard(board_size);
        nqueens(board, board_size);
    }

    public static boolean nqueens(String board[][], int n)
    {
        if (n == 0)
        {
            printBoard(board, board.length);
            return true;
        }
        for (int i = 0; i < board.length; i++)
        {
            for (int j = 0; j < board.length; j++)
            {
                if (checkPlace(board, i, j) == true)
                {
                    board[i][j] = "Q";
                    if (nqueens(board, n - 1) == true)
                        return true;
                    board[i][j] = ".";
                }
            }
        }
        return false;
    }

    public static boolean checkPlace(String board[][], int i, int j)
    {
        if (checkRowCol(board, i, j) && checkDiag(board, i, j))
            return true;
        return false;
    }

    public static boolean checkRowCol(String board[][], int a, int b)
    {
        for (int j = 0; j < board.length; j++)
        {
            if (board[a][j] == "Q")
                return false;
        }
        for (int j = 0; j < board.length; j++)
        {
            if (board[j][b] == "Q")
                return false;
        }
        return true;
    }

    public static boolean checkDiag(String board[][], int a, int b)    // a = i = row
    {                                                               // b = j = col
        int x = a;
        int y = b;
        while (a > 0 && b > 0)
        {
            a--;
            b--;
        }
        while (a < board.length && b < board.length)
        {
            if (board[a][b] == "Q")
                return false;
            a++;
            b++;
        }
        a = x;
        b = y;
        while (a > 0 && b < board.length - 1)
        {
            a--;
            b++;
        }
        while (a < board.length - 1 && b > 0)
        {
            if (board[a][b] == "Q")
                return false;
            a++;
            b--;
        }
        if (board[a][b] == "Q")
            return false;
        return true;
    }

    public static String[][] initBoard(int n)
    {
        String board[][] = new String[n][n];
        for (int i =  0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
                board[i][j] = ".";
        }
        return board;
    }

    public static void printBoard(String board[][], int n)
    {
        for (int i =  0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
                System.out.print(board[i][j] + " ");
            System.out.println();
        }
    }
}

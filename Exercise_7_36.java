// (Game: Eight Queens) The classic Eight Queens puzzle is to place eight queens on a chessboard such that
// no two queens can attack each other(i.e., no two queens are on the same row, same column, or same diagonal).
// There are many possible solutions.
// Write a program that displays one such solution.
// A sample output is shown below:
// |Q| | | | | | | |
// | | | | |Q| | | |
// | | | | | | | |Q|
// | | | | | |Q| | |
// | | |Q| | | | | |
// | | | | | | |Q| |
// | |Q| | | | | | |
// | | | |Q| | | | |

public class Exercise_7_36 {
    public static boolean solve(int[] queens, int row) {
        if (row == 8) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (queens[i] == j)
                        System.out.print("|Q");
                    else
                        System.out.print("| ");
                }
                System.out.println("|");
            }
            return true;
        }

        for (int col = 0; col < 8; col++) {
            if (isValid(queens, row, col)) {
                queens[row] = col;
                if (solve(queens, row + 1))
                    return true;
            }
        }

        return false;
    }

    public static boolean isValid(int[] queens, int row, int col) {
        for (int i = 0; i < row; i++)
            if (queens[i] == col || Math.abs(queens[i] - col) == Math.abs(i - row))
                return false;
        return true;
    }

    public static void main(String[] args) {
        int[] queens = new int[8];
        solve(queens, 0);
    }
}

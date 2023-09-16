import java.util.Scanner;

public class TicTacGame {
    private static char[][] board = new char[3][3];
    private static char currentPlayer;

    public static void main(String[] args) {
        initializeBoard();
        setFirstPlayer();
        boolean gameWon = false;
        while (true) {
            displayBoard();
            if (gameWon) {
                System.out.println("Player " + currentPlayer + " wins! Congratulations!");
                break;
            } else if (isBoardFull()) {
                System.out.println("It's a draw! The game is over.");
                break;
            }
            int[] move = getUserMove();
            int row = move[0];
            int col = move[1];
            if (isValidMove(row, col)) {
                board[row][col] = currentPlayer;
                gameWon = checkWin(row, col);
                if (gameWon == false) {
                    currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                }
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }
    }

    private static void setFirstPlayer() {
        System.out.println("choose your preferences between X and 0 as player:");
        Scanner sc = new Scanner(System.in);
        String c = sc.nextLine();
        currentPlayer = c.charAt(0);
    }

    private static void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    private static void displayBoard() {
        System.out.println("  0 1 2");
        for (int i = 0; i < 3; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int[] getUserMove() {
        Scanner scanner = new Scanner(System.in);
        int[] move = new int[2];
        System.out.print("Player " + currentPlayer + ", enter your move (row and column): ");
        move[0] = scanner.nextInt();
        move[1] = scanner.nextInt();
        return move;
    }

    private static boolean isValidMove(int row, int col) {
        return row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ';
    }

    private static boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean checkWin(int row, int col) {
        return (checkRow(row) || checkColumn(col) || checkDiagonals() || checkAntiDiagonals());
    }

    private static boolean checkRow(int row) {
        return (board[row][0] == board[row][1] && board[row][1] == board[row][2]
            && board[row][0] != ' ');
    }

    private static boolean checkColumn(int col) {
        return (board[0][col] == board[1][col] && board[1][col] == board[2][col]
            && board[0][col] != ' ');
    }

    private static boolean checkDiagonals() {
        return (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != ' ');
    }

    private static boolean checkAntiDiagonals() {
        return (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != ' ');
    }
}

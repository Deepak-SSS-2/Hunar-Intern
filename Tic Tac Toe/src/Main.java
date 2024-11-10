import java.util.Scanner;
public class Main{
        private static final char EMPTY = ' ';
        private static final char PLAYER_X = 'X';
        private static final char PLAYER_O = 'O';
        private static char currentPlayer = PLAYER_X;
        private static char[][] board = {
                { EMPTY, EMPTY, EMPTY },
                { EMPTY, EMPTY, EMPTY },
                { EMPTY, EMPTY, EMPTY }
        };

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            boolean gameEnded = false;

            while (!gameEnded) {
                printBoard();
                playerMove(scanner);
                gameEnded = checkWin() || checkDraw();
                switchPlayer();
            }
            scanner.close();
        }

        private static void printBoard() {
            System.out.println("Board:");
            for (int row = 0; row < 3; row++) {
                for (int col = 0; col < 3; col++) {
                    System.out.print(" " + board[row][col] + " ");
                    if (col < 2) System.out.print("|");
                }
                System.out.println();
                if (row < 2) System.out.println("---+---+---");
            }
            System.out.println();
        }

        private static void playerMove(Scanner scanner) {
            int row, col;
            while (true) {
                System.out.printf("Player %c, enter your move (row [1-3] and column [1-3]): ", currentPlayer);
                row = scanner.nextInt() - 1;
                col = scanner.nextInt() - 1;

                if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == EMPTY) {
                    board[row][col] = currentPlayer;
                    break;
                } else {
                    System.out.println("Invalid move! Try again.");
                }
            }
        }

        private static void switchPlayer() {
            currentPlayer = (currentPlayer == PLAYER_X) ? PLAYER_O : PLAYER_X;
        }

        private static boolean checkWin() {
            // Check rows, columns, and diagonals
            for (int i = 0; i < 3; i++) {
                if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer ||
                        board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer) {
                    System.out.println("Player " + currentPlayer + " wins!");
                    return true;
                }
            }
            if (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer ||
                    board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer) {
                System.out.println("Player " + currentPlayer + " wins!");
                return true;
            }
            return false;
        }

        private static boolean checkDraw() {
            for (int row = 0; row < 3; row++) {
                for (int col = 0; col < 3; col++) {
                    if (board[row][col] == EMPTY) {
                        return false;
                    }
                }
            }
            System.out.println("It's a draw!");
            return true;
        }
}

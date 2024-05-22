package TipTapTap;

import java.util.Scanner;

public class Game {
    private Board board;
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private Scanner scanner;

    public Game() {
        board = new Board();
        player1 = new Player('X');
        player2 = new Player('O');
        currentPlayer = player1;
        scanner = new Scanner(System.in);
    }

    public void start() {
        boolean gameOn = true;

        while (gameOn) {
            board.printBoard();
            System.out.println("Player " + currentPlayer.getSymbol() + ", it's your turn.");
            System.out.print("Enter row and column (0, 1, or 2) separated by space: ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            if (board.isMoveValid(row, col)) {
                board.makeMove(row, col, currentPlayer.getSymbol());
                if (board.checkWin(currentPlayer.getSymbol())) {
                    board.printBoard();
                    System.out.println("Player " + currentPlayer.getSymbol() + " wins!");
                    gameOn = false;
                } else if (board.isBoardFull()) {
                    board.printBoard();
                    System.out.println("The game is a draw!");
                    gameOn = false;
                } else {
                    switchPlayer();
                }
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }
        scanner.close();
    }

    private void switchPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }
}

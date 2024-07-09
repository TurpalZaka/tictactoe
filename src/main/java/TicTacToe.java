import java.util.Scanner;

public class TicTacToe {
    private Board board;
    private Player[] players;
    private int currentPlayerIndex;

    //Konstruktor
    public TicTacToe() {
        board = new Board();
        players = new Player[2];
        players[0] = new Player('X');
        players[1] = new Player('O');
        currentPlayerIndex = 0;
    }

    //Startmethode
    public void start() {
        Scanner scanner = new Scanner(System.in);
        boolean playing = true; // Flag

        while (playing) {
            board.display();
            Player currentPlayer = players[currentPlayerIndex];
            System.out.println("Current Player: " + currentPlayer.getSymbol());
            boolean validMove = false;
            while (!validMove) {
                System.out.print("Enter row (0, 1, or 2): ");
                int row = scanner.nextInt(); // Zeile eingaben
                System.out.print("Enter column (0, 1, or 2): ");
                int col = scanner.nextInt(); // Spalte eingeben
                validMove = board.makeMove(currentPlayer.getSymbol(), row, col);
                if (!validMove) {
                    System.out.println("This move is not valid. Try again.");
                }
            }
            // Überprüfen, ob der aktuelle Spieler gewonnen hat
            if (board.checkWin(currentPlayer.getSymbol())) {
                board.display();
                System.out.println("Player " + currentPlayer.getSymbol() + " wins!");
                playing = false;
            } else if (board.isFull()) { //Überprüfen, ob das Spielfeld voll ist (Unentschieden)
                board.display();
                board.display();
                System.out.println("The game is a draw!");
                playing = false;
            } else {
                currentPlayerIndex = (currentPlayerIndex + 1) % 2;
            }

            // Überprüfen, ob das Spiel vorbei ist und ob der Benutzer ein neues Spiel starten möchte
            if (!playing) {
                System.out.print("Do you want to play again? (y/n): ");
                char response = scanner.next().charAt(0);
                if (response == 'y' || response == 'Y') {
                    board.reset(); // Gesamtes Spielfeld zurücksetzen
                    currentPlayerIndex = 0; // Den ersten Spieler setzen
                    playing = true;
                }
            }
        }
        scanner.close();
    }

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.start();
    }
}
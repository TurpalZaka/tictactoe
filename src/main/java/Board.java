public class Board {
    private char[][] board;

    public Board() {
        board = new char[3][3];
        reset();
    }

    public void reset() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    public void display() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean makeMove(char symbol, int row, int col) {
        if (row <0 || row > 2 || col < 0 || col > 2 || board[row][col] != '-') {
            return false;
        }
        board[row][col] = symbol;
        return true;
    }
}
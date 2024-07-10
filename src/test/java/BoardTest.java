import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {
    private Board board;

    @BeforeEach
    void setUp() {
        board = new Board();
    }

    @Test
    void testInitialBoardIsEmpty() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                assertFalse(board.makeMove('X', i, j));
            }
        }
    }

    @Test
    void testMakeValidMove() {
        assertTrue(board.makeMove('X', 1, 1));
    }

    @Test
    void testMakeInvalidMove() {
        board.makeMove('X', 1, 1);
        assertFalse(board.makeMove('O', 1, 1));
    }

    @Test
    void testCheckWinHorizontal() {
        board.makeMove('X', 0, 0);
        board.makeMove('X', 0, 1);
        board.makeMove('X', 0, 2);
        assertTrue(board.checkWin('X'));
    }

    @Test
    void testCheckWinVertical() {
        board.makeMove('O', 0, 1);
        board.makeMove('O', 1, 1);
        board.makeMove('O', 2, 1);
        assertTrue(board.checkWin('O'));
    }

    @Test
    void testCheckWinDiagonal() {
        board.makeMove('X', 0, 0);
        board.makeMove('X', 1, 1);
        board.makeMove('X', 2, 2);
        assertTrue(board.checkWin('X'));
    }

    @Test
    void testBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board.makeMove('X', i, j);
            }
        }
        assertTrue(board.isFull());
    }

    @Test
    void testBoardNotFull() {
        board.makeMove('X', 0, 0);
        assertFalse(board.isFull());
    }
}

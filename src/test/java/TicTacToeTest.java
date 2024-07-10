import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

public class TicTacToeTest {
    private TicTacToe game;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        game = new TicTacToe();
        System.setOut(new PrintStream(outContent));
    }

    @Test
    void testGameStart() {
        String input = "0 0\n1 1\n0 1\n1 0\n0 2\nn\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        game.start();

        String output = outContent.toString();
        assertTrue(output.contains("Player X wins!"));
        assertTrue(output.contains("Do you want to play again?"));
    }

    @Test
    void testInvalidMove() {
        String input = "3 3\n0 0\n1 1\n0 1\n1 0\n0 2\nn\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        game.start();

        String output = outContent.toString();
        assertTrue(output.contains("This move is not valid. Try again."));
    }

    @Test
    void testDraw() {
        String input = "0 0\n0 1\n0 2\n1 0\n1 1\n2 0\n1 2\n2 1\n2 2\nn\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        game.start();

        String output = outContent.toString();
        assertTrue(output.contains("The game is a draw!"));
    }

    @Test
    void testPlayAgain() {
        String input = "0 0\n1 1\n0 1\n1 0\n0 2\ny\n0 0\nn\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        game.start();

        String output = outContent.toString();
        assertTrue(output.contains("Player X wins!"));
        assertTrue(output.contains("Do you want to play again?"));
        assertTrue(output.contains("Current Player: X"));
    }
}

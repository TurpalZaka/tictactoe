import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {
    @Test
    void testPlayerSymbol() {
        Player player = new Player('X');
        assertEquals('X', player.getSymbol());
    }

    @Test
    void testDifferentPlayerSymbols() {
        Player player1 = new Player('X');
        Player player2 = new Player('O');
        assertNotEquals(player1.getSymbol(), player2.getSymbol());
    }
}

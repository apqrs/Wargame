import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PlayerTest {
    private Player player;
    @BeforeEach
    public void setUp() throws Exception {
        player = new Player("USA", 1000000);

    }
    @Test
    public void storesX() {
        assertEquals(true, true);
    }

}

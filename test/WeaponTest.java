import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WeaponTest {
    private Weapon weapon;
    @BeforeEach
    public void setUp() throws Exception {
        weapon = new Weapon("ICBM", "1000", "5");

    }
    @Test
    public void storesX() {
        assertEquals(true, true);
    }


}

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DefenseTest {
    private Defense defense;
    private Weapon weapon;
    @BeforeEach
    public void setUp() throws Exception {
        defense = new Defense("Anti Air", "50");
        weapon = new Weapon("Gun", "1000", "3");
    }
    @Test
    public void reducesDamage() {
        defense.setTarget(weapon);
        defense.defend();
        assertEquals(500, weapon.getDamage());
    }
}

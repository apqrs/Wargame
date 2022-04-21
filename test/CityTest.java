import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CityTest {
    private City city;
    private Weapon weapon;
    @BeforeEach
    public void setUp() throws Exception {
        city = new City("test", 1000);
        weapon = new Weapon("Gun", "100", "3");
    }
    @Test
    public void getsHit() {
        city.hit(100);
        assertEquals(false, city.getStatus());
        assertEquals(0, city.getCiv());
    }
}

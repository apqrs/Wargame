import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WeaponTest {
    private Weapon weapon;
    private City test;
    @BeforeEach
    public void setUp() throws Exception {
        weapon = new Weapon("ICBM", "10", "5");

    }
    @Test
    public void attacksCity() {
        test = new City("test",3000);
        weapon.execute(test);
        assertEquals(0.9*3000, test.getCiv());
    }

    @Test
    public void reducedDamage(){

        weapon.defense(30);
        assertEquals(0.7*10, weapon.getDamage());
    }

    @Test
    public void takesTurnandExecute(){
        Weapon test = new Weapon("test", "40", "5");
        City testCity = new City("name", 5000);
        test.takeTurn();
        test.setTarget(testCity);
        assertEquals(4, test.getTurn());
        for (int i = 0; i <= 10; i++){
            test.takeTurn();
        }
        assertEquals(0.6 * 5000, testCity.getCiv());
    }


}

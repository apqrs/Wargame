import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class PlayerTest {
    private Player player;
    private ArrayList<City> cityList;
    private ArrayList<Weapon> weaponList;
    private ArrayList<Defense> defenseList;
    @BeforeEach
    public void setUp() throws Exception {
        player = new Player("USA", 1000000);
        cityList = new ArrayList<City>();
        weaponList = new ArrayList<Weapon>();
        defenseList = new ArrayList<Defense>();

    }

    @Test
    public void addsCity() {
        City test = new City("testCity", 10000);
        cityList.add(test);
        player.addCity(test);
        assertEquals(cityList, player.getCities());
    }
    @Test
    public void budgetWorks() {
        player.buyWeapon("ICBM","40", "5", 10, "100000");
        assertEquals(0, player.getBudget());
    }

    @Test
    public void buysWeapon() {

        player.buyWeapon("ICBM","40", "5", 1, "1000");

        assertEquals(1, player.getWeapons().size());
        player.buyWeapon("ICBMO","40", "5", 10, "1000");
        assertEquals(11, player.getWeapons().size());

    }

    @Test
    public void buysDefense() {
        player.buyDefense("DefCon", "40", 1, "3000");
        assertEquals(1, player.getDefenses().size());
        player.buyDefense("DefCon", "40", 21, "3000");
        assertEquals(22, player.getDefenses().size());
    }



}

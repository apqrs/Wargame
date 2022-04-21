import java.util.ArrayList;

public class Player {
    private String name;
    private ArrayList<City> cities = new ArrayList<City>();
    private ArrayList<Weapon> weapons = new ArrayList<Weapon>();
    private ArrayList<Defense> defenses = new ArrayList<Defense>();
    private int budget;

    public Player(String name, int budget){
        this.name = name;
        this.budget = budget;
    }
    public void addCity(City city){
        cities.add(city);
    }

    public int getBudget(){
        return budget;
    }

    public void attack(City city, Weapon weapon){
        city.hit(weapon.getDamage());

    }

    public void buyWeapon(String name, String damage, String turnDelay, int n, String cost){
        int c = Integer.parseInt(cost);
        budget -= n * c;
        for (int i = 0; i< n; i++){
            weapons.add(new Weapon(name, damage, turnDelay));
        }
    }
    public void buyDefense(String name,String str, int n, int cost){
        budget -= n * cost;
        for (int i = 0; i< n; i++){
            defenses.add(new Defense(name, str));
        }
    }

    public boolean defeated(){
        boolean defeated = true;
        boolean cityFallen = true;
        for (Weapon w:weapons){
            if (w.getTurn()>=0){
                defeated = false;
            }
        }
        for (Defense d:defenses){
            if (d.getStatus()){
                defeated = false;
            }
        }

        for (City c:cities){
            if (c.getStatus()){
                cityFallen = false;
            }
        }


        return cityFallen || defeated;

    }

}
import java.util.ArrayList;

public class Player {
    private String name;
    private ArrayList<City> cities = new ArrayList<City>();
    private ArrayList<Weapon> weapons = new ArrayList<Weapon>();
    private ArrayList<Defense> defenses = new ArrayList<Defense>();
    private int budget;
    private double positionX;
    private double positionY;

//Claims players name and budget
    public Player(String name, int budget){
        this.name = name;
        this.budget = budget;
        if (name.equals("usa")){
            positionX = 0.23;
            positionY = 0.7;
        }
        else{
            positionX = 0.8;
            positionY = 0.7;
        }
    }
    // Used to add city to player's lives
    public void addCity(City city){
        cities.add(city);
    }

    public int getBudget(){
        return budget;
    }

    public void attack(City city, Weapon weapon){
        city.hit(weapon.getDamage());

    }
//Used to add weapons to players arsenal
    public void buyWeapon(String name, String damage, String turnDelay, int n, String cost){
        int c = Integer.parseInt(cost);
        budget -= n * c;
        for (int i = 0; i< n; i++){
            weapons.add(new Weapon(name, damage, turnDelay));
        }
    }
    //Used to add defenses to players arsenal
    public void buyDefense(String name,String str, int n, String c){
        int cost = Integer.parseInt(c);
        budget -= n * cost;
        for (int i = 0; i< n; i++){
            defenses.add(new Defense(name, str));
        }
    }
//Shows when a player is defeated.
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

    public ArrayList<City> getCities(){
        return cities;
    }
    public String getName(){
        return name;
    }

    public ArrayList<Weapon> getWeapons(){
        return weapons;
    }
    public ArrayList<Defense> getDefenses(){
        return defenses;
    }

    public double[] getPositions(){
        return new double[]{positionX, positionY};
    }



}
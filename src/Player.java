import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Player {
    private String name;
    private ArrayList<City> cities = new ArrayList<City>();
    private ArrayList<Weapon> weapons = new ArrayList<Weapon>();
    private ArrayList<Defense> defenses = new ArrayList<Defense>();
    private ArrayList<Weapon> launchedWeapons = new ArrayList<Weapon>();
    private int budget;
    private double positionX;
    private double positionY;

//Claims players name and budget
    public Player(String name, int budget){
        this.name = name;
        this.budget = budget;
        if (name.equals("us")){
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

    // returns player budget
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
            weapons.add(new Weapon(name, damage, turnDelay, positionX, positionY));
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
//checks whether the player has lost
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


    // shows the turn flag and budget
    public void showTurn(){

        StdDraw.picture(0.5,0.96, "img/"+this.getName()+"flag.png", 0.1,0.1);
        StdDraw.setPenColor(Color.green);
        StdDraw.text(positionX, 0.98, "Budget: "+ this.getBudget());
    }


    // returns a list of weapons that have been launched
    public ArrayList<Weapon> getLaunchedWeapons(){
        return launchedWeapons;
    }


    // displays the visual element of the game
    public void show(){

        StdDraw.picture(positionX,positionY, "img/"+name+".png", 0.4,0.4);
        Weapon i;
        for (int j = 0; j < cities.size(); j++){
            City city = cities.get(j);
            if (!city.getStatus()){
                cities.remove(j);
            }
            else{
                city.show(j);
            }
        }


    }

    public void showWeapons(){
        Weapon i;
        for (int j = 0; j<launchedWeapons.size(); j++){
            i = launchedWeapons.get(j);

            if (i.getTurn() == -1){
                launchedWeapons.remove(j);

            }
            else{
                i.takeTurn();
            }
        }

    }


    // asks user to attack, defend or do nothing
    public void takeTurn(Player enemy){

        StdDraw.text(0.5,0.4, "Choose action: ");
        StdDraw.text(0.5,0.3, "0. Attack       1. Defend     2. Nothing");
        String input = handleKeyPress();
        Weapon weapon;
        Defense def;
        ArrayList<City> enemyCity = enemy.getCities();
        City ecity;
        int response;
        blank1();

        // determines the space between the lists
        double shift = 0.05;

        // chose attack
        if (input.equals("0")){
            StdDraw.text(0.5,0.4, "Choose Weapon: ");
            for (int i = 0; i < weapons.size(); i++){
                weapon = weapons.get(i);
                StdDraw.text(0.5, 0.3-shift*i, i + " "+weapon.getName());
            }

            response = Integer.parseInt(handleKeyPress());

            if (response>=0 && response < weapons.size()){
                weapon = weapons.get(response);
                weapons.remove(response);
                launchedWeapons.add(weapon);
                blank1();



                StdDraw.text(0.5,0.4, "Choose Target: ");
                response = Integer.parseInt(handleKeyPress());

                if (response < enemyCity.size() && response >= 0){
                    weapon.setTarget(enemyCity.get(response));
                }

            }

        }
        //chose defend
        else if (input.equals("1")){

            ArrayList<Weapon> enemyLaunch = enemy.getLaunchedWeapons();
            StdDraw.text(0.5,0.4, "Choose Defense: ");
            for (int i = 0; i < defenses.size(); i++){
                def = defenses.get(i);
                StdDraw.text(0.5, 0.3-shift*i, i + " "+def.getName());
            }
            response = Integer.parseInt(handleKeyPress());

            if (response>=0 && response < defenses.size()){
                def = defenses.get(response);
                blank1();



                StdDraw.text(0.5,0.4, "Choose Target: ");
                for (int i = 0; i < enemyLaunch.size(); i++){
                    weapon = enemyLaunch.get(i);
                    StdDraw.text(0.5, 0.3-shift*i, i + " "+weapon.getName());
                }
                response = Integer.parseInt(handleKeyPress());

                if (response < enemyLaunch.size() && response >= 0){
                    def.setTarget(enemyLaunch.get(response));
                    def.defend();
                    enemyLaunch.remove(response);
                }

            }

        }


    }

    // handles user input
    public static String handleKeyPress() {
        String guess = "";
        char c;
        double x = 0;
        while (true){
//            StdDraw.text(0.5, 0.1, guess);
            while (!StdDraw.hasNextKeyTyped()) {
                // Wait for a key to be typed
            }
            c = StdDraw.nextKeyTyped();
            StdOut.print(c);
            StdDraw.text(0.5+x, 0.1, ""+c);


            if (c=='\n'){
                blank();
                break;
            }
            guess += c;
            if (c=='r'){
                blank();
                guess = "";
                x = 0;
            }

            while (StdDraw.hasNextKeyTyped()) {
                // Wait for a key to be released
            }
            x += 0.01;
        }
        return guess;
    }


    // draws a dark rectangle to cover up previous text. Acts as a delete function
    public static void blank(){
        StdDraw.setPenColor(Color.RED);
        StdDraw.filledRectangle(0.5, 0.1, 0.5, 0.05);
        StdDraw.setPenColor(Color.GREEN);

    }
    public static void blank1(){
        StdDraw.setPenColor(Color.BLACK);
        StdDraw.filledRectangle(0.5, 0.25, 0.5, 0.24);
        StdDraw.setPenColor(Color.GREEN);
    }



}
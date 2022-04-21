import java.util.ArrayList;

public class Weapon {
    private String name;
    private int damage;
    private int turn;
    private City target;
//    private int cost;

//    private ArrayList<String> weaponInfo = new ArrayList<String>();
//    private ArrayList<int[]> weaponDamage = new ArrayList<int[]>();

    public Weapon(String name, String damage, String turnDelay){
//        weaponInfo.add("ICBM");
//        weaponDamage.add(new int[]{9000, 8});

        this.name = name;
        this.damage = Integer.parseInt(damage);
        this.turn = Integer.parseInt(turnDelay);
//        cost = weaponDamage.get(id)[1];
    }
    public String getName(){
        return name;
    }

    public int getDamage(){
        return damage;
    }

    public int getTurn(){
        return turn;
    }

//    public int getCost(){
//        return cost;
//    }

    public void takeTurn(){
        turn -= 1;
        if (turn == 0){
            this.execute(target);
        }
    }
    public void setTarget(City city){
        this.target = city;
    }

    public void execute(City city){
        city.hit(damage);
    }

    public void defense(){
        turn = -1;
    }
}


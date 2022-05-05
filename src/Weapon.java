import java.util.ArrayList;

public class Weapon {
    private String name;
    private double damage;
    private int delay;
    private City target;
    private Defense target_defense;
    private double currentX;
    private double currentY;
    private double targetX;
    private double targetY;
    private double movementIncrementX;
    private double movementIncrementY;

//    private int cost;

//    private ArrayList<String> weaponInfo = new ArrayList<String>();
//    private ArrayList<int[]> weaponDamage = new ArrayList<int[]>();
// Declares a weapons name damage as well as delay delay
    public Weapon(String name, String damage, String turnDelay, double positionX, double positionY){
//        weaponInfo.add("ICBM");
//        weaponDamage.add(new int[]{9000, 8});

        this.name = name;
        this.damage = Integer.parseInt(damage);
        this.delay = Integer.parseInt(turnDelay);
        this.currentX = positionX;
        this.currentY = positionY;
//        cost = weaponDamage.get(id)[1];
    }
    // Calls name
    public String getName(){
        return name;
    }
// Gets damage
    public double getDamage(){
        return damage;
    }
//Gets delay for weapons
    public int getTurn(){
        return delay;
    }

//    public int getCost(){
//        return cost;
//    }

    public void takeTurn(){

        currentY += movementIncrementY;
        currentX += movementIncrementX;
        delay -= 1;
        this.show();
        if (delay == 0){
            this.execute(target);

            StdDraw.picture(currentX,currentY, "img/boom.png", 0.05,0.05);
            delay = -1;

        }
    }
    public void setTarget(City city){
        this.target = city;
        targetX = city.getPositions()[0];
        targetY = city.getPositions()[1];
        
        movementIncrementX = (targetX - currentX)/delay;
        movementIncrementY = (targetY - currentY)/delay;
        
    }
//    public void setTarget(Defense defense){
//        this.target_defense = defense;
//    }


    public void execute(City city){
        city.hit(damage);
    }

    public void defense(int str){
        if (str == 100){
            delay = -1;
        }
        damage = (1-str/100.0) * damage;

    }

    public double[] getPositions(){
        return new double[]{currentX, currentY};
    }

    public void show(){
        double x = targetX - currentX;
        double y = targetY - currentY;

        StdDraw.picture(currentX, currentY, "img/missile.png",0.03,0.05, Math.toDegrees(Math.atan2(y,x)));
    }
}


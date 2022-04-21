import java.util.ArrayList;

public class Defense {
    private String name;
    //    private int chance;
    private Weapon target;
    private boolean status = true;

    private ArrayList<String> defenseInfo = new ArrayList<String>();
//    private ArrayList<Integer> defenseEffectiveness = new ArrayList<Integer>();

    public Defense(int id){
        defenseInfo.add("Anti air");
//        defenseEffectiveness.add(60);

        this.name = defenseInfo.get(id);
//        this.chance = defenseEffectiveness.get(id);
    }

    public void setTarget(Weapon weapon){
        this.target = weapon;
    }

    public void defend(){
        target.defense();
        status = false;
    }
    public boolean getStatus(){
        return status;
    }
}

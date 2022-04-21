import java.util.ArrayList;

public class Defense {
    private String name;
    //    private int chance;
    private Weapon target;
    private boolean status = true;
    private int str;



    public Defense(String name, String str){

//        defenseEffectiveness.add(60);

        this.name = name;
        this.str = Integer.parseInt(str);
//        this.chance = defenseEffectiveness.get(id);
    }

    public void setTarget(Weapon weapon){
        this.target = weapon;
    }

    public void defend(){
        target.defense(str);
        status = false;
    }
    public boolean getStatus(){
        return status;
    }
}

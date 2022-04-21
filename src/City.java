public class City {
    private String name;
    private int civ;
    private int max;
    private boolean status = true;

    public City(String name, int civ){
        this.name = name;
        this.civ = civ;
        max = civ;
    }
    public void hit(double damage){
        civ -= damage/100 * max;
        checkStatus();
    }
    public int getCiv(){
        return civ;
    }


    public void checkStatus(){
        if (civ <= 0){
            status = false;
        }
    }
    public boolean getStatus(){
        return status;
    }
}

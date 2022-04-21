public class Main {

    public static void main(String[] args) {
        Player usa = new Player("USA",13000000);
        Player russia = new Player("Russia", 13000000);


        usa.addCity(new City("Seatle",737015));
        usa.addCity(new City("Dallas",1300000));
        usa.addCity(new City("Washington", 689545));
        russia.addCity( new City("Novosibirsk",1470000));
        russia.addCity(new City("Moscow",11980000));
        russia.addCity(new City("Yekaterinburg",1350000));
        System.out.println("Hello world");

        String[][] att = {{"ICBM","2000000","7","50"},{"Nuclear Submarinek","7000000","3","100"},{"Bomber","5000","5","20"}};
        String[][] def = {{"Airborne HQ", "50000","25"},{"Underground Base","100000","50"},{"Anti-air defense","200000","100"}};


        //Attack options Sub 7,000,000 100%,IBM 2,000,000 50 %,bombers 500 25% ,
        //Defense options Airborn HQ, Underground base, Anti-air defenses
    }

    public static void buy(){
        String response;


    }
}

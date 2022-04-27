import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static boolean isReady(boolean[] b){
        for (boolean i:b){
            if (!i){
                return false;
            }
        }
        return true;
    }

    public static void buy(Player player, int index, boolean[] b){
        if (b[index]){
            return;
        }

        String[][] att = {{"ICBM","2000000","7","50"},{"Nuclear Submarinek","7000000","3","100"},{"Bomber","5000","5","20"}};
        String[][] def = {{"Airborne HQ", "50000","25"},{"Underground Base","100000","50"},{"Anti-air defense","200000","100"}};
        String choice;
        int val;
        int n;
        int playerBudget = player.getBudget();

        StdOut.println(player.getName() + " Turn");
        StdOut.println();

        StdOut.println("Choose the weapons to buy");
        for (int i = 0; i < att.length; i++){
            StdOut.println(i+" "+ att[i][0] + "Cost: "+att[i][1]+ "Strength: "+att[i][3]+"Time taken: "+att[i][2]);
        }
        choice = StdIn.readString();
        if (choice.equals("s")){
            b[index] = true;
            return;
        }
        val = Integer.parseInt(choice);

        if (val >= 0 && val < att.length){
            StdOut.println("How many?");
            n = StdIn.readInt();

            if (Integer.parseInt(att[val][1])*n <= playerBudget){
                player.buyWeapon(att[val][0],att[val][3], att[val][2],n, att[val][1]);
            }
            else{
                StdOut.println("Out of Budget");
            }
        } else{
            StdOut.println("Invalid Input!");

        }

        StdOut.println("Choose the defenses to buy");
        for (int i = 0; i < att.length; i++){
            StdOut.println(i+" "+ def[i][0]+ "Cost: "+def[i][1]+ "Strength: "+def[i][2]);
        }
        choice = StdIn.readString();
        if (choice.equals("s")){
            b[index] = true;
            return;
        }
        val = Integer.parseInt(choice);

        if (val >= 0 && val < att.length){
            StdOut.println("How many?");
            n = StdIn.readInt();

            if (Integer.parseInt(att[val][1])*n <= playerBudget){
                player.buyDefense(def[val][0],def[val][2], n, def[val][1]);
            }
            else{
                StdOut.println("Out of Budget");
            }
        } else{
            StdOut.println("Invalid Input!");

        }




    }

    public static void main(String[] args) {
        ArrayList<Weapon> weaponsLaunched = new ArrayList<Weapon>();
        Player usa = new Player("USA",13000000);
        Player russia = new Player("Russia", 13000000);


        usa.addCity(new City("Seatle",737015));
        usa.addCity(new City("Dallas",1300000));
        usa.addCity(new City("Washington", 689545));
        russia.addCity( new City("Novosibirsk",1470000));
        russia.addCity(new City("Moscow",11980000));
        russia.addCity(new City("Yekaterinburg",1350000));
        System.out.println("Hello world");


        Player[] users = {usa, russia};
        //Attack options Sub 7,000,000 100%,IBM 2,000,000 50 %,bombers 500 25% ,
        //Defense options Airborn HQ, Underground base, Anti-air defenses

        boolean[] ready = new boolean[users.length];
        int turn = 0;
         while (!isReady(ready)){
             buy(users[turn], turn, ready);
             turn++;

             turn = turn% users.length;

         }

         turn  = 0;
         //main game
        while (gameOver(usa, russia) != -1){
            turn++;

        }

    }

        public static int gameOver(Player usa, Player russia){
            if (usa.defeated()){
                return 1;
            }
            if (russia.defeated()){
                return 2;
            }
            return -1;
        }

        public static void play(){

        }
    }


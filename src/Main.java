import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {

    // checks whether both players are ready for the battle phase
    public static boolean isReady(boolean[] b){
        for (boolean i:b){
            if (!i){
                return false;
            }
        }
        return true;
    }

    // handles the buying process of weapons and defenses
    public static void buy(Player player, int index, boolean[] b, String item){
        StdDraw.clear(Color.BLACK);
        if (b[index]){
            return;
        }

        String[][] att = {{"ICBM","2000000","7","50"},{"Nuclear Submarine","7000000","3","100"},{"Bomber","5000","5","20"}};
        String[][] def = {{"Airborne HQ", "50000","25"},{"Underground Base","100000","50"},{"Anti-air defense","200000","100"}};
        String choice;
        int val;
        int n;
        int playerBudget = player.getBudget();

        player.showTurn();
//        StdOut.println();
        StdDraw.setPenColor(Color.red);
        StdDraw.text(0.2,0.9, "Type 'r' to reset. Press enter after typing. Type 's' to stop");
        StdDraw.setPenColor(Color.WHITE);

        StdDraw.text(0.5,0.9,"Choose the "+item+" to buy");
        if (item.equals("weapon")){
            for (int i = 0; i < att.length; i++){
//            StdOut.println(i+" "+ att[i][0] + "Cost: "+att[i][1]+ "Strength: "+att[i][3]+"Time taken: "+att[i][2]);
                StdDraw.text(0.5,0.8-i/10.0,i+" "+ att[i][0] + " Cost: "+att[i][1]+ " Strength: "+att[i][3]+" Time taken: "+att[i][2]);
            }

            choice = handleKeyPress();
            if (choice.equals("s")){
                b[index] = true;
                return;
            }
            val = Integer.parseInt(choice);

            if (val >= 0 && val < att.length){
//            StdOut.println("How many?");
                n = 1;


                if (Integer.parseInt(att[val][1])*n <= playerBudget){
                    player.buyWeapon(att[val][0],att[val][3], att[val][2],n, att[val][1]);
                }
                else{
                    blank();
                    StdDraw.setPenColor(Color.red);
                    StdDraw.text(0.5,0.1,"Out of Budget!!");
                    StdDraw.setPenColor(Color.BLACK);
                }
            } else{
                blank();
                StdDraw.setPenColor(Color.red);
                StdDraw.text(0.5,0.1,"Invalid Input");
                StdDraw.setPenColor(Color.BLACK);

            }

        }else{
            for (int i = 0; i < att.length; i++){
                StdDraw.text(0.5,0.8-i/10.0,i+" "+ def[i][0]+ " Cost: "+def[i][1]+ " Strength: "+def[i][2]);
            }
            choice = handleKeyPress();
            if (choice.equals("s")){
                b[index] = true;
                return;
            }
            val = Integer.parseInt(choice);

            if (val >= 0 && val < att.length){
                n = 1;

                if (Integer.parseInt(att[val][1])*n <= playerBudget){
                    player.buyDefense(def[val][0],def[val][2], n, def[val][1]);
                }
                else{
                    blank();
                    StdDraw.setPenColor(Color.red);
                    StdDraw.text(0.5,0.1,"Out of Budget!!");
                    StdDraw.setPenColor(Color.BLACK);
                }
            } else{
                blank();
                StdDraw.setPenColor(Color.red);
                StdDraw.text(0.5,0.1,"Invalid Input");
                StdDraw.setPenColor(Color.BLACK);

            }
        }









    }

    public static void main(String[] args) {
//        StdDraw.enableDoubleBuffering();
        StdDraw.setCanvasSize(1000, 600);
        StdDraw.setPenColor(Color.WHITE);

        ArrayList<Weapon> weaponsLaunched = new ArrayList<Weapon>();
        Player usa = new Player("us",13000000);
        Player russia = new Player("russia", 13000000);


        usa.addCity(new City("Seatle",737015, 0.13, 0.75));
        usa.addCity(new City("Dallas",1300000, 0.27, 0.7));
        usa.addCity(new City("Washington", 689545, 0.2, 0.6));
        russia.addCity( new City("Novosibirsk",1470000, 0.83, 0.7));
        russia.addCity(new City("Moscow",11980000, 0.7, 0.7));
        russia.addCity(new City("Yekaterinburg",1350000, 0.9, 0.6));
        System.out.println("Hello world");


        Player[] users = {usa, russia};
        //Attack options Sub 7,000,000 100%,IBM 2,000,000 50 %,bombers 500 25% ,
        //Defense options Airborn HQ, Underground base, Anti-air defenses

        boolean[] ready = new boolean[users.length];
        int turn = 0;
        int nturn;
         while (!isReady(ready)){


             buy(users[turn], turn, ready, "weapon");
             buy(users[turn], turn, ready, "defense");
             turn++;

             turn = turn% users.length;
             StdDraw.show();

         }

         StdOut.println("Game Over");

         turn = -1;
         StdOut.println(gameOver(users));
         while (gameOver(users) == -1){

             StdDraw.clear(Color.BLACK);

             for (Player user: users){
                 user.show();
             }
             for (Player user: users){
                 user.showWeapons();
             }


             turn++;
             if (turn  >= users.length){
                 turn = 0;
             }
            nturn = turn + 1;
             if (nturn >= users.length){
                 nturn = 0;
             }
            users[turn].showTurn();

             users[turn].takeTurn(users[nturn]);

         }

         StdDraw.clear(Color.black);
         StdDraw.text(0.5,0.5, users[gameOver(users)].getName() + " loses. Press enter to exit.");
         handleKeyPress();
         System.exit(1);


    }


    // checks whether the game is over
        public static int gameOver(Player[] players){

            for (int i = 0; i< players.length; i++){
                Player player  = players[i];
                if (player.defeated()){
                    return i;
                }
            }

            return -1;
        }

        public static void play(){

        }

        //handles user input
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


    // draws a dark rectangle to cover up previous text
    public static void blank(){
        StdDraw.setPenColor(Color.BLACK);
        StdDraw.filledRectangle(0.5, 0.1, 0.5, 0.05);
        StdDraw.setPenColor(Color.GREEN);

    }




    }


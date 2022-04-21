import java.util.Scanner;
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

        Boolean[] ready = {false, false};
        while (ready[1] == false && ready[2] == false) {

            Player[] users = {usa, russia};

            int x = 0;
            Scanner help = new Scanner(System.in);

            Player user = users[x];
            StdOut.println("Press 1 for Nuclear Sub");
            StdOut.println("Press 2 for ICBM");
            StdOut.println("Press 3 for ICBM");
            StdOut.println("Press 4 for Airborne HQ");
            StdOut.println("Press 5 for Underground Base");
            StdOut.println("Press 6 for Anti-air defense");
            StdOut.println("Press 7 to begin Annihilation");
            String choice = help.nextLine();


            if (choice == "2") {
                user.buyWeapon("ICBM", "50", "7", 1, "2000000");
                x += 1;
            }
            if (choice == "1") {
                user.buyWeapon("Nuclear Submarine", "100", "3", 1, "7000000");
                x += 1;
            }
            if (choice == "3") {
                user.buyWeapon("Bomber", "25", "3", 1, "50000");
                x += 1;
            }
            if (choice == "4") {
                user.buyDefense("Airborne HQ", "25", 1, 70000);
                x += 1;
            }
            if (choice == "5"){
                user.buyDefense("Underground Base", "50", 1, 150000);
                x += 1;
            }
            if (choice == "6") {
                user.buyDefense("Anti-air defense", "100", 1, 300000);
                x += 1;
            }
            if (choice == "7") {
                StdOut.println("Enjoy a glorious death.");
                ready[x] = true;

            }
            if (x <= 1) {
                x = 0;
            }
        }

    }
    }


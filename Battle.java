package battleArena;

import java.util.*;

public class Battle {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        Char p1 = createPlayer();
        Char p2 = createPlayer();

        System.out.println("======================================= Battle Stars =======================================");
        System.out.println("=============================================================================================");
        while (p1.alive() && p2.alive()) {
            p1.selectAttack(p2);

            if (p2.getHealth() <= 0) {
                displayWinner(p2,p1);
                break;
            }
            if (p1.getHealth() <= 0) {
                displayWinner(p1,p2);
                break;
            }
            System.out.println("-------------------");
            System.out.println(p1.getName() + " Health: " + p1.getHealth());
            System.out.println(p2.getName() + " Health: " + p2.getHealth());
            p2.selectAttack(p1);

            if (p1.getHealth() <= 0) {
                displayWinner(p1,p2);
                break;
            }
            if (p2.getHealth() <= 0) {
                displayWinner(p2,p1);
                break;
            }
        

            System.out.println("-------------------");
            System.out.println(p1.getName() + " Health: " + p1.getHealth());
            System.out.println(p2.getName() + " Health: " + p2.getHealth());
        }

    }
    public static void displayWinner(Char p1,Char p2){
        System.out.println(p1.getName() + " died!");
        System.out.println(p2.getName() + " wins!");
    }

    public static Char createPlayer() {
        Char ch = null;
        System.out.println("================== Enter Player Name: ==================");
        String name = sc.next().trim();
        System.out.println("================== Choose Character  ==================");
        System.out.println("1. Warrior");
        System.out.println("2. Maze");
        System.out.println("3. Archer");
        System.out.println();
        sc.nextLine();
        int n = sc.nextInt();

        switch (n) {
            case 1 -> ch = new Warrior(name);
            case 2 -> ch = new Maze(name);
            case 3 -> ch = new Archer(name);
            case 4 -> System.exit(0);
            default -> {
                System.out.println("Retry");
                return createPlayer();
            }
        }
        return ch;
    }
}

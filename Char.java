package battleArena;

import java.util.Scanner;

public abstract class Char {

    private String name;
    private int health = 100;
    private int healCount = 2;
    private int attackPower;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    public void attack(Char th) {
        int damage = (this.attackPower - (int) (Math.random() * 6));
        th.health = th.health - damage;
        System.out.println(this.name + " Attacked with Damage: " + damage);

    }

    public boolean alive() {
        return this.health > 0;
    }

    public void display() {

        System.out.println();
        System.out.print("Name: " + this.name + "\t");
        System.out.print("Health: " + this.health + "\t");
        System.out.print("Attack Power: " + this.attackPower + "\t");
        System.out.println();
    }

    public void selectAttack(Char t) {
        System.out.println("=================== " + this.name + " turn Select Action ==================");
        System.out.println("1. Attack");
        System.out.println("2. Heal +30  (Condition: Heal only when your health is less then 40 & heal count is limited to 2 times)");
        System.out.println("3. Give Up");
        System.out.println();
        System.out.println("Chose among the following: ");
        int choise = Battle.sc.nextInt();
        switch (choise) {
            case 1 -> attack(t);
            case 2 -> {
                if (this.health + 30 <= 100 && this.healCount > 0 && this.health <= 40) {
                    this.health += 30;
                    this.healCount--;
                    System.out.println(this.getName() + " Healed");
                    System.out.println("health is: " + this.getHealth());
                }
                else{
                    System.out.println("you can heal only 2 times");
                    selectAttack(t);
                }
            }
            case 3 -> this.health = 0;
            default -> {
                System.out.println("Please enter a valid choise");
                selectAttack(t);
            }
        }
    }

}
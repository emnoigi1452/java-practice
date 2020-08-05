/* Random project: XP Calculator (Minecraft)
 * Written in 10 mins
*/

import java.util.Scanner;

class Main {
    private static Scanner sc1;
    private static Scanner sc2;
    static int currentLvl;
    static int targetLvl;

    static int expCurrent(int level) {
        if(level <= 16) {
            return (level * level) + 6 * level;
        }
        else if(level > 16 && level <= 31) {
            return (int)(2.5 * (level * level) - 40.5 * level + 360);
        }
        else {
            return (int)(4.5 * (level * level) - 162.5 * level + 2220);
        }
    }
    static int expTarget(int level) {
        if(level <= 16) {
            return (level * level) + 6 * level;
        }
        else if(level > 16 && level <= 31) {
            return (int)(2.5 * (level * level) - 40.5 * level + 360);
        }
        else {
            return (int)(4.5 * (level * level) - 162.5 * level + 2220);
        }
    }

    public static void main(String[] args) {

        System.out.print("Input current level: ");
        try {
            sc1 = new Scanner(System.in);
        }
        finally {
            currentLvl = sc1.nextInt();
        }

        System.out.println("");
        System.out.print("Input target level: ");
        try {
            sc2 = new Scanner(System.in);
        }
        finally {
            targetLvl = sc2.nextInt();
        }

        if(targetLvl < currentLvl) {
            System.out.println("Target level can't be smaller than current level!");
        }
        else if(targetLvl == currentLvl) {
            System.out.println("You'll need: 0 EXP");
        }
        else {
            System.out.println("You'll need: " + (expTarget(targetLvl) - expCurrent(currentLvl)) + " EXP");
        }

    }
}

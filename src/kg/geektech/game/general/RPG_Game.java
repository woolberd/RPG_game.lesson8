package kg.geektech.game.general;

import kg.geektech.game.players.*;

import java.util.Random;

public class RPG_Game {
    public static boolean statusStun = false;
    public static Random random = new Random();
    public static void startGame(){
        Boss boss = new Boss(75,345);
        Warrior warrior = new Warrior(87,90);
        Magic magic = new Magic(234,567);
        Medic doctor = new Medic(83,974,15);
        Medic asistent = new Medic(736,897,11);
        Berserk berserk = new Berserk(700,560);

        Hero[] heroes = {warrior,magic,doctor,asistent,berserk};

        while ( !isGameFinish(boss,heroes)){
            round(boss,heroes);
        }
    }
    private static  void heroesApplyAbility(Boss boss, Hero [] heroes){
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0 && boss.getHealth() > 0);
            heroes[i].applySuperPower(boss,heroes);

        }
    }
    private static void round(Boss boss, Hero[] heroes){
        bossHits(boss,heroes);
        heroesHits(boss,heroes);
        printStatistics(boss,heroes);
        heroesApplyAbility(boss,heroes);
    }

    private static boolean isGameFinish(Boss boss, Hero[] heroes){
        if (boss.getHealth() <= 0){
            System.out.println("HEROES WIN");
            return true;
        }
        boolean allHeroesDead = true;
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0){
                allHeroesDead = false;
                break;
            }
        }
        if (allHeroesDead){
            System.out.println("BOSS WIN ");
        }
        return allHeroesDead;

    }

    private static void bossHits(Boss boss, Hero[] heroes){
        for (int i = 0; i < heroes.length ; i++) {
            heroes[i].setHealth(heroes[i].getHealth() - boss.getDamage());
        }
    }

    private static void heroesHits(Boss boss, Hero[] heroes){
        for (int i = 0; i < heroes.length ; i++) {
            if (heroes[i].getHealth() > 0 && boss.getHealth() > 0 )
            boss.setHealth(boss.getHealth() - heroes[i].getDamage());
        }
    }
    private static void printStatistics(Boss boss, Hero[] heroes){
        System.out.println("-----------------------");
        System.out.println(" Boss health "  + boss.getHealth() + " [ " + boss.getDamage() + " ] ");

        for (int i = 0; i < heroes.length; i++) {
            System.out.println(heroes[i].getClass().getSimpleName() + " health " + heroes[i].getHealth() +
                    " [ " + heroes[i].getDamage() + " ] ");

        }

    }


}

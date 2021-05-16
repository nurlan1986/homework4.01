package com.geektech;

import java.util.Random;

public abstract class Main {
    public static int bossHealth = 700;
    public static int bossDamage = 50;
    public static String bossDefenceType = "";
    public static int[] heroesHealth = {500, 260, 270, 300, 500, 400};
    public static int[] heroesDamage = {15, 10, 20, 30, 0, 25};
    public static String[] heroesAttackType = {"Magical", "Mental", "Magical", "Medic",};
    public static int roundCounter = 0;


    public static void main(String[] args) {

        while (!isFinished()) {
            round();
        }
    }

    public static void round(){
        printStatistics();
        roundCounter++;
        System.out.println("Round =  "+ roundCounter);
        System.out.println("Round was started!");
        heroesHit();
        changeBossDeFenceType();
        bossHit();
        printStatistics();

    }


    public static void printStatistics() {
        System.out.println("-------------");
        System.out.println("Boss health: " + bossHealth);
        System.out.println("Golem health" + heroesHealth[0]);
        System.out.println("Lucky health: " + heroesHealth[1]);
        System.out.println("Berserk health: " + heroesHealth[2]);
        System.out.println("Thor health: " + heroesHealth[3]);
        System.out.println("Medic health: " + heroesHealth[4]);
        System.out.println("-------------");
    }

    public static void bossHit() {
        for (int i = 0; i < heroesHealth.length; i++) {
            if (heroesHealth[i] > 0 && bossHealth > 0) {
                if (heroesHealth[i] - bossDamage < 0) {
                    heroesHealth[i] = 0;
                }
                else {
                    if (heroesHealth[5]>0) {
                        if(heroesHealth[i]!=heroesHealth[5]){
                            heroesHealth[i]=heroesHealth[i]-(bossDamage-(bossDamage/5));
                        }else {
                            heroesHealth[i]=heroesHealth[i]-bossDamage;
                        }


                    }else {
                        heroesHealth[i]=heroesHealth[i]-bossDamage;
                    }
                }
            }if (heroesHealth[i] < 100 && heroesHealth[3] > 0 && heroesHealth[i] > 0){
                Random random = new Random();
                int healing  = random.nextInt(100);
                heroesHealth [i] = heroesHealth[i] + healing;
                System.out.println("Добавил "+ healing);

            }
        }
    }

    public static void heroesHit() {
        for (int i = 0; i < heroesHealth.length; i++) {
            if (bossHealth > 0 && heroesHealth[i] > 0) {
                if (bossHealth - heroesDamage[i] < 0) bossHealth = 0;
                else bossHealth = bossHealth - heroesDamage[i];
            }
        }
    }

    public static boolean isFinished() {
        if (bossHealth <= 0) {
            System.out.println("Heroes won!!!");
            return true;
        }
        if (heroesHealth[0] <= 0 && heroesHealth[1] <= 0
                && heroesHealth[2] <= 0) {
            System.out.println("Boss won!!!");
            return true;

        }
        return false;
    }

    public static void changeBossDeFenceType() {
        Random random = new Random();
        int randomIndex = random.nextInt(heroesAttackType.length);
        bossDefenceType = heroesAttackType[randomIndex];
        System.out.println("boss defence type: " + bossDefenceType);

    }

            }






package demo;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    private static Team<FootballPlayer> manU;
    private static Team<FootballPlayer> barcelona;
    private static Team<FootballPlayer> realMadrid;
    private static Team<FootballPlayer> psg;
    private static Team<FootballPlayer> chelsea;
    private int ourScore;
    private int theirScore;
    private static final League<Team<FootballPlayer>> championsLeague = new League<>("Champions League");


    public static void main(String[] args) {

        Main main = new Main();
        manU = new Team<>("Manchester United");
        FootballPlayer ronaldo = new FootballPlayer("Ronaldo");
        manU.add(ronaldo);

        barcelona = new Team<>("Barcelona");
        FootballPlayer pique = new FootballPlayer("pique");
        barcelona.add(pique);

        realMadrid = new Team<>("Real Madrid");
        FootballPlayer benzema = new FootballPlayer("Benzema");
        realMadrid.add(benzema);

        psg = new Team<>("PSG");
        FootballPlayer messi = new FootballPlayer("Messi");
        psg.add(messi);


        chelsea = new Team<>("chelsea");
        FootballPlayer rudiger = new FootballPlayer("rudiger");
        chelsea.add(rudiger);

//        manU.randomMatchResult(barcelona, ourScore, theirScore);
//        chelsea.randomMatchResult(barcelona, ourScore, theirScore);
//        realMadrid.randomMatchResult(chelsea, ourScore, theirScore);
//        psg.randomMatchResult(manU, ourScore, theirScore);


        championsLeague.add(barcelona);
        championsLeague.add(manU);
        championsLeague.add(realMadrid);
        championsLeague.add(psg);
        championsLeague.add(chelsea);

        boolean quit = false;
        Scanner scanner = new Scanner(System.in);

        while (!quit) {

            printMenu();

            try {
                int action = scanner.nextInt();
                switch (action) {
                    case 0:
                        System.out.println("Quitting");
                        quit = true;
                        break;
                    case 1:
                        main.matchResult();

                        break;
                    case 2:
                        championsLeague.showLeagueTable();
                        break;
                    case 3:
                        main.chooseTeam();
                        break;
                }

            } catch (Exception e) {
                scanner.nextLine();
                System.out.println("Please try again");
            }
        }
    }

    public static void printMenu() {
        System.out.println("press 0 to quit\n" +
                "Press 1 to for Match Result\n" +
                "Press 2 to view league table\n" +
                "Press 3 to choose team to play");

    }

    public void matchResult() {
        Random rand = new Random();
        ourScore = rand.nextInt(9);
        theirScore = rand.nextInt(9);
        manU.randomMatchResult(barcelona, rand.nextInt(9), rand.nextInt(9));
        chelsea.randomMatchResult(barcelona, rand.nextInt(9), rand.nextInt(9));
        realMadrid.randomMatchResult(chelsea, rand.nextInt(9), rand.nextInt(9));
        psg.randomMatchResult(manU, rand.nextInt(9), rand.nextInt(9));


    }

    public void chooseTeam() {
        System.out.println("Choose the team ");
        Scanner scanner = new Scanner(System.in);
        String team = scanner.nextLine();
        Team<FootballPlayer> foundTeam = championsLeague.findTeam(team);
        System.out.println(championsLeague);
        if (foundTeam == null) {
            System.out.println("The team is not in the champions league");
        } else {
            System.out.println("Choose second team");
            String team2 = scanner.nextLine();
            Team<FootballPlayer> foundSecondTeam = championsLeague.findTeam(team2);
            System.out.println(championsLeague);

            if (foundSecondTeam == null) {
                System.out.println("The team is not in the champions league");

            } else {

                Random rand = new Random();
                ourScore = rand.nextInt(9);
                theirScore = rand.nextInt(9);
                foundTeam.randomMatchResult(foundSecondTeam, ourScore, theirScore);
                System.out.println(ourScore + " " + theirScore);
            }
        }


    }
}


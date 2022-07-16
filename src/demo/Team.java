package demo;

import java.util.ArrayList;
import java.util.Random;

public class Team<T extends Player> implements Comparable<Team<T>> {
    private final String name;
    private int won;
    private int lost;
    private int tied;
    private int played;

    private final ArrayList<T> members;


    public Team(String name) {

        this.name = name;
        this.members = new ArrayList<>();

    }

    public void add(T player) {
        if (members.contains(player)) {
            System.out.println(player.getName() + " is already in the team");
        } else {
            members.add(player);
            System.out.println(player.getName() + " was picked for the team");
        }
    }

    public int numPlayers() {
        return this.members.size();
    }

    public void randomMatchResult(Team<T> opponent, int ourScore, int theirScore) {
        if (ourScore > theirScore) {
            won++;
        } else if (ourScore == theirScore) {
            tied++;
        } else {
            lost++;
        }
        played++;
        if (opponent != null) {
            System.out.println("===============Match Result====================");
            System.out.println(this.getName() + " " + ourScore + " " + opponent.getName() + " " + theirScore);
            opponent.randomMatchResult(null, theirScore, ourScore);
        }

        //    opponent.randomMatchResult(this);


    }

    public void matchResult(Team opponent, int ourScore, int theirScore) {

        String message = "";
        if (ourScore > theirScore) {
            won++;
        } else if (ourScore < theirScore) {
            lost++;
        } else {
            tied++;
        }
        played++;
        if (opponent != null) {
            System.out.println("========== Match Results ========================");
            System.out.println(this.name + " " + ourScore + " " + opponent.name + " " + theirScore);
            opponent.matchResult(null, theirScore, ourScore);

        }
    }

    public int ranking() {
        return (won * 3) + tied;
    }

    @Override
    public int compareTo(Team<T> team) {
        return Integer.compare(team.ranking(), this.ranking());
    }

    public String getName() {
        return name;
    }

    public int getWon() {
        return won;
    }

    public int getLost() {
        return lost;
    }

    public int getTied() {
        return tied;
    }

    public int getPlayed() {
        return played;
    }


}

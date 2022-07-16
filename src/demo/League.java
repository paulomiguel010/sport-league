package demo;

import java.util.ArrayList;
import java.util.Collections;

public class League<T extends Team> {
    private final String name;
    private final ArrayList<T> league;

    public League(String name) {
        this.name = name;
        this.league = new ArrayList<>();
    }

    public ArrayList<T> getLeague() {
        return league;
    }

    public void add(T team) {
        if (league.contains(team)) {
            System.out.println(team.getName() + "is already in the league");
        } else {
            this.league.add(team);
        }
    }

    public void showLeagueTable() {
        System.out.println("=================League Table================");
        System.out.println("Team  " + " Points " + " Won " + " Lost " + " Drew " + " Games Played");
        Collections.sort(league);
        for (int i = 0; i < this.league.size(); i++) {
            T team = league.get(i);

            System.out.println((i + 1) + ")" + team.getName() + " " + team.ranking() + " " +
                    team.getWon() + " " + team.getLost() + " " + team.getTied() + " " + team.getPlayed());
        }
    }

    public T findTeam(String teamName) {
        for (T team : league) {
            if (team.getName().equalsIgnoreCase(teamName)) {
                return team;
            }
        }
        return null;
    }


}

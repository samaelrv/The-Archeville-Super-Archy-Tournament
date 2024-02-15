package com.ramanth;

import java.util.ArrayList;
import java.util.List;

public class ArcherBoardDriver {
    public static void main(String[] args) {

        List<Team> teams = new ArrayList<>();

        teams.add(new Team("Gyrhuna", "János Diák", "Süsü"));
        teams.add(new Team("Achni", "Meilong", "Tianlong"));
        teams.add(new Team("Bathar", "Pakhangba", "Poubi Lai Paphal"));
        String[] playersOrder = {"János Diák", "Süsü", "Meilong", "Tianlong", "Pakhangba", "Poubi Lai Paphal"};
        String[] rounds = {
                "A,B,C,D,E,F",
                "A,B,C,D,E,F",
                "A,B,A,A,A,A",
                "A,A,A,B,A,A",
                "B,C,A,B,E,F"
        };

        for (int round = 0; round < 5; round++) {

            for (int i = 0; i < playersOrder.length; i++) {
                String[] circleHits = rounds[round].split(",");
                for (Team team : teams) {
                    team.updateScore(playersOrder[i], circleHits[i], round + 1);
                }
            }

            Team winner = determineWinner(teams);
            if (winner.teamScore >= 60) {
                System.out.println("Game over."+ winner.name +" won!!!");
                break;

            } else {

                System.out.println("Round " + (round + 1));
                System.out.println("Team Scores");
                System.out.println("-----------------------------");

                for (Team team : teams){
                    System.out.println(team.name + ": " + team.teamScore);
                }
                System.out.println();
                System.out.println("Individual Scores");
                System.out.println("-----------------------------");

                for ( Team team : teams){
                    System.out.println(team.archer1.name + ": " + team.archer1.score);
                    System.out.println(team.archer2.name + ": " + team.archer2.score);
                }
                System.out.println();
                System.out.println("\nBonus points\n-----------------");
                for (Team team : teams) {
                    System.out.println(team.name + ": " +team.bonusScore);
                }
                System.out.println();
            }
        }
    }

    private static Team determineWinner(List<Team> teams) {
        Team winner = teams.get(0);
        for (Team team : teams) {
            if (team.teamScore > winner.teamScore) {
                winner = team;
            }
        }
        return winner;

    }
}

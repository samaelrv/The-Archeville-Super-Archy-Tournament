package com.ramanth;

import java.util.Map;

public class Team {

    String name;
    Archer archer1;
    Archer archer2;
    int teamScore;
    String lastCircleHit;
    int bonusScore;

    public Team(String name, String archer1, String archer2) {

        this.name = name;
        this.archer1 = new Archer(archer1);
        this.archer2 = new Archer(archer2);
        this.teamScore = 0;
        this.bonusScore = 0;
        this.lastCircleHit = "";

    }

    public void updateScore(String playerName, String circle, int round) {
        int points = calculatePoints(circle, round);
        if (playerName.equals(archer1.name)) {
            archer1.score += points;
            if (circle.equals(lastCircleHit)) {
                bonusScore+= 2;
            }
            lastCircleHit = circle;
        } else if (playerName.equals(archer2.name)) {
            archer2.score += points;
            if (circle.equals(lastCircleHit)) {
                bonusScore+= 2;
            }
            lastCircleHit = circle;
        }
        teamScore = archer1.score + archer2.score;
    }

    private int calculatePoints(String circle, int round) {

        Map<Character, Integer> pointsMap = Map.of('A', 5, 'B', 4, 'C', 3, 'D', 2, 'E', 1, 'F', 0);
        return pointsMap.get(circle.charAt(0)) + round - 1;

    }
}

package _09Dominoes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Dominoes {
    public static void main(String[] args) {
        List<Domino> dominoes = initializeDominoes();
        // You have the list of Dominoes
        // Order them into one snake where the adjacent dominoes have the same numbers on their adjacent sides
        // eg: [2, 4], [4, 3], [3, 5] ...

        // "practice Abstracts & Interfaces at week-10":
        System.out.println(dominoes);
        Collections.sort(dominoes);
        System.out.println(dominoes);

        // original exercise in OOP at week-07:
        List<Domino> orderedDominoes = new ArrayList<>();
        orderedDominoes.add(dominoes.get(0));
        int snakeEnd = dominoes.get(0).getRightSide();
        dominoes.remove(0);
        for (int j = 0; j < dominoes.size(); j++) {
            for (int i = 0; i < dominoes.size(); i++) {
                if (snakeEnd == dominoes.get(i).getLeftSide()) {
                    orderedDominoes.add(dominoes.get(i));
                    snakeEnd = dominoes.get(i).getRightSide();
                    dominoes.remove(i);
                    j --;
                }
            }
        }
        System.out.println(orderedDominoes);

    }

    static List<Domino> initializeDominoes() {
        List<Domino> dominoes = new ArrayList<>();
        dominoes.add(new Domino(7, 2));
        dominoes.add(new Domino(5, 2));
        dominoes.add(new Domino(4, 6));
        dominoes.add(new Domino(1, 5));
        dominoes.add(new Domino(6, 7));
        dominoes.add(new Domino(2, 4));
        dominoes.add(new Domino(7, 1));
        return dominoes;
    }
}
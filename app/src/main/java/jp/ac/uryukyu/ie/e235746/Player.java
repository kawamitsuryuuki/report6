package jp.ac.uryukyu.ie.e235746;

import java.util.ArrayList;

public class Player {
    private String name;
    private int number;
    private ArrayList<Card> hands;
    public int cardCount;

    Player(String name, int number) {
        this.name = name;
        this.number = number;
        this.hands = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public int getNumber() {
        return this.number;
    }

    public ArrayList<Card> getHands() {
        return this.hands;
    }

    public void addCards(Card card) {
        this.hands.add(card);
    }
}


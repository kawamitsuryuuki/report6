package jp.ac.uryukyu.ie.e235718;

import java.util.ArrayList;

public class Player {
    private String name;
    private ArrayList<Card> hands;
    public int cardCount;

    Player(String name) {
        this.name = name;
        this.hands = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public ArrayList<Card> getHands() {
        return this.hands;
    }

    public void addCards(Card card) {
        this.hands.add(card);
    }
}


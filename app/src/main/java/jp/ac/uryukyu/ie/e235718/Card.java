package jp.ac.uryukyu.ie.e235718;

public class Card {
    private String type;
    private int number;

    Card(String type, int number) {
        this.type = type;
        this.number = number;
    }

    public String getType() {
        return this.type;
    }

    public int getNumber() {
        return this.number;
    }

    public String showCard() {
        return this.type + this.number;
    }
}

package jp.ac.uryukyu.ie.e235718;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class GameMaster {
    ArrayList<Card> cards;
    Player[] players;

    GameMaster() {
        this.cards = new ArrayList<>();
        this.players = new Player[2];
        String[] types = new String[4];
        types[0] = "Heart";
        types[1] = "Clover";
        types[2] = "Diamond";
        types[3] = "Spade";
        for ( String type : types ) {
            for ( int i = 1; i < 14; i ++ ) {
                this.cards.add(new Card(type, i));
            } 
        }

        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 2; i ++) {
            System.out.println("\n名前を入力してください。");
            String name = scanner.next();
            this.players[i] = new Player(name);
            System.out.printf("プレイヤー%dの名前は%sです。\n", i + 1, players[i].getName());
        }
        scanner.close();
    }

    public void dealOut() {
        Random random = new Random();
        for ( int i = 0; i < 26; i ++ ) {
            for ( Player player : this.players ) {
                int num = random.nextInt(this.cards.size());
                player.addCards(this.cards.get(num));
                this.cards.remove(this.cards.get(num));
            }
        }

        for (Player player : this.players){
            System.out.println(player.getHands().size());
        }
    }
}

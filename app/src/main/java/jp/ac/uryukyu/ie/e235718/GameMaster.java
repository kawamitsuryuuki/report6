package jp.ac.uryukyu.ie.e235718;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class GameMaster {
    ArrayList<Card> cards;
    Player[] players;
    int n;
    Scanner scanner;

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

        this.scanner = new Scanner(System.in);
        for (int i = 0; i < 2; i ++) {
            System.out.println("\n名前を入力してください。");
            String name = scanner.next();
            this.players[i] = new Player(name, i + 1);
            System.out.printf("プレイヤー%dの名前は%sです。\n", i + 1, players[i].getName());
        }
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
    }

    public void startGame() {
        this.n = startPlayer();
        for (int i = 0; i < 26; i ++ ) {
            System.out.printf("\n--------------------------\n");
            System.out.printf("プレイヤー%dの攻撃です。\n", this.players[this.n % 2].getNumber());
            Card offenceCard = this.players[0].getHands().get(0);
            Card defenceCard = this.players[1].getHands().get(0);
            System.out.printf("プレイヤー%dのカードは%sです。\n", this.players[(this.n + 1) % 2].getNumber(), defenceCard.showCard());
            System.out.println("highかlowか入力してください。");
            if (this.scanner.hasNext()) {
                String answer = this.scanner.next();
                if (answer.equals("high")) {
                    if (offenceCard.getNumber() > defenceCard.getNumber()) {
                        System.out.printf("プレイヤー%dのカードは%sなのでアタリ！\n", this.players[this.n % 2].getNumber(), offenceCard.showCard());
                        players[this.n % 2].cardCount += 2;
                    } else {
                        System.out.printf("プレイヤー%dのカードは%sなのでハズレ！\n", this.players[this.n % 2].getNumber(), offenceCard.showCard());
                    }
                } else {
                    if (offenceCard.getNumber() < defenceCard.getNumber()) {
                        System.out.printf("プレイヤー%dのカードは%sなのでアタリ！\n", this.players[this.n % 2].getNumber(), offenceCard.showCard());
                        players[this.n % 2].cardCount += 2;
                    } else {
                        System.out.printf("プレイヤー%dのカードは%sなのでハズレ！\n", this.players[this.n % 2].getNumber(), offenceCard.showCard());
                    }
                }
                this.players[this.n % 2].getHands().remove(offenceCard);
                this.players[(this.n + 1) % 2].getHands().remove(defenceCard);
                this.n += 1;
            } else {
                System.out.println("入力がありません。");
            }
        } 
        finishGame();
    }

    public int startPlayer() {
        Random random = new Random();
        int start = random.nextInt(2);
        if (start == 0) {
            return 0;
        } else {
            return 1;
        }
    }

    public void finishGame() {
        System.out.println("ゲーム終了！");
        System.out.printf("プレイヤー%dの枚数は%d、プレイヤー%dの枚数は%d！\n", this.players[0].getNumber(), this.players[0].cardCount, this.players[1].getNumber(), this.players[1].cardCount);
        if (this.players[0].cardCount > this.players[1].cardCount) {
            System.out.printf("プレイヤー%dの勝ち！\n", this.players[0].getNumber());
        } else if (this.players[0].cardCount < this.players[1].cardCount) {
            System.out.printf("プレイヤー%dの勝ち！\n", this.players[1].getNumber());
        } else {
            System.out.printf("プレイヤー%dとプレイヤー%dは引き分けで終了！\n", this.players[0].getNumber(), this.players[1].getNumber());
        }
        System.exit(0);
    }
}

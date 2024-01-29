package jp.ac.uryukyu.ie.e235746;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CardTest {
    @Test void checkCard() {
       Card sss = new Card("Spade",9);
       assertEquals("Spade9",sss.showCard());
       

    }

}
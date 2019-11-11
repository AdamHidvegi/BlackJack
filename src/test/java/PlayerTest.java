import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class PlayerTest {

    Player player1;
    Deck deck;
    Card card;
    ArrayList<Card> cards;

    @Before
    public void before() {
        card = new Card(CardSuit.HEARTS, CardRank.TWO);
        cards = new ArrayList<Card>();
        deck = new Deck();
        player1 = new Player();
    }

    @Test
    public void checkHand() {
        assertEquals(0, player1.checkHand());
    }

    @Test
    public void sumOfHand() {
        deck.createDeck();
        deck.dealCardToPlayer(player1);
        assertEquals(3, player1.getSumOfHand());
    }

//    @Test
//    public void checkAce() {
//        deck.createDeck();
//        deck.dealCardToPlayer(player1);
//        deck.dealCardToPlayer(player1);
//        deck.dealCardToPlayer(player1);
//        player1.valueOfAce();
//        assertEquals(21, player1.getSumOfHand());
//    }

    @Test
    public void showCard__first() {
        deck.createDeck();
        deck.dealCardToPlayer(player1);
        deck.dealCardToPlayer(player1);
        assertEquals(1, player1.showFirstCardNumber());
        assertEquals("Hearts", player1.showFirstCardSuit());
        assertEquals(2, player1.showSecondCardNumber());
        assertEquals("Hearts", player1.showSecondCardSuit());
        assertEquals(3, player1.showThirdCardNumber());
        assertEquals("Hearts", player1.showThirdCardSuit());
        assertEquals(4, player1.showFourthCardNumber());
        assertEquals("Hearts", player1.showFourthCardSuit());
    }

    @Test
    public void showCard__second() {
        deck.createDeck();
        deck.dealCardToPlayer(player1);
        deck.dealCardToPlayer(player1);
        assertEquals(3, player1.showThirdCardNumber());
        assertEquals("Hearts", player1.showThirdCardSuit());
        assertEquals(4, player1.showFourthCardNumber());
        assertEquals("Hearts", player1.showFourthCardSuit());
    }

}

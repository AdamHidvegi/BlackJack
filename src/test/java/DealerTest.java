import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class DealerTest {

    Player player1;
    Dealer dealer;
    Deck deck;
    Card card;
    ArrayList<Card> cards;

    @Before
    public void before() {
        card = new Card(CardSuit.HEARTS, CardRank.TWO);
        cards = new ArrayList<Card>();
        deck = new Deck();
        player1 = new Player();
        dealer = new Dealer("Molly");
    }

    @Test
    public void getName() {
        assertEquals("Molly", dealer.getName());
    }

    @Test
    public void checkHand() {
        assertEquals(0, dealer.checkHand());
    }

    @Test
    public void sumOfHand() {
        deck.createDeck();
        deck.dealCardToDealer(dealer);
        assertEquals(3, dealer.getSumOfHand());
    }

//    @Test
//    public void checkAce() {
//        deck.createDeck();
//        deck.dealCardToDealer(dealer);
//        deck.dealCardToDealer(dealer);
//        deck.dealCardToDealer(dealer);
//        deck.dealCardToDealer(dealer);
//        dealer.getSumOfHand();
//        dealer.valueOfAce();
//        assertEquals(26, dealer.getSumOfHand());
//    }

    @Test
    public void showCard__first() {
        deck.createDeck();
        deck.dealCardToDealer(dealer);
        deck.dealCardToDealer(dealer);
        assertEquals(1, dealer.showFirstCardNumber());
        assertEquals("Hearts", dealer.showFirstCardSuit());
        assertEquals(2, dealer.showSecondCardNumber());
        assertEquals("Hearts", dealer.showSecondCardSuit());
        assertEquals(3, dealer.showThirdCardNumber());
        assertEquals("Hearts", dealer.showThirdCardSuit());
        assertEquals(4, dealer.showFourthCardNumber());
        assertEquals("Hearts", dealer.showFourthCardSuit());
    }

    @Test
    public void showCard__second() {
        deck.createDeck();
        deck.dealCardToDealer(dealer);
        deck.dealCardToDealer(dealer);
        assertEquals(3, dealer.showThirdCardNumber());
        assertEquals("Hearts", dealer.showThirdCardSuit());
        assertEquals(4, dealer.showFourthCardNumber());
        assertEquals("Hearts", dealer.showFourthCardSuit());
    }

}

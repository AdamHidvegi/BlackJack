import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class CardTest {

    Deck deck;
    ArrayList<Card> cards;
    Dealer dealer;

    @Before
    public void before() {
        deck = new Deck();
        cards = new ArrayList<Card>();
        dealer = new Dealer("Molly");
    }

    @Test
    public void getRank__getSuit() {
        deck.createDeck();
        deck.dealOneCardToDealer(dealer);
        assertEquals(1, dealer.showFirstCardNumber());
        assertEquals("Hearts", dealer.showFirstCardSuit());
    }

}

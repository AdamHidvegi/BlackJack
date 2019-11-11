import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class DeckTest {

    Deck deck;
    Card card;
    Player player1;
    Player player2;
    ArrayList<Card> cards;
    Dealer dealer;

    @Before
    public void before() {
        card = new Card(CardSuit.HEARTS, CardRank.TWO);
        cards = new ArrayList<Card>();
        deck = new Deck();
        player1 = new Player();
        player2 = new Player();
        dealer = new Dealer("Molly");
    }

    @Test
    public void checkDeck() {
        assertEquals(0, deck.checkDeck());
    }

    @Test
    public void createDeck() {
        deck.createDeck();
        assertEquals(52, deck.checkDeck());
    }

    @Test
    public void shuffleDeck() {
        deck.createDeck();
        assertEquals(true, deck.checkRandomCard());
    }

    @Test
    public void dealTwoCards() {
        deck.createDeck();
        deck.shuffleDeck();
        deck.dealCardToPlayer(player1);
        deck.dealCardToDealer(dealer);
        assertEquals(48, deck.checkDeck());
        assertEquals(2, player1.checkHand());
        assertEquals(2, dealer.checkHand());
    }

    @Test
    public void dealOneCard() {
        deck.createDeck();
        deck.shuffleDeck();
        deck.dealOneCardToPlayer(player1);
        deck.dealOneCardToDealer(dealer);
        assertEquals(50, deck.checkDeck());
        assertEquals(1, player1.checkHand());
        assertEquals(1, dealer.checkHand());
    }

}

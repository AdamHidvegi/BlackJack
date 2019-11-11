import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameTest {

    Game game;
    Dealer dealer;
    Player player;
    Deck deck;

    @Before
    public void before() {
        game = new Game();
        dealer = new Dealer("Molly");
        player = new Player();
        deck = new Deck();
    }

    @Test
    public void whoWins__player() {
        deck.createDeck();
        deck.dealOneCardToDealer(dealer);
        deck.dealCardToPlayer(player);
        player.getSumOfHand();
        dealer.getSumOfHand();
        assertEquals("The winner is you! Good job!", game.whoWins(dealer, player));
    }

    @Test
    public void whoWins__draw() {
        deck.createDeck();
        deck.dealCardToDealer(dealer);
        deck.dealOneCardToPlayer(player);
        player.getSumOfHand();
        dealer.getSumOfHand();
        assertEquals("It's a draw, my friend. Let's play another one!", game.whoWins(dealer, player));
    }

    @Test
    public void whoWins__dealer() {
        deck.createDeck();
        deck.dealOneCardToPlayer(player);
        deck.dealCardToDealer(dealer);
        player.getSumOfHand();
        dealer.getSumOfHand();
        assertEquals("The winner is me! Sorry, better luck next time!", game.whoWins(dealer, player));
    }

}

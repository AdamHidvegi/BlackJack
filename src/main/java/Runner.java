import java.util.ArrayList;
import java.util.Scanner;

public class Runner {

    public static void main(String[] args) {

        Deck deck = new Deck();
        Dealer dealer = new Dealer("Molly");
        Player player = new Player();
        Game game = new Game();
        Scanner myScanner = new Scanner(System.in);

        String dealerName = dealer.getName();
        System.out.println("Welcome to BlackJack!");
        String welcome = String.format("My name is %s and I'm gonna be your card dealer today.", dealerName);
        System.out.println(welcome);
        System.out.println("Please, enter your name: ");
        String playerName = myScanner.nextLine();
        System.out.println(String.format("Alright %s, have fun and good luck!", playerName));

        deck.createDeck();
        deck.shuffleDeck();
        deck.shuffleDeck();
        deck.dealCardToDealer(dealer);
        deck.dealCardToPlayer(player);
        System.out.println("My first card is the " + dealer.showFirstCardNumber() + " of " + dealer.showFirstCardSuit() + ", but you don't know what the second is.");
        System.out.print("Your cards are the " + player.showFirstCardNumber() + " of " + player.showFirstCardSuit());
        System.out.println(" and the " + player.showSecondCardNumber() + " of " + player.showSecondCardSuit() + ".");
        System.out.println("You are at " + player.getSumOfHand() + ".");

        System.out.println("Would you like to get a new card or finish this round? (card/stop)");
        String playerAnswer = myScanner.nextLine();
        if (playerAnswer.equals("card")) {
            deck.dealOneCardToPlayer(player);
            System.out.print("Your cards are the " + player.showFirstCardNumber() + " of " + player.showFirstCardSuit() + ", ");
            System.out.print("the " + player.showSecondCardNumber() + " of " + player.showSecondCardSuit());
            System.out.println(" and the " + player.showThirdCardNumber() + " of " + player.showThirdCardSuit() + ".");
            System.out.println("You are at " + player.getSumOfHand() + ".");
            if (player.getSumOfHand() > 21) {
                System.out.println("I'm sorry, but you lost. Better luck next time!");
            }
            else if (player.getSumOfHand() <= 21)  {
                System.out.println("You are still good, would you like to get a new card? (yes/no)");
                String playerNextAnswer = myScanner.nextLine();
                if (playerNextAnswer.equals("yes")) {
                    deck.dealOneCardToPlayer(player);
                    System.out.print("Your cards are the " + player.showFirstCardNumber() + " of " + player.showFirstCardSuit() + ", ");
                    System.out.print("the " + player.showSecondCardNumber() + " of " + player.showSecondCardSuit() + ", ");
                    System.out.print("the " + player.showThirdCardNumber() + " of " + player.showThirdCardSuit());
                    System.out.println(" and the " + player.showFourthCardNumber() + " of " + player.showFourthCardSuit() + ".");
                    System.out.println("You are at " + player.getSumOfHand() + ".");
                    if (player.getSumOfHand() > 21) {
                        System.out.println("I'm sorry, but you lost. Better luck next time!");
                    }
                    else if (player.getSumOfHand() <= 21) {
                        System.out.println("You are still good, but you already have 4 cards, I'd stop if I were you. :)");
                        System.out.println("So, would you like to get a new card or stop? (card/stop)");
                        String playerLastAnswer = myScanner.nextLine();
                        if (playerLastAnswer.equals("card")) {
                            deck.dealOneCardToPlayer(player);
                            System.out.println("You are at " + player.getSumOfHand() + ".");
                            if (player.getSumOfHand() > 21) {
                                System.out.println("I'm sorry, but you lost. Better luck next time!");
                            }
                            else if (player.getSumOfHand() <= 21) {
                                System.out.println("You are still good, but please stop. :D (stop/stop)");
                                String playerVeryLastAnswer = myScanner.nextLine();
                                if (playerVeryLastAnswer.equals("stop")) {
                                    System.out.println("Good, good. Now take a look at my cards.");
                                    dealer.getSumOfHand();
                                    if (dealer.getSumOfHand() < 16) {
                                        deck.dealOneCardToDealer(dealer);
                                        if (dealer.getSumOfHand() > 21) {
                                            System.out.print("My cards are the " + dealer.showFirstCardNumber() + " of " + dealer.showFirstCardSuit() + ", ");
                                            System.out.print("the " + dealer.showSecondCardNumber() + " of " + dealer.showSecondCardSuit());
                                            System.out.println(" and the " + dealer.showThirdCardNumber() + " of " + dealer.showThirdCardSuit() + ".");
                                            System.out.println("I'm at " + dealer.getSumOfHand() + ", so you are the winner!");
                                        }
                                        else if (dealer.getSumOfHand() <= 21) {
                                            if (dealer.getSumOfHand() < 16) {
                                                deck.dealOneCardToDealer(dealer);
                                                if (dealer.getSumOfHand() > 21) {
                                                    System.out.print("My cards are the " + dealer.showFirstCardNumber() + " of " + dealer.showFirstCardSuit() + ", ");
                                                    System.out.print("the " + dealer.showSecondCardNumber() + " of " + dealer.showSecondCardSuit() + ", ");
                                                    System.out.print("the " + dealer.showThirdCardNumber() + " of " + dealer.showThirdCardSuit());
                                                    System.out.println(" and the " + dealer.showFourthCardNumber() + " of " + dealer.showFourthCardSuit() + ".");
                                                    System.out.println("I'm at " + dealer.getSumOfHand() + ", so you are the winner!");
                                                }
                                                else if (dealer.getSumOfHand() <= 21) {
                                                    System.out.print("My cards are the " + dealer.showFirstCardNumber() + " of " + dealer.showFirstCardSuit() + ", ");
                                                    System.out.print("the " + dealer.showSecondCardNumber() + " of " + dealer.showSecondCardSuit() + ", ");
                                                    System.out.print("the " + dealer.showThirdCardNumber() + " of " + dealer.showThirdCardSuit());
                                                    System.out.println(" and the " + dealer.showFourthCardNumber() + " of " + dealer.showFourthCardSuit() + ".");
                                                    System.out.println("I'm at " + dealer.getSumOfHand() + ", but I stop here, I'm a smart computer.");
                                                    System.out.println(game.whoWins(dealer, player));
                                                }
                                                else {
                                                    System.out.println("You shouldn't see this message.");
                                                }
                                            }
                                            else if (dealer.getSumOfHand() >= 16) {
                                                System.out.print("My cards are the " + dealer.showFirstCardNumber() + " of " + dealer.showFirstCardSuit() + ", ");
                                                System.out.print("the " + dealer.showSecondCardNumber() + " of " + dealer.showSecondCardSuit());
                                                System.out.println(" and the " + dealer.showThirdCardNumber() + " of " + dealer.showThirdCardSuit());
                                                System.out.println("I'm at " + dealer.getSumOfHand() + ".");
                                                System.out.println(game.whoWins(dealer, player));
                                            }
                                            else {
                                                System.out.println("You shouldn't see this message.");
                                            }
                                        }
                                        else {
                                            System.out.println("You shouldn't see this message.");
                                        }
                                    }
                                    else if (dealer.getSumOfHand() >= 16) {
                                        System.out.print("My cards are the " + dealer.showFirstCardNumber() + " of " + dealer.showFirstCardSuit() + ", ");
                                        System.out.println("the " + dealer.showSecondCardNumber() + " of " + dealer.showSecondCardSuit() + ".");
                                        System.out.println("I'm at " + dealer.getSumOfHand() + ".");
                                        System.out.println(game.whoWins(dealer, player));
                                    }
                                    else {
                                        System.out.println("You shouldn't see this message.");
                                    }
                                }
                            }
                            else {
                                System.out.println("You shouldn't see this message.");
                            }
                        }
                        else if (playerLastAnswer.equals("stop")) {
                            dealer.getSumOfHand();
                            if (dealer.getSumOfHand() < 16) {
                                deck.dealOneCardToDealer(dealer);
                                if (dealer.getSumOfHand() > 21) {
                                    System.out.print("My cards are the " + dealer.showFirstCardNumber() + " of " + dealer.showFirstCardSuit() + ", ");
                                    System.out.print("the " + dealer.showSecondCardNumber() + " of " + dealer.showSecondCardSuit() + ", ");
                                    System.out.println("and the " + dealer.showThirdCardNumber() + " of " + dealer.showThirdCardSuit() + ".");
                                    System.out.println("I'm at " + dealer.getSumOfHand() + ", so you are the winner!");
                                }
                                else if (dealer.getSumOfHand() <= 21) {
                                    if (dealer.getSumOfHand() < 16) {
                                        deck.dealOneCardToDealer(dealer);
                                        if (dealer.getSumOfHand() > 21) {
                                            System.out.print("My cards are the " + dealer.showFirstCardNumber() + " of " + dealer.showFirstCardSuit() + ", ");
                                            System.out.print("the " + dealer.showSecondCardNumber() + " of " + dealer.showSecondCardSuit() + ", ");
                                            System.out.print("the " + dealer.showThirdCardNumber() + " of " + dealer.showThirdCardSuit());
                                            System.out.println(" and the " + dealer.showFourthCardNumber() + " of " + dealer.showFourthCardSuit() + ".");
                                            System.out.println("I'm at " + dealer.getSumOfHand() + ", so you are the winner!");
                                        }
                                        else if (dealer.getSumOfHand() <= 21) {
                                            System.out.print("My cards are the " + dealer.showFirstCardNumber() + " of " + dealer.showFirstCardSuit() + ", ");
                                            System.out.print("the " + dealer.showSecondCardNumber() + " of " + dealer.showSecondCardSuit() + ", ");
                                            System.out.print("the " + dealer.showThirdCardNumber() + " of " + dealer.showThirdCardSuit());
                                            System.out.println(" and the " + dealer.showFourthCardNumber() + " of " + dealer.showFourthCardSuit() + ".");
                                            System.out.println("I'm at " + dealer.getSumOfHand() + ", but I stop here, I'm a smart computer.");
                                            dealer.getSumOfHand();
                                            player.getSumOfHand();
                                            System.out.println(game.whoWins(dealer, player));
                                        }
                                        else {
                                            System.out.println("You shouldn't see this message.");
                                        }
                                    }
                                }
                                else {
                                    System.out.println("You shouldn't see this message.");
                                }
                            }
                            else if (dealer.getSumOfHand() >= 16) {
                                System.out.print("My cards are the " + dealer.showFirstCardNumber() + " of " + dealer.showFirstCardSuit() + ", ");
                                System.out.println("the " + dealer.showSecondCardNumber() + " of " + dealer.showSecondCardSuit() + ".");
                                System.out.println("I'm at " + dealer.getSumOfHand() + ".");
                                System.out.println(game.whoWins(dealer, player));
                            }
                            else {
                                System.out.println("You shouldn't see this message.");
                            }
                        }
                        else {
                            System.out.println("You shouldn't see this message.");
                        }
                    }
                    else {
                        System.out.println("You shouldn't see this message.");
                    }
                }
                else if (playerNextAnswer.equals("no")) {
                    System.out.println("Aaaaaalrighty then. You are at " + player.getSumOfHand() + ". Now take a look at my cards.");
                    dealer.getSumOfHand();
                    if (dealer.getSumOfHand() < 16) {
                        deck.dealOneCardToDealer(dealer);
                        if (dealer.getSumOfHand() > 21) {
                            System.out.print("My cards are the " + dealer.showFirstCardNumber() + " of " + dealer.showFirstCardSuit() + ", ");
                            System.out.print("the " + dealer.showSecondCardNumber() + " of " + dealer.showSecondCardSuit());
                            System.out.println(" and the " + dealer.showThirdCardNumber() + " of " + dealer.showThirdCardSuit() + ".");
                            System.out.println("I'm at " + dealer.getSumOfHand() + ", so you are the winner!");
                        }
                        else if (dealer.getSumOfHand() <= 21) {
                            if (dealer.getSumOfHand() < 16) {
                                deck.dealOneCardToDealer(dealer);
                                if (dealer.getSumOfHand() > 21) {
                                    System.out.print("My cards are the " + dealer.showFirstCardNumber() + " of " + dealer.showFirstCardSuit() + ", ");
                                    System.out.print("the " + dealer.showSecondCardNumber() + " of " + dealer.showSecondCardSuit() + ", ");
                                    System.out.print("the " + dealer.showThirdCardNumber() + " of " + dealer.showThirdCardSuit());
                                    System.out.println(" and the " + dealer.showFourthCardNumber() + " of " + dealer.showFourthCardSuit() + ".");
                                    System.out.println("I'm at " + dealer.getSumOfHand() + ", so you are the winner!");
                                }
                                else if (dealer.getSumOfHand() <= 21) {
                                    System.out.print("My cards are the " + dealer.showFirstCardNumber() + " of " + dealer.showFirstCardSuit() + ", ");
                                    System.out.print("the " + dealer.showSecondCardNumber() + " of " + dealer.showSecondCardSuit() + ", ");
                                    System.out.print("the " + dealer.showThirdCardNumber() + " of " + dealer.showThirdCardSuit());
                                    System.out.println(" and the " + dealer.showFourthCardNumber() + " of " + dealer.showFourthCardSuit() + ".");
                                    System.out.println("I'm at " + dealer.getSumOfHand() + ", but I stop here, I'm a smart computer.");
                                    System.out.println(game.whoWins(dealer, player));
                                }
                                else {
                                    System.out.println("You shouldn't see this message.");
                                }
                            }
                            else if (dealer.getSumOfHand() >= 16) {
                                System.out.print("My cards are the " + dealer.showFirstCardNumber() + " of " + dealer.showFirstCardSuit() + ", ");
                                System.out.print("the " + dealer.showSecondCardNumber() + " of " + dealer.showSecondCardSuit());
                                System.out.println(" and the " + dealer.showThirdCardNumber() + " of " + dealer.showThirdCardSuit());
                                System.out.println("I'm at " + dealer.getSumOfHand() + ".");
                                System.out.println(game.whoWins(dealer, player));
                            }
                            else {
                                System.out.println("You shouldn't see this message.");
                            }
                        }
                        else {
                            System.out.println("You shouldn't see this message.");
                        }
                    }
                    else if (dealer.getSumOfHand() >= 16) {
                        System.out.print("My cards are the " + dealer.showFirstCardNumber() + " of " + dealer.showFirstCardSuit() + ", ");
                        System.out.println("the " + dealer.showSecondCardNumber() + " of " + dealer.showSecondCardSuit() + ".");
                        System.out.println("I'm at " + dealer.getSumOfHand() + ".");
                        System.out.println(game.whoWins(dealer, player));
                    }
                    else {
                        System.out.println("You shouldn't see this message.");
                    }
                }
                else {
                    System.out.println("You shouldn't see this message.");
                }
            }
            else {
                System.out.println("You shouldn't see this message.");
            }
        }
        else if (playerAnswer.equals("stop")) {
            System.out.println("Aaaaaalrighty then. You are at " + player.getSumOfHand() + ". Now take a look at my cards.");
            dealer.getSumOfHand();
            if (dealer.getSumOfHand() < 16) {
                deck.dealOneCardToDealer(dealer);
                if (dealer.getSumOfHand() > 21) {
                    System.out.print("My cards are the " + dealer.showFirstCardNumber() + " of " + dealer.showFirstCardSuit() + ", ");
                    System.out.print("the " + dealer.showSecondCardNumber() + " of " + dealer.showSecondCardSuit());
                    System.out.println(" and the " + dealer.showThirdCardNumber() + " of " + dealer.showThirdCardSuit() + ".");
                    System.out.println("I'm at " + dealer.getSumOfHand() + ", so you are the winner!");
                }
                else if (dealer.getSumOfHand() <= 21) {
                    if (dealer.getSumOfHand() < 16) {
                        deck.dealOneCardToDealer(dealer);
                        if (dealer.getSumOfHand() > 21) {
                            System.out.print("My cards are the " + dealer.showFirstCardNumber() + " of " + dealer.showFirstCardSuit() + ", ");
                            System.out.print("the " + dealer.showSecondCardNumber() + " of " + dealer.showSecondCardSuit() + ", ");
                            System.out.print("the " + dealer.showThirdCardNumber() + " of " + dealer.showThirdCardSuit());
                            System.out.println(" and the " + dealer.showFourthCardNumber() + " of " + dealer.showFourthCardSuit() + ".");
                            System.out.println("I'm at " + dealer.getSumOfHand() + ", so you are the winner!");
                        }
                        else if (dealer.getSumOfHand() <= 21) {
                            System.out.print("My cards are the " + dealer.showFirstCardNumber() + " of " + dealer.showFirstCardSuit() + ", ");
                            System.out.print("the " + dealer.showSecondCardNumber() + " of " + dealer.showSecondCardSuit() + ", ");
                            System.out.print("the " + dealer.showThirdCardNumber() + " of " + dealer.showThirdCardSuit());
                            System.out.println(" and the " + dealer.showFourthCardNumber() + " of " + dealer.showFourthCardSuit() + ".");
                            System.out.println("I'm at " + dealer.getSumOfHand() + ", but I stop here, I'm a smart computer.");
                            System.out.println(game.whoWins(dealer, player));
                        }
                        else {
                            System.out.println("You shouldn't see this message.");
                        }
                    }
                    else if (dealer.getSumOfHand() >= 16) {
                        System.out.print("My cards are the " + dealer.showFirstCardNumber() + " of " + dealer.showFirstCardSuit() + ", ");
                        System.out.print("the " + dealer.showSecondCardNumber() + " of " + dealer.showSecondCardSuit());
                        System.out.println(" and the " + dealer.showThirdCardNumber() + " of " + dealer.showThirdCardSuit());
                        System.out.println("I'm at " + dealer.getSumOfHand() + ".");
                        System.out.println(game.whoWins(dealer, player));
                    }
                    else {
                        System.out.println("You shouldn't see this message.");
                    }
                }
                else {
                    System.out.println("You shouldn't see this message.");
                }
            }
            else if (dealer.getSumOfHand() >= 16) {
                System.out.print("My cards are the " + dealer.showFirstCardNumber() + " of " + dealer.showFirstCardSuit() + ", ");
                System.out.println("the " + dealer.showSecondCardNumber() + " of " + dealer.showSecondCardSuit() + ".");
                System.out.println("I'm at " + dealer.getSumOfHand() + ".");
                System.out.println(game.whoWins(dealer, player));
            }
            else {
                System.out.println("You shouldn't see this message.");
            }
        }
        else {
            System.out.println("You shouldn't see this message.");
        }
    }

}

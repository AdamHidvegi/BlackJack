import java.util.ArrayList;

public class Dealer {

    private ArrayList<Card> dealerHand;
    private String dealerName;

    public Dealer(String dealerName) {
        this.dealerHand = new ArrayList<Card>();
        this.dealerName = dealerName;
    }

    public String getName() {
        return this.dealerName;
    }

    public int checkHand() {
        return this.dealerHand.size();
    }

    public void addCardToHand(Card card) {
        this.dealerHand.add(card);
    }

    public int getSumOfHand() {
        int sumOfNumbers = 0;
        for (Card card : this.dealerHand) {
            sumOfNumbers += card.getRank();
        }
        return sumOfNumbers;
    }

//    public int valueOfAce() {
//        int modifiedAce = 0;
//        if (this.getSumOfHand() < 21 && this.dealerHand.contains(CardRank.ACE)) {
//            modifiedAce = CardRank.ACE.getSubValue();
//        }
//        return modifiedAce;
//    }

    public int showFirstCardNumber() {
        return this.dealerHand.get(0).getRank();
    }

    public int showSecondCardNumber() {
        return this.dealerHand.get(1).getRank();
    }

    public int showThirdCardNumber() {
        return this.dealerHand.get(2).getRank();
    }

    public int showFourthCardNumber() {
        return this.dealerHand.get(3).getRank();
    }

    public String showFirstCardSuit() {
        return this.dealerHand.get(0).getSuit();
    }

    public String showSecondCardSuit() {
        return this.dealerHand.get(1).getSuit();
    }

    public String showThirdCardSuit() {
        return this.dealerHand.get(2).getSuit();
    }

    public String showFourthCardSuit() {
        return this.dealerHand.get(3).getSuit();
    }

}

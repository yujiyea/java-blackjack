package blackjack;

import java.util.ArrayList;
import java.util.List;

public class User {

    private List<Card> cardList = new ArrayList<>();

    public User() {
    }

    public User(List<Card> cardList) {
        this.cardList = cardList;
    }

    public void receiveCard(Deck deck) {
        Card card = deck.drawCard();
        cardList.add(card);
    }

    public List<Card> getCardList() {
        return cardList;
    }

    public Boolean receivable(int value) {
        List<Integer> sum = new ArrayList<>();
        sum.add(0);

        for (Card card : cardList) {
            List<Integer> newSums = new ArrayList<>();
            for (Integer s : sum) {
                if (card.getNumber().equals(CardNumber.from("A"))) {
                    newSums.add(s + 1);
                    newSums.add(s + 11);
                    continue;
                }
                if (card.getNumber().equals(CardNumber.from("J")) ||
                        card.getNumber().equals(CardNumber.from("Q")) ||
                        card.getNumber().equals(CardNumber.from("K"))) {
                    newSums.add(s + 10);
                    continue;
                }
                newSums.add(s + Integer.parseInt(card.getNumber()));
            }
            sum = newSums;
        }
        return sum.stream().anyMatch(s -> s < value);
    }

}

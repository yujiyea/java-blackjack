package blackjack;

import java.util.ArrayList;
import java.util.List;

public class User {

    private List<Card> cardList = new ArrayList<>();

    public User() {
    }

    public void receiveCard(Deck deck) {
        Card card = deck.drawCard();
        cardList.add(card);
    }

    public List<Card> getCardList() {
        return cardList;
    }
}

package blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

    private static final int CARD_COUNT = 52;
    private List<Card> cardList;
    private int cardCnt;

    public Deck() {
        initializeDeck();
        shuffle();
        this.cardCnt = CARD_COUNT;
    }

    private void initializeDeck() {
        cardList = new ArrayList<>();
        for (CardPattern pattern : CardPattern.values()) {
            for (CardNumber number : CardNumber.values()) {
                cardList.add(new Card(number, pattern));
            }
        }
}

    private void shuffle() {
        Collections.shuffle(cardList);
    }

    public List<Card> getCardList() {
        return cardList;
    }

    public int getCardCnt() {
        return cardCnt;
    }

    public Card drawCard() {
        shuffle();
        return removeCard();
    }

    public Card removeCard() {
        cardCnt--;
        return cardList.remove(0);
    }
}
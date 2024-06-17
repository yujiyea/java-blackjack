package blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

    private static final int CARD_COUNT = 52;
    private List<Card> cards;
    private int cardCnt;

    public Deck() {
        initializeDeck();
        shuffle();
        this.cardCnt = CARD_COUNT;
    }

    private void initializeDeck() {
        cards = new ArrayList<>();
        for (CardPattern pattern : CardPattern.values()) {
            for (String number : CardNumber.getCardNumbers()) {
                cards.add(new Card(number, pattern));
            }
        }
}

    private void shuffle() {
        Collections.shuffle(cards);
    }

    public List<Card> getCards() {
        return cards;
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
        return cards.remove(0);
    }
}
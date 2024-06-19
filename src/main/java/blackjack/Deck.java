package blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

    private static final int CARD_COUNT = 52;
    private List<Card> cardList = new ArrayList<>();
    private int cardCnt;

    public Deck() {
        this.cardCnt = CARD_COUNT;
    }

    public Deck(List<Card> cardList) {
        this.cardList = cardList;
    }

    static {
        for (CardPattern pattern : CardPattern.values()) {
            for (CardNumber number : CardNumber.values()) {
//                cardList.add(new Card(number, pattern));
            }
        }
    }

    public List<Card> getCardList() {
        return cardList;
    }

    public int getCardCnt() {
        return cardCnt;
    }

    public Card drawCard() {
//        RandomShuffle.shuffle(cardList);
        return removeCard();
    }

    private Card removeCard() {
        cardCnt--;
        return cardList.remove(0);
    }
}
package blackjack;

import java.util.Collections;
import java.util.Random;

public class RandomDeckGenerator implements DeckGenerator{

    @Override
    public Deck generate() {
        Deck deck = new Deck();
        Collections.shuffle(deck.getCardList());
        return new Deck(deck.getCardList());
    }
}

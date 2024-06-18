package blackjack;

import java.util.List;
import java.util.function.Predicate;

public class Player extends User{
    private final String name;

    public Player(String name) {
        this.name = name;
    }

    public Player(List<Card> cardList, String name) {
        this.cardList = cardList;
        this.name = name;
    }

    @Override
    public List<Card> showCardList(Predicate<String> conditional) {
        return cardList;
    }
}

package blackjack;

import java.util.List;
import java.util.function.Predicate;

public class Player extends User{
    private final String name;
    private Boolean winStatus;

    public Player(String name) {
        this.name = name;
        this.winStatus = false;
    }

    public Player(List<Card> cardList, String name) {
        this.cardList = cardList;
        this.name = name;
        this.winStatus = false;
    }

    @Override
    public List<Card> showCardList(Predicate<String> conditional) {
        return cardList;
    }

    public void setWinStatus() {
        winStatus = true;
    }

    public String getName() {
        return name;
    }

    public Boolean getWinStatus() {
        return winStatus;
    }
}

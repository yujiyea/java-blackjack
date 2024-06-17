package blackjack;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class DeckTest {

    @Test
    @DisplayName("덱은 카드 52장을 갖는다.")
    void deck_has_52_cards() {
        Deck deck = new Deck();
        assertThat(deck.getCards()).hasSize(52);
    }

    @Test
    @DisplayName("덱에서 랜덤으로 카드를 뽑아서 지우면 덱은 카드 한 장을 잃는다.")
    void deck_draw() {
        Deck deck = new Deck();
        deck.drawCard();
        assertThat(deck.getCardCnt()).isEqualTo(51);
    }

}
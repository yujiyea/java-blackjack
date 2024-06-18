package blackjack;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CardTest {
    @Test
    @DisplayName("카드는 숫자와 문양을 갖는다.")
    void has_num_and_pattern(){

        Card card = new Card(CardNumber.THREE, CardPattern.CLOVER);

        assertThat(card.getPattern()).isEqualTo(CardPattern.CLOVER);
        assertThat(card.getNumber()).isEqualTo("3");
    }
}
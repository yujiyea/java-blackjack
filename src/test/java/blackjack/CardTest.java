package blackjack;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CardTest {
    @Test
    @DisplayName("카드는 숫자와 문양을 갖는다.")
    void has_num_and_pattern(){

        Card card = new Card(CardNumber.from("3"), CardPattern.CLOVER);

        assertThat(card.getPattern()).isEqualTo(CardPattern.CLOVER);
        assertThat(card.getNumber()).isEqualTo("3");
    }

    @Test
    @DisplayName("카드 번호는 정해진 수가 아니면 Exception이 발생한다.")
    void card_number_error() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> CardNumber.from("1"));
    }
}
package blackjack;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class UserTest {

    @Test
    @DisplayName("플레이어와 딜러는 게임 시작 시 두 장의 카드를 받는다.")
    void user_draws_card() {
        User player = new User();
        Deck deck = new Deck();
        player.receiveCard(deck);
        player.receiveCard(deck);
        assertThat(player.getCardList()).hasSize(2);
    }

    @Test
    @DisplayName("플레이어의 현재 카드의 합이 21초과인지 여부를 판단한다.")
    void user_card_sum_is_up_to_21() {
        User player = new User(java.util.List.of (
            new Card("1", CardPattern.CLOVER),
            new Card("2", CardPattern.HEART)
        ));
        Boolean receivable = player.receivable(21);
        assertThat(receivable).isTrue();
    }

}
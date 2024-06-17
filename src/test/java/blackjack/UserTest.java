package blackjack;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

}
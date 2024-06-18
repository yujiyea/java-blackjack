package blackjack;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

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
    @DisplayName("플레이어의 현재 카드의 합이 21이하인지 여부를 판단한다.")
    void user_card_sum_is_down_to_21() {
        User player = new User(java.util.List.of (
            new Card("1", CardPattern.CLOVER),
            new Card("2", CardPattern.HEART)
        ));
        Boolean receivable = player.receivable(21);
        assertThat(receivable).isTrue();
    }

    @Test
    @DisplayName("딜러의 현재 카드의 합이 16이하인지 여부를 판단한다.")
    void user_card_sum_is_down_to_16() {
        User dealer = new User(java.util.List.of (
                new Card("10", CardPattern.CLOVER),
                new Card("A", CardPattern.HEART)
        ));
        Boolean receivable = dealer.receivable(16);
        assertThat(receivable).isTrue();
    }

    @ParameterizedTest
    @DisplayName("유저의 카드 합을 더해서 최적의 결과 값을 도출한다.")
    @MethodSource("generateData")
    void user_best_result(User user, int result){
        int bestResult = user.getBestResult();

        assertThat(bestResult).isEqualTo(result);
    }


    static Stream<Arguments> generateData(){
        return Stream.of(
                Arguments.of(new User(List.of (
                        new Card("10", CardPattern.CLOVER),
                        new Card("5", CardPattern.HEART),
                        new Card("A", CardPattern.CLOVER)
                )), 16),
                Arguments.of(new User(List.of (
                        new Card("10", CardPattern.CLOVER),
                        new Card("J", CardPattern.HEART),
                        new Card("Q", CardPattern.CLOVER)
                )), 30)
        );
    }
}
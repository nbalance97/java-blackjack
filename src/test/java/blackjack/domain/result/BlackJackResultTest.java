package blackjack.domain.result;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BlackJackResultTest {

    @Test
    @DisplayName("승/무/패의 반대를 반환하는 메소드")
    void reversed() {
        assertThat(BlackJackResult.LOSE.reversed()).isEqualTo(BlackJackResult.WIN);
        assertThat(BlackJackResult.WIN.reversed()).isEqualTo(BlackJackResult.LOSE);
        assertThat(BlackJackResult.DRAW.reversed()).isEqualTo(BlackJackResult.DRAW);
    }
}
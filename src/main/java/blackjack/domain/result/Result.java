package blackjack.domain.result;

import java.util.Arrays;

public enum Result {

    LOSE("패", (userScore, dealerScore) -> userScore > 21 || (dealerScore <= 21 && userScore < dealerScore)),
    WIN("승", (userScore, dealerScore) -> dealerScore > 21 || userScore > dealerScore),
    DRAW("무", (userScore, dealerScore) -> userScore == dealerScore);

    private String name;
    private ScoreComparator comparator;

    Result(String name, ScoreComparator comparator) {
        this.name = name;
        this.comparator = comparator;
    }

    public static Result checkUserResult(int userScore, int dealerScore) {
        return Arrays.stream(values())
                .filter(result -> result.compare(userScore, dealerScore))
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }

    public static Result swap(Result result) {
        if (result == WIN) {
            return LOSE;
        }
        if (result == LOSE) {
            return WIN;
        }
        return result;
    }

    public boolean isWin() {
        return this == Result.WIN;
    }

    private boolean compare(int userScore, int dealerScore) {
        return comparator.compare(userScore, dealerScore);
    }

    public String getName() {
        return name;
    }
}

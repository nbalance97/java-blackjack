package domain.gamer;

import domain.card.Card;
import domain.card.providable.CardProvidable;
import domain.result.Score;
import domain.result.WinLose;

import java.util.List;

public interface Gamer {
    void drawInitialCards(CardProvidable cardProvidable);

    void drawCard(CardProvidable cardProvidable);

    boolean canDrawMore();

    List<Card> openInitialCards();

    List<Card> openAllCards();

    Score calculateScore();

    boolean isBurst();

    WinLose determineWinLose(Gamer counterParts);
}
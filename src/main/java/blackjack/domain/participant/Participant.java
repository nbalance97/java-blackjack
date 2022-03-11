package blackjack.domain.participant;

import blackjack.domain.card.Card;
import blackjack.domain.result.ScoreCalculator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Participant {

    protected final List<Card> cards;

    public Participant() {
        cards = new ArrayList<>();
    }

    public void receiveCard(Card card) {
        cards.add(card);
    }

    public List<Card> getCards() {
        return Collections.unmodifiableList(cards);
    }

    public int getCardSum() {
        return ScoreCalculator.cardSum(cards);
    }
}

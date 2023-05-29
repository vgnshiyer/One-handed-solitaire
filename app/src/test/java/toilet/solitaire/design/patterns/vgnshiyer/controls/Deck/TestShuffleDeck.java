package toilet.solitaire.design.patterns.vgnshiyer.controls.Deck;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import toilet.solitaire.design.patterns.vgnshiyer.models.Card;
import toilet.solitaire.design.patterns.vgnshiyer.models.Deck;

public class TestShuffleDeck {
    Deck deck = Deck.getInstance();

    @Test
    public void test_shuffle_deck(){
        List<Card> initial_deck = new ArrayList<Card>(deck.cards);

        (new ShuffleDeck()).execute();
        assertNotEquals(initial_deck, deck.cards);
    }
}

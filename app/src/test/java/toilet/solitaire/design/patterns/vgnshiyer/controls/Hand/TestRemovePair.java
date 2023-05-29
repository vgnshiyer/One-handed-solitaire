package toilet.solitaire.design.patterns.vgnshiyer.controls.Hand;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import toilet.solitaire.design.patterns.vgnshiyer.controls.Deck.ShuffleDeck;
import toilet.solitaire.design.patterns.vgnshiyer.models.Card;
import toilet.solitaire.design.patterns.vgnshiyer.models.Deck;
import toilet.solitaire.design.patterns.vgnshiyer.models.Game;

public class TestRemovePair {
    
    Deck deck = Deck.getInstance();
    Game game = Game.getInstance();

    @Test
    public void test_remove_pair(){
        int id1 = 0;
        int id2 = 1;
        game.hand = 7;

        (new ShuffleDeck()).execute();

        Card card1 = deck.cards.get(0);
        Card card2 = deck.cards.get(1);

        (new RemovePair(id1, id2)).execute();

        assertTrue(!deck.cards.contains(card1));
        assertTrue(!deck.cards.contains(card2));
        assertEquals(5, game.hand);
    }
}

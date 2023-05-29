package toilet.solitaire.design.patterns.vgnshiyer.controls.Hand;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import toilet.solitaire.design.patterns.vgnshiyer.controls.Deck.ShuffleDeck;
import toilet.solitaire.design.patterns.vgnshiyer.models.Card;
import toilet.solitaire.design.patterns.vgnshiyer.models.Deck;
import toilet.solitaire.design.patterns.vgnshiyer.models.Game;

public class TestRemoveMiddle {

    Deck deck = Deck.getInstance();
    Game game = Game.getInstance();
    
    @Test
    public void test_remove_middle_pair(){
        (new ShuffleDeck()).execute();
        game.hand = 7;

        Card card2 = deck.cards.get(1);
        Card card3 = deck.cards.get(2);

        (new RemoveMiddlePair()).execute();

        assertTrue(!deck.cards.contains(card2));
        assertTrue(!deck.cards.contains(card3));
        assertEquals(5, game.hand);
    }
}

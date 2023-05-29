package toilet.solitaire.design.patterns.vgnshiyer.controls.Hand;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import toilet.solitaire.design.patterns.vgnshiyer.controls.Deck.ShuffleDeck;
import toilet.solitaire.design.patterns.vgnshiyer.models.Card;
import toilet.solitaire.design.patterns.vgnshiyer.models.Deck;
import toilet.solitaire.design.patterns.vgnshiyer.models.Game;

public class TestRemoveAllFour {
    
    Deck deck = Deck.getInstance();
    Game game = Game.getInstance();

    @Test
    public void test_remove_all_four(){
        (new ShuffleDeck()).execute();
        game.hand = 7;

        Card card1 = deck.cards.get(0);
        Card card2 = deck.cards.get(1);
        Card card3 = deck.cards.get(2);
        Card card4 = deck.cards.get(3);

        (new RemoveAllFour()).execute();

        assertTrue(!deck.cards.contains(card1));
        assertTrue(!deck.cards.contains(card2));
        assertTrue(!deck.cards.contains(card3));
        assertTrue(!deck.cards.contains(card4));
        assertEquals(3, game.hand);
    }

}

package toilet.solitaire.design.patterns.vgnshiyer.controls.Game;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import toilet.solitaire.design.patterns.vgnshiyer.models.Card;
import toilet.solitaire.design.patterns.vgnshiyer.models.Deck;
import toilet.solitaire.design.patterns.vgnshiyer.models.Game;

public class TestGenerateHand {
    
    Deck deck = Deck.getInstance();
    Game game = Game.getInstance();

    @Test
    public void test_generate_hand() throws IOException{
        game.hand = 2;

        Card c2 = deck.cards.get(deck.cards.size() - 1);
        Card c1 = deck.cards.get(deck.cards.size() - 2);
        
        (new GenerateHand()).execute();

        assertEquals(c1, deck.cards.get(0));
        assertEquals(c2, deck.cards.get(1));
        assertEquals(4, game.hand);
    }
}

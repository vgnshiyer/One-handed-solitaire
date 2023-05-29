package toilet.solitaire.design.patterns.vgnshiyer.controls.Game;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.util.Map;

import org.junit.jupiter.api.Test;

import toilet.solitaire.design.patterns.vgnshiyer.models.Card;
import toilet.solitaire.design.patterns.vgnshiyer.models.Deck;
import toilet.solitaire.design.patterns.vgnshiyer.models.Game;
import toilet.solitaire.design.patterns.vgnshiyer.models.enums.Suits;

public class TestGetMoves {
    
    Deck deck = Deck.getInstance();
    Game game = Game.getInstance();
    @Test
    public void test_middle_two() throws IOException{
        game.hand = 5;
        // case: top and bottom cards are of the same suit
        Card testCard1 = new Card(2, Suits.Hearts);
        Card testCard2 = new Card(4, Suits.Hearts);

        deck.cards.set(0, testCard1);
        deck.cards.set(3, testCard2);

        (new GetMoves()).execute();

        Map<Integer, String> moves = game.getMoves();
        assertTrue(moves.containsValue("remove_middle_two"));
        assertTrue(moves.containsValue("deal"));
        assertTrue(moves.containsValue("exit"));
    }

    @Test
    public void test_all_four() throws IOException{
        game.hand = 5;
        // case: top and bottom cards are of the same rank
        Card testCard1 = new Card(2, Suits.Hearts);
        Card testCard2 = new Card(2, Suits.Diamonds);

        deck.cards.set(0, testCard1);
        deck.cards.set(3, testCard2);

        (new GetMoves()).execute();

        Map<Integer, String> moves = game.getMoves();
        assertTrue(moves.containsValue("remove_four"));
        assertTrue(moves.containsValue("deal"));
        assertTrue(moves.containsValue("exit"));
    }

    @Test
    public void test_pair() throws IOException{
        game.hand = 5;
        // case: first two cards are of the same rank
        Card testCard1 = new Card(2, Suits.Hearts);
        Card testCard2 = new Card(2, Suits.Diamonds);

        deck.cards.set(0, testCard1);
        deck.cards.set(1, testCard2);

        (new GetMoves()).execute();

        Map<Integer, String> moves = game.getMoves();
        assertTrue(moves.containsValue("remove_1&2"));
        assertTrue(moves.containsValue("deal"));
        assertTrue(moves.containsValue("exit"));
    }

    @Test
    public void test_top_three() throws IOException{
        game.hand = 5;
        // case: first two cards are of the same rank
        Card testCard1 = new Card(2, Suits.Hearts);
        Card testCard2 = new Card(2, Suits.Diamonds);
        Card testCard3 = new Card(6, Suits.Hearts);

        deck.cards.set(0, testCard1);
        deck.cards.set(1, testCard2);
        deck.cards.set(3, testCard3);

        (new GetMoves()).execute();

        Map<Integer, String> moves = game.getMoves();
        assertTrue(moves.containsValue("top_three"));
        assertTrue(moves.containsValue("deal"));
        assertTrue(moves.containsValue("exit"));
    }

    @Test
    public void test_bottom_three() throws IOException{
        game.hand = 5;
        // case: first two cards are of the same rank
        Card testCard1 = new Card(2, Suits.Hearts);
        Card testCard2 = new Card(6, Suits.Diamonds);
        Card testCard3 = new Card(6, Suits.Hearts);

        deck.cards.set(0, testCard1);
        deck.cards.set(2, testCard2);
        deck.cards.set(3, testCard3);

        (new GetMoves()).execute();

        Map<Integer, String> moves = game.getMoves();
        assertTrue(moves.containsValue("last_three"));
        assertTrue(moves.containsValue("deal"));
        assertTrue(moves.containsValue("exit"));
    }
}

package toilet.solitaire.design.patterns.vgnshiyer.controls.Deck;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.IOException;
import org.junit.jupiter.api.Test;

import toilet.solitaire.design.patterns.vgnshiyer.models.Card;
import toilet.solitaire.design.patterns.vgnshiyer.models.Deck;

public class TestDeal {
    static Deck deck = Deck.getInstance();

    @Test
    public void test_deal_deck() throws IOException{
        int num = 1;
        Card last_card = deck.cards.get(deck.cards.size() - 1);
        
        (new Deal(num)).execute();
        Card first_card = deck.cards.get(0);

        assertEquals(last_card, first_card);
    }

    @Test
    public void test_deal_with_invalid_input(){
        int num = 5;
        
        IOException exception = assertThrows(IOException.class, () -> (new Deal(num)).execute());
        assertEquals("You can only draw at most four cards and at least one card", exception.getMessage());
    } 
}

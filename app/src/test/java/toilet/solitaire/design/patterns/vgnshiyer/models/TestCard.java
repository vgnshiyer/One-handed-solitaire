package toilet.solitaire.design.patterns.vgnshiyer.models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import toilet.solitaire.design.patterns.vgnshiyer.models.enums.Suits;

public class TestCard {
    static Card card = new Card();

    @BeforeAll
    public static void initData(){
        card.setValue(14);
        card.setSuit(Suits.Hearts);
    }

    @Test
    public void test_check_value(){
        assertEquals(14, card.getValue());
    }

    @Test
    public void test_check_suit(){
        assertEquals(Suits.Hearts, card.getSuit());
    }

    @Test
    public void test_named_value(){
        String name = card.namedValue();
        assertEquals("Ace", name);
    }

    @Test
    public void test_card_description(){
        String description = card.getCardDescription();
        assertEquals("Ace of Hearts", description);
    }

    @Test
    public void test_rank(){
        Character rank = card.getRank();
        assertEquals('A',rank);
    }
}

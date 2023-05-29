package toilet.solitaire.design.patterns.vgnshiyer.models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TestGame {
    Game game = Game.getInstance();

    @Test
    public void test_game_set_difficulty(){
        game.setDifficulty(1);

        assertEquals(game.getDifficulty(), 1);
    }

    @Test
    public void test_hand(){
        game.hand = 3;
        assertEquals(game.hand, 3);
    }
    
    @Test
    public void test_counter(){
        game.counter  = 15;
        assertEquals(game.counter, 15);
    }
    
}

package toilet.solitaire.design.patterns.vgnshiyer.controls.Game;

import java.io.IOException;

import toilet.solitaire.design.patterns.vgnshiyer.controls.Command;
import toilet.solitaire.design.patterns.vgnshiyer.controls.Deck.Deal;
import toilet.solitaire.design.patterns.vgnshiyer.models.Deck;
import toilet.solitaire.design.patterns.vgnshiyer.models.Game;

/* a command that fills the hand with the remaining cards */
public class GenerateHand implements Command {

    Deck deck = Deck.getInstance();
    Game game = Game.getInstance();

    @Override
    public void execute() throws IOException {
        if(game.hand < 4){
            int remaining = Math.min(4 - game.hand, deck.deck_size);
            (new Deal(remaining)).execute();
            game.hand += remaining;
        } else {
            (new Deal(1)).execute();
            if(deck.deck_size >= 0) game.hand++;
        }
    }
}

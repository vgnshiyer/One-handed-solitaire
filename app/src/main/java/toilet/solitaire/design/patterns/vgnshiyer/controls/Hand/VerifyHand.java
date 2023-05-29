package toilet.solitaire.design.patterns.vgnshiyer.controls.Hand;

import toilet.solitaire.design.patterns.vgnshiyer.controls.Command;
import toilet.solitaire.design.patterns.vgnshiyer.models.Deck;
import toilet.solitaire.design.patterns.vgnshiyer.models.Game;

/* validates the hand with the stopping condition */
public class VerifyHand implements Command {
    static int prev_hand = -1;
    Deck deck = Deck.getInstance();
    Game game = Game.getInstance();

    @Override
    public void execute() {
        if(game.hand < 4){
            if(deck.deck_size <= 0){
                game.gameover = true;
                return;
            }
        }

        if(deck.deck_size <= 0){
            if(game.hand < prev_hand) game.counter = 0;
            if(game.counter == 0) prev_hand = game.hand;

            if(prev_hand == game.hand) game.counter += 1;

            if(game.counter == game.hand + 1){
                game.gameover = true;
                return;
            }
        }
    }
}

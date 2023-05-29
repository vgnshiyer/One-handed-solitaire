package toilet.solitaire.design.patterns.vgnshiyer.controls.Hand;

import toilet.solitaire.design.patterns.vgnshiyer.controls.Command;
import toilet.solitaire.design.patterns.vgnshiyer.models.Deck;
import toilet.solitaire.design.patterns.vgnshiyer.models.Game;
import toilet.solitaire.design.patterns.vgnshiyer.models.Waste;

/* remove top three cards from the hand */
public class RemoveTopThree implements Command {

    Deck deck = Deck.getInstance();

    @Override
    public void execute() {
        deck.cards.remove(deck.cards.get(2));
        deck.cards.remove(deck.cards.get(1));
        Waste.setTopCard(deck.cards.get(0));
        deck.cards.remove(deck.cards.get(0));

        Game.getInstance().hand -= 3;
    }
}

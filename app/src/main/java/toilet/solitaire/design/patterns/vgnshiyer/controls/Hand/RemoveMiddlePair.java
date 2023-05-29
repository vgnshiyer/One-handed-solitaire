package toilet.solitaire.design.patterns.vgnshiyer.controls.Hand;

import toilet.solitaire.design.patterns.vgnshiyer.controls.Command;
import toilet.solitaire.design.patterns.vgnshiyer.models.Card;
import toilet.solitaire.design.patterns.vgnshiyer.models.Deck;
import toilet.solitaire.design.patterns.vgnshiyer.models.Game;
import toilet.solitaire.design.patterns.vgnshiyer.models.Waste;

/* removes middle pair from the hand */
public class RemoveMiddlePair implements Command {

    Deck deck = Deck.getInstance();

    @Override
    public void execute() {
        // remove 2nd and 3rd card from the top four in the deck
        Card card2 = deck.cards.get(2);
        Card card3 = deck.cards.get(1);
        deck.cards.remove(card2);
        Waste.setTopCard(card3);
        deck.cards.remove(card3);

        Game.getInstance().hand -= 2;
    }
}

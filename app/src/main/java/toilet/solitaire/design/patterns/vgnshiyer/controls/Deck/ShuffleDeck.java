package toilet.solitaire.design.patterns.vgnshiyer.controls.Deck;

import java.util.Collections;

import toilet.solitaire.design.patterns.vgnshiyer.controls.Command;
import toilet.solitaire.design.patterns.vgnshiyer.models.Deck;

public class ShuffleDeck implements Command {

    Deck deck = Deck.getInstance();

    @Override
    public void execute() {
        Collections.shuffle(deck.cards);
    }
}

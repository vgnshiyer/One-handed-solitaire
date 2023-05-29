package toilet.solitaire.design.patterns.vgnshiyer.controls.Deck;

import java.io.IOException;
import java.util.List;

import toilet.solitaire.design.patterns.vgnshiyer.controls.Command;
import toilet.solitaire.design.patterns.vgnshiyer.models.Card;
import toilet.solitaire.design.patterns.vgnshiyer.models.Deck;
import toilet.solitaire.design.patterns.vgnshiyer.models.enums.Suits;

public class FillDeck implements Command {

    Deck deck = Deck.getInstance();

    /* initialize the deck */
    @Override
    public void execute() throws IOException {
        List<Card> cards = deck.cards;

        for(int i = 0; i < 52; i++){
            Suits suit = Suits.fromValue(i / 13);
            int val = i % 13 + 2;
            cards.add(new Card(val, suit));
        }
    }
}

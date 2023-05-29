package toilet.solitaire.design.patterns.vgnshiyer.controls.Deck;

import java.io.IOException;
import java.util.Collections;

import toilet.solitaire.design.patterns.vgnshiyer.controls.Command;
import toilet.solitaire.design.patterns.vgnshiyer.models.Deck;

public class Deal implements Command {

    Deck deck = Deck.getInstance();
    int num_cards = 0;

    public Deal(int num_cards) throws IOException {
        if(num_cards > 4 || num_cards < 1){
            throw new IOException("You can only draw at most four cards and at least one card");
        }
        this.num_cards = num_cards;
    }

    /* deal a card from the back of the deck */
    @Override
    public void execute() {
        Collections.rotate(deck.cards, num_cards);
        deck.deck_size -= num_cards;
    }
}

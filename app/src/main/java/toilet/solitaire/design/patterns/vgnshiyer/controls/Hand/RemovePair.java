package toilet.solitaire.design.patterns.vgnshiyer.controls.Hand;

import toilet.solitaire.design.patterns.vgnshiyer.controls.Command;
import toilet.solitaire.design.patterns.vgnshiyer.models.Card;
import toilet.solitaire.design.patterns.vgnshiyer.models.Deck;
import toilet.solitaire.design.patterns.vgnshiyer.models.Game;
import toilet.solitaire.design.patterns.vgnshiyer.models.Waste;

/* removes a pair of cards from the hand */
public class RemovePair implements Command {

    Deck deck = Deck.getInstance();
    int id1 = -1;
    int id2 = -1;

    public RemovePair(int id1, int id2) {
        if(id2 < id1){
            int temp = id2;
            id2 = id1;
            id1 = temp;
        }
        this.id1 = id1;
        this.id2 = id2;
    }

    @Override
    public void execute() {
        // remove 2nd and 3rd card from the top four in the deck
        Card card1 = deck.cards.get(id2);
        Card card2 = deck.cards.get(id1);
        deck.cards.remove(card1);
        Waste.setTopCard(card2);
        deck.cards.remove(card2);

        Game.getInstance().hand -= 2;
    }
}

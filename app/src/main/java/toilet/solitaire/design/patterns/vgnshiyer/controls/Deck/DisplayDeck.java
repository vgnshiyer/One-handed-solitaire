package toilet.solitaire.design.patterns.vgnshiyer.controls.Deck;

import toilet.solitaire.design.patterns.vgnshiyer.ColorCodes;
import toilet.solitaire.design.patterns.vgnshiyer.controls.Command;
import toilet.solitaire.design.patterns.vgnshiyer.models.Card;
import toilet.solitaire.design.patterns.vgnshiyer.models.Deck;
import toilet.solitaire.design.patterns.vgnshiyer.models.enums.Suits;

public class DisplayDeck implements Command{

    Deck deck = Deck.getInstance();
    Boolean printShort = false;

    public DisplayDeck(Boolean printShort) {
        this.printShort = printShort;
    }

    /* simply prints the deck (used for debugging purposes) */
    @Override
    public void execute() {
        var cards = deck.cards;

        if(printShort){
            for(Card card : cards){
                int s = card.getSuit().getValue();
                System.out.print(ColorCodes.BLUE + card.getRank() + Suits.shortValues.get(s) + ColorCodes.RESET + " ");
            }
        } else {
            for(Card card : cards){
                System.out.print(ColorCodes.BLUE + card.getCardDescription() + ColorCodes.RESET + " ");
            }    
        }
    }
}

package toilet.solitaire.design.patterns.vgnshiyer.views;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import toilet.solitaire.design.patterns.vgnshiyer.ColorCodes;
import toilet.solitaire.design.patterns.vgnshiyer.models.Card;
import toilet.solitaire.design.patterns.vgnshiyer.models.Deck;
import toilet.solitaire.design.patterns.vgnshiyer.models.Game;
import toilet.solitaire.design.patterns.vgnshiyer.models.enums.Suits;
import toilet.solitaire.design.patterns.vgnshiyer.models.services.CardDisplay;

/* a subclass using the view template */
public class HandView extends View{

    Deck deck = Deck.getInstance();
    Game game = Game.getInstance();

    /* display the hand cards in short format,. eg. 5H,7S,... */
    private void display_short_hand(List<Character> ranks, List<Character> suits, int n){
        System.out.print(ColorCodes.PURPLE + "Cards: " + ColorCodes.RESET);
        for(int i = 0; i < n; i++){
            Character rank = ranks.get(i);
            Character suit = suits.get(i);
            System.out.print(ColorCodes.BLUE + rank + suit + " " + ColorCodes.RESET);
        }
        System.out.println();
    }

    /* Displays the running score */
    private void display_running_score(){
        System.out.print(ColorCodes.YELLOW + "Running score: " + ColorCodes.GREEN + game.hand + ColorCodes.RESET);
        System.out.println("     " + ColorCodes.YELLOW + "Cards in deck: " + ColorCodes.GREEN + Math.max(0,deck.deck_size) + ColorCodes.RESET);
        System.out.println("--------------------------------------------------------------------------");
    }

    @Override
    public void view() throws IOException {
        System.out.println(ColorCodes.BLUE + "My hand: " + ColorCodes.RESET);
        List<Character> ranks = new ArrayList<>();
        List<Character> suits = new ArrayList<>();
        List<Card> cards = deck.cards;
        for(int i = 0; i < Math.min(4,game.hand); i++){
            Card card = cards.get(i);
            ranks.add(card.getRank());
            suits.add(Suits.shortValues.get(card.getSuit().getValue()));
        }
        (new CardDisplay(ranks, suits)).execute();

        display_short_hand(ranks, suits, Math.min(4, game.hand));

        display_running_score();
    }
}

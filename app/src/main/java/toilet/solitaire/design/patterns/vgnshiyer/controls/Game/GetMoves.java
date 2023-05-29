package toilet.solitaire.design.patterns.vgnshiyer.controls.Game;

import java.util.HashMap;
import java.util.Map;

import toilet.solitaire.design.patterns.vgnshiyer.controls.Command;
import toilet.solitaire.design.patterns.vgnshiyer.models.Card;
import toilet.solitaire.design.patterns.vgnshiyer.models.Deck;
import toilet.solitaire.design.patterns.vgnshiyer.models.Game;

/* a command that validates the hand and returns the available moves */
public class GetMoves implements Command {

    Deck deck = Deck.getInstance();
    Game game = Game.getInstance();
    Map<Integer, String> moves = new HashMap<Integer, String>();

    @Override
    public void execute() {
        int id = 1;
        moves.put(id++, "deal");

        if(game.hand >= 4){
            Card card1 = deck.cards.get(0);
            Card card2 = deck.cards.get(1);
            Card card3 = deck.cards.get(2);
            Card card4 = deck.cards.get(3);

            if(card1.getSuit().equals(card4.getSuit())){
                moves.put(id++, "remove_middle_two");
                if(game.getDifficulty() == 3){
                    if(card1.getValue() == card2.getValue()) moves.put(id++, "top_three");
                    if(card3.getValue() == card4.getValue()) moves.put(id++, "last_three");
                }
            }
            if(card1.getValue() == card4.getValue()) moves.put(id++, "remove_four");

            if(game.getDifficulty() == 2 || game.getDifficulty() == 3){
                if(card2.getValue() == card1.getValue()) moves.put(id++, "remove_1&2");
                if(card3.getValue() == card2.getValue()) moves.put(id++, "remove_2&3");
                if(card4.getValue() == card3.getValue()) moves.put(id++, "remove_3&4");
            }
        }
        moves.put(id++, "exit");
        game.setMoves(moves);
    }
}

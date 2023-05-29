package toilet.solitaire.design.patterns.vgnshiyer.views;

import java.io.IOException;

import toilet.solitaire.design.patterns.vgnshiyer.ColorCodes;
import toilet.solitaire.design.patterns.vgnshiyer.models.Game;

/* a subclass using the view template */
public class AvailableMovesView extends View{

    /* displays the moves available at any point of time */
    @Override
    public void view() throws IOException {
        reader.println();
        reader.println(ColorCodes.PURPLE + "You can perform one of the below moves:" + ColorCodes.RESET);
        reader.print(ColorCodes.BLUE);
        var moves = Game.getInstance().getMoves();

        int len = moves.size();
        for(int i = 1; i <= len; i++){
            reader.println(i + ". " + moves.get(i));
        }
        reader.println(ColorCodes.RESET);
    }
}

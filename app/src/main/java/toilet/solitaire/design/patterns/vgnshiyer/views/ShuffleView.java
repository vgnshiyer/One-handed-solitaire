package toilet.solitaire.design.patterns.vgnshiyer.views;

import java.io.IOException;

import toilet.solitaire.design.patterns.vgnshiyer.ColorCodes;
import toilet.solitaire.design.patterns.vgnshiyer.controls.CommandFactory;
import toilet.solitaire.design.patterns.vgnshiyer.controls.Deck.ShuffleDeck;

/* a subclass using the view template */
public class ShuffleView extends View{

    @Override
    public void view() throws IOException {
        String line; 

        System.out.println(ColorCodes.BLUE + "\nDo you want to shuffle the deck before we start the game?" + ColorCodes.PURPLE + " [y/n]" + ColorCodes.RESET);
        while((line = reader.readLine()) != null){
            line = line.trim();

            if(line.equals("y") || line.equals("Y")){
                CommandFactory.getCommand("shuffle").execute();
                reader.setPrompt(ColorCodes.BLUE + "more? " + ColorCodes.RESET);
            } else if(line.equals("n") || line.equals("N")){
                reader.setPrompt("");
                break;
            } else {
                System.out.println(ColorCodes.RED + "Invalid Input!" + ColorCodes.RESET);
            }
        }
    }
}

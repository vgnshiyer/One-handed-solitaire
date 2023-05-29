package toilet.solitaire.design.patterns.vgnshiyer.views;

import java.io.IOException;

import toilet.solitaire.design.patterns.vgnshiyer.ColorCodes;
import toilet.solitaire.design.patterns.vgnshiyer.models.Deck;
import toilet.solitaire.design.patterns.vgnshiyer.models.Game;
import toilet.solitaire.design.patterns.vgnshiyer.models.services.AsciiText;

/* a subclass using the view template */
public class GameResultView extends View{
    int hand = Game.getInstance().hand;
    Deck deck = Deck.getInstance();

    /* Display cards in long format */
    private void display_long(int n){
        for(int i = 0; i < n; i++){
            String card_description = deck.cards.get(i).getCardDescription();
            System.out.print(ColorCodes.BLUE + card_description);
            if(i < n) System.out.print(", ");
            else System.out.print(" ");
        }
        System.out.println(ColorCodes.RESET);
    }

    /* Displays the result of the game */
    @Override
    public void view() throws IOException {
        if(hand == 0 || hand == 1){
            System.out.println(AsciiText.SUPERWIN);
            System.out.println();
            System.out.println(ColorCodes.GREEN + "Congratulations!" + ColorCodes.RESET);
        } else if(hand <= 4){
            System.out.println(AsciiText.WIN);
            System.out.println();
            System.out.println(ColorCodes.BLUE + "Congratulations" + ColorCodes.RESET);
        } else{
            System.out.println(AsciiText.LOSE);
            System.out.println();
            System.out.println(ColorCodes.RED + "You ran out of moves. Better luck next time." + ColorCodes.RESET);
        }
        System.out.print(ColorCodes.PURPLE + "Your final score: " + hand + ColorCodes.RESET);
    
        System.out.println(ColorCodes.PURPLE + "\n\nYour final hand: " + ColorCodes.RESET);
        display_long(hand);
    
        String line;
        reader.println(ColorCodes.BLUE + "\n\nPlay again? [y/n]" + ColorCodes.RESET);
        reader.setPrompt("==> ");
        while((line = reader.readLine()) != null){
            line = line.trim();
            
            if(line.equals("y") || line.equals("Y")){
                break;
            } else if(line.equals("n") || line.equals("N")){
                System.out.println(ColorCodes.BLUE + "Goodbye!.." + ColorCodes.RESET);
                System.exit(0);
            } else {
                reader.println(ColorCodes.RED + "Invalid input!" + ColorCodes.RESET);
            }
        }
        reader.setPrompt("");
    }
}

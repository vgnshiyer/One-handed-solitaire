package toilet.solitaire.design.patterns.vgnshiyer.controls.Game;

import java.io.IOException;

import toilet.solitaire.design.patterns.vgnshiyer.ColorCodes;
import toilet.solitaire.design.patterns.vgnshiyer.controls.Command;
import toilet.solitaire.design.patterns.vgnshiyer.models.Game;
import jline.console.ConsoleReader;

public class SelectMove implements Command{

    ConsoleReader reader;

    public SelectMove(ConsoleReader reader){
        this.reader = reader;
    }

    /* mark a action for execution */
    @Override
    public void execute() throws IOException {
        int move;

        String line;
        
        reader.setPrompt(ColorCodes.BLUE + "Select move: " + ColorCodes.RESET);
        while((line = reader.readLine()) != null){
            line = line.trim();

            try {
                move = Integer.parseInt(line);
                if(move < 1 || move > Game.getInstance().getMoves().size()){
                    reader.println(ColorCodes.RED + "Please input a valid choice." + ColorCodes.RESET);
                } else {
                    Game.getInstance().setCurrentMove(move);
                    break;
                }
            } catch (NumberFormatException e) {
                reader.println(ColorCodes.RED + "Please input a valid choice." + ColorCodes.RESET);
            }
        }
    }
}

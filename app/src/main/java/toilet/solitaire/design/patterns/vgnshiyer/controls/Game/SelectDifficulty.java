package toilet.solitaire.design.patterns.vgnshiyer.controls.Game;

import java.io.IOException;

import jline.console.ConsoleReader;
import toilet.solitaire.design.patterns.vgnshiyer.ColorCodes;
import toilet.solitaire.design.patterns.vgnshiyer.controls.Command;
import toilet.solitaire.design.patterns.vgnshiyer.models.Game;

public class SelectDifficulty implements Command {

    ConsoleReader reader;

    public SelectDifficulty(ConsoleReader reader) {
        this.reader = reader;
    }

    /* select game difficulty level from the user */
    @Override
    public void execute() throws IOException {
        int choice;
        String line;
        
        reader.setPrompt(ColorCodes.BLUE + "Select difficulty level: " + ColorCodes.RESET);
        while((line = reader.readLine()) != null){
            line = line.trim();

            try {
                choice = Integer.parseInt(line);
                if(choice > 3 || choice < 1){
                    reader.println(ColorCodes.RED + "Please input a valid choice." + ColorCodes.RESET);
                } else {
                    Game.getInstance().setDifficulty(choice);
                    break;
                }
            } catch (NumberFormatException e) {
                reader.println(ColorCodes.RED + "Please input a valid choice." + ColorCodes.RESET);
            }
        }
        reader.setPrompt("");
    }
}

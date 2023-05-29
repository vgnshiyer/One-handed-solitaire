package toilet.solitaire.design.patterns.vgnshiyer.controls.Game;

import java.io.IOException;

import toilet.solitaire.design.patterns.vgnshiyer.ColorCodes;
import toilet.solitaire.design.patterns.vgnshiyer.controls.Command;
import jline.console.ConsoleReader;

public class ExitGame implements Command{

    ConsoleReader reader;

    public ExitGame(ConsoleReader reader) {
        this.reader = reader;
    }

    /* exit the game by asking the user for confirmation */
    @Override
    public void execute() throws IOException {
        String line;
        
        reader.setPrompt(ColorCodes.RED + "Do you really want to exit? Note: All progress will be lost! " + ColorCodes.RESET);
        while((line = reader.readLine()) != null){
            line = line.trim();

            if(line.equals("y") || line.equals("Y")){
                System.out.println();
                System.out.println(ColorCodes.BLUE + "Goodbye!.." + ColorCodes.RESET);
                System.exit(0);
            } else if(line.equals("n") || line.equals("N")){
                reader.setPrompt("");
                break;
            } else {
                System.out.println(ColorCodes.RED + "Invalid Input!" + ColorCodes.RESET);
            }
            reader.setPrompt("");
        }
    }
}

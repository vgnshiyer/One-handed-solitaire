package toilet.solitaire.design.patterns.vgnshiyer.views;

import java.io.IOException;

import toilet.solitaire.design.patterns.vgnshiyer.ColorCodes;
import toilet.solitaire.design.patterns.vgnshiyer.models.services.AsciiText;

/* a subclass using the view template */
public class DashboardView extends View{

    /* the opening screen of the game */
    @Override
    public void view() throws IOException{
        reader.println(AsciiText.WELCOME);
        String line;

        reader.setPrompt("  Press 'p' to play...  ");
        while((line = reader.readLine()) != null){
            line = line.trim();

            if(line.equals("p")){
                break;
            } else {
                reader.println(ColorCodes.RED + "Invalid input!" + ColorCodes.RESET);
            }
        }
        reader.setPrompt("");
    }
}

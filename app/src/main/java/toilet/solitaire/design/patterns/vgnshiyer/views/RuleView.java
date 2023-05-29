package toilet.solitaire.design.patterns.vgnshiyer.views;

import java.io.IOException;

import toilet.solitaire.design.patterns.vgnshiyer.ColorCodes;

/* a subclass using the view template */
public class RuleView extends View {

    /* displays the rules of the game */
    @Override
    public void view() throws IOException{
        reader.println(ColorCodes.PURPLE + "Game rules ");
        reader.println(ColorCodes.RED + "1. Basic rules " + ColorCodes.RESET);
        reader.println("Rules: ");
        reader.println("* If 1st & 4th cards belong to the same suit, you can remove the two cards in the middle.");
        reader.println("* If 1st & 4th cards belong to the same rank, you can remove all four cards.");
        reader.println();
        reader.println(ColorCodes.BLUE + "2. Intermediate " + ColorCodes.RESET);
        reader.println("Rules: ");
        reader.println("* All rules that apply for the Basic rules, apply here.");
        reader.println("* If any two adjacent cards belong to the same rank, you can remove them.");
        reader.println();
        reader.println(ColorCodes.GREEN + "3. House rules " + ColorCodes.RESET);
        reader.println("Rules: ");
        reader.println("* All rules that apply for the Basic & Intermediate rules, apply here.");
        reader.println("* If 1st & 4th cards are of the same suit and 3rd & 4th card are of the same rank, you can remove the last three cards.");
        reader.println("* If 1st & 4th cards are of the same suit and 1st & 2nd card are of the same rank, you can remove the top three cards.");
        reader.println();
        reader.println(ColorCodes.RESET);
    }
}

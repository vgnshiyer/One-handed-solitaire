package toilet.solitaire.design.patterns.vgnshiyer.controls;

import toilet.solitaire.design.patterns.vgnshiyer.controls.Deck.DisplayDeck;
import toilet.solitaire.design.patterns.vgnshiyer.controls.Deck.FillDeck;
import toilet.solitaire.design.patterns.vgnshiyer.controls.Deck.ShuffleDeck;
import toilet.solitaire.design.patterns.vgnshiyer.controls.Game.ExitGame;
import toilet.solitaire.design.patterns.vgnshiyer.controls.Game.GenerateHand;
import toilet.solitaire.design.patterns.vgnshiyer.controls.Game.GetMoves;
import toilet.solitaire.design.patterns.vgnshiyer.controls.Game.SelectDifficulty;
import toilet.solitaire.design.patterns.vgnshiyer.controls.Game.SelectMove;
import toilet.solitaire.design.patterns.vgnshiyer.controls.Hand.RemoveAllFour;
import toilet.solitaire.design.patterns.vgnshiyer.controls.Hand.RemoveBottomThree;
import toilet.solitaire.design.patterns.vgnshiyer.controls.Hand.RemoveMiddlePair;
import toilet.solitaire.design.patterns.vgnshiyer.controls.Hand.RemovePair;
import toilet.solitaire.design.patterns.vgnshiyer.controls.Hand.RemoveTopThree;
import toilet.solitaire.design.patterns.vgnshiyer.controls.Hand.VerifyHand;
import toilet.solitaire.design.patterns.vgnshiyer.views.View;

/* Factory method pattern : A pattern which facilitates  command object creation */
public class CommandFactory {
    public static Command getCommand(String command){
        if(command.equals("shuffle"))
            return new ShuffleDeck();
        else if(command.equals("fillDeck"))
            return new FillDeck();
        else if(command.equals("deal"))
            return new GenerateHand();
        else if(command.equals("getMoves"))
            return new GetMoves();
        else if(command.equals("verifyHand"))
            return new VerifyHand();
        else if(command.equals("selectDifficulty"))
            return new SelectDifficulty(View.reader);
        else if(command.equals("selectMove"))
            return new SelectMove(View.reader);
        else if(command.equals("remove_four"))
            return new RemoveAllFour();
        else if(command.equals("last_three"))
            return new RemoveBottomThree();
        else if(command.equals("top_three"))
            return new RemoveTopThree();
        else if(command.equals("remove_middle_two"))
            return new RemoveMiddlePair();
        else if(command.equals("exit"))
            return new ExitGame(View.reader);
        else if(command.equals("remove_1&2"))
            return new RemovePair(0, 1);
        else if(command.equals("remove_2&3"))
            return new RemovePair(1, 2);
        else if(command.equals("remove_3&4"))
            return new RemovePair(2, 3);
        else return null;
    }
}

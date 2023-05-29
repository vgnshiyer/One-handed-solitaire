package toilet.solitaire.design.patterns.vgnshiyer;

import java.io.IOException;

import toilet.solitaire.design.patterns.vgnshiyer.controls.Command;
import toilet.solitaire.design.patterns.vgnshiyer.controls.CommandFactory;
import toilet.solitaire.design.patterns.vgnshiyer.controls.Deck.Deal;
import toilet.solitaire.design.patterns.vgnshiyer.controls.Deck.ShuffleDeck;
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
import toilet.solitaire.design.patterns.vgnshiyer.models.Deck;
import toilet.solitaire.design.patterns.vgnshiyer.models.Game;
import toilet.solitaire.design.patterns.vgnshiyer.views.AvailableMovesView;
import toilet.solitaire.design.patterns.vgnshiyer.views.DashboardView;
import toilet.solitaire.design.patterns.vgnshiyer.views.GameResultView;
import toilet.solitaire.design.patterns.vgnshiyer.views.HandView;
import toilet.solitaire.design.patterns.vgnshiyer.views.RuleView;
import toilet.solitaire.design.patterns.vgnshiyer.views.View;
import toilet.solitaire.design.patterns.vgnshiyer.views.ViewFactory;

public class GameFacade {

    public void newGame(){
        Game.resetGame();
        Deck.resetDeck();
    }
    
    public void startGame() throws IOException{
        View.reader.clearScreen();
        ViewFactory.getView("Dashboard").view();
    }

    /* display the rules and select the difficulty */
    public void selectDifficulty() throws IOException{
        View.reader.clearScreen();
        ViewFactory.getView("Rule").view();
        CommandFactory.getCommand("selectDifficulty").execute();
    }

    public void shuffleDeck() throws IOException{
        ViewFactory.getView("Shuffle").view();
    }

    /* display the four cards in hand */
    public void displayHand() throws IOException{
        View.reader.clearScreen();
        ViewFactory.getView("Hand").view();
    }

    public void verifyHand() throws IOException{
        CommandFactory.getCommand("verifyHand").execute();
    }

    /* get available set of moves looking at the current hand and get input from the user */
    public void getMoves() throws IOException{
        CommandFactory.getCommand("getMoves").execute();
        ViewFactory.getView("AvailableMoves").view();
        CommandFactory.getCommand("selectMove").execute();
    }

    /* perform the action selected by the user */
    public void performMove() throws IOException{
        Game game = Game.getInstance();
        String move = game.getMoves().get(game.getCurrentMove());
        CommandFactory.getCommand(move).execute();

        if(game.hand < 4 && Deck.getInstance().deck_size > 0) CommandFactory.getCommand("deal").execute();
    }

    /* display the final score and end the current game */
    public void end() throws IOException{
        (new GameResultView()).view();
    }
}

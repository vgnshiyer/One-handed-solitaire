package toilet.solitaire.design.patterns.vgnshiyer.models;

import java.util.HashMap;
import java.util.Map;

/* Singleton pattern : the singleton `Game` */
public class Game {
    private static Game thisInstance;
    private int difficulty = 3;
    public int hand = 0;
    public int counter = 0;
    private int currentMove = -1;
    public Boolean gameover = false;
    private Map<Integer, String> moves = new HashMap<>();

    private Game(){}

    /* method which generates the singleton */
    public static Game getInstance(){
        if(thisInstance == null){
            thisInstance = new Game();
        }
        return thisInstance;
    }

    public static void resetGame(){
        thisInstance = new Game();
    }

    public void setCurrentMove(int move){
        this.currentMove = move;
    }

    public int getCurrentMove(){
        return this.currentMove;
    }

    public void setDifficulty(int difficulty){
        this.difficulty = difficulty;
    }

    public int getDifficulty(){
        return this.difficulty;
    }

    public Map<Integer, String> getMoves(){
        return this.moves;
    }

    public void setMoves(Map<Integer, String> moves){
        this.moves = moves;
    }
}

package toilet.solitaire.design.patterns.vgnshiyer.models;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.BasicStroke;
import java.awt.Color;

import toilet.solitaire.design.patterns.vgnshiyer.controls.Deck.FillDeck;
import toilet.solitaire.design.patterns.vgnshiyer.controls.Deck.ShuffleDeck;

/* Singleton pattern : the singleton `Deck` */
public class Deck extends JPanel{
    private int x, y;
    private static Deck thisInstance;
    public List<Card> cards = new ArrayList<Card>();
    public int deck_size = 52;

    private Deck(){}

    private Deck(int x, int y){
        this.x = x;
        this.y = y;
        super.setLocation(x, y);
        super.setSize(72,96);
    }

    /* the method which generates a singleton */
    public static Deck getInstance(){
        if(thisInstance == null){
            thisInstance = new Deck();
            try {
                (new FillDeck()).execute();
                (new ShuffleDeck()).execute();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        return thisInstance;
    }

    /* gui specific methods */
    public static Deck getGuiInstance(int posx, int posy){
        if(thisInstance == null){
            thisInstance = new Deck(posx, posy);
            try {
                (new FillDeck()).execute();
                (new ShuffleDeck()).execute();             
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        return thisInstance;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(5));
        g2d.setColor(Color.WHITE);
        g2d.drawRect(0, 0, 72, this.getHeight());

        if(deck_size <= 0)
            g.drawImage(Card.getCardOutline(), 0, 0, 72, this.getHeight(), this);
        else
            g.drawImage(Card.getCardBack(), 0, 0, 72, this.getHeight(), this);
    }
    /* gui specific methods */

    public static void resetDeck(){
        thisInstance = new Deck();
        try {
            (new FillDeck()).execute();                
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

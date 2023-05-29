package toilet.solitaire.design.patterns.vgnshiyer.models;

import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.Graphics;

import toilet.solitaire.design.patterns.vgnshiyer.models.enums.Suits;
import java.awt.Image;

/* the card class */
public class Card extends JPanel {
    private int value;
    private Suits suit;
    public static String cardBack = "back001.gif";
    public static String cardOutLine = "bottom01.gif";
    public static String directory = "cards";

    /* gui specific methods */
    public static Image getCardBack(){
        try {
            ImageIcon imageIcon = new ImageIcon(Card.class.getClassLoader().getResource(directory + "/" + cardBack));
            Image image = imageIcon.getImage();
            return image;    
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Image getCardOutline(){
        try {
            ImageIcon imageIcon = new ImageIcon(Card.class.getClassLoader().getResource(directory + "/" + cardOutLine));
            Image image = imageIcon.getImage();
            return image;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Image getCardFace(Card card){
        try{
            String filename = Integer.toString(card.value) + String.valueOf(Suits.shortValues.get(card.suit.getValue())).toLowerCase() + ".gif";
            ImageIcon imageIcon = new ImageIcon(Card.class.getClassLoader().getResource(directory + "/" + filename));
            Image image = imageIcon.getImage();
            return image;
        } catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public Image getCardFace(){
        try{
            String filename = Integer.toString(value) + String.valueOf(Suits.shortValues.get(suit.getValue())).toLowerCase() + ".gif";
            ImageIcon imageIcon = new ImageIcon(Card.class.getClassLoader().getResource(directory + "/" + filename));
            Image image = imageIcon.getImage();
            return image;
        } catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public void setPosition(int posx, int posy){
        super.setLocation(posx,posy);
        super.setSize(72, 96);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(getCardFace(), 0, 0, 72, this.getHeight(), this);
    }
    /* gui specific methods end */

    public Card(int value, Suits suit) throws IOException{
        if(value < 2 || value > 14){
            throw new IOException("Card value can only be between 2 and 14");
        }
        this.value = value;
        this.suit = suit;
    }

    public Card(){}

    /* getters and setters */
    public int getValue(){
        return this.value;
    }

    public void setValue(int value){
        this.value = value;
    }

    public Suits getSuit(){
        return this.suit;
    }

    public void setSuit(Suits suit){
        this.suit = suit;
    }

    public String namedValue(){
        String name = "";
        switch (value) {
            case 14:
                name = "Ace";
                break;
            case 13:
                name = "King";
                break;
            case 12:
                name = "Queen";
                break;
            case 11:
                name = "Jack";
                break;
            default:
                name = Integer.toString(value);
                break;
        }
        return name;
    }

    public String getCardDescription(){
        return namedValue() + " of " + Suits.values.get(suit.getValue());
    }

    public Character getRank(){
        Character rank;
        switch (value){
            case (14):
                rank = 'A';
                break;
            case (13):
                rank = 'K';
                break;
            case (12):
                rank = 'Q';
                break;
            case (11):
                rank = 'J';
                break;
            case (10):
                rank = 'X';
                break;
            default:
                rank = (char)(value + '0');
                break;
        }
        return rank;
    }
}

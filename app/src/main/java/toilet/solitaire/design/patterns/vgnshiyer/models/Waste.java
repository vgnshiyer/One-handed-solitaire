package toilet.solitaire.design.patterns.vgnshiyer.models;

import javax.swing.JPanel;
import java.awt.Graphics;

/* class which defines the waste pile */
public class Waste extends JPanel{

    public static Card topCard = null;

    public Waste(int posx, int posy) {
        super.setLocation(posx, posy);
        super.setSize(72,96);
    }

    public static void setTopCard(Card card){
        topCard = card;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(topCard == null)
            g.drawImage(Card.getCardOutline(), 0, 0, 72, this.getHeight(), this);
        else
            g.drawImage(Card.getCardFace(topCard),0,0,72, this.getHeight(), this);
    }

}

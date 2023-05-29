package toilet.solitaire.design.patterns.vgnshiyer.gui_components;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.awt.Color;
import java.util.Random;
import java.awt.Font;

public class WelcomeView extends JPanel {

    public JButton play;

    List<String> message = new ArrayList<String>();

    public void welcome(){
        message.add("warning: This game is extremely addictive..");
        message.add("tip: Play the game on a toilet seat for better experience :)");
        message.add("tip: Do not always go for removing the most number of cards..");
        message.add("tip: Try remembering the sequence in your hand");
        message.add("fun fact: I spent more time playing this game than coding it..");

        /* Welcome screen text for the game */
        JLabel welcomeText = new JLabel("Toilet Solitaire");
        welcomeText.setFont(new Font("Arial", Font.BOLD, 36));
        welcomeText.setBounds(132, 60, 500, 150);
        add(welcomeText);
        
        play = new JButton("New Game");
        play.setFont(new Font("Arial", Font.PLAIN, 16));
        play.setBounds(195, 200, 120, 40);
        add(play);

        JLabel messageText = new JLabel(message.get((new Random()).nextInt(message.size())));
        messageText.setBounds(100,350,500,40);
        add(messageText);
    }
    
    public WelcomeView(){
        super.setLayout(null);
        welcome();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.GREEN);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
    }
}

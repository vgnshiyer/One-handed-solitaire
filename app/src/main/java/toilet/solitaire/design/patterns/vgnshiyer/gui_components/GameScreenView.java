package toilet.solitaire.design.patterns.vgnshiyer.gui_components;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FontMetrics;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import toilet.solitaire.design.patterns.vgnshiyer.controls.CommandFactory;
import toilet.solitaire.design.patterns.vgnshiyer.models.Card;
import toilet.solitaire.design.patterns.vgnshiyer.models.Deck;
import toilet.solitaire.design.patterns.vgnshiyer.models.Game;
import toilet.solitaire.design.patterns.vgnshiyer.models.Waste;

public class GameScreenView extends JPanel{

    private static Deck deck;
    private static Waste waste;
    private Game game = Game.getInstance();
    private Card card;
    protected static int offset = 80;
    private JButton[] moveButtons;

    public void displayGameOverPopup() {
        /* Display game results */
        JDialog gameOverDialog = new JDialog();
        JLabel result;
        if(game.hand <= 1){
            result = new JLabel("It's a Super Win!!");
        } else if(game.hand <= 4){
            result = new JLabel("You Win!");
        } else{
            result = new JLabel("You Lose...");
        }
        /* Display game scores */
        JLabel scoreLabel = new JLabel("Final Score: " + game.hand);
        JButton okButton = new JButton("OK");
        okButton.setBounds(0,0,70,25);
    
        /* Add components to panel */
        gameOverDialog.setLayout(new BoxLayout(gameOverDialog.getContentPane(), BoxLayout.Y_AXIS));
        gameOverDialog.add(result);
        gameOverDialog.add(scoreLabel);
        gameOverDialog.add(okButton);
    
        /* Configure dialog */
        gameOverDialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        gameOverDialog.setTitle("Game Over");
        gameOverDialog.setSize(200, 100);
        gameOverDialog.setResizable(false);
        gameOverDialog.setLocationRelativeTo(this);
    
        /* Add action listener to OK button */
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameOverDialog.dispose();
                System.exit(0);
            }
        });
    
        /* Show dialog */
        gameOverDialog.setVisible(true);
    }

    public void selectDifficultyLevel() {
        /* Display difficulty levels */
        JDialog difficultyDialog = new JDialog();
        JLabel prompt = new JLabel("Select difficulty level.");
        /* Add buttons for user to select difficulty */
        JButton easy = new JButton("Easy");
        JButton medium = new JButton("Medium");
        JButton hard = new JButton("Hard");
        /* Add components to panel */
        easy.setBounds(0,0,70,25);
        medium.setBounds(0,0,70,25);
        hard.setBounds(0,0,70,25);
        difficultyDialog.setLayout(new BoxLayout(difficultyDialog.getContentPane(), BoxLayout.Y_AXIS));
        difficultyDialog.add(prompt);
        difficultyDialog.add(easy);
        difficultyDialog.add(medium);
        difficultyDialog.add(hard);
    
        /* Configure dialog */
        difficultyDialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        difficultyDialog.setTitle("Difficulty level");
        difficultyDialog.setSize(200, 150);
        difficultyDialog.setResizable(false);
        difficultyDialog.setLocationRelativeTo(this);
    
        /* Add action listener to OK button */
        easy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.setDifficulty(3);
                difficultyDialog.setVisible(false);
            }
        });

        medium.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.setDifficulty(2);
                difficultyDialog.setVisible(false);
            }
        });

        hard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.setDifficulty(1);
                difficultyDialog.setVisible(false);
            }
        });
    
        /* Show dialog */
        difficultyDialog.setVisible(true);
    }

    public void revealHand() throws IOException{
        /* Remove old components */
        Component[] components = getComponents();
        for(Component component : components){
            if(component instanceof Card || component instanceof JLabel){
                remove(component);
            }
        }

        /* Display the deck */
        deck = Deck.getGuiInstance(50, 15);
        add(deck);
        JLabel deckCapacityLabel = new JLabel("Cards left: " + Math.max(deck.deck_size,0));
        deckCapacityLabel.setBounds(50,112,100,15);
        deckCapacityLabel.setFont((Font)deckCapacityLabel.getFont().deriveFont(deckCapacityLabel.getFont().getSize() * 0.92f));
        add(deckCapacityLabel);

        /* Display waste pile */
        waste = new Waste(410, 15);
        add(waste);

        /* Display running score */
        JLabel runningScore = new JLabel("Running score: " + game.hand);
        runningScore.setBounds(400, 350, 200, 15);
        runningScore.setFont((Font)runningScore.getFont().deriveFont(runningScore.getFont().getSize() * 0.95f));
        add(runningScore);
        
        /* Display cards in the hand */
        List<Card> cards = deck.cards;
        int offset = 0;
        for(int i = 0; i < Math.min(4, game.hand); i++){
            card = cards.get(i);
            card.setPosition(155 + offset, 120);
            offset += 50;
            card.repaint();
            add(card, 0);
        }
        verifyHand();
        revealMoves();
        repaint();
    }

    public void verifyHand() throws IOException{
        /* Validate current hand and end the game if invalid */
        CommandFactory.getCommand("verifyHand").execute();
        if(Game.getInstance().gameover){
            displayGameOverPopup();
        }
    }

    public void revealMoves() throws IOException{
        /* Get available moves */
        CommandFactory.getCommand("getMoves").execute();
        Map<Integer, String> moves = game.getMoves();
        int n = moves.size();

        JLabel j = new JLabel("What would you like to do?");
        j.setBounds(50,260,200,20);

        /* Remove old components */
        Component[] components = getComponents();
        for(Component component : components){
            if(component instanceof JButton){
                remove(component);
            }
        }

        /* Display the buttons for available moves */
        int x = 70, y = 290;
        moveButtons = new JButton[n];
        for(int i = 1; i <= n-1; i++){
            String move = moves.get(i);
            moveButtons[i] = new JButton(move.replace('_', ' '));
            FontMetrics metrics = moveButtons[i].getFontMetrics(moveButtons[i].getFont());
            int width = metrics.stringWidth(move) + 20; // add some padding
            moveButtons[i].setBounds(x, y, width+20, 25);
            moveButtons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e){
                    try {
                        CommandFactory.getCommand(move).execute();
                        if(game.hand < 4 && Deck.getInstance().deck_size > 0) CommandFactory.getCommand("deal").execute();
                        revealHand();
                        repaint();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            });
            add(moveButtons[i]);
            if(i % 3 == 0){
                x += 170;
                y = 290;
            } else y += 30;
        }
        add(j);
        j.setVisible(true);
    }

    public GameScreenView() throws IOException {
        super.setLayout(null);
        revealHand();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.GREEN);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
    }
}

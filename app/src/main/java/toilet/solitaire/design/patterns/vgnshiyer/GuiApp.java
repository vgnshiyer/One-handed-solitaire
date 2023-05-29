package toilet.solitaire.design.patterns.vgnshiyer;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;

import javax.swing.JFrame;

import toilet.solitaire.design.patterns.vgnshiyer.gui_components.GameScreenView;
import toilet.solitaire.design.patterns.vgnshiyer.gui_components.WelcomeView;

public class GuiApp extends JFrame{

    static protected GameScreenView gamePanel;
    static protected WelcomeView welcomePanel;
    public static final int PANEL_WIDTH = 535, PANEL_HEIGHT = 400;

    public GuiApp() throws IOException{
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /* Add main game panel */
        gamePanel = new GameScreenView();
        gamePanel.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        /* Add welcome screen panel */
        welcomePanel = new WelcomeView();
        welcomePanel.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        add(welcomePanel);

        /* add button click action */
        welcomePanel.play.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                welcomePanel.setVisible(false);
                remove(welcomePanel);
                add(gamePanel);
                gamePanel.selectDifficultyLevel();
            }
        });

        pack();
    }

    public static void main(String[] args) throws IOException{
        new GuiApp().setVisible(true);
    }
}

package lesson8;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {
    static final int WINDOW_X = 600;
    static final int WINDOW_Y = 300;
    static final int WINDOW_WIDTH = 505;
    static final int WINDOW_HEIGHT = 555;

    private SettingWindow settingWindow;
    private BattleField battleField;

    public GameWindow() {
        setBounds(WINDOW_X, WINDOW_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("TicTacToe");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        settingWindow = new SettingWindow(this);
        battleField = new BattleField(this);
        add(battleField, BorderLayout.CENTER);

        JPanel panel = new JPanel(new GridLayout(1, 2));
        JButton buttonStartGame = new JButton("Start new game");
        panel.add(buttonStartGame);
        buttonStartGame.addActionListener(e -> {
            settingWindow.setVisible(true);
        });

        JButton buttonExit = new JButton("Exit");
        panel.add(buttonExit);
        buttonExit.addActionListener(e -> {
            System.exit(0);
        });

        add(panel, BorderLayout.SOUTH);

        setVisible(true);
    }

    public void startNewGame(int gameMode, int fieldSize, int winningLength){
        battleField.startNewGame(gameMode, fieldSize, winningLength);
    }
}

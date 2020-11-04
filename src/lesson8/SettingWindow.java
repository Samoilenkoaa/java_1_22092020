package lesson8;

import javax.swing.*;
import java.awt.*;

public class SettingWindow extends JFrame {
    static final int WINDOW_X = GameWindow.WINDOW_X + 50;
    static final int WINDOW_Y = GameWindow.WINDOW_Y + 50;
    static final int WINDOW_WIDTH = GameWindow.WINDOW_WIDTH - 100;
    static final int WINDOW_HEIGHT = 450;

    public static final int GAME_MODE_H_VS_AI = 0;
    public static final int GAME_MODE_H_VS_H = 1;

    private final int MIN_FIELD_SIZE = 3;
    private final int MAX_FIELD_SIZE = 10;

    private GameWindow gameWindow;

    private JRadioButton jrbHvsAi;
    private JRadioButton jrbHvsH;
    private ButtonGroup buttonGroupGameMode;

    private JSlider slFieldSize;
    private JSlider slWinningLength;

    public SettingWindow(GameWindow gameWindow) {
        this.gameWindow = gameWindow;
        setBounds(WINDOW_X, WINDOW_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("Setting game");

        setLayout(new GridLayout(8, 1));

        add(new JLabel("Choose game mode:"));
        jrbHvsAi = new JRadioButton("H vs A", true);
        jrbHvsH = new JRadioButton("H vs H");
        add(jrbHvsAi);
        add(jrbHvsH);
        buttonGroupGameMode = new ButtonGroup();
        buttonGroupGameMode.add(jrbHvsAi);
        buttonGroupGameMode.add(jrbHvsH);
        jrbHvsH.setEnabled(false);

        slFieldSize = new JSlider(MIN_FIELD_SIZE, MAX_FIELD_SIZE, MIN_FIELD_SIZE);
        slFieldSize.setMajorTickSpacing(1);
        slFieldSize.setPaintLabels(true);
        slFieldSize.setPaintTicks(true);
        slWinningLength = new JSlider(MIN_FIELD_SIZE, MIN_FIELD_SIZE, MIN_FIELD_SIZE);
        slWinningLength.setMajorTickSpacing(1);
        slWinningLength.setPaintLabels(true);
        slWinningLength.setPaintTicks(true);
        slFieldSize.addChangeListener(e -> {
            slWinningLength.setMaximum(slFieldSize.getValue());
        });
        add(new JLabel("Choose field size:"));
        add(slFieldSize);

        add(new JLabel("Choose winning length:"));
        add(slWinningLength);

        JButton buttonStart = new JButton("Start a game");
        add(buttonStart);

        buttonStart.addActionListener(e -> {
            int gameMode;
            if (jrbHvsAi.isSelected()) {
                gameMode = GAME_MODE_H_VS_AI;
            } else {
                gameMode = GAME_MODE_H_VS_H;
            }
            int fieldSize = slFieldSize.getValue();
            int winningLength = slWinningLength.getValue();

            Logic.SIZE = fieldSize;
            Logic.DOTS_TO_WIN = winningLength;
            Logic.finishedGame = false;
            Logic.initMap();

            gameWindow.startNewGame(gameMode, fieldSize, winningLength);
            setVisible(false);
        });

        setVisible(false);
    }
}

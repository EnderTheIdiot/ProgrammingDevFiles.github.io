// Program: snek game v2
// Made by: EnderTheIdiot
// Started: I don't remeber
// Finished: 3/14/2026


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class snekGame extends JPanel implements ActionListener, KeyListener {

    // [SETUP]: Setting Variables
    private GameSetting config;
    private int SPRITE_SIZE;
    private int GAME_WIDTH;
    private int GAME_HEIGHT;
    private int SCREEN_WIDTH;
    private int SCREEN_HEIGHT;
    private int GAME_DELAY;

    // [SETUP]: Direction Variables
    private boolean UP = false;
    private boolean DOWN = false;
    private boolean LEFT = false;
    private boolean RIGHT = false;

    // [SETUP]: Player Variables for score recording
    private String iName;
    private String iTime;
    private int iScore;
    private DateTimeFormatter formatTime;
    private LocalDate replaceECD;

    // [SETUP]: Other Game Variables
    private List<Point> snake;
    private Point food;
    private boolean running = false;
    private Timer timer;
    private int score;
    private File sDirect;
    private JFrame highscoreList;
    private List<PlayerScore> rankCheck;

    // [GAME]: Obtains the settings from the config made with the starting menu, andruns the "startgame()" method
    public snekGame(GameSetting config) {

        formatTime = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        replaceECD = LocalDate.now();

        this.SPRITE_SIZE = config.getSS();
        this.GAME_WIDTH = config.getGW();
        this.GAME_HEIGHT = config.getGH();
        this.SCREEN_WIDTH = config.getSW();
        this.SCREEN_HEIGHT = config.getSH();
        this.GAME_DELAY = config.getGD();
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.addKeyListener(this);
        this.setFocusable(true);
        this.requestFocusInWindow();
        startGame();
    }

    // [GAME]: Starts the game, boots up the timer, and creates the snake
    private void startGame() {
        snake = new ArrayList<>(); // Creates an array list of points that acts as the snake's body.
        snake.add(new Point(GAME_WIDTH / 2, GAME_HEIGHT / 2)); // Sets the starting point for the snake (the middle of the screen by default).
        addFood(); // Adds a apple on the map, ready to be eaten (yum).
        running = true; // Sets the game-running status to true.
        timer = new Timer(GAME_DELAY, this); // Sets the delay of the game timer
        timer.start(); // Starts the game timer
        score = 0;
    }

    // [GAME]: Links movement actions to button presses
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP && !DOWN) { // Moving Down
            UP = true;
            LEFT = false;
            RIGHT = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN && !UP) { // Moving Up
            DOWN = true;
            LEFT = false;
            RIGHT = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT && !RIGHT) { // Moving Right
            LEFT = true;
            DOWN = false;
            UP = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT && !LEFT) { // Moving Left
            RIGHT = true;
            DOWN = false;
            UP = false;
        }
    }

    // [EXTRA]: Required methods that don't do anything (useless)
    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    // [GAME]: Links the arrow keys to the snake's direction
    private void move() {
        Point head = snake.get(0);
        int newx = head.x;
        int newy = head.y;
        if (UP == true) {
            newy = head.y - 1;
        }
        if (DOWN == true) {
            newy = head.y + 1;
        }
        if (RIGHT == true) {
            newx = head.x + 1;
        }
        if (LEFT == true) {
            newx = head.x - 1;
        }
        Point newHead = new Point(newx, newy);
        for (int i = snake.size() - 1; i > 0; i--) {
            Point current = snake.get(i);
            Point previous = snake.get(i - 1);
            current.setLocation(previous);
        }
        snake.set(0, newHead);
    }

    // [GAME]: Checks if the snake head is ontop of food
    private void checkFood() {
        Point snakeHead = snake.get(0);
        if (snakeHead.x == food.x && snakeHead.y == food.y) {
            snake.add(new Point(snakeHead.x, snakeHead.y));
            addFood();
            score += 5;
        }
    }

    // [GAME]: Checks to see if the snake has collided with the wall, or itself
    private void checkCollisions() {
        Point snakeHead = snake.get(0);

        if (snakeHead.x < 0) {
            running = false;
        }
        if (snakeHead.x > GAME_WIDTH) {
            running = false;
        }
        if (snakeHead.y < 0) {
            running = false;
        }
        if (snakeHead.y > GAME_HEIGHT) {
            running = false;
        }
        if (snake.size() > 1) {
            for (int i = 2; i <= (snake.size() - 1); i++) {
                if (snakeHead.x == (snake.get(i)).x && snakeHead.y == (snake.get(i)).y) {
                    running = false;
                }
            }
        }
        if (running == false) {
            gameoverSwitch();
        }
    }

    // [MENU]: Adds the gameover screen, and allows the user to play again.
    public void gameoverSwitch() {

        // [MENU]: Clears any left over windows
        Window[] windows = Window.getWindows();
        for (Window window : windows) {
            if (window instanceof JFrame && window.isVisible()) {
                window.setVisible(false);
            }
        }

        // [MENU]: Settings for Game Over screen
        JFrame gameoverNotification = new JFrame("GAME OVER - snek game");
        gameoverNotification.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameoverNotification.setUndecorated(true);
        gameoverNotification.pack();
        gameoverNotification.setVisible(false);
        gameoverNotification.setSize(170, 125);
        gameoverNotification.setLocationRelativeTo(null);
        gameoverNotification.setLayout(new FlowLayout());
        gameoverNotification.setFocusable(true);
        gameoverNotification.requestFocusInWindow();


        // [SCORES]: Variable for viewing highscores
        File sDirect = new File("highscores.info");

        // [MENU]: Adds key listener
        gameoverNotification.addKeyListener(new KeyListener() {
            @Override
            public void keyPressed(KeyEvent e) {

                // [MENU]: Pulls up the settings window when the player presses 1
                if (e.getKeyCode() == KeyEvent.VK_1) {
                    gameoverNotification.setVisible(false);

                    // [MENU]: The settings menu
                    JFrame infoWindow = new JFrame("snek game v1");
                    infoWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    infoWindow.pack();
                    infoWindow.setSize(400, 130);
                    infoWindow.setLocationRelativeTo(null);
                    infoWindow.setResizable(false);
                    infoWindow.setLayout(new FlowLayout());

                    infoWindow.setFocusable(true);
                    infoWindow.requestFocusInWindow();

                    // [MENU]: Size options
                    JLabel infoB1 = new JLabel("[ the game size ]");
                    JRadioButton smallMode = new JRadioButton("small");
                    JRadioButton normalMode = new JRadioButton("normal");
                    JRadioButton largeMode = new JRadioButton("large");
                    ButtonGroup modeChoice = new ButtonGroup();
                    modeChoice.add(smallMode);
                    modeChoice.add(normalMode);
                    modeChoice.add(largeMode);
                    normalMode.setSelected(true);
                    smallMode.setFocusable(false);
                    normalMode.setFocusable(false);
                    largeMode.setFocusable(false);

                    // [MENU]: Difficulty options
                    JLabel infoB2 = new JLabel("[ the difficulty ]");
                    JRadioButton easyDiff = new JRadioButton("easy");
                    JRadioButton normalDiff = new JRadioButton("normal");
                    JRadioButton hardDiff = new JRadioButton("hardcore");
                    ButtonGroup diffChoice = new ButtonGroup();
                    diffChoice.add(easyDiff);
                    diffChoice.add(normalDiff);
                    diffChoice.add(hardDiff);
                    easyDiff.setFocusable(false);
                    normalDiff.setFocusable(false);
                    hardDiff.setFocusable(false);
                    normalDiff.setSelected(true);

                    JLabel infoB3 = new JLabel("-[ PRESS 1 TO START! ]-");
                    JLabel infoB4 = new JLabel("-[ PRESS 2 TO VIEW SCORES ]-");

                    // [MENU]: Start Game button
                    infoWindow.addKeyListener(new KeyListener() {
                        @Override
                        public void keyPressed(KeyEvent e) {
                            if (e.getKeyCode() == KeyEvent.VK_1) { 
                                infoWindow.setVisible(false);
                                GameSetting config = new GameSetting();
                                if (smallMode.isSelected() == true) {
                                    config.setGH(20);
                                    config.setGW(20);
                                    config.setSH(20 * config.getSS());
                                    config.setSW(20 * config.getSS());
                                }
                                if (normalMode.isSelected() == true) {
                                    config.setGH(40);
                                    config.setGW(40);
                                    config.setSH(40 * config.getSS());
                                    config.setSW(40 * config.getSS());
                                }
                                if (largeMode.isSelected() == true) {
                                    config.setGH(80);
                                    config.setGW(80);
                                    config.setSH(80 * config.getSS());
                                    config.setSW(80 * config.getSS());
                                }
                                if (easyDiff.isSelected() == true) {
                                    config.setDelay(200);
                                }
                                if (hardDiff.isSelected() == true) {
                                    config.setDelay(50);
                                }

                                // [MENU]: Starts the game
                                JFrame gameWindow = new JFrame("snek game v1");
                                snekGame game = new snekGame(config);
                                gameWindow.add(game);
                                gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                gameWindow.setUndecorated(true);
                                gameWindow.pack();
                                gameWindow.setVisible(true);
                                gameWindow.setLocationRelativeTo(null);
                                gameWindow.setResizable(false);
                            }

                            // [MENU]: Brings up highscores when the player presses 2 (if any highscores are available)
                            if (e.getKeyCode() == KeyEvent.VK_2) {
                                if (sDirect.length() > 0) {
                                    JFrame highscoreList = new JFrame("High Scores - snek game");
                                    highscoreList.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                    highscoreList.pack();
                                    highscoreList.setVisible(false);
                                    highscoreList.setSize(300, 225);
                                    highscoreList.setLocationRelativeTo(null);
                                    highscoreList.setLayout(new FlowLayout());
                                    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(sDirect))) {
                                        while (true) {
                                            try {
                                                Object obj = ois.readObject();
                                                if (obj instanceof PlayerScore) {
                                                    final PlayerScore s = (PlayerScore) obj;
                                                    JLabel highscoreInfo = new JLabel(s.toString());
                                                    highscoreList.add(highscoreInfo);
                                                } else {
                                                    System.out.println("Unsupported Object " + obj.getClass().getName());
                                                }
                                            } catch (EOFException e5) {
                                                break;
                                            }
                                        }
                                    } catch (IOException | ClassNotFoundException e4) {
                                        e4.printStackTrace();
                                    }
                                }
                            }
                        }

                        // [EXTRA]: Required methods that don't do anything (useless)
                        @Override
                        public void keyReleased(KeyEvent e) {
                        }

                        @Override
                        public void keyTyped(KeyEvent e) {
                        }
                    });

                    // [MENU]: Adds the setting menu compenents
                    infoWindow.add(infoB1);
                    infoWindow.add(smallMode);
                    infoWindow.add(normalMode);
                    infoWindow.add(largeMode);
                    infoWindow.add(infoB2);
                    infoWindow.add(easyDiff);
                    infoWindow.add(normalDiff);
                    infoWindow.add(hardDiff);
                    infoWindow.add(infoB3);
                    infoWindow.add(infoB4);
                    infoWindow.setVisible(true);
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }

            @Override
            public void keyTyped(KeyEvent e) {
            }
        });

        // [MENU]: Adds elements to Game Over screen
        JLabel gameoverText1 = new JLabel("[ GAME OVER ]");
        JLabel gameoverText2 = new JLabel(" TOTAL SCORE ");
        JLabel gameoverText3 = new JLabel(calScore(score) + " Points!");
        JLabel gameoverText4 = new JLabel("----------------");
        JLabel gameoverText5 = new JLabel("PRESS 1 TO");
        JLabel gameoverText6 = new JLabel("PLAY AGAIN");
        gameoverNotification.add(gameoverText1);
        gameoverNotification.add(gameoverText2);
        gameoverNotification.add(gameoverText3);
        gameoverNotification.add(gameoverText4);
        gameoverNotification.add(gameoverText5);
        gameoverNotification.add(gameoverText6);
        gameoverNotification.setVisible(true);

        // [SCORES]: Checks to see if the score file is empty, if so it will record a new highscore.
        if (sDirect.length() > 0) {
            rankCheck = new ArrayList<>();
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(sDirect))) {
                while (true) {
                    try {
                        Object obj = ois.readObject();
                        if (obj instanceof PlayerScore) {
                            final PlayerScore s = (PlayerScore) obj;
                            rankCheck.add(s);
                            
                            // [SCORES]: Checks to see if the score is higher than any current scores. If so, it adds a new record. If above 5 records, it removes the lowest one.
                            if (calScore(score) >= s.getPlayerPoints()) {
                                if (rankCheck.size() == 5) {
                                    if (!rankCheck.isEmpty()) {
                                        PlayerScore lowestScore = Collections.min(rankCheck);
                                        rankCheck.remove(lowestScore);
                                        for (PlayerScore ns : rankCheck) {
                                            if (sDirect.exists() && sDirect.length() <= 1) {
                                                try (FileOutputStream userFile = new FileOutputStream(sDirect, true);
                                                        ObjectOutputStream objOut = new ObjectOutputStream(userFile)) {
                                                    objOut.writeObject(ns);
                                                } catch (IOException b) {
                                                    System.err.println("Error: " + b.getMessage());
                                                }
                                            }
                                        }
                                    }
                                }
                                highscoreSelection();
                                gameoverNotification.setVisible(false);
                            } 
                        } else {
                            System.out.println("Unsupported Object " + obj.getClass().getName());
                        }
                    } catch (EOFException e5) {
                        break;
                    }
                }
            } catch (IOException | ClassNotFoundException e4) {
                e4.printStackTrace();
            }
        } else {
            highscoreSelection();
            gameoverNotification.setVisible(false);
        }
    }

    // [SCORES]: Used to record the data and time of a high score
    public String getRecordTime() {
        String newECD = replaceECD.format(formatTime);
        return newECD.toString();
    }

    // [SCORES]: Allows the player to save the new high score
    public void highscoreSelection() {
        JFrame highscoreSelWindow = new JFrame("snek game v1 - custom size");
        highscoreSelWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        highscoreSelWindow.pack();
        highscoreSelWindow.setVisible(false);
        highscoreSelWindow.setSize(295, 200);
        highscoreSelWindow.setLocationRelativeTo(null);
        highscoreSelWindow.setLayout(new FlowLayout());

        // [SCORES]: File Location
        File sDirect = new File("highscores.info");

        // [SCORES]: Fixes the key listener
        highscoreSelWindow.setFocusable(true);
        highscoreSelWindow.requestFocusInWindow();
        JLabel HSWText1 = new JLabel(" NEW HIGH SCORE! ");
        JLabel HSWText2 = new JLabel(" TOTAL SCORE ");
        JLabel HSWText3 = new JLabel(calScore(score) + " Points!");
        JLabel HSWText4 = new JLabel(" - ENTER YOUR INITIALS BELOW (3 LETTERS) - ");
        JTextArea nameInput = new JTextArea("AAA");

        // [SCORES]: Confirms the new score record
        JButton enterNameButton = new JButton("ENTER");
        enterNameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if ((nameInput.getText()).length() == 3) {
                    iName = nameInput.getText();
                    iScore = calScore(score);
                    iTime = getRecordTime();
                    PlayerScore newPlayerRecord = new PlayerScore(iName, iScore, iTime);
                    if (sDirect.exists() && sDirect.length() <= 1) {
                        try (FileOutputStream userFile = new FileOutputStream(sDirect, true);
                                ObjectOutputStream objOut = new ObjectOutputStream(userFile)) {
                            objOut.writeObject(newPlayerRecord);
                        } catch (IOException b) {
                            System.err.println("Error: " + b.getMessage());
                        }
                    } else {
                        try (FileOutputStream userFile = new FileOutputStream(sDirect, true);
                                AppendingObjectOutputStream objOut = new AppendingObjectOutputStream(userFile)) {
                            objOut.writeObject(newPlayerRecord);
                        } catch (IOException b) {
                            System.err.println("Error: " + b.getMessage());
                        }
                    }
                    score = 0;
                    gameoverSwitch();
                }
            }
        });

        // [SCORES]: Adds the window elements
        highscoreSelWindow.add(HSWText1);
        highscoreSelWindow.add(HSWText2);
        highscoreSelWindow.add(HSWText3);
        highscoreSelWindow.add(HSWText4);
        highscoreSelWindow.add(nameInput);
        highscoreSelWindow.add(enterNameButton);
        highscoreSelWindow.setVisible(true);
    }

    // [GAME]: Spawns the food
    public void addFood() {
        food = new Point(
                (int) (Math.random() * ((GAME_WIDTH / SPRITE_SIZE) * SPRITE_SIZE) - SPRITE_SIZE) + SPRITE_SIZE,
                (int) (Math.random() * ((GAME_HEIGHT / SPRITE_SIZE) * SPRITE_SIZE) - SPRITE_SIZE) + SPRITE_SIZE);
    }

    // [GAME]: Calculates the score
    public int calScore(int gameScore) {
        int newScore = gameScore;
        if (GAME_WIDTH == 20) {
            newScore *= 3;
        }
        if (GAME_HEIGHT == 40) {
            newScore *= 2;
        }
        if (GAME_DELAY == 100) {
            newScore *= 2;
        }
        if (GAME_DELAY == 50) {
            newScore *= 4;
        }
        return newScore;
    }

    // [GAME]: Runs all the checking methods
    @Override
    public void actionPerformed(ActionEvent e) {
        if (running) {
            move();
            checkCollisions();
            checkFood();
        }
        repaint();
    }

    // [GAME]: Colors the game components
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, GAME_WIDTH * SPRITE_SIZE, GAME_HEIGHT * SPRITE_SIZE);
        for (Point point : snake) {
            g.setColor(Color.WHITE);
            g.fillRect(point.x * SPRITE_SIZE, point.y * SPRITE_SIZE, SPRITE_SIZE, SPRITE_SIZE);
        }

        g.setColor(Color.WHITE);
        g.fillRect(food.x * SPRITE_SIZE, food.y * SPRITE_SIZE, SPRITE_SIZE, SPRITE_SIZE);
        g.setColor(Color.RED);
        g.fillRect((food.x * SPRITE_SIZE) + 2, (food.y * SPRITE_SIZE) + 2, SPRITE_SIZE - 4, SPRITE_SIZE - 4);
    }

    public static void main(String[] args) {

        // [SCORES]: Variable for viewing the current highscores
        File sDirect = new File("highscores.info");

        // [MENU]: The settings menu
        JFrame infoWindow = new JFrame("snek game v1");
        infoWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        infoWindow.pack();
        infoWindow.setSize(400, 130);
        infoWindow.setLocationRelativeTo(null);
        infoWindow.setResizable(false);
        infoWindow.setLayout(new FlowLayout());

        infoWindow.setFocusable(true);
        infoWindow.requestFocusInWindow();

        // [MENU]: Size options
        JLabel infoB1 = new JLabel("[ the game size ]");
        JRadioButton smallMode = new JRadioButton("small");
        JRadioButton normalMode = new JRadioButton("normal");
        JRadioButton largeMode = new JRadioButton("large");
        ButtonGroup modeChoice = new ButtonGroup();
        modeChoice.add(smallMode);
        modeChoice.add(normalMode);
        modeChoice.add(largeMode);
        normalMode.setSelected(true);
        smallMode.setFocusable(false);
        normalMode.setFocusable(false);
        largeMode.setFocusable(false);

        // [MENU]: Difficulty options
        JLabel infoB2 = new JLabel("[ the difficulty ]");
        JRadioButton easyDiff = new JRadioButton("easy");
        JRadioButton normalDiff = new JRadioButton("normal");
        JRadioButton hardDiff = new JRadioButton("hardcore");
        ButtonGroup diffChoice = new ButtonGroup();
        diffChoice.add(easyDiff);
        diffChoice.add(normalDiff);
        diffChoice.add(hardDiff);
        normalDiff.setSelected(true);
        easyDiff.setFocusable(false);
        normalDiff.setFocusable(false);
        hardDiff.setFocusable(false);

        JLabel infoB3 = new JLabel("[ PRESS 1 TO START! ] ");
        JLabel infoB4 = new JLabel("[ PRESS 2 TO VIEW SCORES ]");

        // [MENU]: Start Game button
        infoWindow.addKeyListener(new KeyListener() {
            @Override
            public void keyPressed(KeyEvent e) {
                
                // [MENU]: Starts the game when the player presses 1
                if (e.getKeyCode() == KeyEvent.VK_1) {
                    infoWindow.setVisible(false);
                    GameSetting config = new GameSetting();
                    if (smallMode.isSelected() == true) {
                        config.setGH(20);
                        config.setGW(20);
                        config.setSH(20 * config.getSS());
                        config.setSW(20 * config.getSS());
                    }
                    if (normalMode.isSelected() == true) {
                        config.setGH(40);
                        config.setGW(40);
                        config.setSH(40 * config.getSS());
                        config.setSW(40 * config.getSS());
                    }
                    if (largeMode.isSelected() == true) {
                        config.setGH(80);
                        config.setGW(80);
                        config.setSH(80 * config.getSS());
                        config.setSW(80 * config.getSS());
                    }
                    if (easyDiff.isSelected() == true) {
                        config.setDelay(200);
                    }
                    if (hardDiff.isSelected() == true) {
                        config.setDelay(50);
                    }

                    // [MENU]: Starts the game
                    JFrame gameWindow = new JFrame("snek game v1");
                    snekGame game = new snekGame(config);
                    gameWindow.add(game);
                    gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    gameWindow.setUndecorated(true);
                    gameWindow.pack();
                    gameWindow.setVisible(true);
                    gameWindow.setLocationRelativeTo(null);
                    gameWindow.setResizable(false);
                }

                // [MENU]: Brings up highscores when the player presses 2 (if any highscores are available)
                if (e.getKeyCode() == KeyEvent.VK_2) {
                    if (sDirect.length() > 0) {
                        JFrame highscoreList = new JFrame("High Scores - snek game");
                        highscoreList.pack();
                        highscoreList.setVisible(true);
                        highscoreList.setSize(300, 225);
                        highscoreList.setLocationRelativeTo(null);
                        highscoreList.setLayout(new FlowLayout());
                        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(sDirect))) {
                            while (true) {
                                try {
                                    Object obj = ois.readObject();
                                    if (obj instanceof PlayerScore) {
                                        final PlayerScore s = (PlayerScore) obj;
                                        JLabel highscoreInfo = new JLabel(s.toString());
                                        highscoreList.add(highscoreInfo);
                                    } else {
                                        System.out.println("Unsupported Object " + obj.getClass().getName());
                                    }
                                } catch (EOFException e5) {
                                    break;
                                }
                            }
                        } catch (IOException | ClassNotFoundException e4) {
                            e4.printStackTrace();
                        }
                    }
                }
            }

            // [EXTRA]: Required methods that don't do anything (useless)
            @Override
            public void keyReleased(KeyEvent e) {
            }

            @Override
            public void keyTyped(KeyEvent e) {
            }
        });

        // [MENU]: Adds the setting menu compenents
        infoWindow.add(infoB1);
        infoWindow.add(smallMode);
        infoWindow.add(normalMode);
        infoWindow.add(largeMode);
        infoWindow.add(infoB2);
        infoWindow.add(easyDiff);
        infoWindow.add(normalDiff);
        infoWindow.add(hardDiff);
        infoWindow.add(infoB3);
        infoWindow.add(infoB4);
        infoWindow.setVisible(true);
    }
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class snekGame extends JPanel implements ActionListener, KeyListener {

    // [SETUP]: Setting Variables
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

    // [SETUP]: Other Game Variables
    private List<Point> snake;         
    private Point food;                  
    private boolean running = false;         
    private Timer timer; 

    // [GAME]: Obtains the settings from the config made with the starting menu, and runs the "startgame()" method
    public snekGame(GameSetting config) {
        this.SPRITE_SIZE = config.getSS();                                            
        this.GAME_WIDTH = config.getGW();
        this.GAME_HEIGHT= config.getGH();
        this.SCREEN_WIDTH= config.getSW();
        this.SCREEN_HEIGHT= config.getSH();
        this.GAME_DELAY= config.getGD();
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.addKeyListener(this);
        this.setFocusable(true);
        this.requestFocusInWindow();
        startGame();
    }

    // [GAME]: Starts the game, boots up the timer, and creates the snake
    private void startGame() {     
        snake = new ArrayList<>();                                                  // Creates an array list of points that acts as the snake's body.
        snake.add(new Point(GAME_WIDTH / 2, GAME_HEIGHT / 2));                      // Sets the starting point for the snake (the middle of the screen by default).
        addFood();                                                                  // Adds a apple on the map, ready to be eaten (yum).
        running = true;                                                             // Sets the game-running status to true.
        timer = new Timer (GAME_DELAY, this);                                       // Sets the delay of the game timer
        timer.start();                                                              // Starts the game timer
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
    public void keyReleased(KeyEvent e) {}
    @Override
    public void keyTyped(KeyEvent e) {}

    // [GAME]: Links the arrow keys to the snake's direction
    private void move() {
        Point head = snake.get(0);
        int newx = head.x;
        int newy = head.y;
        if (UP == true) { newy = head.y - 1;}
        if (DOWN == true) { newy = head.y + 1;}
        if (RIGHT == true) { newx = head.x + 1;}
        if (LEFT == true) { newx = head.x - 1;}
        Point newHead = new Point(newx, newy);
        for(int i = snake.size() - 1; i > 0; i--) {
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
        }
    }

    // [GAME]: Checks to see if the snake has collided with the wall, or itself
    private void checkCollisions() { 
        Point snakeHead = snake.get(0);
        
        if (snakeHead.x < 0) { running = false; }
        if (snakeHead.x > GAME_WIDTH) { running = false; }
        if (snakeHead.y < 0) { running = false; }
        if (snakeHead.y > GAME_HEIGHT) { running = false; }
        if (snake.size() > 1) {
            if (snakeHead.x == (snake.get(snake.size() - 1)).x && snakeHead.y == (snake.get(snake.size() - 1)).y) {
                running = false;
            }
        }
        if (running == false) {
            System.out.println("GAME OVER. Restart the program to play again");
        }
        
    }

    // [GAME] Spawns the food
    public void addFood() {
        food = new Point(
            (int)(Math.random() * ((GAME_WIDTH / SPRITE_SIZE) * SPRITE_SIZE) - SPRITE_SIZE) + SPRITE_SIZE,
            (int)(Math.random() * ((GAME_HEIGHT / SPRITE_SIZE) * SPRITE_SIZE) - SPRITE_SIZE) + SPRITE_SIZE
        );
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
        // [MENU]: The settings menu
        JFrame infoWindow = new JFrame("snek game v1");
        infoWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        infoWindow.pack();
        infoWindow.setVisible(true);
        infoWindow.setSize(400, 300);
        infoWindow.setLocationRelativeTo(null);
        infoWindow.setLayout(new FlowLayout());

        // [MENU]: The custom size menu
        JFrame info2Window = new JFrame("snek game v1 - custom size");
        info2Window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        info2Window.pack();
        info2Window.setVisible(false);
        info2Window.setSize(400, 300);
        info2Window.setLocationRelativeTo(null);
        info2Window.setLayout(new FlowLayout());

        // [MENU]: Size options
        JLabel infoB1 = new JLabel("[ the game size ]");
        JRadioButton normalMode = new JRadioButton("normal");
        JRadioButton largeMode = new JRadioButton("large");
        JRadioButton customMode = new JRadioButton("custom");
        ButtonGroup modeChoice = new ButtonGroup();
        modeChoice.add(normalMode);
        modeChoice.add(largeMode);
        modeChoice.add(customMode);
        normalMode.setSelected(true);

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

        // [MENU]: Start Game button
        JButton startGameButton = new JButton("START");
        startGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (customMode.isSelected() == true) {
                    info2Window.setVisible(true);
                } else {
                    infoWindow.setVisible(false);
                    GameSetting config = new GameSetting();
                    if (normalMode.isSelected() == true) {
                        int newSH;
                        newSH = config.getGH();
                        config.setSH((newSH * 10));
                        int newSW;
                        newSW = config.getGW();
                        config.setSW((newSW * 10));
                    }
                    if (largeMode.isSelected() == true) {
                        config.setSize(13);
                        int newSH;
                        newSH = config.getGH();
                        config.setSH((newSH * 13));
                        int newSW;
                        newSW = config.getGW();
                        config.setSW((newSW * 13));
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
                    gameWindow.pack();
                    gameWindow.setVisible(true);
                    gameWindow.setLocationRelativeTo(null);
                }
            }
        });

        // [MENU]: Custom size input
        JLabel infoC = new JLabel("Insert Size");
        JTextArea customSize = new JTextArea();
        JButton startGameButton2 = new JButton("START");
        startGameButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean includesInput;
                try {
                    Integer.parseInt(customSize.getText());
                    includesInput = true;

                } catch (NumberFormatException e1) {
                    includesInput = false;
                }
                if (includesInput == true) {
                    infoWindow.setVisible(false);
                    info2Window.setVisible(false);
                    GameSetting config = new GameSetting();
                    config.setSize(Integer.parseInt(customSize.getText()));
                    int newSH;
                    newSH = config.getGH();
                    config.setSH(newSH * Integer.parseInt(customSize.getText()));
                    int newSW;
                    newSW = config.getGW();
                    config.setSW((newSW * Integer.parseInt(customSize.getText())));
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
                    gameWindow.pack();
                    gameWindow.setVisible(true);
                    gameWindow.setLocationRelativeTo(null);
                } else {
                    System.out.println("No Size Input Given! Please Try Again!");
                }
            }
        });

        // [MENU]: Adds the setting menu compenents 
        infoWindow.add(infoB1);
        infoWindow.add(normalMode);
        infoWindow.add(largeMode);
        infoWindow.add(customMode);
        infoWindow.add(infoB2);
        infoWindow.add(easyDiff);
        infoWindow.add(normalDiff);
        infoWindow.add(hardDiff);
        infoWindow.add(startGameButton);

        // [MENU]: Adds the custom size menu compenents 
        info2Window.add(infoC);
        info2Window.add(customSize);
        info2Window.add(startGameButton2);
    }
}   


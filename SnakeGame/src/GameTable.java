import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class GameTable extends JComponent {

    private Snake snake;
    private Food food;
    private BufferedImage appleImage;
    private BufferedImage snakeHead;
    private final Color SNAKE_BODY_COLOR = new Color(0, 100, 0);;

    public GameTable(Snake snake) {
        try {
            appleImage = ImageIO
                    .read(new File("src//apple.png"));
            snakeHead = ImageIO
                    .read(new File("src//SnakeHead.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.snake = snake;
        this.food = new Food();
    }

    public void checkForFood() {
        if (snake.getBody().get(0).getCoordinates().equals(this.food.getCoordinates())) {
            this.food = new Food();
            this.snake.increaseLength();
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int numLines = SnakeGame.FRAME_LENGTH / SnakeGame.PIXEL_SIZE;

        g.setColor(Color.BLACK);
        for (int i = 0; i <= numLines; i++) {

            g.drawLine(0, i * SnakeGame.PIXEL_SIZE, SnakeGame.FRAME_LENGTH, i * SnakeGame.PIXEL_SIZE);
            g.drawLine(i * SnakeGame.PIXEL_SIZE, 0, i * SnakeGame.PIXEL_SIZE, SnakeGame.FRAME_LENGTH);
        }
        g.setColor(SNAKE_BODY_COLOR);
        for (int i = 0; i < snake.getBody().size(); i++) {
            if (i == 0) {
                g.drawImage(snakeHead, snake.getBody().get(i).getCoordinates().getX(),
                        snake.getBody().get(i).getCoordinates().getY(), SnakeGame.PIXEL_SIZE, SnakeGame.PIXEL_SIZE,
                        null);
                i++;
            }
            g.fillRect(snake.getBody().get(i).getCoordinates().getX(), snake.getBody().get(i).getCoordinates().getY(),
                    SnakeGame.PIXEL_SIZE, SnakeGame.PIXEL_SIZE);
        }
        g.drawImage(appleImage, food.getCoordinates().getX(), food.getCoordinates().getY(), SnakeGame.PIXEL_SIZE,
                SnakeGame.PIXEL_SIZE, null);

    }

    public Snake getSnake() {
        return snake;
    }
}

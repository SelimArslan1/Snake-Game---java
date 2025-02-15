import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class SnakeGame {
    public static final int PIXEL_SIZE = 30;
    public static final int FRAME_LENGTH = 600;
    private static final int GAME_TIME = 100;

    public static void main(String[] args) {

        Snake snake = new Snake(new Coordinates(420, 420));
        GameTable table = new GameTable(snake);
        GameFrame frame = new GameFrame(table);

        ActionListener taskPerformer = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (!snake.checkCollision()) {
                    snake.move();
                    table.checkForFood();
                    table.repaint();
                }
            }
        };
        Timer timer = new Timer(GAME_TIME, taskPerformer);
        timer.start();

    }
}

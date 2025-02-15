import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;

public class GameFrame extends JFrame implements KeyListener {

    private GameTable table;

    public GameFrame(GameTable table) {
        this.table = table;
        this.addKeyListener(this);
        this.add(table);
        this.setVisible(true);
        this.setResizable(true);
        this.setSize(SnakeGame.FRAME_LENGTH + 15, SnakeGame.FRAME_LENGTH + 38);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                if (table.getSnake().getBody().get(0).getDirection() != 4) {
                    table.getSnake().setDirection(2);
                }
                break;
            case KeyEvent.VK_DOWN:
                if (table.getSnake().getBody().get(0).getDirection() != 2) {
                    table.getSnake().setDirection(4);
                }
                break;
            case KeyEvent.VK_LEFT:
                if (table.getSnake().getBody().get(0).getDirection() != 1) {
                    table.getSnake().setDirection(3);
                }
                break;
            case KeyEvent.VK_RIGHT:
                if (table.getSnake().getBody().get(0).getDirection() != 3) {
                    table.getSnake().setDirection(1);
                }
                break;

            default:
                break;
        }
        table.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}

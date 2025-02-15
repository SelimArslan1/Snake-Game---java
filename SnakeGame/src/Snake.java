import java.util.ArrayList;
import javax.swing.*;

public class Snake extends JComponent {

    private ArrayList<BodyPart> bodyParts;
    private int size;
    // 1 -> Right 2 -> Up 3 -> Left 4 -> Down

    public Snake(Coordinates coordinates) {
        bodyParts = new ArrayList<BodyPart>();
        this.bodyParts.add(new BodyPart(coordinates, 1));
        this.size = 1;
        this.increaseLength();
    }

    public Snake() {
        bodyParts = new ArrayList<BodyPart>();
        this.bodyParts.add(new BodyPart(new Coordinates(), 1));
        this.size = 1;
        this.increaseLength();
    }

    public void increaseLength() {
        Coordinates newBodyPart = new Coordinates();
        switch (bodyParts.get(this.size - 1).getDirection()) {
            case 1:
                newBodyPart.setX(bodyParts.get(this.size - 1).getCoordinates().getX() - SnakeGame.PIXEL_SIZE);
                newBodyPart.setY(bodyParts.get(this.size - 1).getCoordinates().getY());
                break;
            case 2:
                newBodyPart.setX(bodyParts.get(this.size - 1).getCoordinates().getX());
                newBodyPart.setY(bodyParts.get(this.size - 1).getCoordinates().getY() + SnakeGame.PIXEL_SIZE);
                break;
            case 3:
                newBodyPart.setX(bodyParts.get(this.size - 1).getCoordinates().getX() + SnakeGame.PIXEL_SIZE);
                newBodyPart.setY(bodyParts.get(this.size - 1).getCoordinates().getY());
                break;
            case 4:
                newBodyPart.setX(bodyParts.get(this.size - 1).getCoordinates().getX());
                newBodyPart.setY(bodyParts.get(this.size - 1).getCoordinates().getY() - SnakeGame.PIXEL_SIZE);
                break;
            default:

                break;
        }
        bodyParts.add(new BodyPart(newBodyPart, bodyParts.get(this.size - 1).getDirection()));
        this.size++;
    }

    public boolean checkCollision() {
        boolean result = false;

        for (int i = 0; i < bodyParts.size(); i++) {
            for (int j = 0; j < bodyParts.size(); j++) {
                if (i != j && bodyParts.get(i).getCoordinates().equals(bodyParts.get(j).getCoordinates())) {
                    result = true;
                }
            }
        }
        return result;
    }
    
    public void setDirection(int direction) {
        bodyParts.get(0).setDirection(direction);
    }

    public void move() {
        for (int i = bodyParts.size() - 1; i > 0; i--) {
            bodyParts.set(i, bodyParts.get(i - 1));
        }
        BodyPart head = new BodyPart(
                new Coordinates(bodyParts.get(0).getCoordinates().getX(), bodyParts.get(0).getCoordinates().getY()),
                bodyParts.get(0).getDirection());
        switch (head.getDirection()) {
            case 1:
                if (head.getCoordinates().getX() == SnakeGame.PIXEL_SIZE * 19) {
                    head.setCoordinates(new Coordinates(0, head.getCoordinates().getY()));
                } else {
                    head.getCoordinates().setX(head.getCoordinates().getX() + SnakeGame.PIXEL_SIZE);
                }
                break;
            case 2:
                if (head.getCoordinates().getY() == 0) {
                    head.setCoordinates(new Coordinates(head.getCoordinates().getX(), SnakeGame.PIXEL_SIZE * 19));
                } else {
                    head.getCoordinates().setY(head.getCoordinates().getY() - SnakeGame.PIXEL_SIZE);
                }
                break;
            case 3:
                if (head.getCoordinates().getX() == 0) {
                    head.setCoordinates(new Coordinates(SnakeGame.PIXEL_SIZE * 19, head.getCoordinates().getY()));
                } else {
                    head.getCoordinates().setX(head.getCoordinates().getX() - SnakeGame.PIXEL_SIZE);
                }
                break;
            case 4:
                if (head.getCoordinates().getY() == SnakeGame.PIXEL_SIZE * 19) {
                    head.setCoordinates(new Coordinates(head.getCoordinates().getX(), 0));
                } else {
                    head.getCoordinates().setY(head.getCoordinates().getY() + SnakeGame.PIXEL_SIZE);
                }
                break;
            default:
                break;
        }
        bodyParts.set(0, head);
    }

    public int getBodyLength() {
        return size;
    }

    public ArrayList<BodyPart> getBody() {
        return bodyParts;
    }
}

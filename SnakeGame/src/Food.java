import java.util.Random;

public class Food {
    
    private Coordinates coordinates;

    public Food() {
        Random rand = new Random();
        int xLocation = rand.nextInt(20);
        int yLocation = rand.nextInt(20);

        this.coordinates = new Coordinates(xLocation * SnakeGame.PIXEL_SIZE, yLocation * SnakeGame.PIXEL_SIZE);
    }
    public Coordinates getCoordinates() {
        return coordinates;
    }
}

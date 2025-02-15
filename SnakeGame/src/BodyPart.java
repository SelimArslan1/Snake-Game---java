public class BodyPart {
    
    private Coordinates coordinates;
    private int direction;

    BodyPart(Coordinates coordinates, int direction) {
        this.coordinates = coordinates;
        this.direction = direction;
    }

    public int getDirection() {
        return direction;
    }
    public Coordinates getCoordinates() {
        return coordinates;
    }
    public void setDirection(int direction) {
        this.direction = direction;
    }
    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }
}

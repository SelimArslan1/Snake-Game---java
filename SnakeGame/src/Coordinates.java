public class Coordinates {
    
    private int x;
    private int y;

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public Coordinates() {
        this.x = 0;
        this.y = 0;
    }
    public boolean equals(Coordinates co) {
        return (this.getX() == co.getX()) && (this.getY() == co.getY());
    }

    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public int getX() {
        return this.x;
    }
    public int getY() {
        return this.y;
    }
}

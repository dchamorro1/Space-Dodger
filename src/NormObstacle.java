import java.awt.*;

public class NormObstacle extends Collidable {

    private Color color;

    public double x;
    public double y;

    public int hits;
    public int speed;

    public NormObstacle(Rectangle rect, Color color, int hits, double x, double y, int speed) {
        super(rect);
        this.color = color;
        this.hits = hits;
        this.x = x;
        this.y = y;
        this.speed = speed;
    }

    public void update()
    {
        int newX = ((int)getRect().getX()-speed);
        setRect(new Rectangle(newX,(int)getRect().getY() , (int)getRect().getWidth(), (int)getRect().getHeight()));
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setHits(int hits) {
        this.hits = hits;
    }

    public int getHits() {
        return hits;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}


import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Player extends Collidable {

    public boolean up = false;
    public boolean down = false;
    public boolean left = false;
    public boolean right = false;
    public double x;
    public double y;

    private Color color;
    public boolean direction;
    private int speed;
    private int width;
    private int height;

    public Player(Rectangle rect, Color color, int speed, int x, int y, int width,int height) {
        super(rect);
        this.color = color;
        this.speed = speed;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        //this.direction = direction;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setX(double x)
    {
        this.x=x;
        setRect(new Rectangle((int)x,(int)y,width,height));
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
        setRect(new Rectangle((int)x,(int)y,width,height));
    }

    public int getSpeed()
    {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setUp(boolean direction) {
        up = direction;
    }

    public void setDown(boolean direction) {
        down = direction;
    }

    public void setLeft(boolean direction) {
        left = direction;
    }

    public void setRight(boolean direction) {
        right = direction;
    }

    public int getWidth()
    {
        return width;
    }

    public void setWidth(int width)
    {
        this.width = width;
        setRect(new Rectangle ((int)x,(int)y,width,height));
    }

    public int getHeight()
    {
        return height;
    }

    public void setHeight(int height)
    {
        this.height = height;
        setRect(new Rectangle ((int)x,(int)y,width,height));
    }


    public void update()
    {
        if(left)
        {
            moveTo(getX()-speed,getY());
        }
        else if(right)
        {
            moveTo(getX()+speed,getY());
        }
        else if (up)
        {
            moveTo(getX(),getY()-speed);
        }
        else if(down)
        {
            moveTo(getX(),getY()+speed);
        }
    }

    public void moveTo(double x, double y)
    {
        setX(x);
        setY(y);
        setRect(new Rectangle((int)x,(int)y,getWidth(),getHeight()));
    }
}


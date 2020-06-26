
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

public class Shield{

    ArrayList<BufferedImage> shield = new ArrayList<BufferedImage>();

    public BufferedImage image;

    public int x;
    public int y;

    public Shield(int x, int y) {
        this.x = x;
        this.y = y;

        try {
            image = ImageIO.read(new File("shield.jpg"));

            shield.add(image);
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

    public void update()
    {
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}


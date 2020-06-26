import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class Background {
    private BufferedImage image;
    public String direction = "";

    private int worldX;
    private int worldY;

    public Background() {
        this(0,0);
    }

    public Background(int worldX, int worldY) {
        this.worldX = worldX;
        this.worldY = worldY;

        try {
            image = ImageIO.read(new File("background.jpg"));
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

    public void draw(Graphics window) {
        window.drawImage(image, getWorldX(), getWorldY(), image.getWidth(), image.getHeight(), null);

        this.worldX -= 1;

        if (this.worldX <= -1 * image.getWidth()) {

            this.worldX = this.worldX + image.getWidth() * 2;
        }
    }

    public void setWorldX(int worldX) {
        this.worldX = worldX;
    }
    public int getWorldX() {
        return this.worldX;
    }
    public int getWorldY() {
        return this.worldY;
    }
    public int getImageWidth() {
        return image.getWidth();
    }

    public String toString() {
        return null;
    }

}
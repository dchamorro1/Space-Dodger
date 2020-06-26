
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

public class Explosion{

   ArrayList<BufferedImage> explosions = new ArrayList<BufferedImage>();

    public BufferedImage image;

    public boolean show;

    public int x;
    public int y;

    public Explosion(int x, int y) {
        this.x = x;
        this.y = y;

        try {
            int subWidth = 64;
            int subHeight = 64;

            image = ImageIO.read(new File("explosion.jpg"));

            explosions.add(image.getSubimage(0, 0, subWidth, subHeight));
            explosions.add(image.getSubimage(subWidth , 0, subWidth, subHeight));
            explosions.add(image.getSubimage(subWidth*2 , 0, subWidth, subHeight));
            explosions.add(image.getSubimage(subWidth*3 , 0, subWidth, subHeight));

            explosions.add(image.getSubimage(0 , subHeight, subWidth, subHeight));
            explosions.add(image.getSubimage(subWidth , subHeight, subWidth, subHeight));
            explosions.add(image.getSubimage(subWidth * 2, subHeight, subWidth, subHeight));
            explosions.add(image.getSubimage(subWidth * 3 , subHeight, subWidth, subHeight));

            explosions.add(image.getSubimage(0 , subHeight * 2, subWidth, subHeight));
            explosions.add(image.getSubimage(subWidth , subHeight * 2, subWidth, subHeight));
            explosions.add(image.getSubimage(subWidth * 2 , subHeight * 2, subWidth, subHeight));
            explosions.add(image.getSubimage(subWidth * 3 , subHeight * 2, subWidth, subHeight));

            explosions.add(image.getSubimage(0 , 0, subWidth * 3, subHeight));
            explosions.add(image.getSubimage(subWidth  , 0, subWidth * 3, subHeight));
            explosions.add(image.getSubimage(subWidth * 2, 0, subWidth * 3, subHeight));
            explosions.add(image.getSubimage(subWidth * 3 , 0, subWidth * 3, subHeight));
        }
        catch (Exception e) {
            System.out.println(e);
        }

    }

    public void update()
    {
       show = true;
    }

    //use this to return the needed frame of the explosion
    public BufferedImage getImage(int index)
    {
        return explosions.get(index);
    }

    public boolean isShow()
    {
        return show;
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


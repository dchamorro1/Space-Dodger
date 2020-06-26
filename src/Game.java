import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    long startTime = System.nanoTime();

    public int shootStart = 0; // currently unnecessary

    Player player;

    ArrayList<NormObstacle> strong = new ArrayList<NormObstacle>();

    ArrayList<NormObstacle> big = new ArrayList<NormObstacle>();

    ArrayList<NormObstacle> shield = new ArrayList<NormObstacle>();

    ArrayList<Explosion> explosion = new ArrayList<Explosion>();

    ArrayList<NormObstacle> shooter = new ArrayList<NormObstacle>();

    ArrayList<NormObstacle> bullet = new ArrayList<NormObstacle>();

    ArrayList<NormObstacle> laser = new ArrayList<NormObstacle>();

    ArrayList<NormObstacle> beam = new ArrayList<NormObstacle>();

    ArrayList<Shield> shieldPic = new ArrayList<Shield>();


    public Game() {
        super();
    }

    public void loadLevel(int level)
    {

        if(level == 1) {
            player = new Player(new Rectangle(5, 200, 10, 10), Color.GREEN, 5, 5, 200, 10, 10);

            //deletes previous strong
            strong.clear();
            big.clear();
            shield.clear();
            shooter.clear();
            bullet.clear();
            laser.clear();

            try
            {
                int x = 0;
                int y = 0;
                Scanner fromFile = new Scanner(new File(".idea/Level1.txt"));

                while(fromFile.hasNextLine())
                {
                    Scanner fromText = new Scanner(fromFile.nextLine());

                    while(fromText.hasNextInt())
                    {
                        int num = fromText.nextInt();
                        x++;
                        if(num == 0)
                        {
                            x+=49;
                        }
                        if(num == 1)
                        {
                            strong.add( new NormObstacle(new Rectangle(x, y, 47, 20), Color.RED, 0, x, y, 3));
                            x+=49;
                        }
                        if(num == 2)
                        {
                            big.add( new NormObstacle(new Rectangle(x, y, 47, 20), Color.cyan, 0, x, y, 8));
                            x+=49;
                        }
                        if(num == 3)
                        {
                            shield.add( new NormObstacle(new Rectangle(x, y, 47, 20), Color.GREEN, 0, x, y, 15));
                            x+=49;
                        }
                        if(num == 4)
                        {
                            shooter.add( new NormObstacle(new Rectangle(x, y, 47, 20), Color.YELLOW, 0, x, y, 2));

                            x+=49;
                        }

                        if(num == 5)
                        {
                            laser.add( new NormObstacle(new Rectangle(x, y, 47, 20), Color.BLACK, 0, x, y, 2));

                            x+=49;
                        }
                    }
                    x=25;
                    y+=22;
                }
            }
            catch(Exception e)
            {
                e.printStackTrace();
                System.exit(0);
            }
            explosion.add(new Explosion(100,100));
            shieldPic.add(new Shield(380,10));
        }

        if(level == 2) {
            player = new Player(new Rectangle(5, 200, 10, 10), Color.GREEN, 5, 5, 200, 10, 10);

            //deletes previous strong
            strong.clear();
            big.clear();
            shield.clear();
            shooter.clear();
            bullet.clear();
            laser.clear();

            try
            {
                int x = 0;
                int y = 0;
                Scanner fromFile = new Scanner(new File(".idea/Level2.txt"));

                while(fromFile.hasNextLine())
                {
                    Scanner fromText = new Scanner(fromFile.nextLine());

                    while(fromText.hasNextInt())
                    {
                        int num = fromText.nextInt();
                        x++;
                        if(num == 0)
                        {
                            x+=49;
                        }
                        if(num == 1)
                        {
                            strong.add( new NormObstacle(new Rectangle(x, y, 47, 20), Color.RED, 0, x, y, 3));
                            x+=49;
                        }
                        if(num == 2)
                        {
                            big.add( new NormObstacle(new Rectangle(x, y, 47, 20), Color.cyan, 0, x, y, 4));
                            x+=49;
                        }
                        if(num == 3)
                        {
                            shield.add( new NormObstacle(new Rectangle(x, y, 47, 20), Color.GREEN, 0, x, y, 4));
                            x+=49;
                        }
                        if(num == 4)
                        {
                            shooter.add( new NormObstacle(new Rectangle(x, y, 47, 20), Color.YELLOW, 0, x, y, 2));
                            x+=49;
                        }

                        if(num == 5)
                        {
                            laser.add( new NormObstacle(new Rectangle(x, y, 47, 20), Color.BLACK, 0, x, y, 2));

                            x+=49;
                        }
                    }
                    x=25;
                    y+=22;
                }
            }
            catch(Exception e)
            {
                e.printStackTrace();
                System.exit(0);
            }
            explosion.add(new Explosion(100,100));
            shieldPic.add(new Shield(380,10));
        }

        if(level == 3) {
            player = new Player(new Rectangle(5, 200, 10, 10), Color.GREEN, 5, 5, 200, 10, 10);

            //deletes previous strong
            strong.clear();
            big.clear();
            shield.clear();
            shooter.clear();
            bullet.clear();
            laser.clear();

            try
            {
                int x = 0;
                int y = 0;
                Scanner fromFile = new Scanner(new File(".idea/Level3.txt"));

                while(fromFile.hasNextLine())
                {
                    Scanner fromText = new Scanner(fromFile.nextLine());

                    while(fromText.hasNextInt())
                    {
                        int num = fromText.nextInt();
                        x++;
                        if(num == 0)
                        {
                            x+=49;
                        }
                        if(num == 1)
                        {
                            strong.add( new NormObstacle(new Rectangle(x, y, 47, 20), Color.RED, 0, x, y, 3));
                            x+=49;
                        }
                        if(num == 2)
                        {
                            big.add( new NormObstacle(new Rectangle(x, y, 47, 20), Color.cyan, 0, x, y, 4));
                            x+=49;
                        }
                        if(num == 3)
                        {
                            shield.add( new NormObstacle(new Rectangle(x, y, 47, 20), Color.GREEN, 0, x, y, 4));
                            x+=49;
                        }
                        if(num == 4)
                        {
                            shooter.add( new NormObstacle(new Rectangle(x, y, 47, 20), Color.YELLOW, 0, x, y, 2));
                            x+=49;
                        }

                        if(num == 5)
                        {
                            laser.add( new NormObstacle(new Rectangle(x, y, 47, 20), Color.BLACK, 0, x, y, 2));

                            x+=49;
                        }
                    }
                    x=25;
                    y+=22;
                }
            }
            catch(Exception e)
            {
                e.printStackTrace();
                System.exit(0);
            }
            explosion.add(new Explosion(100,100));
            shieldPic.add(new Shield(380,10));
        }
    }

    int t1;

    public int getSeconds()
    {
        //Returns the time in seconds since the game started,
        // or the time it took before the game ended
        t1 = (int)(((System.nanoTime()-startTime)/1000000000));
        return t1;
    }
}

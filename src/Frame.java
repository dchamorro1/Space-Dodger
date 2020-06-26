import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

//GET RECT AND ACTUAL PAINTED VERSION OF CYAN RECTANGLE ARE NOT IN THE SAME PLACE

//add more obstacles and ways of dying
//finish making teh score

public class Frame extends JFrame implements Runnable, KeyListener {

    private static final int UPS = 35;

    private int totalLives = 40;

    private long updatesDone = 0;

    private BufferedImage buffer1 = null;

    public Background backOne;
    public Background backTwo;

    public BufferedImage back;

    private int level = 1;

    private Game game = new Game();

    private boolean finalScreen = false;

    private boolean youWon = false;
    private boolean youLost = false;

    private boolean explosion = false;

    private int explosionX = 0;
    private int explosionY = 0;

    private boolean whiteScreen = false;

    private int count = 0;

    private boolean shieldUp = false;

    private int shieldStart = 0;

    private int shieldEnd = 0;

    private boolean laserTime = false;

    private int laserStart = 0;

    private int laserEnd = 0;

    private boolean space = false;

    private int endScore;


    public Frame() {
        super("Side Scroller Game");

        game.loadLevel(level);

        setSize(600, 400);

        //setDefaultCloseOperation(EXIT_ON_CLOSE);

        backOne = new Background();
        backTwo = new Background(backOne.getImageWidth(), 0);

        buffer1 = new BufferedImage(getWidth(),getHeight(),BufferedImage.TYPE_4BYTE_ABGR);

        addKeyListener(this);
        setUndecorated(true);
        setResizable(false);
        setVisible(true);

        Thread t = new Thread(this);
        t.start();

        //int finalScore = 0;
    }

    private int score = 0;

    public void paint(Graphics g) {
        Graphics bg = buffer1.getGraphics();

        bg.setColor(Color.BLUE);
        bg.fillRect(0,0,getWidth(),getHeight());

        if (back == null)
            back = (BufferedImage)(createImage(getWidth(), getHeight()));

       Graphics buffer = back.createGraphics();

        backOne.draw(buffer);
        backTwo.draw(buffer);

        bg.drawImage(back, 0, 0, null);

        //OBSTACLE STRONG
        //All strongBricks
        for (int i = 0; i < game.strong.size(); i++) {
            bg.setColor(game.strong.get(i).getColor());
            bg.fillRect((int) game.strong.get(i).getRect().getX(), (int) game.strong.get(i).getRect().getY(), (int) game.strong.get(i).getRect().getWidth(), (int) game.strong.get(i).getRect().getHeight());
        }

        //OBSTACLE BIG
        for (int i = 0; i < game.big.size(); i++) {
            bg.setColor(game.big.get(i).getColor());
            bg.fillRect((int) game.big.get(i).getRect().getX(), (int) game.big.get(i).getRect().getY(), (int) game.big.get(i).getRect().getWidth(), (int) game.big.get(i).getRect().getHeight());
        }

        //OBSTACLE SHIELD
        for (int i = 0; i < game.shield.size(); i++) {
            bg.setColor(game.shield.get(i).getColor());
            bg.fillRect((int) game.shield.get(i).getRect().getX(), (int) game.shield.get(i).getRect().getY(), (int) game.shield.get(i).getRect().getWidth(), (int) game.shield.get(i).getRect().getHeight());
        }

        //SHOOTER
        for (int i = 0; i < game.shooter.size(); i++) {
            bg.setColor(game.shooter.get(i).getColor());
            bg.fillRect((int) game.shooter.get(i).getRect().getX(), (int) game.shooter.get(i).getRect().getY(), (int) game.shooter.get(i).getRect().getWidth(), (int) game.shooter.get(i).getRect().getHeight());
        }


        //BULLET
        for (int i = 0; i < game.bullet.size(); i++) {
            bg.setColor(game.bullet.get(i).getColor());
            bg.fillRect((int) game.bullet.get(i).getRect().getX(), (int) game.bullet.get(i).getRect().getY(), (int) game.bullet.get(i).getRect().getWidth(), (int) game.bullet.get(i).getRect().getHeight());
        }

        //LASER
        for (int i = 0; i < game.laser.size(); i++) {
            bg.setColor(game.laser.get(i).getColor());
            bg.fillRect((int) game.laser.get(i).getRect().getX(), (int) game.laser.get(i).getRect().getY(), (int) game.laser.get(i).getRect().getWidth(), (int) game.laser.get(i).getRect().getHeight());
        }

        //BEAM
        for (int i = 0; i < game.beam.size(); i++) {
            bg.setColor(game.beam.get(i).getColor());
            bg.fillRect((int) game.beam.get(i).getRect().getX(), (int) game.beam.get(i).getRect().getY(), (int) game.beam.get(i).getRect().getWidth(), (int) game.beam.get(i).getRect().getHeight());
        }

        //SHIELD PIC
        if(shieldUp) {
            for (int i = 0; i < game.shieldPic.size(); i++) {
                bg.drawImage(game.shieldPic.get(i).shield.get(0), 450, 10, null);
            }
        }

        repaint();

        int time = game.getSeconds();

        score = time*10;

        //whiteScreen
        if(whiteScreen)
        {
            count++;
            bg.setColor(Color.white);
            bg.fillRect(0, 0, 600, 400);

            //EXPLOSION
            for(int i=0; i < game.explosion.size(); i++)
            {

                if(count > 0 && count < 6)
                    bg.drawImage(game.explosion.get(i).explosions.get(0), explosionX, explosionY, null);
                else if(count > 6 && count < 12)
                    bg.drawImage(game.explosion.get(i).explosions.get(1), explosionX, explosionY, null);
                else if(count > 12 && count < 18)
                    bg.drawImage(game.explosion.get(i).explosions.get(2), explosionX, explosionY, null);
                else if(count > 18 && count < 24)
                    bg.drawImage(game.explosion.get(i).explosions.get(3), explosionX, explosionY, null);
                else if(count > 24 && count < 30)
                    bg.drawImage(game.explosion.get(i).explosions.get(4), explosionX, explosionY, null);
                else if(count > 30 && count < 36)
                    bg.drawImage(game.explosion.get(i).explosions.get(5), explosionX, explosionY, null);
                else if(count > 36 && count < 42)
                    bg.drawImage(game.explosion.get(i).explosions.get(6), explosionX, explosionY, null);
                else if(count > 42 && count < 48)
                    bg.drawImage(game.explosion.get(i).explosions.get(7), explosionX, explosionY, null);
                else if(count > 48 && count < 54)
                    bg.drawImage(game.explosion.get(i).explosions.get(8), explosionX, explosionY, null);
                else if(count > 54 && count < 60)
                    bg.drawImage(game.explosion.get(i).explosions.get(9), explosionX, explosionY, null);
                else if(count > 60 && count < 66)
                    bg.drawImage(game.explosion.get(i).explosions.get(10), explosionX, explosionY, null);
                else if(count > 66 && count < 72)
                    bg.drawImage(game.explosion.get(i).explosions.get(11), explosionX, explosionY, null);
                else if(count > 72 && count < 78)
                    bg.drawImage(game.explosion.get(i).explosions.get(12), explosionX, explosionY, null);
                else if(count > 78 && count < 84)
                    bg.drawImage(game.explosion.get(i).explosions.get(13), explosionX, explosionY, null);
               // else if(count > 84 && count < 90)
                //    bg.drawImage(game.explosion.get(i).explosions.get(14), explosionX, explosionY, null);
                //else if(count > 90 && count < 96)
                 //   bg.drawImage(game.explosion.get(i).explosions.get(15), explosionX, explosionY, null);
                if(count > 96)
                {
                    whiteScreen = false;
                    count = 0;
                }
            }
        }
        if(count >= 72)
        {
            whiteScreen = false;
            count = 0;
        }

        //PLAYER
        bg.setColor(game.player.getColor());
        bg.fillRect((int) game.player.getRect().getX(), (int) game.player.getRect().getY(), (int) game.player.getRect().getWidth(), (int) game.player.getRect().getHeight());

        //SCORE
        if(!youLost || !youWon)
            bg.drawString("Score: " + score, 510, 30);

        if(finalScreen) {
            bg.setColor(game.player.getColor());
            bg.fillRect(0, 0, 600, 400);

            bg.setColor(Color.RED);
            if(youWon)
                bg.drawString("YOU WON", 300, 100);
            if(youLost) {
                bg.drawString("YOU'VE LOST. TRY AGAIN", 300, 100);
        }
        }
        else {
            bg.drawString("Level: " + level, 280, 15);
        }

        bg.drawString("Total Lives: " + totalLives, 30, 30);

        g.drawImage(buffer1,0,0,null);
    }

    public void resetPlayer(int level)
    {
            game.player.setX(5);
            game.player.setY(200);
    }

    @Override
    public void run() {
        long startTime = System.nanoTime();
        double sleepTime = 1000.0/UPS;

            while (true)
            {
                boolean didUpDate = false;
                long updatesNeed = (long)(((System.nanoTime()-startTime)/1000000)/sleepTime);

                for(;updatesDone<updatesNeed; updatesDone++) {
                    update();
                    didUpDate = true;
                }

                if(didUpDate)
                    repaint();

                try
                {
                    Thread.sleep((int)sleepTime);
                }catch(Exception e)
                {}
            }
        }

    public void update() {
        double oldX = game.player.getX();
        double oldY = game.player.getY();

        //main player
        game.player.update();

        //explosion
        for(int i = 0; i < game.explosion.size(); i++) {
            game.explosion.get(i).update();
        }

        //red strong obstacles
        for (int i = 0; i < game.strong.size(); i++) {
            game.strong.get(i).update();
        }
        //cyan big obstacles
        for (int i = 0; i < game.big.size(); i++) {
            game.big.get(i).update();
        }

        //SHIELD
        for (int i = 0; i < game.shield.size(); i++) {
            game.shield.get(i).update();
        }

        //SHOOTER
        for (int i = 0; i < game.shooter.size(); i++) {
            game.shooter.get(i).update();
        }

        //BULLET
        for (int i = 0; i < game.bullet.size(); i++) {
            game.bullet.get(i).update();
        }

        //LASER
        for (int i = 0; i < game.laser.size(); i++) {
            game.laser.get(i).update();
        }

        //BEAM
        for (int i = 0; i < game.beam.size(); i++) {
            game.beam.get(i).update();
        }

        //BOUNDS CHECK for bottom and right
        if(game.player.getRect().x >=600 || game.player.getRect().y >= 400 )
        {
            game.player.setX(oldX);
            game.player.setY(oldY);
        }
        //BOUNDS CHECK FOR X VALUE left
        if(game.player.getRect().x <= 0)
        {
            game.player.setX(0);
        }
        //BOUNDS CHECK FOR X VALUE right
        if(game.player.getRect().y <= 0)
        {
            game.player.setY(0);
        }

            //EXPLOSIVE INTERSECT
            for(int i = 0; i < game.strong.size(); i++) {
                if (game.player.getRect().intersects(game.strong.get(i).getRect()))
                {
                    if(!shieldUp) {
                        game.strong.remove(i);

                        explosion = true;
                        whiteScreen = true;

                        explosionX = (int) game.player.getRect().getX() + 5;
                        explosionY = (int) game.player.getRect().getY() + 5;

                        //resetPlayer(level);
                        game.player.setX(oldX - 90);
                        game.player.setY(oldY);

                        if(totalLives > 0 && !youWon)
                        totalLives--;
                        //game.loadLevel(level);

                        break;
                    }
                }
            }

        //BIG INTERSECT
        for(int i = 0; i < game.big.size(); i++) {
            if (game.player.getRect().intersects(game.big.get(i).getRect()))
            {
                if(!shieldUp) {
                    game.big.remove(i);

                    game.player.setWidth(game.player.getWidth() + 10);
                    game.player.setHeight(game.player.getHeight() + 10);

                    break;
                }
            }
        }

        //SHIELD INTERSECT
        for(int i = 0; i < game.shield.size(); i++) {
            if (game.player.getRect().intersects(game.shield.get(i).getRect()))
            {
                game.shield.remove(i);

                shieldUp = true;

                int time = game.getSeconds();

                shieldStart = time;
                shieldEnd = time + 5;

                break;
            }
        }

        //SHOOTER
        for(int i = 0; i < game.shield.size(); i++) {
            if (game.player.getRect().intersects(game.shield.get(i).getRect()))
            {
                if(!shieldUp) {
                    game.player.setX(oldX);
                    game.player.setY(oldY);

                    break;
                }
            }
        }

        //BULLET
        for(int i = 0; i < game.bullet.size(); i++) {
            if (game.player.getRect().intersects(game.bullet.get(i).getRect()))
            {
                if(!shieldUp) {
                    if(totalLives > 0 && !youWon)
                    totalLives--;

                    break;
                }
            }
        }

        //ADD BULLETS
            int time = game.getSeconds();

            if(time % 2 == 0)
            {
                for(int i = 0; i < game.shooter.size(); i++) {
                   game.bullet.add(new NormObstacle(new Rectangle( (int)game.shooter.get(i).getRect().getX() - 5, (int)game.shooter.get(i).getRect().getY() + 5, 1, 10), Color.YELLOW, 0, game.shooter.get(i).getRect().getX() - 5, game.shooter.get(i).getRect().getY() + 5, 5));
                }
            }

            //LASER BLOCK
        for(int i = 0; i < game.laser.size(); i++) {
            if (game.player.getRect().intersects(game.laser.get(i).getRect()))
            {
                    game.laser.remove(i);

                    laserTime = true;

                    int time2 = game.getSeconds();

                    laserStart = time2;

                    laserEnd = time2 + 5;

                    break;
            }
        }
        //BEAM
        //remove all other obstacles
        for(int i = 0; i < game.beam.size(); i++) {
            for(int b = 0; b < game.strong.size(); b++) {
                if (game.beam.get(i).getRect().intersects(game.strong.get(b).getRect())) {

                    game.strong.remove(b);

                    break;
                }
            }
        }

        //ADD BEAM
        int time2 = game.getSeconds();
        if(space && laserTime)
        {
            game.beam.add(new NormObstacle(new Rectangle( (int)game.player.getRect().getX() + 10, (int)game.player.getRect().getY() + 5, 1, 10), Color.BLACK, 0, game.player.getRect().getX() + 10, game.player.getRect().getY() + 5, -5));
        }

        //GO TO NEXT LEVEL
        if(game.getSeconds() == 2)
        {
           // if(level<3)
             //   level++;
               // game.loadLevel(level);

        }

        //END BEAM
        if (game.getSeconds() >= laserEnd)
        {
            laserTime = false;
        }

        //END SHIELD
        if (game.getSeconds() >= shieldEnd)
        {
            shieldUp = false;
        }

       if(totalLives == 0){
           level = 6;
           finalScreen = true;
           youLost = true;
       }

       if(game.getSeconds() >= 86)
       {
           youWon = true;
           finalScreen = true;
       }
    }

    @Override
    public void keyTyped(KeyEvent e) { }

    //will always be laggy in key pressed
    @Override
    public void keyPressed(KeyEvent e) {

        if(e.getKeyCode() == KeyEvent.VK_SPACE)
        {
            space = true;
        }

        if(e.getKeyCode() == KeyEvent.VK_ESCAPE)
        {
            System.exit(0);
        }

        if(e.getKeyCode() == KeyEvent.VK_UP)
            game.player.setUp(true);

        if(e.getKeyCode() == KeyEvent.VK_DOWN)
            game.player.setDown(true);

        if(e.getKeyCode() == KeyEvent.VK_LEFT)
            game.player.setLeft(true);

        if(e.getKeyCode() == KeyEvent.VK_RIGHT)
            game.player.setRight(true);

        //RESETS THE GAME//STILL HAVE TO TEST
        if(e.getKeyCode() == KeyEvent.VK_R)
        {

            //totalLives = 5;
           // game.loadLevel(level);
            //resetPlayer(level);

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

        if(e.getKeyCode() == KeyEvent.VK_SPACE)
        {
            space = false;
        }
        if(e.getKeyCode() == KeyEvent.VK_N)
        {
            if(level<3) {
                level++;
                totalLives++;
                game.loadLevel(level);
            }
        }

        if(e.getKeyCode() == KeyEvent.VK_UP)
            game.player.setUp(false);

        if(e.getKeyCode() == KeyEvent.VK_DOWN)
            game.player.setDown(false);

        if(e.getKeyCode() == KeyEvent.VK_LEFT)
            game.player.setLeft(false);

        if(e.getKeyCode() == KeyEvent.VK_RIGHT)
            game.player.setRight(false);

    }
}
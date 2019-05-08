package com.cctc.amatlock.test;

import com.cctc.amatlock.test.utilities.Images;

import java.awt.*;

public class Starship extends CoreObject
{
    private Laser[] lasers = new Laser[1000];
    private int laserCounter = 0;
    int score = 0;

    /**
     * Creates the core object. All subclasses
     * will call this with super.
     * The super call to the Rectangle class.
     *
     * @param x
     * @param y
     * @param width
     * @param height
     * @param color
     */
    public Starship(int x, int y, int width, int height, Color color) {
        super(x, y, width, height, color);
    }

    public void shoot()
    {
        Laser laser = new Laser(x+16, y, 4, 8, Color.red,true);
        laser.setVelY(-6);

        lasers[laserCounter] = laser;
        laserCounter++;

        if(laserCounter >= lasers.length)
        {
            laserCounter = 0;
        }
    }

    @Override
    public void tick() {
        if(destroyed)
        {
            return;
        }
        Point mouse = Screen.getInstance().mouse;

        if(mouse.x < this.x)
        {
            setVelX(-5);

        }
        else if(mouse.x > this.x + this.width)
        {
            setVelX(5);
        }
        else
        {
            setVelX(0);
        }

        x += velX;
        y += velY;

        for(int i = 0; i < laserCounter; i++)
        {
            lasers[i].tick();
        }
    }

    @Override
    public void render(Graphics g) {
        if (!destroyed) {
            g.setColor(color);
//            g.fillRect(x, y, width, height);
            g.drawImage(Images.ship, x, y, width, height, null);

            for (int i = 0; i < laserCounter; i++) {
                lasers[i].render(g);
            }
        }
    }
}

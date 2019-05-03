package com.cctc.amatlock.test;

import java.awt.*;

public class Goei extends CoreObject{
    private int ticks = Randomizer.nextInt(0,60);
    private Laser[] lasers = new Laser[100];
    private int laserCounter = 0;

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
    public Goei(int x, int y, int width, int height, Color color) {
        super(x, y, width, height, color);
    }

    public void shoot()
    {
        Laser laser = new Laser(x, y, 4, 8, Color.red, false);
        laser.setVelY(6);

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
        ticks++;
        if(ticks > 60)
        {
            shoot();
            ticks = 0;
        }

        if( x > Reference.WIDTH - width*2)
        {
           setVelX(-5);
            y += 40;
        }
        else if(x < 0)
        {
            setVelX(5);
            y += 40;
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
            g.fillRect(x, y, width, height);

            for (int i = 0; i < laserCounter; i++) {
                lasers[i].render(g);
            }
        }
    }
}

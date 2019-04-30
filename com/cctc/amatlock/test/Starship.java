package com.cctc.amatlock.test;

import java.awt.*;

public class Starship extends CoreObject
{
    private Laser[] lasers = new Laser[100];
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
        Laser laser = new Laser(x, y, 4, 8, Color.red);
        laser.setVelY(-6);
        lasers[laserCounter] = laser;
        laserCounter ++;
    }

    @Override
    public void tick() {
        Point mouse = Screen.getInstance().mouse;
        if(mouse.x < this.x)
        {
            setVelX(-1);

        }
        else if(mouse.x > this.x)
        {
            setVelX(1);
        }

        x += velX;
        y += velY;

        for(int i =0; i < laserCounter; i++)
        {
            lasers[i].tick();
        }
    }

    @Override
    public void render(Graphics g) {
        g.setColor(color);
        g.fillRect(  x,  y,  width, height );

        for(int i =0; i < laserCounter; i++)
        {
            lasers[i].render(g);
        }
    }
}

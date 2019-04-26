package com.cctc.amatlock.test;

import java.awt.*;

public class Starship extends CoreObject
{
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
        Screen.addObject(laser);
    }

    @Override
    public void tick() {

        x += velX;
        y += velY;


    }

    @Override
    public void render(Graphics g) {
        g.setColor(color);
        g.fillRect(  x,  y,  width, height );
    }
}

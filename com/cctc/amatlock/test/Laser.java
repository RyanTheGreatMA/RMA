package com.cctc.amatlock.test;

import java.awt.*;

public class Laser extends CoreObject{
    public boolean ally;


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
    public Laser(int x, int y, int width, int height, Color color, boolean ally) {
        super(x, y, width, height, color);
        this.ally = ally;
    }

    @Override
    public void tick() {

        Starship ship = Screen.getInstance().ship;
        if (destroyed )
        {
            return;
        }
        if(ally)
        {
            for (int i =0; i < Screen.getObjectCounter(); i++)
            {
                CoreObject obj = Screen.getCoreObjects()[i];
                if (intersects(obj) && !obj.destroyed)
                {


                    obj.destroy();
                    ship.score++;
                    destroy();
                }
            }
        }
        else
        {
            if (intersects(ship) && !ship.destroyed)
            {

                ship.destroy();
            }
        }


        x += velX;
        y += velY;

    }

    @Override
    public void render(Graphics g) {
        if (destroyed )
        {
            return;
        }
        g.setColor(color);
        g.fillRect(  x,  y,  width, height );

    }
}

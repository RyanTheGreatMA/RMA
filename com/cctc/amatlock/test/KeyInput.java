package com.cctc.amatlock.test;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyInput implements KeyListener
{
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        Starship ship = Screen.getInstance().ship;

        if(e.getKeyCode() == KeyEvent.VK_A)
        {
            ship.setVelX(-5);
        }
        else if (e.getKeyCode() == KeyEvent.VK_D)
        {
            ship.setVelX(5);
        }
        else if (e.getKeyCode() == KeyEvent.VK_SPACE)
        {
            ship.shoot();
        }
        else if(e.getKeyCode() == KeyEvent.VK_R)
        {
            Screen.getInstance().reset();
        }
        else if(e.getKeyCode() == KeyEvent.VK_UP)
        {
            Screen.difficulty++;
        }

        else if(e.getKeyCode() == KeyEvent.VK_DOWN)
        {
            Screen.difficulty--;
        }
    }

    @Override
    public void keyReleased(KeyEvent e)
    {
        Starship ship = Screen.getInstance().ship;

        if(e.getKeyCode() == KeyEvent.VK_A)
        {
            ship.setVelX(0);
        }
        else if (e.getKeyCode() == KeyEvent.VK_D)
        {
            ship.setVelX(0);
        }
    }

}

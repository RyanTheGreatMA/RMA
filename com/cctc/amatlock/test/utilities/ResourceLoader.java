package com.cctc.amatlock.test.utilities;

import java.io.IOException;

public class ResourceLoader
{
    private static ImageLoader imageLoader = new ImageLoader();
    private static SoundLoader soundLoader = new SoundLoader();
    // Creates an instance of ImageLoader
    // This is used to load each image


    /**
     * This method will load and store every image
     * we plan to use in our program. This is the
     * only method we will change when we need to
     * add more images.
     */
    public static void loadImages()
    {
        // The try/catch is code to catch if
        // any image isn't found.
        try{
            Images.ship = imageLoader.loadImage("ship.png");
            Images.goei = imageLoader.loadImage("goei.png");
            Images.background = imageLoader.loadImage("background.png");
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public static void loadSounds()
    {
        // The try/catch is code to catch if
        // any image isn't found.
        try{
//            Sounds.background = soundLoader.loadSound("background.wav");
            Sounds.alien = soundLoader.loadSound("alien.wav");

        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}

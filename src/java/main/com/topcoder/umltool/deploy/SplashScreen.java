/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.Rectangle;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Robot;
import java.awt.AWTException;

import javax.swing.ImageIcon;
import javax.swing.JWindow;

/**
 * <p>
 * Splash screen of the uml tool.
 * </p>
 *
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class SplashScreen extends JWindow implements Runnable {
    /**
     * A writable off screen image.
     */
    private BufferedImage bufImage;

    /**
     * The rectangle to be captured.
     */
    private Rectangle rect;

    /**
     * True if initialization thread is running.
     */
    private boolean isAlive;

    /**
     * Constructor for the SplashScreen object. Starts initialization and showing of the splash screen immediately.
     *
     * @param imageFile
     *            File path of the Image to display.
     */
    public SplashScreen() {

        run();
    }

    /**
     * Starts the initialization thread of the SplashScreen.
     */
    public void run() {
        isAlive = true;
        // use ImageIcon, so we don't need to use MediaTracker
        Image image = new ImageIcon(SplashScreen.class.getResource("/images/UML_splash.png")).getImage();
        int imageWidth = image.getWidth(this);
        int imageHeight = image.getHeight(this);

        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        // this.setLocation(location);
        if (imageWidth > 0 && imageHeight > 0) {
            // a Rectangle centered on screen
            rect =
                new Rectangle(screen.width / 2 - imageWidth / 2, screen.height / 2 - imageHeight / 2, imageWidth,
                    imageHeight);
            // the critical lines, create a screen shot
            try {
                bufImage = new Robot().createScreenCapture(rect);
            } catch (AWTException e) {
                DeployHelper.logException(e);
            }
            // obtain the graphics context from the BufferedImage
            Graphics2D g2D = bufImage.createGraphics();
            // Draw the image over the screen shot
            g2D.drawImage(image, 0, 0, this);
            // draw the modified BufferedImage back into the same space
            setBounds(rect);
            // present our work :)
            setVisible(true);
        }
        isAlive = false;
    }

    /**
     * Disposes of the SplashScreen. To be called shortly before the main application is ready to be displayed.
     *
     * @exception IllegalStateException
     *                Is thrown if the initialization thread has not yet reached it's end.
     */
    public void close() throws IllegalStateException {
        if (!isAlive) {
            dispose();
        } else {
            // better not dispose a SplashScreen that has not been painted on screen yet.
            throw new IllegalStateException("SplashScreen not yet fully initialized.");
        }
    }

    /**
     * Overrides the paint() method of JWindow.
     *
     * @param g
     *            The graphics context
     */
    public void paint(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;
        g2D.drawImage(bufImage, 0, 0, this);
    }
}

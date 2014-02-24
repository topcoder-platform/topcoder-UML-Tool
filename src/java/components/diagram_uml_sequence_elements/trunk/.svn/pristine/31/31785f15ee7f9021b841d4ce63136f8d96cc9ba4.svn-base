/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.sequenceelements.lifeline;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.print.PrinterException;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * This helper class prints Graphics content as a jpg file.
 *
 * <p>
 * This AccuracyTestImagePrinter class is from
 * com.topcoder.gui.diagramviewer.uml.sequenceelements.accuracytestsfrom in v1.0. It is used here to
 * test the painting method in LifelineSegment and LifeLine.
 * </p>
 *
 * @author ch_music
 * @version 1.1
 * @since 1.0
 */
public class AccuracyTestImagePrinter {
    /**
     * Path to store the generated jpg files.
     */
    private final String path;

    /**
     * BufferedImage on which the print result drawn.
     */
    private BufferedImage image;

    /**
     * The Graphics.
     */
    private Graphics graphics;

    /**
     * Creates a new ImagePrinter object given with the path of generated jpg.
     *
     * @param path path where the jpg files store
     */
    public AccuracyTestImagePrinter(String path) {
        this.path = path;
    }

    /**
     * Prints to jpg file. Calls initImage first to get the Graphics object and initialized the
     * Graphics object.
     *
     * @throws PrinterException if error occurred while printting
     * @throws IOException if error occurred while generating the jpg file
     */
    public void print() throws PrinterException, IOException {
        ImageIO.write(image, "jpg", new File(path));
    }

    /**
     * Initialize the image.
     *
     * @return Graphics
     */
    public Graphics initImage() {
        image = new BufferedImage(400, 400, BufferedImage.TYPE_3BYTE_BGR);

        graphics = image.getGraphics();
        graphics.setColor(Color.LIGHT_GRAY);
        graphics.fillRect(0, 0, 400, 400);

        return graphics;
    }
}

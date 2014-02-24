/*
 * Copyright (C) 2005 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.swing.print;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


/**
 * Helper class to print the Printable object into a jpg file.
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class ImagePrinter {
    /** Default PageFormat the printing result used. */
    private static final PageFormat PAGE_FORMAT = new PageFormat();

    /** Path to store the generated jpg files. */
    private final String path;

    /** Whethere the given path exists. */
    private final boolean pathExist;

    /** Width of the page. */
    private final int width;

    /** Height of the page. */
    private final int height;

    /** BufferedImage on which the print result drawn. */
    private BufferedImage image;

/**
     * Creates a new ImagePrinter object given with the path of generated jpg.
     *
     * @param path path where the jpg files store
     */
    public ImagePrinter(String path) {
        this.path = path;

        if (path == null) {
            this.pathExist = false;
        } else {
            this.pathExist = new File(path).exists();
        }

        width = (int) Math.round(PAGE_FORMAT.getWidth());
        height = (int) Math.round(PAGE_FORMAT.getHeight());
    }

/**
     * Creates a new ImagePrinter object, the jpg files storing path is specified by environment variable.
     */
    public ImagePrinter() {
        this(".\\test_files\\print_result\\");
    }

    /**
     * Print the printable into the jpg file given with the file name.
     *
     * @param printable printable
     * @param fileName prefix of the jpg file expected to be generated
     *
     * @throws PrinterException if error occurred while printting
     * @throws IOException if error occurred while generating the jpg file
     */
    public void print(Printable printable, String fileName)
        throws PrinterException, IOException {
        if (!pathExist) {
            System.out.println("directory:" + path + " not found, can not print to jpg file, please "
                    + "set the environment:PRINT_RESULT to a valid directory path");

            return;
        }

        Graphics graphics = initImage();
        int page = 0;
        int result = printable.print(graphics, PAGE_FORMAT, page);

        while (result == Printable.PAGE_EXISTS) {
            String filePath = path + File.separator + fileName + "_" + page + ".jpg";
            ImageIO.write(image, "jpg", new File(filePath));

            graphics = initImage();

            System.out.println("print to file:" + filePath + " success");
            page++;
            result = printable.print(graphics, PAGE_FORMAT, page);
        }
    }

    /**
     * Initialize the image.
     *
     * @return Graphics
     */
    private Graphics initImage() {
        image = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);

        Graphics graphics = image.getGraphics();
        graphics.setColor(Color.GRAY);
        graphics.fillRect(0, 0, width, height);

        return graphics;
    }
}

/*
 * Copyright (C) 2005 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.swing.print;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JFrame;


/**
 * JFrame used in test.
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class PrintFrame extends JFrame {
    /** inner component to be printed. */
    private Component comp;

/**
     * Creates a new PrintFrame object with text.
     *
     * @param text text
     */
    public PrintFrame(String text) {
        this(600, 600, text, true);
    }

/**
     * Creates a new PrintFrame object.
     *
     * @param width width of the inner component
     * @param height height of the inner component
     * @param text text of the inner component
     * @param visible visibility of the inner component
     */
    public PrintFrame(int width, int height, String text, boolean visible) {
        super("The component to be printed");
        comp = new PrintingPanel(width, height, text);
        getContentPane().add(comp, BorderLayout.CENTER);
        pack();
        setVisible(true);
        comp.setVisible(visible);
    }

    /**
     * Return the inner component to be printed.
     *
     * @return inner component
     */
    public Component getPrintingComponent() {
        return comp;
    }
}

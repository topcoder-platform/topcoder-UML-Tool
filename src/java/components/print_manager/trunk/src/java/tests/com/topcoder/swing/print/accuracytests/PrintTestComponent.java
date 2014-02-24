/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.swing.print.accuracytests;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * This class provides a component to be printed by the accuracy tests.
 * 
 * @author ch_music
 * @version 1.0
 */
public class PrintTestComponent extends JPanel {
    
    /**
     * A serialVersionUID for this class.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Creates a new PrintTestComponent.
     */
    public PrintTestComponent() {
        super(new BorderLayout());

        setBackground(Color.GREEN);
        add(new JButton("This button should reside on top of the panel."), BorderLayout.PAGE_START);
        add(new JLabel("This label should reside in the middle of the panel. "
                + "The background of the page should be green."), BorderLayout.CENTER);
        add(new JButton("This button should reside at the bottom of the panel."), BorderLayout.PAGE_END);

        setPreferredSize(new Dimension(1000, 1000));
    }
}

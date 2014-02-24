/*
 * Copyright (C) 2005 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.swing.print;

import java.awt.Component;
import java.awt.Rectangle;

import java.util.ArrayList;
import java.util.List;

import com.topcoder.util.config.ConfigManager;
import com.topcoder.util.config.ConfigManagerException;


/**
 * Demo for Print Manager component. This demo shows how to:
 *  <ul>
 *      <li>Print Component thin a Rectangle area</li>
 *      <li>Print the whole Component</li>
 *      <li>Print a list of Component</li>
 *      <li>Print a list of Component within a Rectangle area list corresponding</li>
 *      <li>Print the result using "fit into page" strategy by which result will be scaled automatically and
 *      printed to a single page</li>
 *      <li>Print the result using "scale and split" strategy by which result will be scaled by specified
 *      factor and printed</li>
 *  </ul>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class Demo {
    /** Components to be printed used in this demo. */
    private List<Component> components;

    /** Rectangles used in this demo. */
    private List<Rectangle> rectangles;

    /**
     * Creates a new Demo.
     * @throws Exception if any error occurs
     */
    public Demo() throws Exception {
        init();
    }

    /**
     * Main entrance.
     *
     * @param args arguments
     */
    public static void main(String[] args) {
        try {
            new Demo().startDemo();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Initializes the default values.
     * @throws ConfigManagerException if any error occurs while reading from config
     */
    private void init() throws ConfigManagerException {
        components = new ArrayList<Component>();
        components.add(new PrintFrame(400, 400, "demo 400x400", true));
        components.add(new PrintFrame(500, 500, "demo 500x500", true));

        rectangles = new ArrayList<Rectangle>();
        rectangles.add(new Rectangle(0, 0, 200, 200));
        rectangles.add(new Rectangle(100, 0, 200, 200));

        //load config for demo
        ConfigManager.getInstance().add("Demo.xml");
    }

    /**
     * Start demo.
     */
    public void startDemo() throws Exception{
        //create a new PrintManager
        PrintManager manager = new PrintManager();

        //create a custom PrintManager(see Demo.xml)
        //custom PrintFormatRetriever and ComponentVisibleMaker can be used
        PrintManager customPrintManager = new PrintManager("demo");

        //get the user¡¯s preference for print format and scaling type
        manager.specifyPrintFormat();

        //print the whole component
        manager.print(components.get(0));

        //print the whole component within rectangle area
        manager.print(components.get(0), rectangles.get(0));

        //print the whole component list
        manager.print(components);

        //print the whole component list within rectangle area list corresponding
        manager.print(components, rectangles);

        //print a component without print dialog
        manager.setHasPrintDialog(false);
        manager.print(components.get(0));

        System.exit(0);
    }
}

/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.swing.print.impl;

import com.topcoder.swing.print.ComponentVisibleMaker;
import com.topcoder.swing.print.ParameterCheck;

import java.awt.Component;
import java.awt.Container;
import java.awt.Rectangle;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;


/**
 * <p>This class implements the VisibleMaker interface. This is the default implementation used by PrintManager
 * class.</p>
 *  <p>It is not thread safe, but it will be used in thread safe manner in PrintManager class.</p>
 *
 * @author Xuchen, TCSDEVELOPER
 * @version 1.0
 */
public class DefaultComponentVisibleMaker implements ComponentVisibleMaker {
    /**
     * <p>Represents the original bounds information of components which has been made visible from
     * invisible.</p>
     */
    private final Map<Component, Rectangle> bounds;

    /**
     * <p>Represents the original container parent information of components which has been made visible from
     * invisible. Note the container value maybe null which means there is no parent for given component.</p>
     */
    private final Map<Component, Container> parents;

    /**
     * <p>Represents the original zOrder information of component which has been made visible from invisible.
     * Note the value of zOrder maybe -1 when it has no parent contanter.</p>
     */
    private final Map<Component, Integer> zOrders;

    /**
     * <p>This map is used to store the temporary parent containers for made-visible components.</p>
     *  <p>To make a not displayable Component displayable, the Component should be added to a displayable
     * container. The JFrame is used as the temporary container. Before printing, the JFrame should be made
     * displayable by calling pack(). And after printing, it should be disposed by dispose().</p>
     */
    private final Map<Component, JFrame> newParents;

    /**
     * <p>Create a DefaultVisibleMaker instance.</p>
     */
    public DefaultComponentVisibleMaker() {
        bounds = new HashMap<Component, Rectangle>();
        parents = new HashMap<Component, Container>();
        zOrders = new HashMap<Component, Integer>();
        newParents = new HashMap<Component, JFrame>();
    }

    /**
     * <p>Make given invisible component visible.</p>
     *
     * @param component the given invisible component
     *
     * @throws IllegalArgumentException if the given component is null or visible already
     */
    public void makeVisible(Component component) {
        ParameterCheck.checkNull("component", component);

        if (component.getGraphics() != null) {
            throw new IllegalArgumentException("component is visible already");
        }

        this.bounds.put(component, component.getBounds());

        Container parent = component.getParent();

        if (parent != null) {
            this.parents.put(component, parent);
            this.zOrders.put(component, parent.getComponentZOrder(component));
        } else {
            this.zOrders.put(component, -1);
        }

        //creates a JFrame as new parent for the printing component
        JFrame jFrame = new JFrame();
        jFrame.setSize(0, 0);
        jFrame.add(component);
        jFrame.pack(); //set the jFrame to be displayable
        jFrame.setVisible(false); //hide the jFrame
        component.setVisible(true);

        //save the new parent so that it can be disposed later after printing
        newParents.put(component, jFrame);
    }

    /**
     * <p>Make the given visible component back to its original invisible state. This method should be called
     * after invocation of makevisible() method, otherwise, this method will throw IllegalArgumentException.</p>
     *
     * @param component the visible component need to back to original invisible state
     *
     * @throws IllegalArgumentException if the given component is null or not made visible heretofore
     */
    public void makeInvisible(Component component) {
        ParameterCheck.checkNull("component", component);

        if (!this.bounds.containsKey(component)) {
            throw new IllegalArgumentException("this method should be called after component is made visible");
        }

        Rectangle bound = this.bounds.remove(component);
        Container parent = this.parents.remove(component);
        int zOrder = this.zOrders.remove(component);

        if (parent != null) {
            parent.add(component, zOrder);
            parent.setComponentZOrder(component, zOrder);
        }
        component.setBounds(bound);

        //dispose the temporary parent
        JFrame temp = newParents.remove(component);
        temp.dispose();

        component.setVisible(false);
    }

    /**
     * <p>Clear the state of this ComponentVisibleMaker.</p>
     */
    public void clear() {
        bounds.clear();
        parents.clear();
        zOrders.clear();
        newParents.clear();
    }
}

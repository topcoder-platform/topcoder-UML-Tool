/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.swing.print.failuretests;

import java.util.Iterator;

import javax.swing.JFrame;

import junit.framework.TestCase;

import com.topcoder.swing.print.impl.DefaultComponentVisibleMaker;
import com.topcoder.util.config.ConfigManager;

/**
 * <p>
 * Failure test for <code>DefaultComponentVisibleMaker</code>.
 * </p>
 *
 * @author restarter
 * @version 1.0
 */
public class DefaultComponentVisibleMakerFailureTest extends TestCase {

    /**
     * <p>
     * The JFrame instance created for failure testing.
     * </p>
     */
    private JFrame frame;

    /**
     * <p>
     * The DefaultComponentVisibleMaker instance created for failure testing.
     * </p>
     */
    private DefaultComponentVisibleMaker maker;

    /**
     * <p>
     * Set up the environment. It loads the namespaces.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void setUp() throws Exception {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        maker = new DefaultComponentVisibleMaker();
    }

    /**
     * <p>
     * Clear the environment. It unloads the namespaces.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void tearDown() throws Exception {
        ConfigManager cm = ConfigManager.getInstance();
        for (Iterator it = cm.getAllNamespaces(); it.hasNext();) {
            cm.removeNamespace(it.next().toString());
        }
    }
    /**
     * <p>
     * Failure test for <code>makeVisible(Component component)</code>.
     * </p>
     * <p>
     * component is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testMakeVisibleNull() {
        try {
            maker.makeVisible(null);
            fail("component is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>makeVisible(Component component)</code>.
     * </p>
     * <p>
     * component is invisiable, IllegalArgumentException is expected.
     * </p>
     */
    public void testMakeVisibleInvisible() {
        try {
            frame.setVisible(true);
            maker.makeVisible(frame);
            fail("component is invisible, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>makeInvisible(Component component)</code>.
     * </p>
     * <p>
     * component is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testMakeInvisible() {
        try {
            maker.makeInvisible(null);
            fail("component is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>makeInvisible(Component component)</code>.
     * </p>
     * <p>
     * The method call does not come from calling makeVisiable() method,
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testMakeInvisibleNotNull() {
        try {
            maker.makeInvisible(frame);
            fail("The method call does not come from calling makeVisiable() method, "
                    + "IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }
}

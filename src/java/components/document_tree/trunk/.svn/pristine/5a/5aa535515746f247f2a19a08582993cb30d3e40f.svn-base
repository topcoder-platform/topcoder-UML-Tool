/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.trees.document.accuracytests;

import java.io.File;
import java.lang.reflect.Field;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

import javax.swing.Icon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

import com.topcoder.gui.trees.document.impl.IconTreeCellRenderer;
import com.topcoder.uml.model.core.classifiers.ClassImpl;
import com.topcoder.util.config.ConfigManager;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Accuracy test for <code>IconTreeCellRenderer</code>.
 * 
 * @author enefem21
 * @version 1.0
 */
public class IconTreeCellRendererTest extends TestCase {

    /** Unit under test. */
    private IconTreeCellRenderer iconTreeCellRenderer;

    /** JTree used in the unit test. */
    private JTree tree;

    /** Class used in the unit test. */
    private com.topcoder.uml.model.core.classifiers.Class clasz;

    /**
     * <p>
     * Return the suite for this unit test.
     * </p>
     *
     * @return the suite
     */
    public static Test suite() {
        return new TestSuite(IconTreeCellRendererTest.class);
    }
    
    /**
     * Sets the unit test up.
     * 
     * @throws Exception
     *             to JUnit
     */
    protected void setUp() throws Exception {
        super.setUp();

        ConfigManager cm = ConfigManager.getInstance();
        for (Iterator iter = ConfigManager.getInstance().getAllNamespaces(); iter.hasNext();) {
            ConfigManager.getInstance().removeNamespace(iter.next().toString());
        }

        ConfigManager.getInstance().add("accuracytests/IconTreeCellRenderer.xml");

        Hashtable<Object, Object> hashtable = new Hashtable<Object, Object>();
        clasz = new ClassImpl();
        clasz.setName("Integer");

        hashtable.put("test", clasz);

        tree = new JTree(hashtable);
        iconTreeCellRenderer =
            new IconTreeCellRenderer("com.topcoder.gui.trees.document.impl.IconTreeCellRenderer");

    }

    /**
     * Tears the unit test down.
     * 
     * @throws Exception
     *             to JUnit
     */
    protected void tearDown() throws Exception {

        iconTreeCellRenderer = null;

        ConfigManager.getInstance().removeNamespace("com.topcoder.gui.trees.document.impl.IconTreeCellRenderer");

        super.tearDown();
    }

    /**
     * Test constructor for accuracy. Condition: normal. Expect: all states are set as expected.
     * 
     * @throws Exception
     *             to JUnit
     */
    public void testIconTreeCellRenderer() throws Exception {
        IconTreeCellRenderer iconTreeCellRenderer =
            new IconTreeCellRenderer("com.topcoder.gui.trees.document.impl.IconTreeCellRenderer");

        // check the icons fields
        Field iconsField = IconTreeCellRenderer.class.getDeclaredField("icons");
        iconsField.setAccessible(true);
        Map<String, Icon> icons = (Map<String, Icon>) iconsField.get(iconTreeCellRenderer);
        assertEquals("The field is not set as expected", 2, icons.size());
    }

    /**
     * Test <code>getTreeCellRendererComponent</code> for accuracy. Condition: normal. Expect: returned value is
     * as expected.
     */
    public void testGetTreeCellRendererComponent() {
        JComponent component =
            iconTreeCellRenderer.getTreeCellRendererComponent(tree, new DefaultMutableTreeNode("Integer"), false,
                false, true, 2, false);

        assertEquals("Returned value is not as expected", ((JLabel) component).getText(), "Integer");
    }

}

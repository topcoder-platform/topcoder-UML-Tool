/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 *
 * @ TagOptionManagerAccuracyTests.java
 */
package com.topcoder.gui.panels.documentation.accuracytests;

import java.util.ArrayList;
import java.util.List;

import com.topcoder.gui.panels.documentation.plugins.TagOptionManager;
import com.topcoder.gui.panels.documentation.accuracytests.TestHelper;
import com.topcoder.util.config.ConfigManager;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * <p>
 * The <code>TagOptionManager</code>'s Accuracy Tests.
 * This accuracy tests addresses the functionality provided
 * by the <code>TagOptionManager</code> class.
 * </p>
 *
 * @author still
 * @version 1.0
 */
public class TagOptionManagerAccuracyTests extends TestCase {

  /**
     * <p>
     * Represents the config file used for test by the ConfigManager.
     * </p>
     */
    private static final String CONFIG_FILE = "accuracytests/tagOption.xml";;

  /**
     * <p>
     * Represents the property <code>namespace</code> of TagOptionManager.
     * It is used for getting the value under the <code>namespace</code> by the ConfigManager.
     * </p>
     */
    private static final String NAMESPACE = "defaultTagOptions";

    /**
     * <p>
     * The instance of <code>TagOptionManager</code> for test.
     * </p>
     */
    private TagOptionManager manager = null;

    /**
     * <p>
     * The instance of <code>ConfigManager</code> for test.
     * </p>
     */
    private ConfigManager cm = null;

    /**
     * <p>
     * Test suite of <code>TagOptionManagerAccuracyTests</code>.
     * </p>
     *
     * @return Test suite of <code>TagOptionManagerAccuracyTests</code>.
     */
    public static Test suite() {
        return new TestSuite(TagOptionManagerAccuracyTests.class);
    }

    /**
     * <p>
     * Initialization for all tests here.
     * </p>
     *
     * @throws Exception exception to JUnit.
     */
    protected void setUp() throws Exception {
        TestHelper.clearConfig();
        cm = ConfigManager.getInstance();

        // load XML file used to creat TagOptionManager.
        cm.add(CONFIG_FILE);
    }

    /**
     * Clean the config.
     *
     * @throws Exception exception to JUnit.
     */
    public void tearDown() throws Exception {
        TestHelper.clearConfig();
    }



    /**
     * <p>
     * Accuracy Test of the <code>TagOptionManager(String)</code> constructor.
     * </p>
     *
     * @throws Exception exception to JUnit.
     */
    public void testconstructor() throws Exception {
        manager = new TagOptionManager(NAMESPACE);
      // creat a new instance.
        assertNotNull("Constructor should work well.", manager);
        String objectID = "accuracytests.my1";
        List<String> options = manager.getTagOptions(objectID);
      // get the size.
        assertEquals("The options expected to contain 5 elements", 5,
            options.size());
        // creat the list of tags expected to be gotten.
        List<String> expected = new ArrayList<String>();
        expected.add("throws");
        expected.add("exception");
        expected.add("see");
        expected.add("since");
        expected.add("deprecated");
        // get the element.
        assertTrue("The options expected to contain these elements", options.containsAll(expected));
    }

    /**
     * <p>
     * Accuracy Test of the <code>getTagOptions(String)</code> method.
     * </p>
     *
     * @throws Exception exception to JUnit.
     */
    public void testgetTagOptions() throws Exception {
        manager = new TagOptionManager(NAMESPACE);
      // creat a new instance.
        assertNotNull("Constructor should work well.", manager);

        // get the Property : "GLOBAL"
        String objectID = "GLOBAL";
        List<String> options = manager.getTagOptions(objectID);
        // get the size.
        assertEquals("The options expected to contain 3 elements", 3,
            options.size());
        // creat the list of tags expected to be gotten.
        List<String> expected = new ArrayList<String>();
        expected.add("see");
        expected.add("since");
        expected.add("deprecated");
        // get the element.
        assertTrue("The options expected to contain these elements", options.containsAll(expected));

        // get the Property : "accuracytests.my2"
        objectID = "accuracytests.my2";
        options = manager.getTagOptions(objectID);
      // get the size.
        assertEquals("The options expected to contain 3 elements", 3,
            options.size());
        // get the element.
        assertTrue("The options expected to contain these elements", options.containsAll(expected));

        // get the Property : "accuracytests.my1"
        objectID = "accuracytests.my1";
        options = manager.getTagOptions(objectID);
      // get the size.
        assertEquals("The options expected to contain 5 elements", 5,
            options.size());
        // creat the list of tags expected to be gotten.
        expected.add("throws");
        expected.add("exception");
        // get the element.
        assertTrue("The options expected to contain these elements", options.containsAll(expected));
    }
}

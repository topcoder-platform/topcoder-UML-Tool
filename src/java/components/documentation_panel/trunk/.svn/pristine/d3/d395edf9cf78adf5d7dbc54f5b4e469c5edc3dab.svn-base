/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.documentation.failuretests;

import com.topcoder.gui.panels.documentation.DocumentationPanelConfigurationException;
import com.topcoder.gui.panels.documentation.UnknownElementTypeException;
import com.topcoder.gui.panels.documentation.plugins.TagOptionManager;

import junit.framework.TestCase;


/**
 * Test cases for the class TagOptionManager.
 *
 * @author waits
 * @version 1.0
 */
public class TagOptionManagerTests extends TestCase {
    /** TagOptionManager instance to test against. */
    private TagOptionManager manager = null;

    /**
     * create instances for testing.
     *
     * @throws Exception into JUnit
     */
    protected void setUp() throws Exception {
        Helper.clearConfiguration();
        Helper.addConfigFile(Helper.TAG_OPTION_MANAGER_CONFIG_FILE);

        //create instance
        manager = new TagOptionManager(Helper.TAG_OPTION_MANAGER_NAMESPACE_PREFIX + "valid");
    }

    /**
     * Test ctor with not exist type in 'types'. DocumentationPanelConfigurationException expected.
     */
    public void testCtor_NotExistTypes() {
        try {
            new TagOptionManager(Helper.TAG_OPTION_MANAGER_NAMESPACE_PREFIX + "1");
            fail("There is not exist type in 'TYPES'");
        } catch (DocumentationPanelConfigurationException e) {
            //good
        }
    }
    /**
     * Test ctor with empty value in 'types'. DocumentationPanelConfigurationException expected.
     */
    public void testCtor_EmptyValue() {
        try {
            new TagOptionManager(Helper.TAG_OPTION_MANAGER_NAMESPACE_PREFIX + "2");
            fail("There is empty value for the types.");
        } catch (DocumentationPanelConfigurationException e) {
            //good
        }
    }

    /**
     * Test ctor with empty value in 'types'. DocumentationPanelConfigurationException expected.
     */
    public void testCtor_EmptyValue2() {
        try {
            new TagOptionManager(Helper.TAG_OPTION_MANAGER_NAMESPACE_PREFIX + "3");
            fail("There is empty value for the types.");
        } catch (DocumentationPanelConfigurationException e) {
            //good
        }
    }

    /**
     * Test ctor with unkonwn link type,
     * DocumentationPanelConfigurationException expected.
     */
    public void testCtor_undefinedLinkTypes() {
        try {
            new TagOptionManager(Helper.TAG_OPTION_MANAGER_NAMESPACE_PREFIX + "4");
            fail("One link type is unknown.");
        } catch (DocumentationPanelConfigurationException e) {
            //good
        }
    }
    /**
     * Test getTagOptions with unknown id, UnknownElementTypeException expected.
     *
     */
    public void testGetTagOptions() {
        try {
            this.manager.getTagOptions(null);
            fail("The optionId is unknown.");
        } catch (UnknownElementTypeException e) {
            //good
        }
    }
    /**
     * clear the environment.
     *
     * @throws Exception into Junit
     */
    protected void tearDown() throws Exception {
        Helper.clearConfiguration();
    }
}

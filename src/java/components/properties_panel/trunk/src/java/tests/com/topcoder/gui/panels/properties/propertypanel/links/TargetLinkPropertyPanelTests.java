/*
 * Copyright (C) 2007-2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.properties.propertypanel.links;

import javax.swing.JLabel;

import com.topcoder.gui.panels.properties.PropertiesPanel;
import com.topcoder.gui.panels.properties.TestHelper;
import com.topcoder.uml.model.statemachines.FinalStateImpl;
import com.topcoder.uml.model.statemachines.StateVertex;
import com.topcoder.uml.model.statemachines.Transition;
import com.topcoder.uml.model.statemachines.TransitionImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * <p>
 * Unit test cases for TargetLinkPropertyPanel.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class TargetLinkPropertyPanelTests extends TestCase {
    /**
     * <p>
     * The TargetLinkPropertyPanel instance for testing.
     * </p>
     */
    private TargetLinkPropertyPanel panel;

    /**
     * <p>
     * The PropertiesPanel instance for testing.
     * </p>
     */
    private PropertiesPanel propertiesPanel;

    /**
     * <p>
     * Sets up test environment.
     * </p>
     * @throws Exception to JUnit
     *
     */
    protected void setUp() throws Exception {
        TestHelper.loadSingleXMLConfig(TestHelper.NAMESPACE, TestHelper.CONFIG_FILE);
        propertiesPanel = new PropertiesPanel(new UMLModelManager());

        panel = new TargetLinkPropertyPanel(propertiesPanel);
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     * @throws Exception to JUnit
     *
     */
    protected void tearDown() throws Exception {
        panel = null;
        propertiesPanel = null;

        TestHelper.clearConfigFile(TestHelper.NAMESPACE);
    }

    /**
     * <p>
     * Returns all tests.
     * </p>
     *
     * @return all tests
     */
    public static Test suite() {
        return new TestSuite(TargetLinkPropertyPanelTests.class);
    }

    /**
     * <p>
     * Tests ctor TargetLinkPropertyPanel#TargetLinkPropertyPanel(PropertiesPanel) for accuracy.
     * </p>
     *
     * <p>
     * It verifies the newly created TargetLinkPropertyPanel instance should not be null.
     * </p>
     */
    public void testCtor() {
        assertNotNull("Failed to create a new TargetLinkPropertyPanel instance.", panel);
    }

    /**
     * <p>
     * Tests ctor TargetLinkPropertyPanel#TargetLinkPropertyPanel(PropertiesPanel) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when propertiesPanel is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullPropertiesPanel() {
        try {
            new TargetLinkPropertyPanel(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests TargetLinkPropertyPanel#refreshPanel() for accuracy.
     * </p>
     *
     * <p>
     * It verifies TargetLinkPropertyPanel#refreshPanel() is correct.
     * </p>
     */
    public void testRefreshPanel() {
        StateVertex target = new FinalStateImpl();
        target.setName("TargetLink");
        Transition element = new TransitionImpl();
        element.setTarget(target);

        panel.configurePanel(element);

        assertEquals("Failed to refresh panel correctly.", "TargetLink",
            ((JLabel) panel.retrievePanel().getComponent(0)).getText());
    }

    /**
     * <p>
     * Tests TargetLinkPropertyPanel#refreshPanel() for accuracy.
     * </p>
     *
     * <p>
     * It verifies TargetLinkPropertyPanel#refreshPanel() is correct.
     * </p>
     */
    public void testRefreshPanel_NoVisible() {
        panel.refreshPanel();

        assertEquals("Failed to refresh panel correctly.", "Target",
            ((JLabel) panel.retrievePanel().getComponent(0)).getText());
    }

    /**
     * <p>
     * Tests TargetLinkPropertyPanel#refreshPanel() for accuracy.
     * </p>
     *
     * <p>
     * It tests the case when setLinkedModelElement(null) is call and
     * verifies TargetLinkPropertyPanel#refreshPanel() is correct.
     * </p>
     */
    public void testRefreshPanel_NoTargets() {
        panel.configurePanel(new TransitionImpl());

        assertEquals("Failed to refresh panel correctly.", "",
            ((JLabel) panel.retrievePanel().getComponent(0)).getText());
    }

}
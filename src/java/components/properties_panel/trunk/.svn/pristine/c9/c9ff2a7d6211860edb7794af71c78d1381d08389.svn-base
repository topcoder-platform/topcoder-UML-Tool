/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.properties.accuracytests;

import java.awt.Component;

import javax.swing.JLabel;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

import com.topcoder.gui.panels.properties.PropertiesPanel;
import com.topcoder.gui.panels.properties.propertypanel.links.SourceLinkPropertyPanel;
import com.topcoder.uml.model.statemachines.FinalStateImpl;
import com.topcoder.uml.model.statemachines.StateVertex;
import com.topcoder.uml.model.statemachines.Transition;
import com.topcoder.uml.model.statemachines.TransitionImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;

/**
 * <p>
 * Accuracy Unit test cases for SourceLinkPropertyPanel.
 * </p>
 *
 * @author biotrail
 * @version 1.0
 */
public class SourceLinkPropertyPanelAccuracyTests extends TestCase {
    /**
     * <p>
     * SourceLinkPropertyPanel instance for testing.
     * </p>
     */
    private SourceLinkPropertyPanel instance;

    /**
     * <p>
     * Setup test environment.
     * </p>
     * @throws Exception to JUnit
     *
     */
    protected void setUp() throws Exception {
        AccuracyTestsHelper.loadXMLConfig(AccuracyTestsHelper.CONFIG_FILE);
        instance = new SourceLinkPropertyPanel(new PropertiesPanel(new UMLModelManager()));
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     * @throws Exception to JUnit
     *
     */
    protected void tearDown() throws Exception {
        instance = null;
        AccuracyTestsHelper.clearConfig();
    }

    /**
     * <p>
     * Return all tests.
     * </p>
     *
     * @return all tests
     */
    public static Test suite() {
        return new TestSuite(SourceLinkPropertyPanelAccuracyTests.class);
    }

    /**
     * <p>
     * Tests ctor SourceLinkPropertyPanel#SourceLinkPropertyPanel(PropertiesPanel) for accuracy.
     * </p>
     */
    public void testCtor1() {
        assertNotNull("Failed to create SourceLinkPropertyPanel instance.", instance);
    }

    /**
     * <p>
     * Tests SourceLinkPropertyPanel#refreshPanel() for accuracy.
     * </p>
     */
    public void testRefreshPanel() {
        StateVertex source = new FinalStateImpl();
        source.setName("SourceLinkProperty");
        Transition element = new TransitionImpl();
        element.setSource(source);
        instance.configurePanel(element);

        Component[] labels = AccuracyTestsHelper.getChildComponents(instance.retrievePanel(), JLabel.class);

        boolean sourceLinkLabelPresent = false;
        for (Component comp : labels) {
            JLabel label = (JLabel) comp;
            if (label.getText().contains("SourceLinkProperty")) {
                sourceLinkLabelPresent = true;
            }
        }

        assertTrue("Failed to refresh panel.", sourceLinkLabelPresent);
    }

}
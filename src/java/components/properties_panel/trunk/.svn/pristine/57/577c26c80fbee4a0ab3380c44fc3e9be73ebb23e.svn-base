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
import com.topcoder.gui.panels.properties.propertypanel.links.StimulusLinkPropertyPanel;
import com.topcoder.uml.model.actions.Action;
import com.topcoder.uml.model.actions.objectactions.CreateObjectActionImpl;
import com.topcoder.uml.model.commonbehavior.instances.Stimulus;
import com.topcoder.uml.model.commonbehavior.instances.StimulusImpl;
import com.topcoder.uml.model.commonbehavior.procedure.Procedure;
import com.topcoder.uml.model.commonbehavior.procedure.ProcedureImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;

/**
 * <p>
 * Accuracy Unit test cases for StimulusLinkPropertyPanel.
 * </p>
 *
 * @author biotrail
 * @version 1.0
 */
public class StimulusLinkPropertyPanelAccuracyTests extends TestCase {
    /**
     * <p>
     * StimulusLinkPropertyPanel instance for testing.
     * </p>
     */
    private StimulusLinkPropertyPanel instance;

    /**
     * <p>
     * Setup test environment.
     * </p>
     * @throws Exception to JUnit
     *
     */
    protected void setUp() throws Exception {
        AccuracyTestsHelper.loadXMLConfig(AccuracyTestsHelper.CONFIG_FILE);
        instance = new StimulusLinkPropertyPanel(new PropertiesPanel(new UMLModelManager()));
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
        return new TestSuite(StimulusLinkPropertyPanelAccuracyTests.class);
    }

    /**
     * <p>
     * Tests ctor StimulusLinkPropertyPanel#StimulusLinkPropertyPanel(PropertiesPanel) for accuracy.
     * </p>
     */
    public void testCtor1() {
        assertNotNull("Failed to create StimulusLinkPropertyPanel instance.", instance);
    }

    /**
     * <p>
     * Tests StimulusLinkPropertyPanel#refreshPanel() for accuracy.
     * </p>
     */
    public void testRefreshPanel() {
        Stimulus stimulus = new StimulusImpl();
        stimulus.setName("StimulusLinkProperty");
        Procedure procedure = new ProcedureImpl();
        procedure.addStimulus(stimulus);
        Action element = new CreateObjectActionImpl();
        element.setProcedure(procedure);
        instance.configurePanel(element);

        Component[] labels = AccuracyTestsHelper.getChildComponents(instance.retrievePanel(), JLabel.class);

        boolean stimulusLinkLabelPresent = false;
        for (Component comp : labels) {
            JLabel label = (JLabel) comp;
            if (label.getText().contains("StimulusLinkProperty")) {
                stimulusLinkLabelPresent = true;
            }
        }

        assertTrue("Failed to refresh panel.", stimulusLinkLabelPresent);
    }

}
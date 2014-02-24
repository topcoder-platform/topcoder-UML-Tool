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
import com.topcoder.gui.panels.properties.propertypanel.links.ActionLinkPropertyPanel;
import com.topcoder.uml.model.actions.Action;
import com.topcoder.uml.model.actions.objectactions.CreateObjectActionImpl;
import com.topcoder.uml.model.commonbehavior.instances.Stimulus;
import com.topcoder.uml.model.commonbehavior.instances.StimulusImpl;
import com.topcoder.uml.model.commonbehavior.procedure.Procedure;
import com.topcoder.uml.model.commonbehavior.procedure.ProcedureImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;

/**
 * <p>
 * Accuracy Unit test cases for ActionLinkPropertyPanel.
 * </p>
 *
 * @author biotrail
 * @version 1.0
 */
public class ActionLinkPropertyPanelAccuracyTests extends TestCase {
    /**
     * <p>
     * ActionLinkPropertyPanel instance for testing.
     * </p>
     */
    private ActionLinkPropertyPanel instance;

    /**
     * <p>
     * Setup test environment.
     * </p>
     * @throws Exception to JUnit
     *
     */
    protected void setUp() throws Exception {
        AccuracyTestsHelper.loadXMLConfig(AccuracyTestsHelper.CONFIG_FILE);
        instance = new ActionLinkPropertyPanel(new PropertiesPanel(new UMLModelManager()));
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
        return new TestSuite(ActionLinkPropertyPanelAccuracyTests.class);
    }

    /**
     * <p>
     * Tests ctor ActionLinkPropertyPanel#ActionLinkPropertyPanel(PropertiesPanel) for accuracy.
     * </p>
     */
    public void testCtor1() {
        assertNotNull("Failed to create ActionLinkPropertyPanel instance.", instance);
    }

    /**
     * <p>
     * Tests ActionLinkPropertyPanel#refreshPanel() for accuracy.
     * </p>
     */
    public void testRefreshPanel() {
        Action action = new CreateObjectActionImpl();
        action.setName("ActionLinkProperty");
        Procedure dispatchAction = new ProcedureImpl();
        dispatchAction.setAction(action);
        Stimulus element = new StimulusImpl();
        element.setDispatchAction(dispatchAction);
        instance.configurePanel(element);

        Component[] labels = AccuracyTestsHelper.getChildComponents(instance.retrievePanel(), JLabel.class);

        boolean actionLinkLabelPresent = false;
        for (Component comp : labels) {
            JLabel label = (JLabel) comp;
            if (label.getText().contains("ActionLinkProperty")) {
                actionLinkLabelPresent = true;
            }
        }

        assertTrue("Failed to refresh panel.", actionLinkLabelPresent);
    }

}
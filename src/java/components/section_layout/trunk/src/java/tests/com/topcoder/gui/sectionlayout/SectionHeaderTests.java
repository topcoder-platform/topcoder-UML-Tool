/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.sectionlayout;

import java.beans.PropertyChangeEvent;

import javax.swing.JPanel;

import com.topcoder.gui.sectionlayout.model.DefaultSectionModel;
import com.topcoder.gui.sectionlayout.model.SectionModel;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * <p>
 * Unit test cases for <code>SectionHeader</code>.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class SectionHeaderTests extends TestCase {

    /**
     * <p>
     * The SectionModel instance for helping testing.
     * </p>
     */
    private SectionModel model;

    /**
     * <p>
     * The Section instance for helping testing.
     * </p>
     */
    private Section section;

    /**
     * <p>
     * The SectionHeader instance for helping testing.
     * </p>
     */
    private SectionHeader header;

    /**
     * <p>
     * Setup test environment.
     * </p>
     *
     * @throws Exception to JUnit
     *
     */
    protected void setUp() throws Exception {
        TestHelper.configUIManager();

        model = new DefaultSectionModel();
        section = new Section(new JPanel());
        header = new SectionHeader(section, model);
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void tearDown() throws Exception {
        model = null;
        section = null;
        header = null;
    }

    /**
     * <p>
     * Return the test suite of this class.
     * </p>
     *
     * @return the test suite of this class.
     */
    public static Test suite() {
        return new TestSuite(SectionHeaderTests.class);
    }

    /**
     * <p>
     * Tests SectionHeader#SectionHeader(Section, SectionModel) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the SectionHeader#SectionHeader(Section, SectionModel) is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testCtor() throws Exception {
        assertNotNull("The newly created SectionHeader should not be null.", header);
        assertEquals("The model should be equal.", model, header.getModel());
        assertEquals("The section should be equal.", section, header.getSection());
    }

    /**
     * <p>
     * Tests SectionHeader#SectionHeader(Section, SectionModel) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when section is null and expects IllegalArgumewntException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testCtor_Section_Null() throws Exception {
        try {
            new SectionHeader(null, model);
            fail("IAE should be thrown.");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests SectionHeader#SectionHeader(Section, SectionModel) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when model is null and expects IllegalArgumewntException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testCtor_Model_Null() throws Exception {
        try {
            new SectionHeader(section, null);
            fail("IAE should be thrown.");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests SectionHeader#getModel() for accuracy.
     * </p>
     *
     * <p>
     * Verify : the SectionHeader#getModel() is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testGetModel() throws Exception {
        assertEquals("The model should be equal.", model, header.getModel());
    }

    /**
     * <p>
     * Tests SectionHeader#getSection() for accuracy.
     * </p>
     *
     * <p>
     * Verify : the SectionHeader#getSection() is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testGetSection() throws Exception {
        assertEquals("The section should be equal.", section, header.getSection());
    }

    /**
     * <p>
     * Tests SectionHeader#updateUI() for accuracy.
     * </p>
     *
     * <p>
     * Verify : the SectionHeader#updateUI() is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testUpdateUI() throws Exception {
        header.updateUI();
    }

    /**
     * <p>
     * Tests SectionHeader#getUIClassID() for accuracy.
     * </p>
     *
     * <p>
     * Verify : the SectionHeader#getUIClassID() is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testGetUIClassID() throws Exception {
        assertEquals("The UI class ID should be SectionHeaderUI.", "SectionHeaderUI", header.getUIClassID());
    }

    /**
     * <p>
     * Tests SectionHeader#propertyChange(PropertyChangeEvent) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the SectionHeader#propertyChange(PropertyChangeEvent) is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testPropertyChange() throws Exception {
        header.propertyChange(new PropertyChangeEvent(this, "title", "Section", "new-section"));
    }
}

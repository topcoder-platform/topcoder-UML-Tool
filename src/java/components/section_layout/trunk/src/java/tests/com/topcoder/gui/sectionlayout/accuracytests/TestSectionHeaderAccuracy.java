/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.sectionlayout.accuracytests;

import java.beans.PropertyChangeEvent;

import com.topcoder.gui.sectionlayout.Section;
import com.topcoder.gui.sectionlayout.SectionHeader;
import com.topcoder.gui.sectionlayout.model.DefaultSectionModel;
import com.topcoder.gui.sectionlayout.model.SectionModel;

import junit.framework.TestCase;

import javax.swing.JPanel;


/**
 * Accuracy test cases for class <code>SectionHeader </code>.
 *
 * @author Chenhong
 * @version 1.0
 */
public class TestSectionHeaderAccuracy extends TestCase {
    /** Represents the SectionHeader isntance for testing. */
    private SectionHeader header = null;

    /** The SectionModel for testing. */
    private SectionModel model;

    /** The Section instance for testing. */
    private Section section;

    /**
     * Set up.
     *
     * @throws Exception to junit
     */
    public void setUp() throws Exception {
        AccUtil.configUIManager();

        model = new DefaultSectionModel();
        section = new Section(new JPanel());
        header = new SectionHeader(section, model);
    }

    /**
     * Test the ctor.
     */
    public void testSectionHeader() {
        assertNotNull(header);
    }

    /**
     * Test method updateUI.
     */
    public void testUpdateUI() {
        header.updateUI();
    }

    /**
     * Test method getModel.
     */
    public void testGetModel() {
        assertEquals("Equal is expected.", model, header.getModel());
    }

    /**
     * Test method getSection.
     */
    public void testGetSection() {
        assertEquals("Equal is expected.", section, header.getSection());
    }

    /**
     * Test method <code>getUIClassID() </code>.
     */
    public void testGetUIClassID() {
        assertEquals("SectionHeaderUI", header.getUIClassID());
    }

    /**
     * Test method propertyChange.
     */
    public void testPropertyChange() {
        header.propertyChange(new PropertyChangeEvent(header, "ok", "test", header));
    }
}

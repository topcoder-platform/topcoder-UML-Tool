/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.sectionlayout.stresstests;

import java.awt.Component;
import java.beans.PropertyChangeEvent;

import javax.swing.JPanel;

import junit.framework.TestCase;

import com.topcoder.gui.sectionlayout.Section;
import com.topcoder.gui.sectionlayout.SectionExpandContractListener;

/**
 * <p>
 * Stress test cases for class SectionStress.
 * </p>
 *
 * @author extra
 * @version 1.0
 */
public class SectionStressTests extends TestCase {

    /**
     * <p>
     * Stress test for propertyChange(PropertyChangeEvent event) method.
     * </p>
     * @throws Exception to JUnit.
     */
    public void testPropertyChange() throws Exception {
        StressTestHelper.configUIManager();

        Component component = new JPanel();
        Section section = new Section(component);

        MockSectionExpandContractListener[] listeners = new MockSectionExpandContractListener[5];
        for (int i = 0; i < 5; i++) {
            listeners[i] = new MockSectionExpandContractListener("name:" + i);
            section.addExpandContractListener(listeners[i]);
        }

        PropertyChangeEvent event = new PropertyChangeEvent(this, "newProperty", "oldValue", "newValue");

        section.setExpanded(true);
        long start = System.currentTimeMillis();
        for (int i = 0; i < 20; i++) {
            section.propertyChange(event);
        }
        System.out.println("propertyChange 20 times cost " + (System.currentTimeMillis() - start) + " milliseconds.");

        section.setExpanded(false);
        start = System.currentTimeMillis();
        for (int i = 0; i < 20; i++) {
            section.propertyChange(event);
        }
        System.out.println("propertyChange 20 times cost " + (System.currentTimeMillis() - start) + " milliseconds.");

    }

    /**
     * Mock class implements SectionExpandContractListener.
     *
     * @author extra
     * @version 1.0
     */
    private class MockSectionExpandContractListener implements SectionExpandContractListener {
        /**
         * The name.
         */
        private String name;

        /**
         * Constructor method.
         *
         * @param name
         *            the name.
         */
        private MockSectionExpandContractListener(String name) {
            this.name = name;
        }

        /**
         * contracted.
         *
         * @param section
         *            the section.
         */
        public void contracted(Section section) {
            //System.out.println("contracted:" + name);
        }

        /**
         * expanded.
         *
         * @param section
         *            the section.
         */
        public void expanded(Section section) {
            //System.out.println("expanded:" + name);
        }
    }

}

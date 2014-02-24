/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.sectionlayout;

/**
 * <p>
 * Mock implementation of <code>SectionExpandContractListener</code> interface.
 * </p>
 *
 * <p>
 * <strong>Thread-safe</strong>:
 * It is mutable and not thread-safe.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class MockSectionExpandContractListener implements SectionExpandContractListener {

    /**
     * <p>
     * If true, the expanded is called.
     * </p>
     */
    private boolean expanded = true;

    /**
     * <p>
     * Getter of expanded.
     * </p>
     *
     * @return the expanded flag
     */
    public boolean getExpanded() {
        return expanded;
    }

    /**
     * <p>
     * This method will be invoked when section is expanded.
     * </p>
     *
     * @param section
     *        the section asscoited with event
     */
    public void expanded(Section section) {
        expanded = true;
    }

    /**
     * <p>
     * This method will be invoked when section is contracted.
     * </p>
     *
     * @param section
     *        the section asscoited with event
     */
    public void contracted(Section section) {
        expanded = false;
    }
}

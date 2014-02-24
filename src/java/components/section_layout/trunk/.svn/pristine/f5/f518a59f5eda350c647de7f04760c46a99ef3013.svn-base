/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.sectionlayout.failuretests;

import junit.framework.TestCase;

import com.topcoder.gui.sectionlayout.model.DefaultSectionModel;

/**
 * <p>
 * Failure test for <code>DefaultSectionModel</code>.
 * </p>
 *
 * @author restarter
 * @version 1.0
 */
public class DefaultSectionModelFailureTest extends TestCase {

    /**
     * <p>
     * The DefaultSectionModel instance for testing.
     * </p>
     */
    private DefaultSectionModel model = new DefaultSectionModel();

    /**
     * <p>
     * Test for the <code>setTitle(String title)</code>.
     * </p>
     *
     * <p>
     * the title is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testSetTitle() {
        try {
            model.setTitle(null);
            fail("the title is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }
}

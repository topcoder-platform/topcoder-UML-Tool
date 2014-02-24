/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.trees.document;

import com.topcoder.gui.trees.document.impl.DocumentTreeTabbedPaneImpl;
import java.util.Iterator;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Simple tests for ViewChangedEvent class.
 *
 * @author Orange_Cloud
 * @version 1.1
 */
public class ViewChangedEventTest extends TestCase {
    /**
     * DocumentTreeView implementation to use in tests.
     */
    private DocumentTreeView view1 = null;

    /**
     * Another DocumentTreeView implementation to use in tests.
     */
    private DocumentTreeView view2 = null;

    /**
     * <p>Returns the test suite of this class.</p>
     *
     * @return the test suite of this class.
     */
    public static Test suite() {
        return new TestSuite(ViewChangedEventTest.class);
    }

    /**
     * <p>Sets up test environment.</p>
     *
     * @throws Exception to junit
     */
    protected void setUp() throws Exception {
        super.setUp();
        TestHelper.loadConfigurations();
        DocumentTreeTabbedPane parent =
                new DocumentTreeTabbedPaneImpl(TestHelper.createUMLModelManager(), TestHelper.NAMESPACE_NEW);
        Iterator<DocumentTreePanel> it = parent.getPanels().iterator();
        view1 = it.next().getCurrentView();
        view2 = it.next().getCurrentView();
    }

    /**
     * <p>Tears down test environment.</p>
     *
     * @throws Exception to junit
     */
    protected void tearDown() throws Exception {
        TestHelper.clearConfig();
        super.tearDown();
    }

    /**
     * Tests constructor for null - first parameter.
     * IllegalArgumentException expected.
     */
    public void testConstructorForNull1() {
        try {
            new ViewChangedEvent(null, view2);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException ex) {
            // success
        }
    }

    /**
     * Tests constructor for null - second parameter.
     * IllegalArgumentException expected.
     */
    public void testConstructorForNull2() {
        try {
            new ViewChangedEvent(view1, null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException ex) {
            // success
        }
    }

    /**
     * Tests constructor for correct data.
     */
    public void testConstructor() {
        assertNotNull("created instance", new ViewChangedEvent(view1, view2));
    }

    /**
     * Checks how both getters in this class works.
     */
    public void testGetters() {
        ViewChangedEvent event = new ViewChangedEvent(view1, view2);
        assertSame("old view", view1, event.getOldView());
        assertSame("new view", view2, event.getNewView());
    }
}

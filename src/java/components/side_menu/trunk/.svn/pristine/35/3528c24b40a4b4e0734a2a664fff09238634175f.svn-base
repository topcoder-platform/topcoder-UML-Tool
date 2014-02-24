/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.sidemenu.failuretests;

import junit.framework.TestCase;

import com.topcoder.gui.sidemenu.DefaultSideMenuModel;
import com.topcoder.gui.sidemenu.accuracytests.TestHelper;

/**
 * <p>
 * Failure test class: <code>DefaultSideMenuModel</code>.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class DefaultSideMenuModelTest extends TestCase {
    /**
     * <p>
     * An instance of <code>DefaultSideMenuModel</code> which is tested.
     * </p>
     */
    private DefaultSideMenuModel target = null;

    /**
     * <p>
     * An expanded flag used in tests.
     * </p>
     */
    private boolean expanded = true;

    /**
     * <p>
     * A floating flag used in tests.
     * </p>
     */
    private boolean floating = true;

    /**
     * <p>
     * An absoluteWidth used in tests.
     * </p>
     */
    private int absoluteWidth = 323;

    /**
     * <p>
     * setUp() routine.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    protected void setUp() throws Exception {
        target = new DefaultSideMenuModel(TestHelper.TITLE, expanded, floating, absoluteWidth);
    }

    /**
     * <p>
     * Tests the
     * <code>com.topcoder.gui.sidemenu.DefaultSideMenuModel(String, boolean, boolean, int)</code>
     * for proper behavior. Verifies that IllegalArgumentException if title is null.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testConstructor_String_boolean_boolean_int_failure1() throws Exception {
        try {
            new DefaultSideMenuModel(null, expanded, floating, absoluteWidth);
            fail("IllegalArgumentException if title is null.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * <p>
     * Tests the
     * <code>com.topcoder.gui.sidemenu.DefaultSideMenuModel(String, boolean, boolean, int)</code>
     * for proper behavior. Verifies that IllegalArgumentException if title is empty.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testConstructor_String_boolean_boolean_int_failure2() throws Exception {
        try {
            new DefaultSideMenuModel("   ", expanded, floating, absoluteWidth);
            fail("IllegalArgumentException if title is empty.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * <p>
     * Tests the
     * <code>com.topcoder.gui.sidemenu.DefaultSideMenuModel(String, boolean, boolean, int)</code>
     * for proper behavior. Verifies that IllegalArgumentException if absoluteWidth is 0.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testConstructor_String_boolean_boolean_int_failure3() throws Exception {
        try {
            new DefaultSideMenuModel(TestHelper.TITLE, expanded, floating, 0);
            fail("IllegalArgumentException if absoluteWidth is 0.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * <p>
     * Tests the
     * <code>com.topcoder.gui.sidemenu.DefaultSideMenuModel(String, boolean, boolean, int)</code>
     * for proper behavior. Verifies that IllegalArgumentException if absoluteWidth is < -1.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testConstructor_String_boolean_boolean_int_failure4() throws Exception {
        try {
            new DefaultSideMenuModel(TestHelper.TITLE, expanded, floating, -2);
            fail("IllegalArgumentException if absoluteWidth is < -1.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * <p>
     * Tests the <code>com.topcoder.gui.sidemenu.DefaultSideMenuModel(String)</code> for proper
     * behavior. Verifies that IllegalArgumentException if title is null.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testConstructor_String_failure1() throws Exception {
        try {
            new DefaultSideMenuModel(null);
            fail("IllegalArgumentException if title is null.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * <p>
     * Tests the <code>com.topcoder.gui.sidemenu.DefaultSideMenuModel(String)</code> for proper
     * behavior. Verifies that IllegalArgumentException if title is empty.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testConstructor_String_failure2() throws Exception {
        try {
            new DefaultSideMenuModel("   ");
            fail("IllegalArgumentException if title is empty.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * <p>
     * Tests the <code>addPropertyChangeListener(PropertyChangeListener)</code> for proper
     * behavior. IllegalArgumentException if PropertyChangeListener is null.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testMethodAddPropertyChangeListener_PropertyChangeListener_failure1()
        throws Exception {
        try {
            target.addPropertyChangeListener(null);
            fail("IllegalArgumentException if PropertyChangeListener is null.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * <p>
     * Tests the <code>setAbsoluteWidth(int)</code> for proper behavior. Verifies that
     * IllegalArgumentException if absolute value is 0.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testMethodSetAbsoluteWidth_int_failure1() throws Exception {
        try {
            target.setAbsoluteWidth(0);
            fail("IllegalArgumentException if absolute value is 0.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * <p>
     * Tests the <code>setAbsoluteWidth(int)</code> for proper behavior. Verifies that
     * IllegalArgumentException if absolute value is < -1.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testMethodSetAbsoluteWidth_int_failure2() throws Exception {
        try {
            target.setAbsoluteWidth(-2);
            fail("IllegalArgumentException if absolute value is < -1.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * <p>
     * Tests the <code>setTitle(String)</code> for proper behavior. Verifies that
     * IllegalArgumentException if title is null.
     *
     * @throws Exception
     *             to JUnit
     */
    public void testMethodSetTitle_String_failure1() throws Exception {
        try {
            target.setTitle(null);
            fail("IllegalArgumentException if title is null.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * <p>
     * Tests the <code>setTitle(String)</code> for proper behavior. Verifies that
     * IllegalArgumentException if title is empty.
     *
     * @throws Exception
     *             to JUnit
     */
    public void testMethodSetTitle_String_failure2() throws Exception {
        try {
            target.setTitle("   ");
            fail("IllegalArgumentException if title is empty.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * <p>
     * Tests the <code>removePropertyChangeListener(PropertyChangeListener)</code> for proper
     * behavior. IllegalArgumentException if listener is null.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testMethodRemovePropertyChangeListener_PropertyChangeListener_failure1()
        throws Exception {
        try {
            target.removePropertyChangeListener(null);
            fail("IllegalArgumentException if listener is null.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

}

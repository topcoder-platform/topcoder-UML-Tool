/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.closabletabbedpane.activetabselector;

import com.topcoder.gui.closabletabbedpane.ActiveTabSelector;
import com.topcoder.gui.closabletabbedpane.ClosableTabbedPane;
import com.topcoder.util.errorhandling.ExceptionUtils;

/**
 * <p>
 * This class implements the ActiveTabSelector interface by selecting the nearest tab in one of two direction - the
 * direction of increasing tab index or the direction of decreasing tab index.
 * </p>
 * <p>
 * This class will simply store the direction as an immutable member. Since there are only two possible types of this
 * selector, it will provide both of them as static members for convenience. Instantiation is still allowed through a
 * public constructor. Note that this selector requires no installation or uninstallation.
 * </p>
 * <p>
 * Thread Safety: This class is thread safe since it is immutable.
 * </p>
 * @author humblefool, TCSDEVELOPER
 * @version 1.0
 */
public class DirectionalActiveTabSelector implements ActiveTabSelector {
    /**
     * <p>
     * Represents a DirectionalActiveTabSelector that chooses the active tab in the direction of increasing index.
     * This variable is frozen as it will not change after being initialized a new DirectionalActiveTabSelector(true).
     * It is static since it does not depend on any instance of the class. It may be used as a convenience by users
     * instead of creating a new instance of this class every time.
     * </p>
     */
    public static final DirectionalActiveTabSelector INCREASING_INDEX_DIRECTION_ACTIVE_TAB_SELECTOR =
        new DirectionalActiveTabSelector(true);

    /**
     * <p>
     * Represents a DirectionalActiveTabSelector that chooses the active tab in the direction of decreasing index.
     * This variable is frozen as it will not change after being initialized a new
     * DirectionalActiveTabSelector(false). It is static since it does not depend on any instance of the class. It may
     * be used as a convenience by users instead of creating a new instance of this class every time.
     * </p>
     */
    public static final DirectionalActiveTabSelector DECREASING_INDEX_DIRECTION_ACTIVE_TAB_SELECTOR =
        new DirectionalActiveTabSelector(false);

    /**
     * <p>
     * Represents whether the new active tab will be chosen in the direction of increasing index. It is frozen since
     * it will not change after being set by the constructor. It is referenced by the selectNewActiveTab method and
     * retrieved by the isIncreasingIndexDirection method.
     * </p>
     */
    private final boolean increasingIndexDirection;

    /**
     * <p>
     * Creates this tab selector with the given direction.
     * </p>
     * @param increasingIndexDirection
     *            whether the direction is that of increasing tab index.
     */
    public DirectionalActiveTabSelector(boolean increasingIndexDirection) {
        this.increasingIndexDirection = increasingIndexDirection;
    }

    /**
     * <p>
     * Installs the active tab selector onto the given closable tabbed pane. Re-installing will not have any effect.
     * This method actually does nothing in its current implementation, except the parameter checking.
     * </p>
     * @param tabbedPane
     *            the pane to which this selector must be installed. Must not be null.
     * @throws IllegalArgumentException
     *             if the argument is null
     */
    public void installSelector(ClosableTabbedPane tabbedPane) {
        ExceptionUtils.checkNull(tabbedPane, null, null, "tabbedPane must not be null");
        // Does nothing
    }

    /**
     * <p>
     * Un-installs the active tab selector from the given closable tabbed pane. Un-installing without having installed
     * will not have any effect. This method actually does nothing in its current implementation, except the parameter
     * checking.
     * </p>
     * @param tabbedPane
     *            the pane from which this selector must be un-installed. Must not be null.
     * @throws IllegalArgumentException
     *             if the argument is null.
     */
    public void uninstallSelector(ClosableTabbedPane tabbedPane) {
        ExceptionUtils.checkNull(tabbedPane, null, null, "tabbedPane must not be null");
        // Does nothing
    }

    /**
     * <p>
     * Selects a new active tab in the given pane, assuming that the current tab will soon be closed. If no tab is
     * currently selected, this method will do nothing.
     * </p>
     * <p>
     * Depending on the direction of this selector, this method will choose either selectedIndex+1 or selectedIndex-1.
     * If either choice is out of bounds, then do nothing.
     * </p>
     * @throws IllegalArgumentException
     *             If the argument is null.
     * @param tabbedPane
     *            the pane in which to select. Must not be null.
     */
    public void selectNewActiveTab(ClosableTabbedPane tabbedPane) {
        ExceptionUtils.checkNull(tabbedPane, null, null, "tabbedPane must not be null");
        // If currently no tab is selected, simply return.
        if (tabbedPane.getSelectedIndex() == -1) {
            return;
        }
        try {
            if (increasingIndexDirection) {
                tabbedPane.setSelectedIndex(tabbedPane.getSelectedIndex() + 1);
            } else if (tabbedPane.getSelectedIndex() != 0) {
                // If current index is 0, and I still run the following line,
                // -1 will be set to indicate no tab is selected.
                tabbedPane.setSelectedIndex(tabbedPane.getSelectedIndex() - 1);
            }
        } catch (IndexOutOfBoundsException e) {
            // Ignore it
        }

    }

    /**
     * <p>
     * Gets whether the direction of this tab selector is that of increasing index.
     * </p>
     * @return whether the direction of this tab selector is that of increasing index.
     */
    public boolean isIncreasingIndexDirection() {
        return increasingIndexDirection;
    }
}

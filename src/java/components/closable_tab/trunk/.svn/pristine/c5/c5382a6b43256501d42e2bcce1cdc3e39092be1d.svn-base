/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.closabletabbedpane;

/**
 * <p>
 * This interface lays the contract for selecting a new active tab when a currently active tab is closed. The contract
 * consists of three methods to install the selector, uninstall the selector and to select a new active tab. The
 * following conditions must be followed when calling these methods.
 * <ol>
 * <li>Before selectNewActiveTab is called, the selector must have been installed on the tabbed pane. The
 * implementation MAY throw an exception if this is not followed.</li>
 * <li>Re-installing a selector on a pane should have no effect.</li>
 * <li>Re-un-installing a selector a pane should have no effect.</li>
 * </ol>
 * <p>
 * Thread Safety: Implementations need not be thread safe.
 * </p>
 * @author humblefool, TCSDEVELOPER
 * @version 1.0
 */
public interface ActiveTabSelector {
    /**
     * <p>
     * Installs the active tab selector onto the given closable tabbed pane. Re-installing should not have any effect.
     * </p>
     * @param tabbedPane
     *            the pane to which this selector must be installed. Must not be null.
     * @throws IllegalArgumentException
     *             If the argument is null.
     */
    public void installSelector(ClosableTabbedPane tabbedPane);

    /**
     * <p>
     * Un-installs the active tab selector from the given closable tabbed pane. Un-installing without having installed
     * should not have any effect.
     * </p>
     * @param tabbedPane
     *            the pane from which this selector must be un-installed. Must not be null.
     * @throws IllegalArgumentException
     *             if the argument is null.
     */
    public void uninstallSelector(ClosableTabbedPane tabbedPane);

    /**
     * <p>
     * Selects a new active tab in the given pane, assuming that the current tab will soon be closed.
     * </p>
     * @param tabbedPane
     *            the pane in which to select. Must not be null.
     * @throws IllegalArgumentException
     *             if the argument is null.
     * @throws IllegalStateException
     *             may be thrown if the selector has not been installed on the pane.
     */
    public void selectNewActiveTab(ClosableTabbedPane tabbedPane);
}

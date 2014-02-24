/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.closabletabbedpane.activetabselector;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.topcoder.gui.closabletabbedpane.ActiveTabSelector;
import com.topcoder.gui.closabletabbedpane.ClosableTabbedPane;
import com.topcoder.gui.closabletabbedpane.ClosableTabbedPaneEvent;
import com.topcoder.gui.closabletabbedpane.ClosableTabbedPaneEventHandler;
import com.topcoder.gui.closabletabbedpane.ClosableTabbedPaneHelper;
import com.topcoder.util.errorhandling.ExceptionUtils;

/**
 * <p>
 * This class implements the ActiveTabSelector interface by selecting the previous tab that was active.
 * </p>
 * <p>
 * This class will store the tab change history for the tabbed pane as part of the state. The way in which the history
 * is constructed/changed/used may be seen in section 1.3.2 of the CS. A tabbed pane must first be installed before
 * this class can start selecting new active tabs. This is required in order to add the required listeners to maintain
 * history.
 * </p>
 * <p>
 * Thread Safety: This class is not thread safe since it has mutable state. Although the members are all frozen, the
 * state of the map member is itself changeable.
 * </p>
 * @author humblefool, TCSDEVELOPER
 * @version 1.0
 */
public class PreviousActiveTabSelector implements ActiveTabSelector {
    /**
     * <p>
     * Represents the default value of the maximum history length. It is frozen as it will not change after being
     * initialized to 0 and is static since it is independent of instances of this class. It is referenced by the
     * no-args constructor.
     * </p>
     */
    public static final int DEFAULT_MAXIMUM_HISTORY_LENGTH = 0;

    /**
     * <p>
     * Represents the active tab histories of all tabbed panes for which this selector has been installed. It is
     * frozen since it will not change after being initialized by the constructor to a new empty map. It will never be
     * null. Both keys as well as values will be non-null. The value collection may be empty but will never contain
     * nulls. This variable is modified/referenced by the two inner classes as well as all 3 methods of this class
     * that are part of the ActiveTabSelector contract.
     * </p>
     */
    private final Map<ClosableTabbedPane, LinkedList<Integer>> activeTabHistories = new HashMap<ClosableTabbedPane, LinkedList<Integer>>();

    /**
     * <p>
     * Represents the maximum length of the history maintained for each tabbed pane for which this selector has been
     * installed. Prevents the map from ballooning to huge sizes. This variable is frozen since it will not change
     * after being set by the constructor. It may have any value. A value <=0 implies that history length has NO
     * maximum. It is retrieved by the getMaximumHistoryLength method and used whenever the history map is modified.
     * </p>
     */
    private final int maximumHistoryLength;

    /**
     * <p>
     * Creates this tab selector with the default max history length - 0.
     * </p>
     */
    public PreviousActiveTabSelector() {
        this(DEFAULT_MAXIMUM_HISTORY_LENGTH);
    }

    /**
     * <p>
     * Creates this tab selector with the given max history length.
     * </p>
     * @param maximumHistoryLength
     *            the max history length. Possibly <=0 interpreted as an infinite maximum.
     */
    public PreviousActiveTabSelector(int maximumHistoryLength) {
        this.maximumHistoryLength = maximumHistoryLength;
    }

    /**
     * <p>
     * Installs the active tab selector onto the given closable tabbed pane. Re-installing will not have any effect.
     * </p>
     * <p>
     * If the pane is a member in the member map, this method will do nothing. Otherwise, it will create an entry for
     * the pane with the list containing an entry for the current selected index, and add a change and closable tabbed
     * pane event listener (using the inner classes).
     * </p>
     * @throws IllegalArgumentException
     *             if the argument is null.
     * @param tabbedPane
     *            the pane to which this selector must be installed. Must not be null.
     */
    public void installSelector(ClosableTabbedPane tabbedPane) {
        ExceptionUtils.checkNull(tabbedPane, null, null, "tabbedPane must not be null");
        // If not installed yet
        if (!activeTabHistories.containsKey(tabbedPane)) {
            // Create a linked list for this pane
            LinkedList<Integer> list = new LinkedList<Integer>();
            // Add the currently selected tab into it
            if (tabbedPane.getSelectedIndex() != -1) {
                list.add(tabbedPane.getSelectedIndex());
            }
            activeTabHistories.put(tabbedPane, list);
            // Prepare listeners on it
            tabbedPane.addChangeListener(new HistoryMaintenanceChangeListener());
            tabbedPane.addClosableTabbedPaneEventHandler(new HistoryMaintenanceClosableTabbedPaneEventHandler());
        }
    }

    /**
     * <p>
     * Un-installs the active tab selector from the given closable tabbed pane. Un-installing without having installed
     * will not have any effect.
     * </p>
     * <p>
     * If the pane is not a member in the member map, this method will do nothing. Otherwise, it will remove the
     * entries for the pane, and get the change and closable tabbed pane event listeners. Then, if a listener is an
     * instance of the inner class of this class and has as outer class instance (got by doing inner.getOuter) this
     * instance, it will be removed.
     * </p>
     * @throws IllegalArgumentException
     *             If the argument is null.
     * @param tabbedPane
     *            the pane from which this selector must be un-installed. Must not be null.
     */
    public void uninstallSelector(ClosableTabbedPane tabbedPane) {
        ExceptionUtils.checkNull(tabbedPane, null, null, "tabbedPane must not be null");
        // If installed before
        if (activeTabHistories.containsKey(tabbedPane)) {
            // Remove it first
            activeTabHistories.remove(tabbedPane);
            // For each ChangeListener
            for (ChangeListener listener : tabbedPane.getChangeListeners()) {
                // Remove it only if it is added by this class
                if (listener instanceof HistoryMaintenanceChangeListener
                    && ((HistoryMaintenanceChangeListener) listener).getOuter() == this) {
                    tabbedPane.removeChangeListener(listener);
                }
            }
            // For each ClosableTabbedPaneEventHandler
            for (ClosableTabbedPaneEventHandler listener : tabbedPane.getClosableTabbedPaneEventHandlers()) {
                // Remove it only if it is added by this class
                if (listener instanceof HistoryMaintenanceClosableTabbedPaneEventHandler
                    && ((HistoryMaintenanceClosableTabbedPaneEventHandler) listener).getOuter() == this) {
                    tabbedPane.removeClosableTabbedPaneEventHandler(listener);
                }
            }
        }
    }

    /**
     * <p>
     * Selects a new active tab in the given pane, assuming that the current tab will soon be closed.
     * </p>
     * <p>
     * Refer to section 1.3.2 of the CS to see how to get the previous tab.
     * </p>
     * @throws IllegalStateException
     *             if the selector has not been installed on the pane.
     * @throws IllegalArgumentException
     *             if the argument is null.
     * @param tabbedPane
     *            the pane in which to select. Must not be null.
     */
    public void selectNewActiveTab(ClosableTabbedPane tabbedPane) {
        ExceptionUtils.checkNull(tabbedPane, null, null, "tabbedPane must not be null");
        // Get the history list
        LinkedList<Integer> list = activeTabHistories.get(tabbedPane);
        if (list == null) {
            throw new IllegalStateException("PreviousActiveTabSelector must be installed before using");
        }
        // Select only a top most tab that is not the current one, which is to be deleted
        for (Integer i : list) {
            if (i != tabbedPane.getSelectedIndex()) {
                tabbedPane.setSelectedIndex(i);
                return;
            }
        }
        // If none of other tabs are presented in the linked list, use the default
    }

    /**
     * <p>
     * Gets the maximum history length.
     * </p>
     * @return the maximum history length.
     */
    public int getMaximumHistoryLength() {
        return maximumHistoryLength;
    }

    /**
     * <p>
     * This class implements the ChangeListener interface in order to maintain the tab change history.
     * </p>
     * <p>
     * Thread Safety: This class is thread safe because it is stateless. However, its outer class is not thread safe.
     * </p>
     * @author humblefool, TCSDEVELOPER
     * @version 1.0
     */
    private class HistoryMaintenanceChangeListener implements ChangeListener {
        /**
         * <p>
         * Constructs an instance of this object.
         * </p>
         */
        public HistoryMaintenanceChangeListener() {
            // Does nothing.
        }

        /**
         * <p>
         * Get its outer class's instance in order to identify this inner class.
         * </p>
         * @return its outer class's instance in order to identify this inner class
         */
        public PreviousActiveTabSelector getOuter() {
            return PreviousActiveTabSelector.this;
        }

        /**
         * <p>
         * Called when the selected index of the tabbed pane changes.
         * </p>
         * <p>
         * Refer to section 1.3.2 of the CS.
         * </p>
         * @throws IllegalArgumentException
         *             If e is null.
         * @param e
         *            the change event. Must not be null.
         */
        public void stateChanged(ChangeEvent e) {
            ExceptionUtils.checkNull(e, null, null, "ChangeEvent e must not be null");
            // If it is a concerned event
            if (e.getSource() instanceof JTabbedPane && ((JTabbedPane) e.getSource()).getSelectedIndex() != -1) {
                LinkedList<Integer> list = activeTabHistories.get(e.getSource());
                // Add this newly selected one into the list
                list.addFirst(((JTabbedPane) e.getSource()).getSelectedIndex());
                // Remove the last one if too long
                if (maximumHistoryLength > 0 && list.size() > maximumHistoryLength) {
                    list.removeLast();
                }
            }
        }
    }

    /**
     * <p>
     * This class implements the ClosableTabbedPaneEventHandler interface in order to maintain the correct tab change
     * history despite tabs closing and opening.
     * </p>
     * <p>
     * This class will update the state of the outer class when events are fired using the logic shown in section
     * 1.3.2 of the CS.</>
     * <p>
     * Thread Safety: This class is thread safe because it is stateless. However, its outer class is not thread safe.
     * </p>
     * @author humblefool, TCSDEVELOPER
     * @version 1.0
     */
    private class HistoryMaintenanceClosableTabbedPaneEventHandler implements ClosableTabbedPaneEventHandler {
        /**
         * <p>
         * Constructs an instance of this object.
         * </p>
         */
        public HistoryMaintenanceClosableTabbedPaneEventHandler() {
            // Does nothing
        }

        /**
         * <p>
         * Get its outer class's instance in order to identify this inner class.
         * </p>
         * @return its outer class's instance in order to identify this inner class
         */
        public PreviousActiveTabSelector getOuter() {
            return PreviousActiveTabSelector.this;
        }

        /**
         * <p>
         * Represents the event of a tab having been added to the pane.
         * </p>
         * <p>
         * Refer to section 1.3.2 of the CS. This method will rearrange the indices already saved.
         * </p>
         * @throws IllegalArgumentException
         *             If e is null.
         * @param e
         *            the event. Will not be null.
         */
        public void tabAdded(ClosableTabbedPaneEvent e) {
            ExceptionUtils.checkNull(e, null, null, "ClosableTabbedPaneEvent e must not be null");
            // Retrieve the history
            LinkedList<Integer> list = activeTabHistories.get(e.getClosableTabbedPane());
            // Prepare a new list to hold the modified ones
            LinkedList<Integer> newList = new LinkedList<Integer>();

            for (Integer i : list) {
                // Modify the index if necessary
                if (i >= e.getTabIndex()) {
                    newList.add(i + 1);
                } else {
                    newList.add(i);
                }
            }
            // The following line is very important, and very hard to understand! Please read CAREFULLY!!
            // In the insertTab method, when tabs are Ta, Tb, *Tc, Td, in which Tc is selected
            // If we insert a Te just before Tb, then it should be Ta, Te, Tb, *Tc, *Td,
            // and the selected index is increased by one!
            // This is achieved in insertTab method via the setSelectedMethod.
            // Unluckily this method is likely to be listened, and hence a redundant number is raised!
            // The following line is used to remove this redundant number.
            if (newList.size() > 0 && newList.getFirst() - 1 == e.getClosableTabbedPane().getSelectedIndex()
                && newList.getFirst() > e.getTabIndex()) {
                newList.removeFirst();
            }
            // Put the new list back
            activeTabHistories.put(e.getClosableTabbedPane(), newList);
        }

        /**
         * <p>
         * Represents the event of tab(s) about to close.
         * </p>
         * <p>
         * This class will return an array of all trues, of the same length as events.
         * </p>
         * @throws IllegalArgumentException
         *             if events is null/empty or contains nulls.
         * @param events
         *            the events, one per tab. Will not be null/empty or contain nulls.
         * @return An array of booleans, with the same length as e. The corresponding element is true to continue with
         *         closure of that tab, false otherwise.
         */
        public boolean[] tabsClosing(ClosableTabbedPaneEvent[] events) {
            ClosableTabbedPaneHelper.checkArray(events);
            boolean[] result = new boolean[events.length];
            for (int i = 0; i < events.length; i++) {
                result[i] = true;
            }
            return result;
        }

        /**
         * <p>
         * Represents the event of tab(s) having closed.
         * </p>
         * <p>
         * Refer to section 1.3.2 of the CS. This method will for each event, remove all the tab indices for it.
         * </p>
         * @throws IllegalArgumentException
         *             if events is null/empty or contains nulls.
         * @param events
         *            the events, one per tab. Will not be null/empty or contain nulls.
         */
        public void tabsClosed(ClosableTabbedPaneEvent[] events) {
            ClosableTabbedPaneHelper.checkArray(events);
            // For each event
            for (ClosableTabbedPaneEvent e : events) {
                // Process only when index is set
                if (e.getTabIndex() != -1) {
                    LinkedList<Integer> list = activeTabHistories.get(e.getClosableTabbedPane());
                    // Prepare a new list to hold the modified ones
                    LinkedList<Integer> newList = new LinkedList<Integer>();
                    for (Integer i : list) {
                        // For larger one, minus 1
                        if (i > e.getTabIndex()) {
                            newList.add(i - 1);
                        } else if (i < e.getTabIndex()) {
                            // For smaller one, keep the same
                            newList.add(i);
                        }
                        // Ignore the same one (remove it)
                    }
                    // The following line is very important, and very hard to understand! Please read CAREFULLY!!
                    // In the removeTab method, when tabs are Ta, Tb, *Tc, Td, in which Tc is selected
                    // If we remove Ta, it should be Tb, *Tc, *Td, and the selected index is decreased by one!
                    // This is achieved in removeTab method via the setSelectedMethod.
                    // Unluckily this method is likely to be listened, and hence a redundant number is raised!
                    // The following line is used to remove this redundant number.
                    if (newList.size() > 0
                        && newList.getFirst() + 1 == e.getClosableTabbedPane().getSelectedIndex()
                        && newList.getFirst() >= e.getTabIndex()) {
                        newList.removeFirst();
                    }
                    // Put the modified list back
                    activeTabHistories.put(e.getClosableTabbedPane(), newList);
                }
            }
        }
    }
}

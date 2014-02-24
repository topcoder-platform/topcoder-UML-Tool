/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.closabletabbedpane.failuretests;

import java.awt.Graphics;
import java.awt.event.MouseEvent;

import com.topcoder.gui.closabletabbedpane.ClosableTabbedPane;
import com.topcoder.gui.closabletabbedpane.ClosableTabbedPaneEvent;

/**
 * Mock subclass for <c>ClosableTabbedPane</c> for test.
 *
 * @author liulike
 * @version 1.0
 *
 */
public class MockClosableTabbedPane extends ClosableTabbedPane {

    /**
     * Default constructor.
     *
     */
    public MockClosableTabbedPane() {
        super();
    }

    /**
     * <p>
     * Paints this component. This method will firstly invoke its super one, and
     * then draw a close button on each tab.
     * </p>
     * <p>
     * Refer to section 1.3.1 of the CS.
     * </p>
     *
     * @throws IllegalArgumentException
     *             If g is null.
     * @throws IllegalStateException
     *             if the button's image be used is not set or cannot be loaded
     *             within 200ms
     * @param g
     *            The graphics context on which to paint. Must not be null.
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    /**
     * <p>
     * Processes mouse events occurring on this component. This method will
     * process the left mouse click on close button and the popup right click.
     * </p>
     * <p>
     * Refer to section 1.3.1 of the CS.
     * </p>
     *
     * @throws IllegalArgumentException
     *             If e is null.
     * @throws IllegalStateException
     *             if the button's image be used is not set or cannot be loaded
     *             within 200ms
     * @param e
     *            The mouse event. Must not be null.
     */
    public void processMouseEvent(MouseEvent e) {
        super.processMouseEvent(e);
    }

    /**
     * <p>
     * Processes mouse motion events occurring on this component. This method
     * will detect the tab with hovered close button, which will result in a
     * different display picture.
     * </p>
     * <p>
     * Refer to section 1.3.1 of the CS.
     * </p>
     *
     * @throws IllegalArgumentException
     *             If e is null.
     * @throws IllegalStateException
     *             if the button's image be used is not set or cannot be loaded
     *             within 200ms
     * @param e
     *            The mouse event. Must not be null.
     */
    public void processMouseMotionEvent(MouseEvent e) {
        super.processMouseMotionEvent(e);
    }

    /**
     * <p>
     * Fires a tab added event using the given event.
     * </p>
     * <p>
     * This method will get all closable tabbed pane event listeners and call
     * tabAdded on each of them.
     * </p>
     *
     * @throws IllegalArgumentException
     *             if e is null
     * @param event
     *            The event to fire. Must not be null.
     */
    public void fireTabAddedEvent(ClosableTabbedPaneEvent event) {
        super.fireTabAddedEvent(event);
    }

    /**
     * <p>
     * Fires a tabs closing event using the given event.
     * </p>
     * <p>
     * This method will get all closable tabbed pane event listeners and call
     * tabsClosing on each of them. For each boolean in the return array, it
     * will be true only when all the listeners return true. Besides, if no
     * listener is present, it will return a true array.
     * </p>
     *
     * @throws IllegalArgumentException
     *             If events is null/empty or contains nulls.
     * @param events
     *            The event to fire. Must not be null/empty or contain nulls.
     * @return The result of the event being handled.
     */
    protected boolean[] fireTabsClosingEvent(ClosableTabbedPaneEvent[] events) {
        return super.fireTabsClosingEvent(events);
    }

    /**
     * <p>
     * Fires a tabs closed event using the given event. This method will
     * possibly receive duplicate events.
     * </p>
     * <p>
     * This method will call removeTabAt for each element of the argument list.
     * Then get all closable tabbed pane event listeners and call tabsClosed on
     * each of them. The actual removing process is working as below:
     * <ol>
     * <li>Obtain all the tab indices to be removed, and sort them.</li>
     * <li>Remove all of those tabs except the selected one(if present) from
     * the large index to small index - to make sure we do not need to
     * re-calculate the new index after remove.</li>
     * <li>Fire those events corresponding to tabs just closed to
     * handler(listener).</li>
     * <li>For the selected tab that has been SKIPPED in step 2, call
     * activeTabSelector#selectNewActiveTab first, and then remove it.</li>
     * <li>Fire the tab just removed.</li>
     * </ol>
     * <b>Note: </b> this method separate the close/fire process in order to
     * make PreviousActiveTabSelector runs properly.
     * </p>
     *
     * @throws IllegalArgumentException
     *             If events is null/empty or contains nulls.
     * @param events
     *            The event to fire. Must not be null/empty or contain nulls.
     */
    protected void fireTabsClosedEvent(ClosableTabbedPaneEvent[] events) {
        super.fireTabsClosedEvent(events);
    }

}

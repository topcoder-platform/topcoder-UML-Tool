/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.event;

import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

import javax.swing.JScrollBar;

import com.topcoder.gui.diagramviewer.DVHelper;
import com.topcoder.gui.diagramviewer.DiagramView;
import com.topcoder.gui.diagramviewer.DiagramViewer;
import com.topcoder.gui.panels.zoom.ZoomPane;
import com.topcoder.gui.panels.zoom.ZoomPanel;

/**
 * <p>
 * This is an event listener which listens to adjustment event for a JScrollBar.
 * If the event occurs, it means the ZoomPanel is being scrolled, a ScrollEvent
 * will be triggered in such case. This event listener will be registered to the
 * ZoomPanel's JScrollBars (both vertical and horizontal) automatically.
 * </p>
 * <p>
 * Note, the class is expected only be used in this component. No warranty is
 * provided to use it outside this component.
 * </p>
 * <p>
 * Thread safety: This class is immutable, and thread-safe.
 * </p>
 *
 * @author kakarotto, TCSDEVELOPER
 * @version 1.0
 */
public class ScrollTrigger implements AdjustmentListener {

    /**
     * <p>
     * Default empty ctor.
     * </p>
     */
    public ScrollTrigger() {
        // do nothing.
    }

    /**
     * <p>
     * Check if this event is triggered by a scroll action, if so, trigger a
     * ScrollEvent for the DiagramViewer.
     * </p>
     *
     * @param event the change event
     * @throws IllegalArgumentException if any arg is null
     */
    public void adjustmentValueChanged(AdjustmentEvent event) {
        DVHelper.validateNotNull(event, "event");
        //Obtain the JScrollBar, ZoomPanel, DiagramView and DiagramViewer:
        JScrollBar bar = (JScrollBar) event.getSource();
        ZoomPanel zoomPanel = (ZoomPanel) bar.getParent();
        /*
    	 * BugFix: BUGID UML-7148
    	 * Description:
    	 * ZoomPanel#getComponent is used to get the contained DiagramView.
    	 * It should have retrieved the ZoomPane from ZoomPanel, then used
    	 * ZoomPane#getComponent to get the DiagramView.
    	 */
        // old code
//        DiagramView view = (DiagramView) zoomPanel.getComponent(0);
        ZoomPane zoomPane = (ZoomPane) zoomPanel.getViewport().getComponent(0);
        DiagramView view = (DiagramView) zoomPane.getComponent(0);

        DiagramViewer viewer = view.getViewer();
        //Notify the DiagramViewer that a diagram is scrolled:
        viewer.fireScroll(zoomPanel.getViewport(), view.getDiagram());
    }
}

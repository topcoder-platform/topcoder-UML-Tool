/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.activityelements.failuretests;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.HashMap;

import com.topcoder.gui.diagramviewer.elements.SelectionCornerType;
import com.topcoder.gui.diagramviewer.uml.activityelements.BaseNode;
import com.topcoder.gui.diagramviewer.uml.activityelements.EllipseConnector;
import com.topcoder.gui.diagramviewer.uml.activityelements.event.BoundaryChangedEvent;
import com.topcoder.uml.model.statemachines.FinalStateImpl;

import junit.framework.TestCase;

/**
 * <p>
 * Failure Test for <code>{@link BoundaryChangedEvent}</code> class.
 * </p>
 * @author FireIce
 * @version 1.0
 */
public class BoundaryChangedEventFailureTests extends TestCase {

    /**
     * <p>
     * Represents the base node.
     * </p>
     */
    private BaseNode source;

    /**
     * <p>
     * set up testing environment.
     * </p>
     */
    @Override
    protected void setUp() throws Exception {
        super.setUp();

        source = new BaseNode(FailureTestHelper.createGraphNodeForState(new FinalStateImpl()), new HashMap<String, String>(), new EllipseConnector(), new Point(),
            new Rectangle(), new ArrayList<SelectionCornerType>()) {

            @Override
            public Dimension getPreferredGraphNodeSize() {
                return null;
            }

            @Override
            public void notifyGraphNodeChange(String message) {
            }

        };
    }

    /**
     * <p>
     * Failure test for
     * <code>{@link BoundaryChangedEvent#BoundaryChangedEvent(BaseNode, Rectangle, Rectangle, String)}</code>
     * constructor.
     * </p>
     */
    public void testBoundaryChangedEventNullSource() {
        try {
            new BoundaryChangedEvent(null, "", new Rectangle(), new Rectangle());
            fail("expect throw IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for
     * <code>{@link BoundaryChangedEvent#BoundaryChangedEvent(BaseNode, Rectangle, Rectangle, String)}</code>
     * constructor.
     * </p>
     */
    public void testBoundaryChangedEventNullOldBoundary() {
        try {
            new BoundaryChangedEvent(source, "", null, new Rectangle());
            fail("expect throw IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for
     * <code>{@link BoundaryChangedEvent#BoundaryChangedEvent(BaseNode, Rectangle, Rectangle, String)}</code>
     * constructor.
     * </p>
     */
    public void testBoundaryChangedEventNullNewBoundary() {
        try {
            new BoundaryChangedEvent(source, "", new Rectangle(), null);
            fail("expect throw IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }
}

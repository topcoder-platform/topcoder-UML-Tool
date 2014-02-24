/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 *
 * AuxiliaryElementSelectionFailureTest.java
 */
package com.topcoder.uml.actions.auxiliary.failuretests;

import junit.framework.TestCase;

import java.io.Serializable;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;

import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.uml.actions.auxiliary.AuxiliaryElementSelection;

/**
 * <p>
 * This is a failure tests for <code>AuxiliaryElementSelection</code> class.
 * </p>
 *
 * @author wiedzmin
 * @version 1.0
 */
public class AuxiliaryElementSelectionFailureTest extends TestCase {

    /**Serializable object that is used for testing.*/
    private Serializable obj;

    /**DataFlavor that is used for testing.*/
    private DataFlavor dataFlavor;

    /**AuxiliaryElementSelection instance that will be tested.*/
    private AuxiliaryElementSelection auxiliaryElementSelection;

    /**
     * <p>
     * Set up environment.
     * </p>
     */
    public void setUp() {
        obj = new GraphEdge();
        dataFlavor = new DataFlavor(GraphEdge.class, "MyDataFlavor");

        auxiliaryElementSelection = new AuxiliaryElementSelection(obj, dataFlavor);
    }

    /**
     * <p>
     * Tests constructor AuxiliaryElementSelection(object, dataFlavor) if object is null.
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testCtorIfObjectNull() {
        try {
            new AuxiliaryElementSelection(null, dataFlavor);
            fail("IllegalArgumentException is expected because object cannot be null.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Tests constructor AuxiliaryElementSelection(object, dataFlavor) if dataFlavor is null.
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testCtorIfDataFlavorNull() {
        try {
            new AuxiliaryElementSelection(obj, null);
            fail("IllegalArgumentException is expected because dataFlavor cannot be null.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Tests method isDataFlavorSupported(dataFlavor) if dataFlavor is null.
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testIsDataFlavorSupportedIfDataFlavorNull() {
        try {
            auxiliaryElementSelection.isDataFlavorSupported(null);
            fail("IllegalArgumentException is expected because dataFlavor cannot be null.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Tests method getTransferData(dataFlavor) if dataFlavor is null.
     * IllegalArgumentException is expected.
     * </p>
     *
     * @throws Exception exception
     */
    public void testGetTransferDataIfDataFlavorNull() throws Exception {
        try {
            auxiliaryElementSelection.getTransferData(null);
            fail("IllegalArgumentException is expected because dataFlavor cannot be null.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Tests method getTransferData(dataFlavor) if the requested data flavor is not supported.
     * UnsupportedFlavorException is expected.
     * </p>
     *
     * @throws Exception exception
     */
    public void testGetTransferDataIfDataFlavorNotSupported() throws Exception {
        try {
            auxiliaryElementSelection.getTransferData(new DataFlavor(GraphNode.class, "my_graph_node"));
            fail("UnsupportedFlavorException is expected because this dataFlavor is not supported.");
        } catch (UnsupportedFlavorException e) {
            //success
        }
    }
}
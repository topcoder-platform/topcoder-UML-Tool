/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.auxiliary.accuracytests;

import java.awt.datatransfer.DataFlavor;

import junit.framework.TestCase;

import com.topcoder.uml.actions.auxiliary.AuxiliaryElementDataFlavor;
import com.topcoder.uml.actions.auxiliary.AuxiliaryElementSelection;
import com.topcoder.uml.model.core.auxiliaryelements.Comment;

/**
 * <p>
 * Set of accuracy tests for AuxiliaryElementSelection class.
 * </p>
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class AuxiliaryElementSelectionAccuracyTest extends TestCase {

    /**
     * String for testing.
     */
    private String obj = "obj";

    /**
     * Instance of AuxiliaryElementSelection for testing.
     */
    private AuxiliaryElementSelection auxiliaryElementSelection;

    /**
     * Setting up environment for each test case.
     * @throws Exception wraps all exceptions
     */
    protected void setUp() throws Exception {
        auxiliaryElementSelection = new AuxiliaryElementSelection(obj, AuxiliaryElementDataFlavor.COMMENT);
    }

    /**
     * Constructor under test AuxiliaryElementSelection(Serializable,
     * DataFlavor). Accuracy testing of correctly assigned values.
     * @throws Exception wraps all exceptions
     */
    public final void testAuxiliaryElementSelection() throws Exception {
        AuxiliaryElementSelection currentAuxiliaryElementSelection =
            new AuxiliaryElementSelection(obj, AuxiliaryElementDataFlavor.COMMENT);
        assertEquals("objects must be equal", obj, AccuracyTestsHelper.getFieldValue(currentAuxiliaryElementSelection,
            "obj"));
        assertEquals("data flavors must be equal", AuxiliaryElementDataFlavor.COMMENT, AccuracyTestsHelper
            .getFieldValue(currentAuxiliaryElementSelection, "dataFlavor"));
    }

    /**
     * Method under test AuxiliaryElementSelection.getTransferDataFlavors().
     * Accuracy testing of correctly retrieved data flavors.
     */
    public final void testGetTransferDataFlavors() {
        assertEquals("data flavors must be equal", AuxiliaryElementDataFlavor.COMMENT, auxiliaryElementSelection
            .getTransferDataFlavors()[0]);
        assertEquals("only one data flavor is supported", 1, auxiliaryElementSelection.getTransferDataFlavors().length);
    }

    /**
     * Method under test
     * AuxiliaryElementSelection.isDataFlavorSupported(DataFlavor). Accuracy
     * testing of supported data flavor.
     */
    public final void testIsDataFlavorSupportedTrue() {
        assertTrue("comment data flavor must be supported", auxiliaryElementSelection
            .isDataFlavorSupported(AuxiliaryElementDataFlavor.COMMENT));
    }

    /**
     * Method under test
     * AuxiliaryElementSelection.isDataFlavorSupported(DataFlavor). Accuracy
     * testing of unsupported data flavor.
     */
    public final void testIsDataFlavorSupportedFalseFirst() {
        assertFalse("polyline data flavor must be supported", auxiliaryElementSelection
            .isDataFlavorSupported(AuxiliaryElementDataFlavor.POLYLINE));
    }

    /**
     * Method under test
     * AuxiliaryElementSelection.isDataFlavorSupported(DataFlavor). Accuracy
     * testing of unsupported data flavor because of human presentation name.
     */
    public final void testIsDataFlavorSupportedFalseSecond() {
        assertFalse("polyline data flavor must be supported", auxiliaryElementSelection
            .isDataFlavorSupported(new DataFlavor(Comment.class, "other")));
    }

    /**
     * Method under test AuxiliaryElementSelection.getTransferData(DataFlavor).
     * @throws Exception wraps all exception
     */
    public final void testGetTransferData() throws Exception {
        assertEquals("objects must be equal", obj, auxiliaryElementSelection
            .getTransferData(AuxiliaryElementDataFlavor.COMMENT));
    }
}
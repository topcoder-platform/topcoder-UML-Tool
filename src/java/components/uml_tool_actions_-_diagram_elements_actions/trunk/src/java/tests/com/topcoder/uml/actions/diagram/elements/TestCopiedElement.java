/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.diagram.elements;

import java.awt.datatransfer.DataFlavor;

import com.topcoder.diagraminterchange.Ellipse;

/**
 * <P>
 * Tests for CopiedElement class.
 * </P>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 *
 */
public class TestCopiedElement extends DiagramElementsActionsTestCase {

    /**
     * <P>
     * The instance of CopiedElement used in tests.
     * </P>
     */
    private CopiedElement copiedElement = new CopiedElement(SIMPLE_ELLIPSE,
            new DataFlavor[] {SIMPLE_ELLIPSE_FLAVOR });

    /**
     * <P>
     * Test the constructor of CopiedElement with null as the flavors argument.
     * IllegalArgumentException is expected.
     * </P>
     *
     */
    public void testConstructorWithNullAsFlavors() {
        try {
            new CopiedElement(SIMPLE_ELLIPSE, null);
            fail("flavors" + NULL_ARGUMENT_MESSAGE);
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <P>
     * Tests the constructor of CopiedElement with null as the element argument.
     * IllegalArgumentException is expected.
     * </P>
     *
     */
    public void testContstructorWithNullDiagramElement() {
        try {
            new CopiedElement(null, new DataFlavor[] {SIMPLE_ELLIPSE_FLAVOR });
            fail("diagramElement" + NULL_ARGUMENT_MESSAGE);
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <P>
     * Tests the constructor of CopiedElement with an empty array as the flavors
     * element. IllegalArgumentException is expected.
     * </P>
     *
     */
    public void testConstructorWithEmptyFlavors() {
        try {
            new CopiedElement(SIMPLE_ELLIPSE, new DataFlavor[] {});
            fail("flavors can't be an empty array");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <P>
     * Tests the constructor of CopiedElement with an array contains null as the
     * flavors element. IllegalArgumentException is expected.
     * </P>
     *
     */
    public void testConstructorWithNullInFlavors() {
        try {
            new CopiedElement(SIMPLE_ELLIPSE, new DataFlavor[] {
                SIMPLE_ELLIPSE_FLAVOR, null });
            fail("flavors can't contains null");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <P>
     * Tests the isDataFlavorSupported method with null as the flavor argument.
     * IllegalArgumentException is expected.
     * </P>
     *
     */
    public void testIsDataFlavorSupportedWithNullAsFlavor() {
        try {
            copiedElement.isDataFlavorSupported(null);
            fail("flavor" + NULL_ARGUMENT_MESSAGE);
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <P>
     * Tests the supported case of the isDataFlavorSupported method.
     * </P>
     *
     */
    public void testIsDataFlavorSupportedSuccess() {
        assertTrue("Test the success case. True is expected", copiedElement
                .isDataFlavorSupported(SIMPLE_ELLIPSE_FLAVOR));
    }

    /**
     * <P>
     * Tests the not supported case of the isDataFlavorSupported method.
     * </P>
     *
     */
    public void testIsDataFlavorSupportedNotSupported() {
        assertFalse("Test with the flavor not supported. False is expected",
                copiedElement.isDataFlavorSupported(SIMPLE_IMAGE_FLAVOR));
    }

    /**
     * <P>
     * Tests getTransferData with null as flavor argument.
     * </P>
     *
     */
    public void testGetTransferDataWithNullAsFlavor() {
        try {
            copiedElement.getTransferData(null);
            fail("flavor" + NULL_ARGUMENT_MESSAGE);
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <P>
     * Tests the success case of getTransferData method.
     * </P>
     *
     */
    public void testGetTransferDataSuccess() {
        DataFlavor anotherEllipseFlavor = new DataFlavor(Ellipse.class,
                "new ellipse flavor");
        assertTrue("Equal is expected", copiedElement
                .getTransferData(anotherEllipseFlavor) == SIMPLE_ELLIPSE);
    }

    /**
     * <P>
     * Tests the getDataTransferFlavors method.
     * </P>
     *
     * @throws CloneNotSupportedException
     *             should never throws this
     */
    public void testGetDataTransferFlavors() throws CloneNotSupportedException {
        DataFlavor[] flavors = new DataFlavor[] {SIMPLE_ELLIPSE_FLAVOR,
            SIMPLE_IMAGE_FLAVOR };

        DataFlavor[] cloneFlavors = new DataFlavor[] {
            (DataFlavor) SIMPLE_ELLIPSE_FLAVOR.clone(),
            (DataFlavor) SIMPLE_IMAGE_FLAVOR.clone() };

        CopiedElement element = new CopiedElement(SIMPLE_ELLIPSE, flavors);
        assertFalse(element.getTransferDataFlavors() == flavors);
        assertArrayEquals("Equals is expected", element
                .getTransferDataFlavors(), cloneFlavors);
    }
}

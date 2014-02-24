/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.diagram.elements;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.util.ArrayList;

import com.topcoder.diagraminterchange.DiagramElement;
import com.topcoder.diagraminterchange.Image;

/**
 * <P>
 * Tests for the DiagramElementDataFlavorManager.
 * </P>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 *
 */
public class TestDiagramElementDataFlavorManager extends
        DiagramElementsActionsTestCase {

    /**
     * <P>
     * A string flavor.
     * </P>
     */
    private static final DataFlavor STRING_FLAVOR = new DataFlavor(
            String.class, "string flavor");

    /**
     * <P>
     * A diagram element but the flavor hasn't been added to manager.
     * </P>
     */
    private static final DiagramElement UNADDED_DIAGRAM_ELEMENT = new UnaddedDiagramElement();

    /**
     * <P>
     * A flavor which is suitable for all subclasses of DiagramElement and
     * DiagramElement itself.
     * </P>
     */
    private static final DataFlavor GENERIC_FLAVOR = new DataFlavor(
            DiagramElement.class, "diagram element");

    /**
     * <P>
     * There should be 7 flavors initialized by the constructor of
     * DiagramElementDataFlavorManager.
     * </P>
     */
    private static final int INITIALIZED = 7;

    /**
     * <P>
     * The manager used in the tests.
     * </P>
     */
    private DiagramElementDataFlavorManager manager;

    /**
     * <P>
     * Sets up for all tests. Initialized the manager used in the tests.
     * </P>
     */
    protected void setUp() {
        manager = new DiagramElementDataFlavorManager();
    }

    /**
     * <P>
     * Tests the constructor of DiagramElementDataFlavorManager.
     * </P>
     *
     * @throws NoSuchFieldException
     *             if any field not found
     * @throws IllegalAccessException
     *             if the class or its nullary constructor is not accessible
     */
    public void testConstructor() throws NoSuchFieldException,
            IllegalAccessException {
        DiagramElementDataFlavorManager createdManager = new DiagramElementDataFlavorManager();
        ArrayList < DataFlavor > flavors = (ArrayList < DataFlavor >) reflectObjectField(
                "diagramElementFlavors", createdManager);
        assertEquals("there should be 7 flavors initialized", INITIALIZED,
                flavors.size());
    }

    /**
     * <P>
     * Tests the isSuitableForDiagramElement method with the null as the
     * dataflavor to be checked. IllegalArgumentException is expected.
     * </P>
     *
     */
    public void testIsSuitableForDiagramElementDataFlavorWithNull() {
        try {
            manager.isSuitableForDiagramElement((DataFlavor) null);
            fail("flavor" + NULL_ARGUMENT_MESSAGE);
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <P>
     * Tests the isSuitableForDiagramElement method with the flavor suitable for
     * DiagramElement.
     * </P>
     *
     */
    public void testIsDataFlavorSuitableForDiagramElementSuitable() {

        assertTrue("suitable is expected", manager
                .isSuitableForDiagramElement(SIMPLE_ELLIPSE_FLAVOR));
    }

    /**
     * <P>
     * Tests the isSuitableForDiagramElement method with the flavor not suitable
     * for DiagramElement.
     * </P>
     *
     */
    public void testIsDataFlavorSuitableForDiagramElementNotSuitable() {

        assertFalse("not suitable is expected", manager
                .isSuitableForDiagramElement(STRING_FLAVOR));
    }

    /**
     * <P>
     * Tests the isTransferableSuiableForDiagramElement with null as the
     * Transferable. IllegalArgumentException is expected.
     * </P>
     *
     */
    public void testIsTransferableSuitableForDiagramElementWithNull() {
        try {
            manager.isSuitableForDiagramElement((Transferable) null);
            fail("transferable" + NULL_ARGUMENT_MESSAGE);
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <P>
     * Tests the isTransferableSuitableForDiagramElement method with the suitable
     * transferable.
     * </P>
     *
     */
    public void testIsTransferableSuitableForDiagramElementSuitable() {
        TransferableMock transferable = new TransferableMock();
        transferable.setSuitable(true);
        assertTrue("suitable is expected", manager
                .isSuitableForDiagramElement(transferable));
    }

    /**
     * <P>
     * Tests the isTransferableSuitableForDiagramElement method with the not
     * suitable transferable.
     * </P>
     *
     */
    public void testIsTransferableSuitableForDiagramElementNotSuitable() {
        TransferableMock transferable = new TransferableMock();
        transferable.setSuitable(false);
        assertFalse("not suitable is expected", manager
                .isSuitableForDiagramElement(transferable));
    }

    /**
     * <P>
     * Tests the getDataFlavor method with null as argument.
     * IllegalArgumentException is expected.
     * </P>
     *
     */
    public void testGetDataFlavorWithNull() {
        try {
            manager.getDataFlavor(null);
            fail("element" + NULL_ARGUMENT_MESSAGE);
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <P>
     * Tests the getDataFlavor with there is suitable flavor for the
     * DiagramElement.
     * </P>
     *
     */
    public void testGetDataFlavorAddedFlavor() {
        DataFlavor flavor = manager.getDataFlavor(SIMPLE_ELLIPSE);
        assertEquals("ellipse flavor is expected", SIMPLE_ELLIPSE_FLAVOR,
                flavor);
    }

    /**
     * <P>
     * The flavor of MyImage is not in the flavor manager. So flavor of super class
     * of MyImage should be returned. So flavor of Image is expected.
     * </P>
     *
     */
    public void testGetDataFlavorSubclassOfImage() {
        DataFlavor flavor = manager.getDataFlavor(new MyImage());
        assertEquals("The flavor of super class is expected", SIMPLE_IMAGE_FLAVOR, flavor);
    }

    /**
     * <P>
     * Tests the getDataFlavor with a DiagramElement which the flavor of its
     * class isn't in the the manager. The generic one is expected.
     * </P>
     *
     */
    public void testGetDataFlavorGenericFlavor() {
        DataFlavor flavor = manager.getDataFlavor(UNADDED_DIAGRAM_ELEMENT);
        assertEquals("generic flavor is expected", GENERIC_FLAVOR, flavor);
    }

    /**
     * <P>
     * Tests the addFlavor with null as the flavor. IllegalArgumentException is
     * expected.
     * </P>
     *
     */
    public void testAddFlavorWithNull() {
        try {
            manager.addDataFlavor(null);
            fail("flavor" + NULL_ARGUMENT_MESSAGE);
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <P>
     * Tests the addFlavor method with a flavor already in the manager. The
     * flavor should not be added again.
     * </P>
     *
     *
     * @throws NoSuchFieldException
     *             if any field not found
     * @throws IllegalAccessException
     *             if the class or its nullary constructor is not accessible
     */
    public void testAddFlavorExisted() throws NoSuchFieldException,
            IllegalAccessException {
        manager.addDataFlavor(SIMPLE_ELLIPSE_FLAVOR);
        ArrayList< DataFlavor > flavors = (ArrayList < DataFlavor >) reflectObjectField(
                "diagramElementFlavors", manager);
        assertEquals("no new flavor should be added", INITIALIZED, flavors
                .size());
    }

    /**
     * <P>
     * Tests the addFlavor method.
     * </P>
     *
     */
    public void testAddFlavorSuccess() {
        assertFalse("String flavor should not in the list", manager
                .isSuitableForDiagramElement(STRING_FLAVOR));
        manager.addDataFlavor(STRING_FLAVOR);
        assertTrue("String flavor should be added", manager
                .isSuitableForDiagramElement(STRING_FLAVOR));

    }

    /**
     * <P>
     * A mock class for a subclass of DiagramElement.
     * </P>
     *
     * @author TCSDEVELOPER
     * @version 1.0
     *
     */
    static class UnaddedDiagramElement extends DiagramElement {

    }

    /**
     * <P>
     * A mock class for a subclass of Image.
     * </P>
     *
     * @author TCSDEVELOPER
     * @version 1.0
     *
     */
    class MyImage extends Image {

    }
    /**
     * <P>
     * This is a mock of Transferable. The data flavor of this class can be
     * controlled by setSuitable which means it will return the flavors suitable
     * for DiagramElement or not. This class is mocked to test the
     * isSuitableForDiagramElement method.
     * </P>
     *
     * @author TCSDEVELOPER
     * @version 1.0
     *
     */
    static class TransferableMock implements Transferable {


        /**
         * <P>
         * A suitable flavor array for DiagramElement.
         * </P>
         */
        private static final DataFlavor[] SUITABLE_FLAVORS = new DataFlavor[] {
            STRING_FLAVOR, SIMPLE_ELLIPSE_FLAVOR };

        /**
         * <P>
         * A not suitable flavor array for DiagramElement.
         * </P>
         */
        private static final DataFlavor[] NOT_SUITABLE_FLAVORS = new DataFlavor[] {STRING_FLAVOR };

        /**
         * <P>
         * This flag shows the instance of this class should return flavors
         * suitable for DiagramElement or not.
         * </P>
         */
        private boolean isSuitable;


        /**
         * <P>
         * Sets the suitable flag.
         * </P>
         *
         * @param suitable
         *            the value set to the suitable flag
         */
        public void setSuitable(boolean suitable) {
            this.isSuitable = suitable;
        }

        /**
         * <P>
         * An empty method.
         * </P>
         * @param flavor the DataFlavor to get the TranferData for
         * @return null
         */
        public Object getTransferData(DataFlavor flavor) {
            return null;
        }

        /**
         * <P>
         * Return the suitable flavor array if the suitable flag is true, the
         * not suitable one otherwise.
         * </P>
         *
         * @return the DataFlavors of this class
         */
        public DataFlavor[] getTransferDataFlavors() {
            if (isSuitable) {
                return SUITABLE_FLAVORS;
            }

            return NOT_SUITABLE_FLAVORS;
        }

        /**
         * <P>
         * An empty method.
         * </P>
         * @param flavor the DataFlavor to be checked
         * @return false
         */
        public boolean isDataFlavorSupported(DataFlavor flavor) {
            return false;
        }
    }
}

/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.sequence.accuracytests;

import java.awt.Toolkit;

import com.topcoder.uml.actions.model.sequence.CollaborationTransfer;
import com.topcoder.uml.model.commonbehavior.instances.Object;
import com.topcoder.uml.model.commonbehavior.instances.ObjectImpl;
import com.topcoder.uml.model.commonbehavior.instances.Stimulus;

/**
 * <p>
 * Accuracy test for <code>{@link CollaborationTransfer}</code> class.
 * </p>
 *
 * @author FireIce
 * @version 1.0
 */
public class CollaborationTransferAccuracyTests extends BaseTestCase {
    /**
     * <p>
     * Represents the <code>CollaborationTransfer</code> instance used in
     * tests.
     * </p>
     */
    private CollaborationTransfer transfer;

    /**
     * <p>
     * Accuracy test for
     * <code>{@link CollaborationTransfer#CollaborationTransfer(Object)}</code>
     * constructor.
     * </p>
     */
    public void testCollaborationTransferObjectAccuracy() {
        transfer = new CollaborationTransfer(new ObjectImpl());
        assertNotNull("object should successfully created.", transfer);
    }

    /**
     * <p>
     * Accuracy test for
     * <code>{@link CollaborationTransfer#CollaborationTransfer(Stimulus)}</code>
     * constructor.
     * </p>
     */
    public void testCollaborationTransferStimulusAccuracy1() {
        transfer = new CollaborationTransfer(AccuracyTestHelper.createStimulusForAsynchronousMessage());
        assertNotNull("object should successfully created.", transfer);
    }

    /**
     * <p>
     * Accuracy test for
     * <code>{@link CollaborationTransfer#CollaborationTransfer(Stimulus)}</code>
     * constructor.
     * </p>
     */
    public void testCollaborationTransferStimulusAccuracy2() {
        transfer = new CollaborationTransfer(AccuracyTestHelper.createStimulusForSynchronousMessage());
        assertNotNull("object should successfully created.", transfer);
    }

    /**
     * <p>
     * Accuracy test for
     * <code>{@link CollaborationTransfer#CollaborationTransfer(Stimulus)}</code>
     * constructor.
     * </p>
     */
    public void testCollaborationTransferStimulusAccuracy3() {
        transfer = new CollaborationTransfer(AccuracyTestHelper.createStimulusForCreateMessage());
        assertNotNull("object should successfully created.", transfer);
    }

    /**
     * <p>
     * Accuracy test for
     * <code>{@link CollaborationTransfer#CollaborationTransfer(Stimulus)}</code>
     * constructor.
     * </p>
     */
    public void testCollaborationTransferStimulusAccuracy4() {
        transfer = new CollaborationTransfer(AccuracyTestHelper.createStimulusForReturnMessage());
        assertNotNull("object should successfully created.", transfer);
    }

    /**
     * <p>
     * Accuracy test for
     * <code>{@link CollaborationTransfer#CollaborationTransfer(Stimulus)}</code>
     * constructor.
     * </p>
     */
    public void testCollaborationTransferStimulusAccuracy5() {
        transfer = new CollaborationTransfer(AccuracyTestHelper.createStimulusForSendSignalMessage());
        assertNotNull("object should successfully created.", transfer);
    }

    /**
     * <p>
     * Accuracy test for
     * <code>{@link CollaborationTransfer#lostOwnership(Clipboard, Transferable)}</code>
     * method.
     * </p>
     */
    public void testLostOwnershipAccuracy() {
        transfer = new CollaborationTransfer(AccuracyTestHelper.createStimulusForSendSignalMessage());
        transfer.lostOwnership(Toolkit.getDefaultToolkit().getSystemClipboard(), transfer);
        assertTrue(confirmFileContents("INFO"));
        assertTrue(confirmFileContents(Toolkit.getDefaultToolkit().getSystemClipboard().getName()));
    }

    /**
     * <p>
     * Accuracy test for
     * <code>{@link CollaborationTransfer#isDataFlavorSupported(DataFlavor)}</code>
     * method.
     * </p>
     */
    public void testGetTransferDataFlavorsAccuracy1() {
        transfer = new CollaborationTransfer(AccuracyTestHelper.createStimulusForAsynchronousMessage());
        assertNotNull(transfer.getTransferDataFlavors());
        assertTrue(transfer.getTransferDataFlavors().length == 1);
        assertEquals("incorrect data flavors", CollaborationTransfer.ASYNCHRONOUS_MESSAGE_FLAVOR, transfer
                .getTransferDataFlavors()[0]);
    }

    /**
     * <p>
     * Accuracy test for
     * <code>{@link CollaborationTransfer#isDataFlavorSupported(DataFlavor)}</code>
     * method.
     * </p>
     */
    public void testGetTransferDataFlavorsAccuracy2() {
        transfer = new CollaborationTransfer(AccuracyTestHelper.createStimulusForSynchronousMessage());
        assertNotNull(transfer.getTransferDataFlavors());
        assertTrue(transfer.getTransferDataFlavors().length == 1);
        assertEquals("incorrect data flavors", CollaborationTransfer.SYNCHRONOUS_MESSAGE_FLAVOR, transfer
                .getTransferDataFlavors()[0]);
    }

    /**
     * <p>
     * Accuracy test for
     * <code>{@link CollaborationTransfer#isDataFlavorSupported(DataFlavor)}</code>
     * method.
     * </p>
     */
    public void testGetTransferDataFlavorsAccuracy3() {
        transfer = new CollaborationTransfer(AccuracyTestHelper.createStimulusForCreateMessage());
        assertNotNull(transfer.getTransferDataFlavors());
        assertTrue(transfer.getTransferDataFlavors().length == 1);
        assertEquals("incorrect data flavors", CollaborationTransfer.CREATE_MESSAGE_FLAVOR, transfer
                .getTransferDataFlavors()[0]);
    }

    /**
     * <p>
     * Accuracy test for
     * <code>{@link CollaborationTransfer#isDataFlavorSupported(DataFlavor)}</code>
     * method.
     * </p>
     */
    public void testGetTransferDataFlavorsAccuracy4() {
        transfer = new CollaborationTransfer(AccuracyTestHelper.createStimulusForReturnMessage());
        assertNotNull(transfer.getTransferDataFlavors());
        assertTrue(transfer.getTransferDataFlavors().length == 1);
        assertEquals("incorrect data flavors", CollaborationTransfer.RETURN_MESSAGE_FLAVOR, transfer
                .getTransferDataFlavors()[0]);
    }

    /**
     * <p>
     * Accuracy test for
     * <code>{@link CollaborationTransfer#isDataFlavorSupported(DataFlavor)}</code>
     * method.
     * </p>
     */
    public void testGetTransferDataFlavorsAccuracy5() {
        transfer = new CollaborationTransfer(AccuracyTestHelper.createStimulusForSendSignalMessage());
        assertNotNull(transfer.getTransferDataFlavors());
        assertTrue(transfer.getTransferDataFlavors().length == 1);
        assertEquals("incorrect data flavors", CollaborationTransfer.SEND_SIGNAL_MESSAGE_FLAVOR, transfer
                .getTransferDataFlavors()[0]);
    }

    /**
     * <p>
     * Accuracy test for
     * <code>{@link CollaborationTransfer#isDataFlavorSupported(DataFlavor)}</code>
     * method.
     * </p>
     */
    public void testGetTransferDataFlavorsAccuracy6() {
        transfer = new CollaborationTransfer(new ObjectImpl());
        assertNotNull(transfer.getTransferDataFlavors());
        assertTrue(transfer.getTransferDataFlavors().length == 1);
        assertEquals("incorrect data flavors", CollaborationTransfer.OBJECT_FLAVOR,
                transfer.getTransferDataFlavors()[0]);
    }

    /**
     * <p>
     * Accuracy test for
     * <code>{@link CollaborationTransfer#isDataFlavorSupported(DataFlavor)}</code>
     * method.
     * </p>
     */
    public void testIsDataFlavorSupportedAccuracy1() {
        transfer = new CollaborationTransfer(AccuracyTestHelper.createStimulusForAsynchronousMessage());
        assertTrue(transfer.isDataFlavorSupported(CollaborationTransfer.ASYNCHRONOUS_MESSAGE_FLAVOR));
        assertFalse(transfer.isDataFlavorSupported(CollaborationTransfer.OBJECT_FLAVOR));
    }

    /**
     * <p>
     * Accuracy test for
     * <code>{@link CollaborationTransfer#isDataFlavorSupported(DataFlavor)}</code>
     * method.
     * </p>
     */
    public void testIsDataFlavorSupportedAccuracy2() {
        transfer = new CollaborationTransfer(AccuracyTestHelper.createStimulusForSynchronousMessage());
        assertTrue(transfer.isDataFlavorSupported(CollaborationTransfer.SYNCHRONOUS_MESSAGE_FLAVOR));
        assertFalse(transfer.isDataFlavorSupported(CollaborationTransfer.OBJECT_FLAVOR));
    }

    /**
     * <p>
     * Accuracy test for
     * <code>{@link CollaborationTransfer#isDataFlavorSupported(DataFlavor)}</code>
     * method.
     * </p>
     */
    public void testIsDataFlavorSupportedAccuracy3() {
        transfer = new CollaborationTransfer(AccuracyTestHelper.createStimulusForCreateMessage());
        assertTrue(transfer.isDataFlavorSupported(CollaborationTransfer.CREATE_MESSAGE_FLAVOR));
        assertFalse(transfer.isDataFlavorSupported(CollaborationTransfer.OBJECT_FLAVOR));
    }

    /**
     * <p>
     * Accuracy test for
     * <code>{@link CollaborationTransfer#isDataFlavorSupported(DataFlavor)}</code>
     * method.
     * </p>
     */
    public void testIsDataFlavorSupportedAccuracy4() {
        transfer = new CollaborationTransfer(AccuracyTestHelper.createStimulusForReturnMessage());
        assertTrue(transfer.isDataFlavorSupported(CollaborationTransfer.RETURN_MESSAGE_FLAVOR));
        assertFalse(transfer.isDataFlavorSupported(CollaborationTransfer.OBJECT_FLAVOR));
    }

    /**
     * <p>
     * Accuracy test for
     * <code>{@link CollaborationTransfer#isDataFlavorSupported(DataFlavor)}</code>
     * method.
     * </p>
     */
    public void testIsDataFlavorSupportedAccuracy5() {
        transfer = new CollaborationTransfer(AccuracyTestHelper.createStimulusForSendSignalMessage());
        assertTrue(transfer.isDataFlavorSupported(CollaborationTransfer.SEND_SIGNAL_MESSAGE_FLAVOR));
        assertFalse(transfer.isDataFlavorSupported(CollaborationTransfer.OBJECT_FLAVOR));
    }

    /**
     * <p>
     * Accuracy test for
     * <code>{@link CollaborationTransfer#isDataFlavorSupported(DataFlavor)}</code>
     * method.
     * </p>
     */
    public void testIsDataFlavorSupportedAccuracy6() {
        transfer = new CollaborationTransfer(new ObjectImpl());
        assertFalse(transfer.isDataFlavorSupported(CollaborationTransfer.SEND_SIGNAL_MESSAGE_FLAVOR));
        assertTrue(transfer.isDataFlavorSupported(CollaborationTransfer.OBJECT_FLAVOR));
    }

    /**
     * <p>
     * Accuracy test for
     * <code>{@link CollaborationTransfer#getTransferData(DataFlavor)}</code>
     * method.
     * </p>
     *
     * @throws Exception pass any unexpected exception to JUnit.
     */
    public void testGetTransferDataAccuracy1() throws Exception {
        Object object = new ObjectImpl();
        transfer = new CollaborationTransfer(object);

        assertSame("not same object", object, transfer.getTransferData(CollaborationTransfer.OBJECT_FLAVOR));
    }

    /**
     * <p>
     * Accuracy test for
     * <code>{@link CollaborationTransfer#getTransferData(DataFlavor)}</code>
     * method.
     * </p>
     *
     * @throws Exception pass any unexpected exception to JUnit.
     */
    public void testGetTransferDataAccuracy2() throws Exception {
        Stimulus stimulus = AccuracyTestHelper.createStimulusForAsynchronousMessage();
        transfer = new CollaborationTransfer(stimulus);

        assertSame("not same object", stimulus, transfer
                .getTransferData(CollaborationTransfer.ASYNCHRONOUS_MESSAGE_FLAVOR));
    }

    /**
     * <p>
     * Accuracy test for
     * <code>{@link CollaborationTransfer#getTransferData(DataFlavor)}</code>
     * method.
     * </p>
     *
     * @throws Exception pass any unexpected exception to JUnit.
     */
    public void testGetTransferDataAccuracy3() throws Exception {
        Stimulus stimulus = AccuracyTestHelper.createStimulusForSynchronousMessage();
        transfer = new CollaborationTransfer(stimulus);

        assertSame("not same object", stimulus, transfer
                .getTransferData(CollaborationTransfer.SYNCHRONOUS_MESSAGE_FLAVOR));
    }

    /**
     * <p>
     * Accuracy test for
     * <code>{@link CollaborationTransfer#getTransferData(DataFlavor)}</code>
     * method.
     * </p>
     *
     * @throws Exception pass any unexpected exception to JUnit.
     */
    public void testGetTransferDataAccuracy4() throws Exception {
        Stimulus stimulus = AccuracyTestHelper.createStimulusForCreateMessage();
        transfer = new CollaborationTransfer(stimulus);

        assertSame("not same object", stimulus, transfer.getTransferData(CollaborationTransfer.CREATE_MESSAGE_FLAVOR));
    }

    /**
     * <p>
     * Accuracy test for
     * <code>{@link CollaborationTransfer#getTransferData(DataFlavor)}</code>
     * method.
     * </p>
     *
     * @throws Exception pass any unexpected exception to JUnit.
     */
    public void testGetTransferDataAccuracy5() throws Exception {
        Stimulus stimulus = AccuracyTestHelper.createStimulusForReturnMessage();
        transfer = new CollaborationTransfer(stimulus);

        assertSame("not same object", stimulus, transfer.getTransferData(CollaborationTransfer.RETURN_MESSAGE_FLAVOR));
    }

    /**
     * <p>
     * Accuracy test for
     * <code>{@link CollaborationTransfer#getTransferData(DataFlavor)}</code>
     * method.
     * </p>
     *
     * @throws Exception pass any unexpected exception to JUnit.
     */
    public void testGetTransferDataAccuracy6() throws Exception {
        Stimulus stimulus = AccuracyTestHelper.createStimulusForSendSignalMessage();
        transfer = new CollaborationTransfer(stimulus);

        assertSame("not same object", stimulus, transfer
                .getTransferData(CollaborationTransfer.SEND_SIGNAL_MESSAGE_FLAVOR));
    }
}

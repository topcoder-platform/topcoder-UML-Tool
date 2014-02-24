/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.usecase;

import com.topcoder.uml.actions.model.usecase.accuracytests.AccuracyTestHelper;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.usecases.UseCaseImpl;

import com.topcoder.util.log.Log;

import junit.framework.TestCase;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;


/**
 * Accuracy test for the <code>UsecaseUndoableAction</code> class.
 *
 * @author vividmxx
 * @version 1.0
 */
public class AccuracyTestUsecaseUndoableAction extends TestCase {
    /** The <code>ModelElement</code> instance used for test. */
    private ModelElement useCase = new UseCaseImpl();

    /** The <code>UsecaseToolUtil</code> instance used for test. */
    private UsecaseToolUtil util = new UseCaseUtil();

    /** The <code>UsecaseUndoableAction</code> instance used to test against. */
    private UsecaseUndoableAction action;

    /**
     * Set up the test environment.
     */
    protected void setUp() {
        action = new MockUsecaseUndoableAction(useCase, util);
    }

    /**
     * Test the constructor <code>UsecaseUndoableAction(ModelElement modelElement, UsecaseToolUtil)</code>.
     */
    public void testConstructor() {
        ModelElement useCase = new UseCaseImpl();
        UsecaseToolUtil util = new UseCaseUtil();
        UsecaseUndoableAction action = new MockUsecaseUndoableAction(useCase, util);
        assertNotNull("Instance of UsecaseUndoableAction should be created.", action);
        assertTrue("The usecaseToolUtil field should be set.",
            AccuracyTestHelper.getPrivateField(UsecaseUndoableAction.class, action, "usecaseToolUtil").equals(util));
        assertTrue("The modelElement field should be set.",
            AccuracyTestHelper.getPrivateField(UsecaseUndoableAction.class, action, "modelElement").equals(useCase));
    }

    /**
     * Test the constructor <code>UsecaseUndoableAction(Transferable, DataFlavor, UsecaseToolUtil)</code>.
     *
     * @throws Exception throws to JUnit
     */
    public void testConstructorWithTransferable() throws Exception {
        Transferable transferable = new ModelTransfer(new UseCaseImpl());
        UsecaseToolUtil util = new UseCaseUtil();
        UsecaseUndoableAction action = new MockUsecaseUndoableAction(transferable, ModelTransfer.USECASE_FLAVOR, util);
        assertNotNull("Instance of UsecaseUndoableAction should be created.", action);
        assertTrue("The usecaseToolUtil field should be set.",
            AccuracyTestHelper.getPrivateField(UsecaseUndoableAction.class, action, "usecaseToolUtil").equals(util));
        assertNotNull("The modelElement field should be set.",
            AccuracyTestHelper.getPrivateField(UsecaseUndoableAction.class, action, "modelElement"));
    }

    /**
     * Test the method <code>getUsecaseToolUtil()</code>.
     */
    public void testGetUsecaseToolUtil() {
        assertTrue("The correct util should be returned.", action.getUsecaseToolUtil().equals(util));
    }

    /**
     * Test the method <code>getModelElement()</code>.
     */
    public void testGetModelElement() {
        assertTrue("The correct element should be returned.", action.getModelElement().equals(useCase));
    }

    /**
     * Test the method <code>getLog()</code>.
     */
    public void testGetLog() {
        assertNotNull("The returned Log instance should not be null.", action.getLog());
    }

    /**
     * This is a mock implementation of <code>UsecaseUndoableAction</code>, it is only used in test.
     */
    private class MockUsecaseUndoableAction extends UsecaseUndoableAction {
        /**
         * The constructor which simply calls the constructor of super class.
         *
         * @param modelElement passed to super class.
         * @param usecaseToolUtil passed to super class.
         */
        public MockUsecaseUndoableAction(ModelElement modelElement, UsecaseToolUtil usecaseToolUtil) {
            super(modelElement, usecaseToolUtil);
        }

        /**
         * The constructor which simply calls the constructor of super class.
         *
         * @param transferable passed to super class.
         * @param dataFlavor passed to super class.
         * @param usecaseToolUtil passed to super class.
         *
         * @throws InvalidDataContentException if failed to load ModelElement from Transferable
         */
        public MockUsecaseUndoableAction(Transferable transferable, DataFlavor dataFlavor,
            UsecaseToolUtil usecaseToolUtil) throws InvalidDataContentException {
            super(transferable, dataFlavor, usecaseToolUtil);
        }

        /**
         * Simply calls the method of super class.
         *
         * @return the UsecaseToolUtil instance
         */
        public UsecaseToolUtil getUsecaseToolUtil() {
            return super.getUsecaseToolUtil();
        }

        /**
         * Simply calls the method of super class.
         *
         * @return the ModelElement instance
         */
        public ModelElement getModelElement() {
            return super.getModelElement();
        }

        /**
         * Simply calls the method of super class.
         *
         * @return the Log instance
         */
        public Log getLog() {
            return super.getLog();
        }

        /**
         * Simply returns.
         */
        public void execute() {
        }
    }
}

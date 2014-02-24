/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.usecase.accuracytests;

import com.topcoder.uml.actions.model.usecase.ModelTransfer;
import com.topcoder.uml.model.modelmanagement.Subsystem;
import com.topcoder.uml.model.modelmanagement.SubsystemImpl;
import com.topcoder.uml.model.usecases.Actor;
import com.topcoder.uml.model.usecases.ActorImpl;
import com.topcoder.uml.model.usecases.Extend;
import com.topcoder.uml.model.usecases.ExtendImpl;
import com.topcoder.uml.model.usecases.Include;
import com.topcoder.uml.model.usecases.IncludeImpl;
import com.topcoder.uml.model.usecases.UseCase;
import com.topcoder.uml.model.usecases.UseCaseImpl;

import junit.framework.TestCase;

/**
 * Accuracy test for the <code>ModelTransfer</code> class.
 *
 * @author vividmxx
 * @version 1.0
 */
public class AccuracyTestModelTransfer extends TestCase {

    /**
     * The <code>Actor</code> instance used for test.
     */
    private Actor actor;

    /**
     * The <code>Extend</code> instance used for test.
     */
    private Extend extend;

    /**
     * The <code>Include</code> instance used for test.
     */
    private Include include;

    /**
     * The <code>Subsystem</code> instance used for test.
     */
    private Subsystem subsystem;

    /**
     * The <code>UseCase</code> instance used for test.
     */
    private UseCase useCase;

    /**
     * The <code>ModelTransfer</code> instance used to test against.
     */
    private ModelTransfer modelTransfer;

    /**
     * Set up the test environment.
     */
    public void setUp() {
        include = new IncludeImpl();
        extend = new ExtendImpl();
        useCase = new UseCaseImpl();
        subsystem = new SubsystemImpl();
        actor = new ActorImpl();
        modelTransfer = new ModelTransfer(actor);
    }

    /**
     * Test the constructor <code>ModelTransfer(Actor)</code>.
     */
    public void testConstructorWithActor() {
        ModelTransfer mt = new ModelTransfer(actor);
        assertNotNull("Instance of ModelTransfer should be created.", mt);
        assertTrue("DataFlavor field should be correct.",
            ModelTransfer.ACTOR_FLAVOR.equals(mt.getTransferDataFlavors()[0]));
    }

    /**
     * Test the constructor <code>ModelTransfer(UseCase)</code>.
     */
    public void testConstructorWithUseCase() {
        ModelTransfer mt = new ModelTransfer(useCase);
        assertNotNull("Instance of ModelTransfer should be created.", mt);
        assertTrue("DataFlavor field should be correct.",
            ModelTransfer.USECASE_FLAVOR.equals(mt.getTransferDataFlavors()[0]));
    }

    /**
     * Test the constructor <code>ModelTransfer(Subsystem)</code>.
     */
    public void testConstructorWithSubsystem() {
        ModelTransfer mt = new ModelTransfer(subsystem);
        assertNotNull("Instance of ModelTransfer should be created.", mt);
        assertTrue("DataFlavor field should be correct.",
            ModelTransfer.SUBSYSTEM_FLAVOR.equals(mt.getTransferDataFlavors()[0]));
    }

    /**
     * Test the constructor <code>ModelTransfer(Include)</code>.
     */
    public void testConstructorWithInclude() {
        ModelTransfer mt = new ModelTransfer(include);
        assertNotNull("Instance of ModelTransfer should be created.", mt);
        assertTrue("DataFlavor field should be correct.",
            ModelTransfer.INCLUDE_FLAVOR.equals(mt.getTransferDataFlavors()[0]));
    }

    /**
     * Test the constructor <code>ModelTransfer(Extend)</code>.
     */
    public void testConstructorWithExtend() {
        ModelTransfer mt = new ModelTransfer(extend);
        assertNotNull("Instance of ModelTransfer should be created.", mt);
        assertTrue("DataFlavor field should be correct.",
            ModelTransfer.EXTEND_FLAVOR.equals(mt.getTransferDataFlavors()[0]));
    }

    /**
     * Test the method <code>isDataFlavorSupported(DataFlavor)</code>.
     */
    public void testIsDataFlavorSupported() {
        assertFalse("False should be returned.", modelTransfer.isDataFlavorSupported(ModelTransfer.EXTEND_FLAVOR));
        assertFalse("False should be returned.", modelTransfer.isDataFlavorSupported(ModelTransfer.INCLUDE_FLAVOR));
        assertFalse("False should be returned.", modelTransfer.isDataFlavorSupported(ModelTransfer.SUBSYSTEM_FLAVOR));
        assertFalse("False should be returned.", modelTransfer.isDataFlavorSupported(ModelTransfer.USECASE_FLAVOR));
        assertTrue("True should be returned.", modelTransfer.isDataFlavorSupported(ModelTransfer.ACTOR_FLAVOR));
    }

    /**
     * Test the method <code>getTransferData(DataFlavor)</code>.
     *
     * @throws Exception
     *             throws to JUnit
     */
    public void testGetTransferData() throws Exception {
        assertTrue("The transfer data should be correct.",
            actor.equals(modelTransfer.getTransferData(ModelTransfer.ACTOR_FLAVOR)));
    }
}

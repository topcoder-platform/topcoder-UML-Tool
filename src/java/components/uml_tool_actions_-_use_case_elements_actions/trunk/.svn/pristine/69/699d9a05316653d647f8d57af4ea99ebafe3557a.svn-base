/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.usecase;

import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.modelmanagement.Subsystem;
import com.topcoder.uml.model.modelmanagement.SubsystemImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * Unit test cases for <code>{@link AddSubsystemAction}</code> class.
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class AddSubsystemActionTest extends TestCase {
    /** The UMLModelManager instance for testing. */
    private UMLModelManager manager;

    /** The Subsystem instance for testing. */
    private Subsystem subsystem;

    /** The AddSubsystemAction instance for testing. */
    private AddSubsystemAction addSubsystemAction;

    /** The Namespace instance for testing. */
    private Namespace namespace;

    /**
     * Set up the initial values.
     */
    public void setUp() {
        subsystem = new SubsystemImpl();
        manager = new UMLModelManager();
        addSubsystemAction = new AddSubsystemAction(subsystem, manager);
        namespace = new MockNamespaceAbstractImpl();
    }

    /**
     * <p>
     * Test <code>{@link AddSubsystemAction#AddSubsystemAction(Subsystem, UMLModelManager)}</code> with null subsystem.
     * Should throw an Exception here.
     * </p>
     */
    public void testConstructor_SubsystemUMLModelManager_NullSubsystem() {
        try {
            subsystem = null;
            new AddSubsystemAction(subsystem, manager);
            fail("Should throw an IllegalArgumentException here.");
        } catch (IllegalArgumentException iae) {
            //success
        }
    }

    /**
     * <p>
     * Test <code>{@link AddSubsystemAction#AddSubsystemAction(Subsystem, UMLModelManager)}</code> with null manager.
     * Should throw an Exception here.
     * </p>
     */
    public void testConstructor_SubsystemUMLModelManager_NullUMLModelManager() {
        try {
            manager = null;
            new AddSubsystemAction(subsystem, manager);
            fail("Should throw an IllegalArgumentException here.");
        } catch (IllegalArgumentException iae) {
            //success
        }
    }

    /**
     * <p>
     * Test <code>{@link AddSubsystemAction#AddSubsystemAction(Subsystem, UMLModelManager)}</code> with success
     * process.
     * </p>
     */
    public void testConstructor_SubsystemUMLModelManager_Success() {
        addSubsystemAction = new AddSubsystemAction(subsystem, manager);
        assertNotNull(addSubsystemAction);
    }

    /**
     * <p>
     * Test <code>{@link AddSubsystemAction#AddSubsystemAction(Subsystem, UMLModelManager, Namespace)}</code> with null
     * subsystem. Should throw an Exception here.
     * </p>
     */
    public void testConstructor_SubsystemUMLModelManagerNamespace_NullSubsystem() {
        try {
            subsystem = null;
            new AddSubsystemAction(subsystem, manager, namespace);
            fail("Should throw an IllegalArgumentException here.");
        } catch (IllegalArgumentException iae) {
            //success
        }
    }

    /**
     * <p>
     * Test <code>{@link AddSubsystemAction#AddSubsystemAction(Subsystem, UMLModelManager, Namespace)}</code> with null
     * manager. Should throw an Exception here.
     * </p>
     */
    public void testConstructor_SubsystemUMLModelManagerNamespace_NullUMLModelManager() {
        try {
            manager = null;
            new AddSubsystemAction(subsystem, manager, namespace);
            fail("Should throw an IllegalArgumentException here.");
        } catch (IllegalArgumentException iae) {
            //success
        }
    }

    /**
     * <p>
     * Test <code>{@link AddSubsystemAction#AddSubsystemAction(Subsystem, UMLModelManager, Namespace)}</code> with null
     * namespace. Should throw an Exception here.
     * </p>
     */
    public void testConstructor_SubsystemUMLModelManagerNamespace_NullNamespace() {
        try {
            namespace = null;
            new AddSubsystemAction(subsystem, manager, namespace);
            fail("Should throw an IllegalArgumentException here.");
        } catch (IllegalArgumentException iae) {
            //success
        }
    }

    /**
     * <p>
     * Test <code>{@link AddSubsystemAction#AddSubsystemAction(Subsystem, UMLModelManager, Namespace)}</code> with
     * success process.
     * </p>
     */
    public void testConstructor_SubsystemUMLModelManagerNamespace_Success() {
        addSubsystemAction = new AddSubsystemAction(subsystem, manager, namespace);
        assertNotNull(addSubsystemAction);
    }

    /**
     * <p>
     * Test <code>{@link AddSubsystemAction#getPresentationName()}</code> with success process.
     * </p>
     */
    public void testGetPresentationName_Success() {
        assertEquals("Add Subsystem", addSubsystemAction.getPresentationName());
    }

    /**
     * <p>
     * Test <code>{@link AddSubsystemAction#execute()}</code> with success process.
     * </p>
     *
     * @throws Exception to junit.
     */
    public void testExecute_Success() throws Exception {
        addSubsystemAction.execute();
    }

    /**
     * <p>
     * Test <code>{@link AddSubsystemAction#redo()}</code> with success process.
     * </p>
     */
    public void testRedo_Success() {
        addSubsystemAction.redo();
    }

    /**
     * <p>
     * Test <code>{@link AddSubsystemAction#undo()}</code> with success process.
     * </p>
     */
    public void testUndo_Success() {
        addSubsystemAction.undo();
    }

    /**
     * Returns the test suite of this test case.
     *
     * @return the test suite of this test case.
     */
    public static Test suite() {
        return new TestSuite(AddSubsystemActionTest.class);
    }
}

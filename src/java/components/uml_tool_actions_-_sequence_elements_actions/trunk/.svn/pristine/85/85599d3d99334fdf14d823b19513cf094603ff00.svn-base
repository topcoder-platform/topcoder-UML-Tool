/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.sequence;

import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.Transferable;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.topcoder.uml.model.collaborations.collaborationinteractions.Collaboration;
import com.topcoder.uml.model.collaborations.collaborationinteractions.CollaborationImpl;
import com.topcoder.uml.model.commonbehavior.instances.Object;
import com.topcoder.uml.model.commonbehavior.instances.ObjectImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.uml.projectconfiguration.ProjectConfigurationManager;

/**
 * <p>
 * This class gives a demo of all the functionality this component offers.
 * </p>
 *
 * @author evilisneo
 * @version 1.0
 */
public class Demo extends TestCase {

    /**
     * <p>
     * Sets up the environment for the TestCase.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    protected void setUp() throws Exception {
        TestHelper.loadConfig();
    }

    /**
     * <p>
     * Tears down the environment for the TestCase.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    protected void tearDown() throws Exception {
        TestHelper.releaseConfig();
    }

    /**
     * <p>
     * Aggregates all tests in this class.
     * </p>
     *
     * @return Test suite aggregating all tests.
     */
    public static Test suite() {
        return new TestSuite(Demo.class);
    }

    /**
     * <p>
     * Demo as in CS 4.3.
     * </p>
     * <p>
     * The following demo covers only the Object actions. Working with all other model elements are
     * practically the same. This component can not have its own scenario of running, it will be used by the
     * other components which define's its behavior.
     * </p>
     * <p>
     * Below is the simple example of adding an object, copying and pasting an object, cutting and pasting an
     * object and removing an object from the namespace. Except copy all the other actions has redo and undo
     * capability. This provides the user an easy to use option and ability to correct any mistakes.
     * </p>
     *
     * @throws Exception
     *             throws exception to JUnit.
     */
    public void testDemo1() throws Exception {
        /*
         * Object, Manager and Collaboration instances will be received from graphical part of UML Tool.
         */
        // Currently we define all these object ourseleves.
        Collaboration collaboration = new CollaborationImpl();
        UMLModelManager manager = new UMLModelManager();
        manager.setProjectConfigurationManager(new ProjectConfigurationManager(manager));
        Object object = new ObjectImpl();

        // Adding the object to the collaboration. This is just the instance creation.
        AddObjectAction addObject = new AddObjectAction(object, collaboration, manager);

        // Only after execute, the object is actually added.
        addObject.execute();

        // Now we can use undo and redo actions
        // this will remove the object from the collaboration
        addObject.undo();

        // Now we can redo the operation. The object will be added to collaboration again
        addObject.redo();

        // Copying an object to the clipboard. This only creates the instance.
        // by default this uses the system Clipboard.
        CopyObjectAction copyObject = new CopyObjectAction(object);

        // After executing, the object will be copied to the system clipboard
        copyObject.execute();

        // Custom ClipBoard creation
        Clipboard clipboard = new Clipboard("Test");

        // creating a copy object with the object and the Clipboard
        copyObject = new CopyObjectAction(object, clipboard);

        // After executing, the object will be copied to the given clipboard.
        copyObject.execute();

        // get the object from the clipboard as a transferable object
        Transferable transferable = clipboard.getContents(null);

        PasteObjectAction pasteObject;

        // we check whether the object is supported
        if (transferable.isDataFlavorSupported(CollaborationTransfer.OBJECT_FLAVOR)) {

            // paste the object to a collaboration
            pasteObject = new PasteObjectAction(transferable, collaboration);

            // only after execution, it is actually pasted. If we are pasting the object which is already
            // present, exception will be thrown
            pasteObject.execute();
        } else {
            // Provide some exception logic
        }

        // adding object to the namespace
        Object object1 = new ObjectImpl();

        // add the object
        new AddObjectAction(object1, collaboration, manager).execute();

        // Instance of the remove object.
        RemoveObjectAction removeObject = new RemoveObjectAction(object1);

        // remove the object from the collaboration
        removeObject.execute();

        // undo removal
        removeObject.undo();

        // redo removal
        removeObject.redo();

        // undo removal
        removeObject.undo();

        // cutting the object from its instance to the clipboard
        CutObjectAction cutObject = new CutObjectAction(object1, clipboard);

        // cut the object
        cutObject.execute();

        // undo cut
        cutObject.undo();

        // redo cut
        cutObject.redo();

        // new namespace to which the object to be pasted
        Collaboration collaboration1 = new CollaborationImpl();

        // get the contents from the clipboard
        transferable = clipboard.getContents(null);

        // create instance to paste the object to the newly created namespace
        pasteObject = new PasteObjectAction(transferable, collaboration1);

        // paste the object.
        pasteObject.execute();

        // undo paste
        pasteObject.undo();

        // redo paste
        pasteObject.redo();
    }
}

/*
 * Copyright (C) 2005 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.sequence.stresstests;

import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.Transferable;

import com.topcoder.uml.actions.model.sequence.AddObjectAction;
import com.topcoder.uml.actions.model.sequence.CollaborationTransfer;
import com.topcoder.uml.actions.model.sequence.CopyObjectAction;
import com.topcoder.uml.actions.model.sequence.CutObjectAction;
import com.topcoder.uml.actions.model.sequence.PasteObjectAction;
import com.topcoder.uml.actions.model.sequence.RemoveObjectAction;

import com.topcoder.uml.model.collaborations.collaborationinteractions.Collaboration;
import com.topcoder.uml.model.collaborations.collaborationinteractions.CollaborationImpl;
import com.topcoder.uml.model.commonbehavior.instances.Object;
import com.topcoder.uml.model.commonbehavior.instances.ObjectImpl;

import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.uml.projectconfiguration.ProjectConfigurationManager;

import junit.framework.TestCase;

/**
 * <p>
 * Stress test case for ObjectAction.
 * </p>
 * 
 * @author catcher
 * @version 1.0
 */
public class ObjectActionStressTest extends TestCase {

    /**
     * Represent the Object instance for test.
     */
    private Object object;

    /**
     * Represent Collaboration instance for test.
     */
    private Collaboration collaboration;

    /**
     * Represent Clipboard instance for test.
     */
    private Clipboard clipboard;

    /**
     * Represent UMLModelManager instance for test.
     */
    private UMLModelManager manager;

    /**
     * Represent ProjectConfigurationManager object for test.
     */
    private ProjectConfigurationManager config;

    /**
     * Sets up the test environment.
     * 
     * @throws Exception
     *         throw exception if any error occurs during setup.
     */
    protected void setUp() throws Exception {

        StressTestHelper.loadConfig();

        object = new ObjectImpl();
        object.setName("stress");
        collaboration = new CollaborationImpl();
        object.setNamespace(collaboration);

        clipboard = new Clipboard("StressClipboard");
        manager = new UMLModelManager("StressManager");

        config = new ProjectConfigurationManager(manager, "testNamespace");
        manager.setProjectConfigurationManager(config);

    }

    /**
     * Clears the configuration from ConfigManager.
     * 
     * @throws Exception
     *         throw exception if any error occurs during tearDown.
     */
    protected void tearDown() throws Exception {
        StressTestHelper.clearConfig();
    }

    /**
     * Stress test for Add Object Action.
     * 
     * @throws Exception
     *         into Junit
     */
    public void testAddObjectAction() throws Exception {

        long start = System.currentTimeMillis();

        for (int j = 0; j < StressTestHelper.MAX_COUNT; j++) {
            collaboration = new CollaborationImpl();
            AddObjectAction addObject = new AddObjectAction(object, collaboration, manager);
            addObject.execute();
            addObject.undo();
            addObject.redo();

            assertTrue("object should be added to collaboration", collaboration.containsOwnedElement(object));
        }

        System.out.println("running " + StressTestHelper.MAX_COUNT + " AddObject actions using will cost "
                        + (System.currentTimeMillis() - start) + " milliseconds.");
    }

    /**
     * Stress test for Copy Object Action.
     * 
     * @throws Exception
     *         into Junit
     */
    public void testCopyObjectAction() throws Exception {

        long start = System.currentTimeMillis();
        for (int j = 0; j < StressTestHelper.MAX_COUNT; j++) {
            clipboard = new Clipboard("StressClipboard");
            CopyObjectAction copyObject = new CopyObjectAction(object, clipboard);

            copyObject.execute();

            Object copiedObj = (Object) clipboard.getContents(new java.lang.Object()).getTransferData(
                            CollaborationTransfer.OBJECT_FLAVOR);
            assertEquals("object instance should be copied to clipboard.", "stress", copiedObj.getName());
        }
        System.out.println("running " + StressTestHelper.MAX_COUNT + " CopyObject actions using will cost "
                        + (System.currentTimeMillis() - start) + " milliseconds.");
    }

    /**
     * Stress test for Paste Object Action.
     * 
     * @throws Exception
     *         into Junit
     */
    public void testPasteObjectAction() throws Exception {

        long start = System.currentTimeMillis();

        for (int j = 0; j < StressTestHelper.MAX_COUNT; j++) {
            collaboration = new CollaborationImpl();
            Transferable transferable = transferable = new CollaborationTransfer(object);
            PasteObjectAction pasteObject = new PasteObjectAction(transferable, collaboration);

            pasteObject.execute();

            pasteObject.undo();
            pasteObject.redo();

            assertTrue("object should be added to the collaboration", collaboration.containsOwnedElement(object));

        }
        System.out.println("running " + StressTestHelper.MAX_COUNT + " PasteObject actions using will cost "
                        + (System.currentTimeMillis() - start) + " milliseconds.");
    }

    /**
     * Stress test for Cut Object Action.
     * 
     * @throws Exception
     *         into Junit
     */
    public void testCutObjectAction() throws Exception {

        long start = System.currentTimeMillis();

        for (int j = 0; j < StressTestHelper.MAX_COUNT; j++) {
            collaboration.clearOwnedElements();
            collaboration.addOwnedElement(object);
            clipboard = new Clipboard("StressClipboard");

            CutObjectAction cutObject = new CutObjectAction(object, clipboard);
            cutObject.execute();
            cutObject.undo();
            cutObject.redo();
            // Get object from clipboard.
            Object cutObj = (Object) clipboard.getContents(new java.lang.Object()).getTransferData(
                            CollaborationTransfer.OBJECT_FLAVOR);
            assertEquals("object instance should be moved to clipboard.", "stress", cutObj.getName());
        }

        System.out.println("running " + StressTestHelper.MAX_COUNT + " CutObject actions using will cost "
                        + (System.currentTimeMillis() - start) + " milliseconds.");
    }

    /**
     * Stress test for Remove Object Action.
     * 
     * @throws Exception
     *         into Junit
     */
    public void testRemoveObjectAction() throws Exception {

        long start = System.currentTimeMillis();
        for (int j = 0; j < StressTestHelper.MAX_COUNT; j++) {
            collaboration.clearOwnedElements();
            collaboration.addOwnedElement(object);
            RemoveObjectAction removeObject = new RemoveObjectAction(object);
            removeObject.execute();
            removeObject.undo();
            removeObject.redo();
            assertFalse("object should be remove from the collaboration", collaboration.containsOwnedElement(object));
        }
        System.out.println("running " + StressTestHelper.MAX_COUNT + " RemoveObject actions using will cost "
                        + (System.currentTimeMillis() - start) + " milliseconds.");
    }

}
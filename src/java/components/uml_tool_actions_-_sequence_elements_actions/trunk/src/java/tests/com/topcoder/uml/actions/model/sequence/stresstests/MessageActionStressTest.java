/*
 * Copyright (C) 2005 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.sequence.stresstests;

import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.Transferable;
import com.topcoder.uml.actions.model.sequence.AddAsynchronousMessageAction;
import com.topcoder.uml.actions.model.sequence.CollaborationTransfer;
import com.topcoder.uml.actions.model.sequence.CopyAsynchronousMessageAction;
import com.topcoder.uml.actions.model.sequence.CutAsynchronousMessageAction;
import com.topcoder.uml.actions.model.sequence.PasteAsynchronousMessageAction;
import com.topcoder.uml.actions.model.sequence.RemoveAsynchronousMessageAction;
import com.topcoder.uml.model.actions.messagingactions.CallOperationAction;
import com.topcoder.uml.model.actions.messagingactions.CallOperationActionImpl;
import com.topcoder.uml.model.collaborations.collaborationinteractions.Collaboration;
import com.topcoder.uml.model.collaborations.collaborationinteractions.CollaborationImpl;
import com.topcoder.uml.model.commonbehavior.instances.Stimulus;
import com.topcoder.uml.model.commonbehavior.instances.StimulusImpl;
import com.topcoder.uml.model.commonbehavior.procedure.Procedure;
import com.topcoder.uml.model.commonbehavior.procedure.ProcedureImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.uml.projectconfiguration.ProjectConfigurationManager;

import junit.framework.TestCase;

/**
 * <p>
 * Stress test case for MessageAction.
 * </p>
 * 
 * @author catcher
 * @version 1.0
 */
public class MessageActionStressTest extends TestCase {

    /**
     * Represent Stimulus instance for test.
     */
    private Stimulus stimulus;

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

        stimulus = new StimulusImpl();

        // Create an asynchronous message.
        Procedure procedure = new ProcedureImpl();
        CallOperationAction action = new CallOperationActionImpl();
        action.setAsynchronous(true);
        procedure.setAction(action);
        stimulus.setDispatchAction(procedure);

        stimulus.setName("stress");

        collaboration = new CollaborationImpl();
        stimulus.setNamespace(collaboration);
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
     * Stress test for Add Message Action.
     * 
     * @throws Exception
     *         into Junit
     */
    public void testAddMessageAction() throws Exception {

        long start = System.currentTimeMillis();

        for (int j = 0; j < StressTestHelper.MAX_COUNT; j++) {
            collaboration = new CollaborationImpl();
            AddAsynchronousMessageAction addMessage = new AddAsynchronousMessageAction(stimulus, collaboration, manager);
            addMessage.execute();
            addMessage.undo();
            addMessage.redo();
        }

        assertEquals("object should be added to collaboration", true, collaboration.containsOwnedElement(stimulus));
        System.out.println("running " + StressTestHelper.MAX_COUNT + " AddMessage actions using will cost "
                        + (System.currentTimeMillis() - start) + " milliseconds.");
    }

    /**
     * Stress test for Copy Message Action.
     * 
     * @throws Exception
     *         into Junit
     */
    public void testCopyMessageAction() throws Exception {

        long start = System.currentTimeMillis();

        for (int j = 0; j < StressTestHelper.MAX_COUNT; j++) {
            clipboard = new Clipboard("StressClipboard");
            CopyAsynchronousMessageAction copyMessage = new CopyAsynchronousMessageAction(stimulus, clipboard);
            copyMessage.execute();
            Stimulus copyStimulus = (Stimulus) clipboard.getContents(new java.lang.Object()).getTransferData(
                            CollaborationTransfer.ASYNCHRONOUS_MESSAGE_FLAVOR);
            assertEquals("object instance should be copied to clipboard.", "stress", copyStimulus.getName());
        }

        System.out.println("running " + StressTestHelper.MAX_COUNT + " CopyMessage actions using will cost "
                        + (System.currentTimeMillis() - start) + " milliseconds.");
    }

    /**
     * Stress test for Paste Message Action.
     * 
     * @throws Exception
     *         into Junit
     */
    public void testPasteMessageAction() throws Exception {

        long start = System.currentTimeMillis();

        for (int j = 0; j < StressTestHelper.MAX_COUNT; j++) {
            collaboration = new CollaborationImpl();
            Transferable transferable = transferable = new CollaborationTransfer(stimulus);
            PasteAsynchronousMessageAction pasteMessage = new PasteAsynchronousMessageAction(transferable,
                            collaboration);
            pasteMessage.execute();

            pasteMessage.undo();
            pasteMessage.redo();
            assertTrue("object should be added to the collaboration", collaboration.containsOwnedElement(stimulus));
        }

        System.out.println("running " + StressTestHelper.MAX_COUNT + " PasteMessage actions using will cost "
                        + (System.currentTimeMillis() - start) + " milliseconds.");
    }

    /**
     * Stress test for Cut Message Action.
     * 
     * @throws Exception
     *         into Junit
     */
    public void testCutMessageAction() throws Exception {

        long start = System.currentTimeMillis();

        for (int j = 0; j < StressTestHelper.MAX_COUNT; j++) {
            collaboration.clearOwnedElements();
            collaboration.addOwnedElement(stimulus);
            clipboard = new Clipboard("StressClipboard");
            CutAsynchronousMessageAction cutMessage = new CutAsynchronousMessageAction(stimulus, clipboard);
            cutMessage.execute();
            cutMessage.undo();
            cutMessage.redo();
            // Get element and change the type to Stimulus.
            Stimulus cutStimulus = (Stimulus) clipboard.getContents(new java.lang.Object()).getTransferData(
                            CollaborationTransfer.ASYNCHRONOUS_MESSAGE_FLAVOR);
            assertEquals("object instance should be moved to clipboard.", "stress", cutStimulus.getName());
        }

        System.out.println("running " + StressTestHelper.MAX_COUNT + " CutMessage actions using will cost "
                        + (System.currentTimeMillis() - start) + " milliseconds.");
    }

    /**
     * Stress test for Remove Message Action.
     * 
     * @throws Exception
     *         into Junit
     */
    public void testRemoveMessageAction() throws Exception {

        long start = System.currentTimeMillis();

        for (int j = 0; j < StressTestHelper.MAX_COUNT; j++) {
            collaboration.clearOwnedElements();
            collaboration.addOwnedElement(stimulus);

            RemoveAsynchronousMessageAction removeMessage = new RemoveAsynchronousMessageAction(stimulus);
            removeMessage.execute();

            removeMessage.undo();
            removeMessage.redo();
            assertFalse("object should be remove from the collaboration", collaboration.containsOwnedElement(stimulus));
        }

        System.out.println("running " + StressTestHelper.MAX_COUNT + " RemoveMessage actions using will cost "
                        + (System.currentTimeMillis() - start) + " milliseconds.");
    }

}
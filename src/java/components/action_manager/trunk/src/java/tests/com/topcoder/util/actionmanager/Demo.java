/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.util.actionmanager;

import java.util.List;

import com.topcoder.util.log.Level;
import com.topcoder.util.log.Log;
import com.topcoder.util.log.LogFactory;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * <p>
 * The component demonstration for this component.
 * </p>
 *
 * <p>
 * The following scenarios are included:
 * <ul>
 * <li>Creation of the ActionManager</li>
 * <li>Executing of simple action</li>
 * <li>Executing of transient action</li>
 * <li>Executing of UndoableAction</li>
 * <li>Getting the Presentation Names for the UndoableActions</li>
 * <li>Marking an UndoableAction not to be used further</li>
 * </ul>
 * </p>
 *
 * @author biotrail
 * @version 1.0
 */
public class Demo extends TestCase {
    /**
     * <p>
     * Setup test environment.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void setUp() throws Exception {
        TestHelper.loadSingleXMLConfig(TestHelper.LOG_NAMESPACE, TestHelper.LOG_CONFIGFILE);
        TestHelper.loadSingleXMLConfig("com.topcoder.util.actionmanager", "test_files/config.xml");
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void tearDown() throws Exception {
        TestHelper.clearConfigFile(TestHelper.LOG_NAMESPACE);
        TestHelper.clearConfigFile("com.topcoder.util.actionmanager");
    }

    /**
     * <p>
     * Return all tests.
     * </p>
     *
     * @return all tests
     */
    public static Test suite() {
        return new TestSuite(Demo.class);
    }

    /**
     * <p>
     * This method is used to show how to use this component.
     * </p>
     *
     * <p>
     * The following scenarios are included:
     * <ul>
     * <li>Creation of the ActionManager</li>
     * <li>Executing of simple action</li>
     * <li>Executing of transient action</li>
     * <li>Executing of UndoableAction</li>
     * <li>Getting the Presentation Names for the UndoableActions</li>
     * <li>Marking an UndoableAction not to be used further</li>
     * </ul>
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testDemo() throws Exception {
        /////////////////////////////////////////////////////
        // Demonstration of the creation of the ActionManager
        /////////////////////////////////////////////////////

        ActionManager manager = null;
        // ActionManager with no logging to be done and with max UndoableAction limit set to 10
        manager = new ActionManager();
        // ActionManager initialized from the configuration values specified in the passed namespace
        // in the configuration file.
        manager = new ActionManager("com.topcoder.util.actionmanager");
        // ActionManager created by explicitly specifying the max UndoableAction limit to 50 and
        // specifying the Log instance to be used and the Level of logging to be performed to ERROR.
        Log logger = LogFactory.getLog("MyLog");
        manager = new ActionManager(50, logger, Level.DEBUG);

        //////////////////////////////////////////////
        // Demonstration of executing of simple action
        //////////////////////////////////////////////

        // Creating the Action for Opening a Project.
        Action openProject = new OpenProjectAction();
        // Executing the "openProject" Action. This should clear the state of the AdvancedUndoManager
        manager.executeAction(openProject);
        // Creating the Action for Closing a Project.
        Action closeProject = new CloseProjectAction();
        // Executing the "closeProject" Action. This should clear the state of the AdvancedUndoManager
        manager.executeAction(closeProject);

        /////////////////////////////////////////////////
        // Demonstration of executing of transient action
        /////////////////////////////////////////////////

        // Creating the Action for printing a project
        TransientAction printAction = new PrintClassDiagramAction();
        // Creating the Action for saving a project.
        TransientAction saveAction = new SaveProjectAction();

        // Executing these TransientAction. These should not change the state of the
        // AdavancedUndoManager within the ActionManager.
        manager.executeAction(printAction);
        manager.executeAction(saveAction);

        // Creation of the Undoable wrapper for the two TransientActions.
        UndoableAction undoableWrapperPrintAction = new TransientUndoableAction(printAction, "PrintAction", null);
        UndoableAction undoableWrapperSaveAction = new TransientUndoableAction(saveAction, "SaveAction", logger);

        // the undo method will not do anything, while the redo() will execute the action again.
        undoableWrapperPrintAction.undo();
        undoableWrapperSaveAction.redo();

        // However the following calls will affect the state of the AdvancedUndoManager within the
        // ActionManager.
        manager.executeAction(undoableWrapperPrintAction);
        manager.executeAction(undoableWrapperSaveAction);

        // Getting the last exception if any had occurred in the execution of TransientUndoableAction.
        ActionExecutionException exception = ((TransientUndoableAction) undoableWrapperPrintAction).getLastException();

        ///////////////////////////////////////////////
        // Demonstration of executing of UndoableAction
        ///////////////////////////////////////////////

        // Creation of an UndoableAction for the Adding a class to the diagram.
        UndoableAction addClassAction = new AddClassDiagramAction();
        // Creation of an UndoableAction for the Adding a members to the class.
        UndoableAction addClassMemberAction = new AddClassMemberAction();

        // Executing these Actions. Should change the state of the AdvancedUndoManager when these
        // when these actions are executed.
        manager.executeAction(addClassAction);
        manager.executeAction(addClassMemberAction);

        // Creating UndoableActions for deleting a set of classes and adding them to a
        // CompoundUndoableAction so that these are executed as a unit and can be un-done/re-done
        // as a unit.
        UndoableAction compoundAction = new CompoundUndoableAction("CompoundUndoableAction");
        // Create a DeleteClassAction [not from this component, but a similar action (may be with
        // different name) will be present in the other component of the TC UML Tool, for each of the
        // class to be deleted. [Only one shown here, others to be done similarly]
        UndoableAction deleteClassAction = new DeleteClassAction();
        compoundAction.addEdit(deleteClassAction);

        // Execute the compoundAction. All actions inside it will be executed and the state of the
        // AdvancedUndoManager will be changed.
        manager.executeAction(compoundAction);
        // Getting the last Action that can be undone.
        // The "action" instance returned should be "compoundAction" instance.
        UndoableAction action = manager.getUndoableActionToBeUndone();
        // Getting the LastException that might have occurred in executing the "compoundException".
        Exception e = ((CompoundUndoableAction) compoundAction).getLastException();
        // Performing the undo of the UndoableActions till "compoundAction". In this case, since
        // "compoundAction" is the last one and so only the "compoundAction" will be undone.
        manager.undoActions(compoundAction);
        // Getting the last Action that can be redone.
        // The "action" instance returned should be "compoundAction" instance.
        action = manager.getUndoableActionToBeRedone();
        // Performing the undo of the UndoableActions till "compoundAction". In this case, since
        // "compoundAction" is the last one and so only the "compoundAction" will be undone.
        manager.redoActions(compoundAction);
        // Getting the List of UndoableAction(s) that can be Undone.
        List undoActions = manager.getUndoableActionsToBeUndone();
        // Getting the List of UndoableAction(s) that can be Undone.
        List redoActions = manager.getUndoableActionsToBeRedone();

        //////////////////////////////////////////////////////////////////////////
        // Demonstration of getting the Presentation Names for the UndoableActions
        //////////////////////////////////////////////////////////////////////////

        String presentationName = undoableWrapperPrintAction.getPresentationName();
        String undoPresentationName = undoableWrapperPrintAction.getUndoPresentationName();
        String redoPresentationName = undoableWrapperPrintAction.getRedoPresentationName();

        ////////////////////////////////////////////////////////////////////
        // Demonstration of marking an UndoableAction not to be used further
        ////////////////////////////////////////////////////////////////////

        // Using the "undoableWrapperPrintAction" created in step 2.b for this.
        undoableWrapperPrintAction.die();
        // After this call the following call will thrown an ActionExecutionException.
        try {
            manager.executeAction(undoableWrapperPrintAction);
        } catch (ActionExecutionException aee) {
            // expected
        }
    }
}

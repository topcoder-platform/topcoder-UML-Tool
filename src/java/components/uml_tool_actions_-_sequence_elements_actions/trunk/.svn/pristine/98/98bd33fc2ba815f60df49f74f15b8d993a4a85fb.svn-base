/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.sequence;

import java.lang.reflect.Field;
import java.util.Iterator;

import com.topcoder.uml.model.actions.messagingactions.CallOperationAction;
import com.topcoder.uml.model.actions.messagingactions.CallOperationActionImpl;
import com.topcoder.uml.model.actions.messagingactions.SendSignalAction;
import com.topcoder.uml.model.actions.messagingactions.SendSignalActionImpl;
import com.topcoder.uml.model.actions.objectactions.CreateObjectAction;
import com.topcoder.uml.model.actions.objectactions.CreateObjectActionImpl;
import com.topcoder.uml.model.collaborations.collaborationinteractions.Collaboration;
import com.topcoder.uml.model.collaborations.collaborationinteractions.CollaborationImpl;
import com.topcoder.uml.model.commonbehavior.instances.Object;
import com.topcoder.uml.model.commonbehavior.instances.ObjectImpl;
import com.topcoder.uml.model.commonbehavior.instances.Stimulus;
import com.topcoder.uml.model.commonbehavior.instances.StimulusImpl;
import com.topcoder.uml.model.commonbehavior.procedure.Procedure;
import com.topcoder.uml.model.commonbehavior.procedure.ProcedureImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.util.config.ConfigManager;
import com.topcoder.util.config.UnknownNamespaceException;

/**
 * <p>
 * Defines helper methods used in tests.
 * </p>
 *
 * @author evilisneo
 * @version 1.0
 */
public final class TestHelper {

    /** Current User Directory. */
    public static final String TEMP = System.getProperty("user.dir");

    /** Test Files Directory. */
    public static final String TEST_FILES_DIR = TEMP + "/test_files/";

    /** Correct Config file. */
    public static final String FILE_CONFIG = TEMP + "/test_files/Logging.xml";

    /**
     * UMLModelManager instance for testing.
     */
    public static final UMLModelManager MODEL_MANAGER = new UMLModelManager();

    /**
     * Collaboration instance used for testing.
     */
    public static final Collaboration COLLABORATION = new CollaborationImpl();

    /**
     * Stimulus instance used for testing.
     */
    public static final Stimulus STIMULUS = new StimulusImpl();

    /**
     * Stimulus instance used for testing.
     */
    public static final Object OBJECT = new ObjectImpl();

    /**
     * <p>
     * Creates a new instance of <code>TestHelper</code> class. The private constructor prevents the
     * creation of a new instance.
     * </p>
     */
    private TestHelper() {
    }

    /**
     * <p>
     * Adds the valid config files for testing.
     * </p>
     *
     * @throws Exception
     *             unexpected exception.
     */
    public static void loadConfig() throws Exception {
        releaseConfig();
        ConfigManager configManager = ConfigManager.getInstance();
        configManager.add(FILE_CONFIG);
    }

    /**
     * <p>
     * Clears the config.
     * </p>
     */
    public static void releaseConfig() {
        ConfigManager configManager = ConfigManager.getInstance();
        // remove all the name space from the config manager.
        for (Iterator iter = configManager.getAllNamespaces(); iter.hasNext();) {
            try {
                configManager.removeNamespace((String) iter.next());
            } catch (UnknownNamespaceException e) {
                // ignore
            }
        }
    }

    /**
     * <p>
     * Creates a stimulus type and sets the necessary details for an asynchronous message.
     * </p>
     *
     * @return the created stimulus.
     */
    public static Stimulus getAsynchronousMessage() {
        Stimulus stimulus = new StimulusImpl();
        Procedure procedure = new ProcedureImpl();
        // call operation action for the procedure
        CallOperationAction callOperationAction = new CallOperationActionImpl();
        // set asynchronous to true
        callOperationAction.setAsynchronous(true);
        procedure.setAction(callOperationAction);
        // set the dispatch action
        stimulus.setDispatchAction(procedure);
        return stimulus;
    }

    /**
     * <p>
     * Creates a stimulus type and sets the necessary details for a synchronous message.
     * </p>
     *
     * @return the created stimulus.
     */
    public static Stimulus getSynchronousMessage() {
        // get the asynchronous message
        Stimulus stimulus = getAsynchronousMessage();
        // set the asynchronous action to false.
        ((CallOperationAction) stimulus.getDispatchAction().getAction()).setAsynchronous(false);
        return stimulus;
    }

    /**
     * <p>
     * Creates a stimulus type and sets the necessary details for a create message type.
     * </p>
     *
     * @return the created stimulus.
     */
    public static Stimulus getCreateMessage() {
        Stimulus stimulus = new StimulusImpl();
        Procedure procedure = new ProcedureImpl();
        CreateObjectAction createObjectAction = new CreateObjectActionImpl();
        procedure.setAction(createObjectAction);
        stimulus.setDispatchAction(procedure);
        return stimulus;
    }

    /**
     * <p>
     * Creates a stimulus type and sets the necessary details for a return message type.
     * </p>
     *
     * @return the created stimulus.
     */
    public static Stimulus getReturnMessage() {
        Stimulus stimulus = new StimulusImpl();
        stimulus.setDispatchAction(new ProcedureImpl());
        return stimulus;
    }

    /**
     * <p>
     * Creates a stimulus type and sets the necessary details for a send signal message type.
     * </p>
     *
     * @return the created stimulus.
     */
    public static Stimulus getSendSignalMessage() {
        Stimulus stimulus = new StimulusImpl();
        Procedure procedure = new ProcedureImpl();
        SendSignalAction sendSignalAction = new SendSignalActionImpl();
        procedure.setAction(sendSignalAction);
        stimulus.setDispatchAction(procedure);
        return stimulus;
    }

    /**
     * <p>
     * Gets the field value of a given object.
     * </p>
     *
     * @param object
     *            the object where to get the field value.
     * @param fieldName
     *            the name of the field.
     * @return the field value
     * @throws Exception
     *             any exception occurs.
     */
    public static java.lang.Object getFieldValue(java.lang.Object object, String fieldName) throws Exception {
        Field field = object.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        return field.get(object);
    }
}

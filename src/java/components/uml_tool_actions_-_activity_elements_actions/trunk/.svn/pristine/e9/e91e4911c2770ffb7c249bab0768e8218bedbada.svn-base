/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.activity.accuracytests;

import java.io.File;
import java.util.Iterator;

import com.topcoder.uml.model.activitygraphs.ActionState;
import com.topcoder.uml.model.activitygraphs.ActionStateImpl;
import com.topcoder.uml.model.activitygraphs.ObjectFlowState;
import com.topcoder.uml.model.activitygraphs.ObjectFlowStateImpl;
import com.topcoder.uml.model.core.extensionmechanisms.TagDefinition;
import com.topcoder.uml.model.core.extensionmechanisms.TagDefinitionImpl;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValue;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValueImpl;
import com.topcoder.uml.model.datatypes.PseudostateKind;
import com.topcoder.uml.model.statemachines.CompositeState;
import com.topcoder.uml.model.statemachines.CompositeStateImpl;
import com.topcoder.uml.model.statemachines.FinalState;
import com.topcoder.uml.model.statemachines.FinalStateImpl;
import com.topcoder.uml.model.statemachines.Pseudostate;
import com.topcoder.uml.model.statemachines.PseudostateImpl;
import com.topcoder.uml.model.statemachines.SimpleState;
import com.topcoder.uml.model.statemachines.SimpleStateImpl;
import com.topcoder.uml.model.statemachines.StateMachine;
import com.topcoder.uml.model.statemachines.StateMachineImpl;
import com.topcoder.uml.model.statemachines.StateVertex;
import com.topcoder.uml.model.statemachines.Transition;
import com.topcoder.uml.model.statemachines.TransitionImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.uml.projectconfiguration.ProjectConfigurationManager;
import com.topcoder.util.config.ConfigManager;

/**
 * <p>
 * This class provides helper method for the accuracy tests.
 * </p>
 * <p>
 * This class is made public as the accuracy tests classes are located in different packages.
 * </p>
 *
 * @author ch_music
 * @version 1.0
 */
public final class AccuracyTestHelper {

    /**
     * The namespace for Logging Wrapper component.
     */
    public static final String LOG_NAMESPACE = "com.topcoder.util.log";

    /**
     * The config file for Logging Wrapper component.
     */
    public static final String LOG_CONFIGPATH = "test_files/AccuracyTests_LoggingWrapper.xml";

    /**
     * Private constructor to prevent instantiation.
     */
    private AccuracyTestHelper() {
    }

    /**
     * Loads a configuration in the given file into the given namespace with Configuration Manager.
     *
     * @param namespace the namespace target
     * @param fileName the path of the configuration file
     * @throws Exception if any exception occurs
     */
    public static void loadConfig(String namespace, String fileName) throws Exception {
        ConfigManager configManager = ConfigManager.getInstance();
        File file = new File(fileName);

        if (configManager.existsNamespace(namespace)) {
            configManager.removeNamespace(namespace);
        }

        configManager.add(namespace, file.getCanonicalPath(), ConfigManager.CONFIG_XML_FORMAT);
    }

    /**
     * Removes all the loaded configuration from Configuration Manager.
     *
     * @param namespace the namespace to be removed from Configuration Manager
     * @throws Exception if any exception occurs
     */
    public static void tearConfig() throws Exception {
        ConfigManager configManager = ConfigManager.getInstance();

        for (Iterator i = configManager.getAllNamespaces(); i.hasNext();) {
            String namespace = (String) i.next();

            if (configManager.existsNamespace(namespace)) {
                configManager.removeNamespace(namespace);
            }
        }
    }

    /**
     * Adds a tag value with the given type and data value to a StateVertex.
     *
     * @param state the StateVertex
     * @param type the tag type
     * @param dataValue the tag value
     * @return the given StateVertex with a TaggedValue added
     */
    public static StateVertex addTaggedValue(StateVertex state, String type, String dataValue) {
        TagDefinition tagDefinition = new TagDefinitionImpl();
        tagDefinition.setTagType(type);

        TaggedValue taggedValue = new TaggedValueImpl();
        taggedValue.setType(tagDefinition);
        taggedValue.setDataValue(dataValue);

        state.addTaggedValue(taggedValue);

        return state;
    }

    /**
     * Checks if a StateVertex contains a TaggedValue object, whose TaggedDefinition's tagType the TaggedValue's
     * dataValue is the same as the given ones.
     *
     * @param state The StateVertex object to be checked
     * @param tagType the tag type to be compared with
     * @param value the data value to be compared with
     * @return true if the given StateVertex contains a TaggedValue object, whose TaggedDefinition's tagType the
     *         TaggedValue's dataValue is the same as the given ones
     */
    public static boolean checkTaggedValue(StateVertex state, String tagType, String value) {
        for (TaggedValue taggedValue : state.getTaggedValues()) {
            if (tagType.equals(taggedValue.getType().getTagType())
                    && value.equals(taggedValue.getDataValue())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Creates a UMLModelManager configured with a mock ProjectConfigurationManager.
     *
     * @return a UMLModelManager configured with a mock ProjectConfigurationManager
     * @throws Exception if any exception occurs
     */
    public static UMLModelManager createModelManager() throws Exception {
        UMLModelManager manager = new UMLModelManager();
        ProjectConfigurationManager pcm = new MockProjectConfigurationManager(manager);
        manager.setProjectConfigurationManager(pcm);

        // Sets to "Java". This attribute is used for testing, please change carefully.
        manager.setProjectLanguage("Java");

        return manager;
    }

    /**
     * Creates a SimpleState node that qualifies as an Accept Event Action.
     *
     * @return a SimpleState node that qualifies as an Accept Event Action
     */
    public static SimpleState createAcceptEventAction() {
        SimpleState state = new SimpleStateImpl();
        state.setName("AcceptEventAction");
        addTaggedValue(state, "AcceptEventAction", "True");
        createAndSetContainer(state);

        return state;
    }

    /**
     * Creates an ActionState node.
     *
     * @return an ActionState node
     */
    public static ActionState createActionState() {
        ActionState state = new ActionStateImpl();
        state.setName("ActionState");
        createAndSetContainer(state);

        return state;
    }

    /**
     * Creates a Pseudostate node that qualifies as a Decision Node.
     *
     * @return a Pseudostate node that qualifies as a Decision Node
     */
    public static Pseudostate createDecisionNode() {
        Pseudostate state = new PseudostateImpl();
        state.setName("DecisionNode");
        state.setKind(PseudostateKind.CHOICE);
        createAndSetContainer(state);

        return state;
    }

    /**
     * Creates a FinalState node that qualifies as a Final Node.
     *
     * @return a FinalState node that qualifies as a Final Node
     */
    public static FinalState createFinalNode() {
        FinalState state = new FinalStateImpl();
        state.setName("FinalNode");
        createAndSetContainer(state);

        return state;
    }

    /**
     * Creates a FinalState node that qualifies as a Flow Final Node.
     *
     * @return a FinalState node that qualifies as a Flow Final Node
     */
    public static FinalState createFlowFinalNode() {
        FinalState state = new FinalStateImpl();
        state.setName("FlowFinalNode");
        addTaggedValue(state, "FinalNodeType", "FlowFinalNode");
        createAndSetContainer(state);

        return state;
    }

    /**
     * Creates a Pseudostate node that qualifies as a Fork Node.
     *
     * @return a Pseudostate node that qualifies as a Fork Node
     */
    public static Pseudostate createForkNode() {
        Pseudostate state = new PseudostateImpl();
        state.setName("ForkNode");
        state.setKind(PseudostateKind.FORK);
        createAndSetContainer(state);

        return state;
    }

    /**
     * Creates a Pseudostate node that qualifies as an Initial Node.
     *
     * @return a Pseudostate node that qualifies as an Initial Node
     */
    public static Pseudostate createInitialNode() {
        Pseudostate state = new PseudostateImpl();
        state.setName("InitialNode");
        state.setKind(PseudostateKind.INITIAL);
        createAndSetContainer(state);

        return state;
    }

    /**
     * Creates a Pseudostate node that qualifies as a Join Node.
     *
     * @return a Pseudostate node that qualifies as a Join Node
     */
    public static Pseudostate createJoinNode() {
        Pseudostate state = new PseudostateImpl();
        state.setName("JoinNode");
        state.setKind(PseudostateKind.JOIN);
        createAndSetContainer(state);

        return state;
    }

    /**
     * Creates a Pseudostate node that qualifies as a Merge Node.
     *
     * @return a Pseudostate node that qualifies as a Merge Node
     */
    public static Pseudostate createMergeNode() {
        Pseudostate state = new PseudostateImpl();
        state.setName("MergeNode");
        state.setKind(PseudostateKind.JUNCTION);
        createAndSetContainer(state);

        return state;
    }

    /**
     * Creates an ObjectFlowState node.
     *
     * @return an ObjectFlowState node
     */
    public static ObjectFlowState createObjectFlowState() {
        ObjectFlowState state = new ObjectFlowStateImpl();
        state.setName("ObjectFlowState");
        createAndSetContainer(state);

        return state;
    }

    /**
     * Creates a SimpleState node that qualifies as a Send Signal Action.
     *
     * @return a SimpleState node that qualifies as a Send Signal Action
     */
    public static SimpleState createSendSignalAction() {
        SimpleState state = new SimpleStateImpl();
        state.setName("SendSignalAction");
        addTaggedValue(state, "SendSignalAction", "True");
        createAndSetContainer(state);

        return state;
    }

    /**
     * Creates a container for a StateVertex instance and set the appropriate attributes.
     *
     * @param state the StateVertex instance for which the container is to be made
     */
    private static void createAndSetContainer(StateVertex state) {
        CompositeState container = new CompositeStateImpl();
        container.addSubVertex(state);
        state.setContainer(container);
    }

    /**
     * Creates a Transition.
     *
     * @return a Transition
     */
    public static Transition createTransition() {
        Transition transition = new TransitionImpl();
        transition.setName("transition");

        StateMachine container = new StateMachineImpl();
        container.addTransition(transition);
        transition.setStateMachine(container);

        return transition;
    }
}

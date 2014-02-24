/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.trees.document.stresstests;

import java.io.File;
import java.util.Iterator;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.SimpleSemanticModelElement;
import com.topcoder.diagraminterchange.Uml1SemanticModelBridge;
import com.topcoder.uml.model.activitygraphs.ActivityGraph;
import com.topcoder.uml.model.activitygraphs.ActivityGraphImpl;
import com.topcoder.uml.model.collaborations.collaborationinstances.CollaborationInstanceSet;
import com.topcoder.uml.model.collaborations.collaborationinstances.CollaborationInstanceSetImpl;
import com.topcoder.uml.model.collaborations.collaborationinteractions.Collaboration;
import com.topcoder.uml.model.collaborations.collaborationinteractions.CollaborationImpl;
import com.topcoder.uml.model.commonbehavior.instances.Instance;
import com.topcoder.uml.model.commonbehavior.instances.ObjectImpl;
import com.topcoder.uml.model.core.Attribute;
import com.topcoder.uml.model.core.AttributeImpl;
import com.topcoder.uml.model.core.Method;
import com.topcoder.uml.model.core.MethodImpl;
import com.topcoder.uml.model.core.auxiliaryelements.Comment;
import com.topcoder.uml.model.core.auxiliaryelements.CommentImpl;
import com.topcoder.uml.model.core.classifiers.Class;
import com.topcoder.uml.model.core.classifiers.ClassImpl;
import com.topcoder.uml.model.core.classifiers.Interface;
import com.topcoder.uml.model.core.classifiers.InterfaceImpl;
import com.topcoder.uml.model.modelmanagement.Model;
import com.topcoder.uml.model.modelmanagement.Package;
import com.topcoder.uml.model.modelmanagement.PackageImpl;
import com.topcoder.uml.model.statemachines.Guard;
import com.topcoder.uml.model.statemachines.GuardImpl;
import com.topcoder.uml.model.statemachines.Transition;
import com.topcoder.uml.model.statemachines.TransitionImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.uml.projectconfiguration.ProjectConfigurationManager;
import com.topcoder.util.config.ConfigManager;
import com.topcoder.util.config.UnknownNamespaceException;

/**
 * <p>
 * A helper class to perform those common operations which are helpful for the test.
 * </p>
 *
 * @author yinzi
 * @version 1.0
 */
public class StressTestHelper {
    /**
     * <p>
     * The namespace used for the class.
     * </p>
     */
    public static final String NAMESPACE = "com.topcoder.gui.trees.document.impl";

    /**
     * <p>
     * The sample configuration file for this component.
     * </p>
     */
    public static final String CONFIG_FILE = "test_files/stresstests" + File.separator + "config.xml";

    /**
     * <p>
     * This private constructor prevents to create a new instance.
     * </p>
     */
    private StressTestHelper() {
        // empty
    }

    /**
     * <p>
     * Loads all the normal configuration files for this component.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public static void loadConfigurations() throws Exception {
        StressTestHelper.loadXMLConfig(StressTestHelper.CONFIG_FILE);
        StressTestHelper.loadXMLConfig("test_files/stresstests" + File.separator + "invalid_config.xml");
        StressTestHelper.loadXMLConfig("test_files/stresstests" + File.separator + "uml_model.xml");
        StressTestHelper.loadXMLConfig("test_files/stresstests" + File.separator + "sampleJavaFile.xml");
    }

    /**
     * <p>
     * Uses the given file to config the configuration manager.
     * </p>
     *
     * @param fileName config file to set up environment
     *
     * @throws Exception when any exception occurs
     */
    public static void loadXMLConfig(String fileName) throws Exception {
        //set up environment
        ConfigManager config = ConfigManager.getInstance();
        File file = new File(fileName);

        config.add(file.getCanonicalPath());
    }

    /**
     * <p>
     * Clears all the namespaces from the configuration manager.
     * </p>
     *
     * @throws UnknownNamespaceException to JUnit.
     */
    public static void clearConfig() throws UnknownNamespaceException {
        ConfigManager cm = ConfigManager.getInstance();

        for (Iterator i = cm.getAllNamespaces(); i.hasNext();) {
            cm.removeNamespace((String) i.next());
        }
    }

    /**
     * <p>
     * This method creates a <code>UMLModelManager</code> instance for testing purpose.
     * </p>
     *
     * @return the <code>UMLModelManager</code> instance for testing purpose.
     *
     * @throws Exception to JUnit
     */
    public static UMLModelManager createUMLModelManager() throws Exception {
        UMLModelManager manager = new UMLModelManager();

        Model root = manager.getModel();
        root.setName("ModelDemo");

        addClassViewData(root);

        addPackageViewData(manager, root);

        addDiagramViewData(manager);

        ProjectConfigurationManager configManager = new ProjectConfigurationManager(manager);

        configManager.addInitialDiagramFormatter("Java", new MockInitialDiagramElementFormatter());
        configManager.addInitialElementFormatter("Java", new MockInitialElementFormatter());

        manager.setProjectConfigurationManager(configManager);
        manager.setProjectLanguage("Java");
        return manager;
    }

    /**
     * <p>
     * This method loads some sample data to the model manager for the diagram class view class.
     * </p>
     *
     * @param manager the <code>UMLModelManager</code> instance
     */
    private static void addDiagramViewData(UMLModelManager manager) {
        Diagram useCaseDiagram = new Diagram();
        useCaseDiagram.setName("TCUML UseCase Demo 1");
        useCaseDiagram.setSemanticModel(createSimpleSemanticModelElement("Use Case"));
        manager.addDiagram(useCaseDiagram);

        GraphNode node = new GraphNode();
        node.setSemanticModel(createUml1SemanticModelBridge("GraphNode Demo"));
        useCaseDiagram.addContained(node);

        GraphNode childNode = new GraphNode();
        childNode.setSemanticModel(createUml1SemanticModelBridge("Child GraphNode Demo"));
        node.addContained(childNode);

        Diagram classDiagram = new Diagram();
        classDiagram.setName("TCUML Class Demo 1");
        classDiagram.setSemanticModel(createSimpleSemanticModelElement("Class"));
        manager.addDiagram(classDiagram);

        GraphNode node1 = new GraphNode();
        node1.setSemanticModel(createUml1SemanticModelBridge("GraphNode Demo 1"));
        classDiagram.addContained(node1);

        GraphNode node2 = new GraphNode();
        node2.setSemanticModel(createUml1SemanticModelBridge("GraphNode Demo 2"));
        classDiagram.addContained(node2);
    }

    /**
     * <p>
     * This method creates a <code>SimpleSemanticModelElement</code> instance based on the given
     * element name.
     * </p>
     *
     * <p>
     * The model element associated with the Uml1SemanticModelBridge is always a <code>Class</code>,
     * it is only for testing purpose.
     * </p>
     *
     * @param name the model element name
     * @return the <code>SimpleSemanticModelElement</code> instance based on the given
     * element name.
     */
    public static Uml1SemanticModelBridge createUml1SemanticModelBridge(String name) {
        Uml1SemanticModelBridge bridge = new Uml1SemanticModelBridge();
        Class type = new ClassImpl();
        type.setName(name);
        bridge.setElement(type);

        return bridge;
    }

    /**
     * <p>
     * This method creates a <code>SimpleSemanticModelElement</code> instance based on the given
     * <code>typeInfo</code>.
     * </p>
     *
     * @param typeInfo the type information to set to the <code>SimpleSemanticModelElement</code>
     * instance
     * @return the <code>SimpleSemanticModelElement</code> instance based on the given
     * <code>typeInfo</code>.
     */
    private static SimpleSemanticModelElement createSimpleSemanticModelElement(String typeInfo) {
        SimpleSemanticModelElement t = new SimpleSemanticModelElement();
        /*
         * BugFix: UML-10104
         */
        // old code
//        t.setTypeinfo(typeInfo);
        t.setTypeInfo(typeInfo);

        return t;
    }

    /**
     * <p>
     * This method loads some sample data to the model manager for the package class view class.
     * </p>
     *
     * @param manager the <code>UMLModelManager</code> instance
     * @param root the root model of the model manager
     */
    private static void addPackageViewData(UMLModelManager manager, Model root) {
        ActivityGraph activityGraph = new ActivityGraphImpl();
        activityGraph.setName("ActivityGraphDemo1");
        Transition transition1 = new TransitionImpl();
        transition1.setName("TransactionDemo1");
        activityGraph.addTransition(transition1);
        Transition transition2 = new TransitionImpl();
        transition2.setName("TransactionDemo2");
        activityGraph.addTransition(transition2);
        Guard guard = new GuardImpl();
        guard.setName("GuardDemo");
        transition2.setGuard(guard);
        manager.addActivityGraph(activityGraph);

        Collaboration collaboration = new CollaborationImpl();
        collaboration.setName("CollaborationDemo1");
        root.addOwnedElement(collaboration);

        Comment comment = new CommentImpl();
        comment.setName("CommentDemo");
        collaboration.addComment(comment);

        CollaborationInstanceSet instanceSet = new CollaborationInstanceSetImpl();
        instanceSet.setName("CollaborationInstanceSetDemo");
        collaboration.addCollaborationInstanceSet(instanceSet);

        Instance instance = new ObjectImpl();
        instance.setName("ObjectDemo");
        instanceSet.addParticipatingInstance(instance);
    }

    /**
     * <p>
     * This method loads some sample data to the model manager for the class class view class.
     * </p>
     *
     * @param root the root model of the model manager
     */
    private static void addClassViewData(Model root) {
        Package customPackage = new PackageImpl();
        customPackage.setName("com.topcoder.tcuml");
        root.addOwnedElement(customPackage);

        Class classType = new ClassImpl();
        classType.setName("SimpleUMLClassDemo");
        customPackage.addOwnedElement(classType);

        Attribute attribute = new AttributeImpl();
        attribute.setName("name");
        classType.addFeature(attribute);

        Interface interfaceType = new InterfaceImpl();
        interfaceType.setName("SimpleUMLInterfaceDemo");
        customPackage.addOwnedElement(interfaceType);

        Method method = new MethodImpl();
        method.setName("setName");
        interfaceType.addFeature(method);
    }
}

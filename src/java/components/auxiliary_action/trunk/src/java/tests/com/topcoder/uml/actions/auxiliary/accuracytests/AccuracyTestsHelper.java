/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.auxiliary.accuracytests;

import java.lang.reflect.Field;
import java.util.Iterator;

import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.Polyline;
import com.topcoder.diagraminterchange.SimpleSemanticModelElement;
import com.topcoder.diagraminterchange.TextElement;
import com.topcoder.diagraminterchange.Uml1SemanticModelBridge;
import com.topcoder.uml.model.core.auxiliaryelements.CommentImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.uml.projectconfiguration.ProjectConfigurationManager;
import com.topcoder.uml.projectconfiguration.stereotypeloader.XMLStereotypeLoader;
import com.topcoder.uml.standardclassloader.ClassDataLoaderStrategy;
import com.topcoder.util.config.ConfigManager;

/**
 * Set of help functions.
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class AccuracyTestsHelper {

    /**
     * Storage for all configurations tests.
     */
    private static final String CONFIG_TESTS_FILE = "accuracytests/configurations.xml";

    /**
     * Empty construction.
     */
    private AccuracyTestsHelper() {
    }

    /**
     * Loading test configurations.
     * @throws Exception wrap all exceptions
     */
    public static void loadConfiguration() throws Exception {
        clearConfiguration();
        ConfigManager config = ConfigManager.getInstance();
        config.add(CONFIG_TESTS_FILE);
    }

    /**
     * Clearing all configurations.
     * @throws Exception wrap all exceptions
     */
    public static void clearConfiguration() throws Exception {
        ConfigManager config = ConfigManager.getInstance();
        Iterator<String> iter = config.getAllNamespaces();
        while (iter.hasNext()) {
            String namespace = iter.next();
            config.removeNamespace(namespace);
        }
    }

    /**
     * Getting the value of the object's field.
     * @param object provided object
     * @param fieldName the name of the field
     * @return the valued of the field
     * @throws Exception wraps all exceptions
     */
    public static Object getFieldValue(Object object, String fieldName) throws Exception {
        Field field = object.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        return field.get(object);
    }

    /**
     * Getting uml model manager.
     * @return model manager
     * @throws Exception wraps all exceptions
     */
    public static UMLModelManager getModelManager() throws Exception {
        UMLModelManager modelManager = UMLModelManager.getInstance();
        modelManager.setProjectConfigurationManager(new ProjectConfigurationManager(modelManager,
            new ClassDataLoaderStrategy(), new XMLStereotypeLoader("name"), "namespace"));
        modelManager.setProjectLanguage("Java");
        return modelManager;
    }

    /**
     * Getting free text graph node.
     * @return graph node
     */
    public static GraphNode getFreeTextGraphNode() {
        GraphNode freeTextGraphNode = new GraphNode();
        SimpleSemanticModelElement simpleSemanticModelElement = new SimpleSemanticModelElement();
        simpleSemanticModelElement.setTypeInfo("FreeText");
        freeTextGraphNode.setSemanticModel(simpleSemanticModelElement);
        freeTextGraphNode.addContained(new TextElement());
        freeTextGraphNode.setContainer(new GraphNode());
        return freeTextGraphNode;
    }

    /**
     * Getting free text graph node.
     * @return graph node
     */
    public static GraphEdge getPolylineGraphEdge() {
        GraphEdge polylineGraphEdge = new GraphEdge();
        polylineGraphEdge.addContained(new Polyline());
        polylineGraphEdge.setContainer(new GraphNode());
        return polylineGraphEdge;
    }

    /**
     * Getting comment relationship graph edge.
     * @return graph node
     */
    public static GraphNode getCommentGraphNode() {
        GraphNode graphNode = new GraphNode();
        Uml1SemanticModelBridge uml1SemanticModelBridge = new Uml1SemanticModelBridge();
        uml1SemanticModelBridge.setElement(new CommentImpl());
        graphNode.setSemanticModel(uml1SemanticModelBridge);
        graphNode.setContainer(new GraphNode());
        return graphNode;
    }

    /**
     * Getting comment relationship graph edge.
     * @return graph node
     */
    public static GraphEdge getCommentRelationshipGraphEdge() {
        GraphEdge graphEdge = new GraphEdge();
        SimpleSemanticModelElement simpleSemanticModelElement = new SimpleSemanticModelElement();
        simpleSemanticModelElement.setTypeInfo("CommentLink");
        graphEdge.setSemanticModel(simpleSemanticModelElement);
        graphEdge.setContainer(new GraphNode());
        return graphEdge;
    }
}
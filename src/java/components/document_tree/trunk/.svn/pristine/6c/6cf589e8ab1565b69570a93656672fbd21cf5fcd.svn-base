/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.trees.document.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.DiagramElement;
import com.topcoder.diagraminterchange.GraphElement;
import com.topcoder.diagraminterchange.SemanticModelBridge;
import com.topcoder.diagraminterchange.SimpleSemanticModelElement;
import com.topcoder.diagraminterchange.Uml1SemanticModelBridge;
import com.topcoder.gui.trees.document.AlphabeticDiagramComparator;
import com.topcoder.gui.trees.document.DocumentTreeConfigurationException;
import com.topcoder.gui.trees.document.DocumentTreeNode;
import com.topcoder.gui.trees.document.DocumentTreeNodeType;
import com.topcoder.gui.trees.document.DocumentTreeViewType;
import com.topcoder.gui.trees.document.Util;
import com.topcoder.uml.model.activitygraphs.ActivityGraph;
import com.topcoder.uml.model.collaborations.collaborationinstances.CollaborationInstanceSet;
import com.topcoder.uml.model.collaborations.collaborationinteractions.Collaboration;
import com.topcoder.uml.model.commonbehavior.instances.Instance;
import com.topcoder.uml.model.commonbehavior.instances.Object;
import com.topcoder.uml.model.commonbehavior.links.Link;
import com.topcoder.uml.model.core.Attribute;
import com.topcoder.uml.model.core.Classifier;
import com.topcoder.uml.model.core.Element;
import com.topcoder.uml.model.core.Feature;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.core.Operation;
import com.topcoder.uml.model.core.auxiliaryelements.Comment;
import com.topcoder.uml.model.core.classifiers.Class;
import com.topcoder.uml.model.core.classifiers.Interface;
import com.topcoder.uml.model.core.relationships.AssociationEnd;
import com.topcoder.uml.model.core.relationships.Relationship;
import com.topcoder.uml.model.modelmanagement.Model;
import com.topcoder.uml.model.modelmanagement.Package;
import com.topcoder.uml.model.statemachines.Guard;
import com.topcoder.uml.model.statemachines.StateVertex;
import com.topcoder.uml.model.statemachines.Transition;
import com.topcoder.uml.model.usecases.Actor;
import com.topcoder.uml.model.usecases.UseCase;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.uml.projectconfiguration.ProjectConfigurationManager;
import com.topcoder.util.config.ConfigManager;
import com.topcoder.util.config.Property;
import com.topcoder.util.config.UnknownNamespaceException;

/**
 * <p>
 * This is a helper class and it is package private and final.
 * </p>
 *
 * <p>
 * This class is mainly for reusing the code for the following classes:
 * <ul>
 * <li>ClassCentricDocumentTreeView</li>
 * <li>DiagramCentricDocumentTreeView</li>
 * <li>PackageCentricDocumentTreeView</li>
 * </ul>
 * </p>
 *
 * <p>
 * Thread Safety : This class is not thread safe because the state of the given <code>BaseDocumentTreeView</code>
 * instance is mutable.
 * </p>
 *
 * @author biotrail
 * @version 1.0
 */
final class DocumentTreeViewHelper {
    /**
     * <p>
     * This private constructor prevents to create a new instance.
     * </p>
     */
    private DocumentTreeViewHelper() {
        // empty
    }

    /**
     * <p>
     * This method creates the tree structure for the <code>ClassCentricDocumentTreeView</code> class.
     * </p>
     *
     * @param view
     *            the given document tree view instance
     * @param manager
     *            the <code>UMLModelManager</code> instance to provide the model
     *
     * @return the root tree node of the created tree structure
     */
    static DefaultMutableTreeNode createClassTree(BaseDocumentTreeView view, UMLModelManager manager) {
        Model root = manager.getModel();

        DefaultMutableTreeNode rootTreeNode = createMutableTreeNode(view, new DocumentTreeNode(root));

        // traverse all the model elements owned by the root model
        for (ModelElement modelElement : root.getOwnedElements()) {
            traverse(view, rootTreeNode, modelElement);
        }

        // loadStandardNamespaces(view, manager, rootTreeNode);

        return rootTreeNode;
    }

    /**
     * <p>
     * This method creates the tree structure for the <code>DiagramCentricDocumentTreeView</code> class.
     * </p>
     *
     * @param view
     *            the given document tree view instance
     * @param manager
     *            the <code>UMLModelManager</code> instance to provide the model
     * @param diagramCategoryNames
     *            the mapping from the typeInfo property of a diagram's semantic bridge to a category name.
     * @param showChild
     *            whether the child of the diagram should be shown or not
     * @return the root tree node of the created tree structure
     *
     * @throws IllegalStateException
     *             if any diagram owns a non-SimpleSemanticModelElement semantic model or the type information of
     *             the simple semantic model element is null
     */
    static DefaultMutableTreeNode createDiagramTree(BaseDocumentTreeView view, UMLModelManager manager,
        Map<String, String> diagramCategoryNames, boolean showChild) {
        Model root = manager.getModel();

        DefaultMutableTreeNode rootTreeNode = createMutableTreeNode(view, new DocumentTreeNode(root));

        // set up a mapping from the diagram category names to all its Diagram instances
        // Changed to Tree Map to have the category in lexicographical order.
        Map<String, List<Diagram>> diagrams = new TreeMap<String, List<Diagram>>();
        for (String value : diagramCategoryNames.values()) {
            diagrams.put(value, new ArrayList<Diagram>());
        }
        for (Diagram diagram : manager.getDiagrams()) {
            SemanticModelBridge bridge = diagram.getSemanticModel();
            if (bridge instanceof SimpleSemanticModelElement) {
                String typeInfo = ((SimpleSemanticModelElement) bridge).getTypeInfo();
                if (typeInfo == null) {
                    throw new IllegalStateException(
                        "The type information of the simple semantic model element is null.");
                }

                String categoryName = diagramCategoryNames.get(typeInfo);

                if (categoryName != null) {
                    List<Diagram> diagramsForCategory = diagrams.get(categoryName);
                    diagramsForCategory.add(diagram);
                }
            } else {
                throw new IllegalStateException("The semantic model for the diagram is not a "
                    + "SimpleSemanticModelElement instance.");
            }
        }

        // searches all the diagram category names and set up the tree structure
        for (Entry<String, List<Diagram>> entry : diagrams.entrySet()) {
            DefaultMutableTreeNode categoryMutableTreeNode =
                createChildMutableTreeNode(view, rootTreeNode, new DocumentTreeNode(entry.getKey()));

            /*
             * BugFix: BUGR-65 Sorting diagrams
             */
            Collections.sort(entry.getValue(), new AlphabeticDiagramComparator());
            for (Diagram diagram : entry.getValue()) {
                DefaultMutableTreeNode diagramMutableTreeNode =
                    createChildMutableTreeNode(view, categoryMutableTreeNode, new DocumentTreeNode(diagram));
                if (showChild) {
                    traverse(view, diagramMutableTreeNode, diagram);
                }
            }
        }

        return rootTreeNode;
    }

    /**
     * <p>
     * This method creates the tree structure for the <code>PackageCentricDocumentTreeView</code> class.
     * </p>
     *
     * @param view
     *            the given document tree view instance
     * @param manager
     *            the <code>UMLModelManager</code> instance to provide the model
     * @param activityGraphsCategoryName
     *            the name of the category under which activity graphs are stored in the tree.
     * @param collaborationsCategoryName
     *            the name of the category under which collaborations are stored in the tree.
     *
     * @return the root tree node of the created tree structure
     */
    static DefaultMutableTreeNode createPackageTree(BaseDocumentTreeView view, UMLModelManager manager,
        String activityGraphsCategoryName, String collaborationsCategoryName) {
        Model root = manager.getModel();

        DefaultMutableTreeNode rootTreeNode = createClassTree(view, manager);

        DefaultMutableTreeNode activityGraphsCategoryNode =
            createChildMutableTreeNode(view, rootTreeNode, new DocumentTreeNode(activityGraphsCategoryName));
        // traverse all the ActivityGraph instances owned
        for (ActivityGraph activityGraph : manager.getActivityGraphs()) {
            DefaultMutableTreeNode activityTreeNode =
                createChildMutableTreeNode(view, activityGraphsCategoryNode, new DocumentTreeNode(activityGraph));

            // creates nodes for the Transition instances owned
            for (Transition transaction : activityGraph.getTransitions()) {
                DefaultMutableTreeNode transactionTreeNode =
                    createChildMutableTreeNode(view, activityTreeNode, new DocumentTreeNode(transaction));

                // creates a node for Guard instance if present
                Guard guard = transaction.getGuard();
                if (guard != null) {
                    createChildMutableTreeNode(view, transactionTreeNode, new DocumentTreeNode(guard));
                }
            }
        }

        DefaultMutableTreeNode collaborationsCategoryNode =
            createChildMutableTreeNode(view, rootTreeNode, new DocumentTreeNode(collaborationsCategoryName));
        // traverse all the Collaboration instances owned
        for (ModelElement modelElement : root.getOwnedElements()) {
            if (modelElement instanceof Collaboration) {
                Collaboration collaboration = (Collaboration) modelElement;
                DefaultMutableTreeNode collaborationTreeNode =
                    createChildMutableTreeNode(view, collaborationsCategoryNode, new DocumentTreeNode(
                        collaboration));

                // add all the owned comments
                for (Comment comment : collaboration.getComments()) {
                    createChildMutableTreeNode(view, collaborationTreeNode, new DocumentTreeNode(comment));
                }

                // add all the instances
                for (CollaborationInstanceSet set : collaboration.getCollaborationInstanceSets()) {
                    for (Instance instance : set.getParticipatingInstances()) {
                        createChildMutableTreeNode(view, collaborationTreeNode, new DocumentTreeNode(instance));
                    }
                }
            }
        }

        return rootTreeNode;
    }

    /**
     * <p>
     * This method is used to add a <code>DocumentTreeNode</code> to the tree structure of the given document tree
     * view.
     * </p>
     *
     * <p>
     * Note, this method is reused by all the tree views.
     * </p>
     *
     * @param view
     *            the given document tree view
     * @param treeNode
     *            the tree node to add
     *
     * @throws IllegalArgumentException
     *             if the tree node is null
     */
    static void addTreeNode(BaseDocumentTreeView view, DocumentTreeNode treeNode) {
        Util.checkNull(treeNode, "treeNode");

        // the node does exist in the tree
        DefaultMutableTreeNode mutableTreeNode = view.documentNodeToTreeNodeMap.get(treeNode);
        if (mutableTreeNode != null) {
            return;
        }

        DefaultTreeModel treeModel = (DefaultTreeModel) view.tree.getModel();
        DefaultMutableTreeNode rootMutableTreeNode = (DefaultMutableTreeNode) treeModel.getRoot();
        DefaultMutableTreeNode parent = null;

        if (DocumentTreeViewType.CLASS_CENTRIC.equals(view.getViewType())
            || DocumentTreeViewType.PACKAGE_CENTRIC.equals(view.getViewType())) {
            if (DocumentTreeNodeType.MODEL_ELEMENT.equals(treeNode.getType())) {
                // search the parent node for the model element
                parent =
                    searchParentNodeForModelElement(view, rootMutableTreeNode, (ModelElement) treeNode
                        .getNodeObject());
            }
        } else if (DocumentTreeViewType.DIAGRAM_CENTRIC.equals(view.getViewType())) {
            if (DocumentTreeNodeType.GRAPH_ELEMENT.equals(treeNode.getType())) {
                // search the parent node for the graph element
                parent =
                    searchParentNodeForGraphElement(view, rootMutableTreeNode, (GraphElement) treeNode
                        .getNodeObject());
            }
        }

        // the parent is presents in the tree, then add it under the parent node
        if (parent != null) {
            DefaultMutableTreeNode child = new DefaultMutableTreeNode();
            child.setUserObject(treeNode);
            parent.add(child);

            addMapping(view, treeNode, child);
        }
    }

    /**
     * <p>
     * This method is used to update a <code>DocumentTreeNode</code> in the tree structure of the given document
     * tree view.
     * </p>
     *
     * <p>
     * When a node is updated, there are two possibilities. One is that its name has changed, another is that its
     * parent namespace has changed.
     * </p>
     *
     * <p>
     * Note, this method is reused by all the tree views.
     * </p>
     *
     * @param view
     *            the given document tree view
     * @param treeNode
     *            the tree node to update
     *
     * @throws IllegalArgumentException
     *             If treeNode is null or does not exist in the tree.
     */
    static void updateTreeNode(BaseDocumentTreeView view, DocumentTreeNode treeNode) {
        Util.checkNull(treeNode, "treeNode");
        DefaultMutableTreeNode mutableTreeNode = view.documentNodeToTreeNodeMap.get(treeNode);
        if (mutableTreeNode == null) {
            throw new IllegalArgumentException("The given treeNode does not exist in the tree.");
        }

        DefaultTreeModel treeModel = (DefaultTreeModel) view.tree.getModel();
        DefaultMutableTreeNode rootMutableTreeNode = (DefaultMutableTreeNode) treeModel.getRoot();

        DefaultMutableTreeNode parent = (DefaultMutableTreeNode) mutableTreeNode.getParent();

        // we assume the new parent is the same old parent
        DefaultMutableTreeNode newParent = parent;

        if (view.getViewType().equals(DocumentTreeViewType.CLASS_CENTRIC)
            || view.getViewType().equals(DocumentTreeViewType.PACKAGE_CENTRIC)) {

            if (treeNode.getType().equals(DocumentTreeNodeType.MODEL_ELEMENT)) {

                // search the new parent node in the tree
                newParent =
                    searchParentNodeForModelElement(view, rootMutableTreeNode, (ModelElement) treeNode
                        .getNodeObject());
            }
        }

        if (view.getViewType().equals(DocumentTreeViewType.DIAGRAM_CENTRIC)) {
            if (treeNode.getType().equals(DocumentTreeNodeType.GRAPH_ELEMENT)) {

                // search the new parent node in the tree
                newParent =
                    searchParentNodeForGraphElement(view, rootMutableTreeNode, (GraphElement) treeNode
                        .getNodeObject());

            }
        }

        // if the two parent node is not the same, then update it, otherwise it should be caused by
        // the name of the node is changed
        if (parent != newParent) {
            if (newParent != null) {
                // The namespace has been changed
                treeModel.removeNodeFromParent(mutableTreeNode);
                treeModel.insertNodeInto(mutableTreeNode, newParent, 0);
            }
        } else {
            // The name of the node is changed
            // Using the reload instead of the node change.
            // treeModel.nodeChanged(mutableTreeNode);
            treeModel.reload(mutableTreeNode);
        }
    }

    /**
     * <p>
     * This method is used to remove a <code>DocumentTreeNode</code> from the tree structure of the given document
     * tree view.
     * </p>
     *
     * <p>
     * Note, this method is reused by all the tree views.
     * </p>
     *
     * @param view
     *            the given document tree view
     * @param treeNode
     *            the tree node to update
     *
     * @throws IllegalArgumentException
     *             If treeNode is null or does not exist in the tree.
     */
    static void removeTreeNode(BaseDocumentTreeView view, DocumentTreeNode treeNode) {
        Util.checkNull(treeNode, "treeNode");
        DefaultMutableTreeNode mutableTreenode = view.documentNodeToTreeNodeMap.get(treeNode);
        if (mutableTreenode == null) {
            throw new IllegalArgumentException("The given treeNode does not exist in the tree.");
        }

        DefaultTreeModel treeModel = (DefaultTreeModel) view.tree.getModel();
        treeModel.removeNodeFromParent(mutableTreenode);
        view.documentNodeToTreeNodeMap.remove(treeNode);
        view.treeNodeToDocumentNodeMap.remove(mutableTreenode);
    }

    /**
     * <p>
     * Returns the value of the property.
     * </p>
     *
     * <p>
     * If the property is missing, then exception will be thrown.
     * </p>
     *
     * @param namespace
     *            the namespace to get the property value from.
     * @param propertyName
     *            the name of property
     *
     * @return the value of the property
     *
     * @throws DocumentTreeConfigurationException
     *             if fails to load the config values.
     */
    static String getPropertyValue(String namespace, String propertyName) {
        try {
            String property = ConfigManager.getInstance().getString(namespace, propertyName);

            // Property is missing
            if (property == null) {
                throw new DocumentTreeConfigurationException("The property for [" + propertyName
                    + "] is missing but it is required.");
            }

            // Empty property value is not allowed
            if ((property.trim().length() == 0)) {
                throw new DocumentTreeConfigurationException("Property " + propertyName + " is empty.");
            }

            return property;
        } catch (UnknownNamespaceException e) {
            throw new DocumentTreeConfigurationException("UnknownNamespaceException occurs "
                + "when accessing ConfigManager.", e);
        }
    }

    /**
     * <p>
     * Gets the <code>Property</code> instance that represents the given property name in the config manager.
     * </p>
     *
     * @param namespace
     *            the namespace to get the property value from.
     * @param name
     *            the name of property
     *
     * @return the <code>Property</code> instance that represents the given property name in the config manager.
     *
     * @throws DocumentTreeConfigurationException
     *             if the property is missing or the namespace is unknown.
     */
    static Property getRequiredProperty(String namespace, String name) {
        ConfigManager cm = ConfigManager.getInstance();

        try {
            Property property = cm.getPropertyObject(namespace, name);

            if (property == null) {
                throw new DocumentTreeConfigurationException("The " + name + " property is missing.");
            }

            return property;
        } catch (UnknownNamespaceException e) {
            throw new DocumentTreeConfigurationException("UnknownNamespaceException occurs "
                + "when accessing ConfigManager.", e);
        }
    }

    /**
     * <p>
     * This method searches the parent node in the tree structure of <code>BaseDocumentTreeView</code> instance for
     * the given <code>ModelElement</code> instance.
     * </p>
     *
     * <p>
     * Note, if the parent node can not be found, then null will be returned.
     * </p>
     *
     * @param view
     *            the given document tree view
     * @param mutableTreeNode
     *            the current tree node to search
     * @param element
     *            the model element instance to search its parent node
     *
     * @return the parent tree node of the given model element
     */
    private static DefaultMutableTreeNode searchParentNodeForModelElement(BaseDocumentTreeView view,
        DefaultMutableTreeNode mutableTreeNode, ModelElement element) {
        DocumentTreeNode curNode = view.treeNodeToDocumentNodeMap.get(mutableTreeNode);

        // only search model element node
        if (curNode.getType().equals(DocumentTreeNodeType.MODEL_ELEMENT)) {
            ModelElement curElement = (ModelElement) curNode.getNodeObject();

            // search Namespace node
            if (curElement instanceof Namespace) {
                Namespace curNamespace = (Namespace) curElement;
                if (curNamespace.containsOwnedElement(element)) {
                    return mutableTreeNode;
                }
            }

            // search Classifier node
            if (curElement instanceof Classifier) {
                Classifier classifier = (Classifier) curElement;

                // If it is an AssociationEnd instance
                if (element instanceof AssociationEnd) {
                    if (classifier.containsAssociation((AssociationEnd) element)) {
                        return mutableTreeNode;
                    }
                }

                // If it is a Feature instance
                if (element instanceof Feature) {
                    if (classifier.containsFeature((Feature) element)) {
                        return mutableTreeNode;
                    }
                }
            }

            // for package view only
            if (view.getViewType().equals(DocumentTreeViewType.PACKAGE_CENTRIC)) {
                if (curElement instanceof ActivityGraph && element instanceof Transition) {

                    // search the ActivityGraph instance
                    ActivityGraph activeGraph = (ActivityGraph) curElement;
                    Transition transition = (Transition) element;
                    if (activeGraph.containsTransition(transition)) {
                        return mutableTreeNode;
                    }
                }

                if (curElement instanceof Transition && element instanceof Guard) {
                    // search the Transition instance
                    Transition transition = (Transition) curElement;
                    Guard guard = (Guard) element;
                    if (transition.getGuard() == guard) {
                        return mutableTreeNode;
                    }
                }

                if (curElement instanceof Collaboration) {
                    Collaboration collaboration = (Collaboration) curElement;

                    // search all the comments contained
                    if (element instanceof Comment) {
                        if (collaboration.containsComment((Comment) element)) {
                            return mutableTreeNode;
                        }
                    }

                    // search all the instances contained
                    if (element instanceof Instance) {
                        for (CollaborationInstanceSet set : collaboration.getCollaborationInstanceSets()) {
                            if (set.containsParticipatingInstance((Instance) element)) {
                                return mutableTreeNode;
                            }
                        }
                    }
                }
            }
        }

        // search all the child nodes of the parent node recursively if not found
        for (int i = 0; i < mutableTreeNode.getChildCount(); i++) {
            DefaultMutableTreeNode childMutableTreeNode = (DefaultMutableTreeNode) mutableTreeNode.getChildAt(i);

            DefaultMutableTreeNode parent = searchParentNodeForModelElement(view, childMutableTreeNode, element);

            // if not found, search the next child node
            if (parent != null) {
                return parent;
            }
        }

        // no parent node present
        return null;
    }

    /**
     * <p>
     * This method searches the parent node in the tree structure of <code>BaseDocumentTreeView</code> instance for
     * the given <code>GraphElement</code> instance.
     * </p>
     *
     * <p>
     * Note, if the parent node can not be found, then null will be returned.
     * </p>
     *
     * @param view
     *            the given document tree view
     * @param mutableTreeNode
     *            the current tree node to search
     * @param element
     *            the graph element instance to search its parent node
     *
     * @return the parent tree node of the given graph element
     */
    private static DefaultMutableTreeNode searchParentNodeForGraphElement(BaseDocumentTreeView view,
        DefaultMutableTreeNode mutableTreeNode, GraphElement element) {
        DocumentTreeNode curNode = view.treeNodeToDocumentNodeMap.get(mutableTreeNode);

        // we only search GRAPH_ELEMENT node
        if (curNode.getType().equals(DocumentTreeNodeType.GRAPH_ELEMENT)) {
            GraphElement curElement = (GraphElement) curNode.getNodeObject();

            // check whether it is contained
            if (curElement.containsContained(element)) {
                return mutableTreeNode;
            }
        }

        // search all the child nodes of the parent node recursively if not found
        for (int i = 0; i < mutableTreeNode.getChildCount(); i++) {
            DefaultMutableTreeNode childMutableTreeNode = (DefaultMutableTreeNode) mutableTreeNode.getChildAt(i);

            DefaultMutableTreeNode parent = searchParentNodeForGraphElement(view, childMutableTreeNode, element);

            // if not found, search the next child node
            if (parent != null) {
                return parent;
            }
        }

        // no parent node present
        return null;
    }

    /**
     * <p>
     * This method loads all the standard namespaces from the project configuration manager and add them to the
     * tree structure of the given document tree view.
     * </p>
     *
     * @param view
     *            the given document tree view
     * @param manager
     *            the <code>UMLModelManager</code> instance to get the associated
     *            <code>ProjectConfigurationManager</code> instance
     * @param treeNode
     *            the root tree node of the given document tree view
     *
     */
    private static void loadStandardNamespaces(BaseDocumentTreeView view, UMLModelManager manager,
        DefaultMutableTreeNode treeNode) {
        ProjectConfigurationManager configManager = manager.getProjectConfigurationManager();

        String language = manager.getProjectLanguage();

        if (language != null && language.trim().length() != 0) {
            for (Namespace namespace : configManager.getStandardNamespaces(language)) {
                traverse(view, treeNode, namespace);
            }
        }
    }

    /**
     * <p>
     * This method searches the given model element recursively.
     * </p>
     *
     * <p>
     * If the given model element is suitable, then it will be added to the tree structure and the model elements
     * contained in it will be searched recursively.
     * </p>
     *
     * @param view
     *            the given document tree view
     * @param treeNode
     *            the current tree node to traverse
     * @param element
     *            the model element instance to search
     */
    private static void traverse(BaseDocumentTreeView view, DefaultMutableTreeNode treeNode, ModelElement element) {
        DefaultMutableTreeNode childTreeNode = null;

        // we only adds tree node for Namespace, Classifier, AssociationEnd, Operation, Attribute types
        if (element instanceof Namespace || element instanceof Classifier || element instanceof AssociationEnd
            || element instanceof Operation || element instanceof Attribute) {
            childTreeNode = createChildMutableTreeNode(view, treeNode, new DocumentTreeNode(element));
        }

        // If it is a Namespace element, traverses all its owned elements
        if (element instanceof Namespace) {
            for (ModelElement owned : ((Namespace) element).getOwnedElements()) {
                traverse(view, childTreeNode, owned);
            }
        }

        // If it is a Classifier, traverses all its owned AssociationEnd and Feature elements
        if (element instanceof Classifier) {
            Classifier classifier = (Classifier) element;

            // traverses the AssociationEnd instances owned
            for (AssociationEnd end : classifier.getAssociations()) {
                traverse(view, childTreeNode, end);
            }

            // traverses the Feature instances owned
            for (Feature feature : classifier.getFeatures()) {
                traverse(view, childTreeNode, feature);
            }
        }
    }

    /**
     * <p>
     * This method caches the mapping between <code>DocumentTreeNode</code> and <code>DefaultMutableTreeNode</code>
     * instances to the given document tree view.
     * </p>
     *
     * @param view
     *            the given document tree view
     * @param node
     *            the <code>DocumentTreeNode</code> instance
     * @param treeNode
     *            the <code>DefaultMutableTreeNode</code> instance
     */
    private static void addMapping(BaseDocumentTreeView view, DocumentTreeNode node,
        DefaultMutableTreeNode treeNode) {
        view.documentNodeToTreeNodeMap.put(node, treeNode);
        view.treeNodeToDocumentNodeMap.put(treeNode, node);
    }

    /**
     * <p>
     * This method searches the given graph element recursively.
     * </p>
     *
     * <p>
     * If the given graph element is suitable, then it will be added to the tree structure and the graph elements
     * contained in it will be searched recursively.
     * </p>
     *
     * @param view
     *            the given document tree view
     * @param treeNode
     *            the current tree node to traverse
     * @param element
     *            the graph element instance to search
     */
    private static void traverse(BaseDocumentTreeView view, DefaultMutableTreeNode treeNode, GraphElement element) {
        SemanticModelBridge bridge = element.getSemanticModel();
        if (bridge instanceof Uml1SemanticModelBridge) {
            Element associatedElement = ((Uml1SemanticModelBridge) bridge).getElement();

            // we add tree nodes for graph elements that owns Package, Class, Interface, Relationship,
            // UseCase, Object, StateVertex, Actor, Comment, Transition or Link model element
            if (associatedElement instanceof Package || associatedElement instanceof Class
                || associatedElement instanceof Interface || associatedElement instanceof Relationship
                || associatedElement instanceof UseCase || associatedElement instanceof Object
                || associatedElement instanceof StateVertex || associatedElement instanceof Actor
                || associatedElement instanceof Comment || associatedElement instanceof Transition
                || associatedElement instanceof Link) {
                createChildMutableTreeNode(view, treeNode, new DocumentTreeNode(element));
            }
        }

        for (DiagramElement diagramElement : element.getContaineds()) {
            // traverses all the contained GraphElement instances
            if (diagramElement instanceof GraphElement) {
                traverse(view, treeNode, (GraphElement) diagramElement);
            }
        }
    }

    /**
     * <p>
     * This method creates a <code>DefaultMutableTreeNode</code> instance based on the given
     * <code>DocumentTreeNode</code> instance.
     * </p>
     *
     * @param view
     *            the given document tree view
     * @param childNode
     *            the <code>DocumentTreeNode</code> instance to creates its associated
     *            <code>DefaultMutableTreeNode</code> instance
     *
     * @return the created <code>DefaultMutableTreeNode</code> instance based on the given
     *         <code>DocumentTreeNode</code> instance.
     */
    private static DefaultMutableTreeNode createMutableTreeNode(BaseDocumentTreeView view,
        DocumentTreeNode childNode) {
        DefaultMutableTreeNode childTreeNode = new DefaultMutableTreeNode();
        childTreeNode.setUserObject(childNode);

        // cache the relationship
        addMapping(view, childNode, childTreeNode);

        return childTreeNode;
    }

    /**
     * <p>
     * This method creates a <code>DefaultMutableTreeNode</code> instance based on the given
     * <code>DocumentTreeNode</code> instance and sets up the parent-child relationship.
     * </p>
     *
     * @param view
     *            the given document tree view
     * @param parent
     *            the parent tree node
     * @param childNode
     *            the child node value
     *
     * @return the created <code>DefaultMutableTreeNode</code> instance based on the given
     *         <code>DocumentTreeNode</code> instance.
     */
    private static DefaultMutableTreeNode createChildMutableTreeNode(BaseDocumentTreeView view,
        DefaultMutableTreeNode parent, DocumentTreeNode childNode) {
        DefaultMutableTreeNode childTreeNode = createMutableTreeNode(view, childNode);

        // the bi-relationship is set up in this method
        parent.add(childTreeNode);

        return childTreeNode;
    }
}

/*
 * Copyright (C) 2013 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.FocusEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.Map.Entry;

import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTree;
import javax.swing.JViewport;
import javax.swing.TransferHandler;
import javax.swing.filechooser.FileFilter;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.DiagramElement;
import com.topcoder.diagraminterchange.GraphConnector;
import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.GraphElement;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.Polyline;
import com.topcoder.diagraminterchange.Property;
import com.topcoder.diagraminterchange.SemanticModelBridge;
import com.topcoder.diagraminterchange.SimpleSemanticModelElement;
import com.topcoder.diagraminterchange.TextElement;
import com.topcoder.diagraminterchange.Uml1SemanticModelBridge;
import com.topcoder.gui.diagramviewer.DiagramView;
import com.topcoder.gui.diagramviewer.DiagramViewer;
import com.topcoder.gui.diagramviewer.edges.Connector;
import com.topcoder.gui.diagramviewer.edges.Edge;
import com.topcoder.gui.diagramviewer.edges.TextField;
import com.topcoder.gui.diagramviewer.elements.Node;
import com.topcoder.gui.diagramviewer.elements.NodeContainer;
import com.topcoder.gui.diagramviewer.elements.SelectionCorner;
import com.topcoder.gui.diagramviewer.elements.SelectionCornerType;
import com.topcoder.gui.diagramviewer.uml.activityelements.AcceptEventAction;
import com.topcoder.gui.diagramviewer.uml.activityelements.ActionState;
import com.topcoder.gui.diagramviewer.uml.activityelements.DecisionNode;
import com.topcoder.gui.diagramviewer.uml.activityelements.FinalNode;
import com.topcoder.gui.diagramviewer.uml.activityelements.FlowFinalNode;
import com.topcoder.gui.diagramviewer.uml.activityelements.ForkNode;
import com.topcoder.gui.diagramviewer.uml.activityelements.IllegalGraphElementException;
import com.topcoder.gui.diagramviewer.uml.activityelements.InitialNode;
import com.topcoder.gui.diagramviewer.uml.activityelements.JoinNode;
import com.topcoder.gui.diagramviewer.uml.activityelements.MergeNode;
import com.topcoder.gui.diagramviewer.uml.activityelements.ObjectFlowNode;
import com.topcoder.gui.diagramviewer.uml.activityelements.SendSignalAction;
import com.topcoder.gui.diagramviewer.uml.activityelements.Transition;
import com.topcoder.gui.diagramviewer.uml.auxiliaryelements.CommentLinkEdge;
import com.topcoder.gui.diagramviewer.uml.auxiliaryelements.CommentNode;
import com.topcoder.gui.diagramviewer.uml.auxiliaryelements.FreeTextNode;
import com.topcoder.gui.diagramviewer.uml.auxiliaryelements.PolylineNode;
import com.topcoder.gui.diagramviewer.uml.auxiliaryelements.PropertyMapping;
import com.topcoder.gui.diagramviewer.uml.classedges.AbstractionEdge;
import com.topcoder.gui.diagramviewer.uml.classedges.AssociationEdge;
import com.topcoder.gui.diagramviewer.uml.classedges.DependencyEdge;
import com.topcoder.gui.diagramviewer.uml.classedges.GeneralizationEdge;
import com.topcoder.gui.diagramviewer.uml.classelements.ClassNode;
import com.topcoder.gui.diagramviewer.uml.classelements.EnumClassNode;
import com.topcoder.gui.diagramviewer.uml.classelements.ExceptionNode;
import com.topcoder.gui.diagramviewer.uml.classelements.GroupTextField;
import com.topcoder.gui.diagramviewer.uml.classelements.InterfaceNode;
import com.topcoder.gui.diagramviewer.uml.classelements.PackageNode;
import com.topcoder.gui.diagramviewer.uml.classelements.StereotypeTextField;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.AsynchronousMessageEdge;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.CreateMessageEdge;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.EdgeLayoutException;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.ObjectNode;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.ObjectNodeConnector;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.ObjectNodePropertyType;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.ReturnMessageEdge;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.SendSignalMessageEdge;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.SequenceEdge;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.SequenceEdgePropertyType;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.SynchronousMessageEdge;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.edgeendings.ConfiguredEdgeEndingPropertyType;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.edgelayout.DefaultEdgeLayoutStrategy;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.lifeline.Lifeline;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.lifeline.LifelinePropertyType;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.lifeline.LifelineSegment;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.ActorNode;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.BaseEdge;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.BaseNode;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.ExtendEdge;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.IncludeEdge;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.SubsystemNodeContainer;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.UseCaseNode;
import com.topcoder.gui.panels.documentation.plugins.DefaultDocumentationEditor;
import com.topcoder.gui.panels.style.StyleObject;
import com.topcoder.gui.panels.style.styleobject.GraphEdgeStyleObjectAdapter;
import com.topcoder.gui.panels.style.styleobject.GraphNodeStyleObjectAdapter;
import com.topcoder.gui.panels.style.styleobject.PolylineStyleObjectAdapter;
import com.topcoder.gui.panels.zoom.ZoomPane;
import com.topcoder.gui.panels.zoom.ZoomPanel;
import com.topcoder.gui.trees.document.DocumentTreeNode;
import com.topcoder.gui.trees.document.DocumentTreeNodeType;
import com.topcoder.gui.trees.document.DocumentTreeTabbedPane;
import com.topcoder.gui.trees.document.DocumentTreeView;
import com.topcoder.gui.trees.document.impl.DiagramCentricDocumentTreeView;
import com.topcoder.swing.imageexporter.ImageExporter;
import com.topcoder.swing.imageexporter.ImageExporterConfigurationException;
import com.topcoder.uml.actions.general.ChangeZOrderAction;
import com.topcoder.uml.actions.general.operationtypes.ChangeZOrderOperationType;
import com.topcoder.uml.actions.project.ExportDiagramToImageAction;
import com.topcoder.uml.model.actions.Action;
import com.topcoder.uml.model.actions.messagingactions.CallOperationAction;
import com.topcoder.uml.model.actions.objectactions.CreateObjectAction;
import com.topcoder.uml.model.collaborations.collaborationinteractions.Collaboration;
import com.topcoder.uml.model.collaborations.collaborationroles.Message;
import com.topcoder.uml.model.commonbehavior.instances.ObjectImpl;
import com.topcoder.uml.model.commonbehavior.instances.Stimulus;
import com.topcoder.uml.model.commonbehavior.links.Link;
import com.topcoder.uml.model.commonbehavior.procedure.Procedure;
import com.topcoder.uml.model.core.Attribute;
import com.topcoder.uml.model.core.AttributeImpl;
import com.topcoder.uml.model.core.Classifier;
import com.topcoder.uml.model.core.Element;
import com.topcoder.uml.model.core.Feature;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.core.Operation;
import com.topcoder.uml.model.core.OperationImpl;
import com.topcoder.uml.model.core.Parameter;
import com.topcoder.uml.model.core.ParameterImpl;
import com.topcoder.uml.model.core.StructuralFeatureAbstractImpl;
import com.topcoder.uml.model.core.auxiliaryelements.Comment;
import com.topcoder.uml.model.core.classifiers.Class;
import com.topcoder.uml.model.core.classifiers.ClassImpl;
import com.topcoder.uml.model.core.classifiers.Enumeration;
import com.topcoder.uml.model.core.classifiers.EnumerationImpl;
import com.topcoder.uml.model.core.classifiers.EnumerationLiteral;
import com.topcoder.uml.model.core.classifiers.EnumerationLiteralImpl;
import com.topcoder.uml.model.core.classifiers.Interface;
import com.topcoder.uml.model.core.dependencies.Abstraction;
import com.topcoder.uml.model.core.dependencies.Dependency;
import com.topcoder.uml.model.core.extensionmechanisms.Stereotype;
import com.topcoder.uml.model.core.extensionmechanisms.StereotypeImpl;
import com.topcoder.uml.model.core.extensionmechanisms.TagDefinition;
import com.topcoder.uml.model.core.extensionmechanisms.TagDefinitionImpl;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValue;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValueImpl;
import com.topcoder.uml.model.core.relationships.Association;
import com.topcoder.uml.model.core.relationships.AssociationEnd;
import com.topcoder.uml.model.core.relationships.Generalization;
import com.topcoder.uml.model.datatypes.CallConcurrencyKind;
import com.topcoder.uml.model.datatypes.ChangeableKind;
import com.topcoder.uml.model.datatypes.ParameterDirectionKind;
import com.topcoder.uml.model.datatypes.VisibilityKind;
import com.topcoder.uml.model.modelmanagement.Model;
import com.topcoder.uml.model.modelmanagement.Package;
import com.topcoder.uml.model.modelmanagement.PackageImpl;
import com.topcoder.uml.model.statemachines.FinalState;
import com.topcoder.uml.model.statemachines.Guard;
import com.topcoder.uml.model.statemachines.GuardImpl;
import com.topcoder.uml.model.statemachines.Pseudostate;
import com.topcoder.uml.model.statemachines.SimpleState;
import com.topcoder.uml.model.usecases.Actor;
import com.topcoder.uml.model.usecases.UseCase;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.uml.projectconfiguration.ProjectConfigurationException;
import com.topcoder.uml.projectconfiguration.ProjectConfigurationManager;
import com.topcoder.umltool.deploy.actions.ExtensionFileFilter;
import com.topcoder.umltool.deploy.actions.undoable.ChangeEntityNameAction;
import com.topcoder.umltool.deploy.actions.undoable.CompositeUndoableAction;
import com.topcoder.umltool.deploy.actions.undoable.RemoveAbstractionEdgeAction;
import com.topcoder.umltool.deploy.actions.undoable.RemoveAcceptEventActionAction;
import com.topcoder.umltool.deploy.actions.undoable.RemoveActionStateAction;
import com.topcoder.umltool.deploy.actions.undoable.RemoveActorNodeAction;
import com.topcoder.umltool.deploy.actions.undoable.RemoveAssociationEdgeAction;
import com.topcoder.umltool.deploy.actions.undoable.RemoveClassNodeAction;
import com.topcoder.umltool.deploy.actions.undoable.RemoveCommentLinkEdgeAction;
import com.topcoder.umltool.deploy.actions.undoable.RemoveCommentNodeAction;
import com.topcoder.umltool.deploy.actions.undoable.RemoveDecisionNodeAction;
import com.topcoder.umltool.deploy.actions.undoable.RemoveDependencyEdgeAction;
import com.topcoder.umltool.deploy.actions.undoable.RemoveEdgeAction;
import com.topcoder.umltool.deploy.actions.undoable.RemoveExtendEdgeAction;
import com.topcoder.umltool.deploy.actions.undoable.RemoveFinalNodeAction;
import com.topcoder.umltool.deploy.actions.undoable.RemoveFlowFinalNodeAction;
import com.topcoder.umltool.deploy.actions.undoable.RemoveForkNodeAction;
import com.topcoder.umltool.deploy.actions.undoable.RemoveFreeTextNodeAction;
import com.topcoder.umltool.deploy.actions.undoable.RemoveGeneralizationEdgeAction;
import com.topcoder.umltool.deploy.actions.undoable.RemoveIncludeEdgeAction;
import com.topcoder.umltool.deploy.actions.undoable.RemoveInitialNodeAction;
import com.topcoder.umltool.deploy.actions.undoable.RemoveInterfaceNodeAction;
import com.topcoder.umltool.deploy.actions.undoable.RemoveJoinNodeAction;
import com.topcoder.umltool.deploy.actions.undoable.RemoveMergeNodeAction;
import com.topcoder.umltool.deploy.actions.undoable.RemoveNodeAction;
import com.topcoder.umltool.deploy.actions.undoable.RemoveObjectFlowNodeAction;
import com.topcoder.umltool.deploy.actions.undoable.RemovePackageNodeAction;
import com.topcoder.umltool.deploy.actions.undoable.RemovePolylineAction;
import com.topcoder.umltool.deploy.actions.undoable.RemoveSendSignalActionAction;
import com.topcoder.umltool.deploy.actions.undoable.RemoveSequenceEdgeAction;
import com.topcoder.umltool.deploy.actions.undoable.RemoveSubsystemNodeContainerAction;
import com.topcoder.umltool.deploy.actions.undoable.RemoveTransitionAction;
import com.topcoder.umltool.deploy.actions.undoable.RemoveUseCaseNodeAction;
import com.topcoder.umltool.deploy.actions.undoable.UpdateEdgeAction;
import com.topcoder.umltool.deploy.converters.CombinedFragment;
import com.topcoder.umltool.deploy.converters.DefaultXMIHandler;
import com.topcoder.umltool.deploy.converters.DeployNode;
import com.topcoder.umltool.deploy.handlers.ActivityBoundChangedHandler;
import com.topcoder.umltool.deploy.handlers.ActivityNameChangedHandler;
import com.topcoder.umltool.deploy.handlers.AttributeCompartmentMouseHandler;
import com.topcoder.umltool.deploy.handlers.AttributeTextChangedHandler;
import com.topcoder.umltool.deploy.handlers.AuxiliaryBoundChangedHandler;
import com.topcoder.umltool.deploy.handlers.AuxiliaryTextChangedHandler;
import com.topcoder.umltool.deploy.handlers.ClassEdgeNameChangedHandler;
import com.topcoder.umltool.deploy.handlers.ClassNameChangedHandler;
import com.topcoder.umltool.deploy.handlers.CornerDragHandler;
import com.topcoder.umltool.deploy.handlers.CornerMouseHandler;
import com.topcoder.umltool.deploy.handlers.EdgeDragHandler;
import com.topcoder.umltool.deploy.handlers.EdgeMouseHandler;
import com.topcoder.umltool.deploy.handlers.ElementSelectionHandler;
import com.topcoder.umltool.deploy.handlers.FeatureKeyHandler;
import com.topcoder.umltool.deploy.handlers.FeatureSelectionHandler;
import com.topcoder.umltool.deploy.handlers.NodeDragHandler;
import com.topcoder.umltool.deploy.handlers.NodeMouseHandler;
import com.topcoder.umltool.deploy.handlers.NodeTextMouseHandler;
import com.topcoder.umltool.deploy.handlers.ObjectNodeEditNameHandler;
import com.topcoder.umltool.deploy.handlers.ObjectNodeResizeHandler;
import com.topcoder.umltool.deploy.handlers.OperationCompartmentMouseHandler;
import com.topcoder.umltool.deploy.handlers.OperationTextChangedHandler;
import com.topcoder.umltool.deploy.handlers.PolylineCornerDragHandler;
import com.topcoder.umltool.deploy.handlers.PolylineCornerMouseHandler;
import com.topcoder.umltool.deploy.handlers.PolylineMouseHandler;
import com.topcoder.umltool.deploy.handlers.SequenceEdgeDragHandler;
import com.topcoder.umltool.deploy.handlers.SequenceEdgeMouseHandler;
import com.topcoder.umltool.deploy.handlers.SequenceEdgeNameChangedHandler;
import com.topcoder.umltool.deploy.handlers.UsecaseNameChangedHandler;
import com.topcoder.umltool.deploy.handlers.WayPointHandler;
import com.topcoder.umltool.deploy.handlers.WayPointMouseHandler;
import com.topcoder.umltool.deploy.handlers.CornerDragHandler.CornerDragType;
import com.topcoder.umltool.xmiconverters.poseidon5.ActivityDiagramConversionFacade;
import com.topcoder.umltool.xmiconverters.poseidon5.XMIConverterConfigurationException;
import com.topcoder.umltool.xmiconverters.poseidon5.XMIConvertersUtil;
import com.topcoder.umltool.xmiconverters.poseidon5.XMISequenceDiagramConverterUtil;
import com.topcoder.util.actionmanager.ActionExecutionException;
import com.topcoder.util.config.ConfigManager;
import com.topcoder.util.config.UnknownNamespaceException;
import com.topcoder.util.log.Level;
import com.topcoder.xmi.reader.XMIReader;
import com.topcoder.xmi.reader.XMIReaderConfigException;
import com.topcoder.xmi.reader.XMIReaderIOException;
import com.topcoder.xmi.reader.XMIReaderParseException;

/**
 * <p>
 * This class defines utilities used in this component.
 * </p>
 *
 * @author ly, FireIce, ylouis, gevak
 * @version 1.0
 */
public final class DeployHelper {

    /**
     * <p>
     * Strings for diagram typeinfo.
     * </p>
     */
    public static final String DIAGRAM_TYPEINFO[] =
        {"ClassDiagram", "UseCaseDiagram", "SequenceDiagram", "ActivityDiagram"};

    /**
     * <p>
     * Enum for diagram type.
     * </p>
     */
    public static final DiagramType DIAGRAM_TYPE[] =
        {DiagramType.CLASS, DiagramType.USECASE, DiagramType.SEQUENCE, DiagramType.ACTIVITY};

    /**
     * <p>
     * String for body compartment.
     * </p>
     */
    public static final String BODY_COMPARTMENT = "BodyCompartment";

    /**
     * <p>
     * Visibility token for public item.
     * </p>
     */
    private static final String VB_PUBLIC = "+";

    /**
     * <p>
     * Visibility token for protected item.
     * </p>
     */
    private static final String VB_PROTECTED = "#";

    /**
     * <p>
     * Visibility token for package item.
     * </p>
     */
    private static final String VB_PACKAGE = "~";

    /**
     * <p>
     * Visibility token for private item.
     * </p>
     */
    private static final String VB_PRIVATE = "-";

    /**
     * <p>
     * Represents the default segment length for self connected edge.
     * </p>
     */
    private static final int SEGMENT_LENGTH = 40;

    /**
     * <p>
     * Comparator for sequence edge.
     * </p>
     *
     * @author ly, FireIce, ylouis
     * @version 1.0
     */
    private static class SequenceEdgeComparator implements Comparator<SequenceEdge> {
        /**
         * <p>
         * Compares two sequence edges according to their Y coordinates.
         * </p>
         *
         * @param edge1
         *            first sequence edge
         * @param edge2
         *            second sequence edge
         * @return the comparison result
         */
        public int compare(SequenceEdge edge1, SequenceEdge edge2) {
            double y1 = edge1.getGraphEdge().getWaypoints().get(0).getY();
            double y2 = edge2.getGraphEdge().getWaypoints().get(0).getY();
            return Double.compare(y1, y2);
        }
    }

    /**
     * <p>
     * Private constructor to prevent this class being instantiated.
     * </p>
     */
    private DeployHelper() {
        // Does nothing.
    }

    /**
     * <p>
     * Checks whether the given argument is <code>null</code>.
     * </p>
     *
     * @param argument
     *            the argument to be checked
     * @param name
     *            the name of the argument
     * @throws IllegalArgumentException
     *             if the argument is <code>null</code>
     */
    public static void checkNotNull(java.lang.Object argument, String name) {
        if (argument == null) {
            throw new IllegalArgumentException(name + " should not be null.");
        }
    }

    /**
     * <p>
     * Changes class's constructor with the new name.
     * </p>
     *
     * @param mainFrame
     *            the main frame
     * @param classImpl
     *            the class
     * @param newName
     *            the new name
     * @param source
     *            the source
     */
    public static void changeConstructors(MainFrame mainFrame, ClassImpl classImpl, String newName, Object source) {
        CompositeUndoableAction action = new CompositeUndoableAction("class name changed");
        String name = classImpl.getName();
        for (Feature feature : classImpl.getFeatures()) {
            if ((feature instanceof Operation) && (feature.getName().equals(name))) {
                action.put(new ChangeEntityNameAction(feature, newName, false), source);
            }
        }
        action.put(new ChangeEntityNameAction(classImpl, newName, false), source);
        mainFrame.handleActionEvent(action, source, "class name changed");
    }

    /**
     * <p>
     * Gets the classifier object of int type.
     * </p>
     *
     * @param type
     *            classifier name
     * @return the classifier found
     */
    public static Classifier getClassifier(String type) {
        UMLModelManager manager = UMLModelManager.getInstance();
        Model root = manager.getModel();

        // traverse all the model elements owned by the root model
        for (ModelElement modelElement : root.getOwnedElements()) {
            if (modelElement instanceof Classifier) {
                if (type.equals(modelElement.getName())) {
                    return (Classifier) modelElement;
                }
            }
        }

        ProjectConfigurationManager configManager = manager.getProjectConfigurationManager();

        String language = manager.getProjectLanguage();

        if (language != null && language.trim().length() != 0) {
            for (Namespace namespace : configManager.getStandardNamespaces(language)) {
                if (namespace instanceof Classifier) {
                    if (type.equals(namespace.getName())) {
                        root.addOwnedElement(namespace);
                        namespace.setNamespace(root);
                        return (Classifier) namespace;
                    }
                }
            }
        }
        return null;
    }

    /**
     * <p>
     * Gets the value of given property from given namespace.
     * </p>
     *
     * @param namespace
     *            the configuration namespace
     * @param property
     *            the configuration property
     * @return property value
     * @throws DeployConfigException
     *             if UnknownNamespaceException is thrown
     */
    static String getProperty(String namespace, String property) throws DeployConfigException {
        try {
            return ConfigManager.getInstance().getString(namespace, property);
        } catch (UnknownNamespaceException e) {
            throw new DeployConfigException("Can not get " + property + " from " + namespace + " .", e);
        }
    }

    /**
     * <p>
     * Gets the value of given property from given namespace.
     * </p>
     *
     * @param namespace
     *            the configuration namespace
     * @param property
     *            the configuration property
     * @return property value
     */
    static String getProperty(String namespace, String property, String defaultValue) {
        try {
            return ConfigManager.getInstance().getString(namespace, property);
        } catch (UnknownNamespaceException e) {
            return defaultValue;
        }
    }

    /**
     * Gets the values of given property from given namespace.
     *
     * @param namespace
     *            the configuration namespace
     * @param property
     *            the configuration property
     * @return property values
     *
     * @throws DeployConfigException
     *             if UnknownNamespaceException is thrown
     */
    static String[] getValues(String namespace, String property) throws DeployConfigException {
        String[] value;
        try {
            value = ConfigManager.getInstance().getStringArray(namespace, property);
        } catch (UnknownNamespaceException e) {
            throw new DeployConfigException("Can not get " + property + " from " + namespace + " .", e);
        }
        return value;
    }

    /**
     * <p>
     * Removes all namespaces.
     * </p>
     *
     * @throws Exception
     *             when error occurs
     */
    static void removeAllNamespaces() throws Exception {
        ConfigManager manager = ConfigManager.getInstance();
        for (Iterator<?> it = manager.getAllNamespaces(); it.hasNext();) {
            manager.removeNamespace((String) it.next());
        }
    }

    /**
     * <p>
     * Loads the configuration file.
     * </p>
     *
     * @param filename
     *            the filename to load the configuration from
     * @throws Exception
     *             when error occurs
     */
    static void loadConfig(String filename) throws Exception {
        ConfigManager.getInstance().add(filename);
    }

    /**
     * <p>
     * Shows an error message box.
     * </p>
     *
     * @param mainFrame
     *            the frame window
     * @param e
     *            exception
     * @param message
     *            error message
     */
    public static void handleException(JFrame mainFrame, Throwable e, String message) {
        if (e != null) {
            logException(e);
            message += e.getMessage();
        }
        JOptionPane.showMessageDialog(mainFrame, message, MainFrame.MAIN_FRAME_TITLE, JOptionPane.ERROR_MESSAGE);
    }

    /**
     * <p>
     * Creates a property with given key and value.
     * </p>
     *
     * @param key
     *            the property key
     * @param value
     *            the property value
     * @return a new property created
     */
    public static Property createProperty(String key, String value) {
        Property p = new Property();
        p.setKey(key);
        p.setValue(value);
        return p;
    }

    /**
     * <p>
     * Creates a point for diagram element.
     * </p>
     *
     * @param x
     *            x coordinate
     * @param y
     *            y coordinate
     * @return a point for diagram element
     */
    public static com.topcoder.diagraminterchange.Point createPoint(double x, double y) {
        com.topcoder.diagraminterchange.Point pos = new com.topcoder.diagraminterchange.Point();
        pos.setX(x);
        pos.setY(y);
        return pos;
    }

    /**
     * <p>
     * Creates a point for diagram element.
     * </p>
     *
     * @param point
     *            java.awt.point type
     * @return a point for diagram element
     */
    public static com.topcoder.diagraminterchange.Point createPoint(Point point) {
        return createPoint(point.getX(), point.getY());
    }

    /**
     * <p>
     * Creates a dimension for diagram element.
     * </p>
     *
     * @param width
     *            size's width
     * @param height
     *            size's height
     * @return a dimension size for diagram element
     */
    static com.topcoder.diagraminterchange.Dimension createDimension(double width, double height) {
        com.topcoder.diagraminterchange.Dimension size = new com.topcoder.diagraminterchange.Dimension();
        size.setWidth(width);
        size.setHeight(height);
        return size;
    }

    /**
     * <p>
     * Creates a dimension for diagram element.
     * </p>
     *
     * @param sizetry
     *            // create a XMI reader XMIReader reader = new XMIReader(); // create handlers with the given
     *            model manager XMI2ModelHandler modelHandler = new XMI2ModelHandler(reader, modelManager);
     *            XMI2ActivityGraphHandler graphHandler = new XMI2ActivityGraphHandler(reader, modelManager);
     *            XMI2DiagramHandler diagramHandler = new XMI2DiagramHandler(reader, modelManager); // add all the
     *            created handlers to the reader reader.addHandler(modelHandler.getClass().getName(),
     *            modelHandler); reader.addHandler(graphHandler.getClass().getName(), graphHandler);
     *            reader.addHandler(diagramHandler.getClass().getName(), diagramHandler); // parse the stream and
     *            populate the model manager reader.parse(stream); // get the created model Model model =
     *            modelManager.getModel(); Collection<TaggedValue> list = model.getTaggedValues(); // run through
     *            the list of tagged values for (TaggedValue element : list) { // if there is a value with tag type
     *            ProjectLanguage if (element.getType() != null &&
     *            element.getType().getTagType().equals(PROJECT_LANGUAGE) && element.getDataValue() != null) { //
     *            set the language to the model manager modelManager.setProjectLanguage(element.getDataValue());
     *            return; } } // if there is no project language present // get the default language from the
     *            config manager String projectLanguage = configManager.getDefaultProjectLanguage(); // create a
     *            new tag definition with ProjectLanguage as type TagDefinition tagDefinition = new
     *            TagDefinitionImpl(); tagDefinition.setTagType(PROJECT_LANGUAGE); // create a tagged value with
     *            the project language as data and type as tag definition. TaggedValue taggedValue = new
     *            TaggedValueImpl(); taggedValue.setDataValue(projectLanguage); taggedValue.setType(tagDefinition);
     *            // add the tagged value to the model manager model.addTaggedValue(taggedValue); // set the
     *            project language modelManager.setProjectLanguage(projectLanguage); } catch
     *            (XMIReaderConfigException e) { throw new
     *            ActionExecutionException("Occurred while parsing the .xmi file", e); } catch (Exception e) {
     *            throw new ActionExecutionException("Occurred while loading the data from the XMI file", e); }
     *            size of com.awt.dimension type
     * @return a dimension size for diagram element
     */
    public static com.topcoder.diagraminterchange.Dimension createDimension(Dimension size) {
        return createDimension(size.width, size.height);
    }

    /**
     * <p>
     * Gets the position of corresponding GraphElement.
     * </p>
     *
     * @return the position of the GraphElement
     * @throws IllegalGraphElementException
     *             if the structure of GraphElement is invalid
     */
    public static Point getAbsoluteGraphNodePosition(GraphElement graphElement) {
        // The visual node's position is relative value, need to get the
        // absolute position of the visual node
        double x = 0;
        double y = 0;
        for (GraphElement node = graphElement; node.getContainer() != null; node = node.getContainer()) {
            if (node.getPosition() == null) {
                throw new IllegalGraphElementException(graphElement, "Position of GraphElement is null.");
            }
            x += node.getPosition().getX();
            y += node.getPosition().getY();
        }
        return new Point(Math.round((float) x), Math.round((float) y));
    }

    /**
     * <p>
     * This method return a default properties mapping.
     * </p>
     *
     * @return the default properties mapping
     */
    public static Map<String, String> createProperties() {
        Map<String, String> properties = new HashMap<String, String>();
        properties.put("FillColor", "FILL_COLOR");
        properties.put("StrokeColor", "STROKE_COLOR");
        properties.put("FontColor", "FONT_COLOR");
        properties.put("FontFamily", "FONT_FAMILY");
        properties.put("FontStyle", "FONT_STYLE");
        properties.put("FontSize", "FONT_SIZE");

        return properties;
    }

    /**
     * <p>
     * Sets the typeInfo of the <code>graphElement</code>.
     * </p>
     *
     * @param graphElement
     *            the <code>GraphElement</code> which typeInfo should be set
     * @param typeInfo
     *            the typeInfo which should be set to the <code>graphElement</code>
     */
    public static void setTypeInfo(GraphElement graphElement, String typeInfo) {
        SimpleSemanticModelElement simpleElement = new SimpleSemanticModelElement();
        simpleElement.setTypeInfo(typeInfo);
        graphElement.setSemanticModel(simpleElement);
    }

    /**
     * <p>
     * Gets the typeInfo of the <code>graphElement</code>.
     * </p>
     *
     * @param graphElement
     *            the <code>GraphElement</code> which typeInfo should be set
     * @return the typeInfo of the <code>graphElement</code>
     */
    public static String getTypeInfo(GraphElement graphElement) {
        if (graphElement.getSemanticModel() instanceof SimpleSemanticModelElement) {
            SimpleSemanticModelElement simpleElement =
                    (SimpleSemanticModelElement) graphElement.getSemanticModel();
            return simpleElement.getTypeInfo();
        } else {
            return "";
        }
    }

    /**
     * <p>
     * Sets the element of the <code>graphElement</code> to <code>element</code>.
     * </p>
     *
     * @param graphElement
     *            the <code>GraphElement</code> which element should be set.
     * @param element
     *            the element which should be set to the <code>graphElement</code>.
     */
    public static void setElement(GraphElement graphElement, Element element) {
        Uml1SemanticModelBridge uml1ModelBridge = new Uml1SemanticModelBridge();
        uml1ModelBridge.setElement(element);
        graphElement.setSemanticModel(uml1ModelBridge);
    }

    /**
     * <p>
     * Adds child to parent, and sets its container.
     * </p>
     *
     * @param parent
     *            parent graph element
     * @param child
     *            child graph element
     */
    public static void addContained(GraphElement parent, DiagramElement child) {
        parent.addContained(child);
        child.setContainer(parent);
    }

    /**
     * <p>
     * Creates a valid stereotype compartment <code>GraphNode</code>.
     * </p>
     *
     * @param stereotypeName
     *            stereotype name, null if there's no stereotype
     * @param isInterface
     *            for InterfaceNode
     * @return a valid stereotype compartment <code>GraphNode</code>
     */
    public static GraphNode createStereotypeCompartment(String stereotypeName, boolean isInterface) {
        GraphNode node = new GraphNode();

        // create SimpleSemanticmodelElement.typeinfo = "StereotypeCompartment"
        setTypeInfo(node, "StereotypeCompartment");

        // create SimpleSemanticModelElement.typeInfo = "StereotypeStart"
        GraphElement stereotypeStart = new GraphNode();
        setTypeInfo(stereotypeStart, "StereotypeStart");

        GraphElement keywordMetaclass = null;
        if (isInterface) {
            // create SimpleSemanticModelElement.typeInfo = "KeywordMetaclass"
            keywordMetaclass = new GraphNode();
            setTypeInfo(keywordMetaclass, "KeywordMetaclass");
        }

        String[] stereotypes = new String[0];
        if (stereotypeName != null) {
            stereotypes = stereotypeName.split(",");
        }
        GraphNode[] elements = new GraphNode[stereotypes.length];
        for (int i = 0; i < stereotypes.length; i++) {
            String stereotype = stereotypes[i];
            // create SimpleSemanticModelElement.typeInfo = "Name"
            GraphElement name = new GraphNode();
            setTypeInfo(name, "Name");
            // create Uml1SemanticModelBridgeElement.element = <UML:Package>
            elements[i] = new GraphNode();
            ModelElement element = new StereotypeImpl();
            element.setName(stereotype);
            // setElement(elements[i], element);
            addContained(elements[i], name);
        }

        // create SimpleSemanticModelElement.typeInfo = "StereotypeSeparator"
        GraphElement stereotypeSeparator = new GraphNode();
        setTypeInfo(stereotypeSeparator, "StereotypeSeparator");

        // create SimpleSemanticModelElement.typeInfo = "StereotypeEnd"
        GraphElement stereotypeEnd = new GraphNode();
        setTypeInfo(stereotypeEnd, "StereotypeEnd");

        // build correct structure
        addContained(node, stereotypeStart);

        if (keywordMetaclass != null) {
            addContained(node, keywordMetaclass);
            if (stereotypes.length > 0) {
                addContained(node, stereotypeSeparator);
            }
        }

        if (stereotypes.length > 0) {
            addContained(node, elements[0]);
            for (int i = 1; i < stereotypes.length; i++) {
                addContained(node, stereotypeSeparator);
                addContained(node, elements[i]);
            }
        }
        addContained(node, stereotypeEnd);

        return node;
    }

    /**
     * <p>
     * Creates a valid namespace compartment <code>GraphElement</code>.
     * </p>
     *
     * @param namespace
     *            the namespace text to display, null if there's no namespace to show
     * @return a valid namespace compartment <code>GraphElement</code>
     */
    private static GraphElement createNamespaceCompartment(String namespace) {
        GraphNode node = new GraphNode();

        // create SimpleSemanticmodelElement.typeinfo = "NamespaceCompartment"
        setTypeInfo(node, "NamespaceCompartment");

        // create SimpleSemanticModelElement.typeInfo = "NamespaceStart"
        GraphElement namespaceStart = new GraphNode();
        setTypeInfo(namespaceStart, "NamespaceStart");

        String[] packageNames = new String[0];
        if (namespace != null) {
            packageNames = namespace.split("\\.");
        }
        GraphNode[] packages = new GraphNode[packageNames.length];
        for (int i = 0; i < packageNames.length; i++) {
            String packageName = packageNames[i];
            // create SimpleSemanticModelElement.typeInfo = "Name"
            GraphElement name = new GraphNode();
            setTypeInfo(name, "Name");
            // create Uml1SemanticModelBridgeElement.element = <UML:Package>
            packages[i] = new GraphNode();
            ModelElement element = new PackageImpl();
            element.setName(packageName);
            // setElement(packages[i], element);
            addContained(packages[i], name);
        }

        // create SimpleSemanticModelElement.typeInfo = "NamespaceSeparator"
        GraphElement namespaceSeparator = new GraphNode();
        setTypeInfo(namespaceSeparator, "NamespaceSeparator");

        // create SimpleSemanticModelElement.typeInfo = "NamespaceEnd"
        GraphElement namespaceEnd = new GraphNode();
        setTypeInfo(namespaceEnd, "NamespaceEnd");

        // build correct structure
        addContained(node, namespaceStart);
        if (packageNames.length > 0) {
            addContained(node, packages[0]);
            for (int i = 1; i < packageNames.length; i++) {
                addContained(node, namespaceSeparator);
                addContained(node, packages[i]);
            }
        }
        addContained(node, namespaceEnd);

        node.setVisible(packageNames.length != 0);
        return node;
    }

    /**
     * <p>
     * Creates a valid name compartment <code>GraphElement</code> structure.
     * </p>
     *
     * @param stereotypeName
     *            stereotype name
     * @param namespace
     *            namespace
     * @param isInterface
     *            for InterfaceNode
     * @return a valid name compartment <code>GraphElement</code> structure
     */
    private static GraphElement createNameCompartment(String stereotypeName, String namespace, boolean isInterface) {
        GraphElement nameCompartment = new GraphNode();
        setTypeInfo(nameCompartment, "NameCompartment");

        // create SimpleSemanticmodelElement.typeinfo = "StereotypeCompartment"
        GraphElement stereotypeCompartment = createStereotypeCompartment(stereotypeName, isInterface);
        addContained(nameCompartment, stereotypeCompartment);

        // create SimpleSemanticmodelElement.typeinfo = "Name"
        GraphElement name = new GraphNode();
        setTypeInfo(name, "Name");
        addContained(nameCompartment, name);

        // create SimpleSemanticmodelElement.typeinfo = "NamespaceCompartment"
        GraphElement namespaceCompartment = createNamespaceCompartment(namespace);
        // default to invisible
        namespaceCompartment.setVisible(false);
        addContained(nameCompartment, namespaceCompartment);
        return nameCompartment;
    }

    /**
     * <p>
     * This method creates a default graphNode for UseCaseNode.
     * </p>
     *
     * @param element
     *            uml model element
     * @param position
     *            position of the graph node
     * @param size
     *            size of the graph node
     * @return the default graphNode for UseCaseNode
     */
    public static GraphNode createGraphNodeForUseCase(ModelElement element, Point position, Dimension size) {
        GraphNode graphNode = new GraphNode();

        // set size and position
        graphNode.setSize(createDimension(size));
        graphNode.setPosition(createPoint(position));

        // create SimpleSemanticmodelElement.typeinfo = "NameCompartment"
        String stereotypeName = getStereotypesString(element);
        Namespace namespace = element.getNamespace();
        String namespaceText = namespace != null ? namespace.getName() : null;
        GraphElement nameCompartment = createNameCompartment(stereotypeName, namespaceText, false);
        addContained(graphNode, nameCompartment);

        setElement(graphNode, element);

        // create properties
        graphNode.addProperty(createProperty("STROKE_COLOR", "000000"));
        graphNode.addProperty(createProperty("FILL_COLOR", "CCCCFF"));
        graphNode.addProperty(createProperty("FONT_COLOR", "000000"));
        graphNode.addProperty(createProperty("FONT_FAMILY", "Arial"));
        graphNode.addProperty(createProperty("FONT_STYLE", Integer.toString(Font.PLAIN)));
        graphNode.addProperty(createProperty("FONT_SIZE", DeployHelper.getProperty("com.topcoder.umltool.deploy",
                "DiagramFontSize", "10")));

        return graphNode;
    }

    /**
     * <p>
     * This method creates a default graphNode for ActorNode.
     * </p>
     *
     * @param element
     *            uml model element
     * @param position
     *            position of the graph node
     * @param size
     *            size of the graph node
     * @return the default graphNode for UseCaseNode
     */
    public static GraphNode createGraphNodeForActor(ModelElement element, Point position, Dimension size) {
        GraphNode graphNode = new GraphNode();
        com.topcoder.diagraminterchange.Dimension umlSize = new com.topcoder.diagraminterchange.Dimension();
        umlSize.setHeight(size.height);
        umlSize.setWidth(size.width);

        com.topcoder.diagraminterchange.Point umlPosition = new com.topcoder.diagraminterchange.Point();
        umlPosition.setX(position.x);
        umlPosition.setY(position.y);

        // set size and position
        graphNode.setSize(umlSize);
        graphNode.setPosition(umlPosition);

        // create SimpleSemanticmodelElement.typeinfo = "StereotypeCompartment"
        String stereotypeName = getStereotypesString(element);
        GraphElement stereotypeCompartment = createStereotypeCompartment(stereotypeName, false);
        addContained(graphNode, stereotypeCompartment);

        // create SimpleSemanticmodelElement.typeinfo = "Name"
        GraphElement name = new GraphNode();
        setTypeInfo(name, "Name");
        addContained(graphNode, name);

        // create SimpleSemanticmodelElement.typeinfo = "NamespaceCompartment"
        Namespace namespace = element.getNamespace();
        String namespaceText = namespace != null ? namespace.getName() : null;
        GraphElement namespaceCompartment = createNamespaceCompartment(namespaceText);
        addContained(graphNode, namespaceCompartment);

        setElement(graphNode, element);

        // create properties
        graphNode.addProperty(createProperty("STROKE_COLOR", "000000"));
        graphNode.addProperty(createProperty("FILL_COLOR", "FFFFFF"));
        graphNode.addProperty(createProperty("FONT_COLOR", "000000"));
        graphNode.addProperty(createProperty("FONT_FAMILY", "Arial"));
        graphNode.addProperty(createProperty("FONT_STYLE", Integer.toString(Font.PLAIN)));
        graphNode.addProperty(createProperty("FONT_SIZE", DeployHelper.getProperty("com.topcoder.umltool.deploy",
                "DiagramFontSize", "10")));

        return graphNode;
    }

    /**
     * <p>
     * This method creates a default graphNode for SubsystemNodeContainer.
     * </p>
     *
     * @param element
     *            uml model element
     * @param position
     *            position of the graph node
     * @param size
     *            size of the graph node
     * @return the default graphNode for SubsystemNodeContainer
     */
    public static GraphNode createGraphNodeForSubsystem(ModelElement element, Point position, Dimension size) {
        GraphNode graphNode = new GraphNode();
        com.topcoder.diagraminterchange.Dimension umlSize = new com.topcoder.diagraminterchange.Dimension();
        umlSize.setHeight(size.height);
        umlSize.setWidth(size.width);

        com.topcoder.diagraminterchange.Point umlPosition = new com.topcoder.diagraminterchange.Point();
        umlPosition.setX(position.x);
        umlPosition.setY(position.y);

        // set size and position
        graphNode.setSize(umlSize);
        graphNode.setPosition(umlPosition);

        // create SimpleSemanticmodelElement.typeinfo = "NameCompartment"
        String stereotypeName = getStereotypesString(element);
        Namespace namespace = element.getNamespace();
        String namespaceText = namespace != null ? namespace.getName() : null;
        GraphElement nameCompartment = createNameCompartment(stereotypeName, namespaceText, false);
        addContained(graphNode, nameCompartment);

        GraphElement bodyCompartment = new GraphNode();
        setTypeInfo(bodyCompartment, "BodyCompartment");
        bodyCompartment.setPosition(createPoint(0, 0));
        addContained(graphNode, bodyCompartment);

        setElement(graphNode, element);

        // create properties
        graphNode.addProperty(createProperty("STROKE_COLOR", "000000"));
        graphNode.addProperty(createProperty("FILL_COLOR", "CCCCFF"));
        graphNode.addProperty(createProperty("FONT_COLOR", "000000"));
        graphNode.addProperty(createProperty("FONT_FAMILY", "Arial"));
        graphNode.addProperty(createProperty("FONT_STYLE", Integer.toString(Font.PLAIN)));
        graphNode.addProperty(createProperty("FONT_SIZE", DeployHelper.getProperty("com.topcoder.umltool.deploy",
                "DiagramFontSize", "10")));

        return graphNode;
    }

    /**
     * <p>
     * This method creates a default GraphEdge for IncludeEdge or ExtendEdge.
     * </p>
     *
     * @param element
     *            model element
     * @param wayPoints
     *            way points of the graph edge
     * @param edgeName
     *            name for graph edge
     * @return the default GraphEdge for IncludeEdge or ExtendEdge
     */
    public static GraphEdge createGraphEdgeForUseCase(ModelElement element, List<Point> wayPoints, String edgeName) {
        GraphEdge graphEdge = new GraphEdge();

        // set position
        graphEdge.setPosition(createPoint(new Point(0, 0)));

        // add way points
        for (Point point : wayPoints) {
            graphEdge.addWaypoint(createPoint(point.x, point.y));
        }

        element.setName(edgeName);

        // create SimpleSemanticmodelElement.typeinfo = "StereotypeCompartment"
        GraphNode stereotypeCompartment = createStereotypeCompartment("", false);
        addContained(graphEdge, stereotypeCompartment);

        // create SimpleSemanticmodelElement.typeinfo = "Name"
        GraphNode name = new GraphNode();
        setTypeInfo(name, "Name");
        addContained(graphEdge, name);

        setElement(graphEdge, element);

        // create properties
        graphEdge.addProperty(createProperty("STROKE_COLOR", "000000"));
        graphEdge.addProperty(createProperty("FILL_COLOR", "B0C4DE"));
        graphEdge.addProperty(createProperty("FONT_COLOR", "000000"));
        graphEdge.addProperty(createProperty("FONT_FAMILY", "Arial"));
        graphEdge.addProperty(createProperty("FONT_STYLE", Integer.toString(Font.PLAIN)));
        graphEdge.addProperty(createProperty("FONT_SIZE", DeployHelper.getProperty("com.topcoder.umltool.deploy",
                "DiagramFontSize", "10")));

        return graphEdge;
    }

    /**
     * <p>
     * create corner selection for object node
     * </p>
     *
     * @return corner selection
     */
    public static Collection<SelectionCornerType> createSelectionCorner() {
        Collection<SelectionCornerType> corners = new HashSet<SelectionCornerType>();
        corners.add(SelectionCornerType.EAST);
        corners.add(SelectionCornerType.NORTH);
        corners.add(SelectionCornerType.NORTHEAST);
        corners.add(SelectionCornerType.NORTHWEST);
        corners.add(SelectionCornerType.SOUTH);
        corners.add(SelectionCornerType.SOUTHEAST);
        corners.add(SelectionCornerType.SOUTHWEST);
        corners.add(SelectionCornerType.WEST);
        return corners;
    }

    /**
     * <p>
     * create object node property name map for object node
     * </p>
     *
     * @return the property name map
     */
    private static EnumMap<ObjectNodePropertyType, String> createObjectNodePropertyMap() {
        EnumMap<ObjectNodePropertyType, String> propertyNameMapping =
                new EnumMap<ObjectNodePropertyType, String>(ObjectNodePropertyType.class);
        propertyNameMapping.put(ObjectNodePropertyType.FILL_COLOR, "FILL_COLOR");
        propertyNameMapping.put(ObjectNodePropertyType.STROKE_COLOR, "STROKE_COLOR");
        propertyNameMapping.put(ObjectNodePropertyType.FONT_COLOR, "FONT_COLOR");
        propertyNameMapping.put(ObjectNodePropertyType.FONT_FAMILY, "FONT_FAMILY");
        propertyNameMapping.put(ObjectNodePropertyType.FONT_STYLE, "FONT_STYLE");
        propertyNameMapping.put(ObjectNodePropertyType.FONT_SIZE, "FONT_SIZE");
        return propertyNameMapping;
    }

    /**
     * <p>
     * create configured edge ending property types for sequence edge
     * </p>
     *
     * @return configured edge ending property types
     */
    private static EnumMap<ConfiguredEdgeEndingPropertyType, String> createSequenceEdgeEndingProperties() {
        EnumMap<ConfiguredEdgeEndingPropertyType, String> endingProperties =
                new EnumMap<ConfiguredEdgeEndingPropertyType, String>(ConfiguredEdgeEndingPropertyType.class);
        endingProperties.put(ConfiguredEdgeEndingPropertyType.STROKE_COLOR, "STROKE_COLOR");
        endingProperties.put(ConfiguredEdgeEndingPropertyType.FILL_COLOR, "FILL_COLOR");
        endingProperties.put(ConfiguredEdgeEndingPropertyType.ARROW_X_LENGTH, "ARROW_X_LENGTH");
        endingProperties.put(ConfiguredEdgeEndingPropertyType.ARROW_Y_LENGTH, "ARROW_Y_LENGTH");
        endingProperties.put(ConfiguredEdgeEndingPropertyType.RENDER_SCHEME, "RENDER_SCHEME");
        return endingProperties;
    }

    /**
     * <p>
     * create sequence edge property types for sequence edge
     * </p>
     *
     * @return sequence edge property types
     */
    private static EnumMap<SequenceEdgePropertyType, String> createSequenceEdgeProperties() {
        EnumMap<SequenceEdgePropertyType, String> edgeProperties =
                new EnumMap<SequenceEdgePropertyType, String>(SequenceEdgePropertyType.class);

        edgeProperties.put(SequenceEdgePropertyType.STROKE_COLOR, "STROKE_COLOR");
        edgeProperties.put(SequenceEdgePropertyType.FILL_COLOR, "FILL_COLOR");
        edgeProperties.put(SequenceEdgePropertyType.FILL_COLOR2, "FILL_COLOR2");
        edgeProperties.put(SequenceEdgePropertyType.SHADOW_COLOR, "SHADOW_COLOR");
        edgeProperties.put(SequenceEdgePropertyType.DASH_LENGTH, "DASH_LENGTH");
        edgeProperties.put(SequenceEdgePropertyType.BLANK_LENGTH, "BLANK_LENGTH");
        edgeProperties.put(SequenceEdgePropertyType.TEXT_BOX_STROKE_COLOR, "TEXT_BOX_STROKE_COLOR");
        edgeProperties.put(SequenceEdgePropertyType.TEXT_BOX_FILL_COLOR, "TEXT_BOX_FILL_COLOR");
        edgeProperties.put(SequenceEdgePropertyType.TEXT_BOX_FILL_COLOR2, "TEXT_BOX_FILL_COLOR2");
        edgeProperties.put(SequenceEdgePropertyType.FONT_FAMILY, "FONT_FAMILY");
        edgeProperties.put(SequenceEdgePropertyType.FONT_STYLE, "FONT_STYLE");
        edgeProperties.put(SequenceEdgePropertyType.FONT_SIZE, "FONT_SIZE");
        edgeProperties.put(SequenceEdgePropertyType.FONT_COLOR, "FONT_COLOR");
        edgeProperties.put(SequenceEdgePropertyType.RENDER_SCHEME, "RENDER_SCHEME");

        return edgeProperties;
    }

    /**
     * <p>
     * This method creates a GraphNode instance that follows the structures of Activity Node.
     * </p>
     *
     * @param element
     *            the uml element
     * @param position
     *            position of the graph node
     * @param size
     *            size of the graph node
     * @return a GraphNode instance that follows the structures of Activity Node
     */
    public static GraphNode createGraphNodeForActivityNode(ModelElement element, Point position, Dimension size) {
        GraphNode graphNode = new GraphNode();
        setElement(graphNode, element);

        graphNode.setPosition(createPoint(position));
        graphNode.setSize(createDimension(size));

        // create a stereotype node
        GraphNode stereoTypeNode = new GraphNode();
        setTypeInfo(stereoTypeNode, "StereotypeCompartment");

        // create a name node
        GraphNode nameNode = new GraphNode();
        setTypeInfo(nameNode, "Name");

        addContained(graphNode, stereoTypeNode);
        addContained(graphNode, nameNode);

        // create properties
        graphNode.addProperty(createProperty("STROKE_COLOR", "000000"));
        if (element instanceof FinalState && isFlowFinal((FinalState) element)) {
            graphNode.addProperty(createProperty("FILL_COLOR", "FFFFFF"));
        } else {
            graphNode.addProperty(createProperty("FILL_COLOR", "000000"));
        }
        graphNode.addProperty(createProperty("FONT_COLOR", "000000"));
        graphNode.addProperty(createProperty("FONT_FAMILY", "Arial"));
        graphNode.addProperty(createProperty("FONT_STYLE", Integer.toString(Font.PLAIN)));
        graphNode.addProperty(createProperty("FONT_SIZE", DeployHelper.getProperty("com.topcoder.umltool.deploy",
                "DiagramFontSize", "10")));

        return graphNode;
    }

    /**
     * <p>
     * Creates the tag value.
     * </p>
     *
     * @param tagType
     *            the tag type
     * @param dataValue
     *            the data value
     * @return a <code>TaggedValue</code> created
     */
    public static TaggedValue createTagValue(String tagType, String dataValue) {
        TagDefinition tagDefinition = getTagDefinition(tagType);

        TaggedValue taggedValue = new TaggedValueImpl();
        taggedValue.setType(tagDefinition);
        taggedValue.setDataValue(dataValue);

        return taggedValue;
    }

    /**
     * <p>
     * This method creates a GraphNode instance that follows the structures of Activity State.
     * </p>
     *
     * @param element
     *            the uml element
     * @param position
     *            position of the graph node
     * @param size
     *            size of the graph node
     * @return a GraphNode instance that follows the structures of Activity State.
     */
    public static GraphNode createGraphNodeForActivityState(ModelElement element, Point position, Dimension size) {
        GraphNode root = new GraphNode();
        root.setPosition(createPoint(position));
        root.setSize(createDimension(size));

        GraphNode graphNode = root;

        setElement(graphNode, element);

        // creates a NameCompartment node
        GraphNode subNode = new GraphNode();
        setTypeInfo(subNode, "NameCompartment");

        addContained(graphNode, subNode);
        graphNode = subNode;

        // creates a NameAndType node
        subNode = new GraphNode();
        setTypeInfo(subNode, "NameAndType");

        addContained(graphNode, subNode);
        graphNode = subNode;

        // creates a Name node
        subNode = new GraphNode();
        setTypeInfo(subNode, "Name");

        addContained(graphNode, subNode);

        // create properties
        root.addProperty(createProperty("STROKE_COLOR", "000000"));
        root.addProperty(createProperty("FILL_COLOR", "FFFFFF"));
        root.addProperty(createProperty("FONT_COLOR", "000000"));
        root.addProperty(createProperty("FONT_FAMILY", "Arial"));
        root.addProperty(createProperty("FONT_STYLE", Integer.toString(Font.PLAIN)));
        root.addProperty(createProperty("FONT_SIZE", DeployHelper.getProperty("com.topcoder.umltool.deploy",
                "DiagramFontSize", "10")));

        return root;
    }

    /**
     * <p>
     * This method creates a GraphEdge instance that follows the structures of Transition.
     * </p>
     *
     * @param element
     *            model element
     * @param wayPoints
     *            way points of the graph edge
     * @return a GraphEdge instance that follows the structures of Transition.
     */
    public static GraphEdge createGraphEdgeForTransition(ModelElement element, List<Point> wayPoints) {
        GraphEdge root = new GraphEdge();

        // set position
        root.setPosition(createPoint(new Point(0, 0)));

        // add way points
        for (Point point : wayPoints) {
            root.addWaypoint(createPoint(point.x, point.y));
        }

        setElement(root, element);

        // create a Name node
        GraphNode graphNode = new GraphNode();
        setTypeInfo(graphNode, "Name");
        addContained(root, graphNode);

        // create a TransitionDescription node
        graphNode = new GraphNode();
        setTypeInfo(graphNode, "TransitionDescription");

        // create a GuardStart node
        GraphNode subNode = new GraphNode();
        setTypeInfo(subNode, "GuardStart");
        addContained(graphNode, subNode);

        // create a Guard node
        subNode = new GraphNode();
        // set descriptionCompartment test
        Guard guard = new GuardImpl();
        guard.setName("TransitionDescriptionCompartment");
        // setElement(subNode, guard);
        // create a Name node
        GraphNode subSubNode = new GraphNode();
        setTypeInfo(subSubNode, "Name");
        addContained(subNode, subSubNode);

        addContained(graphNode, subNode);

        // create a GuardEnd node
        subNode = new GraphNode();
        setTypeInfo(subNode, "GuardEnd");
        addContained(graphNode, subNode);

        addContained(root, graphNode);

        // create graph node for StereotypeCompartment
        graphNode = new GraphNode();
        setTypeInfo(graphNode, "StereotypeCompartment");
        addContained(root, graphNode);

        // create properties
        root.addProperty(createProperty("STROKE_COLOR", "000000"));
        root.addProperty(createProperty("FILL_COLOR", "B0C4DE"));
        root.addProperty(createProperty("FONT_COLOR", "000000"));
        root.addProperty(createProperty("FONT_FAMILY", "Arial"));
        root.addProperty(createProperty("FONT_STYLE", Integer.toString(Font.PLAIN)));
        root.addProperty(createProperty("FONT_SIZE", DeployHelper.getProperty("com.topcoder.umltool.deploy",
                "DiagramFontSize", "10")));

        return root;
    }

    /**
     * <p>
     * This method creates a default graphNode for ActorNode.
     * </p>
     *
     * @param position
     *            position of the graph node
     * @param size
     *            size of the graph node
     * @return the default graphNode for ObjectNode
     */
    public static GraphNode createGraphNodeForObjectNode(Point position, Dimension size, ObjectImpl object) {
        GraphNode graphNode = new GraphNode();
        com.topcoder.diagraminterchange.Dimension umlSize = new com.topcoder.diagraminterchange.Dimension();
        umlSize.setHeight(size.height);
        umlSize.setWidth(size.width);

        com.topcoder.diagraminterchange.Point umlPosition = new com.topcoder.diagraminterchange.Point();
        umlPosition.setX(position.x);
        umlPosition.setY(position.y);

        // set size and position
        graphNode.setSize(umlSize);
        graphNode.setPosition(umlPosition);

        setElement(graphNode, object);

        return graphNode;
    }

    /**
     * <p>
     * Creates a valid <code>GraphElement</code> for given element.
     * </p>
     *
     * @param element
     *            the ModelElement to create a container graph element
     * @return a valid <code>GraphElement</code> for given element
     */
    public static GraphElement createGraphElement(ModelElement element) {
        GraphElement graphElement = new GraphNode();
        setElement(graphElement, element);

        // create SimpleSemanticmodelElement.typeinfo = "Name"
        GraphElement name = new GraphNode();
        setTypeInfo(name, "Name");
        addContained(graphElement, name);

        return graphElement;
    }

    /**
     * <p>
     * Creates an attribute.
     * </p>
     *
     * @param attributeName
     *            attribute name
     * @param typeName
     *            attribute type name
     * @return an attribute
     */
    public static Attribute createAttribute(String attributeName, String typeName) {
        Attribute attribute = new AttributeImpl();
        attribute.setName(attributeName);
        StructuralFeatureAbstractImpl.setType(attribute, getClassifier(typeName));
        attribute.setVisibility(VisibilityKind.PRIVATE);
        attribute.setChangeability(ChangeableKind.CHANGEABLE);
        return attribute;
    }

    /**
     * <p>
     * Creates a valid attribute compartment <code>GraphNode</code> structure.
     * </p>
     *
     * @param element
     *            model element to add attributes
     * @return a valid attribute compartment <code>GraphNode</code> structure
     */
    private static GraphElement createAttributeCompartment(Classifier element) {
        GraphElement attributeCompartment = new GraphNode();
        setTypeInfo(attributeCompartment, "AttributeCompartment");

        // create SimpleSemanticmodelElement.typeinfo = "DelimitedSection"
        GraphElement delimitedSection = new GraphNode();
        setTypeInfo(delimitedSection, "DelimitedSection");
        addContained(attributeCompartment, delimitedSection);

        return attributeCompartment;
    }

    /**
     * <p>
     * Creates an operation.
     * </p>
     *
     * @param name
     *            operation name
     * @param returnType
     *            return type
     * @return an operation
     */
    public static Operation createOperation(String name, String returnType) {
        Operation operation = new OperationImpl();
        operation.setName(name);

        Parameter parameter = new ParameterImpl();
        parameter.setType(getClassifier(returnType));
        parameter.setKind(ParameterDirectionKind.RETURN);
        parameter.setName("Return");
        operation.addParameter(parameter);
        parameter.setBehavioralFeature(operation);

        operation.setConcurrency(CallConcurrencyKind.SEQUENTIAL);
        operation.setVisibility(VisibilityKind.PUBLIC);

        return operation;
    }

    /**
     * <p>
     * Creates a valid operation compartment <code>GraphNode</code> structure.
     * </p>
     *
     * @param element
     *            model element to add operations
     * @return a valid operation compartment <code>GraphNode</code> structure
     */
    private static GraphElement createOperationCompartment(Classifier element) {
        GraphElement operationCompartment = new GraphNode();
        setTypeInfo(operationCompartment, "OperationCompartment");

        // create SimpleSemanticmodelElement.typeinfo = "DelimitedSection"
        GraphElement delimitedSection = new GraphNode();
        setTypeInfo(delimitedSection, "DelimitedSection");
        addContained(operationCompartment, delimitedSection);

        return operationCompartment;
    }

    /**
     * <p>
     * Creates an enumeration literal.
     * </p>
     *
     * @param literalName
     *            enumeration literal name
     * @return an enumeration literal
     */
    private static EnumerationLiteral createEnumerationLiteral(String literalName) {
        EnumerationLiteral literal = new EnumerationLiteralImpl();
        literal.setName(literalName);
        literal.setVisibility(VisibilityKind.PUBLIC);
        return literal;
    }

    /**
     * <p>
     * Creates a valid enumeration literal <code>GraphElement</code>.
     * </p>
     *
     * @param literalName
     *            enumeration literal name
     * @return a valid enumeration literal <code>GraphElement</code>
     */
    private static GraphElement createLiteralGraphElement(String literalName) {
        GraphElement literalGraphElement = new GraphNode();
        ModelElement element = new EnumerationLiteralImpl();
        element.setName(literalName);
        setElement(literalGraphElement, element);

        // create SimpleSemanticmodelElement.typeinfo = "StereotypeCompartment"
        GraphElement stereotypeCompartment = createStereotypeCompartment("", false);
        addContained(literalGraphElement, stereotypeCompartment);

        // create SimpleSemanticmodelElement.typeinfo = "Name"
        GraphElement name = new GraphNode();
        setTypeInfo(name, "Name");
        addContained(literalGraphElement, name);

        return literalGraphElement;
    }

    /**
     * <p>
     * Creates a valid enumeration literal compartment <code>GraphNode</code> structure.
     * </p>
     *
     * @param element
     *            model element to add literals
     * @return a valid enumeration literal compartment <code>GraphNode</code> structure
     */
    private static GraphElement createEnumerationLiteralCompartment(Enumeration element) {
        GraphElement literalCompartment = new GraphNode();
        setTypeInfo(literalCompartment, "EnumerationLiteralCompartment");

        // create SimpleSemanticmodelElement.typeinfo = "DelimitedSection"
        GraphElement delimitedSection = new GraphNode();
        setTypeInfo(delimitedSection, "DelimitedSection");
        addContained(literalCompartment, delimitedSection);

        element.addLiteral(createEnumerationLiteral("TYPE_1"));
        addContained(delimitedSection, createLiteralGraphElement("TYPE_1"));
        element.addLiteral(createEnumerationLiteral("TYPE_2"));
        addContained(delimitedSection, createLiteralGraphElement("TYPE_2"));
        element.addLiteral(createEnumerationLiteral("TYPE_3"));
        addContained(delimitedSection, createLiteralGraphElement("TYPE_3"));
        return literalCompartment;
    }

    /**
     * <p>
     * Creates a valid <code>GraphNode</code> for PackageNode.
     * </p>
     *
     * @param element
     *            model element
     * @param position
     *            the absolute position of the node
     * @param size
     *            the size of the node
     * @return a valid <code>GraphNode</code> for PackageNode
     */
    public static GraphNode createGraphNodeForPackage(ModelElement element, Point position, Dimension size) {

        GraphNode node = new GraphNode();

        // set size and position
        node.setSize(createDimension(size));
        node.setPosition(createPoint(position));

        // Uml1SemanticModelBridge.element = <UML:Package>
        setElement(node, element);

        // create SimpleSemanticmodelElement.typeinfo = "NameCompartment"
        String stereotypeName = getStereotypesString(element);
        Namespace namespace = element.getNamespace();
        String namespaceText = namespace != null ? namespace.getName() : null;
        GraphElement nameCompartment = createNameCompartment(stereotypeName, namespaceText, false);
        nameCompartment.getContaineds().get(0).setVisible(true);
        addContained(node, nameCompartment);

        // create SimpleSemanticmodelElement.typeinfo = "BodyCompartment"
        GraphElement bodyCompartment = new GraphNode();
        setTypeInfo(bodyCompartment, "BodyCompartment");
        bodyCompartment.setPosition(createPoint(0, 0));
        addContained(node, bodyCompartment);

        // create properties
        node.addProperty(createProperty("STROKE_COLOR", "000000"));
        node.addProperty(createProperty("FILL_COLOR", "FFF2CC"));
        node.addProperty(createProperty("FONT_COLOR", "000000"));
        node.addProperty(createProperty("FONT_FAMILY", "Arial"));
        node.addProperty(createProperty("FONT_STYLE", Integer.toString(Font.PLAIN)));
        node.addProperty(createProperty("FONT_SIZE", DeployHelper.getProperty("com.topcoder.umltool.deploy",
                "DiagramFontSize", "10")));

        return node;
    }

    /**
     * <p>
     * Validate if given Class instance has "exception" stereotype.
     * </p>
     *
     * @param exception
     *            Classifier instance, null impossible
     * @return true if class has "exception" stereotype, otherwise false
     * @throws IllegalArgumentException
     *             when exception is null
     */
    public static boolean isExceptionClass(Classifier exception) {
        if (exception == null) {
            throw new IllegalArgumentException("Param exception should not be null.");
        }

        Collection<Stereotype> stereotypes = exception.getStereotypes();
        for (Stereotype stereotype : stereotypes) {
            if (stereotype.getName().equalsIgnoreCase("exception")) {
                return true;
            }
        }

        return false;
    }

    /**
     * <p>
     * Validate if given Class instance has "enum" stereotype.
     * </p>
     *
     * @param exception
     *            Classifier instance, null impossible
     * @return true if class has "enum" stereotype, otherwise false
     * @throws IllegalArgumentException
     *             when exception is null
     */
    public static boolean isEnumClass(Classifier exception) {
        if (exception == null) {
            throw new IllegalArgumentException("Param exception should not be null.");
        }

        Collection<Stereotype> stereotypes = exception.getStereotypes();
        for (Stereotype stereotype : stereotypes) {
            if (stereotype.getName().equalsIgnoreCase("enum")) {
                return true;
            }
        }

        return false;
    }

    /**
     * <p>
     * Creates a valid <code>GraphNode</code> for ClassNode.
     * </p>
     *
     * @param element
     *            model element
     * @param position
     *            the absolute position of the node
     * @param size
     *            the size of the node
     * @return a valid <code>GraphNode</code> for ClassNode
     */
    public static GraphNode createGraphNodeForClass(ModelElement element, Point position, Dimension size) {
        GraphNode node = new GraphNode();

        // set size and position
        node.setSize(createDimension(size));
        node.setPosition(createPoint(position));

        // Uml1SemanticModelBridge.element = <UML:Interface> or <UML:Class>
        setElement(node, element);

        boolean isInterface = element instanceof Interface;
        boolean isException = isExceptionClass((Classifier) element);
        boolean isEnum = isEnumClass((Classifier) element);

        // create SimpleSemanticmodelElement.typeinfo = "NameCompartment"
        String stereotypeName = getStereotypesString(element);
        Namespace namespace = element.getNamespace();
        String namespaceText = namespace != null ? namespace.getName() : null;
        GraphElement nameCompartment = createNameCompartment(stereotypeName, namespaceText, isInterface);
        addContained(node, nameCompartment);

        // create SimpleSemanticmodelElement.typeinfo = "CompartmentSeparator"
        GraphElement compartmentSeparator = new GraphNode();
        setTypeInfo(compartmentSeparator, "CompartmentSeparator");
        addContained(node, compartmentSeparator);

        // create SimpleSemanticmodelElement.typeinfo = "AttributeCompartment"
        GraphElement attributeCompartment = createAttributeCompartment((Classifier) element);
        addContained(node, attributeCompartment);
        /*
         * BUGR-101, Attributes should not be shown by default for exceptions
         */
        // old code
        // if (isInterface) {
        if (isInterface || isException) {
            // default to invisible for Interface
            attributeCompartment.setVisible(false);
        }

        // create SimpleSemanticmodelElement.typeinfo = "CompartmentSeparator"
        addContained(node, compartmentSeparator);

        // create SimpleSemanticmodelElement.typeinfo = "OperationCompartment"
        GraphElement operationCompartment = createOperationCompartment((Classifier) element);
        addContained(node, operationCompartment);

        if (isEnum) {
            operationCompartment.setVisible(false);
        }

        // create properties
        node.addProperty(createProperty("STROKE_COLOR", "000000"));
        if (isInterface) {
            node.addProperty(createProperty("FILL_COLOR", "CCCCFF"));
        } else if (isException) {
            node.addProperty(createProperty("FILL_COLOR", "FF6666"));
        } else if (isEnum) {
            node.addProperty(createProperty("FILL_COLOR", "9932CD"));
        } else {
            node.addProperty(createProperty("FILL_COLOR", "CCFFCC"));
        }
        node.addProperty(createProperty("FONT_COLOR", "000000"));
        node.addProperty(createProperty("FONT_FAMILY", "Arial"));
        node.addProperty(createProperty("FONT_STYLE", Integer.toString(Font.PLAIN)));
        node.addProperty(createProperty("FONT_SIZE", DeployHelper.getProperty("com.topcoder.umltool.deploy",
                "DiagramFontSize", "10")));

        return node;
    }

    /**
     * <p>
     * Concatenates all stereotype names into a string.
     * </p>
     *
     * @param element
     *            the model element which contains stereotypes
     * @return the concatenated string, null if no stereotype
     */
    private static String getStereotypesString(ModelElement element) {
        if (element.getStereotypes().size() == 0) {
            return null;
        }
        String stereotypeName = "";
        for (Stereotype stereotype : element.getStereotypes()) {
            stereotypeName += stereotype.getName();
        }
        return stereotypeName;
    }

    /**
     * <p>
     * Creates a valid <code>GraphNode</code> for EnumerationNode.
     * </p>
     *
     * @param position
     *            the absolute position of the node
     * @param size
     *            the size of the node
     * @return a valid <code>GraphNode</code> for EnumerationNode
     */
    public static GraphNode createGraphNodeForEnumeration(Point position, Dimension size) {

        GraphNode node = new GraphNode();

        com.topcoder.diagraminterchange.Dimension sizeTC = new com.topcoder.diagraminterchange.Dimension();
        sizeTC.setHeight(size.height);
        sizeTC.setWidth(size.width);

        com.topcoder.diagraminterchange.Point positionTC = new com.topcoder.diagraminterchange.Point();
        positionTC.setX(position.x);
        positionTC.setY(position.y);

        // set size and position
        node.setSize(sizeTC);
        node.setPosition(positionTC);

        Enumeration element = new EnumerationImpl();

        String stereotypeName = getStereotypesString(element);

        Namespace namespace = element.getNamespace();
        String namespaceText = namespace != null ? namespace.getName() : null;

        // create SimpleSemanticmodelElement.typeinfo = "NameCompartment"
        GraphElement nameCompartment = createNameCompartment(stereotypeName, namespaceText, false);
        addContained(node, nameCompartment);

        // create SimpleSemanticmodelElement.typeinfo = "CompartmentSeparator"
        GraphElement compartmentSeparator = new GraphNode();
        setTypeInfo(compartmentSeparator, "CompartmentSeparator");
        addContained(node, compartmentSeparator);

        // create SimpleSemanticmodelElement.typeinfo =
        // "EnumerationLiteralCompartment"
        GraphElement literalCompartment = createEnumerationLiteralCompartment(element);
        addContained(node, literalCompartment);

        // create SimpleSemanticmodelElement.typeinfo = "CompartmentSeparator"
        addContained(node, compartmentSeparator);

        // create SimpleSemanticmodelElement.typeinfo = "AttributeCompartment"
        GraphElement attributeCompartment = createAttributeCompartment(element);
        addContained(node, attributeCompartment);

        // create SimpleSemanticmodelElement.typeinfo = "CompartmentSeparator"
        addContained(node, compartmentSeparator);

        // create SimpleSemanticmodelElement.typeinfo = "OperationCompartment"
        GraphElement operationCompartment = createOperationCompartment(element);
        addContained(node, operationCompartment);

        // Uml1SemanticModelBridge.element = <UML:Enumeration>
        setElement(node, element);

        // create properties
        node.addProperty(createProperty("STROKE_COLOR", "000000"));
        node.addProperty(createProperty("FILL_COLOR", "9932CD"));
        node.addProperty(createProperty("FONT_COLOR", "000000"));
        node.addProperty(createProperty("FONT_FAMILY", "Arial"));
        node.addProperty(createProperty("FONT_STYLE", Integer.toString(Font.PLAIN)));
        node.addProperty(createProperty("FONT_SIZE", DeployHelper.getProperty("com.topcoder.umltool.deploy",
                "DiagramFontSize", "10")));

        return node;
    }

    /**
     * <p>
     * Creates a GraphNode for given association end.
     * </p>
     *
     * @param associationEnd
     *            association model element which contains this association end
     * @return a GraphNode for given association end
     */
    public static GraphNode createAssociationEndGraphNode(AssociationEnd associationEnd) {
        GraphNode graphNode = new GraphNode();
        setElement(graphNode, associationEnd);

        // create SimpleSemanticmodelElement.typeinfo = "Name"
        GraphElement name = new GraphNode();
        setTypeInfo(name, "Name");
        addContained(graphNode, name);

        // create SimpleSemanticmodelElement.typeinfo = "Visibility"
        GraphElement visibility = new GraphNode();
        setTypeInfo(visibility, "Visibility");
        addContained(graphNode, visibility);

        // create SimpleSemanticmodelElement.typeinfo = "Multiplicity"
        GraphElement multiplicity = new GraphNode();
        setTypeInfo(multiplicity, "Multiplicity");
        addContained(graphNode, multiplicity);

        // create SimpleSemanticmodelElement.typeinfo = "ExpressionCompartment"
        GraphElement expressionCompartment = new GraphNode();
        setTypeInfo(expressionCompartment, "ExpressionCompartment");
        addContained(graphNode, expressionCompartment);

        // create SimpleSemanticmodelElement.typeinfo = "ExpressionStart"
        GraphElement expressionStart = new GraphNode();
        setTypeInfo(expressionStart, "ExpressionStart");
        addContained(expressionCompartment, expressionStart);

        // create SimpleSemanticmodelElement.typeinfo = "Ordering"
        GraphElement ordering = new GraphNode();
        setTypeInfo(ordering, "Ordering");
        addContained(expressionCompartment, ordering);

        // create SimpleSemanticmodelElement.typeinfo = "ExpressionEnd"
        GraphElement expressionEnd = new GraphNode();
        setTypeInfo(expressionEnd, "ExpressionEnd");
        addContained(expressionCompartment, expressionEnd);

        return graphNode;
    }

    /**
     * <p>
     * This method creates a GraphEdge instance that follows the structures of Association.
     * </p>
     *
     * @param element
     *            model element
     * @param wayPoints
     *            way points of the graph edge
     * @param edgeName
     *            name for graph edge
     * @return a GraphEdge instance that follows the structures of Association.
     */
    public static GraphEdge createGraphEdgeForAssociation(Association element, List<Point> wayPoints,
            String edgeName) {
        GraphEdge root = new GraphEdge();

        // set position
        root.setPosition(createPoint(new Point(0, 0)));

        // add way points
        for (Point point : wayPoints) {
            root.addWaypoint(createPoint(point.x, point.y));
        }

        // set name
        element.setName(edgeName);

        setElement(root, element);

        // create an AssociationEnd node
        GraphNode graphNode = createAssociationEndGraphNode(element.getConnections().get(0));
        addContained(root, graphNode);

        // create an AssociationEnd node
        graphNode = createAssociationEndGraphNode(element.getConnections().get(1));
        addContained(root, graphNode);

        // create a TransitionDescription node
        graphNode = new GraphNode();
        setTypeInfo(graphNode, "TransitionDescription");

        // create a DirectedName node
        graphNode = new GraphNode();
        graphNode.setSize(createDimension(0, 0));
        setTypeInfo(graphNode, "DirectedName");
        addContained(root, graphNode);

        // create a Name node
        GraphNode subGraphNode = new GraphNode();
        setTypeInfo(subGraphNode, "Name");
        addContained(graphNode, subGraphNode);

        // create a StereotypeCompartment node
        graphNode = new GraphNode();
        graphNode.setSize(createDimension(0, 0));
        setTypeInfo(graphNode, "StereotypeCompartment");
        addContained(root, graphNode);

        // create properties
        root.addProperty(createProperty("STROKE_COLOR", "000000"));
        root.addProperty(createProperty("FILL_COLOR", "B0C4DE"));
        root.addProperty(createProperty("FONT_COLOR", "000000"));
        root.addProperty(createProperty("FONT_FAMILY", "Arial"));
        root.addProperty(createProperty("FONT_STYLE", Integer.toString(Font.PLAIN)));
        root.addProperty(createProperty("FONT_SIZE", DeployHelper.getProperty("com.topcoder.umltool.deploy",
                "DiagramFontSize", "10")));

        return root;
    }

    /**
     * <p>
     * This method creates a GraphEdge instance that follows the structures of Generalization, Realization or
     * Dependency.
     * </p>
     *
     * @param element
     *            the ModelElement to create a Generalization, Realization or Dependency edge
     * @param wayPoints
     *            way points of the graph edge
     * @param edgeName
     *            name for graph edge
     * @return a GraphEdge instance that follows the structures of Generalization, Realization or Dependency
     */
    public static GraphEdge createGraphEdgeForClass(ModelElement element, List<Point> wayPoints) {
        GraphEdge root = new GraphEdge();

        // set position
        root.setPosition(createPoint(new Point(0, 0)));

        // add way points
        for (Point point : wayPoints) {
            root.addWaypoint(createPoint(point.x, point.y));
        }

        setElement(root, element);

        // create a DirectedName node
        GraphNode graphNode = new GraphNode();
        graphNode.setSize(createDimension(0, 0));
        setTypeInfo(graphNode, "DirectedName");
        addContained(root, graphNode);

        // create a Name node
        GraphNode subGraphNode = new GraphNode();
        setTypeInfo(subGraphNode, "Name");
        addContained(graphNode, subGraphNode);

        // create a StereotypeCompartment node
        graphNode = new GraphNode();
        graphNode.setSize(createDimension(0, 0));
        setTypeInfo(graphNode, "StereotypeCompartment");
        addContained(root, graphNode);

        // create properties
        root.addProperty(createProperty("STROKE_COLOR", "000000"));
        root.addProperty(createProperty("FILL_COLOR", "B0C4DE"));
        root.addProperty(createProperty("FONT_COLOR", "000000"));
        root.addProperty(createProperty("FONT_FAMILY", "Arial"));
        root.addProperty(createProperty("FONT_STYLE", Integer.toString(Font.PLAIN)));
        root.addProperty(createProperty("FONT_SIZE", DeployHelper.getProperty("com.topcoder.umltool.deploy",
                "DiagramFontSize", "10")));

        return root;
    }

    /**
     * <p>
     * This method creates a default graphNode for CommentNode.
     * </p>
     *
     * @param element
     *            uml model element
     * @param position
     *            position of the graph node
     * @param size
     *            size of the graph node
     * @return the default graphNode for CommentNode
     */
    public static GraphNode createGraphNodeForComment(ModelElement element, Point position, Dimension size) {
        GraphNode graphNode = new GraphNode();
        com.topcoder.diagraminterchange.Dimension umlSize = new com.topcoder.diagraminterchange.Dimension();
        umlSize.setHeight(size.height);
        umlSize.setWidth(size.width);

        com.topcoder.diagraminterchange.Point umlPosition = new com.topcoder.diagraminterchange.Point();
        umlPosition.setX(position.x);
        umlPosition.setY(position.y);

        // set size and position
        graphNode.setSize(umlSize);
        graphNode.setPosition(umlPosition);

        setElement(graphNode, element);

        // create properties
        graphNode.addProperty(createProperty("STROKE_COLOR", "#000000"));
        graphNode.addProperty(createProperty("FILL_COLOR", "#FFFF00"));
        graphNode.addProperty(createProperty("FONT_COLOR", "#000000"));
        graphNode.addProperty(createProperty("FONT_FAMILY", "Arial"));
        graphNode.addProperty(createProperty("FONT_STYLE", Integer.toString(Font.PLAIN)));
        graphNode.addProperty(createProperty("FONT_SIZE", DeployHelper.getProperty("com.topcoder.umltool.deploy",
                "DiagramFontSize", "10")));

        return graphNode;
    }

    /**
     * <p>
     * This method creates a default graphNode for FreeTextNode.
     * </p>
     *
     * @param position
     *            position of the graph node
     * @param size
     *            size of the graph node
     * @param text
     *            text of the TextElement
     * @return the default graphNode for FreeTextNode
     */
    public static GraphNode createGraphNodeForFreeText(Point position, Dimension size, String text) {
        GraphNode graphNode = new GraphNode();

        // set size and position
        graphNode.setSize(createDimension(size));
        graphNode.setPosition(createPoint(position));

        setTypeInfo(graphNode, "FreeText");
        TextElement textElement = new TextElement();
        textElement.setText(text);
        DeployHelper.addContained(graphNode, textElement);

        // create properties
        graphNode.addProperty(createProperty("STROKE_COLOR", "#000000"));
        graphNode.addProperty(createProperty("FILL_COLOR", "#FFFFFF"));
        graphNode.addProperty(createProperty("FONT_COLOR", "#000000"));
        graphNode.addProperty(createProperty("FONT_FAMILY", "Arial"));
        graphNode.addProperty(createProperty("FONT_STYLE", Integer.toString(Font.PLAIN)));
        graphNode.addProperty(createProperty("FONT_SIZE", DeployHelper.getProperty("com.topcoder.umltool.deploy",
                "DiagramFontSize", "10")));

        return graphNode;
    }

    /**
     * <p>
     * This method creates a GraphEdge instance that follows the structures of Association.
     * </p>
     *
     * @param wayPoints
     *            way points of the graph edge
     * @param edgeName
     *            name for graph edge
     * @return a GraphEdge instance that follows the structures of Association.
     */
    public static GraphEdge createGraphEdgeForCommentLink(List<Point> wayPoints) {
        GraphEdge root = new GraphEdge();

        // set position
        root.setPosition(createPoint(new Point(0, 0)));

        // add way points
        for (Point point : wayPoints) {
            root.addWaypoint(createPoint(point.x, point.y));
        }

        setTypeInfo(root, "CommentLink");

        // create properties
        root.addProperty(createProperty("STROKE_COLOR", "000000"));
        root.addProperty(createProperty("FILL_COLOR", "B0C4DE"));
        root.addProperty(createProperty("FONT_COLOR", "000000"));
        root.addProperty(createProperty("FONT_FAMILY", "Arial"));
        root.addProperty(createProperty("FONT_STYLE", Integer.toString(Font.PLAIN)));
        root.addProperty(createProperty("FONT_SIZE", DeployHelper.getProperty("com.topcoder.umltool.deploy",
                "DiagramFontSize", "10")));

        return root;
    }

    /**
     * <p>
     * Adds this node's model element to its container's namespace.
     * </p>
     *
     * @param node
     *            the node whose namespace needs updating
     */
    public static void addToOwner(Node node) {
        GraphNode graphNode = node.getGraphNode();
        ModelElement modelElement = DeployHelper.getElement(graphNode);
        if (modelElement instanceof Namespace) {
            GraphNode contaner = (GraphNode) graphNode.getContainer();
            if (contaner instanceof Diagram) {
                Namespace namespace = UMLModelManager.getInstance().getModel();
                modelElement.setNamespace(namespace);
                if (!namespace.containsOwnedElement(modelElement)) {
                    namespace.addOwnedElement(modelElement);
                }

            } else {
                contaner = (GraphNode) contaner.getContainer();
                ModelElement element = DeployHelper.getElement(contaner);
                if (element instanceof Namespace) {
                    Namespace namespace = (Namespace) element;
                    modelElement.getNamespace().removeOwnedElement(modelElement);
                    modelElement.setNamespace(namespace);
                    if (!namespace.containsOwnedElement(modelElement)) {
                        namespace.addOwnedElement(modelElement);
                    }
                }
            }
            DeployHelper.nodeNotifyChange(node, "Namespace updated");
        }
    }

    /**
     * <p>
     * Removes this node's model element from its container's namespace.
     * </p>
     *
     * @param node
     *            the node whose namespace needs updating
     */
    public static void removeFromOwner(Node node) {
        GraphNode graphNode = node.getGraphNode();
        ModelElement modelElement = DeployHelper.getElement(graphNode);
        if (modelElement instanceof Namespace) {
            GraphNode contaner = (GraphNode) graphNode.getContainer();
            if (contaner instanceof Diagram) {
                Namespace namespace = UMLModelManager.getInstance().getModel();
                namespace.removeOwnedElement(modelElement);

            } else {
                contaner = (GraphNode) contaner.getContainer();
                ModelElement element = DeployHelper.getElement(contaner);
                if (element instanceof Namespace) {
                    Namespace namespace = (Namespace) element;
                    namespace.removeOwnedElement(modelElement);
                }
            }
            DeployHelper.nodeNotifyChange(node, "Namespace updated");
        }
    }

    /**
     * <p>
     * Gets all object nodes in the given view.
     * </p>
     *
     * @param view
     *            the view to find object node
     * @return the list of object node in the given view
     */
    public static List<ObjectNode> getObjectNodes(DiagramView view) {
        List<ObjectNode> nodes = new ArrayList<ObjectNode>();
        for (Component component : view.getComponents()) {
            if (component instanceof ObjectNode) {
                nodes.add((ObjectNode) component);
            }
        }
        return nodes;
    }

    /**
     * <p>
     * Gets the connected edges and their indices of one node.
     * </p>
     *
     * @param node
     *            the node to find connected edges
     * @return the edge and index map that connected with the given node
     */
    public static Map<Edge, Integer> getConnectedEdges(Node node) {
        Map<Edge, Integer> edgeIndexMap = new HashMap<Edge, Integer>();
        GraphNode graphNode = node.getGraphNode();
        DiagramView view = (DiagramView) node.getParent();
        for (GraphConnector anchorage : graphNode.getAnchorages()) {
            for (GraphEdge graphEdge : anchorage.getGraphEdges()) {
                // for each graph edge connected with the given node
                for (Component component : view.getComponents()) {
                    if (component instanceof Edge) {
                        if (((Edge) component).getGraphEdge() == graphEdge) {
                            Edge edge = (Edge) component;
                            int index =
                                    graphEdge.getAnchors().get(0).getGraphElement() == graphNode ? 0 : edge
                                            .getWayPoints().size() - 1;
                            edgeIndexMap.put(edge, index);
                        }
                    }
                }
            }
        }
        return edgeIndexMap;
    }

    /**
     * <p>
     * Returns the <code>ModelElement</code> for given <code>GraphElement</code>.
     * </p>
     *
     * @param graphElement
     *            the <code>GraphElement</code> which <code>ModelElement</code> is returned
     * @return the <code>ModelElement</code> of given <code>GraphElement</code>
     */
    public static ModelElement getElement(GraphElement graphElement) {
        if (graphElement.getSemanticModel() instanceof Uml1SemanticModelBridge) {
            return ((ModelElement) (((Uml1SemanticModelBridge) graphElement.getSemanticModel()).getElement()));
        } else {
            return null;
        }
    }

    /**
     * <p>
     * Returns the <code>ModelElement</code> for given <code>JComponent</code>.
     * </p>
     *
     * @param component
     *            the <code>JComponent</code> which <code>ModelElement</code> is returned
     * @return the <code>ModelElement</code> of given <code>JComponent</code>
     */
    public static ModelElement getElement(JComponent component) {
        if (component instanceof Node) {
            return getElement(((Node) component).getGraphNode());
        } else if (component instanceof Edge) {
            return getElement(((Edge) component).getGraphEdge());
        } else if (component instanceof StereotypeTextField) {
            return getElement(((StereotypeTextField) component).getGraphNode());
        } else {
            return null;
        }
    }

    /**
     * <p>
     * Method to get the extension of the file, in lowercase.
     * </p>
     *
     * @return the extension string
     */
    public static String getExtension(File f) {
        String s = f.getName();
        int i = s.lastIndexOf('.');
        if (i > 0 && i < s.length() - 1)
            return s.substring(i + 1).toLowerCase();
        return "";
    }

    /**
     * <p>
     * Method to get the extension of the file filter, in lowercase
     * </p>
     *
     * @return the extension string
     */
    public static String getExtension(JFileChooser f) {
        String description = f.getFileFilter().getDescription();
        int extensionStart = description.lastIndexOf(".");
        String extension = description.substring(extensionStart + 1, description.length() - 1);
        return extension;
    }

    /**
     * <p>
     * Removes the mouse motion listener for given text field, then add a new listener which can pass event behind.
     * </p>
     *
     * @param textField
     *            the text field which should not be dragged
     */
    public static void replaceTextHandlers(TextField textField) {
        for (MouseMotionListener listener : textField.getMouseMotionListeners()) {
            textField.removeMouseMotionListener(listener);
        }
        textField.addMouseListener(new NodeTextMouseHandler());
        textField.addMouseMotionListener(new NodeTextMouseHandler());
    }

    /**
     * <p>
     * Removes the mouse motion listener for given class node's features, then add a new listener which can pass
     * event behind.
     * </p>
     *
     * @param classNode
     *            the class node whose features should not be dragged
     * @param mainFrame
     *            main frame window
     */
    public static void replaceFeatureHandlers(ClassNode classNode, MainFrame mainFrame) {
        GroupTextField attributeCompartment = classNode.getAttributesCompartment();
        for (StereotypeTextField attribute : attributeCompartment.getItems()) {
            if (isNewStereotypeTextField(attribute)) {
                for (MouseMotionListener listener : attribute.getMouseMotionListeners()) {
                    attribute.removeMouseMotionListener(listener);
                }
                FeatureSelectionHandler selectionHandler = new FeatureSelectionHandler(mainFrame);
                attribute.addMouseListener(selectionHandler);
                attribute.addMouseMotionListener(selectionHandler);
                attribute.addTextChangedListener(new AttributeTextChangedHandler(mainFrame));
                attribute.addKeyListener(new FeatureKeyHandler(mainFrame));
            }
        }

        GroupTextField operationCompartment = classNode.getOperationsCompartment();
        for (StereotypeTextField operation : operationCompartment.getItems()) {
            if (isNewStereotypeTextField(operation)) {
                for (MouseMotionListener listener : operation.getMouseMotionListeners()) {
                    operation.removeMouseMotionListener(listener);
                }
                FeatureSelectionHandler selectionHandler = new FeatureSelectionHandler(mainFrame);
                operation.addMouseListener(selectionHandler);
                operation.addMouseMotionListener(selectionHandler);
                operation.addTextChangedListener(new OperationTextChangedHandler(mainFrame));
                operation.addKeyListener(new FeatureKeyHandler(mainFrame));
            }
        }
    }

    /**
     * <p>
     * Checks whether the given sterotype text field is new.
     * </p>
     *
     * @param textField
     *            the StereotypeTextField to be checked
     * @return true if new, false otherwise
     */
    private static boolean isNewStereotypeTextField(StereotypeTextField textField) {
        for (KeyListener listener : textField.getKeyListeners()) {
            if (listener instanceof FeatureKeyHandler) {
                return false;
            }
        }
        return true;
    }

    /**
     * <p>
     * Adds common handlers to given node.
     * </p>
     *
     * @param node
     *            node where handlers are added
     * @param mainFrame
     *            main frame window
     */
    public static void addNodeHandlers(Node node, MainFrame mainFrame) {
        node.addNodeDragListener(new NodeDragHandler(mainFrame));
        node.addMouseListener(new ElementSelectionHandler(mainFrame));
        node.addCornerDragListener(new CornerDragHandler(mainFrame));
        node.addMouseListener(new NodeMouseHandler(mainFrame));
        for (SelectionCorner corner : node.getSelectionCorners()) {
            corner.addMouseListener(new CornerMouseHandler(mainFrame));
        }
    }

    /**
     * <p>
     * Adds common handlers to given edge.
     * </p>
     *
     * @param edge
     *            edge handlers are added
     * @param mainFrame
     *            main frame window
     */
    public static void addEdgeHandlers(Edge edge, MainFrame mainFrame) {
        edge.addEdgeDragListener(new EdgeDragHandler(mainFrame));
        edge.addMouseListener(new ElementSelectionHandler(mainFrame));
        edge.addWayPointDragListener(new WayPointHandler(mainFrame));
        edge.addMouseListener(new EdgeMouseHandler(mainFrame));
        for (com.topcoder.gui.diagramviewer.edges.SelectionCorner corner : edge.getWayPoints()) {
            corner.addMouseListener(new WayPointMouseHandler(mainFrame));
        }
    }

    /**
     * <p>
     * Gets current diagram view in main frame.
     * </p>
     *
     * @param mainFrame
     *            referece to main frame
     * @return current diagram view if exists opened views, else return null
     */
    public static DiagramView getDiagramView(MainFrame mainFrame) {
        ZoomPanel zoomPanel = (ZoomPanel) mainFrame.getDiagramViewer().getTabbedPane().getSelectedComponent();
        if (zoomPanel != null) {
            JViewport viewport = (JViewport) zoomPanel.getComponent(0);
            ZoomPane zoomPane = (ZoomPane) viewport.getComponent(0);
            DiagramView view = (DiagramView) zoomPane.getComponent(0);
            return view;
        } else {
            return null;
        }
    }

    /**
     * <p>
     * Creates a GraphConnector for given graph node and graph edge.
     * </p>
     *
     * @param graphNode
     *            graph node need connecting
     * @param graphEdge
     *            graph edge need connecting
     * @return a GraphConnector connecting the graph node and graph edge
     */
    public static GraphConnector createGraphConnector(GraphNode graphNode, GraphEdge graphEdge) {
        GraphConnector graphConnector = new GraphConnector();
        graphConnector.setGraphElement(graphNode);
        graphConnector.addGraphEdge(graphEdge);
        return graphConnector;
    }

    /**
     * <p>
     * Connects the graph edge with its starting and ending graph nodes.
     * </p>
     *
     * @param graphEdge
     *            graph edge need connecting
     * @param startGraphNode
     *            the graph node from which edge start
     * @param targetGraphNode
     *            the graph node at which edge end
     */
    public static void connectEdgeWithNodes(GraphEdge graphEdge, GraphNode startGraphNode,
            GraphNode targetGraphNode) {
        GraphConnector graphConnector = createGraphConnector(startGraphNode, graphEdge);
        startGraphNode.addAnchorage(graphConnector);
        // Add first anchor
        graphConnector.setPosition(graphEdge.getWaypoints().get(0));
        graphEdge.addAnchor(0, graphConnector);

        graphConnector = createGraphConnector(targetGraphNode, graphEdge);
        targetGraphNode.addAnchorage(graphConnector);
        // Add second anchor
        int count = graphEdge.countWaypoints();
        graphConnector.setPosition(graphEdge.getWaypoints().get(count - 1));
        graphEdge.addAnchor(1, graphConnector);
    }

    /**
     * <p>
     * Removes the graph edge from its starting and ending graph nodes.
     * </p>
     *
     * @param graphEdge
     *            graph edge need connecting
     * @param startGraphNode
     *            the graph node from which edge start
     * @param targetGraphNode
     *            the graph node at which edge end
     */
    public static void removeEdgeBetweenNodes(GraphEdge graphEdge, GraphNode startGraphNode,
            GraphNode targetGraphNode) {
        if (graphEdge.countAnchors() != 2) {
            // Return directly if anchors have been removed
            return;
        }
        GraphConnector leftAnchor = graphEdge.getAnchors().get(0);
        GraphConnector rightAnchor = graphEdge.getAnchors().get(1);

        // Remove anchorages from graph nodes
        startGraphNode.removeAnchorage(leftAnchor);
        targetGraphNode.removeAnchorage(rightAnchor);

        // Remove anchors from graph edge
        graphEdge.removeAnchor(leftAnchor);
        graphEdge.removeAnchor(rightAnchor);
    }

    /**
     * <p>
     * Finds the component corresponding to given uml model element.
     * </p>
     *
     * @param modelElement
     *            uml model element
     * @param mainFrame
     *            main frame window
     * @return the found component, null if not found
     */
    public static List<JComponent> getComponent(ModelElement modelElement, MainFrame mainFrame) {
        List<JComponent> components = new ArrayList<JComponent>();
        List<GraphElement> graphElements = getGraphElement(modelElement);
        for (GraphElement graphElement : graphElements) {
            JComponent component = getComponent(graphElement, mainFrame);
            if (component != null) {
                components.add(component);
            }
        }
        return components;
    }

    /**
     * <p>
     * Finds the component corresponding to given graph element.
     * </p>
     *
     * @param graphElement
     *            a graph element for Node or Edge
     * @param mainFrame
     *            main frame window
     * @return the found component, null if not found
     */
    public static JComponent getComponent(GraphElement graphElement, MainFrame mainFrame) {
        Diagram diagram = getDiagram(graphElement);
        DiagramViewer diagramViewer = mainFrame.getDiagramViewer();

        DiagramView diagramView = diagramViewer.createDiagramView((Diagram) diagram);
        return getComponent(graphElement, diagramView);
    }

    /**
     * <p>
     * Finds the component corresponding to given polyline.
     * </p>
     *
     * @param a
     *            graph element for Node or Edge
     * @param mainFrame
     *            main frame window
     * @return the found component, null if not found
     */
    public static PolylineNode getPolylineNode(Polyline polyline, MainFrame mainFrame) {
        Diagram diagram = getDiagram(polyline);
        DiagramViewer diagramViewer = mainFrame.getDiagramViewer();
        DiagramView diagramView = diagramViewer.createDiagramView((Diagram) diagram);
        Component[] components = diagramView.getComponents();
        for (Component component : components) {
            if (component instanceof PolylineNode) {
                if (((PolylineNode) component).getPolyline() == polyline) {
                    return (PolylineNode) component;
                }
            }
        }
        return null;
    }

    /**
     * <p>
     * Finds the component corresponding to given graph element.
     * </p>
     *
     * @param graphElement
     *            a graph element for Node or Edge
     * @param diagramView
     *            the diagram view which contains the component
     * @return the found component, null if not found
     */
    public static JComponent getComponent(GraphElement graphElement, DiagramView diagramView) {
        Component[] components = diagramView.getComponents();
        for (Component component : components) {
            if (component instanceof Node) {
                GraphNode graphNode = ((Node) component).getGraphNode();
                if (graphElement == graphNode) {
                    return (JComponent) component;
                }
                if (component instanceof ClassNode) {
                    JComponent subComponent = getComponent(graphElement, (ClassNode) component);
                    if (subComponent != null) {
                        return subComponent;
                    }
                }
            } else if (component instanceof Edge) {
                GraphEdge graphEdge = ((Edge) component).getGraphEdge();
                if (graphElement == graphEdge) {
                    return (JComponent) component;
                }
            }
        }
        return null;
    }

    /**
     * <p>
     * Finds the component corresponding to given graph element.
     * </p>
     *
     * @param graphElement
     *            a graph element for Node or Edge
     * @param classNode
     *            the class node which contains the component
     * @return the found component, null if not found
     */
    public static JComponent getComponent(GraphElement graphElement, ClassNode classNode) {
        Component[] components = classNode.getComponents();
        for (Component component : components) {
            if (component instanceof GroupTextField) {
                Component[] subComponents = ((GroupTextField) component).getComponents();
                for (Component subComponent : subComponents) {
                    if (subComponent instanceof StereotypeTextField) {
                        GraphNode graphNode = ((StereotypeTextField) subComponent).getGraphNode();
                        if (graphElement == graphNode) {
                            return (JComponent) subComponent;
                        }
                    }
                }
            }
        }
        return null;
    }

    /**
     * <p>
     * Finds the graph element which contains the given uml model element in uml model manager.
     * </p>
     *
     * @param modelElement
     *            uml model element
     * @return the graph element which contains the given uml model element, null if not found
     */
    public static List<GraphElement> getGraphElement(ModelElement modelElement) {
        List<GraphElement> graphElements = new ArrayList<GraphElement>();
        GraphElement graphElement;
        for (Diagram diagram : UMLModelManager.getInstance().getDiagrams()) {
            if ((graphElement = getGraphElement(modelElement, diagram)) != null) {
                graphElements.add(graphElement);
            }
        }
        return graphElements;
    }

    /**
     * <p>
     * Finds the graph element which contains the given uml model element in container.
     * </p>
     *
     * @param modelElement
     *            uml model element
     * @param container
     *            the container
     * @return the graph element which contains the given uml model element, null if not found
     */
    public static GraphElement getGraphElement(ModelElement modelElement, GraphElement container) {
        for (DiagramElement diagramElement : container.getContaineds()) {
            if (diagramElement instanceof GraphElement) {
                if ((((GraphElement) diagramElement).getSemanticModel() instanceof Uml1SemanticModelBridge)
                        && (DeployHelper.getElement((GraphElement) diagramElement) == modelElement)) {
                    return (GraphElement) diagramElement;
                } else {
                    GraphElement element;
                    if ((element = getGraphElement(modelElement, (GraphElement) diagramElement)) != null) {
                        return element;
                    }
                }
            }
        }
        return null;
    }

    /**
     * <p>
     * Gets the diagram which contains the given graph element.
     * </p>
     *
     * @param graphElement
     *            a GraphElement whose owner diagram should be found
     * @return the diagram which contains the given graph element
     */
    public static Diagram getDiagram(DiagramElement graphElement) {
        if (graphElement instanceof Diagram) {
            return (Diagram) graphElement;
        }
        DiagramElement container = graphElement;
        while (!((container = container.getContainer()) instanceof Diagram))
            ;
        return (Diagram) container;
    }

    /**
     * <p>
     * Gets the DiagramType of the <code>Diagram</code>.
     * </p>
     *
     * @param diagram
     *            the <code>Diagram</code> which DiagramType should be set
     * @return the DiagramType of the <code>Diagram</code> or null if can not judge diagram type
     */
    public static DiagramType getDiagramType(Diagram diagram) {
        String typeName = getTypeInfo(diagram);
        for (int i = 0; i < DIAGRAM_TYPEINFO.length; i++) {
            if (DIAGRAM_TYPEINFO[i].equals(typeName)) {
                return DIAGRAM_TYPE[i];
            }
        }
        return null;
    }

    /**
     * <p>
     * Gets the diagram which contains the given uml model element.
     * </p>
     *
     * @param modelElement
     *            uml model element
     * @return the diagram which contains the given uml model element
     */
    public static List<Diagram> getDiagram(ModelElement modelElement) {
        List<Diagram> diagrams = new ArrayList<Diagram>();
        List<GraphElement> graphElements = getGraphElement(modelElement);
        for (GraphElement graphElement : graphElements) {
            diagrams.add(getDiagram(graphElement));
        }
        return diagrams;
    }

    /**
     * <p>
     * Creates a corresponding RemoveNodeAction for specified Node.
     * </p>
     *
     * @param node
     *            node to be removed
     * @param mainFrame
     *            main frame window
     * @param isComplete
     *            whether it is delete complete or only delete representation
     * @return a corresponding RemoveNodeAction for specified Node
     */
    public static RemoveNodeAction createRemoveNodeAction(Node node, MainFrame mainFrame, boolean isComplete) {
        RemoveNodeAction action = null;
        if (node instanceof ActorNode) {
            action = new RemoveActorNodeAction(mainFrame, (ActorNode) node, isComplete);
        } else if (node instanceof UseCaseNode) {
            action = new RemoveUseCaseNodeAction(mainFrame, (UseCaseNode) node, isComplete);
        } else if (node instanceof SubsystemNodeContainer) {
            action = new RemoveSubsystemNodeContainerAction(mainFrame, (SubsystemNodeContainer) node, isComplete);
        } else if (node instanceof AcceptEventAction) {
            action = new RemoveAcceptEventActionAction(mainFrame, (AcceptEventAction) node, isComplete);
        } else if (node instanceof ActionState) {
            action = new RemoveActionStateAction(mainFrame, (ActionState) node, isComplete);
        } else if (node instanceof DecisionNode) {
            action = new RemoveDecisionNodeAction(mainFrame, (DecisionNode) node, isComplete);
        } else if (node instanceof FinalNode) {
            action = new RemoveFinalNodeAction(mainFrame, (FinalNode) node, isComplete);
        } else if (node instanceof FlowFinalNode) {
            action = new RemoveFlowFinalNodeAction(mainFrame, (FlowFinalNode) node, isComplete);
        } else if (node instanceof ForkNode) {
            action = new RemoveForkNodeAction(mainFrame, (ForkNode) node, isComplete);
        } else if (node instanceof InitialNode) {
            action = new RemoveInitialNodeAction(mainFrame, (InitialNode) node, isComplete);
        } else if (node instanceof JoinNode) {
            action = new RemoveJoinNodeAction(mainFrame, (JoinNode) node, isComplete);
        } else if (node instanceof MergeNode) {
            action = new RemoveMergeNodeAction(mainFrame, (MergeNode) node, isComplete);
        } else if (node instanceof ObjectFlowNode) {
            action = new RemoveObjectFlowNodeAction(mainFrame, (ObjectFlowNode) node, isComplete);
        } else if (node instanceof SendSignalAction) {
            action = new RemoveSendSignalActionAction(mainFrame, (SendSignalAction) node, isComplete);
        } else if (node instanceof CommentNode) {
            action = new RemoveCommentNodeAction(mainFrame, (CommentNode) node, isComplete);
        } else if (node instanceof FreeTextNode) {
            action = new RemoveFreeTextNodeAction(mainFrame, (FreeTextNode) node);
        } else if (node instanceof PolylineNode) {
            action = new RemovePolylineAction(mainFrame, (PolylineNode) node);
        } else if (node instanceof PackageNode) {
            action = new RemovePackageNodeAction(mainFrame, (PackageNode) node, isComplete);
        } else if (node instanceof InterfaceNode) {
            action = new RemoveInterfaceNodeAction(mainFrame, (InterfaceNode) node, isComplete);
        } else if (node instanceof ClassNode) {
            action = new RemoveClassNodeAction(mainFrame, (ClassNode) node, isComplete);
        }
        return action;
    }

    /**
     * <p>
     * Creates remove action for given edge.
     * </p>
     *
     * @param mainFrame
     *            main frame window
     * @param edge
     *            edge to be removed
     * @param isComplete
     *            true if delete completely, false if only delete representation
     * @return the remove action created
     */
    public static RemoveEdgeAction createRemoveEdgeAction(MainFrame mainFrame, Edge edge, boolean isComplete) {
        RemoveEdgeAction action = null;
        if (edge instanceof IncludeEdge) {
            action = new RemoveIncludeEdgeAction(mainFrame, (IncludeEdge) edge, isComplete);
        } else if (edge instanceof ExtendEdge) {
            action = new RemoveExtendEdgeAction(mainFrame, (ExtendEdge) edge, isComplete);
        } else if (edge instanceof com.topcoder.gui.diagramviewer.uml.activityelements.Transition) {
            action =
                    new RemoveTransitionAction(mainFrame,
                            (com.topcoder.gui.diagramviewer.uml.activityelements.Transition) edge, isComplete);
        } else if (edge instanceof AssociationEdge) {
            action = new RemoveAssociationEdgeAction(mainFrame, (AssociationEdge) edge, isComplete);
        } else if (edge instanceof GeneralizationEdge) {
            action = new RemoveGeneralizationEdgeAction(mainFrame, (GeneralizationEdge) edge, isComplete);
        } else if (edge instanceof DependencyEdge) {
            action = new RemoveDependencyEdgeAction(mainFrame, (DependencyEdge) edge, isComplete);
        } else if (edge instanceof AbstractionEdge) {
            action = new RemoveAbstractionEdgeAction(mainFrame, (AbstractionEdge) edge, isComplete);
        } else if (edge instanceof CommentLinkEdge) {
            action = new RemoveCommentLinkEdgeAction(mainFrame, (CommentLinkEdge) edge);
        } else if (edge instanceof SequenceEdge) {
            action = new RemoveSequenceEdgeAction(mainFrame, (SequenceEdge) edge, isComplete);
        }
        return action;
    }

    /**
     * <p>
     * Gets the filtered selected nodes of the document tree.
     * </p>
     * <p>
     * Selected nodes that is descendant of other selected nodes are filtered.
     * </P>
     *
     * @param mainFrame
     *            reference to main frame to get the document tree and selected components
     * @return filtered selected object
     */
    public static List<java.lang.Object> getFilteredSelectedNodes(MainFrame mainFrame) {
        Set<java.lang.Object> objects = new HashSet<java.lang.Object>();

        for (Component component : mainFrame.getDiagramViewer().getAllSelectedElements()) {
            // if (component instanceof FreeTextNode || component instanceof CommentLinkEdge
            // || component instanceof PolylineNode || component instanceof StereotypeTextField
            // || component instanceof CommentNode) {
            objects.add(component);
            // }
        }

        DocumentTreeView view = mainFrame.getDocumentTree().getCurrentPanel().getCurrentView();
        TreePath[] paths = view.getTree().getSelectionPaths();
        if (paths == null) {
            return new ArrayList<Object>(objects);
        }

        // filter category nodes
        List<TreePath> filteredPath = new ArrayList<TreePath>();
        for (TreePath path : paths) {
            DefaultMutableTreeNode treeNode = (DefaultMutableTreeNode) path.getLastPathComponent();
            DocumentTreeNode documentNode = (DocumentTreeNode) treeNode.getUserObject();
            if (documentNode.getType() != DocumentTreeNodeType.DIAGRAM_CATEGORY) {
                filteredPath.add(path);
            }
        }

        // filter selected children
        for (TreePath path : filteredPath) {
            boolean legal = true;
            for (TreePath parentPath : filteredPath) {
                if (path != parentPath && parentPath.isDescendant(path)) {
                    legal = false;
                    break;
                }
            }
            if (legal) {
                DefaultMutableTreeNode treeNode = (DefaultMutableTreeNode) path.getLastPathComponent();
                DocumentTreeNode documentNode = (DocumentTreeNode) treeNode.getUserObject();
                java.lang.Object object = (java.lang.Object) documentNode.getNodeObject();
                List<GraphElement> graphElements = new ArrayList<GraphElement>();
                if (object instanceof ModelElement) {
                    for (GraphElement graphElement : getGraphElement((ModelElement) object)) {
                        graphElements.add(graphElement);
                    }

                    if (graphElements.isEmpty() && object instanceof ClassImpl) {
                        // BUGR-148: Classes don't need to be part of a diagram in order to be deleted
                        objects.add(object);
                    }
                } else if (object instanceof GraphElement) {
                    graphElements.add((GraphElement) object);
                }
                for (GraphElement graphElement : graphElements) {
                    if (graphElement instanceof Diagram) {
                        objects.add(graphElement);
                    } else {
                        JComponent component = getComponent(graphElement, mainFrame);
                        if (component != null && !isContainedBySelectedContainer(mainFrame, component)) {
                            object = component;
                            objects.add(object);
                        }
                    }
                }
            }
        }

        return new ArrayList<Object>(objects);
    }

    /**
     * <p>
     * Notifies the node is changed.
     * </p>
     *
     * @param node
     *            the node
     * @param message
     *            the string message
     */
    private static void nodeNotifyChange(Node node, String message) {
        if (node instanceof BaseNode) {
            ((BaseNode) node).notifyGraphNodeChange(message);
        } else if (node instanceof SubsystemNodeContainer) {
            ((SubsystemNodeContainer) node).notifyGraphNodeChange(message);
        } else if (node instanceof ObjectNode) {
            ((ObjectNode) node).notifyGraphNodeChange(message);
        } else if (node instanceof com.topcoder.gui.diagramviewer.uml.activityelements.BaseNode) {
            ((com.topcoder.gui.diagramviewer.uml.activityelements.BaseNode) node).notifyGraphNodeChange(message);
        } else if (node instanceof com.topcoder.gui.diagramviewer.uml.auxiliaryelements.BaseNode) {
            ((com.topcoder.gui.diagramviewer.uml.auxiliaryelements.BaseNode) node).notifyUpdate();
            node.repaint();
        } else if (node instanceof com.topcoder.gui.diagramviewer.uml.classelements.BaseNode) {
            ((com.topcoder.gui.diagramviewer.uml.classelements.BaseNode) node).notifyGraphNodeChange(message);
        } else if (node instanceof PackageNode) {
            ((PackageNode) node).notifyGraphNodeChange(message);
        }
        updateEdges(node);

    }

    /**
     * <p>
     * Updates all connected edges when the position of node is changed
     * </p>
     *
     * @param node
     *            the dragged node
     */
    public static void updateEdges(Node node) {
        Map<Edge, Integer> edgeIndexMap = DeployHelper.getConnectedEdges(node);

        for (Edge edge : edgeIndexMap.keySet()) {
            GraphEdge graphEdge = edge.getGraphEdge();
            GraphNode leftConnectedNode = (GraphNode) graphEdge.getAnchors().get(0).getGraphElement();
            GraphNode rightConnectedNode = (GraphNode) graphEdge.getAnchors().get(1).getGraphElement();
            if (leftConnectedNode == rightConnectedNode) {
                // Self-connected edge
                int xOff, yOff;
                // Special for sequence edge
                if (node instanceof ObjectNode) {
                    Point oldWayPoint = edge.getWayPoints().get(0).getCenter();
                    Connector connector = edge.getLeftConnector();
                    Point newWayPoint = connector.getConnectionPoint(oldWayPoint);
                    xOff = newWayPoint.x - oldWayPoint.x;
                    yOff = newWayPoint.y - oldWayPoint.y;
                } else {
                    // Get right bottom corner of node
                    GraphNode graphNode = node.getGraphNode();
                    Point rightBottomNodeCorner = DeployHelper.getAbsoluteGraphNodePosition(graphNode);
                    rightBottomNodeCorner.x += graphNode.getSize().getWidth();
                    rightBottomNodeCorner.y += graphNode.getSize().getHeight();

                    // Get right bottom corner of edge
                    Point rightBottomEdgeCorner = edge.getWayPoints().get(2).getCenter();

                    // Get the segment length
                    int length =
                            (int) (graphEdge.getWaypoints().get(2).getY() - graphEdge.getWaypoints().get(1).getY());

                    // Compute the offset
                    xOff = rightBottomNodeCorner.x - (rightBottomEdgeCorner.x - length / 2);
                    yOff = rightBottomNodeCorner.y - (rightBottomEdgeCorner.y - length / 2);
                }
                moveEdge(edge, xOff, yOff);
            } else {
                int index = edgeIndexMap.get(edge);
                if (index == 0) {
                    // This edge starts from this node
                    DeployHelper.changeLeftEnding(edge);
                    if (edge.getWayPoints().size() == 2) {
                        DeployHelper.changeRightEnding(edge);
                    }
                } else {
                    // This edge ends at this node
                    DeployHelper.changeRightEnding(edge);
                    if (edge.getWayPoints().size() == 2) {
                        DeployHelper.changeLeftEnding(edge);
                    }
                }
            }
        }
    }

    /**
     * <p>
     * Moves specified edge according to given offset.
     * </p>
     *
     * @param edge
     *            the edge to be moved
     * @param offsetx
     *            the x offset
     * @param offsety
     *            the y offset
     */
    public static void moveEdge(Edge edge, int offsetx, int offsety) {
        Map<TextField, Point> map = new HashMap<TextField, Point>();
        Component[] components = edge.getComponents();
        for (Component component : components) {
            if (component instanceof TextField) {
                map.put((TextField) component, component.getLocation());
            }
        }

        List<com.topcoder.diagraminterchange.Point> newWayPoints =
                new ArrayList<com.topcoder.diagraminterchange.Point>();
        for (com.topcoder.diagraminterchange.Point wayPoint : edge.getGraphEdge().getWaypoints()) {
            com.topcoder.diagraminterchange.Point newPoint = new com.topcoder.diagraminterchange.Point();
            newPoint.setX(wayPoint.getX() + offsetx);
            newPoint.setY(wayPoint.getY() + offsety);
            newWayPoints.add(newPoint);
        }
        UpdateEdgeAction moveEdgeAction =
                new UpdateEdgeAction(edge, edge.getGraphEdge().getWaypoints(), newWayPoints);
        moveEdgeAction.executeAction();
        for (Component component : components) {
            if (component instanceof TextField) {
                Point oldLocation = map.get(component);
                component.setLocation(oldLocation.x + offsetx, oldLocation.y + offsety);
            }
        }
    }

    /**
     * <p>
     * Updates Z order of given node container and its contained nodes.
     * </p>
     *
     * @param nodeContainer
     *            the node container whose Z order needs updating
     */
    public static void updateZOrder(NodeContainer nodeContainer) {
        DiagramView view = (DiagramView) nodeContainer.getParent();
        moveToFront(view, nodeContainer);
        Set<Node> set = DeployHelper.getNodes(nodeContainer);
        for (Node node : set) {
            if (node.getParent() == view) {
                if (node instanceof NodeContainer) {
                    updateZOrder((NodeContainer) node);
                } else {
                    moveToFront(view, node);
                }
            }
        }
    }

    /**
     * <p>
     * Moves given node and its connected edges to the front.
     * </p>
     *
     * @param view
     *            the diagram view containing node and edges
     * @param node
     *            the node to be moved to front
     */
    public static void moveToFront(DiagramView view, Node node) {
        view.setComponentZOrder(node, 0);
        for (Edge edge : DeployHelper.getConnectedEdges(node).keySet()) {
            view.setComponentZOrder(edge, 0);
        }
    }

    /**
     * <p>
     * Moves given node to the front.
     * </p>
     *
     * @param view
     *            the diagram view containing node
     * @param node
     *            the node to be moved to front
     */
    public static void moveNodeToFront(DiagramView view, Node node) {
        DiagramElement diagramElement = null;
        if (node instanceof PolylineNode) {
            diagramElement = ((PolylineNode) node).getPolyline();
        } else {
            diagramElement = node.getGraphNode();
        }
        ChangeZOrderAction changeZOrderAction =
                new ChangeZOrderAction(diagramElement, ChangeZOrderOperationType.TOFRONT);
        try {
            changeZOrderAction.executeAction();
        } catch (ActionExecutionException e) {
            // impossible
        }
        view.setComponentZOrder(node, 0);
    }

    /**
     * <p>
     * Notifies the node is changed. Special for ClassNode.
     * </p>
     *
     * @param node
     *            the node
     * @param message
     *            the string message
     * @param main
     *            frame window
     */
    public static void nodeNotifyChange(Node node, String message, MainFrame mainFrame) {
        nodeNotifyChange(node, message);
        if (node instanceof ClassNode) {
            replaceFeatureHandlers((ClassNode) node, mainFrame);
        }
        if (node instanceof NodeContainer) {
            NodeContainer nodeContainer = (NodeContainer) node;
            Set<Node> set = DeployHelper.getNodes(nodeContainer);
            for (Node contained : set) {
                nodeNotifyChange(contained, message, mainFrame);
            }
        }
    }

    /**
     * <p>
     * Notifies the model element is changed, update all related nodes.
     * </p>
     *
     * @param modelElement
     *            the model element has been changed
     * @param message
     *            the string message
     * @param main
     *            frame window
     */
    public static void notifyModelElementChange(ModelElement modelElement, String message, MainFrame mainFrame) {
        List<JComponent> components = getComponent(modelElement, mainFrame);
        for (JComponent component : components) {
            if (component instanceof Node) {
                nodeNotifyChange((Node) component, message, mainFrame);
            }
        }
    }

    /**
     * <p>
     * Notifies the edge is changed.
     * </p>
     *
     * @param edge
     *            the edge
     */
    public static void edgeNotifyChange(Edge edge) {
        if (edge instanceof BaseEdge) {
            ((BaseEdge) edge).notifyGraphEdgeChange();
        } else if (edge instanceof SequenceEdge) {
            ((SequenceEdge) edge).notifyGraphEdgeChange();
        } else if (edge instanceof Transition) {
            ((Transition) edge).notifyGraphEdgeChange();
        } else if (edge instanceof com.topcoder.gui.diagramviewer.uml.classedges.BaseEdge) {
            try {
                ((com.topcoder.gui.diagramviewer.uml.classedges.BaseEdge) edge).notifyGraphEdgeChange("");
            } catch (com.topcoder.gui.diagramviewer.uml.classedges.IllegalGraphElementException e) {
                logException(e);
                ;
            }
        }
    }

    /**
     * <p>
     * Updates panels according to the diagram view's selection.
     * </p>
     *
     * @param mainFrame
     *            the mainframe
     * @param view
     *            the diagram view
     */
    public static void notifySelectionChanged(MainFrame mainFrame, DiagramView view) {
        DiagramViewer diagramViewer = view.getViewer();
        if (diagramViewer.getAllSelectedElements().size() < 1) {
            diagramViewer.addSelectedElement(view);
        }
        notifySelectionChanged(mainFrame, diagramViewer);
    }

    /**
     * <p>
     * Updates panels according to the diagram view's selection.
     * </p>
     *
     * @param mainFrame
     *            the mainframe
     * @param diagramViewer
     *            the diagram viewer
     */
    public static void notifySelectionChanged(MainFrame mainFrame, DiagramViewer diagramViewer) {
        if (!mainFrame.isExpand())
            mainFrame.setToolPanelLayout(true);
        List<JComponent> selectComponents = diagramViewer.getAllSelectedElements();
        updateDocumentTree(selectComponents, mainFrame);
        updatePropertiesAndDocumentationPanel(selectComponents, mainFrame);
        updateStylePanel(selectComponents, mainFrame);
        if (!mainFrame.isExpand())
            mainFrame.setToolPanelLayout(false);
        // mainFrame.invalidate();
        mainFrame.repaint();
    }

    /**
     * <p>
     * Updates style panel according to the selected components.
     * </p>
     *
     * @param selectComponents
     *            the selected components in the view
     * @param mainFrame
     *            the mainframe
     */
    private static void updateStylePanel(List<JComponent> selectComponents, MainFrame mainFrame) {
        mainFrame.getStylePanel().setVisible(true);
        List<StyleObject> styleObjects = new ArrayList<StyleObject>();
        for (JComponent component : selectComponents) {
            if (component instanceof PolylineNode) {
                styleObjects.add(new PolylineStyleObjectAdapter(((PolylineNode) component).getPolyline()));
            } else if (component instanceof Node) {
                styleObjects.add(new GraphNodeStyleObjectAdapter(((Node) component).getGraphNode()));
            } else if (component instanceof Edge) {
                styleObjects.add(new GraphEdgeStyleObjectAdapter(((Edge) component).getGraphEdge()));
            } else if (component instanceof DiagramView) {
                styleObjects.add(new GraphNodeStyleObjectAdapter(((DiagramView) component).getDiagram()));
            } else if (component instanceof TextField) {
                styleObjects.add(new GraphNodeStyleObjectAdapter(((TextField) component).getGraphNode()));
            }
        }

        mainFrame.getStylePanel().setStyleObjectList(styleObjects);
    }

    /**
     * <p>
     * Updates property panel and documentation panel according to the selected components.
     * </p>
     *
     * @param selectComponents
     *            the selected components in the view
     * @param mainFrame
     *            the mainframe
     */
    private static void updatePropertiesAndDocumentationPanel(List<JComponent> selectComponents,
            MainFrame mainFrame) {
        mainFrame.getPropertiesPanel().setVisible(true);
        mainFrame.getDocumentationPanel().setVisible(true);
        List<ModelElement> modelElements = new ArrayList<ModelElement>();
        for (JComponent component : selectComponents) {
            if (component instanceof Node && !(component instanceof FreeTextNode)
                    && !(component instanceof PolylineNode)) {
                modelElements.add(DeployHelper.getElement(((Node) component).getGraphNode()));
            } else if (component instanceof Edge && !(component instanceof CommentLinkEdge)) {
                modelElements.add(DeployHelper.getElement(((Edge) component).getGraphEdge()));
            } else if (component instanceof DiagramView) {
                mainFrame.getPropertiesPanel().configurePanel(((DiagramView) component).getDiagram());
                mainFrame.getDocumentationPanel().setVisible(false);
                return;
            } else if (component instanceof TextField) {
                modelElements.add(DeployHelper.getElement(((TextField) component).getGraphNode()));
            }
        }
        if (modelElements.size() > 0) {
            mainFrame.getPropertiesPanel().configurePanel(modelElements);
        } else {
            mainFrame.getPropertiesPanel().setVisible(false);
        }
        if (modelElements.size() == 1) {
            notifyDocumentationPanel(mainFrame);
            mainFrame.getDocumentationPanel().setTarget(modelElements.get(0));
        } else {
            mainFrame.getDocumentationPanel().setVisible(false);
        }
    }

    /**
     * <p>
     * Updates document tree panel according to the selected components.
     * </p>
     *
     * @param selectComponents
     *            the selected components in the view
     * @param mainFrame
     *            the mainframe
     */
    private static void updateDocumentTree(List<JComponent> selectComponents, MainFrame mainFrame) {
        DocumentTreeTabbedPane documentTreePanel = mainFrame.getDocumentTree();
        DocumentTreeView documentTreeView = documentTreePanel.getCurrentPanel().getCurrentView();
        DocumentTreeNode[] documentTreeNodes = null;
        if (documentTreeView instanceof DiagramCentricDocumentTreeView) {
            List<GraphElement> graphElements = getGraphElements(selectComponents);
            documentTreeNodes = getDocumentTreeNodes(graphElements, documentTreeView);
        } else {
            List<ModelElement> modelElements = getModelElements(selectComponents);
            documentTreeNodes = getDocumentTreeNodes(documentTreeView, modelElements);
        }
        if (documentTreeNodes != null) {
            documentTreeView.setSelectedTreeNodes(documentTreeNodes);
        } else {
            documentTreeView.getTree().setSelectionPath(null);
        }
    }

    /**
     * <p>
     * Notifies the documentation panel the target will change.
     * </p>
     *
     * @param mainFrame
     *            the mainframe
     */
    public static void notifyDocumentationPanel(MainFrame mainFrame) {
        FocusEvent event = new FocusEvent(mainFrame.getDocTextArea(), FocusEvent.FOCUS_LOST);
        ((DefaultDocumentationEditor) mainFrame.getDocEditor()).focusLost(event);
    }

    /**
     * <p>
     * Changes given edge's left ending. This method will update the way point position, and corresponding edge
     * ending.
     * </p>
     *
     * @param edge
     *            the edge whose left ending needs changing
     */
    public static void changeLeftEnding(Edge edge) {
        GraphEdge graphEdge = edge.getGraphEdge();
        Point oldWayPoint = new Point(edge.getWayPoints().get(0).getCenter());
        Connector connector = edge.getLeftConnector();
        if (connector != null) {
            Point newWayPoint = connector.getConnectionPoint(edge.getWayPoints().get(1).getCenter());
            graphEdge.getWaypoints().get(0).setX(newWayPoint.x);
            graphEdge.getWaypoints().get(0).setY(newWayPoint.y);
            edge.notifyChangeWayPoint(0, oldWayPoint);
        }
    }

    /**
     * <p>
     * Changes given edge's right ending. This method will update the way point position, and corresponding edge
     * ending.
     * </p>
     *
     * @param edge
     *            the edge whose right ending needs changing
     */
    public static void changeRightEnding(Edge edge) {
        GraphEdge graphEdge = edge.getGraphEdge();
        int index = edge.getWayPoints().size() - 1;
        Point oldWayPoint = new Point(edge.getWayPoints().get(index).getCenter());
        Connector connector = edge.getRightConnector();
        if (connector != null) {
            Point newWayPoint = connector.getConnectionPoint(edge.getWayPoints().get(index - 1).getCenter());
            graphEdge.getWaypoints().get(index).setX(newWayPoint.x);
            graphEdge.getWaypoints().get(index).setY(newWayPoint.y);
            edge.notifyChangeWayPoint(index, oldWayPoint);
        }
    }

    /**
     * <p>
     * Updates edge when one of its way points has been changed.
     * </p>
     *
     * @param edge
     *            the edge whose way point has been changed
     * @param mainFrame
     *            frame window
     */
    public static void updateEdgeWayPoint(Edge edge, MainFrame mainFrame) {
        GraphEdge graphEdge = edge.getGraphEdge();
        int index = -1;
        for (int i = 0; i < edge.getWayPoints().size(); i++) {
            Point center = edge.getWayPoints().get(i).getCenter();
            int x = (int) Math.round(graphEdge.getWaypoints().get(i).getX());
            int y = (int) Math.round(graphEdge.getWaypoints().get(i).getY());
            if (!center.equals(new Point(x, y))) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            return;
        }
        if (edge.getWayPoints().size() < graphEdge.getWaypoints().size()) {
            edge.notifyAddWayPoint(index);
            edge.getWayPoints().get(index).addMouseListener(new WayPointMouseHandler(mainFrame));
            if (index == 1) {
                changeLeftEnding(edge);
            }
            if (index == edge.getWayPoints().size() - 2) {
                changeRightEnding(edge);
            }
        } else if (edge.getWayPoints().size() == graphEdge.getWaypoints().size()) {
            Point oldPoint = edge.getWayPoints().get(index).getCenter();
            edge.notifyChangeWayPoint(index, oldPoint);
            if (index == 1) {
                changeLeftEnding(edge);
            }
            if (index == edge.getWayPoints().size() - 2) {
                changeRightEnding(edge);
            }
        } else {
            Point removedPoint = edge.getWayPoints().get(index).getCenter();
            edge.notifyRemoveWayPoint(index, removedPoint);
            if (index == 1) {
                changeLeftEnding(edge);
            }
            if (index == edge.getWayPoints().size() - 1) {
                changeRightEnding(edge);
            }
        }
        edge.notifySelected();
    }

    /**
     * <p>
     * Gets whether a final state is flow final state.
     * </p>
     *
     * @param finalstate
     *            the final state to check
     * @return true if it is flow final state, otherwise false
     */
    public static boolean isFlowFinal(FinalState finalstate) {
        for (TaggedValue taggedValue : finalstate.getTaggedValues()) {
            if (taggedValue.getType().getTagType().equals("FinalNodeType")
                    && taggedValue.getDataValue().equals("FlowFinalNode")) {
                return true;
            }
        }
        return false;
    }

    /**
     * <p>
     * Gets whether a simple state is send signal action.
     * </p>
     *
     * @param simplestate
     *            the final state to check
     * @return true if it is send signal action, otherwise false
     */
    public static boolean isSendSignal(SimpleState simplestate) {
        for (TaggedValue taggedValue : simplestate.getTaggedValues()) {
            if (taggedValue.getType().getTagType().equals("SendSignalAction")
                    && taggedValue.getDataValue().equals("True")) {
                return true;
            }
        }
        return false;
    }

    /**
     * <p>
     * Gets the graph elements according to the selected components.
     * </p>
     *
     * @param selectComponents
     *            the selected components in the view
     * @return the graph elements
     */
    private static List<GraphElement> getGraphElements(List<JComponent> selectComponents) {
        List<GraphElement> graphElements = new ArrayList<GraphElement>();
        for (JComponent component : selectComponents) {
            if (component instanceof Node) {
                graphElements.add(((Node) component).getGraphNode());
            } else if (component instanceof Edge) {
                graphElements.add(((Edge) component).getGraphEdge());
            } else if (component instanceof DiagramView) {
                graphElements.add(((DiagramView) component).getDiagram());
            } else if (component instanceof TextField) {
                graphElements.add(((TextField) component).getGraphNode());
            }
        }
        return graphElements;
    }

    /**
     * <p>
     * Gets the model elements according to the selected components.
     * </p>
     *
     * @param selectComponents
     *            the selected components in the view
     * @return the model elements
     */
    private static List<ModelElement> getModelElements(List<JComponent> selectComponents) {
        List<ModelElement> modelElements = new ArrayList<ModelElement>();
        for (JComponent component : selectComponents) {
            ModelElement modelElement = getElement(component);
            if (modelElement != null) {
                modelElements.add(modelElement);
            }
        }
        return modelElements;
    }

    /**
     * <p>
     * Gets the document tree nodes in the document tree view according to the graph elements.
     * </p>
     *
     * @param graphElements
     *            the graph elements
     * @param documentTreeView
     *            the document tree view
     * @return the document tree nodes
     */
    private static DocumentTreeNode[] getDocumentTreeNodes(List<GraphElement> graphElements,
            DocumentTreeView documentTreeView) {
        List<DocumentTreeNode> documentTreeNodes = new ArrayList<DocumentTreeNode>();
        DocumentTreeNode documentTreeNode;
        for (GraphElement graphElement : graphElements) {
            documentTreeNode = getDocumentTreeNode(graphElement, documentTreeView);
            if (documentTreeNode != null) {
                documentTreeNodes.add(documentTreeNode);
            }
        }
        if (documentTreeNodes.size() > 0) {
            return (DocumentTreeNode[]) documentTreeNodes.toArray(new DocumentTreeNode[0]);
        } else
            return null;
    }

    /**
     * <p>
     * Gets the document tree nodes in the document tree view according to the graph elements.
     * </p>
     *
     * @param documentTreeView
     *            the document tree view
     * @param modelElements
     *            the graph elements
     * @return the document tree nodes
     */
    private static DocumentTreeNode[] getDocumentTreeNodes(DocumentTreeView documentTreeView,
            List<ModelElement> modelElements) {
        List<DocumentTreeNode> documentTreeNodes = new ArrayList<DocumentTreeNode>();
        List<DocumentTreeNode> documentTreeNodeList;
        for (ModelElement modelElement : modelElements) {
            documentTreeNodeList = getDocumentTreeNode(modelElement, documentTreeView);
            for (DocumentTreeNode node : documentTreeNodeList) {
                documentTreeNodes.add(node);
            }
        }
        if (documentTreeNodes.size() > 0) {
            return (DocumentTreeNode[]) documentTreeNodes.toArray(new DocumentTreeNode[0]);
        } else
            return null;
    }

    /**
     * <p>
     * Gets the document tree node in document tree view which is corresponding to the model element.
     * </p>
     *
     * @param modelElement
     *            the model element
     * @param documentTreeView
     *            the document tree view
     * @return the corresponded document tree node
     */
    public static List<DocumentTreeNode> getDocumentTreeNode(ModelElement modelElement,
            DocumentTreeView documentTreeView) {
        List<DocumentTreeNode> nodes = new ArrayList<DocumentTreeNode>();
        JTree jTree = documentTreeView.getTree();
        DefaultMutableTreeNode root = (DefaultMutableTreeNode) jTree.getModel().getRoot();
        java.util.Enumeration<?> df = root.depthFirstEnumeration();
        DocumentTreeNode treeNode = null;
        java.lang.Object treeElement = null;
        while (df.hasMoreElements()) {
            treeNode = (DocumentTreeNode) ((DefaultMutableTreeNode) df.nextElement()).getUserObject();
            treeElement = treeNode.getNodeObject();
            if (treeNode.getType() == DocumentTreeNodeType.MODEL_ELEMENT) {
                if (treeElement == modelElement) {
                    nodes.add(treeNode);
                }
            }
            if (treeNode.getType() == DocumentTreeNodeType.GRAPH_ELEMENT) {
                if (!(treeElement instanceof Diagram)
                        && (DeployHelper.getElement((GraphElement) treeElement) == modelElement)) {
                    nodes.add(treeNode);
                }
            }
        }
        return nodes;
    }

    /**
     * <p>
     * Gets the document tree node in document tree view which is corresponding to the graph element.
     * </p>
     *
     * @param graphElement
     *            the graph element
     * @param documentTreeView
     *            the document tree view
     * @return the corresponded document tree node
     */
    public static DocumentTreeNode getDocumentTreeNode(GraphElement graphElement, DocumentTreeView documentTreeView) {
        JTree jTree = documentTreeView.getTree();
        DefaultMutableTreeNode root = (DefaultMutableTreeNode) jTree.getModel().getRoot();
        java.util.Enumeration df = root.depthFirstEnumeration();
        DocumentTreeNode treeNode = null;
        java.lang.Object treeElement = null;
        ModelElement modelElement = null;
        if (!(graphElement instanceof Diagram)) {
            if (graphElement.getSemanticModel() instanceof Uml1SemanticModelBridge) {
                modelElement = DeployHelper.getElement(graphElement);
            }
        }
        while (df.hasMoreElements()) {
            treeNode = (DocumentTreeNode) ((DefaultMutableTreeNode) df.nextElement()).getUserObject();
            treeElement = treeNode.getNodeObject();
            if (treeNode.getType() == DocumentTreeNodeType.MODEL_ELEMENT) {
                if (treeElement == modelElement) {
                    return treeNode;
                }
            }
            if (treeNode.getType() == DocumentTreeNodeType.GRAPH_ELEMENT) {
                if (treeElement == graphElement) {
                    return treeNode;
                }
            }
        }
        return null;
    }

    /**
     * <p>
     * Gets the connector by node.
     * </p>
     *
     * @param node
     *            the node to get connector
     * @return the connector in node
     */
    public static Connector getConnector(Node node) {
        if (node instanceof BaseNode) {
            return ((BaseNode) node).getConnector();
        } else if (node instanceof SubsystemNodeContainer) {
            return ((SubsystemNodeContainer) node).getConnector();
        } else if (node instanceof ObjectNode) {
            return ((ObjectNode) node).getConnector();
        } else if (node instanceof CommentNode) {
            return ((CommentNode) node).getConnector();
        } else if (node instanceof com.topcoder.gui.diagramviewer.uml.activityelements.BaseNode) {
            return ((com.topcoder.gui.diagramviewer.uml.activityelements.BaseNode) node).getConnector();
        } else if (node instanceof com.topcoder.gui.diagramviewer.uml.classelements.BaseNode) {
            return ((com.topcoder.gui.diagramviewer.uml.classelements.BaseNode) node).getConnector();
        } else if (node instanceof PackageNode) {
            return ((PackageNode) node).getConnector();
        }
        return null;
    }

    /**
     * <p>
     * Creates an use case node by graph node.
     * </p>
     *
     * @param mainFrame
     *            reference to main frame
     * @param graphNode
     *            the graph node to create component
     * @return the created component
     */
    public static UseCaseNode createUsecaseNode(MainFrame mainFrame, GraphNode graphNode) {
        Map<String, String> properties = DeployHelper.createProperties();
        UseCaseNode node = new UseCaseNode(graphNode, properties);
        DeployHelper.replaceTextHandlers(node.getNameCompartment());
        DeployHelper.replaceTextHandlers(node.getStereotypeCompartment());
        DeployHelper.replaceTextHandlers(node.getNamespaceCompartment());
        node.getNameCompartment().addTextChangeListener(new UsecaseNameChangedHandler(mainFrame));
        DeployHelper.addNodeHandlers(node, mainFrame);
        return node;
    }

    /**
     * <p>
     * Creates an actor node by graph node.
     * </p>
     *
     * @param mainFrame
     *            reference to main frame
     * @param graphNode
     *            the graph node to create component
     * @return the created component
     */
    public static ActorNode createActorNode(MainFrame mainFrame, GraphNode graphNode) {
        Map<String, String> properties = DeployHelper.createProperties();
        ActorNode node = new ActorNode(graphNode, properties);
        DeployHelper.replaceTextHandlers(node.getNameCompartment());
        DeployHelper.replaceTextHandlers(node.getStereotypeCompartment());
        DeployHelper.replaceTextHandlers(node.getNamespaceCompartment());
        node.getNameCompartment().addTextChangeListener(new UsecaseNameChangedHandler(mainFrame));
        DeployHelper.addNodeHandlers(node, mainFrame);
        return node;
    }

    /**
     * <p>
     * Creates a subsystem node by graph node.
     * </p>
     *
     * @param mainFrame
     *            reference to main frame
     * @param graphNode
     *            the graph node to create component
     * @return the created component
     */
    public static SubsystemNodeContainer createSubsystemNode(MainFrame mainFrame, GraphNode graphNode) {
        Map<String, String> properties = DeployHelper.createProperties();
        SubsystemNodeContainer node = new SubsystemNodeContainer(graphNode, properties, new TransferHandler(null));
        DeployHelper.replaceTextHandlers(node.getNameCompartment());
        DeployHelper.replaceTextHandlers(node.getStereotypeCompartment());
        DeployHelper.replaceTextHandlers(node.getNamespaceCompartment());
        node.getNameCompartment().addTextChangeListener(new UsecaseNameChangedHandler(mainFrame));
        DeployHelper.addNodeHandlers(node, mainFrame);
        return node;
    }

    /**
     * <p>
     * Creates an accept event action node by graph node.
     * </p>
     *
     * @param mainFrame
     *            reference to main frame
     * @param graphNode
     *            the graph node to create component
     * @return the created component
     */
    public static AcceptEventAction createAcceptEventActionNode(MainFrame mainFrame, GraphNode graphNode) {
        Map<String, String> properties = DeployHelper.createProperties();
        AcceptEventAction node = new AcceptEventAction(graphNode, properties, new Point(), new Rectangle());
        DeployHelper.replaceTextHandlers(node.getNameCompartment());
        DeployHelper.replaceTextHandlers(node.getStereotypeCompartment());
        node.getNameCompartment().addTextChangedListener(new ActivityNameChangedHandler(mainFrame));
        node.addBoundaryChangedListener(new ActivityBoundChangedHandler());
        DeployHelper.addNodeHandlers(node, mainFrame);
        return node;
    }

    /**
     * <p>
     * Creates an action state node by graph node.
     * </p>
     *
     * @param mainFrame
     *            reference to main frame
     * @param graphNode
     *            the graph node to create component
     * @return the created component
     */
    public static ActionState createActionStateNode(MainFrame mainFrame, GraphNode graphNode) {
        Map<String, String> properties = DeployHelper.createProperties();
        ActionState node = new ActionState(graphNode, properties, new Point(), new Rectangle());
        DeployHelper.replaceTextHandlers(node.getNameCompartment());
        DeployHelper.replaceTextHandlers(node.getStereotypeCompartment());
        node.getNameCompartment().addTextChangedListener(new ActivityNameChangedHandler(mainFrame));
        node.addBoundaryChangedListener(new ActivityBoundChangedHandler());
        DeployHelper.addNodeHandlers(node, mainFrame);
        return node;
    }

    /**
     * <p>
     * Creates a decision node by graph node.
     * </p>
     *
     * @param mainFrame
     *            reference to main frame
     * @param graphNode
     *            the graph node to create component
     * @return the created component
     */
    public static DecisionNode createDecisionNode(MainFrame mainFrame, GraphNode graphNode) {
        Map<String, String> properties = DeployHelper.createProperties();
        DecisionNode node = new DecisionNode(graphNode, properties, new Point(), new Rectangle());
        DeployHelper.replaceTextHandlers(node.getNameCompartment());
        DeployHelper.replaceTextHandlers(node.getStereotypeCompartment());
        node.getNameCompartment().addTextChangedListener(new ActivityNameChangedHandler(mainFrame));
        node.addBoundaryChangedListener(new ActivityBoundChangedHandler());
        DeployHelper.addNodeHandlers(node, mainFrame);
        return node;
    }

    /**
     * <p>
     * Creates a final node by graph node.
     * </p>
     *
     * @param mainFrame
     *            reference to main frame
     * @param graphNode
     *            the graph node to create component
     * @return the created component
     */
    public static FinalNode createFinalNode(MainFrame mainFrame, GraphNode graphNode) {
        Map<String, String> properties = DeployHelper.createProperties();
        FinalNode node = new FinalNode(graphNode, properties, new Point(), new Rectangle());
        DeployHelper.replaceTextHandlers(node.getNameCompartment());
        DeployHelper.replaceTextHandlers(node.getStereotypeCompartment());
        node.getNameCompartment().addTextChangedListener(new ActivityNameChangedHandler(mainFrame));
        node.addBoundaryChangedListener(new ActivityBoundChangedHandler());
        DeployHelper.addNodeHandlers(node, mainFrame);
        return node;
    }

    /**
     * <p>
     * Creates a flow final node by graph node.
     * </p>
     *
     * @param mainFrame
     *            reference to main frame
     * @param graphNode
     *            the graph node to create component
     * @return the created component
     */
    public static FlowFinalNode createFlowFinalNode(MainFrame mainFrame, GraphNode graphNode) {
        Map<String, String> properties = DeployHelper.createProperties();
        FlowFinalNode node = new FlowFinalNode(graphNode, properties, new Point(), new Rectangle());
        DeployHelper.replaceTextHandlers(node.getNameCompartment());
        DeployHelper.replaceTextHandlers(node.getStereotypeCompartment());
        node.getNameCompartment().addTextChangedListener(new ActivityNameChangedHandler(mainFrame));
        node.addBoundaryChangedListener(new ActivityBoundChangedHandler());
        DeployHelper.addNodeHandlers(node, mainFrame);
        return node;
    }

    /**
     * <p>
     * Creates a fork node by graph node.
     * </p>
     *
     * @param mainFrame
     *            reference to main frame
     * @param graphNode
     *            the graph node to create component
     * @return the created component
     */
    public static ForkNode createForkNode(MainFrame mainFrame, GraphNode graphNode) {
        Map<String, String> properties = DeployHelper.createProperties();
        ForkNode node = new ForkNode(graphNode, properties, new Point(), new Rectangle());
        DeployHelper.replaceTextHandlers(node.getNameCompartment());
        DeployHelper.replaceTextHandlers(node.getStereotypeCompartment());
        node.getNameCompartment().addTextChangedListener(new ActivityNameChangedHandler(mainFrame));
        node.addBoundaryChangedListener(new ActivityBoundChangedHandler());
        DeployHelper.addNodeHandlers(node, mainFrame);
        return node;
    }

    /**
     * <p>
     * Creates an initial node by graph node.
     * </p>
     *
     * @param mainFrame
     *            reference to main frame
     * @param graphNode
     *            the graph node to create component
     * @return the created component
     */
    public static InitialNode createInitialNode(MainFrame mainFrame, GraphNode graphNode) {
        Map<String, String> properties = DeployHelper.createProperties();
        InitialNode node = new InitialNode(graphNode, properties, new Point(), new Rectangle());
        DeployHelper.replaceTextHandlers(node.getNameCompartment());
        DeployHelper.replaceTextHandlers(node.getStereotypeCompartment());
        node.getNameCompartment().addTextChangedListener(new ActivityNameChangedHandler(mainFrame));
        node.addBoundaryChangedListener(new ActivityBoundChangedHandler());
        DeployHelper.addNodeHandlers(node, mainFrame);
        return node;
    }

    /**
     * <p>
     * Creates a join node by graph node.
     * </p>
     *
     * @param mainFrame
     *            reference to main frame
     * @param graphNode
     *            the graph node to create component
     * @return the created component
     */
    public static JoinNode createJoinNode(MainFrame mainFrame, GraphNode graphNode) {
        Map<String, String> properties = DeployHelper.createProperties();
        JoinNode node = new JoinNode(graphNode, properties, new Point(), new Rectangle());
        DeployHelper.replaceTextHandlers(node.getNameCompartment());
        DeployHelper.replaceTextHandlers(node.getStereotypeCompartment());
        node.getNameCompartment().addTextChangedListener(new ActivityNameChangedHandler(mainFrame));
        node.addBoundaryChangedListener(new ActivityBoundChangedHandler());
        DeployHelper.addNodeHandlers(node, mainFrame);
        return node;
    }

    /**
     * <p>
     * Creates a merge node by graph node.
     * </p>
     *
     * @param mainFrame
     *            reference to main frame
     * @param graphNode
     *            the graph node to create component
     * @return the created component
     */
    public static MergeNode createMergeNode(MainFrame mainFrame, GraphNode graphNode) {
        Map<String, String> properties = DeployHelper.createProperties();
        MergeNode node = new MergeNode(graphNode, properties, new Point(), new Rectangle());
        DeployHelper.replaceTextHandlers(node.getNameCompartment());
        DeployHelper.replaceTextHandlers(node.getStereotypeCompartment());
        node.getNameCompartment().addTextChangedListener(new ActivityNameChangedHandler(mainFrame));
        node.addBoundaryChangedListener(new ActivityBoundChangedHandler());
        DeployHelper.addNodeHandlers(node, mainFrame);
        return node;
    }

    /**
     * <p>
     * Creates a object flow node by graph node.
     * </p>
     *
     * @param mainFrame
     *            reference to main frame
     * @param graphNode
     *            the graph node to create component
     * @return the created component
     */
    public static ObjectFlowNode createObjectFlowNode(MainFrame mainFrame, GraphNode graphNode) {
        Map<String, String> properties = DeployHelper.createProperties();
        ObjectFlowNode node = new ObjectFlowNode(graphNode, properties, new Point(), new Rectangle());
        DeployHelper.replaceTextHandlers(node.getNameCompartment());
        DeployHelper.replaceTextHandlers(node.getStereotypeCompartment());
        node.getNameCompartment().addTextChangedListener(new ActivityNameChangedHandler(mainFrame));
        node.addBoundaryChangedListener(new ActivityBoundChangedHandler());
        DeployHelper.addNodeHandlers(node, mainFrame);
        return node;
    }

    /**
     * <p>
     * Creates a send signal action node by graph node.
     * </p>
     *
     * @param mainFrame
     *            reference to main frame
     * @param graphNode
     *            the graph node to create component
     * @return the created component
     */
    public static SendSignalAction createSendSignalActionNode(MainFrame mainFrame, GraphNode graphNode) {
        Map<String, String> properties = DeployHelper.createProperties();
        SendSignalAction node = new SendSignalAction(graphNode, properties, new Point(), new Rectangle());
        DeployHelper.replaceTextHandlers(node.getNameCompartment());
        DeployHelper.replaceTextHandlers(node.getStereotypeCompartment());
        node.getNameCompartment().addTextChangedListener(new ActivityNameChangedHandler(mainFrame));
        node.addBoundaryChangedListener(new ActivityBoundChangedHandler());
        DeployHelper.addNodeHandlers(node, mainFrame);
        return node;
    }

    /**
     * <p>
     * Creates an association edge by graph edge.
     * </p>
     *
     * @param mainFrame
     *            reference to main frame
     * @param diagramView
     *            reference to diagram view
     * @param graphEdge
     *            the graph edge to create component
     * @return the created component
     */
    public static AssociationEdge createAssociationEdge(MainFrame mainFrame, DiagramView diagramView,
            GraphEdge graphEdge) {
        AssociationEdge edge = null;
        try {
            edge = new AssociationEdge(graphEdge);
            edge.setProperties(DeployHelper.createProperties());
            edge.notifyPropertiesChange();

            // Edge's size is the same as the DiagramView
            edge.setSize(diagramView.getSize());
            edge.getNameCompartment().addTextChangeListener(new ClassEdgeNameChangedHandler(mainFrame));
            DeployHelper.addEdgeHandlers(edge, mainFrame);
        } catch (com.topcoder.gui.diagramviewer.uml.classedges.IllegalGraphElementException e) {
            DeployHelper.handleException(mainFrame, e, "Create association edge failed. ");
        }
        return edge;
    }

    /**
     * <p>
     * Creates a dependency edge by graph edge.
     * </p>
     *
     * @param mainFrame
     *            reference to main frame
     * @param diagramView
     *            reference to diagram view
     * @param graphEdge
     *            the graph edge to create component
     * @return the created component
     */
    public static DependencyEdge createDependencyEdge(MainFrame mainFrame, DiagramView diagramView,
            GraphEdge graphEdge) {
        DependencyEdge edge = null;
        try {
            edge = new DependencyEdge(graphEdge);
            edge.setProperties(DeployHelper.createProperties());
            edge.notifyPropertiesChange();

            // Edge's size is the same as the DiagramView
            edge.setSize(diagramView.getSize());
            edge.getNameCompartment().addTextChangeListener(new ClassEdgeNameChangedHandler(mainFrame));
            DeployHelper.addEdgeHandlers(edge, mainFrame);
        } catch (com.topcoder.gui.diagramviewer.uml.classedges.IllegalGraphElementException e) {
            DeployHelper.handleException(mainFrame, e, "Create dependency edge failed. ");
        }
        return edge;
    }

    /**
     * <p>
     * Creates a generalization edge by graph edge.
     * </p>
     *
     * @param mainFrame
     *            reference to main frame
     * @param diagramView
     *            reference to diagram view
     * @param graphEdge
     *            the graph edge to create component
     * @return the created component
     */
    public static GeneralizationEdge createGeneralizationEdge(MainFrame mainFrame, DiagramView diagramView,
            GraphEdge graphEdge) {
        GeneralizationEdge edge = null;
        try {
            edge = new GeneralizationEdge(graphEdge);
            edge.setProperties(DeployHelper.createProperties());

            // Edge's size is the same as the DiagramView
            edge.setSize(diagramView.getSize());
            edge.getNameCompartment().addTextChangeListener(new ClassEdgeNameChangedHandler(mainFrame));
            DeployHelper.addEdgeHandlers(edge, mainFrame);
        } catch (com.topcoder.gui.diagramviewer.uml.classedges.IllegalGraphElementException e) {
            DeployHelper.handleException(mainFrame, e, "Create generalization edge failed. ");
        }
        return edge;
    }

    /**
     * <p>
     * Creates an abstraction edge by graph edge.
     * </p>
     *
     * @param mainFrame
     *            reference to main frame
     * @param diagramView
     *            reference to diagram view
     * @param graphEdge
     *            the graph edge to create component
     * @return the created component
     */
    public static AbstractionEdge createAbstractionEdge(MainFrame mainFrame, DiagramView diagramView,
            GraphEdge graphEdge) {
        AbstractionEdge edge = null;
        try {
            edge = new AbstractionEdge(graphEdge);
            edge.setProperties(DeployHelper.createProperties());
            edge.notifyPropertiesChange();

            // Edge's size is the same as the DiagramView
            edge.setSize(diagramView.getSize());
            edge.getNameCompartment().addTextChangeListener(new ClassEdgeNameChangedHandler(mainFrame));
            DeployHelper.addEdgeHandlers(edge, mainFrame);
        } catch (com.topcoder.gui.diagramviewer.uml.classedges.IllegalGraphElementException e) {
            DeployHelper.handleException(mainFrame, e, "Create abstraction edge failed. ");
        }
        return edge;
    }

    /**
     * <p>
     * Creates an include edge by graph edge.
     * </p>
     *
     * @param mainFrame
     *            reference to main frame
     * @param diagramView
     *            reference to diagram view
     * @param graphEdge
     *            the graph edge to create component
     * @return the created component
     */
    public static IncludeEdge createIncludeEdge(MainFrame mainFrame, DiagramView diagramView, GraphEdge graphEdge) {
        IncludeEdge edge = null;
        try {
            edge = new IncludeEdge(graphEdge);
            edge.setProperties(DeployHelper.createProperties());
            edge.notifyPropertiesChange();

            // Edge's size is the same as the DiagramView
            edge.setSize(diagramView.getSize());
            edge.getNameCompartment().addTextChangeListener(new UsecaseNameChangedHandler(mainFrame));
            DeployHelper.addEdgeHandlers(edge, mainFrame);
        } catch (IllegalGraphElementException e) {
            DeployHelper.handleException(mainFrame, e, "Fail to create an IncludeEdge.");
        }
        return edge;
    }

    /**
     * <p>
     * Creates an extend edge by graph edge.
     * </p>
     *
     * @param mainFrame
     *            reference to main frame
     * @param diagramView
     *            reference to diagram view
     * @param graphEdge
     *            the graph edge to create component
     * @return the created component
     */
    public static ExtendEdge createExtendEdge(MainFrame mainFrame, DiagramView diagramView, GraphEdge graphEdge) {
        ExtendEdge edge = null;
        try {
            edge = new ExtendEdge(graphEdge);
            edge.setProperties(DeployHelper.createProperties());
            edge.notifyPropertiesChange();

            // Edge's size is the same as the DiagramView
            edge.setSize(diagramView.getSize());
            edge.getNameCompartment().addTextChangeListener(new UsecaseNameChangedHandler(mainFrame));
            DeployHelper.addEdgeHandlers(edge, mainFrame);
        } catch (IllegalGraphElementException e) {
            DeployHelper.handleException(mainFrame, e, "Fail to create an ExtendEdge.");
        }
        return edge;
    }

    /**
     * <p>
     * Creates a transition edge by graph edge.
     * </p>
     *
     * @param mainFrame
     *            reference to main frame
     * @param diagramView
     *            reference to diagram view
     * @param graphEdge
     *            the graph edge to create component
     * @return the created component
     */
    public static Transition createTransitionEdge(MainFrame mainFrame, DiagramView diagramView, GraphEdge graphEdge) {
        Transition edge = null;
        try {
            edge = new Transition(graphEdge);
            edge.setProperties(DeployHelper.createProperties());
            edge.notifyPropertiesChange();

            // Edge's size is the same as the DiagramView
            edge.setSize(diagramView.getSize());
            edge.getNameCompartment().addTextChangedListener(new ActivityNameChangedHandler(mainFrame));
            DeployHelper.addEdgeHandlers(edge, mainFrame);
        } catch (IllegalGraphElementException e) {
            DeployHelper.handleException(mainFrame, e, "Fail to create a Transition.");
        }
        return edge;
    }

    /**
     * <p>
     * Creates a comment node by graph node.
     * </p>
     *
     * @param mainFrame
     *            reference to main frame
     * @param graphNode
     *            the graph node to create component
     * @return the created component
     */
    public static CommentNode createCommentNode(MainFrame mainFrame, GraphNode graphNode) {
        CommentNode node = new CommentNode(graphNode, createPropertyMapping());
        node.addTextChangeListener(new AuxiliaryTextChangedHandler(mainFrame));
        node.addBoundaryChangeListener(new AuxiliaryBoundChangedHandler());
        DeployHelper.addNodeHandlers(node, mainFrame);
        node.notifyUpdate();
        return node;
    }

    /**
     * <p>
     * Creates property mapping for auxiliary elements.
     * </p>
     *
     * @return the property mapping
     */
    private static PropertyMapping createPropertyMapping() {
        PropertyMapping propertyMapping = new PropertyMapping();
        propertyMapping.addPropertyKey("FillColor", "FILL_COLOR");
        propertyMapping.addPropertyKey("StrokeColor", "STROKE_COLOR");
        propertyMapping.addPropertyKey("FontColor", "FONT_COLOR");
        propertyMapping.addPropertyKey("FontFamily", "FONT_FAMILY");
        propertyMapping.addPropertyKey("FontStyle", "FONT_STYLE");
        propertyMapping.addPropertyKey("FontSize", "FONT_SIZE");
        return propertyMapping;
    }

    /**
     * <p>
     * Creates a PolylineNode.
     * </p>
     *
     * @param mainFrame
     *            reference to main frame
     * @param polyline
     *            the poly line to create component
     * @return the created component
     */
    public static PolylineNode createPolylineNode(MainFrame mainFrame, Polyline polyline) {
        PolylineNode node = new PolylineNode(polyline, createPropertyMapping());
        node.addNodeDragListener(new NodeDragHandler(mainFrame));
        node.addMouseListener(new ElementSelectionHandler(mainFrame));
        node.addCornerDragListener(new PolylineCornerDragHandler(mainFrame));
        node.addMouseListener(new PolylineMouseHandler(mainFrame));
        for (SelectionCorner corner : node.getSelectionCorners()) {
            corner.addMouseListener(new PolylineCornerMouseHandler(mainFrame));
        }
        return node;
    }

    /**
     * <p>
     * Creates a free text node by graph node.
     * </p>
     *
     * @param mainFrame
     *            reference to main frame
     * @param graphNode
     *            the graph node to create component
     * @return the created component
     */
    public static FreeTextNode createFreeTextNode(MainFrame mainFrame, GraphNode graphNode) {
        FreeTextNode node = new FreeTextNode(graphNode, createPropertyMapping());
        node.addTextChangeListener(new AuxiliaryTextChangedHandler(mainFrame));
        node.addBoundaryChangeListener(new AuxiliaryBoundChangedHandler());
        DeployHelper.addNodeHandlers(node, mainFrame);
        node.notifyUpdate();
        return node;
    }

    /**
     * <p>
     * Creates a comment link edge by graph edge.
     * </p>
     *
     * @param mainFrame
     *            reference to main frame
     * @param diagramView
     *            reference to diagram view
     * @param graphEdge
     *            the graph edge to create component
     * @return the created component
     */
    public static CommentLinkEdge createCommentLinkEdge(MainFrame mainFrame, DiagramView diagramView,
            GraphEdge graphEdge) {
        CommentLinkEdge edge = null;
        try {
            edge = new CommentLinkEdge(graphEdge);
            edge.setProperties(DeployHelper.createProperties());
            edge.notifyPropertiesChange();

            // Edge's size is the same as the DiagramView
            edge.setSize(diagramView.getSize());
            DeployHelper.addEdgeHandlers(edge, mainFrame);
        } catch (IllegalGraphElementException e) {
            DeployHelper.handleException(mainFrame, e, "Fail to create a CommentLinkEdge.");
        }
        return edge;
    }

    /**
     * <p>
     * Creates an object node by graph node.
     * </p>
     *
     * @param mainFrame
     *            reference to main frame
     * @param graphNode
     *            the graph node to create component
     * @return the created component
     */
    public static ObjectNode createObjectNode(MainFrame mainFrame, GraphNode graphNode) {
        EnumMap<ObjectNodePropertyType, String> propertyNameMapping = createObjectNodePropertyMap();
        Collection<SelectionCornerType> corners = createSelectionCorner();

        ObjectNode objectNode = null;
        Rectangle bound = new Rectangle();
        GraphConnector graphConnector = new GraphConnector();
        try {
            bound.x = SelectionCorner.DEFAULT_RADIUS;
            bound.y = SelectionCorner.DEFAULT_RADIUS;
            objectNode =
                    new ObjectNode((com.topcoder.uml.model.commonbehavior.instances.Object) DeployHelper
                            .getElement(graphNode), graphConnector, graphNode, new Point(0, 0), bound, corners,
                            propertyNameMapping);
            objectNode.setIsNameVisible(true);
            objectNode.setIsStereotypesVisible(false);
            objectNode.addEditNameListener(new ObjectNodeEditNameHandler());
            objectNode.addResizeListener(new ObjectNodeResizeHandler(mainFrame));
            objectNode.addNodeDragListener(new NodeDragHandler(mainFrame));
            objectNode.addMouseListener(new ElementSelectionHandler(mainFrame));
            objectNode.addCornerDragListener(new CornerDragHandler(mainFrame, CornerDragType.HORIZONTAL));
            objectNode.addMouseListener(new NodeMouseHandler(mainFrame));
            for (SelectionCorner corner : objectNode.getSelectionCorners()) {
                corner.addMouseListener(new CornerMouseHandler(mainFrame));
            }
            objectNode.setConnector(new ObjectNodeConnector(objectNode));
            Lifeline lifeline = createLifeline(mainFrame, objectNode);

            objectNode.add(lifeline);
            objectNode.notifyGraphNodeChange("Creating");
        } catch (IllegalGraphElementException e) {
            DeployHelper.handleException(mainFrame, e, "Fail to create an ObjectNode.");
        }
        return objectNode;
    }

    /**
     * <p>
     * Creates a lifeline.
     * </p>
     *
     * @return the created component
     */
    private static Lifeline createLifeline(MainFrame mainFrame, ObjectNode objectNode) {
        GraphEdge graphEdge = new GraphEdge();
        graphEdge.addWaypoint(createPoint(objectNode.getWidth() / 2, objectNode.getHeight()));
        graphEdge.addWaypoint(createPoint(objectNode.getWidth() / 2, objectNode.getHeight()));
        Lifeline lifeline = new Lifeline(graphEdge, createLifelinePropertyMap());
        return lifeline;
    }

    /**
     * <p>
     * Gets the lifeline of specified object node.
     * </p>
     *
     * @param objectNode
     *            the object node to find life line
     * @return the life line found
     */
    public static Lifeline getLifeLine(ObjectNode objectNode) {
        for (Component component : objectNode.getComponents()) {
            if (component instanceof Lifeline) {
                return (Lifeline) component;
            }
        }
        return null;
    }

    /**
     * <p>
     * create life line property name map for life line
     * </p>
     *
     * @return the property name map
     */
    private static EnumMap<LifelinePropertyType, String> createLifelinePropertyMap() {
        EnumMap<LifelinePropertyType, String> propertyNameMapping =
                new EnumMap<LifelinePropertyType, String>(LifelinePropertyType.class);
        propertyNameMapping.put(LifelinePropertyType.BLANK_LENGTH, "BLANK_LENGTH");
        propertyNameMapping.put(LifelinePropertyType.DASH_LENGTH, "DASH_LENGTH");
        propertyNameMapping.put(LifelinePropertyType.LIFELINE_LENGTH, "LIFELINE_LENGTH");
        propertyNameMapping.put(LifelinePropertyType.RENDER_SCHEME, "RENDER_SCHEME");
        propertyNameMapping.put(LifelinePropertyType.SHADOW_COLOR, "SHADOW_COLOR");
        propertyNameMapping.put(LifelinePropertyType.SHADOW_LENGTH, "SHADOW_LENGTH");
        propertyNameMapping.put(LifelinePropertyType.STROKE_COLOR, "STROKE_COLOR");
        return propertyNameMapping;
    }

    /**
     * <p>
     * Creates a sequence edge by graph edge.
     * </p>
     *
     * @param mainFrame
     *            reference to main frame
     * @param diagramView
     *            reference to diagram view
     * @param graphEdge
     *            the graph edge to create component
     * @return the created component
     */
    public static SequenceEdge createSequenceEdge(MainFrame mainFrame, DiagramView diagramView, GraphEdge graphEdge) {
        SequenceEdge edge = null;

        // create a sequence edge
        EnumMap<ConfiguredEdgeEndingPropertyType, String> endingProperties = createSequenceEdgeEndingProperties();
        EnumMap<SequenceEdgePropertyType, String> edgeProperties = createSequenceEdgeProperties();

        Link link = (Link) getElement(graphEdge);
        Stimulus stimulus = link.getStimuli().iterator().next();
        Procedure procedure = stimulus.getDispatchAction();
        if (procedure != null) {
            Action action = procedure.getAction();
            if (action instanceof CallOperationAction) {
                if (((CallOperationAction) action).isAsynchronous()) {
                    edge = new AsynchronousMessageEdge(link, graphEdge, endingProperties, edgeProperties);
                } else {
                    edge = new SynchronousMessageEdge(link, graphEdge, endingProperties, edgeProperties);
                }
            } else if (action instanceof CreateObjectAction) {
                edge = new CreateMessageEdge(link, graphEdge, endingProperties, edgeProperties);
            } else if (action instanceof com.topcoder.uml.model.actions.messagingactions.SendSignalAction) {
                edge = new SendSignalMessageEdge(link, graphEdge, endingProperties, edgeProperties);
            } else if (action == null) {
                edge = new ReturnMessageEdge(link, graphEdge, endingProperties, edgeProperties);
            }
        }

        edge.setProperties(DeployHelper.createProperties());
        edge.notifyPropertiesChange();

        // set the size of the sequence edge
        edge.setSize(diagramView.getSize());
        edge.getNameCompartment().addTextChangedListener(new SequenceEdgeNameChangedHandler(mainFrame));
        // DeployHelper.addEdgeHandlers(edge, mainFrame);
        edge.addEdgeDragListener(new SequenceEdgeDragHandler(mainFrame));
        edge.addMouseListener(new ElementSelectionHandler(mainFrame));
        edge.addMouseListener(new SequenceEdgeMouseHandler(mainFrame));

        return edge;
    }

    public static StereotypeTextField createStereotypeTextField(MainFrame mainFrame, DiagramView diagramView,
            GraphNode graphNode) {
        StereotypeTextField stereotypeTextField = new StereotypeTextField(graphNode);
        return stereotypeTextField;
    }

    /**
     * <p>
     * Creates a package node by graph node.
     * </p>
     *
     * @param mainFrame
     *            reference to main frame
     * @param graphNode
     *            the graph node to create component
     * @return the created component
     */
    public static PackageNode createPackageNode(MainFrame mainFrame, GraphNode graphNode) {
        Map<String, String> properties = DeployHelper.createProperties();
        PackageNode node = new PackageNode(graphNode, properties, new TransferHandler(null));
        DeployHelper.replaceTextHandlers(node.getNameCompartment());
        DeployHelper.replaceTextHandlers(node.getStereotypeCompartment());
        DeployHelper.replaceTextHandlers(node.getNamespaceCompartment());
        node.getNameCompartment().addTextChangedListener(new ClassNameChangedHandler(mainFrame));
        DeployHelper.addNodeHandlers(node, mainFrame);
        return node;
    }

    /**
     * <p>
     * Creates a class node by graph node.
     * </p>
     *
     * @param mainFrame
     *            reference to main frame
     * @param graphNode
     *            the graph node to create component
     * @return the created component
     */
    public static ClassNode createClassNode(MainFrame mainFrame, GraphNode graphNode) {
        Map<String, String> properties = DeployHelper.createProperties();
        ClassNode node = new ClassNode(graphNode, properties);
        replaceTextHandlers(node.getNameCompartment());
        replaceTextHandlers(node.getStereotypeCompartment());
        replaceTextHandlers(node.getNamespaceCompartment());
        replaceFeatureHandlers(node, mainFrame);
        node.getNameCompartment().addTextChangedListener(new ClassNameChangedHandler(mainFrame));
        DeployHelper.addNodeHandlers(node, mainFrame);
        GroupTextField attributesCompartment = node.getAttributesCompartment();
        AttributeCompartmentMouseHandler attributesHandler = new AttributeCompartmentMouseHandler(mainFrame);
        attributesCompartment.addMouseListener(attributesHandler);
        attributesCompartment.addMouseMotionListener(attributesHandler);
        GroupTextField operationsCompartment = node.getOperationsCompartment();
        OperationCompartmentMouseHandler operationsHandler = new OperationCompartmentMouseHandler(mainFrame);
        operationsCompartment.addMouseListener(operationsHandler);
        operationsCompartment.addMouseMotionListener(operationsHandler);
        // BUGR-116
        node.setAttributesOperationsPopup(mainFrame.getPopupMenu());
        return node;
    }

    /**
     * <p>
     * Creates an exception node by graph node.
     * </p>
     *
     * @param mainFrame
     *            reference to main frame
     * @param graphNode
     *            the graph node to create component
     * @return the created component
     */
    public static ExceptionNode createExceptionNode(MainFrame mainFrame, GraphNode graphNode) {
        Map<String, String> properties = DeployHelper.createProperties();
        ExceptionNode node = new ExceptionNode(graphNode, properties);
        replaceTextHandlers(node.getNameCompartment());
        replaceTextHandlers(node.getStereotypeCompartment());
        replaceTextHandlers(node.getNamespaceCompartment());
        replaceFeatureHandlers(node, mainFrame);
        node.getNameCompartment().addTextChangedListener(new ClassNameChangedHandler(mainFrame));
        DeployHelper.addNodeHandlers(node, mainFrame);
        GroupTextField attributesCompartment = node.getAttributesCompartment();
        AttributeCompartmentMouseHandler attributesHandler = new AttributeCompartmentMouseHandler(mainFrame);
        attributesCompartment.addMouseListener(attributesHandler);
        attributesCompartment.addMouseMotionListener(attributesHandler);
        GroupTextField operationsCompartment = node.getOperationsCompartment();
        OperationCompartmentMouseHandler operationsHandler = new OperationCompartmentMouseHandler(mainFrame);
        operationsCompartment.addMouseListener(operationsHandler);
        operationsCompartment.addMouseMotionListener(operationsHandler);
        return node;
    }

    /**
     * <p>
     * Creates an exception node by graph node.
     * </p>
     *
     * @param mainFrame
     *            reference to main frame
     * @param graphNode
     *            the graph node to create component
     * @return the created component
     */
    public static EnumClassNode createEnumClassNode(MainFrame mainFrame, GraphNode graphNode) {
        Map<String, String> properties = DeployHelper.createProperties();
        EnumClassNode node = new EnumClassNode(graphNode, properties);
        replaceTextHandlers(node.getNameCompartment());
        replaceTextHandlers(node.getStereotypeCompartment());
        replaceTextHandlers(node.getNamespaceCompartment());
        replaceFeatureHandlers(node, mainFrame);
        node.getNameCompartment().addTextChangedListener(new ClassNameChangedHandler(mainFrame));
        DeployHelper.addNodeHandlers(node, mainFrame);
        GroupTextField attributesCompartment = node.getAttributesCompartment();
        AttributeCompartmentMouseHandler attributesHandler = new AttributeCompartmentMouseHandler(mainFrame);
        attributesCompartment.addMouseListener(attributesHandler);
        attributesCompartment.addMouseMotionListener(attributesHandler);
        GroupTextField operationsCompartment = node.getOperationsCompartment();
        OperationCompartmentMouseHandler operationsHandler = new OperationCompartmentMouseHandler(mainFrame);
        operationsCompartment.addMouseListener(operationsHandler);
        operationsCompartment.addMouseMotionListener(operationsHandler);
        return node;
    }

    /**
     * <p>
     * Creates an Interface node by graph node.
     * </p>
     *
     * @param mainFrame
     *            reference to main frame
     * @param graphNode
     *            the graph node to create component
     * @return the created component
     */
    public static InterfaceNode createInterfaceNode(MainFrame mainFrame, GraphNode graphNode) {
        Map<String, String> properties = DeployHelper.createProperties();
        InterfaceNode node = new InterfaceNode(graphNode, properties);
        replaceTextHandlers(node.getNameCompartment());
        replaceTextHandlers(node.getStereotypeCompartment());
        replaceTextHandlers(node.getNamespaceCompartment());
        replaceFeatureHandlers(node, mainFrame);
        node.getNameCompartment().addTextChangedListener(new ClassNameChangedHandler(mainFrame));
        DeployHelper.addNodeHandlers(node, mainFrame);
        GroupTextField attributesCompartment = node.getAttributesCompartment();
        AttributeCompartmentMouseHandler attributesHandler = new AttributeCompartmentMouseHandler(mainFrame);
        attributesCompartment.addMouseListener(attributesHandler);
        attributesCompartment.addMouseMotionListener(attributesHandler);
        GroupTextField operationsCompartment = node.getOperationsCompartment();
        OperationCompartmentMouseHandler operationsHandler = new OperationCompartmentMouseHandler(mainFrame);
        operationsCompartment.addMouseListener(operationsHandler);
        operationsCompartment.addMouseMotionListener(operationsHandler);
        return node;
    }

    /**
     * <p>
     * Clears the diagram viwer's selected.
     * </p>
     *
     * @param diagramViewer
     *            the diagram viewer
     */
    public static void clearSelected(DiagramViewer diagramViewer) {
        List<JComponent> selectedElements = new ArrayList<JComponent>(diagramViewer.getAllSelectedElements());
        if (selectedElements.size() == 0)
            return;
        for (JComponent component : selectedElements) {
            diagramViewer.removeSelectedElement(component);
            if (component instanceof Node) {
                ((Node) component).notifyUnselected();
            }
            if (component instanceof Edge) {
                ((Edge) component).notifyUnselected();
            } else if (component instanceof StereotypeTextField) {
                component.setOpaque(false);
                component.repaint();
            }
        }
    }

    /**
     * <p>
     * Calculates a preferred size for the diagram.
     * </p>
     *
     * @param view
     *            the diagram view containing the diagram
     * @return a preferred bound
     */
    public static Rectangle getPreferredBound(DiagramView view) {
        Rectangle bound = new Rectangle();
        DiagramViewer viewer = view.getViewer();
        int viewerGap = viewer.getDiagramViewGap();
        Dimension defaultDiagramSize = new Dimension();
        defaultDiagramSize.width = viewer.getWidth() - viewerGap * 2;
        defaultDiagramSize.height = viewer.getHeight() - viewerGap * 2;
        double width = defaultDiagramSize.width;
        double height = defaultDiagramSize.height;

        Point leftTop = new Point(0, 0);
        Point rightBottom = new Point((int) width, (int) height);

        for (Component component : view.getComponents()) {
            if (component instanceof Node) {
                Point position = component.getLocation();
                Dimension size = component.getSize();

                leftTop.x = Math.min(leftTop.x, position.x);
                leftTop.y = Math.min(leftTop.y, position.y);
                rightBottom.x = Math.max(rightBottom.x, position.x + size.width);
                rightBottom.y = Math.max(rightBottom.y, position.y + size.height);
            } else if (component instanceof Edge) {
                Edge edge = (Edge) component;
                List<com.topcoder.gui.diagramviewer.edges.SelectionCorner> wayPoints = edge.getWayPoints();
                for (com.topcoder.gui.diagramviewer.edges.SelectionCorner corner : wayPoints) {
                    leftTop.x = Math.min(leftTop.x, corner.getCenter().x - corner.getRadius());
                    leftTop.y = Math.min(leftTop.y, corner.getCenter().y - corner.getRadius());
                    rightBottom.x = Math.max(rightBottom.x, corner.getCenter().x + corner.getRadius());
                    rightBottom.y = Math.max(rightBottom.y, corner.getCenter().y + corner.getRadius());
                }
            }
        }
        width = Math.max(width, rightBottom.x - leftTop.x);
        height = Math.max(height, rightBottom.y - leftTop.y);

        bound.setBounds(leftTop.x, leftTop.y, (int) width, (int) height);
        return bound;
    }

    /**
     * <p>
     * Creates a file chooser for export diagrams.
     * </p>
     *
     * @return the created file chooser
     */
    public static JFileChooser createExportFileChooser() {
        JFileChooser f = new JFileChooser();
        FileFilter defaultFilter = new ExtensionFileFilter("GIF Files", ImageExporter.GIF_FORMAT);
        f.removeChoosableFileFilter(f.getFileFilter());
        f.addChoosableFileFilter(new ExtensionFileFilter("BMP Files", ImageExporter.BMP_FORMAT));
        f.addChoosableFileFilter(defaultFilter);
        f.addChoosableFileFilter(new ExtensionFileFilter("JPG Files", ImageExporter.JPEG_FORMAT));
        f.addChoosableFileFilter(new ExtensionFileFilter("PNG Files", ImageExporter.PNG_FORMAT));
        f.addChoosableFileFilter(new ExtensionFileFilter("PNM Files", ImageExporter.PNM_FORMAT));
        f.addChoosableFileFilter(new ExtensionFileFilter("TIFF Files", ImageExporter.TIFF_FORMAT));
        f.setFileFilter(defaultFilter);
        return f;
    }

    /**
     * <p>
     * Export diagram to a image with the given file name and extension.
     * </p>
     *
     * @param mainFrame
     *            reference to main frame
     * @param view
     *            the view to export
     * @param filePath
     *            the path of the image file to export
     * @param fileName
     *            the name of the image file to export
     * @param extension
     *            the extension of the image file to export
     */
    public static void exportToFile(MainFrame mainFrame, DiagramView view, String filePath, String fileName,
            String extension) {
        ImageExporter imageExporter = null;

        // saves and sets grid visibility
        DiagramViewer viewer = view.getViewer();
        boolean isGridVisible = viewer.isBackgroundGridVisible();
        boolean isOpaque = view.isOpaque();
        viewer.setBackgroundGridVisible(false);

        try {
            imageExporter = new ImageExporter();
            DeployHelper.clearSelected(viewer);

            // sets view properties
            view.setOpaque(true);
            view.setBackground(Color.WHITE);

            // exporting
            ExportDiagramToImageAction exportImageAction =
                    new ExportDiagramToImageAction(view, filePath, fileName, extension, imageExporter);
            exportImageAction.execute();
        } catch (ImageExporterConfigurationException e) {
            handleException(mainFrame, e, "Loading configuration file error for Image exporter");
        } catch (ActionExecutionException e) {
            handleException(mainFrame, e, "Error while export image.");
        } finally {
            // recovers view properties and grid visibility
            view.setOpaque(isOpaque);
            viewer.setBackgroundGridVisible(isGridVisible);
        }
    }

    /**
     * <p>
     * Updates the zoom pane containing given diagram view.
     * </p>
     *
     * @param view
     *            the diagram view whose diagram size has been changed
     */
    public static void updateZoomPane(DiagramView view) {
        ZoomPane zoomPane = (ZoomPane) view.getParent();
        if (zoomPane != null) {
            ZoomPanel zoomPanel = (ZoomPanel) zoomPane.getParent().getParent();
            Diagram diagram = view.getDiagram();
            double zoomFactor = diagram.getZoom();

            Dimension preferredSize = view.getSize();
            preferredSize.width = (int) diagram.getSize().getWidth();
            preferredSize.height = (int) diagram.getSize().getHeight();
            preferredSize.width += diagram.getPosition().getX() * 2;
            preferredSize.height += diagram.getPosition().getY() * 2;
            preferredSize.width *= zoomFactor;
            preferredSize.height *= zoomFactor;

            zoomPane.setPreferredSize(new Dimension(preferredSize));
            zoomPane.setSize(new Dimension(preferredSize));

            // FIX: BUGR-87
            zoomPane.bindPopupMenu();

            zoomPanel.setZoomFactor(zoomFactor);
            zoomPanel.getParent().repaint();
        }
    }

    /**
     * <p>
     * Resizes the diagram view according to its diagram.
     * </p>
     *
     * @param view
     *            the diagram view to be resized
     */
    public static void resizeDiagramView(DiagramView view) {
        Diagram diagram = view.getDiagram();
        Dimension size = new Dimension();
        size.width = (int) Math.ceil(diagram.getSize().getWidth());
        size.height = (int) Math.ceil(diagram.getSize().getHeight());
        view.setSize(size);

        // Update all edges' size
        for (Component component : view.getComponents()) {
            if (component instanceof Edge) {
                Edge edge = (Edge) component;
                edge.setSize(size);
            }
        }

        DeployHelper.updateZoomPane(view);
    }

    /**
     * <p>
     * Gets the editable component of a node. In most case, the name compartment text field is returned.
     * </p>
     *
     * @param node
     *            the node to get editable component
     * @return the editable component of a node
     */
    public static Component getEditableComponent(Node node) {
        if (node instanceof BaseNode) {
            return ((BaseNode) node).getNameCompartment();
        }
        if (node instanceof SubsystemNodeContainer) {
            return ((SubsystemNodeContainer) node).getNameCompartment();
        }
        if (node instanceof com.topcoder.gui.diagramviewer.uml.activityelements.BaseNode) {
            return ((com.topcoder.gui.diagramviewer.uml.activityelements.BaseNode) node).getNameCompartment();
        }
        if (node instanceof com.topcoder.gui.diagramviewer.uml.classelements.BaseNode) {
            return ((com.topcoder.gui.diagramviewer.uml.classelements.BaseNode) node).getNameCompartment();
        }
        if (node instanceof PackageNode) {
            return ((PackageNode) node).getNameCompartment();
        }
        if (node instanceof com.topcoder.gui.diagramviewer.uml.auxiliaryelements.BaseNode) {
            return node;
        }
        return null;
    }

    /**
     * <p>
     * Determines whether given graph element is contained by the container.
     * </p>
     *
     * @param graphElement
     *            the graph element to check
     * @param container
     *            the container to check
     * @return true if contained, false otherwise
     */
    private static boolean isContained(GraphElement graphElement, GraphElement container) {
        for (; graphElement != null; graphElement = graphElement.getContainer()) {
            if (graphElement.getContainer() == container) {
                return true;
            }
        }
        return false;
    }

    /**
     * <p>
     * Adds contained edges of given node container to given list.
     * </p>
     *
     * @param nodeContainer
     *            the node container whose contained nodes' connected edges to be added
     * @param baseContainers
     *            the containers one of which all added edges' connected graph nodes should belong to
     * @param containedEdges
     *            the list to store edges
     */
    private static void addContainedEdges(NodeContainer nodeContainer, List<GraphElement> baseContainers,
            List<Edge> containedEdges) {
        Set<Node> set = DeployHelper.getNodes(nodeContainer);
        for (Node node : set) {
            Map<Edge, Integer> edgeIndexMap = getConnectedEdges(node);
            for (Entry<Edge, Integer> entry : edgeIndexMap.entrySet()) {
                Edge edge = entry.getKey();
                if (containedEdges.contains(edge)) {
                    continue;
                }
                GraphEdge graphEdge = edge.getGraphEdge();
                GraphElement graphNode;
                int index = entry.getValue().intValue();
                if (index == 0) {
                    graphNode = graphEdge.getAnchors().get(1).getGraphElement();
                } else {
                    graphNode = graphEdge.getAnchors().get(0).getGraphElement();
                }
                for (GraphElement baseContainer : baseContainers) {
                    if (isContained(graphNode, baseContainer)) {
                        containedEdges.add(edge);
                        break;
                    }
                }
            }
        }
    }

    /**
     * <p>
     * Gets all contained edges of a node container.
     * </p>
     *
     * @param nodeContainer
     *            the node container to get contained edges
     * @return all contained edges
     */
    public static List<Edge> getContainedEdges(NodeContainer nodeContainer) {
        List<Edge> containedEdges = new ArrayList<Edge>();
        List<GraphElement> containers = new ArrayList<GraphElement>();
        containers.add(nodeContainer.getGraphNode());
        addContainedEdges(nodeContainer, containers, containedEdges);
        return containedEdges;
    }

    /**
     * <p>
     * Adds given node to its container defined in the graph node.
     * </p>
     *
     * @param node
     *            node need adding
     * @param main
     *            frame window
     */
    public static void addNodeToContainer(Node node, MainFrame mainFrame) {
        GraphNode graphNode = node.getGraphNode();
        if (!(graphNode.getContainer() instanceof Diagram)) {
            // node container
            JComponent container = DeployHelper.getComponent(graphNode.getContainer().getContainer(), mainFrame);
            if (container instanceof NodeContainer) {
                ((NodeContainer) container).addNode(DeployHelper.BODY_COMPARTMENT, node);
                DeployHelper.updateZOrder((NodeContainer) container);
            }
        }

        DeployHelper.nodeNotifyChange(node, "Node added to container", mainFrame);
    }

    /**
     * <p>
     * Removes given node from its container defined in the graph node.
     * </p>
     *
     * @param node
     *            node need adding
     * @param main
     *            frame window
     */
    public static void removeNodeFromContainer(Node node, MainFrame mainFrame) {
        GraphNode graphNode = node.getGraphNode();
        if (!(graphNode.getContainer() instanceof Diagram)) {
            // node container
            JComponent container = DeployHelper.getComponent(graphNode.getContainer().getContainer(), mainFrame);
            if (container instanceof NodeContainer) {
                ((NodeContainer) container).removeNode(DeployHelper.BODY_COMPARTMENT, node);
            }
        }
        DeployHelper.nodeNotifyChange(node, "Node removed from container", mainFrame);
    }

    /**
     * <p>
     * Parses visibility kind from given feature text.
     * </p>
     *
     * @param text
     *            the text for an attribute or an opeation
     * @return the visibility kind parsed, default to private
     */
    public static VisibilityKind parseVisibilityKind(String text) {
        VisibilityKind visibilityKind;
        String visibilityToken = text.substring(0, 1);
        if (visibilityToken.equals(VB_PUBLIC)) {
            visibilityKind = VisibilityKind.PUBLIC;
        } else if (visibilityToken.equals(VB_PROTECTED)) {
            visibilityKind = VisibilityKind.PROTECTED;
        } else if (visibilityToken.equals(VB_PACKAGE)) {
            visibilityKind = VisibilityKind.PACKAGE;
        } else if (visibilityToken.equals(VB_PRIVATE)) {
            visibilityKind = VisibilityKind.PRIVATE;
        } else {
            visibilityKind = null;
        }
        return visibilityKind;
    }

    /**
     * <p>
     * Adds the classifier to the uml model manager.
     * </p>
     *
     * @param classifier
     *            the classifier
     */
    public static void modelAddClassifier(Classifier classifier) {
        List<Namespace> parentPath = new ArrayList<Namespace>();
        Namespace namespace = classifier.getNamespace();
        UMLModelManager manager = UMLModelManager.getInstance();
        Model root = manager.getModel();
        while ((namespace != null) && (namespace != root)) {
            // while ((namespace != null)) {
            parentPath.add(namespace);
            namespace = namespace.getNamespace();
        }
        Namespace parent, child;
        parent = root;
        for (int i = parentPath.size() - 1; i >= 0; --i) {
            if ((child = modelContainPackage(parent, parentPath.get(i))) != null) {
                parent = child;
            } else {
                for (; i >= 0; --i) {
                    child = new PackageImpl();
                    child.setName(parentPath.get(i).getName());
                    child.setNamespace(parent);
                    parent.addOwnedElement(child);
                    parent = child;
                }
                break;
            }
        }
        parent.addOwnedElement(classifier);
        classifier.setNamespace(parent);
    }

    /**
     * <p>
     * Finds the child namespace in the parent namespace.
     * </p>
     *
     * @param parent
     *            the parent namespace
     * @param child
     *            the child namespace
     * @return the childnamespace in the parent namespace
     */
    private static Namespace modelContainPackage(Namespace parent, Namespace child) {
        for (ModelElement element : parent.getOwnedElements()) {
            if ((element instanceof Namespace) && (element.getName().equals(child.getName()))) {
                return (Namespace) element;
            }
        }
        return null;
    }

    /**
     * <p>
     * Finds the specified type with given name.
     * </p>
     *
     * @param name
     *            name of the specified type
     * @param mainFrame
     *            main frame window
     * @return the found type
     */
    public static Classifier findType(String name, MainFrame mainFrame) {
        Classifier type = findTypeFromModel(name);
        if (type != null) {
            return type;
        }

        // Search the standard namespaces
        type = findTypeFromStandardNamespaces(name);
        if (type == null) {
            type = new ClassImpl();
            type.setName(name);
        }

        DeployHelper.modelAddClassifier(type);
        mainFrame.getDocumentTree().updateTree();

        return type;
    }

    /**
     * <p>
     * Finds the type from model according to given name.
     * </p>
     *
     * @param name
     *            the type's name
     * @return found type
     */
    private static Classifier findTypeFromModel(String name) {
        UMLModelManager manager = UMLModelManager.getInstance();
        List<Namespace> namespaces = new ArrayList<Namespace>();

        for (ModelElement element : manager.getModel().getOwnedElements()) {
            if (element instanceof Namespace) {
                namespaces.add((Namespace) element);
            }
        }

        return findInsideNamespace(name, namespaces);

    }

    /**
     * <p>
     * Finds the type from standard namespaces according to given name.
     * </p>
     *
     * @param name
     *            the type's name
     * @return found type
     */
    private static Classifier findTypeFromStandardNamespaces(String name) {
        UMLModelManager manager = UMLModelManager.getInstance();
        ProjectConfigurationManager configManager = manager.getProjectConfigurationManager();

        String language = manager.getProjectLanguage();

        if (language != null && language.trim().length() != 0) {

            List<Namespace> namespaces = new ArrayList<Namespace>();

            for (Namespace namespace : configManager.getStandardNamespaces(language)) {
                namespaces.add(namespace);
            }

            return findInsideNamespace(name, namespaces);
        }
        return null;
    }

    /**
     * Finds a class with given name from the given list of namespaces.
     *
     * @param name
     *            the given name
     * @param namespaces
     *            the given namespaces
     * @return the class with the same name, null if there is no class with given name
     */
    private static Classifier findInsideNamespace(String name, List<Namespace> namespaces) {
        while (!namespaces.isEmpty()) {
            Namespace namespace = namespaces.get(0);
            if (namespace instanceof Classifier) {

                if (namespace.getName() != null && namespace.getName().equals(name)) {
                    return (Classifier) namespace;
                }

            }

            if (namespace instanceof Package) {
                for (ModelElement temp : ((Package) namespace).getOwnedElements()) {
                    if (temp instanceof Namespace) {
                        namespaces.add((Namespace) temp);
                    }
                }
            }
            namespaces.remove(0);
        }

        return null;

    }

    /**
     * <p>
     * Gets the filtered selected elements. The returned elements usually is used for moving.
     * </p>
     * <p>
     * The elements returned can only be Node or Edge. All selected nodes contained by any other selected node
     * container will be filtered. All selected edges with any of two connected nodes not to be moved will be
     * filtered. All selected edges "contained" by other any selected node container will be filtered.
     * </p>
     *
     * @param mainFrame
     *            main frame window
     * @param view
     *            diagram view which contains result elements
     * @return the filtered selected elements
     */
    public static List<JComponent> getFilteredSelectedElements(MainFrame mainFrame, DiagramView view) {
        DiagramViewer viewer = mainFrame.getDiagramViewer();
        List<JComponent> allSelected = viewer.getAllSelectedElements();
        boolean[] isFiltered = new boolean[allSelected.size()];
        int i = 0;
        for (; i < isFiltered.length; i++) {
            isFiltered[i] = false;
        }
        i = 0;
        for (JComponent component : allSelected) {
            if (component.getParent() != view) {
                isFiltered[i] = true;
            } else if (!(component instanceof Node) && !(component instanceof Edge)) {
                isFiltered[i] = true;
            } else if (component instanceof Node) {
                Node node = (Node) component;
                if (isContainedBySelectedContainer(mainFrame, node)) {
                    isFiltered[i] = true;
                }
            } else {
                Edge edge = (Edge) component;
                if (edge instanceof SequenceEdge) {
                    isFiltered[i] = true;
                } else if (isContainedBySelectedContainer(mainFrame, edge)) {
                    isFiltered[i] = true;
                } else {
                    List<Node> connectedNodes = getConnectedNodes(view, edge);
                    for (Node connectedNode : connectedNodes) {
                        boolean isSlected = viewer.isElementSelected(connectedNode);
                        if (!isSlected) {
                            isSlected = isContainedBySelectedContainer(mainFrame, connectedNode);
                        }
                        if (!isSlected) {
                            isFiltered[i] = true;
                            break;
                        }
                    }
                }
            }
            ++i;
        }
        List<JComponent> filteredElements = new ArrayList<JComponent>();
        i = 0;
        for (JComponent component : allSelected) {
            if (!isFiltered[i]) {
                filteredElements.add(component);
            }
            ++i;
        }
        return filteredElements;
    }

    /**
     * <p>
     * Checks whether given node is contained by any other selected node container.
     * </p>
     *
     * @param mainFrame
     *            main frame window
     * @param node
     *            the node to be checked
     * @return true if contained, false otherwise
     */
    public static boolean isContainedBySelectedContainer(MainFrame mainFrame, Node node) {
        DiagramViewer viewer = mainFrame.getDiagramViewer();
        GraphNode graphNode = node.getGraphNode();
        GraphNode container = (GraphNode) graphNode.getContainer();
        while (container != null && !(container instanceof Diagram)) {
            // The container is not diagram, it must be body compartment, so get the real container
            container = (GraphNode) container.getContainer();
            NodeContainer nodeContainer = (NodeContainer) getComponent(container, mainFrame);
            if (viewer.isElementSelected(nodeContainer)) {
                return true;
            }
            container = (GraphNode) container.getContainer();
        }
        return false;
    }

    /**
     * <p>
     * Checks whether given edge is contained by any other selected node container.
     * </p>
     *
     * @param mainFrame
     *            main frame window
     * @param edge
     *            the edge to be checked
     * @return true if contained, false otherwise
     */
    private static boolean isContainedBySelectedContainer(MainFrame mainFrame, Edge edge) {
        DiagramViewer viewer = mainFrame.getDiagramViewer();
        for (JComponent component : viewer.getAllSelectedElements()) {
            if (component instanceof NodeContainer) {
                NodeContainer nodeContainer = (NodeContainer) component;
                List<Edge> containedEdges = getContainedEdges(nodeContainer);
                if (containedEdges.contains(edge)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * <p>
     * Checks whether given component is contained by any other selected node container.
     * </p>
     *
     * @param mainFrame
     *            main frame window
     * @param component
     *            the component to be checked
     * @return true if contained, false otherwise
     */
    private static boolean isContainedBySelectedContainer(MainFrame mainFrame, JComponent component) {
        if (component instanceof Node) {
            return isContainedBySelectedContainer(mainFrame, (Node) component);
        }
        if (component instanceof Edge) {
            return isContainedBySelectedContainer(mainFrame, (Edge) component);
        }
        return false;
    }

    /**
     * <p>
     * Gets the connected nodes for given edge.
     * </p>
     *
     * @param mainFrame
     *            main frame window
     * @param edge
     *            edge to find its connected nodes
     * @return the connected nodes
     */
    public static List<Node> getConnectedNodes(DiagramView diagramView, Edge edge) {
        List<Node> connectedNodes = new ArrayList<Node>();
        GraphEdge graphEdge = edge.getGraphEdge();
        for (GraphConnector graphConnector : graphEdge.getAnchors()) {
            GraphNode connectedGraphNode = (GraphNode) graphConnector.getGraphElement();
            connectedNodes.add((Node) getComponent(connectedGraphNode, diagramView));
        }
        return connectedNodes;
    }

    /**
     * <p>
     * Layout sequence edges in sequence diagram view.
     * </p>
     *
     * @param mainFrame
     *            reference to main frame
     * @param diagramView
     *            diagram view of sequence diagram
     */
    public static void layoutSequenceEdges(MainFrame mainFrame, DiagramView diagramView) {
        layoutSequenceEdges(mainFrame, diagramView, getSequenceEdges(diagramView));
    }

    /**
     * <p>
     * Layout sequence edges in sequence diagram view.
     * </p>
     *
     * @param mainFrame
     *            reference to main frame
     * @param diagramView
     *            diagram view of sequence diagram
     */
    public static void layoutSequenceEdges(MainFrame mainFrame, DiagramView diagramView, List<SequenceEdge> edges) {
        List<ObjectNode> objectNodes = DeployHelper.getObjectNodes(diagramView);
        for (ObjectNode objectNode : objectNodes) {
            Component[] components = objectNode.getComponents();
            for (Component component : components) {
                if (component instanceof LifelineSegment) {
                    objectNode.remove(component);
                }
            }
        }

        DefaultEdgeLayoutStrategy edgeLayoutStrategy = new DefaultEdgeLayoutStrategy();
        Map<SequenceEdge, ObjectNode[]> edgeNodeMapping = getSequenceEdgeNodeMapping(diagramView, edges);
        List<LifelineSegment> lifelineSegments = null;
        try {
            lifelineSegments = edgeLayoutStrategy.layout(edges, edgeNodeMapping);
        } catch (EdgeLayoutException e) {
            handleException(mainFrame, e, "Layout sequence edges failed. ");
        }

        int maxLength = 0;
        int bottom;
        for (LifelineSegment segment : lifelineSegments) {
            bottom = segment.getY() + segment.getHeight();
            if (bottom > maxLength) {
                maxLength = bottom;
            }
        }

        for (ObjectNode objectNode : objectNodes) {
            Lifeline lifeline = getLifeline(objectNode);
            maxLength =
                    Math.max(
                            (int) lifeline.getGraphEdge().getWaypoints().get(0).getY() + lifeline.getLifelineLength(),
                            maxLength);
            lifeline.setSize(lifeline.getWidth(), maxLength);
            lifeline.getGraphEdge().getWaypoints().get(1).setY(maxLength);
            // adjust lifeline to the last component in object node
            objectNode.remove(lifeline);
            objectNode.add(lifeline);
            nodeNotifyChange(objectNode, "Add SequenceEdge");
        }
    }

    /**
     * <p>
     * Gets all sequence edges in diagram view.
     * </p>
     *
     * @param view
     *            diagram view contains sequence edges
     * @return the list of sequence edges.
     */
    public static List<SequenceEdge> getSequenceEdges(DiagramView view) {
        List<SequenceEdge> edges = new ArrayList<SequenceEdge>();
        Component[] components = view.getComponents();
        for (Component component : components) {
            if (component instanceof SequenceEdge) {
                edges.add((SequenceEdge) component);
            }
        }
        Collections.sort(edges, new SequenceEdgeComparator());
        return edges;
    }

    /**
     * <p>
     * Gets the map of sequence edge and connected object nodes.
     * </p>
     *
     * @param mainFrame
     *            reference to main frame
     * @param edges
     *            sequence edges in diagram view
     * @return the map of sequence edge and connected object nodes
     */
    private static Map<SequenceEdge, ObjectNode[]> getSequenceEdgeNodeMapping(DiagramView diagramView,
            List<SequenceEdge> edges) {
        Map<SequenceEdge, ObjectNode[]> edgeNodeMapping = new HashMap<SequenceEdge, ObjectNode[]>();
        for (SequenceEdge edge : edges) {
            List<Node> connectedNodes = getConnectedNodes(diagramView, edge);
            ObjectNode[] nodes = new ObjectNode[2];
            nodes[0] = (ObjectNode) connectedNodes.get(0);
            nodes[1] = (ObjectNode) connectedNodes.get(1);
            edgeNodeMapping.put(edge, nodes);
        }
        return edgeNodeMapping;
    }

    /**
     * <p>
     * Gets the life line in object node.
     * </p>
     *
     * @param objectNode
     *            the object node to get life line
     * @return the life line in the given object node
     */
    private static Lifeline getLifeline(ObjectNode objectNode) {
        Component[] components = objectNode.getComponents();
        for (Component component : components) {
            if (component instanceof Lifeline) {
                return (Lifeline) component;
            }
        }

        return null;
    }

    /**
     * <p>
     * Selects the node after feature is deleted.
     * </p>
     *
     * @param viewer
     *            the diagram viewer
     * @param the
     *            node to be selected
     */
    public static void selectNode(DiagramViewer viewer, Node node) {
        DeployHelper.clearSelected(viewer);
        viewer.addSelectedElement(node);
        node.notifySelected();
    }

    /**
     * <p>
     * Generates valid output file name for given name. Simply replace special characters with '_'.
     * </p>
     *
     * @param name
     *            original name
     * @return valid output file name
     */
    public static String generateOutputFileName(String name) {
        char[] specialCharacters = {'<', '>', '/', '\\', '|', ':', '"', '?', '*', '.', ' '};

        String fileName = name;
        for (int i = 0; i < specialCharacters.length; i++) {
            fileName = fileName.replace(specialCharacters[i], '_');
        }

        return fileName;
    }

    /**
     * <p>
     * Updates stereotype compartment of specified graph node from its contained model element.
     * </p>
     *
     * @param graphNode
     *            the graph node whose stereotype compartment should be updated
     */
    public static void updateStereotypeCompartment(GraphNode graphNode) {
        ModelElement modelElement = getElement(graphNode);
        GraphNode nameCompartment = (GraphNode) graphNode.getContaineds().get(0);
        GraphNode stereotypeCompartment = (GraphNode) nameCompartment.getContaineds().get(0);

        for (DiagramElement diagramElement : stereotypeCompartment.getContaineds()) {
            GraphElement graphElement = (GraphNode) diagramElement;
            if (graphElement.getSemanticModel() instanceof Uml1SemanticModelBridge) {
                stereotypeCompartment.removeContained(graphElement);
            }
        }

        for (Stereotype stereotype : modelElement.getStereotypes()) {
            int size = stereotypeCompartment.getContaineds().size();
            if (size > 2) {
                // TODO
                // stereotypeCompartment.addContained(size - 2, create)
            }
            stereotypeCompartment.addContained(createGraphElement(stereotype));
        }
    }

    /**
     * <p>
     * Sets the cursor for diagram view. When the diagram is zoomed, set the cursor to its parent(zoom pane).
     * </p>
     *
     * @param view
     *            the diagram view to set cursor
     * @param cursor
     *            the cursor to set
     */
    public static void setViewCursor(DiagramView view, Cursor cursor) {
        if (view.isVisible()) {
            view.setCursor(cursor);
        } else {
            view.getParent().setCursor(cursor);
        }
    }

    /**
     * <p>
     * Reorders the graph node and graph edge in diagrams. To keep GraphConnectors save successfully.
     * </p>
     *
     * @param modelManager
     *            uml model manager contains all diagrams
     */
    public static void reorderGraphNodeEdge(UMLModelManager modelManager) {
        for (Diagram diagram : modelManager.getDiagrams()) {
            for (DiagramElement diagramElement : new ArrayList<DiagramElement>(diagram.getContaineds())) {
                if (diagramElement instanceof GraphEdge) {
                    diagram.removeContained(diagramElement);
                    diagram.addContained(diagramElement);
                }
            }
        }
    }

    /**
     * <p>
     * Gets the tag definition corresponding to the name.
     * </p>
     *
     * @param name
     *            the name
     * @return the tag definition
     */
    public static TagDefinition getTagDefinition(String name) {
        UMLModelManager manager = UMLModelManager.getInstance();
        Model root = manager.getModel();

        // traverse all the model elements owned by the root model
        for (ModelElement modelElement : root.getOwnedElements()) {
            if (modelElement instanceof TagDefinition) {
                if (((TagDefinition) modelElement).getTagType().equals(name)) {
                    return (TagDefinition) modelElement;
                }
            }
        }

        TagDefinition tagDefinition = new TagDefinitionImpl();
        tagDefinition.setTagType(name);
        tagDefinition.setNamespace(root);
        root.addOwnedElement(tagDefinition);
        return tagDefinition;
    }

    /**
     * <p>
     * Logs the exception into file.
     * </p>
     *
     * @param throwable
     *            the exception to log
     */
    public static void logException(Throwable throwable) {
        UMLToolDeploy.logger.log(Level.ERROR, getStackTrace(throwable));
    }

    /**
     * <p>
     * Gets the stack trace message from exception
     * </p>
     *
     * @param throwable
     *            the exception to get stack trace message
     * @return the stack trace message
     */
    private static String getStackTrace(Throwable throwable) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        throwable.printStackTrace(printWriter);
        return stringWriter.toString();
    }

    /**
     * <p>
     * Gets the stereotype according to its name and base class type.
     * </p>
     *
     * @param mainFrame
     *            main frame window
     * @param name
     *            stereotype name
     * @param type
     *            base class of the stereotype
     * @return the found stereotype
     */
    public static Stereotype getStereotype(MainFrame mainFrame, String name, java.lang.Class<?> type) {
        List<Stereotype> stereotypes = mainFrame.getPropertiesPanel().getStereotypes(type);
        for (Stereotype stereotype : stereotypes) {
            if (name.equals(stereotype.getName())) {
                return stereotype;
            }
        }
        return null;
    }

    /**
     * <p>
     * Checks whether namespace parent contains namespace child.
     * </p>
     *
     * @param parent
     *            the namespace to be parent
     * @param child
     *            the namespace to be child
     * @return true if parent contains child, otherwise false
     */
    public static boolean containsNamespace(Namespace parent, Namespace child) {
        for (ModelElement modelElement : parent.getOwnedElements()) {
            if (modelElement == child) {
                return true;
            } else if (modelElement instanceof Namespace) {
                if (containsNamespace((Namespace) modelElement, child)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * <p>
     * Loads a ZUML file while opening project.
     * </p>
     *
     * @param file
     *            the zuml file to load
     * @param modelManager
     *            moel manager instance
     * @param configManager
     *            project config manager
     * @param isXMI
     *            is this is a XMI file
     * @throws XMIReaderConfigException
     *             exception while creating XMI reader
     * @throws XMIReaderParseException
     *             exception while parsing
     * @throws XMIReaderIOException
     *             exception for XMI reader IO operations
     * @throws ProjectConfigurationException
     *             exception while getting project configuration mananger
     * @throws XMIConverterConfigurationException
     *             exception while configuring XMI converter
     */
    public static void loadPoseidonFile(File file, UMLModelManager modelManager,
            ProjectConfigurationManager configManager, boolean isXMI) throws XMIReaderConfigException,
            XMIReaderIOException, XMIReaderParseException, ProjectConfigurationException,
            XMIConverterConfigurationException {
        checkNotNull(file, "file");
        checkNotNull(modelManager, "modelManager");
        checkNotNull(configManager, "configManager");
        if (!file.exists()) {
            throw new IllegalArgumentException("The file passed does not exist");
        }
        if (file.isDirectory()) {
            throw new IllegalArgumentException("The file passed should not be a directory");
        }

        // create a XMI reader
        XMIReader reader = new XMIReader();

        // filter state machine diagram
        reader.addHandler("UML2:StateMachine", new DefaultXMIHandler());

        // filter collaboration diagram
        reader.addHandler("UML:InteractionInstanceSet", new DefaultXMIHandler());
        reader.addHandler("UML2:InteractionConstraint", new DefaultXMIHandler());
        reader.addHandler("UML:Exception", new DefaultXMIHandler());
        reader.addHandler("UML:Argument", new DefaultXMIHandler());
        reader.addHandler("UML2:InputPin", new DefaultXMIHandler());
        reader.addHandler("UML2:OutputPin", new DefaultXMIHandler());
        reader.addHandler("UML2:LiteralUnlimitedNatural", new DefaultXMIHandler());
        reader.addHandler("UML2:LiteralInteger", new DefaultXMIHandler());
        reader.addHandler("UML2:ActivityPartition", new DefaultXMIHandler());
        reader.addHandler("UML:CallEvent", new DefaultXMIHandler());

        XMIConvertersUtil.config(reader);

        // parse the stream and populate the model manager
        if (isXMI) {
            reader.parse(file);
        } else {
            reader.parseZipFile(file.getAbsolutePath());
        }

        // get the created model
        Model model = modelManager.getModel();

        // converts sequence diagrams
        XMISequenceDiagramConverterUtil.convertCollaborationInModel(model);
        XMISequenceDiagramConverterUtil.convertSequenceDiagrams(modelManager.getDiagrams());

        // converts activity diagrams
        ActivityDiagramConversionFacade.convertModel(model);
        ActivityDiagramConversionFacade.convertDiagrams(modelManager.getDiagrams());

        removeUnsupportedDiagrams();

        removeUnsupportedElements(model);

        removeUnsupportedGraphElements();

        recoverCreateStereotype(model);

        removeUnsupportedStereotype(model);

        recoverTagDefinition(model);

        fixNamespace(model);

        Collection<TaggedValue> list = model.getTaggedValues();
        // run through the list of tagged values
        for (TaggedValue element : list) {
            // if there is a value with tag type ProjectLanguage
            if (element.getType() != null && element.getType().getTagType().equals("ProjectLanguage")
                    && element.getDataValue() != null) {
                // set the language to the model manager
                modelManager.setProjectLanguage(element.getDataValue());
                return;
            }
        }
        // if there is no project language present
        // get the default language from the config manager
        String projectLanguage = configManager.getDefaultProjectLanguage();
        TagDefinition tagDefinition = getTagDefinition("ProjectLanguage");
        // create a tagged value with the project language as data and type
        // as tag definition.
        TaggedValue taggedValue = new TaggedValueImpl();
        taggedValue.setDataValue(projectLanguage);
        taggedValue.setType(tagDefinition);
        // add the tagged value to the model manager
        model.addTaggedValue(taggedValue);
        // set the project language
        modelManager.setProjectLanguage(projectLanguage);
    }

    /**
     * <p>
     * Fixes the namespace for element contained in given name space.
     * </p>
     *
     * @param namespace
     *            the elements in this namespace should be fixed
     */
    private static void fixNamespace(Namespace namespace) {
        for (ModelElement modelElement : namespace.getOwnedElements()) {
            if (modelElement.getNamespace() == null) {
                modelElement.setNamespace(namespace);
            }
            if (modelElement instanceof Namespace) {
                fixNamespace((Namespace) modelElement);
            }
        }
    }

    /**
     * <p>
     * Recovers the given graph node to tcuml style.
     * </p>
     *
     * @param graphNode
     *            the graph node to recover
     */
    public static void recoverGraphNode(GraphNode graphNode) {
        SemanticModelBridge semanticModel = graphNode.getSemanticModel();
        if (semanticModel instanceof Uml1SemanticModelBridge) {
            ModelElement modelElement = DeployHelper.getElement(graphNode);
            recoverProperty(graphNode);
            GraphNode tempGraphNode = null;
            if ((modelElement instanceof Actor)) {
                if (graphNode.getContaineds().size() != 3) {
                    tempGraphNode =
                            DeployHelper.createGraphNodeForActor(modelElement, new Point(), new Dimension());
                }
                recoverColor(graphNode, false);
            } else if (modelElement instanceof com.topcoder.uml.model.core.classifiers.Class) {
                if (graphNode.getContaineds().size() > 0
                        && ((GraphElement) graphNode.getContaineds().get(0)).getContaineds().size() != 3) {
                    tempGraphNode =
                            DeployHelper.createGraphNodeForClass(modelElement, new Point(), new Dimension());
                    tempGraphNode.getContaineds().get(2).setVisible(
                            getCompartmentVisibility(graphNode, "AttributeCompartment"));
                    tempGraphNode.getContaineds().get(4).setVisible(
                            getCompartmentVisibility(graphNode, "OperationCompartment"));
                }
                recoverColor(graphNode, false);
            } else if (modelElement instanceof Interface) {
                if (graphNode.getContaineds().size() != 5
                        || (graphNode.getContaineds().size() > 0 && ((GraphElement) graphNode.getContaineds().get(0))
                                .getContaineds().size() != 3)) {
                    tempGraphNode =
                            DeployHelper.createGraphNodeForClass(modelElement, new Point(), new Dimension());
                    tempGraphNode =
                            DeployHelper.createGraphNodeForClass(modelElement, new Point(), new Dimension());
                    tempGraphNode.getContaineds().get(2).setVisible(
                            getCompartmentVisibility(graphNode, "AttributeCompartment"));
                    tempGraphNode.getContaineds().get(4).setVisible(
                            getCompartmentVisibility(graphNode, "OperationCompartment"));
                }
                recoverColor(graphNode, false);
            } else if (modelElement instanceof Package) {
                if (graphNode.getContaineds().size() > 0
                        && ((GraphElement) graphNode.getContaineds().get(0)).getContaineds().size() != 3) {
                    tempGraphNode =
                            DeployHelper.createGraphNodeForPackage(modelElement, new Point(), new Dimension());
                    GraphNode bodyGraphNode = (GraphNode) graphNode.getContaineds().get(1);
                    for (DiagramElement diagramElement : new ArrayList<DiagramElement>(bodyGraphNode
                            .getContaineds())) {
                        if (diagramElement instanceof GraphNode) {
                            GraphNode subNode = (GraphNode) diagramElement;
                            com.topcoder.diagraminterchange.Point point =
                                    new com.topcoder.diagraminterchange.Point();
                            point.setX(subNode.getPosition().getX() + bodyGraphNode.getPosition().getX());
                            point.setY(subNode.getPosition().getY() + bodyGraphNode.getPosition().getY());
                            subNode.setPosition(point);
                            DeployHelper.addContained(tempGraphNode, diagramElement);
                        } else if (diagramElement instanceof GraphEdge) {
                            GraphEdge graphEdge = (GraphEdge) diagramElement;
                            Point absolutePoint = getAbsoluteGraphNodePosition(graphEdge);
                            for (com.topcoder.diagraminterchange.Point point : graphEdge.getWaypoints()) {
                                point.setX(point.getX() + absolutePoint.getX());
                                point.setY(point.getY() + absolutePoint.getY());
                            }
                            for (DiagramElement subDiagramElement : graphEdge.getContaineds()) {
                                GraphNode subGraphNode = (GraphNode) subDiagramElement;
                                com.topcoder.diagraminterchange.Point point = subGraphNode.getPosition();
                                point.setX(point.getX() + absolutePoint.getX());
                                point.setY(point.getY() + absolutePoint.getY());
                            }
                            graphEdge.getPosition().setX(0.0);
                            graphEdge.getPosition().setY(0.0);
                            bodyGraphNode.removeContained(diagramElement);
                            DeployHelper.addContained(DeployHelper.getDiagram(graphNode), diagramElement);
                        }
                    }
                }
                recoverColor(graphNode, false);
            } else if (modelElement instanceof UseCase) {
                if (graphNode.getContaineds().size() != 3) {
                    tempGraphNode =
                            DeployHelper.createGraphNodeForUseCase(modelElement, new Point(), new Dimension());
                }
                recoverColor(graphNode, false);
            } else if (modelElement instanceof SimpleState) {
                tempGraphNode =
                        DeployHelper.createGraphNodeForActivityState(modelElement, new Point(), new Dimension());
                recoverColor(graphNode, false);
            } else if (modelElement instanceof Pseudostate || modelElement instanceof FinalState) {
                tempGraphNode =
                        DeployHelper.createGraphNodeForActivityNode(modelElement, new Point(), new Dimension());
                recoverColor(graphNode, false);
            }

            if (tempGraphNode != null) {
                graphNode.clearContaineds();
                for (DiagramElement diagramElement : tempGraphNode.getContaineds()) {
                    DeployHelper.addContained(graphNode, diagramElement);
                }
            }
        } else if (semanticModel instanceof SimpleSemanticModelElement) {
            if (getTypeInfo(graphNode).equals("FreeText")) {
                recoverProperty(graphNode);
            }
        }
    }

    /**
     * <p>
     * Recovers the given graph edge to tcuml style.
     * </p>
     *
     * @param graphEdge
     *            the graph edge to recover
     */
    public static void recoverGraphEdge(GraphEdge graphEdge) {
        SemanticModelBridge semanticModel = graphEdge.getSemanticModel();
        if (semanticModel instanceof Uml1SemanticModelBridge) {
            recoverProperty(graphEdge);
            ModelElement modelElement = DeployHelper.getElement(graphEdge);
            GraphEdge tempGraphEdge = null;
            if ((modelElement instanceof Generalization) || (modelElement instanceof Abstraction)
                    || (modelElement instanceof Dependency)) {
                if (graphEdge.getContaineds().size() != 2
                        || !getTypeInfo((GraphElement) graphEdge.getContaineds().get(0)).equals("DirectedName")
                        || !getTypeInfo((GraphElement) graphEdge.getContaineds().get(1)).equals(
                                "StereotypeCompartment")) {
                    tempGraphEdge = DeployHelper.createGraphEdgeForClass(modelElement, new ArrayList<Point>());
                }
            } else if (modelElement instanceof Association) {
                if (graphEdge.getContaineds().size() != 4
                        || !getTypeInfo((GraphElement) graphEdge.getContaineds().get(2)).equals("DirectedName")
                        || !getTypeInfo((GraphElement) graphEdge.getContaineds().get(3)).equals(
                                "StereotypeCompartment")) {
                    tempGraphEdge =
                            DeployHelper.createGraphEdgeForAssociation((Association) modelElement,
                                    new ArrayList<Point>(), ((Association) modelElement).getName());
                }
            } else if (modelElement instanceof com.topcoder.uml.model.statemachines.Transition) {
                tempGraphEdge = DeployHelper.createGraphEdgeForTransition(modelElement, new ArrayList<Point>());
            }

            if (tempGraphEdge != null) {
                copyGraphEdgeContaineds(graphEdge, tempGraphEdge);
                graphEdge.clearContaineds();
                for (DiagramElement diagramElement : tempGraphEdge.getContaineds()) {
                    DeployHelper.addContained(graphEdge, diagramElement);
                }
            }
        }

        for (com.topcoder.diagraminterchange.Point point : graphEdge.getWaypoints()) {
            point.setX(point.getX() + graphEdge.getPosition().getX());
            point.setY(point.getY() + graphEdge.getPosition().getY());
        }
        for (DiagramElement subDiagramElement : graphEdge.getContaineds()) {
            GraphNode subGraphNode = (GraphNode) subDiagramElement;
            com.topcoder.diagraminterchange.Point point = subGraphNode.getPosition();
            if (point != null) {
                point.setX(point.getX() + graphEdge.getPosition().getX());
                point.setY(point.getY() + graphEdge.getPosition().getY());
            }
        }

        graphEdge.getPosition().setX(0.0);
        graphEdge.getPosition().setY(0.0);
    }

    /**
     * <p>
     * Recovers the color properties from given diagram element.
     * </p>
     *
     * @param diagramElement
     *            the diagram element containing color properties
     * @param isNeedSharp
     *            whether the color properties start with '#'
     */
    private static void recoverColor(DiagramElement diagramElement, boolean isNeedSharp) {
        for (Property property : diagramElement.getProperties()) {
            if (property.getKey().indexOf("COLOR") >= 0) {
                String value = property.getValue();
                if (!isNeedSharp && value.charAt(0) == '#') {
                    value = value.substring(1);
                    property.setValue(value);
                }
            }
        }
    }

    /**
     * <p>
     * Recovers the properties from given diagram element.
     * </p>
     *
     * @param diagramElement
     *            the diagram element containing properties
     */
    private static void recoverProperty(DiagramElement diagramElement) {
        boolean isHaveFillColor = false;
        boolean isHaveStrokeColor = false;
        boolean isHaveFontFamily = false;
        boolean isHaveFontSize = false;
        for (Property property : diagramElement.getProperties()) {
            if (property.getKey().equals("FONT_SIZE")) {
                String value = property.getValue();
                int dotPos = value.indexOf('.');
                if (dotPos >= 0) {
                    value = value.substring(0, dotPos);
                    property.setValue(value);
                }
                isHaveFontSize = true;
            } else if (property.getKey().equals("FILL_COLOR")) {
                isHaveFillColor = true;
            } else if (property.getKey().equals("STROKE_COLOR")) {
                isHaveStrokeColor = true;
            } else if (property.getKey().equals("FONT_FAMILY")) {
                isHaveFontFamily = true;
            }
        }
        if (!isHaveFillColor && (diagramElement instanceof GraphNode)) {
            ModelElement modelElement = null;
            if (((GraphNode) diagramElement).getSemanticModel() instanceof Uml1SemanticModelBridge) {
                modelElement = getElement((GraphNode) diagramElement);
            }
            if (modelElement instanceof Comment) {
                diagramElement.addProperty(createProperty("FILL_COLOR", "#FFFF00"));
            } else if (modelElement instanceof Pseudostate
                    || (modelElement instanceof FinalState && !isFlowFinal((FinalState) modelElement))) {
                diagramElement.addProperty(createProperty("FILL_COLOR", "#000000"));
            } else {
                diagramElement.addProperty(createProperty("FILL_COLOR", "#FFFFFF"));
            }
        }
        if (!isHaveStrokeColor) {
            diagramElement.addProperty(createProperty("STROKE_COLOR", "#000000"));
        }
        if (!isHaveFontFamily && (diagramElement instanceof GraphEdge)) {
            Diagram diagram = getDiagram(diagramElement);
            String value = "";
            for (Property diagramProperty : diagram.getProperties()) {
                if (diagramProperty.getKey().equals("FONT_FAMILY")) {
                    value = diagramProperty.getValue();
                    break;
                }
            }
            if (value.length() == 0) {
                value = "Arial";
            }
            diagramElement.addProperty(createProperty("FONT_FAMILY", value));
        }
        // FIX : 12338 font family and font size for ReturnMessage
        if (!isHaveFontSize && (diagramElement instanceof GraphEdge)) {
            Diagram diagram = getDiagram(diagramElement);
            String value = "";
            for (Property diagramProperty : diagram.getProperties()) {
                if (diagramProperty.getKey().equals("FONT_SIZE")) {
                    value = diagramProperty.getValue();
                    int dotPos = value.indexOf('.');
                    if (dotPos >= 0) {
                        value = value.substring(0, dotPos);
                    }
                }
            }
            if (value.length() == 0) {
                value = DeployHelper.getProperty("com.topcoder.umltool.deploy", "DiagramFontSize", "10");
            }
            diagramElement.addProperty(createProperty("FONT_SIZE", value));
        }
    }

    /**
     * <p>
     * Recovers the tag definitions from given model.
     * </p>
     *
     * @param model
     *            the model containing tag definitions to recover
     */
    private static void recoverTagDefinition(Model model) {
        // traverse all the model elements owned by the root model
        for (ModelElement modelElement : model.getOwnedElements()) {
            if (modelElement instanceof TagDefinition) {
                TagDefinition tagDefinition = (TagDefinition) modelElement;
                if (tagDefinition.getTagType() == null)
                    tagDefinition.setTagType(tagDefinition.getName());
            }
        }
    }

    /**
     * <p>
     * Recovers the create stereotypes from given model.
     * </p>
     *
     * @param model
     *            the model containing create stereotypes to recover
     */
    public static void recoverCreateStereotype(Model model) {
        // traverse all the model elements owned by the root model
        for (ModelElement modelElement : new ArrayList<ModelElement>(model.getOwnedElements())) {
            if (modelElement instanceof Stereotype) {
                if (modelElement.getName().equals("create")) {
                    Stereotype stereotype = (Stereotype) modelElement;
                    stereotype.setBaseClass("Operation");
                }
            }
        }
    }

    /**
     * <p>
     * Determines whether the given graph node's specified compartment is visible.
     * </p>
     *
     * @param graphNode
     *            the graph node to check
     * @param typeinfo
     *            the type info of specified compartment
     * @return the visibility
     */
    public static boolean getCompartmentVisibility(GraphNode graphNode, String typeinfo) {
        for (DiagramElement diagramElement : graphNode.getContaineds()) {
            if (diagramElement instanceof GraphNode) {
                GraphNode compartmentGraphNode = (GraphNode) diagramElement;
                if (compartmentGraphNode.getSemanticModel() instanceof SimpleSemanticModelElement) {
                    if (DeployHelper.getTypeInfo(compartmentGraphNode).equals(typeinfo)) {
                        return compartmentGraphNode.isVisible();
                    }
                }
            }
        }
        return false;
    }

    /**
     * <p>
     * Copies the graph elements contained from first graph edge to second.
     * </p>
     *
     * @param oldGraphEdge
     *            the old graph edge to copy
     * @param newGraphEdge
     *            the new graph edge to store copied graph elements
     */
    private static void copyGraphEdgeContaineds(GraphEdge oldGraphEdge, GraphEdge newGraphEdge) {
        GraphNode oldNode, newNode;
        String typeinfo, oldTypeinfo;
        int i, j;

        for (i = 0; i < newGraphEdge.getContaineds().size(); ++i) {
            newNode = (GraphNode) newGraphEdge.getContaineds().get(i);
            typeinfo = getTypeInfo(newNode);
            for (DiagramElement diagramElement : oldGraphEdge.getContaineds()) {
                oldNode = (GraphNode) diagramElement;
                oldTypeinfo = getTypeInfo(oldNode);
                if (typeinfo.length() != 0 && oldTypeinfo.length() != 0 && typeinfo.contains(getTypeInfo(oldNode))) {
                    newNode.setPosition(oldNode.getPosition());
                } else if (typeinfo.length() == 0 && getElement(newNode) == getElement(oldNode)) {
                    newNode.setPosition(null);
                    int size = Math.min(newNode.getContaineds().size(), oldNode.getContaineds().size());
                    for (j = 0; j < size; ++j) {
                        GraphNode subNewNode = (GraphNode) newNode.getContaineds().get(j);
                        GraphNode subOldNode = (GraphNode) oldNode.getContaineds().get(j);
                        subOldNode.getPosition().setX(
                                subOldNode.getPosition().getX() + oldNode.getPosition().getX());
                        subOldNode.getPosition().setY(
                                subOldNode.getPosition().getY() + oldNode.getPosition().getY());
                        subNewNode.setPosition(subOldNode.getPosition());
                    }
                }
            }
        }
    }

    /**
     * <p>
     * Removes all unsupported diagrams from model manager.
     * </p>
     */
    private static void removeUnsupportedDiagrams() {
        UMLModelManager modelManager = UMLModelManager.getInstance();
        for (Diagram diagram : modelManager.getDiagrams()) {
            if (diagram.getSemanticModel() instanceof SimpleSemanticModelElement) {
                String typeinfo = ((SimpleSemanticModelElement) diagram.getSemanticModel()).getTypeInfo();
                if (!typeinfo.equals("ClassDiagram") && !typeinfo.equals("SequenceDiagram")
                        && !typeinfo.equals("UseCaseDiagram") && !typeinfo.equals("ActivityDiagram")) {
                    modelManager.removeDiagram(diagram);
                } else {
                    diagram.setZoom(1.0);
                }
            }
        }
    }

    /**
     * <p>
     * Removes all unsupported elements from model.
     * </p>
     */
    private static void removeUnsupportedElements(Model model) {
        for (ModelElement modelElement : new ArrayList<ModelElement>(model.getOwnedElements())) {
            if (modelElement instanceof DeployNode) {
                DeployNode deployNode = (DeployNode) modelElement;
                model.removeOwnedElement(deployNode);
                for (Comment comment : deployNode.getComments()) {
                    model.removeOwnedElement(comment);
                }
            } else if (modelElement instanceof Collaboration) { // FIXME should removed in coverter sd plugin
                Collaboration collaboration = (Collaboration) modelElement;
                for (ModelElement subElement : new ArrayList<ModelElement>(collaboration.getOwnedElements())) {
                    if (subElement instanceof com.topcoder.uml.model.commonbehavior.instances.Object) {
                        com.topcoder.uml.model.commonbehavior.instances.Object object =
                                (com.topcoder.uml.model.commonbehavior.instances.Object) subElement;
                        object.clearOwnedLinks();
                        object.clearLinkEnds();
                    } else if (subElement instanceof Procedure || subElement instanceof Message) {
                        collaboration.removeOwnedElement(subElement);
                    }
                }
            }
        }
    }

    /**
     * <p>
     * Removes all unsupported graph elements from model manager.
     * </p>
     */
    private static void removeUnsupportedGraphElements() {
        UMLModelManager modelManager = UMLModelManager.getInstance();
        for (Diagram diagram : modelManager.getDiagrams()) {
            if (DeployHelper.getTypeInfo(diagram).equals("SequenceDiagram")) {
                for (DiagramElement diagramElement : diagram.getContaineds()) {
                    if (diagramElement instanceof GraphNode
                            && ((GraphNode) diagramElement).getSemanticModel() instanceof Uml1SemanticModelBridge
                            && DeployHelper.getElement((GraphNode) diagramElement) instanceof CombinedFragment) {
                        diagram.removeContained(diagramElement);
                    }
                }
            }
        }
    }

    /**
     * <p>
     * Removes all unsupported stereotypes from given namespace.
     * </p>
     *
     * @param namespace
     *            the namespace to remove unsupported stereotypes
     */
    private static void removeUnsupportedStereotype(Namespace namespace) {
        for (ModelElement modelElement : namespace.getOwnedElements()) {
            if (modelElement instanceof Namespace) {
                removeUnsupportedStereotype((Namespace) modelElement);
            }
            if (modelElement instanceof Stereotype) {
                if (((Stereotype) modelElement).getBaseClass() == null) {
                    namespace.removeOwnedElement(modelElement);
                }
            }
        }

        if (namespace instanceof Classifier) {
            for (Feature feature : ((Classifier) namespace).getFeatures()) {
                for (Stereotype stereotype : new ArrayList<Stereotype>(feature.getStereotypes())) {
                    if (stereotype.getName().contains("gentleware")) {
                        feature.removeStereotype(stereotype);
                    }
                }
            }
        }
    }

    /**
     * <p>
     * Creates a self-connected way points list which will be used to create a graph edge.
     * </p>
     *
     * @param node
     *            the self- connected node
     * @return the created way points list
     */
    public static List<Point> createSelfConnectedWayPoints(Node node) {
        List<Point> wayPoints = new ArrayList<Point>();

        GraphNode graphNode = node.getGraphNode();
        Point position = DeployHelper.getAbsoluteGraphNodePosition(graphNode);
        position.x += graphNode.getSize().getWidth();
        position.y += graphNode.getSize().getHeight();

        // Create three mid way points
        wayPoints.add(new Point(position.x + SEGMENT_LENGTH / 2, position.y - SEGMENT_LENGTH / 2));
        wayPoints.add(new Point(position.x + SEGMENT_LENGTH / 2, position.y + SEGMENT_LENGTH / 2));
        wayPoints.add(new Point(position.x - SEGMENT_LENGTH / 2, position.y + SEGMENT_LENGTH / 2));

        Connector connector = DeployHelper.getConnector(node);
        Point start = connector.getConnectionPoint(wayPoints.get(0));
        Point end = connector.getConnectionPoint(wayPoints.get(2));

        wayPoints.add(0, start);
        wayPoints.add(end);

        return wayPoints;
    }

    /**
     * <p>
     * Gets the nodes from body compartment of given node container.
     * </p>
     *
     * @param container
     *            node container
     * @return a set containing the nodes
     */
    public static Set<Node> getNodes(NodeContainer container) {
        Set<Node> set = container.getNodes(DeployHelper.BODY_COMPARTMENT);
        if (set == null) {
            set = new HashSet<Node>();
        }
        return set;
    }

    /**
     * Changes first letter in string to Upper case
     *
     * @param name
     *            string to be changed
     * @return changed string
     */
    public static String firstToUpperCase(String name) {
        checkNotNull(name, "name");
        char[] characters = name.toCharArray();
        if (characters.length > 0) {
            characters[0] = Character.toUpperCase(characters[0]);
        }

        return new String(characters);
    }

    public static boolean isSameOperation(Operation op1, Operation op2) {
        if (op1.getName().equals(op2.getName())) {

            boolean equalParam = true;
            int i = 0;
            if (op1.getParameters().size() != op2.getParameters().size()) {
                return false;
            }
            for (Parameter param : op2.getParameters()) {
                Parameter p = op1.getParameters().get(i);
                if (!param.getName().equals(p.getName())) {
                    equalParam = false;
                    break;
                }
                if (param.getType() != p.getType()) {
                    equalParam = false;
                    break;
                }
                i++;
            }

            return equalParam;
        }

        return false;
    }

    public static List<Operation> getAllExtensions(Operation operation) {
        List<Operation> childOps = new ArrayList<Operation>();
        Classifier owner = operation.getOwner();
        if ((owner instanceof Class && operation.isAbstract() && owner.isAbstract()) || owner instanceof Interface) {
            List<Classifier> processingList = new ArrayList<Classifier>();
            processingList.add(owner);

            while (!processingList.isEmpty()) {
                Classifier classifier = processingList.get(0);
                processingList.remove(0);

                if (classifier instanceof Class) {
                    Class clasz = (Class) classifier;

                    boolean isImplemented = false;
                    if (clasz != owner) {
                        for (Feature feature : clasz.getFeatures()) {
                            if (feature instanceof Operation) {
                                Operation childOperation = (Operation) feature;
                                if (DeployHelper.isSameOperation(operation, childOperation)) {
                                    isImplemented = true;
                                    childOps.add(childOperation);
                                }
                            }
                        }
                    }

                    if (!isImplemented && clasz.isAbstract()) {
                        Collection<Generalization> specializations = clasz.getSpecializations();
                        for (Generalization specialization : specializations) {
                            if (specialization.getChild() instanceof Class) {
                                processingList.add((Class) specialization.getChild());
                            }
                        }
                    }
                } else if (classifier instanceof Interface) {
                    Interface ifc = (Interface) classifier;
                    Collection<Generalization> specializations = ifc.getSpecializations();
                    for (Generalization specialization : specializations) {
                        if (specialization.getChild() instanceof Interface) {
                            processingList.add((Interface) specialization.getChild());
                        }
                    }
                    Collection<Dependency> clientDependencies = ifc.getSupplierDependencies();
                    for (Dependency dependency : clientDependencies) {
                        if (dependency instanceof Abstraction) {
                            for (ModelElement modelElement : dependency.getClients()) {
                                if (modelElement instanceof Class) {
                                    processingList.add((Class) modelElement);
                                }
                            }
                        }
                    }
                }
            }

        }
        return childOps;
    }

    /**
     * Loads properties file.
     *
     * @param path
     * Properties file.
     *
     * @return
     * Properties.
     *
     * @throws IOException
     * If I/O error occurs.
     */
    public static Properties loadProperties(String path) throws IOException {
        Properties props = new Properties();
        InputStream in = new FileInputStream(path);
        try {
            props.load(in);
        } finally {
            try {
                in.close();
            } catch (IOException ex) {
                logException(ex);
            }
        }
        return props;
    }
}

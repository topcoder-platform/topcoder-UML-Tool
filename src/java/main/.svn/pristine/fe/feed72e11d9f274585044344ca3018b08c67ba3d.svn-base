/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.actions.undoable;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.GraphElement;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.Uml1SemanticModelBridge;
import com.topcoder.gui.diagramviewer.DiagramView;
import com.topcoder.gui.diagramviewer.edges.Edge;
import com.topcoder.gui.diagramviewer.elements.Node;
import com.topcoder.gui.diagramviewer.elements.NodeContainer;
import com.topcoder.gui.diagramviewer.uml.classelements.ClassNode;
import com.topcoder.gui.diagramviewer.uml.classelements.StereotypeTextField;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.ObjectNode;
import com.topcoder.uml.actions.general.UndoableAbstractAction;
import com.topcoder.uml.actions.model.classifiers.feature.AddAttributeAction;
import com.topcoder.uml.actions.model.classifiers.feature.AddOperationAction;
import com.topcoder.uml.model.activitygraphs.ActionState;
import com.topcoder.uml.model.activitygraphs.ObjectFlowState;
import com.topcoder.uml.model.commonbehavior.instances.Stimulus;
import com.topcoder.uml.model.commonbehavior.links.Link;
import com.topcoder.uml.model.core.Attribute;
import com.topcoder.uml.model.core.AttributeImpl;
import com.topcoder.uml.model.core.Element;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.Operation;
import com.topcoder.uml.model.core.OperationImpl;
import com.topcoder.uml.model.core.Parameter;
import com.topcoder.uml.model.core.ParameterImpl;
import com.topcoder.uml.model.core.StructuralFeatureAbstractImpl;
import com.topcoder.uml.model.core.auxiliaryelements.Comment;
import com.topcoder.uml.model.core.classifiers.Class;
import com.topcoder.uml.model.core.classifiers.Interface;
import com.topcoder.uml.model.core.dependencies.Abstraction;
import com.topcoder.uml.model.core.dependencies.Dependency;
import com.topcoder.uml.model.core.extensionmechanisms.Stereotype;
import com.topcoder.uml.model.core.extensionmechanisms.StereotypeImpl;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValue;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValueImpl;
import com.topcoder.uml.model.core.relationships.Association;
import com.topcoder.uml.model.core.relationships.Generalization;
import com.topcoder.uml.model.datatypes.PseudostateKind;
import com.topcoder.uml.model.modelmanagement.Subsystem;
import com.topcoder.uml.model.statemachines.FinalState;
import com.topcoder.uml.model.statemachines.Pseudostate;
import com.topcoder.uml.model.statemachines.SimpleState;
import com.topcoder.uml.model.statemachines.Transition;
import com.topcoder.uml.model.usecases.Actor;
import com.topcoder.uml.model.usecases.Extend;
import com.topcoder.uml.model.usecases.Include;
import com.topcoder.uml.model.usecases.UseCase;
import com.topcoder.umltool.deploy.DeployHelper;
import com.topcoder.umltool.deploy.MainFrame;
import com.topcoder.util.actionmanager.ActionExecutionException;

/**
 * <p>
 * This class defines paste component action used for paste component to diagram view.
 * </p>
 * <p>
 * Component to be pasted is created in the constructor according to given graph element.
 * </p>
 *
 * @author ly, FireIce, ylouis, TCSDEVELOPER
 * @version 1.0
 */
public class PasteComponentAction extends UndoableAbstractAction {
    /**
     * <p>
     * Presentation name for parent class.
     * </p>
     */
    private final static String PRESENTAION_NAME = "PASTE";

    /**
     * <p>
     * Reference to main frame.
     * <p>
     */
    private final MainFrame mainFrame;

    /**
     * <p>
     * The diagram view to pasted to.
     * </p>
     */
    private DiagramView diagramView;

    /**
     * <p>
     * The component to paste.
     * </p>
     */
    private JComponent component;

    private ModelElement modelElement;

    private List<UndoableAbstractAction> actions = new ArrayList<UndoableAbstractAction>();

    private List<ClassNode> classNodes = new ArrayList<ClassNode>();

    /**
     * <p>
     * Creates an instance of <code>PasteComponentAction</code>.
     * </p>
     *
     * @param mainFrame
     *            reference to main frame
     * @param graphElement
     *            the graph element of the component to be paste
     * @param diagram
     *            the diagram to be pasted to
     */
    public PasteComponentAction(MainFrame mainFrame, GraphElement graphElement, Diagram diagram) {
        super(PRESENTAION_NAME);
        DeployHelper.checkNotNull(mainFrame, "mainFrame");
        DeployHelper.checkNotNull(graphElement, "graphElement");
        DeployHelper.checkNotNull(diagram, "diagram");

        this.mainFrame = mainFrame;
        this.diagramView = mainFrame.getDiagramViewer().openDiagramView(diagram);

        modelElement = DeployHelper.getElement(graphElement);

        if (modelElement instanceof Actor) {
            component = DeployHelper.createActorNode(mainFrame, (GraphNode) graphElement);
        } else if (modelElement instanceof UseCase) {
            component = DeployHelper.createUsecaseNode(mainFrame, (GraphNode) graphElement);
        } else if (modelElement instanceof Subsystem) {
            component = DeployHelper.createSubsystemNode(mainFrame, (GraphNode) graphElement);
        } else if (modelElement instanceof ActionState) {
            component = DeployHelper.createActionStateNode(mainFrame, (GraphNode) graphElement);
        } else if (modelElement instanceof Pseudostate) {
            component = createPseudostateNode(mainFrame, (Pseudostate) modelElement, (GraphNode) graphElement);
        } else if (modelElement instanceof FinalState) {
            if (DeployHelper.isFlowFinal((FinalState) modelElement)) {
                component = DeployHelper.createFlowFinalNode(mainFrame, (GraphNode) graphElement);
            } else {
                component = DeployHelper.createFinalNode(mainFrame, (GraphNode) graphElement);
            }
        } else if (modelElement instanceof ObjectFlowState) {
            component = DeployHelper.createObjectFlowNode(mainFrame, (GraphNode) graphElement);
        } else if (modelElement instanceof SimpleState) {
            if (DeployHelper.isSendSignal((SimpleState) modelElement)) {
                component = DeployHelper.createSendSignalActionNode(mainFrame, (GraphNode) graphElement);
            } else {
                component = DeployHelper.createAcceptEventActionNode(mainFrame, (GraphNode) graphElement);
            }
        } else if (modelElement instanceof Association) {
            component = DeployHelper.createAssociationEdge(mainFrame, diagramView, (GraphEdge) graphElement);
        } else if (modelElement instanceof Abstraction) {
            component = DeployHelper.createAbstractionEdge(mainFrame, diagramView, (GraphEdge) graphElement);
        } else if (modelElement instanceof Dependency) {
            component = DeployHelper.createDependencyEdge(mainFrame, diagramView, (GraphEdge) graphElement);
        } else if (modelElement instanceof Generalization) {
            component = DeployHelper.createGeneralizationEdge(mainFrame, diagramView, (GraphEdge) graphElement);
        } else if (modelElement instanceof Include) {
            component = DeployHelper.createIncludeEdge(mainFrame, diagramView, (GraphEdge) graphElement);
        } else if (modelElement instanceof Extend) {
            component = DeployHelper.createExtendEdge(mainFrame, diagramView, (GraphEdge) graphElement);
        } else if (modelElement instanceof Transition) {
            component = DeployHelper.createTransitionEdge(mainFrame, diagramView, (GraphEdge) graphElement);
        } else if (modelElement instanceof Comment) {
            component = DeployHelper.createCommentNode(mainFrame, (GraphNode) graphElement);
        } else if (modelElement instanceof com.topcoder.uml.model.core.classifiers.Class) {
            component = DeployHelper.createClassNode(mainFrame, (GraphNode) graphElement);
        } else if (modelElement instanceof Interface) {
            component = DeployHelper.createInterfaceNode(mainFrame, (GraphNode) graphElement);
        } else if (modelElement instanceof com.topcoder.uml.model.modelmanagement.Package) {
            component = DeployHelper.createPackageNode(mainFrame, (GraphNode) graphElement);
        } else if (modelElement == null && DeployHelper.getTypeInfo(graphElement).equals("FreeText")) {
            component = DeployHelper.createFreeTextNode(mainFrame, (GraphNode) graphElement);
        } else if (modelElement == null && DeployHelper.getTypeInfo(graphElement).equals("CommentLink")) {
            component = DeployHelper.createCommentLinkEdge(mainFrame, diagramView, (GraphEdge) graphElement);
        } else if (modelElement instanceof com.topcoder.uml.model.commonbehavior.instances.Object) {
            component = DeployHelper.createObjectNode(mainFrame, (GraphNode) graphElement);
            DeployHelper.getLifeLine((ObjectNode) component).setSize((int) diagram.getSize().getWidth(),
                (int) diagram.getSize().getHeight());
        } else if (modelElement instanceof Stimulus) {
            Stimulus copiedStimulus = (Stimulus) DeployHelper.getElement(graphElement);
            Link copiedLink = copiedStimulus.getCommunicationLink();
            DeployHelper.setElement(graphElement, copiedLink);
            component = DeployHelper.createSequenceEdge(mainFrame, diagramView, (GraphEdge) graphElement);
        } else if (modelElement instanceof Link) {
            component = DeployHelper.createSequenceEdge(mainFrame, diagramView, (GraphEdge) graphElement);
        } else if (modelElement instanceof Attribute) {
            component = DeployHelper.createStereotypeTextField(mainFrame, diagramView, (GraphNode) graphElement);
        } else if (modelElement instanceof Operation) {
            component = DeployHelper.createStereotypeTextField(mainFrame, diagramView, (GraphNode) graphElement);
        }

    }

    /**
     * <p>
     * Creates a component with Pseudostate model element.
     * </p>
     *
     * @param mainFrame
     *            reference to main frame
     * @param pseudostate
     *            model element of Pseudostate type
     * @param graphNode
     *            graph node of the creating component
     * @return the created component
     */
    private JComponent createPseudostateNode(MainFrame mainFrame, Pseudostate pseudostate, GraphNode graphNode) {
        if (pseudostate.getKind() == PseudostateKind.CHOICE) {
            component = DeployHelper.createDecisionNode(mainFrame, graphNode);
        } else if (pseudostate.getKind() == PseudostateKind.FORK) {
            component = DeployHelper.createForkNode(mainFrame, graphNode);
        } else if (pseudostate.getKind() == PseudostateKind.INITIAL) {
            component = DeployHelper.createInitialNode(mainFrame, graphNode);
        } else if (pseudostate.getKind() == PseudostateKind.JOIN) {
            component = DeployHelper.createJoinNode(mainFrame, graphNode);
        } else if (pseudostate.getKind() == PseudostateKind.JUNCTION) {
            component = DeployHelper.createMergeNode(mainFrame, graphNode);
        }
        return component;
    }

    /**
     * <p>
     * The method actually undo the edit that was made. If any exception prevents redo/undo methods from completing
     * successfully, it should be log with logError.
     * </p>
     */
    public void undoAction() {
        if (component instanceof StereotypeTextField) {
            int i = 0;
            for (UndoableAbstractAction action : actions) {
                action.undo();
                DeployHelper.nodeNotifyChange(classNodes.get(i), PRESENTAION_NAME, mainFrame);
                i++;
            }

        } else {
            diagramView.remove(component);
        }
    }

    /**
     * <p>
     * The method actually redo the edit. If any exception prevents redo/undo methods from completing successfully,
     * it should be log with logError.
     * </p>
     */
    public void redoAction() {
        if (component instanceof StereotypeTextField) {
            int i = 0;
            for (UndoableAbstractAction action : actions) {
                action.redo();
                DeployHelper.nodeNotifyChange(classNodes.get(i), PRESENTAION_NAME, mainFrame);
                i++;
            }

        } else {
            diagramView.add(component);
            if (component instanceof NodeContainer) {
                DeployHelper.updateZOrder((NodeContainer) component);
            } else if (component instanceof Node) {
                DeployHelper.moveToFront((DiagramView) component.getParent(), (Node) component);
            }
        }
    }

    /**
     * <p>
     * The method actually execute this auction.
     * </p>
     *
     * @throws ActionExecutionException
     *             if any exception prevents this method from completing successfully
     */
    public void executeAction() throws ActionExecutionException {
        if (component instanceof StereotypeTextField) {
            List<java.lang.Object> nodes = DeployHelper.getFilteredSelectedNodes(mainFrame);
            for (java.lang.Object node : nodes) {
                if (node instanceof ClassNode) {
                    classNodes.add((ClassNode) node);
                    StereotypeTextField textField = ((StereotypeTextField) component);
                    Element element =
                        ((Uml1SemanticModelBridge) textField.getGraphNode().getSemanticModel()).getElement();
                    if (element instanceof Attribute) {
                        Attribute attribute = (Attribute) element;

                        ClassNode classNode = (ClassNode) node;
                        com.topcoder.uml.model.core.classifiers.Class clasz =
                            (Class) ((Uml1SemanticModelBridge) classNode.getGraphNode().getSemanticModel())
                                .getElement();
                        AttributeImpl dupl = new AttributeImpl();
                        dupl.setName(attribute.getName());
                        StructuralFeatureAbstractImpl.setType(dupl, attribute.getType());
                        dupl.setVisibility(attribute.getVisibility());
                        dupl.setChangeability(attribute.getChangeability());
                        for (Stereotype stereotype : attribute.getStereotypes()) {
                            StereotypeImpl s = new StereotypeImpl();
                            s.setName(stereotype.getName());
                            dupl.addStereotype(s);
                        }
                        for (TaggedValue taggedValue : attribute.getTaggedValues()) {
                            TaggedValueImpl t = new TaggedValueImpl();
                            t.setName(taggedValue.getName());
                            t.setDataValue(taggedValue.getDataValue());
                            t.setModelElement(dupl);
                            t.setType(taggedValue.getType());
                            dupl.addTaggedValue(t);
                        }
                        dupl.setOwner(clasz);
                        UndoableAbstractAction action = new AddAttributeAction(clasz, dupl);
                        action.execute();
                        actions.add(action);
                        DeployHelper.nodeNotifyChange(classNode, PRESENTAION_NAME, mainFrame);
                    } else if (element instanceof Operation) {
                        Operation operation = (Operation) element;

                        ClassNode classNode = (ClassNode) node;
                        com.topcoder.uml.model.core.classifiers.Class clasz =
                            (Class) ((Uml1SemanticModelBridge) classNode.getGraphNode().getSemanticModel())
                                .getElement();
                        OperationImpl dupl = new OperationImpl();
                        dupl.setName(operation.getName());
                        for (Parameter parameter : operation.getParameters()) {
                            ParameterImpl param = new ParameterImpl();
                            param.setName(parameter.getName());
                            param.setType(parameter.getType());
                            param.setKind(parameter.getKind());
                            dupl.addParameter(param);
                        }
                        dupl.setVisibility(operation.getVisibility());
                        dupl.setConcurrency(operation.getConcurrency());
                        for (Stereotype stereotype : operation.getStereotypes()) {
                            StereotypeImpl s = new StereotypeImpl();
                            s.setName(stereotype.getName());
                            dupl.addStereotype(s);
                        }
                        for (TaggedValue taggedValue : operation.getTaggedValues()) {
                            TaggedValueImpl t = new TaggedValueImpl();
                            t.setName(taggedValue.getName());
                            t.setDataValue(taggedValue.getDataValue());
                            t.setType(taggedValue.getType());
                            t.setModelElement(dupl);
                            dupl.addTaggedValue(t);
                        }
                        dupl.setOwner(clasz);
                        UndoableAbstractAction action = new AddOperationAction(clasz, dupl);
                        action.execute();
                        actions.add(action);
                        DeployHelper.nodeNotifyChange(classNode, PRESENTAION_NAME, mainFrame);
                    }
                }
            }
        } else {
            diagramView.add(component);
            if (component instanceof Node) {
                ((Node) component).setComponentPopupMenu(mainFrame.getPopupMenu());
                DeployHelper.nodeNotifyChange((Node) component, PRESENTAION_NAME, mainFrame);
            } else if (component instanceof Edge) {
                DeployHelper.edgeNotifyChange((Edge) component);
            }
        }
    }
}

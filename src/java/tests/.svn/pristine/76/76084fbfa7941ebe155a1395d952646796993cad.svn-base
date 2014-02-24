package com.topcoder.umltool.deploy.zumlimport.test;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.dnd.DropTarget;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.JComponent;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.TransferHandler;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.DiagramElement;
import com.topcoder.diagraminterchange.GraphConnector;
import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.Polyline;
import com.topcoder.diagraminterchange.SemanticModelBridge;
import com.topcoder.diagraminterchange.SimpleSemanticModelElement;
import com.topcoder.diagraminterchange.Uml1SemanticModelBridge;
import com.topcoder.gui.diagramviewer.ConfigurationException;
import com.topcoder.gui.diagramviewer.DiagramView;
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
import com.topcoder.gui.diagramviewer.uml.classelements.ExceptionNode;
import com.topcoder.gui.diagramviewer.uml.classelements.GroupTextField;
import com.topcoder.gui.diagramviewer.uml.classelements.InterfaceNode;
import com.topcoder.gui.diagramviewer.uml.classelements.PackageNode;
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
import com.topcoder.gui.diagramviewer.uml.usecaseelements.ExtendEdge;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.IncludeEdge;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.SubsystemNodeContainer;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.UseCaseNode;
import com.topcoder.gui.panels.documentation.DocumentationPanel;
import com.topcoder.gui.panels.documentation.plugins.DefaultDocumentationEditor;
import com.topcoder.gui.panels.style.StyleObject;
import com.topcoder.gui.panels.style.StylePanel;
import com.topcoder.gui.panels.style.styleobject.GraphEdgeStyleObjectAdapter;
import com.topcoder.gui.panels.style.styleobject.GraphNodeStyleObjectAdapter;
import com.topcoder.gui.panels.style.styleobject.PolylineStyleObjectAdapter;
import com.topcoder.uml.model.actions.Action;
import com.topcoder.uml.model.actions.messagingactions.CallOperationAction;
import com.topcoder.uml.model.actions.objectactions.CreateObjectAction;
import com.topcoder.uml.model.activitygraphs.ObjectFlowState;
import com.topcoder.uml.model.collaborations.collaborationinteractions.Collaboration;
import com.topcoder.uml.model.commonbehavior.instances.Object;
import com.topcoder.uml.model.commonbehavior.instances.Stimulus;
import com.topcoder.uml.model.commonbehavior.links.Link;
import com.topcoder.uml.model.commonbehavior.procedure.Procedure;
import com.topcoder.uml.model.core.Attribute;
import com.topcoder.uml.model.core.Classifier;
import com.topcoder.uml.model.core.Feature;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.core.Operation;
import com.topcoder.uml.model.core.OperationImpl;
import com.topcoder.uml.model.core.Parameter;
import com.topcoder.uml.model.core.auxiliaryelements.Comment;
import com.topcoder.uml.model.core.classifiers.Class;
import com.topcoder.uml.model.core.classifiers.Interface;
import com.topcoder.uml.model.core.dependencies.Abstraction;
import com.topcoder.uml.model.core.dependencies.Dependency;
import com.topcoder.uml.model.core.extensionmechanisms.TagDefinition;
import com.topcoder.uml.model.core.extensionmechanisms.TagDefinitionImpl;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValue;
import com.topcoder.uml.model.core.relationships.Association;
import com.topcoder.uml.model.core.relationships.Generalization;
import com.topcoder.uml.model.datatypes.PseudostateKind;
import com.topcoder.uml.model.modelmanagement.Model;
import com.topcoder.uml.model.modelmanagement.Package;
import com.topcoder.uml.model.modelmanagement.Subsystem;
import com.topcoder.uml.model.statemachines.FinalState;
import com.topcoder.uml.model.statemachines.Pseudostate;
import com.topcoder.uml.model.statemachines.SimpleState;
import com.topcoder.uml.model.statemachines.StateVertex;
import com.topcoder.uml.model.usecases.Actor;
import com.topcoder.uml.model.usecases.Extend;
import com.topcoder.uml.model.usecases.Include;
import com.topcoder.uml.model.usecases.UseCase;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.umltool.deploy.DeployConfigException;
import com.topcoder.umltool.deploy.DeployHelper;
import com.topcoder.umltool.deploy.DiagramType;
import com.topcoder.umltool.deploy.MainFrame;
import com.topcoder.umltool.deploy.actions.undoable.UpdateDiagramAction;
import com.topcoder.umltool.deploy.handlers.ActivityBoundChangedHandler;
import com.topcoder.umltool.deploy.handlers.ActivityNameChangedHandler;
import com.topcoder.umltool.deploy.handlers.AttributeCompartmentMouseHandler;
import com.topcoder.umltool.deploy.handlers.AuxiliaryBoundChangedHandler;
import com.topcoder.umltool.deploy.handlers.AuxiliaryTextChangedHandler;
import com.topcoder.umltool.deploy.handlers.ClassEdgeNameChangedHandler;
import com.topcoder.umltool.deploy.handlers.ClassNameChangedHandler;
import com.topcoder.umltool.deploy.handlers.CornerDragHandler;
import com.topcoder.umltool.deploy.handlers.CornerMouseHandler;
import com.topcoder.umltool.deploy.handlers.DiagramViewDragHandler;
import com.topcoder.umltool.deploy.handlers.ElementSelectionHandler;
import com.topcoder.umltool.deploy.handlers.NodeDragHandler;
import com.topcoder.umltool.deploy.handlers.NodeMouseHandler;
import com.topcoder.umltool.deploy.handlers.ObjectNodeEditNameHandler;
import com.topcoder.umltool.deploy.handlers.ObjectNodeResizeHandler;
import com.topcoder.umltool.deploy.handlers.OperationCompartmentMouseHandler;
import com.topcoder.umltool.deploy.handlers.PolylineCornerDragHandler;
import com.topcoder.umltool.deploy.handlers.PolylineCornerMouseHandler;
import com.topcoder.umltool.deploy.handlers.PolylineMouseHandler;
import com.topcoder.umltool.deploy.handlers.SequenceEdgeDragHandler;
import com.topcoder.umltool.deploy.handlers.SequenceEdgeMouseHandler;
import com.topcoder.umltool.deploy.handlers.SequenceEdgeNameChangedHandler;
import com.topcoder.umltool.deploy.handlers.UsecaseNameChangedHandler;
import com.topcoder.umltool.deploy.handlers.ViewDropTargetHandler;
import com.topcoder.umltool.deploy.handlers.CornerDragHandler.CornerDragType;
import com.topcoder.util.config.ConfigManager;
import com.topcoder.util.config.UnknownNamespaceException;

public class TestHelper {
	
	/**
	 * <p>
	 * Recovers diagram view for given diagram. It creates elements contained in
	 * diagram and adds them to given diagram view instance.
	 * </p>
	 * 
	 * @param diagram
	 *            the diagram to recover view
	 * @param view
	 *            the view instance to add elements
	 * @param isConverted
	 *            whether the diagram is converted from a Poseidon type file
	 */
	public static void recoverDiagramView(Diagram diagram, DiagramView view,
			boolean isConverted) {
		view.setBackground(Color.WHITE);
		view.setOpaque(true);
		// recover nodes first
		for (DiagramElement diagramElement : diagram.getContaineds()) {
			if (diagramElement instanceof GraphNode
					|| diagramElement instanceof Polyline) {
				try {
					createNode(diagramElement, view, isConverted);
				} catch (Exception e) {
					DeployHelper.logException(e);
					continue;
				}
			}
		}

		// recover edges
		for (DiagramElement diagramElement : diagram.getContaineds()) {
			if (diagramElement instanceof GraphEdge) {
				try {
					createEdge((GraphEdge) diagramElement, view, isConverted);
				} catch (Exception e) {
					DeployHelper.logException(e);
					continue;
				}
			}
		}

		if (DeployHelper.getTypeInfo(diagram).equals(
				DeployHelper.DIAGRAM_TYPEINFO[DiagramType.SEQUENCE.ordinal()])) {
			layoutSequenceEdges(view);
		}

		if (diagram.isVisible()) {
			DeployHelper.updateZoomPane(view);
		}

		UpdateDiagramAction action = new UpdateDiagramAction(view, "recover");
	}
	
	 /**
     * <p>
     * Layout sequence edges in sequence diagram view.
     * </p>
     * @param diagramView
     *            diagram view of sequence diagram
     */
    public static void layoutSequenceEdges(DiagramView diagramView) {
        layoutSequenceEdges( diagramView, DeployHelper.getSequenceEdges(diagramView));
    }

    /**
     * <p>
     * Gets the map of sequence edge and connected object nodes.
     * </p>
     * @param edges
     *            sequence edges in diagram view
     * @return the map of sequence edge and connected object nodes
     */
    private static Map<SequenceEdge, ObjectNode[]> getSequenceEdgeNodeMapping(
            List<SequenceEdge> edges, DiagramView diagramView) {
        Map<SequenceEdge, ObjectNode[]> edgeNodeMapping = new HashMap<SequenceEdge, ObjectNode[]>();
        for (SequenceEdge edge : edges) {
            List<Node> connectedNodes = getConnectedNodes( edge,diagramView);
            ObjectNode[] nodes = new ObjectNode[2];
            nodes[0] = (ObjectNode) connectedNodes.get(0);
            nodes[1] = (ObjectNode) connectedNodes.get(1);
            edgeNodeMapping.put(edge, nodes);
        }
        return edgeNodeMapping;
    }
    /**
     * <p>
     * Gets the connected nodes for given edge.
     * </p>
     * @param edge
     *            edge to find its connected nodes
     * @return the connected nodes
     */
    public static List<Node> getConnectedNodes(Edge edge, DiagramView diagramView) {
        List<Node> connectedNodes = new ArrayList<Node>();
        GraphEdge graphEdge = edge.getGraphEdge();
        for (GraphConnector graphConnector : graphEdge.getAnchors()) {
            GraphNode connectedGraphNode = (GraphNode) graphConnector.getGraphElement();
            connectedNodes.add((Node) DeployHelper.getComponent(connectedGraphNode,diagramView));
        }
        return connectedNodes;
    }

    /**
     * <p>
     * Layout sequence edges in sequence diagram view.
     * </p>
     * @param diagramView
     *            diagram view of sequence diagram
     */
    public static void layoutSequenceEdges( DiagramView diagramView, List<SequenceEdge> edges) {
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
        Map<SequenceEdge, ObjectNode[]> edgeNodeMapping = getSequenceEdgeNodeMapping( edges,diagramView);
        List<LifelineSegment> lifelineSegments = null;
        try {
            lifelineSegments = edgeLayoutStrategy.layout(edges, edgeNodeMapping);
        } catch (EdgeLayoutException e) {
            e.printStackTrace();
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
            maxLength = Math.max((int) lifeline.getGraphEdge().getWaypoints().get(0).getY()
                    + lifeline.getLifelineLength(), maxLength);
            lifeline.setSize(lifeline.getWidth(), maxLength);
            lifeline.getGraphEdge().getWaypoints().get(1).setY(maxLength);
            // adjust lifeline to the last component in object node
            objectNode.remove(lifeline);
            objectNode.add(lifeline);
        }
    }
    /**
     * <p>
     * Gets the life line in object node.
     * </p>
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
	 * Creates the documentation panel.
	 * </p>
	 */
	public static DocumentationPanel createDocumentationPanel()
			throws DeployConfigException {
		DocumentationPanel documentationPanelComponent = null;
		try {
			documentationPanelComponent = new DocumentationPanel(
					DocumentationPanel.class.getName());
		} catch (Exception e) {
			throw new DeployConfigException("DocumentationPanel config error.",
					e);
		}
		/*
		documentationPanelComponent.setPreferredSize(new Dimension(120, 120));
		documentationPanelComponent.setTarget(new OperationImpl());
		
		docEditor = (DefaultDocumentationEditor) ((JSplitPane) documentationPanelComponent
				.getComponent(0)).getComponent(0);
		docTextArea = (JTextArea) ((JScrollPane) docEditor.getComponent(0))
				.getViewport().getView();
				*/

		return documentationPanelComponent;
	}
	
	/**
	 * <p>
	 * Creates a corresponding edge given a graph edge.
	 * </p>
	 * 
	 * @param graphEdge
	 *            the graph edge for creating node
	 * @param view
	 *            diagram view
	 * @param isConverted
	 *            whether the diagram is converted from a Poseidon type file
	 * @return the edge created, null if no corresponding edge
	 */
	public static Edge createEdge(GraphEdge graphEdge, DiagramView view,
			boolean isConverted) {
		Edge edge = null;
		if (isConverted) {
			DeployHelper.recoverGraphEdge(graphEdge);
		} else {
			// Fix some illegal graph edge whose position is not (0, 0)
			com.topcoder.diagraminterchange.Point pos = graphEdge.getPosition();
			if (pos.getX() != 0.0 || pos.getY() != 0.0) {
				pos.setX(0.0);
				pos.setY(0.0);
			}
		}
		SemanticModelBridge semanticModel = graphEdge.getSemanticModel();
		if (semanticModel instanceof Uml1SemanticModelBridge) {
			ModelElement modelElement = DeployHelper.getElement(graphEdge);
			if (modelElement instanceof Include) {
				edge = createIncludeEdge(view, graphEdge);
			} else if (modelElement instanceof Extend) {
				edge = createExtendEdge(view, graphEdge);
			} else if (modelElement instanceof Association) {
				// Support files saved by early versions which don't save the
				// graph nodes for association ends. Create
				// the graph nodes for association ends. Fix since 0.1.13.
				if (graphEdge.getContaineds().size() == 2) {
					Association association = (Association) modelElement;
					GraphNode graphNode = DeployHelper
							.createAssociationEndGraphNode(association
									.getConnections().get(0));
					graphEdge.addContained(0, graphNode);
					graphNode.setContainer(graphEdge);

					graphNode = DeployHelper
							.createAssociationEndGraphNode(association
									.getConnections().get(1));
					graphEdge.addContained(1, graphNode);
					graphNode.setContainer(graphEdge);
				}
				edge = createAssociationEdge(view, graphEdge);
			} else if (modelElement instanceof Abstraction) {
				edge = createAbstractionEdge( view, graphEdge);
			} else if (modelElement instanceof Dependency) {
				edge = createDependencyEdge(view, graphEdge);
			} else if (modelElement instanceof Generalization) {
				edge = createGeneralizationEdge( view,
						graphEdge);
			} else if (modelElement instanceof com.topcoder.uml.model.statemachines.Transition) {
				edge = createTransitionEdge(view, graphEdge);
			} else if (modelElement instanceof Link) {
				edge = createSequenceEdge( view, graphEdge);
			}
			// Support files saved by early versions which don't have element's
			// namespace saved. Restore their namespaces.
			if (modelElement instanceof Link) {
				Link link = (Link) modelElement;
				Uml1SemanticModelBridge bridge = (Uml1SemanticModelBridge) view
						.getDiagram().getOwner();
				Collaboration collaboration = (Collaboration) bridge
						.getElement();
				for (Stimulus stimulus : link.getStimuli()) {
					stimulus.setNamespace(collaboration);
					fixOwnership(stimulus);
				}
			} else if (!(modelElement instanceof com.topcoder.uml.model.statemachines.Transition)) {
				if (modelElement.getNamespace() == null) {
					Model model = UMLModelManager.getInstance().getModel();
					Namespace owner = findOwnerNamespace(model, modelElement);
					if (owner != null) {
						modelElement.setNamespace(owner);
					} else {
						modelElement.setNamespace(model);
						if (!model.containsOwnedElement(modelElement)) {
							model.addOwnedElement(modelElement);
						}
					}
				}
				fixOwnership(modelElement);
			}
		} else if (semanticModel instanceof SimpleSemanticModelElement) {
			if (DeployHelper.getTypeInfo(graphEdge).equals("CommentLink")) {
				edge = createCommentLinkEdge(view, graphEdge);
			}
		}
		if (edge != null) {
			// connect edge with nodes
			GraphNode start = (GraphNode) graphEdge.getAnchors().get(0)
					.getGraphElement();
			GraphNode end = (GraphNode) graphEdge.getAnchors().get(1)
					.getGraphElement();
			Node startNode = (Node) DeployHelper.getComponent(start, view);
			Node endNode = (Node) DeployHelper.getComponent(end, view);
			Connector leftConnector = DeployHelper.getConnector(startNode);
			Connector rightConnector = DeployHelper.getConnector(endNode);
			edge.setLeftConnector(leftConnector);
			edge.setRightConnector(rightConnector);
			view.add(edge);
			view.setComponentZOrder(edge, 0);
		}
		return edge;
	}
	/**
     * <p>
     * Creates a comment link edge by graph edge.
     * </p>
     * @param mainFrame
     *            reference to main frame
     * @param diagramView
     *            reference to diagram view
     * @param graphEdge
     *            the graph edge to create component
     * @return the created component
     */
    public static CommentLinkEdge createCommentLinkEdge( DiagramView diagramView,
            GraphEdge graphEdge) {
        CommentLinkEdge edge = null;
        try {
            edge = new CommentLinkEdge(graphEdge);
            //edge.setProperties(DeployHelper.createProperties());
          //  edge.notifyPropertiesChange();
           
            // Edge's size is the same as the DiagramView
            edge.setSize(diagramView.getSize());
        } catch (IllegalGraphElementException e) {
           e.printStackTrace();
        }
        return edge;
    }
	
	 /**
     * <p>
     * Creates a sequence edge by graph edge.
     * </p>
     * @param mainFrame
     *            reference to main frame
     * @param diagramView
     *            reference to diagram view
     * @param graphEdge
     *            the graph edge to create component
     * @return the created component
     */
    public static SequenceEdge createSequenceEdge(DiagramView diagramView, GraphEdge graphEdge) {
        SequenceEdge edge = null;

        // create a sequence edge
        EnumMap<ConfiguredEdgeEndingPropertyType, String> endingProperties = createSequenceEdgeEndingProperties();
        EnumMap<SequenceEdgePropertyType, String> edgeProperties = createSequenceEdgeProperties();

        Link link = (Link) DeployHelper.getElement(graphEdge);
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
        //edge.notifyPropertiesChange();

        // set the size of the sequence edge
        edge.setSize(diagramView.getSize());
      
        return edge;
    }
    /**
     * <p>
     * create sequence edge property types for sequence edge
     * </p>
     * @return sequence edge property types
     */
    private static EnumMap<SequenceEdgePropertyType, String> createSequenceEdgeProperties() {
        EnumMap<SequenceEdgePropertyType, String> edgeProperties = new EnumMap<SequenceEdgePropertyType, String>(
                SequenceEdgePropertyType.class);

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
     * create configured edge ending property types for sequence edge
     * </p>
     * @return configured edge ending property types
     */
    private static EnumMap<ConfiguredEdgeEndingPropertyType, String> createSequenceEdgeEndingProperties() {
        EnumMap<ConfiguredEdgeEndingPropertyType, String> endingProperties = new EnumMap<ConfiguredEdgeEndingPropertyType, String>(
                ConfiguredEdgeEndingPropertyType.class);
        endingProperties.put(ConfiguredEdgeEndingPropertyType.STROKE_COLOR, "STROKE_COLOR");
        endingProperties.put(ConfiguredEdgeEndingPropertyType.FILL_COLOR, "FILL_COLOR");
        endingProperties.put(ConfiguredEdgeEndingPropertyType.ARROW_X_LENGTH, "ARROW_X_LENGTH");
        endingProperties.put(ConfiguredEdgeEndingPropertyType.ARROW_Y_LENGTH, "ARROW_Y_LENGTH");
        endingProperties.put(ConfiguredEdgeEndingPropertyType.RENDER_SCHEME, "RENDER_SCHEME");
        return endingProperties;
    }
   
	/**
     * <p>
     * Creates an abstraction edge by graph edge.
     * </p>
     * @param mainFrame
     *            reference to main frame
     * @param diagramView
     *            reference to diagram view
     * @param graphEdge
     *            the graph edge to create component
     * @return the created component
     */
    public static AbstractionEdge createAbstractionEdge(DiagramView diagramView,
            GraphEdge graphEdge) {
        AbstractionEdge edge = null;
        try {
            edge = new AbstractionEdge(graphEdge);
            edge.setProperties(DeployHelper.createProperties());
            edge.notifyPropertiesChange();

            // Edge's size is the same as the DiagramView
            edge.setSize(diagramView.getSize());
          //  edge.getNameCompartment().addTextChangeListener(new ClassEdgeNameChangedHandler(mainFrame));
          //  DeployHelper.addEdgeHandlers(edge, mainFrame);
        } catch (com.topcoder.gui.diagramviewer.uml.classedges.IllegalGraphElementException e) {
            e.printStackTrace();
        }
        return edge;
    }
	/**
     * <p>
     * Updates style panel according to the selected components.
     * </p>
     * @param selectComponents
     *            the selected components in the view
     * @param stylePanel
     *            the tylePanel
     */
    public static void updateStylePanel(List<JComponent> selectComponents, StylePanel stylePanel) {
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
        stylePanel.setStyleObjectList(styleObjects);
    }
    
    /**
	 * <p>
	 * Creates a corresponding node given a graph node or a Polyline.
	 * </p>
	 * 
	 * @param element
	 *            the graph node for creating node, or Polyline
	 * @param view
	 *            diagram view
	 * @param isConverted
	 *            whether the diagram is converted from a Poseidon type file
	 * @return the node created, null if no corresponding node
	 */
	public static  Node createNode(DiagramElement element, DiagramView view,
			boolean isConverted) {
		Node node = null;
		Diagram diagram = view.getDiagram();
		if (element instanceof Polyline) {
			node = createPolylineNode((Polyline) element);
			node.getGraphNode().setContainer(view.getDiagram());
			((PolylineNode) node).notifyUpdate();
		} else {
			GraphNode graphNode = (GraphNode) element;
			if (isConverted) {
				DeployHelper.recoverGraphNode(graphNode);
			}
			for (GraphConnector connector : graphNode.getAnchorages()) {
				connector.setGraphElement(graphNode);
			}
			SemanticModelBridge semanticModel = graphNode.getSemanticModel();
			if (semanticModel instanceof Uml1SemanticModelBridge) {
				ModelElement modelElement = DeployHelper.getElement(graphNode);

				// Support files saved by early version which don't have
				// element's namespace saved. Restore their namespaces.
				if (!(modelElement instanceof StateVertex)) {
					fixNamespace(graphNode, modelElement);
				}

				if (modelElement instanceof UseCase) {
					node = createUsecaseNode( graphNode);
				} else if (modelElement instanceof Actor) {
					node = createActorNode(graphNode);
				} else if (modelElement instanceof Subsystem) {
					node = createSubsystemNode( graphNode);
					createSubNodes((NodeContainer) node, view, isConverted);
				} else if (modelElement instanceof SimpleState) {
					if (modelElement instanceof com.topcoder.uml.model.activitygraphs.ActionState) {
						node = createActionStateNode(
								graphNode);
					} else if (modelElement instanceof ObjectFlowState) {
						node = createObjectFlowNode(
								graphNode);
					} else {
						SimpleState state = (SimpleState) modelElement;

						// Supports files saved by version 0.1.10, which don't
						// have tag type saved for some activity
						// nodes. Adds a tag type.

						if (node instanceof SendSignalAction) {
							fixTagType(state, "True", "SendSignalAction");
						} else if (node instanceof AcceptEventAction) {
							fixTagType(state, "True", "AcceptEventAction");
						}

						if (DeployHelper.isSendSignal(state)) {
							node = createSendSignalActionNode(
									graphNode);
						} else {
							node = createAcceptEventActionNode(
									graphNode);
						}

					}
				} else if (modelElement instanceof Pseudostate) {
					Pseudostate state = (Pseudostate) modelElement;
					if (state.getKind() == PseudostateKind.CHOICE) {
						node = createDecisionNode( graphNode);
					} else if (state.getKind() == PseudostateKind.FORK) {
						node = createForkNode( graphNode);
					} else if (state.getKind() == PseudostateKind.INITIAL) {
						node = createInitialNode( graphNode);
					} else if (state.getKind() == PseudostateKind.JOIN) {
						node = createJoinNode(graphNode);
					} else if (state.getKind() == PseudostateKind.JUNCTION) {
						node = createMergeNode( graphNode);
					}
				} else if (modelElement instanceof FinalState) {
					FinalState state = (FinalState) modelElement;

					// Supports files saved by version 0.1.10, which don't have
					// tag type saved for some activity nodes.
					// Adds a tag type.
					fixTagType(state, "FlowFinalNode", "FinalNodeType");

					if (DeployHelper.isFlowFinal(state)) {
						node = createFlowFinalNode( graphNode);
					} else {
						node = createFinalNode(graphNode);
					}
				} else if (modelElement instanceof Object) {
					node =createObjectNode( graphNode);
					DeployHelper.getLifeLine((ObjectNode) node).setSize(
							(int) diagram.getSize().getWidth(),
							(int) diagram.getSize().getHeight());
				} else if (modelElement instanceof Comment) {
					node = createCommentNode( graphNode);
				} else if (modelElement instanceof Package) {
					node = createPackageNode( graphNode);
					createSubNodes((NodeContainer) node, view, isConverted);
				} else if (modelElement instanceof Interface) {
					node=createInterfaceNode(graphNode);

					// Support files saved by version 0.1.10, which don't have
					// tag type saved for each parameter.
					fixTagType((Classifier) modelElement);
				} else if (modelElement instanceof Class) {
					// Support file saved by old versions where some int type of
					// parameters added through properties
					// panel after loading not saved. Fix since 0.1.13.

					Classifier classifer = (Classifier) modelElement;
					for (Feature feature : classifer.getFeatures()) {
						if (feature instanceof Operation) {
							Operation operation = (Operation) feature;
							for (Parameter parameter : operation
									.getParameters()) {
								if (parameter.getType() == null) {
									parameter.setType(DeployHelper
											.getClassifier("int"));
								}
								// Fix the typeParameters of classifier
								Classifier type = parameter.getType();
								if (!type.containsTypedParameter(parameter)) {
									type.addTypedParameter(parameter);
								}
							}
						}
						// Fix the owner
						if (feature.getOwner() == null) {
							feature.setOwner(classifer);
						}
						// Fix the typeFeatures of classifier
						if (feature instanceof Attribute) {
							Attribute attribute = (Attribute) feature;
							Classifier type = attribute.getType();
							if (type != null
									&& !type.containsTypedFeature(attribute)) {
								type.addTypedFeature(attribute);
							}
						}
					}

					boolean isException = DeployHelper
							.isExceptionClass((Classifier) modelElement);
					if (isException) {
						node = createExceptionNode( graphNode);
					} else {
						node = createClassNode( graphNode);
					}

					// Support files saved by version 0.1.10, which don't have
					// tag type saved for each parameter.
					fixTagType((Classifier) modelElement);
				}

			} else if (semanticModel instanceof SimpleSemanticModelElement) {
				if (DeployHelper.getTypeInfo(graphNode).equals("FreeText")) {
					node = createFreeTextNode(graphNode);
				}
			}
		}
		if (node != null) {
			view.add(node);
			if (node instanceof NodeContainer) {
				NodeContainer nodeContainer = (NodeContainer) node;
				Set<Node> set = nodeContainer
						.getNodes(DeployHelper.BODY_COMPARTMENT);
				if (set != null && set.size() > 0) {
					DeployHelper.updateZOrder(nodeContainer);
				}
			} else if (isConverted) {
				view.setComponentZOrder(node, 0);
			}
		}
		return node;
	}
	/**
     * <p>
     * Creates a class node by graph node.
     * </p>
     * @param mainFrame
     *            reference to main frame
     * @param graphNode
     *            the graph node to create component
     * @return the created component
     */
    public static ClassNode createClassNode( GraphNode graphNode) {
        Map<String, String> properties = DeployHelper.createProperties();
        ClassNode node = new ClassNode(graphNode, properties);
        
        return node;
    }

    /**
     * <p>
     * Creates an exception node by graph node.
     * </p>
     * @param mainFrame
     *            reference to main frame
     * @param graphNode
     *            the graph node to create component
     * @return the created component
     */
    public static ExceptionNode createExceptionNode( GraphNode graphNode) {
        Map<String, String> properties = DeployHelper.createProperties();
        ExceptionNode node = new ExceptionNode(graphNode, properties);
        
        return node;
    }
	/**
	 * <p>
	 * Supports files saved by version 0.1.10, which don't have tag type saved
	 * for some activity nodes. Adds a tag type.
	 * </p>
	 * 
	 * @param element
	 *            the element of activity node to fix tag type
	 * @param dataValue
	 *            the data value of tagged value whose type is to be fixed
	 * @param tagType
	 *            the new tag type name
	 */
	private static void fixTagType(ModelElement element, String dataValue,
			String tagType) {
		for (TaggedValue taggedValue : element.getTaggedValues()) {
			if (dataValue.equals(taggedValue.getDataValue())
					&& taggedValue.getType() == null) {
				taggedValue.setType(DeployHelper.getTagDefinition(tagType));
				break;
			}
		}
	}
	/**
	 * <p>
	 * Supports files saved by version 0.1.10, which don't have tag type saved
	 * for each parameter. Adds a tag type.
	 * </p>
	 * 
	 * @param classifier
	 *            classifier whose operation parameters should be fixed
	 */
	private static void fixTagType(Classifier classifier) {
		for (Feature feature : classifier.getFeatures()) {
			if (feature instanceof Operation) {
				Operation operation = (Operation) feature;
				for (Parameter parameter : operation.getParameters()) {
					fixTaggedValues(parameter);
				}
			}

			// Add this fix since 1.0.2
			fixTaggedValues(feature);
		}
		// Add this fix since 1.0.2
		fixTaggedValues(classifier);
	}

	/**
	 * <p>
	 * Fixes the tagged values for given model element.
	 * </p>
	 * 
	 * @param modelElement
	 *            the element to fix tagged values
	 */
	private static void fixTaggedValues(ModelElement modelElement) {
		for (TaggedValue taggedValue : modelElement.getTaggedValues()) {
			if (taggedValue.getType() == null) {
				appendTagDefinition(taggedValue);
			}
		}
	}
	/**
	 * <p>
	 * Appends a default tag definition for given tagged value.
	 * </p>
	 * 
	 * @param taggedValue
	 *            the tagged value to add tag definition
	 */
	private static void appendTagDefinition(TaggedValue taggedValue) {
		// Find the tagged from model
		TagDefinition documentTagDef = null;
		Model model = UMLModelManager.getInstance().getModel();
		for (ModelElement modelElement : model.getOwnedElements()) {
			if (modelElement instanceof TagDefinition) {
				TagDefinition tagDefinition = (TagDefinition) modelElement;
				if ("documentation".equals(tagDefinition.getTagType())) {
					documentTagDef = tagDefinition;
					break;
				}
			}
		}
		if (documentTagDef == null) {
			// create new one if we can't find it from model
			documentTagDef = new TagDefinitionImpl();
			documentTagDef.setTagType("documentation");
			// add to model
			model.addOwnedElement(documentTagDef);
		}

		// set the tag type
		taggedValue.setType(documentTagDef);
	}
	

    /**
     * <p>
     * Creates a free text node by graph node.
     * </p>
     * @param mainFrame
     *            reference to main frame
     * @param graphNode
     *            the graph node to create component
     * @return the created component
     */
    public static FreeTextNode createFreeTextNode( GraphNode graphNode) {
        FreeTextNode node = new FreeTextNode(graphNode, createPropertyMapping());
       // node.addTextChangeListener(new AuxiliaryTextChangedHandler(mainFrame));
        node.addBoundaryChangeListener(new AuxiliaryBoundChangedHandler());
       // DeployHelper.addNodeHandlers(node, mainFrame);
        node.notifyUpdate();
        return node;
    }

    

    /**
     * <p>
     * Creates an object node by graph node.
     * </p>
     * @param mainFrame
     *            reference to main frame
     * @param graphNode
     *            the graph node to create component
     * @return the created component
     */
    public static ObjectNode createObjectNode( GraphNode graphNode) {
        EnumMap<ObjectNodePropertyType, String> propertyNameMapping = createObjectNodePropertyMap();
        Collection<SelectionCornerType> corners = createSelectionCorner();

        ObjectNode objectNode = null;
        Rectangle bound = new Rectangle();
        GraphConnector graphConnector = new GraphConnector();
        try {
            bound.x = SelectionCorner.DEFAULT_RADIUS;
            bound.y = SelectionCorner.DEFAULT_RADIUS;
            objectNode = new ObjectNode((com.topcoder.uml.model.commonbehavior.instances.Object) DeployHelper
                    .getElement(graphNode), graphConnector, graphNode, new Point(0, 0), bound, corners,
                    propertyNameMapping);
            objectNode.setIsNameVisible(true);
            objectNode.setIsStereotypesVisible(false);
            objectNode.addEditNameListener(new ObjectNodeEditNameHandler());
            //objectNode.addResizeListener(new ObjectNodeResizeHandler(mainFrame));
           // objectNode.addNodeDragListener(new NodeDragHandler(mainFrame));
          //  objectNode.addMouseListener(new ElementSelectionHandler(mainFrame));
           // objectNode.addCornerDragListener(new CornerDragHandler(mainFrame, CornerDragType.HORIZONTAL));
            //objectNode.addMouseListener(new NodeMouseHandler(mainFrame));
            
            objectNode.setConnector(new ObjectNodeConnector(objectNode));
            Lifeline lifeline = createLifeline(objectNode);

            objectNode.add(lifeline);
            objectNode.notifyGraphNodeChange("Creating");
        } catch (IllegalGraphElementException e) {
            e.printStackTrace();
        }
        return objectNode;
    }
    /**
     * <p>
     * create corner selection for object node
     * </p>
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
     * @return the property name map
     */
    private static EnumMap<ObjectNodePropertyType, String> createObjectNodePropertyMap() {
        EnumMap<ObjectNodePropertyType, String> propertyNameMapping = new EnumMap<ObjectNodePropertyType, String>(
                ObjectNodePropertyType.class);
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
     * Creates a lifeline.
     * </p>
     * @return the created component
     */
    private static Lifeline createLifeline(ObjectNode objectNode) {
        GraphEdge graphEdge = new GraphEdge();
        graphEdge.addWaypoint(createPoint(objectNode.getWidth() / 2, objectNode.getHeight()));
        graphEdge.addWaypoint(createPoint(objectNode.getWidth() / 2, objectNode.getHeight()));
        Lifeline lifeline = new Lifeline(graphEdge, createLifelinePropertyMap());
        return lifeline;
    }
    /**
     * <p>
     * create life line property name map for life line
     * </p>
     * @return the property name map
     */
    private static EnumMap<LifelinePropertyType, String> createLifelinePropertyMap() {
        EnumMap<LifelinePropertyType, String> propertyNameMapping = new EnumMap<LifelinePropertyType, String>(
                LifelinePropertyType.class);
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
     * Creates a point for diagram element.
     * </p>
     * @param point
     *            java.awt.point type
     * @return a point for diagram element
     */
    public static com.topcoder.diagraminterchange.Point createPoint(Point point) {
        return createPoint(point.getX(), point.getY());
    }
    /**
     * <p>
     * Creates a point for diagram element.
     * </p>
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
	 * Creates sub nodes for given node container.
	 * </p>
	 * 
	 * @param nodeContainer
	 *            node container whose sub nodes should be created
	 * @param view
	 *            diagram view holding the nodes
	 * @param isConverted
	 *            whether is converted from .zuml
	 */
	public static void createSubNodes(NodeContainer nodeContainer, DiagramView view,
			boolean isConverted) {
		GraphNode graphNode = nodeContainer.getGraphNode();
		GraphNode bodyCompartment = (GraphNode) graphNode.getContaineds()
				.get(1);

		// Support files saved by versions before 1.1.6
		moveElementsToBodyCompartment(graphNode, bodyCompartment);

		for (DiagramElement diagramElement : bodyCompartment.getContaineds()) {
			if (diagramElement instanceof GraphNode) {
				Node subNode = createNode((GraphNode) diagramElement, view,
						isConverted);
				if (subNode != null) {
					nodeContainer.addNode(DeployHelper.BODY_COMPARTMENT,
							subNode);
				}
			}
		}
	}
	/**
	 * <p>
	 * Moves contained sub elements to body compartment for given graph node of
	 * node container.
	 * </p>
	 * 
	 * @param graphNode
	 *            graph node of node container
	 * @param bodyCompartment
	 *            graph node for the body compartment
	 */
	public static void moveElementsToBodyCompartment(GraphNode graphNode,
			GraphNode bodyCompartment) {
		int size = graphNode.getContaineds().size();
		if (size > 2) {
			bodyCompartment.setPosition(DeployHelper.createPoint(0, 0));
			for (int i = 2; i < size; i++) {
				DiagramElement diagramElement = graphNode.getContaineds()
						.get(i);
				DeployHelper.addContained(bodyCompartment, diagramElement);
			}
			for (int i = 2; i < size; i++) {
				graphNode.removeContained(2);
			}
		}
	}
	/**
     * <p>
     * Creates an use case node by graph node.
     * </p>
     * @param mainFrame
     *            reference to main frame
     * @param graphNode
     *            the graph node to create component
     * @return the created component
     */
    public static UseCaseNode createUsecaseNode(GraphNode graphNode) {
        Map<String, String> properties = DeployHelper.createProperties();
        UseCaseNode node = new UseCaseNode(graphNode, properties);
        DeployHelper.replaceTextHandlers(node.getNameCompartment());
        DeployHelper.replaceTextHandlers(node.getStereotypeCompartment());
        DeployHelper.replaceTextHandlers(node.getNamespaceCompartment());
      //  node.getNameCompartment().addTextChangeListener(new UsecaseNameChangedHandler(mainFrame));
      //  DeployHelper.addNodeHandlers(node, mainFrame);
        return node;
    }

    /**
     * <p>
     * Creates an actor node by graph node.
     * </p>
     * @param mainFrame
     *            reference to main frame
     * @param graphNode
     *            the graph node to create component
     * @return the created component
     */
    public static ActorNode createActorNode( GraphNode graphNode) {
        Map<String, String> properties = DeployHelper.createProperties();
        ActorNode node = new ActorNode(graphNode, properties);
        DeployHelper.replaceTextHandlers(node.getNameCompartment());
        DeployHelper.replaceTextHandlers(node.getStereotypeCompartment());
        DeployHelper.replaceTextHandlers(node.getNamespaceCompartment());
    //    node.getNameCompartment().addTextChangeListener(new UsecaseNameChangedHandler(mainFrame));
    //    DeployHelper.addNodeHandlers(node, mainFrame);
        return node;
    }

    /**
     * <p>
     * Creates a subsystem node by graph node.
     * </p>
     * @param mainFrame
     *            reference to main frame
     * @param graphNode
     *            the graph node to create component
     * @return the created component
     */
    public static SubsystemNodeContainer createSubsystemNode(GraphNode graphNode) {
        Map<String, String> properties = DeployHelper.createProperties();
        SubsystemNodeContainer node = new SubsystemNodeContainer(graphNode, properties, new TransferHandler(null));
        DeployHelper.replaceTextHandlers(node.getNameCompartment());
        DeployHelper.replaceTextHandlers(node.getStereotypeCompartment());
        DeployHelper.replaceTextHandlers(node.getNamespaceCompartment());
      //  node.getNameCompartment().addTextChangeListener(new UsecaseNameChangedHandler(mainFrame));
      //  DeployHelper.addNodeHandlers(node, mainFrame);
        return node;
    }

    /**
     * <p>
     * Creates an accept event action node by graph node.
     * </p>
     * @param mainFrame
     *            reference to main frame
     * @param graphNode
     *            the graph node to create component
     * @return the created component
     */
    public static AcceptEventAction createAcceptEventActionNode( GraphNode graphNode) {
        Map<String, String> properties = DeployHelper.createProperties();
        AcceptEventAction node = new AcceptEventAction(graphNode, properties, new Point(), new Rectangle());
        DeployHelper.replaceTextHandlers(node.getNameCompartment());
        DeployHelper.replaceTextHandlers(node.getStereotypeCompartment());
        //node.getNameCompartment().addTextChangedListener(new ActivityNameChangedHandler(mainFrame));
        node.addBoundaryChangedListener(new ActivityBoundChangedHandler());
        //DeployHelper.addNodeHandlers(node, mainFrame);
        return node;
    }

    /**
     * <p>
     * Creates an action state node by graph node.
     * </p>
     * @param mainFrame
     *            reference to main frame
     * @param graphNode
     *            the graph node to create component
     * @return the created component
     */
    public static ActionState createActionStateNode(GraphNode graphNode) {
        Map<String, String> properties = DeployHelper.createProperties();
        ActionState node = new ActionState(graphNode, properties, new Point(), new Rectangle());
        DeployHelper.replaceTextHandlers(node.getNameCompartment());
        DeployHelper.replaceTextHandlers(node.getStereotypeCompartment());
      //  node.getNameCompartment().addTextChangedListener(new ActivityNameChangedHandler(mainFrame));
        node.addBoundaryChangedListener(new ActivityBoundChangedHandler());
       // DeployHelper.addNodeHandlers(node, mainFrame);
        return node;
    }

    /**
     * <p>
     * Creates a decision node by graph node.
     * </p>
     * @param mainFrame
     *            reference to main frame
     * @param graphNode
     *            the graph node to create component
     * @return the created component
     */
    public static DecisionNode createDecisionNode( GraphNode graphNode) {
        Map<String, String> properties = DeployHelper.createProperties();
        DecisionNode node = new DecisionNode(graphNode, properties, new Point(), new Rectangle());
        DeployHelper.replaceTextHandlers(node.getNameCompartment());
        DeployHelper.replaceTextHandlers(node.getStereotypeCompartment());
       // node.getNameCompartment().addTextChangedListener(new ActivityNameChangedHandler(mainFrame));
        node.addBoundaryChangedListener(new ActivityBoundChangedHandler());
      //  DeployHelper.addNodeHandlers(node, mainFrame);
        return node;
    }

    /**
     * <p>
     * Creates a final node by graph node.
     * </p>
     * @param mainFrame
     *            reference to main frame
     * @param graphNode
     *            the graph node to create component
     * @return the created component
     */
    public static FinalNode createFinalNode(GraphNode graphNode) {
        Map<String, String> properties = DeployHelper.createProperties();
        FinalNode node = new FinalNode(graphNode, properties, new Point(), new Rectangle());
        DeployHelper.replaceTextHandlers(node.getNameCompartment());
        DeployHelper.replaceTextHandlers(node.getStereotypeCompartment());
       // node.getNameCompartment().addTextChangedListener(new ActivityNameChangedHandler(mainFrame));
        node.addBoundaryChangedListener(new ActivityBoundChangedHandler());
        //DeployHelper.addNodeHandlers(node, mainFrame);
        return node;
    }

    /**
     * <p>
     * Creates a flow final node by graph node.
     * </p>
     * @param mainFrame
     *            reference to main frame
     * @param graphNode
     *            the graph node to create component
     * @return the created component
     */
    public static FlowFinalNode createFlowFinalNode( GraphNode graphNode) {
        Map<String, String> properties = DeployHelper.createProperties();
        FlowFinalNode node = new FlowFinalNode(graphNode, properties, new Point(), new Rectangle());
        DeployHelper.replaceTextHandlers(node.getNameCompartment());
        DeployHelper.replaceTextHandlers(node.getStereotypeCompartment());
       // node.getNameCompartment().addTextChangedListener(new ActivityNameChangedHandler(mainFrame));
        node.addBoundaryChangedListener(new ActivityBoundChangedHandler());
       //.addNodeHandlers(node, mainFrame);
        return node;
    }

    /**
     * <p>
     * Creates a fork node by graph node.
     * </p>
     * @param mainFrame
     *            reference to main frame
     * @param graphNode
     *            the graph node to create component
     * @return the created component
     */
    public static ForkNode createForkNode( GraphNode graphNode) {
        Map<String, String> properties = DeployHelper.createProperties();
        ForkNode node = new ForkNode(graphNode, properties, new Point(), new Rectangle());
        DeployHelper.replaceTextHandlers(node.getNameCompartment());
        DeployHelper.replaceTextHandlers(node.getStereotypeCompartment());
       // node.getNameCompartment().addTextChangedListener(new ActivityNameChangedHandler(mainFrame));
        node.addBoundaryChangedListener(new ActivityBoundChangedHandler());
       // DeployHelper.addNodeHandlers(node, mainFrame);
        return node;
    }

    /**
     * <p>
     * Creates an initial node by graph node.
     * </p>
     * @param mainFrame
     *            reference to main frame
     * @param graphNode
     *            the graph node to create component
     * @return the created component
     */
    public static InitialNode createInitialNode( GraphNode graphNode) {
        Map<String, String> properties = DeployHelper.createProperties();
        InitialNode node = new InitialNode(graphNode, properties, new Point(), new Rectangle());
        DeployHelper.replaceTextHandlers(node.getNameCompartment());
        DeployHelper.replaceTextHandlers(node.getStereotypeCompartment());
      //  node.getNameCompartment().addTextChangedListener(new ActivityNameChangedHandler(mainFrame));
        node.addBoundaryChangedListener(new ActivityBoundChangedHandler());
      //  DeployHelper.addNodeHandlers(node, mainFrame);
        return node;
    }

    /**
     * <p>
     * Creates a join node by graph node.
     * </p>
     * @param mainFrame
     *            reference to main frame
     * @param graphNode
     *            the graph node to create component
     * @return the created component
     */
    public static JoinNode createJoinNode( GraphNode graphNode) {
        Map<String, String> properties = DeployHelper.createProperties();
        JoinNode node = new JoinNode(graphNode, properties, new Point(), new Rectangle());
        DeployHelper.replaceTextHandlers(node.getNameCompartment());
        DeployHelper.replaceTextHandlers(node.getStereotypeCompartment());
       // node.getNameCompartment().addTextChangedListener(new ActivityNameChangedHandler(mainFrame));
        node.addBoundaryChangedListener(new ActivityBoundChangedHandler());
       // DeployHelper.addNodeHandlers(node, mainFrame);
        return node;
    }

    /**
     * <p>
     * Creates a merge node by graph node.
     * </p>
     * @param mainFrame
     *            reference to main frame
     * @param graphNode
     *            the graph node to create component
     * @return the created component
     */
    public static MergeNode createMergeNode(GraphNode graphNode) {
        Map<String, String> properties = DeployHelper.createProperties();
        MergeNode node = new MergeNode(graphNode, properties, new Point(), new Rectangle());
        DeployHelper.replaceTextHandlers(node.getNameCompartment());
        DeployHelper.replaceTextHandlers(node.getStereotypeCompartment());
      //  node.getNameCompartment().addTextChangedListener(new ActivityNameChangedHandler(mainFrame));
        node.addBoundaryChangedListener(new ActivityBoundChangedHandler());
      //  DeployHelper.addNodeHandlers(node, mainFrame);
        return node;
    }

    /**
     * <p>
     * Creates a object flow node by graph node.
     * </p>
     * @param mainFrame
     *            reference to main frame
     * @param graphNode
     *            the graph node to create component
     * @return the created component
     */
    public static ObjectFlowNode createObjectFlowNode(GraphNode graphNode) {
        Map<String, String> properties = DeployHelper.createProperties();
        ObjectFlowNode node = new ObjectFlowNode(graphNode, properties, new Point(), new Rectangle());
        DeployHelper.replaceTextHandlers(node.getNameCompartment());
        DeployHelper.replaceTextHandlers(node.getStereotypeCompartment());
        node.addBoundaryChangedListener(new ActivityBoundChangedHandler());

        return node;
    }

    /**
     * <p>
     * Creates a send signal action node by graph node.
     * </p>
     * @param mainFrame
     *            reference to main frame
     * @param graphNode
     *            the graph node to create component
     * @return the created component
     */
    public static SendSignalAction createSendSignalActionNode( GraphNode graphNode) {
        Map<String, String> properties = DeployHelper.createProperties();
        SendSignalAction node = new SendSignalAction(graphNode, properties, new Point(), new Rectangle());
        DeployHelper.replaceTextHandlers(node.getNameCompartment());
        DeployHelper.replaceTextHandlers(node.getStereotypeCompartment());
        node.addBoundaryChangedListener(new ActivityBoundChangedHandler());

        return node;
    }

    /**
     * <p>
     * Creates an association edge by graph edge.
     * </p>
     * @param mainFrame
     *            reference to main frame
     * @param diagramView
     *            reference to diagram view
     * @param graphEdge
     *            the graph edge to create component
     * @return the created component
     */
    public static AssociationEdge createAssociationEdge(DiagramView diagramView,
            GraphEdge graphEdge) {
        AssociationEdge edge = null;
        try {
            edge = new AssociationEdge(graphEdge);
            edge.setProperties(DeployHelper.createProperties());
            edge.notifyPropertiesChange();

            // Edge's size is the same as the DiagramView
            edge.setSize(diagramView.getSize());
        } catch (com.topcoder.gui.diagramviewer.uml.classedges.IllegalGraphElementException e) {
            e.printStackTrace();
        }
        return edge;
    }

    /**
     * <p>
     * Creates a dependency edge by graph edge.
     * </p>
     * @param mainFrame
     *            reference to main frame
     * @param diagramView
     *            reference to diagram view
     * @param graphEdge
     *            the graph edge to create component
     * @return the created component
     */
    public static DependencyEdge createDependencyEdge( DiagramView diagramView, GraphEdge graphEdge) {
        DependencyEdge edge = null;
        try {
            edge = new DependencyEdge(graphEdge);
            edge.setProperties(DeployHelper.createProperties());
            edge.notifyPropertiesChange();

            // Edge's size is the same as the DiagramView
            edge.setSize(diagramView.getSize());
        } catch (com.topcoder.gui.diagramviewer.uml.classedges.IllegalGraphElementException e) {
            e.printStackTrace();
        }
        return edge;
    }

    /**
     * <p>
     * Creates a generalization edge by graph edge.
     * </p>
     * @param mainFrame
     *            reference to main frame
     * @param diagramView
     *            reference to diagram view
     * @param graphEdge
     *            the graph edge to create component
     * @return the created component
     */
    public static GeneralizationEdge createGeneralizationEdge(DiagramView diagramView,
            GraphEdge graphEdge) {
        GeneralizationEdge edge = null;
        try {
            edge = new GeneralizationEdge(graphEdge);
            edge.setProperties(DeployHelper.createProperties());

            // Edge's size is the same as the DiagramView
            edge.setSize(diagramView.getSize());
          
            
        } catch (com.topcoder.gui.diagramviewer.uml.classedges.IllegalGraphElementException e) {
          e.printStackTrace();
        }
        return edge;
    }
	/**
     * <p>
     * Creates a PolylineNode.
     * </p>
     * @param mainFrame
     *            reference to main frame
     * @param polyline
     *            the poly line to create component
     * @return the created component
     */
    public static PolylineNode createPolylineNode(Polyline polyline) {
        PolylineNode node = new PolylineNode(polyline, createPropertyMapping());
       
        return node;
    }
    /**
     * <p>
     * Creates property mapping for auxiliary elements.
     * </p>
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
	 * Supports files saved by early version which don't have element's
	 * namespace saved. Restores its namespace.
	 * </p>
	 * 
	 * @param graphNode
	 *            graph node containing model element whose namespace should be
	 *            set
	 * @param modelElement
	 *            model element whose namespace should be set
	 */
	public static void fixNamespace(GraphNode graphNode, ModelElement modelElement) {
		GraphNode container = (GraphNode) graphNode.getContainer();

		if (modelElement instanceof Object) {
			// Set namespace to collaboration
			if (modelElement.getNamespace() == null
					|| !(modelElement.getNamespace() instanceof Collaboration)) {
				Diagram diagram = (Diagram) container;
				Uml1SemanticModelBridge bridge = (Uml1SemanticModelBridge) diagram
						.getOwner();
				Collaboration collaboration = (Collaboration) bridge
						.getElement();
				modelElement.setNamespace(collaboration);
			}
		} else {
			Namespace namespace = UMLModelManager.getInstance().getModel();

			if (modelElement.getNamespace() == null
					|| (modelElement.getNamespace() != namespace && DeployHelper
							.containsNamespace(modelElement.getNamespace(),
									namespace))) {
				Namespace owner = findOwnerNamespace(namespace, modelElement);
				if (owner != null) {
					modelElement.setNamespace(owner);
				} else {
					modelElement.setNamespace(namespace);
					if (!namespace.containsOwnedElement(modelElement)) {
						namespace.addOwnedElement(modelElement);
					}
				}
			}
		}

		fixOwnership(modelElement);
	}
	
	/**
	 * <p>
	 * Changes namespace for given model element. Remove the element from old
	 * namespace, and then add it to new namespace.
	 * </p>
	 * 
	 * @param modelElement
	 *            the model element which namespace is to be changed
	 */
	public static void fixOwnership(ModelElement modelElement) {
		// To fix the namespace completely, make sure the namespace contains the
		// model element
		if (!modelElement.getNamespace().containsOwnedElement(modelElement)) {
			// Find old namespace which contains the model element
			Namespace oldNamespace = findOwnerNamespace(UMLModelManager
					.getInstance().getModel(), modelElement);
			if (oldNamespace != null) {
				oldNamespace.removeOwnedElement(modelElement);
			}
			modelElement.getNamespace().addOwnedElement(modelElement);
		}
	}

	/**
	 * <p>
	 * Finds the owner namespace for given model element.
	 * </p>
	 * 
	 * @param namespace
	 *            the namespace scope to search the owner namespace
	 * @param modelElement
	 *            the model element to find the owner namespace
	 * @return the owner namespace, null if not found
	 */
	public static  Namespace findOwnerNamespace(Namespace namespace,
			ModelElement modelElement) {
		for (ModelElement ownedElement : namespace.getOwnedElements()) {
			if (ownedElement == modelElement) {
				return namespace;
			}
			if (ownedElement instanceof Namespace) {
				Namespace owner = findOwnerNamespace((Namespace) ownedElement,
						modelElement);
				if (owner != null) {
					return owner;
				}
			}
		}
		return null;
	}
	

    /**
     * <p>
     * Creates a generalization edge by graph edge.
     * </p>
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
     * @param mainFrame
     *            reference to main frame
     * @param diagramView
     *            reference to diagram view
     * @param graphEdge
     *            the graph edge to create component
     * @return the created component
     */
    public static IncludeEdge createIncludeEdge(DiagramView diagramView, GraphEdge graphEdge) {
        IncludeEdge edge = null;
        try {
            edge = new IncludeEdge(graphEdge);
            edge.setProperties(DeployHelper.createProperties());
            edge.notifyPropertiesChange();

            // Edge's size is the same as the DiagramView
            edge.setSize(diagramView.getSize());
          //  edge.getNameCompartment().addTextChangeListener(new UsecaseNameChangedHandler(mainFrame));
          //  DeployHelper.addEdgeHandlers(edge, mainFrame);
        } catch (IllegalGraphElementException e) {
        	e.printStackTrace();
          //  DeployHelper.handleException(mainFrame, e, "Fail to create an IncludeEdge.");
        }
        return edge;
    }

    /**
     * <p>
     * Creates an extend edge by graph edge.
     * </p>
     * @param mainFrame
     *            reference to main frame
     * @param diagramView
     *            reference to diagram view
     * @param graphEdge
     *            the graph edge to create component
     * @return the created component
     */
    public static ExtendEdge createExtendEdge( DiagramView diagramView, GraphEdge graphEdge) {
        ExtendEdge edge = null;
        try {
            edge = new ExtendEdge(graphEdge);
            edge.setProperties(DeployHelper.createProperties());
            edge.notifyPropertiesChange();

            // Edge's size is the same as the DiagramView
            edge.setSize(diagramView.getSize());
           // edge.getNameCompartment().addTextChangeListener(new UsecaseNameChangedHandler(mainFrame));
         //   DeployHelper.addEdgeHandlers(edge, mainFrame);
        } catch (IllegalGraphElementException e) {
           e.printStackTrace();
        }
        return edge;
    }

    /**
     * <p>
     * Creates a transition edge by graph edge.
     * </p>
     * @param mainFrame
     *            reference to main frame
     * @param diagramView
     *            reference to diagram view
     * @param graphEdge
     *            the graph edge to create component
     * @return the created component
     */
    public static Transition createTransitionEdge( DiagramView diagramView, GraphEdge graphEdge) {
        Transition edge = null;
        try {
            edge = new Transition(graphEdge);
            edge.setProperties(DeployHelper.createProperties());
            edge.notifyPropertiesChange();

            // Edge's size is the same as the DiagramView
            edge.setSize(diagramView.getSize());
          //  edge.getNameCompartment().addTextChangedListener(new ActivityNameChangedHandler(mainFrame));
         //   DeployHelper.addEdgeHandlers(edge, mainFrame);
        } catch (IllegalGraphElementException e) {
           e.printStackTrace();
        }
        return edge;
    }

    /**
     * <p>
     * Creates a comment node by graph node.
     * </p>
     * @param mainFrame
     *            reference to main frame
     * @param graphNode
     *            the graph node to create component
     * @return the created component
     */
    public static CommentNode createCommentNode( GraphNode graphNode) {
        CommentNode node = new CommentNode(graphNode, createPropertyMapping());
       // node.addTextChangeListener(new AuxiliaryTextChangedHandler(mainFrame));
        //node.addBoundaryChangeListener(new AuxiliaryBoundChangedHandler());
       // DeployHelper.addNodeHandlers(node, mainFrame);
        node.notifyUpdate();
        return node;
    }
    
    /**
     * <p>
     * Creates a package node by graph node.
     * </p>
     * @param mainFrame
     *            reference to main frame
     * @param graphNode
     *            the graph node to create component
     * @return the created component
     */
    public static PackageNode createPackageNode(GraphNode graphNode) {
        Map<String, String> properties = DeployHelper.createProperties();
        PackageNode node = new PackageNode(graphNode, properties, new TransferHandler(null));
        DeployHelper.replaceTextHandlers(node.getNameCompartment());
        DeployHelper.replaceTextHandlers(node.getStereotypeCompartment());
        DeployHelper.replaceTextHandlers(node.getNamespaceCompartment());
    //    node.getNameCompartment().addTextChangedListener(new ClassNameChangedHandler(mainFrame));
    //    DeployHelper.addNodeHandlers(node, mainFrame);
        return node;
    }
    /**
     * <p>
     * Creates an Interface node by graph node.
     * </p>
     * @param mainFrame
     *            reference to main frame
     * @param graphNode
     *            the graph node to create component
     * @return the created component
     */
    public static InterfaceNode createInterfaceNode(GraphNode graphNode) {
        Map<String, String> properties = DeployHelper.createProperties();
        InterfaceNode node = new InterfaceNode(graphNode, properties);
        return node;
    }
    
    /**
     * <p>
     * get the property as string from config file.
     * </p>
     *
     *@param key the property name
     *@return the property as string
     * @throws Exception
     *             to JUnit
     */
	public static String getProperty(String ns,String key) throws Exception {
		ConfigManager cm = ConfigManager.getInstance();
		return (String) cm.getProperty(ns, key);
	}
	
	/**
     * <p>
     * configGetCol of namespace, if the property loads fail , return the
     * defaultValue.
     * </p>
     *
     * @param property the property will be loaded.
     * @param defaultValue the defaultValue of the property.
     * @return the value loaded from namespace ,if fail , return defaultValue
     * @throws ConfigurationException if the UnknownNamespaceException occurs.
     */
    public static Color configGetCol(String ns,String property) throws ConfigurationException {
        try {
        	ConfigManager cm = ConfigManager.getInstance();
            String color = cm.getString(ns, property);
            
            return new Color(Integer.parseInt(color, 16));
        } catch (NumberFormatException e) {
            throw new ConfigurationException("configuration error occurs when loading Color"
                    + ": The color 's format is error");
        } catch (IllegalArgumentException e) {
            throw new ConfigurationException("configuration error occurs when loading Color");
        } catch (UnknownNamespaceException e) {
            throw new ConfigurationException("configuration error occurs when loading Color"
                    + ": The namespace is unknown");
        }
    }
}

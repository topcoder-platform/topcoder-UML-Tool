/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.handlers;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.tree.DefaultMutableTreeNode;

import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.GraphElement;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.DiagramViewer;
import com.topcoder.gui.diagramviewer.edges.Edge;
import com.topcoder.gui.diagramviewer.edges.SelectionCorner;
import com.topcoder.gui.diagramviewer.edges.TextField;
import com.topcoder.gui.diagramviewer.elements.Node;
import com.topcoder.gui.panels.properties.PropertiesPanel;
import com.topcoder.gui.trees.document.DocumentTreeNode;
import com.topcoder.gui.trees.document.DocumentTreePanel;
import com.topcoder.gui.trees.document.DocumentTreeView;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.umltool.deploy.DeployHelper;
import com.topcoder.umltool.deploy.MainFrame;

/**
 * <p>
 * This class defines utilities used for handlers.
 * </p>
 *
 * @author ly, FireIce, ylouis, TCSDEVELOPER
 * @version 1.0
 */
public final class HandlerHelper {

    /**
     * <p>
     * Represents the default size for ActorNode.
     * </p>
     */
    static final Dimension DEFAULT_ACTOR_SIZE = new Dimension(40, 80);

    /**
     * <p>
     * Represents the default size for UseCaseNode.
     * </p>
     */
    static final Dimension DEFAULT_USECASE_SIZE = new Dimension(90, 50);

    /**
     * <p>
     * Represents the default size for SubsystemNodeContainer.
     * </p>
     */
    static final Dimension DEFAULT_SUBSYSTEM_SIZE = new Dimension(100, 80);

    /**
     * <p>
     * Represents the default size for InitialNode.
     * </p>
     */
    static final Dimension DEFAULT_INITIAL_SIZE = new Dimension(30, 30);

    /**
     * <p>
     * Represents the default size for AcceptEventAction.
     * </p>
     */
    static final Dimension DEFAULT_ACCEPTEVENT_SIZE = new Dimension(160, 40);

    /**
     * <p>
     * Represents the default size for ActionState.
     * </p>
     */
    static final Dimension DEFAULT_ACTIONSTATE_SIZE = new Dimension(80, 40);

    /**
     * <p>
     * Represents the default size for DecisionNode.
     * </p>
     */
    static final Dimension DEFAULT_DECISION_SIZE = new Dimension(20, 20);

    /**
     * <p>
     * Represents the default size for FinalNode.
     * </p>
     */
    static final Dimension DEFAULT_FINAL_SIZE = new Dimension(30, 30);

    /**
     * <p>
     * Represents the default size for FlowFinalNode.
     * </p>
     */
    static final Dimension DEFAULT_FLOWFINAL_SIZE = new Dimension(30, 30);

    /**
     * <p>
     * Represents the default size for ForkNode.
     * </p>
     */
    static final Dimension DEFAULT_FORK_SIZE = new Dimension(70, 10);

    /**
     * <p>
     * Represents the default size for JoinNode.
     * </p>
     */
    static final Dimension DEFAULT_JOIN_SIZE = new Dimension(70, 10);

    /**
     * <p>
     * Represents the default size for MergeNode.
     * </p>
     */
    static final Dimension DEFAULT_MERGE_SIZE = new Dimension(20, 20);

    /**
     * <p>
     * Represents the default size for ObjectFlowNode.
     * </p>
     */
    static final Dimension DEFAULT_OBJECTFLOW_SIZE = new Dimension(100, 40);

    /**
     * <p>
     * Represents the default size for SendSignalAction.
     * </p>
     */
    static final Dimension DEFAULT_SENDSIGNAL_SIZE = new Dimension(160, 40);

    /**
     * <p>
     * Represents the default size for CommentNode.
     * </p>
     */
    static final Dimension DEFAULT_COMMENT_SIZE = new Dimension(150, 100);

    /**
     * <p>
     * Represents the default size for FreeTextNode.
     * </p>
     */
    static final Dimension DEFAULT_FREETEXT_SIZE = new Dimension(100, 20);

    /**
     * <p>
     * Represents the default size for rectangle shape.
     * </p>
     */
    static final Dimension DEFAULT_SHAPE_SIZE = new Dimension(80, 40);

    /**
     * <p>
     * Represents the default size for PackageNode.
     * </p>
     */
    static final Dimension DEFAULT_PACKAGE_SIZE = new Dimension(140, 120);

    /**
     * <p>
     * Represents the default size for ClassNode.
     * </p>
     */
    static final Dimension DEFAULT_CLASS_SIZE = new Dimension(100, 72);

    /**
     * <p>
     * Clears the old document tree viwe's selected.
     * </p>
     *
     * @param mainFrame
     *            the mainframe
     * @param oldView
     *            the old document tree view
     */
    public static void treeViewChanged(MainFrame mainFrame, DocumentTreeView oldView) {
        DiagramViewer diagramViewer = mainFrame.getDiagramViewer();
        List<JComponent> components = new ArrayList<JComponent>();
        components.addAll(diagramViewer.getAllSelectedElements());
        oldView.getTree().setSelectionPath(null);
        for (JComponent component : components) {
            diagramViewer.addSelectedElement(component);
            if (component instanceof Node) {
                ((Node) component).notifySelected();
            }
            if (component instanceof Edge) {
                ((Edge) component).notifySelected();
            }
        }
        DeployHelper.notifySelectionChanged(mainFrame, diagramViewer);
    }

    /**
     * <p>
     * Gets the selected component which is corresponding to the model element.
     * </p>
     *
     * @param modelElment
     *            the model element
     * @param mainFrame
     *            the mainframe
     * @return the corresponded component
     */
    public static JComponent getSelectComponent(ModelElement modelElment, MainFrame mainFrame) {
        DiagramViewer diagramViewer = mainFrame.getDiagramViewer();
        List<JComponent> selectedDiagramElements = diagramViewer.getAllSelectedElements();
        for (JComponent jComponent : selectedDiagramElements) {
            if (jComponent instanceof Node) {
                if (DeployHelper.getElement(((Node) jComponent).getGraphNode()) == modelElment) {
                    return jComponent;
                }
            } else if (jComponent instanceof Edge) {
                if (DeployHelper.getElement(((Edge) jComponent).getGraphEdge()) == modelElment) {
                    return jComponent;
                }
            }
        }
        return null;
    }

    /**
     * <p>
     * Gets the selected node which is corresponding to the graph node.
     * </p>
     *
     * @param graphNode
     *            the graph node
     * @param mainFrame
     *            the mainframe
     * @return the corresponded node
     */
    public static Node getSelectNode(GraphNode graphNode, MainFrame mainFrame) {
        DiagramViewer diagramViewer = mainFrame.getDiagramViewer();
        List<JComponent> selectedDiagramElements = diagramViewer.getAllSelectedElements();
        for (JComponent jComponent : selectedDiagramElements) {
            if (jComponent instanceof Node) {
                if (((Node) jComponent).getGraphNode() == graphNode) {
                    return (Node) jComponent;
                }
            }
        }
        return null;
    }

    /**
     * <p>
     * Gets the selected edge which is corresponding to the graph edge.
     * </p>
     *
     * @param graphEdge
     *            the graph edge
     * @param mainFrame
     *            the mainframe
     * @return the corresponded edge
     */
    public static Edge getSelectEdge(GraphEdge graphEdge, MainFrame mainFrame) {
        DiagramViewer diagramViewer = mainFrame.getDiagramViewer();
        List<JComponent> selectedDiagramElements = diagramViewer.getAllSelectedElements();
        for (JComponent jComponent : selectedDiagramElements) {
            if (jComponent instanceof Edge) {
                if (((Edge) jComponent).getGraphEdge() == graphEdge) {
                    return (Edge) jComponent;
                }
            }
        }
        return null;
    }

    /**
     * <p>
     * Gets the document tree nodes which is corresponding to input document tree nodes in document tree view.
     * </p>
     *
     * @param documentTreeNodes
     *            the document tree nodes
     * @param view
     *            the document tree view
     * @return the corresponded document tree nodes
     */
    public static List<DocumentTreeNode> getDocumentTreeNodes(DocumentTreeNode[] documentTreeNodes,
        DocumentTreeView view) {
        List<DocumentTreeNode> treeNodes = new ArrayList<DocumentTreeNode>();
        for (DocumentTreeNode node : documentTreeNodes) {
            treeNodes.add(node);
        }
        List<DocumentTreeNode> nodes = new ArrayList<DocumentTreeNode>();
        JTree jTree = view.getTree();
        DefaultMutableTreeNode root = (DefaultMutableTreeNode) jTree.getModel().getRoot();
        java.util.Enumeration<?> df = root.depthFirstEnumeration();
        DocumentTreeNode treeNode = null;
        while (df.hasMoreElements()) {
            treeNode = (DocumentTreeNode) ((DefaultMutableTreeNode) df.nextElement()).getUserObject();
            if (treeNodes.contains(treeNode)) {
                nodes.add(treeNode);
            }
        }
        return nodes;
    }

    /**
     * <p>
     * Updates the panels according to the component.
     * </p>
     *
     * @param jComponent
     *            the component
     * @param mainFrame
     *            the mainframe
     */
    public static void updatePanels(JComponent jComponent, MainFrame mainFrame) {
        updateDiagramViewer(jComponent, mainFrame);
        updateDocumentTree(jComponent, mainFrame);
        updatePropertyPanel(jComponent, mainFrame);
    }

    /**
     * <p>
     * Updates the component in the diagram viewer.
     * </p>
     *
     * @param jComponent
     *            the component
     * @param mainFrame
     *            the mainframe
     */
    private static void updateDiagramViewer(JComponent jComponent, MainFrame mainFrame) {
        if (jComponent instanceof Node) {
            DeployHelper.nodeNotifyChange((Node) jComponent, "Name changed", mainFrame);
        } else if (jComponent instanceof Edge) {
            DeployHelper.edgeNotifyChange((Edge) jComponent);
        } else if (jComponent instanceof TextField) {
            DeployHelper.nodeNotifyChange((Node) ((TextField) jComponent).getParent().getParent(), "Name changed",
                mainFrame);
        }
    }

    /**
     * <p>
     * Updates the component in the document tree.
     * </p>
     *
     * @param jComponent
     *            the component
     * @param mainFrame
     *            the mainframe
     */
    private static void updateDocumentTree(JComponent jComponent, MainFrame mainFrame) {
        GraphElement graphElement = null;
        if (jComponent instanceof Node) {
            graphElement = ((Node) jComponent).getGraphNode();
        } else if (jComponent instanceof Edge) {
            graphElement = ((Edge) jComponent).getGraphEdge();
        } else if (jComponent instanceof TextField) {
            graphElement = ((TextField) jComponent).getGraphNode();
        }

        ModelElement modelElement = DeployHelper.getElement(graphElement);
        for (DocumentTreePanel panel : mainFrame.getDocumentTree().getPanels()) {
            for (DocumentTreeView documentTreeView : panel.getAllViews()) {
                for (DocumentTreeNode documentTreeNode : DeployHelper.getDocumentTreeNode(modelElement,
                    documentTreeView)) {
                    documentTreeView.updateTreeNode(documentTreeNode);
                }
                documentTreeView.getTree().repaint();
            }
        }
    }

    /**
     * <p>
     * Updates the component in the property panel.
     * </p>
     *
     * @param jComponent
     *            the component
     * @param mainFrame
     *            the mainframe
     */
    private static void updatePropertyPanel(JComponent jComponent, MainFrame mainFrame) {
        PropertiesPanel propertiesPanel = mainFrame.getPropertiesPanel();
        if (propertiesPanel.getConfiguredModelElements().size() > 0) {
            propertiesPanel.configurePanel(propertiesPanel.getConfiguredModelElements());
        }
    }

    /**
     * <p>
     * Finds a way point's index from an edge.
     * </p>
     *
     * @param edge
     *            edge containing this way point
     * @param wayPoint
     *            a way point
     * @return index for this way point, -1 if not found
     */
    static int findIndex(Edge edge, Point wayPoint) {
        for (int i = 0; i < edge.getWayPoints().size(); i++) {
            SelectionCorner corner = edge.getWayPoints().get(i);
            if (corner.getCenter().equals(wayPoint)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * <p>
     * Checks whether a point is above a segment.
     * </p>
     *
     * @param point
     *            point need checking
     * @param edge
     *            edge containing the segment
     * @param segment
     *            line need checking
     * @return true if point is above line, otherwise false
     */
    static boolean isAboveEdge(Point point, Edge edge, Line2D segment) {
        Point2D start = segment.getP1();
        Point2D end = segment.getP2();
        return Line2D.ptSegDist(start.getX(), start.getY(), end.getX(), end.getY(), point.x, point.y) <= edge
            .getActiveWidth() / 2;
    }

    /**
     * <p>
     * Finds an index for a new inserted way point.
     * </p>
     *
     * @param edge
     *            edge containing this way point
     * @param wayPoint
     *            a way point
     * @return index for this way point, -1 if not found
     */
    static int findInsertIndex(Edge edge, Point wayPoint) {
        int size = edge.getWayPoints().size();
        for (int i = 0; i < size - 1; i++) {
            Point start = edge.getWayPoints().get(i).getCenter();
            Point end = edge.getWayPoints().get(i + 1).getCenter();
            if (isAboveEdge(wayPoint, edge, new Line2D.Double(start, end))) {
                return i + 1;
            }
        }
        return -1;
    }

    /**
     * <p>
     * Pass the event behind.
     * </p>
     *
     * @param e
     *            the mouse released event
     */
    static void passBehind(MouseEvent e) {
        JComponent source = (JComponent) e.getSource();
        Container parent = source.getParent();
        if (parent != null) {
            Point pos = SwingUtilities.convertPoint(source, e.getPoint(), parent);
            MouseEvent event =
                new MouseEvent(parent, e.getID(), e.getWhen(), e.getModifiers(), pos.x, pos.y, e.getClickCount(),
                    e.isPopupTrigger());
            parent.dispatchEvent(event);
        }
    }
}

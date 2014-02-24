/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.handlers;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JTree;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.GraphElement;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.Polyline;
import com.topcoder.gui.diagramviewer.DiagramView;
import com.topcoder.gui.diagramviewer.DiagramViewer;
import com.topcoder.gui.diagramviewer.edges.Edge;
import com.topcoder.gui.diagramviewer.edges.TextField;
import com.topcoder.gui.diagramviewer.elements.Node;
import com.topcoder.gui.diagramviewer.uml.auxiliaryelements.PolylineNode;
import com.topcoder.gui.panels.style.StyleObject;
import com.topcoder.gui.panels.style.styleobject.GraphEdgeStyleObjectAdapter;
import com.topcoder.gui.panels.style.styleobject.GraphNodeStyleObjectAdapter;
import com.topcoder.gui.panels.style.styleobject.PolylineStyleObjectAdapter;
import com.topcoder.gui.trees.document.DocumentTreeEventListener;
import com.topcoder.gui.trees.document.DocumentTreeNode;
import com.topcoder.gui.trees.document.DocumentTreeNodeType;
import com.topcoder.gui.trees.document.DocumentTreeTabbedPane;
import com.topcoder.gui.trees.document.DocumentTreeView;
import com.topcoder.gui.trees.document.NameChangedEvent;
import com.topcoder.gui.trees.document.SelectionChangedEvent;
import com.topcoder.gui.trees.document.ViewChangedEvent;
import com.topcoder.uml.model.activitygraphs.ActivityGraph;
import com.topcoder.uml.model.collaborations.collaborationinteractions.Collaboration;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.classifiers.ClassImpl;
import com.topcoder.uml.model.core.relationships.AssociationEnd;
import com.topcoder.umltool.deploy.DeployHelper;
import com.topcoder.umltool.deploy.MainFrame;
import com.topcoder.umltool.deploy.actions.undoable.ChangeEntityNameAction;

/**
 * <p>
 * This implementation of DocumentTreeEventListener will check which elements in the document tree selected, and
 * update diagram viewer, style panel, properties panel and documentation panel in the main frame.
 * </p>
 * <p>
 * Thread safety: This class are not required to be thread-safe. They could be used in a thread safe manner in this
 * component.
 * </p>
 *
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class DocumentTreeEventHandler implements DocumentTreeEventListener {
    /**
     * <p>
     * The list contains the selected model elements.
     * </p>
     */
    private static List<ModelElement> modelElements = new ArrayList<ModelElement>();

    /**
     * <p>
     * The list contains the selected styleobjects.
     * </p>
     */
    private static List<StyleObject> styleObjects = new ArrayList<StyleObject>();

    /**
     * <p>
     * The list contains the selected document tree nodes.
     * </p>
     */
    private static List<DocumentTreeNode> documentTreeNodes = new ArrayList<DocumentTreeNode>();

    /**
     * <p>
     * The MainFrame associated with this handler.
     * </p>
     */
    private MainFrame mainFrame = null;

    /**
     * <p>
     * Creates an instance of document tree event handler with the mainframe.
     * </p>
     *
     * @param mainFrame
     *            the mainframe
     */

    public DocumentTreeEventHandler(MainFrame mainFrame) {
        DeployHelper.checkNotNull(mainFrame, "mainFrame");
        this.mainFrame = mainFrame;
    }

    /**
     * <p>
     * The selected document tree node is changed.
     * </p>
     *
     * @param event
     *            the selection changed event
     * @throws IllegalArgumentException
     *             if event is null
     */
    public void treeNodeSelectionChanged(SelectionChangedEvent event) {
        DeployHelper.checkNotNull(event, "event");
        updateNodes(event);
        updatePanels();
        openDiagram();

        DocumentTreeTabbedPane documentTreePanel = mainFrame.getDocumentTree();
        DocumentTreeView documentTreeView = documentTreePanel.getCurrentPanel().getCurrentView();
        JTree tree = documentTreeView.getTree();
        tree.scrollPathToVisible(tree.getSelectionPath());
        // BugFix: BUGR-419
        // This bug is caused by the JTree get the focus from the Document Editor.
        // So, it is better not request the focus here.
        // tree.requestFocus();
    }

    /**
     * <p>
     * Updates the node in diagram viewer and updates the document tree nodes list, model elements list and
     * styleobjects list.
     * </p>
     *
     * @param event
     *            the SelectionChangedEvent
     */
    private void updateNodes(SelectionChangedEvent event) {
        DocumentTreeNode[] nodes = event.getSelectedTreeNodes();
        boolean[] areNew = event.getAreNew();
        for (int i = 0; i < nodes.length; ++i) {
            if (areNew[i]) {
                documentTreeNodes.add(nodes[i]);
                selectNode(nodes[i], true);
            } else {
                remove(nodes[i]);
                selectNode(nodes[i], false);
            }
        }
    }

    /**
     * <p>
     * Removes the document tree node from the document tree nodes list.
     * </p>
     *
     * @param node
     *            the document tree node
     */
    private void remove(DocumentTreeNode node) {
        int i;
        for (i = 0; i < documentTreeNodes.size(); ++i) {
            if (node == documentTreeNodes.get(i)) {
                break;
            }
        }
        if (i < documentTreeNodes.size()) {
            documentTreeNodes.remove(i);
        }
    }

    /**
     * <p>
     * Removes the model element from the model elements list.
     * </p>
     *
     * @param modelElement
     *            the model element
     */
    private void remove(ModelElement modelElement) {
        int i;
        for (i = 0; i < modelElements.size(); ++i) {
            if (modelElement == modelElements.get(i)) {
                break;
            }
        }
        if (i < modelElements.size()) {
            modelElements.remove(i);
        }
    }

    /**
     * <p>
     * Updates the node corresponding to the document tree node in the diagram viewer and the model elements list.
     * </p>
     *
     * @param documentTreeNode
     *            the document tree node
     * @param isSelected
     *            the flag whether selecting or unselecting the node
     */
    private void selectNode(DocumentTreeNode documentTreeNode, boolean isSelected) {
        DocumentTreeNodeType type = documentTreeNode.getType();
        if (type != DocumentTreeNodeType.DIAGRAM_CATEGORY) {
            Object object = documentTreeNode.getNodeObject();
            if (object instanceof Diagram) {
                selectDiagram((Diagram) object, isSelected);
            } else {
                List<JComponent> jComponents = new ArrayList<JComponent>();
                ModelElement modelElement;
                if (type == DocumentTreeNodeType.MODEL_ELEMENT) {
                    modelElement = (ModelElement) object;
                    jComponents = DeployHelper.getComponent((ModelElement) object, mainFrame);
                } else {
                    modelElement = DeployHelper.getElement((GraphElement) object);
                    JComponent component = DeployHelper.getComponent((GraphElement) object, mainFrame);
                    if (component != null) {
                        jComponents.add(component);
                    }
                }
                if (jComponents.size() > 0) {
                    for (JComponent jComponent : jComponents) {
                        if (isSelected) {
                            mainFrame.getDiagramViewer().addSelectedElement(jComponent);
                        } else {
                            mainFrame.getDiagramViewer().removeSelectedElement(jComponent);
                        }
                        updateDiagramViewAndStyle(jComponent, isSelected);
                    }
                }
                if (isSelected) {
                    modelElements.add(modelElement);
                } else {
                    remove(modelElement);
                }
            }
        }
    }

    /**
     * <p>
     * Updates the component in the diagram viewer and update the style objects list.
     * </p>
     *
     * @param jComponent
     *            the component
     * @param isSelected
     *            the flag whether selecting or unselecting the component
     */
    private void updateDiagramViewAndStyle(JComponent jComponent, boolean isSelected) {
        if (jComponent instanceof PolylineNode) {
            PolylineNode polylineNode = (PolylineNode) jComponent;
            if (isSelected) {
                polylineNode.notifySelected();
                styleObjects.add(new PolylineStyleObjectAdapter(polylineNode.getPolyline()));
            } else {
                polylineNode.notifyUnselected();
                removeStyleObject(polylineNode.getPolyline());
            }
        } else if (jComponent instanceof Node) {
            Node node = (Node) jComponent;
            if (isSelected) {
                node.notifySelected();
                styleObjects.add(new GraphNodeStyleObjectAdapter(node.getGraphNode()));
            } else {
                node.notifyUnselected();
                removeStyleObject(node.getGraphNode());
            }
        } else if (jComponent instanceof Edge) {
            Edge edge = (Edge) jComponent;
            if (isSelected) {
                edge.notifySelected();
                styleObjects.add(new GraphEdgeStyleObjectAdapter(edge.getGraphEdge()));
            } else {
                edge.notifyUnselected();
                removeStyleObject(edge.getGraphEdge());
            }
        } else if (jComponent instanceof TextField) {
            TextField textField = (TextField) jComponent;
            if (isSelected) {
                textField.setOpaque(true);
                textField.repaint();
                styleObjects.add(new GraphNodeStyleObjectAdapter(textField.getGraphNode()));
            } else {
                textField.setOpaque(false);
                textField.repaint();
                removeStyleObject(textField.getGraphNode());
            }
        }
    }

    /**
     * <p>
     * Updates the style panel, property panel and documentation panel.
     * </p>
     */
    private void updatePanels() {
        mainFrame.getStylePanel().setVisible(true);
        mainFrame.getPropertiesPanel().setVisible(true);
        mainFrame.getDocumentationPanel().setVisible(true);
        if (styleObjects.size() == 0) {
            mainFrame.getStylePanel().clearStyleObjects();
            mainFrame.getStylePanel().setVisible(false);
        } else {
            mainFrame.getStylePanel().setStyleObjectList(styleObjects);
        }
        if (modelElements.size() == 0) {
            mainFrame.getPropertiesPanel().setVisible(false);
            mainFrame.getDocumentationPanel().setVisible(false);
        } else {
            if (modelElements.size() == 1) {
                DeployHelper.notifyDocumentationPanel(mainFrame);
                mainFrame.getDocumentationPanel().setTarget(modelElements.get(0));
            } else {
                mainFrame.getDocumentationPanel().setVisible(false);
            }
            mainFrame.getPropertiesPanel().configurePanel(modelElements);
        }
    }

    /**
     * <p>
     * Updates the diagram viewer when selecting a diagram.
     * </p>
     *
     * @param diagram
     *            the diagram
     * @param isSelected
     *            whether the diagram is selected
     */
    private void selectDiagram(Diagram diagram, boolean isSelected) {
        DiagramViewer diagramViewer = mainFrame.getDiagramViewer();
        DiagramView diagramView = diagramViewer.createDiagramView(diagram);
        if (isSelected) {
            styleObjects.add(new GraphNodeStyleObjectAdapter(diagram));
            diagramViewer.addSelectedElement(diagramView);
        } else {
            removeStyleObject(diagram);
            diagramViewer.removeSelectedElement(diagramView);
        }
    }

    /**
     * <p>
     * Removes the style object corresponding to the graph node from the style objects list.
     * </p>
     *
     * @param graphNode
     *            the graph node
     */
    private void removeStyleObject(GraphNode graphNode) {
        StyleObject styleObject = null;
        for (StyleObject object : styleObjects) {
            if ((object instanceof GraphNodeStyleObjectAdapter)
                && (((GraphNodeStyleObjectAdapter) object).getGraphNode() == graphNode)) {
                styleObject = object;
                break;
            }
        }
        styleObjects.remove(styleObject);
    }

    /**
     * <p>
     * Removes the style object corresponding to the graph edge from the style objects list.
     * </p>
     *
     * @param graphEdge
     *            the graph edge
     */
    private void removeStyleObject(GraphEdge graphEdge) {
        StyleObject styleObject = null;
        for (StyleObject object : styleObjects) {
            if ((object instanceof GraphEdgeStyleObjectAdapter)
                && (((GraphEdgeStyleObjectAdapter) object).getGraphEdge() == graphEdge)) {
                styleObject = object;
                break;
            }
        }
        styleObjects.remove(styleObject);
    }

    /**
     * <p>
     * Removes the style object corresponding to the graph edge from the style objects list.
     * </p>
     *
     * @param polyline
     *            the polyline to remove style object
     */
    private void removeStyleObject(Polyline polyline) {
        StyleObject styleObject = null;
        for (StyleObject object : styleObjects) {
            if ((object instanceof PolylineStyleObjectAdapter)
                && (((PolylineStyleObjectAdapter) object).getPolyline() == polyline)) {
                styleObject = object;
                break;
            }
        }
        styleObjects.remove(styleObject);
    }

    /**
     * <p>
     * Opens the diagram which contains the last selected element in the diagram viewer.
     * </p>
     */
    private void openDiagram() {
        Object object = null;
        DocumentTreeNode documentTreeNode;
        for (int i = documentTreeNodes.size() - 1; i >= 0; --i) {
            documentTreeNode = documentTreeNodes.get(i);
            if (documentTreeNode.getType() != DocumentTreeNodeType.DIAGRAM_CATEGORY) {
                if (!(documentTreeNode.getNodeObject() instanceof Collaboration)
                    && !(documentTreeNode.getNodeObject() instanceof ActivityGraph)) {
                    object = documentTreeNode.getNodeObject();
                    if ((object instanceof GraphElement)
                        || (DeployHelper.getGraphElement((ModelElement) object) != null)) {
                        break;
                    }
                    object = null;
                }
            }
        }
        if (object == null) {
            return;
        }
        Diagram diagram = null;
        DiagramView view = DeployHelper.getDiagramView(mainFrame);
        if (object instanceof Diagram) {
            diagram = (Diagram) object;
        } else {
            if (object instanceof ModelElement) {
                List<Diagram> diagrams = DeployHelper.getDiagram((ModelElement) object);
                if ((view != null) && (diagrams.contains(view.getDiagram()))) {
                    diagram = view.getDiagram();
                } else {
                    if (diagrams.size() > 0) {
                        diagram = diagrams.get(0);
                    }
                }
            } else {
                diagram = DeployHelper.getDiagram((GraphElement) object);
            }
        }
        if (diagram != null) {
            if (view == null || view.getDiagram() != diagram) {
                DiagramView openedView = mainFrame.getDiagramViewer().openDiagramView(diagram);
                DeployHelper.updateZoomPane(openedView);
            }
        }
    }

    /**
     * <p>
     * The documenttreenode's name is changed. Updates the element and panels.
     * </p>
     *
     * @param event
     *            the NameChangedEvent
     * @throws IllegalArgumentException
     *             if event is null
     */
    public void treeNodeNameChanged(NameChangedEvent event) {
        DeployHelper.checkNotNull(event, "event");
        DocumentTreeNode treeNode = event.getTreeNode();
        DocumentTreeNodeType nodeType = treeNode.getType();
        Object object = treeNode.getNodeObject();
        List<JComponent> jComponents = new ArrayList<JComponent>();
        ModelElement modelElement = null;
        if (nodeType == DocumentTreeNodeType.MODEL_ELEMENT) {
            // when the changed node is a model element.
            modelElement = (ModelElement) object;
            if (modelElement instanceof AssociationEnd) {
                jComponents =
                    DeployHelper.getComponent(((AssociationEnd) modelElement).getAssociation(), mainFrame);
            } else {
                jComponents = DeployHelper.getComponent(modelElement, mainFrame);
            }
        } else if (nodeType == DocumentTreeNodeType.GRAPH_ELEMENT) {
            if (object instanceof Diagram) {
                // when the changed node is a diagram.
                ((Diagram) object).setName(event.getNewName());
                /*
                 * BugFix: BUGR-65 Sorting diagrams
                 */
                mainFrame.getDocumentTree().updateTree();
                mainFrame.getDiagramViewer().openDiagramView((Diagram) object);
                mainFrame.getDocumentTree().getCurrentPanel().getCurrentView().setSelectedTreeNodes(
                    new DocumentTreeNode[] {treeNode});
            } else {
                // When the changed node is a graph element.
                modelElement = DeployHelper.getElement((GraphElement) object);
                jComponents.add(DeployHelper.getComponent((GraphElement) object, mainFrame));
            }
        } else {
            mainFrame.getDocumentTree().getCurrentPanel().getCurrentView().updateTreeNode(treeNode);
        }
        if (modelElement != null) {
            if (modelElement instanceof ClassImpl) {
                DeployHelper.changeConstructors(mainFrame, (ClassImpl) modelElement, event.getNewName(),
                    jComponents);
            } else {
                ChangeEntityNameAction changeEntityNameAction =
                    new ChangeEntityNameAction(modelElement, event.getNewName(), mainFrame.isAutoGenerateMethods());
                mainFrame.handleActionEvent(changeEntityNameAction, jComponents, "change name");
            }
        }
    }

    /**
     * <p>
     * The view type has changed. Update the tree.
     * </p>
     *
     * @param event
     *            the ViewChangeEvent
     * @throws IllegalArgumentException
     *             if event is null
     */
    public void treeViewChanged(ViewChangedEvent event) {
        DocumentTreeView oldView = event.getOldView();
        HandlerHelper.treeViewChanged(mainFrame, oldView);
    }
}

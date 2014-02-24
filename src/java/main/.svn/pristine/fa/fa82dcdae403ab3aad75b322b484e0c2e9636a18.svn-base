/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.handlers;

import java.util.List;

import javax.swing.JComponent;

import com.topcoder.gui.diagramviewer.DiagramViewer;
import com.topcoder.gui.diagramviewer.edges.Edge;
import com.topcoder.gui.diagramviewer.edges.TextField;
import com.topcoder.gui.diagramviewer.elements.Node;
import com.topcoder.gui.diagramviewer.uml.auxiliaryelements.PolylineNode;
import com.topcoder.gui.panels.properties.ModelElementSelectionListener;
import com.topcoder.gui.panels.style.styleobject.GraphEdgeStyleObjectAdapter;
import com.topcoder.gui.panels.style.styleobject.GraphNodeStyleObjectAdapter;
import com.topcoder.gui.panels.style.styleobject.PolylineStyleObjectAdapter;
import com.topcoder.gui.trees.document.DocumentTreeNode;
import com.topcoder.gui.trees.document.DocumentTreeTabbedPane;
import com.topcoder.gui.trees.document.DocumentTreeView;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.Parameter;
import com.topcoder.umltool.deploy.DeployHelper;
import com.topcoder.umltool.deploy.MainFrame;

/**
 * <p>
 * This implementation of ModelElementSelectionListener will check which model element is selected, and update diagram
 * viewer, style panel, document tree panel and documentation panel in the main frame.
 * </p>
 * <p>
 * Thread safety: This class are not required to be thread-safe. They could be used in a thread safe manner in this
 * component.
 * </p>
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class ModelElementSelectionHandler implements ModelElementSelectionListener {
    /**
     * <p>
     * The mainframe associated with this handler.
     * </p>
     */
    private MainFrame mainFrame = null;

    /**
     * <p>
     * Creates an instance of ModelElementSelectionHandler with the mainframe.
     * </p>
     * @param mainFrame
     *            the mainframe
     */
    public ModelElementSelectionHandler(MainFrame mainFrame) {
        DeployHelper.checkNotNull(mainFrame, "mainFrame");
        this.mainFrame = mainFrame;
    }

    /**
     * <p>
     * A different model element is selected.
     * </p>
     * @param modelElement
     *            the newly selected model element
     * @throws IllegalArgumentException
     *             if modelElement is null
     */
    public void selectionChanged(ModelElement modelElement) {
        DeployHelper.checkNotNull(modelElement, "modelElement");
        DeployHelper.clearSelected(mainFrame.getDiagramViewer());
        updateDocumentTree(modelElement);
        updateDiagramViewAndStyle(modelElement);
        DeployHelper.notifyDocumentationPanel(mainFrame);
        mainFrame.getDocumentationPanel().setTarget(modelElement);
        if (modelElement instanceof Parameter) {
            mainFrame.getPropertiesPanel().setVisible(true);
        }
    }

    /**
     * <p>
     * Updates document tree panel.
     * </p>
     * @param modelElement
     *            the newly selected model element
     */
    private void updateDocumentTree(ModelElement modelElement) {
        DocumentTreeTabbedPane documentTreePanel = mainFrame.getDocumentTree();
        DocumentTreeView documentTreeView = documentTreePanel.getCurrentPanel().getCurrentView();
        List<DocumentTreeNode> documentTreeNodes = DeployHelper.getDocumentTreeNode(modelElement, documentTreeView);
        if (documentTreeNodes.size() > 0) {
            documentTreeView.setSelectedTreeNodes(documentTreeNodes.toArray(new DocumentTreeNode[0]));
        } else {
            documentTreeView.getTree().setSelectionPath(null);
        }
    }

    /**
     * <p>
     * Updates the diagram viewer and style panel.
     * </p>
     * @param modelElement
     *            the newly selected model element
     */
    private void updateDiagramViewAndStyle(ModelElement modelElement) {
        DiagramViewer diagramViewer = mainFrame.getDiagramViewer();
        List<JComponent> jComponents = DeployHelper.getComponent(modelElement, mainFrame);
        if (jComponents.size() == 0) {
            return;
        }
        for (JComponent jComponent : jComponents) {
            mainFrame.getDiagramViewer().addSelectedElement(jComponent);
            if (jComponent instanceof PolylineNode) {
                PolylineNode polylineNode = (PolylineNode) jComponent;
                diagramViewer.openDiagramView(DeployHelper.getDiagram(polylineNode.getPolyline()));
                polylineNode.notifySelected();
                mainFrame.getStylePanel().setStyleObject(new PolylineStyleObjectAdapter(polylineNode.getPolyline()));
            } else if (jComponent instanceof Node) {
                Node node = (Node) jComponent;
                diagramViewer.openDiagramView(DeployHelper.getDiagram(node.getGraphNode()));
                node.notifySelected();
                mainFrame.getStylePanel().setStyleObject(new GraphNodeStyleObjectAdapter(node.getGraphNode()));
            } else if (jComponent instanceof Edge) {
                Edge edge = (Edge) jComponent;
                diagramViewer.openDiagramView(DeployHelper.getDiagram(edge.getGraphEdge()));
                edge.notifySelected();
                mainFrame.getStylePanel().setStyleObject(new GraphEdgeStyleObjectAdapter(edge.getGraphEdge()));
            } else if (jComponent instanceof TextField) {
                TextField textField = (TextField) jComponent;
                diagramViewer.openDiagramView(DeployHelper.getDiagram(textField.getGraphNode()));
                textField.setOpaque(true);
                textField.repaint();
                mainFrame.getStylePanel().setStyleObject(new GraphNodeStyleObjectAdapter(textField.getGraphNode()));
            }
        }
    }
}

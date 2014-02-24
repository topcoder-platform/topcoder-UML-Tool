package com.topcoder.umltool.deploy.actions;

import java.awt.Color;
import java.awt.Component;
import java.awt.dnd.DropTarget;
import java.util.HashSet;
import java.util.Set;

import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.UndoableEdit;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.Dimension;
import com.topcoder.diagraminterchange.Point;
import com.topcoder.diagraminterchange.SimpleSemanticModelElement;
import com.topcoder.diagraminterchange.Uml1SemanticModelBridge;
import com.topcoder.gui.diagramviewer.DiagramView;
import com.topcoder.gui.diagramviewer.DiagramViewer;
import com.topcoder.gui.panels.zoom.ZoomPane;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.uml.projectconfiguration.ProjectConfigurationException;
import com.topcoder.umltool.deploy.DeployHelper;
import com.topcoder.umltool.deploy.MainFrame;
import com.topcoder.umltool.deploy.handlers.DiagramViewDragHandler;
import com.topcoder.umltool.deploy.handlers.ViewDropTargetHandler;
import com.topcoder.util.actionmanager.ActionExecutionException;
import com.topcoder.util.actionmanager.UndoableAction;

public class DuplicateDiagramAction implements UndoableAction {

    private MainFrame mainFrame;

    private Diagram diagram;

    public DuplicateDiagramAction(MainFrame mainFrame, Diagram diagram) {
        this.mainFrame = mainFrame;
        this.diagram = diagram;
    }

    public void execute() throws ActionExecutionException {
        Diagram copy = new Diagram();
        copy.setName(diagram.getName() + " (duplicate)");

        SimpleSemanticModelElement simpleElement = new SimpleSemanticModelElement();
        simpleElement.setTypeInfo(((SimpleSemanticModelElement) diagram.getSemanticModel()).getTypeInfo());
        copy.setSemanticModel(simpleElement);

        UMLModelManager manager = UMLModelManager.getInstance();
        // set the owner property of the Diagram to the owner.
        Uml1SemanticModelBridge modelBridge = new Uml1SemanticModelBridge();
        modelBridge.setElement(((Uml1SemanticModelBridge) diagram.getOwner()).getElement());
        copy.setOwner(modelBridge);
        // set the viewport, size and position of the diagrams to (0.0,0.0). The X and Y coordinate of the Point is
        // 0.0
        // by default and the width and height of the Dimension is 0.0 by default
        copy.setViewport(new Point());
        copy.setSize(new Dimension());
        copy.setPosition(new Point());
        // set the zoom attribute of the diagrams to "1.0";
        copy.setZoom(1.0);
        // apply initial formatting for the diagram with the project language and ProjectConfigurationManager
        String projectLanguage = manager.getProjectLanguage();
        // Note that an IllegalStateException will be thrown or the ProjectLanguage is null(it cannot be empty in
        // UMLModelManager).
        if (projectLanguage == null) {
            throw new IllegalStateException("The Language of the Project should not be null.");
        }
        try {
            // Note that in UMLModelManager an IllegalStateException will be thrown if the
            // projectConfigurationManager
            // was not set yet
            manager.getProjectConfigurationManager().applyInitialFormatting(projectLanguage, diagram);
        } catch (ProjectConfigurationException e) {
            throw new IllegalStateException(
                "Cannot apply initial formatting to the diagram according to the language.");
        }
        mainFrame.getUmlModelManager().addDiagram(copy);

        mainFrame.getDiagramViewer().closeDiagramView(diagram);
        mainFrame.getDiagramViewer().revalidate();
        mainFrame.getDocumentTree().updateTree();

        DiagramViewer viewer = mainFrame.getDiagramViewer();

        Dimension dimension = new Dimension();
        int gap = mainFrame.getDiagramViewer().getDiagramViewGap();
        dimension.setWidth(mainFrame.getDiagramViewer().getWidth() - gap * 2);
        dimension.setHeight(mainFrame.getDiagramViewer().getHeight() - gap * 2);
        Point point = new Point();
        point.setX(gap);
        point.setY(gap);

        DiagramView view = null;
        mainFrame.getDocumentTree().updateTree();
        // if (action instanceof CreateDiagramAction) {
        // diagram = ((CreateDiagramAction) action).getDiagram();
        // } else if (action instanceof CreateActivityDiagramAction) {
        // diagram = ((CreateActivityDiagramAction) action).getDiagram();
        // }

        // set position and size to diagram
        copy.setPosition(point);
        copy.setSize(dimension);

        // set view and zoom pane.
        DeployHelper.clearSelected(viewer);
        view = viewer.openDiagramView(copy);

        DropTarget dropTarget = new DropTarget(view, new ViewDropTargetHandler(mainFrame));
        view.setDropTarget(dropTarget);

        DiagramViewDragHandler viewDragHandler = new DiagramViewDragHandler();
        view.addMouseListener(viewDragHandler);
        view.addMouseMotionListener(viewDragHandler);

        java.awt.Dimension preferredSize =
            new java.awt.Dimension((int) Math.ceil(diagram.getSize().getWidth()), (int) Math.ceil(diagram
                .getSize().getHeight()));
        view.setSize(preferredSize);
        view.setPreferredSize(preferredSize);
        preferredSize.width += gap * 2;
        preferredSize.height += gap * 2;
        ZoomPane zoomPane = (ZoomPane) view.getParent();
        zoomPane.setSize(preferredSize);
        zoomPane.setPreferredSize(preferredSize);

        view.setBackground(Color.WHITE);
        view.setOpaque(true);
        view.setComponentPopupMenu(mainFrame.getPopupMenu());

        viewer.revalidate();

        Set<Object> objs = new HashSet<Object>();
        for (DiagramView v : viewer.getCachedDiagramViews()) {
            if (v.getDiagram() == diagram) {
                Component[] components = v.getComponents();
                for (Component component : components) {
                    objs.add(component);
                }
                break;
            }
        }

        CopyPasteCutUtil.copyRepresentation(mainFrame, objs);

        new PasteAction(mainFrame).actionPerformed(new java.awt.event.ActionEvent(mainFrame, 2, ""));
    }

    public boolean addEdit(UndoableEdit anEdit) {
        return false;
    }

    public boolean canRedo() {
        return false;
    }

    public boolean canUndo() {
        return false;
    }

    public void die() {

    }

    public String getPresentationName() {
        return "Duplicate diagram";
    }

    public String getRedoPresentationName() {
        return null;
    }

    public String getUndoPresentationName() {
        return null;
    }

    public boolean isSignificant() {
        return false;
    }

    public void redo() throws CannotRedoException {
    }

    public boolean replaceEdit(UndoableEdit anEdit) {
        return false;
    }

    public void undo() throws CannotUndoException {
    }

}

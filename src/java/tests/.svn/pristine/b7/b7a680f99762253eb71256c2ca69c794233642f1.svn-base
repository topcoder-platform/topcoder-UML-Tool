/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.io.File;
import java.lang.reflect.Field;
import java.util.List;

import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.JViewport;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.Uml1SemanticModelBridge;
import com.topcoder.gui.diagramviewer.DiagramView;
import com.topcoder.gui.diagramviewer.DiagramViewer;
import com.topcoder.gui.diagramviewer.edges.Edge;
import com.topcoder.gui.diagramviewer.elements.Node;
import com.topcoder.gui.diagramviewer.uml.activityelements.ActionState;
import com.topcoder.gui.diagramviewer.uml.classedges.NoArrow;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.ObjectNode;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.IncludeEdge;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.UseCaseNode;
import com.topcoder.gui.panels.zoom.ZoomPane;
import com.topcoder.gui.panels.zoom.ZoomPanel;
import com.topcoder.uml.actions.diagram.CreateActivityDiagramAction;
import com.topcoder.uml.actions.diagram.CreateClassDiagramAction;
import com.topcoder.uml.actions.diagram.CreateDiagramAction;
import com.topcoder.uml.actions.diagram.CreateUseCaseDiagramAction;
import com.topcoder.uml.actions.model.activity.AddActionStateAction;
import com.topcoder.uml.actions.model.usecase.AddIncludeAction;
import com.topcoder.uml.actions.model.usecase.AddUseCaseAction;
import com.topcoder.uml.actions.project.CreateNewProjectAction;
import com.topcoder.uml.actions.project.LoadTCUMLFileAction;
import com.topcoder.uml.actions.project.SaveTCUMLFileAction;
import com.topcoder.uml.model.activitygraphs.ActionStateImpl;
import com.topcoder.uml.model.activitygraphs.ActivityGraph;
import com.topcoder.uml.model.activitygraphs.ActivityGraphImpl;
import com.topcoder.uml.model.commonbehavior.instances.ObjectImpl;
import com.topcoder.uml.model.core.extensionmechanisms.TagDefinition;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValue;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValueImpl;
import com.topcoder.uml.model.modelmanagement.Model;
import com.topcoder.uml.model.usecases.Include;
import com.topcoder.uml.model.usecases.IncludeImpl;
import com.topcoder.uml.model.usecases.UseCase;
import com.topcoder.uml.model.usecases.UseCaseImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.umltool.deploy.actions.ActionListenerManager;
import com.topcoder.umltool.deploy.actions.undoable.AddCollaborationAction;
import com.topcoder.umltool.deploy.menus.EditMenu;
import com.topcoder.util.actionmanager.ActionExecutionException;

/**
 * <p>
 * Test helper for testing uml tool.
 * </p>
 *
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class TestHelper {
    /** The position of the graph node. Used for testing only. */
    public static final Point POSITION = new Point(100, 150);

    /** The size of the graph node. Used for testing only. */
    public static final Dimension SIZE = new Dimension(180, 100);

    /** The position of the graph node. Used for testing only. */
    public static final Point POSITION2 = new Point(400, 250);

    /** Start position of the graph edge. Used for testing only. */
    public static final Point START = new Point(200, 200);

    /** End position of the graph edge. Used for testing only. */
    public static final Point END = new Point(500, 300);

    /** Main frame window for testing. */
    private static MainFrame mainFrame = initMainFrame();

    /** Diagram view that contains the object node, initialized in initMainFrame. */
    private static DiagramView diagramView;

    /** Diagrams for testing. */
    private static Diagram[] diagrams;

    /** Test file for persistence. */
    public static File testFile = new File("test_files/test.tcuml");

    /**
     * <p>
     * Initializes main frame and creates a diagram view.
     * </p>
     *
     * @return the created main frame
     */
    private static MainFrame initMainFrame() {
        MainFrame mainFrame = null;
        try {
            mainFrame = new MainFrame();
        } catch (DeployConfigException e1) {
            e1.printStackTrace();
        }
        diagrams = new Diagram[4];
        createTestDiagrams(mainFrame);

        for (Diagram diagram : diagrams) {
            mainFrame.getDiagramViewer().openDiagramView(diagram);
        }

        mainFrame.setAssociationType(NoArrow.class);

        return mainFrame;
    }

    /**
     * <p>
     * Creates four different diagrams.
     * </p>
     *
     * @param mainFrame
     *            main frame window
     */
    private static void createTestDiagrams(MainFrame mainFrame) {
        com.topcoder.diagraminterchange.Dimension size = new com.topcoder.diagraminterchange.Dimension();
        size.setWidth(1000);
        size.setHeight(1000);

        CreateDiagramAction action = new CreateClassDiagramAction(null, "ClassDiagram");
        try {
            action.execute();
        } catch (ActionExecutionException e) {
            e.printStackTrace();
        }
        diagrams[DiagramType.CLASS.ordinal()] = action.getDiagram();
        action.getDiagram().setSize(size);

        action = new CreateUseCaseDiagramAction(null, "UseCaseDiagram");
        try {
            action.execute();
        } catch (ActionExecutionException e) {
            e.printStackTrace();
        }
        diagrams[DiagramType.USECASE.ordinal()] = action.getDiagram();
        action.getDiagram().setSize(size);

        AddCollaborationAction addCollaborationAction = new AddCollaborationAction(mainFrame);
        action =
            new com.topcoder.uml.actions.diagram.CreateSequenceDiagramAction(addCollaborationAction
                .getCollaboration(), "Sequence Diagram");

        try {
            addCollaborationAction.executeAction();
            action.execute();
        } catch (ActionExecutionException e) {
            e.printStackTrace();
        }
        diagrams[DiagramType.SEQUENCE.ordinal()] = action.getDiagram();
        action.getDiagram().setSize(size);

        CreateActivityDiagramAction activityAction =
            new CreateActivityDiagramAction(new ActivityGraphImpl(), "ActivityDiagram");
        try {
            activityAction.execute();
        } catch (ActionExecutionException e) {
            e.printStackTrace();
        }
        diagrams[DiagramType.ACTIVITY.ordinal()] = activityAction.getDiagram();
        activityAction.getDiagram().setSize(size);
    }

    /**
     * <p>
     * Gets the main frame used for testing.
     * </p>
     *
     * @return the main frame for testing
     */
    public static MainFrame getMainFrame() {
        return mainFrame;
    }

    /**
     * <p>
     * Gets the diagram view for testing.
     * </p>
     *
     * @return the diagram view for testing
     */
    public static DiagramView getDiagramView(DiagramType type) {
        diagramView = mainFrame.getDiagramViewer().openDiagramView(diagrams[type.ordinal()]);
        return diagramView;
    }

    /**
     * <p>
     * Creates an object node.
     * </p>
     *
     * @return the created object node
     */
    public static ObjectNode createObjectNode() {
        ObjectImpl object = new ObjectImpl();

        GraphNode graphNode = new GraphNode();
        graphNode.setPosition(new com.topcoder.diagraminterchange.Point());
        graphNode.setSize(new com.topcoder.diagraminterchange.Dimension());
        DeployHelper.setElement(graphNode, object);
        DeployHelper.addContained(getCurrentDiagram(), graphNode);

        ObjectNode objectNode = DeployHelper.createObjectNode(mainFrame, graphNode);
        DeployHelper.getLifeLine(objectNode).setSize((int) getCurrentDiagram().getSize().getWidth(),
            (int) getCurrentDiagram().getSize().getHeight());

        return objectNode;
    }

    /**
     * <p>
     * Creates an UseCaseNode and add it to the diagram view.
     * </p>
     *
     * @return the created node
     */
    public static UseCaseNode addUseCaseNode() {
        UseCase usecase = new UseCaseImpl();
        AddUseCaseAction action = new AddUseCaseAction(usecase, UMLModelManager.getInstance());
        try {
            action.execute();
        } catch (ActionExecutionException e) {
            e.printStackTrace();
        }
        GraphNode graphNode = DeployHelper.createGraphNodeForUseCase(usecase, POSITION, SIZE);
        UseCaseNode node = new UseCaseNode(graphNode, DeployHelper.createProperties());
        DiagramView view = getDiagramView(DiagramType.USECASE);
        view.getDiagram().addContained(graphNode);
        graphNode.setContainer(diagramView.getDiagram());
        view.add(node);
        node.notifyGraphNodeChange("Add to view");
        return node;
    }

    /**
     * <p>
     * Creates an ActionState and add it to the diagram view.
     * </p>
     *
     * @return the created node
     */
    public static ActionState addActionState() {
        DiagramView view = getDiagramView(DiagramType.ACTIVITY);
        com.topcoder.uml.model.activitygraphs.ActionState state = new ActionStateImpl();
        state.setName("Action State");
        Uml1SemanticModelBridge bridge = (Uml1SemanticModelBridge) view.getDiagram().getOwner();
        AddActionStateAction action =
            new AddActionStateAction(state, (ActivityGraph) bridge.getElement(), UMLModelManager.getInstance());
        try {
            action.execute();
        } catch (ActionExecutionException e) {
            e.printStackTrace();
        }
        GraphNode graphNode = DeployHelper.createGraphNodeForActivityState(state, POSITION, SIZE);
        ActionState node =
            new ActionState(graphNode, DeployHelper.createProperties(), new Point(), new Rectangle());
        view.getDiagram().addContained(graphNode);
        graphNode.setContainer(view.getDiagram());
        view.add(node);
        node.notifyGraphNodeChange("Add to view");
        return node;
    }

    /**
     * Gets the value of a private field in the given class. The field has the given name. The value is retrieved
     * from the given instance. If the instance is null, the field is a static field. If any error occurs, null is
     * returned.
     *
     * @param type
     *            the class which the private field belongs to
     * @param instance
     *            the instance which the private field belongs to
     * @param name
     *            the name of the private field to be retrieved
     * @return the value of the private field
     */
    public static Object getPrivateField(Class<?> type, Object instance, String name) {
        Field field = null;
        Object obj = null;
        try {
            // Get the reflection of the field
            field = type.getDeclaredField(name);
            // Set the field accessible.
            field.setAccessible(true);
            // Get the value
            obj = field.get(instance);
        } catch (NoSuchFieldException e) {
            // Ignore
        } catch (IllegalAccessException e) {
            // Ignore
        } finally {
            if (field != null) {
                // Reset the accessibility
                field.setAccessible(false);
            }
        }

        return obj;
    }

    /**
     * <p>
     * Creates an IncludeEdge and add it to the diagram view.
     * </p>
     *
     * @param wayPoints
     *            way points
     * @return the created edge
     */
    public static IncludeEdge addIncludeEdge(List<Point> wayPoints) {
        Include include = new IncludeImpl();
        AddIncludeAction action = new AddIncludeAction(include, UMLModelManager.getInstance());
        try {
            action.execute();
        } catch (ActionExecutionException e) {
            e.printStackTrace();
        }
        GraphEdge graphEdge = DeployHelper.createGraphEdgeForUseCase(include, wayPoints, "Include");
        IncludeEdge edge = new IncludeEdge(graphEdge);
        diagramView.add(edge);
        return edge;
    }

    /**
     * <p>
     * Gets current showing diagram.
     * </p>
     *
     * @return the showing diagram or null if no diagram is showing
     */
    public static Diagram getCurrentDiagram() {
        Diagram currentDiagram = null;
        if (mainFrame.getDiagramViewer().getTabbedPane().getSelectedIndex() != -1) {
            ZoomPanel zoomPanel = (ZoomPanel) mainFrame.getDiagramViewer().getTabbedPane().getSelectedComponent();
            JViewport viewport = (JViewport) zoomPanel.getComponent(0);
            ZoomPane zoomPane = (ZoomPane) viewport.getComponent(0);
            DiagramView view = (DiagramView) zoomPane.getComponent(0);
            currentDiagram = view.getDiagram();
        }
        return currentDiagram;
    }

    /**
     * Finds if a component is in the diagram view.
     *
     * @param view
     *            diagram view to find the component
     * @param component
     *            component to find
     * @return true if component is in the given view, otherwise false
     */
    public static boolean isContainedInDiagramView(DiagramView view, JComponent component) {
        Component[] components = view.getComponents();
        for (Component comp : components) {
            if (comp == component) {
                return true;
            }
        }
        return false;
    }

    /**
     * <p>
     * Adds a node to given view at given location.
     * </p>
     *
     * @param view
     *            view to add node
     * @param type
     *            the node type
     * @param location
     *            the node's location
     * @return the added node
     */
    public static Node addNode(DiagramView view, Class<?> type, Point location) {
        return addNode(view, type, new Rectangle(location.x, location.y, 300, 200));
    }

    /**
     * <p>
     * Adds a node to given view with given bounds.
     * </p>
     *
     * @param view
     *            view to add node
     * @param type
     *            the node type
     * @param bounds
     *            the node's bounds
     * @return the added node
     */
    public static Node addNode(DiagramView view, Class<?> type, Rectangle bounds) {
        DiagramViewer viewer = view.getViewer();
        DeployHelper.clearSelected(viewer);
        viewer.fireNewElementAdded(view, type, bounds);
        return (Node) viewer.getAllSelectedElements().get(0);
    }

    /**
     * <p>
     * Adds an edge to given view at given location.
     * </p>
     *
     * @param view
     *            view to add edge
     * @param type
     *            the edge type
     * @param start
     *            the start node for edge
     * @param end
     *            the end node for edge
     * @return the added edge
     */
    public static Edge addEdge(DiagramView view, Class<?> type, Node start, Node end) {
        DiagramViewer viewer = view.getViewer();
        DeployHelper.clearSelected(viewer);
        Rectangle startBound = start.getBounds();
        Rectangle endBound = end.getBounds();
        Point startPos = new Point(startBound.x + startBound.width / 2, startBound.y + startBound.height / 2);
        Point endPos = new Point(endBound.x + endBound.width / 2, endBound.y + endBound.height / 2);
        viewer.fireNewElementAdded(view, type, new Rectangle(startPos.x, startPos.y, endPos.x - startPos.x,
            endPos.y - startPos.y));
        return (Edge) viewer.getAllSelectedElements().get(0);
    }

    /**
     * <p>
     * Deletes the selected elements.
     * </p>
     */
    public static void deleteSelectedElements() {
        Action action = ActionListenerManager.getInstance().getAction(EditMenu.DELETE_ELEMENT_MENU_ACTION);
        action.actionPerformed(new ActionEvent(mainFrame, ActionEvent.ACTION_FIRST, ""));
    }

    /**
     * <p>
     * Copies the selected elements
     * </p>
     */
    public static void copySelectedElements() {
        Action copyAction = ActionListenerManager.getInstance().getAction(EditMenu.COPY_ELEMENT_MENU_ACTION);
        copyAction.actionPerformed(new ActionEvent(mainFrame, ActionEvent.ACTION_FIRST, ""));
    }

    /**
     * <p>
     * Pastes the elements in clip board.
     * </p>
     */
    public static void pasteElements() {
        Action action = ActionListenerManager.getInstance().getAction(EditMenu.PASTE_MENU_ACTION);
        action.actionPerformed(new ActionEvent(mainFrame, ActionEvent.ACTION_FIRST, ""));
    }

    /**
     * <p>
     * Selects specified component.
     * </p>
     */
    public static void selectComponent(JComponent component) {
        DiagramViewer viewer = mainFrame.getDiagramViewer();
        viewer.addSelectedElement(component);
    }

    /**
     * <p>
     * Saves elements into test file.
     * </p>
     *
     * @throws ActionExecutionException
     *             if fail to save
     */
    public static void save() throws ActionExecutionException {
        UMLModelManager modelManager = UMLModelManager.getInstance();
        DeployHelper.reorderGraphNodeEdge(modelManager);
        SaveTCUMLFileAction saveAction = new SaveTCUMLFileAction(testFile, true, modelManager);
        saveAction.execute();
    }

    /**
     * <p>
     * Loads elements from test file.
     * </p>
     *
     * @throws ActionExecutionException
     *             if fail to load
     */
    public static void load() throws ActionExecutionException {
        DeployHelper.clearSelected(mainFrame.getDiagramViewer());
        mainFrame.getDiagramViewer().clear();
        mainFrame.getUmlModelManager().getModel().clearTaggedValues();
        LoadTCUMLFileAction action =
            new LoadTCUMLFileAction(testFile, mainFrame.getUmlModelManager(), mainFrame
                .getProjectConfigurationManager());
        action.execute();
        mainFrame.recoverDiagramViews(false);
    }

    /**
     * <p>
     * Opens specified diagram.
     * </p>
     */
    public static void openDiagram(DiagramType diagramType) {
        DiagramViewer viewer = mainFrame.getDiagramViewer();
        viewer.openDiagramView(diagrams[diagramType.ordinal()]);
    }

    /**
     * <p>
     * Restore the status of main frame for tests.
     * </p>
     */
    public static void restoreMainFrame() {
        CreateNewProjectAction createNewProjectAction =
            new CreateNewProjectAction("Java", mainFrame.getUmlModelManager());

        createNewProjectAction.execute();

        // get the created model
        Model model = mainFrame.getUmlModelManager().getModel();
        model.clearTaggedValues();

        // create a new tag definition with ProjectLanguage as type
        TagDefinition tagDefinition = DeployHelper.getTagDefinition("ProjectLanguage");
        // create a tagged value with the project language as data and type as tag definition.
        TaggedValue taggedValue = new TaggedValueImpl();
        taggedValue.setDataValue("Java");
        taggedValue.setType(tagDefinition);
        // add the tagged value to the model manager
        model.addTaggedValue(taggedValue);

        DiagramViewer viewer = mainFrame.getDiagramViewer();
        viewer.clear();
        createTestDiagrams(mainFrame);
        for (Diagram diagram : diagrams) {
            mainFrame.getDiagramViewer().openDiagramView(diagram);
        }

        DeployHelper.clearSelected(viewer);
    }

    /**
     * <p>
     * Finds given element from diagram viewer.
     * </p>
     *
     * @param element
     *            element to find
     * @return true if found, otherwise false
     */
    public static boolean findElement(JComponent element) {
        MainFrame mainFrame = TestHelper.getMainFrame();
        DiagramViewer viewer = mainFrame.getDiagramViewer();
        for (DiagramView view : viewer.getCachedDiagramViews()) {
            for (Component component : view.getComponents()) {
                if (component.getClass().equals(element.getClass())
                    && component.getBounds().equals(element.getBounds())) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * <p>
     * Select all elements in current diagram view.
     * </p>
     */
    public static void selectAll() {
        DiagramViewer viewer = mainFrame.getDiagramViewer();
        DiagramView view = DeployHelper.getDiagramView(mainFrame);
        viewer.fireSelectionRectangleChange(view, new Rectangle(new Point(0, 0), view.getSize()));
    }

    /**
     * <p>
     * Clears selected status.
     * </p>
     */
    public static void clearSelected() {
        DiagramViewer viewer = mainFrame.getDiagramViewer();
        DeployHelper.clearSelected(viewer);
    }
}

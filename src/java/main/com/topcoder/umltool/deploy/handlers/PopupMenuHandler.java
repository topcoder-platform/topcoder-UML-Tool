/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */

package com.topcoder.umltool.deploy.handlers;

import java.awt.Component;
import java.awt.Point;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;
import javax.swing.JComponent;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.DiagramView;
import com.topcoder.gui.diagramviewer.edges.TextField;
import com.topcoder.gui.diagramviewer.elements.Node;
import com.topcoder.gui.diagramviewer.uml.activityelements.AcceptEventAction;
import com.topcoder.gui.diagramviewer.uml.activityelements.ActionState;
import com.topcoder.gui.diagramviewer.uml.activityelements.BaseNode;
import com.topcoder.gui.diagramviewer.uml.activityelements.DecisionNode;
import com.topcoder.gui.diagramviewer.uml.activityelements.FinalNode;
import com.topcoder.gui.diagramviewer.uml.activityelements.FlowFinalNode;
import com.topcoder.gui.diagramviewer.uml.activityelements.ForkNode;
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
import com.topcoder.gui.diagramviewer.uml.classedges.AbstractionEdge;
import com.topcoder.gui.diagramviewer.uml.classedges.AssociationEdge;
import com.topcoder.gui.diagramviewer.uml.classedges.DependencyEdge;
import com.topcoder.gui.diagramviewer.uml.classedges.GeneralizationEdge;
import com.topcoder.gui.diagramviewer.uml.classelements.ClassNode;
import com.topcoder.gui.diagramviewer.uml.classelements.InterfaceNode;
import com.topcoder.gui.diagramviewer.uml.classelements.PackageNode;
import com.topcoder.gui.diagramviewer.uml.classelements.StereotypeTextField;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.AsynchronousMessageEdge;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.CreateMessageEdge;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.ObjectNode;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.ReturnMessageEdge;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.SendSignalMessageEdge;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.SynchronousMessageEdge;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.ActorNode;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.ExtendEdge;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.IncludeEdge;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.SubsystemNodeContainer;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.UseCaseNode;
import com.topcoder.gui.panels.zoom.ZoomPane;
import com.topcoder.uml.model.core.Attribute;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.umltool.deploy.DeployHelper;
import com.topcoder.umltool.deploy.DiagramType;
import com.topcoder.umltool.deploy.FeatureAddAction;
import com.topcoder.umltool.deploy.MainFrame;
import com.topcoder.umltool.deploy.actions.AddElementAction;
import com.topcoder.umltool.deploy.actions.DeleteElementAction;
import com.topcoder.umltool.deploy.actions.DeleteRepresentationAction;
import com.topcoder.umltool.deploy.actions.GetterOperationAddAction;
import com.topcoder.umltool.deploy.actions.GetterSetterOperationAddAction;
import com.topcoder.umltool.deploy.actions.MoveBackwardAction;
import com.topcoder.umltool.deploy.actions.MoveForwardAction;
import com.topcoder.umltool.deploy.actions.MoveToBackAction;
import com.topcoder.umltool.deploy.actions.MoveToFrontAction;
import com.topcoder.umltool.deploy.actions.PropertyAddAction;
import com.topcoder.umltool.deploy.actions.SetterOperationAddAction;
import com.topcoder.umltool.deploy.actions.ShowElementsAction;
import com.topcoder.umltool.deploy.actions.ShowExternalElementsAction;

import com.topcoder.gui.diagramviewer.uml.classelements.GroupTextField;
import com.topcoder.umltool.deploy.SpecialJPopupMenu;

/**
 * <p>
 * Implementation of the PopupMenuListener interface. This class is registered to listen to the action of popup menu.
 * </p>
 * <p>
 * Thread Safety: The class is immutable and thread safe.
 * </p>
 * @author ly, FireIce, ylouis, TCSDEVELOPER
 * @version 1.0
 */

public class PopupMenuHandler implements PopupMenuListener {
    /**
     * <p>
     * Represents the attribute compartment's graph node index in the graph node structure.
     * </p>
     */
    private static final int ATTRIBUTE_INDEX = 2;

    /**
     * <p>
     * Represents the operation compartment's graph node index in the graph node structure.
     * </p>
     */
    private static final int OPERATION_INDEX = 4;

    /**
     * <p>
     * Reference to main frame.
     * </p>
     */
    private final MainFrame mainFrame;

    /**
     * <p>
     * Reference to popup menu in main frame.
     * </p>
     */
    private JPopupMenu popupMenu;

    /**
     * <p>
     * Creates an instance of ChangePositionHandler.
     * </p>
     * @param mainFrame
     *            main frame of uml tool
     * @throws IllegalArgumentException
     *             if argument is null
     */
    public PopupMenuHandler(MainFrame mainFrame) {
        DeployHelper.checkNotNull(mainFrame, "mainFrame");
        this.mainFrame = mainFrame;
        this.popupMenu = mainFrame.getPopupMenu();
    }

    /**
     * <p>
     * Shows menu.
     * </p>
     * @param e
     *            popup menu event
     */
    public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
        Component invoker = popupMenu.getInvoker();
        // FIX: BUGR-87
        if(invoker instanceof ZoomPane)
        {
            Point p1=((SpecialJPopupMenu)popupMenu).getLocationOnComponent();
            JComponent tmp=(JComponent)((ZoomPane)invoker).getInverseTransformComponent(p1);
            while(!popupMenu.equals(tmp.getComponentPopupMenu()))tmp=(JComponent)tmp.getParent();
            if(tmp!=null)invoker=tmp;
        }

        // FIX : 12292
        Node node = null;
        if (invoker instanceof Node) {
            node = (Node) invoker;
        }//BUGR-116
        else if (invoker instanceof StereotypeTextField){
        	StereotypeTextField f = (StereotypeTextField)invoker;
        	ModelElement modelElement = DeployHelper.getElement(f.getGraphNode());

        	if(modelElement instanceof Attribute){
        		addAccessorsMenu(f, (Attribute) modelElement);
        	}
        }
        else if ((invoker instanceof TextField)||(invoker instanceof GroupTextField)) {
            if (invoker.getParent() instanceof Node) {
                node = (Node) invoker.getParent();
            }
        } else if (invoker instanceof DiagramView) {
            popupMenu.removeAll();
            addAddElementMenu(((DiagramView) invoker));
        }else{
        	popupMenu.removeAll();
        }

        if (node != null) {
            DiagramView diagramView = getDiagramView(node);
            popupMenu.removeAll();
            addExternalMenu(diagramView, node);
            popupMenu.add(createShowMenu(node));
            popupMenu.addSeparator();
            popupMenu.add(createMoveToMenu(node));
            popupMenu.addSeparator();
            addAddElementMenu(diagramView, node);
            popupMenu.addSeparator();
            addDeleteMenu(diagramView, node);
            DeployHelper.selectNode(diagramView.getViewer(), node);
            DeployHelper.notifySelectionChanged(mainFrame, diagramView);
            node.requestFocus(true);
        }
    }

    /**
     * Add menu which enables ceating accessors for attribues
     * @param field
     *          Text field for attribute
     * @param attribute
     *          Attribute
     */
	private void addAccessorsMenu(StereotypeTextField field, Attribute attribute) {
		ClassNode classNode = (ClassNode) field.getParent().getParent();
		String language = mainFrame.getUmlModelManager().getProjectLanguage();
		popupMenu.removeAll();

		if (language.equals("Java")) {
			FeatureAddAction g = new GetterOperationAddAction(mainFrame, attribute);
    		g.setClassNode(classNode);


			FeatureAddAction s = new SetterOperationAddAction(mainFrame, attribute);
			s.setClassNode(classNode);

			popupMenu.add(g).setText("Create getter");
			popupMenu.add(s).setText("Create setter");
			popupMenu.add(new GetterSetterOperationAddAction(g,s)).setText("Create getter and setter");

        } else if(language.equals("CSharp")) {
        	FeatureAddAction s = new PropertyAddAction(mainFrame, attribute ,"property-set");
        	s.setClassNode(classNode);

        	FeatureAddAction g = new PropertyAddAction(mainFrame, attribute ,"property-get");
    		g.setClassNode(classNode);

    		FeatureAddAction gs = new PropertyAddAction(mainFrame, attribute ,"property");
    		gs.setClassNode(classNode);


    		popupMenu.add(g).setText("Create property getter");
    		popupMenu.add(s).setText("Create property setter");
    		popupMenu.add(gs).setText("Create property");
        }
	}

	/**
     * <p>
     * Records position when popup menu becomes invisible.
     * </p>
     * @param e
     *            popup menu event
     */
    public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
        // FIX: BUGR-87
        DiagramView diagramView=DeployHelper.getDiagramView(mainFrame);
        if(diagramView.isVisible()){
            Point p1=diagramView.getLocationOnScreen();
            Point p2 = popupMenu.getLocationOnScreen();
            Point p = new Point(p2.x - p1.x, p2.y - p1.y);
            mainFrame.setPopupPosition(p);
        }else{
            mainFrame.setPopupPosition(((ZoomPane)diagramView.getParent())
                    .getInverseTransformPoint(((SpecialJPopupMenu)popupMenu).getLocationOnComponent()));

        }
    }

    /**
     * <p>
     * Empty.
     * </p>
     */
    public void popupMenuCanceled(PopupMenuEvent e) {
        System.out.println("popupmenu cancelling");
    }

    /**
     * <p>
     * Creates the "Move to" menu for given node.
     * </p>
     * @param node
     *            the node to create menu
     * @return the menu created
     */
    private JMenu createMoveToMenu(Node node) {
        JMenu moveMenu = new JMenu("Move ");

        moveMenu.add(new MoveToFrontAction("to Front", node, mainFrame));
        moveMenu.add(new MoveToBackAction("to Back", node, mainFrame));
        moveMenu.add(new MoveForwardAction("Forward", node, mainFrame));
        moveMenu.add(new MoveBackwardAction("Backward", node, mainFrame));

        return moveMenu;
    }

    /**
     * <p>
     * Creates the "Show" menu for given node. The menu controls the visibility of sterotypes, package, attributes and
     * operations.
     * </p>
     * @param node
     *            the node to create "Show" menu
     * @return the menu created
     */
    private JMenu createShowMenu(Node node) {
        JMenu showMenu = new JMenu("Show");

        GraphNode graphNode = node.getGraphNode();

        if (node instanceof BaseNode) {
            BaseNode activityNode = (BaseNode) node;

            GraphNode stereotype = activityNode.getStereotypeCompartment().getGraphNode();
            showMenu.add(createCheckMenuItem("Stereotype", node, stereotype));
        } else if (node instanceof ObjectNode) {
            // TODO add sterotype menu item for ObjectNode
        	showMenu.add(createCheckMenuItem("Lifeline Name", node, ((ObjectNode)node).getGraphNode()));
        	showMenu.add(createCheckMenuItem("Lifeline Type", node, getDiagramView(node).getDiagram()));
        } else if (node instanceof com.topcoder.gui.diagramviewer.uml.usecaseelements.BaseNode) {
            com.topcoder.gui.diagramviewer.uml.usecaseelements.BaseNode baseNode = (com.topcoder.gui.diagramviewer.uml.usecaseelements.BaseNode) node;

            GraphNode stereotype = baseNode.getStereotypeCompartment().getGraphNode();
            showMenu.add(createCheckMenuItem("Stereotype", node, stereotype));

            GraphNode namespace = baseNode.getNamespaceCompartment().getGraphNode();
            showMenu.add(createCheckMenuItem("Package", node, namespace));
        } else if (node instanceof SubsystemNodeContainer) {
            SubsystemNodeContainer subsystemNodeContainer = (SubsystemNodeContainer) node;

            GraphNode stereotype = subsystemNodeContainer.getStereotypeCompartment().getGraphNode();
            showMenu.add(createCheckMenuItem("Stereotype", node, stereotype));

            GraphNode namespace = subsystemNodeContainer.getNamespaceCompartment().getGraphNode();
            showMenu.add(createCheckMenuItem("Package", node, namespace));
        } else if (node instanceof PackageNode) {
            PackageNode packageNode = (PackageNode) node;

            GraphNode stereotype = packageNode.getStereotypeCompartment().getGraphNode();
            showMenu.add(createCheckMenuItem("Stereotype", node, stereotype));

            GraphNode namespace = packageNode.getNamespaceCompartment().getGraphNode();
            showMenu.add(createCheckMenuItem("Package", node, namespace));
        } else if (node instanceof ClassNode) {
            ClassNode classNode = (ClassNode) node;

            GraphNode stereotype = classNode.getStereotypeCompartment().getGraphNode();
            showMenu.add(createCheckMenuItem("Stereotype", node, stereotype));

            GraphNode namespace = classNode.getNamespaceCompartment().getGraphNode();
            showMenu.add(createCheckMenuItem("Package", node, namespace));

            GraphNode attirbuteCompartment = (GraphNode) graphNode.getContaineds().get(ATTRIBUTE_INDEX);
            showMenu.add(createCheckMenuItem("Attributes", node, attirbuteCompartment));

            GraphNode operationCompartment = (GraphNode) graphNode.getContaineds().get(OPERATION_INDEX);
            showMenu.add(createCheckMenuItem("Operations", node, operationCompartment));
        }

        return showMenu;
    }

    /**
     * <p>
     * Adds the "Add Element" menu items for given diagram view.
     * </p>
     * @param diagramView
     *            the diagram view to create menu
     */
    private void addAddElementMenu(DiagramView diagramView) {
        Diagram diagram = diagramView.getDiagram();
        String typeInfo = DeployHelper.getTypeInfo(diagram);
        if (typeInfo.equals(DeployHelper.DIAGRAM_TYPEINFO[DiagramType.CLASS.ordinal()])) {
            popupMenu.add(new AddElementAction("New Class", mainFrame, diagramView, ClassNode.class));
            popupMenu.add(new AddElementAction("New Interface", mainFrame, diagramView, InterfaceNode.class));
            popupMenu.add(new AddElementAction("New Package", mainFrame, diagramView, PackageNode.class));
        } else if (typeInfo.equals(DeployHelper.DIAGRAM_TYPEINFO[DiagramType.USECASE.ordinal()])) {
            popupMenu.add(new AddElementAction("New Actor", mainFrame, diagramView, ActorNode.class));
            popupMenu.add(new AddElementAction("New SubSystem", mainFrame, diagramView, SubsystemNodeContainer.class));
            popupMenu.add(new AddElementAction("New UseCase", mainFrame, diagramView, UseCaseNode.class));
        } else if (typeInfo.equals(DeployHelper.DIAGRAM_TYPEINFO[DiagramType.SEQUENCE.ordinal()])) {
            popupMenu.add(new AddElementAction("New Lifeline", mainFrame, diagramView, ObjectNode.class));
            // popupMenu.add(new AddElementAction("New Fragment", mainFrame,
            // diagramView, PackageNode.class));
        } else if (typeInfo.equals(DeployHelper.DIAGRAM_TYPEINFO[DiagramType.ACTIVITY.ordinal()])) {
            popupMenu.add(new AddElementAction("New Fork Node", mainFrame, diagramView, ForkNode.class));
            popupMenu.add(new AddElementAction("New Join Node", mainFrame, diagramView, JoinNode.class));
            popupMenu.add(new AddElementAction("New Decision Node", mainFrame, diagramView, DecisionNode.class));
            popupMenu.add(new AddElementAction("New Merge Node", mainFrame, diagramView, MergeNode.class));
            popupMenu.add(new AddElementAction("New Initial Node", mainFrame, diagramView, InitialNode.class));
            JMenuItem menuItem = (JMenuItem) popupMenu.getComponent(popupMenu.getComponentCount() - 1);
            menuItem.setEnabled(!isInitialNodeExist(diagramView));
            popupMenu.add(new AddElementAction("New Activity Final Node", mainFrame, diagramView, FinalNode.class));
            popupMenu.add(new AddElementAction("New Flow Final Node", mainFrame, diagramView, FlowFinalNode.class));
            popupMenu.add(new AddElementAction("New Object Flow Node", mainFrame, diagramView, ObjectFlowNode.class));
            popupMenu.add(new AddElementAction("New Call Action", mainFrame, diagramView, ActionState.class));
            popupMenu
                    .add(new AddElementAction("New Send Signal Action", mainFrame, diagramView, SendSignalAction.class));
            popupMenu.add(new AddElementAction("New Accept Event Action", mainFrame, diagramView,
                    AcceptEventAction.class));
        }
        popupMenu.add(new AddElementAction("New Comment", mainFrame, diagramView, CommentNode.class));
        popupMenu.add(new AddElementAction("New Text Element", mainFrame, diagramView, FreeTextNode.class));
        popupMenu.add(new AddElementAction("New Shape", mainFrame, diagramView, PolylineNode.class));
    }

    /**
     * <p>
     * Adds the "Add Element" menu items for given node.
     * </p>
     * @param diagramView
     *            the diagram view to add element
     * @param node
     *            the node to add menu
     */
    private void addAddElementMenu(DiagramView diagramView, Node node) {
        Diagram diagram = diagramView.getDiagram();
        String typeInfo = DeployHelper.getTypeInfo(diagram);

        if (node instanceof ClassNode) {
            popupMenu.add(new AddElementAction("New Association", mainFrame, diagramView, node.getClass(),
                    AssociationEdge.class));
            popupMenu.add(new AddElementAction("New Aggregation", mainFrame, diagramView, node.getClass(),
                    AssociationEdge.class));
            popupMenu.add(new AddElementAction("New Composition", mainFrame, diagramView, node.getClass(),
                    AssociationEdge.class));
            popupMenu.add(new AddElementAction("New Generalization", mainFrame, diagramView, node.getClass(),
                    GeneralizationEdge.class));
            popupMenu.add(new AddElementAction("New Dependency", mainFrame, diagramView, node.getClass(),
                    DependencyEdge.class));
            if (!(node instanceof InterfaceNode)) {
                popupMenu.add(new AddElementAction("New Realization", mainFrame, diagramView, ClassNode.class,
                        AbstractionEdge.class));
            }
        } else if (node instanceof PackageNode) {
            if (typeInfo.equals(DeployHelper.DIAGRAM_TYPEINFO[DiagramType.CLASS.ordinal()])) {
                popupMenu.add(new AddElementAction("New Association", mainFrame, diagramView, node.getClass(),
                        AssociationEdge.class));
                popupMenu.add(new AddElementAction("New Aggregation", mainFrame, diagramView, node.getClass(),
                        AssociationEdge.class));
            } else if (typeInfo.equals(DeployHelper.DIAGRAM_TYPEINFO[DiagramType.USECASE.ordinal()])) {
                popupMenu.add(new AddElementAction("New Dependency", mainFrame, diagramView, node.getClass(),
                        DependencyEdge.class));
            }

        } else if (node instanceof ActorNode) {
            popupMenu.add(new AddElementAction("New Generalization", mainFrame, diagramView, node.getClass(),
                    GeneralizationEdge.class));
        } else if (node instanceof UseCaseNode) {
            popupMenu.add(new AddElementAction("New Association", mainFrame, diagramView, node.getClass(),
                    AssociationEdge.class));
            popupMenu.add(new AddElementAction("New Include", mainFrame, diagramView, node.getClass(),
                    IncludeEdge.class));
            popupMenu
                    .add(new AddElementAction("New Extend", mainFrame, diagramView, node.getClass(), ExtendEdge.class));
        } else if (node instanceof SubsystemNodeContainer) {
            // Empty
        } else if (node instanceof PackageNode) {
            popupMenu.add(new AddElementAction("New Association", mainFrame, diagramView, node.getClass(),
                    AssociationEdge.class));
            popupMenu.add(new AddElementAction("New Include", mainFrame, diagramView, node.getClass(),
                    IncludeEdge.class));
            popupMenu
                    .add(new AddElementAction("New Extend", mainFrame, diagramView, node.getClass(), ExtendEdge.class));
        } else if (node instanceof ObjectNode) {
            popupMenu.add(new AddElementAction("New Synchronous Message", mainFrame, diagramView, ObjectNode.class,
                    SynchronousMessageEdge.class));
            popupMenu.add(new AddElementAction("New Asynchronous Message", mainFrame, diagramView, ObjectNode.class,
                    AsynchronousMessageEdge.class));
            popupMenu.add(new AddElementAction("New Create Message", mainFrame, diagramView, ObjectNode.class,
                    CreateMessageEdge.class));
            popupMenu.add(new AddElementAction("New Signal Message", mainFrame, diagramView, ObjectNode.class,
                    SendSignalMessageEdge.class));
            popupMenu.add(new AddElementAction("New Return Message", mainFrame, diagramView, ObjectNode.class,
                    ReturnMessageEdge.class));
        } else if (node instanceof SendSignalAction || node instanceof AcceptEventAction
                || node instanceof DecisionNode || node instanceof FlowFinalNode || node instanceof ForkNode
                || node instanceof JoinNode || node instanceof MergeNode || node instanceof ObjectFlowNode) {
            popupMenu.add(new AddElementAction("New Fork Node", mainFrame, diagramView, ForkNode.class));
            popupMenu.add(new AddElementAction("New Join Node", mainFrame, diagramView, JoinNode.class));
            popupMenu.add(new AddElementAction("New Decision Node", mainFrame, diagramView, DecisionNode.class));
            popupMenu.add(new AddElementAction("New Merge Node", mainFrame, diagramView, MergeNode.class));
            popupMenu.add(new AddElementAction("New Activity Final Node", mainFrame, diagramView, FinalNode.class));
            popupMenu.add(new AddElementAction("New Flow Final Node", mainFrame, diagramView, FlowFinalNode.class));
            popupMenu.add(new AddElementAction("New Object Flow Node", mainFrame, diagramView, ObjectFlowNode.class));
            popupMenu.add(new AddElementAction("New Call Action", mainFrame, diagramView, ActionState.class));
            popupMenu
                    .add(new AddElementAction("New Send Signal Action", mainFrame, diagramView, SendSignalAction.class));
            popupMenu.add(new AddElementAction("New Accept Event Action", mainFrame, diagramView,
                    AcceptEventAction.class));
            popupMenu.add(new AddElementAction("New Transition", mainFrame, diagramView, ActionState.class,
                    Transition.class));
        }
        popupMenu.add(new AddElementAction("New Comment", mainFrame, diagramView, node.getClass(),
                CommentLinkEdge.class));
    }

    /**
     * <p>
     * Adds menu for deleting node.
     * </p>
     * @param diagramView
     *            diagram view to add delete menu
     * @param node
     *            node to delete
     */
    private void addDeleteMenu(DiagramView diagramView, Node node) {
        AbstractAction action = new DeleteElementAction(mainFrame);
        action.putValue(Action.SMALL_ICON, null);
        action.putValue(Action.ACCELERATOR_KEY, null);
        popupMenu.add(action);
        action = new DeleteRepresentationAction(mainFrame);
        action.putValue(Action.SMALL_ICON, null);
        action.putValue(Action.ACCELERATOR_KEY, null);
        popupMenu.add(action);
    }

    /**
     * <p>
     * Creates a <code>JCheckBoxMenuItem</code> for given graph node.
     * </p>
     * @param name
     *            name of menu item
     * @param node
     *            the node whose graph node's visibility is to be changed
     * @param graphNode
     *            the graph node whose visibility is to be changed
     * @return the menu item created
     */
    private JCheckBoxMenuItem createCheckMenuItem(String name, Node node, GraphNode graphNode) {
        JCheckBoxMenuItem item = new JCheckBoxMenuItem(new ShowElementsAction(name, mainFrame, node, graphNode));
        if (graphNode != null) {
            item.setState(graphNode.isVisible());
        } else {
            item.setState(false);
        }
        
        if(node instanceof ObjectNode){
        	ObjectNode objectNode=(ObjectNode)node;
        	 int flag=objectNode.getDisplayFlag();
        	if(name.indexOf("Name")>=0)
        	{
        		flag&=1;
        	}
        	else
        	{
        		flag&=2;
        	}
        	item.setState(flag==0);
        		
        }
        return item;
    }

    /**
     * <p>
     * Gets the parent diagram view of one node.
     * </p>
     * @param node
     *            the node in diagram view
     * @return the diagram view contains the node
     */
    private DiagramView getDiagramView(Node node) {
        Component component = null;
        for (component = node.getParent(); !(component instanceof DiagramView); component = component.getParent()) {

        }
        return (DiagramView) component;
    }

    /**
     * <p>
     * Checks if there exists an initial node.
     * </p>
     * @param diagramView
     *            the diagram view to find initial node
     * @return true if found, otherwise false
     */
    private boolean isInitialNodeExist(DiagramView diagramView) {
        Component[] components = diagramView.getComponents();
        for (Component component : components) {
            if (component instanceof InitialNode) {
                return true;
            }
        }
        return false;
    }

    /**
     * <p>
     * Adds the "External" menu item for give node
     * </p>
     * @param diagramView
     *            the diagram view to add element
     * @param node
     *            the node to add menu
     */
    private void addExternalMenu(DiagramView diagramView, Node node) {
        if (node instanceof ClassNode) {
        	ClassNode classNode = (ClassNode) node;
        	JCheckBoxMenuItem item = new JCheckBoxMenuItem(new ShowExternalElementsAction("External", mainFrame, classNode));
        	item.setSelected(classNode.isExternal());
        	popupMenu.add(item);
        }
    }
}

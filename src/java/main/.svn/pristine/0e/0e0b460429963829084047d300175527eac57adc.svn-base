/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */

package com.topcoder.umltool.deploy;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Point;
import java.util.EnumMap;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

import com.topcoder.gui.diagramviewer.DiagramState;
import com.topcoder.gui.diagramviewer.DiagramView;
import com.topcoder.gui.diagramviewer.DiagramViewer;
import com.topcoder.gui.diagramviewer.uml.activityelements.AcceptEventAction;
import com.topcoder.gui.diagramviewer.uml.activityelements.ActionState;
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
import com.topcoder.gui.diagramviewer.uml.classedges.Aggregation;
import com.topcoder.gui.diagramviewer.uml.classedges.AggregationBiDirectional;
import com.topcoder.gui.diagramviewer.uml.classedges.AssociationEdge;
import com.topcoder.gui.diagramviewer.uml.classedges.Composition;
import com.topcoder.gui.diagramviewer.uml.classedges.CompositionBiDirectional;
import com.topcoder.gui.diagramviewer.uml.classedges.DependencyEdge;
import com.topcoder.gui.diagramviewer.uml.classedges.DirectedAssociation;
import com.topcoder.gui.diagramviewer.uml.classedges.GeneralizationEdge;
import com.topcoder.gui.diagramviewer.uml.classedges.NoArrow;
import com.topcoder.gui.diagramviewer.uml.classelements.ClassNode;
import com.topcoder.gui.diagramviewer.uml.classelements.EnumClassNode;
import com.topcoder.gui.diagramviewer.uml.classelements.ExceptionNode;
import com.topcoder.gui.diagramviewer.uml.classelements.InterfaceNode;
import com.topcoder.gui.diagramviewer.uml.classelements.PackageNode;
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
import com.topcoder.gui.toolbars.elements.ElementSelectedListener;
import com.topcoder.gui.toolbars.elements.SectionPanel;
import com.topcoder.gui.toolbars.elements.ToolBarMainPanelProducer;

/**
 * <p>
 * Tool panel of the uml tool used for add elements to diagrams.
 * </p>
 * <p>
 * It contains four types of tool panels related to DiagramType.
 * </p>
 * <p>
 * Note, ElementSelectedListener interface is implemented here.
 * </p>
 *
 * @author ly, FireIce, ylouis, TCSDEVELOPER
 * @version 1.0
 */
@SuppressWarnings("serial")
public class ToolPanel extends JPanel implements ElementSelectedListener {
    /**
     * <p>
     * Represents the map of diagram type to tool panel.
     * </p>
     */
    private Map<DiagramType, JPanel> toolPanelMap = new EnumMap<DiagramType, JPanel>(DiagramType.class);

    /**
     * <p>
     * Represents current diagram type.
     * </p>
     * <p>
     * The content of tool panel is changed according to this value.
     * </p>
     */
    private DiagramType currentDiagramType = null;

    /**
     * <p>
     * Represents the selected button in tool panel.
     * </p>
     * <p>
     * Selected button is recorded for unselect previous button.
     * </p>
     */
    private JToggleButton selectedButton = null;

    /**
     * <p>
     * Main frame window.
     * </p>
     */
    private final MainFrame mainFrame;

    /**
     * <p>
     * Reference to the DiagramViewer of the uml tool.
     * </p>
     */
    private DiagramViewer diagramViewer = null;

    /**
     * <p>
     * Creates an instance of tool panel and sets related class variables by using the arguments.
     * </p>
     * <p>
     * Four tool panels are initialized by loading from the config manager. .
     * </p>
     *
     * @param mainFrame
     *            Reference to the main frame.
     * @param diagramViewer
     *            Reference to the DiagramViewer.
     * @throws IllegalArgumentException
     *             if any argument is null, or if propertyNameMapping is empty
     */
    public ToolPanel(MainFrame mainFrame, DiagramViewer diagramViewer) {
        DeployHelper.checkNotNull(mainFrame, "mainFrame");
        DeployHelper.checkNotNull(diagramViewer, "diagramViewer");
        this.mainFrame = mainFrame;
        this.diagramViewer = diagramViewer;

        setLayout(new BorderLayout());

        // Create four instances of ToolBarMainPanelProducer
        String look = "javax.swing.plaf.metal.MetalLookAndFeel";
        Dimension preferredSize = new Dimension(200, 250);
        Dimension minimumSize = new Dimension(0, 0);

        ToolBarMainPanelProducer classMainPanelProducer =
            new ToolBarMainPanelProducer(4, 3, look, preferredSize, minimumSize);
        ToolBarMainPanelProducer usecaseMainPanelProducer =
            new ToolBarMainPanelProducer(4, 3, look, preferredSize, minimumSize);
        ToolBarMainPanelProducer sequenceMainPanelProducer =
            new ToolBarMainPanelProducer(3, 3, look, preferredSize, minimumSize);
        ToolBarMainPanelProducer activityMainPanelProducer =
            new ToolBarMainPanelProducer(4, 3, look, preferredSize, minimumSize);

        try {
            // create class diagram section panels
            String namespace = "com.topcoder.gui.toolbars.elements.class.elements";
            SectionPanel sectionPanel = new SectionPanel(namespace);

            sectionPanel.addListenerForAllButtons(this);
            classMainPanelProducer.addNewSectionPanel(0, 0, 3, 1, sectionPanel);

            namespace = "com.topcoder.gui.toolbars.elements.class.connectors1";
            sectionPanel = new SectionPanel(namespace);
            sectionPanel.addListenerForAllButtons(this);
            classMainPanelProducer.addNewSectionPanel(0, 1, 3, 1, sectionPanel);

            namespace = "com.topcoder.gui.toolbars.elements.class.connectors2";
            sectionPanel = new SectionPanel(namespace);
            sectionPanel.addListenerForAllButtons(this);
            classMainPanelProducer.addNewSectionPanel(0, 2, 3, 1, sectionPanel);

            namespace = "com.topcoder.gui.toolbars.elements.text";
            sectionPanel = new SectionPanel(namespace);
            sectionPanel.addListenerForAllButtons(this);
            classMainPanelProducer.addNewSectionPanel(0, 3, 1, 1, sectionPanel);

            namespace = "com.topcoder.gui.toolbars.elements.shapes";
            sectionPanel = new SectionPanel(namespace);
            sectionPanel.addListenerForAllButtons(this);
            classMainPanelProducer.addNewSectionPanel(1, 3, 1, 1, sectionPanel);

            namespace = "com.topcoder.gui.toolbars.elements.comments";
            sectionPanel = new SectionPanel(namespace);
            sectionPanel.addListenerForAllButtons(this);
            classMainPanelProducer.addNewSectionPanel(2, 3, 1, 1, sectionPanel);

            // create usecase diagram section panels
            namespace = "com.topcoder.gui.toolbars.elements.usecase.elements";
            sectionPanel = new SectionPanel(namespace);
            sectionPanel.addListenerForAllButtons(this);
            usecaseMainPanelProducer.addNewSectionPanel(0, 0, 3, 1, sectionPanel);

            namespace = "com.topcoder.gui.toolbars.elements.usecase.connectors1";
            sectionPanel = new SectionPanel(namespace);
            sectionPanel.addListenerForAllButtons(this);
            usecaseMainPanelProducer.addNewSectionPanel(0, 1, 3, 1, sectionPanel);

            namespace = "com.topcoder.gui.toolbars.elements.usecase.connectors2";
            sectionPanel = new SectionPanel(namespace);
            sectionPanel.addListenerForAllButtons(this);
            usecaseMainPanelProducer.addNewSectionPanel(0, 2, 3, 1, sectionPanel);

            namespace = "com.topcoder.gui.toolbars.elements.text";
            sectionPanel = new SectionPanel(namespace);
            sectionPanel.addListenerForAllButtons(this);
            usecaseMainPanelProducer.addNewSectionPanel(0, 3, 1, 1, sectionPanel);

            namespace = "com.topcoder.gui.toolbars.elements.shapes";
            sectionPanel = new SectionPanel(namespace);
            sectionPanel.addListenerForAllButtons(this);
            usecaseMainPanelProducer.addNewSectionPanel(1, 3, 1, 1, sectionPanel);

            namespace = "com.topcoder.gui.toolbars.elements.comments";
            sectionPanel = new SectionPanel(namespace);
            sectionPanel.addListenerForAllButtons(this);
            usecaseMainPanelProducer.addNewSectionPanel(2, 3, 1, 1, sectionPanel);

            // create sequence diagram section panels
            namespace = "com.topcoder.gui.toolbars.elements.sequence.elements";
            sectionPanel = new SectionPanel(namespace);
            sectionPanel.addListenerForAllButtons(this);
            sequenceMainPanelProducer.addNewSectionPanel(0, 0, 3, 1, sectionPanel);

            // TODO fragment is not supported
            // sequenceMainPanelProducer.addNewSectionPanel(0, 0, 2, 1, sectionPanel);

            // namespace = "com.topcoder.gui.toolbars.elements.sequence.fragments";
            // sectionPanel = new SectionPanel(namespace);
            // sectionPanel.addListenerForAllButtons(this);
            // sequenceMainPanelProducer.addNewSectionPanel(2, 0, 1, 1, sectionPanel);

            namespace = "com.topcoder.gui.toolbars.elements.sequence.connectors";
            sectionPanel = new SectionPanel(namespace);
            sectionPanel.addListenerForAllButtons(this);
            sequenceMainPanelProducer.addNewSectionPanel(0, 1, 3, 1, sectionPanel);

            namespace = "com.topcoder.gui.toolbars.elements.text";
            sectionPanel = new SectionPanel(namespace);
            sectionPanel.addListenerForAllButtons(this);
            sequenceMainPanelProducer.addNewSectionPanel(0, 2, 1, 1, sectionPanel);

            namespace = "com.topcoder.gui.toolbars.elements.shapes";
            sectionPanel = new SectionPanel(namespace);
            sectionPanel.addListenerForAllButtons(this);
            sequenceMainPanelProducer.addNewSectionPanel(1, 2, 1, 1, sectionPanel);

            namespace = "com.topcoder.gui.toolbars.elements.comments";
            sectionPanel = new SectionPanel(namespace);
            sectionPanel.addListenerForAllButtons(this);
            sequenceMainPanelProducer.addNewSectionPanel(2, 2, 1, 1, sectionPanel);

            // create activity diagram section panels
            namespace = "com.topcoder.gui.toolbars.elements.activity.elements";
            sectionPanel = new SectionPanel(namespace);
            sectionPanel.addListenerForAllButtons(this);
            activityMainPanelProducer.addNewSectionPanel(0, 0, 3, 1, sectionPanel);

            namespace = "com.topcoder.gui.toolbars.elements.activity.connectors";
            sectionPanel = new SectionPanel(namespace);
            sectionPanel.addListenerForAllButtons(this);
            activityMainPanelProducer.addNewSectionPanel(2, 2, 1, 1, sectionPanel);

            namespace = "com.topcoder.gui.toolbars.elements.activity.nodes1";
            sectionPanel = new SectionPanel(namespace);
            sectionPanel.addListenerForAllButtons(this);
            activityMainPanelProducer.addNewSectionPanel(0, 1, 3, 1, sectionPanel);

            namespace = "com.topcoder.gui.toolbars.elements.activity.nodes2";
            sectionPanel = new SectionPanel(namespace);
            sectionPanel.addListenerForAllButtons(this);
            activityMainPanelProducer.addNewSectionPanel(0, 2, 2, 1, sectionPanel);

            namespace = "com.topcoder.gui.toolbars.elements.text";
            sectionPanel = new SectionPanel(namespace);
            sectionPanel.addListenerForAllButtons(this);
            activityMainPanelProducer.addNewSectionPanel(0, 3, 1, 1, sectionPanel);

            namespace = "com.topcoder.gui.toolbars.elements.shapes";
            sectionPanel = new SectionPanel(namespace);
            sectionPanel.addListenerForAllButtons(this);
            activityMainPanelProducer.addNewSectionPanel(1, 3, 1, 1, sectionPanel);

            namespace = "com.topcoder.gui.toolbars.elements.comments";
            sectionPanel = new SectionPanel(namespace);
            sectionPanel.addListenerForAllButtons(this);
            activityMainPanelProducer.addNewSectionPanel(2, 3, 1, 1, sectionPanel);
        } catch (Exception e) {
            DeployHelper.handleException(mainFrame, e, "Create tool panel from config file failed.");
        }

        // set the tool panel map and set default diagram type.
        toolPanelMap.put(DiagramType.CLASS, classMainPanelProducer.getToolBarMainPanel());
        toolPanelMap.put(DiagramType.USECASE, usecaseMainPanelProducer.getToolBarMainPanel());
        toolPanelMap.put(DiagramType.SEQUENCE, sequenceMainPanelProducer.getToolBarMainPanel());
        toolPanelMap.put(DiagramType.ACTIVITY, activityMainPanelProducer.getToolBarMainPanel());
        SetToolPanelType(DiagramType.CLASS);
    }

    /**
     * <p>
     * Sets current diagram type, and update the tool panel.
     * </p>
     *
     * @param diagramType
     *            diagram type to change
     */
    public void SetToolPanelType(DiagramType diagramType) {
        // diagramType exists and not equal to current one
        if (diagramType != null && toolPanelMap.containsKey(diagramType)) {
            // unselect previous selected element
            UnselectElement();

            // check whether need to change tool panel type
            if (diagramType != currentDiagramType) {
                // remove previous panel type
                if (currentDiagramType != null) {
                    remove(toolPanelMap.get(currentDiagramType));
                }
                currentDiagramType = diagramType;
                add(toolPanelMap.get(diagramType));
                updateUI();
            }
        }
    }

    /**
     * <p>
     * Unselects selected button.
     * </p>
     */
    public void UnselectElement() {
        if (selectedButton != null) {
            selectedButton.setSelected(false);
            selectedButton = null;
        }
    }

    /**
     * <p>
     * Invoked when one element is selected in tool panel.
     * </p>
     *
     * @param button
     *            the JToggleButton instance that is registered by this listener
     * @param sectionPanel
     *            the SectionPanel instance that the button is added into.
     */
    public void elementSelected(JToggleButton button, SectionPanel sectionPanel) {
        DeployHelper.checkNotNull(button, "button");
        DeployHelper.checkNotNull(sectionPanel, "sectionPanel");

        DiagramView view = DeployHelper.getDiagramView(mainFrame);

        if (!button.isSelected()) {
            // unselect it if it is already selected
            button.setSelected(false);
            selectedButton = null;
            diagramViewer.setState(DiagramState.SELECT_ELEMENT);

            if (view != null) {
                DeployHelper.setViewCursor(view, Cursor.getDefaultCursor());
            }
        } else {
            if (button != selectedButton) {
                // select another button, unselect previous one
                if (selectedButton != null) {
                    selectedButton.setSelected(false);
                }
                selectedButton = button;

                // set the state and adding element type of diagramviewer
                String buttonName = button.getName();
                if (view == null) {
                    return;
                }

                if (mainFrame.isSwiftCreation()) {
                    // Create cursor with the icon of the button
                    Cursor cursor =
                        view.getToolkit().createCustomCursor(((ImageIcon) button.getIcon()).getImage(),
                            new Point(0, 0), "");
                    if (cursor == null) {
                        cursor = new Cursor(Cursor.CROSSHAIR_CURSOR);
                    }
                    DeployHelper.setViewCursor(view, cursor);
                } else {
                    DeployHelper.setViewCursor(view, new Cursor(Cursor.CROSSHAIR_CURSOR));
                }

                if (buttonName.equals("Create a new Usecase")) {
                    diagramViewer.setNewElementType(UseCaseNode.class);
                    diagramViewer.setState(DiagramState.ADD_ELEMENT_BY_CLICK);
                } else if (buttonName.equals("Create a new Actor")) {
                    diagramViewer.setNewElementType(ActorNode.class);
                    diagramViewer.setState(DiagramState.ADD_ELEMENT_BY_CLICK);
                } else if (buttonName.equals("Create a new Subsystem")) {
                    diagramViewer.setNewElementType(SubsystemNodeContainer.class);
                    diagramViewer.setState(DiagramState.ADD_ELEMENT_BY_CLICK);
                } else if (buttonName.equals("Create an Include")) {
                    diagramViewer.setNewElementType(IncludeEdge.class);
                    diagramViewer.setState(DiagramState.ADD_DASHED_EDGE);
                } else if (buttonName.equals("Create an Extend")) {
                    diagramViewer.setNewElementType(ExtendEdge.class);
                    diagramViewer.setState(DiagramState.ADD_DASHED_EDGE);
                } else if (buttonName.equals("Create a new Lifeline")) {
                    diagramViewer.setNewElementType(ObjectNode.class);
                    diagramViewer.setState(DiagramState.ADD_ELEMENT_BY_CLICK);
                } else if (buttonName.equals("Create a Synchronous Message")) {
                    diagramViewer.setNewElementType(SynchronousMessageEdge.class);
                    diagramViewer.setState(DiagramState.ADD_SOLID_EDGE);
                } else if (buttonName.equals("Create an Asynchronous Message")) {
                    diagramViewer.setNewElementType(AsynchronousMessageEdge.class);
                    diagramViewer.setState(DiagramState.ADD_SOLID_EDGE);
                } else if (buttonName.equals("Create a Create Message")) {
                    diagramViewer.setNewElementType(CreateMessageEdge.class);
                    diagramViewer.setState(DiagramState.ADD_SOLID_EDGE);
                } else if (buttonName.equals("Create a Send Signal Message")) {
                    diagramViewer.setNewElementType(SendSignalMessageEdge.class);
                    diagramViewer.setState(DiagramState.ADD_SOLID_EDGE);
                } else if (buttonName.equals("Create a Return Message")) {
                    diagramViewer.setNewElementType(ReturnMessageEdge.class);
                    diagramViewer.setState(DiagramState.ADD_SOLID_EDGE);
                } else if (buttonName.equals("Create a new Fork Node")) {
                    diagramViewer.setNewElementType(ForkNode.class);
                    diagramViewer.setState(DiagramState.ADD_ELEMENT_BY_CLICK);
                } else if (buttonName.equals("Create a new Join Node")) {
                    diagramViewer.setNewElementType(JoinNode.class);
                    diagramViewer.setState(DiagramState.ADD_ELEMENT_BY_CLICK);
                } else if (buttonName.equals("Create a new Decision Node")) {
                    diagramViewer.setNewElementType(DecisionNode.class);
                    diagramViewer.setState(DiagramState.ADD_ELEMENT_BY_CLICK);
                } else if (buttonName.equals("Create a new Merge Node")) {
                    diagramViewer.setNewElementType(MergeNode.class);
                    diagramViewer.setState(DiagramState.ADD_ELEMENT_BY_CLICK);
                } else if (buttonName.equals("Create a new Initial Node")) {
                    diagramViewer.setNewElementType(InitialNode.class);
                    diagramViewer.setState(DiagramState.ADD_ELEMENT_BY_CLICK);
                } else if (buttonName.equals("Create a new Activity Final Node")) {
                    diagramViewer.setNewElementType(FinalNode.class);
                    diagramViewer.setState(DiagramState.ADD_ELEMENT_BY_CLICK);
                } else if (buttonName.equals("Create a new Flow Final Node")) {
                    diagramViewer.setNewElementType(FlowFinalNode.class);
                    diagramViewer.setState(DiagramState.ADD_ELEMENT_BY_CLICK);
                } else if (buttonName.equals("Create a new Call Action")) {
                    diagramViewer.setNewElementType(ActionState.class);
                    diagramViewer.setState(DiagramState.ADD_ELEMENT_BY_CLICK);
                } else if (buttonName.equals("Create a new Send Signal Action")) {
                    diagramViewer.setNewElementType(SendSignalAction.class);
                    diagramViewer.setState(DiagramState.ADD_ELEMENT_BY_CLICK);
                } else if (buttonName.equals("Create a new Accept Event Action")) {
                    diagramViewer.setNewElementType(AcceptEventAction.class);
                    diagramViewer.setState(DiagramState.ADD_ELEMENT_BY_CLICK);
                } else if (buttonName.equals("Create a new Object Flow Node")) {
                    diagramViewer.setNewElementType(ObjectFlowNode.class);
                    diagramViewer.setState(DiagramState.ADD_ELEMENT_BY_CLICK);
                } else if (buttonName.equals("Create a Transition")) {
                    diagramViewer.setNewElementType(Transition.class);
                    diagramViewer.setState(DiagramState.ADD_SOLID_EDGE);
                } else if (buttonName.equals("Create an Association")) {
                    diagramViewer.setNewElementType(AssociationEdge.class);
                    diagramViewer.setState(DiagramState.ADD_SOLID_EDGE);
                    mainFrame.setAssociationType(NoArrow.class);
                } else if (buttonName.equals("Create a Directed Association")) {
                    diagramViewer.setNewElementType(AssociationEdge.class);
                    diagramViewer.setState(DiagramState.ADD_SOLID_EDGE);
                    mainFrame.setAssociationType(DirectedAssociation.class);
                } else if (buttonName.equals("Create an Aggregation")) {
                    diagramViewer.setNewElementType(AssociationEdge.class);
                    diagramViewer.setState(DiagramState.ADD_SOLID_EDGE);
                    mainFrame.setAssociationType(Aggregation.class);
                } else if (buttonName.equals("Create a Directed Aggregation")) {
                    diagramViewer.setNewElementType(AssociationEdge.class);
                    diagramViewer.setState(DiagramState.ADD_SOLID_EDGE);
                    mainFrame.setAssociationType(AggregationBiDirectional.class);
                } else if (buttonName.equals("Create a Composition")) {
                    diagramViewer.setNewElementType(AssociationEdge.class);
                    diagramViewer.setState(DiagramState.ADD_SOLID_EDGE);
                    mainFrame.setAssociationType(Composition.class);
                } else if (buttonName.equals("Create a Directed Composition")) {
                    diagramViewer.setNewElementType(AssociationEdge.class);
                    diagramViewer.setState(DiagramState.ADD_SOLID_EDGE);
                    mainFrame.setAssociationType(CompositionBiDirectional.class);
                } else if (buttonName.equals("Create a Generalizaton")) {
                    diagramViewer.setNewElementType(GeneralizationEdge.class);
                    diagramViewer.setState(DiagramState.ADD_SOLID_EDGE);
                } else if (buttonName.equals("Create a Dependency")) {
                    diagramViewer.setNewElementType(DependencyEdge.class);
                    diagramViewer.setState(DiagramState.ADD_DASHED_EDGE);
                } else if (buttonName.equals("Create a Realization")) {
                    diagramViewer.setNewElementType(AbstractionEdge.class);
                    diagramViewer.setState(DiagramState.ADD_DASHED_EDGE);
                } else if (buttonName.equals("Create a new Comment")) {
                    diagramViewer.setNewElementType(CommentNode.class);
                    diagramViewer.setState(DiagramState.ADD_ELEMENT_BY_CLICK);
                } else if (buttonName.equals("Create a new text element")) {
                    diagramViewer.setNewElementType(FreeTextNode.class);
                    diagramViewer.setState(DiagramState.ADD_ELEMENT_BY_CLICK);
                } else if (buttonName.equals("Connect comment to model element")) {
                    diagramViewer.setNewElementType(CommentLinkEdge.class);
                    diagramViewer.setState(DiagramState.ADD_DASHED_EDGE);
                } else if (buttonName.equals("Create a new shape")) {
                    diagramViewer.setNewElementType(PolylineNode.class);
                    diagramViewer.setState(DiagramState.ADD_ELEMENT_BY_DRAGGING_RECTANGLE);
                } else if (buttonName.equals("Create a new Package")) {
                    diagramViewer.setNewElementType(PackageNode.class);
                    diagramViewer.setState(DiagramState.ADD_ELEMENT_BY_CLICK);
                } else if (buttonName.equals("Create a new Class")) {
                    diagramViewer.setNewElementType(ClassNode.class);
                    diagramViewer.setState(DiagramState.ADD_ELEMENT_BY_CLICK);
                } else if (buttonName.equals("Create a new Interface")) {
                    diagramViewer.setNewElementType(InterfaceNode.class);
                    diagramViewer.setState(DiagramState.ADD_ELEMENT_BY_CLICK);
                } else if (buttonName.equals("Create a new Exception")) {
                    diagramViewer.setNewElementType(ExceptionNode.class);
                    diagramViewer.setState(DiagramState.ADD_ELEMENT_BY_CLICK);
                } else if (buttonName.equals("Create a new Enum")) {
                    diagramViewer.setNewElementType(EnumClassNode.class);
                    diagramViewer.setState(DiagramState.ADD_ELEMENT_BY_CLICK);
                }
            }
        }
    }
}

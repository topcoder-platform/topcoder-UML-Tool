/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.dnd.DropTarget;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.JViewport;
import javax.swing.ToolTipManager;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.DiagramElement;
import com.topcoder.diagraminterchange.GraphConnector;
import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.Polyline;
import com.topcoder.diagraminterchange.SemanticModelBridge;
import com.topcoder.diagraminterchange.SimpleSemanticModelElement;
import com.topcoder.diagraminterchange.Uml1SemanticModelBridge;
import com.topcoder.gui.closabletabbedpane.ClosableTabbedPane;
import com.topcoder.gui.closabletabbedpane.ClosableTabbedPaneEvent;
import com.topcoder.gui.closabletabbedpane.ClosableTabbedPaneEventHandler;
import com.topcoder.gui.diagramviewer.DiagramView;
import com.topcoder.gui.diagramviewer.DiagramViewer;
import com.topcoder.gui.diagramviewer.edges.Connector;
import com.topcoder.gui.diagramviewer.edges.Edge;
import com.topcoder.gui.diagramviewer.elements.Node;
import com.topcoder.gui.diagramviewer.elements.NodeContainer;
import com.topcoder.gui.diagramviewer.event.DiagramNameChangedListener;
import com.topcoder.gui.diagramviewer.uml.activityelements.AcceptEventAction;
import com.topcoder.gui.diagramviewer.uml.activityelements.SendSignalAction;
import com.topcoder.gui.diagramviewer.uml.auxiliaryelements.PolylineNode;
import com.topcoder.gui.diagramviewer.uml.classedges.ActiveEdgeEnding;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.ObjectNode;
import com.topcoder.gui.panels.documentation.DocumentationEditor;
import com.topcoder.gui.panels.documentation.DocumentationPanel;
import com.topcoder.gui.panels.properties.PropertiesPanel;
import com.topcoder.gui.panels.style.StylePanel;
import com.topcoder.gui.panels.zoom.ZoomPane;
import com.topcoder.gui.panels.zoom.ZoomPanel;
import com.topcoder.gui.sectionlayout.Section;
import com.topcoder.gui.sectionlayout.SectionDockContainer;
import com.topcoder.gui.sectionlayout.SectionExpandContractListener;
import com.topcoder.gui.sectionlayout.dock.Dock;
import com.topcoder.gui.sectionlayout.dock.DockContainer;
import com.topcoder.gui.sectionlayout.dock.DockEvent;
import com.topcoder.gui.sectionlayout.dock.DockListener;
import com.topcoder.gui.sectionlayout.dock.FloatContainer;
import com.topcoder.gui.sectionlayout.dock.dndimpl.DefaultDock;
import com.topcoder.gui.sidemenu.DefaultCollapsedSideMenuPanel;
import com.topcoder.gui.sidemenu.DefaultExpandedSideMenuPanel;
import com.topcoder.gui.sidemenu.SideMenuModel;
import com.topcoder.gui.sidemenu.SideMenuPanel;
import com.topcoder.gui.trees.document.DocumentTreeNode;
import com.topcoder.gui.trees.document.DocumentTreePanel;
import com.topcoder.gui.trees.document.DocumentTreeTabbedPane;
import com.topcoder.gui.trees.document.DocumentTreeView;
import com.topcoder.gui.trees.document.impl.DiagramCentricDocumentTreeView;
import com.topcoder.gui.trees.document.impl.DocumentTreeTabbedPaneImpl;
import com.topcoder.uml.actions.auxiliary.comment.model.ChangeCommentTextAction;
import com.topcoder.uml.actions.diagram.ChangeDiagramTitleAction;
import com.topcoder.uml.actions.diagram.elements.AddDiagramElementAction;
import com.topcoder.uml.actions.diagram.elements.CutDiagramElementAction;
import com.topcoder.umltool.deploy.actions.undoable.ChangeDocumentationAction;
import com.topcoder.umltool.deploy.actions.undoable.ChangeEntityNameAction;
import com.topcoder.uml.actions.general.ChangeEntityVisibilityAction;
import com.topcoder.uml.actions.general.ChangePositionAction;
import com.topcoder.uml.actions.general.ChangeRelationshipPathAction;
import com.topcoder.uml.actions.general.ChangeSizeAction;
import com.topcoder.uml.actions.general.ChangeStyleAction;
import com.topcoder.uml.actions.general.ChangeZOrderAction;
import com.topcoder.uml.actions.general.SetEntityStereotypesAction;
import com.topcoder.umltool.deploy.actions.undoable.UpdateDocumentationTagsAction;
import com.topcoder.uml.actions.model.classifiers.feature.AddAttributeAction;
import com.topcoder.uml.actions.model.classifiers.feature.AddOperationAction;
import com.topcoder.uml.actions.model.custom.SetTransitionGuardAction;
import com.topcoder.uml.actions.project.ExportToXMIFileAction;
import com.topcoder.uml.actions.project.LoadTCUMLFileAction;
import com.topcoder.uml.actions.project.LoadXMIFileAction;
import com.topcoder.uml.actions.project.SaveTCUMLFileAction;
import com.topcoder.uml.model.activitygraphs.ObjectFlowState;
import com.topcoder.uml.model.collaborations.collaborationinteractions.Collaboration;
import com.topcoder.uml.model.commonbehavior.instances.Object;
import com.topcoder.uml.model.commonbehavior.instances.Stimulus;
import com.topcoder.uml.model.commonbehavior.links.Link;
import com.topcoder.uml.model.core.Attribute;
import com.topcoder.uml.model.core.Classifier;
import com.topcoder.uml.model.core.Element;
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
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValueImpl;
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
import com.topcoder.uml.projectconfiguration.ProjectConfigurationException;
import com.topcoder.uml.projectconfiguration.ProjectConfigurationManager;
import com.topcoder.uml.stubclassgenerator.CodeGenerator;
import com.topcoder.uml.stubclassgenerator.GeneratorConfigurationException;
import com.topcoder.umltool.deploy.actions.AboutAction;
import com.topcoder.umltool.deploy.actions.ActionListenerManager;
import com.topcoder.umltool.deploy.actions.CopyElementAction;
import com.topcoder.umltool.deploy.actions.CopyRepresentationAction;
import com.topcoder.umltool.deploy.actions.CreateActivityDiagramAction;
import com.topcoder.umltool.deploy.actions.CreateClassDiagramAction;
import com.topcoder.umltool.deploy.actions.CreateSequenceDiagramAction;
import com.topcoder.umltool.deploy.actions.CreateUseCaseDiagramAction;
import com.topcoder.umltool.deploy.actions.CutElementAction;
import com.topcoder.umltool.deploy.actions.CutRepresentationAction;
import com.topcoder.umltool.deploy.actions.DeleteElementAction;
import com.topcoder.umltool.deploy.actions.DeleteRepresentationAction;
import com.topcoder.umltool.deploy.actions.DuplicateElementAction;
import com.topcoder.umltool.deploy.actions.ExitAction;
import com.topcoder.umltool.deploy.actions.ExportAllDiagramsAction;
import com.topcoder.umltool.deploy.actions.ExportCurrentDiagramAction;
import com.topcoder.umltool.deploy.actions.ExtensionFileFilter;
import com.topcoder.umltool.deploy.actions.GenerateCodeAction;
import com.topcoder.umltool.deploy.actions.ImportFromJarAction;
import com.topcoder.umltool.deploy.actions.NewProjectAction;
import com.topcoder.umltool.deploy.actions.OpenProjectAction;
import com.topcoder.umltool.deploy.actions.PasteAction;
import com.topcoder.umltool.deploy.actions.PrintAllDiagramsAction;
import com.topcoder.umltool.deploy.actions.PrintCurrentDiagramAction;
import com.topcoder.umltool.deploy.actions.RedoChangesAction;
import com.topcoder.umltool.deploy.actions.RenameElementAction;
import com.topcoder.umltool.deploy.actions.SaveAsProjectAction;
import com.topcoder.umltool.deploy.actions.SaveProjectAction;
import com.topcoder.umltool.deploy.actions.SelectAllElementsAction;
import com.topcoder.umltool.deploy.actions.SettingsAction;
import com.topcoder.umltool.deploy.actions.UndoChangesAction;
import com.topcoder.umltool.deploy.actions.ZoomInAction;
import com.topcoder.umltool.deploy.actions.ZoomOutAction;
import com.topcoder.umltool.deploy.actions.undoable.AddCollaborationAction;
import com.topcoder.umltool.deploy.actions.undoable.ChangeAbstractAction;
import com.topcoder.umltool.deploy.actions.undoable.ChangeActiveAction;
import com.topcoder.umltool.deploy.actions.undoable.ChangeAggregationAction;
import com.topcoder.umltool.deploy.actions.undoable.ChangeAsynchronousAction;
import com.topcoder.umltool.deploy.actions.undoable.ChangeChangeabilityAction;
import com.topcoder.umltool.deploy.actions.undoable.ChangeConcurrencyAction;
import com.topcoder.umltool.deploy.actions.undoable.ChangeElementVisibilityAction;
import com.topcoder.umltool.deploy.actions.undoable.ChangeFinalAction;
import com.topcoder.umltool.deploy.actions.undoable.ChangeInitialValueAction;
import com.topcoder.umltool.deploy.actions.undoable.ChangeKindAction;
import com.topcoder.umltool.deploy.actions.undoable.ChangeMultiplicityAction;
import com.topcoder.umltool.deploy.actions.undoable.ChangeNamespaceAction;
import com.topcoder.umltool.deploy.actions.undoable.ChangeNavigableAction;
import com.topcoder.umltool.deploy.actions.undoable.ChangeOrderingAction;
import com.topcoder.umltool.deploy.actions.undoable.ChangeParametersAction;
import com.topcoder.umltool.deploy.actions.undoable.ChangeRootAction;
import com.topcoder.umltool.deploy.actions.undoable.ChangeStaticAction;
import com.topcoder.umltool.deploy.actions.undoable.ChangeTransientAction;
import com.topcoder.umltool.deploy.actions.undoable.ChangeTypeAction;
import com.topcoder.umltool.deploy.actions.undoable.CompositeUndoableAction;
import com.topcoder.umltool.deploy.actions.undoable.RemoveDiagramElementAction;
import com.topcoder.umltool.deploy.actions.undoable.ReturningAction;
import com.topcoder.umltool.deploy.actions.undoable.UpdateDiagramAction;
import com.topcoder.umltool.deploy.actions.undoable.UpdateModelElementAction;
import com.topcoder.umltool.deploy.actions.undoable.UpdatePolylineAction;
import com.topcoder.umltool.deploy.handlers.AddDiagramElementHandler;
import com.topcoder.umltool.deploy.handlers.AddElementHandler;
import com.topcoder.umltool.deploy.handlers.AddFeatureHandler;
import com.topcoder.umltool.deploy.handlers.ChangeCommentTextHandler;
import com.topcoder.umltool.deploy.handlers.ChangeDocumentationHandler;
import com.topcoder.umltool.deploy.handlers.ChangeElementVisibilityHandler;
import com.topcoder.umltool.deploy.handlers.ChangeEntityNameHandler;
import com.topcoder.umltool.deploy.handlers.ChangeNamespaceHandler;
import com.topcoder.umltool.deploy.handlers.ChangeParameterHandler;
import com.topcoder.umltool.deploy.handlers.ChangePositionHandler;
import com.topcoder.umltool.deploy.handlers.ChangePropertyHandler;
import com.topcoder.umltool.deploy.handlers.ChangeRelationshipPathHandler;
import com.topcoder.umltool.deploy.handlers.ChangeSizeHandler;
import com.topcoder.umltool.deploy.handlers.ChangeStyleHandler;
import com.topcoder.umltool.deploy.handlers.ChangeZOrderHandler;
import com.topcoder.umltool.deploy.handlers.CreateDiagramHandler;
import com.topcoder.umltool.deploy.handlers.CutGraphElementHandler;
import com.topcoder.umltool.deploy.handlers.DiagramViewDragHandler;
import com.topcoder.umltool.deploy.handlers.DiagramViewerSelectionHandler;
import com.topcoder.umltool.deploy.handlers.DocumentTreeEventHandler;
import com.topcoder.umltool.deploy.handlers.DocumentationHandler;
import com.topcoder.umltool.deploy.handlers.ModelElementChangeHandler;
import com.topcoder.umltool.deploy.handlers.ModelElementSelectionHandler;
import com.topcoder.umltool.deploy.handlers.PopupMenuHandler;
import com.topcoder.umltool.deploy.handlers.RemoveDiagramElementHandler;
import com.topcoder.umltool.deploy.handlers.RemoveDiagramHandler;
import com.topcoder.umltool.deploy.handlers.ScrollHandler;
import com.topcoder.umltool.deploy.handlers.StyleHandler;
import com.topcoder.umltool.deploy.handlers.TabChangedHandler;
import com.topcoder.umltool.deploy.handlers.TagHandler;
import com.topcoder.umltool.deploy.handlers.TreeTabChangedHandler;
import com.topcoder.umltool.deploy.handlers.UpdatePolylineHandler;
import com.topcoder.umltool.deploy.handlers.ViewDropTargetHandler;
import com.topcoder.umltool.deploy.handlers.ZoomHandler;
import com.topcoder.umltool.deploy.menus.CreateDiagramMenu;
import com.topcoder.umltool.deploy.menus.EditMenu;
import com.topcoder.umltool.deploy.menus.FileMenu;
import com.topcoder.umltool.deploy.menus.GenerateMenu;
import com.topcoder.umltool.deploy.menus.HelpMenu;
import com.topcoder.umltool.deploy.menus.MainMenuBar;
import com.topcoder.umltool.deploy.menus.ViewMenu;
import com.topcoder.umltool.lnf.RoundCornerLineBorder;
import com.topcoder.umltool.lnf.UMLToolTabbedPanelUI;
import com.topcoder.util.actionmanager.ActionExecutionException;
import com.topcoder.util.actionmanager.ActionManager;
import com.topcoder.util.actionmanager.UndoableAction;
import com.topcoder.util.config.ConfigManager;
import com.topcoder.util.eventmanager.ActionEvent;
import com.topcoder.util.eventmanager.EventManager;
import com.topcoder.util.eventmanager.RedoChangesEvent;
import com.topcoder.util.eventmanager.UndoChangesEvent;

/**
 * <p>
 * Main frame of the uml tool.
 * </p>
 * <p>
 * Maintains main menu, tool bar, diagram view tab pane and several panels.
 * </p>
 * <p>
 * Maintains event manager, action manager.
 * </p>
 *
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class MainFrame extends JFrame {
    /**
     * <p>
     * Represents the title of main frame.
     * </p>
     */
    public static final String MAIN_FRAME_TITLE = "TopCoder UML Tool";

    /**
     * <p>
     * Represents the string to load icons for tool bar from config file.
     * </p>
     */
    public static final String TOOL_BAR_ICON_KEY_NAME = "ToolBar Icon key name";

    /**
     * <p>
     * The serial id.
     * <p>
     */
    private static final long serialVersionUID = -6558544540471190594L;

    /**
     * <p>
     * Icon file name for frame.
     * <p>
     */
    private static final String ICON_FILE_NAME = "/images/UmlTool_16.png";

    /**
     * <p>
     * Logo file name for frame.
     * <p>
     */
    private static final String LOGO_FILE_NAME = "/images/TopCoder_logo_med_transparent.png";

    /**
     * <p>
     * Open project type. Represents open a tcuml file.
     * <p>
     */
    public static final int OPEN_PROJECT_TCUML = 0;

    /**
     * <p>
     * Open project type. Represents open a XMI file generated by TC UML Tool.
     * <p>
     */
    public static final int OPEN_PROJECT_XMI_TC = 1;

    /**
     * <p>
     * Open project type. Represents open a zuml file.
     * <p>
     */
    public static final int OPEN_PROJECT_ZUML = 2;

    /**
     * <p>
     * Open project type. Represents open a XMI file generated by POSEIDON.
     * <p>
     */
    public static final int OPEN_PROJECT_XMI_POSEIDON = 3;

    /**
     * <p>
     * Main menu of the main frame.
     * </p>
     */
    private MainMenuBar menu;

    /**
     * <p>
     * Main panel of the main frame, diagram view tab pane and all panels are in it.
     * </p>
     */
    private JPanel mainPanel;

    /**
     * <p>
     * Tool bar of the main frame.
     * </p>
     */
    private JToolBar toolBar;

    /**
     * <p>
     * Represents the diagram viewer, initialized in constructor.
     * </p>
     */
    private DiagramViewer diagramViewerComponent;

    /**
     * <p>
     * Represents the tool panel, initialized in constructor.
     * </p>
     */
    private ToolPanel toolPanelComponent;

    /**
     * <p>
     * Represents the style panel, initialized in constructor.
     * </p>
     */
    private StylePanel stylePanelComponent;

    /**
     * <p>
     * Represents the document tree panel, initialized in constructor.
     * </p>
     */
    private DocumentTreeTabbedPaneImpl documentTreePanelComponent;

    /**
     * <p>
     * Represents the properties panel, initialized in constructor.
     * </p>
     */
    private PropertiesPanel propertiesPanelComponent;

    /**
     * <p>
     * Represents the documentation panel, initialized in constructor.
     * </p>
     */
    private DocumentationPanel documentationPanelComponent;

    /**
     * <p>
     * Represents the documentation panel's documentation editor.
     * </p>
     */
    private DocumentationEditor docEditor;

    /**
     * <p>
     * Represents the documentation editor's text area.
     * </p>
     */
    private JTextArea docTextArea;

    /**
     * <p>
     * Action manager to maintain undo/redo actions, initialized in constructor.
     * </p>
     */
    private ActionManager actionManager;

    /**
     * <p>
     * Event manager to maintain undo/redo events, initialized in constructor.
     * </p>
     */
    private EventManager eventManager;

    /**
     * <p>
     * Code generator to maintain code generation.
     * </p>
     */
    private CodeGenerator codeGenerator;

    /**
     * <p>
     * Represents the action and source map, initialized in constructor.
     * </p>
     * <p>
     * Maintains the source of actions in action manager.
     * </p>
     */
    private Map<com.topcoder.util.actionmanager.Action, java.lang.Object> actionSourceMap;

    /**
     * <p>
     * Represents the uml model manager, gets in constructor.
     * </p>
     */
    private UMLModelManager umlModelManager;

    /**
     * <p>
     * Represents the project configuration manager, gets in constructor.
     * </p>
     */
    private ProjectConfigurationManager projectConfigurationManager;

    /**
     * <p>
     * Represents the diagram counter for each diagram type, used to naming created diagrams.
     * </p>
     */
    private Vector<Integer> diagramCounter = new Vector<Integer>(4);

    /**
     * <p>
     * Represents clipboard map.
     * </p>
     */
    private Map<java.lang.Object, Clipboard> clipboardMap = new HashMap<java.lang.Object, Clipboard>();

    /**
     * <p>
     * Stores the setting file name.
     * </p>
     */
    private String settingFile;

    /**
     * <p>
     * Represents whether the diagrams need save.
     * </p>
     */
    private boolean isDirty;

    /**
     * <p>
     * Represents whether the diagrams was converted while loading.
     * </p>
     */
    public boolean isConverted;

    /**
     * <p>
     * Represents the type of new created association edge.
     * </p>
     */
    private java.lang.Class<? extends ActiveEdgeEnding> associationType;

    /**
     * <p>
     * Represents the popup menu of the tool.
     * </p>
     */
    private JPopupMenu popupMenu;

    /**
     * <p>
     * Represents the position of popup menu.
     * </p>
     */
    private Point popupPosition;

    /**
     * <p>
     * Represents the last open file.
     * </p>
     */
    private File lastOpenFile;

    /**
     * <p>
     * Represents the last image exporting path.
     * </p>
     */
    private String lastImageExportPath;

    /**
     * <p>
     * Represents whether the file needs automatic save.
     * </p>
     */
    private boolean autoSave;

    /**
     * <p>
     * Represents whether allow users to create multiple elements without return to the tool panel.
     * </p>
     */
    private boolean swiftCreation;

    /**
     * <p>
     * Represents the backup directory.
     * </p>
     */
    private String backupDirectory;

    private List<File> recentProjects;

    private boolean autoAddOperation;

    private JToolBar toolPanel;

    private JPanel toolBarPanel;

    /**
     * <p>
     * Represents divide location for right panel.
     * </p>
     */
    private int rightDivideLocation;

    private boolean autoGenerateMethods;

    /**
     * <p>
     * Creates an instance of main frame.
     * </p>
     *
     * @throws DeployConfigException
     *             if there's configuration error
     */
    public MainFrame() throws DeployConfigException {
        super();
        setTitle(MAIN_FRAME_TITLE + " - Unsaved");
        Image image = new ImageIcon(getClass().getResource(ICON_FILE_NAME)).getImage();
        this.setIconImage(image);
        init();
        ToolTipManager.sharedInstance().setInitialDelay(200);
    }

    /**
     * <p>
     * Gets the diagram viewer.
     * </p>
     */
    public DiagramViewer getDiagramViewer() {
        return diagramViewerComponent;
    }

    /**
     * <p>
     * Gets the tool panel.
     * </p>
     */
    public ToolPanel getToolPanel() {
        return toolPanelComponent;
    }

    /**
     * <p>
     * Gets the code generator.
     * </p>
     */
    public CodeGenerator getCodeGenerator() {
        return codeGenerator;
    }

    /**
     * <p>
     * Gets the style panel.
     * </p>
     */
    public StylePanel getStylePanel() {
        if (this.isExpand)
            return stylePanelComponent;
        return vStylePanelComponent;

    }

    /**
     * <p>
     * Gets the document tree.
     * </p>
     */
    public DocumentTreeTabbedPane getDocumentTree() {
        return documentTreePanelComponent;
    }

    /**
     * <p>
     * Gets the document editor.
     * </p>
     */
    public DocumentationEditor getDocEditor() {
        return docEditor;
    }

    /**
     * <p>
     * Gets the document editor's text area.
     * </p>
     */
    public JTextArea getDocTextArea() {
        return docTextArea;
    }

    /**
     * <p>
     * Gets the properties panel.
     * </p>
     */
    public PropertiesPanel getPropertiesPanel() {
        return propertiesPanelComponent;
    }

    /**
     * <p>
     * Gets the documentation panel.
     * </p>
     */
    public DocumentationPanel getDocumentationPanel() {
        return documentationPanelComponent;
    }

    /**
     * <p>
     * Gets the event manager.
     * </p>
     */
    public EventManager getEventManager() {
        return eventManager;
    }

    /**
     * <p>
     * Gets the project configuration manager.
     * </p>
     */
    public ProjectConfigurationManager getProjectConfigurationManager() {
        return projectConfigurationManager;
    }

    /**
     * <p>
     * Gets the uml model manager.
     * </p>
     */
    public UMLModelManager getUmlModelManager() {
        return umlModelManager;
    }

    /**
     * <p>
     * Gets the transferable list.
     * </p>
     */
    public Map<java.lang.Object, Clipboard> getClipboardMap() {
        return clipboardMap;
    }

    /**
     * <p>
     * Gets the setting file.
     * </p>
     *
     * @return the setting file
     */
    public String getSettingFile() {
        return settingFile;
    }

    /**
     * <p>
     * Sets the setting file.
     * </p>
     *
     * @param file
     *            the file
     */
    public void setSettingFile(String file) {
        settingFile = file;
    }

    /**
     * <p>
     * Gets the association type.
     * </p>
     *
     * @return the association type
     */
    public java.lang.Class<? extends ActiveEdgeEnding> getAssociationType() {
        return associationType;
    }

    /**
     * <p>
     * Sets the association type.
     * </p>
     *
     * @param associationType
     *            the association type
     */
    public void setAssociationType(java.lang.Class<? extends ActiveEdgeEnding> associationType) {
        this.associationType = associationType;
    }

    /**
     * <p>
     * Gets the popup menu.
     * </p>
     *
     * @return the popup menu
     */
    public JPopupMenu getPopupMenu() {
        return popupMenu;
    }

    /**
     * <p>
     * Sets the association type.
     * </p>
     *
     * @param popupPosition
     *            the positoin of popup menu
     */
    public void setPopupPosition(Point popupPosition) {
        this.popupPosition = popupPosition;
    }

    /**
     * <p>
     * Gets the position of popup menu.
     * </p>
     *
     * @return the position of popup menu
     */
    public Point getPopupPosition() {
        return popupPosition;
    }

    /**
     * <p>
     * Gets the swift creation property.
     * </p>
     *
     * @return whether allow users to create multiple elements without return to the tool panel
     */
    public boolean isSwiftCreation() {
        return swiftCreation;
    }

    /**
     * <p>
     * Initializes the projectConfigurationManager.
     * </p>
     */
    public void initPJManager() throws DeployConfigException {
        try {
            projectConfigurationManager =
                new ProjectConfigurationManager(umlModelManager, ProjectConfigurationManager.class.getName());

            umlModelManager.setProjectConfigurationManager(projectConfigurationManager);

            String language = umlModelManager.getProjectLanguage();
            if (language == null) {
                language = "Java";
                umlModelManager.setProjectLanguage("Java");
            }
            if (language != null && language.trim().length() != 0) {
                for (Namespace element : projectConfigurationManager.getStandardNamespaces(language)) {
                    if (element.getNamespace() == null) {
                        element.setNamespace(umlModelManager.getModel());
                        umlModelManager.getModel().addOwnedElement(element);
                    }
                }
            }
        } catch (ProjectConfigurationException e) {
            throw new DeployConfigException("ProjectConfigurationManager config error.", e);
        }
    }

    /**
     * <p>
     * Initializes the position, size of main frame.
     * </p>
     * <p>
     * Initializes action listeners for main menu and tool bar.
     * </p>
     * <p>
     * Initializes all panels, event manager.
     * </p>
     */
    private void init() throws DeployConfigException {
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new MainFrameWindowAdapter());
        this.addFocusListener(new MainFrameFocusAdapter());
        this.getContentPane().setLayout(new BorderLayout());

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        screenSize.height = screenSize.height - 25;
        this.setLocation(0, 0);
        this.setSize(screenSize);

        initActionListeners();

        umlModelManager = UMLModelManager.getInstance();
        initPJManager();

        // create a new tag definition with ProjectLanguage as type
        TagDefinition tagDefinition = new TagDefinitionImpl();
        tagDefinition.setTagType("ProjectLanguage");
        // create a tagged value with the project language as data and type as
        // tag definition.
        TaggedValue taggedValue = new TaggedValueImpl();
        taggedValue.setDataValue("Java");
        taggedValue.setType(tagDefinition);
        // add the tagged value to the model manager
        umlModelManager.getModel().addTaggedValue(taggedValue);

        try {
            codeGenerator = new CodeGenerator(false, true, "stub_class_generator");
        } catch (GeneratorConfigurationException e) {
            throw new DeployConfigException("CodeGenerator config error.", e);
        }

        settingFile = DeployHelper.getProperty("com.topcoder.umltool.deploy", "SettingFile");

        String lastOpenProject = DeployHelper.getProperty("com.topcoder.umltool.deploy", "LastOpenProject");
        if (lastOpenProject != null) {
            File startProjectFile = lastOpenProject.length() != 0 ? new File(lastOpenProject) : null;
            setLastOpenFile(startProjectFile);
        }
        String[] lastProjects = DeployHelper.getValues("com.topcoder.umltool.deploy", "LastOpenProjects");

        recentProjects = new ArrayList<File>();

        if (lastProjects != null) {

            for (String project : lastProjects) {
                if (project.length() != 0) {
                    recentProjects.add(new File(project));
                }
            }
        }
        setLastImageExportPath(DeployHelper.getProperty("com.topcoder.umltool.deploy", "LastImageExportPath"));

        String beAutoSave = DeployHelper.getProperty("com.topcoder.umltool.deploy", "AutoSave");
        if (beAutoSave.equals("false")) {
            autoSave = false;
        } else {
            autoSave = true;
        }

        String beSwiftCreation = DeployHelper.getProperty("com.topcoder.umltool.deploy", "SwiftCreation");
        String strAutoAddOperation =
            DeployHelper.getProperty("com.topcoder.umltool.deploy", "AddOperationAutomatic");
        if (beSwiftCreation.equals("false")) {
            swiftCreation = false;
        } else {
            swiftCreation = true;
        }
        if (strAutoAddOperation != null && strAutoAddOperation.equals("true")) {
            this.autoAddOperation = true;
        } else {
            this.autoAddOperation = false;
        }

        backupDirectory = DeployHelper.getProperty("com.topcoder.umltool.deploy", "BackupDirectory");

        String autoGenerateString = DeployHelper.getProperty("com.topcoder.umltool.deploy", "AutoGenerateMethods");
        autoGenerateMethods = autoGenerateString.equals("true") ? true : false;

        isDirty = false;

        menu = new MainMenuBar(this);
        this.setJMenuBar(menu);

        toolBar = new JToolBar("");
        toolBar.setFloatable(false);
        toolBarPanel = new JPanel();
        initToolBar();

        initMainPanel();

        initListeners();

        initEventManager();

        initPopupMenu();
        toolBarPanel.setLayout(new GridBagLayout());
        // toolBarPanel.add(toolBar, BorderLayout.NORTH);
        // toolBarPanel.add(toolPanel, BorderLayout.CENTER);
        toolBarPanel.add(toolBar, new GridBagConstraints(0, 0, 3, 1, 2, 2, GridBagConstraints.WEST,
            GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
        toolBarPanel.add(toolPanel, new GridBagConstraints(0, 2, 1, 1, 1, 2, GridBagConstraints.WEST,
            GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
        this.getContentPane().add(toolBarPanel, BorderLayout.NORTH);
        this.getContentPane().add(mainPanel, BorderLayout.CENTER);

        diagramCounter.add(DiagramType.CLASS.ordinal(), 1);
        diagramCounter.add(DiagramType.USECASE.ordinal(), 1);
        diagramCounter.add(DiagramType.SEQUENCE.ordinal(), 1);
        diagramCounter.add(DiagramType.ACTIVITY.ordinal(), 1);
    }

    /**
     * <p>
     * Initializes action listeners for main menu and tool bar.
     * </p>
     */
    private void initActionListeners() {
        ActionListenerManager manager = ActionListenerManager.getInstance();

        // Create the File menu actions.
        Action newProjectAction = new NewProjectAction(this);
        manager.setAction(FileMenu.NEW_PROJECT_MENU_ACTION, newProjectAction);

        Action openProjectAction = new OpenProjectAction(this);
        manager.setAction(FileMenu.OPEN_PROJECT_MENU_ACTION, openProjectAction);

        Action saveProjectAction = new SaveProjectAction(this);
        manager.setAction(FileMenu.SAVE_PROJECT_MENU_ACTION, saveProjectAction);

        Action saveAsProjectAction = new SaveAsProjectAction(this);
        manager.setAction(FileMenu.SAVE_AS_PROJECT_MENU_ACTION, saveAsProjectAction);

        Action importFromJar = new ImportFromJarAction(this);
        manager.setAction(FileMenu.IMPORT_FROM_JAR_MENU_ACTION, importFromJar);

        Action exportCurrentDiagramAction = new ExportCurrentDiagramAction(this);
        manager.setAction(FileMenu.EXPORT_CURRENT_DIAGRAM_MENU_ACTION, exportCurrentDiagramAction);

        Action exportAllDiagramsAction = new ExportAllDiagramsAction(this);
        manager.setAction(FileMenu.EXPORT_ALL_DIAGRAMS_MENU_ACTION, exportAllDiagramsAction);

        Action printCurrentDiagramAction = new PrintCurrentDiagramAction(this);
        manager.setAction(FileMenu.PRINT_CURRENT_DIAGRAM_MENU_ACTION, printCurrentDiagramAction);

        Action printAllDiagramsAction = new PrintAllDiagramsAction(this);
        manager.setAction(FileMenu.PRINT_ALL_DIAGRAMS_MENU_ACTION, printAllDiagramsAction);

        Action exitAction = new ExitAction(this);
        manager.setAction(FileMenu.EXIT_MENU_ACTION, exitAction);

        // Create the Edit menu Actions.
        Action cutElementAction = new CutElementAction(this);
        manager.setAction(EditMenu.CUT_ELEMENT_MENU_ACTION, cutElementAction);

        Action cutRepresentationAction = new CutRepresentationAction(this);
        manager.setAction(EditMenu.CUT_REPRESENTATION_MENU_ACTION, cutRepresentationAction);

        Action copyElementAction = new CopyElementAction(this);
        manager.setAction(EditMenu.COPY_ELEMENT_MENU_ACTION, copyElementAction);

        Action copyRepresentationAction = new CopyRepresentationAction(this);
        manager.setAction(EditMenu.COPY_REPRESENTATION_MENU_ACTION, copyRepresentationAction);

        Action pasteAction = new PasteAction(this);
        manager.setAction(EditMenu.PASTE_MENU_ACTION, pasteAction);

        Action selectAllElementsAction = new SelectAllElementsAction(this);
        manager.setAction(EditMenu.SELECT_ALL_ELEMENTS_MENU_ACTION, selectAllElementsAction);

        Action renameElementAction = new RenameElementAction(this);
        manager.setAction(EditMenu.RENAME_ELEMENT_ACTION, renameElementAction);

        Action deleteElementAction = new DeleteElementAction(this);
        manager.setAction(EditMenu.DELETE_ELEMENT_MENU_ACTION, deleteElementAction);

        Action deleteRepresentationAction = new DeleteRepresentationAction(this);
        manager.setAction(EditMenu.DELETE_REPRESENTATION_MENU_ACTION, deleteRepresentationAction);

        Action undoChangesAction = new UndoChangesAction(this);
        manager.setAction(EditMenu.UNDO_CHANGES_MENU_ACTION, undoChangesAction);

        Action redoChangesAction = new RedoChangesAction(this);
        manager.setAction(EditMenu.REDO_CHANGES_MENU_ACTION, redoChangesAction);

        Action settingsAction = new SettingsAction(this);
        manager.setAction(EditMenu.SETTINGS_MENU_ACTION, settingsAction);

        // Create the Create Diagram menu Actions.
        Action createClassDiagramAction = new CreateClassDiagramAction(this);
        manager.setAction(CreateDiagramMenu.CREATE_CLASS_DIAGRAM_ACTION, createClassDiagramAction);

        Action createUseCaseDiagramAction = new CreateUseCaseDiagramAction(this);
        manager.setAction(CreateDiagramMenu.CREATE_USE_CASE_DIAGRAM_ACTION, createUseCaseDiagramAction);

        Action createSequenceDiagramAction = new CreateSequenceDiagramAction(this);
        manager.setAction(CreateDiagramMenu.CREATE_SEQUENCE_DIAGRAM_ACTION, createSequenceDiagramAction);

        Action createActivityDiagramAction = new CreateActivityDiagramAction(this);
        manager.setAction(CreateDiagramMenu.CREATE_ACTIVITY_DIAGRAM_ACTION, createActivityDiagramAction);

        // Create the View menu Actions.
        Action zoomInAction = new ZoomInAction(this);
        manager.setAction(ViewMenu.ZOOM_IN_ACTION, zoomInAction);

        Action zoomOutAction = new ZoomOutAction(this);
        manager.setAction(ViewMenu.ZOOM_OUT_ACTION, zoomOutAction);

        // Create the Generate menu actions.
        Action generateCodeAction = new GenerateCodeAction(this);
        manager.setAction(GenerateMenu.GENERATE_CODE_MENU_ACTION, generateCodeAction);

        // Create the Help menu actions.
        Action aboutAction = new AboutAction(this);
        manager.setAction(HelpMenu.ABOUT_MENU_ACTION, aboutAction);
    }

    /**
     * <p>
     * Initializes the tool bar.
     * </p>
     */
    private void initToolBar() {
        ActionListenerManager manager = ActionListenerManager.getInstance();
        Action action;
        JButton button;
        Icon icon;

        action = manager.getAction(FileMenu.NEW_PROJECT_MENU_ACTION);
        icon = (Icon) action.getValue(MainFrame.TOOL_BAR_ICON_KEY_NAME);
        button = toolBar.add(action);
        button.setIcon(icon);
        button.setBorder(new EmptyBorder(1, 1, 1, 1));

        action = manager.getAction(FileMenu.OPEN_PROJECT_MENU_ACTION);
        icon = (Icon) action.getValue(MainFrame.TOOL_BAR_ICON_KEY_NAME);
        button = toolBar.add(action);
        button.setIcon(icon);
        button.setBorder(new EmptyBorder(1, 1, 1, 1));

        action = manager.getAction(FileMenu.SAVE_PROJECT_MENU_ACTION);
        icon = (Icon) action.getValue(MainFrame.TOOL_BAR_ICON_KEY_NAME);
        button = toolBar.add(action);
        button.setIcon(icon);
        button.setBorder(new EmptyBorder(1, 1, 1, 1));

        action = manager.getAction(FileMenu.PRINT_CURRENT_DIAGRAM_MENU_ACTION);
        icon = (Icon) action.getValue(MainFrame.TOOL_BAR_ICON_KEY_NAME);
        button = toolBar.add(action);
        button.setIcon(icon);
        button.setBorder(new EmptyBorder(1, 1, 1, 1));

        toolBar.addSeparator();

        action = manager.getAction(EditMenu.COPY_ELEMENT_MENU_ACTION);
        icon = (Icon) action.getValue(MainFrame.TOOL_BAR_ICON_KEY_NAME);
        button = toolBar.add(action);
        button.setIcon(icon);
        button.setBorder(new EmptyBorder(1, 1, 1, 1));

        action = manager.getAction(EditMenu.CUT_ELEMENT_MENU_ACTION);
        icon = (Icon) action.getValue(MainFrame.TOOL_BAR_ICON_KEY_NAME);
        button = toolBar.add(action);
        button.setIcon(icon);
        button.setBorder(new EmptyBorder(1, 1, 1, 1));

        action = manager.getAction(EditMenu.PASTE_MENU_ACTION);
        icon = (Icon) action.getValue(MainFrame.TOOL_BAR_ICON_KEY_NAME);
        button = toolBar.add(action);
        button.setIcon(icon);
        button.setBorder(new EmptyBorder(1, 1, 1, 1));

        toolBar.addSeparator();

        action = manager.getAction(EditMenu.UNDO_CHANGES_MENU_ACTION);
        icon = (Icon) action.getValue(MainFrame.TOOL_BAR_ICON_KEY_NAME);
        button = toolBar.add(action);
        button.setIcon(icon);
        button.setBorder(new EmptyBorder(1, 1, 1, 1));

        action = manager.getAction(EditMenu.REDO_CHANGES_MENU_ACTION);
        icon = (Icon) action.getValue(MainFrame.TOOL_BAR_ICON_KEY_NAME);
        button = toolBar.add(action);
        button.setIcon(icon);
        button.setBorder(new EmptyBorder(1, 1, 1, 1));

        toolBar.addSeparator();

        action = manager.getAction(CreateDiagramMenu.CREATE_CLASS_DIAGRAM_ACTION);
        icon = (Icon) action.getValue(MainFrame.TOOL_BAR_ICON_KEY_NAME);
        button = toolBar.add(action);
        button.setIcon(icon);
        button.setBorder(new EmptyBorder(1, 1, 1, 1));

        action = manager.getAction(CreateDiagramMenu.CREATE_USE_CASE_DIAGRAM_ACTION);
        icon = (Icon) action.getValue(MainFrame.TOOL_BAR_ICON_KEY_NAME);
        button = toolBar.add(action);
        button.setIcon(icon);
        button.setBorder(new EmptyBorder(1, 1, 1, 1));

        action = manager.getAction(CreateDiagramMenu.CREATE_SEQUENCE_DIAGRAM_ACTION);
        icon = (Icon) action.getValue(MainFrame.TOOL_BAR_ICON_KEY_NAME);
        button = toolBar.add(action);
        button.setIcon(icon);
        button.setBorder(new EmptyBorder(1, 1, 1, 1));

        action = manager.getAction(CreateDiagramMenu.CREATE_ACTIVITY_DIAGRAM_ACTION);
        icon = (Icon) action.getValue(MainFrame.TOOL_BAR_ICON_KEY_NAME);
        button = toolBar.add(action);
        button.setIcon(icon);
        button.setBorder(new EmptyBorder(1, 1, 1, 1));

        toolBar.addSeparator();

        action = manager.getAction(ViewMenu.ZOOM_IN_ACTION);
        icon = (Icon) action.getValue(MainFrame.TOOL_BAR_ICON_KEY_NAME);
        button = toolBar.add(action);
        button.setIcon(icon);
        button.setBorder(new EmptyBorder(1, 1, 1, 1));

        action = manager.getAction(ViewMenu.ZOOM_OUT_ACTION);
        icon = (Icon) action.getValue(MainFrame.TOOL_BAR_ICON_KEY_NAME);
        button = toolBar.add(action);
        button.setIcon(icon);
        button.setBorder(new EmptyBorder(1, 1, 1, 1));

    }

    /**
     * <p>
     * Represent side menu wide in main frame.
     * </p>
     */
    private final static int EXPANDED_SIDE_MENU_WIDE = 215;

    /**
     * <p>
     * Represent section wide in main frame.
     * </p>
     */
    private final static int EXPANDED_SECTION_WIDE = EXPANDED_SIDE_MENU_WIDE - 10;

    /**
     * <p>
     * Gets the Icon property from UIManager.
     * </p>
     *
     * @param key
     *            the property key
     * @return the Icon
     * @throws IllegalArgumentException
     *             if the property is missing
     */
    private Icon getIcon(java.lang.Object key) {
        Icon icon = null;
        icon = UIManager.getIcon(key);
        if (icon == null) {
            throw new IllegalArgumentException("The property [" + key + "] should be set.");
        }
        return icon;
    }

    /**
     * <p>
     * Initializes panels in main frame.
     * </p>
     */
    private void initMainPanel() throws DeployConfigException {
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        mainPanel.setFocusable(true);
        mainPanel.setBackground(UIManager.getColor("MainFrame.backgroundColor"));

        final JPanel logoPanel = new JPanel(new BorderLayout(), true);
        logoPanel.setBackground(UIManager.getColor("LogoPane.backgroundColor"));

        final JPanel leftPanel = new JPanel(new BorderLayout(), true);
        // final JSplitPane mainSplitPanel = new
        // JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        // final JSplitPane leftSplitPanel1 = new
        // JSplitPane(JSplitPane.VERTICAL_SPLIT);
        // final JSplitPane leftSplitPanel2 = new
        // JSplitPane(JSplitPane.VERTICAL_SPLIT);
        final JSplitPane rightSplitPanel1 = new JSplitPane(JSplitPane.VERTICAL_SPLIT);

        diagramViewerComponent = createDiagramViewer();

        java.net.URL logoURL = MainFrame.class.getResource(MainFrame.LOGO_FILE_NAME);
        ImageIcon logo = new ImageIcon(logoURL, "Built by TopCoder");
        JLabel logoLabel = new JLabel(logo);
        logoLabel.addMouseListener(new BrowserLauncher(this));
        logoPanel.add(logoLabel, BorderLayout.EAST);

        toolPanelComponent = new ToolPanel(this, diagramViewerComponent);
        toolPanelComponent.setBorder(new LineBorder(UIManager.getColor("SectionBorderColor"), 1));
        // JScrollPane toolsScrollPane = new JScrollPane(toolPanelComponent);
        TitlePanel toolsTitlePanel = new TitlePanel("          ", toolPanelComponent);
        final Section toolsSection = new Section(toolsTitlePanel);

        toolsSection.setTitle("Tools");

        stylePanelComponent = createStylePanel();
        stylePanelComponent.setBorder(new LineBorder(UIManager.getColor("SectionBorderColor"), 1));

        // JScrollPane styleScrollPane = new JScrollPane(stylePanelComponent);
        // styleScrollPane.setPreferredSize(new Dimension(120, 120));
        // styleScrollPane.setMinimumSize(new Dimension(0, 0));
        TitlePanel styleTitlePanel = new TitlePanel("       ", stylePanelComponent);
        final Section styleSection = new Section(styleTitlePanel);

        styleSection.setTitle("Style");

        documentTreePanelComponent = createDocumentTreePanel();

        ActionListenerManager manager = ActionListenerManager.getInstance();

        for (DocumentTreePanel documentTreePanel : documentTreePanelComponent.getPanels()) {
            DocumentTreeView view = documentTreePanel.getCurrentView();
            if (view instanceof DiagramCentricDocumentTreeView) {
                DiagramCentricDocumentTreeView diagramView = (DiagramCentricDocumentTreeView) view;
                diagramView.setAddActivityDiagramAction(manager
                    .getAction(CreateDiagramMenu.CREATE_ACTIVITY_DIAGRAM_ACTION));
                diagramView.setAddClassDiagramAction(manager
                    .getAction(CreateDiagramMenu.CREATE_CLASS_DIAGRAM_ACTION));
                diagramView.setAddSequenceDiagramAction(manager
                    .getAction(CreateDiagramMenu.CREATE_SEQUENCE_DIAGRAM_ACTION));
                diagramView.setAddUseCaseDiagramAction(manager
                    .getAction(CreateDiagramMenu.CREATE_USE_CASE_DIAGRAM_ACTION));
                diagramView.setDeleteDiagramAction(manager.getAction(EditMenu.DELETE_ELEMENT_MENU_ACTION));
                diagramView.setDuplicateDiagramAction(new DuplicateElementAction(this));
            }
        }

        documentTreePanelComponent.getTabbedPane().setUI(new UMLToolTabbedPanelUI());
        documentTreePanelComponent.getTabbedPane().setBackground(new Color(138, 138, 138));
        documentTreePanelComponent.getTabbedPane().setBorder(
            new LineBorder(UIManager.getColor("SectionBorderColor"), 1));
        TitlePanel documentTreeTitlePanel = new TitlePanel("    ", documentTreePanelComponent.getTabbedPane());

        final Section documentTreeSection = new Section(documentTreeTitlePanel);
        documentTreeSection.setTitle("Document Tree");
        documentTreeSection.setSize(EXPANDED_SECTION_WIDE, 320);

        propertiesPanelComponent = createPropertiesPanel();
        JScrollPane propertiesScrollPane = new JScrollPane(propertiesPanelComponent);
        propertiesScrollPane.setPreferredSize(new Dimension(100, 100));
        propertiesScrollPane.setMinimumSize(new Dimension(0, 0));

        documentationPanelComponent = createDocumentationPanel();
        JScrollPane documentationScrollPane = new JScrollPane(documentationPanelComponent);
        documentationScrollPane.setPreferredSize(new Dimension(100, 100));
        documentationScrollPane.setMinimumSize(new Dimension(0, 0));

        DockContainer dockContainer = new SectionDockContainer(leftPanel);
        final Dock tooldock = new DefaultDock(toolsSection);
        // tooldock.setFloatable(false);
        // tooldock.setDragEnabled(false);
        dockContainer.dock(tooldock);

        final Dock styledock = new DefaultDock(styleSection);
        dockContainer.dock(styledock);
        // styledock.setFloatable(false);
        // styledock.setDragEnabled(false);

        final Dock documentTreedock = new DefaultDock(documentTreeSection, true);
        dockContainer.dock(documentTreedock);
        class SectionExpandContractAdapter implements SectionExpandContractListener {
            final private Dimension originSize;

            public SectionExpandContractAdapter(Dimension originSize) {
                this.originSize = originSize;
            }

            public void contracted(Section section) {
                section.setSize(EXPANDED_SECTION_WIDE, 30);
                section.getDockableComponent().getParent().validate();
                int height =
                    calcDocumentTreeHeight(leftPanel.getHeight(), styleSection, styledock, toolsSection, tooldock) - 10;
                if (!(documentTreedock.getCurrentDockContainer() instanceof FloatContainer)) {
                    documentTreeSection.setSize(EXPANDED_SECTION_WIDE, height);
                }
                leftPanel.revalidate();

            }

            public void expanded(Section section) {
                section.setSize(originSize);
                section.getDockableComponent().getParent().validate();
                int height =
                    calcDocumentTreeHeight(leftPanel.getHeight(), styleSection, styledock, toolsSection, tooldock) - 10;
                if (!(documentTreedock.getCurrentDockContainer() instanceof FloatContainer)) {
                    documentTreeSection.setSize(EXPANDED_SECTION_WIDE, height);
                }

                leftPanel.revalidate();

            }

        }

        styleSection.addExpandContractListener(new SectionExpandContractAdapter(styleSection.getPreferredSize()));
        documentTreeSection.addExpandContractListener(new SectionExpandContractAdapter(documentTreeSection
            .getPreferredSize()));
        toolsSection.addExpandContractListener(new SectionExpandContractAdapter(toolsSection.getPreferredSize()));

        dockContainer.addDockListener(new DockListener() {
            public void docked(DockEvent event) {
                if (!(documentTreedock.getCurrentDockContainer() instanceof FloatContainer)) {
                    int height =
                        event.getDock() == styledock ? styleSection.getHeight() : toolsSection.getHeight();
                    height = documentTreeSection.getHeight() - height;
                    documentTreeSection.setSize(EXPANDED_SECTION_WIDE, height);

                }

                leftPanel.invalidate();
            }

            public void undocked(DockEvent event) {
                if (!(documentTreedock.getCurrentDockContainer() instanceof FloatContainer)) {
                    int height =
                        event.getDock() == styledock ? styleSection.getHeight() : toolsSection.getHeight();
                    height += documentTreeSection.getHeight();
                    documentTreeSection.setSize(EXPANDED_SECTION_WIDE, height);

                }
                leftPanel.revalidate();
            }

        });

        JPanel bottomPane = new JPanel();
        bottomPane.setLayout(new BorderLayout());
        Icon minIcon = getIcon("ButtomPanel.minIcon");
        final JButton minBtn = new JButton(minIcon);
        // toolkit.add(minBtn);

        Icon restoreIcon = getIcon("ButtomPanel.restoreIcon");
        final JButton restoreBtn = new JButton(restoreIcon);
        // toolkit.add(restoreBtn);

        Icon fullIcon = getIcon("ButtomPanel.fullIcon");
        final JButton fullBtn = new JButton(fullIcon);
        // toolkit.add(fullBtn);

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Properties", propertiesScrollPane);
        tabbedPane.addTab("Documentation", documentationScrollPane);
        // tabbedPane.setUI((UMLToolTabbedPanelUI)UIManager.get("UMLTabbedPanelUI"));
        tabbedPane.setUI(new UMLToolTabbedPanelUI());
        /*
         * BottomHeader header = new BottomHeader(new JButton[] { minBtn, restoreBtn, fullBtn }, tabbedPane);
         * bottomPane.add(header, BorderLayout.NORTH);
         */
        bottomPane.setBorder(new RoundCornerLineBorder(UIManager.getColor("BottomPane.borderColor"), UIManager
            .getColor("BottomPane.backgroundColor"), 1));

        bottomPane.add(tabbedPane, BorderLayout.CENTER);

        // ///////////////////set side menu panel////////////////
        String title = "Side Menu";
        Icon expandIcon = getIcon("SideMenu.expandIcon");
        Icon collapseIcon = getIcon("SideMenu.collapseIcon");
        Icon pinIcon = getIcon("SideMenu.pinIcon");
        final SideMenuPanel sideMenuPanel = new SideMenuPanel(title, leftPanel, expandIcon, collapseIcon, pinIcon);
        sideMenuPanel.setAbsoluteWidth(EXPANDED_SIDE_MENU_WIDE);

        sideMenuPanel.setExpanded(false);
        sideMenuPanel.getExpandedComponent().setBorder(
            new RoundCornerLineBorder(UIManager.getColor("SideMenu.borderColor"), UIManager
                .getColor("SideMenu.backgroundColor"), 1));
        sideMenuPanel.getCollapsedComponent().setBorder(
            new RoundCornerLineBorder(UIManager.getColor("SideMenu.borderColor"), UIManager
                .getColor("SideMenu.backgroundColor"), 1));
        ((JScrollPane) leftPanel.getComponent(0)).setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        leftPanel.addComponentListener(new ComponentAdapter() {

            public void componentResized(ComponentEvent e) {

                int height =
                    calcDocumentTreeHeight(leftPanel.getHeight(), styleSection, styledock, toolsSection, tooldock)
                        + toolPanel.getHeight() - 70;
                if (!((JScrollPane) leftPanel.getComponent(0)).getHorizontalScrollBar().isVisible()) {
                    height += 15;
                }
                if (height < 100) {
                    height = 100;

                    ((JScrollPane) leftPanel.getComponent(0))
                        .setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
                } else {

                    ((JScrollPane) leftPanel.getComponent(0))
                        .setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
                }

                if (!(documentTreedock.getCurrentDockContainer() instanceof FloatContainer)) {
                    documentTreeSection.setSize(EXPANDED_SECTION_WIDE, height);
                    leftPanel.revalidate();
                }
            }
        });

        JComponent collapsedPanel = sideMenuPanel.getCollapsedComponent();
        collapsedPanel.setBackground(UIManager.getColor("SideMenu.collapsedColor"));
        if (collapsedPanel instanceof DefaultCollapsedSideMenuPanel) {
            ((DefaultCollapsedSideMenuPanel) collapsedPanel).getUpperExpandButton().setBorder(
                new EmptyBorder(1, 1, 1, 1));
            ((DefaultCollapsedSideMenuPanel) collapsedPanel).getLowerExpandButton().setBorder(
                new EmptyBorder(1, 1, 1, 1));
        }
        JComponent expandPanel = sideMenuPanel.getExpandedComponent();
        expandPanel.setBackground(UIManager.getColor("SideMenu.expandedColor"));
        if (expandPanel instanceof DefaultExpandedSideMenuPanel) {
            ((DefaultExpandedSideMenuPanel) expandPanel).getPinButton().setBorder(new EmptyBorder(1, 1, 1, 1));
            ((DefaultExpandedSideMenuPanel) expandPanel).getCollapseButton()
                .setBorder(new EmptyBorder(1, 1, 1, 1));
        }
        sideMenuPanel.getSideMenuModel().addPropertyChangeListener(new PropertyChangeListener() {
            public void propertyChange(PropertyChangeEvent event) {
                if (event.getPropertyName().equals(SideMenuModel.EXPANDED)) {
                    Boolean b = (Boolean) event.getNewValue();

                    if (!(tooldock.getCurrentDockContainer() instanceof FloatContainer)
                        && !(styledock.getCurrentDockContainer() instanceof FloatContainer)) {
                        if (b.booleanValue()) {
                            setToolPanelLayout(true);
                            isExpand = true;
                            toolPanel.setVisible(false);
                            if (toolPanel.getParent() == toolBarPanel)
                                toolBarPanel.remove(toolPanel);
                            else {
                                Component comp = toolPanel;
                                while (comp != null && !(comp instanceof java.awt.Window)) {
                                    comp = comp.getParent();
                                }
                                if (comp != null)
                                    ((java.awt.Window) comp).dispose();
                            }

                        } else {
                            toolPanel = new JToolBar();
                            toolPanel.setFloatable(false);
                            // toolPanel.setLayout(new
                            // FlowLayout(FlowLayout.LEFT));
                            setToolPanelLayout(false);
                            isExpand = false;
                            toolBarPanel.add(toolPanel, new GridBagConstraints(0, 2, 1, 1, 1, 2,
                                GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0,
                                0));
                            // toolBar.setSize(toolBar.getWidth(),
                            // toolBar.getHeight()*2);
                        }
                    }
                }
                mainPanel.validate();

                int height =
                    calcDocumentTreeHeight(leftPanel.getHeight(), styleSection, styledock, toolsSection, tooldock)
                        + toolPanel.getHeight() - 70;
                if (!((JScrollPane) leftPanel.getComponent(0)).getHorizontalScrollBar().isVisible()) {
                    height += 15;
                }
                if (height < 100) {
                    height = 100;

                    ((JScrollPane) leftPanel.getComponent(0))
                        .setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
                } else {

                    ((JScrollPane) leftPanel.getComponent(0))
                        .setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
                }

                if (!(documentTreedock.getCurrentDockContainer() instanceof FloatContainer)) {
                    documentTreeSection.setSize(EXPANDED_SECTION_WIDE, height);
                    leftPanel.revalidate();
                }
                DeployHelper.notifySelectionChanged(MainFrame.this, diagramViewerComponent);
            }

        });

        ((ClosableTabbedPane) diagramViewerComponent.getTabbedPane())
            .addClosableTabbedPaneEventHandler(new ClosableTabbedPaneEventHandler() {

                public void tabAdded(ClosableTabbedPaneEvent events) {
                    DeployHelper.notifySelectionChanged(MainFrame.this, diagramViewerComponent);

                }

                public void tabsClosed(ClosableTabbedPaneEvent[] events) {

                    ZoomPanel zoomPanel = (ZoomPanel) events[0].getSource();
                    JViewport viewport = (JViewport) zoomPanel.getComponent(0);
                    ZoomPane zoomPane = (ZoomPane) viewport.getComponent(0);
                    DiagramView view = (DiagramView) zoomPane.getComponent(0);

                    if (view != null) {
                        DeployHelper.notifySelectionChanged(MainFrame.this, view);
                        DiagramType type = DeployHelper.getDiagramType(view.getDiagram());
                        view.getDiagram().setVisible(false);
                        if (type != null) {
                            if (!isExpand())
                                setToolPanelLayout(true);
                            toolPanelComponent.SetToolPanelType(type);
                            if (!isExpand())
                                setToolPanelLayout(false);
                        }
                    }

                }

                public boolean[] tabsClosing(ClosableTabbedPaneEvent[] events) {
                    if (events == null)
                        return null;
                    boolean[] ret = new boolean[events.length];
                    Arrays.fill(ret, true);
                    return ret;
                }

            });
        String strLocation = DeployHelper.getProperty("com.topcoder.umltool.deploy", "rightDivideLocation");

        if (strLocation != null) {
            try {
                rightDivideLocation = Integer.parseInt(strLocation);
            } catch (NumberFormatException e) {
                rightDivideLocation = 500;
            }
        } else {
            rightDivideLocation = 500;
        }

        // documentTreedock.setFloatable(false);
        // leftPanel.setSize(EXPANDED_SECTION_WIDE,getHeight()-120);
        toolsSection.setSize(EXPANDED_SECTION_WIDE, 250);
        styleSection.setSize(EXPANDED_SECTION_WIDE, 190);

        rightSplitPanel1.setOneTouchExpandable(true);
        rightSplitPanel1.setDividerSize(10);
        rightSplitPanel1.setDividerLocation(rightDivideLocation);
        rightSplitPanel1.setResizeWeight(0);
        rightSplitPanel1.setTopComponent(diagramViewerComponent);
        rightSplitPanel1.setContinuousLayout(true);
        rightSplitPanel1.setBottomComponent(bottomPane);// tabbedPane);
        rightSplitPanel1.setBorder(new RoundCornerLineBorder(UIManager.getColor("SplitPanel.borderColor"),
            UIManager.getColor("SplitPanel.backgroundColor"), 0));

        rightSplitPanel1.addPropertyChangeListener(JSplitPane.DIVIDER_LOCATION_PROPERTY,
            new PropertyChangeListener() {

                public void propertyChange(PropertyChangeEvent evt) {
                    rightDivideLocation = ((Integer) evt.getNewValue()).intValue();
                }

            });
        minBtn.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                int temp = rightDivideLocation;
                rightSplitPanel1.setDividerLocation(rightSplitPanel1.getHeight() - 20 - minBtn.getHeight());
                rightDivideLocation = temp;
            }

        });
        restoreBtn.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                rightSplitPanel1.setDividerLocation(rightDivideLocation);
            }

        });
        fullBtn.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                int temp = rightDivideLocation;
                rightSplitPanel1.setDividerLocation(2);
                rightDivideLocation = temp;
            }

        });

        toolPanel = new JToolBar();
        toolPanel.setFloatable(false);
        try {
            vStylePanelComponent = new StylePanel(StylePanel.class.getName(), true);
            vStylePanelComponent.setPreferredSize(new Dimension(500, 50));

        } catch (Exception e) {
            throw new DeployConfigException("StylePanel config error.", e);
        }
        /*
         * try { int fontSize = Integer.parseInt(DeployHelper.getProperty( "com.topcoder.umltool.deploy",
         * "FontSize")); //vStylePanelComponent.setFont(stylePanelComponent.getFont() // .deriveFont((float)
         * fontSize)); } catch (Exception e2) { } / toolPanellist = getAllToggleButton(toolPanelComponent); for
         * (int i = 0; i < toolPanellist.size(); i++) { JToggleButton button = toolPanellist.get(i);
         * toolPanel.add(button); } toolPanel.add(vStylePanelComponent);
         */
        setToolPanelLayout(false);
        mainPanel.add(rightSplitPanel1, new GridBagConstraints(1, 0, 1, 1, 2, 2, GridBagConstraints.CENTER,
            GridBagConstraints.BOTH, new Insets(2, 0, 1, 0), 0, 0));

        mainPanel.add(sideMenuPanel, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.WEST,
            GridBagConstraints.BOTH, new Insets(2, 5, 1, 5), 0, 0));
        mainPanel.add(logoPanel, new GridBagConstraints(0, 1, 2, 1, 0, 0, GridBagConstraints.WEST,
            GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    }

    private int calcDockHeight(Section section, Dock dock) {
        if (dock.getCurrentDockContainer() instanceof FloatContainer)
            return 0;
        return section.getHeight();
    }

    private int calcDocumentTreeHeight(int all, Section styleSection, Dock styleDock, Section toolsSection,
        Dock toolsDock) {
        return all - calcDockHeight(styleSection, styleDock) - calcDockHeight(toolsSection, toolsDock) - 10;
    }

    public void setSize(int w, int h) {
        super.setSize(w, h);
        if (!isExpand && toolPanellist != null && toolPanellist.size() > 0) {
            DeployHelper.notifySelectionChanged(MainFrame.this, diagramViewerComponent);
        }
    }

    private boolean isExpand = false;

    private StylePanel vStylePanelComponent;

    private List<JToggleButton> toolPanellist;

    private Map<JToggleButton, Container> buttonMap = new HashMap<JToggleButton, Container>();

    boolean isExpand() {
        return isExpand;
    }

    void setToolPanelLayout(boolean expanded) {
        if (expanded) {
            for (int i = 0; i < toolPanellist.size(); i++) {
                JToggleButton button = toolPanellist.get(i);
                Container component = buttonMap.get(button);

                component.add(button);
            }
            toolPanellist.clear();
            toolPanel.remove(vStylePanelComponent);
        } else {
            toolPanellist = getAllToggleButton(toolPanelComponent);
            for (int i = 0; i < toolPanellist.size(); i++) {
                JToggleButton button = toolPanellist.get(i);
                if (i == 0 && button.getToolTipText().indexOf("Actor") >= 0 && this.getWidth() < 1240) {
                    continue;
                }

                toolPanel.add(button);
                toolPanel.add(vStylePanelComponent, new GridBagConstraints(1, 1, 2, 3, 20, 2,
                    GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));

            }
            // toolPanel.add(vStylePanelComponent);
            // toolBarPanel.add(vStylePanelComponent,BorderLayout.EAST);
        }
    }

    private List<JToggleButton> getAllToggleButton(Container container) {

        Component[] components = container.getComponents();
        List<JToggleButton> ret = new ArrayList<JToggleButton>();
        for (Component component : components) {
            if (component instanceof JToggleButton) {

                JToggleButton originalButton = (JToggleButton) component;

                buttonMap.put(originalButton, originalButton.getParent());
                // System.err.println(originalButton);
                // Button.addActionListener(originalButton.getActionListeners()[0]);
                ret.add(originalButton);
            } else if (component instanceof Container) {
                ret.addAll(getAllToggleButton((Container) component));
            }
        }
        return ret;
    }

    /**
     * <p>
     * Creates the style panel.
     * </p>
     */
    private StylePanel createStylePanel() throws DeployConfigException {
        StylePanel stylePanelComponent = null;
        try {
            stylePanelComponent = new StylePanel(StylePanel.class.getName());
        } catch (Exception e) {
            throw new DeployConfigException("StylePanel config error.", e);
        }
        stylePanelComponent.setPreferredSize(new Dimension(200, 180));
        try {
            int fontSize = Integer.parseInt(DeployHelper.getProperty("com.topcoder.umltool.deploy", "FontSize"));
            stylePanelComponent.setFont(stylePanelComponent.getFont().deriveFont((float) fontSize));
        } catch (Exception e2) {
        }
        return stylePanelComponent;
    }

    /**
     * <p>
     * Creates the document tree panel.
     * </p>
     */
    private DocumentTreeTabbedPaneImpl createDocumentTreePanel() throws DeployConfigException {
        DocumentTreeTabbedPaneImpl documentTreePanelComponent = null;
        try {
            UMLModelManager manager = UMLModelManager.getInstance();
            manager.setProjectConfigurationManager(new ProjectConfigurationManager(manager));
            documentTreePanelComponent =
                new DocumentTreeTabbedPaneImpl(manager, "com.topcoder.gui.trees.document.impl");
        } catch (Exception e) {
            throw new DeployConfigException("DocumentTreePanel config error.", e);
        }
        // documentTreePanelComponent.getTabbedPane().setPreferredSize(new Dimension(400, 400));
        return documentTreePanelComponent;
    }

    /**
     * <p>
     * Creates the properties panel.
     * </p>
     */
    private PropertiesPanel createPropertiesPanel() throws DeployConfigException {
        PropertiesPanel propertiesPanelComponent = null;
        try {
            propertiesPanelComponent = new PropertiesPanel(UMLModelManager.getInstance());
        } catch (Exception e) {
            throw new DeployConfigException("PropertiesPanel config error.", e);
        }
        propertiesPanelComponent.setPreferredSize(new Dimension(120, 120));
        return propertiesPanelComponent;
    }

    /**
     * <p>
     * Creates the documentation panel.
     * </p>
     */
    private DocumentationPanel createDocumentationPanel() throws DeployConfigException {
        DocumentationPanel documentationPanelComponent = null;
        try {
            documentationPanelComponent = new DocumentationPanel(DocumentationPanel.class.getName());
        } catch (Exception e) {
            throw new DeployConfigException("DocumentationPanel config error.", e);
        }
        documentationPanelComponent.setPreferredSize(new Dimension(120, 120));
        documentationPanelComponent.setTarget(new OperationImpl());
        docEditor =
            (DocumentationEditor) ((JSplitPane) documentationPanelComponent.getComponent(0)).getComponent(0);
        docTextArea = (JTextArea) ((JScrollPane) docEditor.getComponent(0)).getViewport().getView();

        return documentationPanelComponent;
    }

    /**
     * <p>
     * Creates the diagram viewer.
     * </p>
     */
    public DiagramViewer createDiagramViewer() throws DeployConfigException {
        DiagramViewer diagramViewerComponent = null;
        try {
            diagramViewerComponent = new DiagramViewer();

            // Register the listeners
            diagramViewerComponent.addAddNewElementListener(new AddElementHandler(this));
            diagramViewerComponent.addScrollListener(new ScrollHandler());
            diagramViewerComponent.addZoomListener(new ZoomHandler());
            diagramViewerComponent.addSelectionListener(new DiagramViewerSelectionHandler(this));

            diagramViewerComponent.getTabbedPane().addFocusListener(new TabChangedHandler(this));
            diagramViewerComponent.getTabbedPane().addChangeListener(new TabChangedHandler(this));

            diagramViewerComponent.setDiagramNameChangedListener(new DiagramNameChangedListener() {

                public void nameChanged(Diagram diagram, String newName) {
                    handleActionEvent(new ChangeDiagramTitleAction(diagram, newName), this, "change diagram title");
                }
            });
            // Show the background grid
            diagramViewerComponent.setBackgroundGridVisible(true);

            // Register the renderer
            diagramViewerComponent.setGridRenderer(new DeployGridRenderer(18));
        } catch (Exception e) {
            throw new DeployConfigException("DiagramViewer config error.", e);
        }
        diagramViewerComponent.setPreferredSize(new Dimension(500, 500));
        return diagramViewerComponent;
    }

    /**
     * <p>
     * Creates a diagram with the given diagram type.
     * </p>
     *
     * @param diagramType
     *            type of diagram to create
     */
    public void createDiagram(DiagramType diagramType) {

        UndoableAction action = null;
        int count = diagramCounter.get(diagramType.ordinal());
        if (diagramType == DiagramType.CLASS) {
            action = new com.topcoder.uml.actions.diagram.CreateClassDiagramAction(null, "Class Diagram " + count);
        } else if (diagramType == DiagramType.USECASE) {
            action =
                new com.topcoder.uml.actions.diagram.CreateUseCaseDiagramAction(null, "Use Case Diagram " + count);
        } else if (diagramType == DiagramType.SEQUENCE) {
            // if is sequence diagram type, create collaboration if in need.
            java.lang.Object object = findNodeInTree(getDocumentTree(), Collaboration.class);
            if (object == null) {
                CompositeUndoableAction compositeAction =
                    new CompositeUndoableAction("Create collaboration and sequence diagram");
                AddCollaborationAction addCollaborationAction = new AddCollaborationAction(this);
                action =
                    new com.topcoder.uml.actions.diagram.CreateSequenceDiagramAction(addCollaborationAction
                        .getCollaboration(), "Sequence Diagram " + count);
                compositeAction.put(addCollaborationAction, this);
                compositeAction.put(action, this);
                action = compositeAction;
            } else {
                action =
                    new com.topcoder.uml.actions.diagram.CreateSequenceDiagramAction((Element) object,
                        "Sequence Diagram " + count);
            }
        } else if (diagramType == DiagramType.ACTIVITY) {
            action =
                new com.topcoder.uml.actions.diagram.CreateActivityDiagramAction(null, "Activity Diagram " + count);
        }
        diagramCounter.set(diagramType.ordinal(), ++count);
        DeployHelper.checkNotNull(action, "createDiagramAction");
        handleActionEvent(action, this, "create diagram");
    }

    /**
     * <p>
     * Finds a node in document tree with the given class type.
     * </p>
     *
     * @param tree
     *            document tree to find node
     * @param type
     *            the class type to find
     * @return the node with the given type if found, null if no match.
     */
    private java.lang.Object findNodeInTree(DocumentTreeTabbedPane tree, java.lang.Class<?> type) {
        java.lang.Object object = null;
        DocumentTreeNode[] nodes = getDocumentTree().getSelectedTreeNodes();
        for (DocumentTreeNode node : nodes) {
            object = node.getNodeObject();
            if (type.isAssignableFrom(object.getClass())) {
                return object;
            }
        }
        return null;
    }

    /**
     * <p>
     * Initializes listeners for panels in main frame.
     * </p>
     */
    private void initListeners() {
        StyleHandler styleHandler = new StyleHandler(this);
        stylePanelComponent.addStyleListener(styleHandler);
        vStylePanelComponent.addStyleListener(styleHandler);
        DocumentTreeEventHandler documentTreeEventHandler = new DocumentTreeEventHandler(this);
        documentTreePanelComponent.addDocumentTreeEventListener(documentTreeEventHandler);
        TreeTabChangedHandler treeTabChangedHandler = new TreeTabChangedHandler(this);
        documentTreePanelComponent.getTabbedPane().addChangeListener(treeTabChangedHandler);
        ModelElementSelectionHandler modelElementSelectionHander = new ModelElementSelectionHandler(this);
        propertiesPanelComponent.addModelElementSelectionListener(modelElementSelectionHander);
        ModelElementChangeHandler modelElementChangeHandler = new ModelElementChangeHandler(this);
        propertiesPanelComponent.addModelElementChangeListener(modelElementChangeHandler);
        propertiesPanelComponent.addDiagramChangeListener(new DiagramChangeHandler(this));
        DocumentationHandler documentationHandler = new DocumentationHandler(this);
        documentationPanelComponent.addDocumentationListener(documentationHandler);
        TagHandler tagHandler = new TagHandler(this);
        documentationPanelComponent.addTagListener(tagHandler);
    }

    /**
     * <p>
     * Adds action event listeners for event manager.
     * </p>
     */
    private void initEventManager() {
        actionSourceMap = new HashMap<com.topcoder.util.actionmanager.Action, java.lang.Object>();

        actionManager = new ActionManager();

        eventManager = new EventManager(actionManager);
        eventManager.addActionEventListener(new ChangePositionHandler(this), ChangePositionAction.class);
        eventManager.addActionEventListener(new ChangeSizeHandler(this), ChangeSizeAction.class);
        eventManager.addActionEventListener(new ChangeStyleHandler(this), ChangeStyleAction.class);
        eventManager.addActionEventListener(new ChangeEntityNameHandler(this), ChangeEntityNameAction.class);
        eventManager.addActionEventListener(new ChangeEntityNameHandler(this), ChangeDiagramTitleAction.class);
        eventManager.addActionEventListener(new ChangeNamespaceHandler(this), ChangeNamespaceAction.class);
        eventManager.addActionEventListener(new ChangePropertyHandler(this), ChangeTypeAction.class);
        eventManager.addActionEventListener(new ChangePropertyHandler(this), ChangeEntityVisibilityAction.class);
        eventManager.addActionEventListener(new ChangePropertyHandler(this), ChangeChangeabilityAction.class);
        eventManager.addActionEventListener(new ChangePropertyHandler(this), ChangeInitialValueAction.class);
        eventManager.addActionEventListener(new ChangePropertyHandler(this), SetTransitionGuardAction.class);
        eventManager.addActionEventListener(new ChangePropertyHandler(this), ChangeAggregationAction.class);
        eventManager.addActionEventListener(new ChangePropertyHandler(this), ChangeMultiplicityAction.class);
        eventManager.addActionEventListener(new ChangePropertyHandler(this), ChangeKindAction.class);
        eventManager.addActionEventListener(new ChangePropertyHandler(this), ChangeConcurrencyAction.class);
        eventManager.addActionEventListener(new ChangePropertyHandler(this), ChangeOrderingAction.class);
        eventManager.addActionEventListener(new ChangeParameterHandler(this), ChangeParametersAction.class);
        eventManager.addActionEventListener(new ChangePropertyHandler(this), SetEntityStereotypesAction.class);
        eventManager.addActionEventListener(new ChangePropertyHandler(this), ChangeAbstractAction.class);
        eventManager.addActionEventListener(new ChangePropertyHandler(this), ChangeFinalAction.class);
        eventManager.addActionEventListener(new ChangePropertyHandler(this), ChangeRootAction.class);
        eventManager.addActionEventListener(new ChangePropertyHandler(this), ChangeStaticAction.class);
        eventManager.addActionEventListener(new ChangePropertyHandler(this), ChangeActiveAction.class);
        eventManager.addActionEventListener(new ChangePropertyHandler(this), ChangeTransientAction.class);
        eventManager.addActionEventListener(new ChangePropertyHandler(this), ChangeNavigableAction.class);
        eventManager.addActionEventListener(new ChangePropertyHandler(this), ChangeAsynchronousAction.class);
        eventManager.addActionEventListener(new ChangeDocumentationHandler(this), ChangeDocumentationAction.class);
        eventManager.addActionEventListener(new ChangeDocumentationHandler(this),
            UpdateDocumentationTagsAction.class);

        eventManager.addActionEventListener(new CreateDiagramHandler(),
            com.topcoder.uml.actions.diagram.CreateClassDiagramAction.class);
        eventManager.addActionEventListener(new CreateDiagramHandler(),
            com.topcoder.uml.actions.diagram.CreateUseCaseDiagramAction.class);
        eventManager.addActionEventListener(new CreateDiagramHandler(),
            com.topcoder.uml.actions.diagram.CreateSequenceDiagramAction.class);
        eventManager.addActionEventListener(new CreateDiagramHandler(),
            com.topcoder.uml.actions.diagram.CreateActivityDiagramAction.class);
        eventManager.addActionEventListener(new RemoveDiagramHandler(this),
            com.topcoder.uml.actions.diagram.RemoveClassDiagramAction.class);
        eventManager.addActionEventListener(new RemoveDiagramHandler(this),
            com.topcoder.uml.actions.diagram.RemoveUseCaseDiagramAction.class);
        eventManager.addActionEventListener(new RemoveDiagramHandler(this),
            com.topcoder.uml.actions.diagram.RemoveSequenceDiagramAction.class);
        eventManager.addActionEventListener(new RemoveDiagramHandler(this),
            com.topcoder.uml.actions.diagram.RemoveActivityDiagramAction.class);

        eventManager.addActionEventListener(new ChangeRelationshipPathHandler(this),
            ChangeRelationshipPathAction.class);
        eventManager.addActionEventListener(new AddDiagramElementHandler(this), AddDiagramElementAction.class);
        eventManager.addActionEventListener(new RemoveDiagramElementHandler(this),
            RemoveDiagramElementAction.class);
        eventManager.addActionEventListener(new CutGraphElementHandler(this), CutDiagramElementAction.class);

        eventManager.addActionEventListener(new AddFeatureHandler(this), AddAttributeAction.class);
        eventManager.addActionEventListener(new AddFeatureHandler(this), AddOperationAction.class);

        eventManager.addActionEventListener(new ChangeCommentTextHandler(this), ChangeCommentTextAction.class);
        eventManager.addActionEventListener(new UpdatePolylineHandler(this), UpdatePolylineAction.class);

        eventManager.addActionEventListener(new ChangeElementVisibilityHandler(this),
            ChangeElementVisibilityAction.class);

        eventManager.addActionEventListener(new ChangeZOrderHandler(), ChangeZOrderAction.class);
    }

    /**
     * <p>
     * Handles the action event. Source of the action is saved in actionSourceMap. Pass the event to event manager.
     * </p>
     *
     * @param action
     *            the action to be handled
     * @param source
     *            source used for action event
     * @param actionMessage
     *            message string used for handle exception
     */
    public void handleActionEvent(com.topcoder.util.actionmanager.Action action, java.lang.Object source,
        String actionMessage) {
        if (action instanceof CompositeUndoableAction) {
            CompositeUndoableAction compositeAction = (CompositeUndoableAction) action;
            if (compositeAction.isEmpty()) {
                return;
            } else {
                compositeAction.setEventManager(eventManager);
            }

            List<UndoableAction> addedActions = new ArrayList<UndoableAction>();
            for (UndoableAction undoableAction : compositeAction.getActionList()) {
                if (undoableAction instanceof ReturningAction) {
                    ReturningAction returningAction = (ReturningAction) undoableAction;
                    if (returningAction.getActions() != null) {
                        addedActions.addAll(returningAction.getActions());
                    }
                }
            }
            for (UndoableAction undoableAction : addedActions) {
                compositeAction.put(undoableAction, this);
            }

            for (UndoableAction undoableAction : compositeAction.getActionList()) {
                if (undoableAction instanceof UpdateModelElementAction) {
                    UpdateModelElementAction updateModelElementAction = (UpdateModelElementAction) undoableAction;
                    updateModelElementAction.setMainFrame(this);
                }
            }
        } else if (action instanceof ReturningAction) {
            CompositeUndoableAction composite = new CompositeUndoableAction(this, "Composite actions");
            // UML-558: Documentation panel is not updating
            composite.put((UndoableAction) action, source);
            composite.setEventManager(eventManager);
            ReturningAction returningAction = (ReturningAction) action;
            List<UpdateModelElementAction> actions = returningAction.getActions();
            if (actions != null) {
                for (UpdateModelElementAction updateModelElementAction : actions) {
                    updateModelElementAction.setMainFrame(this);
                    composite.put(updateModelElementAction, this);
                }
            }
            action = composite;
        }

        isDirty = true;

        ActionEvent actionEvent = new ActionEvent(action, source);
        try {
            eventManager.handleActionEvent(actionEvent);
            actionSourceMap.put(action, source);
        } catch (ActionExecutionException e) {
            DeployHelper.handleException(this, e, "Execute action failed: " + e.getMessage());
        }
    }

    /**
     * <p>
     * Gets the last undo change event.
     * </p>
     *
     * @return the last undo change event.
     */
    public UndoChangesEvent getLastUndoChangeEvent() {
        List<UndoableAction> undoableActionList = actionManager.getUndoableActionsToBeUndone();
        List<UndoableAction> redoableActionList = actionManager.getUndoableActionsToBeRedone();

        Set<com.topcoder.util.actionmanager.Action> actionSet =
            new HashSet<com.topcoder.util.actionmanager.Action>(actionSourceMap.keySet());

        for (com.topcoder.util.actionmanager.Action action : actionSet) {
            if (!undoableActionList.contains(action) && !redoableActionList.contains(action)) {
                actionSourceMap.remove(action);
            }
        }

        if (!undoableActionList.isEmpty()) {
            UndoableAction action = undoableActionList.get(0);
            UndoChangesEvent undoActionEvent = new UndoChangesEvent(action, actionSourceMap.get(action));
            return undoActionEvent;
        } else {
            return null;
        }
    }

    /**
     * <p>
     * Gets the last redo change event.
     * </p>
     *
     * @return the last redo change event.
     */
    public RedoChangesEvent getLastRedoChangeEvent() {
        List<UndoableAction> undoableActionList = actionManager.getUndoableActionsToBeUndone();
        List<UndoableAction> redoableActionList = actionManager.getUndoableActionsToBeRedone();

        Set<com.topcoder.util.actionmanager.Action> actionSet =
            new HashSet<com.topcoder.util.actionmanager.Action>(actionSourceMap.keySet());

        for (com.topcoder.util.actionmanager.Action action : actionSet) {
            if (!undoableActionList.contains(action) && !redoableActionList.contains(action)) {
                actionSourceMap.remove(action);
            }
        }

        if (!redoableActionList.isEmpty()) {
            UndoableAction action = redoableActionList.get(0);
            RedoChangesEvent redoActionEvent = new RedoChangesEvent(action, actionSourceMap.get(action));
            return redoActionEvent;
        } else {
            return null;
        }
    }

    /**
     * <p>
     * Initializes the popup menu.
     * </p>
     */
    private void initPopupMenu() {
        // FIX: BUGR-87
        popupMenu = new SpecialJPopupMenu();

        popupMenu.addPopupMenuListener(new PopupMenuHandler(this));
    }

    /**
     * <p>
     * Updates the diagram view tab pane.
     * </p>
     */
    public void updateDiagramView() {
        getDiagramViewer().getTabbedPane().repaint();
    }

    /**
     * <p>
     * Sets the project dirty flag.
     * </p>
     *
     * @param isDirty
     *            the flag to set
     */
    public void setIsDirty(boolean isDirty) {
        this.isDirty = isDirty;
    }

    /**
     * <p>
     * Checks whether save is needed.
     * </p>
     *
     * @return true if confirm is done, false if closed.
     */
    public boolean querySave() {
        if (isDirty) {
            int result =
                JOptionPane.showConfirmDialog(this, "Do you want to save the changes you made to this project?");
            if (result == JOptionPane.YES_OPTION) {
                return saveProject();
            } else if (result == JOptionPane.NO_OPTION) {
                return true;
            } else {
                return false;
            }
        } else {
            return true;
        }
    }

    /**
     * <p>
     * Quits the application or retrns false if quit should not occur due to unsaved work.
     * </p>
     *
     * @return false if application shouldn't quit due to unsaved work
     */
    public boolean quit() {
        boolean doQuit = querySave();
        if (doQuit) {
            dispose();
            storeStartSettings();
            System.exit(0);
        }
        return doQuit;
    }

    /**
     * <p>
     * Stores start settings for uml tool.
     * </p>
     */
    public void storeStartSettings() {
        try {
            ConfigManager.getInstance().createTemporaryProperties("com.topcoder.umltool.deploy");

            ConfigManager.getInstance().setProperty("com.topcoder.umltool.deploy", "Width",
                new Integer(getWidth()).toString());
            ConfigManager.getInstance().setProperty("com.topcoder.umltool.deploy", "Height",
                new Integer(getHeight()).toString());

            File projectFile = getLastOpenFile();
            String projectFilePath = projectFile != null ? projectFile.getCanonicalPath() : "";
            // UML-557: '&' in recent files open list in Settings_config.xml

            ConfigManager.getInstance().setProperty("com.topcoder.umltool.deploy", "LastOpenProject",
                prepareXmlEscapeChars(projectFilePath));
            ConfigManager.getInstance().setProperty("com.topcoder.umltool.deploy", "LastImageExportPath",
                prepareXmlEscapeChars(getLastImageExportPath()));

            // store last projects
            String[] lastProjects = new String[recentProjects.size()];
            for (int i = 0; i < recentProjects.size(); i++) {
                lastProjects[i] = prepareXmlEscapeChars(recentProjects.get(i).getPath());
            }
            ConfigManager.getInstance().setProperty("com.topcoder.umltool.deploy", "LastOpenProjects",
                lastProjects);
            ConfigManager.getInstance().commit("com.topcoder.umltool.deploy", "");
        } catch (Exception e) {
            DeployHelper.logException(e);
        }
    }

    /**
     * Replaces all predefined entities in the String with escape characters.
     *
     * @param string
     *            the given string
     * @return the string with predefined entities replaced by appropriate escape characters.
     */
    private static String prepareXmlEscapeChars(String string) {
        return string.replace('\\', '/').replace("&", "&amp;").replace("%", "&#37;").replace(">", "&gt;")
            .replace("<", "&lt;");
    }

    /**
     * <p>
     * Loads a project file.
     * </p>
     *
     * @param filePath
     *            the path to the file to load
     */
    public void loadProject(String filePath) {
        File file = new File(filePath);
        String extension = DeployHelper.getExtension(file);
        int openType = MainFrame.OPEN_PROJECT_TCUML;
        if ("tcuml".equals(extension)) {
            openType = MainFrame.OPEN_PROJECT_TCUML;
        } else if ("zuml".equals(extension)) {
            openType = MainFrame.OPEN_PROJECT_ZUML;
        } else if ("xmi".equals(extension)) {
            openType = MainFrame.OPEN_PROJECT_XMI_TC;
        }
        this.loadProject(file, openType);
    }

    /**
     * <p>
     * Loads file.
     * </p>
     *
     * @param file
     *            the file to load
     * @param openType
     *            the loading type
     */
    public void loadProject(File file, int openType) {
        // clean the DiagramViewer
        DeployHelper.clearSelected(getDiagramViewer());
        getDocumentTree().updateTree();
        getDiagramViewer().clear();

        // clear model
        umlModelManager.getModel().clearTaggedValues();
        ProjectUtility.getInstance().setProjectFile(file);
        setTitle(MainFrame.MAIN_FRAME_TITLE + " - " + file.getName());

        isConverted = false;
        try {
            com.topcoder.util.actionmanager.Action action = null;
            if (openType == OPEN_PROJECT_TCUML) {
                action = new LoadTCUMLFileAction(file, getUmlModelManager(), getProjectConfigurationManager());
                action.execute();
                // Some converted tcuml file has create stereotype without base
                // class
                DeployHelper.recoverCreateStereotype(umlModelManager.getModel());
            } else if (openType == OPEN_PROJECT_ZUML) {
                isConverted = true;
                ProjectUtility.getInstance().setProjectFile(null);
                DeployHelper.loadPoseidonFile(file, getUmlModelManager(), getProjectConfigurationManager(), false);
            } else if (openType == OPEN_PROJECT_XMI_TC) {
                action = new LoadXMIFileAction(file, getUmlModelManager(), getProjectConfigurationManager());
                action.execute();
                // Some converted tcuml file has create stereotype without base
                // class
                DeployHelper.recoverCreateStereotype(umlModelManager.getModel());
            } else if (openType == OPEN_PROJECT_XMI_POSEIDON) {
                isConverted = true;
                ProjectUtility.getInstance().setProjectFile(null);
                DeployHelper.loadPoseidonFile(file, getUmlModelManager(), getProjectConfigurationManager(), true);
            }

            // Add the opened file to the recent projects list and refresh the
            // menu
            if (!recentProjects.contains(file)) {
                recentProjects.add(0, file);
            } else {
                // If the file already exists in the list, move it to the top
                recentProjects.remove(file);
                recentProjects.add(0, file);
            }
            // Limit the recent projects count to 10
            if (recentProjects.size() > 10)
                recentProjects = recentProjects.subList(0, 10);

            menu.refreshMenus(this);

            this.validate();
            this.repaint();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error while loading diagrams: " + e.getMessage() + ".",
                "Loading error", JOptionPane.ERROR_MESSAGE);
            DeployHelper.logException(e);
        } finally {
            // update UI
            recoverDiagramViews(isConverted);
        }

        // Set the last open file
        setLastOpenFile(file);
        addLastOpenFile(file);

        getDocumentTree().updateTree();
        repaint();

        initEventManager();
    }

    /**
     * <p>
     * Recovers all loaded diagrams.
     * </p>
     *
     * @param isConverted
     *            whether the diagram is converted from a Poseidon type file
     */
    public void recoverDiagramViews(boolean isConverted) {
        UMLModelManager modelManager = UMLModelManager.getInstance();
        DiagramViewer viewer = getDiagramViewer();
        for (Diagram diagram : modelManager.getDiagrams()) {
            // diagram.setPosition(DeployHelper.createPoint(20, 20));

            DiagramView view;
            if (diagram.isVisible()) {
                view = viewer.openDiagramView(diagram);
            } else {
                view = viewer.createDiagramView(diagram);
            }

            recoverDiagramView(diagram, view, isConverted);
        }

        // clear isDirty flag
        isDirty = false;
    }

    /**
     * <p>
     * Recovers diagram view for given diagram. It creates elements contained in diagram and adds them to given
     * diagram view instance.
     * </p>
     *
     * @param diagram
     *            the diagram to recover view
     * @param view
     *            the view instance to add elements
     * @param isConverted
     *            whether the diagram is converted from a Poseidon type file
     */
    public void recoverDiagramView(Diagram diagram, DiagramView view, boolean isConverted) {
        DropTarget dropTarget = new DropTarget(view, new ViewDropTargetHandler(this));
        view.setDropTarget(dropTarget);

        DiagramViewDragHandler viewDragHandler = new DiagramViewDragHandler();
        view.addMouseListener(viewDragHandler);
        view.addMouseMotionListener(viewDragHandler);

        view.setBackground(Color.WHITE);
        view.setOpaque(true);
        // recover nodes first
        for (DiagramElement diagramElement : diagram.getContaineds()) {

            if (diagramElement instanceof GraphNode || diagramElement instanceof Polyline) {
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

        if (DeployHelper.getTypeInfo(diagram)
            .equals(DeployHelper.DIAGRAM_TYPEINFO[DiagramType.SEQUENCE.ordinal()])) {
            DeployHelper.layoutSequenceEdges(this, view);
        }

        if (diagram.isVisible()) {
            DeployHelper.updateZoomPane(view);
        }

        // Set the popup menu for view
        view.setComponentPopupMenu(this.getPopupMenu());

        UpdateDiagramAction action = new UpdateDiagramAction(view, "recover");
        this.handleActionEvent(action, view, action.getPresentationName());
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
    private Node createNode(DiagramElement element, DiagramView view, boolean isConverted) {
        Node node = null;
        Diagram diagram = view.getDiagram();
        if (element instanceof Polyline) {
            node = DeployHelper.createPolylineNode(this, (Polyline) element);
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
                    node = DeployHelper.createUsecaseNode(this, graphNode);
                } else if (modelElement instanceof Actor) {
                    node = DeployHelper.createActorNode(this, graphNode);
                } else if (modelElement instanceof Subsystem) {
                    node = DeployHelper.createSubsystemNode(this, graphNode);
                    createSubNodes((NodeContainer) node, view, isConverted);
                } else if (modelElement instanceof SimpleState) {
                    if (modelElement instanceof com.topcoder.uml.model.activitygraphs.ActionState) {
                        node = DeployHelper.createActionStateNode(this, graphNode);
                    } else if (modelElement instanceof ObjectFlowState) {
                        node = DeployHelper.createObjectFlowNode(this, graphNode);
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
                            node = DeployHelper.createSendSignalActionNode(this, graphNode);
                        } else {
                            node = DeployHelper.createAcceptEventActionNode(this, graphNode);
                        }

                    }
                } else if (modelElement instanceof Pseudostate) {
                    Pseudostate state = (Pseudostate) modelElement;
                    if (state.getKind() == PseudostateKind.CHOICE) {
                        node = DeployHelper.createDecisionNode(this, graphNode);
                    } else if (state.getKind() == PseudostateKind.FORK) {
                        node = DeployHelper.createForkNode(this, graphNode);
                    } else if (state.getKind() == PseudostateKind.INITIAL) {
                        node = DeployHelper.createInitialNode(this, graphNode);
                    } else if (state.getKind() == PseudostateKind.JOIN) {
                        node = DeployHelper.createJoinNode(this, graphNode);
                    } else if (state.getKind() == PseudostateKind.JUNCTION) {
                        node = DeployHelper.createMergeNode(this, graphNode);
                    }
                } else if (modelElement instanceof FinalState) {
                    FinalState state = (FinalState) modelElement;

                    // Supports files saved by version 0.1.10, which don't have
                    // tag type saved for some activity nodes.
                    // Adds a tag type.
                    fixTagType(state, "FlowFinalNode", "FinalNodeType");

                    if (DeployHelper.isFlowFinal(state)) {
                        node = DeployHelper.createFlowFinalNode(this, graphNode);
                    } else {
                        node = DeployHelper.createFinalNode(this, graphNode);
                    }
                } else if (modelElement instanceof Object) {
                    node = DeployHelper.createObjectNode(this, graphNode);
                    DeployHelper.getLifeLine((ObjectNode) node).setSize((int) diagram.getSize().getWidth(),
                        (int) diagram.getSize().getHeight());
                } else if (modelElement instanceof Comment) {
                    node = DeployHelper.createCommentNode(this, graphNode);
                } else if (modelElement instanceof Package) {
                    node = DeployHelper.createPackageNode(this, graphNode);
                    createSubNodes((NodeContainer) node, view, isConverted);
                } else if (modelElement instanceof Interface) {
                    node = DeployHelper.createInterfaceNode(this, graphNode);

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
                            for (Parameter parameter : operation.getParameters()) {
                                if (parameter.getType() == null) {
                                    parameter.setType(DeployHelper.getClassifier("int"));
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
                            if (type != null && !type.containsTypedFeature(attribute)) {
                                type.addTypedFeature(attribute);
                            }
                        }
                    }

                    boolean isException = DeployHelper.isExceptionClass((Classifier) modelElement);
                    if (isException) {
                        node = DeployHelper.createExceptionNode(this, graphNode);
                    } else {
                        node = DeployHelper.createClassNode(this, graphNode);
                    }

                    // Support files saved by version 0.1.10, which don't have
                    // tag type saved for each parameter.
                    fixTagType((Classifier) modelElement);
                }

            } else if (semanticModel instanceof SimpleSemanticModelElement) {
                if (DeployHelper.getTypeInfo(graphNode).equals("FreeText")) {
                    node = DeployHelper.createFreeTextNode(this, graphNode);
                }
            }
        }
        if (node != null) {
            view.add(node);
            node.setComponentPopupMenu(getPopupMenu());
            if (node instanceof NodeContainer) {
                NodeContainer nodeContainer = (NodeContainer) node;
                Set<Node> set = nodeContainer.getNodes(DeployHelper.BODY_COMPARTMENT);
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
    private void createSubNodes(NodeContainer nodeContainer, DiagramView view, boolean isConverted) {
        GraphNode graphNode = nodeContainer.getGraphNode();
        GraphNode bodyCompartment = (GraphNode) graphNode.getContaineds().get(1);

        // Support files saved by versions before 1.1.6
        moveElementsToBodyCompartment(graphNode, bodyCompartment);

        for (DiagramElement diagramElement : bodyCompartment.getContaineds()) {
            if (diagramElement instanceof GraphNode) {
                Node subNode = createNode((GraphNode) diagramElement, view, isConverted);
                if (subNode != null) {
                    nodeContainer.addNode(DeployHelper.BODY_COMPARTMENT, subNode);
                }
            }
        }
    }

    /**
     * <p>
     * Moves contained sub elements to body compartment for given graph node of node container.
     * </p>
     *
     * @param graphNode
     *            graph node of node container
     * @param bodyCompartment
     *            graph node for the body compartment
     */
    private void moveElementsToBodyCompartment(GraphNode graphNode, GraphNode bodyCompartment) {
        int size = graphNode.getContaineds().size();
        if (size > 2) {
            bodyCompartment.setPosition(DeployHelper.createPoint(0, 0));
            for (int i = 2; i < size; i++) {
                DiagramElement diagramElement = graphNode.getContaineds().get(i);
                DeployHelper.addContained(bodyCompartment, diagramElement);
            }
            for (int i = 2; i < size; i++) {
                graphNode.removeContained(2);
            }
        }
    }

    /**
     * <p>
     * Supports files saved by version 0.1.10, which don't have tag type saved for some activity nodes. Adds a tag
     * type.
     * </p>
     *
     * @param element
     *            the element of activity node to fix tag type
     * @param dataValue
     *            the data value of tagged value whose type is to be fixed
     * @param tagType
     *            the new tag type name
     */
    private void fixTagType(ModelElement element, String dataValue, String tagType) {
        for (TaggedValue taggedValue : element.getTaggedValues()) {
            if (dataValue.equals(taggedValue.getDataValue()) && taggedValue.getType() == null) {
                taggedValue.setType(DeployHelper.getTagDefinition(tagType));
                break;
            }
        }
    }

    /**
     * <p>
     * Supports files saved by version 0.1.10, which don't have tag type saved for each parameter. Adds a tag type.
     * </p>
     *
     * @param classifier
     *            classifier whose operation parameters should be fixed
     */
    private void fixTagType(Classifier classifier) {
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
    private void fixTaggedValues(ModelElement modelElement) {
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
    private void appendTagDefinition(TaggedValue taggedValue) {
        // Find the tagged from model
        TagDefinition documentTagDef = null;
        Model model = umlModelManager.getModel();
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
     * Supports files saved by early version which don't have element's namespace saved. Restores its namespace.
     * </p>
     *
     * @param graphNode
     *            graph node containing model element whose namespace should be set
     * @param modelElement
     *            model element whose namespace should be set
     */
    private void fixNamespace(GraphNode graphNode, ModelElement modelElement) {
        GraphNode container = (GraphNode) graphNode.getContainer();

        if (modelElement instanceof Object) {
            // Set namespace to collaboration
            if (modelElement.getNamespace() == null || !(modelElement.getNamespace() instanceof Collaboration)) {
                Diagram diagram = (Diagram) container;
                Uml1SemanticModelBridge bridge = (Uml1SemanticModelBridge) diagram.getOwner();
                Collaboration collaboration = (Collaboration) bridge.getElement();
                modelElement.setNamespace(collaboration);
            }
        } else {
            Namespace namespace = UMLModelManager.getInstance().getModel();

            if (modelElement.getNamespace() == null
                || (modelElement.getNamespace() != namespace && DeployHelper.containsNamespace(modelElement
                    .getNamespace(), namespace))) {
                Namespace owner = findOwnerNamespace(namespace, modelElement);
                if (owner != null || modelElement instanceof Feature) {
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
     * Changes namespace for given model element. Remove the element from old namespace, and then add it to new
     * namespace.
     * </p>
     *
     * @param modelElement
     *            the model element which namespace is to be changed
     */
    private void fixOwnership(ModelElement modelElement) {
        // To fix the namespace completely, make sure the namespace contains the
        // model element
        if (!modelElement.getNamespace().containsOwnedElement(modelElement)) {
            // Find old namespace which contains the model element
            Namespace oldNamespace = findOwnerNamespace(UMLModelManager.getInstance().getModel(), modelElement);
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
    private Namespace findOwnerNamespace(Namespace namespace, ModelElement modelElement) {
        for (ModelElement ownedElement : namespace.getOwnedElements()) {
            if (ownedElement == modelElement) {
                return namespace;
            }
            if (ownedElement instanceof Namespace) {
                Namespace owner = findOwnerNamespace((Namespace) ownedElement, modelElement);
                if (owner != null) {
                    return owner;
                }
            }
        }
        return null;
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
    private Edge createEdge(GraphEdge graphEdge, DiagramView view, boolean isConverted) {
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
                edge = DeployHelper.createIncludeEdge(this, view, graphEdge);
            } else if (modelElement instanceof Extend) {
                edge = DeployHelper.createExtendEdge(this, view, graphEdge);
            } else if (modelElement instanceof Association) {
                // Support files saved by early versions which don't save the
                // graph nodes for association ends. Create
                // the graph nodes for association ends. Fix since 0.1.13.
                if (graphEdge.getContaineds().size() == 2) {
                    Association association = (Association) modelElement;
                    GraphNode graphNode =
                        DeployHelper.createAssociationEndGraphNode(association.getConnections().get(0));
                    graphEdge.addContained(0, graphNode);
                    graphNode.setContainer(graphEdge);

                    graphNode = DeployHelper.createAssociationEndGraphNode(association.getConnections().get(1));
                    graphEdge.addContained(1, graphNode);
                    graphNode.setContainer(graphEdge);
                }
                edge = DeployHelper.createAssociationEdge(this, view, graphEdge);
            } else if (modelElement instanceof Abstraction) {
                edge = DeployHelper.createAbstractionEdge(this, view, graphEdge);
            } else if (modelElement instanceof Dependency) {
                edge = DeployHelper.createDependencyEdge(this, view, graphEdge);
                Dependency dependency = (Dependency) modelElement;
                dependency.addClient(DeployHelper.getElement(graphEdge.getAnchors().get(0).getGraphElement()));
                dependency.addSupplier(DeployHelper.getElement(graphEdge.getAnchors().get(1).getGraphElement()));
                for (ModelElement client : dependency.getClients()) {
                    client.addClientDependency(dependency);
                }
                for (ModelElement client : dependency.getSuppliers()) {
                    client.addSupplierDependency(dependency);
                }
            } else if (modelElement instanceof Generalization) {
                edge = DeployHelper.createGeneralizationEdge(this, view, graphEdge);
            } else if (modelElement instanceof com.topcoder.uml.model.statemachines.Transition) {
                edge = DeployHelper.createTransitionEdge(this, view, graphEdge);
            } else if (modelElement instanceof Link) {
                edge = DeployHelper.createSequenceEdge(this, view, graphEdge);
            }
            // Support files saved by early versions which don't have element's
            // namespace saved. Restore their namespaces.
            if (modelElement instanceof Link) {
                Link link = (Link) modelElement;
                Uml1SemanticModelBridge bridge = (Uml1SemanticModelBridge) view.getDiagram().getOwner();
                Collaboration collaboration = (Collaboration) bridge.getElement();
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
                edge = DeployHelper.createCommentLinkEdge(this, view, graphEdge);
            }
        }
        if (edge != null) {
            // connect edge with nodes
            GraphNode start = (GraphNode) graphEdge.getAnchors().get(0).getGraphElement();
            GraphNode end = (GraphNode) graphEdge.getAnchors().get(1).getGraphElement();
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
     * Saves project. If project file is specified, save to it. Otherwise let user choose a project file.
     * </p>
     *
     * @return true if saved, otherwise false
     */
    public boolean saveProject() {
        File projectFile = ProjectUtility.getInstance().getProjectFile();
        if (projectFile != null) {
            saveDataInFile(projectFile, null);
            return true;
        }

        return saveAs();
    }

    /**
     * <p>
     * Saves project as.
     * </p>
     *
     * @return true if saved, otherwise false
     */
    public boolean saveAs() {
        JFileChooser f = new JFileChooser();
        f.setSelectedFile(getLastOpenFile());
        f.removeChoosableFileFilter(f.getFileFilter());
        f.addChoosableFileFilter(new ExtensionFileFilter("XMI Files", "xmi"));
        f.addChoosableFileFilter(new ExtensionFileFilter("TC UML Files", "tcuml"));
        f.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int returnVal = f.showSaveDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            // gets extension in current filter
            String filterExtension = DeployHelper.getExtension(f);

            // gets path and name of the selected file
            File selectedFile = f.getSelectedFile();
            String fileName = selectedFile.getName();
            String filePath = selectedFile.getParent();

            // adjusts extension
            String extension = DeployHelper.getExtension(selectedFile);
            if (extension == "" || (!extension.equals("xmi") && !extension.equals("tcuml"))) {
                extension = filterExtension;
                fileName = fileName + "." + extension;
            }
            File saveFile = new File(filePath + '/' + fileName);

            // Set the last open file
            setLastOpenFile(saveFile);
            addLastOpenFile(saveFile);

            return saveDataInFile(saveFile, f);
        } else {
            return false;
        }
    }

    /**
     * <p>
     * Save data in file.
     * </p>
     *
     * @param file
     * @param fileChooser
     */
    public boolean saveDataInFile(File file, JFileChooser fileChooser) {
        String extension = DeployHelper.getExtension(file);

        com.topcoder.util.actionmanager.Action action = null;

        Date date = new Date();
        String dateStr = new SimpleDateFormat("yyyyMMdd-HH_mm_ss").format(date);
        String name = file.getName();

        File bakFile;
        if (backupDirectory != null) {
            bakFile =
                new File(backupDirectory + "/" + name + "/" + name.substring(0, name.lastIndexOf('.')) + dateStr
                    + '.' + extension);
        } else {
            bakFile =
                new File(file.getParent() + "/" + name + "_Backups" + "/"
                    + name.substring(0, name.lastIndexOf('.')) + dateStr + '.' + extension);
        }
        boolean backupFile = false;

        if (fileChooser == null) {
            backupFile = true;
            if ("tcuml".equals(extension)) {
                action = new SaveTCUMLFileAction(file, true, getUmlModelManager());
            } else if ("xmi".equals(extension)) {
                action = new ExportToXMIFileAction(file, true, getUmlModelManager());
            } else {
                // TODO currently only the two specified extension is allowed.
            }
        } else {
            if (file.exists()) {
                int option =
                    JOptionPane.showConfirmDialog(fileChooser, file.getAbsolutePath()
                        + " already exist, do you want to replace it?", "Save", JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.NO_OPTION) {
                    return false;
                }
                backupFile = true;
            }
            if ("tcuml".equals(extension)) {
                action = new SaveTCUMLFileAction(file, true, getUmlModelManager());
            } else if ("xmi".equals(extension)) {
                action = new ExportToXMIFileAction(file, true, getUmlModelManager());
            } else {
                String desc = fileChooser.getFileFilter().getDescription();
                if (desc.indexOf("*.xmi") > 0) {
                    action = new ExportToXMIFileAction(file, true, getUmlModelManager());
                } else {
                    action = new SaveTCUMLFileAction(file, true, getUmlModelManager());
                }
            }
        }

        if (backupFile) {
            try {
                if (!bakFile.getParentFile().exists()) {
                    bakFile.getParentFile().mkdirs();
                }
                if (!bakFile.exists()) {
                    bakFile.createNewFile();
                }
                copyFile(file, bakFile);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Fail to backup project file " + e.getMessage(),
                    "Backup File", JOptionPane.ERROR_MESSAGE);
                DeployHelper.logException(e);
            }
        }

        try {
            DeployHelper.reorderGraphNodeEdge(umlModelManager);
            action.execute();
        } catch (ActionExecutionException e) {
            // Show Error Message Dialog
            JOptionPane.showMessageDialog(this, "Fail to save project - " + e.getMessage(), "Save",
                JOptionPane.ERROR_MESSAGE);
            DeployHelper.logException(e);

            if (backupFile) {
                try {
                    copyFile(bakFile, file);
                } catch (IOException e1) {
                    JOptionPane.showMessageDialog(this, "Fail to recover project file " + e1.getMessage(),
                        "Recover File", JOptionPane.ERROR_MESSAGE);
                    DeployHelper.logException(e1);
                }
            }

            return false;
        } finally {
            if ((fileChooser == null) && (!autoSave)) {
                bakFile.delete();
            }
        }

        isDirty = false;
        ProjectUtility.getInstance().setProjectFile(file);
        setTitle(MainFrame.MAIN_FRAME_TITLE + " - " + file.getName());
        return true;
    }

    /**
     * <p>
     * Window adapter for close window.
     * </p>
     */
    private class MainFrameWindowAdapter extends WindowAdapter {
        public void windowClosing(WindowEvent e) {
            quit();
        }
    }

    /**
     * <p>
     * Focus adapter for set focus to main frame.
     * </p>
     */
    private class MainFrameFocusAdapter extends FocusAdapter {
        public void focusGained(FocusEvent e) {
            validate();
            getContentPane().repaint();
        }
    }

    /**
     * <p>
     * Gets the last image export path.
     * </p>
     *
     * @return the last image export path
     */
    public String getLastImageExportPath() {
        return lastImageExportPath;
    }

    /**
     * <p>
     * Sets the last image export path.
     * </p>
     *
     * @param lastExportPath
     *            the last image export path
     */
    public void setLastImageExportPath(String lastImageExportPath) {
        this.lastImageExportPath = lastImageExportPath;
    }

    /**
     * <p>
     * Gets the last open file.
     * </p>
     *
     * @return the last open file
     */
    public File getLastOpenFile() {
        return lastOpenFile;
    }

    /**
     * <p>
     * Sets the last open file.
     * </p>
     *
     * @param lastOpenFile
     *            the last open file
     */
    public void setLastOpenFile(File lastOpenFile) {
        this.lastOpenFile = lastOpenFile;
    }

    /**
     * Adds last open file to recent file list Only 10 most recent are stored
     *
     * @param lastOpenFile
     */
    public void addLastOpenFile(File lastOpenFile) {
        if (recentProjects.contains(lastOpenFile)) {
            recentProjects.remove(lastOpenFile);
        }

        recentProjects.add(0, lastOpenFile);

        // at most lat 10 are stored
        for (int i = 11; i <= recentProjects.size(); i++) {
            recentProjects.remove(i - 1);
        }
    }

    /**
     * <p>
     * Copys a file to another file.
     * </p>
     *
     * @param inputFile
     *            the input file
     * @param outputFile
     *            the output file
     * @throws IOException
     *             when copy file error
     */
    private void copyFile(File inputFile, File outputFile) throws IOException {
        InputStream in = new FileInputStream(inputFile);
        OutputStream out = new FileOutputStream(outputFile);

        byte[] buffer = new byte[1024];
        int bytesRead;

        while ((bytesRead = in.read(buffer)) >= 0) {
            out.write(buffer, 0, bytesRead);
        }
        out.close();
        in.close();
    }

    public List<File> getRecentProjects() {
        return recentProjects;
    }

    /**
     * <p>
     * Launches
     * </p>
     *
     * @param inputFile
     *            the input file
     * @param outputFile
     *            the output file
     * @throws IOException
     *             when copy file error
     */
    private class BrowserLauncher extends MouseAdapter {

        private JFrame frame;

        private final Cursor handCursor = new Cursor(Cursor.HAND_CURSOR);

        private final Cursor normalCursor = new Cursor(Cursor.DEFAULT_CURSOR);

        public BrowserLauncher(JFrame theFrame) {
            frame = theFrame;
        }

        public void mouseEntered(MouseEvent e) {
            frame.setCursor(handCursor);
        }

        public void mouseExited(MouseEvent e) {

            frame.setCursor(normalCursor);
        }

        public void mouseClicked(MouseEvent e) {
            String url = "http://www.topcoder.com";
            String os = System.getProperty("os.name");

            try {
                if (os.startsWith("Windows")) {
                    Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + url);
                } else if (os.startsWith("Mac OS")) {
                    java.lang.Class<?> fileMgr = java.lang.Class.forName("com.apple.eio.FileManager");
                    Method openURL = fileMgr.getDeclaredMethod("openURL", new java.lang.Class[] {String.class});
                    openURL.invoke(null, new java.lang.Object[] {url});
                } else {
                    String[] browsers = {"firefox", "opera", "mozilla", "netscape"};
                    String browser = null;
                    for (int count = 0; count < browsers.length && browser == null; count++)
                        if (Runtime.getRuntime().exec(new String[] {"which", browsers[count]}).waitFor() == 0) {
                            browser = browsers[count];
                        }
                    if (browser == null) {
                        throw new Exception("No supported browsers installed");
                    } else
                        Runtime.getRuntime().exec(new String[] {browser, url});
                }
            } catch (Exception ex) {
                String feedback = "Error while attempting to open browser";
                JOptionPane.showMessageDialog(null, feedback + ":\n" + ex.getLocalizedMessage());
            }
        }

    }

    /**
     * <p>
     * Gets the autoAddOperation flag.
     * </p>
     */
    public boolean isAutoAddOperation() {
        return autoAddOperation;
    }

    /**
     * Sets whether the diagram should be auto saved or not.
     *
     * @param autoSave
     *            the given parameter
     */
    public void setAutoSave(boolean autoSave) {
        this.autoSave = autoSave;
    }

    /**
     * Sets the backup directory.
     *
     * @param backupDirectory
     *            the given parameter
     */
    public void setBackupDirectory(String backupDirectory) {
        this.backupDirectory = backupDirectory;
    }

    /**
     * Sets whether the operation should be automatically added or not.
     *
     * @param autoAddOperation
     *            the given parameter
     */
    public void setAutoAddOperation(boolean autoAddOperation) {
        this.autoAddOperation = autoAddOperation;
    }

    public boolean isAutoGenerateMethods() {
        return autoGenerateMethods;
    }

    public void setAutoGenerateMethods(boolean autoGenerateMethods) {
        this.autoGenerateMethods = autoGenerateMethods;
    }

}
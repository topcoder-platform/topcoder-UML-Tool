/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.RepaintManager;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.gui.closabletabbedpane.ClosableTabbedPane;
import com.topcoder.gui.closabletabbedpane.CloseButtonState;
import com.topcoder.gui.diagramviewer.event.AddNewElementEvent;
import com.topcoder.gui.diagramviewer.event.AddNewElementListener;
import com.topcoder.gui.diagramviewer.event.DiagramNameChangedListener;
import com.topcoder.gui.diagramviewer.event.ScrollEvent;
import com.topcoder.gui.diagramviewer.event.ScrollListener;
import com.topcoder.gui.diagramviewer.event.ScrollTrigger;
import com.topcoder.gui.diagramviewer.event.SelectionEvent;
import com.topcoder.gui.diagramviewer.event.SelectionListener;
import com.topcoder.gui.diagramviewer.event.ZoomEvent;
import com.topcoder.gui.diagramviewer.event.ZoomListener;
import com.topcoder.gui.diagramviewer.gridrenderers.SimpleGridRenderer;
import com.topcoder.gui.panels.zoom.ZoomPane;
import com.topcoder.gui.panels.zoom.ZoomPanel;
import com.topcoder.umltool.lnf.RoundCornerLineBorder;
import com.topcoder.umltool.lnf.UMLToolTabbedPanelUI;
import com.topcoder.util.cache.Cache;
import com.topcoder.util.config.ConfigManager;
import com.topcoder.util.config.UnknownNamespaceException;
import com.topcoder.util.objectfactory.InvalidClassSpecificationException;
import com.topcoder.util.objectfactory.ObjectFactory;
import com.topcoder.util.objectfactory.impl.ConfigManagerSpecificationFactory;
import com.topcoder.util.objectfactory.impl.IllegalReferenceException;
import com.topcoder.util.objectfactory.impl.SpecificationConfigurationException;

/**
 * <p>
 * This a concrete JComponent that can display multiple DiagramViews inside tabs, it use a inner JTabbedPane to
 * provide the tab functionality. It has server configurable properties, such as max number of open tabs, whether
 * to show background grid, whether to display tab title in full version, etc. See fields doc for details. It can
 * create instances of DiagramView for specified Diagram objects, and has a cache object to cache the DiagramView
 * instances, the cache functionality is obtained by using Simple Cache 2.0 component, so the cache is configurable
 * through configuration manager. It maintains a list of selected elements, and has methods to update the list,
 * also one method is provided to test if a element is selected. It has a bottom bar that can be added some
 * widgets, the bar itself is an instance of JPanel, and can be accessed by getter, application can add other
 * widgets on it if needed. Several custom event listener is automatically registered to it (or to the ZoomPanel
 * created by it), see event sub package for detail.
 * </p>
 * <p>
 * <b>Sample Configuration:</b>
 * </p>
 *
 * <pre>
 *                     &lt;?xml version=&quot;1.0&quot; ?&gt;
 *                        &lt;CMConfig&gt;
 *                            &lt;Config name=&quot;com.topcoder.gui.diagramviewer.DiagramViewer&quot;&gt;
 *                               &lt;Property name=&quot;object_factory_namespace&quot;&gt;
 *                                   &lt;Value&gt;com.topcoder.gui.diagramviewer.ObjectFactory&lt;/Value&gt;
 *                               &lt;/Property&gt;
 *                               &lt;Property name=&quot;grid_size&quot;&gt;
 *                                    &lt;Value&gt;10&lt;/Value&gt;
 *                                &lt;/Property&gt;
 *                               &lt;Property name=&quot;max_open_tabs&quot;&gt;
 *                                   &lt;Value&gt;5&lt;/Value&gt;
 *                               &lt;/Property&gt;
 *                               &lt;Property name=&quot;background_grid_visibility&quot;&gt;
 *                                   &lt;Value&gt;true&lt;/Value&gt;
 *                               &lt;/Property&gt;
 *                               &lt;Property name=&quot;tab_title_displayed_in_full_version&quot;&gt;
 *                                   &lt;Value&gt;false&lt;/Value&gt;
 *                               &lt;/Property&gt;
 *                               &lt;Property name=&quot;tab_shortened_title_max_length&quot;&gt;
 *                                    &lt;Value&gt;10&lt;/Value&gt;
 *                               &lt;/Property&gt;
 *                               &lt;Property name=&quot;diagram_view_background_color&quot;&gt;
 *                                    &lt;Value&gt;FE01A9&lt;/Value&gt;
 *                               &lt;/Property&gt;
 *                               &lt;Property name=&quot;grid_renderer&quot;&gt;
 *                                    &lt;Value&gt;gridRenderer&lt;/Value&gt;
 *                               &lt;/Property&gt;
 *                               &lt;Property name=&quot;diagram_view_gap&quot;&gt;
 *                                    &lt;Value&gt;50&lt;/Value&gt;
 *                               &lt;/Property&gt;
 *                               &lt;Property name=&quot;diagram_view_cache&quot;&gt;
 *                                   &lt;Value&gt;viewCache&lt;/Value&gt;
 *                               &lt;/Property&gt;
 *                               &lt;Property name=&quot;zoom_rotate_increment&quot;&gt;
 *                                   &lt;Value&gt;5&lt;/Value&gt;
 *                               &lt;/Property&gt;
 *                               &lt;Property name=&quot;zoom_in_action_namespace&quot;&gt;
 *                                   &lt;Value&gt;com.topcoder.gui.diagramviewer.ZoomInAction&lt;/Value&gt;
 *                               &lt;/Property&gt;
 *                               &lt;Property name=&quot;zoom_out_action_namespace&quot;&gt;
 *                                    &lt;Value&gt;com.topcoder.gui.diagramviewer.ZoomOutAction&lt;/Value&gt;
 *                               &lt;/Property&gt;
 *                               &lt;Property name=&quot;close_tab_action_namespace&quot;&gt;
 *                                   &lt;Value&gt;com.topcoder.gui.diagramviewer.CloseTabAction&lt;/Value&gt;
 *                               &lt;/Property&gt;
 *                           &lt;/Config&gt;
 *                           &lt;!-- Configure the Zoom In Button --&gt;
 *                               &lt;Config name=&quot;com.topcoder.gui.diagramviewer.ZoomInAction&quot;&gt;
 *                                   &lt;Property name=&quot;name&quot;&gt;
 *                                        &lt;Value&gt;zoom in&lt;/Value&gt;
 *                                   &lt;/Property&gt;
 *                                &lt;Property name=&quot;icon&quot;&gt;
 *                                   &lt;Value&gt;test_files/zoomin.icon&lt;/Value&gt;
 *                               &lt;/Property&gt;
 *                               &lt;Property name=&quot;increment&quot;&gt;
 *                                   &lt;Value&gt;10&lt;/Value&gt;
 *                                &lt;/Property&gt;
 *                           &lt;/Config&gt;
 *                           &lt;!-- Configure the Zoom Out Button --&gt;
 *                               &lt;Config name=&quot;com.topcoder.gui.diagramviewer.ZoomOutAction&quot;&gt;
 *                                   &lt;Property name=&quot;name&quot;&gt;
 *                                       &lt;Value&gt;zoom out&lt;/Value&gt;
 *                                   &lt;/Property&gt;
 *                                   &lt;Property name=&quot;icon&quot;&gt;
 *                                       &lt;Value&gt;test_files/zoomout.icon&lt;/Value&gt;
 *                                   &lt;/Property&gt;
 *                                   &lt;Property name=&quot;increment&quot;&gt;
 *                                       &lt;Value&gt;-10&lt;/Value&gt;
 *                                   &lt;/Property&gt;
 *                           &lt;/Config&gt;
 *                           &lt;!-- Configure the Close Tab Button --&gt;
 *                               &lt;Config name=&quot;com.topcoder.gui.diagramviewer.CloseTabAction&quot;&gt;
 *                                   &lt;Property name=&quot;name&quot;&gt;
 *                                       &lt;Value&gt;close tab&lt;/Value&gt;
 *                                   &lt;/Property&gt;
 *                               &lt;Property name=&quot;icon&quot;&gt;
 *                                    &lt;Value&gt;test_files/close.icon&lt;/Value&gt;
 *                               &lt;/Property&gt;
 *                           &lt;/Config&gt;
 *                           &lt;!-- Configure the ObjectFactory --&gt;
 *                               &lt;Config name=&quot;com.topcoder.gui.diagramviewer.ObjectFactory&quot;&gt;
 *                                   &lt;Property name=&quot;viewCache&quot;&gt;
 *                                       &lt;Property name=&quot;type&quot;&gt;
 *                                           &lt;Value&gt;com.topcoder.gui.diagramviewer.MockCache&lt;/Value&gt;
 *                                       &lt;/Property&gt;
 *                                   &lt;/Property&gt;
 *                                   &lt;Property name=&quot;gridRenderer&quot;&gt;
 *                                       &lt;Property name=&quot;type&quot;&gt;
 *                                           &lt;Value&gt;com.topcoder.gui.diagramviewer.MockGridRenderer&lt;/Value&gt;
 *                                       &lt;/Property&gt;
 *                                   &lt;/Property&gt;
 *                           &lt;/Config&gt;
 *                        &lt;/CMConfig&gt;
 * </pre>
 * <p>
 * Thread safety: this class is mutable and not thread safe.
 * </p>
 *
 * @author kakarotto, TCSDEVELOPER
 * @version 1.0
 */
public class DiagramViewer extends JComponent {

    /**
     * The Default value of max_open_tabs.
     */
    private static final String MAX_OPEN_TABS = "5";

    /*
     * BugFix: BUGID UML-7690 Description: When scrolling the diagram, it takes a long time using the scroll
     * button. The interval set on the scroll pane should be bigger so that using the scroll button is easier.
     * Solution: Add an unitScrollIncrement property to configuration, set its value to zoom panel's scroll bars.
     */
    /**
     * The Default value of scroll bar's unit increment.
     */
    private static final String DEFAULT_UNIT_SCROLL_INCREMENT = "5";

    /**
     * The Default value of background_grid_visibility.
     */
    private static final String BACKGROUND_GRID_VISIBILITY = "true";

    /**
     * The Default value of tab_title_displayed_in_full_version.
     */
    private static final String TAB_TITLE_DISPLAYED_IN_FULL_VERSION = "false";

    /**
     * The Default value of tab_shortened_title_max_length.
     */
    private static final String TAB_SHORTENED_TITLE_MAX_LENGTH = "10";

    /**
     * The Default value of diagram_view_background_color.
     */
    private static final Color DIAGRAM_VIEW_BACKGROUND_COLOR = Color.WHITE;

    /**
     * The Default value of diagram_view_gap.
     */
    private static final String DIAGRAM_VIEW_GAP = "5";

    /**
     * The Default value of zoom_rotate_increment.
     */
    private static final String ZOOM_ROTATE_INCREMENT = "5";

    /**
     * <p>
     * The default value of the gridRenderer.
     * </p>
     */
    private static final GridRenderer DEFAULT_GRIDRENDERER = new SimpleGridRenderer(10);

    /**
     * <p>
     * The default object factory namespace.
     * </p>
     */
    private static final String DEFAULT_OBJECT_FACTORY_NAMESPACE = "com.topcoder.gui.diagramviewer.ObjectFactory";

    /**
     * <p>
     * The Default namespace of ZoomInAction.
     * </p>
     */
    private static final String DEFAULT_ZOOM_IN_ACTION_NAMESPACE = "com.topcoder.gui.diagramviewer.ZoomInAction";

    /**
     * <p>
     * The Default namespace of ZoomOutAction.
     * </p>
     */
    private static final String DEFAULT_ZOOM_OUT_ACTION_NAMESPACE = "com.topcoder.gui.diagramviewer.ZoomOutAction";

    /**
     * <p>
     * The Default namespace of CloseTabAction.
     * </p>
     */
    private static final String DEFAULT_CLOSE_TAB_ACTION_NAMESPACE =
        "com.topcoder.gui.diagramviewer.CloseTabAction";

    /**
     * <p>
     * The ConfigManager instance for loading Namespace.
     * </p>
     */
    private final ConfigManager cm = ConfigManager.getInstance();

    /**
     * <p>
     * The namespace of the DiagramViewer, used for private Method of get properties .
     * </p>
     */
    private String namespace;

    /**
     * <p>
     * Represents the max number of open tabs.
     * </p>
     * <p>
     * Initialized in ctor, can be changed by being loaded from config manager in ctor, the property name is
     * "max_open_tabs". Can not be non-positive. Can be accessed by getter and setter.
     * </p>
     */
    private int maxOpenTabs;

    /*
     * BugFix: BUGID UML-7690 Description: When scrolling the diagram, it takes a long time using the scroll
     * button. The interval set on the scroll pane should be bigger so that using the scroll button is easier.
     * Solution: Add an unitScrollIncrement property to configuration, set its value to zoom panel's scroll bars.
     */
    /**
     * <p>
     * Represents the scroll bars' unit increment.
     * </p>
     * <p>
     * Initialized in ctor, can be changed by being loaded from config manager in ctor, the property name is
     * "default_unit_scroll_increment". Can not be non-positive. Can be accessed by getter and setter.
     * </p>
     */
    private int unitScrollIncrement;

    /**
     * <p>
     * Represents whether the tab title is displayed in full version. Default is false.
     * </p>
     * <p>
     * Initialized in ctor by being loaded from config manager using a property name
     * "tab_title_displayed_in_full_version", if loading failed set to the default value false. Can be accessed by
     * getter and setter.
     * </p>
     */
    private boolean tabTitleDisplayedInFullVersion;

    /**
     * <p>
     * Represents the max length of the tab title when using a shortened version of the title. Default value is 10.
     * </p>
     * <p>
     * Initialized in ctor by being loaded from config manager using a property name
     * "tab_shortened_title_max_length", if loading failed set to the default value 10. Can be accessed by getter
     * and setter.
     * </p>
     */
    private int tabShortenedTitleMaxLength;

    /**
     * <p>
     * Represents whether the grid in the diagram view can be visible. Default value is true.
     * </p>
     * <p>
     * Initialized to true, can be changed by being loaded from config manager in ctor, the property name is
     * "background_grid_visibility", if loading failed set to the default value true. Can be accessed by getter and
     * setter.
     * </p>
     */
    private boolean backgroundGridVisible = true;

    /**
     * <p>
     * Represents the background color the Diagram.
     * </p>
     * <p>
     * Initialized in the ctor by loaded from the config manager using a property name
     * "diagram_view_background_color". If loading failed, set to a default value Color.white. Can not be null. Can
     * be accessed by getter and setter.
     * </p>
     */
    private Color diagramBackgroundColor;

    /**
     * <p>
     * Represents the grid renderer, it is used to render the background for the DiagramView.
     * </p>
     * <p>
     * Initialized in ctor. If loading failed, set to a default implementation SimpleGridRenderer. Can not be null.
     * Can be accessed by getter of setter.
     * </p>
     * <p>
     * It is initialized in ctor by being created by ObjectFactory, the parameter used by ObjectFactory is loaded
     * from config manager, using a property name "grid_renderer".
     * </p>
     */
    private GridRenderer gridRenderer;

    /**
     * <p>
     * Represents the gap between the active area (actual diagram) in the DiagramView and the bounds (top and left)
     * of the DiagramView. This affects the rendering of the background grid, the grid in the active area should be
     * painted differently (lighter) than the grid outside the active area.
     * </p>
     * <p>
     * Initialized in the ctor by loaded from the config manager using a property name "diagram_view_gap". If
     * loading failed, set to a default value 50, never changed later. Can not be negative. Can be accessed by
     * getter.
     * </p>
     */
    private int diagramViewGap;

    /**
     * <p>
     * Represents the cache that holds the DiagramView instances created by this viewer. The creation of diagram
     * views might be an expensive operation, so these objects should be kept in cache. The DiagramView instances
     * in this cache may or may not be shown to the user. If one is required to be shown, then it can be retrieved
     * form this cache and added to this viewer; if one tab of the viewer (also an instance of DiagramView) is
     * required to be closed, then it is just removed from the tabbedPane but still remained in this cache.
     * </p>
     * <p>
     * Initialized in ctor and never changed later. If loading failed set to null. Can be null (indicates there is
     * no cache, though NOT recommended). Can not be accessed outside this class.
     * </p>
     * <p>
     * It is initialized in ctor by being created by ObjectFactory, the parameter used by ObjectFactory is loaded
     * from config manager, using a property name "diagram_view_cache".
     * </p>
     */
    private Cache diagramViewCache;

    /**
     * <p>
     * Represents the zoom in action that can be used to zoom in the Diagram (by using ZoomPanel). It is used to
     * construct a zoom in button in ctor, then the button will be added to the bottom bar at the lower right
     * corner.
     * </p>
     * <p>
     * Initialized in the constructor and never changed later. Can be get by getter.
     * </p>
     * <p>
     * The ZoomAction can be configured by config manager, so a namespace can be specified when instantiating it,
     * this namespace can be loaded from config manager using property name "zoom_in_action_namespace", if loading
     * failed then no namespace will be used and the ZoomAction will use the default namespace.
     * </p>
     */
    private ZoomAction zoomInAction;

    /**
     * <p>
     * Represents the zoom out action that can be used to zoom out the Diagram (by using ZoomPanel). It is used to
     * construct a zoom out button in ctor, then the button will be added to the bottom bar at the lower right
     * corner.
     * </p>
     * <p>
     * Initialized in the constructor and never changed later. Can be get by getter.
     * </p>
     * <p>
     * The ZoomAction can be configured by config manager, so a namespace can be specified when instantiating it,
     * this namespace can be loaded from config manager using property name "zoom_out_action_namespace", if loading
     * failed then no namespace will be used and the ZoomAction will use the default namespace.
     * </p>
     */
    private ZoomAction zoomOutAction;

    /**
     * <p>
     * Represents the close tab action that can be used to close the DiagramView tab inside the DiagramViewer. It
     * is used to construct a close tab button in ctor, then the button will be added to the DiagramViewer at the
     * upper right corner.
     * </p>
     * <p>
     * Initialized in the constructor and never changed later. Can be get by getter.
     * </p>
     * <p>
     * The CloseTabAction can be configured by config manager, so a namespace can be specified when instantiating
     * it, this namespace can be loaded from config manager using property name "close_tab_action_namespace", if
     * loading failed then no namespace will be used and the CloseTabAction will use the default namespace.
     * </p>
     */
    private CloseTabAction closeTabAction;

    /**
     * <p>
     * Represents the tabbed pane used to display multiple diagrams inside tabs. The number of the max tabs that it
     * can contain is specified by field maxOpenTabs. The tab title it shows depends on the field
     * tabTitleDiplayedInFullVersion, if it is true then the full version of the title will be shown, otherwise a
     * shortened version will be shown and a tool tip is available with the full name. The zoomTextFieldAction
     * field should be registered as a ChangeListener to this pane.
     * </p>
     * <p>
     * Initialized in constructor and never changed, then added to this component as a child. Can not be null, and
     * can not be accessed outside this class.
     * </p>
     */
    private ClosableTabbedPane tabbedPane;

    /**
     * <p>
     * Represents the text input box that can be used by graphical elements to edit properties such as name.
     * </p>
     * <p>
     * Initialized in ctor and never changed later. Can not be null. Can be accessed by getter.
     * </p>
     */
    private final TextInputBox textInputBox;

    /**
     * <p>
     * Represents the bottom bar that is shown on the bottom of this view (see GUI sample pictures for reference).
     * It currently contains only the zoom spin buttons and a text field used to change zoom factor, the
     * application can add other widgets to this bar if needed.
     * </p>
     * <p>
     * Initialized in ctor and never changed later (widgets can be added though). Can not be null. Can be accessed
     * by getter.
     * </p>
     */
    private final JPanel bottomBar;

    /**
     * <p>
     * Represents the type of the new element to be added to a Diagram View.
     * </p>
     * <p>
     * Initialized to null, and will be set to null in method fireNewElementAdded. Can not be null when the method
     * setState is called and the new state is DiagramState.ADD_ELEMENT_BY_CLICK or
     * DiagramState.ADD_ELEMENT_BY_DRAGGING_RECTANGLE, null will cause an IllegalStateException thrown in such a
     * case. Can be accessed by getter and setter.
     * </p>
     */
    private Class newElementType = null;

    /**
     * <p>
     * Represents the state of this viewer.
     * </p>
     * <p>
     * Initialized to DiagramState.SELECT_ELEMENT. Can not be null. Can be accessed by getter and setter.
     * </p>
     *
     * @see DiagramState
     */
    private DiagramState state = DiagramState.SELECT_ELEMENT;

    /**
     * <p>
     * Represents the list of selected elements inside the diagram.
     * </p>
     * <p>
     * Initialized to an ArrayList (or other implementations, can be chosen by developer), and never changed. The
     * element of this list can not be null, and must be instance of Node or Edge. Method addSelectedElement is
     * used to add an element to this list, method removeSelectedElement is used to remove an element from this
     * list. Method getSelectedElements returns an unmodifiable view of this list.
     * </p>
     */
    private final List<JComponent> selectedElements = new ArrayList<JComponent>();

    /**
     * <p>
     * Represents the action for a text field that the user can input zoom factor for current DiagramView. The text
     * field always show the zoom factor of current DiagramView, and the value should be changed when tab is
     * changed, this is done by this action by acting as a ChangeListener. This action is created in ctor and
     * registered to the text field as ChangeListener and ActionListener.
     * </p>
     * <p>
     * Initialized in ctor and never changed later. Can not be null. Can be accessed by getter.
     * </p>
     */
    private final ZoomTextFieldAction zoomTextFieldAction;

    private final Image closeTabImage;

    /**
     * <p>
     * Represents the increment used to change zoom factor when mouse is rotated while key "Ctrl" is being pressed.
     * </p>
     * <p>
     * Initialized in the ctor by loaded from the config manager using a property name "zoom_rotate_increment". If
     * loading failed, set to a default value 0, means do not support change zoom factor when rotating mouse wheel,
     * never changed later. Can not be negative. Can be accessed by getter.
     * </p>
     */
    /*
     * BugFix: BUGID UML-7154 Description: The zoom factor should have been a double. This needs to be updated.
     */
    // old code
    // private int zoomRotateIncrement;
    private double zoomRotateIncrement;

    private DiagramNameChangedListener diagramNameChangedListener;

    /**
     * <p>
     * Creates an instance using the default namespace: the full name of this class.
     * </p>
     *
     * @throws ConfigurationException
     *             if configuration errors occur.
     */
    public DiagramViewer() throws ConfigurationException {
        this(DiagramViewer.class.getName());
    }

    /**
     * <p>
     * Creates an instance by loading the configuration properties from the given namespace. The properties are
     * loaded from ConfigManager. Since every property of this component is optional, if any property is missed
     * then the corresponding field will be set to default value (see fields doc for details).
     * </p>
     * <p>
     * If error occurs when using ConfigManager or ObjectFactory, wrap it to a ConfigurationException and throw.
     * </p>
     *
     * @param namespace
     *            the configuration namespace
     * @throws IllegalArgumentException
     *             if namespace is null or empty
     * @throws ConfigurationException
     *             if a configuration error occurs.
     */
    public DiagramViewer(String namespace) throws ConfigurationException {
        this.namespace = DVHelper.validateString(namespace, "namespace");
        // load the property of the DiagrmaViewer.
        loadProperty();
        // load the diagramViewCache and the gridRenderer.
        loadObject();
        // load three actions.
        loadAction();

        // there is also a text field that is used to change zoom factor
        // for current active tab, the class ZoomTextFieldAction is provided
        // as a event handler for this text field, so just create the text
        // field and register ActionListener for it:
        this.textInputBox = new TextInputBox();
        JTextField textField = new JTextField();
        zoomTextFieldAction = new ZoomTextFieldAction(this, textField);
        textField.addActionListener(zoomTextFieldAction);

        // Set the layout manager of DiagramViewer to BorderLayout.
        setLayout(new BorderLayout());
        /*
         * BugFix: BUGID UML-7689 Description: The close table button needs to be changed to a popup behavior of
         * each table. The popup should contain a "Close tab" menu item. The current close tab is not fitting well
         * into the assembled tool. Solution: Remove top bar and assign the close action as tabbed pane's popup.
         */
        // old code
        // // Create a JPanel to hold the close tab button, and add the
        // JPanel topBar = new JPanel();
        // // button to the rightmost corner of it.
        // topBar.add(new JButton(closeTabAction));
        // topBar.setLayout(new FlowLayout(FlowLayout.RIGHT));
        // // Add the panel to BorderLayout.NORTH.
        // add(topBar, BorderLayout.NORTH);
        // Initialize the bottomBar to a new JPanel, and add the zoom
        this.bottomBar = new JPanel();
        // in/out buttons and zoom text field to the rightmost corner of it.
        this.bottomBar.setLayout(new FlowLayout(FlowLayout.RIGHT));

        this.bottomBar.add(new JButton(zoomInAction));
        this.bottomBar.add(new JButton(zoomOutAction));
        this.bottomBar.add(textField);
        // Add the bottomBar to BorderLayout.SOUTH.
        // Add the tabbedPane to BorderLayout.CENTER.
        /*
         * Bugfix: UML-9703 Don't show bottom bar since uml tool application will add zoom buttons on tool bar.
         */
        // old code
        // add(this.bottomBar, BorderLayout.SOUTH);
        tabbedPane = new ClosableTabbedPane();
        tabbedPane.setUI(new UMLToolTabbedPanelUI());
        tabbedPane.setCloseButtonPadding(new Dimension(5, 0));
        this.setBorder(new RoundCornerLineBorder(UIManager.getColor("DiagramViewer.borderColor"), UIManager
            .getColor("DiagramViewer.backgroundColor"), 1));

        closeTabImage =
            Toolkit.getDefaultToolkit().createImage(getClass().getResource(UIManager.getString("CloseTab.xIcon")));
        tabbedPane.setCloseButtonImage(CloseButtonState.ACTIVE_TAB_HOVERED, closeTabImage);
        tabbedPane.setCloseButtonImage(CloseButtonState.ACTIVE_TAB_NOT_HOVERED, closeTabImage);
        tabbedPane.setCloseButtonImage(CloseButtonState.INACTIVE_TAB_HOVERED, closeTabImage);
        tabbedPane.setCloseButtonImage(CloseButtonState.INACTIVE_TAB_NOT_HOVERED, closeTabImage);

        add(tabbedPane, BorderLayout.CENTER);
    }

    /**
     * <p>
     * Getter of maxOpenTabs.
     * </p>
     *
     * @return the max number of open tabs
     */
    public int getMaxOpenTabs() {
        return maxOpenTabs;
    }

    /**
     * <p>
     * Setter of maxOpenTabs, the value should be positive.
     * </p>
     *
     * @param maxOpenTabs
     *            the max number of open tabs
     * @throws IllegalArgumentException
     *             if the arg is non-positive
     */
    public void setMaxOpenTabs(int maxOpenTabs) {
        this.maxOpenTabs = DVHelper.validatePositive(maxOpenTabs, "maxOpenTabs");
    }

    /**
     * <p>
     * Getter of tabTitleDisplayedInFullVersion.
     * </p>
     *
     * @return tabTitleDisplayedInFullVersion whether the tab title is displayed in full version
     */
    public boolean isTabTitleDisplayedInFullVersion() {
        return tabTitleDisplayedInFullVersion;
    }

    /**
     * <p>
     * Setter of tabTitleDisplayedInFullVersion.
     * </p>
     *
     * @param tabTitleDisplayedInFullVersion
     *            whether the tab title is displayed in full version
     */
    public void setTabTitleDisplayedInFullVersion(boolean tabTitleDisplayedInFullVersion) {
        this.tabTitleDisplayedInFullVersion = tabTitleDisplayedInFullVersion;
    }

    /**
     * <p>
     * Getter of tabShortenedTitleMaxLength.
     * </p>
     *
     * @return the max length of the shortened version of the tab title
     */
    public int getTabShortenedTitleMaxLength() {
        return tabShortenedTitleMaxLength;
    }

    /**
     * <p>
     * Setter of tabShortenedTitleMaxLength, the value should be positive.
     * </p>
     *
     * @param length
     *            the max length
     * @throws IllegalArgumentException
     *             if the arg is non-positive
     */
    public void setTabShortenedTitleMaxLength(int length) {
        tabShortenedTitleMaxLength = DVHelper.validatePositive(length, "length");
    }

    /**
     * <p>
     * Getter of backgroundGridVisible.
     * </p>
     *
     * @return true if the grid is visible, otherwise false.
     */
    public boolean isBackgroundGridVisible() {
        return backgroundGridVisible;
    }

    /**
     * <p>
     * Setter of backgroundGridVisible.
     * </p>
     *
     * @param gridVisible
     *            true to make the grid visible, false to make it invisible
     */
    public void setBackgroundGridVisible(boolean gridVisible) {
        backgroundGridVisible = gridVisible;
    }

    /**
     * <p>
     * Getter of gridRenderer.
     * </p>
     *
     * @return the size of the grid
     */
    public GridRenderer getGridRenderer() {
        return gridRenderer;
    }

    /**
     * <p>
     * Setter of gridRenderer, the value should not be null.
     * </p>
     *
     * @param gridRenderer
     *            the grid size
     * @throws IllegalArgumentException
     *             if the arg is null
     */
    public void setGridRenderer(GridRenderer gridRenderer) {
        this.gridRenderer = (GridRenderer) DVHelper.validateNotNull(gridRenderer, "gridRenderer");
    }

    /**
     * <p>
     * Getter of newElementType.
     * </p>
     *
     * @return the type of the new element to be added
     */
    public Class getNewElementType() {
        return newElementType;
    }

    /**
     * <p>
     * Setter of newElementType, the class type should be subclass of Node/Edge.
     * </p>
     *
     * @param newElementType
     *            the type of the new element to be added to the diagram
     * @throws IllegalArgumentException
     *             if the arg is null or not subclass of Node/Edge
     */
    public void setNewElementType(Class newElementType) {
        this.newElementType = (Class) DVHelper.validateClassType(newElementType, "newElementType");
    }

    /**
     * <p>
     * Getter of state.
     * </p>
     *
     * @return the state of this viewer
     */
    public DiagramState getState() {
        return state;
    }

    /**
     * <p>
     * Setter of state, the value should not be null, when the newElementType is null the state should not be
     * ADD_ELEMENT_BY_CLICK or ADD_ELEMENT_BY_DRAGGING_RECTANGLE.
     * </p>
     *
     * @param state
     *            the new state
     * @throws IllegalStateException
     *             if state is null or the newElementType is null when new state is ADD_ELEMENT_BY_CLICK or
     *             ADD_ELEMENT_BY_DRAGGING_RECTANGLE
     */
    public void setState(DiagramState state) {
        if (state == null) {
            throw new IllegalStateException("The state should not be null.");
        }

        if ((this.newElementType == null)
            && ((state == DiagramState.ADD_ELEMENT_BY_CLICK) || (state == DiagramState.ADD_ELEMENT_BY_DRAGGING_RECTANGLE))) {
            throw new IllegalStateException("the newElementType is null when new state is "
                + "ADD_ELEMENT_BY_CLICK or ADD_ELEMENT_BY_DRAGGING_RECTANGLE.");
        }

        this.state = state;
    }

    /**
     * <p>
     * Getter of the diagramViewGap.
     * </p>
     *
     * @return the diagram view gap
     */
    public int getDiagramViewGap() {
        return diagramViewGap;
    }

    /**
     * <p>
     * Getter of zoomInAction.
     * </p>
     *
     * @return the zoom in action corresponds to the zoom in button
     */
    public ZoomAction getZoomInAction() {
        return zoomInAction;
    }

    /**
     * <p>
     * Getter of zoomOutAction.
     * </p>
     *
     * @return the zoom out action corresponds to the zoom out button
     */
    public ZoomAction getZoomOutAction() {
        return zoomOutAction;
    }

    /**
     * <p>
     * Getter of closeTabAction.
     * </p>
     *
     * @return the close tab action corresponds to the close tab button
     */
    public CloseTabAction getCloseTabAction() {
        return closeTabAction;
    }

    /**
     * <p>
     * Getter of bottomBar.
     * </p>
     *
     * @return the bottom bar
     */
    public JPanel getBottomBar() {
        return bottomBar;
    }

    /*
     * BugFix: BUGID UML-8858 Description: The DiagramViewer needs a getter added for the tabbedPane value. This is
     * to allow adding event viewers to the tab.
     */
    /**
     * <p>
     * Getter of tabbedPane.
     * </p>
     *
     * @return the tabbed pane
     */
    public JTabbedPane getTabbedPane() {
        return tabbedPane;
    }

    /**
     * <p>
     * Getter of textInputBox.
     * </p>
     *
     * @return the text input box
     */
    public TextInputBox getTextInputBox() {
        return textInputBox;
    }

    /**
     * <p>
     * Register a SelectionListener. Null can be ignored by listenerList#add method.
     * </p>
     *
     * @param listener
     *            the SelectionListener to be registered
     * @throws IllegalArgumentException
     *             if any of the args is null
     */
    public void addSelectionListener(SelectionListener listener) {
        super.listenerList.add(SelectionListener.class, listener);
    }

    /**
     * <p>
     * Removes a registered SelectionListener. Null can be ignored by listenerList#remove method.
     * </p>
     *
     * @param listener
     *            the SelectionListener to be removed
     * @throws IllegalArgumentException
     *             if any of the args is null
     */
    public void removeSelectionListener(SelectionListener listener) {
        super.listenerList.remove(SelectionListener.class, listener);
    }

    /**
     * <p>
     * Create a SelectionEvent and notify all listeners registered interest for SelectionEvent.
     * </p>
     *
     * @param view
     *            the DiagramView where the selection rectangle changed
     * @param rectangle
     *            the selection rectangle
     * @throws IllegalArgumentException
     *             if any of the args is null
     */
    public void fireSelectionRectangleChange(DiagramView view, Rectangle rectangle) {
        SelectionEvent event = new SelectionEvent(view, rectangle);

        for (SelectionListener listener : listenerList.getListeners(SelectionListener.class)) {
            listener.selectionRectangleChanged(event);
        }
    }

    /**
     * <p>
     * Register a ScrollListener. Null can be ignored by listenerList#add method.
     * </p>
     *
     * @param listener
     *            the ScrollListener to be registered.
     * @throws IllegalArgumentException
     *             if any of the args is null
     */
    public void addScrollListener(ScrollListener listener) {
        super.listenerList.add(ScrollListener.class, listener);
    }

    /**
     * <p>
     * Removes a registered ScrollListener. Null can be ignored by listenerList#remove method.
     * </p>
     *
     * @param listener
     *            the ScrollListener to be removed
     * @throws IllegalArgumentException
     *             if any of the args is null
     */
    public void removeScrollListener(ScrollListener listener) {
        super.listenerList.remove(ScrollListener.class, listener);
    }

    /**
     * <p>
     * Create a ScrollEvent and notify all listeners registered interest for ScrollEvent.
     * </p>
     *
     * @param viewport
     *            the new JViewport of the ZoomPanel that contains the DiagramView corresponds to this diagram
     * @param diagram
     *            the diagram that is scrolled
     * @throws IllegalArgumentException
     *             if any of the args is null
     */
    public void fireScroll(JViewport viewport, Diagram diagram) {
        ScrollEvent event = new ScrollEvent(viewport, diagram);

        for (ScrollListener listener : listenerList.getListeners(ScrollListener.class)) {
            listener.diagramViewScrolled(event);
        }
    }

    /**
     * <p>
     * Register a ZoomListener. Null can be ignored by listenerList#add method.
     * </p>
     *
     * @param listener
     *            the ZoomListener to be registered.
     * @throws IllegalArgumentException
     *             if any of the args is null
     */
    public void addZoomListener(ZoomListener listener) {
        super.listenerList.add(ZoomListener.class, listener);
    }

    /**
     * <p>
     * Removes a registered ZoomListener. Null can be ignored by listenerList#remove method.
     * </p>
     *
     * @param listener
     *            the ZoomListener to be removed
     * @throws IllegalArgumentException
     *             if any of the args is null
     */
    public void removeZoomListener(ZoomListener listener) {
        super.listenerList.remove(ZoomListener.class, listener);
    }

    /**
     * <p>
     * Create a ZoomEvent and notify all listeners registered interest for ZoomEvent.
     * </p>
     *
     * @param factorIncrement
     *            the increment of the zoom factor, negative means zoom out, positive means zoom in
     * @throws IllegalArgumentException
     *             if zoomPanel is null
     */
    /*
     * BugFix: BUGID UML-7154 Description: The zoom factor should have been a double. This needs to be updated.
     */
    // old code
    // public void fireZoom(int factorIncrement) {
    public void fireZoom(double factorIncrement) {
        // Obtain the currently enabled tab:
        ZoomPanel zoomPanel = (ZoomPanel) tabbedPane.getSelectedComponent();
        /*
         * BugFix: BUGID UML-7149 Description: If there's no zoom panel selected, this method should not throw an
         * exception, instead it should do nothing. If the factor increment will make the zoom factor not positive,
         * it should be ignored.
         */
        // old code
        // DVHelper.validateNotNull(zoomPanel, "zoomPanel");
        //
        // ZoomEvent event = new ZoomEvent(zoomPanel, zoomPanel.getZoomFactor() + factorIncrement);
        //
        // for (ZoomListener listener : listenerList.getListeners(ZoomListener.class)) {
        // listener.diagramViewZoomed(event);
        // }
        if (zoomPanel == null) {
            return;
        }
        double newZoomFactor = zoomPanel.getZoomFactor() + factorIncrement;
        if (newZoomFactor > 0) {
            ZoomEvent event = new ZoomEvent(zoomPanel, newZoomFactor);

            for (ZoomListener listener : listenerList.getListeners(ZoomListener.class)) {
                listener.diagramViewZoomed(event);
            }
        }
    }

    /**
     * <p>
     * Register an AddNewElementListener. Null can be ignored by listenerList#add method.
     * </p>
     *
     * @param listener
     *            the AddNewElementListener to be registered
     * @throws IllegalArgumentException
     *             if any of the args is null
     */
    public void addAddNewElementListener(AddNewElementListener listener) {
        super.listenerList.add(AddNewElementListener.class, listener);
    }

    /**
     * <p>
     * Removes a registered AddNewElementListener. Null can be ignored by listenerList#remove method.
     * </p>
     *
     * @param listener
     *            the AddNewElementListener to be removed
     * @throws IllegalArgumentException
     *             if any of the args is null
     */
    public void removeAddNewElementListener(AddNewElementListener listener) {
        super.listenerList.remove(AddNewElementListener.class, listener);
    }

    /**
     * <p>
     * Create an AddNewElementEvent (triggered by clicking on the DiagramView) and notify all listeners registered
     * interest for AddNewElementEvent. Then set the newElementType to null.
     * </p>
     *
     * @param diagramView
     *            the DiagramView where the new element is to be added
     * @param type
     *            the type of the new element
     * @throws IllegalArgumentException
     *             if any of the args is null or the class type is not the subclass of Edge or Node.
     */
    public void fireNewElementAdded(DiagramView diagramView, Class type) {
        fireNewElementAdded(diagramView, type, new Rectangle());
    }

    /**
     * <p>
     * Create an AddNewElementEvent (triggered by dragging bounds rectangle on the DiagramView) and notify all
     * listeners registered interest for AddNewElementEvent. Then set the newElementType to null.
     * </p>
     *
     * @param diagramView
     *            the DiagramView where the new element is to be added
     * @param type
     *            the type of the new element
     * @param bounds
     *            the bounds of the new element
     * @throws IllegalArgumentException
     *             if any of the args is null or the class type is not the subclass of Edge or Node.
     */
    public void fireNewElementAdded(DiagramView diagramView, Class type, Rectangle bounds) {
        AddNewElementEvent event = new AddNewElementEvent(diagramView, type, bounds);

        for (AddNewElementListener listener : listenerList.getListeners(AddNewElementListener.class)) {
            listener.addNewElement(event);
        }
    }

    /**
     * <p>
     * Create a DiagramView for specified Diagram. First check the diagramViewCache to see is there a DiagramView
     * has been already created for this Diagram, if there is then return the cached one directly, otherwise create
     * a new one, cache it and return it.
     * </p>
     *
     * @param diagram
     *            the Diagram for which the DiagramView is created
     * @return the DiagramView just created or the one cached before
     * @throws IllegalArgumentException
     *             if any of the args is null
     */
    public DiagramView createDiagramView(Diagram diagram) {
        DVHelper.validateNotNull(diagram, "diagram");

        DiagramView view = (DiagramView) diagramViewCache.get(diagram);

        if (view == null) {
            // Create new DiagramView:
            view = new DiagramView(diagram, this);
            // Cache the view:
            diagramViewCache.put(diagram, view);
        }
        return view;
    }

    /**
     * <p>
     * Create DiagramView instances for specified array of Diagram. This is a convenient way to create many
     * DiagramView at one time.
     * </p>
     *
     * @param diagrams
     *            an array of Diagram
     * @return an array of DiagramView corresponds the Diagram
     * @throws IllegalArgumentException
     *             if any of the args is null
     */
    public DiagramView[] createDiagramViews(Diagram[] diagrams) {
        DVHelper.validateNotNull(diagrams, "diagrams");

        // Create an new array:
        DiagramView[] views = new DiagramView[diagrams.length];

        for (int i = 0; i < diagrams.length; i++) {
            views[i] = createDiagramView(diagrams[i]);
        }
        return views;
    }

    /**
     * <p>
     * Open a diagram tab for the specified Diagram. First create a DiagramView by createDiagramView method, then
     * add it to the tabbedPane. Note if there is already a tab for the given diagram, nothing should happen.
     * </p>
     *
     * @param diagram
     *            the Diagram for which to open a DiagramView tab
     * @return the opened DiagramView tab
     * @throws IllegalArgumentException
     *             if any of the args is null
     */
    public DiagramView openDiagramView(Diagram diagram) {
        // Create a DiagramView (if there is already a tab, then the view must
        // be cached):
        DiagramView view = createDiagramView(diagram);
        diagram.setVisible(true);

        /*
         * BugFix: BUGID UML-7150 Description: DiagramView is not tabbedPane's child, so it should not be used to
         * get the index in tabbedPane. The zoom panel instance should have been used. BugFix: BUGID UML-7151
         * Description: String#subString(int n) is used to get beginning n characters. It should have used
         * String#subString(0, n). BugFix: BUGID UML-7152 Description: When a diagram view is opened, the tab
         * containing the diagram view should be opened. Solution: Fix these bugs.
         */
        // old code
        // // If the tabbedPane has already contained the view, return directly.
        // if (tabbedPane.indexOfComponent(view) == -1) {
        // String title;
        // if (tabTitleDisplayedInFullVersion) {
        // title = diagram.getName();
        // } else {
        // title = diagram.getName().substring(tabShortenedTitleMaxLength - 3) + "...";
        // }
        // // Set the full name as a tool tip:
        // view.setToolTipText(diagram.getName());
        //
        // // Create ZoomPanel:
        // ZoomPanel zoomPanel = new ZoomPanel(view);
        //
        // // Register ScrollTrigger to both vertical and horizontal scroll
        // // bars of
        // // zoomPanel.
        // ScrollTrigger st = new ScrollTrigger();
        //
        // zoomPanel.getVerticalScrollBar().addAdjustmentListener(st);
        // zoomPanel.getHorizontalScrollBar().addAdjustmentListener(st);
        //
        // tabbedPane.add(title, zoomPanel);
        // }
        ZoomPanel zoomPanel = null;
        String title;
        if (tabTitleDisplayedInFullVersion || (diagram.getName().length() < tabShortenedTitleMaxLength - 3)) {
            title = diagram.getName();
        } else {
            title = diagram.getName().substring(0, tabShortenedTitleMaxLength - 3) + "...";
        }
        if (view.getParent() != null) {
            ZoomPane zoomPane = (ZoomPane) view.getParent();
            JViewport viewport = (JViewport) zoomPane.getParent();
            zoomPanel = (ZoomPanel) viewport.getParent();
            int index = tabbedPane.indexOfComponent(zoomPanel);
            if (index == -1) {
                tabbedPane.add(zoomPanel);
                index = tabbedPane.indexOfComponent(zoomPanel);
            }
            tabbedPane.setTitleAt(index, title);

            // Set the tool tip text for each tab
            tabbedPane.setToolTipTextAt(index, diagram.getName());
        } else {
            /*
             * BugFix: UML-9877 Move the code outside if-else
             */
            // old code
            // // Set the full name as a tool tip:
            // view.setToolTipText(diagram.getName());
            // Create ZoomPanel:
            // Set current repaint manager as null first before new zoom panel,
            // otherwise ZoomRepaintManager will be wrapped recursively
            RepaintManager.setCurrentManager(null);
            zoomPanel = new ZoomPanel(view);

            // Register ScrollTrigger to both vertical and horizontal scroll
            // bars of
            // zoomPanel.
            ScrollTrigger st = new ScrollTrigger();

            zoomPanel.getVerticalScrollBar().addAdjustmentListener(st);
            zoomPanel.getHorizontalScrollBar().addAdjustmentListener(st);
            zoomPanel.setZoomBackground(UIManager.getColor("ZoomPanel.backgroundColor"));

            /*
             * BugFix: BUGID UML-7690 Description: When scrolling the diagram, it takes a long time using the
             * scroll button. The interval set on the scroll pane should be bigger so that using the scroll button
             * is easier. Solution: Add an unitScrollIncrement property to configuration, set its value to zoom
             * panel's scroll bars.
             */
            zoomPanel.getVerticalScrollBar().setUnitIncrement(unitScrollIncrement);
            zoomPanel.getHorizontalScrollBar().setUnitIncrement(unitScrollIncrement);

            tabbedPane.addTab(title, null, zoomPanel, diagram.getName());
            zoomPanel.setBorder(new LineBorder(new Color(200, 221, 242), 7, false));

        }
        tabbedPane.setSelectedComponent(zoomPanel);
        /*
         * BugFix: UML-9877 Move the code outside if-else
         */
        // Set the full name as a tool tip:
        view.setToolTipText(diagram.getName());

        /*
         * BugFix: BUGID UML-7689 Description: The close table button needs to be changed to a popup behavior of
         * each table. The popup should contain a "Close tab" menu item. The current close tab is not fitting well
         * into the assembled tool. Solution: Remove top bar and assign the close action as tabbed pane's popup.
         */
        /*
         * if (tabbedPane.getComponentPopupMenu() == null) { JPopupMenu closeMenu = new JPopupMenu();
         * closeMenu.add(closeTabAction); tabbedPane.setComponentPopupMenu(closeMenu); }
         */
        return view;
    }

    /**
     * <p>
     * Close the tab for the specified diagram. If there is no tab corresponds for the diagram, nothing will
     * happen.
     * </p>
     *
     * @param diagram
     *            the Diagram for which the tab is to be closed
     * @throws IllegalArgumentException
     *             if any of the args is null
     */
    public void closeDiagramView(Diagram diagram) {
        DVHelper.validateNotNull(diagram, "diagram");
        /*
         * BugFix: BUGID UML-7150 Description: DiagramView is not tabbedPane's child, so it should not be used to
         * get the index in tabbedPane. The zoom panel instance should have been used. BugFix: BUGID UML-7153
         * Description: When a tab is removed, the next tab should be selected so that listeners can be triggered.
         * Solution: Fix these bugs.
         */
        // old code
        // tabbedPane.remove((DiagramView) diagramViewCache.get(diagram));
        DiagramView view = (DiagramView) diagramViewCache.get(diagram);
        ZoomPane zoomPane = (ZoomPane) view.getParent();
        JViewport viewPort = (JViewport) zoomPane.getParent();
        ZoomPanel zoomPanel = (ZoomPanel) viewPort.getParent();
        tabbedPane.remove(zoomPanel);
        int index = tabbedPane.getSelectedIndex();
        // Set a new index, otherwise listeners will not be triggered
        tabbedPane.setSelectedIndex(-1);
        tabbedPane.setSelectedIndex(index);

        view.getDiagram().setVisible(false);

        /*
         * BugFix: BUGID UML-7689 Description: The close table button needs to be changed to a popup behavior of
         * each table. The popup should contain a "Close tab" menu item. The current close tab is not fitting well
         * into the assembled tool. Solution: Remove top bar and assign the close action as tabbed pane's popup.
         */
        if (index == -1) {
            tabbedPane.setComponentPopupMenu(null);
        }
    }

    /**
     * <p>
     * Close the currently enabled tab.
     * </p>
     */
    public void closeCurrentDiagramView() {
        // JTabbedPane#getSelectedComponent to get currently active panel.
        ZoomPanel zoomPanel = (ZoomPanel) tabbedPane.getSelectedComponent();
        if (zoomPanel != null) {
            tabbedPane.remove(zoomPanel);
            JViewport viewport = (JViewport) zoomPanel.getComponent(0);
            ZoomPane zoomPane = (ZoomPane) viewport.getComponent(0);
            DiagramView view = (DiagramView) zoomPane.getComponent(0);
            view.getDiagram().setVisible(false);
        }
        /*
         * BugFix: BUGID UML-7689 Description: The close table button needs to be changed to a popup behavior of
         * each table. The popup should contain a "Close tab" menu item. The current close tab is not fitting well
         * into the assembled tool. Solution: Remove top bar and assign the close action as tabbed pane's popup.
         */
        int index = tabbedPane.getSelectedIndex();
        // Set a new index, otherwise listeners will not be triggered
        tabbedPane.setSelectedIndex(-1);
        tabbedPane.setSelectedIndex(index);
        if (index == -1) {
            tabbedPane.setComponentPopupMenu(null);
        }
    }

    /**
     * <p>
     * Retrieves all the cached DiagramViews.
     * </p>
     *
     * @return all the cached DiagramView instances
     */
    public DiagramView[] getCachedDiagramViews() {
        // Create an array:
        DiagramView[] views = new DiagramView[(int) diagramViewCache.getSize()];
        int index = 0;

        // iterate through diagramViewCache, retrieve the views
        for (Iterator it = this.diagramViewCache.keySet().iterator(); it.hasNext();) {
            views[index++] = this.createDiagramView(((Diagram) it.next()));
        }

        return views;
    }

    /**
     * <p>
     * Select an element to the selectedElement list. If the element has already been selected, nothing should
     * happen.
     * </p>
     *
     * @param element
     *            the element newly selected
     * @throws IllegalArgumentException
     *             if any of the args is null
     */
    public void addSelectedElement(JComponent element) {
        DVHelper.validateNotNull(element, "element");

        if (!selectedElements.contains(element)) {
            selectedElements.add(element);
        }
    }

    /**
     * <p>
     * Returns all the selected elements in this diagram viewer, should return a unmodifiable view of the
     * selectedElements list.
     * </p>
     *
     * @return an unmodifiable list that contains all the selected elements
     */
    public List<JComponent> getAllSelectedElements() {
        return Collections.unmodifiableList(selectedElements);
    }

    /**
     * <p>
     * Removes an element from the selectedElement list. If the element has not been selected, nothing should
     * happen.
     * </p>
     *
     * @param element
     *            the element to be removed from the selection list
     * @throws IllegalArgumentException
     *             if any of the args is null
     */
    public void removeSelectedElement(JComponent element) {
        DVHelper.validateNotNull(element, "element");
        selectedElements.remove(element);
    }

    /**
     * <p>
     * Checks whether the given element is in the selection list.
     * </p>
     *
     * @param element
     *            the element to be checked
     * @return whether the element is selected
     * @throws IllegalArgumentException
     *             if any of the args is null
     */
    public boolean isElementSelected(JComponent element) {
        DVHelper.validateNotNull(element, "element");

        return selectedElements.contains(element);
    }

    /**
     * <p>
     * Show the bottom bar. If it is not added to this viewer, add it.
     * </p>
     */
    public void showBottomBar() {
        add(bottomBar);
        revalidate();
    }

    /**
     * <p>
     * Hide the bottom bar. If it has been added to this viewer, remove it.
     * </p>
     */
    public void hideBottomBar() {
        remove(bottomBar);
        revalidate();
    }

    /**
     * <p>
     * Getter of diagramBackgroundColor, see field doc for explanation.
     * </p>
     *
     * @return the background color of the diagram
     */
    public Color getDiagramBackgroundColor() {
        return diagramBackgroundColor;
    }

    /**
     * <p>
     * Setter of diagramBackgroundColor, see field doc for explanation.
     * </p>
     *
     * @param color
     *            the new color
     * @throws IllegalArgumentException
     *             if the arg is null
     */
    public void setDiagramBackgroundColor(Color color) {
        DVHelper.validateNotNull(color, "color");
        diagramBackgroundColor = color;
    }

    /**
     * <p>
     * Getter of zoomTextFieldAction, see field doc for explanation.
     * </p>
     *
     * @return the zoomTextFieldAction
     */
    public ZoomTextFieldAction getZoomTextFieldAction() {
        return zoomTextFieldAction;
    }

    /**
     * <p>
     * Gets the zoom factor for current active tab.
     * </p>
     *
     * @return zoom factor of current active tab
     */
    /*
     * BugFix: BUGID UML-7154 Description: The zoom factor should have been a double. This needs to be updated.
     */
    // old code
    // public int getZoomFactorForCurrentTab() {
    // return (int) ((ZoomPanel) tabbedPane.getSelectedComponent())
    // .getZoomFactor();
    // }
    public double getZoomFactorForCurrentTab() {
        return ((ZoomPanel) tabbedPane.getSelectedComponent()).getZoomFactor();
    }

    /**
     * <p>
     * Getter of zoomRotateIncrement, see field doc for explanation.
     * </p>
     *
     * @return the zoom increment when rotating mouse while key "Ctrl" is being pressed
     */
    /*
     * BugFix: BUGID UML-7154 Description: The zoom factor should have been a double. This needs to be updated.
     */
    // old code
    // public int getZoomRotateIncrement() {
    public double getZoomRotateIncrement() {
        return zoomRotateIncrement;
    }

    // BugFix: UML-9437
    /**
     * <p>
     * Clear the cache and close all the tab.
     * </p>
     */
    public void clear() {
        // clear the cache
        diagramViewCache.clear();

        // remove all the tab.
        tabbedPane.removeAll();
    }

    /**
     * <p>
     * Lord the property of the namespace, this is a sub-method of the ctor2.
     * </p>
     *
     * @throws ConfigurationException
     *             when errors occur.
     */
    private void loadProperty() throws ConfigurationException {
        // set the property.
        maxOpenTabs = configGetInt("max_open_tabs", MAX_OPEN_TABS);
        if (maxOpenTabs <= 0) {
            throw new ConfigurationException("The maxOpenTabs value should be positive");
        }

        /*
         * BugFix: BUGID UML-7690 Description: When scrolling the diagram, it takes a long time using the scroll
         * button. The interval set on the scroll pane should be bigger so that using the scroll button is easier.
         * Solution: Add an unitScrollIncrement property to configuration, set its value to zoom panel's scroll
         * bars.
         */
        unitScrollIncrement = configGetInt("default_unit_scroll_increment", DEFAULT_UNIT_SCROLL_INCREMENT);
        if (unitScrollIncrement <= 0) {
            throw new ConfigurationException("The unitScrollIncrement value should be positive");
        }

        tabTitleDisplayedInFullVersion =
            configGetBool("tab_title_displayed_in_full_version", TAB_TITLE_DISPLAYED_IN_FULL_VERSION);
        tabShortenedTitleMaxLength =
            configGetInt("tab_shortened_title_max_length", TAB_SHORTENED_TITLE_MAX_LENGTH);
        if (tabShortenedTitleMaxLength <= 0) {
            throw new ConfigurationException("The tabShortenedTitleMaxLength value should  be positive");
        }

        backgroundGridVisible = configGetBool("background_grid_visibility", BACKGROUND_GRID_VISIBILITY);

        diagramBackgroundColor = configGetCol("diagram_view_background_color", DIAGRAM_VIEW_BACKGROUND_COLOR);

        /*
         * BugFix: BUGID UML-7154 Description: The zoom factor should have been a double. This needs to be updated.
         */
        // old code
        // zoomRotateIncrement = configGetInt("zoom_rotate_increment", ZOOM_ROTATE_INCREMENT);
        zoomRotateIncrement = configGetDouble("zoom_rotate_increment", ZOOM_ROTATE_INCREMENT);
        if (zoomRotateIncrement < 0) {
            throw new ConfigurationException("The zoomRotateIncrement value should not be negative");
        }
        diagramViewGap = configGetInt("diagram_view_gap", DIAGRAM_VIEW_GAP);
        if (diagramViewGap < 0) {
            throw new ConfigurationException("The diagramViewGapt value should not be negative");
        }

    }

    /**
     * <p>
     * Lord the Object,e.g,cache and gridRenderer, from the namespace, this is a sub-method of the ctor2.
     * </p>
     *
     * @throws ConfigurationException
     *             when errors occur.
     */

    private void loadObject() throws ConfigurationException {

        String factoryNamespace;
        // Load object factory namespace used by this component from the
        // ConfigManager.

        factoryNamespace =
            DVHelper.configGet(namespace, "object_factory_namespace.", DEFAULT_OBJECT_FACTORY_NAMESPACE);

        // Initialize the ObjectFactory instance for that namespace.
        ObjectFactory of;
        // Create object using ObjectFactory#createObject method.
        try {
            of = new ObjectFactory(new ConfigManagerSpecificationFactory(factoryNamespace));
        } catch (SpecificationConfigurationException e) {
            throw new ConfigurationException("SpecificationConfigurationException exception occurred"
                + " while creating ObjectFactory:" + factoryNamespace, e);
        } catch (IllegalReferenceException e) {
            throw new ConfigurationException("IllegalReferenceException exception occurred"
                + " while creating ObjectFactory:" + factoryNamespace, e);
        }

        try {
            String cache = cm.getString(namespace, "diagram_view_cache");
            if (cache == null || cache.trim().length() == 0) {
                gridRenderer = null;
            } else {
                diagramViewCache = (Cache) of.createObject(cache);
            }
        } catch (IllegalArgumentException e) {
            throw new ConfigurationException("errors occur when create object diagramViewCache.", e);
        } catch (InvalidClassSpecificationException e) {
            throw new ConfigurationException("errors occur when create object diagramViewCache.", e);
        } catch (UnknownNamespaceException e) {
            throw new ConfigurationException("errors occur when create object diagramViewCache.", e);
        }

        try {
            String grid = cm.getString(namespace, "grid_renderer");
            if (grid == null || grid.trim().length() == 0) {
                gridRenderer = DEFAULT_GRIDRENDERER;
            } else {
                gridRenderer = (GridRenderer) of.createObject(grid);
            }
        } catch (IllegalArgumentException e) {
            throw new ConfigurationException("errors occur when create object gridRenderer.", e);
        } catch (InvalidClassSpecificationException e) {
            throw new ConfigurationException("errors occur when create object gridRenderer.", e);
        } catch (UnknownNamespaceException e) {
            throw new ConfigurationException("errors occur when create object gridRenderer.", e);
        }

    }

    /**
     * <p>
     * Lord the action from the namespace, e.g, closeTabAction, zoomIn/OutAction.
     * </p>
     *
     * @throws ConfigurationException
     *             when errors occur.
     */
    private void loadAction() throws ConfigurationException {

        closeTabAction =
            new CloseTabAction(DVHelper.configGet(namespace, "close_tab_action_namespace",
                DEFAULT_CLOSE_TAB_ACTION_NAMESPACE), this);
        zoomInAction =
            new ZoomAction(DVHelper.configGet(namespace, "zoom_in_action_namespace",
                DEFAULT_ZOOM_IN_ACTION_NAMESPACE), this);
        zoomOutAction =
            new ZoomAction(DVHelper.configGet(namespace, "zoom_out_action_namespace",
                DEFAULT_ZOOM_OUT_ACTION_NAMESPACE), this);
    }

    /**
     * <p>
     * configGetInt of namespace, if the property loads fail , return the defaultValue.
     * </p>
     *
     * @param property
     *            the property will be loaded.
     * @param defaultValue
     *            the defaultValue of the property.
     * @return the value loaded from namespace ,if fail , return defaultValue
     * @throws ConfigurationException
     *             if the error occurs.
     */
    private final int configGetInt(String property, String defaultValue) throws ConfigurationException {
        try {
            return Integer.parseInt(DVHelper.configGet(namespace, property, defaultValue));
        } catch (NumberFormatException e) {
            throw new ConfigurationException("configuration error occurs when loading " + property
                + ": The number format is invalid.");
        }
    }

    /**
     * <p>
     * configGetInt of namespace, if the property loads fail , return the defaultValue.
     * </p>
     *
     * @param property
     *            the property will be loaded.
     * @param defaultValue
     *            the defaultValue of the property.
     * @return the value loaded from namespace ,if fail , return defaultValue
     * @throws ConfigurationException
     *             if the error occurs.
     */
    private final double configGetDouble(String property, String defaultValue) throws ConfigurationException {
        try {
            return Double.parseDouble(DVHelper.configGet(namespace, property, defaultValue));
        } catch (NumberFormatException e) {
            throw new ConfigurationException("configuration error occurs when loading " + property
                + ": The number format is invalid.");
        }
    }

    /**
     * <p>
     * configGetCol of namespace, if the property loads fail , return the defaultValue.
     * </p>
     *
     * @param property
     *            the property will be loaded.
     * @param defaultValue
     *            the defaultValue of the property.
     * @return the value loaded from namespace ,if fail , return defaultValue
     * @throws ConfigurationException
     *             if the UnknownNamespaceException occurs.
     */
    private final Color configGetCol(String property, Color defaultValue) throws ConfigurationException {
        try {
            String color = cm.getString(namespace, property);
            if ((color == null) || (color.trim().length() == 0)) {
                return defaultValue;
            }
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

    /**
     * <p>
     * configGetBool of namespace, if the property loads fail , return the defaultValue.
     * </p>
     *
     * @param property
     *            the property will be loaded.
     * @param defaultValue
     *            the defaultValue of the property.
     * @return the value loaded from namespace ,if fail , return defaultValue
     * @throws ConfigurationException
     *             if the UnknownNamespaceException occurs.
     */
    private final boolean configGetBool(String property, String defaultValue) throws ConfigurationException {
        String ret = DVHelper.configGet(namespace, property, defaultValue).trim();
        if (ret.equalsIgnoreCase("true") || ret.equalsIgnoreCase("false")) {
            return Boolean.parseBoolean(ret);
        } else {
            throw new ConfigurationException("configuration error occurs when loading " + property
                + ": The bool value is invalid.");
        }
    }

    public void fireDiagramNameChanged(Diagram diagram, String newName) {
        diagramNameChangedListener.nameChanged(diagram, newName);
    }

    public void setDiagramNameChangedListener(DiagramNameChangedListener diagramNameChangedListener) {
        this.diagramNameChangedListener = diagramNameChangedListener;
    }

}

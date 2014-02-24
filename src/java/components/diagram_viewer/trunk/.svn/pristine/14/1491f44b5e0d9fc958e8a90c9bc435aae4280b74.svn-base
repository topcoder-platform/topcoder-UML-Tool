/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;

/**
 * <p>
 * This is an action class to be used to zoom in/out a ZoomPanel, it has a field
 * increment that indicates how to compute the new zoom factor when zooming, if
 * this field has a positive value, it means this is a zoom in action, else if
 * the field has a negative value, it means this is a zoom out action.
 * </p>
 * <p>
 * The button name and icon are both configurable through config manager. The
 * property for button name is "name", the property for icon is "icon". When
 * instantiating these two properties are loaded using ConfigManager.
 * </p> *
 * <p>
 * <b>Sample Configuration:</b>
 * </p>
 *
 * <pre>
 *
 *         &lt;Config name=&quot;com.topcoder.gui.diagramviewer.ZoomAction&quot;&gt;
 *             &lt;Property name=&quot;name&quot;&gt;
 *                 &lt;Value&gt;zoom action&lt;/Value&gt;
 *             &lt;/Property&gt;
 *
 *             &lt;Property name=&quot;icon&quot;&gt;
 *                 &lt;Value&gt;com.topcoder.gui.diagramviewer.zoom.icon&lt;/Value&gt;
 *             &lt;/Property&gt;
 *
 *             &lt;Property name=&quot;increment&quot;&gt;
 *                 &lt;Value&gt;0&lt;/Value&gt;
 *             &lt;/Property&gt;
 *         &lt;/Config&gt;
 *
 * </pre>
 *
 * <p>
 * Thread safety: This class is immutable, but the super class is mutable so
 * this class is not thread safe.
 * </p>
 *
 * @author kakarotto, TCSDEVELOPER
 * @version 1.0
 */
public class ZoomAction extends AbstractAction {

    /**
     * Represents the default coin.
     */
    private static final String DEFAULT_ICON = "com/topcoder/gui/diagramviewer/zoom.icon";

    /**
     * Represents the default name.
     */
    private static final String DEFAULT_NAME = "close tab";

    /**
     * Represents the default increment.
     */
    private static final String DEFAULT_INCREMENT = "0";

    /**
     * <p>
     * Represents the DiagramViewer that holds this action.
     * </p>
     * <p>
     * Initialized in ctor and never changed. Can not be null. Can be accessed
     * by getter.
     * </p>
     */
    private final DiagramViewer diagramViewer;

    /**
     * <p>
     * Represents the increment of the zoom factor, is used when zooming.
     * </p>
     * <p>
     * Initialized in ctor. Positive value makes this action to a zoom in
     * action, negative value makes it a zoom out action. Zero is acceptable,
     * indicates nothing will happen when this action is performed. Can be
     * accessed by getter and setter.
     * </p>
     */
    /*
	 * BugFix: BUGID UML-7154
	 * Description:
	 * The zoom factor should have been a double.  This needs to be updated.
	 */
    // old code
//    private int increment;
    private double increment;

    /**
     * <p>
     * Creates an instance using the default namespace: the full name of this
     * class. Also assigns the passing DiagramViewer to field diagramViewer.
     * </p>
     *
     * @param viewer the DiagramViewer that creates this action
     * @throws IllegalArgumentException if any of the args is null
     * @throws ConfigurationException when errors occur.
     */
    public ZoomAction(DiagramViewer viewer) throws ConfigurationException {
        this(ZoomAction.class.getName(), viewer);
    }

    /**
     * <p>
     * Creates an instance by loading the configuration properties from the
     * given namespace. The properties are loaded from ConfigManager. Since
     * every property of this component is optional, if any property is missed
     * then the corresponding field will be set to default value (see fields doc
     * for details).
     * </p>
     * <p>
     * If error occurs when using ConfigManager or ObjectFactory, wrap it to a
     * ConfigurationException and throw.
     * </p>
     *
     * @param namespace the configuration namespace
     * @param viewer the DiagramViewer that creates this action
     * @throws ConfigurationException when errors occur
     * @throws IllegalArgumentException if any of the args is null
     */
    public ZoomAction(String namespace, DiagramViewer viewer) throws ConfigurationException {
        super(DVHelper.configGet(namespace, "name", DEFAULT_NAME), new ImageIcon(DVHelper.configGet(namespace, "icon",
                DEFAULT_ICON)));
        DVHelper.validateNotNull(viewer, "viewer");
        try {
        	/*
        	 * BugFix: BUGID UML-7154
        	 * Description:
        	 * The zoom factor should have been a double.  This needs to be updated.
        	 */
            // old code
//            this.increment = Integer.parseInt(DVHelper.configGet(namespace, "increment", DEFAULT_INCREMENT));
        	this.increment = Double.parseDouble(DVHelper.configGet(namespace, "increment", DEFAULT_INCREMENT));
        } catch (NumberFormatException e) {
            throw new ConfigurationException("NumberFormatException occurs when get the value of increment", e);
        }
        this.diagramViewer = viewer;
    }

    /**
     * <p>
     * Trigger a ZoomEvent for the DiagramView contained in currently enabled
     * tab of the DiagramViewer.
     * </p>
     *
     * @param event the action event (ignore null)
     */
    public void actionPerformed(ActionEvent event) {
        diagramViewer.fireZoom(increment);
    }

    /**
     * <p>
     * Setter of increment, see field for explanation.
     * </p>
     *
     * @param increment the new increment
     */
    /*
	 * BugFix: BUGID UML-7154
	 * Description:
	 * The zoom factor should have been a double.  This needs to be updated.
	 */
    // old code
//    public void setIncrement(int increment) {
    public void setIncrement(double increment) {
        this.increment = increment;
    }

    /**
     * <p>
     * Getter of increment, see field for explanation.
     * </p>
     *
     * @return the increment of the zoom factor
     */
    /*
	 * BugFix: BUGID UML-7154
	 * Description:
	 * The zoom factor should have been a double.  This needs to be updated.
	 */
    // old code
//    public int getIncrement() {
    public double getIncrement() {
        return this.increment;
    }

    /**
     * <p>
     * Getter of diagramViewer, see field doc for explanation.
     * </p>
     *
     * @return the DiagramViewer that holds this action
     */
    public DiagramViewer getDiagramViewer() {
        return diagramViewer;
    }
}

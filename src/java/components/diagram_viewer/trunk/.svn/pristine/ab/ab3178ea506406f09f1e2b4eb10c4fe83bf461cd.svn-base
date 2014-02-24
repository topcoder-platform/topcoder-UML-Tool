/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;

/**
 * <p>
 * This is an action class to be used to create a button on the bottom bar of
 * the DiagramViewer, this button is used to close the currently enabled diagram
 * tab.
 * </p>
 * <p>
 * The button name and icon are both configurable through config manager. The
 * property for button name is "name", the property for icon is "icon". When
 * instantiating these two properties are loaded using ConfigManager.
 * </p>
 * <p>
 * Thread safety: This class is immutable, but the super class is mutable so
 * this class is not thread safe.
 * </p>
 * <p>
 * <b>Sample Configuration:</b>
 * </p>
 *
 * <pre>
 *       &lt;!-- Configure the Close Tab Button --&gt;
 *           &lt;Config name=&quot;com.topcoder.gui.diagramviewer.CloseTabAction&quot;&gt;
 *               &lt;Property name=&quot;name&quot;&gt;
 *                   &lt;Value&gt;close tab&lt;/Value&gt;
 *               &lt;/Property&gt;
 *
 *               &lt;Property name=&quot;icon&quot;&gt;
 *                   &lt;Value&gt;com/topcoder/gui/diagramviewer/close.icon&lt;/Value&gt;
 *               &lt;/Property&gt;
 *           &lt;/Config&gt;
 * </pre>
 *
 * @author kakarotto, TCSDEVELOPER
 * @version 1.0
 */
public class CloseTabAction extends AbstractAction {

    /**
     * Represents the default coin.
     */
    private static final String DEFAULT_ICON = "com/topcoder/gui/diagramviewer/close.icon";

    /**
     * Represents the default name.
     */
    private static final String DEFAULT_NAME = "close tab";

    /**
     * <p>
     * Represents the DiagramViewer that holds this action. This action will
     * close the current opened tab of this viewer when performed.
     * </p>
     * <p>
     * Initialized in ctor and never changed. Can not be null. Can be accessed
     * by getter.
     * </p>
     */
    private final DiagramViewer diagramViewer;

    /**
     * <p>
     * Creates an instance using the default namespace: the full name of this
     * class. Also assigns the passing DiagramViewer to field diagramViewer.
     * </p>
     *
     * @param viewer the DiagramViewer that creates this action
     * @throws IllegalArgumentException if any of the args is null
     * @throws ConfigurationException if a configuration error occurs
     */
    public CloseTabAction(DiagramViewer viewer) throws ConfigurationException {
        this(CloseTabAction.class.getName(), viewer);
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
     * @throws IllegalArgumentException if any of the args is null,and namespace
     *             in empty.
     * @throws ConfigurationException if a configuration error occurs
     */
    public CloseTabAction(String namespace, DiagramViewer viewer) throws ConfigurationException {
        super(DVHelper.configGet(namespace, "name", DEFAULT_NAME), new ImageIcon(DVHelper.configGet(namespace, "icon",
                DEFAULT_ICON)));
        DVHelper.validateNotNull(viewer, "viewer");
        this.diagramViewer = viewer;
    }

    /**
     * <p>
     * Close currently enabled diagram tab of the DiagramViewer.
     * </p>
     *
     * @param event the action event (ignore null)
     */
    public void actionPerformed(ActionEvent event) {
        diagramViewer.closeCurrentDiagramView();
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

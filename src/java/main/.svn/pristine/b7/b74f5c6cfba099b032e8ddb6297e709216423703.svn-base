/*
 * Copyright (C) 2013 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.actions;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.util.Properties;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JOptionPane;

import com.topcoder.umltool.deploy.DeployHelper;
import com.topcoder.umltool.deploy.MainFrame;
import com.topcoder.umltool.deploy.menus.EmptyIcon;

/**
 * <p>
 * About action to display about information.
 * </p>
 *
 * <p>
 * <strong>Changes:</strong><br/>
 * Made application version and copyright year configurable.
 * </p>
 *
 * @author ly, FireIce, ylouis, gevak
 * @version 1.0
 */
public class AboutAction extends AbstractAction {
    /**
     * <p>
     * Version property file path.
     * </p>
     */
    private static final String VERSION_PROPERTY_FILE_PATH = "conf" + File.separator + "Version.properties";

    /**
     * <p>
     * Default copyright year.
     * </p>
     */
    private static final String COPYRIGHT_YEAR_DEFAULT_VALUE = "<unknown year>";

    /**
     * <p>
     * Default version.
     * </p>
     */
    private static final String VERSION_DEFAULT_VALUE = "<unknown version>";

    /**
     * <p>
     * Copyright year property name.
     * </p>
     */
    private static final String COPYRIGHT_YEAR_PROPERTY_NAME = "copyrightYear";

    /**
     * <p>
     * Version property name.
     * </p>
     */
    private static final String VERSION_PROPERTY_NAME = "version";

    /**
     * <p>
     * The version id.
     * <p>
     */
    private static final long serialVersionUID = -2873752707169317598L;

    /**
     * <p>
     * Action name.
     * <p>
     */
    private static final String ACTION_NAME = "About";

    /**
     * <p>
     * Action description.
     * <p>
     */
    private static final String SHORT_DESCRIPTION = "About...";

    /**
     * <p>
     * Reference to main frame.
     * <p>
     */
    private final MainFrame mainFrame;

    /**
     * <p>
     * Version.
     * </p>
     */
    private final String version;

    /**
     * <p>
     * Copyright year.
     * </p>
     */
    private final String copyrightYear;

    /**
     * <p>
     * Constructs an instance of about action.
     * <p>
     * @param mainFrame
     *            main frame of uml tool
     */
    public AboutAction(MainFrame mainFrame) {
        super(ACTION_NAME, EmptyIcon.ICON_16);
        this.putValue(Action.SHORT_DESCRIPTION, SHORT_DESCRIPTION);

        this.mainFrame = mainFrame;

        // Load version information.
        Properties versionProperties = null;
        try {
            versionProperties = DeployHelper.loadProperties(VERSION_PROPERTY_FILE_PATH);
        } catch (IOException ex) {
            versionProperties = new Properties();
        }
        version = versionProperties.getProperty(VERSION_PROPERTY_NAME, VERSION_DEFAULT_VALUE);
        copyrightYear = versionProperties.getProperty(COPYRIGHT_YEAR_PROPERTY_NAME, COPYRIGHT_YEAR_DEFAULT_VALUE);
    }

    /**
     * <p>
     * Performing the action.
     * <p>
     * @param actionEvent
     *            the action event
     */
    public void actionPerformed(ActionEvent actionEvent) {
        JOptionPane.showMessageDialog(mainFrame, "TopCoder UML Tool " + version + " (c) "
                + copyrightYear + " TopCoder, Inc.", "About", JOptionPane.INFORMATION_MESSAGE);

    }
}

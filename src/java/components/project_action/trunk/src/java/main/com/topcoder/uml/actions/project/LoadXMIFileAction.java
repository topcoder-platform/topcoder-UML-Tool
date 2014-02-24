/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.project;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.uml.projectconfiguration.ProjectConfigurationManager;
import com.topcoder.util.actionmanager.Action;
import com.topcoder.util.actionmanager.ActionExecutionException;

/**
 * <p>
 * <code>LoadXMIFileAction</code> creates a new project and loads the XMI file. It uses XMI Reader component
 * to parse the contents into the UML Model. The default project language from
 * <code>ProjectConfigurationManager</code> is used, if the &quot;ProjectLanguage&quot; value is missing in
 * the model manager.
 * </p>
 * <p>
 * <b>Thread-safety: </b>This class is immutable, but it would change it internal state of the
 * <code>UMLModelManager</code> object, so it is not thread-safe.
 * </p>
 *
 * @author standlove, TCSDEVELOPER
 * @version 1.0
 */
public class LoadXMIFileAction implements Action {

    /**
     * <p>
     * Represents the xmi file to load in the execute method to populate the <code>UMLModelManager</code>
     * object. Initialized in the constructor, and this reference is never changed afterwards. It must be
     * non-null.
     * </p>
     */
    private final File xmiFile;

    /**
     * <p>
     * Represents the <code>UMLModelManager</code> object processed by this action in execute method, its internal state
     * would be changed after execution. Initialized in the constructor, and this reference is never changed
     * afterwards. It must be non-null.
     * </p>
     */
    private final UMLModelManager modelManager;

    /**
     * <p>
     * Represents the <code>ProjectConfigurationManager</code> object to get the default language in the
     * execute method. Initialized in the constructor, and this reference is never changed afterwards. It must
     * be non-null.
     * </p>
     */
    private final ProjectConfigurationManager configManager;

    /**
     * <p>
     * Creates the instance with the xmi file, the <code>UMLModelManager</code> object and the
     * <code>ProjectConfigurationManager</code> object.
     * </p>
     *
     * @param xmiFile
     *            the xmi file to load in the execute method to populate the UMLModelManager object.
     * @param modelManager
     *            the UMLModelManager object processed by this action
     * @param configManager
     *            the ProjectConfigurationManager object to get the default language
     * @throws IllegalArgumentException
     *             if any argument is null, or the xmiFile doesn't exist.
     */
    public LoadXMIFileAction(File xmiFile, UMLModelManager modelManager, ProjectConfigurationManager configManager) {
        // check if xmiFile is null
        Helper.checkObjectNotNull(xmiFile, "xmiFile in LoadXMIFileAction#LoadXMIFileAction");
        // check if modelManager is null
        Helper.checkObjectNotNull(modelManager, "modelManager in LoadXMIFileAction#LoadXMIFileAction");
        // check if configManager is null
        Helper.checkObjectNotNull(configManager, "configManager in LoadXMIFileAction#LoadXMIFileAction");
        if (!xmiFile.exists() || !xmiFile.isFile()) {
            throw new IllegalArgumentException("xmiFile does not exist or it is not a file");
        }
        this.xmiFile = xmiFile;
        this.modelManager = modelManager;
        this.configManager = configManager;
    }

    /**
     * <p>
     * Creates a new project and loads the XMI file. It will use XMI Reader component to parse the contents
     * into the UML Model. After that, it will get the Model from the <code>UMLModelManager</code> and check
     * if it has a &quot;ProjectLanguage&quot; <code>TagDefinition</code>. It will get the tag value and
     * set it in the <code>UMLModelManager</code>. The default project language from
     * <code>ProjectConfigurationManager</code> is used, if this value is missing.
     * </p>
     *
     * @throws ActionExecutionException
     *             Any exception occurs during the execution, it is mainly used to wrap the all possible
     *             underlying exceptions.
     */
    public void execute() throws ActionExecutionException {
        InputStream stream = null;
        try {
            stream = new FileInputStream(xmiFile);
            // load the XMI file
            Helper.loadXMIFile(modelManager, stream, configManager);
        } catch (FileNotFoundException e) {
            throw new ActionExecutionException("The passed XMI file does not exist", e);
        } finally {
            // close the stream
            try {
                if (stream != null) {
                    stream.close();
                }
            } catch (IOException e) {
                throw new ActionExecutionException("Occurred while closing the file stream", e);
            }
        }
    }
}

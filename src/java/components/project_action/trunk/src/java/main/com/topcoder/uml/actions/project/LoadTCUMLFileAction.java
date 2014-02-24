/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.project;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;

import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.uml.projectconfiguration.ProjectConfigurationManager;
import com.topcoder.util.actionmanager.Action;
import com.topcoder.util.actionmanager.ActionExecutionException;

/**
 * <p>
 * <code>LoadTCUMLFileAction</code> creates a new project and loads the TCUML file, by unzipping it and
 * loading the XMI file inside.
 * </p>
 * <p>
 * <b>Thread-safety: </b>This class is immutable, but it would change it internal state of the
 * <code>UMLModelManager</code> object, so it is not thread-safe.
 * </p>
 *
 * @author standlove, TCSDEVELOPER
 * @version 1.0
 */
public class LoadTCUMLFileAction implements Action {

    /**
     * <p>
     * Represents the tc uml file to load in the execute method to populate the <code>UMLModelManager</code>
     * object. Initialized in the constructor, and this reference is never changed afterwards. It will be
     * non-null.
     * </p>
     */
    private final File tcUMLFile;

    /**
     * <p>
     * Represents the <code>UMLModelManager</code> object processed by this action in execute method, its
     * internal state would be changed after execution. Initialized in the constructor, and this reference is
     * never changed afterwards. It will be non-null.
     * </p>
     */
    private final UMLModelManager modelManager;

    /**
     * <p>
     * Represents the <code>ProjectConfigurationManager</code> object to get the default language in the execute method.
     * Initialized in the constructor, and this reference is never changed afterwards. It must be non-null.
     * </p>
     */
    private final ProjectConfigurationManager configManager;

    /**
     * <p>
     * Creates the instance with tc uml file to load, the <code>UMLModelManager</code> object and the
     * <code>ProjectConfigurationManager</code> object.
     * </p>
     *
     * @param tcUMLFile
     *            the tc uml file to load in the execute method to populate the UMLModelManager object.
     * @param modelManager
     *            the UMLModelManager object processed by this action
     * @param configManager
     *            the ProjectConfigurationManager object to get the default language
     * @throws IllegalArgumentException
     *             if any argument is null, or the tcUMLFile doesn't exist.
     */
    public LoadTCUMLFileAction(File tcUMLFile, UMLModelManager modelManager,
            ProjectConfigurationManager configManager) {
        // check if tcUMLFile is null
        Helper.checkObjectNotNull(tcUMLFile, "tcUMLFile in LoadTCUMLFileAction#LoadTCUMLFileAction");
        // check if modelManager is null
        Helper.checkObjectNotNull(modelManager, "modelManager in LoadTCUMLFileAction#LoadTCUMLFileAction");
        // check if configManager is null
        Helper.checkObjectNotNull(configManager, "configManager in LoadTCUMLFileAction#LoadTCUMLFileAction");
        if (!tcUMLFile.exists()) {
            throw new IllegalArgumentException("The tcUMLFile passed does not exist");
        }
        if (tcUMLFile.isDirectory()) {
            throw new IllegalArgumentException("The tcUMLFile passed should not be a directory");
        }
        this.tcUMLFile = tcUMLFile;
        this.modelManager = modelManager;
        this.configManager = configManager;
    }

    /**
     * <p>
     * Creates a new project and loads the TCUML file, by unzipping it and loading the XMI file inside.
     * </p>
     *
     * @throws ActionExecutionException
     *             if there is no ZipEntry with name ending with ".xmi", or any exception occurs during the
     *             execution, it is mainly used to wrap the all possible underlying exceptions.
     */
    public void execute() throws ActionExecutionException {
        // create a zipfile object from the given file
        ZipFile zipFile = null;
        try {
            zipFile = new ZipFile(tcUMLFile);
            // get all the files present inside the zipfile
            Enumeration<? extends ZipEntry> enumeration = zipFile.entries();
            InputStream stream = null;
            // run through each element
            while (enumeration.hasMoreElements()) {
                ZipEntry entry = enumeration.nextElement();
                // if a file with .xmi exists create a stream from that and exit
                // the loop
                if (entry.getName().endsWith(".xmi")) {
                    stream = zipFile.getInputStream(entry);
                    break;
                }
            }
            // if there is no such file
            if (stream == null) {
                throw new ActionExecutionException("The UML file should contain a xmi file");
            }
            // load the XMI file.
            Helper.loadXMIFile(modelManager, stream, configManager);
        } catch (ZipException e) {
            throw new ActionExecutionException("Occurred while extracting the files from the UML file", e);
        } catch (IOException e) {
            throw new ActionExecutionException(
                    "Occurred while getting the .xmi file from the Zipped UML file");
        } catch (Exception e) {
            throw new ActionExecutionException("Occurred while loading the TCUML file", e);
        } finally {
            // close the zip file
            try {
                if (zipFile != null) {
                    zipFile.close();
                }
            } catch (IOException e) {
                throw new ActionExecutionException("Occurred while getting the closing the zip file");
            }
        }

    }
}

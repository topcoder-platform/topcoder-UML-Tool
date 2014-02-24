/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.project;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.util.actionmanager.ActionExecutionException;
import com.topcoder.util.actionmanager.TransientAction;
import com.topcoder.xmi.writer.XMIWriter;

/**
 * <p>
 * <code>SaveTCUMLFileAction</code> saves the project to a TCUML file, which is a zip file containing the
 * actual XMI file inside. It contains a flag to indicate the diagram data should be saved to the file or not.
 * </p>
 * <p>
 * <b>Thread-safety: </b>This class is immutable, and it wouldn't change it internal state of the
 * <code>UMLModelManager</code> object, but it may fail you we save to the same file from different threads
 * at the same time, so it is not completely thread-safe.
 * </p>
 *
 * @author standlove, TCSDEVELOPER
 * @version 1.0
 */
public class SaveTCUMLFileAction implements TransientAction {

    /**
     * <p>
     * Represents the tc uml file to save the xmi data to in the execute method. Initialized in the
     * constructor, and this reference is never changed afterwards. It must be non-null.
     * </p>
     */
    private final File tcUMLFile;

    /**
     * <p>
     * Represents a boolean value indicating the diagram data should be saved or not in the execute method.
     * Initialized in the constructor, and this reference is never changed afterwards.
     * </p>
     */
    private final boolean withDiagramData;

    /**
     * <p>
     * Represents the <code>UMLModelManager</code> object processed by this action in execute method, its internal state
     * wouldn't be changed after execution. Initialized in the constructor, and this reference is never
     * changed afterwards. It must be non-null.
     * </p>
     */
    private final UMLModelManager modelManager;

    /**
     * <p>
     * Constructs the Instance with tc uml file to save to, a boolean flag and the <code>UMLModelManager</code> object.
     * If the tcUMLFile doesn't exist, a new file will be
     * created, if it already exists, the old one will be overwritten.
     * </p>
     *
     * @param tcUMLFile
     *            the tc uml file to save the xmi data to
     * @param withDiagramData
     *            a boolean value indicating the diagram data should be saved or not
     * @param modelManager
     *            the UMLModelManager object processed by this action
     * @throws IllegalArgumentException
     *             if tcUMLFile or modelManager argument is null.
     */
    public SaveTCUMLFileAction(File tcUMLFile, boolean withDiagramData, UMLModelManager modelManager) {
        // check if tcUMLFile is null
        Helper.checkObjectNotNull(tcUMLFile, "tcUMLFile in SaveTCUMLFileAction#SaveTCUMLFileAction");
        // check if modelManager is null
        Helper.checkObjectNotNull(modelManager, "modelManager in SaveTCUMLFileAction#SaveTCUMLFileAction");
        this.tcUMLFile = tcUMLFile;
        this.withDiagramData = withDiagramData;
        this.modelManager = modelManager;
    }

    /**
     * <p>
     * Saves the project to a TCUML file, which is a zip file containing the actual XMI file inside. It
     * contains a flag to indicate the diagram data should be saved to the file or not. If the tcUMLFile
     * doesn't exist, a new file will be created, if it already exists, the old one will be overwritten.
     * </p>
     *
     * @throws ActionExecutionException
     *             if any exception occurs during the execution, it is mainly used to wrap the all possible
     *             underlying exceptions.
     */
    public void execute() throws ActionExecutionException {
        ZipOutputStream zipOutputStream = null;
        FileOutputStream outputStream = null;
        try {
            // create a ZipOutputStream for the given tcUMLFile
            outputStream = new FileOutputStream(tcUMLFile);
            zipOutputStream = new ZipOutputStream(outputStream);
            // add a Zip entry with the filename extension .xmi
            zipOutputStream.putNextEntry(new ZipEntry(fileName()));
            // create XMIwriter with all the Transformers
            XMIWriter writer = new XMIWriter(modelManager, Helper.xmiTransformers());
            // transforms the model manager and writes into the stream
            writer.transform(zipOutputStream, withDiagramData);
        } catch (FileNotFoundException e) {
            throw new ActionExecutionException(
                    "Occurred while creating the zip output stream on the TCUMLfile", e);
        } catch (IOException e) {
            throw new ActionExecutionException("Occurred while creating a new Zip entry", e);
        } catch (Exception e) {
            throw new ActionExecutionException("Occurred while saving the data into the XMI file", e);
        } finally {
            // close the stream.
            try {
                if (zipOutputStream != null) {
                    zipOutputStream.close();
                }
            } catch (IOException e) {
                throw new ActionExecutionException("Occurred while closing the Zip output stream", e);
            }
        }
    }

    /**
     * <p>
     * Returns the name consisting of the name of the tcUMLFile (without extension) + &quot;.xmi&quot;. e.g.
     * if tcUMLFile's name is: project_action.zuml, then the name is project_action.xmi.
     * <p>
     * </p>
     * Only the last extension will be removed, e.g. if the tcUMLFile's name is project.test.zuml, then the
     * name is project.test.xmi. if the tcUMLFile's name doesn't have an extension, it will simply append the
     * &quot;.xmi&quot; to it to generate the name.
     * </p>
     *
     * @return the .xmi file name created from the tcUMLFile name.
     */
    private String fileName() {
        String string = tcUMLFile.getName();
        if (string.lastIndexOf(".") != -1) {
            return string.substring(0, string.lastIndexOf(".")) + ".xmi";
        } else {
            return string + ".xmi";
        }
    }
}

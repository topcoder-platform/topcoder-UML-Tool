/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.project;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.util.actionmanager.ActionExecutionException;
import com.topcoder.util.actionmanager.TransientAction;
import com.topcoder.xmi.writer.XMIWriter;

/**
 * <p>
 * <code>ExportToXMIFileAction</code> will saves the project to an XMI file. It will use XMI Writer
 * component to transform the UML Model to XMI. It contains a flag to indicate the diagram data should be
 * saved to the file or not.
 * </p>
 * <p>
 * <b>Thread-safety: </b>This class is immutable, and it wouldn't change it internal state of the
 * <code>UMLModelManager</code> object, but it may fail if we save to the same file from different threads
 * at the same time, so it is not completely thread-safe.
 * </p>
 *
 * @author standlove, TCSDEVELOPER
 * @version 1.0
 */
public class ExportToXMIFileAction implements TransientAction {

    /**
     * <p>
     * Represents the xmi file to save the xmi data to in the execute method. Initialized in the constructor,
     * and this reference is never changed afterwards. It must be non-null.
     * </p>
     */
    private final File xmiFile;

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
     * Constructs the instance with the xmi file, a boolean flag and the <code>UMLModelManager</code> object. If the
     * tcUMLFile doesn't exist, a new file will be created, if it already exists, the old one will be overwritten.
     * </p>
     *
     * @param xmiFile
     *            the xmi file to save the xmi data.
     * @param withDiagramData
     *            a boolean value indicating the diagram data should be saved or not
     * @param modelManager
     *            the <code>UMLModelManager</code> object processed by this action
     * @throws IllegalArgumentException
     *             if xmiFile or modelManager argument is null.
     */
    public ExportToXMIFileAction(File xmiFile, boolean withDiagramData, UMLModelManager modelManager) {
        // check if xmiFile is null
        Helper.checkObjectNotNull(xmiFile, "xmiFile in ExportToXMIFileAction#ExportToXMIFileAction");
        // check if modelManager is null
        Helper.checkObjectNotNull(modelManager, "modelManager in ExportToXMIFileAction#ExportToXMIFileAction");
        this.xmiFile = xmiFile;
        this.withDiagramData = withDiagramData;
        this.modelManager = modelManager;
    }

    /**
     * <p>
     * Saves the project to an XMI file. It will use XMI Writer component to transform the UML Model to XMI. It
     * contains a flag to indicate the diagram data should be saved to the file or not. If the tcUMLFile
     * doesn't exist, a new file will be created, if it already exists, the old one will be overwritten.
     * </p>
     *
     * @throws ActionExecutionException
     *             if any exception occurs during the execution, it is mainly used to wrap the all possible
     *             underlying exceptions.
     */
    public void execute() throws ActionExecutionException {
        FileOutputStream stream = null;
        try {
            // Output stream from the XMI file
            stream = new FileOutputStream(xmiFile);
            // create XMIwriter with all the Transformers
            XMIWriter writer = new XMIWriter(modelManager, Helper.xmiTransformers());
            // transform the model manager and write the data into the file stream
            writer.transform(stream, withDiagramData);
        } catch (FileNotFoundException e) {
            throw new ActionExecutionException("Occurred while creating the File Output stream from the xmiFile", e);
        } catch (Exception e) {
            throw new ActionExecutionException("Occurred while writing the data into the XMI file", e);
        } finally {
            try {
                if (stream != null) {
                    stream.close();
                }
            } catch (IOException e) {
                throw new ActionExecutionException("Occurred while closing the File Output stream", e);
            }
        }
    }
}

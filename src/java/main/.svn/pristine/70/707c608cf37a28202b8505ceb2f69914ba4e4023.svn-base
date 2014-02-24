/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.backend.xmi.reader;

import com.topcoder.umltool.backend.xmi.reader.XMI2ModelHandlerAdapter;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.xmi.reader.XMIReader;
import com.topcoder.xmi.reader.handlers.modelfactory.ConfigurationException;
import com.topcoder.xmi.reader.handlers.modelfactory.ModelElementFactory;
import com.topcoder.xmi.reader.handlers.uml.activitygraph.ActivityGraphXMIHandler;

/**
 * <p>
 * This class serves as an adapter for an {@link ActivityGraphXMIHandler}.
 * </p>
 * <p>
 * A new {@link ActivityGraphXMIHandlerAdapter} will be created using the following things:
 * <ol>
 * <li>The {@link XMIReader} provided to the constructor</li>
 * <li>A {@link ModelElementFactory} from a default namespace {@link ActivityGraphXMIHandlerAdapter#NAMESPACE}</li>
 * <li>The {@link UMLModelManager} singleton instance</li>
 * </ol>
 * </p>
 *
 * @author hanno, evilisneo
 * @version 1.0
 */
public class ActivityGraphXMIHandlerAdapter extends ActivityGraphXMIHandler {
    /**
     * <p>
     * The namespace containing the configuration.
     * </p>
     */
    public static final String NAMESPACE = XMIReader.class.getName() + "_activityGraph";

    /**
     * <p>
     * Creates a new {@link ActivityGraphXMIHandlerAdapter} using the given {@link XMIReader}. The new
     * {@link ActivityGraphXMIHandlerAdapter} will use a {@link ModelElementFactory} created from the namespace
     * {@link XMI2ModelHandlerAdapter#NAMESPACE} and the singleton instance of {@link UMLModelManager}.
     * </p>
     *
     * @param xmiReader
     *            The {@link XMIReader} using this {@link ActivityGraphXMIHandlerAdapter}
     * @throws ConfigurationException
     *             if there were any issues with configuration
     */
    public ActivityGraphXMIHandlerAdapter(XMIReader xmiReader) throws ConfigurationException {
        super(xmiReader, new ModelElementFactory(NAMESPACE), UMLModelManager.getInstance());
    }
}

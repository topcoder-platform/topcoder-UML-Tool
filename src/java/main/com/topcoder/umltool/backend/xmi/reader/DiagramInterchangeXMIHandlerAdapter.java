/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.backend.xmi.reader;

import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.xmi.reader.XMIReader;
import com.topcoder.xmi.reader.handlers.diagraminterchange.DiagramInterchangeXMIHandler;
import com.topcoder.xmi.reader.handlers.modelfactory.ConfigurationException;
import com.topcoder.xmi.reader.handlers.modelfactory.ModelElementFactory;

/**
 * <p>
 * This class serves as an adapter for an {@link DiagramInterchangeXMIHandler}.
 * </p>
 * <p>
 * A new {@link DiagramInterchangeXMIHandlerAdapter} will be created using the following things:
 * <ol>
 * <li>The {@link XMIReader} provided to the constructor</li>
 * <li>A {@link ModelElementFactory} from a default namespace {@link DiagramInterchangeXMIHandlerAdapter#NAMESPACE}
 * </li>
 * <li>The {@link UMLModelManager} singleton instance</li>
 * </ol>
 * </p>
 *
 * @author hanno, evilisneo
 * @version 1.0
 */
public class DiagramInterchangeXMIHandlerAdapter extends DiagramInterchangeXMIHandler {
    /**
     * <p>
     * The namespace containing the configuration.
     * </p>
     */
    public static final String NAMESPACE = XMIReader.class.getName() + "_diagramInterchange";

    /**
     * <p>
     * Creates a new {@link DiagramInterchangeXMIHandlerAdapter} using the given {@link XMIReader}. The new
     * {@link DiagramInterchangeXMIHandlerAdapter} will use a {@link ModelElementFactory} created from the
     * namespace {@link DiagramInterchangeXMIHandlerAdapter#NAMESPACE} and the singleton instance of
     * {@link UMLModelManager}.
     * </p>
     *
     * @param xmiReader
     *            The {@link XMIReader} using this {@link DiagramInterchangeXMIHandlerAdapter}
     * @throws ConfigurationException
     *             if there were any issues with configuration
     */
    public DiagramInterchangeXMIHandlerAdapter(XMIReader xmiReader) throws ConfigurationException {
        super(xmiReader, new ModelElementFactory(NAMESPACE), UMLModelManager.getInstance());
    }
}

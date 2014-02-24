/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.backend.xmi.reader;

import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.xmi.reader.XMIReader;
import com.topcoder.xmi.reader.handlers.modelfactory.ConfigurationException;
import com.topcoder.xmi.reader.handlers.modelfactory.ModelElementFactory;
import com.topcoder.xmi.reader.handlers.uml.model.XMI2ModelHandler;

/**
 * <p>
 * This class serves as an adapter for an {@link XMI2ModelHandler}.
 * </p>
 * <p>
 * A new {@link XMI2ModelHandlerAdapter} will be created using the following things:
 * <ol>
 * <li>The {@link XMIReader} provided to the constructor</li>
 * <li>A {@link ModelElementFactory} from a default namespace {@link XMI2ModelHandlerAdapter#NAMESPACE}</li>
 * <li>The {@link UMLModelManager} singleton instance</li>
 * </ol>
 * </p>
 *
 * @author hanno, evilisneo
 * @version 1.0
 */
public class XMI2ModelHandlerAdapter extends XMI2ModelHandler {
    /**
     * <p>
     * The namespace containing the configuration.
     * </p>
     */
    public static final String NAMESPACE = XMIReader.class.getName() + "_model";

    /**
     * <p>
     * Creates a new {@link XMI2ModelHandlerAdapter} using the given {@link XMIReader}. The new
     * {@link XMI2ModelHandlerAdapter} will use a {@link ModelElementFactory} created from the namespace
     * {@link XMI2ModelHandlerAdapter#NAMESPACE} and the singleton instance of {@link UMLModelManager}.
     * </p>
     *
     * @param xmiReader
     *            The {@link XMIReader} using this {@link XMI2ModelHandler}
     * @throws ConfigurationException
     *             if there were any issues with configuration
     */
    public XMI2ModelHandlerAdapter(XMIReader xmiReader) throws ConfigurationException {
        super(xmiReader, new ModelElementFactory(NAMESPACE), UMLModelManager.getInstance());
    }
}

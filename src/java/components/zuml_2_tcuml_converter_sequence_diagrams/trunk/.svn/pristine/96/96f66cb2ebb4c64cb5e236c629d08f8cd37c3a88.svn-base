/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.xmiconverters.poseidon5.stresstests;

import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.xmi.reader.XMIReader;
import com.topcoder.xmi.reader.handlers.modelfactory.ConfigurationException;
import com.topcoder.xmi.reader.handlers.modelfactory.ModelElementFactory;
import com.topcoder.xmi.reader.handlers.uml.model.XMI2ModelHandler;

/**
 * Mock of class extends XMI2ModelHandler.
 * @author extra
 * @version 1.0
 */
public class MockXMI2ModelHandler extends XMI2ModelHandler{
    /**
     * Represents namespace 'com.topcoder.umltool.xmiconverters.poseidon5.stresstests'.
     */
    public static final String NAMESPACE = "com.topcoder.umltool.xmiconverters.poseidon5.stresstests";

    /**
     * Constructor of the class.
     * @param reader the reader to create the instance.
     * @throws ConfigurationException if any error occurs.
     */
    public MockXMI2ModelHandler(XMIReader reader) throws ConfigurationException {
        super(reader, new ModelElementFactory(NAMESPACE), UMLModelManager.getInstance());
    }
}

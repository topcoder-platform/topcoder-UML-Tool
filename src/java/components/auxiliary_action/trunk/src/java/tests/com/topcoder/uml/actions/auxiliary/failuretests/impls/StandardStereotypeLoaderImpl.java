/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 *
 * StandardStereotypeLoaderImpl.java
 */
package com.topcoder.uml.actions.auxiliary.failuretests.impls;

import com.topcoder.uml.projectconfiguration.StandardStereotypeLoader;
import com.topcoder.uml.projectconfiguration.ProjectConfigurationException;
import com.topcoder.uml.model.core.extensionmechanisms.Stereotype;

import java.util.List;
import java.util.ArrayList;

/**
 * <p>
 * Simple implementation of StandardStereotypeLoader interface. Used for testing.
 * </p>
 *
 * @author wiedzmin
 * @version 1.0
 */
public class StandardStereotypeLoaderImpl implements StandardStereotypeLoader {

    /**
     * <p>
     * Constructs StandardStereotypeLoaderImpl.
     * </p>
     */
    public StandardStereotypeLoaderImpl() {
    }

    /**
     * <p>
     * Simple implementation of getStereotypes method. Returns empty array.
     * </p>
     *
     * @param string string
     * @param string1 string1
     * @return list with Stereotypes
     * @throws ProjectConfigurationException project configuration exception.
     */
    public List<Stereotype> getStereotypes(String string, String string1) throws ProjectConfigurationException {
        return new ArrayList<Stereotype>();
    }
}

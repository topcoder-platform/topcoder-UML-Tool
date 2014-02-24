/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.trees.document;

import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.projectconfiguration.InitialElementFormatter;
import com.topcoder.uml.projectconfiguration.ProjectConfigurationException;

/**
 * <p>
 * This is a mock implementation of InitialElementFormatter interface.
 * It is only used for testing.
 * </p>
 *
 * @author biotrail
 * @version 1.0
 */
public class MockInitialElementFormatter implements InitialElementFormatter {
    /**
     * <p>
     * Implements the format(ModelElement) method.
     * </p>
     *
     * @param element the model element
     * @return true always.
     *
     * @throws ProjectConfigurationException if the value of system property
     * &quot;exception&quot; is &quot;ActionExecutionException&quot;
     */
    public boolean format(ModelElement element) throws ProjectConfigurationException {
        if ("ActionExecutionException".equals(System.getProperty("exception"))) {
            throw new ProjectConfigurationException("ActionExecutionException.");
        }
        element.setSpecification(true);
        return true;
    }

}

/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.activity;

import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.projectconfiguration.InitialElementFormatter;
import com.topcoder.uml.projectconfiguration.ProjectConfigurationException;

/**
 * <p>
 * This is a mock implementation of InitialElementFormatter interface.
 * It is only used for testing.
 * </p>
 *
 * @author TCSDEVELOPER
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
     * &quot;exception&quot; is &quot;ProjectConfigurationException&quot;
     */
    public boolean format(ModelElement element) throws ProjectConfigurationException {
        if ("ProjectConfigurationException".equals(System.getProperty("exception"))) {
            throw new ProjectConfigurationException("exception.");
        }
        element.setSpecification(true);
        return true;
    }

}

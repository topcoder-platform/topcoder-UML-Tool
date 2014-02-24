/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.diagram.failuretests;

import com.topcoder.diagraminterchange.DiagramElement;
import com.topcoder.uml.projectconfiguration.InitialDiagramElementFormatter;
import com.topcoder.uml.projectconfiguration.ProjectConfigurationException;

/**
 * <p>
 * This is a mock implementation of InitialDiagramElementFormatter used for testing.
 * </p>
 *
 * @author stylecheck
 * @version 1.0
 */
public class MockInitialDiagramElementFormatter implements InitialDiagramElementFormatter {
    /**
     * <p>
     * Implements the format method.
     * </p>
     *
     * @param element the diagram element
     * @return true.
     *
     * @throws ProjectConfigurationException if the value of system property
     * &quot;throwException&quot; is &quot;ProjectConfigurationException&quot;
     */
    public boolean format(DiagramElement element) throws ProjectConfigurationException {
        if ("ProjectConfigurationException".equals(System.getProperty("throwException"))) {
            throw new ProjectConfigurationException("Mock exception.");
        }
        return true;
    }

}

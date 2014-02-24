/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.trees.document;

import com.topcoder.diagraminterchange.DiagramElement;
import com.topcoder.uml.projectconfiguration.InitialDiagramElementFormatter;
import com.topcoder.uml.projectconfiguration.ProjectConfigurationException;

/**
 * <p>
 * This is a mock implementation of InitialDiagramElementFormatter interface.
 * It is only used for testing.
 * </p>
 *
 * @author biotrail
 * @version 1.0
 */
public class MockInitialDiagramElementFormatter implements InitialDiagramElementFormatter {
    /**
     * <p>
     * Implements the format(DiagramElement) method.
     * </p>
     *
     * @param element the diagram element
     * @return true always.
     *
     * @throws ProjectConfigurationException if the value of system property
     * &quot;exception&quot; is &quot;ProjectConfigurationException&quot;
     */
    public boolean format(DiagramElement element) throws ProjectConfigurationException {
        if ("ProjectConfigurationException".equals(System.getProperty("exception"))) {
            throw new ProjectConfigurationException("exception.");
        }
        element.setVisible(false);

        return true;
    }

}

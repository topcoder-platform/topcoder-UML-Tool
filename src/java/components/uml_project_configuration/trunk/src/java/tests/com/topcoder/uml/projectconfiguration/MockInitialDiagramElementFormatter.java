/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.projectconfiguration;

import com.topcoder.diagraminterchange.DiagramElement;

/**
 * <p>
 * This is a mock implementation of InitialDiagramElementFormatter interface.
 * It is only used for testing.
 * </p>
 *
 * @author TCSDEVELOPER
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
     */
    public boolean format(DiagramElement element) {
        return true;
    }
}

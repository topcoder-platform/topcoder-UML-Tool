/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.projectconfiguration;

import com.topcoder.diagraminterchange.DiagramElement;

/**
 * <p>
 * This interface specifies the contract for implementations of a diagram element formatter.
 * </p>
 *
 * <p>
 * This formatter will apply formatting to diagram elements.
 * </p>
 *
 * <p>
 * Thread Safety : The implementation of this interface is required to be thread safety.
 * </p>
 *
 * @author kinzz, biotrail
 * @version 1.0
 */
public interface InitialDiagramElementFormatter {
    /**
     * <p>
     * Apply formatting to the giving diagram elements.
     * </p>
     *
     *
     * @param element the non null element to be formatted.
     * @return true if the passed in object was modified, otherwise false.
     *
     * @throws IllegalArgumentException if the element is null.
     * @throws ProjectConfigurationException if any exception
     * prevent formatting the element successfully.
     */
    public boolean format(DiagramElement element) throws ProjectConfigurationException;

}

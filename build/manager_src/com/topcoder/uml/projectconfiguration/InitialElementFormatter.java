/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.projectconfiguration;

import com.topcoder.uml.model.core.ModelElement;

/**
 * <p>
 * This interface specifies the contract for implementations of a model element formatter.
 * </p>
 *
 * <p>
 * This formatter will apply formatting to model elements.
 * </P>
 *
 * <p>
 * Thread Safety : The implementation of this interface is required to be thread safety.
 * </p>
 *
 * @author kinzz, biotrail
 * @version 1.0
 */
public interface InitialElementFormatter {
    /**
     * <p>
     * Apply formatting to the given model elements.
     * </p>
     *
     *
     * @param element the non null element to be formatted.
     * @return true if the passed in object was modified, otherwise false.
     *
     * @throws IllegalArgumentException if the element is null.
     * @throws ProjectConfigurationException if any exception prevent formatting the element successfully
     */
    public boolean format(ModelElement element) throws ProjectConfigurationException;

}

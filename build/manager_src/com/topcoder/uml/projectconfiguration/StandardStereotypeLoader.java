/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.projectconfiguration;

import java.util.List;

import com.topcoder.uml.model.core.extensionmechanisms.Stereotype;

/**
 * <p>
 * This interface specifies the contract for implementations of a stereotype loader.
 * </p>
 *
 * <p>
 * This loader will load stereotype from the specific source.
 * </p>
 *
 * <p>
 * Thread Safety : The implementation of this interface is required to be thread safety.
 * </p>
 *
 * @author kinzz, biotrail
 * @version 1.0
 */
public interface StandardStereotypeLoader {
    /**
     * <p>
     * Retrieve the standard stereotypes for an element type according to the language.
     * </p>
     *
     * @param language the non null, non empty language.
     * @param elementType the non null, non empty type of the element.
     * @return the non null standard stereotypes for an element type according to the language.
     *
     * @throws IllegalArgumentException if any argument is null, or empty.
     * @throws ProjectConfigurationException if exception occurs trying to get the configuration.
     */
    public List<Stereotype> getStereotypes(String language, String elementType) throws ProjectConfigurationException;
}

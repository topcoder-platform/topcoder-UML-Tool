/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.writer.transformers.model;

/**
 * This interface defines a contract to retieve XMIElementDescription for some element type in TC UML Model.
 * The implementation can load all the descriptions from configuration file,
 * try to parse OMG DTD, or even hardcode the descriptions.
 * Currently, an implementation which uses reflection with a few configurations is provided.
 *
 * <p>
 * Implementation of interface is not required thread-safe.
 * </p>
 *
 * @author maone, TCSDEVELOPER
 * @version 1.0
 */
public interface XMIDescription {
    /**
     * Get XMIElementDescription for the given model type.
     *
     * @return the XMIElementDescription for the given model type,
     * or null if there is no description corresponding to given type
     * @param type the model type to retrieve description for.
     * @throws IllegalArgumentException if given type is null.
     * @throws DescriptionRetrievalException if any error occurs while retrieving.
     */
    public XMIElementDescription getXMIElementDescription(Class type)
        throws DescriptionRetrievalException;
}

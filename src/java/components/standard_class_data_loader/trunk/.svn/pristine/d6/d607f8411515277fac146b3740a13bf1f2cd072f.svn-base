/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.standardclassloader;

import java.util.List;

import com.topcoder.uml.model.core.Namespace;

/**
 * <p>
 * This interface defines the contract for standard data class loaders.
 * </p>
 *
 * <p>
 * This interface provides the functionality to retrieve all the namespaces for
 * a given language.
 * </p>
 *
 * <p>
 * Thread Safety : Implementations of this interface are required to be thread safety.
 * </p>
 *
 * @author sql_lall, TCSDEVELOPER
 * @version 1.0
 */
public interface StandardClassDataLoader {
    /**
     * <p>
     * This method represents the responsibility of standard data class loaders.
     * </p>
     *
     * <p>
     * This method returns a list of namespace data that the language supports.
     * </p>
     *
     * <p>
     * Note, The return value may be an empty list, but will not be null.
     * </p>
     *
     * <p>
     * If the language is unknown by an implementing class, an UnknownLanguageException should be thrown.
     * This most likely includes if the language is null or empty, but these possibilities are not
     * disallowed from having meaning within implementations.
     * </p>
     *
     * @param language languages whose namespaces are to be retrieved. It may be null or empty, though
     * this is likely to result in an UnknownLanguageException being thrown.
     *
     * @return List of namespaces for the given language, possibly empty, never null.
     *
     * @throws UnknownLanguageException If the given language is not known by the loader.
     * @throws ClassDataLoaderConfigurationException if there are any configuration
     * problems getting the namespaces for the given language
     */
    public List<Namespace> getNamespaces(String language) throws UnknownLanguageException,
        ClassDataLoaderConfigurationException;
}

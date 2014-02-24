/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.standardclassloader;

import java.util.List;
import com.topcoder.uml.model.core.Namespace;

/**
 * <p>
 * The interface defines the contract required for data class loader of a language.
 * </p>
 *
 * <p>
 * This interface provides the way to retrieve the namespace information for the language
 * that the loader is responsible for.
 * </p>
 *
 * <p>
 * Note, implementations of this interface must be able to be constructed using the Object
 * factory if they are to be used by the ClassLoaderStrategy.
 * </p>
 *
 * <p>
 * Thread Safety : The implementation of this interface do not have to be thread safety.
 * </p>
 *
 * @author sql_lall, TCSDEVELOPER
 * @version 1.0
 */
public interface LanguageClassDataLoader {
    /**
     * <p>
     * Return a list of namespaces for the language this is representing.
     * </p>
     *
     * <p>
     * Note, the return value is possible empty if no namespaces are stored.
     * It should never return null, or throw an exception.
     * </p>
     *
     * @return a List of namespaces for the language this is representing
     *
     * @throws ClassDataLoaderConfigurationException if there are any configuration
     * problems getting the namespaces for the given language
     */
    public List<Namespace> getNamespaces() throws ClassDataLoaderConfigurationException;
}

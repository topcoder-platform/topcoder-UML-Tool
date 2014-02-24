/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.standardclassloader;

import com.topcoder.uml.model.core.Namespace;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.topcoder.util.objectfactory.InvalidClassSpecificationException;
import com.topcoder.util.objectfactory.ObjectFactory;
import com.topcoder.util.objectfactory.impl.ConfigManagerSpecificationFactory;
import com.topcoder.util.objectfactory.impl.IllegalReferenceException;
import com.topcoder.util.objectfactory.impl.SpecificationConfigurationException;
import com.topcoder.util.config.ConfigManager;
import com.topcoder.util.config.Property;
import com.topcoder.util.config.UnknownNamespaceException;

/**
 * <p>
 * This class implements the Standard Class Data loader which allows each
 * language to be attached to its own pluggable loading algorithm.
 * </p>
 *
 * <p>
 * This class maintains a mapping from known languages to their respective LanguageClassDataLoaders.
 * </p>
 *
 * <p>
 * Sample Configuration :
 *     &lt;Config name=&quot;strategyClassDataLoader&quot;&gt;
 *      &lt;!-- required construction parameter
 *           for use with the object factory --&gt;
 *      &lt;Property name=&quot;objectFactoryNamespace&quot;&gt;
 *           &lt;Value&gt;classData_objectFactory&lt;/Value&gt;
 *      &lt;/Property&gt;
 *     &lt;!-- supported languages --&gt;
 *     &lt;Property name=&quot;languages&quot;&gt;
 *         &lt;Value&gt;Java&lt;/Value&gt;
 *         &lt;!-- &lt;Value&gt;CSharp&lt;/Value&gt; --&gt;
 *     &lt;/Property&gt;
 *      &lt;!-- Java loader information --&gt;
 *      &lt;Property name=&quot;Java&quot;&gt;
 *          &lt;Property name=&quot;key&quot;&gt;
 *             &lt;Value&gt;javaLoader&lt;/Value&gt;
 *          &lt;/Property&gt;
 *      &lt;/Property&gt;
 *     &lt;/Config&gt;
 *         &lt;Config name=&quot;classData_objectFactory&quot;&gt;
 *       &lt;!-- Object factory configuration for the default java loader --&gt;
 *       &lt;Property name=&quot;javaLoader&quot;&gt;
 *           &lt;Property name=&quot;type&quot;&gt;
 *               &lt;Value&gt;com.topcoder.uml.standardclassloader.implementations.
 *               XMLLanguageClassDataLoader&lt;/Value&gt;
 *           &lt;/Property&gt;
 *           &lt;Property name=&quot;params&quot;&gt;
 *               &lt;!-- single-string filename constructor --&gt;
 *               &lt;Property name=&quot;param1&quot;&gt;
 *                   &lt;Property name=&quot;type&quot;&gt;
 *                       &lt;Value&gt;String&lt;/Value&gt;
 *                   &lt;/Property&gt;
 *                   &lt;Property name=&quot;value&quot;&gt;
 *                       &lt;!-- using the sample file provided --&gt;
 *                       &lt;Value&gt;test_files/sampleJavaFile.xml&lt;/Value&gt;
 *                   &lt;/Property&gt;
 *               &lt;/Property&gt;
 *           &lt;/Property&gt;
 *       &lt;/Property&gt;
 *   &lt;/Config&gt;
 * </p>
 *
 * <p>
 * Thread safety : This class is thread safety. After construction,
 * it only performs retrieval methods on its loaders, while ensuring
 * each loader is called by one one thread at a time.
 * </p>
 *
 * @author sql_lall, TCSDEVELOPER
 * @version 1.0
 */
public class ClassDataLoaderStrategy implements StandardClassDataLoader {
    /**
     * <p>
     * The default namespace to load class data from.
     * </p>
     */
    public static final String DEFAULT_NAMESPACE = "com.topcoder.uml.standardclassloader";

    /**
     * <p>
     * Mapping of languages to their data loaders.
     * </p>
     *
     * <p>
     * The key of the mapping is the language while the value is the corresponding data loader.
     * </p>
     *
     * <p>
     * It will never be null and will never be changed after set.
     * </p>
     */
    private final Map<String, LanguageClassDataLoader> loaders = new HashMap<String, LanguageClassDataLoader>();

    /**
     * <p>
     * Construct a new strategy loader with default namespace to load configuration values.
     * </p>
     *
     * <p>
     * Note, the default namespace is <b>com.topcoder.uml.standardclassloader</b>.
     * </p>
     *
     * <p>
     * For the sample configuration, please refer to the class documentation.
     * </p>
     *
     * @throws ClassDataLoaderConfigurationException If there are any problems reading from
     * configuration or constructing the loaders from the object factory.
     */
    public ClassDataLoaderStrategy() throws ClassDataLoaderConfigurationException {
        this(DEFAULT_NAMESPACE);
    }

    /**
     * <p>
     * Construct a new strategy loader with the namespace to load configuration values given.
     * </p>
     *
     * <p>
     * For the sample configuration, please refer to the class documentation.
     * </p>
     *
     * @param namespace The namespace to read the language names / object factory
     * keys and namespace from.
     *
     * @throws ClassDataLoaderConfigurationException If there are any problems reading from
     * configuration or constructing the loaders from the object factory.
     */
    public ClassDataLoaderStrategy(String namespace) throws ClassDataLoaderConfigurationException {
        if (namespace == null) {
            throw new ClassDataLoaderConfigurationException("The namespace should not be null.");
        }

        if (namespace.trim().length() == 0) {
            throw new ClassDataLoaderConfigurationException("The namespace should not be empty.");
        }

        try {
            ObjectFactory factory = new ObjectFactory(new ConfigManagerSpecificationFactory(getString(namespace,
                "objectFactoryNamespace")));

            // get the values of the languages property
            String[] languages = getStringArray(namespace, "languages");

            if (languages == null) {
                return;
            }

            // language exists and put them into loaders map
            for (String language : languages) {
                // get the value of language.key property
                String key = getString(namespace, language + ".key");

                Object object = factory.createObject(key);
                if (!(object instanceof LanguageClassDataLoader)) {
                    throw new ClassDataLoaderConfigurationException(
                        "The object should be of LanguageClassDataLoader type.");
                }

                loaders.put(language, (LanguageClassDataLoader) object);
            }

        } catch (SpecificationConfigurationException e) {
            throw new ClassDataLoaderConfigurationException(
                "SpecificationConfigurationException occurs while creating object from object factory.", e);
        } catch (IllegalReferenceException e) {
            throw new ClassDataLoaderConfigurationException(
                "IllegalReferenceException occurs while creating object from object factory.", e);
        } catch (InvalidClassSpecificationException e) {
            throw new ClassDataLoaderConfigurationException(
                "InvalidClassSpecificationException occurs while creating object from object factory.", e);
        }
    }

    /**
     * <p>
     * This method implements the contract of StandardDataClassLoader interface.
     * </p>
     *
     * @param language The language who's namespaces are to be retrieved.
     * @return A list of namespaces for the given language, possibly empty, never null.
     *
     * @throws UnknownLanguageException If the language is unknown by this class data
     * loader strategy, it may be caused by null or empty language input.
     * @throws ClassDataLoaderConfigurationException if there are any configuration
     * problems getting the namespaces for the given language
     */
    public List<Namespace> getNamespaces(String language) throws UnknownLanguageException,
        ClassDataLoaderConfigurationException {
        if (language == null) {
            throw new UnknownLanguageException("The language should not be null.");
        }

        if (language.trim().length() == 0) {
            throw new UnknownLanguageException("The language should not be empty.");
        }

        // check the language should be contain in loaders map
        if (!loaders.containsKey(language)) {
            throw new UnknownLanguageException("The language [" + language + "] is unknown.");
        }

        // make sure the thread safe
        synchronized (loaders) {
            return loaders.get(language).getNamespaces();
        }
    }

    /**
     * <p>
     * Return a list of languages known by this class data loader strategy.
     * </p>
     *
     * <p>
     * Note, it is guaranteed that for all languages returned by this method, get the corresponding
     * namespaces won't throw UnknownLanguageException.
     * </p>
     *
     * @return all the languages known by this class data loader strategy.
     */
    public List<String> getLanguages() {
        return new ArrayList<String>(loaders.keySet());
    }

    /**
     * <p>
     * Return the value of the property.
     * </p>
     *
     * @param namespace the namespace to get the property value from.
     * @param propertyName the name of property
     *
     * @return the value of the property
     *
     * @throws ClassDataLoaderConfigurationException if fails to load the config values.
     */
    private String getString(String namespace, String propertyName) throws ClassDataLoaderConfigurationException {
        String property;
        try {
            property = ConfigManager.getInstance().getString(namespace, propertyName);
        } catch (UnknownNamespaceException e) {
            throw new ClassDataLoaderConfigurationException("UnknownNamespaceException occurs "
                + "when accessing ConfigManager.", e);
        }

        // Property is missed
        if (property == null) {
            throw new ClassDataLoaderConfigurationException("Missed property: " + propertyName);
        }

        // Empty property value is not allowed
        if ((property.trim().length() == 0)) {
            throw new ClassDataLoaderConfigurationException("Property " + propertyName + " is empty.");
        }

        return property;
    }

    /**
     * <p>
     * Get the property values specified under the given property argument with the given property name.
     * </p>
     *
     * @param namespace the namespace to get the property value from.
     * @param propertyName a property name to retrieve.
     *
     * @return the property values in string array representation, it may be null if the namespace is missing
     *
     * @throws ClassDataLoaderConfigurationException if fail to load the config values
     */
    private String[] getStringArray(String namespace, String propertyName)
        throws ClassDataLoaderConfigurationException {
        try {
            Property property = ConfigManager.getInstance().getPropertyObject(namespace, propertyName);

            // Property is missing
            if (property == null) {
                return null;
            }

            String[] values = property.getValues();

            // values is missing
            if (values == null) {
                throw new ClassDataLoaderConfigurationException("Missing value for property: " + propertyName);
            }

            // values exists but contains empty value
            for (int i = 0; i < values.length; i++) {
                if (values[i].trim().length() == 0) {
                    throw new ClassDataLoaderConfigurationException(propertyName + " contains empty string value.");
                }
            }

            return values;
        } catch (UnknownNamespaceException e) {
            throw new ClassDataLoaderConfigurationException("Unknown namespace: " + namespace, e);
        }

    }
}
